package defpackage;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class QG {
    public static final SparseArray a;
    public static final /* synthetic */ QG[] b;

    /* JADX INFO: Fake field, exist only in values array */
    QG EF15;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        QG qg = new QG("MOBILE", 0);
        QG qg2 = new QG("WIFI", 1);
        QG qg3 = new QG("MOBILE_MMS", 2);
        QG qg4 = new QG("MOBILE_SUPL", 3);
        QG qg5 = new QG("MOBILE_DUN", 4);
        QG qg6 = new QG("MOBILE_HIPRI", 5);
        QG qg7 = new QG("WIMAX", 6);
        QG qg8 = new QG("BLUETOOTH", 7);
        QG qg9 = new QG("DUMMY", 8);
        QG qg10 = new QG("ETHERNET", 9);
        QG qg11 = new QG("MOBILE_FOTA", 10);
        QG qg12 = new QG("MOBILE_IMS", 11);
        QG qg13 = new QG("MOBILE_CBS", 12);
        QG qg14 = new QG("WIFI_P2P", 13);
        QG qg15 = new QG("MOBILE_IA", 14);
        QG qg16 = new QG("MOBILE_EMERGENCY", 15);
        QG qg17 = new QG("PROXY", 16);
        QG qg18 = new QG("VPN", 17);
        QG qg19 = new QG("NONE", 18);
        b = new QG[]{qg, qg2, qg3, qg4, qg5, qg6, qg7, qg8, qg9, qg10, qg11, qg12, qg13, qg14, qg15, qg16, qg17, qg18, qg19};
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, qg);
        sparseArray.put(1, qg2);
        sparseArray.put(2, qg3);
        sparseArray.put(3, qg4);
        sparseArray.put(4, qg5);
        sparseArray.put(5, qg6);
        sparseArray.put(6, qg7);
        sparseArray.put(7, qg8);
        sparseArray.put(8, qg9);
        sparseArray.put(9, qg10);
        sparseArray.put(10, qg11);
        sparseArray.put(11, qg12);
        sparseArray.put(12, qg13);
        sparseArray.put(13, qg14);
        sparseArray.put(14, qg15);
        sparseArray.put(15, qg16);
        sparseArray.put(16, qg17);
        sparseArray.put(17, qg18);
        sparseArray.put(-1, qg19);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static QG valueOf(String str) {
        return (QG) Enum.valueOf(QG.class, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static QG[] values() {
        return (QG[]) b.clone();
    }
}
