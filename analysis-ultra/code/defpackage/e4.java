package defpackage;

import android.content.Intent;
import android.graphics.Rect;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.MaterialCheckable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iphunt.sandoki.services.AutoTaskService;
import com.iphunt.sandoki.ui.AirplaneModeActivity;
import com.iphunt.sandoki.ui.AirplaneModeViewModel;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.viewmodel.ConfigData;
import com.v2ray.ang.viewmodel.NetworkList;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.c;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e4 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e4(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List z2;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                AirplaneModeActivity airplaneModeActivity = (AirplaneModeActivity) obj;
                int i2 = AirplaneModeActivity.A;
                if (!airplaneModeActivity.m && compoundButton.isPressed()) {
                    AirplaneModeViewModel airplaneModeViewModel = airplaneModeActivity.b;
                    airplaneModeViewModel.b.edit().putBoolean("auto_toggle_enabled", z).apply();
                    airplaneModeViewModel.d.k(Boolean.valueOf(z));
                    airplaneModeActivity.b.b.getBoolean("control_mode_secure", false);
                    if (z) {
                        airplaneModeActivity.j();
                        return;
                    } else {
                        airplaneModeActivity.stopService(new Intent(airplaneModeActivity, (Class<?>) AutoTaskService.class));
                        Toast.makeText(airplaneModeActivity, "Background auto task stopped", 0).show();
                        return;
                    }
                }
                return;
            case 1:
                Chip chip = (Chip) obj;
                Rect rect = Chip.x;
                MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener = chip.j;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(chip, z);
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = chip.i;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(compoundButton, z);
                    return;
                }
                return;
            default:
                HomeFragment homeFragment = (HomeFragment) obj;
                Gson gson = homeFragment.F0;
                int i3 = HomeFragment.f2;
                compoundButton.getClass();
                Lazy lazy = zq0.a;
                zq0.u().k("COnfigSwitch", z);
                if (z) {
                    Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("*/*");
                    intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/x-ultra", "application/octet-stream"});
                    homeFragment.i1.a(intent);
                    return;
                }
                if (qf3.C(zq0.u().d("ConfigFile"))) {
                    zq0.u().o("ConfigFile");
                }
                if (qf3.C(zq0.u().d("OwnTweak"))) {
                    String d = zq0.u().d("OwnTweak");
                    Type type = new TypeToken<List<? extends NetworkList>>() { // from class: com.v2ray.ang.ui.HomeFragment$initViews$5$listType$1
                    }.b;
                    try {
                        gson.getClass();
                        Object c = gson.c(d, new TypeToken(type));
                        c.getClass();
                        z2 = (List) c;
                    } catch (Exception unused) {
                        TypeToken<NetworkList> typeToken = new TypeToken<NetworkList>() { // from class: com.v2ray.ang.ui.HomeFragment$initViews$5$ownList$singleType$1
                        };
                        gson.getClass();
                        z2 = c.z((NetworkList) gson.c(d, new TypeToken(typeToken.b)));
                    }
                    ConfigData configValue = homeFragment.e0().getConfigValue();
                    configValue.getClass();
                    homeFragment.H0 = c.C(configValue.getNetworks(), z2);
                    return;
                }
                ConfigData configValue2 = homeFragment.e0().getConfigValue();
                configValue2.getClass();
                homeFragment.H0 = configValue2.getNetworks();
                return;
        }
    }
}
