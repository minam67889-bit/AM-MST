package ads_mobile_sdk;

import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.AbstractC0325Me;
import defpackage.AbstractC0738ad;
import defpackage.AbstractC3634my;
import defpackage.C0729aX;
import defpackage.C3147go;
import defpackage.C4473xa0;
import defpackage.Ge0;
import defpackage.I20;
import defpackage.I6;
import defpackage.Sf0;
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
public final class fp {
    public final hq0 a;

    public fp(hq0 hq0Var) {
        AbstractC3634my.g(hq0Var, "flags");
        this.a = hq0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0193 A[Catch: all -> 0x005b, TRY_LEAVE, TryCatch #2 {all -> 0x005b, blocks: (B:4:0x001b, B:6:0x0030, B:9:0x0037, B:11:0x0047, B:12:0x018f, B:14:0x0193, B:19:0x0061, B:21:0x0081, B:23:0x0084, B:25:0x008a, B:26:0x0093, B:28:0x0110, B:29:0x0128, B:31:0x0152, B:33:0x0156, B:34:0x015d, B:36:0x016d, B:38:0x0171, B:39:0x0178, B:43:0x0188), top: B:2:0x001b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Sf0 a(String str) {
        Sf0 sf0;
        Sf0 sf02;
        SecretKey generateKey;
        byte[] encoded;
        int i;
        AbstractC3634my.g(str, "unencryptedString");
        pu0 pu0Var = pu0.CUI_NAME_BLOB_ENCRYPTION;
        WeakHashMap weakHashMap = ed3.a;
        rc3 a = ed3.a(pu0Var, C3147go.a, true);
        fb1 fb1Var = null;
        boolean z = false;
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(UserVerificationMethods.USER_VERIFY_PATTERN);
                generateKey = keyGenerator.generateKey();
                encoded = generateKey.getEncoded();
            } catch (Exception e) {
                sf0 = new qt0(e, fb1Var, z ? 1 : 0, 6);
            }
            if (encoded != null && encoded.length == 16) {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(1, generateKey);
                byte[] iv = cipher.getIV();
                if (iv.length != 16) {
                    sf02 = new tt0("iv had unexpected length: " + iv.length);
                } else {
                    byte[] bytes = str.getBytes(AbstractC0738ad.a);
                    AbstractC3634my.f(bytes, "getBytes(...)");
                    byte[] doFinal = cipher.doFinal(bytes);
                    KeyGenerator keyGenerator2 = KeyGenerator.getInstance("HmacSHA1");
                    keyGenerator2.init(UserVerificationMethods.USER_VERIFY_PATTERN);
                    SecretKey generateKey2 = keyGenerator2.generateKey();
                    byte[] encoded2 = generateKey2.getEncoded();
                    if (encoded2 == null || encoded2.length != 16) {
                        sf02 = new tt0("Hmac is unexpected size: " + (encoded2 != null ? Integer.valueOf(encoded2.length) : null));
                    } else {
                        byte[] i2 = I20.i(encoded, encoded2);
                        if (i2 == null) {
                            sf02 = new tt0("Unable to compute sha1 of symmetric key.");
                        } else {
                            byte[] iv2 = cipher.getIV();
                            AbstractC3634my.f(iv2, "getIV(...)");
                            byte[] Z = I6.Z(i2, iv2);
                            AbstractC3634my.d(doFinal);
                            byte[] Z2 = I6.Z(Z, doFinal);
                            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(this.a.p(), 8)));
                            Cipher cipher2 = Cipher.getInstance("RSA/None/OAEPwithSHA-1andMGF1Padding");
                            cipher2.init(1, generatePublic);
                            C4473xa0 o = mi1.o();
                            o.e(qq.a(encoded));
                            o.d(qq.a(encoded2));
                            o.b();
                            mi1 mi1Var = (mi1) o.b;
                            mi1Var.getClass();
                            mi1Var.type_ = 3;
                            i = mi1Var.bitField0_;
                            mi1Var.bitField0_ = 1 | i;
                            byte[] doFinal2 = cipher2.doFinal(((mi1) o.a()).a());
                            byte[] decode = Base64.decode(this.a.q(), 11);
                            if (decode.length != 5) {
                                sf02 = new tt0("sha1 has of public key has unexpected size: " + decode.length + "}");
                            } else {
                                AbstractC3634my.d(doFinal2);
                                byte[] Z3 = I6.Z(I6.Z(decode, doFinal2), Z2);
                                Mac mac = Mac.getInstance("HmacSHA1");
                                mac.init(generateKey2);
                                byte[] doFinal3 = mac.doFinal(Z2);
                                AbstractC3634my.f(doFinal3, "doFinal(...)");
                                sf0 = new vt0(Base64.encodeToString(I6.Z(Z3, doFinal3), 11));
                                sf02 = sf0;
                            }
                        }
                    }
                }
                if (sf02 instanceof pt0) {
                    td3.a((pt0) sf02, false);
                }
                AbstractC0325Me.k(a, null);
                return sf02;
            }
            sf02 = new tt0("Encoded symmetric key had unexected length: " + (encoded != null ? Integer.valueOf(encoded.length) : null));
            if (sf02 instanceof pt0) {
            }
            AbstractC0325Me.k(a, null);
            return sf02;
        } catch (Throwable th) {
            try {
                a.b(th);
                if (th instanceof Ge0) {
                    throw th;
                }
                a.a(th);
                if (th instanceof C0729aX) {
                    throw new ev0(th);
                }
                if (th instanceof CancellationException) {
                    throw new dt0(th);
                }
                if (th instanceof au0) {
                    throw th;
                }
                throw new it0(th);
            } finally {
            }
        }
    }
}
