package com.v2ray.ang.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.ads.RequestConfiguration;
import com.sandok.tunnel.service.OpenVPNService;
import com.sandok.tunnel.utils.ConfigUtil;
import com.v2ray.ang.Hometab;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.viewmodel.ConfigData;
import defpackage.i5;
import defpackage.qf3;
import defpackage.yg0;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final class d implements HomeFragment.EpkiPost {
    public final /* synthetic */ HomeFragment a;

    public d(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    @Override // com.v2ray.ang.ui.HomeFragment.EpkiPost
    public final void post_dispatch(String str) {
        String str2;
        HomeFragment homeFragment = this.a;
        if (homeFragment.o()) {
            if (homeFragment.x0) {
                ConfigData configValue = homeFragment.e0().getConfigValue();
                if (configValue != null) {
                    str2 = configValue.getDefOVPNPass();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    homeFragment.y0 = HomeFragment.d0();
                    homeFragment.z0 = str2;
                } else {
                    return;
                }
            } else {
                Hometab.Companion companion = Hometab.n;
                String str3 = homeFragment.y0;
                if (str3 == null) {
                    str3 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                }
                companion.getClass();
                homeFragment.y0 = Hometab.Companion.a(str3);
                String str4 = homeFragment.z0;
                if (str4 == null) {
                    str4 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                }
                homeFragment.z0 = Hometab.Companion.a(str4);
            }
            String str5 = homeFragment.q0;
            if (str5 == null) {
                str5 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            ConfigUtil configUtil = homeFragment.U0;
            if (configUtil != null) {
                String sSHHost = configUtil.getSSHHost();
                String str6 = homeFragment.y0;
                String str7 = homeFragment.z0;
                Context f = homeFragment.f();
                if (f != null) {
                    Intent putExtra = new Intent(f, (Class<?>) OpenVPNService.class).setAction(OpenVPNService.ACTION_CONNECT).putExtra("net.openvpn.openvpn.PROFILE", str5).putExtra("net.openvpn.openvpn.GUI_VERSION", "0.0").putExtra("net.openvpn.openvpn.PROXY_NAME", "proxy_name").putExtra("net.openvpn.openvpn.PROXY_USERNAME", (String) null).putExtra("net.openvpn.openvpn.PROXY_PASSWORD", (String) null).putExtra("net.openvpn.openvpn.PROXY_ALLOW_CREDS_DIALOG", true).putExtra("net.openvpn.openvpn.SERVER", sSHHost).putExtra("net.openvpn.openvpn.PROTO", "adaptive").putExtra("net.openvpn.openvpn.IPv6", "default").putExtra("net.openvpn.openvpn.CONN_TIMEOUT", "60").putExtra("net.openvpn.openvpn.USERNAME", str6).putExtra("net.openvpn.openvpn.PASSWORD", str7).putExtra("net.openvpn.openvpn.CACHE_PASSWORD", false).putExtra("net.openvpn.openvpn.PK_PASSWORD", str7).putExtra("net.openvpn.openvpn.RESPONSE", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).putExtra("net.openvpn.openvpn.EPKI_ALIAS", str).putExtra("net.openvpn.openvpn.COMPRESSION_MODE", "yes");
                    putExtra.getClass();
                    try {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 31) {
                            if (i >= 26) {
                                i5.C(f, putExtra);
                                return;
                            } else {
                                f.startService(putExtra);
                                return;
                            }
                        }
                        f.startService(putExtra);
                        return;
                    } catch (Exception e) {
                        e.getMessage();
                        Context f2 = homeFragment.f();
                        if (f2 != null) {
                            qf3.L(f2, "Failed to start VPN service");
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            yg0.N("configUtil");
            throw null;
        }
    }
}
