package com.v2ray.ang.ui;

import co.strongteam.ultra.R;
import defpackage.mk1;
import defpackage.qf3;
import defpackage.u7;
import defpackage.zq0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import libv2ray.CoreController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lmk1;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@DebugMetadata(c = "com.v2ray.ang.ui.HomeFragment$importBatchConfig$1", f = "HomeFragment.kt", i = {0, 0, 1, 1, 2}, l = {2351, 2352, 2370}, m = "invokeSuspend", n = {"count", "countSub", "count", "countSub", "e"}, s = {"I$0", "I$1", "I$0", "I$1", "L$0"})
/* loaded from: classes3.dex */
public final class HomeFragment$importBatchConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mk1>, Object> {
    final /* synthetic */ String $server;
    final /* synthetic */ boolean $startv2ray;
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lmk1;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
    @DebugMetadata(c = "com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$1", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mk1>, Object> {
        final /* synthetic */ int $count;
        final /* synthetic */ boolean $startv2ray;
        int label;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, HomeFragment homeFragment, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$count = i;
            this.this$0 = homeFragment;
            this.$startv2ray = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<mk1> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$count, this.this$0, this.$startv2ray, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super mk1> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(mk1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                kotlin.d.b(obj);
                int i = this.$count;
                HomeFragment homeFragment = this.this$0;
                if (i > 0) {
                    homeFragment.f0().reloadServerList();
                    if (this.$startv2ray) {
                        HomeFragment homeFragment2 = this.this$0;
                        if (homeFragment2.T0) {
                            Lazy lazy = zq0.a;
                            String x = zq0.x();
                            if (x != null && x.length() != 0) {
                                CoreController coreController = com.v2ray.ang.service.b.a;
                                com.v2ray.ang.service.b.b(homeFragment2.M());
                            } else {
                                qf3.K(homeFragment2.M(), R.string.title_file_chooser);
                            }
                        }
                    }
                } else {
                    qf3.N(homeFragment.M(), "Invalid V2ray Config");
                    Lazy lazy2 = zq0.a;
                    zq0.u().o("QR_Config");
                    this.this$0.J0();
                }
                return mk1.a;
            }
            u7.p("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lmk1;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
    @DebugMetadata(c = "com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$2", f = "HomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mk1>, Object> {
        int label;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HomeFragment homeFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = homeFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<mk1> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super mk1> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(mk1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                kotlin.d.b(obj);
                qf3.M(this.this$0.L(), R.string.toast_failure);
                return mk1.a;
            }
            u7.p("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$importBatchConfig$1(String str, HomeFragment homeFragment, boolean z, Continuation<? super HomeFragment$importBatchConfig$1> continuation) {
        super(2, continuation);
        this.$server = str;
        this.this$0 = homeFragment;
        this.$startv2ray = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<mk1> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$importBatchConfig$1(this.$server, this.this$0, this.$startv2ray, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super mk1> continuation) {
        return ((HomeFragment$importBatchConfig$1) create(coroutineScope, continuation)).invokeSuspend(mk1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0086, code lost:
    
        if (kotlinx.coroutines.c.e(r10, r6, r9) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
    
        if (kotlinx.coroutines.c.e(r1, r4, r9) != r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L26
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L19
            java.lang.Object r0 = r9.L$0
            java.lang.Exception r0 = (java.lang.Exception) r0
            kotlin.d.b(r10)
            goto L9f
        L19:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.u7.p(r9)
            return r2
        L1f:
            kotlin.d.b(r10)     // Catch: java.lang.Exception -> L24
            goto La6
        L24:
            r10 = move-exception
            goto L89
        L26:
            int r1 = r9.I$1
            int r5 = r9.I$0
            kotlin.d.b(r10)     // Catch: java.lang.Exception -> L24
            goto L6f
        L2e:
            kotlin.d.b(r10)
            com.v2ray.ang.Hometab$Companion r10 = com.v2ray.ang.Hometab.n     // Catch: java.lang.Exception -> L24
            java.lang.String r1 = r9.$server     // Catch: java.lang.Exception -> L24
            r10.getClass()     // Catch: java.lang.Exception -> L24
            java.lang.String r10 = com.v2ray.ang.Hometab.Companion.a(r1)     // Catch: java.lang.Exception -> L24
            com.v2ray.ang.ui.HomeFragment r1 = r9.this$0     // Catch: java.lang.Exception -> L24
            com.v2ray.ang.viewmodel.MainViewModel r1 = r1.f0()     // Catch: java.lang.Exception -> L24
            java.lang.String r1 = r1.getSubscriptionId()     // Catch: java.lang.Exception -> L24
            kotlin.Pair r10 = defpackage.ay2.i(r10, r1, r5)     // Catch: java.lang.Exception -> L24
            java.lang.Object r1 = r10.component1()     // Catch: java.lang.Exception -> L24
            java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Exception -> L24
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L24
            java.lang.Object r10 = r10.component2()     // Catch: java.lang.Exception -> L24
            java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Exception -> L24
            int r10 = r10.intValue()     // Catch: java.lang.Exception -> L24
            r9.I$0 = r1     // Catch: java.lang.Exception -> L24
            r9.I$1 = r10     // Catch: java.lang.Exception -> L24
            r9.label = r5     // Catch: java.lang.Exception -> L24
            r5 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r5 = kotlinx.coroutines.f.b(r5, r9)     // Catch: java.lang.Exception -> L24
            if (r5 != r0) goto L6d
            goto L9e
        L6d:
            r5 = r1
            r1 = r10
        L6f:
            lv r10 = defpackage.oy.a     // Catch: java.lang.Exception -> L24
            kotlinx.coroutines.MainCoroutineDispatcher r10 = defpackage.bn0.a     // Catch: java.lang.Exception -> L24
            com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$1 r6 = new com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$1     // Catch: java.lang.Exception -> L24
            com.v2ray.ang.ui.HomeFragment r7 = r9.this$0     // Catch: java.lang.Exception -> L24
            boolean r8 = r9.$startv2ray     // Catch: java.lang.Exception -> L24
            r6.<init>(r5, r7, r8, r2)     // Catch: java.lang.Exception -> L24
            r9.I$0 = r5     // Catch: java.lang.Exception -> L24
            r9.I$1 = r1     // Catch: java.lang.Exception -> L24
            r9.label = r4     // Catch: java.lang.Exception -> L24
            java.lang.Object r9 = kotlinx.coroutines.c.e(r10, r6, r9)     // Catch: java.lang.Exception -> L24
            if (r9 != r0) goto La6
            goto L9e
        L89:
            lv r1 = defpackage.oy.a
            kotlinx.coroutines.MainCoroutineDispatcher r1 = defpackage.bn0.a
            com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$2 r4 = new com.v2ray.ang.ui.HomeFragment$importBatchConfig$1$2
            com.v2ray.ang.ui.HomeFragment r5 = r9.this$0
            r4.<init>(r5, r2)
            r9.L$0 = r10
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.c.e(r1, r4, r9)
            if (r10 != r0) goto L9f
        L9e:
            return r0
        L9f:
            com.v2ray.ang.ui.HomeFragment r9 = r9.this$0
            int r10 = com.v2ray.ang.ui.HomeFragment.f2
            r9.J0()
        La6:
            mk1 r9 = defpackage.mk1.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment$importBatchConfig$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
