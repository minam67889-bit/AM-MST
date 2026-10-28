package com.google.android.recaptcha.internal;

import android.content.Context;
import defpackage.AbstractC0325Me;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC3634my;
import defpackage.C3148gp;
import defpackage.I6;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzcd {
    public zzcd(Context context) {
    }

    public static final byte[] zza(File file) {
        AbstractC3634my.g(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int read = fileInputStream.read(bArr, i3, i2);
                if (read < 0) {
                    break;
                }
                i2 -= read;
                i3 += read;
            }
            if (i2 > 0) {
                bArr = Arrays.copyOf(bArr, i3);
                AbstractC3634my.f(bArr, "copyOf(...)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    C3148gp c3148gp = new C3148gp(8193);
                    c3148gp.write(read2);
                    AbstractC0641Yi.o(fileInputStream, c3148gp);
                    int size = c3148gp.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] b = c3148gp.b();
                    bArr = Arrays.copyOf(bArr, size);
                    AbstractC3634my.f(bArr, "copyOf(...)");
                    I6.R(b, i, bArr, 0, c3148gp.size());
                }
            }
            fileInputStream.close();
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0325Me.k(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void zzb(File file, byte[] bArr) {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        AbstractC3634my.g(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } finally {
        }
    }
}
