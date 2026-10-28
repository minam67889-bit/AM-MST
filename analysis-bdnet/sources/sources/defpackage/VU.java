package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import dastan.prince.bdfreevpn.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class VU {
    public final int a;
    public final C4464xS b;
    public final int[][] c;
    public final C4464xS[] d;
    public final TU e;
    public final TU f;
    public final TU g;
    public final TU h;

    public VU(UU uu) {
        this.a = uu.a;
        this.b = uu.b;
        this.c = uu.c;
        this.d = uu.d;
        this.e = uu.e;
        this.f = uu.f;
        this.g = uu.g;
        this.h = uu.h;
    }

    public static void a(UU uu, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = FM.t;
                TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                C4464xS a = C4464xS.a(context, obtainAttributes.getResourceId(0, 0), obtainAttributes.getResourceId(1, 0), new C3317j(0)).a();
                obtainAttributes.recycle();
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
                uu.a(StateSet.trimStateSet(iArr2, i), a);
            }
        }
    }

    public static VU b(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        UU uu = new UU();
        uu.b();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            uu.b();
        }
        try {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (xml.getName().equals("selector")) {
                a(uu, context, xml, asAttributeSet, context.getTheme());
            }
            xml.close();
            if (uu.a == 0) {
                return null;
            }
            return new VU(uu);
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

    public final C4464xS c() {
        C4464xS c4464xS = this.b;
        TU tu = this.h;
        TU tu2 = this.g;
        TU tu3 = this.f;
        TU tu4 = this.e;
        if (tu4 == null && tu3 == null && tu2 == null && tu == null) {
            return c4464xS;
        }
        C4385wS f = c4464xS.f();
        if (tu4 != null) {
            f.e = tu4.b;
        }
        if (tu3 != null) {
            f.f = tu3.b;
        }
        if (tu2 != null) {
            f.h = tu2.b;
        }
        if (tu != null) {
            f.g = tu.b;
        }
        return f.a();
    }

    public final boolean d() {
        TU tu;
        TU tu2;
        TU tu3;
        TU tu4;
        return this.a > 1 || ((tu = this.e) != null && tu.a > 1) || (((tu2 = this.f) != null && tu2.a > 1) || (((tu3 = this.g) != null && tu3.a > 1) || ((tu4 = this.h) != null && tu4.a > 1)));
    }
}
