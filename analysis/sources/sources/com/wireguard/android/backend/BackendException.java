package com.wireguard.android.backend;

import com.wireguard.util.NonNullForAll;

@NonNullForAll
/* loaded from: classes.dex */
public final class BackendException extends Exception {
    private final Object[] format;
    private final Reason reason;

    public enum Reason {
        UNKNOWN_KERNEL_MODULE_NAME,
        WG_QUICK_CONFIG_ERROR_CODE,
        TUNNEL_MISSING_CONFIG,
        VPN_NOT_AUTHORIZED,
        UNABLE_TO_START_VPN,
        TUN_CREATION_ERROR,
        GO_ACTIVATION_ERROR_CODE,
        DNS_RESOLUTION_FAILURE
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BackendException(Reason reason, Object... objArr) {
        this.reason = reason;
        this.format = objArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object[] getFormat() {
        return this.format;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Reason getReason() {
        return this.reason;
    }
}
