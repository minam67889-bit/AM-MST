package defpackage;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;

/* renamed from: If, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0223If {
    public static C0223If c;
    public final RQ a;
    public final QQ b;

    public C0223If(Context context) {
        RQ rq = new RQ(context);
        this.a = rq;
        this.b = (QQ) rq.edit();
    }

    public static C0223If d(Context context) {
        if (c == null) {
            c = new C0223If(context);
        }
        return c;
    }

    public final void A(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-156778523096971L), z);
        qq.apply();
    }

    public final void B(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-156830062704523L), z);
        qq.apply();
    }

    public final void C(String str) {
        ZT.q(-157104940611467L, this.b, str);
    }

    public final void D(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160472194971531L), z);
        qq.apply();
    }

    public final void E(String str) {
        ZT.q(-160008338503563L, this.b, str);
    }

    public final void F(String str) {
        ZT.q(-159647561250699L, this.b, str);
    }

    public final void G(String str) {
        ZT.q(-159694805890955L, this.b, str);
    }

    public final void H(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160283216410507L), z);
        qq.apply();
    }

    public final void I(String str) {
        ZT.q(-159892374386571L, this.b, str);
    }

    public final void J(String str) {
        ZT.q(-159931029092235L, this.b, str);
    }

    public final void K(String str) {
        ZT.q(-157792135378827L, this.b, str);
    }

    public final void L(String str) {
        ZT.q(-157298214139787L, this.b, str);
    }

    public final void M(int i) {
        QQ qq = this.b;
        qq.putInt(Deobfuscator$BDNETVPN$app.getString(-157869444790155L), i);
        qq.apply();
    }

    public final void N(String str) {
        ZT.q(-159295373932427L, this.b, str);
    }

    public final void O(int i) {
        QQ qq = this.b;
        qq.putInt(Deobfuscator$BDNETVPN$app.getString(-159364093409163L), i);
        qq.apply();
    }

    public final void P(String str) {
        ZT.q(-157830790084491L, this.b, str);
    }

    public final void Q(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160394885560203L), z);
        qq.apply();
    }

    public final void R(String str) {
        ZT.q(-159969683797899L, this.b, str);
    }

    public final void S(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160558094317451L), z);
        qq.apply();
    }

    public final Set a() {
        return this.a.getStringSet(Deobfuscator$BDNETVPN$app.getString(-162649743390603L), new HashSet());
    }

    public final String b() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-156967501657995L), Deobfuscator$BDNETVPN$app.getString(-157010451330955L));
    }

    public final Boolean c() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-160695533270923L), false));
    }

    public final String e() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-160961821243275L), Deobfuscator$BDNETVPN$app.getString(-161043425621899L));
    }

    public final String f() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-157551617210251L), Deobfuscator$BDNETVPN$app.getString(-157620336686987L));
    }

    public final String g() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-157199429891979L), Deobfuscator$BDNETVPN$app.getString(-157293919172491L));
    }

    public final int h() {
        return this.a.getInt(Deobfuscator$BDNETVPN$app.getString(-158195862304651L), 0);
    }

    public final Integer i() {
        return Integer.valueOf(this.a.getInt(Deobfuscator$BDNETVPN$app.getString(-161120735033227L), 0));
    }

    public final String j() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-158831517464459L), Deobfuscator$BDNETVPN$app.getString(-158878762104715L));
    }

    public final String k() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-162048447969163L), Deobfuscator$BDNETVPN$app.getString(-162125757380491L));
    }

    public final String l() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-158307531454347L), Deobfuscator$BDNETVPN$app.getString(-158346186160011L));
    }

    public final String m() {
        return this.a.getString(Deobfuscator$BDNETVPN$app.getString(-159273899095947L), Deobfuscator$BDNETVPN$app.getString(-159291078965131L));
    }

    public final int n() {
        return this.a.getInt(Deobfuscator$BDNETVPN$app.getString(-159312553801611L), 0);
    }

    public final boolean o() {
        return this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-156735573424011L), false);
    }

    public final Boolean p() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-160515144644491L), false));
    }

    public final Boolean q() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-160339050985355L), false));
    }

    public final boolean r() {
        return this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-156692623751051L), false);
    }

    public final Boolean s() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-161365548169099L), false));
    }

    public final Boolean t() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-160433540265867L), false));
    }

    public final Boolean u() {
        return Boolean.valueOf(this.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-160601043990411L), false));
    }

    public final void v(String str) {
        ZT.q(-157061990938507L, this.b, str);
    }

    public final void w(String str) {
        ZT.q(-160046993209227L, this.b, str);
    }

    public final void x(String str) {
        ZT.q(-159591726675851L, this.b, str);
    }

    public final void y(boolean z) {
        QQ qq = this.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-156873012377483L), z);
        qq.apply();
    }

    public final void z(String str) {
        ZT.q(-162937506199435L, this.b, str);
    }
}
