package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import dastan.prince.bdfreevpn.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: tE, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4134tE extends LinearLayout {
    public final ArrayList a;
    public final ArrayList b;
    public final C2882dV c;
    public final C4055sE d;
    public Integer[] e;
    public TU f;
    public VU g;
    public int h;
    public XU i;
    public boolean j;

    /* JADX WARN: Type inference failed for: r13v5, types: [sE] */
    public AbstractC4134tE(Context context, AttributeSet attributeSet) {
        super(XE.B(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        TU b;
        XmlResourceParser xml;
        int next;
        XU xu;
        AttributeSet asAttributeSet;
        int next2;
        this.a = new ArrayList();
        this.b = new ArrayList();
        final MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.c = new C2882dV(materialButtonToggleGroup, 20);
        this.d = new Comparator() { // from class: sE
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                MaterialButtonToggleGroup materialButtonToggleGroup2 = MaterialButtonToggleGroup.this;
                int compareTo = Boolean.valueOf(materialButton.o).compareTo(Boolean.valueOf(materialButton2.o));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return compareTo2 != 0 ? compareTo2 : Integer.compare(materialButtonToggleGroup2.indexOfChild(materialButton), materialButtonToggleGroup2.indexOfChild(materialButton2));
            }
        };
        this.j = true;
        Context context2 = getContext();
        TypedArray G = AbstractC0641Yi.G(context2, attributeSet, FM.m, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (G.hasValue(2)) {
            int resourceId = G.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                    try {
                        xu = new XU();
                        xu.c = new int[10][];
                        xu.d = new TO[10];
                        asAttributeSet = Xml.asAttributeSet(xml);
                        do {
                            next2 = xml.next();
                            if (next2 == 2) {
                                break;
                            }
                        } while (next2 != 1);
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                if (next2 != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (xml.getName().equals("selector")) {
                    xu.a(context2, xml, asAttributeSet, context2.getTheme());
                }
                xml.close();
                this.i = xu;
            }
            xu = null;
            this.i = xu;
        }
        if (G.hasValue(4)) {
            VU b2 = VU.b(context2, G, 4);
            this.g = b2;
            if (b2 == null) {
                UU uu = new UU(C4464xS.a(context2, G.getResourceId(4, 0), G.getResourceId(5, 0), new C3317j(0)).a());
                this.g = uu.a != 0 ? new VU(uu) : null;
            }
        }
        if (G.hasValue(3)) {
            C3317j c3317j = new C3317j(0.0f);
            int resourceId2 = G.getResourceId(3, 0);
            if (resourceId2 == 0) {
                b = TU.b(C4464xS.c(G, 3, c3317j));
            } else if (context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        b = new TU();
                        AttributeSet asAttributeSet2 = Xml.asAttributeSet(xml);
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
                            b.d(context2, xml, asAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    b = TU.b(c3317j);
                }
            } else {
                b = TU.b(C4464xS.c(G, 3, c3317j));
            }
            this.f = b;
        }
        this.h = G.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(G.getBoolean(0, true));
        G.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void a() {
        int i;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i2 - 1);
            if (this.h <= 0) {
                i = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                i = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.h - i);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.h - i;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.j = true;
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        this.a.add(materialButton.getShapeAppearanceModel());
        this.b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float max;
        if (this.i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i2 = firstVisibleChildIndex; i2 <= lastVisibleChildIndex; i2++) {
            if (c(i2)) {
                if (c(i2) && this.i != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i2);
                    XU xu = this.i;
                    int width = materialButton3.getWidth();
                    int i3 = -width;
                    for (int i4 = 0; i4 < xu.a; i4++) {
                        WU wu = (WU) xu.d[i4].b;
                        int i5 = wu.a;
                        float f = wu.b;
                        if (i5 == 2) {
                            max = Math.max(i3, f);
                        } else if (i5 == 1) {
                            max = Math.max(i3, width * f);
                        }
                        i3 = (int) max;
                    }
                    int max2 = Math.max(0, i3);
                    int i6 = i2 - 1;
                    while (true) {
                        materialButton = null;
                        if (i6 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i6)) {
                                materialButton2 = (MaterialButton) getChildAt(i6);
                                break;
                            }
                            i6--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i7 = i2 + 1;
                    while (true) {
                        if (i7 >= childCount) {
                            break;
                        }
                        if (c(i7)) {
                            materialButton = (MaterialButton) getChildAt(i7);
                            break;
                        }
                        i7++;
                    }
                    r5 = Math.min(max2, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i2 != firstVisibleChildIndex && i2 != lastVisibleChildIndex) {
                    r5 /= 2;
                }
                i = Math.min(i, r5);
            }
        }
        int i8 = firstVisibleChildIndex;
        while (i8 <= lastVisibleChildIndex) {
            if (c(i8)) {
                ((MaterialButton) getChildAt(i8)).setSizeChange(this.i);
                ((MaterialButton) getChildAt(i8)).setWidthChangeMax((i8 == firstVisibleChildIndex || i8 == lastVisibleChildIndex) ? i : i * 2);
            }
            i8++;
        }
    }

    public final boolean c(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void d() {
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            LinearLayout.LayoutParams layoutParams = materialButton.v;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.v = null;
                materialButton.s = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.d);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        UU uu;
        int i;
        if (!(this.f == null && this.g == null) && this.j) {
            this.j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i2 = 0;
            while (i2 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i2);
                if (materialButton.getVisibility() != 8) {
                    boolean z = i2 == firstVisibleChildIndex;
                    boolean z2 = i2 == lastVisibleChildIndex;
                    VU vu = this.g;
                    if (vu == null || (!z && !z2)) {
                        vu = (VU) this.b.get(i2);
                    }
                    if (vu == null) {
                        uu = new UU((C4464xS) this.a.get(i2));
                    } else {
                        UU uu2 = new UU();
                        int i3 = vu.a;
                        uu2.a = i3;
                        uu2.b = vu.b;
                        int[][] iArr = vu.c;
                        int[][] iArr2 = new int[iArr.length][];
                        uu2.c = iArr2;
                        C4464xS[] c4464xSArr = vu.d;
                        uu2.d = new C4464xS[c4464xSArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i3);
                        System.arraycopy(c4464xSArr, 0, uu2.d, 0, uu2.a);
                        uu2.e = vu.e;
                        uu2.f = vu.f;
                        uu2.g = vu.g;
                        uu2.h = vu.h;
                        uu = uu2;
                    }
                    boolean z3 = getOrientation() == 0;
                    boolean z4 = getLayoutDirection() == 1;
                    if (z3) {
                        i = z ? 5 : 0;
                        if (z2) {
                            i |= 10;
                        }
                        if (z4) {
                            i = ((i & 10) >> 1) | ((i & 5) << 1);
                        }
                    } else {
                        i = z ? 3 : 0;
                        if (z2) {
                            i |= 12;
                        }
                    }
                    int i4 = ~i;
                    TU tu = this.f;
                    if ((i4 | 1) == i4) {
                        uu.e = tu;
                    }
                    if ((i4 | 2) == i4) {
                        uu.f = tu;
                    }
                    if ((i4 | 4) == i4) {
                        uu.g = tu;
                    }
                    if ((i4 | 8) == i4) {
                        uu.h = tu;
                    }
                    VU vu2 = uu.a == 0 ? null : new VU(uu);
                    if (vu2.d()) {
                        materialButton.setStateListShapeAppearanceModel(vu2);
                    } else {
                        materialButton.setShapeAppearanceModel(vu2.c());
                    }
                }
                i2++;
            }
        }
    }

    public XU getButtonSizeChange() {
        return this.i;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.e;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i2;
    }

    public InterfaceC0509Tg getInnerCornerSize() {
        return this.f.b;
    }

    public TU getInnerCornerSizeStateList() {
        return this.f;
    }

    public C4464xS getShapeAppearance() {
        VU vu = this.g;
        if (vu == null) {
            return null;
        }
        return vu.c();
    }

    public int getSpacing() {
        return this.h;
    }

    public VU getStateListShapeAppearance() {
        return this.g;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        e();
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.a.remove(indexOfChild);
            this.b.remove(indexOfChild);
        }
        this.j = true;
        e();
        d();
        a();
    }

    public void setButtonSizeChange(XU xu) {
        if (this.i != xu) {
            this.i = xu;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z);
        }
    }

    public void setInnerCornerSize(InterfaceC0509Tg interfaceC0509Tg) {
        this.f = TU.b(interfaceC0509Tg);
        this.j = true;
        e();
        invalidate();
    }

    public void setInnerCornerSizeStateList(TU tu) {
        this.f = tu;
        this.j = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.j = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(C4464xS c4464xS) {
        UU uu = new UU(c4464xS);
        this.g = uu.a == 0 ? null : new VU(uu);
        this.j = true;
        e();
        invalidate();
    }

    public void setSpacing(int i) {
        this.h = i;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(VU vu) {
        this.g = vu;
        this.j = true;
        e();
        invalidate();
    }
}
