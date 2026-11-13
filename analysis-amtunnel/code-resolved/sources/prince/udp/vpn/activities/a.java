package prince.udp.vpn.activities;

import android.os.Bundle;
import defpackage.AbstractActivityC0513c2;
import defpackage.AbstractC2866kI;
import defpackage.AbstractC3622yh;
import defpackage.RI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.PDoQService;

/* loaded from: classes2.dex */
public abstract class a extends AbstractActivityC0513c2 {
    public PDoQService b;
    public RI c;

    static {
        "UDPClientBase";
    }

    public final JSONObject e() {
        String str;
        String str2;
        File file = new File(getFilesDir().getAbsolutePath() + "/janny.json");
        try {
            if (!file.exists()) {
                try {
                    str = AbstractC3622yh.c(AbstractC2866kI.M(getApplicationContext(), "janny.json"), AbstractC3622yh.a);
                } catch (Exception unused) {
                    str = null;
                }
                return new JSONObject(str);
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr, 0, 1024);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception unused2) {
            }
            try {
                str2 = AbstractC3622yh.c(sb.toString(), AbstractC3622yh.a);
            } catch (Exception unused3) {
                str2 = null;
            }
            return new JSONObject(str2);
        } catch (Exception e) {
            f("Json: " + e.getMessage());
            return null;
        }
    }

    public abstract void f(String str);

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC0225Oa, defpackage.AbstractActivityC0210Na, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
