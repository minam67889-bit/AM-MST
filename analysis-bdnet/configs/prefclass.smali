.class public final LIf;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static c:LIf;


# instance fields
.field public final a:LRQ;

.field public final b:LQQ;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    new-instance v0, LRQ;

    .line 6
    invoke-direct {v0, p1}, LRQ;-><init>(Landroid/content/Context;)V

    .line 9
    iput-object v0, p0, LIf;->a:LRQ;

    .line 11
    invoke-virtual {v0}, LRQ;->edit()Landroid/content/SharedPreferences$Editor;

    .line 14
    move-result-object p1

    .line 15
    check-cast p1, LQQ;

    .line 17
    iput-object p1, p0, LIf;->b:LQQ;

    .line 19
    return-void
.end method

.method public static d(Landroid/content/Context;)LIf;
    .locals 1

    .line 1
    sget-object v0, LIf;->c:LIf;

    .line 3
    if-nez v0, :cond_0

    .line 5
    new-instance v0, LIf;

    .line 7
    invoke-direct {v0, p0}, LIf;-><init>(Landroid/content/Context;)V

    .line 10
    sput-object v0, LIf;->c:LIf;

    .line 12
    :cond_0
    sget-object p0, LIf;->c:LIf;

    .line 14
    return-object p0
.end method


# virtual methods
.method public final A(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8e96d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final B(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8ea2d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final C(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8ee2d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final D(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x91f2d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final E(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9186d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final F(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9132d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final G(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x913dd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final H(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x91c6d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final I(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x916bd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final J(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9174d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final K(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8f82d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final L(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8f0fd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final M(I)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8f94d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final N(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x90e0d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final O(I)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x90f0d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final P(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8f8bd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final Q(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x91e0d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final R(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x917dd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final S(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9206d82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final a()Ljava/util/Set;
    .locals 3

    .line 1
    const-wide v0, -0x93edd82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    new-instance v1, Ljava/util/HashSet;

    .line 12
    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 15
    iget-object v2, p0, LIf;->a:LRQ;

    .line 17
    invoke-virtual {v2, v0, v1}, LRQ;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final b()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x8ec2d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x8eccd82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final c()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x9226d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final e()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x9264d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x9277d82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final f()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x8f4ad82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x8f5ad82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final g()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x8ef8d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x8f0ed82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final h()I
    .locals 3

    .line 1
    const-wide v0, -0x8fe0d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getInt(Ljava/lang/String;I)I

    .line 16
    move-result v0

    .line 17
    return v0
.end method

.method public final i()Ljava/lang/Integer;
    .locals 3

    .line 1
    const-wide v0, -0x9289d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getInt(Ljava/lang/String;I)I

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final j()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x9074d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x907fd82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final k()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x9361d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x9373d82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final l()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x8ffad82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x9003d82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final m()Ljava/lang/String;
    .locals 3

    .line 1
    const-wide v0, -0x90dbd82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const-wide v1, -0x90dfd82d778bL

    .line 15
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, LIf;->a:LRQ;

    .line 21
    invoke-virtual {v2, v0, v1}, LRQ;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 24
    move-result-object v0

    .line 25
    return-object v0
.end method

.method public final n()I
    .locals 3

    .line 1
    const-wide v0, -0x90e4d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getInt(Ljava/lang/String;I)I

    .line 16
    move-result v0

    .line 17
    return v0
.end method

.method public final o()Z
    .locals 3

    .line 1
    const-wide v0, -0x8e8cd82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    return v0
.end method

.method public final p()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x91fcd82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final q()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x91d3d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final r()Z
    .locals 3

    .line 1
    const-wide v0, -0x8e82d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    return v0
.end method

.method public final s()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x92c2d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final t()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x91e9d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final u()Ljava/lang/Boolean;
    .locals 3

    .line 1
    const-wide v0, -0x9210d82d778bL

    .line 6
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    iget-object v2, p0, LIf;->a:LRQ;

    .line 13
    invoke-virtual {v2, v0, v1}, LRQ;->getBoolean(Ljava/lang/String;Z)Z

    .line 16
    move-result v0

    .line 17
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 20
    move-result-object v0

    .line 21
    return-object v0
.end method

.method public final v(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8ed8d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final w(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x918fd82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final x(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9125d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public final y(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x8eacd82d778bL

    .line 8
    invoke-static {v1, v2}, Lorg/lsposed/lsparanoid/Deobfuscator$BDNETVPN$app;->getString(J)Ljava/lang/String;

    .line 11
    move-result-object v1

    .line 12
    invoke-virtual {v0, v1, p1}, LQQ;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 15
    invoke-virtual {v0}, LQQ;->apply()V

    .line 18
    return-void
.end method

.method public final z(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, LIf;->b:LQQ;

    .line 3
    const-wide v1, -0x9430d82d778bL

    .line 8
    invoke-static {v1, v2, v0, p1}, LZT;->q(JLQQ;Ljava/lang/String;)V

    .line 11
    return-void
.end method
