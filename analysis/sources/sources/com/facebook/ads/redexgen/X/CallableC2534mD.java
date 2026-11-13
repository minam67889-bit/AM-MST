package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.os.Build;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.mD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public class CallableC2534mD implements Callable<Boolean> {
    public static byte[] A04;
    public static String[] A05 = {"CoyLTTqL9oN", "BQ7yf8H5Dy6", "lyn", "mKjKy3YozjHGjndyHmGPrtRgt1Zkpmof", "kCMvlxHItYqHUu0uJG5AXtsVRpKoPm5F", "PZWzUgGQe3CdPYsrWXqgA6txhpTzavVR", "1z7bJiu6sIQ4w4e4OAYhOvPnvUYdbbgv", "yc5QaeADf08N4Bq6BgqF"};
    public final /* synthetic */ SharedPreferences A00;
    public final /* synthetic */ C2470lA A01;
    public final /* synthetic */ C2512lq A02;
    public final /* synthetic */ String A03;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ ScopedSysTraceEvent.MAX_SECTION_NAME_LEN);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{24, 61, 51, 46, 61, 45, 17, 29, 31, 92, 19, 28, 22, 0, 29, 27, 22, 92, 4, 23, 28, 22, 27, 28, 21, 100, 116, 102, 119, 110, 112, 96, Byte.MAX_VALUE, 116, 112, 114, 112, 123, 112, 103, 124, 118};
    }

    static {
        A02();
    }

    public CallableC2534mD(C2470lA c2470lA, C2512lq c2512lq, SharedPreferences sharedPreferences, String str) {
        this.A01 = c2470lA;
        this.A02 = c2512lq;
        this.A00 = sharedPreferences;
        this.A03 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r1.equals(r0) != false) goto L6;
     */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean call() throws Exception {
        AtomicInteger atomicInteger;
        String str = null;
        if (Build.VERSION.SDK_INT < 31) {
            String A01 = A01(0, 1, 52);
            String checksumApiFingerprint = Build.VERSION.CODENAME;
        }
        if (C2578mv.A2r(this.A01)) {
            String A0B = this.A02.A0B();
            String checksumApiFingerprint2 = A01(6, 19, 13);
            if (checksumApiFingerprint2.equals(A0B)) {
                C2470lA c2470lA = this.A01;
                String checksumApiFingerprint3 = this.A01.getPackageName();
                str = C2763q0.A01(c2470lA, checksumApiFingerprint3);
            }
        }
        String checksumApiFingerprint4 = A05[7];
        if (checksumApiFingerprint4.length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[0] = "qQmXUpBlhYC";
        strArr[1] = "2roBSgd9zyy";
        if (str == null) {
            C2470lA c2470lA2 = this.A01;
            String checksumApiFingerprint5 = this.A01.getPackageName();
            C2535mE.A00 = C2705p1.A02(c2470lA2, checksumApiFingerprint5);
        } else {
            if (C2578mv.A1k(this.A01)) {
                C2470lA c2470lA3 = this.A01;
                String checksumApiFingerprint6 = this.A01.getPackageName();
                String A02 = C2705p1.A02(c2470lA3, checksumApiFingerprint6);
                String checksumApiFingerprint7 = A01(1, 5, 33);
                C2502lg c2502lg = new C2502lg(checksumApiFingerprint7);
                c2502lg.A05(1);
                c2502lg.A06(1);
                c2502lg.A0A(false);
                JSONObject jSONObject = new JSONObject();
                String checksumApiFingerprint8 = A01(25, 5, 120);
                jSONObject.put(checksumApiFingerprint8, str);
                String checksumApiFingerprint9 = A01(30, 5, 108);
                jSONObject.put(checksumApiFingerprint9, A02);
                c2502lg.A07(jSONObject);
                InterfaceC2500le A08 = this.A01.A08();
                int i = AbstractC2501lf.A1I;
                String checksumApiFingerprint10 = A01(35, 7, 106);
                A08.AC0(checksumApiFingerprint10, i, c2502lg);
            }
            C2535mE.A00 = str;
        }
        SharedPreferences.Editor edit = this.A00.edit();
        String str2 = this.A03;
        String checksumApiFingerprint11 = C2535mE.A00;
        edit.putString(str2, checksumApiFingerprint11).apply();
        atomicInteger = C2535mE.A05;
        atomicInteger.set(2);
        return true;
    }
}
