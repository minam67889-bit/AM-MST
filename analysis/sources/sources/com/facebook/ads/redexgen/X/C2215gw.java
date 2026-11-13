package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* renamed from: com.facebook.ads.redexgen.X.gw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C2215gw {
    public static C2215gw A05;
    public static byte[] A06;
    public static final Object A07;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<C2214gv>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<C2214gv>> A03 = new HashMap<>();
    public final ArrayList<C2213gu> A02 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 80);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-116, -116, -78, -43, -40, -32, -47, -34, -116, -48, -43, -48, -116, -38, -37, -32, -116, -39, -51, -32, -49, -44, -90, -116, -111, -111, -73, -38, -35, -27, -42, -29, -111, -34, -46, -27, -44, -39, -42, -43, -110, -111, -111, -34, -46, -27, -44, -39, -82, -95, -23, -102, -23, -32, -102, -29, -24, -18, -33, -24, -18, -102, 126, -47, -63, -58, -61, -53, -61, 126, -88, -54, -37, -48, -42, -43, -121, -45, -48, -38, -37, -95, -121, 27, 62, 50, 48, 59, 17, 65, 62, 48, 51, 50, 48, 66, 67, 28, 48, 61, 48, 54, 52, 65, -51, -31, -12, -29, -24, -23, -18, -25, -96, -31, -25, -31, -23, -18, -13, -12, -96, -26, -23, -20, -12, -27, -14, -96, -80, -61, -47, -51, -54, -44, -57, -52, -59, 126, -46, -41, -50, -61, 126, -19, -17, 0, -11, -5, -6, -3, -5, 14, -1, 1, 9, 12, 19, 9, 6, 25, 6, 29, 34, 25, 14, -53, -60, -63, -60, -59, -51, -60, 118, -56, -69, -73, -55, -59, -60};
    }

    static {
        A03();
        A07 = new Object();
    }

    public C2215gw(Context context) {
        this.A00 = context;
        this.A01 = new HandlerC2212gt(this, context.getMainLooper());
    }

    public static C2215gw A00(Context context) {
        C2215gw c2215gw;
        synchronized (A07) {
            if (A05 == null) {
                A05 = new C2215gw(context.getApplicationContext());
            }
            c2215gw = A05;
        }
        return c2215gw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:10:0x001c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A02() {
        C2213gu[] c2213guArr;
        while (true) {
            synchronized (this.A04) {
                int size = this.A02.size();
                if (size > 0) {
                    c2213guArr = new C2213gu[size];
                    this.A02.toArray(c2213guArr);
                    this.A02.clear();
                } else {
                    return;
                }
            }
            for (C2213gu c2213gu : c2213guArr) {
                int j = c2213gu.A01.size();
                for (int nbr = 0; nbr < j; nbr++) {
                    C2214gv c2214gv = c2213gu.A01.get(nbr);
                    if (!c2214gv.A01) {
                        c2214gv.A02.onReceive(this.A00, c2213gu.A00);
                    }
                }
            }
        }
    }

    public final void A05(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<C2214gv> remove = this.A04.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                C2214gv c2214gv = remove.get(size);
                c2214gv.A01 = true;
                for (int j = 0; j < c2214gv.A03.countActions(); j++) {
                    String action = c2214gv.A03.getAction(j);
                    ArrayList<C2214gv> arrayList = this.A03.get(action);
                    if (arrayList != null) {
                        int i = arrayList.size();
                        for (int i2 = i - 1; i2 >= 0; i2--) {
                            C2214gv c2214gv2 = arrayList.get(i2);
                            if (c2214gv2.A02 == broadcastReceiver) {
                                c2214gv2.A01 = true;
                                arrayList.remove(i2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.A03.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void A06(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            C2214gv c2214gv = new C2214gv(intentFilter, broadcastReceiver);
            ArrayList<C2214gv> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c2214gv);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C2214gv> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(c2214gv);
            }
        }
    }

    public final boolean A07(Intent intent) {
        String A01;
        synchronized (this.A04) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.A00.getContentResolver());
            Uri data = intent.getData();
            String action2 = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean debug = (intent.getFlags() & 8) != 0;
            if (debug) {
                StringBuilder sb = new StringBuilder();
                String type = A01(UserVerificationMethods.USER_VERIFY_PATTERN, 15, 14);
                StringBuilder append = sb.append(type).append(resolveTypeIfNeeded);
                String type2 = A01(62, 8, 14);
                StringBuilder append2 = append.append(type2).append(action2);
                String type3 = A01(51, 11, 42);
                append2.append(type3).append(intent).toString();
            }
            HashMap<String, ArrayList<C2214gv>> hashMap = this.A03;
            String type4 = intent.getAction();
            ArrayList<C2214gv> arrayList = hashMap.get(type4);
            if (arrayList != null) {
                if (debug) {
                    StringBuilder sb2 = new StringBuilder();
                    String type5 = A01(70, 13, 23);
                    sb2.append(type5).append(arrayList).toString();
                }
                ArrayList arrayList2 = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    C2214gv c2214gv = arrayList.get(i);
                    if (debug) {
                        StringBuilder sb3 = new StringBuilder();
                        String type6 = A01(104, 24, 48);
                        sb3.append(type6).append(c2214gv.A03).toString();
                    }
                    if (!c2214gv.A00) {
                        int match = c2214gv.A03.match(action, resolveTypeIfNeeded, action2, data, categories, A01(83, 21, ScopedSysTraceEvent.MAX_SECTION_NAME_LEN));
                        if (match >= 0) {
                            if (debug) {
                                String str = A01(24, 27, 33) + Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(c2214gv);
                            c2214gv.A00 = true;
                        } else if (debug) {
                            switch (match) {
                                case -4:
                                    A01 = A01(149, 8, 74);
                                    break;
                                case -3:
                                    A01 = A01(143, 6, 60);
                                    break;
                                case -2:
                                    A01 = A01(157, 4, 85);
                                    break;
                                case -1:
                                    A01 = A01(161, 4, 89);
                                    break;
                                default:
                                    A01 = A01(165, 14, 6);
                                    break;
                            }
                            String str2 = A01(0, 24, 28) + A01;
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((C2214gv) arrayList2.get(i2)).A00 = false;
                    }
                    this.A02.add(new C2213gu(intent, arrayList2));
                    if (!this.A01.hasMessages(1)) {
                        this.A01.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
