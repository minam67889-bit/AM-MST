package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.MediaItem;
import com.facebook.ads.androidx.media3.common.StreamKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Kr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public class C1417Kr {
    public static byte[] A09;
    public static String[] A0A = {"7j90bvDgzfqlbEzjggDQ0tumMor6c39i", "DS0qTicpuqrJa9y9APE8xKGZ6jqQq7hO", "bwLao16ozlkyPtnb", "bRC4ZhduoY1TeWH0dmwLqNCKAYzjc2JB", "irlYSgmKLq9oPIhMA3nXv4gxbR5AW4t9", "JOkP9gpRTqL", "j5a18SEnqhhuje8BlWMjgWFu1IOx9", "b3FjBYI8XOmFEVpNdTc0"};
    public final Uri A00;
    public final C1408Ki A01;
    public final C1413Kn A02;
    public final Object A03;
    public final String A04;
    public final String A05;
    public final List<StreamKey> A06;
    public final List<MediaItem.SubtitleConfiguration> A07;

    @Deprecated
    public final List<MediaItem.Subtitle> A08;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{25, 14, 18, 23, 31, 46, 11, 20, 21, 85, 92, 78, 85, 126, 82, 89, 88};
    }

    static {
        A01();
    }

    public C1417Kr(Uri uri, String str, C1413Kn c1413Kn, C1408Ki c1408Ki, List<StreamKey> streamKeys, String str2, List<MediaItem.SubtitleConfiguration> subtitleConfigurations, Object obj) {
        this.A00 = uri;
        this.A05 = str;
        this.A02 = c1413Kn;
        this.A01 = c1408Ki;
        this.A06 = streamKeys;
        this.A04 = str2;
        this.A07 = subtitleConfigurations;
        LinkedList linkedList = new LinkedList();
        if (0 < subtitleConfigurations.size()) {
            subtitleConfigurations.get(0);
            throw new NullPointerException(A00(0, 9, 11));
        }
        List<MediaItem.Subtitle> subtitles = new ArrayList<>(linkedList);
        this.A08 = subtitles;
        this.A03 = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1417Kr)) {
            return false;
        }
        C1417Kr c1417Kr = (C1417Kr) obj;
        if (this.A00.equals(c1417Kr.A00) && N1.A1E(this.A05, c1417Kr.A05) && N1.A1E(this.A02, c1417Kr.A02)) {
            boolean A1E = N1.A1E(null, null);
            String[] strArr = A0A;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[0] = "JgPeis42D24zQ58EqafXIiwjhwvhcCAP";
            strArr2[3] = "ddAeIVnYKwqulpmkyZHCntWoZZj3cr7e";
            if (A1E && this.A06.equals(c1417Kr.A06) && N1.A1E(this.A04, c1417Kr.A04) && this.A07.equals(c1417Kr.A07) && N1.A1E(this.A03, c1417Kr.A03)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A00.hashCode();
        int i = result * 31;
        int result2 = this.A05 == null ? 0 : this.A05.hashCode();
        int result3 = (((i + result2) * 31) + (this.A02 == null ? 0 : this.A02.hashCode())) * 31;
        if (0 == 0) {
            int result4 = (((result3 + 0) * 31) + this.A06.hashCode()) * 31;
            int result5 = this.A04 == null ? 0 : this.A04.hashCode();
            return ((((result4 + result5) * 31) + this.A07.hashCode()) * 31) + (this.A03 != null ? this.A03.hashCode() : 0);
        }
        throw new NullPointerException(A00(9, 8, 77));
    }
}
