package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.kB, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2405kB extends AbstractRunnableC1693Wc {
    public static byte[] A02;
    public final /* synthetic */ N8 A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 55);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-77, -65, -78, -66, -62, -78, -69, -80, -58, -84, -80, -82, -67, -67, -74, -69, -76};
    }

    public C2405kB(N8 n8, String str) {
        this.A00 = n8;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1693Wc
    public final void A07() {
        T8 t8;
        T8 t82;
        CountDownLatch countDownLatch;
        N7 n7;
        N7 n72;
        N7 n73;
        boolean A0J;
        N7 n74;
        try {
            countDownLatch = this.A00.A06;
            countDownLatch.await();
            n7 = this.A00.A02;
            synchronized (n7) {
                n72 = this.A00.A02;
                Iterator<String> keys = n72.A05().keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    A0J = this.A00.A0J(this.A01);
                    if (A0J) {
                        N8 n8 = this.A00;
                        n74 = this.A00.A02;
                        n8.A0E((C1469Nf) n74.A05().get(next), next, next.equals(this.A01));
                    }
                }
                n73 = this.A00.A02;
                n73.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e) {
            t82 = this.A00.A03;
            InterfaceC1617Tc A08 = t82.A08();
            String encryptedId = A00(0, 17, 22);
            A08.ABC(encryptedId, AbstractC1618Td.A1B, new C1619Te(e));
        } catch (JSONException e2) {
            this.A00.A0M();
            t8 = this.A00.A03;
            InterfaceC1617Tc A082 = t8.A08();
            String encryptedId2 = A00(0, 17, 22);
            A082.ABC(encryptedId2, AbstractC1618Td.A1A, new C1619Te(e2));
        }
    }
}
