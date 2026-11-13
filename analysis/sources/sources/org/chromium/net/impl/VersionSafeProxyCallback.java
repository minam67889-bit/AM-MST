package org.chromium.net.impl;

import com.liapp.y;
import defpackage.AbstractC4575vQ;
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean apiContainsProxyCallbackClass() {
        return VersionSafeCallbacks.ApiVersion.getMaximumAvailableApiLevel() >= 38;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Executor getExecutor() {
        return this.mExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onBeforeTunnelRequest(Proxy.Callback.Request request) {
        this.mBackend.onBeforeTunnelRequest(request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onTunnelHeadersReceived(List<Map.Entry<String, String>> list, int i) {
        return this.mBackend.onTunnelHeadersReceived(list, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VersionSafeProxyCallback(Executor executor, Proxy.Callback callback) {
        if (apiContainsProxyCallbackClass()) {
            Objects.requireNonNull(executor);
            this.mExecutor = executor;
            Objects.requireNonNull(callback);
            this.mBackend = callback;
            return;
        }
        throw new AssertionError(AbstractC4575vQ.n(VersionSafeCallbacks.ApiVersion.getMaximumAvailableApiLevel(), y.ۮخݳ٬ۨ(1835573734), y.ش۳ֲ׬٨(1672387514)));
    }
}
