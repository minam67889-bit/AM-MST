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
        return this.a.getString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
    }

    public final String c() {
        return this.a.getString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
    }

    public final String d() {
        return this.a.getString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
    }

    public final String e() {
        return this.a.getString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
    }

    public final int f() {
        return this.a.getInt("#ERR IndexError: list index out of range", 6);
    }

    public final void g(boolean z) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putBoolean("#ERR IndexError: list index out of range", z);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void h(boolean z) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putBoolean("#ERR IndexError: list index out of range", z);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void i(String str) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putString("#ERR IndexError: list index out of range", str);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void j(String str) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putString("#ERR IndexError: list index out of range", str);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final void k(int i) {
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = this.b;
        sharedPreferencesEditorC2544eC.putInt("#ERR IndexError: list index out of range", i);
        sharedPreferencesEditorC2544eC.apply();
    }

    public final String toString() {
        return super.toString();
    }
}
