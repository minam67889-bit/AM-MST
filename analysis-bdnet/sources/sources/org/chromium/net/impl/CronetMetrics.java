package org.chromium.net.impl;

import internal.org.jni_zero.CalledByNative;
import internal.org.jni_zero.JNINamespace;
import java.util.Date;
import org.chromium.net.RequestFinishedInfo;

@JNINamespace("cronet")
/* loaded from: classes2.dex */
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mConnectEndMs;
    private final long mConnectStartMs;
    private final long mDnsEndMs;
    private final long mDnsStartMs;
    private final long mPushEndMs;
    private final long mPushStartMs;
    private final Long mReceivedByteCount;
    private final long mRequestEndMs;
    private final long mRequestStartMs;
    private final long mResponseStartMs;
    private final long mSendingEndMs;
    private final long mSendingStartMs;
    private final Long mSentByteCount;
    private final boolean mSocketReused;
    private final long mSslEndMs;
    private final long mSslStartMs;
    private final Long mTotalTimeMs;
    private final Long mTtfbMs;

    @CalledByNative
    public CronetMetrics(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        this.mRequestStartMs = j;
        this.mDnsStartMs = j2;
        this.mDnsEndMs = j3;
        this.mConnectStartMs = j4;
        this.mConnectEndMs = j5;
        this.mSslStartMs = j6;
        this.mSslEndMs = j7;
        this.mSendingStartMs = j8;
        this.mSendingEndMs = j9;
        this.mPushStartMs = j10;
        this.mPushEndMs = j11;
        this.mResponseStartMs = j12;
        this.mRequestEndMs = j13;
        this.mSocketReused = z;
        this.mSentByteCount = Long.valueOf(j14);
        this.mReceivedByteCount = Long.valueOf(j15);
        if (j == -1 || j12 == -1) {
            this.mTtfbMs = null;
        } else {
            this.mTtfbMs = Long.valueOf(j12 - j);
        }
        if (j == -1 || j13 == -1) {
            this.mTotalTimeMs = null;
        } else {
            this.mTotalTimeMs = Long.valueOf(j13 - j);
        }
    }

    private static boolean checkOrder(long j, long j2) {
        return (j2 >= j && j != -1) || j2 == -1;
    }

    public static CronetMetrics empty() {
        return new CronetMetrics(-1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, -1L, false, 0L, 0L);
    }

    public static long getDateDeltaMillisOrDefault(Date date, Date date2, long j) {
        return (date == null || date2 == null) ? j : date2.getTime() - date.getTime();
    }

    private static Date toDate(long j) {
        if (j != -1) {
            return new Date(j);
        }
        return null;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectEnd() {
        return toDate(this.mConnectEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectStart() {
        return toDate(this.mConnectStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsEnd() {
        return toDate(this.mDnsEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsStart() {
        return toDate(this.mDnsStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushEnd() {
        return toDate(this.mPushEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushStart() {
        return toDate(this.mPushStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Long getReceivedByteCount() {
        return this.mReceivedByteCount;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestEnd() {
        return toDate(this.mRequestEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestStart() {
        return toDate(this.mRequestStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getResponseStart() {
        return toDate(this.mResponseStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingEnd() {
        return toDate(this.mSendingEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingStart() {
        return toDate(this.mSendingStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Long getSentByteCount() {
        return this.mSentByteCount;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public boolean getSocketReused() {
        return this.mSocketReused;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslEnd() {
        return toDate(this.mSslEndMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslStart() {
        return toDate(this.mSslStartMs);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTotalTimeMs() {
        return this.mTotalTimeMs;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTtfbMs() {
        return this.mTtfbMs;
    }
}
