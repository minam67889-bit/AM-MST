package defpackage;

import java.util.Arrays;
import java.util.Objects;

/* renamed from: po, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3861po {
    public final byte[] a;
    public final String b;
    public final byte[] c;

    public C3861po(byte[] bArr, String str, byte[] bArr2) {
        this.a = bArr;
        this.b = str;
        this.c = bArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3861po)) {
            return false;
        }
        C3861po c3861po = (C3861po) obj;
        return Arrays.equals(this.a, c3861po.a) && this.b.contentEquals(c3861po.b) && Arrays.equals(this.c, c3861po.c);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.a)), this.b, Integer.valueOf(Arrays.hashCode(this.c)));
    }

    public final String toString() {
        return W50.m("EncryptedTopic { ", "EncryptedTopic=" + AbstractC4388wV.p0(this.a) + ", KeyIdentifier=" + this.b + ", EncapsulatedKey=" + AbstractC4388wV.p0(this.c) + " }");
    }
}
