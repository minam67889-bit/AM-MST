package defpackage;

import android.view.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.activities.a;
import prince.dastan.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: uq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC4257uq implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ DialogC4336vq b;

    public /* synthetic */ ViewOnClickListenerC4257uq(DialogC4336vq dialogC4336vq, int i) {
        this.a = i;
        this.b = dialogC4336vq;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        DialogC4336vq dialogC4336vq = this.b;
        switch (this.a) {
            case 0:
                Set keySet = AbstractC3342jE.a.keySet();
                int size = keySet.size();
                String[] strArr = new String[size];
                Iterator it = keySet.iterator();
                int i = 0;
                while (it.hasNext()) {
                    strArr[i] = (String) it.next();
                    i++;
                }
                W00 w00 = dialogC4336vq.g;
                if (w00 != null) {
                    for (int i2 = 0; i2 < size; i2++) {
                        String str2 = strArr[i2];
                        boolean endsWith = str2.endsWith(Deobfuscator$BDNETVPN$app.getString(-41776478779275L));
                        VPNClient vPNClient = w00.a;
                        if (endsWith || str2.endsWith(Deobfuscator$BDNETVPN$app.getString(-41802248583051L))) {
                            try {
                                try {
                                    String i3 = a.i(new FileInputStream(new File(str2)));
                                    int i4 = F00.a;
                                    try {
                                        str = AbstractC4569ym.c(i3, AbstractC4569ym.a);
                                    } catch (Exception unused) {
                                        str = null;
                                    }
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(vPNClient.getFilesDir(), Deobfuscator$BDNETVPN$app.getString(-41819428452235L)));
                                    fileOutputStream.write(str.toString().getBytes());
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    vPNClient.getApplicationContext();
                                    PUtils.killProcess();
                                } catch (Exception e) {
                                    SweetToast.error(vPNClient.getApplicationContext(), String.format(Deobfuscator$BDNETVPN$app.getString(-41866673092491L), e.getClass().getName()));
                                }
                            } catch (Exception unused2) {
                                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-41961162373003L));
                            }
                        } else {
                            SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-42068536555403L));
                        }
                    }
                }
                dialogC4336vq.dismiss();
                break;
            default:
                dialogC4336vq.dismiss();
                break;
        }
    }
}
