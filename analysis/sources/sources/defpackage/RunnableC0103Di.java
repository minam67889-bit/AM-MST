package defpackage;

import ads_mobile_sdk.am;
import ads_mobile_sdk.ed;
import ads_mobile_sdk.fa;
import ads_mobile_sdk.fd;
import ads_mobile_sdk.mv;
import ads_mobile_sdk.p9;
import ads_mobile_sdk.pe2;
import ads_mobile_sdk.q9;
import ads_mobile_sdk.ra3;
import ads_mobile_sdk.rt3;
import ads_mobile_sdk.sx0;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.vpn.TunnelManagerThread;

/* renamed from: Di, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0103Di implements Runnable {
    public final /* synthetic */ int a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC0103Di(int i) {
        this.a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void b() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void c() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void d() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void e() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        HashSet hashSet;
        HashMap hashMap;
        HashSet hashSet2;
        HashSet hashSet3;
        HashMap hashMap2;
        KeyguardManager keyguardManager;
        am amVar;
        HashSet hashSet4;
        HashMap hashMap3;
        String str;
        Activity activity;
        String str2;
        Boolean bool;
        String str3;
        switch (this.a) {
            case 0:
                return;
            case 1:
                try {
                    int i = QW.a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (C4602vn.k != null) {
                        C4602vn.a().c();
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i2 = QW.a;
                    Trace.endSection();
                    throw th;
                }
            case 2:
            case 3:
                return;
            case 4:
                TunnelManagerThread tunnelManagerThread = SocksDNSService.m;
                if (tunnelManagerThread != null) {
                    tunnelManagerThread.reconnectSSH();
                    return;
                }
                return;
            case 5:
            case 6:
                return;
            case 7:
                Point point = null;
                if (pe2.b != null) {
                    point = new Point(0, 0);
                    pe2.b.getDefaultDisplay().getRealSize(point);
                }
                if (point != null) {
                    pe2.c = point;
                    return;
                }
                return;
            case 8:
                String str4 = "OMIDLIB";
                rt3 rt3Var = rt3.g;
                rt3Var.getClass();
                rt3Var.b.clear();
                Iterator it = Collections.unmodifiableCollection(q9.c.b).iterator();
                while (it.hasNext()) {
                    ((p9) it.next()).getClass();
                }
                rt3Var.f = System.nanoTime();
                fd fdVar = rt3Var.d;
                fdVar.getClass();
                q9 q9Var = q9.c;
                HashMap hashMap4 = fdVar.b;
                HashMap hashMap5 = fdVar.a;
                HashSet hashSet5 = fdVar.d;
                HashSet hashSet6 = fdVar.h;
                HashMap hashMap6 = fdVar.c;
                HashMap hashMap7 = fdVar.g;
                HashSet hashSet7 = fdVar.e;
                HashSet hashSet8 = fdVar.f;
                if (q9Var != null) {
                    Iterator it2 = Collections.unmodifiableCollection(q9Var.b).iterator();
                    while (it2.hasNext()) {
                        p9 p9Var = (p9) it2.next();
                        View view = (View) p9Var.c.get();
                        if (p9Var.e && !p9Var.f) {
                            String str5 = p9Var.g;
                            if (view != null) {
                                Iterator it3 = it2;
                                Context context = view.getContext();
                                while (true) {
                                    if (!(context instanceof ContextWrapper)) {
                                        activity = null;
                                    } else if (context instanceof Activity) {
                                        activity = (Activity) context;
                                    } else {
                                        context = ((ContextWrapper) context).getBaseContext();
                                    }
                                }
                                boolean isInPictureInPictureMode = activity != null ? activity.isInPictureInPictureMode() : false;
                                if (isInPictureInPictureMode) {
                                    hashSet6.add(str5);
                                }
                                HashSet hashSet9 = hashSet6;
                                if (view.isAttachedToWindow()) {
                                    boolean hasWindowFocus = view.hasWindowFocus();
                                    str2 = str4;
                                    WeakHashMap weakHashMap = fdVar.i;
                                    if (hasWindowFocus) {
                                        weakHashMap.remove(view);
                                        bool = Boolean.FALSE;
                                    } else if (weakHashMap.containsKey(view)) {
                                        bool = (Boolean) weakHashMap.get(view);
                                    } else {
                                        bool = Boolean.FALSE;
                                        weakHashMap.put(view, bool);
                                    }
                                    if (!bool.booleanValue() || isInPictureInPictureMode) {
                                        HashSet hashSet10 = new HashSet();
                                        View view2 = view;
                                        while (true) {
                                            if (view2 == null) {
                                                hashSet5.addAll(hashSet10);
                                                str3 = null;
                                            } else {
                                                String d = AbstractC3852m20.d(view2);
                                                if (d != null) {
                                                    str3 = d;
                                                } else {
                                                    hashSet10.add(view2);
                                                    Object parent = view2.getParent();
                                                    view2 = parent instanceof View ? (View) parent : null;
                                                }
                                            }
                                        }
                                    } else {
                                        str3 = "noWindowFocus";
                                    }
                                } else {
                                    str3 = "notAttached";
                                    str2 = str4;
                                }
                                if (str3 == null) {
                                    hashSet7.add(str5);
                                    hashMap5.put(view, str5);
                                    Iterator it4 = p9Var.b.a.iterator();
                                    while (it4.hasNext()) {
                                        sx0 sx0Var = (sx0) it4.next();
                                        View view3 = (View) sx0Var.a.get();
                                        if (view3 != null) {
                                            ed edVar = (ed) hashMap4.get(view3);
                                            if (edVar != null) {
                                                edVar.b.add(str5);
                                            } else {
                                                hashMap4.put(view3, new ed(sx0Var, str5));
                                            }
                                        }
                                    }
                                } else if (str3 != "noWindowFocus") {
                                    hashSet8.add(str5);
                                    hashMap6.put(str5, view);
                                    hashMap7.put(str5, str3);
                                }
                                hashSet6 = hashSet9;
                                it2 = it3;
                                str4 = str2;
                            } else {
                                hashSet8.add(str5);
                                hashMap7.put(str5, "noAdView");
                                it2 = it2;
                            }
                        }
                    }
                }
                String str6 = str4;
                HashSet hashSet11 = hashSet6;
                long nanoTime = System.nanoTime();
                am amVar2 = rt3Var.c;
                fa faVar = (fa) amVar2.b;
                int size = hashSet8.size();
                am amVar3 = rt3Var.e;
                if (size > 0) {
                    Iterator it5 = hashSet8.iterator();
                    while (it5.hasNext()) {
                        String str7 = (String) it5.next();
                        Iterator it6 = it5;
                        JSONObject a = faVar.a((View) null);
                        View view4 = (View) hashMap6.get(str7);
                        String str8 = (String) hashMap7.get(str7);
                        if (str8 != null) {
                            hashSet4 = hashSet8;
                            JSONObject a2 = ((fa) amVar2.a).a(view4);
                            try {
                                a2.put("adSessionId", str7);
                                amVar = amVar2;
                                hashMap3 = hashMap7;
                                str = str6;
                            } catch (JSONException e) {
                                amVar = amVar2;
                                hashMap3 = hashMap7;
                                str = str6;
                                Log.e(str, "Error with setting ad session id", e);
                            }
                            try {
                                a2.put("notVisibleReason", str8);
                            } catch (JSONException e2) {
                                Log.e(str, "Error with setting not visible reason", e2);
                            }
                            pe2.a(a, a2);
                        } else {
                            amVar = amVar2;
                            hashSet4 = hashSet8;
                            hashMap3 = hashMap7;
                            str = str6;
                        }
                        pe2.b(a);
                        HashSet hashSet12 = new HashSet();
                        hashSet12.add(str7);
                        ((mv) amVar3.b).a(new N40(amVar3, hashSet12, a, nanoTime, 1));
                        str6 = str;
                        it5 = it6;
                        hashSet8 = hashSet4;
                        amVar2 = amVar;
                        hashMap7 = hashMap3;
                    }
                }
                HashSet hashSet13 = hashSet8;
                HashMap hashMap8 = hashMap7;
                if (hashSet7.size() > 0) {
                    JSONObject a3 = faVar.a((View) null);
                    hashSet3 = hashSet13;
                    hashSet = hashSet7;
                    hashMap2 = hashMap8;
                    hashMap = hashMap6;
                    hashSet2 = hashSet11;
                    faVar.a(null, a3, rt3Var, true, false);
                    pe2.b(a3);
                    ((mv) amVar3.b).a(new N40(amVar3, hashSet, a3, nanoTime, 0));
                } else {
                    hashSet = hashSet7;
                    hashMap = hashMap6;
                    hashSet2 = hashSet11;
                    hashSet3 = hashSet13;
                    hashMap2 = hashMap8;
                    ((mv) amVar3.b).a(new AsyncTaskC0831bb0(amVar3));
                }
                hashMap5.clear();
                hashMap4.clear();
                hashMap.clear();
                hashSet5.clear();
                hashSet.clear();
                hashSet3.clear();
                hashMap2.clear();
                fdVar.j = false;
                hashSet2.clear();
                long nanoTime2 = System.nanoTime() - rt3Var.f;
                ArrayList arrayList = rt3Var.a;
                if (arrayList.size() > 0) {
                    Iterator it7 = arrayList.iterator();
                    if (it7.hasNext()) {
                        if (it7.next() != null) {
                            throw new ClassCastException();
                        }
                        TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                        throw null;
                    }
                }
                ra3 ra3Var = ra3.d;
                Context context2 = (Context) ra3Var.a.get();
                if (context2 == null || (keyguardManager = (KeyguardManager) context2.getSystemService("keyguard")) == null) {
                    return;
                }
                boolean isDeviceLocked = keyguardManager.isDeviceLocked();
                ra3Var.a(ra3Var.b, isDeviceLocked);
                ra3Var.c = isDeviceLocked;
                return;
            default:
                Handler handler = rt3.i;
                if (handler != null) {
                    handler.post(rt3.j);
                    rt3.i.postDelayed(rt3.k, 200L);
                    return;
                }
                return;
        }
    }
}
