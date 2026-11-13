package com.v2ray.ang.viewmodel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.v2ray.ang.AngApplication;
import com.v2ray.ang.dto.ProfileItem;
import com.v2ray.ang.dto.ServerAffiliationInfo;
import com.v2ray.ang.dto.ServersCache;
import com.v2ray.ang.dto.SubscriptionItem;
import com.v2ray.ang.service.V2RayTestService;
import defpackage.ay2;
import defpackage.hv;
import defpackage.k5;
import defpackage.lv;
import defpackage.m91;
import defpackage.o0;
import defpackage.oy;
import defpackage.rn1;
import defpackage.ul1;
import defpackage.yg0;
import defpackage.zq0;
import defpackage.zr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.c;
import kotlin.comparisons.a;
import kotlin.sequences.b;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1;
import kotlin.text.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001W\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\bJ\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\bJ\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\bJ\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u000eJ1\u0010!\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010 \u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010 0\u001f2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000f¢\u0006\u0004\b%\u0010\u0016J\r\u0010&\u001a\u00020\u000f¢\u0006\u0004\b&\u0010\u0016J\r\u0010'\u001a\u00020\u000f¢\u0006\u0004\b'\u0010\u0016J\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\bJ\u0015\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b.\u0010\u000eJ\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\bJ\r\u00100\u001a\u00020\u0006¢\u0006\u0004\b0\u0010\bR\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u000eR\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00104\u001a\u0004\b9\u00106\"\u0004\b:\u0010\u000eR\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;0 8\u0006¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR!\u0010F\u001a\b\u0012\u0004\u0012\u00020@0?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010B\u001a\u0004\bF\u0010DR!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bH\u0010DR!\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000b0?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010B\u001a\u0004\bK\u0010DR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010B\u001a\u0004\bO\u0010PR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020R0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000b0?8\u0006¢\u0006\f\n\u0004\bU\u0010T\u001a\u0004\bV\u0010DR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020R0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010TR\u001d\u0010\\\u001a\b\u0012\u0004\u0012\u00020R0[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020R0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010TR\u001d\u0010a\u001a\b\u0012\u0004\u0012\u00020R0[8\u0006¢\u0006\f\n\u0004\ba\u0010]\u001a\u0004\bb\u0010_R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020R0[8F¢\u0006\u0006\u001a\u0004\bc\u0010_¨\u0006e"}, d2 = {"Lcom/v2ray/ang/viewmodel/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "Lmk1;", "startListenBroadcast", "()V", "onCleared", "reloadServerList", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "guid", "removeServer", "(Ljava/lang/String;)V", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "fromPosition", "toPosition", "swapServer", "(II)V", "updateCache", "updateConfigViaSubAll", "()I", "exportAllServer", "testAllTcping", "testAllRealPing", "testCurrentServerRealPing", "id", "subscriptionIdChanged", "Landroid/content/Context;", "context", "Lkotlin/Pair;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "getSubscriptions", "(Landroid/content/Context;)Lkotlin/Pair;", "getPosition", "(Ljava/lang/String;)I", "removeDuplicateServer", "removeAllServer", "removeInvalidServer", "sortByTestResults", "Landroid/content/res/AssetManager;", "assets", "initAssets", "(Landroid/content/res/AssetManager;)V", "keyword", "filterConfig", "loadStartTime", "updateBytes", "serverList", "Ljava/util/List;", "subscriptionId", "Ljava/lang/String;", "getSubscriptionId", "()Ljava/lang/String;", "setSubscriptionId", "keywordFilter", "getKeywordFilter", "setKeywordFilter", "Lcom/v2ray/ang/dto/ServersCache;", "serversCache", "getServersCache", "()Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "isRunning$delegate", "Lkotlin/Lazy;", "isRunning", "()Landroidx/lifecycle/MutableLiveData;", "isSuccess$delegate", "isSuccess", "updateListAction$delegate", "getUpdateListAction", "updateListAction", "updateTestResultAction$delegate", "getUpdateTestResultAction", "updateTestResultAction", "Lkotlinx/coroutines/CoroutineScope;", "tcpingTestScope$delegate", "getTcpingTestScope", "()Lkotlinx/coroutines/CoroutineScope;", "tcpingTestScope", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "_startTime", "Landroidx/lifecycle/MutableLiveData;", "logAction", "getLogAction", "com/v2ray/ang/viewmodel/MainViewModel$mMsgReceiver$1", "mMsgReceiver", "Lcom/v2ray/ang/viewmodel/MainViewModel$mMsgReceiver$1;", "_downloaded", "Landroidx/lifecycle/LiveData;", "downloaded", "Landroidx/lifecycle/LiveData;", "getDownloaded", "()Landroidx/lifecycle/LiveData;", "_uploaded", "uploaded", "getUploaded", "getStartTime", "startTime", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainViewModel extends AndroidViewModel {
    private final MutableLiveData<Long> _downloaded;
    private final MutableLiveData<Long> _startTime;
    private final MutableLiveData<Long> _uploaded;
    private final LiveData<Long> downloaded;

    /* renamed from: isRunning$delegate, reason: from kotlin metadata */
    private final Lazy isRunning;

    /* renamed from: isSuccess$delegate, reason: from kotlin metadata */
    private final Lazy isSuccess;
    private String keywordFilter;
    private final MutableLiveData<String> logAction;
    private final MainViewModel$mMsgReceiver$1 mMsgReceiver;
    private List<String> serverList;
    private final List<ServersCache> serversCache;
    private String subscriptionId;

    /* renamed from: tcpingTestScope$delegate, reason: from kotlin metadata */
    private final Lazy tcpingTestScope;

    /* renamed from: updateListAction$delegate, reason: from kotlin metadata */
    private final Lazy updateListAction;

    /* renamed from: updateTestResultAction$delegate, reason: from kotlin metadata */
    private final Lazy updateTestResultAction;
    private final LiveData<Long> uploaded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.v2ray.ang.viewmodel.MainViewModel$mMsgReceiver$1] */
    public MainViewModel(Application application) {
        super(application);
        application.getClass();
        Lazy lazy = zq0.a;
        this.serverList = zq0.f();
        String e = zq0.z().e("cache_subscription_id", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        this.subscriptionId = e == null ? RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED : e;
        this.keywordFilter = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        this.serversCache = new ArrayList();
        this.isRunning = c.b(new o0(24));
        this.isSuccess = c.b(new o0(25));
        this.updateListAction = c.b(new o0(26));
        this.updateTestResultAction = c.b(new o0(27));
        this.tcpingTestScope = c.b(new o0(28));
        this._startTime = new MutableLiveData<>();
        this.logAction = new MutableLiveData<>();
        this.mMsgReceiver = new BroadcastReceiver() { // from class: com.v2ray.ang.viewmodel.MainViewModel$mMsgReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context ctx, Intent intent) {
                Integer num;
                Object obj;
                if (intent != null) {
                    intent.getStringExtra("content");
                }
                Object obj2 = null;
                if (intent != null) {
                    num = Integer.valueOf(intent.getIntExtra("key", 0));
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 11) {
                    MainViewModel.this.getLogAction().k("V2ray Running");
                    MainViewModel.this.isRunning().k(Boolean.TRUE);
                    return;
                }
                if (num != null && num.intValue() == 12) {
                    MainViewModel.this.getLogAction().k("V2ray Not Running");
                    MutableLiveData<Boolean> isRunning = MainViewModel.this.isRunning();
                    Boolean bool = Boolean.FALSE;
                    isRunning.k(bool);
                    MainViewModel.this.isSuccess().k(bool);
                    return;
                }
                if (num != null && num.intValue() == 31) {
                    MainViewModel.this.getLogAction().k("V2ray Start Success");
                    MainViewModel.this.isRunning().k(Boolean.TRUE);
                    return;
                }
                if (num != null && num.intValue() == 32) {
                    MainViewModel.this.getLogAction().k("V2ray failed to start");
                    MutableLiveData<Boolean> isRunning2 = MainViewModel.this.isRunning();
                    Boolean bool2 = Boolean.FALSE;
                    isRunning2.k(bool2);
                    MainViewModel.this.isSuccess().k(bool2);
                    return;
                }
                if (num != null && num.intValue() == 41) {
                    MainViewModel.this.getLogAction().k("V2ray Stop Success");
                    MutableLiveData<Boolean> isRunning3 = MainViewModel.this.isRunning();
                    Boolean bool3 = Boolean.FALSE;
                    isRunning3.k(bool3);
                    MainViewModel.this.isSuccess().k(bool3);
                    return;
                }
                if (num != null && num.intValue() == 61) {
                    MainViewModel.this.getLogAction().k("V2ray Checking Server");
                    Object d = MainViewModel.this.isRunning().d();
                    Boolean bool4 = Boolean.TRUE;
                    if (yg0.a(d, bool4)) {
                        MainViewModel.this.getUpdateTestResultAction().k(intent.getStringExtra("content"));
                        String stringExtra = intent.getStringExtra("content");
                        if (stringExtra != null) {
                            MainViewModel mainViewModel = MainViewModel.this;
                            if (g.o(stringExtra, "Success", false)) {
                                mainViewModel.isSuccess().k(bool4);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (num != null && num.intValue() == 71) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        obj = intent.getSerializableExtra("content", Pair.class);
                    } else {
                        Object serializableExtra = intent.getSerializableExtra("content");
                        if (serializableExtra instanceof Pair) {
                            obj2 = serializableExtra;
                        }
                        obj = (Pair) obj2;
                    }
                    Pair pair = (Pair) obj;
                    if (pair != null) {
                        Lazy lazy2 = zq0.a;
                        zq0.o(((Number) pair.getSecond()).longValue(), (String) pair.getFirst());
                        MainViewModel.this.getUpdateListAction().k(Integer.valueOf(MainViewModel.this.getPosition((String) pair.getFirst())));
                    }
                }
            }
        };
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        this._downloaded = mutableLiveData;
        this.downloaded = mutableLiveData;
        MutableLiveData<Long> mutableLiveData2 = new MutableLiveData<>();
        this._uploaded = mutableLiveData2;
        this.uploaded = mutableLiveData2;
    }

    private final CoroutineScope getTcpingTestScope() {
        return (CoroutineScope) this.tcpingTestScope.getValue();
    }

    public static final MutableLiveData isRunning_delegate$lambda$0() {
        return new MutableLiveData();
    }

    public static final MutableLiveData isSuccess_delegate$lambda$1() {
        return new MutableLiveData();
    }

    public static final CoroutineScope tcpingTestScope_delegate$lambda$4() {
        lv lvVar = oy.a;
        return zr.a(hv.c);
    }

    public static final MutableLiveData updateListAction_delegate$lambda$2() {
        return new MutableLiveData();
    }

    public static final MutableLiveData updateTestResultAction_delegate$lambda$3() {
        return new MutableLiveData();
    }

    public final int exportAllServer() {
        List<String> R;
        if (this.subscriptionId.length() == 0 && this.keywordFilter.length() == 0) {
            R = this.serverList;
        } else {
            List<ServersCache> list = this.serversCache;
            ArrayList arrayList = new ArrayList(kotlin.collections.c.l(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ServersCache) it.next()).getGuid());
            }
            R = kotlin.collections.c.R(arrayList);
        }
        Application application = getApplication();
        application.getClass();
        R.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it2 = R.iterator();
            while (it2.hasNext()) {
                String t = ay2.t(it2.next());
                if (!TextUtils.isEmpty(t)) {
                    sb.append(t);
                    sb.append('\n');
                }
            }
            if (sb.length() > 0) {
                Regex regex = ul1.a;
                ul1.A(application, sb.toString());
            }
            return b.f(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(sb)).size();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final void filterConfig(String keyword) {
        keyword.getClass();
        if (keyword.equals(this.keywordFilter)) {
            return;
        }
        this.keywordFilter = keyword;
        Lazy lazy = zq0.a;
        zq0.z().i("cache_keyword_filter", keyword);
        reloadServerList();
    }

    public final LiveData<Long> getDownloaded() {
        return this.downloaded;
    }

    public final String getKeywordFilter() {
        return this.keywordFilter;
    }

    public final MutableLiveData<String> getLogAction() {
        return this.logAction;
    }

    public final int getPosition(String guid) {
        guid.getClass();
        int i = 0;
        for (Object obj : this.serversCache) {
            int i2 = i + 1;
            if (i >= 0) {
                if (yg0.a(((ServersCache) obj).getGuid(), guid)) {
                    return i;
                }
                i = i2;
            } else {
                kotlin.collections.c.O();
                throw null;
            }
        }
        return -1;
    }

    public final List<ServersCache> getServersCache() {
        return this.serversCache;
    }

    public final LiveData<Long> getStartTime() {
        return this._startTime;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final Pair<List<String>, List<String>> getSubscriptions(Context context) {
        context.getClass();
        Lazy lazy = zq0.a;
        ArrayList i = zq0.i();
        if (this.subscriptionId.length() > 0) {
            ArrayList arrayList = new ArrayList(kotlin.collections.c.l(i, 10));
            Iterator it = i.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Pair) it.next()).getFirst());
            }
            if (!arrayList.contains(this.subscriptionId)) {
                subscriptionIdChanged(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            }
        }
        if (i.isEmpty()) {
            return new Pair<>(null, null);
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.c.l(i, 10));
        Iterator it2 = i.iterator();
        while (it2.hasNext()) {
            arrayList2.add((String) ((Pair) it2.next()).getFirst());
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        arrayList3.add(0, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        ArrayList arrayList4 = new ArrayList(kotlin.collections.c.l(i, 10));
        Iterator it3 = i.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((SubscriptionItem) ((Pair) it3.next()).getSecond()).getRemarks());
        }
        ArrayList arrayList5 = new ArrayList(arrayList4);
        String string = context.getString(R.string.filter_config_all);
        string.getClass();
        arrayList5.add(0, string);
        return new Pair<>(arrayList3, arrayList5);
    }

    public final MutableLiveData<Integer> getUpdateListAction() {
        return (MutableLiveData) this.updateListAction.getValue();
    }

    public final MutableLiveData<String> getUpdateTestResultAction() {
        return (MutableLiveData) this.updateTestResultAction.getValue();
    }

    public final LiveData<Long> getUploaded() {
        return this.uploaded;
    }

    public final void initAssets(AssetManager assets) {
        assets.getClass();
        kotlinx.coroutines.c.d(rn1.a(this), oy.a, null, new MainViewModel$initAssets$1(this, assets, null), 2);
    }

    public final MutableLiveData<Boolean> isRunning() {
        return (MutableLiveData) this.isRunning.getValue();
    }

    public final MutableLiveData<Boolean> isSuccess() {
        return (MutableLiveData) this.isSuccess.getValue();
    }

    public final void loadStartTime() {
        MutableLiveData<Long> mutableLiveData = this._startTime;
        Lazy lazy = zq0.a;
        mutableLiveData.k(Long.valueOf(zq0.u().c(0L, "v2rayTime")));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        ((AngApplication) getApplication()).unregisterReceiver(this.mMsgReceiver);
        Job job = (Job) getTcpingTestScope().getA().get(Job.Key);
        if (job != null) {
            kotlinx.coroutines.g.c(job);
        }
        m91.a.a();
    }

    public final void reloadServerList() {
        Lazy lazy = zq0.a;
        this.serverList = zq0.f();
        updateCache();
        getUpdateListAction().k(-1);
    }

    public final int removeAllServer() {
        int i;
        if (this.subscriptionId.length() == 0 && this.keywordFilter.length() == 0) {
            Lazy lazy = zq0.a;
            String[] a = zq0.w().a();
            if (a != null) {
                i = a.length;
            } else {
                i = 0;
            }
            zq0.v().clearAll();
            zq0.w().clearAll();
            zq0.y().clearAll();
            return i;
        }
        for (ServersCache serversCache : kotlin.collections.c.R(this.serversCache)) {
            Lazy lazy2 = zq0.a;
            zq0.F(serversCache.getGuid());
        }
        return kotlin.collections.c.R(this.serversCache).size();
    }

    public final int removeDuplicateServer() {
        ArrayList arrayList = new ArrayList();
        for (ServersCache serversCache : this.serversCache) {
            Lazy lazy = zq0.a;
            ProfileItem e = zq0.e(serversCache.getGuid());
            if (e != null) {
                arrayList.add(new Pair(serversCache.getGuid(), e));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i2 = i + 1;
            if (i >= 0) {
                ProfileItem profileItem = (ProfileItem) ((Pair) next).getSecond();
                Iterator it2 = arrayList.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    int i4 = i3 + 1;
                    if (i3 >= 0) {
                        Pair pair = (Pair) next2;
                        if (i3 > i && profileItem.equals((ProfileItem) pair.getSecond()) && !arrayList2.contains(pair.getFirst())) {
                            arrayList2.add(pair.getFirst());
                        }
                        i3 = i4;
                    } else {
                        kotlin.collections.c.O();
                        throw null;
                    }
                }
                i = i2;
            } else {
                kotlin.collections.c.O();
                throw null;
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            Lazy lazy2 = zq0.a;
            zq0.F(str);
        }
        return arrayList2.size();
    }

    public final int removeInvalidServer() {
        if (this.subscriptionId.length() == 0 && this.keywordFilter.length() == 0) {
            Lazy lazy = zq0.a;
            return zq0.E(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        }
        int i = 0;
        for (ServersCache serversCache : kotlin.collections.c.R(this.serversCache)) {
            Lazy lazy2 = zq0.a;
            i += zq0.E(serversCache.getGuid());
        }
        return i;
    }

    public final void removeServer(String guid) {
        guid.getClass();
        this.serverList.remove(guid);
        Lazy lazy = zq0.a;
        zq0.F(guid);
        int position = getPosition(guid);
        if (position >= 0) {
            this.serversCache.remove(position);
        }
    }

    public final void setKeywordFilter(String str) {
        str.getClass();
        this.keywordFilter = str;
    }

    public final void setSubscriptionId(String str) {
        str.getClass();
        this.subscriptionId = str;
    }

    public final void sortByTestResults() {
        long j;
        ArrayList arrayList = new ArrayList();
        Lazy lazy = zq0.a;
        ArrayList f = zq0.f();
        Iterator it = f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Lazy lazy2 = zq0.a;
            ServerAffiliationInfo d = zq0.d(str);
            if (d != null) {
                j = d.getTestDelayMillis();
            } else {
                j = 0;
            }
            if (j <= 0) {
                j = 999999;
            }
            arrayList.add(new MainViewModel$sortByTestResults$ServerDelay(str, j));
        }
        if (arrayList.size() > 1) {
            Comparator comparator = new Comparator() { // from class: com.v2ray.ang.viewmodel.MainViewModel$sortByTestResults$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.a(Long.valueOf(((MainViewModel$sortByTestResults$ServerDelay) t).getTestDelayMillis()), Long.valueOf(((MainViewModel$sortByTestResults$ServerDelay) t2).getTestDelayMillis()));
                }
            };
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, comparator);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MainViewModel$sortByTestResults$ServerDelay mainViewModel$sortByTestResults$ServerDelay = (MainViewModel$sortByTestResults$ServerDelay) it2.next();
            f.remove(mainViewModel$sortByTestResults$ServerDelay.getGuid());
            f.add(mainViewModel$sortByTestResults$ServerDelay.getGuid());
        }
        Lazy lazy3 = zq0.a;
        zq0.m(f);
    }

    public final void startListenBroadcast() {
        int i;
        isRunning().k(Boolean.FALSE);
        IntentFilter intentFilter = new IntentFilter("com.v2ray.ang.action.activity");
        Application application = getApplication();
        MainViewModel$mMsgReceiver$1 mainViewModel$mMsgReceiver$1 = this.mMsgReceiver;
        Regex regex = ul1.a;
        if (Build.VERSION.SDK_INT >= 33) {
            i = 2;
        } else {
            i = 4;
        }
        k5.B(application, mainViewModel$mMsgReceiver$1, intentFilter, i);
        Application application2 = getApplication();
        application2.getClass();
        try {
            Intent intent = new Intent();
            intent.setAction("com.v2ray.ang.action.service");
            intent.setPackage("co.strongteam.ultra");
            intent.putExtra("key", 1);
            intent.putExtra("content", (Serializable) RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            application2.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public final void subscriptionIdChanged(String id) {
        id.getClass();
        if (!yg0.a(this.subscriptionId, id)) {
            this.subscriptionId = id;
            Lazy lazy = zq0.a;
            zq0.z().i("cache_subscription_id", id);
            reloadServerList();
        }
    }

    public final void swapServer(int fromPosition, int toPosition) {
        int length = this.subscriptionId.length();
        List<String> list = this.serverList;
        if (length == 0) {
            Collections.swap(list, fromPosition, toPosition);
        } else {
            Collections.swap(this.serverList, list.indexOf(this.serversCache.get(fromPosition).getGuid()), this.serverList.indexOf(this.serversCache.get(toPosition).getGuid()));
        }
        Collections.swap(this.serversCache, fromPosition, toPosition);
        Lazy lazy = zq0.a;
        zq0.m(this.serverList);
    }

    public final void testAllRealPing() {
        Application application = getApplication();
        application.getClass();
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(application, (Class<?>) V2RayTestService.class));
            intent.putExtra("key", 72);
            intent.putExtra("content", (Serializable) RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            application.startService(intent);
        } catch (Exception unused) {
        }
        Lazy lazy = zq0.a;
        List<ServersCache> list = this.serversCache;
        ArrayList arrayList = new ArrayList(kotlin.collections.c.l(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ServersCache) it.next()).getGuid());
        }
        zq0.a(kotlin.collections.c.R(arrayList));
        getUpdateListAction().k(-1);
        kotlinx.coroutines.c.d(rn1.a(this), oy.a, null, new MainViewModel$testAllRealPing$2(kotlin.collections.c.R(this.serversCache), this, null), 2);
    }

    public final void testAllTcping() {
        MainViewModel mainViewModel;
        Job job = (Job) getTcpingTestScope().getA().get(Job.Key);
        if (job != null) {
            kotlinx.coroutines.g.c(job);
        }
        m91.a.a();
        Lazy lazy = zq0.a;
        List<ServersCache> list = this.serversCache;
        ArrayList arrayList = new ArrayList(kotlin.collections.c.l(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ServersCache) it.next()).getGuid());
        }
        zq0.a(kotlin.collections.c.R(arrayList));
        for (ServersCache serversCache : kotlin.collections.c.R(this.serversCache)) {
            ProfileItem profile = serversCache.getProfile();
            String server = profile.getServer();
            String serverPort = profile.getServerPort();
            if (server != null && serverPort != null) {
                mainViewModel = this;
                kotlinx.coroutines.c.d(this.getTcpingTestScope(), null, null, new MainViewModel$testAllTcping$2$1(server, serverPort, serversCache, mainViewModel, null), 3);
            } else {
                mainViewModel = this;
            }
            this = mainViewModel;
        }
    }

    public final void testCurrentServerRealPing() {
        Application application = getApplication();
        application.getClass();
        try {
            Intent intent = new Intent();
            intent.setAction("com.v2ray.ang.action.service");
            intent.setPackage("co.strongteam.ultra");
            intent.putExtra("key", 6);
            intent.putExtra("content", (Serializable) RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            application.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public final void updateBytes() {
        MutableLiveData<Long> mutableLiveData = this._downloaded;
        Lazy lazy = zq0.a;
        mutableLiveData.i(Long.valueOf(zq0.u().c(0L, "BytesIn")));
        this._uploaded.i(Long.valueOf(zq0.u().c(0L, "BytesOut")));
    }

    public final synchronized void updateCache() {
        try {
            this.serversCache.clear();
            for (String str : this.serverList) {
                Lazy lazy = zq0.a;
                ProfileItem e = zq0.e(str);
                if (e != null && (this.subscriptionId.length() <= 0 || yg0.a(this.subscriptionId, e.getSubscriptionId()))) {
                    if (this.keywordFilter.length() != 0) {
                        String remarks = e.getRemarks();
                        Locale locale = Locale.ROOT;
                        String lowerCase = remarks.toLowerCase(locale);
                        lowerCase.getClass();
                        String lowerCase2 = this.keywordFilter.toLowerCase(locale);
                        lowerCase2.getClass();
                        if (g.o(lowerCase, lowerCase2, false)) {
                        }
                    }
                    this.serversCache.add(new ServersCache(str, e));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int updateConfigViaSubAll() {
        if (this.subscriptionId.length() == 0) {
            try {
                Lazy lazy = zq0.a;
                Iterator it = zq0.i().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += ay2.x((Pair) it.next());
                }
                return i;
            } catch (Exception unused) {
            }
        } else {
            Lazy lazy2 = zq0.a;
            SubscriptionItem h = zq0.h(this.subscriptionId);
            if (h != null) {
                return ay2.x(new Pair(this.subscriptionId, h));
            }
        }
        return 0;
    }
}
