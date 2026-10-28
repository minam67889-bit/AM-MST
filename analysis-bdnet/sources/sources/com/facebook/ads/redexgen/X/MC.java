package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;

/* loaded from: assets/audience_network/classes.dex */
public class MC extends AbstractRunnableC2694oq {
    public static byte[] A02;
    public static String[] A03 = {"CdCLIQRd", "Gozok8EGiq89CC7S8QZsNr", "pl5lQHAXyLio1ost", "M44cRouQCRL7K0vypo2P04DU", "Y2GzUIW8g3L", "Bs9wehYqNd3BdGUVOwkaAN", "ajmsB695tQiR2xtfKUGvlSwazulcZzs7", "Sy9bhDNhoUd7kDt0yrvFBLns12VVbk64"};
    public final /* synthetic */ C2090eu A00;
    public final /* synthetic */ String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 47;
            if (A03[6].charAt(27) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "CuQnTMvQt2iEBPylhK7T15";
            strArr[1] = "FSZFy24WJ9CShZHmahty6u";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A03[6].charAt(27) != 'c') {
            throw new RuntimeException();
        }
        A03[3] = "LuOw";
        A02 = new byte[]{-99, -87, -100, -88, -84, -100, -91, -102, -80, -106, -102, -104, -89, -89, -96, -91, -98};
    }

    static {
        A01();
    }

    public MC(C2090eu c2090eu, String str) {
        this.A00 = c2090eu;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC2694oq
    public final void A07() {
        C2470lA c2470lA;
        C2470lA c2470lA2;
        CountDownLatch countDownLatch;
        C2089et c2089et;
        C2089et c2089et2;
        C2089et c2089et3;
        boolean A0J;
        C2089et c2089et4;
        try {
            countDownLatch = this.A00.A06;
            countDownLatch.await();
            c2089et = this.A00.A02;
            synchronized (c2089et) {
                c2089et2 = this.A00.A02;
                Iterator<String> keys = c2089et2.A05().keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    A0J = this.A00.A0J(this.A01);
                    if (A0J) {
                        C2090eu c2090eu = this.A00;
                        c2089et4 = this.A00.A02;
                        c2090eu.A0E((C2124fS) c2089et4.A05().get(next), next, next.equals(this.A01));
                    }
                }
                c2089et3 = this.A00.A02;
                c2089et3.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e) {
            c2470lA2 = this.A00.A03;
            InterfaceC2500le A08 = c2470lA2.A08();
            String encryptedId = A00(0, 17, 8);
            A08.ABz(encryptedId, AbstractC2501lf.A1B, new C2502lg(e));
        } catch (JSONException e2) {
            this.A00.A0M();
            c2470lA = this.A00.A03;
            InterfaceC2500le A082 = c2470lA.A08();
            String encryptedId2 = A00(0, 17, 8);
            A082.ABz(encryptedId2, AbstractC2501lf.A1A, new C2502lg(e2));
        }
    }
}
