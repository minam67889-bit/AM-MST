package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import app.vpn.amtunnellite.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class XT {
    public final int a;
    public final ER b;
    public final int[][] c;
    public final ER[] d;
    public final VT e;
    public final VT f;
    public final VT g;
    public final VT h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public XT(WT wt) {
        this.a = wt.a;
        this.b = wt.b;
        this.c = wt.c;
        this.d = wt.d;
        this.e = wt.e;
        this.f = wt.f;
        this.g = wt.g;
        this.h = wt.h;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(WT wt, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainStyledAttributes;
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                int depth2 = xmlResourceParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                        Resources resources = context.getResources();
                        int[] iArr = CL.t;
                        if (theme == null) {
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, iArr);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                        }
                        ER a = ER.a(context, obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), new C3540i(0)).a();
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr2 = new int[attributeCount];
                        int i = 0;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                            if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                                int i3 = i + 1;
                                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr2[i] = attributeNameResource;
                                i = i3;
                            }
                        }
                        wt.a(StateSet.trimStateSet(iArr2, i), a);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static XT b(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        WT wt = new WT();
        wt.c();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            wt.c();
        }
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                if (xml.getName().equals("selector")) {
                    a(wt, context, xml, asAttributeSet, context.getTheme());
                }
                xml.close();
                return wt.b();
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable th) {
            if (xml != null) {
                try {
                    xml.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ER c() {
        ER er = this.b;
        VT vt = this.h;
        VT vt2 = this.g;
        VT vt3 = this.f;
        VT vt4 = this.e;
        if (vt4 == null && vt3 == null && vt2 == null && vt == null) {
            return er;
        }
        DR f = er.f();
        if (vt4 != null) {
            f.e = vt4.b;
        }
        if (vt3 != null) {
            f.f = vt3.b;
        }
        if (vt2 != null) {
            f.h = vt2.b;
        }
        if (vt != null) {
            f.g = vt.b;
        }
        return f.a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean d() {
        if (this.a > 1) {
            return true;
        }
        VT vt = this.e;
        if (vt != null && vt.a > 1) {
            return true;
        }
        VT vt2 = this.f;
        if (vt2 != null && vt2.a > 1) {
            return true;
        }
        VT vt3 = this.g;
        if (vt3 != null && vt3.a > 1) {
            return true;
        }
        VT vt4 = this.h;
        if (vt4 != null && vt4.a > 1) {
            return true;
        }
        return false;
    }
}
