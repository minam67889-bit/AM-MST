package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import defpackage.AbstractC3855m4;
import defpackage.AbstractC4753xk;
import defpackage.D0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.achartengine.renderer.DefaultRenderer;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
    public int a;
    public Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public String i;
    public String j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IconCompat() {
        this.a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(DefaultRenderer.BACKGROUND_COLOR);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static IconCompat b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.e = i;
        iconCompat.b = "";
        iconCompat.j = "";
        return iconCompat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int c() {
        int i = this.a;
        if (i != -1) {
            if (i == 2) {
                return this.e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.b;
        if (i2 >= 28) {
            return AbstractC4753xk.e(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int d() {
        StringBuilder sb;
        int i = this.a;
        if (i != -1) {
            return i;
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.b;
        if (i2 >= 28) {
            return AbstractC4753xk.m(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder("Unable to get icon type ");
            sb.append(obj);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (NoSuchMethodException e2) {
            e = e2;
            sb = new StringBuilder("Unable to get icon type ");
            sb.append(obj);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (InvocationTargetException e3) {
            e = e3;
            sb = new StringBuilder("Unable to get icon type ");
            sb.append(obj);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri e() {
        int i = this.a;
        if (i != -1) {
            if (i == 4 || i == 6) {
                return Uri.parse((String) this.b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.b;
        if (i2 >= 28) {
            return AbstractC4753xk.n(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:
    
        if (r0 >= 26) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Icon f(Context context) {
        Bitmap bitmap;
        Icon createWithResource;
        Bitmap bitmap2;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        StringBuilder sb;
        int i = Build.VERSION.SDK_INT;
        int i2 = this.a;
        String str = null;
        InputStream openInputStream = null;
        switch (i2) {
            case -1:
                return (Icon) this.b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                bitmap = (Bitmap) this.b;
                createWithResource = Icon.createWithBitmap(bitmap);
                colorStateList = this.g;
                if (colorStateList != null) {
                    createWithResource.setTintList(colorStateList);
                }
                mode = this.h;
                if (mode == k) {
                    return createWithResource;
                }
                createWithResource.setTintMode(mode);
                return createWithResource;
            case 2:
                if (i2 == -1) {
                    Object obj = this.b;
                    if (i >= 28) {
                        str = AbstractC4753xk.f(obj);
                    } else {
                        try {
                            str = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                            Log.e("IconCompat", "Unable to get icon package", e);
                        }
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    String str2 = this.j;
                    str = (str2 == null || TextUtils.isEmpty(str2)) ? ((String) this.b).split(":", -1)[0] : this.j;
                }
                createWithResource = Icon.createWithResource(str, this.e);
                colorStateList = this.g;
                if (colorStateList != null) {
                }
                mode = this.h;
                if (mode == k) {
                }
                break;
            case 3:
                createWithResource = Icon.createWithData((byte[]) this.b, this.e, this.f);
                colorStateList = this.g;
                if (colorStateList != null) {
                }
                mode = this.h;
                if (mode == k) {
                }
                break;
            case 4:
                createWithResource = Icon.createWithContentUri((String) this.b);
                colorStateList = this.g;
                if (colorStateList != null) {
                }
                mode = this.h;
                if (mode == k) {
                }
                break;
            case 5:
                bitmap2 = (Bitmap) this.b;
                break;
            case 6:
                if (i >= 30) {
                    createWithResource = D0.a(e());
                    colorStateList = this.g;
                    if (colorStateList != null) {
                    }
                    mode = this.h;
                    if (mode == k) {
                    }
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                    }
                    Uri e2 = e();
                    String scheme = e2.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            openInputStream = context.getContentResolver().openInputStream(e2);
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder("Unable to load image from URI: ");
                            sb.append(e2);
                            Log.w("IconCompat", sb.toString(), e);
                            if (openInputStream == null) {
                            }
                        }
                    } else {
                        try {
                            openInputStream = new FileInputStream(new File((String) this.b));
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            sb = new StringBuilder("Unable to load image from path: ");
                            sb.append(e2);
                            Log.w("IconCompat", sb.toString(), e);
                            if (openInputStream == null) {
                            }
                        }
                    }
                    if (openInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        bitmap2 = BitmapFactory.decodeStream(openInputStream);
                        createWithResource = AbstractC3855m4.b(bitmap2);
                        colorStateList = this.g;
                        if (colorStateList != null) {
                        }
                        mode = this.h;
                        if (mode == k) {
                        }
                    } else {
                        bitmap2 = BitmapFactory.decodeStream(openInputStream);
                        bitmap = a(bitmap2, false);
                        createWithResource = Icon.createWithBitmap(bitmap);
                        colorStateList = this.g;
                        if (colorStateList != null) {
                        }
                        mode = this.h;
                        if (mode == k) {
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String str;
        int height;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    height = this.f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IconCompat(int i) {
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = k;
        this.i = null;
        this.a = i;
    }
}
