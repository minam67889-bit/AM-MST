package com.google.android.recaptcha.internal;

import android.content.Context;
import defpackage.AbstractC4167q6;
import defpackage.AbstractC4673wh;
import defpackage.AbstractC4747xe;
import defpackage.AbstractC4766xx;
import defpackage.C0550Uo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class zzcd {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcd(@NotNull Context context) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @NotNull
    public static final byte[] zza(@NotNull File file) {
        AbstractC4766xx.p(file, "<this>");
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
                AbstractC4766xx.o(bArr, "copyOf(...)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    C0550Uo c0550Uo = new C0550Uo(8193);
                    c0550Uo.write(read2);
                    AbstractC4673wh.m(fileInputStream, c0550Uo);
                    int size = c0550Uo.size() + i;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] f = c0550Uo.f();
                    bArr = Arrays.copyOf(bArr, size);
                    AbstractC4766xx.o(bArr, "copyOf(...)");
                    AbstractC4167q6.N(f, i, bArr, 0, c0550Uo.size());
                }
            }
            AbstractC4747xe.l(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC4747xe.l(fileInputStream, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void zzb(@NotNull File file, @NotNull byte[] bArr) {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        AbstractC4766xx.p(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            AbstractC4747xe.l(fileOutputStream, null);
        } finally {
        }
    }
}
