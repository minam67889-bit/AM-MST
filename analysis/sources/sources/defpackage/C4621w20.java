package defpackage;

import com.wireguard.android.backend.Tunnel;

/* renamed from: w20, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4621w20 implements Tunnel {
    public static Tunnel.State a = Tunnel.State.DOWN;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Tunnel
    public final String getName() {
        return "AMWG";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Tunnel
    public final void onStateChange(Tunnel.State state) {
        a = state;
    }
}
