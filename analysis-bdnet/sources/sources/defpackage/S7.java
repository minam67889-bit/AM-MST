package defpackage;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.f;
import androidx.fragment.app.g;
import androidx.fragment.app.t;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import dastan.prince.bdfreevpn.R;
import java.io.File;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.fragment.GraphFragment;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerThread;
import prince.dastan.vpn.service.vpn.TunnelUtils;
import prince.dastan.vpn.service.vpn.VpnUtils;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import prince.dastan.vpn.tethering.ProxyService;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes.dex */
public final class S7 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ S7(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void b() {
        while (true) {
            GraphFragment graphFragment = (GraphFragment) this.b;
            if (!graphFragment.b || graphFragment.getActivity() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (AbstractC3131gc0.n == 0) {
                AbstractC3131gc0.n = TrafficStats.getTotalRxBytes();
            }
            if (AbstractC3131gc0.m == 0) {
                AbstractC3131gc0.m = TrafficStats.getTotalTxBytes();
            }
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            long j = totalRxBytes - AbstractC3131gc0.n;
            long totalTxBytes = TrafficStats.getTotalTxBytes();
            long j2 = totalTxBytes - AbstractC3131gc0.m;
            AbstractC3131gc0.n = totalRxBytes;
            AbstractC3131gc0.m = totalTxBytes;
            arrayList.add(Long.valueOf(j));
            arrayList.add(Long.valueOf(j2));
            Long l = (Long) arrayList.get(0);
            Long l2 = (Long) arrayList.get(1);
            l.getClass();
            l2.getClass();
            C0886cV c0886cV = ((GraphFragment) this.b).c;
            long longValue = l.longValue();
            synchronized (c0886cV) {
                c0886cV.a();
                ArrayList arrayList2 = c0886cV.d;
                ((C0807bV) arrayList2.get(arrayList2.size() - 1)).b += longValue;
                ArrayList arrayList3 = c0886cV.f;
                ((C0807bV) arrayList3.get(arrayList3.size() - 1)).b += longValue;
            }
            C0886cV c0886cV2 = ((GraphFragment) this.b).c;
            long longValue2 = l2.longValue();
            synchronized (c0886cV2) {
                c0886cV2.a();
                ArrayList arrayList4 = c0886cV2.d;
                ((C0807bV) arrayList4.get(arrayList4.size() - 1)).a += longValue2;
                ArrayList arrayList5 = c0886cV2.f;
                ((C0807bV) arrayList5.get(arrayList5.size() - 1)).a += longValue2;
            }
            ((GraphFragment) this.b).getActivity().runOnUiThread(new S7(this, 12));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
        }
    }

    private final void c() {
        Object obj;
        synchronized (((PC) this.b).a) {
            obj = ((PC) this.b).f;
            ((PC) this.b).f = PC.k;
        }
        ((PC) this.b).h(obj);
    }

    private final void d() {
        PsiphonDNSService psiphonDNSService = (PsiphonDNSService) this.b;
        synchronized (psiphonDNSService) {
            SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-81251523196811L), psiphonDNSService.getString(R.string.starting_service_ssh));
            psiphonDNSService.d();
            String string = Deobfuscator$BDNETVPN$app.getString(-81290177902475L);
            NetworkInfo activeNetworkInfo = psiphonDNSService.c.getActiveNetworkInfo();
            SkStatus.logInfo(String.format(string, (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? Deobfuscator$BDNETVPN$app.getString(-81346012477323L) : TunnelUtils.getLocalIpAddress()));
            try {
                psiphonDNSService.f();
            } catch (Exception e) {
                SkStatus.logException(e);
                psiphonDNSService.b.post(new RunnableC2873dM(psiphonDNSService));
            }
        }
    }

    private final void e() {
        SocksDNSService socksDNSService = (SocksDNSService) this.b;
        synchronized (socksDNSService) {
            SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-86804915910539L), socksDNSService.getString(R.string.starting_service_ssh));
            socksDNSService.e();
            String string = Deobfuscator$BDNETVPN$app.getString(-86843570616203L);
            NetworkInfo activeNetworkInfo = socksDNSService.c.getActiveNetworkInfo();
            SkStatus.logInfo(String.format(string, (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? Deobfuscator$BDNETVPN$app.getString(-86899405191051L) : TunnelUtils.getLocalIpAddress()));
            try {
                SocksDNSService.F = true;
                new Thread(new RunnableC3954r1(socksDNSService, 14)).start();
                TunnelManagerThread tunnelManagerThread = new TunnelManagerThread(socksDNSService.b, socksDNSService);
                SocksDNSService.E = tunnelManagerThread;
                tunnelManagerThread.setOnStopClienteListener(new ST(socksDNSService));
                SocksDNSService.C = new Date().getTime();
            } catch (Exception e) {
                SkStatus.logException(e);
                socksDNSService.i();
                socksDNSService.k();
                socksDNSService.b.post(new TT(socksDNSService));
            }
        }
    }

    public HashSet a() {
        HashSet hashSet = new HashSet();
        Cursor g = ((C4581yy) this.b).c.g(new B2("SELECT * FROM room_table_modification_log WHERE invalidated = 1;", 6));
        while (g.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(g.getInt(0)));
            } catch (Throwable th) {
                g.close();
                throw th;
            }
        }
        g.close();
        if (!hashSet.isEmpty()) {
            ((C4581yy) this.b).f.r();
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        DialogInterface.OnDismissListener onDismissListener;
        Dialog dialog;
        View d;
        int width;
        int i;
        HashSet hashSet;
        Selector selector;
        boolean z;
        C3480l1 c3480l1;
        switch (this.a) {
            case 0:
                CC cc = (CC) this.b;
                if (cc.o) {
                    boolean z2 = cc.m;
                    R7 r7 = cc.a;
                    if (z2) {
                        cc.m = false;
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        r7.e = currentAnimationTimeMillis;
                        r7.g = -1L;
                        r7.f = currentAnimationTimeMillis;
                        r7.h = 0.5f;
                    }
                    if ((r7.g > 0 && AnimationUtils.currentAnimationTimeMillis() > r7.g + r7.i) || !cc.e()) {
                        cc.o = false;
                        return;
                    }
                    boolean z3 = cc.n;
                    ListView listView = cc.c;
                    if (z3) {
                        cc.n = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        listView.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (r7.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = r7.a(currentAnimationTimeMillis2);
                    long j = currentAnimationTimeMillis2 - r7.f;
                    r7.f = currentAnimationTimeMillis2;
                    cc.q.scrollListBy((int) (j * ((a * 4.0f) + ((-4.0f) * a * a)) * r7.d));
                    WeakHashMap weakHashMap = AbstractC2925e20.a;
                    listView.postOnAnimation(this);
                    return;
                }
                return;
            case 1:
                C0347Na c0347Na = (C0347Na) this.b;
                c0347Na.c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) c0347Na.e;
                C3165h20 c3165h20 = bottomSheetBehavior.O;
                if (c3165h20 != null && c3165h20.g()) {
                    c0347Na.a(c0347Na.b);
                    return;
                } else {
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.D(c0347Na.b);
                        return;
                    }
                    return;
                }
            case 2:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.b;
                Object obj = constraintTrackingWorker.b.b.a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                String str = obj instanceof String ? (String) obj : null;
                if (TextUtils.isEmpty(str)) {
                    C3975rD.c().b(ConstraintTrackingWorker.k, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.i.i(new DC());
                    return;
                }
                C3569m50 c3569m50 = constraintTrackingWorker.b.d;
                Context context = constraintTrackingWorker.a;
                WorkerParameters workerParameters = constraintTrackingWorker.f;
                c3569m50.getClass();
                ListenableWorker a2 = C3569m50.a(context, str, workerParameters);
                constraintTrackingWorker.j = a2;
                if (a2 == null) {
                    C3975rD.c().a(ConstraintTrackingWorker.k, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.i.i(new DC());
                    return;
                }
                C3091g50 j2 = C0777b50.b(constraintTrackingWorker.a).c.n().j(constraintTrackingWorker.b.a.toString());
                if (j2 == null) {
                    constraintTrackingWorker.i.i(new DC());
                    return;
                }
                Context context2 = constraintTrackingWorker.a;
                P40 p40 = new P40(context2, C0777b50.b(context2).d, constraintTrackingWorker);
                p40.b(Collections.singletonList(j2));
                if (!p40.a(constraintTrackingWorker.b.a.toString())) {
                    C3975rD.c().a(ConstraintTrackingWorker.k, W50.D("Constraints not met for delegate ", str, ". Requesting retry."), new Throwable[0]);
                    constraintTrackingWorker.i.i(new EC());
                    return;
                }
                C3975rD.c().a(ConstraintTrackingWorker.k, W50.m("Constraints met for delegate ", str), new Throwable[0]);
                try {
                    C3278iS d2 = constraintTrackingWorker.j.d();
                    d2.addListener(new RunnableC3320j1(7, constraintTrackingWorker, d2), constraintTrackingWorker.b.c);
                    return;
                } catch (Throwable th) {
                    C3975rD c = C3975rD.c();
                    String str2 = ConstraintTrackingWorker.k;
                    c.a(str2, W50.D("Delegated worker ", str, " threw exception in startWork."), th);
                    synchronized (constraintTrackingWorker.g) {
                        try {
                            if (constraintTrackingWorker.h) {
                                C3975rD.c().a(str2, "Constraints were unmet, Retrying.", new Throwable[0]);
                                constraintTrackingWorker.i.i(new EC());
                            } else {
                                constraintTrackingWorker.i.i(new DC());
                            }
                            return;
                        } finally {
                        }
                    }
                }
            case 3:
                AnimationAnimationListenerC4567yk animationAnimationListenerC4567yk = (AnimationAnimationListenerC4567yk) this.b;
                animationAnimationListenerC4567yk.b.endViewTransition(animationAnimationListenerC4567yk.c);
                animationAnimationListenerC4567yk.d.a();
                return;
            case 4:
                AbstractC4260ut.a(4, (ArrayList) this.b);
                return;
            case 5:
                g gVar = (g) this.b;
                onDismissListener = gVar.mOnDismissListener;
                dialog = gVar.mDialog;
                onDismissListener.onDismiss(dialog);
                return;
            case 6:
                C0831bm c0831bm = (C0831bm) this.b;
                int i2 = c0831bm.b.o;
                int i3 = c0831bm.a;
                boolean z4 = i3 == 3;
                DrawerLayout drawerLayout = c0831bm.d;
                if (z4) {
                    d = drawerLayout.d(3);
                    width = (d != null ? -d.getWidth() : 0) + i2;
                } else {
                    d = drawerLayout.d(5);
                    width = drawerLayout.getWidth() - i2;
                }
                if (d != null) {
                    if (((!z4 || d.getLeft() >= width) && (z4 || d.getLeft() <= width)) || drawerLayout.g(d) != 0) {
                        return;
                    }
                    C0670Zl c0670Zl = (C0670Zl) d.getLayoutParams();
                    c0831bm.b.s(d, width, d.getTop());
                    c0670Zl.c = true;
                    drawerLayout.invalidate();
                    View d3 = drawerLayout.d(i3 == 3 ? 5 : 3);
                    if (d3 != null) {
                        drawerLayout.b(d3);
                    }
                    if (drawerLayout.r) {
                        return;
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        drawerLayout.getChildAt(i4).dispatchTouchEvent(obtain2);
                    }
                    obtain2.recycle();
                    drawerLayout.r = true;
                    return;
                }
                return;
            case 7:
                C3304im c3304im = (C3304im) this.b;
                c3304im.l = null;
                c3304im.drawableStateChanged();
                return;
            case 8:
                FWPuncherService fWPuncherService = (FWPuncherService) this.b;
                synchronized (fWPuncherService) {
                    try {
                        FWPuncherService.q = 0L;
                        fWPuncherService.f();
                        try {
                            Thread thread = fWPuncherService.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                            }
                            Process process = fWPuncherService.e;
                            if (process != null) {
                                process.destroy();
                            }
                            File file = fWPuncherService.f;
                            if (file != null) {
                                VpnUtils.killProcess(file);
                            }
                            RunnableC0129Ep runnableC0129Ep = fWPuncherService.i;
                            if (runnableC0129Ep != null) {
                                runnableC0129Ep.b = true;
                            }
                            fWPuncherService.e = null;
                            fWPuncherService.f = null;
                        } catch (Exception unused) {
                        }
                        try {
                            fWPuncherService.unregisterReceiver(fWPuncherService.n);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            fWPuncherService.h.unregisterNetworkCallback(fWPuncherService.m);
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(fWPuncherService);
                    } finally {
                    }
                }
                ((FWPuncherService) this.b).a();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused4) {
                }
                SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-73490517292939L), ((FWPuncherService) this.b).getString(R.string.state_disconnected));
                FWPuncherService.r.addStatus(Deobfuscator$BDNETVPN$app.getString(-73546351867787L));
                return;
            case 9:
                C0648Yp c0648Yp = (C0648Yp) this.b;
                int i5 = c0648Yp.A;
                ValueAnimator valueAnimator = c0648Yp.z;
                if (i5 != 1) {
                    i = 2;
                    if (i5 != 2) {
                        return;
                    }
                } else {
                    i = 2;
                    valueAnimator.cancel();
                }
                c0648Yp.A = 3;
                float[] fArr = new float[i];
                fArr[0] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                fArr[1] = 0.0f;
                valueAnimator.setFloatValues(fArr);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 10:
                ((f) this.b).d();
                return;
            case 11:
                ((t) this.b).x(true);
                return;
            case 12:
                boolean isTunnelActive = SkStatus.isTunnelActive();
                S7 s7 = (S7) this.b;
                if (isTunnelActive) {
                    try {
                        ((GraphFragment) s7.b).a();
                    } catch (Exception unused5) {
                    }
                }
                if (FWPuncherService.o) {
                    try {
                        ((GraphFragment) s7.b).a();
                        return;
                    } catch (Exception unused6) {
                        return;
                    }
                }
                return;
            case 13:
                b();
                return;
            case 14:
                ReentrantReadWriteLock.ReadLock readLock = ((C4581yy) this.b).c.h.readLock();
                try {
                    try {
                        readLock.lock();
                    } finally {
                        readLock.unlock();
                    }
                } catch (SQLiteException | IllegalStateException e) {
                    e = e;
                    hashSet = null;
                }
                if (((C4581yy) this.b).a() && ((C4581yy) this.b).d.compareAndSet(true, false) && !((SQLiteDatabase) ((C4581yy) this.b).c.c.o().b).inTransaction()) {
                    WorkDatabase_Impl workDatabase_Impl = ((C4581yy) this.b).c;
                    if (workDatabase_Impl.f) {
                        try {
                            C0263Jt o = workDatabase_Impl.c.o();
                            o.b();
                            try {
                                hashSet = a();
                                try {
                                    o.q();
                                    o.i();
                                } catch (Throwable th2) {
                                    th = th2;
                                    o.i();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                            readLock.unlock();
                            if (hashSet == null) {
                                return;
                            } else {
                                return;
                            }
                        } catch (IllegalStateException e3) {
                            e = e3;
                            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                            readLock.unlock();
                            if (hashSet == null) {
                            }
                        }
                    } else {
                        hashSet = a();
                    }
                    readLock.unlock();
                    if (hashSet == null || hashSet.isEmpty()) {
                        return;
                    }
                    synchronized (((C4581yy) this.b).h) {
                        try {
                            YP yp = (YP) ((C4581yy) this.b).h.iterator();
                            if (yp.hasNext()) {
                                ((AbstractC4502xy) ((Map.Entry) yp.next()).getValue()).getClass();
                                throw null;
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 15:
                c();
                return;
            case 16:
                ProxyService proxyService = (ProxyService) this.b;
                Log.d("ProxyService", "do proxy server start");
                while (proxyService.f != null && (selector = proxyService.e) != null) {
                    try {
                        selector.select();
                    } catch (Exception e4) {
                        Log.e("ProxyService", "selector select exception", e4);
                    }
                    if (proxyService.e.isOpen()) {
                        Iterator<SelectionKey> it = proxyService.e.selectedKeys().iterator();
                        while (it.hasNext()) {
                            SelectionKey next = it.next();
                            it.remove();
                            Object attachment = next.attachment();
                            try {
                                (attachment instanceof C0323Mc ? (C0323Mc) attachment : new C0323Mc()).c(next);
                            } catch (Exception unused7) {
                            }
                        }
                    }
                }
                Log.d("ProxyService", "do proxy server finish");
                ProxyService.i = false;
                return;
            case 17:
                d();
                return;
            case 18:
                RecyclerView recyclerView = (RecyclerView) this.b;
                AbstractC0799bN abstractC0799bN = recyclerView.I;
                if (abstractC0799bN != null) {
                    C3936qk c3936qk = (C3936qk) abstractC0799bN;
                    ArrayList arrayList = c3936qk.h;
                    boolean isEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = c3936qk.j;
                    boolean isEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = c3936qk.k;
                    boolean isEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = c3936qk.i;
                    boolean isEmpty4 = arrayList4.isEmpty();
                    if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                        Iterator it2 = arrayList.iterator();
                        while (true) {
                            boolean hasNext = it2.hasNext();
                            long j3 = c3936qk.d;
                            if (hasNext) {
                                AbstractC4143tN abstractC4143tN = (AbstractC4143tN) it2.next();
                                View view = abstractC4143tN.a;
                                ViewPropertyAnimator animate = view.animate();
                                c3936qk.q.add(abstractC4143tN);
                                animate.setDuration(j3).alpha(0.0f).setListener(new C3541lk(c3936qk, abstractC4143tN, animate, view)).start();
                            } else {
                                arrayList.clear();
                                if (!isEmpty2) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    c3936qk.m.add(arrayList5);
                                    arrayList2.clear();
                                    RunnableC3461kk runnableC3461kk = new RunnableC3461kk(c3936qk, arrayList5, 0);
                                    if (isEmpty) {
                                        runnableC3461kk.run();
                                    } else {
                                        View view2 = ((C3857pk) arrayList5.get(0)).a.a;
                                        WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                                        view2.postOnAnimationDelayed(runnableC3461kk, j3);
                                    }
                                }
                                if (!isEmpty3) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    c3936qk.n.add(arrayList6);
                                    arrayList3.clear();
                                    RunnableC3461kk runnableC3461kk2 = new RunnableC3461kk(c3936qk, arrayList6, 1);
                                    if (isEmpty) {
                                        runnableC3461kk2.run();
                                    } else {
                                        View view3 = ((C3778ok) arrayList6.get(0)).a.a;
                                        WeakHashMap weakHashMap3 = AbstractC2925e20.a;
                                        view3.postOnAnimationDelayed(runnableC3461kk2, j3);
                                    }
                                }
                                if (!isEmpty4) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    c3936qk.l.add(arrayList7);
                                    arrayList4.clear();
                                    RunnableC3461kk runnableC3461kk3 = new RunnableC3461kk(c3936qk, arrayList7, 2);
                                    if (isEmpty && isEmpty2 && isEmpty3) {
                                        runnableC3461kk3.run();
                                    } else {
                                        if (isEmpty) {
                                            j3 = 0;
                                        }
                                        long max = Math.max(!isEmpty2 ? c3936qk.e : 0L, !isEmpty3 ? c3936qk.f : 0L) + j3;
                                        View view4 = ((AbstractC4143tN) arrayList7.get(0)).a;
                                        WeakHashMap weakHashMap4 = AbstractC2925e20.a;
                                        view4.postOnAnimationDelayed(runnableC3461kk3, max);
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                recyclerView.j0 = z;
                return;
            case 19:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.b;
                if (searchView$SearchAutoComplete.f) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f = false;
                    return;
                }
                return;
            case 20:
                e();
                return;
            case 21:
                ((StaggeredGridLayoutManager) this.b).B0();
                return;
            case 22:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.b).c.g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 23:
                ActionMenuView actionMenuView = ((Toolbar) this.b).a;
                if (actionMenuView == null || (c3480l1 = actionMenuView.t) == null) {
                    return;
                }
                c3480l1.l();
                return;
            case 24:
                SweetToast.success((Context) this.b, "Success! IP Found!");
                return;
            case 25:
                ((C3165h20) this.b).p(0);
                return;
            case 26:
                Worker worker = (Worker) this.b;
                try {
                    worker.f.i(worker.g());
                    return;
                } catch (Throwable th4) {
                    worker.f.j(th4);
                    return;
                }
            default:
                XRayDNSService xRayDNSService = (XRayDNSService) this.b;
                synchronized (xRayDNSService) {
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-99548083877771L), xRayDNSService.getString(R.string.starting_service_ssh));
                    xRayDNSService.f();
                    String string = Deobfuscator$BDNETVPN$app.getString(-99586738583435L);
                    NetworkInfo activeNetworkInfo = xRayDNSService.c.getActiveNetworkInfo();
                    SkStatus.logInfo(String.format(string, (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? Deobfuscator$BDNETVPN$app.getString(-99642573158283L) : TunnelUtils.getLocalIpAddress()));
                    try {
                        XRayDNSService.D = true;
                        xRayDNSService.i();
                        TunnelManagerThread tunnelManagerThread = new TunnelManagerThread(xRayDNSService.b, xRayDNSService);
                        XRayDNSService.C = tunnelManagerThread;
                        tunnelManagerThread.setOnStopClienteListener(new J50(xRayDNSService));
                    } catch (Exception e5) {
                        SkStatus.logException(e5);
                        xRayDNSService.j();
                        xRayDNSService.l();
                        xRayDNSService.b.post(new K50(xRayDNSService));
                    }
                }
                return;
        }
    }
}
