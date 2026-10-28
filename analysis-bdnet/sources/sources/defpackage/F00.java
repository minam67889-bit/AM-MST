package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Pattern;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;

/* loaded from: classes2.dex */
public abstract class F00 {
    public static final /* synthetic */ int a = 0;

    static {
        Deobfuscator$BDNETVPN$app.getString(-172927600129931L);
        Deobfuscator$BDNETVPN$app.getString(-172957664901003L);
        Deobfuscator$BDNETVPN$app.getString(-172992024639371L);
        Deobfuscator$BDNETVPN$app.getString(-173022089410443L);
        Deobfuscator$BDNETVPN$app.getString(-173043564246923L);
        Deobfuscator$BDNETVPN$app.getString(-173069334050699L);
        Deobfuscator$BDNETVPN$app.getString(-173095103854475L);
        Deobfuscator$BDNETVPN$app.getString(-173172413265803L);
        Deobfuscator$BDNETVPN$app.getString(-173206773004171L);
        Deobfuscator$BDNETVPN$app.getString(-173254017644427L);
        Deobfuscator$BDNETVPN$app.getString(-173327032088459L);
        Deobfuscator$BDNETVPN$app.getString(-173369981761419L);
        Deobfuscator$BDNETVPN$app.getString(-173404341499787L);
        Deobfuscator$BDNETVPN$app.getString(-173447291172747L);
        Deobfuscator$BDNETVPN$app.getString(-173511715682187L);
        Deobfuscator$BDNETVPN$app.getString(-173601909995403L);
        Deobfuscator$BDNETVPN$app.getString(-173649154635659L);
        Deobfuscator$BDNETVPN$app.getString(-173709284177803L);
        Deobfuscator$BDNETVPN$app.getString(-173747938883467L);
        Deobfuscator$BDNETVPN$app.getString(-173769413719947L);
        Deobfuscator$BDNETVPN$app.getString(-173795183523723L);
        Deobfuscator$BDNETVPN$app.getString(-173846723131275L);
        Deobfuscator$BDNETVPN$app.getString(-173885377836939L);
        Deobfuscator$BDNETVPN$app.getString(-173958392280971L);
        Deobfuscator$BDNETVPN$app.getString(-173988457052043L);
        Deobfuscator$BDNETVPN$app.getString(-174014226855819L);
        Deobfuscator$BDNETVPN$app.getString(-174074356397963L);
        Deobfuscator$BDNETVPN$app.getString(-174194615482251L);
        Deobfuscator$BDNETVPN$app.getString(-174314874566539L);
        Deobfuscator$BDNETVPN$app.getString(-174460903454603L);
        Deobfuscator$BDNETVPN$app.getString(-174594047440779L);
        Deobfuscator$BDNETVPN$app.getString(-174727191426955L);
        Deobfuscator$BDNETVPN$app.getString(-174860335413131L);
        Deobfuscator$BDNETVPN$app.getString(-174937644824459L);
        Deobfuscator$BDNETVPN$app.getString(-175049313974155L);
        Deobfuscator$BDNETVPN$app.getString(-175160983123851L);
        Deobfuscator$BDNETVPN$app.getString(-175264062338955L);
        Deobfuscator$BDNETVPN$app.getString(-175375731488651L);
        Deobfuscator$BDNETVPN$app.getString(-175487400638347L);
        Deobfuscator$BDNETVPN$app.getString(-175534645278603L);
        Deobfuscator$BDNETVPN$app.getString(-175581889918859L);
        Deobfuscator$BDNETVPN$app.getString(-175629134559115L);
        Deobfuscator$BDNETVPN$app.getString(-175676379199371L);
        Deobfuscator$BDNETVPN$app.getString(-175719328872331L);
        Deobfuscator$BDNETVPN$app.getString(-175895422531467L);
        Deobfuscator$BDNETVPN$app.getString(-176071516190603L);
        Deobfuscator$BDNETVPN$app.getString(-176247609849739L);
        Deobfuscator$BDNETVPN$app.getString(-176385048803211L);
        Deobfuscator$BDNETVPN$app.getString(-176522487756683L);
        Deobfuscator$BDNETVPN$app.getString(-176659926710155L);
        Deobfuscator$BDNETVPN$app.getString(-176754415990667L);
        Deobfuscator$BDNETVPN$app.getString(-176848905271179L);
        Deobfuscator$BDNETVPN$app.getString(-176964869388171L);
        Deobfuscator$BDNETVPN$app.getString(-177080833505163L);
        Deobfuscator$BDNETVPN$app.getString(-177175322785675L);
        Deobfuscator$BDNETVPN$app.getString(-177248337229707L);
        Deobfuscator$BDNETVPN$app.getString(-177342826510219L);
        Deobfuscator$BDNETVPN$app.getString(-177463085594507L);
        Deobfuscator$BDNETVPN$app.getString(-177536100038539L);
        Deobfuscator$BDNETVPN$app.getString(-177617704417163L);
        Deobfuscator$BDNETVPN$app.getString(-177699308795787L);
        Deobfuscator$BDNETVPN$app.getString(-177798093043595L);
        Deobfuscator$BDNETVPN$app.getString(-177862517553035L);
        Deobfuscator$BDNETVPN$app.getString(-177926942062475L);
        Deobfuscator$BDNETVPN$app.getString(-177987071604619L);
        Deobfuscator$BDNETVPN$app.getString(-178042906179467L);
        Deobfuscator$BDNETVPN$app.getString(-178098740754315L);
        Deobfuscator$BDNETVPN$app.getString(-178133100492683L);
        Deobfuscator$BDNETVPN$app.getString(-178197525002123L);
        Deobfuscator$BDNETVPN$app.getString(-178261949511563L);
        Deobfuscator$BDNETVPN$app.getString(-178292014282635L);
        Deobfuscator$BDNETVPN$app.getString(-178330668988299L);
        Deobfuscator$BDNETVPN$app.getString(-178352143824779L);
        Deobfuscator$BDNETVPN$app.getString(-178373618661259L);
        Deobfuscator$BDNETVPN$app.getString(-178395093497739L);
        Deobfuscator$BDNETVPN$app.getString(-178416568334219L);
        Deobfuscator$BDNETVPN$app.getString(-178438043170699L);
        Deobfuscator$BDNETVPN$app.getString(-178459518007179L);
        Deobfuscator$BDNETVPN$app.getString(-178480992843659L);
        Deobfuscator$BDNETVPN$app.getString(-178511057614731L);
        Deobfuscator$BDNETVPN$app.getString(-178541122385803L);
        Deobfuscator$BDNETVPN$app.getString(-178571187156875L);
        Deobfuscator$BDNETVPN$app.getString(-178609841862539L);
        Deobfuscator$BDNETVPN$app.getString(-178648496568203L);
        Deobfuscator$BDNETVPN$app.getString(-178687151273867L);
        Deobfuscator$BDNETVPN$app.getString(-178747280816011L);
        Deobfuscator$BDNETVPN$app.getString(-178803115390859L);
        Deobfuscator$BDNETVPN$app.getString(-178858949965707L);
        Deobfuscator$BDNETVPN$app.getString(-178914784540555L);
        Deobfuscator$BDNETVPN$app.getString(-178974914082699L);
        Deobfuscator$BDNETVPN$app.getString(-179004978853771L);
        Deobfuscator$BDNETVPN$app.getString(-179035043624843L);
        Deobfuscator$BDNETVPN$app.getString(-179073698330507L);
        Deobfuscator$BDNETVPN$app.getString(-179112353036171L);
        Deobfuscator$BDNETVPN$app.getString(-179151007741835L);
        Deobfuscator$BDNETVPN$app.getString(-179189662447499L);
        Deobfuscator$BDNETVPN$app.getString(-179245497022347L);
        Deobfuscator$BDNETVPN$app.getString(-179301331597195L);
    }

    public static void a(Context context, String str) {
        ((ClipboardManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-169079309432715L))).setPrimaryClip(ClipData.newPlainText(Deobfuscator$BDNETVPN$app.getString(-169122259105675L), str));
    }

    public static String b(String str) {
        try {
            return AbstractC4569ym.e(str, AbstractC4569ym.a);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        for (Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
            byte[] byteArray = signature.toByteArray();
            MessageDigest messageDigest = MessageDigest.getInstance(Deobfuscator$BDNETVPN$app.getString(-169173798713227L));
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] cArr2 = new char[digest.length * 2];
            for (int i = 0; i < digest.length; i++) {
                byte b = digest[i];
                int i2 = i * 2;
                cArr2[i2] = cArr[(b & 255) >>> 4];
                cArr2[i2 + 1] = cArr[b & 15];
            }
            sb.append(new String(cArr2));
        }
        return sb.toString();
    }

    public static String d(InetAddress inetAddress, int i) {
        byte[] address = inetAddress.getAddress();
        int i2 = (-1) << (32 - i);
        int i3 = 0;
        for (int i4 = 0; i4 < address.length; i4++) {
            i3 |= (address[i4] & 255) << ((3 - i4) * 8);
        }
        int nextInt = new Random().nextInt((((~i2) | r4) - r4) - 1) + (i3 & i2) + 1;
        return ((nextInt >> 24) & 255) + Deobfuscator$BDNETVPN$app.getString(-170956210141067L) + ((nextInt >> 16) & 255) + Deobfuscator$BDNETVPN$app.getString(-170964800075659L) + ((nextInt >> 8) & 255) + Deobfuscator$BDNETVPN$app.getString(-170973390010251L) + (nextInt & 255);
    }

    public static String e(String str) {
        return str.split(Pattern.quote(Deobfuscator$BDNETVPN$app.getString(-169465856489355L)))[1];
    }

    public static int f(int i, int i2) {
        return i + ((int) (Math.random() * ((i2 - i) + 1)));
    }

    public static void g(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new C00(context, str, 0));
    }

    public static void h(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new C00(context, str, 2));
    }

    public static void i(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new C00(context, str, 1));
    }
}
