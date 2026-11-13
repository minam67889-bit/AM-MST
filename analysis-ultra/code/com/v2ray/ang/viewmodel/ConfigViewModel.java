package com.v2ray.ang.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/v2ray/ang/viewmodel/ConfigViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Lcom/v2ray/ang/viewmodel/ConfigData;", "configData", "Lmk1;", "setConfig", "(Lcom/v2ray/ang/viewmodel/ConfigData;)V", "getConfigValue", "()Lcom/v2ray/ang/viewmodel/ConfigData;", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "_config", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "config", "Landroidx/lifecycle/LiveData;", "getConfig", "()Landroidx/lifecycle/LiveData;", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfigViewModel extends ViewModel {
    private final MutableLiveData<ConfigData> _config;
    private final LiveData<ConfigData> config;

    public ConfigViewModel() {
        MutableLiveData<ConfigData> mutableLiveData = new MutableLiveData<>();
        this._config = mutableLiveData;
        this.config = mutableLiveData;
    }

    public final LiveData<ConfigData> getConfig() {
        return this.config;
    }

    public final ConfigData getConfigValue() {
        return (ConfigData) this._config.d();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this._config.k(null);
    }

    public final void setConfig(ConfigData configData) {
        this._config.k(configData);
    }
}
