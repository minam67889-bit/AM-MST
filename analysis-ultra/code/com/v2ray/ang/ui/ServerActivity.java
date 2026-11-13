package com.v2ray.ang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.trilead.ssh2.sftp.ErrorCodes;
import com.v2ray.ang.dto.EConfigType;
import com.v2ray.ang.dto.NetworkType;
import com.v2ray.ang.dto.ProfileItem;
import com.v2ray.ang.ui.ServerActivity;
import defpackage.j61;
import defpackage.k61;
import defpackage.p60;
import defpackage.ul1;
import defpackage.wz;
import defpackage.yg0;
import defpackage.zq0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/v2ray/ang/ui/ServerActivity;", "Lcom/v2ray/ang/ui/BaseActivity;", "<init>", "()V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerActivity extends BaseActivity {
    public static final /* synthetic */ int h0 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final Lazy S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;
    public final Lazy a0;
    public final Lazy b0;
    public final Lazy c;
    public final Lazy c0;
    public final Lazy d;
    public final Lazy d0;
    public final Lazy e;
    public final Lazy e0;
    public final Lazy f;
    public final Lazy f0;
    public final Lazy g;
    public final Lazy g0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public ServerActivity() {
        final int i = 0;
        this.c = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                ServerActivity serverActivity = this.b;
                switch (i2) {
                    case 0:
                        int i3 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i4 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i5 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i6 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i7 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i8 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i9 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i10 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i11 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i2 = 2;
        this.d = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i3 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i4 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i5 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i6 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i7 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i8 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i9 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i10 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i11 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i3 = 14;
        this.e = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i3;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i4 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i5 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i6 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i7 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i8 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i9 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i10 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i11 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i4 = 26;
        this.f = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i4;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i5 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i6 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i7 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i8 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i9 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i10 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i11 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i5 = 8;
        this.g = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i6 = i5;
                ServerActivity serverActivity = this.b;
                switch (i6) {
                    case 0:
                        int i7 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i8 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i9 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i10 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i6 = 17;
        this.h = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i6;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i7 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i8 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i9 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i10 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i7 = 18;
        this.i = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i7;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i8 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i9 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i10 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i8 = 19;
        this.j = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i8;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i9 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i10 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i9 = 20;
        this.k = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i9;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i10 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i10 = 21;
        this.l = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i10;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i11 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i13 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i11 = 11;
        this.m = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i11;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i12 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i12 = 22;
        this.n = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i12;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i13 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i14 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i15 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i16 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i17 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i13 = 3;
        this.o = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i13;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.p = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i3;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.q = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i12;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i14 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i14 = 23;
        this.r = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i14;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i15 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i15 = 24;
        this.s = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i15;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i16 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i16 = 25;
        this.t = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i16;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.u = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i4;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i17 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i18 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i19 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i20 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i21 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i22 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i23 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i24 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i26 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i27 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i28 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i30 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i17 = 1;
        this.v = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i17;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.w = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i13;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i18 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i18 = 4;
        this.x = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i18;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i19 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i19 = 5;
        this.y = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i19;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i20 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i20 = 6;
        this.z = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i20;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i21 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i21 = 7;
        this.A = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i21;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.B = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i5;
                ServerActivity serverActivity = this.b;
                switch (i22) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i22 = 9;
        this.C = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i22;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i23 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i23 = 10;
        this.D = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i23;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i24 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i24 = 12;
        this.E = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i24;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i25 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i25 = 13;
        this.F = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i25;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i26 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i26 = 15;
        this.G = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i26;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i27 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i27 = 16;
        this.H = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i27;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.I = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i6;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.J = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i7;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.K = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i8;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.L = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i9;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.M = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i10;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.N = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i14;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.O = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i15;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.P = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i16;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i28 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i28 = 27;
        this.Q = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i28;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i282 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i29 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i29 = 28;
        this.R = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i29;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i282 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i30 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        final int i30 = 29;
        this.S = kotlin.c.b(new Function0(this) { // from class: h61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i222 = i30;
                ServerActivity serverActivity = this.b;
                switch (i222) {
                    case 0:
                        int i32 = ServerActivity.h0;
                        String stringExtra = serverActivity.getIntent().getStringExtra("guid");
                        if (stringExtra == null) {
                            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        return stringExtra;
                    case 1:
                        int i42 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_id);
                    case 2:
                        int i52 = ServerActivity.h0;
                        boolean z = false;
                        if (serverActivity.getIntent().getBooleanExtra("isRunning", false) && serverActivity.l().length() > 0) {
                            String l = serverActivity.l();
                            Lazy lazy = zq0.a;
                            if (yg0.a(l, zq0.x())) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    case 3:
                        int i62 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_security);
                    case 4:
                        int i72 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_flow);
                    case 5:
                        int i82 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_security);
                    case 6:
                        int i92 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_security);
                    case 7:
                        int i102 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_allow_insecure);
                    case 8:
                        int i112 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_allow_insecure);
                    case 9:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_sni);
                    case 10:
                        int i132 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_sni);
                    case 11:
                        int i142 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.mode_type_grpc);
                    case 12:
                        int i152 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_fingerprint);
                    case 13:
                        int i162 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_fingerprint);
                    case 14:
                        int i172 = ServerActivity.h0;
                        EConfigType.Companion companion = EConfigType.INSTANCE;
                        Intent intent = serverActivity.getIntent();
                        EConfigType eConfigType = EConfigType.VMESS;
                        EConfigType fromInt = companion.fromInt(intent.getIntExtra("createConfigType", eConfigType.getValue()));
                        if (fromInt != null) {
                            return fromInt;
                        }
                        return eConfigType;
                    case 15:
                        int i182 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_network);
                    case 16:
                        int i192 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_header_type);
                    case 17:
                        int i202 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.sp_header_type_title);
                    case 18:
                        int i212 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_request_host);
                    case 19:
                        int i2222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_request_host);
                    case 20:
                        int i232 = ServerActivity.h0;
                        return (TextView) serverActivity.findViewById(R.id.tv_path);
                    case 21:
                        int i242 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_path);
                    case 22:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurityxs);
                    case 23:
                        int i262 = ServerActivity.h0;
                        return (Spinner) serverActivity.findViewById(R.id.sp_stream_alpn);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i272 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_stream_alpn);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i282 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_public_key);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getIntent().getStringExtra("subscriptionId");
                    case 27:
                        int i302 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_preshared_key);
                    case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                        int i31 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_public_key);
                    default:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_short_id);
                }
            }
        });
        this.T = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.U = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i17;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.V = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i2;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.W = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i18;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i31 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i31 = 5;
        this.X = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i31;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i32 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i32 = 6;
        this.Y = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i32;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        this.Z = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i21;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i33 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i33 = 9;
        this.a0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i33;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i34 = 10;
        this.b0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i34;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i35 = 11;
        this.c0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i35;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i36 = 12;
        this.d0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i36;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i37 = 13;
        this.e0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i37;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i38 = 15;
        this.f0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i38;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
        final int i39 = 16;
        this.g0 = kotlin.c.b(new Function0(this) { // from class: i61
            public final /* synthetic */ ServerActivity b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i62 = i39;
                ServerActivity serverActivity = this.b;
                switch (i62) {
                    case 0:
                        int i72 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_short_id);
                    case 1:
                        int i82 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_spider_x);
                    case 2:
                        int i92 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.lay_spider_x);
                    case 3:
                        int i102 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.allowinsecures);
                    case 4:
                        int i112 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_reserved1);
                    case 5:
                        int i122 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_address);
                    case 6:
                        int i132 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_local_mtu);
                    case 7:
                        int i142 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_obfs_password);
                    case 8:
                        int i152 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.securitys);
                    case 9:
                        int i162 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop);
                    case 10:
                        int i172 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port_hop_interval);
                    case 11:
                        int i182 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_pinsha256);
                    case 12:
                        int i192 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_down);
                    case 13:
                        int i202 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_bandwidth_up);
                    case 14:
                        int i212 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_utls);
                    case 15:
                        int i222 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_extra);
                    case 16:
                        int i232 = ServerActivity.h0;
                        return (LinearLayout) serverActivity.findViewById(R.id.layout_extra);
                    case 17:
                        int i242 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.ss_securitys);
                    case 18:
                        int i252 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.flows);
                    case 19:
                        int i262 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.networks);
                    case 20:
                        int i272 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_tcp);
                    case 21:
                        int i282 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.header_type_kcp_and_quic);
                    case 22:
                        int i292 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.streamsecurity_alpn);
                    case 23:
                        int i302 = ServerActivity.h0;
                        return serverActivity.getResources().getStringArray(R.array.xhttp_mode);
                    case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                        int i312 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_remarks);
                    case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                        int i322 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_address);
                    default:
                        int i332 = ServerActivity.h0;
                        return (EditText) serverActivity.findViewById(R.id.et_port);
                }
            }
        });
    }

    public final LinearLayout h() {
        return (LinearLayout) this.B.getValue();
    }

    public final LinearLayout i() {
        return (LinearLayout) this.R.getValue();
    }

    public final LinearLayout j() {
        return (LinearLayout) this.T.getValue();
    }

    public final LinearLayout k() {
        return (LinearLayout) this.V.getValue();
    }

    public final String l() {
        return (String) this.c.getValue();
    }

    public final EditText m() {
        Object value = this.v.getValue();
        value.getClass();
        return (EditText) value;
    }

    public final String[] n() {
        Object value = this.j.getValue();
        value.getClass();
        return (String[]) value;
    }

    public final String[] o() {
        Object value = this.n.getValue();
        value.getClass();
        return (String[]) value;
    }

    @Override // com.v2ray.ang.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        EConfigType eConfigType;
        String[] strArr;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        String num;
        Spinner spinner4;
        super.onCreate(bundle);
        setTitle(getString(R.string.title_server));
        Lazy lazy = zq0.a;
        ProfileItem e = zq0.e(l());
        if (e == null || (eConfigType = e.getConfigType()) == null) {
            eConfigType = (EConfigType) this.e.getValue();
        }
        switch (j61.a[eConfigType.ordinal()]) {
            case 1:
                setContentView(R.layout.activity_server_vmess);
                break;
            case 2:
                return;
            case 3:
                setContentView(R.layout.activity_server_shadowsocks);
                break;
            case 4:
                setContentView(R.layout.activity_server_socks);
                break;
            case 5:
                setContentView(R.layout.activity_server_socks);
                break;
            case 6:
                setContentView(R.layout.activity_server_vless);
                break;
            case 7:
                setContentView(R.layout.activity_server_trojan);
                break;
            case 8:
                setContentView(R.layout.activity_server_wireguard);
                break;
            case 9:
                setContentView(R.layout.activity_server_hysteria2);
                break;
            default:
                p60.b();
                return;
        }
        Lazy lazy2 = this.G;
        Spinner spinner5 = (Spinner) lazy2.getValue();
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new k61(this, e));
        }
        Lazy lazy3 = this.z;
        Spinner spinner6 = (Spinner) lazy3.getValue();
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new wz(this, 3));
        }
        Lazy lazy4 = this.A;
        Lazy lazy5 = this.C;
        Lazy lazy6 = this.y;
        Lazy lazy7 = this.Y;
        Lazy lazy8 = this.X;
        Lazy lazy9 = this.W;
        Lazy lazy10 = this.x;
        Lazy lazy11 = this.u;
        Lazy lazy12 = this.t;
        Lazy lazy13 = this.P;
        String str = "1420";
        String str2 = "172.16.0.2/32";
        String str3 = "0,0,0";
        String str4 = "443";
        Lazy lazy14 = this.s;
        if (e != null) {
            Object value = lazy14.getValue();
            value.getClass();
            Regex regex = ul1.a;
            ((EditText) value).setText(ul1.j(e.getRemarks()));
            Object value2 = lazy12.getValue();
            value2.getClass();
            EditText editText = (EditText) value2;
            String server = e.getServer();
            String str5 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            if (server == null) {
                server = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            editText.setText(ul1.j(server));
            Object value3 = lazy11.getValue();
            value3.getClass();
            EditText editText2 = (EditText) value3;
            String serverPort = e.getServerPort();
            if (serverPort != null) {
                str4 = serverPort;
            }
            editText2.setText(ul1.j(str4));
            EditText m = m();
            String password = e.getPassword();
            if (password == null) {
                password = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            m.setText(ul1.j(password));
            EConfigType configType = e.getConfigType();
            EConfigType eConfigType2 = EConfigType.SOCKS;
            Lazy lazy15 = this.w;
            if (configType != eConfigType2 && e.getConfigType() != EConfigType.HTTP) {
                if (e.getConfigType() == EConfigType.VLESS) {
                    EditText editText3 = (EditText) lazy15.getValue();
                    if (editText3 != null) {
                        String method = e.getMethod();
                        if (method == null) {
                            method = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText3.setText(ul1.j(method));
                    }
                    Object value4 = this.i.getValue();
                    value4.getClass();
                    String[] strArr2 = (String[]) value4;
                    String flow = e.getFlow();
                    if (flow == null) {
                        flow = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    }
                    int p = kotlin.collections.b.p(flow, strArr2);
                    if (p >= 0 && (spinner4 = (Spinner) lazy10.getValue()) != null) {
                        spinner4.setSelection(p);
                    }
                } else if (e.getConfigType() == EConfigType.WIREGUARD) {
                    EditText m2 = m();
                    String secretKey = e.getSecretKey();
                    if (secretKey == null) {
                        secretKey = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    }
                    m2.setText(ul1.j(secretKey));
                    EditText editText4 = (EditText) lazy13.getValue();
                    if (editText4 != null) {
                        String publicKey = e.getPublicKey();
                        if (publicKey == null) {
                            publicKey = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText4.setText(ul1.j(publicKey));
                    }
                    Lazy lazy16 = this.Q;
                    EditText editText5 = (EditText) lazy16.getValue();
                    if (editText5 != null) {
                        editText5.setVisibility(0);
                    }
                    EditText editText6 = (EditText) lazy16.getValue();
                    if (editText6 != null) {
                        String preSharedKey = e.getPreSharedKey();
                        if (preSharedKey == null) {
                            preSharedKey = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText6.setText(ul1.j(preSharedKey));
                    }
                    EditText editText7 = (EditText) lazy9.getValue();
                    if (editText7 != null) {
                        String reserved = e.getReserved();
                        if (reserved != null) {
                            str3 = reserved;
                        }
                        editText7.setText(ul1.j(str3));
                    }
                    EditText editText8 = (EditText) lazy8.getValue();
                    if (editText8 != null) {
                        String localAddress = e.getLocalAddress();
                        if (localAddress != null) {
                            str2 = localAddress;
                        }
                        editText8.setText(ul1.j(str2));
                    }
                    EditText editText9 = (EditText) lazy7.getValue();
                    if (editText9 != null) {
                        Integer mtu = e.getMtu();
                        if (mtu != null && (num = mtu.toString()) != null) {
                            str = num;
                        }
                        editText9.setText(ul1.j(str));
                    }
                } else if (e.getConfigType() == EConfigType.HYSTERIA2) {
                    EditText editText10 = (EditText) this.Z.getValue();
                    if (editText10 != null) {
                        editText10.setText(ul1.j(e.getObfsPassword()));
                    }
                    EditText editText11 = (EditText) this.a0.getValue();
                    if (editText11 != null) {
                        editText11.setText(ul1.j(e.getPortHopping()));
                    }
                    EditText editText12 = (EditText) this.b0.getValue();
                    if (editText12 != null) {
                        editText12.setText(ul1.j(e.getPortHoppingInterval()));
                    }
                    EditText editText13 = (EditText) this.c0.getValue();
                    if (editText13 != null) {
                        editText13.setText(ul1.j(e.getPinSHA256()));
                    }
                    EditText editText14 = (EditText) this.d0.getValue();
                    if (editText14 != null) {
                        editText14.setText(ul1.j(e.getBandwidthDown()));
                    }
                    EditText editText15 = (EditText) this.e0.getValue();
                    if (editText15 != null) {
                        editText15.setText(ul1.j(e.getBandwidthUp()));
                    }
                }
            } else {
                EditText editText16 = (EditText) lazy15.getValue();
                if (editText16 != null) {
                    String username = e.getUsername();
                    if (username == null) {
                        username = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    }
                    editText16.setText(ul1.j(username));
                }
            }
            if (e.getConfigType() == EConfigType.SHADOWSOCKS) {
                Object value5 = this.h.getValue();
                value5.getClass();
                strArr = (String[]) value5;
            } else {
                Object value6 = this.g.getValue();
                value6.getClass();
                strArr = (String[]) value6;
            }
            String method2 = e.getMethod();
            if (method2 == null) {
                method2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            int p2 = kotlin.collections.b.p(method2, strArr);
            if (p2 >= 0 && (spinner3 = (Spinner) lazy6.getValue()) != null) {
                spinner3.setSelection(p2);
            }
            String[] o = o();
            String security = e.getSecurity();
            if (security == null) {
                security = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            int p3 = kotlin.collections.b.p(security, o);
            Lazy lazy17 = this.O;
            Lazy lazy18 = this.F;
            Lazy lazy19 = this.D;
            if (p3 >= 0) {
                Spinner spinner7 = (Spinner) lazy3.getValue();
                if (spinner7 != null) {
                    spinner7.setSelection(p3);
                }
                LinearLayout linearLayout = (LinearLayout) lazy19.getValue();
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                LinearLayout linearLayout2 = (LinearLayout) lazy18.getValue();
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                LinearLayout linearLayout3 = (LinearLayout) lazy17.getValue();
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                EditText editText17 = (EditText) lazy5.getValue();
                if (editText17 != null) {
                    editText17.setText(ul1.j(e.getSni()));
                }
                String fingerPrint = e.getFingerPrint();
                if (fingerPrint != null) {
                    Object value7 = this.p.getValue();
                    value7.getClass();
                    int p4 = kotlin.collections.b.p(fingerPrint, (String[]) value7);
                    Spinner spinner8 = (Spinner) this.E.getValue();
                    if (spinner8 != null) {
                        if (p4 < 0) {
                            p4 = 0;
                        }
                        spinner8.setSelection(p4);
                    }
                }
                String alpn = e.getAlpn();
                if (alpn != null) {
                    Object value8 = this.q.getValue();
                    value8.getClass();
                    int p5 = kotlin.collections.b.p(alpn, (String[]) value8);
                    Spinner spinner9 = (Spinner) this.N.getValue();
                    if (spinner9 != null) {
                        if (p5 < 0) {
                            p5 = 0;
                        }
                        spinner9.setSelection(p5);
                    }
                }
                if (yg0.a(e.getSecurity(), "tls")) {
                    LinearLayout h = h();
                    if (h != null) {
                        h.setVisibility(0);
                    }
                    Object value9 = this.o.getValue();
                    value9.getClass();
                    int p6 = kotlin.collections.b.p(String.valueOf(e.getInsecure()), (String[]) value9);
                    if (p6 >= 0 && (spinner2 = (Spinner) lazy4.getValue()) != null) {
                        spinner2.setSelection(p6);
                    }
                    LinearLayout i = i();
                    if (i != null) {
                        i.setVisibility(8);
                    }
                    LinearLayout j = j();
                    if (j != null) {
                        j.setVisibility(8);
                    }
                    LinearLayout k = k();
                    if (k != null) {
                        k.setVisibility(8);
                    }
                } else if (yg0.a(e.getSecurity(), "reality")) {
                    LinearLayout i2 = i();
                    if (i2 != null) {
                        i2.setVisibility(0);
                    }
                    EditText editText18 = (EditText) lazy13.getValue();
                    if (editText18 != null) {
                        String publicKey2 = e.getPublicKey();
                        if (publicKey2 == null) {
                            publicKey2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText18.setText(ul1.j(publicKey2));
                    }
                    LinearLayout j2 = j();
                    if (j2 != null) {
                        j2.setVisibility(0);
                    }
                    EditText editText19 = (EditText) this.S.getValue();
                    if (editText19 != null) {
                        String shortId = e.getShortId();
                        if (shortId == null) {
                            shortId = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText19.setText(ul1.j(shortId));
                    }
                    LinearLayout k2 = k();
                    if (k2 != null) {
                        k2.setVisibility(0);
                    }
                    EditText editText20 = (EditText) this.U.getValue();
                    if (editText20 != null) {
                        String spiderX = e.getSpiderX();
                        if (spiderX == null) {
                            spiderX = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        }
                        editText20.setText(ul1.j(spiderX));
                    }
                    LinearLayout h2 = h();
                    if (h2 != null) {
                        h2.setVisibility(8);
                    }
                }
            }
            String security2 = e.getSecurity();
            if (security2 == null || security2.length() == 0) {
                LinearLayout linearLayout4 = (LinearLayout) lazy19.getValue();
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = (LinearLayout) lazy18.getValue();
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                LinearLayout linearLayout6 = (LinearLayout) lazy17.getValue();
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(8);
                }
                LinearLayout h3 = h();
                if (h3 != null) {
                    h3.setVisibility(8);
                }
                LinearLayout i3 = i();
                if (i3 != null) {
                    i3.setVisibility(8);
                }
                LinearLayout j3 = j();
                if (j3 != null) {
                    j3.setVisibility(8);
                }
                LinearLayout k3 = k();
                if (k3 != null) {
                    k3.setVisibility(8);
                }
            }
            String[] n = n();
            String network = e.getNetwork();
            if (network != null) {
                str5 = network;
            }
            int p7 = kotlin.collections.b.p(str5, n);
            if (p7 >= 0 && (spinner = (Spinner) lazy2.getValue()) != null) {
                spinner.setSelection(p7);
                return;
            }
            return;
        }
        Object value10 = lazy14.getValue();
        value10.getClass();
        ((EditText) value10).setText((CharSequence) null);
        Object value11 = lazy12.getValue();
        value11.getClass();
        ((EditText) value11).setText((CharSequence) null);
        Object value12 = lazy11.getValue();
        value12.getClass();
        Regex regex2 = ul1.a;
        ((EditText) value12).setText(ul1.j("443"));
        m().setText((CharSequence) null);
        Spinner spinner10 = (Spinner) lazy6.getValue();
        if (spinner10 != null) {
            spinner10.setSelection(0);
        }
        Spinner spinner11 = (Spinner) lazy2.getValue();
        if (spinner11 != null) {
            spinner11.setSelection(0);
        }
        Spinner spinner12 = (Spinner) this.H.getValue();
        if (spinner12 != null) {
            spinner12.setSelection(0);
        }
        EditText editText21 = (EditText) this.K.getValue();
        if (editText21 != null) {
            editText21.setText((CharSequence) null);
        }
        EditText editText22 = (EditText) this.M.getValue();
        if (editText22 != null) {
            editText22.setText((CharSequence) null);
        }
        Spinner spinner13 = (Spinner) lazy3.getValue();
        if (spinner13 != null) {
            spinner13.setSelection(0);
        }
        Spinner spinner14 = (Spinner) lazy4.getValue();
        if (spinner14 != null) {
            spinner14.setSelection(0);
        }
        EditText editText23 = (EditText) lazy5.getValue();
        if (editText23 != null) {
            editText23.setText((CharSequence) null);
        }
        Spinner spinner15 = (Spinner) lazy10.getValue();
        if (spinner15 != null) {
            spinner15.setSelection(0);
        }
        EditText editText24 = (EditText) lazy13.getValue();
        if (editText24 != null) {
            editText24.setText((CharSequence) null);
        }
        EditText editText25 = (EditText) lazy9.getValue();
        if (editText25 != null) {
            editText25.setText(ul1.j("0,0,0"));
        }
        EditText editText26 = (EditText) lazy8.getValue();
        if (editText26 != null) {
            editText26.setText(ul1.j("172.16.0.2/32"));
        }
        EditText editText27 = (EditText) lazy7.getValue();
        if (editText27 != null) {
            editText27.setText(ul1.j("1420"));
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.action_server, menu);
        MenuItem findItem = menu.findItem(R.id.del_config);
        MenuItem findItem2 = menu.findItem(R.id.save_config);
        if (l().length() > 0) {
            if (((Boolean) this.d.getValue()).booleanValue()) {
                if (findItem != null) {
                    findItem.setVisible(false);
                }
                if (findItem2 != null) {
                    findItem2.setVisible(false);
                }
            }
        } else if (findItem != null) {
            findItem.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163 A[ExcHandler: Exception -> 0x0163] */
    @Override // com.v2ray.ang.ui.BaseActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onOptionsItemSelected(android.view.MenuItem r15) {
        /*
            Method dump skipped, instructions count: 1693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.ServerActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    public final String[] p(String str) {
        if (yg0.a(str, NetworkType.TCP.getType())) {
            Object value = this.k.getValue();
            value.getClass();
            return (String[]) value;
        }
        if (yg0.a(str, NetworkType.KCP.getType())) {
            Object value2 = this.l.getValue();
            value2.getClass();
            return (String[]) value2;
        }
        if (yg0.a(str, NetworkType.GRPC.getType())) {
            Object value3 = this.m.getValue();
            value3.getClass();
            return (String[]) value3;
        }
        if (yg0.a(str, NetworkType.XHTTP.getType())) {
            Object value4 = this.r.getValue();
            value4.getClass();
            return (String[]) value4;
        }
        return new String[]{"---"};
    }
}
