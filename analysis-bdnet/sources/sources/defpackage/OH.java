package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class OH {
    public static final SparseArray a;
    public static final /* synthetic */ OH[] b;

    /* JADX INFO: Fake field, exist only in values array */
    OH EF1;

    static {
        OH oh = new OH("MOBILE", 0);
        OH oh2 = new OH("WIFI", 1);
        OH oh3 = new OH("MOBILE_MMS", 2);
        OH oh4 = new OH("MOBILE_SUPL", 3);
        OH oh5 = new OH("MOBILE_DUN", 4);
        OH oh6 = new OH("MOBILE_HIPRI", 5);
        OH oh7 = new OH("WIMAX", 6);
        OH oh8 = new OH("BLUETOOTH", 7);
        OH oh9 = new OH("DUMMY", 8);
        OH oh10 = new OH("ETHERNET", 9);
        OH oh11 = new OH("MOBILE_FOTA", 10);
        OH oh12 = new OH("MOBILE_IMS", 11);
        OH oh13 = new OH("MOBILE_CBS", 12);
        OH oh14 = new OH("WIFI_P2P", 13);
        OH oh15 = new OH("MOBILE_IA", 14);
        OH oh16 = new OH("MOBILE_EMERGENCY", 15);
        OH oh17 = new OH("PROXY", 16);
        OH oh18 = new OH("VPN", 17);
        OH oh19 = new OH("NONE", 18);
        b = new OH[]{oh, oh2, oh3, oh4, oh5, oh6, oh7, oh8, oh9, oh10, oh11, oh12, oh13, oh14, oh15, oh16, oh17, oh18, oh19};
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, oh);
        sparseArray.put(1, oh2);
        sparseArray.put(2, oh3);
        sparseArray.put(3, oh4);
        sparseArray.put(4, oh5);
        sparseArray.put(5, oh6);
        sparseArray.put(6, oh7);
        sparseArray.put(7, oh8);
        sparseArray.put(8, oh9);
        sparseArray.put(9, oh10);
        sparseArray.put(10, oh11);
        sparseArray.put(11, oh12);
        sparseArray.put(12, oh13);
        sparseArray.put(13, oh14);
        sparseArray.put(14, oh15);
        sparseArray.put(15, oh16);
        sparseArray.put(16, oh17);
        sparseArray.put(17, oh18);
        sparseArray.put(-1, oh19);
    }

    public static OH valueOf(String str) {
        return (OH) Enum.valueOf(OH.class, str);
    }

    public static OH[] values() {
        return (OH[]) b.clone();
    }
}
