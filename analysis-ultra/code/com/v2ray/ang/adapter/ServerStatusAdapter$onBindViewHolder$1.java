package com.v2ray.ang.adapter;

import com.v2ray.ang.Hometab;
import com.v2ray.ang.adapter.ServerStatusAdapter;
import com.v2ray.ang.viewmodel.ServerList;
import defpackage.bn0;
import defpackage.lv;
import defpackage.mk1;
import defpackage.oy;
import defpackage.u7;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.c;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lmk1;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@DebugMetadata(c = "com.v2ray.ang.adapter.ServerStatusAdapter$onBindViewHolder$1", f = "ServerStatusAdapter.kt", i = {0}, l = {79}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* loaded from: classes3.dex */
final class ServerStatusAdapter$onBindViewHolder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mk1>, Object> {
    final /* synthetic */ ServerStatusAdapter.ViewHolder $holder;
    final /* synthetic */ ServerList $server;
    Object L$0;
    int label;
    final /* synthetic */ ServerStatusAdapter this$0;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lmk1;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
    @DebugMetadata(c = "com.v2ray.ang.adapter.ServerStatusAdapter$onBindViewHolder$1$1", f = "ServerStatusAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.v2ray.ang.adapter.ServerStatusAdapter$onBindViewHolder$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mk1>, Object> {
        final /* synthetic */ ServerStatusAdapter.ViewHolder $holder;
        final /* synthetic */ Pair<Boolean, Long> $result;
        int label;
        final /* synthetic */ ServerStatusAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServerStatusAdapter serverStatusAdapter, ServerStatusAdapter.ViewHolder viewHolder, Pair<Boolean, Long> pair, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = serverStatusAdapter;
            this.$holder = viewHolder;
            this.$result = pair;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<mk1> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$holder, this.$result, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super mk1> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(mk1.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                d.b(obj);
                ServerStatusAdapter serverStatusAdapter = this.this$0;
                ServerStatusAdapter.ViewHolder viewHolder = this.$holder;
                Pair<Boolean, Long> pair = this.$result;
                serverStatusAdapter.getClass();
                ServerStatusAdapter.v(viewHolder, pair);
                return mk1.a;
            }
            u7.p("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerStatusAdapter$onBindViewHolder$1(ServerStatusAdapter serverStatusAdapter, ServerList serverList, ServerStatusAdapter.ViewHolder viewHolder, Continuation<? super ServerStatusAdapter$onBindViewHolder$1> continuation) {
        super(2, continuation);
        this.this$0 = serverStatusAdapter;
        this.$server = serverList;
        this.$holder = viewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<mk1> create(Object obj, Continuation<?> continuation) {
        return new ServerStatusAdapter$onBindViewHolder$1(this.this$0, this.$server, this.$holder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super mk1> continuation) {
        return ((ServerStatusAdapter$onBindViewHolder$1) create(coroutineScope, continuation)).invokeSuspend(mk1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Pair pair;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                d.b(obj);
            } else {
                u7.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        } else {
            d.b(obj);
            ServerStatusAdapter serverStatusAdapter = this.this$0;
            Hometab.Companion companion = Hometab.n;
            String serverIPHost = this.$server.getServerIPHost();
            companion.getClass();
            String a = Hometab.Companion.a(serverIPHost);
            serverStatusAdapter.getClass();
            try {
                Socket socket = new Socket();
                long currentTimeMillis = System.currentTimeMillis();
                socket.connect(new InetSocketAddress(a, 443), 1000);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                socket.close();
                pair = new Pair(Boolean.TRUE, Long.valueOf(currentTimeMillis2));
            } catch (Exception unused) {
                pair = new Pair(Boolean.FALSE, null);
            }
            this.this$0.g.put(this.$server.getServerIPHost(), pair);
            lv lvVar = oy.a;
            MainCoroutineDispatcher mainCoroutineDispatcher = bn0.a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$holder, pair, null);
            this.L$0 = null;
            this.label = 1;
            if (c.e(mainCoroutineDispatcher, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return mk1.a;
    }
}
