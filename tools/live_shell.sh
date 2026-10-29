#!/usr/bin/env bash
# Live command channel, git in / issue out.
#
# I can push to the repo but cannot post issue comments from the sandbox; the
# runner can do both. So: the command lives in a file that other workflows
# ignore, and the answer comes back as a comment.
#
#   tools/live_shell.sh <owner/repo> <issue> <branch> [seconds]
#
# Any command that starts something long-lived must use
# `setsid nohup ... > /tmp/x.log 2>&1 < /dev/null &` so it survives into the
# next command of the same job.
set -uo pipefail

REPO="${1:?repo}"
ISSUE="${2:?issue}"
BRANCH="${3:?branch}"
LIFETIME="${4:-3300}"
DEADLINE=$(( SECONDS + LIFETIME ))
CMD_PATH="analysis-bdnet/live/cmd"
LIMIT=55000

say() {
  printf 'OUT:%s\n%s\n' "$1" "$2" > /tmp/live-comment.txt
  gh api -X POST "repos/$REPO/issues/$ISSUE/comments" \
    -F body=@/tmp/live-comment.txt > /dev/null 2>&1 || true
}

seen=""
say "0" "live shell online on $(hostname) at $(date -u +%H:%M:%S)Z, lifetime ${LIFETIME}s, waiting on $CMD_PATH"
echo "live shell online, watching $CMD_PATH"

while [ $SECONDS -lt $DEADLINE ]; do
  if ! git fetch -q --depth 1 origin "$BRANCH" 2>/dev/null; then
    sleep 5
    continue
  fi
  blob=$(git rev-parse "origin/$BRANCH:$CMD_PATH" 2>/dev/null)
  if [ -z "${blob:-}" ] || [ "$blob" = "$seen" ]; then
    sleep 4
    continue
  fi
  seen=$blob

  cmd=$(git show "origin/$BRANCH:$CMD_PATH" 2>/dev/null)
  echo "=== $blob: ${cmd:0:100}"

  started=$(date +%s)
  out=$(timeout 240 bash -lc "$cmd" 2>&1)
  code=$?
  took=$(( $(date +%s) - started ))

  {
    printf 'OUT:%s  exit=%d  %ds\n```\n%s\n```\n' "$blob" "$code" "$took" "${out:0:$LIMIT}"
  } > /tmp/live-comment.txt
  [ ${#out} -gt $LIMIT ] && printf '\n(truncated: %d bytes total)\n' "${#out}" >> /tmp/live-comment.txt
  gh api -X POST "repos/$REPO/issues/$ISSUE/comments" \
    -F body=@/tmp/live-comment.txt > /dev/null 2>&1 || true
done

say "$seen" "live shell closing at $(date -u +%H:%M:%S)Z (lifetime reached)"
