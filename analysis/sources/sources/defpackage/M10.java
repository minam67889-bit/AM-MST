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
import prince.udp.vpn.service.WGService;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class M10 implements Runnable {
    public final /* synthetic */ Interface.Builder a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Peer.Builder c;
    public final /* synthetic */ String d;
    public final /* synthetic */ WGService e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public M10(WGService wGService, Interface.Builder builder, ArrayList arrayList, Peer.Builder builder2, String str) {
        this.e = wGService;
        this.a = builder;
        this.b = arrayList;
        this.c = builder2;
        this.d = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        WGService wGService = this.e;
        try {
            wGService.a.setState(wGService.b, Tunnel.State.UP, new Config.Builder().setInterface(this.a.addAddress(InetNetwork.parse(wGService.h + Deobfuscator$AMTUNNELLITE$app.getString(-192473200660129L))).parsePrivateKey(wGService.i).addDnsServers(this.b).build()).addPeer(this.c.addAllowedIp(InetNetwork.parse(Deobfuscator$AMTUNNELLITE$app.getString(-192456020790945L))).setEndpoint(InetEndpoint.parse(wGService.d + Deobfuscator$AMTUNNELLITE$app.getString(-192962826931873L) + this.d)).parsePublicKey(wGService.j).setPersistentKeepalive(25).build()).build());
            WGService.l.i(Deobfuscator$AMTUNNELLITE$app.getString(-192954236997281L));
            SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-192842567847585L), Deobfuscator$AMTUNNELLITE$app.getString(-192868337651361L));
            SkStatus.logInfo(Deobfuscator$AMTUNNELLITE$app.getString(-192803913141921L));
        } catch (Exception unused) {
        }
    }
}
