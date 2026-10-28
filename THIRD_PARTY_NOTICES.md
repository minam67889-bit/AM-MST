# Third-party notices

## MasterDnsVPN

The DNS tunnel protocol implemented in `core/` — packet layout, packet-type
table, header integrity byte, base36 label codec, encryption derivation,
session/stream semantics — is derived from:

* **Project:** MasterDnsVPN
* **Author:** Amin Mahmoudi (masterking32)
* **Source:** https://github.com/masterking32/MasterDnsVPN
* **Revision analysed:** `v2026.10.26.100415-5f83ee9`
* **License:** MIT

```
MIT License

Copyright (c) 2026 Amin Mahmoudi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

The reference server is **not** vendored into this repository; CI clones and
builds it at test time.

## Android

Built against the Android SDK. No AndroidX, Compose or other runtime
dependencies are used by the application module.

## Pinned reference

Upstream source that this client was written against (not vendored):

* Repository: <https://github.com/masterking32/MasterDnsVPN>
* Commit: `5f83ee9a1690a968f9edf495d3a7e00a2043b0bd`
  (release tag `v2026.10.26.100415-5f83ee9`)

Reproduce the comparison locally with:

```bash
git clone https://github.com/masterking32/MasterDnsVPN
cd MasterDnsVPN && git checkout 5f83ee9a1690a968f9edf495d3a7e00a2043b0bd
```
