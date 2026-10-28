package ads_mobile_sdk;

import defpackage.InterfaceC0779b60;

/* loaded from: classes.dex */
public final class rd implements InterfaceC0779b60 {
    public static final rd a = new rd();

    @Override // defpackage.InterfaceC0779b60
    public final boolean a(int i) {
        sd sdVar;
        switch (i) {
            case 0:
                sdVar = sd.UNKNOWN_ENCRYPTION_METHOD;
                break;
            case 1:
                sdVar = sd.BITSLICER;
                break;
            case 2:
                sdVar = sd.TINK_HYBRID;
                break;
            case 3:
                sdVar = sd.UNENCRYPTED;
                break;
            case 4:
                sdVar = sd.DG;
                break;
            case 5:
                sdVar = sd.DG_XTEA;
                break;
            case 6:
                sdVar = sd.ADSHIELD_3;
                break;
            default:
                sdVar = null;
                break;
        }
        return sdVar != null;
    }
}
