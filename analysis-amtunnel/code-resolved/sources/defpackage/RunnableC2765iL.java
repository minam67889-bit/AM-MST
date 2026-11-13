package defpackage;

import com.wireguard.android.backend.Tunnel;
import com.wireguard.config.Config;
import com.wireguard.config.InetEndpoint;
import com.wireguard.config.InetNetwork;
import com.wireguard.config.Interface;
import com.wireguard.config.Peer;
import java.util.ArrayList;
import java.util.List;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.WGService;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* renamed from: iL, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC2765iL implements Runnable {
    public final /* synthetic */ Interface.Builder a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Peer.Builder c;
    public final /* synthetic */ String d;
    public final /* synthetic */ WGService e;

    public RunnableC2765iL(WGService wGService, Interface.Builder builder, ArrayList arrayList, Peer.Builder builder2, String str) {
        this.e = wGService;
        this.a = builder;
        this.b = arrayList;
        this.c = builder2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WGService wGService = this.e;
        try {
            wGService.a.setState(wGService.b, Tunnel.State.UP, new Config.Builder().setInterface(this.a.addAddress(InetNetwork.parse(wGService.n + "/22")).parsePrivateKey(wGService.o).addDnsServers(this.b).build()).addPeer(this.c.addAllowedIp(InetNetwork.parse("0.0.0.0/0")).setEndpoint(InetEndpoint.parse(wGService.d + ":" + this.d)).parsePublicKey(wGService.p).setPersistentKeepalive(25).build()).build());
            ((UDPClient) WGService.r).i("Connected");
            SkStatus.updateStateString("CONNECTED", "WG Connected");
            SkStatus.logInfo("<strong><font color=\"green\">WG CONNECTED</strong>");
        } catch (Exception unused) {
        }
    }
}
