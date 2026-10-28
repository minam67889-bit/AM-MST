package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3131gc0;
import defpackage.C3218hg;
import defpackage.C3297ig;
import defpackage.C3616mg;
import defpackage.FM;
import defpackage.HM;
import defpackage.InterfaceC0454Rd;
import defpackage.W80;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class ClockFaceView extends HM implements InterfaceC0454Rd {
    public final c A;
    public final int[] B;
    public final float[] C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final String[] H;
    public float I;
    public final ColorStateList J;
    public final ClockHandView v;
    public final Rect w;
    public final RectF x;
    public final Rect y;
    public final SparseArray z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = new Rect();
        this.x = new RectF();
        this.y = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.z = sparseArray;
        this.C = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList s = W80.s(context, obtainStyledAttributes, 1);
        this.J = s;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.v = clockHandView;
        this.D = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = s.getColorForState(new int[]{android.R.attr.state_selected}, s.getDefaultColor());
        this.B = new int[]{colorForState, colorForState, s.getDefaultColor()};
        clockHandView.c.add(this);
        int defaultColor = AbstractC3131gc0.u(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList s2 = W80.s(context, obtainStyledAttributes, 0);
        setBackgroundColor(s2 != null ? s2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        obtainStyledAttributes.recycle();
        this.A = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.H = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z = false;
        for (int i = 0; i < Math.max(this.H.length, size); i++) {
            TextView textView = (TextView) sparseArray.get(i);
            if (i >= this.H.length) {
                removeView(textView);
                sparseArray.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i, textView);
                    addView(textView);
                }
                textView.setText(this.H[i]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i));
                int i2 = (i / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i2));
                z = i2 > 1 ? true : z;
                AbstractC2925e20.m(textView, this.A);
                textView.setTextColor(this.J);
            }
        }
        ClockHandView clockHandView2 = this.v;
        if (clockHandView2.b && !z) {
            clockHandView2.m = 1;
        }
        clockHandView2.b = z;
        clockHandView2.invalidate();
        this.E = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.G = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // defpackage.HM
    public final void m() {
        C3616mg c3616mg = new C3616mg();
        c3616mg.b(this);
        HashMap hashMap = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i2 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i2 == null) {
                    i2 = 1;
                }
                if (!hashMap.containsKey(i2)) {
                    hashMap.put(i2, new ArrayList());
                }
                ((List) hashMap.get(i2)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            int round = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.t * 0.66f) : this.t;
            Iterator it = list.iterator();
            float f = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                HashMap hashMap2 = c3616mg.c;
                if (!hashMap2.containsKey(Integer.valueOf(id))) {
                    hashMap2.put(Integer.valueOf(id), new C3218hg());
                }
                C3297ig c3297ig = ((C3218hg) hashMap2.get(Integer.valueOf(id))).d;
                c3297ig.y = R.id.circle_center;
                c3297ig.z = round;
                c3297ig.A = f;
                f += 360.0f / list.size();
            }
        }
        c3616mg.a(this);
        setConstraintSet(null);
        requestLayout();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.z;
            if (i3 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i3)).setVisibility(0);
            i3++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.v.g;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.z;
            int size = sparseArray.size();
            rectF = this.x;
            rect = this.w;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f) {
                    textView = textView2;
                    f = height;
                }
            }
            i++;
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            TextView textView3 = (TextView) sparseArray.get(i2);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.y);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.B, this.C, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.H.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.G / Math.max(Math.max(this.E / displayMetrics.heightPixels, this.F / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
