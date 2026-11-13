package org.chromium.net;

import com.liapp.y;
import defpackage.T60;
import defpackage.Z5;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class Proxy {
    public static final int HTTP = 0;
    public static final int HTTPS = 1;
    private final Callback mCallback;
    private final Executor mExecutor;
    private final String mHost;
    private final int mPort;
    private final int mScheme;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scheme {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Callback getCallback() {
        return this.mCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Executor getExecutor() {
        return this.mExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getHost() {
        return this.mHost;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPort() {
        return this.mPort;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getScheme() {
        return this.mScheme;
    }

    public static abstract class Callback {

        public static abstract class Request implements AutoCloseable {
            @Override // java.lang.AutoCloseable
            public abstract void close();

            public abstract void proceed(List<Map.Entry<String, String>> list);
        }

        public abstract boolean onTunnelHeadersReceived(List<Map.Entry<String, String>> list, int i);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public List<Map.Entry<String, String>> onBeforeTunnelRequest() {
            throw new UnsupportedOperationException(y.׬ܮ֮ڱܭ(1520125768));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void onBeforeTunnelRequest(Request request) {
            try {
                List<Map.Entry<String, String>> onBeforeTunnelRequest = onBeforeTunnelRequest();
                if (onBeforeTunnelRequest != null) {
                    request.proceed(onBeforeTunnelRequest);
                }
                if (request != null) {
                    request.close();
                }
            } catch (Throwable th) {
                if (request != null) {
                    try {
                        request.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Proxy(int i, String str, int i2, Executor executor, Callback callback) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(T60.w(i, "Unknown scheme "));
        }
        this.mScheme = i;
        Objects.requireNonNull(str);
        this.mHost = str;
        this.mPort = i2;
        Objects.requireNonNull(executor);
        this.mExecutor = executor;
        Objects.requireNonNull(callback);
        this.mCallback = callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Proxy(int i, String str, int i2, Callback callback) {
        this(i, str, i2, new Z5(2), callback);
    }
}
