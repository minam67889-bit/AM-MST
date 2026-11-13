package defpackage;

import android.R;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.z;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.util.Features;
import org.jacoco.core.runtime.AgentOptions;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.PDoQService;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Rw implements InterfaceC2916lF, InterfaceC3110oy, InterfaceC2500dK, InterfaceC0122Hc, InterfaceC0220Nk, InterfaceC3279s8, InterfaceC2795j0, OnCompleteListener, D0, WebMessageListenerBoundaryInterface, OnFailureListener, Continuation {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ Rw(int i) {
        this.a = i;
    }

    public Rw(G2 g2, RecaptchaAction recaptchaAction) {
        this.a = 20;
        this.b = recaptchaAction;
        Objects.requireNonNull(g2);
    }

    public /* synthetic */ Rw(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public Rw(RunnableC3589y0 runnableC3589y0) {
        this.a = 19;
        Objects.requireNonNull(runnableC3589y0);
        this.b = runnableC3589y0;
    }

    public static void k(C3574xm c3574xm) {
        c3574xm.i("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c3574xm.i("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c3574xm.i("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        c3574xm.i("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        c3574xm.i("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    public static C3490w7 l(C3574xm c3574xm) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("work_spec_id", new C3076oG(1, "work_spec_id", "TEXT", null, true, 1));
        hashMap.put("prerequisite_id", new C3076oG(2, "prerequisite_id", "TEXT", null, true, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        hashSet.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new C3234rG(Arrays.asList("work_spec_id"), "index_Dependency_work_spec_id", false));
        hashSet2.add(new C3234rG(Arrays.asList("prerequisite_id"), "index_Dependency_prerequisite_id", false));
        C3287sG c3287sG = new C3287sG("Dependency", hashMap, hashSet, hashSet2);
        C3287sG a = C3287sG.a(c3574xm, "Dependency");
        if (!c3287sG.equals(a)) {
            return new C3490w7(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + c3287sG + "\n Found:\n" + a);
        }
        HashMap hashMap2 = new HashMap(25);
        hashMap2.put(FacebookMediationAdapter.KEY_ID, new C3076oG(1, FacebookMediationAdapter.KEY_ID, "TEXT", null, true, 1));
        hashMap2.put("state", new C3076oG(0, "state", "INTEGER", null, true, 1));
        hashMap2.put("worker_class_name", new C3076oG(0, "worker_class_name", "TEXT", null, true, 1));
        hashMap2.put("input_merger_class_name", new C3076oG(0, "input_merger_class_name", "TEXT", null, false, 1));
        hashMap2.put("input", new C3076oG(0, "input", "BLOB", null, true, 1));
        hashMap2.put(AgentOptions.OUTPUT, new C3076oG(0, AgentOptions.OUTPUT, "BLOB", null, true, 1));
        hashMap2.put("initial_delay", new C3076oG(0, "initial_delay", "INTEGER", null, true, 1));
        hashMap2.put("interval_duration", new C3076oG(0, "interval_duration", "INTEGER", null, true, 1));
        hashMap2.put("flex_duration", new C3076oG(0, "flex_duration", "INTEGER", null, true, 1));
        hashMap2.put("run_attempt_count", new C3076oG(0, "run_attempt_count", "INTEGER", null, true, 1));
        hashMap2.put("backoff_policy", new C3076oG(0, "backoff_policy", "INTEGER", null, true, 1));
        hashMap2.put("backoff_delay_duration", new C3076oG(0, "backoff_delay_duration", "INTEGER", null, true, 1));
        hashMap2.put("period_start_time", new C3076oG(0, "period_start_time", "INTEGER", null, true, 1));
        hashMap2.put("minimum_retention_duration", new C3076oG(0, "minimum_retention_duration", "INTEGER", null, true, 1));
        hashMap2.put("schedule_requested_at", new C3076oG(0, "schedule_requested_at", "INTEGER", null, true, 1));
        hashMap2.put("run_in_foreground", new C3076oG(0, "run_in_foreground", "INTEGER", null, true, 1));
        hashMap2.put("out_of_quota_policy", new C3076oG(0, "out_of_quota_policy", "INTEGER", null, true, 1));
        hashMap2.put("required_network_type", new C3076oG(0, "required_network_type", "INTEGER", null, false, 1));
        hashMap2.put("requires_charging", new C3076oG(0, "requires_charging", "INTEGER", null, true, 1));
        hashMap2.put("requires_device_idle", new C3076oG(0, "requires_device_idle", "INTEGER", null, true, 1));
        hashMap2.put("requires_battery_not_low", new C3076oG(0, "requires_battery_not_low", "INTEGER", null, true, 1));
        hashMap2.put("requires_storage_not_low", new C3076oG(0, "requires_storage_not_low", "INTEGER", null, true, 1));
        hashMap2.put("trigger_content_update_delay", new C3076oG(0, "trigger_content_update_delay", "INTEGER", null, true, 1));
        hashMap2.put("trigger_max_content_delay", new C3076oG(0, "trigger_max_content_delay", "INTEGER", null, true, 1));
        hashMap2.put("content_uri_triggers", new C3076oG(0, "content_uri_triggers", "BLOB", null, false, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new C3234rG(Arrays.asList("schedule_requested_at"), "index_WorkSpec_schedule_requested_at", false));
        hashSet4.add(new C3234rG(Arrays.asList("period_start_time"), "index_WorkSpec_period_start_time", false));
        C3287sG c3287sG2 = new C3287sG("WorkSpec", hashMap2, hashSet3, hashSet4);
        C3287sG a2 = C3287sG.a(c3574xm, "WorkSpec");
        if (!c3287sG2.equals(a2)) {
            return new C3490w7(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + c3287sG2 + "\n Found:\n" + a2);
        }
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("tag", new C3076oG(1, "tag", "TEXT", null, true, 1));
        hashMap3.put("work_spec_id", new C3076oG(2, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new C3234rG(Arrays.asList("work_spec_id"), "index_WorkTag_work_spec_id", false));
        C3287sG c3287sG3 = new C3287sG("WorkTag", hashMap3, hashSet5, hashSet6);
        C3287sG a3 = C3287sG.a(c3574xm, "WorkTag");
        if (!c3287sG3.equals(a3)) {
            return new C3490w7(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + c3287sG3 + "\n Found:\n" + a3);
        }
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("work_spec_id", new C3076oG(1, "work_spec_id", "TEXT", null, true, 1));
        hashMap4.put("system_id", new C3076oG(0, "system_id", "INTEGER", null, true, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        C3287sG c3287sG4 = new C3287sG("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
        C3287sG a4 = C3287sG.a(c3574xm, "SystemIdInfo");
        if (!c3287sG4.equals(a4)) {
            return new C3490w7(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + c3287sG4 + "\n Found:\n" + a4);
        }
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new C3076oG(1, AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", null, true, 1));
        hashMap5.put("work_spec_id", new C3076oG(2, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new C3234rG(Arrays.asList("work_spec_id"), "index_WorkName_work_spec_id", false));
        C3287sG c3287sG5 = new C3287sG("WorkName", hashMap5, hashSet8, hashSet9);
        C3287sG a5 = C3287sG.a(c3574xm, "WorkName");
        if (!c3287sG5.equals(a5)) {
            return new C3490w7(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + c3287sG5 + "\n Found:\n" + a5);
        }
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("work_spec_id", new C3076oG(1, "work_spec_id", "TEXT", null, true, 1));
        hashMap6.put("progress", new C3076oG(0, "progress", "BLOB", null, true, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new C3129pG("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        C3287sG c3287sG6 = new C3287sG("WorkProgress", hashMap6, hashSet10, new HashSet(0));
        C3287sG a6 = C3287sG.a(c3574xm, "WorkProgress");
        if (!c3287sG6.equals(a6)) {
            return new C3490w7(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + c3287sG6 + "\n Found:\n" + a6);
        }
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("key", new C3076oG(1, "key", "TEXT", null, true, 1));
        hashMap7.put("long_value", new C3076oG(0, "long_value", "INTEGER", null, false, 1));
        C3287sG c3287sG7 = new C3287sG("Preference", hashMap7, new HashSet(0), new HashSet(0));
        C3287sG a7 = C3287sG.a(c3574xm, "Preference");
        if (c3287sG7.equals(a7)) {
            return new C3490w7(true, (String) null);
        }
        return new C3490w7(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + c3287sG7 + "\n Found:\n" + a7);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // defpackage.InterfaceC0220Nk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(defpackage.InterfaceC0250Pk r7, defpackage.InterfaceC2560ec r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.C2847k
            if (r0 == 0) goto L13
            r0 = r8
            k r0 = (defpackage.C2847k) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            k r0 = new k
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.b
            Cc r1 = defpackage.EnumC0044Cc.a
            int r2 = r0.d
            dJ r3 = defpackage.C2499dJ.a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            mB r7 = r0.a
            defpackage.AbstractC3365tp.j0(r8)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L2b:
            r8 = move-exception
            goto L5f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            defpackage.AbstractC3365tp.j0(r8)
            mB r8 = new mB
            tc r2 = r0.getContext()
            r8.<init>(r7, r2)
            r0.a = r8     // Catch: java.lang.Throwable -> L5d
            r0.d = r4     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r6.b     // Catch: java.lang.Throwable -> L5d
            Tm r7 = (defpackage.InterfaceC0312Tm) r7     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 != r1) goto L50
            goto L51
        L50:
            r7 = r3
        L51:
            if (r7 != r1) goto L54
            return r1
        L54:
            r7 = r8
        L55:
            r7.releaseIntercepted()
            return r3
        L59:
            r5 = r8
            r8 = r7
            r7 = r5
            goto L5f
        L5d:
            r7 = move-exception
            goto L59
        L5f:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Rw.a(Pk, ec):java.lang.Object");
    }

    @Override // defpackage.InterfaceC2795j0
    public boolean b(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.b;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.e;
        int width = (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = AbstractC3238rK.a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        C3628yn c3628yn = swipeDismissBehavior.b;
        if (c3628yn != null) {
            c3628yn.K(view);
        }
        return true;
    }

    @Override // defpackage.InterfaceC2500dK
    public int c(View view) {
        Cz cz = (Cz) view.getLayoutParams();
        ((Bz) this.b).getClass();
        return (view.getTop() - ((Cz) view.getLayoutParams()).b.top) - ((ViewGroup.MarginLayoutParams) cz).topMargin;
    }

    @Override // defpackage.InterfaceC3279s8
    public void d() {
        ((z) this.b).a();
    }

    @Override // defpackage.InterfaceC0122Hc
    public Object e(C0107Gc c0107Gc) {
        return ((InterfaceC0102Fm) this.b).invoke(c0107Gc);
    }

    @Override // defpackage.InterfaceC2500dK
    public int f() {
        return ((Bz) this.b).G();
    }

    @Override // defpackage.InterfaceC3110oy
    public void g() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{Features.WEB_MESSAGE_LISTENER, Features.WEB_MESSAGE_ARRAY_BUFFER};
    }

    @Override // defpackage.InterfaceC3110oy
    public void h(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.b).setResultCode(i);
    }

    @Override // defpackage.InterfaceC2500dK
    public int j() {
        Bz bz = (Bz) this.b;
        return bz.o - bz.D();
    }

    public C2598fD m(JSONObject jSONObject) {
        InterfaceC2967mD c0033Bh;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            c0033Bh = new C2727hk(12);
        } else {
            c0033Bh = new C0033Bh(25);
        }
        return c0033Bh.j((C2727hk) this.b, jSONObject);
    }

    public void n() {
        View view;
        View view2 = (View) this.b;
        if (view2 == null) {
            return;
        }
        if (view2.isInEditMode() || view2.onCheckIsTextEditor()) {
            view2.requestFocus();
            view = view2;
        } else {
            view = view2.getRootView().findFocus();
        }
        if (view == null) {
            view = view2.getRootView().findViewById(R.id.content);
        }
        if (view == null || !view.hasWindowFocus()) {
            return;
        }
        view.post(new H0(view, 15));
    }

    @Override // defpackage.InterfaceC2500dK
    public View o(int i) {
        return ((Bz) this.b).u(i);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        Object z;
        Exception exception = task.getException();
        InterfaceC3121p8 interfaceC3121p8 = (InterfaceC3121p8) this.b;
        if (exception != null) {
            z = AbstractC3365tp.z(exception);
        } else {
            if (task.isCanceled()) {
                interfaceC3121p8.cancel(null);
                return;
            }
            z = task.getResult();
        }
        interfaceC3121p8.resumeWith(z);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        if (exc instanceof C3413uk) {
            Logger logger = C0430aO.e;
            logger.v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            C0430aO c0430aO = (C0430aO) ((RunnableC3589y0) this.b).c;
            int i = (int) c0430aO.b;
            c0430aO.b = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * c0430aO.b : i != 960 ? 30L : 960L;
            c0430aO.a = (c0430aO.b * 1000) + DefaultClock.getInstance().currentTimeMillis();
            logger.v("Scheduling refresh for " + c0430aO.a, new Object[0]);
            c0430aO.c.postDelayed(c0430aO.d, c0430aO.b * 1000);
        }
    }

    @Override // defpackage.InterfaceC2916lF
    public void onLine(String str) {
        int i = 4;
        switch (this.a) {
            case 0:
                boolean contains = str.contains("#ERR IndexError: list index out of range");
                PDoQService pDoQService = (PDoQService) this.b;
                if (contains) {
                    try {
                        boolean z = PDoQService.w;
                        pDoQService.g();
                    } catch (Exception unused) {
                        pDoQService.h();
                        AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    }
                }
                if (str.contains("#ERR IndexError: list index out of range")) {
                    AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    Vw vw = PDoQService.z;
                    if (vw != null) {
                        ((UDPClient) vw).E();
                    } else {
                        AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    }
                    TunnelManagerHelper.stopPDoQ(pDoQService.getApplicationContext());
                }
                if (str.contains("#ERR IndexError: list index out of range")) {
                    ((UDPClient) PDoQService.z).i("#ERR IndexError: list index out of range");
                    Vw vw2 = PDoQService.z;
                    if (vw2 != null) {
                        ((UDPClient) vw2).E();
                    } else {
                        AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    }
                    AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    TunnelManagerHelper.stopPDoQ(pDoQService.getApplicationContext());
                    return;
                }
                return;
            default:
                boolean contains2 = str.contains("#ERR IndexError: list index out of range");
                SuperService superService = (SuperService) this.b;
                if (contains2) {
                    AbstractC2879kf.U(superService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    HF hf = SuperService.C;
                    if (hf != null) {
                        ((UDPClient) hf).E();
                    } else {
                        AbstractC2879kf.U(superService.getApplicationContext(), "#ERR IndexError: list index out of range");
                    }
                    TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                }
                if (str.contains("#ERR IndexError: list index out of range") && !superService.r) {
                    try {
                        superService.e = new File(superService.getApplicationInfo().nativeLibraryDir, "#ERR IndexError: list index out of range");
                        String format = String.format(Locale.ENGLISH, "#ERR IndexError: list index out of range", Integer.valueOf(SuperService.z), Integer.valueOf(SuperService.A), "#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
                        File file = new File(superService.getFilesDir().getPath(), "#ERR IndexError: list index out of range");
                        superService.u = file;
                        try {
                            PrintWriter printWriter = new PrintWriter(file);
                            printWriter.println(format);
                            printWriter.flush();
                            printWriter.close();
                            superService.d = new ProcessBuilder(new String[0]).command(new File(superService.e.getCanonicalPath()).getAbsolutePath(), "#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range", superService.u.getAbsolutePath()).redirectErrorStream(true).start();
                            SkStatus.updateStateString("#ERR IndexError: list index out of range", superService.getString(2131952179));
                            SkStatus.logInfo(2131952179, new Object[0]);
                            ((UDPClient) SuperService.C).i("#ERR IndexError: list index out of range");
                            C2701hA c2701hA = new C2701hA(superService, i);
                            C3303sg c3303sg = new C3303sg(superService.d.getInputStream(), c2701hA);
                            C3303sg c3303sg2 = new C3303sg(superService.d.getErrorStream(), c2701hA);
                            c3303sg.start();
                            c3303sg2.start();
                        } catch (Exception unused2) {
                        }
                    } catch (Exception e) {
                        SkStatus.logInfo(String.format("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range", e.getMessage()));
                    }
                    superService.r = true;
                }
                if (str.contains("#ERR IndexError: list index out of range") && superService.s && !superService.t) {
                    SkStatus.updateStateString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
                    ((UDPClient) SuperService.C).i("#ERR IndexError: list index out of range");
                    superService.t = true;
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPostMessage(android.webkit.WebView r8, java.lang.reflect.InvocationHandler r9, android.net.Uri r10, boolean r11, java.lang.reflect.InvocationHandler r12) {
        /*
            r7 = this;
            java.lang.Class<org.chromium.support_lib_boundary.WebMessageBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessageBoundaryInterface.class
            java.lang.Object r9 = org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil.castToSuppLibClass(r0, r9)
            org.chromium.support_lib_boundary.WebMessageBoundaryInterface r9 = (org.chromium.support_lib_boundary.WebMessageBoundaryInterface) r9
            java.lang.reflect.InvocationHandler[] r0 = r9.getPorts()
            int r1 = r0.length
            hA[] r1 = new defpackage.C2701hA[r1]
            r2 = 0
        L10:
            int r3 = r0.length
            if (r2 >= r3) goto L2b
            hA r3 = new hA
            r4 = r0[r2]
            r5 = 9
            r3.<init>(r5)
            java.lang.Class<org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface> r5 = org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface.class
            java.lang.Object r4 = org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil.castToSuppLibClass(r5, r4)
            org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface r4 = (org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface) r4
            r3.b = r4
            r1[r2] = r3
            int r2 = r2 + 1
            goto L10
        L2b:
            V1 r0 = defpackage.AbstractC3557xL.a
            boolean r0 = r0.b()
            if (r0 == 0) goto L60
            java.lang.Class<org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface.class
            java.lang.reflect.InvocationHandler r9 = r9.getMessagePayload()
            java.lang.Object r9 = org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil.castToSuppLibClass(r0, r9)
            org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface r9 = (org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface) r9
            int r0 = r9.getType()
            if (r0 == 0) goto L56
            r1 = 1
            if (r0 == r1) goto L4b
            r9 = 0
            r3 = r9
            goto L6a
        L4b:
            qL r0 = new qL
            byte[] r9 = r9.getAsArrayBuffer()
            r0.<init>(r9)
        L54:
            r3 = r0
            goto L6a
        L56:
            qL r0 = new qL
            java.lang.String r9 = r9.getAsString()
            r0.<init>(r9)
            goto L54
        L60:
            qL r0 = new qL
            java.lang.String r9 = r9.getData()
            r0.<init>(r9)
            goto L54
        L6a:
            if (r3 == 0) goto L8c
            java.lang.Class<org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface> r9 = org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface.class
            java.lang.Object r9 = org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil.castToSuppLibClass(r9, r12)
            org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface r9 = (org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface) r9
            Pc r12 = new Pc
            r0 = 2
            r12.<init>(r9, r0)
            java.lang.Object r9 = r9.getOrCreatePeer(r12)
            r6 = r9
            Sp r6 = (defpackage.Sp) r6
            java.lang.Object r9 = r7.b
            r1 = r9
            tL r1 = (defpackage.InterfaceC3345tL) r1
            r2 = r8
            r4 = r10
            r5 = r11
            r1.onPostMessage(r2, r3, r4, r5, r6)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Rw.onPostMessage(android.webkit.WebView, java.lang.reflect.InvocationHandler, android.net.Uri, boolean, java.lang.reflect.InvocationHandler):void");
    }

    @Override // defpackage.InterfaceC2500dK
    public int r(View view) {
        Cz cz = (Cz) view.getLayoutParams();
        ((Bz) this.b).getClass();
        return view.getBottom() + ((Cz) view.getLayoutParams()).b.bottom + ((ViewGroup.MarginLayoutParams) cz).bottomMargin;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* synthetic */ Object then(Task task) {
        if (task.isSuccessful()) {
            return ((RecaptchaTasksClient) task.getResult()).executeTask((RecaptchaAction) this.b);
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (!(exc instanceof C2925lO)) {
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - " + exc.getMessage());
        }
        return Tasks.forResult("");
    }
}
