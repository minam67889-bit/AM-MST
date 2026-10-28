package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: Fl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0158Fl implements InterfaceC4525un, VU {
    public static final String[] b = {"8.8.8.8", "8.8.4.4"};
    public Context a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ C0158Fl(Context context, boolean z) {
        this.a = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HashSet e(LineNumberReader lineNumberReader) {
        String hostAddress;
        HashSet hashSet = new HashSet(10);
        while (true) {
            String readLine = lineNumberReader.readLine();
            if (readLine != null) {
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    int i = indexOf + 4;
                    int length = readLine.length() - 1;
                    if (length < i) {
                        Log.d("DnsUtil", "Malformed property detected: \"" + readLine + '\"');
                    } else {
                        String substring2 = readLine.substring(i, length);
                        if (!substring2.isEmpty() && (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4"))) {
                            InetAddress byName = InetAddress.getByName(substring2);
                            if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                                hashSet.add(hostAddress);
                            }
                        }
                    }
                }
            } else {
                return hashSet;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4525un
    public void a(AbstractC4747xe abstractC4747xe) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC3979nf("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new RunnableC4756xn(this, abstractC4747xe, threadPoolExecutor, 0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C0285Ki b() {
        Context context = this.a;
        if (context != null) {
            C0285Ki c0285Ki = new C0285Ki();
            c0285Ki.a = C0288Kl.a(AbstractC4673wh.b);
            J0 j0 = new J0(context, 3);
            c0285Ki.b = j0;
            c0285Ki.c = C0288Kl.a(new C4142po(8, j0, new C0917ci(j0)));
            J0 j02 = c0285Ki.b;
            c0285Ki.d = new C0917ci((InterfaceC0890cL) j02);
            InterfaceC0890cL a = C0288Kl.a(new C4291rk(c0285Ki.d, C0288Kl.a(new C0083Co(j02))));
            c0285Ki.e = a;
            C0083Co c0083Co = new C0083Co();
            J0 j03 = c0285Ki.b;
            MQ mq = new MQ(j03, a, c0083Co);
            InterfaceC0890cL interfaceC0890cL = c0285Ki.a;
            InterfaceC0890cL interfaceC0890cL2 = c0285Ki.c;
            C4291rk c4291rk = new C4291rk(interfaceC0890cL, interfaceC0890cL2, mq, a, a);
            N50 n50 = AbstractC4817ya0.f;
            Q60 q60 = AbstractC4747xe.j;
            Q8 q8 = new Q8();
            q8.a = j03;
            q8.b = interfaceC0890cL2;
            q8.c = a;
            q8.d = mq;
            q8.e = interfaceC0890cL;
            q8.f = a;
            q8.g = n50;
            q8.h = q60;
            q8.i = a;
            c0285Ki.f = C0288Kl.a(new C4291rk(c4291rk, q8, new RW(interfaceC0890cL, a, mq, a)));
            return c0285Ki;
        }
        throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|(7:3|4|5|(4:8|(1:22)(4:10|(1:15)|17|(2:19|20)(1:21))|16|6)|23|24|(2:26|(15:32|33|(3:35|(3:37|(2:39|(2:40|(2:42|(4:44|45|(2:48|46)|49)(1:51))(4:52|53|(2:56|54)|57)))(1:58)|50)|59)|60|(1:62)|63|(2:65|(4:70|71|(2:73|74)|(2:80|81)(1:79))(1:69))|85|(1:67)|70|71|(0)|(1:77)|80|81)(1:30)))|93|(1:28)|32|33|(0)|60|(0)|63|(0)|85|(0)|70|71|(0)|(0)|80|81) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0146, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0147, code lost:
    
        android.util.Log.d("DnsUtil", "Exception in getServersMethodExec", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x010e, code lost:
    
        android.util.Log.d("DnsUtil", "Exception detecting DNS servers using ConnectivityManager method", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b A[Catch: Exception -> 0x00d9, TryCatch #1 {Exception -> 0x00d9, blocks: (B:33:0x0075, B:35:0x008b, B:37:0x0093, B:39:0x009f, B:40:0x00af, B:42:0x00b5, B:45:0x00c1, B:46:0x00c5, B:48:0x00cb, B:53:0x00db, B:54:0x00df, B:56:0x00e5, B:50:0x00f3, B:60:0x00f6, B:62:0x00fc, B:63:0x00ff, B:65:0x0105), top: B:32:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc A[Catch: Exception -> 0x00d9, TryCatch #1 {Exception -> 0x00d9, blocks: (B:33:0x0075, B:35:0x008b, B:37:0x0093, B:39:0x009f, B:40:0x00af, B:42:0x00b5, B:45:0x00c1, B:46:0x00c5, B:48:0x00cb, B:53:0x00db, B:54:0x00df, B:56:0x00e5, B:50:0x00f3, B:60:0x00f6, B:62:0x00fc, B:63:0x00ff, B:65:0x0105), top: B:32:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105 A[Catch: Exception -> 0x00d9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d9, blocks: (B:33:0x0075, B:35:0x008b, B:37:0x0093, B:39:0x009f, B:40:0x00af, B:42:0x00b5, B:45:0x00c1, B:46:0x00c5, B:48:0x00cb, B:53:0x00db, B:54:0x00df, B:56:0x00e5, B:50:0x00f3, B:60:0x00f6, B:62:0x00fc, B:63:0x00ff, B:65:0x0105), top: B:32:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c A[Catch: Exception -> 0x0146, TRY_LEAVE, TryCatch #2 {Exception -> 0x0146, blocks: (B:71:0x011a, B:73:0x013c), top: B:70:0x011a }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] c() {
        String[] strArr;
        String[] strArr2;
        HashSet e;
        ArrayList arrayList;
        ConnectivityManager connectivityManager;
        String[] strArr3 = null;
        if (Build.VERSION.SDK_INT < 26) {
            ArrayList arrayList2 = new ArrayList();
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
                String[] strArr4 = {"net.dns1", "net.dns2"};
                for (int i = 0; i < 2; i++) {
                    String str = (String) method.invoke(null, strArr4[i]);
                    if (str != null) {
                        if (!str.matches("^\\d+(\\.\\d+){3}$") && !str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) {
                        }
                        if (!arrayList2.contains(str)) {
                            arrayList2.add(str);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.d("DnsUtil", "Exception detecting DNS servers using SystemProperties method", e2);
            }
            if (arrayList2.size() > 0) {
                strArr = (String[]) arrayList2.toArray(new String[0]);
                if (strArr == null && strArr.length > 0) {
                    return strArr;
                }
                arrayList = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (connectivityManager.getNetworkInfo(network).isConnected()) {
                            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                            List<InetAddress> dnsServers = linkProperties.getDnsServers();
                            Iterator<RouteInfo> it = linkProperties.getRoutes().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().isDefaultRoute()) {
                                        Iterator<InetAddress> it2 = dnsServers.iterator();
                                        while (it2.hasNext()) {
                                            arrayList.add(it2.next().getHostAddress());
                                        }
                                    }
                                } else {
                                    Iterator<InetAddress> it3 = dnsServers.iterator();
                                    while (it3.hasNext()) {
                                        arrayList3.add(it3.next().getHostAddress());
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(arrayList3);
                }
                if (arrayList.size() > 0) {
                    strArr2 = (String[]) arrayList.toArray(new String[0]);
                    if (strArr2 == null && strArr2.length > 0) {
                        return strArr2;
                    }
                    e = e(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream())));
                    if (e.size() > 0) {
                        strArr3 = (String[]) e.toArray(new String[0]);
                    }
                    if (strArr3 == null && strArr3.length > 0) {
                        return strArr3;
                    }
                    return b;
                }
                strArr2 = null;
                if (strArr2 == null) {
                }
                e = e(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream())));
                if (e.size() > 0) {
                }
                if (strArr3 == null) {
                }
                return b;
            }
        }
        strArr = null;
        if (strArr == null) {
        }
        arrayList = new ArrayList();
        ArrayList arrayList32 = new ArrayList();
        connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        if (connectivityManager != null) {
        }
        if (arrayList.isEmpty()) {
        }
        if (arrayList.size() > 0) {
        }
        strArr2 = null;
        if (strArr2 == null) {
        }
        e = e(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream())));
        if (e.size() > 0) {
        }
        if (strArr3 == null) {
        }
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VU
    public WU d(C4213qi c4213qi) {
        C3243e5 c3243e5 = (C3243e5) c4213qi.d;
        if (c3243e5 != null) {
            Context context = this.a;
            if (context != null) {
                String str = (String) c4213qi.c;
                if (!TextUtils.isEmpty(str)) {
                    C4213qi c4213qi2 = new C4213qi(context, str, c3243e5, true);
                    return new C3762kt((Context) c4213qi2.b, (String) c4213qi2.c, (C3243e5) c4213qi2.d, c4213qi2.a);
                }
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        throw new IllegalArgumentException("Must set a callback to create the configuration.");
    }
}
