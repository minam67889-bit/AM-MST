package org.chromium.net.impl;

import defpackage.W50;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.chromium.net.Proxy;
import org.chromium.net.impl.VersionSafeCallbacks;

/* loaded from: classes2.dex */
final class VersionSafeProxyCallback {
    private static final int PROXY_CALLBACK_API_LEVEL = 38;
    private final Proxy.Callback mBackend;
    private final Executor mExecutor;

    public VersionSafeProxyCallback(Executor executor, Proxy.Callback callback) {
        if (!apiContainsProxyCallbackClass()) {
            throw new AssertionError(W50.j(VersionSafeCallbacks.ApiVersion.getMaximumAvailableApiLevel(), "This should not have been created: the Cronet API being used has an ApiLevel of ", ", but ProxyCallback was added in ApiLevel 38"));
        }
        Objects.requireNonNull(executor);
        this.mExecutor = executor;
        Objects.requireNonNull(callback);
        this.mBackend = callback;
    }

    private boolean apiContainsProxyCallbackClass() {
        return VersionSafeCallbacks.ApiVersion.getMaximumAvailableApiLevel() >= 38;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public void onBeforeTunnelRequest(Proxy.Callback.Request request) {
        this.mBackend.onBeforeTunnelRequest(request);
    }

    public boolean onTunnelHeadersReceived(List<Map.Entry<String, String>> list, int i) {
        return this.mBackend.onTunnelHeadersReceived(list, i);
    }
}
