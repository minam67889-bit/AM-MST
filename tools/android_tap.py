#!/usr/bin/env python3
"""Drive BD NET's UI on an emulator: pick a DNS server, press connect.

The apk has no stable ids, so this works the way a thumb does: dump the view
hierarchy with `uiautomator dump`, find the node whose text matches what we
want, tap its centre, and confirm the next dump changed.

Usage::

    python3 tools/android_tap.py list                     # what is on screen
    python3 tools/android_tap.py tap --text "SlowDns"     # tap the first match
    python3 tools/android_tap.py tap --text-re "(?i)slow" --index 2
    python3 tools/android_tap.py connect                  # find + tap the big button

`connect` looks, in order, for a node whose text or content-desc contains
"connect", "اتصال", "شروع", "start", or the classic power-button content-desc.
"""

from __future__ import annotations

import argparse
import re
import subprocess
import sys
import time
import xml.etree.ElementTree as ET

CONNECT_PATTERNS = (
    r"(?i)connect", r"(?i)start", r"اتصال", r"وصل", r"شروع", r"(?i)power",
    r"(?i)turn on", r"(?i)disconnected",
)


def adb(*args: str, timeout: int = 60) -> str:
    return subprocess.run(["adb", *args], capture_output=True, text=True,
                          timeout=timeout).stdout


def dump() -> ET.Element | None:
    adb("shell", "uiautomator", "dump", "/sdcard/ui.xml")
    xml = adb("shell", "cat", "/sdcard/ui.xml")
    start = xml.find("<?xml")
    if start < 0:
        return None
    try:
        return ET.fromstring(xml[start:])
    except ET.ParseError:
        return None


def nodes(root: ET.Element):
    for node in root.iter("node"):
        yield (node.get("text") or "", node.get("content-desc") or "",
               node.get("bounds") or "", node.get("class") or "",
               node.get("clickable") or "")


def centre(bounds: str) -> tuple[int, int] | None:
    m = re.match(r"\[(\d+),(\d+)\]\[(\d+),(\d+)\]", bounds)
    if not m:
        return None
    x1, y1, x2, y2 = map(int, m.groups())
    return (x1 + x2) // 2, (y1 + y2) // 2


def show(root: ET.Element) -> int:
    count = 0
    for text, desc, bounds, cls, clickable in nodes(root):
        if not (text or desc):
            continue
        count += 1
        print(f"{bounds:24s} {cls.split('.')[-1]:16s} clickable={clickable:5s} "
              f"text={text!r} desc={desc!r}")
    print(f"-- {count} labelled nodes")
    return count


def find(root: ET.Element, pattern: str, index: int = 0) -> ET.Element | None:
    rx = re.compile(pattern)
    hits = [n for n in root.iter("node")
            if rx.search(n.get("text") or "") or rx.search(n.get("content-desc") or "")]
    if not hits:
        return None
    return hits[index] if index < len(hits) else hits[-1]


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    sub = ap.add_subparsers(dest="cmd", required=True)
    sub.add_parser("list")
    t = sub.add_parser("tap")
    t.add_argument("--text", default=None)
    t.add_argument("--text-re", dest="text_re", default=None)
    t.add_argument("--index", type=int, default=0)
    sub.add_parser("connect")
    args = ap.parse_args(argv)

    root = dump()
    if root is None:
        print("no view hierarchy (screen off or app not foreground?)")
        return 1

    if args.cmd == "list":
        show(root)
        return 0

    if args.cmd == "connect":
        for pattern in CONNECT_PATTERNS:
            node = find(root, pattern)
            if node is not None:
                print(f"connect button matched {pattern!r}: "
                      f"{node.get('text')!r}/{node.get('content-desc')!r}")
                pos = centre(node.get("bounds") or "")
                if pos:
                    adb("shell", "input", "tap", str(pos[0]), str(pos[1]))
                    time.sleep(2)
                    return 0
        print("no connect button found; screen had:")
        show(root)
        return 1

    node = find(root, args.text_re or re.escape(args.text or ""), args.index)
    if node is None:
        print("no match; screen had:")
        show(root)
        return 1
    pos = centre(node.get("bounds") or "")
    if not pos:
        print(f"match had no bounds: {node.attrib}")
        return 1
    print(f"tapping {pos} for {node.get('text')!r}{node.get('content-desc')!r}")
    adb("shell", "input", "tap", str(pos[0]), str(pos[1]))
    time.sleep(2)
    return 0


if __name__ == "__main__":
    sys.exit(main())
