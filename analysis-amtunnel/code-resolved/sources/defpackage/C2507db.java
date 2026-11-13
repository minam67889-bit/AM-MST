package defpackage;

import android.content.Context;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* renamed from: db, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2507db {
    public static C2507db c;
    public final SharedPreferencesC2597fC a;
    public final SharedPreferencesEditorC2544eC b;

    public C2507db(Context context) {
        SharedPreferencesC2597fC sharedPreferencesC2597fC = new SharedPreferencesC2597fC(context);
        this.a = sharedPreferencesC2597fC;
        this.b = (SharedPreferencesEditorC2544eC) sharedPreferencesC2597fC.edit();
    }

    public static C2507db a(Context context) {
        if (c == null) {
            c = new C2507db(context);
        }
        return c;
    }

    public final String b() {
        return this.a.getString("SSH_HOST", "");
    }

    public final String c() {
        return this.a.getString("SERVER_SELECTED_NAME", "");
    }

    public final String d() {
        return this.a.getString("SUPER_CUSTOM_DNS", "udp://8.8.8.8");
    }

    public final String e() {
        return this.a.getString("SUPER_DNS", "Direct");
    }

    public final int f() {
        return this.a.getInt("TUNNEL_TYPE", 6);
    }

    public final void g(boolean z) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putBoolean("isCustomPDOQSet", z);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void h(boolean z) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putBoolean("isCustomSuperSet", z);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void i(String str) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putString("PDOQ_DNS", str);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void j(String str) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putString("SUPER_DNS", str);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void k(int i) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putInt("TUNNEL_TYPE", i);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final String toString() {
        return super.toString();
    }
}
