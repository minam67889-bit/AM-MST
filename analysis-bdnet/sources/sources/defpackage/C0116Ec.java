package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.net.impl.JavaUploadDataSinkBase;
import prince.dastan.vpn.tethering.ProxyService;

/* renamed from: Ec, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0116Ec {
    public static final Pattern q = Pattern.compile("(.*):([\\d]+)");
    public static final Pattern r = Pattern.compile("(https?)://([^:/]+)(:[\\d]+])?/.*");
    public static int s = 0;
    public static int t = 0;
    public SocketChannel a;
    public SelectionKey b;
    public ByteBuffer c;
    public int d;
    public int f;
    public String g;
    public final boolean i;
    public String j;
    public int k;
    public String l;
    public C0323Mc m;
    public String n;
    public C4452xG o;
    public final String p;
    public char[] e = new char[UserVerificationMethods.USER_VERIFY_ALL];
    public final HashMap h = new HashMap();

    public C0116Ec(boolean z) {
        this.i = z;
        StringBuilder sb = new StringBuilder("channel");
        int i = s;
        s = i + 1;
        sb.append(i);
        this.p = sb.toString();
        this.f = 0;
        f();
    }

    public final void a() {
        String str = this.p;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" close socket ");
            int i = t;
            t = i + 1;
            sb.append(i);
            Log.d("TetherChannel", sb.toString());
            this.b.cancel();
            this.a.close();
        } catch (Exception e) {
            Log.e("TetherChannel", str + " close exception", e);
        }
    }

    public final String b() {
        if (!this.i) {
            return null;
        }
        String c = c();
        if ("CONNECT".equals(this.j)) {
            Matcher matcher = q.matcher(c);
            if (matcher.matches()) {
                this.l = matcher.group(1);
                this.k = Integer.parseInt(matcher.group(2));
            }
        } else {
            Matcher matcher2 = r.matcher(c);
            if (matcher2.matches()) {
                this.l = matcher2.group(2);
                if (matcher2.group(3) != null) {
                    Integer.parseInt(matcher2.group(3).substring(1));
                } else if ("https".equals(matcher2.group(1))) {
                    this.k = 443;
                } else {
                    this.k = 80;
                }
            }
        }
        return this.l;
    }

    public final String c() {
        String str = (String) this.o.c;
        if (str == null || str.startsWith("/")) {
            this.n = W50.C((String) this.h.get("Host"), str);
        } else {
            this.n = str;
        }
        return this.n;
    }

    public final void d() {
        int i;
        C0323Mc c0323Mc;
        String str;
        SocketChannel b;
        if (this.c == null) {
            this.c = ByteBuffer.allocate(JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE);
        }
        this.c.clear();
        try {
            i = this.a.read(this.c);
        } catch (IOException e) {
            Log.e("TetherChannel", this.p + " read exception.", e);
            i = 0;
        }
        this.c.flip();
        int limit = this.c.limit() - this.c.position();
        StringBuilder n = ZT.n(this.i ? "request" : "response", " ");
        n.append(this.p);
        n.append(" read count ");
        n.append(i);
        n.append(" datasize ");
        n.append(limit);
        Log.d("TetherChannel", n.toString());
        if (i == -1) {
            C0323Mc c0323Mc2 = this.m;
            if (c0323Mc2 != null) {
                Log.d("ChannelPair", "onClose " + this);
                c0323Mc2.a();
                return;
            }
            return;
        }
        if (limit == 0) {
            return;
        }
        if (this.d == 3) {
            C0323Mc c0323Mc3 = this.m;
            if (c0323Mc3 != null) {
                c0323Mc3.d(this);
                return;
            }
            return;
        }
        String e2 = e();
        while (true) {
            if (e2 == null) {
                break;
            }
            int i2 = this.d;
            if (i2 == 1) {
                Log.d("TetherChannel", this.p + " setStatusLine " + e2);
                this.g = e2;
                if (this.i) {
                    C4452xG c4452xG = new C4452xG(3);
                    if (!TextUtils.isEmpty(e2)) {
                        try {
                            int indexOf = e2.indexOf(" ");
                            if (indexOf != -1) {
                                c4452xG.b = e2.substring(0, indexOf);
                                String substring = e2.substring(indexOf + 1);
                                int indexOf2 = substring.indexOf(" ");
                                if (indexOf2 != -1) {
                                    c4452xG.c = substring.substring(0, indexOf2);
                                    String substring2 = substring.substring(indexOf2 + 1);
                                    if (!TextUtils.isEmpty(substring2)) {
                                        c4452xG.d = substring2;
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    this.o = c4452xG;
                    this.j = (String) c4452xG.b;
                } else if (!TextUtils.isEmpty(e2)) {
                    try {
                        int indexOf3 = e2.indexOf(" ");
                        if (indexOf3 != -1) {
                            e2.substring(0, indexOf3);
                            String substring3 = e2.substring(indexOf3 + 1);
                            int indexOf4 = substring3.indexOf(" ");
                            if (indexOf4 != -1) {
                                Integer.parseInt(substring3.substring(0, indexOf4));
                                substring3.substring(indexOf4 + 1);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                this.d = 2;
                if (this.m != null) {
                    Log.d("ChannelPair", "onStatusLine " + this.g);
                }
            } else if (i2 != 2) {
                continue;
            } else if (TextUtils.isEmpty(e2)) {
                this.d = 3;
                C0323Mc c0323Mc4 = this.m;
                if (c0323Mc4 != null) {
                    Log.d("ChannelPair", "onHeaders");
                    if (this.i) {
                        try {
                            str = this.j;
                        } catch (Exception e5) {
                            Log.e("ChannelPair", "establish response exception", e5);
                        }
                        if (c0323Mc4.b == null) {
                            if ("CONNECT".equals(str)) {
                                String b2 = b();
                                if (this.k == 0) {
                                    b();
                                }
                                b = C0323Mc.b(this.k, b2);
                            } else {
                                String b3 = b();
                                if (this.k == 0) {
                                    b();
                                }
                                b = C0323Mc.b(this.k, b3);
                            }
                            if (b == null) {
                                c0323Mc4.a();
                            } else {
                                C0116Ec c0116Ec = new C0116Ec(false);
                                c0323Mc4.b = c0116Ec;
                                c0116Ec.m = c0323Mc4;
                                c0116Ec.a = b;
                                c0323Mc4.b.b = b.register(ProxyService.g.e, 1, c0323Mc4);
                            }
                        } else {
                            Log.d("ChannelPair", "reuse socket " + c0323Mc4.b.p);
                            c0323Mc4.b.f();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        if ("CONNECT".equals(str)) {
                            stringBuffer.append("HTTP/1.0 200 Connection Established\r\nProxy-agent: KissProxy\r\n\r\n");
                            c0323Mc4.b.d = 3;
                            c0323Mc4.a.g(ByteBuffer.wrap(stringBuffer.toString().getBytes()));
                        } else {
                            stringBuffer.append(str + " ");
                            String c = c();
                            if (!c.startsWith("/")) {
                                c = c.substring(c.indexOf(47, 8));
                            }
                            Log.d("ChannelPair", "connResponse " + c);
                            stringBuffer.append(c);
                            stringBuffer.append(" ");
                            C4452xG c4452xG2 = this.o;
                            stringBuffer.append(c4452xG2 == null ? null : (String) c4452xG2.d);
                            stringBuffer.append("\r\n");
                            HashMap hashMap = this.h;
                            for (String str2 : hashMap.keySet()) {
                                stringBuffer.append(str2);
                                stringBuffer.append(": ");
                                stringBuffer.append((String) hashMap.get(str2));
                                stringBuffer.append("\r\n");
                            }
                            stringBuffer.append("\r\n");
                            String stringBuffer2 = stringBuffer.toString();
                            Log.d("ChannelPair", stringBuffer2);
                            c0323Mc4.b.g(ByteBuffer.wrap(stringBuffer2.getBytes()));
                        }
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(this.g);
                        stringBuffer3.append("\r\n");
                        for (Map.Entry entry : this.h.entrySet()) {
                            stringBuffer3.append((String) entry.getKey());
                            stringBuffer3.append(": ");
                            stringBuffer3.append((String) entry.getValue());
                            stringBuffer3.append("\r\n");
                        }
                        stringBuffer3.append("\r\n");
                        c0323Mc4.a.g(ByteBuffer.wrap(stringBuffer3.toString().getBytes()));
                    }
                }
            } else if (!TextUtils.isEmpty(e2)) {
                int indexOf5 = e2.indexOf(":");
                String str3 = this.p;
                if (indexOf5 <= 0 || indexOf5 >= e2.length()) {
                    Log.w("TetherChannel", str3 + " invalid header content " + e2);
                } else {
                    String substring4 = e2.substring(0, indexOf5);
                    String trim = e2.substring(indexOf5 + 1).trim();
                    if (TextUtils.isEmpty(substring4) || TextUtils.isEmpty(trim)) {
                        Log.w("TetherChannel", str3 + " +invalie header value");
                    } else {
                        Log.d("TetherChannel", str3 + " addHeader [name] " + substring4 + " [value] " + trim);
                        this.h.put(substring4, trim);
                    }
                }
            }
            e2 = e();
        }
        if (this.d != 3 || (c0323Mc = this.m) == null) {
            return;
        }
        c0323Mc.d(this);
    }

    public final String e() {
        byte b;
        if (this.c.remaining() <= 0) {
            return null;
        }
        while (this.c.remaining() > 0 && (b = this.c.get()) != -1 && b != 10) {
            if (b != 13) {
                int i = this.f;
                char[] cArr = this.e;
                if (i == cArr.length) {
                    char[] cArr2 = new char[cArr.length * 2];
                    this.e = cArr2;
                    System.arraycopy(cArr, 0, cArr2, 0, i);
                }
                char[] cArr3 = this.e;
                int i2 = this.f;
                this.f = i2 + 1;
                cArr3[i2] = (char) b;
            }
        }
        String copyValueOf = String.copyValueOf(this.e, 0, this.f);
        this.f = 0;
        return copyValueOf;
    }

    public final void f() {
        System.currentTimeMillis();
        if ("CONNECT".equals(this.j)) {
            this.d = 3;
        } else {
            this.d = 1;
        }
        this.h.clear();
    }

    public final void g(ByteBuffer byteBuffer) {
        try {
            this.a.write(byteBuffer);
        } catch (IOException e) {
            Log.e("TetherChannel", this.p + "  write exception.", e);
        }
    }
}
