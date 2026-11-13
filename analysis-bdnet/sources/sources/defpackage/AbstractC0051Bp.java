package defpackage;

import prince.dastan.vpn.service.vpn.logger.ConnectionStatus;

/* renamed from: Bp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0051Bp {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ConnectionStatus.values().length];
        a = iArr;
        try {
            iArr[ConnectionStatus.LEVEL_CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[ConnectionStatus.LEVEL_AUTH_FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[ConnectionStatus.LEVEL_NONETWORK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[ConnectionStatus.LEVEL_NOTCONNECTED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[ConnectionStatus.UNKNOWN_LEVEL.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
