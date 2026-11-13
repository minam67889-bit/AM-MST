package com.v2ray.ang.viewmodel;

import com.google.android.gms.ads.RequestConfiguration;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ec1;
import defpackage.hz;
import defpackage.vh;
import defpackage.yg0;
import kotlin.Metadata;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bI\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003Jî\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\t2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020SHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u00106\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b7\u0010#¨\u0006U"}, d2 = {"Lcom/v2ray/ang/viewmodel/NetworkList;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Name", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Info", "Payload", "ProxyPort", "SNI", "DefaultProxy", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "CustomProxy", "V2rayConfig", "TunnelType", "BugDNS", "URI", "V2rayAddress", "V2rayPort", "V2rayHost", "V2ray_is_SNI", "V2raySNI", "V2rayServerNeed", "V2rayNetwork", "Route", "Icon", "VinJect", "V2rayinSecure", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getName", "()Ljava/lang/String;", "getInfo", "getPayload", "getProxyPort", "getSNI", "getDefaultProxy", "()Z", "getCustomProxy", "getV2rayConfig", "getTunnelType", "getBugDNS", "getURI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getV2rayAddress", "getV2rayPort", "getV2rayHost", "getV2ray_is_SNI", "getV2raySNI", "getV2rayServerNeed", "getV2rayNetwork", "getRoute", "getIcon", "getVinJect", "getV2rayinSecure", "safeURI", "getSafeURI", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/v2ray/ang/viewmodel/NetworkList;", "equals", "other", "hashCode", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "toString", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NetworkList {
    private final String BugDNS;
    private final String CustomProxy;
    private final boolean DefaultProxy;
    private final String Icon;
    private final String Info;
    private final String Name;
    private final String Payload;
    private final String ProxyPort;
    private final String Route;
    private final String SNI;
    private final String TunnelType;
    private final Boolean URI;
    private final String V2rayAddress;
    private final String V2rayConfig;
    private final String V2rayHost;
    private final String V2rayNetwork;
    private final String V2rayPort;
    private final String V2raySNI;
    private final String V2rayServerNeed;
    private final boolean V2ray_is_SNI;
    private final boolean V2rayinSecure;
    private final boolean VinJect;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ NetworkList(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.Boolean r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, boolean r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, boolean r43, boolean r44, int r45, defpackage.xu r46) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.viewmodel.NetworkList.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, xu):void");
    }

    public static /* synthetic */ NetworkList copy$default(NetworkList networkList, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, Boolean bool, String str10, String str11, String str12, boolean z2, String str13, String str14, String str15, String str16, String str17, boolean z3, boolean z4, int i, Object obj) {
        boolean z5;
        boolean z6;
        String str18 = (i & 1) != 0 ? networkList.Name : str;
        String str19 = (i & 2) != 0 ? networkList.Info : str2;
        String str20 = (i & 4) != 0 ? networkList.Payload : str3;
        String str21 = (i & 8) != 0 ? networkList.ProxyPort : str4;
        String str22 = (i & 16) != 0 ? networkList.SNI : str5;
        boolean z7 = (i & 32) != 0 ? networkList.DefaultProxy : z;
        String str23 = (i & 64) != 0 ? networkList.CustomProxy : str6;
        String str24 = (i & 128) != 0 ? networkList.V2rayConfig : str7;
        String str25 = (i & 256) != 0 ? networkList.TunnelType : str8;
        String str26 = (i & 512) != 0 ? networkList.BugDNS : str9;
        Boolean bool2 = (i & 1024) != 0 ? networkList.URI : bool;
        String str27 = (i & 2048) != 0 ? networkList.V2rayAddress : str10;
        String str28 = (i & AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE) != 0 ? networkList.V2rayPort : str11;
        String str29 = (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? networkList.V2rayHost : str12;
        String str30 = str18;
        boolean z8 = (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? networkList.V2ray_is_SNI : z2;
        String str31 = (i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? networkList.V2raySNI : str13;
        String str32 = (i & 65536) != 0 ? networkList.V2rayServerNeed : str14;
        String str33 = (i & 131072) != 0 ? networkList.V2rayNetwork : str15;
        String str34 = (i & 262144) != 0 ? networkList.Route : str16;
        String str35 = (i & 524288) != 0 ? networkList.Icon : str17;
        boolean z9 = (i & 1048576) != 0 ? networkList.VinJect : z3;
        if ((i & 2097152) != 0) {
            z6 = z9;
            z5 = networkList.V2rayinSecure;
        } else {
            z5 = z4;
            z6 = z9;
        }
        return networkList.copy(str30, str19, str20, str21, str22, z7, str23, str24, str25, str26, bool2, str27, str28, str29, z8, str31, str32, str33, str34, str35, z6, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.Name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getBugDNS() {
        return this.BugDNS;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getURI() {
        return this.URI;
    }

    /* renamed from: component12, reason: from getter */
    public final String getV2rayAddress() {
        return this.V2rayAddress;
    }

    /* renamed from: component13, reason: from getter */
    public final String getV2rayPort() {
        return this.V2rayPort;
    }

    /* renamed from: component14, reason: from getter */
    public final String getV2rayHost() {
        return this.V2rayHost;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getV2ray_is_SNI() {
        return this.V2ray_is_SNI;
    }

    /* renamed from: component16, reason: from getter */
    public final String getV2raySNI() {
        return this.V2raySNI;
    }

    /* renamed from: component17, reason: from getter */
    public final String getV2rayServerNeed() {
        return this.V2rayServerNeed;
    }

    /* renamed from: component18, reason: from getter */
    public final String getV2rayNetwork() {
        return this.V2rayNetwork;
    }

    /* renamed from: component19, reason: from getter */
    public final String getRoute() {
        return this.Route;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInfo() {
        return this.Info;
    }

    /* renamed from: component20, reason: from getter */
    public final String getIcon() {
        return this.Icon;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getVinJect() {
        return this.VinJect;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getV2rayinSecure() {
        return this.V2rayinSecure;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPayload() {
        return this.Payload;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProxyPort() {
        return this.ProxyPort;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSNI() {
        return this.SNI;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDefaultProxy() {
        return this.DefaultProxy;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCustomProxy() {
        return this.CustomProxy;
    }

    /* renamed from: component8, reason: from getter */
    public final String getV2rayConfig() {
        return this.V2rayConfig;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTunnelType() {
        return this.TunnelType;
    }

    public final NetworkList copy(String Name, String Info, String Payload, String ProxyPort, String SNI, boolean DefaultProxy, String CustomProxy, String V2rayConfig, String TunnelType, String BugDNS, Boolean URI, String V2rayAddress, String V2rayPort, String V2rayHost, boolean V2ray_is_SNI, String V2raySNI, String V2rayServerNeed, String V2rayNetwork, String Route, String Icon, boolean VinJect, boolean V2rayinSecure) {
        ec1.T(Name, Info, Payload, ProxyPort, SNI);
        ec1.T(CustomProxy, V2rayConfig, TunnelType, BugDNS, V2rayAddress);
        ec1.T(V2rayPort, V2rayHost, V2raySNI, V2rayServerNeed, V2rayNetwork);
        Route.getClass();
        return new NetworkList(Name, Info, Payload, ProxyPort, SNI, DefaultProxy, CustomProxy, V2rayConfig, TunnelType, BugDNS, URI, V2rayAddress, V2rayPort, V2rayHost, V2ray_is_SNI, V2raySNI, V2rayServerNeed, V2rayNetwork, Route, Icon, VinJect, V2rayinSecure);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkList)) {
            return false;
        }
        NetworkList networkList = (NetworkList) other;
        if (yg0.a(this.Name, networkList.Name) && yg0.a(this.Info, networkList.Info) && yg0.a(this.Payload, networkList.Payload) && yg0.a(this.ProxyPort, networkList.ProxyPort) && yg0.a(this.SNI, networkList.SNI) && this.DefaultProxy == networkList.DefaultProxy && yg0.a(this.CustomProxy, networkList.CustomProxy) && yg0.a(this.V2rayConfig, networkList.V2rayConfig) && yg0.a(this.TunnelType, networkList.TunnelType) && yg0.a(this.BugDNS, networkList.BugDNS) && yg0.a(this.URI, networkList.URI) && yg0.a(this.V2rayAddress, networkList.V2rayAddress) && yg0.a(this.V2rayPort, networkList.V2rayPort) && yg0.a(this.V2rayHost, networkList.V2rayHost) && this.V2ray_is_SNI == networkList.V2ray_is_SNI && yg0.a(this.V2raySNI, networkList.V2raySNI) && yg0.a(this.V2rayServerNeed, networkList.V2rayServerNeed) && yg0.a(this.V2rayNetwork, networkList.V2rayNetwork) && yg0.a(this.Route, networkList.Route) && yg0.a(this.Icon, networkList.Icon) && this.VinJect == networkList.VinJect && this.V2rayinSecure == networkList.V2rayinSecure) {
            return true;
        }
        return false;
    }

    public final String getBugDNS() {
        return this.BugDNS;
    }

    public final String getCustomProxy() {
        return this.CustomProxy;
    }

    public final boolean getDefaultProxy() {
        return this.DefaultProxy;
    }

    public final String getIcon() {
        return this.Icon;
    }

    public final String getInfo() {
        return this.Info;
    }

    public final String getName() {
        return this.Name;
    }

    public final String getPayload() {
        return this.Payload;
    }

    public final String getProxyPort() {
        return this.ProxyPort;
    }

    public final String getRoute() {
        return this.Route;
    }

    public final String getSNI() {
        return this.SNI;
    }

    public final boolean getSafeURI() {
        Boolean bool = this.URI;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final String getTunnelType() {
        return this.TunnelType;
    }

    public final Boolean getURI() {
        return this.URI;
    }

    public final String getV2rayAddress() {
        return this.V2rayAddress;
    }

    public final String getV2rayConfig() {
        return this.V2rayConfig;
    }

    public final String getV2rayHost() {
        return this.V2rayHost;
    }

    public final String getV2rayNetwork() {
        return this.V2rayNetwork;
    }

    public final String getV2rayPort() {
        return this.V2rayPort;
    }

    public final String getV2raySNI() {
        return this.V2raySNI;
    }

    public final String getV2rayServerNeed() {
        return this.V2rayServerNeed;
    }

    public final boolean getV2ray_is_SNI() {
        return this.V2ray_is_SNI;
    }

    public final boolean getV2rayinSecure() {
        return this.V2rayinSecure;
    }

    public final boolean getVinJect() {
        return this.VinJect;
    }

    public int hashCode() {
        int i;
        int hashCode;
        int i2;
        int i3;
        int c = vh.c(vh.c(vh.c(vh.c(this.Name.hashCode() * 31, 31, this.Info), 31, this.Payload), 31, this.ProxyPort), 31, this.SNI);
        int i4 = 1237;
        if (this.DefaultProxy) {
            i = 1231;
        } else {
            i = 1237;
        }
        int c2 = vh.c(vh.c(vh.c(vh.c((c + i) * 31, 31, this.CustomProxy), 31, this.V2rayConfig), 31, this.TunnelType), 31, this.BugDNS);
        Boolean bool = this.URI;
        int i5 = 0;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        int c3 = vh.c(vh.c(vh.c((c2 + hashCode) * 31, 31, this.V2rayAddress), 31, this.V2rayPort), 31, this.V2rayHost);
        if (this.V2ray_is_SNI) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int c4 = vh.c(vh.c(vh.c(vh.c((c3 + i2) * 31, 31, this.V2raySNI), 31, this.V2rayServerNeed), 31, this.V2rayNetwork), 31, this.Route);
        String str = this.Icon;
        if (str != null) {
            i5 = str.hashCode();
        }
        int i6 = (c4 + i5) * 31;
        if (this.VinJect) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int i7 = (i6 + i3) * 31;
        if (this.V2rayinSecure) {
            i4 = 1231;
        }
        return i7 + i4;
    }

    public String toString() {
        String str = this.Name;
        String str2 = this.Info;
        String str3 = this.Payload;
        String str4 = this.ProxyPort;
        String str5 = this.SNI;
        boolean z = this.DefaultProxy;
        String str6 = this.CustomProxy;
        String str7 = this.V2rayConfig;
        String str8 = this.TunnelType;
        String str9 = this.BugDNS;
        Boolean bool = this.URI;
        String str10 = this.V2rayAddress;
        String str11 = this.V2rayPort;
        String str12 = this.V2rayHost;
        boolean z2 = this.V2ray_is_SNI;
        String str13 = this.V2raySNI;
        String str14 = this.V2rayServerNeed;
        String str15 = this.V2rayNetwork;
        String str16 = this.Route;
        String str17 = this.Icon;
        boolean z3 = this.VinJect;
        boolean z4 = this.V2rayinSecure;
        StringBuilder A = hz.A("NetworkList(Name=", str, ", Info=", str2, ", Payload=");
        hz.H(A, str3, ", ProxyPort=", str4, ", SNI=");
        A.append(str5);
        A.append(", DefaultProxy=");
        A.append(z);
        A.append(", CustomProxy=");
        hz.H(A, str6, ", V2rayConfig=", str7, ", TunnelType=");
        hz.H(A, str8, ", BugDNS=", str9, ", URI=");
        A.append(bool);
        A.append(", V2rayAddress=");
        A.append(str10);
        A.append(", V2rayPort=");
        hz.H(A, str11, ", V2rayHost=", str12, ", V2ray_is_SNI=");
        A.append(z2);
        A.append(", V2raySNI=");
        A.append(str13);
        A.append(", V2rayServerNeed=");
        hz.H(A, str14, ", V2rayNetwork=", str15, ", Route=");
        hz.H(A, str16, ", Icon=", str17, ", VinJect=");
        A.append(z3);
        A.append(", V2rayinSecure=");
        A.append(z4);
        A.append(")");
        return A.toString();
    }

    public NetworkList(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, Boolean bool, String str10, String str11, String str12, boolean z2, String str13, String str14, String str15, String str16, String str17, boolean z3, boolean z4) {
        ec1.T(str, str2, str3, str4, str5);
        ec1.T(str6, str7, str8, str9, str10);
        ec1.T(str11, str12, str13, str14, str15);
        str16.getClass();
        this.Name = str;
        this.Info = str2;
        this.Payload = str3;
        this.ProxyPort = str4;
        this.SNI = str5;
        this.DefaultProxy = z;
        this.CustomProxy = str6;
        this.V2rayConfig = str7;
        this.TunnelType = str8;
        this.BugDNS = str9;
        this.URI = bool;
        this.V2rayAddress = str10;
        this.V2rayPort = str11;
        this.V2rayHost = str12;
        this.V2ray_is_SNI = z2;
        this.V2raySNI = str13;
        this.V2rayServerNeed = str14;
        this.V2rayNetwork = str15;
        this.Route = str16;
        this.Icon = str17;
        this.VinJect = z3;
        this.V2rayinSecure = z4;
    }

    public NetworkList() {
        this(null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, false, 4194303, null);
    }
}
