#!/usr/bin/env bash
# ---------------------------------------------------------------------------
# Turns a fresh Linux box into a MasterDnsVPN tunnel server for this client.
#
#   sudo ./install-masterdnsvpn.sh t.yourdomain.com
#
# What it does, in order:
#   1. checks that this machine really is authoritative for the domain
#      (a DNS tunnel only works when the domain's NS records point here),
#   2. downloads the prebuilt server binary (or uses --binary PATH),
#   3. generates the encryption key once and keeps it,
#   4. writes /etc/masterdnsvpn/server.toml and a systemd unit,
#   5. opens UDP/53 in ufw/firewalld if they are installed,
#   6. prints a ready-to-paste client profile.
#
# The server itself is upstream MasterDnsVPN, unmodified.
# ---------------------------------------------------------------------------
set -euo pipefail

DOMAIN="${1:-}"
PORT="${PORT:-53}"
REPO="minam67889-bit/AM-MST"
BIN_PATH="/usr/local/bin/masterdnsvpn-server"
CONF_DIR="/etc/masterdnsvpn"
CONF="$CONF_DIR/server.toml"
KEY_FILE="$CONF_DIR/encryption_key.txt"
ENCRYPTION="${ENCRYPTION:-1}"          # 1 = XOR, 2 = ChaCha20, 3..5 = AES-GCM
BINARY_OVERRIDE=""

usage() {
  cat <<EOF
usage: sudo $0 <tunnel-domain> [options]

  t.yourdomain.com     the domain whose NS records point at this server
  --port N             UDP port to listen on (default 53)
  --encryption N       1 XOR, 2 ChaCha20, 3-5 AES-GCM (default 1)
  --binary PATH        use a local server binary instead of downloading
  --dry-run            print the config and exit

Get a domain and a box first - docs/SERVER.md walks through the cheapest
paths step by step.
EOF
}

while [ $# -gt 0 ]; do
  case "$1" in
    --port) PORT="$2"; shift 2 ;;
    --encryption) ENCRYPTION="$2"; shift 2 ;;
    --binary) BINARY_OVERRIDE="$2"; shift 2 ;;
    --dry-run) DRY_RUN=1; shift ;;
    -h|--help) usage; exit 0 ;;
    *) if [ -z "$DOMAIN" ]; then DOMAIN="$1"; shift; else usage; exit 2; fi ;;
  esac
done

[ -n "$DOMAIN" ] || { usage; exit 2; }
[ "$(id -u)" = "0" ] || { echo "error: run as root (sudo)"; exit 1; }

say() { printf '\n\033[1;34m==>\033[0m %s\n' "$*"; }
warn() { printf '\033[1;33m warning:\033[0m %s\n' "$*"; }

# --------------------------------------------------------------- 1. NS check
say "Checking that $DOMAIN is delegated to this machine"
PUBLIC_IP="$(curl -fsS4 --max-time 10 https://api.ipify.org 2>/dev/null || curl -fsS4 --max-time 10 https://ifconfig.me 2>/dev/null || true)"
[ -n "${PUBLIC_IP:-}" ] && echo "    this host's public IPv4: $PUBLIC_IP"

NS_LIST="$(dig +short NS "$DOMAIN" 2>/dev/null || nslookup -type=NS "$DOMAIN" 2>/dev/null | awk '/nameserver/{print $NF}' | tr -d '.' || true)"
if [ -z "$NS_LIST" ]; then
  warn "no NS records found for $DOMAIN."
  warn "A DNS tunnel needs them: set ns1/$DOMAIN and ns2/$DOMAIN (A records) to this IPv4,"
  warn "then point the domain's NS records at those names. See docs/SERVER.md."
  warn "Continuing anyway - the server will run, but public resolvers will not find it."
else
  echo "    NS records: $(echo "$NS_LIST" | tr '\n' ' ')"
  ok=0
  for ns in $NS_LIST; do
    resolved="$(dig +short A "$ns" 2>/dev/null | head -1 || true)"
    echo "    $ns -> ${resolved:-unresolved}"
    [ "${resolved:-}" = "$PUBLIC_IP" ] && ok=1
  done
  if [ "$ok" = "1" ]; then
    say "delegation looks correct"
  else
    warn "none of the NS addresses equal this host's public IPv4 ($PUBLIC_IP)."
    warn "If you are behind NAT or still propagating, give it a few minutes."
  fi
fi

# ----------------------------------------------------------------- 2. binary
if [ -n "$BINARY_OVERRIDE" ]; then
  say "Using local binary $BINARY_OVERRIDE"
  install -m 0755 "$BINARY_OVERRIDE" "$BIN_PATH"
elif [ -x "$BIN_PATH" ]; then
  say "Server binary already installed at $BIN_PATH"
else
  case "$(uname -m)" in
    x86_64|amd64) ARCH=amd64 ;;
    aarch64|arm64) ARCH=arm64 ;;
    *) echo "error: unsupported architecture $(uname -m)"; exit 1 ;;
  esac
  say "Downloading the prebuilt server for linux/$ARCH"
  URL="https://github.com/$REPO/releases/latest/download/masterdnsvpn-server-linux-$ARCH"
  if ! curl -fSL --retry 3 -o /tmp/masterdnsvpn-server "$URL"; then
    echo "error: could not download $URL"
    echo "Build it yourself instead:"
    echo "  git clone https://github.com/masterking32/MasterDnsVPN && cd MasterDnsVPN"
    echo "  CGO_ENABLED=0 go build -o masterdnsvpn-server ./cmd/server"
    echo "  sudo $0 $DOMAIN --binary ./masterdnsvpn-server"
    exit 1
  fi
  install -m 0755 /tmp/masterdnsvpn-server "$BIN_PATH"
fi
"$BIN_PATH" -version 2>/dev/null || true

# -------------------------------------------------------------------- 3. key
say "Preparing $CONF_DIR"
mkdir -p "$CONF_DIR"
chmod 700 "$CONF_DIR"
if [ -s "$KEY_FILE" ]; then
  say "Keeping the existing encryption key"
else
  # 32 hex chars, same shape the server generates itself
  if command -v openssl >/dev/null; then
    openssl rand -hex 16 > "$KEY_FILE"
  else
    head -c 16 /dev/urandom | od -An -tx1 | tr -d ' \n' > "$KEY_FILE"
  fi
  echo "    generated a new key"
fi
chmod 600 "$KEY_FILE"
KEY="$(cat "$KEY_FILE")"

# ----------------------------------------------------------------- 4. config
say "Writing $CONF"
cat > "$CONF" <<EOF
# MasterDnsVPN server - generated by install-masterdnsvpn.sh
DOMAIN = ["$DOMAIN"]
PROTOCOL_TYPE = "SOCKS5"
UDP_HOST = "0.0.0.0"
UDP_PORT = $PORT
DATA_ENCRYPTION_METHOD = $ENCRYPTION
ENCRYPTION_KEY_FILE = "$KEY_FILE"
MAX_PACKETS_PER_BATCH = 10
EOF
chmod 600 "$CONF"

if [ -n "${DRY_RUN:-}" ]; then
  say "dry run - config:"
  cat "$CONF"
  exit 0
fi

cat > /etc/systemd/system/masterdnsvpn.service <<EOF
[Unit]
Description=MasterDnsVPN tunnel server
After=network-online.target
Wants=network-online.target

[Service]
Type=simple
ExecStart=$BIN_PATH -config $CONF -nowait
Restart=always
RestartSec=3
LimitNOFILE=1048576
AmbientCapabilities=CAP_NET_BIND_SERVICE
CapabilityBoundingSet=CAP_NET_BIND_SERVICE
NoNewPrivileges=true
PrivateTmp=true
ProtectSystem=full

[Install]
WantedBy=multi-user.target
EOF

systemctl daemon-reload
systemctl enable --now masterdnsvpn.service
sleep 2
systemctl --no-pager --lines=15 status masterdnsvpn.service || true

# ---------------------------------------------------------------- 5. firewall
say "Firewall"
if command -v ufw >/dev/null && ufw status 2>/dev/null | grep -q "Status: active"; then
  ufw allow "$PORT"/udp >/dev/null && echo "    ufw: allowed $PORT/udp"
elif command -v firewall-cmd >/dev/null && firewall-cmd --state >/dev/null 2>&1; then
  firewall-cmd --permanent --add-port="$PORT"/udp >/dev/null
  firewall-cmd --reload >/dev/null
  echo "    firewalld: allowed $PORT/udp"
else
  echo "    no active ufw/firewalld found - make sure your provider's firewall allows UDP/$PORT"
fi

# ----------------------------------------------------------------- 6. verify
say "Verifying"
if ss -lunp 2>/dev/null | grep -q ":$PORT "; then
  echo "    listening on UDP/$PORT"
else
  warn "nothing is listening on UDP/$PORT - check: journalctl -u masterdnsvpn -n 50"
fi
echo "    local test: dig +short TXT test.$DOMAIN @127.0.0.1 -p $PORT"

cat <<EOF

────────────────────────────────────────────────────────────────
 Server profile - paste this into the app ("Import server profile")
────────────────────────────────────────────────────────────────
domain = $DOMAIN
key = $KEY
method = $ENCRYPTION
# Any resolvers your network can reach; the app tests which ones can
# actually carry the tunnel and drops the rest automatically.
resolvers = 1.1.1.1, 1.0.0.1, 8.8.8.8, 8.8.4.4, 9.9.9.9, 208.67.222.222
strategy = 2
duplication = 2
────────────────────────────────────────────────────────────────

Next: install the APK, open it, press "Import server profile" and paste the
block above. Then press Connect.
EOF
