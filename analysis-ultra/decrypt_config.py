#!/usr/bin/env python3
"""Decrypt Ultra Tunnel (co.strongteam.ultra) server catalogue.

Recovered from libgojni.so (github.com/2dust/AndroidLibXrayLite) and verified
against build 59 assets/configfile.json.  Envelope:

    base64( salt[16] || nonce[12] || AES-256-GCM(ct) || tag[16] )
    key = Argon2id(passphrase, salt, t=3, m=8192 KiB, p=1, len=32, v19)
    AAD = salt

Two passphrases:
  * remote/export ("decrypt", one random ASCII letter inserted at index 3 after
    base64): /4ssU0OjjtKH8AheiAxnc3DwSGDzsy+8
  * bundled asset + every protected inner field (EO/DO): NurChickenPowder

Protected inner fields (SlowDNSHost, SlowDNSKey, ServerIPHost, ...) are wrapped
in the same envelope with the same bundled passphrase.
"""
from __future__ import annotations

import base64
import json
import re
import sys

from argon2.low_level import Type, hash_secret_raw
from Crypto.Cipher import AES

REMOTE_SECRET = b"/4ssU0OjjtKH8AheiAxnc3DwSGDzsy+8"
BUNDLED_SECRET = b"NurChickenPowder"
MEM_KIB = 8192

TOP_FIELDS = ("DefOVPNUser", "DefOVPNPass", "HysteriaUser", "HysteriaOBFS", "DefaultOVPNCert")
SERVER_FIELDS = ("ServerIPHost", "OVPNUser", "OVPNPass", "UDP_obfs", "UDP_user", "CustomCertificate",
                 "SlowDNSHost", "SlowDNSKey", "V2rayUUID", "V2rayPath", "H2pass", "TrojanPass")
NETWORK_FIELDS = ("Payload", "CustomProxy", "SNI", "V2rayConfig", "BugDNS", "V2rayAddress",
                  "V2rayHost", "V2raySNI")
B64 = re.compile(r"[A-Za-z0-9+/]*={0,2}")


def open_envelope(text: str, secret: bytes = BUNDLED_SECRET) -> str:
    raw = base64.b64decode(text.replace("\r", "").replace("\n", ""), validate=True)
    key = hash_secret_raw(secret, raw[:16], 3, MEM_KIB, 1, 32, Type.ID, version=19)
    c = AES.new(key, AES.MODE_GCM, nonce=raw[16:28])
    c.update(raw[:16])
    return c.decrypt_and_verify(raw[28:-16], raw[-16:]).decode("utf-8")


def decode_fields(obj: dict) -> dict:
    cache: dict[str, str] = {}

    def decrypt_fields(record: dict, names) -> dict:
        out = dict(record)
        for name in names:
            value = record.get(name)
            if not isinstance(value, str):
                continue
            packed = value.replace("\r", "").replace("\n", "")
            if len(packed) < 60 or not B64.fullmatch(packed):
                continue
            if packed not in cache:
                cache[packed] = open_envelope(value)
            out[name] = cache[packed]
        return out

    result = decrypt_fields(obj, TOP_FIELDS)
    for section, names in (("Servers", SERVER_FIELDS), ("Networks", NETWORK_FIELDS)):
        result[section] = [decrypt_fields(row, names) for row in obj[section]]
    return result


def load(path: str, already_decrypted: bool = False) -> dict:
    if already_decrypted:
        obj = json.load(open(path, encoding="utf-8"))
    else:
        text = open(path, encoding="utf-8-sig").read().strip()
        if text.startswith("{"):
            obj = json.loads(text)
        else:
            flat = text.replace("\r", "").replace("\n", "")
            remote = len(flat) % 4 == 1
            if remote:
                text = flat[:3] + flat[4:]
            obj = json.loads(open_envelope(text, REMOTE_SECRET if remote else BUNDLED_SECRET))
    return decode_fields(obj)


if __name__ == "__main__":
    src = sys.argv[1]
    dst = sys.argv[2]
    decrypted = len(sys.argv) > 3 and sys.argv[3] == "--inner-only"
    data = load(src, already_decrypted=decrypted)
    with open(dst, "w", encoding="utf-8") as fh:
        json.dump(data, fh, ensure_ascii=False, indent=1)
    print(f"Version={data.get('Version')} servers={len(data['Servers'])} networks={len(data['Networks'])} -> {dst}")
