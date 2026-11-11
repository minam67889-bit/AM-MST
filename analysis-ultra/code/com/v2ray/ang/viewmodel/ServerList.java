package com.v2ray.ang.viewmodel;

import com.google.android.gms.ads.RequestConfiguration;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ec1;
import defpackage.hz;
import defpackage.vh;
import defpackage.yg0;
import kotlin.Metadata;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\bC\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jó\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020QHÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001e¨\u0006S"}, d2 = {"Lcom/v2ray/ang/viewmodel/ServerList;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Name", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Flag", "ServerIPHost", "ServerType", "ServerProtocol", "OpenVPNTCPPort", "OpenVPNUdpPort", "SSH_Port", "SSLPort", "isdefUser", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "OVPNUser", "OVPNPass", "UDP_obfs", "UDP_user", "Default_cert", "CustomCertificate", "SlowDNSHost", "SlowDNSKey", "V2rayProtocol", "V2rayUUID", "V2rayPath", "ServerInfo", "TrojanPass", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getFlag", "getServerIPHost", "getServerType", "getServerProtocol", "getOpenVPNTCPPort", "getOpenVPNUdpPort", "getSSH_Port", "getSSLPort", "getIsdefUser", "()Z", "getOVPNUser", "getOVPNPass", "getUDP_obfs", "getUDP_user", "getDefault_cert", "getCustomCertificate", "getSlowDNSHost", "getSlowDNSKey", "getV2rayProtocol", "getV2rayUUID", "getV2rayPath", "getServerInfo", "getTrojanPass", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "other", "hashCode", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "toString", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ServerList {
    private final String CustomCertificate;
    private final boolean Default_cert;
    private final String Flag;
    private final String Name;
    private final String OVPNPass;
    private final String OVPNUser;
    private final String OpenVPNTCPPort;
    private final String OpenVPNUdpPort;
    private final String SSH_Port;
    private final String SSLPort;
    private final String ServerIPHost;
    private final String ServerInfo;
    private final String ServerProtocol;
    private final String ServerType;
    private final String SlowDNSHost;
    private final String SlowDNSKey;
    private final String TrojanPass;
    private final String UDP_obfs;
    private final String UDP_user;
    private final String V2rayPath;
    private final String V2rayProtocol;
    private final String V2rayUUID;
    private final boolean isdefUser;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ ServerList(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, boolean r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, boolean r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, int r49, defpackage.xu r50) {
        /*
            r25 = this;
            r0 = r49 & 16
            if (r0 == 0) goto L8
            java.lang.String r0 = "OVPN"
            r6 = r0
            goto La
        L8:
            r6 = r30
        La:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r49 & r0
            r1 = 0
            if (r0 == 0) goto L14
            r20 = r1
            goto L16
        L14:
            r20 = r44
        L16:
            r0 = 524288(0x80000, float:7.34684E-40)
            r0 = r49 & r0
            java.lang.String r2 = ""
            if (r0 == 0) goto L21
            r21 = r2
            goto L23
        L21:
            r21 = r45
        L23:
            r0 = 1048576(0x100000, float:1.469368E-39)
            r0 = r49 & r0
            if (r0 == 0) goto L2c
            r22 = r2
            goto L2e
        L2c:
            r22 = r46
        L2e:
            r0 = 2097152(0x200000, float:2.938736E-39)
            r0 = r49 & r0
            if (r0 == 0) goto L37
            r23 = r2
            goto L39
        L37:
            r23 = r47
        L39:
            r0 = 4194304(0x400000, float:5.877472E-39)
            r0 = r49 & r0
            if (r0 == 0) goto L66
            r24 = r1
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r36
            r13 = r37
            r14 = r38
            r15 = r39
            r16 = r40
            r17 = r41
            r18 = r42
            r19 = r43
            r1 = r25
            goto L8c
        L66:
            r24 = r48
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r36
            r13 = r37
            r14 = r38
            r15 = r39
            r16 = r40
            r17 = r41
            r18 = r42
            r19 = r43
        L8c:
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.viewmodel.ServerList.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, xu):void");
    }

    public static /* synthetic */ ServerList copy$default(ServerList serverList, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, String str11, String str12, String str13, boolean z2, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i, Object obj) {
        String str22;
        String str23;
        String str24 = (i & 1) != 0 ? serverList.Name : str;
        String str25 = (i & 2) != 0 ? serverList.Flag : str2;
        String str26 = (i & 4) != 0 ? serverList.ServerIPHost : str3;
        String str27 = (i & 8) != 0 ? serverList.ServerType : str4;
        String str28 = (i & 16) != 0 ? serverList.ServerProtocol : str5;
        String str29 = (i & 32) != 0 ? serverList.OpenVPNTCPPort : str6;
        String str30 = (i & 64) != 0 ? serverList.OpenVPNUdpPort : str7;
        String str31 = (i & 128) != 0 ? serverList.SSH_Port : str8;
        String str32 = (i & 256) != 0 ? serverList.SSLPort : str9;
        boolean z3 = (i & 512) != 0 ? serverList.isdefUser : z;
        String str33 = (i & 1024) != 0 ? serverList.OVPNUser : str10;
        String str34 = (i & 2048) != 0 ? serverList.OVPNPass : str11;
        String str35 = (i & AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE) != 0 ? serverList.UDP_obfs : str12;
        String str36 = (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? serverList.UDP_user : str13;
        String str37 = str24;
        boolean z4 = (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? serverList.Default_cert : z2;
        String str38 = (i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? serverList.CustomCertificate : str14;
        String str39 = (i & 65536) != 0 ? serverList.SlowDNSHost : str15;
        String str40 = (i & 131072) != 0 ? serverList.SlowDNSKey : str16;
        String str41 = (i & 262144) != 0 ? serverList.V2rayProtocol : str17;
        String str42 = (i & 524288) != 0 ? serverList.V2rayUUID : str18;
        String str43 = (i & 1048576) != 0 ? serverList.V2rayPath : str19;
        String str44 = (i & 2097152) != 0 ? serverList.ServerInfo : str20;
        if ((i & 4194304) != 0) {
            str23 = str44;
            str22 = serverList.TrojanPass;
        } else {
            str22 = str21;
            str23 = str44;
        }
        return serverList.copy(str37, str25, str26, str27, str28, str29, str30, str31, str32, z3, str33, str34, str35, str36, z4, str38, str39, str40, str41, str42, str43, str23, str22);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.Name;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsdefUser() {
        return this.isdefUser;
    }

    /* renamed from: component11, reason: from getter */
    public final String getOVPNUser() {
        return this.OVPNUser;
    }

    /* renamed from: component12, reason: from getter */
    public final String getOVPNPass() {
        return this.OVPNPass;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUDP_obfs() {
        return this.UDP_obfs;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUDP_user() {
        return this.UDP_user;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getDefault_cert() {
        return this.Default_cert;
    }

    /* renamed from: component16, reason: from getter */
    public final String getCustomCertificate() {
        return this.CustomCertificate;
    }

    /* renamed from: component17, reason: from getter */
    public final String getSlowDNSHost() {
        return this.SlowDNSHost;
    }

    /* renamed from: component18, reason: from getter */
    public final String getSlowDNSKey() {
        return this.SlowDNSKey;
    }

    /* renamed from: component19, reason: from getter */
    public final String getV2rayProtocol() {
        return this.V2rayProtocol;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFlag() {
        return this.Flag;
    }

    /* renamed from: component20, reason: from getter */
    public final String getV2rayUUID() {
        return this.V2rayUUID;
    }

    /* renamed from: component21, reason: from getter */
    public final String getV2rayPath() {
        return this.V2rayPath;
    }

    /* renamed from: component22, reason: from getter */
    public final String getServerInfo() {
        return this.ServerInfo;
    }

    /* renamed from: component23, reason: from getter */
    public final String getTrojanPass() {
        return this.TrojanPass;
    }

    /* renamed from: component3, reason: from getter */
    public final String getServerIPHost() {
        return this.ServerIPHost;
    }

    /* renamed from: component4, reason: from getter */
    public final String getServerType() {
        return this.ServerType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getServerProtocol() {
        return this.ServerProtocol;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOpenVPNTCPPort() {
        return this.OpenVPNTCPPort;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOpenVPNUdpPort() {
        return this.OpenVPNUdpPort;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSSH_Port() {
        return this.SSH_Port;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSSLPort() {
        return this.SSLPort;
    }

    public final ServerList copy(String Name, String Flag, String ServerIPHost, String ServerType, String ServerProtocol, String OpenVPNTCPPort, String OpenVPNUdpPort, String SSH_Port, String SSLPort, boolean isdefUser, String OVPNUser, String OVPNPass, String UDP_obfs, String UDP_user, boolean Default_cert, String CustomCertificate, String SlowDNSHost, String SlowDNSKey, String V2rayProtocol, String V2rayUUID, String V2rayPath, String ServerInfo, String TrojanPass) {
        ec1.T(Name, Flag, ServerIPHost, ServerType, ServerProtocol);
        ec1.T(OpenVPNTCPPort, OpenVPNUdpPort, SSH_Port, SSLPort, OVPNUser);
        ec1.T(OVPNPass, UDP_obfs, UDP_user, CustomCertificate, SlowDNSHost);
        SlowDNSKey.getClass();
        V2rayUUID.getClass();
        V2rayPath.getClass();
        ServerInfo.getClass();
        return new ServerList(Name, Flag, ServerIPHost, ServerType, ServerProtocol, OpenVPNTCPPort, OpenVPNUdpPort, SSH_Port, SSLPort, isdefUser, OVPNUser, OVPNPass, UDP_obfs, UDP_user, Default_cert, CustomCertificate, SlowDNSHost, SlowDNSKey, V2rayProtocol, V2rayUUID, V2rayPath, ServerInfo, TrojanPass);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerList)) {
            return false;
        }
        ServerList serverList = (ServerList) other;
        if (yg0.a(this.Name, serverList.Name) && yg0.a(this.Flag, serverList.Flag) && yg0.a(this.ServerIPHost, serverList.ServerIPHost) && yg0.a(this.ServerType, serverList.ServerType) && yg0.a(this.ServerProtocol, serverList.ServerProtocol) && yg0.a(this.OpenVPNTCPPort, serverList.OpenVPNTCPPort) && yg0.a(this.OpenVPNUdpPort, serverList.OpenVPNUdpPort) && yg0.a(this.SSH_Port, serverList.SSH_Port) && yg0.a(this.SSLPort, serverList.SSLPort) && this.isdefUser == serverList.isdefUser && yg0.a(this.OVPNUser, serverList.OVPNUser) && yg0.a(this.OVPNPass, serverList.OVPNPass) && yg0.a(this.UDP_obfs, serverList.UDP_obfs) && yg0.a(this.UDP_user, serverList.UDP_user) && this.Default_cert == serverList.Default_cert && yg0.a(this.CustomCertificate, serverList.CustomCertificate) && yg0.a(this.SlowDNSHost, serverList.SlowDNSHost) && yg0.a(this.SlowDNSKey, serverList.SlowDNSKey) && yg0.a(this.V2rayProtocol, serverList.V2rayProtocol) && yg0.a(this.V2rayUUID, serverList.V2rayUUID) && yg0.a(this.V2rayPath, serverList.V2rayPath) && yg0.a(this.ServerInfo, serverList.ServerInfo) && yg0.a(this.TrojanPass, serverList.TrojanPass)) {
            return true;
        }
        return false;
    }

    public final String getCustomCertificate() {
        return this.CustomCertificate;
    }

    public final boolean getDefault_cert() {
        return this.Default_cert;
    }

    public final String getFlag() {
        return this.Flag;
    }

    public final boolean getIsdefUser() {
        return this.isdefUser;
    }

    public final String getName() {
        return this.Name;
    }

    public final String getOVPNPass() {
        return this.OVPNPass;
    }

    public final String getOVPNUser() {
        return this.OVPNUser;
    }

    public final String getOpenVPNTCPPort() {
        return this.OpenVPNTCPPort;
    }

    public final String getOpenVPNUdpPort() {
        return this.OpenVPNUdpPort;
    }

    public final String getSSH_Port() {
        return this.SSH_Port;
    }

    public final String getSSLPort() {
        return this.SSLPort;
    }

    public final String getServerIPHost() {
        return this.ServerIPHost;
    }

    public final String getServerInfo() {
        return this.ServerInfo;
    }

    public final String getServerProtocol() {
        return this.ServerProtocol;
    }

    public final String getServerType() {
        return this.ServerType;
    }

    public final String getSlowDNSHost() {
        return this.SlowDNSHost;
    }

    public final String getSlowDNSKey() {
        return this.SlowDNSKey;
    }

    public final String getTrojanPass() {
        return this.TrojanPass;
    }

    public final String getUDP_obfs() {
        return this.UDP_obfs;
    }

    public final String getUDP_user() {
        return this.UDP_user;
    }

    public final String getV2rayPath() {
        return this.V2rayPath;
    }

    public final String getV2rayProtocol() {
        return this.V2rayProtocol;
    }

    public final String getV2rayUUID() {
        return this.V2rayUUID;
    }

    public int hashCode() {
        int i;
        int hashCode;
        int c = vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(this.Name.hashCode() * 31, 31, this.Flag), 31, this.ServerIPHost), 31, this.ServerType), 31, this.ServerProtocol), 31, this.OpenVPNTCPPort), 31, this.OpenVPNUdpPort), 31, this.SSH_Port), 31, this.SSLPort);
        int i2 = 1237;
        if (this.isdefUser) {
            i = 1231;
        } else {
            i = 1237;
        }
        int c2 = vh.c(vh.c(vh.c(vh.c((c + i) * 31, 31, this.OVPNUser), 31, this.OVPNPass), 31, this.UDP_obfs), 31, this.UDP_user);
        if (this.Default_cert) {
            i2 = 1231;
        }
        int c3 = vh.c(vh.c(vh.c((c2 + i2) * 31, 31, this.CustomCertificate), 31, this.SlowDNSHost), 31, this.SlowDNSKey);
        String str = this.V2rayProtocol;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int c4 = vh.c(vh.c(vh.c((c3 + hashCode) * 31, 31, this.V2rayUUID), 31, this.V2rayPath), 31, this.ServerInfo);
        String str2 = this.TrojanPass;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return c4 + i3;
    }

    public String toString() {
        String str = this.Name;
        String str2 = this.Flag;
        String str3 = this.ServerIPHost;
        String str4 = this.ServerType;
        String str5 = this.ServerProtocol;
        String str6 = this.OpenVPNTCPPort;
        String str7 = this.OpenVPNUdpPort;
        String str8 = this.SSH_Port;
        String str9 = this.SSLPort;
        boolean z = this.isdefUser;
        String str10 = this.OVPNUser;
        String str11 = this.OVPNPass;
        String str12 = this.UDP_obfs;
        String str13 = this.UDP_user;
        boolean z2 = this.Default_cert;
        String str14 = this.CustomCertificate;
        String str15 = this.SlowDNSHost;
        String str16 = this.SlowDNSKey;
        String str17 = this.V2rayProtocol;
        String str18 = this.V2rayUUID;
        String str19 = this.V2rayPath;
        String str20 = this.ServerInfo;
        String str21 = this.TrojanPass;
        StringBuilder A = hz.A("ServerList(Name=", str, ", Flag=", str2, ", ServerIPHost=");
        hz.H(A, str3, ", ServerType=", str4, ", ServerProtocol=");
        hz.H(A, str5, ", OpenVPNTCPPort=", str6, ", OpenVPNUdpPort=");
        hz.H(A, str7, ", SSH_Port=", str8, ", SSLPort=");
        A.append(str9);
        A.append(", isdefUser=");
        A.append(z);
        A.append(", OVPNUser=");
        hz.H(A, str10, ", OVPNPass=", str11, ", UDP_obfs=");
        hz.H(A, str12, ", UDP_user=", str13, ", Default_cert=");
        A.append(z2);
        A.append(", CustomCertificate=");
        A.append(str14);
        A.append(", SlowDNSHost=");
        hz.H(A, str15, ", SlowDNSKey=", str16, ", V2rayProtocol=");
        hz.H(A, str17, ", V2rayUUID=", str18, ", V2rayPath=");
        hz.H(A, str19, ", ServerInfo=", str20, ", TrojanPass=");
        return vh.s(A, str21, ")");
    }

    public ServerList(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, String str11, String str12, String str13, boolean z2, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        ec1.T(str, str2, str3, str4, str5);
        ec1.T(str6, str7, str8, str9, str10);
        ec1.T(str11, str12, str13, str14, str15);
        str16.getClass();
        str18.getClass();
        str19.getClass();
        str20.getClass();
        this.Name = str;
        this.Flag = str2;
        this.ServerIPHost = str3;
        this.ServerType = str4;
        this.ServerProtocol = str5;
        this.OpenVPNTCPPort = str6;
        this.OpenVPNUdpPort = str7;
        this.SSH_Port = str8;
        this.SSLPort = str9;
        this.isdefUser = z;
        this.OVPNUser = str10;
        this.OVPNPass = str11;
        this.UDP_obfs = str12;
        this.UDP_user = str13;
        this.Default_cert = z2;
        this.CustomCertificate = str14;
        this.SlowDNSHost = str15;
        this.SlowDNSKey = str16;
        this.V2rayProtocol = str17;
        this.V2rayUUID = str18;
        this.V2rayPath = str19;
        this.ServerInfo = str20;
        this.TrojanPass = str21;
    }
}
