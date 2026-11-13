package prince.dastan.vpn.activities;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import bin.mt.signature.KillerApplication;
import defpackage.C0223If;
import defpackage.C2963eX;
import defpackage.C4062sL;
import defpackage.C4305vR;
import defpackage.EB;
import defpackage.InterfaceC4014rk;
import defpackage.RQ;
import defpackage.RunnableC3954r1;
import defpackage.S50;

/* loaded from: classes2.dex */
public class VPNApplication extends KillerApplication implements Application.ActivityLifecycleCallbacks, InterfaceC4014rk {
    public static final /* synthetic */ int e = 0;
    public C2963eX a;
    public Activity b;
    public RQ c;
    public C0223If d;

    @Override // defpackage.InterfaceC4014rk
    public final void b(EB eb) {
        this.a.b(this.b, new C4305vR(6));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.a.b) {
            return;
        }
        this.b = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        getApplicationContext();
        this.c = new RQ(this);
        this.d = C0223If.d(this);
        new Thread(new RunnableC3954r1(this, 18)).start();
        C4062sL.i.f.a(this);
        C2963eX c2963eX = new C2963eX();
        c2963eX.d = this;
        c2963eX.c = null;
        c2963eX.a = false;
        c2963eX.b = false;
        this.a = c2963eX;
        S50.c(getApplicationContext());
    }
}
