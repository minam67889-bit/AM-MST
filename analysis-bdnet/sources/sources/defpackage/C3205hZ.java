package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* renamed from: hZ, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3205hZ extends AbstractC0199Hh {
    public static Font g0(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int j0 = j0(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int j02 = j0(fontStyle, font2.getStyle());
            if (j02 < j0) {
                font = font2;
                j0 = j02;
            }
        }
        return font;
    }

    public static int j0(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // defpackage.AbstractC0199Hh
    public final Typeface A(Context context, C0054Bs c0054Bs, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (C0080Cs c0080Cs : c0054Bs.a) {
                try {
                    Font build = new Font.Builder(resources, c0080Cs.f).setWeight(c0080Cs.b).setSlant(c0080Cs.c ? 1 : 0).setTtcIndex(c0080Cs.e).setFontVariationSettings(c0080Cs.d).build();
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
            return new Typeface.CustomFallbackBuilder(build2).setStyle(g0(build2, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.AbstractC0199Hh
    public final Typeface B(Context context, C0132Es[] c0132EsArr, int i) {
        try {
            FontFamily h0 = h0(c0132EsArr, context.getContentResolver());
            if (h0 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(h0).setStyle(g0(h0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.AbstractC0199Hh
    public final Typeface C(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily h0 = h0((C0132Es[]) list.get(0), contentResolver);
            if (h0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(h0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily h02 = h0((C0132Es[]) list.get(i2), contentResolver);
                if (h02 != null) {
                    customFallbackBuilder.addCustomFallback(h02);
                }
            }
            return customFallbackBuilder.setStyle(g0(h0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // defpackage.AbstractC0199Hh
    public final Typeface D(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    public final FontFamily h0(C0132Es[] c0132EsArr, ContentResolver contentResolver) {
        Font font;
        String str;
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (C0132Es c0132Es : c0132EsArr) {
            if (Objects.equals(c0132Es.a.getScheme(), "systemfont")) {
                font = i0(c0132Es);
            } else {
                try {
                    Uri uri = c0132Es.a;
                    str = c0132Es.e;
                    openFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    font = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(openFileDescriptor).setWeight(c0132Es.c).setSlant(c0132Es.d ? 1 : 0).setTtcIndex(c0132Es.b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        font = ttcIndex.build();
                        openFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (font != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(font);
                } else {
                    builder.addFont(font);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font i0(C0132Es c0132Es) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }
}
