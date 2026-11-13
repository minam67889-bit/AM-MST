package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: mY, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3891mY extends AbstractC4817ya0 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Font h0(FontFamily fontFamily, int i) {
        int i2;
        int i3;
        if ((i & 1) != 0) {
            i2 = 700;
        } else {
            i2 = 400;
        }
        if ((i & 2) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        FontStyle fontStyle = new FontStyle(i2, i3);
        Font font = fontFamily.getFont(0);
        int j0 = j0(fontStyle, font.getStyle());
        for (int i4 = 1; i4 < fontFamily.getSize(); i4++) {
            Font font2 = fontFamily.getFont(i4);
            int j02 = j0(fontStyle, font2.getStyle());
            if (j02 < j0) {
                font = font2;
                j0 = j02;
            }
        }
        return font;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FontFamily i0(C0773as[] c0773asArr, ContentResolver contentResolver) {
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (C0773as c0773as : c0773asArr) {
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(c0773as.a, "r", null);
            } catch (IOException e) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            }
            if (openFileDescriptor == null) {
                if (openFileDescriptor == null) {
                }
            } else {
                try {
                    Font build = new Font.Builder(openFileDescriptor).setWeight(c0773as.c).setSlant(c0773as.d ? 1 : 0).setTtcIndex(c0773as.b).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (Throwable th) {
                    try {
                        openFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            openFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int j0(FontStyle fontStyle, FontStyle fontStyle2) {
        int i;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i = 0;
        } else {
            i = 2;
        }
        return abs + i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final C0773as D(C0773as[] c0773asArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface u(Context context, C0631Xr c0631Xr, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (C0657Yr c0657Yr : c0631Xr.a) {
                try {
                    Font build = new Font.Builder(resources, c0657Yr.f).setWeight(c0657Yr.b).setSlant(c0657Yr.c ? 1 : 0).setTtcIndex(c0657Yr.e).setFontVariationSettings(c0657Yr.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(h0(build2, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface v(Context context, C0773as[] c0773asArr, int i) {
        try {
            FontFamily i0 = i0(c0773asArr, context.getContentResolver());
            if (i0 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(i0).setStyle(h0(i0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface w(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily i0 = i0((C0773as[]) list.get(0), contentResolver);
            if (i0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(i0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily i02 = i0((C0773as[]) list.get(i2), contentResolver);
                if (i02 != null) {
                    customFallbackBuilder.addCustomFallback(i02);
                }
            }
            return customFallbackBuilder.setStyle(h0(i0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface x(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface y(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }
}
