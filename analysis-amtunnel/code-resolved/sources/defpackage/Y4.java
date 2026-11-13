package defpackage;

import android.animation.ValueAnimator;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
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
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.vpn.TunnelManagerThread;
import prince.udp.vpn.service.vpn.TunnelUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes.dex */
public final class Y4 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ Y4(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.b
            Ep r0 = (defpackage.C0089Ep) r0
            ZA r0 = r0.c
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r0.h
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r1 = 1
            r2 = 0
            r3 = 0
            r0.lock()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            java.lang.Object r4 = r5.b     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            Ep r4 = (defpackage.C0089Ep) r4     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            boolean r4 = r4.a()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            if (r4 != 0) goto L20
            r0.unlock()
            return
        L20:
            java.lang.Object r4 = r5.b     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            Ep r4 = (defpackage.C0089Ep) r4     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            java.util.concurrent.atomic.AtomicBoolean r4 = r4.d     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            boolean r1 = r4.compareAndSet(r1, r2)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            if (r1 != 0) goto L30
            r0.unlock()
            return
        L30:
            java.lang.Object r1 = r5.b     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            Ep r1 = (defpackage.C0089Ep) r1     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            ZA r1 = r1.c     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            VF r1 = r1.c     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            xm r1 = r1.d()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            android.database.sqlite.SQLiteClosable r1 = r1.b     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            if (r1 == 0) goto L4a
            r0.unlock()
            return
        L4a:
            java.lang.Object r1 = r5.b     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            Ep r1 = (defpackage.C0089Ep) r1     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            ZA r1 = r1.c     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            boolean r2 = r1.f     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            if (r2 == 0) goto L73
            VF r1 = r1.c     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            xm r1 = r1.d()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            r1.a()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            java.util.HashSet r3 = r5.a()     // Catch: java.lang.Throwable -> L6e
            r1.l()     // Catch: java.lang.Throwable -> L6e
            r1.h()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            goto L77
        L68:
            r1 = move-exception
            goto Lbc
        L6a:
            r1 = move-exception
            goto L7b
        L6c:
            r1 = move-exception
            goto L7b
        L6e:
            r2 = move-exception
            r1.h()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
            throw r2     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
        L73:
            java.util.HashSet r3 = r5.a()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a java.lang.IllegalStateException -> L6c
        L77:
            r0.unlock()
            goto L83
        L7b:
            java.lang.String r2 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r2, r4, r1)     // Catch: java.lang.Throwable -> L68
            goto L77
        L83:
            if (r3 == 0) goto Lbb
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lbb
            java.lang.Object r0 = r5.b
            Ep r0 = (defpackage.C0089Ep) r0
            uB r0 = r0.h
            monitor-enter(r0)
            java.lang.Object r1 = r5.b     // Catch: java.lang.Throwable -> La6
            Ep r1 = (defpackage.C0089Ep) r1     // Catch: java.lang.Throwable -> La6
            uB r1 = r1.h     // Catch: java.lang.Throwable -> La6
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La6
            qB r1 = (defpackage.C3177qB) r1     // Catch: java.lang.Throwable -> La6
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La6
            if (r2 != 0) goto La8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            goto Lbb
        La6:
            r1 = move-exception
            goto Lb9
        La8:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> La6
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> La6
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> La6
            Dp r1 = (defpackage.AbstractC0073Dp) r1     // Catch: java.lang.Throwable -> La6
            r1.getClass()     // Catch: java.lang.Throwable -> La6
            r1 = 0
            throw r1     // Catch: java.lang.Throwable -> La6
        Lb9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            throw r1
        Lbb:
            return
        Lbc:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Y4.b():void");
    }

    private final void c() {
        Object obj;
        synchronized (((Wr) this.b).a) {
            obj = ((Wr) this.b).f;
            ((Wr) this.b).f = Wr.k;
        }
        ((Wr) this.b).h(obj);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [TI, java.lang.Thread] */
    private final void d() {
        SocksDNSService socksDNSService = (SocksDNSService) this.b;
        synchronized (socksDNSService) {
            SocksDNSService.t = true;
            SkStatus.updateStateString(SkStatus.SSH_STARTING, socksDNSService.getString(2131952171));
            socksDNSService.d();
            NetworkInfo activeNetworkInfo = socksDNSService.c.getActiveNetworkInfo();
            SkStatus.logInfo("Local IP: " + ((activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? "Indisponivel" : TunnelUtils.getLocalIpAddress()));
            try {
                ?? thread = new Thread();
                thread.b = "libudpqtwo";
                thread.a = socksDNSService;
                thread.e = C2507db.a(socksDNSService);
                socksDNSService.e = thread;
                thread.start();
                TunnelManagerThread tunnelManagerThread = new TunnelManagerThread(socksDNSService.b, socksDNSService);
                SocksDNSService.s = tunnelManagerThread;
                tunnelManagerThread.setOnStopClienteListener(new C3338tE(socksDNSService));
                SocksDNSService.q = new Date().getTime();
            } catch (Exception e) {
                SkStatus.logException(e);
                socksDNSService.b.post(new RunnableC3391uE(socksDNSService));
            }
        }
    }

    public HashSet a() {
        HashSet hashSet = new HashSet();
        Cursor g = ((C0089Ep) this.b).c.g(new C0367Xh("SELECT * FROM room_table_modification_log WHERE invalidated = 1;", 2));
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
            ((C0089Ep) this.b).f.m();
        }
        return hashSet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pr pr;
        View d;
        int width;
        int i;
        boolean z;
        Handler handler;
        Y4 y4;
        A0 a0;
        int i2 = 16;
        switch (this.a) {
            case 0:
                Nr nr = (Nr) this.b;
                if (nr.u) {
                    boolean z2 = nr.s;
                    X4 x4 = nr.a;
                    if (z2) {
                        nr.s = false;
                        x4.getClass();
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        x4.e = currentAnimationTimeMillis;
                        x4.g = -1L;
                        x4.f = currentAnimationTimeMillis;
                        x4.h = 0.5f;
                    }
                    if ((x4.g > 0 && AnimationUtils.currentAnimationTimeMillis() > x4.g + x4.i) || !nr.e()) {
                        nr.u = false;
                        return;
                    }
                    boolean z3 = nr.t;
                    View view = nr.c;
                    if (z3) {
                        nr.t = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        view.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (x4.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = x4.a(currentAnimationTimeMillis2);
                    long j = currentAnimationTimeMillis2 - x4.f;
                    x4.f = currentAnimationTimeMillis2;
                    nr.w.scrollListBy((int) (((float) j) * ((a * 4.0f) + ((-4.0f) * a * a)) * x4.d));
                    WeakHashMap weakHashMap = AbstractC3238rK.a;
                    view.postOnAnimation(this);
                    return;
                }
                return;
            case 1:
                C3649z7 c3649z7 = (C3649z7) this.b;
                c3649z7.c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) c3649z7.e;
                C3344tK c3344tK = bottomSheetBehavior.O;
                if (c3344tK != null && c3344tK.g()) {
                    c3649z7.a(c3649z7.b);
                    return;
                } else {
                    if (bottomSheetBehavior.N == 2) {
                        bottomSheetBehavior.D(c3649z7.b);
                        return;
                    }
                    return;
                }
            case 2:
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
            case 3:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.b;
                String b = constraintTrackingWorker.getInputData().b("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                if (TextUtils.isEmpty(b)) {
                    C3686zs.c().b(ConstraintTrackingWorker.f, "No worker to delegate to.", new Throwable[0]);
                    pr = new Pr();
                } else {
                    ListenableWorker a2 = constraintTrackingWorker.getWorkerFactory().a(constraintTrackingWorker.getApplicationContext(), b, constraintTrackingWorker.a);
                    constraintTrackingWorker.e = a2;
                    if (a2 != null) {
                        KM j2 = EM.W(constraintTrackingWorker.getApplicationContext()).l.n().j(constraintTrackingWorker.getId().toString());
                        if (j2 == null) {
                            constraintTrackingWorker.d.i(new Pr());
                            return;
                        }
                        C3346tM c3346tM = new C3346tM(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                        c3346tM.c(Collections.singletonList(j2));
                        if (!c3346tM.a(constraintTrackingWorker.getId().toString())) {
                            C3686zs.c().a(ConstraintTrackingWorker.f, AbstractC3603yE.x("Constraints not met for delegate ", b, ". Requesting retry."), new Throwable[0]);
                            constraintTrackingWorker.d.i(new Object());
                            return;
                        }
                        C3686zs.c().a(ConstraintTrackingWorker.f, AbstractC3603yE.w("Constraints met for delegate ", b), new Throwable[0]);
                        try {
                            Or startWork = constraintTrackingWorker.e.startWork();
                            startWork.addListener(new RunnableC3589y0(7, constraintTrackingWorker, startWork), constraintTrackingWorker.getBackgroundExecutor());
                            return;
                        } catch (Throwable th) {
                            C3686zs c = C3686zs.c();
                            String str = ConstraintTrackingWorker.f;
                            c.a(str, AbstractC3603yE.x("Delegated worker ", b, " threw exception in startWork."), th);
                            synchronized (constraintTrackingWorker.b) {
                                try {
                                    if (constraintTrackingWorker.c) {
                                        C3686zs.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                                        constraintTrackingWorker.d.i(new Object());
                                    } else {
                                        constraintTrackingWorker.d.i(new Pr());
                                    }
                                    return;
                                } finally {
                                }
                            }
                        }
                    }
                    C3686zs.c().a(ConstraintTrackingWorker.f, "No worker to delegate to.", new Throwable[0]);
                    pr = new Pr();
                }
                constraintTrackingWorker.d.i(pr);
                return;
            case 4:
                AnimationAnimationListenerC0200Mf animationAnimationListenerC0200Mf = (AnimationAnimationListenerC0200Mf) this.b;
                animationAnimationListenerC0200Mf.b.endViewTransition(animationAnimationListenerC0200Mf.c);
                animationAnimationListenerC0200Mf.d.a();
                return;
            case 5:
                AbstractC2781im.a((ArrayList) this.b, 4);
                return;
            case 6:
                g gVar = (g) this.b;
                g.access$100(gVar).onDismiss(g.access$000(gVar));
                return;
            case 7:
                I1 i1 = (I1) this.b;
                i1.a(true);
                i1.invalidateSelf();
                return;
            case 8:
                C0544ch c0544ch = (C0544ch) this.b;
                int i3 = c0544ch.i.o;
                int i4 = c0544ch.h;
                boolean z4 = i4 == 3;
                DrawerLayout drawerLayout = c0544ch.k;
                if (z4) {
                    d = drawerLayout.d(3);
                    width = (d != null ? -d.getWidth() : 0) + i3;
                } else {
                    d = drawerLayout.d(5);
                    width = drawerLayout.getWidth() - i3;
                }
                if (d != null) {
                    if (((!z4 || d.getLeft() >= width) && (z4 || d.getLeft() <= width)) || drawerLayout.g(d) != 0) {
                        return;
                    }
                    C0439ah c0439ah = (C0439ah) d.getLayoutParams();
                    c0544ch.i.s(d, width, d.getTop());
                    c0439ah.c = true;
                    drawerLayout.invalidate();
                    View d2 = drawerLayout.d(i4 == 3 ? 5 : 3);
                    if (d2 != null) {
                        drawerLayout.b(d2);
                    }
                    if (drawerLayout.x) {
                        return;
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        drawerLayout.getChildAt(i5).dispatchTouchEvent(obtain2);
                    }
                    obtain2.recycle();
                    drawerLayout.x = true;
                    return;
                }
                return;
            case 9:
                C2828jh c2828jh = (C2828jh) this.b;
                c2828jh.r = null;
                c2828jh.drawableStateChanged();
                return;
            case 10:
                C3624yj c3624yj = (C3624yj) this.b;
                int i6 = c3624yj.A;
                ValueAnimator valueAnimator = c3624yj.z;
                if (i6 != 1) {
                    i = 2;
                    if (i6 != 2) {
                        return;
                    }
                } else {
                    i = 2;
                    valueAnimator.cancel();
                }
                c3624yj.A = 3;
                float[] fArr = new float[i];
                fArr[0] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                fArr[1] = 0.0f;
                valueAnimator.setFloatValues(fArr);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 11:
                ((f) this.b).d();
                return;
            case 12:
                ((t) this.b).x(true);
                return;
            case 13:
                b();
                return;
            case 14:
                c();
                return;
            case 15:
                RecyclerView recyclerView = (RecyclerView) this.b;
                AbstractC3640yz abstractC3640yz = recyclerView.O;
                if (abstractC3640yz != null) {
                    C0063Df c0063Df = (C0063Df) abstractC3640yz;
                    ArrayList arrayList = c0063Df.h;
                    boolean z5 = !arrayList.isEmpty();
                    ArrayList arrayList2 = c0063Df.j;
                    boolean z6 = !arrayList2.isEmpty();
                    ArrayList arrayList3 = c0063Df.k;
                    boolean z7 = !arrayList3.isEmpty();
                    ArrayList arrayList4 = c0063Df.i;
                    boolean z8 = !arrayList4.isEmpty();
                    if (z5 || z6 || z8 || z7) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean hasNext = it.hasNext();
                            long j3 = c0063Df.d;
                            if (hasNext) {
                                Qz qz = (Qz) it.next();
                                View view2 = qz.a;
                                ViewPropertyAnimator animate = view2.animate();
                                c0063Df.q.add(qz);
                                animate.setDuration(j3).alpha(0.0f).setListener(new C3620yf(c0063Df, qz, animate, view2)).start();
                            } else {
                                arrayList.clear();
                                if (z6) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    c0063Df.m.add(arrayList5);
                                    arrayList2.clear();
                                    RunnableC3567xf runnableC3567xf = new RunnableC3567xf(c0063Df, arrayList5, 0);
                                    if (z5) {
                                        View view3 = ((C0047Cf) arrayList5.get(0)).a.a;
                                        WeakHashMap weakHashMap2 = AbstractC3238rK.a;
                                        view3.postOnAnimationDelayed(runnableC3567xf, j3);
                                    } else {
                                        runnableC3567xf.run();
                                    }
                                }
                                if (z7) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    c0063Df.n.add(arrayList6);
                                    arrayList3.clear();
                                    RunnableC3567xf runnableC3567xf2 = new RunnableC3567xf(c0063Df, arrayList6, 1);
                                    if (z5) {
                                        View view4 = ((C0031Bf) arrayList6.get(0)).a.a;
                                        WeakHashMap weakHashMap3 = AbstractC3238rK.a;
                                        view4.postOnAnimationDelayed(runnableC3567xf2, j3);
                                    } else {
                                        runnableC3567xf2.run();
                                    }
                                }
                                if (z8) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    c0063Df.l.add(arrayList7);
                                    arrayList4.clear();
                                    RunnableC3567xf runnableC3567xf3 = new RunnableC3567xf(c0063Df, arrayList7, 2);
                                    if (z5 || z6 || z7) {
                                        if (!z5) {
                                            j3 = 0;
                                        }
                                        long max = Math.max(z6 ? c0063Df.e : 0L, z7 ? c0063Df.f : 0L) + j3;
                                        View view5 = ((Qz) arrayList7.get(0)).a;
                                        WeakHashMap weakHashMap4 = AbstractC3238rK.a;
                                        view5.postOnAnimationDelayed(runnableC3567xf3, max);
                                    } else {
                                        runnableC3567xf3.run();
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                recyclerView.p0 = z;
                return;
            case 16:
                ScrollableNumberPicker scrollableNumberPicker = (ScrollableNumberPicker) this.b;
                if (scrollableNumberPicker.F) {
                    ScrollableNumberPicker.a(scrollableNumberPicker);
                    handler = scrollableNumberPicker.H;
                    y4 = new Y4(scrollableNumberPicker, i2);
                } else {
                    if (!scrollableNumberPicker.G) {
                        return;
                    }
                    ScrollableNumberPicker.c(scrollableNumberPicker);
                    handler = scrollableNumberPicker.H;
                    y4 = new Y4(scrollableNumberPicker, i2);
                }
                handler.postDelayed(y4, scrollableNumberPicker.s);
                return;
            case 17:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) this.b;
                if (searchView$SearchAutoComplete.f) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.f = false;
                    return;
                }
                return;
            case 18:
                d();
                return;
            case 19:
                ((StaggeredGridLayoutManager) this.b).D0();
                return;
            case 20:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.b).c.m;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 21:
                ActionMenuView actionMenuView = ((Toolbar) this.b).a;
                if (actionMenuView == null || (a0 = actionMenuView.z) == null) {
                    return;
                }
                a0.l();
                return;
            default:
                ((C3344tK) this.b).p(0);
                return;
        }
    }
}
