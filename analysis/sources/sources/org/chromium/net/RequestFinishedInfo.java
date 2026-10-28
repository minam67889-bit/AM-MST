package org.chromium.net;

import com.liapp.y;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class RequestFinishedInfo {
    public static final int CANCELED = 2;
    public static final int FAILED = 1;
    public static final int SUCCEEDED = 0;

    public static abstract class Listener {
        private final Executor mExecutor;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Listener(Executor executor) {
            if (executor == null) {
                throw new IllegalStateException(y.۳׭خ۲ݮ(1787261727));
            }
            this.mExecutor = executor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Executor getExecutor() {
            return this.mExecutor;
        }

        public abstract void onRequestFinished(RequestFinishedInfo requestFinishedInfo);
    }

    public static abstract class Metrics {
        public abstract Date getConnectEnd();

        public abstract Date getConnectStart();

        public abstract Date getDnsEnd();

        public abstract Date getDnsStart();

        public abstract Date getPushEnd();

        public abstract Date getPushStart();

        public abstract Long getReceivedByteCount();

        public abstract Date getRequestEnd();

        public abstract Date getRequestStart();

        public abstract Date getResponseStart();

        public abstract Date getSendingEnd();

        public abstract Date getSendingStart();

        public abstract Long getSentByteCount();

        public abstract boolean getSocketReused();

        public abstract Date getSslEnd();

        public abstract Date getSslStart();

        public abstract Long getTotalTimeMs();

        public abstract Long getTtfbMs();
    }

    public abstract Collection<Object> getAnnotations();

    public abstract CronetException getException();

    public abstract int getFinishedReason();

    public abstract Metrics getMetrics();

    public abstract UrlResponseInfo getResponseInfo();

    public abstract String getUrl();
}
