package com.v2ray.ang.viewmodel;

import com.google.android.gms.ads.RequestConfiguration;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ec1;
import defpackage.hz;
import defpackage.vh;
import defpackage.xu;
import defpackage.yg0;
import java.util.List;
import kotlin.Metadata;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014HÆ\u0003J¼\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0010HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,¨\u0006D"}, d2 = {"Lcom/v2ray/ang/viewmodel/ConfigData;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Version", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "ReleaseNotes", "Telegram", "WhatsApp", "Facebook", "DefOVPNUser", "DefOVPNPass", "HysteriaUser", "HysteriaOBFS", "DefaultOVPNCert", "isTimerOn", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "timetoadd", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "viplink", "businesslink", "Servers", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Lcom/v2ray/ang/viewmodel/ServerList;", "Networks", "Lcom/v2ray/ang/viewmodel/NetworkList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getReleaseNotes", "getTelegram", "getWhatsApp", "getFacebook", "getDefOVPNUser", "getDefOVPNPass", "getHysteriaUser", "getHysteriaOBFS", "getDefaultOVPNCert", "()Z", "getTimetoadd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getViplink", "getBusinesslink", "getServers", "()Ljava/util/List;", "getNetworks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/v2ray/ang/viewmodel/ConfigData;", "equals", "other", "hashCode", "toString", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfigData {
    private final String DefOVPNPass;
    private final String DefOVPNUser;
    private final String DefaultOVPNCert;
    private final String Facebook;
    private final String HysteriaOBFS;
    private final String HysteriaUser;
    private final List<NetworkList> Networks;
    private final String ReleaseNotes;
    private final List<ServerList> Servers;
    private final String Telegram;
    private final String Version;
    private final String WhatsApp;
    private final String businesslink;
    private final boolean isTimerOn;
    private final Integer timetoadd;
    private final String viplink;

    public /* synthetic */ ConfigData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, Integer num, String str11, String str12, List list, List list2, int i, xu xuVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i & 1024) != 0 ? true : z, (i & 2048) != 0 ? null : num, (i & AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE) != 0 ? "https://panel.vpnprous.com" : str11, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? "https://10xbdnet.xyz/login" : str12, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.Version;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDefaultOVPNCert() {
        return this.DefaultOVPNCert;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsTimerOn() {
        return this.isTimerOn;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getTimetoadd() {
        return this.timetoadd;
    }

    /* renamed from: component13, reason: from getter */
    public final String getViplink() {
        return this.viplink;
    }

    /* renamed from: component14, reason: from getter */
    public final String getBusinesslink() {
        return this.businesslink;
    }

    public final List<ServerList> component15() {
        return this.Servers;
    }

    public final List<NetworkList> component16() {
        return this.Networks;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReleaseNotes() {
        return this.ReleaseNotes;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTelegram() {
        return this.Telegram;
    }

    /* renamed from: component4, reason: from getter */
    public final String getWhatsApp() {
        return this.WhatsApp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFacebook() {
        return this.Facebook;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDefOVPNUser() {
        return this.DefOVPNUser;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDefOVPNPass() {
        return this.DefOVPNPass;
    }

    /* renamed from: component8, reason: from getter */
    public final String getHysteriaUser() {
        return this.HysteriaUser;
    }

    /* renamed from: component9, reason: from getter */
    public final String getHysteriaOBFS() {
        return this.HysteriaOBFS;
    }

    public final ConfigData copy(String Version, String ReleaseNotes, String Telegram, String WhatsApp, String Facebook, String DefOVPNUser, String DefOVPNPass, String HysteriaUser, String HysteriaOBFS, String DefaultOVPNCert, boolean isTimerOn, Integer timetoadd, String viplink, String businesslink, List<ServerList> Servers, List<NetworkList> Networks) {
        ec1.T(Version, ReleaseNotes, Telegram, WhatsApp, Facebook);
        ec1.T(DefOVPNUser, DefOVPNPass, HysteriaUser, HysteriaOBFS, DefaultOVPNCert);
        viplink.getClass();
        businesslink.getClass();
        Servers.getClass();
        Networks.getClass();
        return new ConfigData(Version, ReleaseNotes, Telegram, WhatsApp, Facebook, DefOVPNUser, DefOVPNPass, HysteriaUser, HysteriaOBFS, DefaultOVPNCert, isTimerOn, timetoadd, viplink, businesslink, Servers, Networks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) other;
        if (yg0.a(this.Version, configData.Version) && yg0.a(this.ReleaseNotes, configData.ReleaseNotes) && yg0.a(this.Telegram, configData.Telegram) && yg0.a(this.WhatsApp, configData.WhatsApp) && yg0.a(this.Facebook, configData.Facebook) && yg0.a(this.DefOVPNUser, configData.DefOVPNUser) && yg0.a(this.DefOVPNPass, configData.DefOVPNPass) && yg0.a(this.HysteriaUser, configData.HysteriaUser) && yg0.a(this.HysteriaOBFS, configData.HysteriaOBFS) && yg0.a(this.DefaultOVPNCert, configData.DefaultOVPNCert) && this.isTimerOn == configData.isTimerOn && yg0.a(this.timetoadd, configData.timetoadd) && yg0.a(this.viplink, configData.viplink) && yg0.a(this.businesslink, configData.businesslink) && yg0.a(this.Servers, configData.Servers) && yg0.a(this.Networks, configData.Networks)) {
            return true;
        }
        return false;
    }

    public final String getBusinesslink() {
        return this.businesslink;
    }

    public final String getDefOVPNPass() {
        return this.DefOVPNPass;
    }

    public final String getDefOVPNUser() {
        return this.DefOVPNUser;
    }

    public final String getDefaultOVPNCert() {
        return this.DefaultOVPNCert;
    }

    public final String getFacebook() {
        return this.Facebook;
    }

    public final String getHysteriaOBFS() {
        return this.HysteriaOBFS;
    }

    public final String getHysteriaUser() {
        return this.HysteriaUser;
    }

    public final List<NetworkList> getNetworks() {
        return this.Networks;
    }

    public final String getReleaseNotes() {
        return this.ReleaseNotes;
    }

    public final List<ServerList> getServers() {
        return this.Servers;
    }

    public final String getTelegram() {
        return this.Telegram;
    }

    public final Integer getTimetoadd() {
        return this.timetoadd;
    }

    public final String getVersion() {
        return this.Version;
    }

    public final String getViplink() {
        return this.viplink;
    }

    public final String getWhatsApp() {
        return this.WhatsApp;
    }

    public int hashCode() {
        int i;
        int hashCode;
        int c = vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(vh.c(this.Version.hashCode() * 31, 31, this.ReleaseNotes), 31, this.Telegram), 31, this.WhatsApp), 31, this.Facebook), 31, this.DefOVPNUser), 31, this.DefOVPNPass), 31, this.HysteriaUser), 31, this.HysteriaOBFS), 31, this.DefaultOVPNCert);
        if (this.isTimerOn) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i2 = (c + i) * 31;
        Integer num = this.timetoadd;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return this.Networks.hashCode() + ((this.Servers.hashCode() + vh.c(vh.c((i2 + hashCode) * 31, 31, this.viplink), 31, this.businesslink)) * 31);
    }

    public final boolean isTimerOn() {
        return this.isTimerOn;
    }

    public String toString() {
        String str = this.Version;
        String str2 = this.ReleaseNotes;
        String str3 = this.Telegram;
        String str4 = this.WhatsApp;
        String str5 = this.Facebook;
        String str6 = this.DefOVPNUser;
        String str7 = this.DefOVPNPass;
        String str8 = this.HysteriaUser;
        String str9 = this.HysteriaOBFS;
        String str10 = this.DefaultOVPNCert;
        boolean z = this.isTimerOn;
        Integer num = this.timetoadd;
        String str11 = this.viplink;
        String str12 = this.businesslink;
        List<ServerList> list = this.Servers;
        List<NetworkList> list2 = this.Networks;
        StringBuilder A = hz.A("ConfigData(Version=", str, ", ReleaseNotes=", str2, ", Telegram=");
        hz.H(A, str3, ", WhatsApp=", str4, ", Facebook=");
        hz.H(A, str5, ", DefOVPNUser=", str6, ", DefOVPNPass=");
        hz.H(A, str7, ", HysteriaUser=", str8, ", HysteriaOBFS=");
        hz.H(A, str9, ", DefaultOVPNCert=", str10, ", isTimerOn=");
        A.append(z);
        A.append(", timetoadd=");
        A.append(num);
        A.append(", viplink=");
        hz.H(A, str11, ", businesslink=", str12, ", Servers=");
        A.append(list);
        A.append(", Networks=");
        A.append(list2);
        A.append(")");
        return A.toString();
    }

    public ConfigData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, Integer num, String str11, String str12, List<ServerList> list, List<NetworkList> list2) {
        ec1.T(str, str2, str3, str4, str5);
        ec1.T(str6, str7, str8, str9, str10);
        str11.getClass();
        str12.getClass();
        list.getClass();
        list2.getClass();
        this.Version = str;
        this.ReleaseNotes = str2;
        this.Telegram = str3;
        this.WhatsApp = str4;
        this.Facebook = str5;
        this.DefOVPNUser = str6;
        this.DefOVPNPass = str7;
        this.HysteriaUser = str8;
        this.HysteriaOBFS = str9;
        this.DefaultOVPNCert = str10;
        this.isTimerOn = z;
        this.timetoadd = num;
        this.viplink = str11;
        this.businesslink = str12;
        this.Servers = list;
        this.Networks = list2;
    }
}
