package com.wireguard.android.backend;

import com.wireguard.android.backend.Tunnel;
import com.wireguard.config.Config;
import com.wireguard.util.NonNullForAll;
import java.util.Set;

@NonNullForAll
/* loaded from: classes.dex */
public interface Backend {
    Set<String> getRunningTunnelNames();

    Tunnel.State getState(Tunnel tunnel);

    Statistics getStatistics(Tunnel tunnel);

    String getVersion();

    Tunnel.State setState(Tunnel tunnel, Tunnel.State state, Config config);
}
