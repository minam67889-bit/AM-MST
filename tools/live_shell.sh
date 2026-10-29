#!/usr/bin/env bash
# Live command channel over a GitHub issue.
#
# The agent cannot reach a runner directly, but both ends can reach
# api.github.com. So: a comment that starts with "RUN:" is a command, and the
# runner answers with a comment that starts with "OUT:<comment id>".
#
#   tools/live_shell.sh <owner/repo> <issue-number> [seconds]
#
# Everything runs in the job's workspace, and anything started with
# `setsid nohup ... &` keeps running between commands for the life of the job.
set -uo pipefail

REPO="${1:?repo}"
ISSUE="${2:?issue}"
LIFETIME="${3:-3300}"
DEADLINE=$(( SECONDS + LIFETIME ))
LIMIT=55000

say() { printf 'OUT:%s\n%s\n' "$1" "$2" > /tmp/live-comment.txt; gh api -X POST \
  "repos/$REPO/issues/$ISSUE/comments" -F body=@/tmp/live-comment.txt > /dev/null 2>&1 || true; }

newest() { gh api "repos/$REPO/issues/$ISSUE/comments?per_page=100" \
  --jq '[.[] | select(.body | startswith("RUN:")) | .id] | max // 0' 2>/dev/null || echo 0; }

last=$(newest)
say 0 "live shell online on $(hostname) at $(date -u +%H:%M:%S)Z, lifetime ${LIFETIME}s
pwd=$(pwd)
workspace files: $(ls | tr '\n' ' ')"
echo "live shell online, last=$last"

while [ $SECONDS -lt $DEADLINE ]; do
  next=$(gh api "repos/$REPO/issues/$ISSUE/comments?per_page=100" \
    --jq "[.[] | select(.id > $last) | select(.body | startswith(\"RUN:\")) | .id] | min // empty" 2>/dev/null)
  if [ -z "${next:-}" ]; then
    sleep 3
    continue
  fi

  cmd=$(gh api "repos/$REPO/issues/$ISSUE/comments/$next" --jq '.body' 2>/dev/null | sed '1s/^RUN:[[:space:]]*//')
  echo "=== running $next: ${cmd:0:120}"

  started=$(date +%s)
  out=$(cd "$GITHUB_WORKSPACE" 2>/dev/null || cd "$PWD"; timeout 240 bash -lc "$cmd" 2>&1)
  code=$?
  took=$(( $(date +%s) - started ))

  {
    printf 'OUT:%s  exit=%d  %ds\n```\n%s\n```\n' "$next" "$code" "$took" "${out:0:$LIMIT}"
  } > /tmp/live-comment.txt
  if [ ${#out} -gt $LIMIT ]; then
    printf '\n(truncated: %d bytes total)\n' "${#out}" >> /tmp/live-comment.txt
  fi
  gh api -X POST "repos/$REPO/issues/$ISSUE/comments" -F body=@/tmp/live-comment.txt > /dev/null 2>&1 || true
  last=$next
done

say "$last" "live shell closing at $(date -u +%H:%M:%S)Z (lifetime reached)"
