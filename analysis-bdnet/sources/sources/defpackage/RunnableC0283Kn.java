package defpackage;

import ads_mobile_sdk.m03;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpConfig;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import org.chromium.net.impl.JavaUploadDataSinkBase;
import org.chromium.net.impl.JavaUrlRequestUtils;
import prince.dastan.vpn.activities.IPHunterActivity;

/* renamed from: Kn, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0283Kn implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ RunnableC0283Kn(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                C0459Ri c0459Ri = (C0459Ri) this.b;
                AbstractC0325Me abstractC0325Me = (AbstractC0325Me) this.c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.d;
                c0459Ri.getClass();
                try {
                    C4338vs n = AbstractC0325Me.n(c0459Ri.a);
                    if (n == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    C4259us c4259us = (C4259us) ((InterfaceC0205Hn) n.b);
                    synchronized (c4259us.d) {
                        c4259us.f = threadPoolExecutor;
                    }
                    ((InterfaceC0205Hn) n.b).a(new C0309Ln(abstractC0325Me, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    abstractC0325Me.N(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                Intent intent = (Intent) this.c;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.d;
                AbstractServiceC4492xo abstractServiceC4492xo = (AbstractServiceC4492xo) this.b;
                abstractServiceC4492xo.getClass();
                try {
                    abstractServiceC4492xo.b(intent);
                    return;
                } finally {
                    taskCompletionSource.setResult(null);
                }
            case 2:
                int i = 1;
                while (true) {
                    IPHunterActivity iPHunterActivity = (IPHunterActivity) this.b;
                    if (!iPHunterActivity.h) {
                        return;
                    }
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("command", "airplane_mode_simul");
                        iPHunterActivity.showAssist(bundle);
                    } catch (Exception e) {
                        iPHunterActivity.b();
                        F00.h(iPHunterActivity.getApplicationContext(), "IP Hunter Error: " + e.getMessage());
                    }
                    while (true) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) iPHunterActivity.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                            String a = iPHunterActivity.a();
                            String[] strArr = (String[]) this.c;
                            strArr[0] = a;
                            for (String str : (String[]) this.d) {
                                String trim = str.trim();
                                if (!trim.isEmpty() && strArr[0].startsWith(trim)) {
                                    StringBuilder sb = new StringBuilder("Found IP: ");
                                    ZT.s(sb, strArr[0], " (Matches prefix: ", trim, ") after ");
                                    iPHunterActivity.runOnUiThread(new RunnableC4342vw(iPHunterActivity, W50.r(sb, i, " attempt(s)"), 1));
                                    Context applicationContext = iPHunterActivity.getApplicationContext();
                                    int i2 = F00.a;
                                    new Handler(Looper.getMainLooper()).post(new S7(applicationContext, 24));
                                    return;
                                }
                            }
                            iPHunterActivity.runOnUiThread(new RunnableC4342vw(iPHunterActivity, W50.j(i, "No match found. Retrying... (Attempt: ", ")"), 2));
                            try {
                                Thread.sleep(1000L);
                                i++;
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        } else {
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                }
                break;
            case 3:
                ((JavaUploadDataSinkBase) this.b).lambda$executeOnUploadExecutor$5((String) this.c, (JavaUrlRequestUtils.CheckedRunnable) this.d);
                return;
            case 4:
                Uri uri = WebViewCompat.a;
                AbstractC4433x30.k();
                boolean b = AbstractC4196u30.r.b();
                WebViewStartUpConfig webViewStartUpConfig = (WebViewStartUpConfig) this.b;
                WebViewCompat.WebViewStartUpCallback webViewStartUpCallback = (WebViewCompat.WebViewStartUpCallback) this.c;
                if (b) {
                    AbstractC4354w30.a.a(webViewStartUpConfig, new C3290ic(webViewStartUpCallback, 28));
                    return;
                }
                if (webViewStartUpConfig.shouldRunUiThreadStartUpTasks()) {
                    WebSettings.getDefaultUserAgent(((Context) this.d).getApplicationContext());
                }
                new Handler(Looper.getMainLooper()).post(new RunnableC3954r1(webViewStartUpCallback, 20));
                return;
            default:
                ((m03) this.b).a((HashMap) this.c, (Context) this.d);
                return;
        }
    }
}
