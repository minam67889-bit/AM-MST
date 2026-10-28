package defpackage;

import android.content.Context;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* renamed from: sf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4363sf {
    public static C4363sf c;
    public final XP a;
    public final WP b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4363sf(Context context) {
        XP xp = new XP(context);
        this.a = xp;
        this.b = (WP) xp.edit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C4363sf a(Context context) {
        if (c == null) {
            c = new C4363sf(context);
        }
        return c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String b() {
        return this.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-203708835106465L), Deobfuscator$AMTUNNELLITE$app.getString(-203730309942945L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String c() {
        return this.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-203047410142881L), Deobfuscator$AMTUNNELLITE$app.getString(-202879906418337L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String d() {
        return this.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-207007369989793L), Deobfuscator$AMTUNNELLITE$app.getString(-207475521425057L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String e() {
        return this.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-207153398877857L), Deobfuscator$AMTUNNELLITE$app.getString(-207179168681633L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int f() {
        return this.a.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(boolean z) {
        WP wp = this.b;
        wp.putBoolean(Deobfuscator$AMTUNNELLITE$app.getString(-206869931036321L), z);
        wp.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void h(boolean z) {
        WP wp = this.b;
        wp.putBoolean(Deobfuscator$AMTUNNELLITE$app.getString(-207320902602401L), z);
        wp.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void i(String str) {
        WP wp = this.b;
        wp.putString(Deobfuscator$AMTUNNELLITE$app.getString(-206272930582177L), str);
        wp.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void j(String str) {
        WP wp = this.b;
        wp.putString(Deobfuscator$AMTUNNELLITE$app.getString(-207196348550817L), str);
        wp.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void k(int i) {
        WP wp = this.b;
        wp.putInt(Deobfuscator$AMTUNNELLITE$app.getString(-204920015883937L), i);
        wp.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return super.toString();
    }
}
