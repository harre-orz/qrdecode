#!/usr/bin/env python

import sys
import zbar
import qrtools

qr = qrtools.QR()
s = ""
for arg in sys.argv[1:]:
    qr.decode(arg)
    s += qr.data.lstrip('\0')
print(s.strip())
