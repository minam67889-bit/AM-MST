package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class VT {
    public int a;
    public InterfaceC0127Eg b;
    public int[][] c = new int[10][];
    public InterfaceC0127Eg[] d = new InterfaceC0127Eg[10];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static VT b(InterfaceC0127Eg interfaceC0127Eg) {
        VT vt = new VT();
        vt.a(StateSet.WILD_CARD, interfaceC0127Eg);
        return vt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(int[] iArr, InterfaceC0127Eg interfaceC0127Eg) {
        int i = this.a;
        if (i == 0 || iArr.length == 0) {
            this.b = interfaceC0127Eg;
        }
        int[][] iArr2 = this.c;
        if (i >= iArr2.length) {
            int i2 = i + 10;
            int[][] iArr3 = new int[i2][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.c = iArr3;
            InterfaceC0127Eg[] interfaceC0127EgArr = new InterfaceC0127Eg[i2];
            System.arraycopy(this.d, 0, interfaceC0127EgArr, 0, i);
            this.d = interfaceC0127EgArr;
        }
        int[][] iArr4 = this.c;
        int i3 = this.a;
        iArr4[i3] = iArr;
        this.d[i3] = interfaceC0127Eg;
        this.a = i3 + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InterfaceC0127Eg c(int[] iArr) {
        int i;
        int[][] iArr2 = this.c;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = -1;
            if (i3 < this.a) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.c;
            while (true) {
                if (i2 >= this.a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i2], iArr3)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            i3 = i;
        }
        if (i3 < 0) {
            return this.b;
        }
        return this.d[i3];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainStyledAttributes;
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                int depth2 = xmlResourceParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                        Resources resources = context.getResources();
                        int[] iArr = CL.A;
                        if (theme == null) {
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, iArr);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                        }
                        InterfaceC0127Eg c = ER.c(obtainStyledAttributes, 5, new C3540i(0.0f));
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr2 = new int[attributeCount];
                        int i = 0;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                            if (attributeNameResource != R.attr.cornerSize) {
                                int i3 = i + 1;
                                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr2[i] = attributeNameResource;
                                i = i3;
                            }
                        }
                        a(StateSet.trimStateSet(iArr2, i), c);
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
