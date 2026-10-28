package ads_mobile_sdk;

import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.AbstractC0434Qc;
import defpackage.AbstractC4167q6;
import defpackage.AbstractC4542v10;
import defpackage.AbstractC4747xe;
import defpackage.AbstractC4766xx;
import defpackage.C0471Rn;
import defpackage.C3506hW;
import defpackage.C4785y70;
import defpackage.InterfaceC3821lc0;
import defpackage.InterfaceC3975nc0;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* loaded from: classes.dex */
public final class at {
    public final ex0 a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public at(ex0 ex0Var) {
        AbstractC4766xx.p(ex0Var, "flags");
        this.a = ex0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x01a9 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #2 {all -> 0x005b, blocks: (B:4:0x001b, B:6:0x0030, B:9:0x0037, B:11:0x0047, B:12:0x01a5, B:14:0x01a9, B:19:0x0061, B:21:0x0083, B:23:0x0086, B:25:0x008c, B:26:0x0095, B:28:0x0126, B:30:0x013f, B:31:0x0168, B:33:0x016c, B:34:0x0173, B:36:0x0183, B:38:0x0187, B:39:0x018e, B:43:0x019e), top: B:2:0x001b, inners: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InterfaceC3821lc0 a(String str) {
        InterfaceC3821lc0 j01Var;
        InterfaceC3821lc0 interfaceC3821lc0;
        SecretKey generateKey;
        byte[] encoded;
        Integer num;
        Integer num2;
        int i;
        ex0 ex0Var = this.a;
        s11 s11Var = s11.CUI_NAME_BLOB_ENCRYPTION;
        WeakHashMap weakHashMap = hs3.a;
        rr3 a = hs3.a(s11Var, C0471Rn.a, true);
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(UserVerificationMethods.USER_VERIFY_PATTERN);
                generateKey = keyGenerator.generateKey();
                encoded = generateKey.getEncoded();
            } catch (Exception e) {
                j01Var = new j01(e, null, null, 6);
            }
            if (encoded != null && encoded.length == 16) {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(1, generateKey);
                byte[] iv = cipher.getIV();
                if (iv.length != 16) {
                    interfaceC3821lc0 = new m01("iv had unexpected length: " + iv.length);
                } else {
                    byte[] bytes = str.getBytes(AbstractC0434Qc.a);
                    AbstractC4766xx.o(bytes, "getBytes(...)");
                    byte[] doFinal = cipher.doFinal(bytes);
                    KeyGenerator keyGenerator2 = KeyGenerator.getInstance("HmacSHA1");
                    keyGenerator2.init(UserVerificationMethods.USER_VERIFY_PATTERN);
                    SecretKey generateKey2 = keyGenerator2.generateKey();
                    byte[] encoded2 = generateKey2.getEncoded();
                    if (encoded2 != null && encoded2.length == 16) {
                        byte[] g = AbstractC4542v10.g(encoded, encoded2);
                        if (g == null) {
                            interfaceC3821lc0 = new m01("Unable to compute sha1 of symmetric key.");
                        } else {
                            byte[] iv2 = cipher.getIV();
                            AbstractC4766xx.o(iv2, "getIV(...)");
                            byte[] V = AbstractC4167q6.V(g, iv2);
                            AbstractC4766xx.m(doFinal);
                            byte[] V2 = AbstractC4167q6.V(V, doFinal);
                            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode((String) ex0Var.a("gads:gads:blob_encryption_public_key", "MIGdMA0GCSqGSIb3DQEBAQUAA4GLADCBhwKBgQDILejyvRuVmPUcwUTpEVaE8A_-D7bZPnTOMs91 WZ0iSLQrK0lcICNKeWom1jWNBxjw89oyra30BlZCDEu7nfGacaTmzX74wD_RJV3xh81_9l2PWr46 0J9DJcXSi4yGzJyyUYp7Q1YXam8J6DYWV6PoemmP71T2fbm9i1VQy1NFgQIBAw", wr.a), 8)));
                            Cipher cipher2 = Cipher.getInstance("RSA/None/OAEPwithSHA-1andMGF1Padding");
                            cipher2.init(1, generatePublic);
                            C4785y70 v = is1.v();
                            du a2 = du.a(encoded, 0, encoded.length);
                            v.d$3();
                            ((is1) v.b).b(a2);
                            du a3 = du.a(encoded2, 0, encoded2.length);
                            v.d$3();
                            ((is1) v.b).a(a3);
                            v.d$3();
                            is1 is1Var = (is1) v.b;
                            is1Var.getClass();
                            is1Var.type_ = 3;
                            i = is1Var.bitField0_;
                            is1Var.bitField0_ = 1 | i;
                            byte[] doFinal2 = cipher2.doFinal(((is1) v.b()).c());
                            byte[] decode = Base64.decode(ex0Var.s(), 11);
                            if (decode.length != 5) {
                                j01Var = new m01("sha1 has of public key has unexpected size: " + decode.length + "}");
                            } else {
                                AbstractC4766xx.m(doFinal2);
                                byte[] V3 = AbstractC4167q6.V(AbstractC4167q6.V(decode, doFinal2), V2);
                                Mac mac = Mac.getInstance("HmacSHA1");
                                mac.init(generateKey2);
                                byte[] doFinal3 = mac.doFinal(V2);
                                AbstractC4766xx.o(doFinal3, "doFinal(...)");
                                j01Var = new q01(Base64.encodeToString(AbstractC4167q6.V(V3, doFinal3), 11));
                            }
                            interfaceC3821lc0 = j01Var;
                        }
                    } else {
                        if (encoded2 != null) {
                            num2 = Integer.valueOf(encoded2.length);
                        } else {
                            num2 = null;
                        }
                        interfaceC3821lc0 = new m01("Hmac is unexpected size: " + num2);
                    }
                }
                if (interfaceC3821lc0 instanceof i01) {
                    xs3.a((i01) interfaceC3821lc0, false);
                }
                AbstractC4747xe.l(a, null);
                return interfaceC3821lc0;
            }
            if (encoded != null) {
                num = Integer.valueOf(encoded.length);
            } else {
                num = null;
            }
            interfaceC3821lc0 = new m01("Encoded symmetric key had unexected length: " + num);
            if (interfaceC3821lc0 instanceof i01) {
            }
            AbstractC4747xe.l(a, null);
            return interfaceC3821lc0;
        } catch (Throwable th) {
            try {
                a.b(th);
                if (!(th instanceof InterfaceC3975nc0)) {
                    if (!(th instanceof C3506hW) && !(th instanceof CancellationException)) {
                        a.a(th);
                    }
                    if (!(th instanceof C3506hW)) {
                        if (!(th instanceof CancellationException)) {
                            if (th instanceof w01) {
                                throw th;
                            }
                            throw new b01(th);
                        }
                        throw new wz0(th);
                    }
                    throw new i21(th);
                }
                throw th;
            } finally {
            }
        }
    }
}
