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
import app.vpn.amtunnellite.R;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC4673wh;
import defpackage.C0489Sf;
import defpackage.C0515Tf;
import defpackage.C0619Xf;
import defpackage.CL;
import defpackage.FL;
import defpackage.InterfaceC0098Dd;
import defpackage.T00;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class ClockFaceView extends FL implements InterfaceC0098Dd {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = new Rect();
        this.x = new RectF();
        this.y = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.z = sparseArray;
        this.C = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CL.f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList d0 = AbstractC3411gE.d0(context, obtainStyledAttributes, 1);
        this.J = d0;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.v = clockHandView;
        this.D = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = d0.getColorForState(new int[]{android.R.attr.state_selected}, d0.getDefaultColor());
        this.B = new int[]{colorForState, colorForState, d0.getDefaultColor()};
        clockHandView.c.add(this);
        int defaultColor = AbstractC4673wh.y(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList d02 = AbstractC3411gE.d0(context, obtainStyledAttributes, 0);
        setBackgroundColor(d02 != null ? d02.getDefaultColor() : defaultColor);
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
                T00.l(textView, this.A);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.FL
    public final void m() {
        C0619Xf c0619Xf = new C0619Xf();
        c0619Xf.b(this);
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
                HashMap hashMap2 = c0619Xf.c;
                if (!hashMap2.containsKey(Integer.valueOf(id))) {
                    hashMap2.put(Integer.valueOf(id), new C0489Sf());
                }
                C0515Tf c0515Tf = ((C0489Sf) hashMap2.get(Integer.valueOf(id))).d;
                c0515Tf.y = R.id.circle_center;
                c0515Tf.z = round;
                c0515Tf.A = f;
                f += 360.0f / list.size();
            }
        }
        c0619Xf.a(this);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.H.length, false, 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        n();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.G / Math.max(Math.max(this.E / displayMetrics.heightPixels, this.F / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
