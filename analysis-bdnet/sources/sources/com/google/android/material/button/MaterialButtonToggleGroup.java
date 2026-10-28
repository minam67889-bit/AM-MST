package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import app.vpn.amtunnellite.R;
import com.google.android.material.timepicker.e;
import defpackage.AbstractC4702x40;
import defpackage.AbstractC4817ya0;
import defpackage.C3540i;
import defpackage.CD;
import defpackage.CL;
import defpackage.T00;
import defpackage.V9;
import defpackage.VT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends CD {
    public static final /* synthetic */ int q = 0;
    public final LinkedHashSet k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final int o;
    public HashSet p;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(AbstractC4817ya0.f0(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet);
        this.k = new LinkedHashSet();
        this.l = false;
        this.p = new HashSet();
        TypedArray B = AbstractC4702x40.B(getContext(), attributeSet, CL.n, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(B.getBoolean(7, false));
        this.o = B.getResourceId(2, -1);
        this.n = B.getBoolean(4, false);
        if (this.f == null) {
            this.f = VT.b(new C3540i(0.0f));
        }
        setEnabled(B.getBoolean(0, true));
        B.recycle();
        setImportantForAccessibility(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getChildrenA11yClassName() {
        return (this.m ? RadioButton.class : ToggleButton.class).getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && getChildAt(i2).getVisibility() != 8) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.CD, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.o);
        T00.l(materialButton, new V9(this, 2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f(int i, boolean z) {
        if (i == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.p);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.m && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.n || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        g(hashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(Set set) {
        HashSet hashSet = this.p;
        this.p = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.l = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.l = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a();
                }
            }
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCheckedButtonId() {
        if (!this.m || this.p.isEmpty()) {
            return -1;
        }
        return ((Integer) this.p.iterator().next()).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            if (this.p.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.o;
        if (i != -1) {
            g(Collections.singleton(Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.m ? 1 : 2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelectionRequired(boolean z) {
        this.n = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingleSelection(boolean z) {
        if (this.m != z) {
            this.m = z;
            g(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setA11yClassName(childrenA11yClassName);
        }
    }
}
