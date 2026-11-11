#!/usr/bin/env python3
"""Decrypt Ultra Tunnel's assets/configfile.json.

Constants and envelope format are the ones the app itself uses
(AndroidLibXrayLite EO/DO in libgojni.so):
    salt[16] || nonce[12] || AES-256-GCM ciphertext || tag[16]
    key = Argon2id(passphrase, salt, t=3, m=16384KiB, p=1, len=32, v19)
    AAD = salt
"""
import base64, json, sys
from argon2.low_level import Type, hash_secret_raw
from Crypto.Cipher import AES

FILE_SECRET = b"iOi/hqT/TocUv0UbDImfWPGR1mfSdzzX"    # Libv2ray.encrypt/decrypt (export)
FIELD_SECRET = b"NewDecryptLibPassword"               # Libv2ray.EO/DO (bundled config)


def open_envelope(text, secret):
    raw = base64.b64decode(text.replace("\r", "").replace("\n", ""), validate=True)
    salt, nonce = raw[:16], raw[16:28]
    key = hash_secret_raw(secret, salt, time_cost=3, memory_cost=16384,
                          parallelism=1, hash_len=32, type=Type.ID, version=19)
    c = AES.new(key, AES.MODE_GCM, nonce=nonce)
    c.update(salt)
    return c.decrypt_and_verify(raw[28:-16], raw[-16:]).decode("utf-8")


def main(path, out):
    text = open(path, encoding="utf-8-sig").read().strip()
    for name, secret, exported in (("DO/FIELD_SECRET", FIELD_SECRET, False),
                                   ("decrypt/FILE_SECRET", FILE_SECRET, True)):
        t = text
        if exported:
            if len(t) < 4 or not t[3].isalpha():
                continue
            t = t[:3] + t[4:]
        try:
            clear = open_envelope(t, secret)
        except Exception as exc:
            print(f"{name}: {type(exc).__name__}: {exc}", file=sys.stderr)
            continue
        obj = json.loads(clear)
        print(f"{name}: OK  {len(clear)} chars  version={obj.get('Version')} "
              f"servers={len(obj.get('Servers', []))} networks={len(obj.get('Networks', []))}")
        with open(out, "w", encoding="utf-8") as fh:
            json.dump(obj, fh, ensure_ascii=False, indent=1)
        return 0
    print("FAILED both secrets", file=sys.stderr)
    return 1


if __name__ == "__main__":
    sys.exit(main(sys.argv[1], sys.argv[2]))
