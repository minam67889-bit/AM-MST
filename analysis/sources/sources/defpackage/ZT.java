package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class ZT {
    public int a;
    public VP b;
    public int[][] c;
    public VP[] d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainStyledAttributes;
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                int depth2 = xmlResourceParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                        Resources resources = context.getResources();
                        int[] iArr = CL.D;
                        if (theme == null) {
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, iArr);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                        }
                        TypedValue peekValue = obtainStyledAttributes.peekValue(0);
                        YT yt = null;
                        if (peekValue != null) {
                            int i = peekValue.type;
                            if (i == 5) {
                                yt = new YT(2, TypedValue.complexToDimensionPixelSize(peekValue.data, obtainStyledAttributes.getResources().getDisplayMetrics()));
                            } else if (i == 6) {
                                yt = new YT(1, peekValue.getFraction(1.0f, 1.0f));
                            }
                        }
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr2 = new int[attributeCount];
                        int i2 = 0;
                        for (int i3 = 0; i3 < attributeCount; i3++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                            if (attributeNameResource != R.attr.widthChange) {
                                int i4 = i2 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr2[i2] = attributeNameResource;
                                i2 = i4;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr2, i2);
                        VP vp = new VP(8);
                        vp.b = yt;
                        int i5 = this.a;
                        if (i5 == 0 || trimStateSet.length == 0) {
                            this.b = vp;
                        }
                        int[][] iArr3 = this.c;
                        if (i5 >= iArr3.length) {
                            int i6 = i5 + 10;
                            int[][] iArr4 = new int[i6][];
                            System.arraycopy(iArr3, 0, iArr4, 0, i5);
                            this.c = iArr4;
                            VP[] vpArr = new VP[i6];
                            System.arraycopy(this.d, 0, vpArr, 0, i5);
                            this.d = vpArr;
                        }
                        int[][] iArr5 = this.c;
                        int i7 = this.a;
                        iArr5[i7] = trimStateSet;
                        this.d[i7] = vp;
                        this.a = i7 + 1;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
