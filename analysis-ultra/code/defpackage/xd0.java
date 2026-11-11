package defpackage;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import co.strongteam.ultra.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.iphunt.sandoki.ui.AirplaneModeActivity;
import com.v2ray.ang.Hometab;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.ui.LogsFragment;
import com.v2ray.ang.ui.ServerStatusVIew;
import com.v2ray.ang.ui.SettingsActivity;
import com.v2ray.ang.util.MainActivityWifi;
import com.v2ray.ang.viewmodel.ConfigData;
import kotlin.text.g;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class xd0 implements Toolbar.OnMenuItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    public final /* synthetic */ Hometab a;

    public /* synthetic */ xd0(Hometab hometab) {
        this.a = hometab;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        LogsFragment logsFragment;
        String str;
        Hometab.Companion companion = Hometab.n;
        int itemId = menuItem.getItemId();
        Hometab hometab = this.a;
        HomeFragment homeFragment = null;
        String str2 = null;
        HomeFragment homeFragment2 = null;
        switch (itemId) {
            case R.id.action_clear_logs /* 2131296326 */:
                Fragment C = hometab.getSupportFragmentManager().C("f1");
                if (C instanceof LogsFragment) {
                    logsFragment = (LogsFragment) C;
                } else {
                    logsFragment = null;
                }
                if (logsFragment != null) {
                    logsFragment.a0.clear();
                    om0 om0Var = logsFragment.Z;
                    if (om0Var != null) {
                        om0Var.notifyDataSetChanged();
                        return true;
                    }
                    yg0.N("adapter");
                    throw null;
                }
                return true;
            case R.id.addserver /* 2131296345 */:
                Fragment C2 = hometab.getSupportFragmentManager().C("f0");
                if (C2 instanceof HomeFragment) {
                    homeFragment = (HomeFragment) C2;
                }
                if (homeFragment != null) {
                    homeFragment.X();
                    return true;
                }
                return true;
            case R.id.addtweaks /* 2131296346 */:
                Fragment C3 = hometab.getSupportFragmentManager().C("f0");
                if (C3 instanceof HomeFragment) {
                    homeFragment2 = (HomeFragment) C3;
                }
                if (homeFragment2 != null) {
                    homeFragment2.Y();
                    return true;
                }
                return true;
            case R.id.releaseNotes /* 2131296963 */:
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(hometab);
                materialAlertDialogBuilder.h("OK", new k(3));
                AlertController.AlertParams alertParams = materialAlertDialogBuilder.a;
                alertParams.c = R.drawable.icon;
                alertParams.e = "Release Notes";
                ConfigData i = hometab.i();
                if (i != null) {
                    str = i.getVersion();
                } else {
                    str = null;
                }
                ConfigData i2 = hometab.i();
                if (i2 != null) {
                    str2 = i2.getReleaseNotes();
                }
                alertParams.g = hz.v("Version ", str, " \n\n", str2);
                alertParams.l = false;
                materialAlertDialogBuilder.a().show();
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        HomeFragment homeFragment;
        HomeFragment homeFragment2;
        String str;
        Hometab.Companion companion = Hometab.n;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        final int i = 1;
        final Hometab hometab = this.a;
        switch (itemId) {
            case R.id.nav_addserver /* 2131296848 */:
                Fragment C = hometab.getSupportFragmentManager().C("f0");
                if (C instanceof HomeFragment) {
                    homeFragment = (HomeFragment) C;
                } else {
                    homeFragment = null;
                }
                if (homeFragment != null) {
                    homeFragment.X();
                    break;
                }
                break;
            case R.id.nav_addtweak /* 2131296849 */:
                Fragment C2 = hometab.getSupportFragmentManager().C("f0");
                if (C2 instanceof HomeFragment) {
                    homeFragment2 = (HomeFragment) C2;
                } else {
                    homeFragment2 = null;
                }
                if (homeFragment2 != null) {
                    homeFragment2.Y();
                    break;
                }
                break;
            case R.id.nav_clearData /* 2131296850 */:
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(hometab);
                AlertController.AlertParams alertParams = materialAlertDialogBuilder.a;
                alertParams.c = R.mipmap.ic_launcher_round;
                alertParams.e = "Clear Setting/data";
                alertParams.g = "Are you sure you want to reset all the data?";
                materialAlertDialogBuilder.h("Yes", new DialogInterface.OnClickListener() { // from class: ud0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        int i3 = i;
                        Hometab hometab2 = hometab;
                        switch (i3) {
                            case 0:
                                Hometab.Companion companion2 = Hometab.n;
                                dialogInterface.dismiss();
                                hometab2.recreate();
                                return;
                            default:
                                Hometab.Companion companion3 = Hometab.n;
                                try {
                                    Object systemService = hometab2.getSystemService("activity");
                                    systemService.getClass();
                                    ((ActivityManager) systemService).clearApplicationUserData();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                        }
                    }
                });
                materialAlertDialogBuilder.g("No", null);
                materialAlertDialogBuilder.f();
                break;
            case R.id.nav_exit /* 2131296852 */:
                hometab.finish();
                break;
            case R.id.nav_iphunt /* 2131296856 */:
                if (!ul1.f(hometab).equals("Mobile")) {
                    qf3.N(hometab, "Works only on Mobile Data");
                    break;
                } else {
                    hometab.startActivity(new Intent(hometab, (Class<?>) AirplaneModeActivity.class));
                    break;
                }
            case R.id.nav_jointele /* 2131296857 */:
                ConfigData i2 = hometab.i();
                if (i2 != null) {
                    str = i2.getTelegram();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    String obj = g.c0(g.V(str, "/")).toString();
                    if (obj.length() == 0) {
                        qf3.N(hometab, "Invalid Telegram link");
                        break;
                    } else {
                        Uri parse = Uri.parse("tg://resolve?domain=".concat(obj));
                        Uri parse2 = Uri.parse(str);
                        try {
                            hometab.startActivity(new Intent("android.intent.action.VIEW", parse));
                            break;
                        } catch (ActivityNotFoundException e) {
                            e.getMessage();
                            hometab.startActivity(new Intent("android.intent.action.VIEW", parse2));
                            break;
                        }
                    }
                } else {
                    qf3.N(hometab, "No Telegram link configured");
                    break;
                }
                break;
            case R.id.nav_serverStatus /* 2131296859 */:
                hometab.startActivity(new Intent(hometab, (Class<?>) ServerStatusVIew.class));
                break;
            case R.id.nav_tethering /* 2131296860 */:
                hometab.startActivity(new Intent(hometab, (Class<?>) MainActivityWifi.class));
                break;
            case R.id.nav_updateNotes /* 2131296861 */:
                ConfigData i3 = hometab.i();
                i3.getClass();
                String releaseNotes = i3.getReleaseNotes();
                ConfigData i4 = hometab.i();
                i4.getClass();
                String version = i4.getVersion();
                MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(hometab);
                final int i5 = 0;
                materialAlertDialogBuilder2.h("OK", new DialogInterface.OnClickListener() { // from class: ud0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i22) {
                        int i32 = i5;
                        Hometab hometab2 = hometab;
                        switch (i32) {
                            case 0:
                                Hometab.Companion companion2 = Hometab.n;
                                dialogInterface.dismiss();
                                hometab2.recreate();
                                return;
                            default:
                                Hometab.Companion companion3 = Hometab.n;
                                try {
                                    Object systemService = hometab2.getSystemService("activity");
                                    systemService.getClass();
                                    ((ActivityManager) systemService).clearApplicationUserData();
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                        }
                    }
                });
                AlertController.AlertParams alertParams2 = materialAlertDialogBuilder2.a;
                alertParams2.c = R.drawable.icon;
                alertParams2.e = "New Update";
                alertParams2.g = hz.v("Version ", version, " \n\n", releaseNotes);
                alertParams2.l = false;
                materialAlertDialogBuilder2.a().show();
                break;
            case R.id.nav_v2raySettings /* 2131296862 */:
                hometab.startActivity(new Intent(hometab, (Class<?>) SettingsActivity.class));
                break;
        }
        DrawerLayout drawerLayout = hometab.d;
        if (drawerLayout != null) {
            drawerLayout.d();
            return true;
        }
        yg0.N("drawerLayout");
        throw null;
    }
}
