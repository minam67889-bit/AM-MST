package defpackage;

import android.os.Build;
import android.util.Log;
import android.view.View;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNApplication;

/* loaded from: classes.dex */
public final class QO implements IQ, InterfaceC0414Pp, InterfaceC3438kU, V0, InterfaceC3718o1, P1, Continuation {
    public Object a;

    public /* synthetic */ QO(Object obj) {
        this.a = obj;
    }

    public static void b(C0263Jt c0263Jt) {
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c0263Jt.k("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        c0263Jt.k("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        c0263Jt.k("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    public static C0270Ka c(C0263Jt c0263Jt) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("work_spec_id", new C3360jW("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap.put("prerequisite_id", new C3360jW("prerequisite_id", "TEXT", true, 2, null, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        hashSet.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new C3600mW("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
        hashSet2.add(new C3600mW("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
        C3679nW c3679nW = new C3679nW("Dependency", hashMap, hashSet, hashSet2);
        C3679nW a = C3679nW.a(c0263Jt, "Dependency");
        if (!c3679nW.equals(a)) {
            return new C0270Ka(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + c3679nW + "\n Found:\n" + a);
        }
        HashMap hashMap2 = new HashMap(25);
        hashMap2.put(FacebookMediationAdapter.KEY_ID, new C3360jW(FacebookMediationAdapter.KEY_ID, "TEXT", true, 1, null, 1));
        hashMap2.put("state", new C3360jW("state", "INTEGER", true, 0, null, 1));
        hashMap2.put("worker_class_name", new C3360jW("worker_class_name", "TEXT", true, 0, null, 1));
        hashMap2.put("input_merger_class_name", new C3360jW("input_merger_class_name", "TEXT", false, 0, null, 1));
        hashMap2.put("input", new C3360jW("input", "BLOB", true, 0, null, 1));
        hashMap2.put("output", new C3360jW("output", "BLOB", true, 0, null, 1));
        hashMap2.put("initial_delay", new C3360jW("initial_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("interval_duration", new C3360jW("interval_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("flex_duration", new C3360jW("flex_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("run_attempt_count", new C3360jW("run_attempt_count", "INTEGER", true, 0, null, 1));
        hashMap2.put("backoff_policy", new C3360jW("backoff_policy", "INTEGER", true, 0, null, 1));
        hashMap2.put("backoff_delay_duration", new C3360jW("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("period_start_time", new C3360jW("period_start_time", "INTEGER", true, 0, null, 1));
        hashMap2.put("minimum_retention_duration", new C3360jW("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        hashMap2.put("schedule_requested_at", new C3360jW("schedule_requested_at", "INTEGER", true, 0, null, 1));
        hashMap2.put("run_in_foreground", new C3360jW("run_in_foreground", "INTEGER", true, 0, null, 1));
        hashMap2.put("out_of_quota_policy", new C3360jW("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        hashMap2.put("required_network_type", new C3360jW("required_network_type", "INTEGER", false, 0, null, 1));
        hashMap2.put("requires_charging", new C3360jW("requires_charging", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_device_idle", new C3360jW("requires_device_idle", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_battery_not_low", new C3360jW("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        hashMap2.put("requires_storage_not_low", new C3360jW("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        hashMap2.put("trigger_content_update_delay", new C3360jW("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("trigger_max_content_delay", new C3360jW("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        hashMap2.put("content_uri_triggers", new C3360jW("content_uri_triggers", "BLOB", false, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new C3600mW("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
        hashSet4.add(new C3600mW("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
        C3679nW c3679nW2 = new C3679nW("WorkSpec", hashMap2, hashSet3, hashSet4);
        C3679nW a2 = C3679nW.a(c0263Jt, "WorkSpec");
        if (!c3679nW2.equals(a2)) {
            return new C0270Ka(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + c3679nW2 + "\n Found:\n" + a2);
        }
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put("tag", new C3360jW("tag", "TEXT", true, 1, null, 1));
        hashMap3.put("work_spec_id", new C3360jW("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new C3600mW("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
        C3679nW c3679nW3 = new C3679nW("WorkTag", hashMap3, hashSet5, hashSet6);
        C3679nW a3 = C3679nW.a(c0263Jt, "WorkTag");
        if (!c3679nW3.equals(a3)) {
            return new C0270Ka(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + c3679nW3 + "\n Found:\n" + a3);
        }
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("work_spec_id", new C3360jW("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap4.put("system_id", new C3360jW("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        C3679nW c3679nW4 = new C3679nW("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
        C3679nW a4 = C3679nW.a(c0263Jt, "SystemIdInfo");
        if (!c3679nW4.equals(a4)) {
            return new C0270Ka(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + c3679nW4 + "\n Found:\n" + a4);
        }
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new C3360jW(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", true, 1, null, 1));
        hashMap5.put("work_spec_id", new C3360jW("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new C3600mW("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
        C3679nW c3679nW5 = new C3679nW("WorkName", hashMap5, hashSet8, hashSet9);
        C3679nW a5 = C3679nW.a(c0263Jt, "WorkName");
        if (!c3679nW5.equals(a5)) {
            return new C0270Ka(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + c3679nW5 + "\n Found:\n" + a5);
        }
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("work_spec_id", new C3360jW("work_spec_id", "TEXT", true, 1, null, 1));
        hashMap6.put("progress", new C3360jW("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new C3440kW("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(FacebookMediationAdapter.KEY_ID)));
        C3679nW c3679nW6 = new C3679nW("WorkProgress", hashMap6, hashSet10, new HashSet(0));
        C3679nW a6 = C3679nW.a(c0263Jt, "WorkProgress");
        if (!c3679nW6.equals(a6)) {
            return new C0270Ka(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + c3679nW6 + "\n Found:\n" + a6);
        }
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put("key", new C3360jW("key", "TEXT", true, 1, null, 1));
        hashMap7.put("long_value", new C3360jW("long_value", "INTEGER", false, 0, null, 1));
        C3679nW c3679nW7 = new C3679nW("Preference", hashMap7, new HashSet(0), new HashSet(0));
        C3679nW a7 = C3679nW.a(c0263Jt, "Preference");
        if (c3679nW7.equals(a7)) {
            return new C0270Ka(true, (String) null);
        }
        return new C0270Ka(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + c3679nW7 + "\n Found:\n" + a7);
    }

    @Override // defpackage.InterfaceC3438kU
    public Iterator a(C3518lU c3518lU, CharSequence charSequence) {
        return new C3358jU(this, c3518lU, charSequence, 0);
    }

    @Override // defpackage.V0
    public boolean d(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.a;
        if (!swipeDismissBehavior.s(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.e;
        int width = (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        C2835cv c2835cv = swipeDismissBehavior.b;
        if (c2835cv != null) {
            c2835cv.H(view);
        }
        return true;
    }

    @Override // defpackage.YL
    public Object get() {
        return new NR((XR) ((XL) this.a).get());
    }

    @Override // defpackage.P1
    public void onAdFailedToLoad(SC sc) {
        ((C2963eX) this.a).a = false;
    }

    @Override // defpackage.P1
    public void onAdLoaded(Object obj) {
        C2963eX c2963eX = (C2963eX) this.a;
        c2963eX.c = (InterfaceC3570m6) obj;
        c2963eX.a = false;
        new Date().getTime();
        QQ qq = (QQ) ((VPNApplication) c2963eX.d).c.edit();
        qq.putLong(Deobfuscator$BDNETVPN$app.getString(-17028877219723L), System.currentTimeMillis());
        qq.apply();
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean isSuccessful = task.isSuccessful();
        AbstractC3085g20 abstractC3085g20 = (AbstractC3085g20) this.a;
        if (isSuccessful) {
            return abstractC3085g20.x((String) task.getResult());
        }
        Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) Preconditions.checkNotNull(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
        return abstractC3085g20.x("NO_RECAPTCHA");
    }

    public QO(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            this.a = new WT(view);
            return;
        }
        YT yt = new YT(view);
        yt.b = view;
        this.a = yt;
    }
}
