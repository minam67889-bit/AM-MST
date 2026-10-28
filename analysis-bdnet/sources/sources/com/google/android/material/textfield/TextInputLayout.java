package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.AbstractC0118Ee;
import defpackage.AbstractC0540Ul;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC0731aZ;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC2984el;
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC4434x4;
import defpackage.AbstractC4626zW;
import defpackage.C0010Aa;
import defpackage.C0244Ja;
import defpackage.C0270Ka;
import defpackage.C0304Li;
import defpackage.C0329Mi;
import defpackage.C0492Sp;
import defpackage.C0504Tb;
import defpackage.C0618Xl;
import defpackage.C0727aV;
import defpackage.C2835cv;
import defpackage.C3290ic;
import defpackage.C3317j;
import defpackage.C3408k5;
import defpackage.C3474kx;
import defpackage.C3554lx;
import defpackage.C3740oE;
import defpackage.C3780om;
import defpackage.C3849pe;
import defpackage.C4018ro;
import defpackage.C4097so;
import defpackage.C4254un;
import defpackage.C4385wS;
import defpackage.C4452xG;
import defpackage.C4464xS;
import defpackage.C4547yW;
import defpackage.CP;
import defpackage.CW;
import defpackage.DW;
import defpackage.EW;
import defpackage.FM;
import defpackage.FW;
import defpackage.HE;
import defpackage.InterfaceC0509Tg;
import defpackage.JE;
import defpackage.NU;
import defpackage.RunnableC3954r1;
import defpackage.S50;
import defpackage.S7;
import defpackage.T5;
import defpackage.W50;
import defpackage.W80;
import defpackage.XE;
import defpackage.XO;
import defpackage.XX;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] D0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public boolean A0;
    public ColorStateList B;
    public boolean B0;
    public ColorStateList C;
    public boolean C0;
    public boolean D;
    public CharSequence E;
    public boolean F;
    public JE G;
    public JE H;
    public StateListDrawable I;
    public boolean J;
    public JE K;
    public JE L;
    public C4464xS M;
    public boolean N;
    public final int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public final Rect W;
    public final FrameLayout a;
    public final Rect a0;
    public final NU b;
    public final RectF b0;
    public final C4097so c;
    public Typeface c0;
    public final int d;
    public ColorDrawable d0;
    public EditText e;
    public int e0;
    public CharSequence f;
    public final LinkedHashSet f0;
    public int g;
    public ColorDrawable g0;
    public int h;
    public int h0;
    public int i;
    public Drawable i0;
    public int j;
    public ColorStateList j0;
    public final C3554lx k;
    public ColorStateList k0;
    public boolean l;
    public int l0;
    public int m;
    public int m0;
    public boolean n;
    public int n0;
    public EW o;
    public ColorStateList o0;
    public T5 p;
    public int p0;
    public int q;
    public int q0;
    public int r;
    public int r0;
    public CharSequence s;
    public int s0;
    public boolean t;
    public int t0;
    public T5 u;
    public int u0;
    public ColorStateList v;
    public boolean v0;
    public int w;
    public final C3849pe w0;
    public C0492Sp x;
    public boolean x0;
    public C0492Sp y;
    public boolean y0;
    public ColorStateList z;
    public ValueAnimator z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(XE.B(context, attributeSet, dastan.prince.bdfreevpn.R.attr.textInputStyle, dastan.prince.bdfreevpn.R.style.Widget_Design_TextInputLayout), attributeSet, dastan.prince.bdfreevpn.R.attr.textInputStyle);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = new C3554lx(this);
        this.o = new CP(9);
        this.W = new Rect();
        this.a0 = new Rect();
        this.b0 = new RectF();
        this.f0 = new LinkedHashSet();
        C3849pe c3849pe = new C3849pe(this);
        this.w0 = c3849pe;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = AbstractC4434x4.a;
        c3849pe.R = linearInterpolator;
        c3849pe.j(false);
        c3849pe.Q = linearInterpolator;
        c3849pe.j(false);
        if (c3849pe.g != 8388659) {
            c3849pe.g = 8388659;
            c3849pe.j(false);
        }
        int[] iArr = FM.F;
        AbstractC0641Yi.g(context2, attributeSet, dastan.prince.bdfreevpn.R.attr.textInputStyle, dastan.prince.bdfreevpn.R.style.Widget_Design_TextInputLayout);
        AbstractC0641Yi.i(context2, attributeSet, iArr, dastan.prince.bdfreevpn.R.attr.textInputStyle, dastan.prince.bdfreevpn.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, dastan.prince.bdfreevpn.R.attr.textInputStyle, dastan.prince.bdfreevpn.R.style.Widget_Design_TextInputLayout);
        C4452xG c4452xG = new C4452xG(context2, obtainStyledAttributes);
        NU nu = new NU(this, c4452xG);
        this.b = nu;
        this.D = obtainStyledAttributes.getBoolean(48, true);
        setHint(obtainStyledAttributes.getText(4));
        this.y0 = obtainStyledAttributes.getBoolean(47, true);
        this.x0 = obtainStyledAttributes.getBoolean(42, true);
        if (obtainStyledAttributes.hasValue(6)) {
            setMinEms(obtainStyledAttributes.getInt(6, -1));
        } else if (obtainStyledAttributes.hasValue(3)) {
            setMinWidth(obtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            setMaxEms(obtainStyledAttributes.getInt(5, -1));
        } else if (obtainStyledAttributes.hasValue(2)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.M = C4464xS.b(context2, attributeSet, dastan.prince.bdfreevpn.R.attr.textInputStyle, dastan.prince.bdfreevpn.R.style.Widget_Design_TextInputLayout).a();
        this.O = context2.getResources().getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.Q = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.d = getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.S = obtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.T = obtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.R = this.S;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        C4385wS f = this.M.f();
        if (dimension >= 0.0f) {
            f.e = new C3317j(dimension);
        }
        if (dimension2 >= 0.0f) {
            f.f = new C3317j(dimension2);
        }
        if (dimension3 >= 0.0f) {
            f.g = new C3317j(dimension3);
        }
        if (dimension4 >= 0.0f) {
            f.h = new C3317j(dimension4);
        }
        this.M = f.a();
        ColorStateList r = W80.r(context2, c4452xG, 7);
        if (r != null) {
            int defaultColor = r.getDefaultColor();
            this.p0 = defaultColor;
            this.V = defaultColor;
            if (r.isStateful()) {
                this.q0 = r.getColorForState(new int[]{-16842910}, -1);
                this.r0 = r.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.s0 = r.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.r0 = this.p0;
                ColorStateList u = AbstractC3131gc0.u(context2, dastan.prince.bdfreevpn.R.color.mtrl_filled_background_color);
                this.q0 = u.getColorForState(new int[]{-16842910}, -1);
                this.s0 = u.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.p0 = 0;
            this.q0 = 0;
            this.r0 = 0;
            this.s0 = 0;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            ColorStateList h = c4452xG.h(1);
            this.k0 = h;
            this.j0 = h;
        }
        ColorStateList r2 = W80.r(context2, c4452xG, 14);
        this.n0 = obtainStyledAttributes.getColor(14, 0);
        this.l0 = context2.getColor(dastan.prince.bdfreevpn.R.color.mtrl_textinput_default_box_stroke_color);
        this.t0 = context2.getColor(dastan.prince.bdfreevpn.R.color.mtrl_textinput_disabled_color);
        this.m0 = context2.getColor(dastan.prince.bdfreevpn.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (r2 != null) {
            setBoxStrokeColorStateList(r2);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(W80.r(context2, c4452xG, 15));
        }
        if (obtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(50, 0));
        }
        this.B = c4452xG.h(24);
        this.C = c4452xG.h(25);
        int resourceId = obtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = obtainStyledAttributes.getText(35);
        int i = obtainStyledAttributes.getInt(34, 1);
        boolean z = obtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(45, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = obtainStyledAttributes.getText(43);
        int resourceId3 = obtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = obtainStyledAttributes.getText(57);
        boolean z3 = obtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(19, -1));
        this.r = obtainStyledAttributes.getResourceId(22, 0);
        this.q = obtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(obtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.q);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.r);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (obtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(c4452xG.h(41));
        }
        if (obtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(c4452xG.h(46));
        }
        if (obtainStyledAttributes.hasValue(51)) {
            setHintTextColor(c4452xG.h(51));
        }
        if (obtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(c4452xG.h(23));
        }
        if (obtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(c4452xG.h(21));
        }
        if (obtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(c4452xG.h(59));
        }
        C4097so c4097so = new C4097so(this, c4452xG);
        this.c = c4097so;
        boolean z4 = obtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(obtainStyledAttributes.getInt(49, 1));
        c4452xG.q();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(nu);
        frameLayout.addView(c4097so);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.e;
        if (!(editText instanceof AutoCompleteTextView) || AbstractC3131gc0.x(editText)) {
            return this.G;
        }
        int u = S50.u(this.e, dastan.prince.bdfreevpn.R.attr.colorControlHighlight);
        int i = this.P;
        int[][] iArr = D0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            JE je = this.G;
            int i2 = this.V;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{S50.z(u, i2, 0.1f), i2}), je, je);
        }
        Context context = getContext();
        JE je2 = this.G;
        TypedValue c0 = AbstractC0731aZ.c0(context, dastan.prince.bdfreevpn.R.attr.colorSurface, "TextInputLayout");
        int i3 = c0.resourceId;
        int color = i3 != 0 ? context.getColor(i3) : c0.data;
        JE je3 = new JE(je2.b.a);
        int z = S50.z(u, color, 0.1f);
        je3.n(new ColorStateList(iArr, new int[]{z, 0}));
        je3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{z, color});
        JE je4 = new JE(je2.b.a);
        je4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, je3, je4), je2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], h(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = h(true);
        }
        return this.H;
    }

    public static void m(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i = this.g;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.i);
        }
        int i2 = this.h;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.j);
        }
        this.J = false;
        k();
        setTextInputAccessibilityDelegate(new DW(this));
        Typeface typeface = this.e.getTypeface();
        C3849pe c3849pe = this.w0;
        c3849pe.n(typeface);
        float textSize = this.e.getTextSize();
        if (c3849pe.h != textSize) {
            c3849pe.h = textSize;
            c3849pe.j(false);
        }
        float letterSpacing = this.e.getLetterSpacing();
        if (c3849pe.X != letterSpacing) {
            c3849pe.X = letterSpacing;
            c3849pe.j(false);
        }
        int gravity = this.e.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (c3849pe.g != i3) {
            c3849pe.g = i3;
            c3849pe.j(false);
        }
        if (c3849pe.f != gravity) {
            c3849pe.f = gravity;
            c3849pe.j(false);
        }
        this.u0 = editText.getMinimumHeight();
        this.e.addTextChangedListener(new CW(this, editText));
        if (this.j0 == null) {
            this.j0 = this.e.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.e.getHint();
                this.f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        if (this.p != null) {
            p(this.e.getText());
        }
        t();
        this.k.b();
        this.b.bringToFront();
        C4097so c4097so = this.c;
        c4097so.bringToFront();
        Iterator it = this.f0.iterator();
        while (it.hasNext()) {
            ((C4018ro) it.next()).a(this);
        }
        c4097so.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        C3849pe c3849pe = this.w0;
        if (charSequence == null || !TextUtils.equals(c3849pe.B, charSequence)) {
            c3849pe.B = charSequence;
            c3849pe.C = null;
            c3849pe.j(false);
        }
        if (this.v0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.t == z) {
            return;
        }
        if (z) {
            T5 t5 = this.u;
            if (t5 != null) {
                this.a.addView(t5);
                this.u.setVisibility(0);
            }
        } else {
            T5 t52 = this.u;
            if (t52 != null) {
                t52.setVisibility(8);
            }
            this.u = null;
        }
        this.t = z;
    }

    public final void a() {
        if (this.e != null) {
            if (this.P != 1) {
                return;
            }
            if (!(getHintMaxLines() == 1)) {
                EditText editText = this.e;
                editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.w0.f() + this.d), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText2 = this.e;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_filled_edittext_font_2_0_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (W80.J(getContext())) {
                EditText editText3 = this.e;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_filled_edittext_font_1_3_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f) {
        C3849pe c3849pe = this.w0;
        if (c3849pe.b == f) {
            return;
        }
        if (this.z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.z0 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC0731aZ.b0(getContext(), dastan.prince.bdfreevpn.R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.b));
            this.z0.setDuration(AbstractC0731aZ.a0(getContext(), dastan.prince.bdfreevpn.R.attr.motionDurationMedium4, 167));
            this.z0.addUpdateListener(new C0244Ja(this, 3));
        }
        this.z0.setFloatValues(c3849pe.b, f);
        this.z0.start();
    }

    public final void c() {
        int i;
        int i2;
        JE je = this.G;
        if (je == null) {
            return;
        }
        C4464xS c4464xS = je.b.a;
        C4464xS c4464xS2 = this.M;
        if (c4464xS != c4464xS2) {
            je.setShapeAppearanceModel(c4464xS2);
        }
        if (this.P == 2 && (i = this.R) > -1 && (i2 = this.U) != 0) {
            JE je2 = this.G;
            je2.b.k = i;
            je2.invalidateSelf();
            ColorStateList valueOf = ColorStateList.valueOf(i2);
            HE he = je2.b;
            if (he.e != valueOf) {
                he.e = valueOf;
                je2.onStateChange(je2.getState());
            }
        }
        int i3 = this.V;
        if (this.P == 1) {
            i3 = AbstractC0118Ee.b(this.V, S50.t(getContext(), dastan.prince.bdfreevpn.R.attr.colorSurface, 0));
        }
        this.V = i3;
        this.G.n(ColorStateList.valueOf(i3));
        JE je3 = this.K;
        if (je3 != null && this.L != null) {
            if (this.R > -1 && this.U != 0) {
                je3.n(this.e.isFocused() ? ColorStateList.valueOf(this.l0) : ColorStateList.valueOf(this.U));
                this.L.n(ColorStateList.valueOf(this.U));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.e == null) {
            throw new IllegalStateException();
        }
        boolean z = getLayoutDirection() == 1;
        int i = rect.bottom;
        Rect rect2 = this.a0;
        rect2.bottom = i;
        int i2 = this.P;
        if (i2 == 1) {
            rect2.left = i(rect.left, z);
            rect2.top = rect.top + this.Q;
            rect2.right = j(rect.right, z);
            return rect2;
        }
        if (i2 != 2) {
            rect2.left = i(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z);
            return rect2;
        }
        rect2.left = this.e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f != null) {
            boolean z = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.e.setHint(hint);
                this.F = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure newChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.e) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        JE je;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z = this.D;
        C3849pe c3849pe = this.w0;
        if (z) {
            c3849pe.getClass();
            int save = canvas2.save();
            if (c3849pe.C != null) {
                RectF rectF = c3849pe.e;
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    TextPaint textPaint = c3849pe.O;
                    textPaint.setTextSize(c3849pe.G);
                    float f = c3849pe.q;
                    float f2 = c3849pe.r;
                    float f3 = c3849pe.F;
                    if (f3 != 1.0f) {
                        canvas2.scale(f3, f3, f, f2);
                    }
                    if ((c3849pe.e0 > 1 || c3849pe.f0 > 1) && !c3849pe.D && c3849pe.o()) {
                        float lineStart = c3849pe.q - c3849pe.Z.getLineStart(0);
                        int alpha = textPaint.getAlpha();
                        canvas2.translate(lineStart, f2);
                        float f4 = alpha;
                        textPaint.setAlpha((int) (c3849pe.c0 * f4));
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 31) {
                            float f5 = c3849pe.H;
                            float f6 = c3849pe.I;
                            float f7 = c3849pe.J;
                            int i2 = c3849pe.K;
                            textPaint.setShadowLayer(f5, f6, f7, AbstractC0118Ee.d(i2, (textPaint.getAlpha() * Color.alpha(i2)) / 255));
                        }
                        c3849pe.Z.draw(canvas2);
                        textPaint.setAlpha((int) (c3849pe.b0 * f4));
                        if (i >= 31) {
                            float f8 = c3849pe.H;
                            float f9 = c3849pe.I;
                            float f10 = c3849pe.J;
                            int i3 = c3849pe.K;
                            textPaint.setShadowLayer(f8, f9, f10, AbstractC0118Ee.d(i3, (Color.alpha(i3) * textPaint.getAlpha()) / 255));
                        }
                        int lineBaseline = c3849pe.Z.getLineBaseline(0);
                        CharSequence charSequence = c3849pe.d0;
                        float f11 = lineBaseline;
                        canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, textPaint);
                        if (i >= 31) {
                            textPaint.setShadowLayer(c3849pe.H, c3849pe.I, c3849pe.J, c3849pe.K);
                        }
                        String trim = c3849pe.d0.toString().trim();
                        if (trim.endsWith("…")) {
                            trim = trim.substring(0, trim.length() - 1);
                        }
                        String str = trim;
                        textPaint.setAlpha(alpha);
                        canvas2 = canvas;
                        canvas2.drawText(str, 0, Math.min(c3849pe.Z.getLineEnd(0), str.length()), 0.0f, f11, (Paint) textPaint);
                    } else {
                        canvas2.translate(f, f2);
                        c3849pe.Z.draw(canvas2);
                    }
                    canvas2.restoreToCount(save);
                }
            }
        }
        if (this.L == null || (je = this.K) == null) {
            return;
        }
        je.draw(canvas2);
        if (this.e.isFocused()) {
            Rect bounds = this.L.getBounds();
            Rect bounds2 = this.K.getBounds();
            float f12 = c3849pe.b;
            int centerX = bounds2.centerX();
            bounds.left = AbstractC4434x4.c(centerX, bounds2.left, f12);
            bounds.right = AbstractC4434x4.c(centerX, bounds2.right, f12);
            this.L.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        if (this.A0) {
            return;
        }
        this.A0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C3849pe c3849pe = this.w0;
        if (c3849pe != null) {
            c3849pe.M = drawableState;
            ColorStateList colorStateList2 = c3849pe.k;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = c3849pe.j) != null && colorStateList.isStateful())) {
                c3849pe.j(false);
                z = true;
                if (this.e != null) {
                    w(isLaidOut() && isEnabled(), false);
                }
                t();
                z();
                if (z) {
                    invalidate();
                }
                this.A0 = false;
            }
        }
        z = false;
        if (this.e != null) {
        }
        t();
        z();
        if (z) {
        }
        this.A0 = false;
    }

    public final int e() {
        if (this.D) {
            int i = this.P;
            C3849pe c3849pe = this.w0;
            if (i == 0) {
                return (int) c3849pe.f();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (c3849pe.f() / 2.0f);
                }
                float f = c3849pe.f();
                TextPaint textPaint = c3849pe.P;
                textPaint.setTextSize(c3849pe.i);
                textPaint.setTypeface(c3849pe.s);
                textPaint.setLetterSpacing(c3849pe.W);
                return Math.max(0, (int) (f - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final C0492Sp f() {
        C0492Sp c0492Sp = new C0492Sp();
        c0492Sp.c = AbstractC0731aZ.a0(getContext(), dastan.prince.bdfreevpn.R.attr.motionDurationShort2, 87);
        c0492Sp.d = AbstractC0731aZ.b0(getContext(), dastan.prince.bdfreevpn.R.attr.motionEasingLinearInterpolator, AbstractC4434x4.a);
        return c0492Sp;
    }

    public final boolean g() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof C0329Mi);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public JE getBoxBackground() {
        int i = this.P;
        if (i == 1 || i == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.b0;
        return layoutDirection == 1 ? this.M.h.a(rectF) : this.M.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.b0;
        return layoutDirection == 1 ? this.M.g.a(rectF) : this.M.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.b0;
        return layoutDirection == 1 ? this.M.e.a(rectF) : this.M.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.b0;
        return layoutDirection == 1 ? this.M.f.a(rectF) : this.M.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.n0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    public CharSequence getCounterOverflowDescription() {
        T5 t5;
        if (this.l && this.n && (t5 = this.p) != null) {
            return t5.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    public ColorStateList getCounterTextColor() {
        return this.z;
    }

    public ColorStateList getCursorColor() {
        return this.B;
    }

    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.j0;
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.c.g.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.c.g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.c.m;
    }

    public int getEndIconMode() {
        return this.c.i;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.c.n;
    }

    public CheckableImageButton getEndIconView() {
        return this.c.g;
    }

    public CharSequence getError() {
        C3554lx c3554lx = this.k;
        if (c3554lx.q) {
            return c3554lx.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.k.t;
    }

    public CharSequence getErrorContentDescription() {
        return this.k.s;
    }

    public int getErrorCurrentTextColors() {
        T5 t5 = this.k.r;
        if (t5 != null) {
            return t5.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.c.c.getDrawable();
    }

    public CharSequence getHelperText() {
        C3554lx c3554lx = this.k;
        if (c3554lx.x) {
            return c3554lx.w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        T5 t5 = this.k.y;
        if (t5 != null) {
            return t5.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.w0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        C3849pe c3849pe = this.w0;
        return c3849pe.g(c3849pe.k);
    }

    public int getHintMaxLines() {
        return this.w0.e0;
    }

    public ColorStateList getHintTextColor() {
        return this.k0;
    }

    public EW getLengthCounter() {
        return this.o;
    }

    public int getMaxEms() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.j;
    }

    public int getMinEms() {
        return this.g;
    }

    public int getMinWidth() {
        return this.i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.c.g.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.c.g.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.t) {
            return this.s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.v;
    }

    public CharSequence getPrefixText() {
        return this.b.c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.b.b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.b.b;
    }

    public C4464xS getShapeAppearanceModel() {
        return this.M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.b.d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.b.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.b.g;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.b.h;
    }

    public CharSequence getSuffixText() {
        return this.c.p;
    }

    public ColorStateList getSuffixTextColor() {
        return this.c.q.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.c.q;
    }

    public Typeface getTypeface() {
        return this.c0;
    }

    public final JE h(boolean z) {
        int i = 0;
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_shape_corner_size_small_component);
        float f = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.e;
        float popupElevation = editText instanceof C3740oE ? ((C3740oE) editText).getPopupElevation() : getResources().getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        XO xo = new XO();
        XO xo2 = new XO();
        XO xo3 = new XO();
        XO xo4 = new XO();
        C4254un c4254un = new C4254un(i);
        C4254un c4254un2 = new C4254un(i);
        C4254un c4254un3 = new C4254un(i);
        C4254un c4254un4 = new C4254un(i);
        C3317j c3317j = new C3317j(f);
        C3317j c3317j2 = new C3317j(f);
        C3317j c3317j3 = new C3317j(dimensionPixelOffset);
        C3317j c3317j4 = new C3317j(dimensionPixelOffset);
        C4464xS c4464xS = new C4464xS();
        c4464xS.a = xo;
        c4464xS.b = xo2;
        c4464xS.c = xo3;
        c4464xS.d = xo4;
        c4464xS.e = c3317j;
        c4464xS.f = c3317j2;
        c4464xS.g = c3317j4;
        c4464xS.h = c3317j3;
        c4464xS.i = c4254un;
        c4464xS.j = c4254un2;
        c4464xS.k = c4254un3;
        c4464xS.l = c4254un4;
        EditText editText2 = this.e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof C3740oE ? ((C3740oE) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = JE.F;
            TypedValue c0 = AbstractC0731aZ.c0(context, dastan.prince.bdfreevpn.R.attr.colorSurface, JE.class.getSimpleName());
            int i2 = c0.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i2 != 0 ? context.getColor(i2) : c0.data);
        }
        JE je = new JE();
        je.k(context);
        je.n(dropDownBackgroundTintList);
        je.m(popupElevation);
        je.setShapeAppearanceModel(c4464xS);
        HE he = je.b;
        if (he.h == null) {
            he.h = new Rect();
        }
        je.b.h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        je.invalidateSelf();
        return je;
    }

    public final int i(int i, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.e.getCompoundPaddingLeft() : this.c.c() : this.b.a()) + i;
    }

    public final int j(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.e.getCompoundPaddingRight() : this.b.a() : this.c.c());
    }

    public final void k() {
        int i = this.P;
        if (i == 0) {
            this.G = null;
            this.K = null;
            this.L = null;
        } else if (i == 1) {
            this.G = new JE(this.M);
            this.K = new JE();
            this.L = new JE();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(W50.r(new StringBuilder(), this.P, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.D || (this.G instanceof C0329Mi)) {
                this.G = new JE(this.M);
            } else {
                C4464xS c4464xS = this.M;
                int i2 = C0329Mi.I;
                if (c4464xS == null) {
                    c4464xS = new C4464xS();
                }
                C0304Li c0304Li = new C0304Li(c4464xS, new RectF());
                C0329Mi c0329Mi = new C0329Mi(c0304Li);
                c0329Mi.H = c0304Li;
                this.G = c0329Mi;
            }
            this.K = null;
            this.L = null;
        }
        u();
        z();
        if (this.P == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.Q = getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (W80.J(getContext())) {
                this.Q = getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.P != 0) {
            v();
        }
        EditText editText = this.e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.P;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() {
        float f;
        float f2;
        float f3;
        RectF rectF;
        float f4;
        int i;
        float f5;
        int i2;
        if (g()) {
            int width = this.e.getWidth();
            int gravity = this.e.getGravity();
            C3849pe c3849pe = this.w0;
            boolean c = c3849pe.c(c3849pe.B);
            c3849pe.D = c;
            Rect rect = c3849pe.d;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (c) {
                        i2 = rect.left;
                        f3 = i2;
                    } else {
                        f = rect.right;
                        f2 = c3849pe.a0;
                    }
                } else if (c) {
                    f = rect.right;
                    f2 = c3849pe.a0;
                } else {
                    i2 = rect.left;
                    f3 = i2;
                }
                float max = Math.max(f3, rect.left);
                rectF = this.b0;
                rectF.left = max;
                rectF.top = rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f4 = (width / 2.0f) + (c3849pe.a0 / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (c3849pe.D) {
                        f5 = c3849pe.a0;
                        f4 = f5 + max;
                    } else {
                        i = rect.right;
                        f4 = i;
                    }
                } else if (c3849pe.D) {
                    i = rect.right;
                    f4 = i;
                } else {
                    f5 = c3849pe.a0;
                    f4 = f5 + max;
                }
                rectF.right = Math.min(f4, rect.right);
                rectF.bottom = c3849pe.f() + rect.top;
                if (c3849pe.Z != null && !c3849pe.o()) {
                    StaticLayout staticLayout = c3849pe.Z;
                    float lineWidth = (c3849pe.i / c3849pe.h) * staticLayout.getLineWidth(staticLayout.getLineCount() - 1);
                    if (c3849pe.D) {
                        rectF.right = rectF.left + lineWidth;
                    } else {
                        rectF.left = rectF.right - lineWidth;
                    }
                }
                if (rectF.width() > 0.0f || rectF.height() <= 0.0f) {
                }
                float f6 = rectF.left;
                float f7 = this.O;
                rectF.left = f6 - f7;
                rectF.right += f7;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.R);
                rectF.top = 0.0f;
                C0329Mi c0329Mi = (C0329Mi) this.G;
                c0329Mi.getClass();
                c0329Mi.t(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            f = width / 2.0f;
            f2 = c3849pe.a0 / 2.0f;
            f3 = f - f2;
            float max2 = Math.max(f3, rect.left);
            rectF = this.b0;
            rectF.left = max2;
            rectF.top = rect.top;
            if (gravity != 17) {
            }
            f4 = (width / 2.0f) + (c3849pe.a0 / 2.0f);
            rectF.right = Math.min(f4, rect.right);
            rectF.bottom = c3849pe.f() + rect.top;
            if (c3849pe.Z != null) {
                StaticLayout staticLayout2 = c3849pe.Z;
                float lineWidth2 = (c3849pe.i / c3849pe.h) * staticLayout2.getLineWidth(staticLayout2.getLineCount() - 1);
                if (c3849pe.D) {
                }
            }
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void n(T5 t5, int i) {
        try {
            t5.setTextAppearance(i);
            if (t5.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        t5.setTextAppearance(dastan.prince.bdfreevpn.R.style.TextAppearance_AppCompat_Caption);
        t5.setTextColor(getContext().getColor(dastan.prince.bdfreevpn.R.color.design_error));
    }

    public final boolean o() {
        C3554lx c3554lx = this.k;
        return (c3554lx.o != 1 || c3554lx.r == null || TextUtils.isEmpty(c3554lx.p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.w0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        C4097so c4097so = this.c;
        c4097so.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.C0 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (max = Math.max(c4097so.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.e.setMinimumHeight(max);
            z = true;
        }
        boolean s = s();
        if (z || s) {
            this.e.post(new RunnableC3954r1(this, 16));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float descent;
        int i5;
        int compoundPaddingTop;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.e;
        if (editText != null) {
            Rect rect = this.W;
            AbstractC2984el.a(this, editText, rect);
            JE je = this.K;
            if (je != null) {
                int i6 = rect.bottom;
                je.setBounds(rect.left, i6 - this.S, rect.right, i6);
            }
            JE je2 = this.L;
            if (je2 != null) {
                int i7 = rect.bottom;
                je2.setBounds(rect.left, i7 - this.T, rect.right, i7);
            }
            if (this.D) {
                float textSize = this.e.getTextSize();
                C3849pe c3849pe = this.w0;
                if (c3849pe.h != textSize) {
                    c3849pe.h = textSize;
                    c3849pe.j(false);
                }
                int gravity = this.e.getGravity();
                int i8 = (gravity & (-113)) | 48;
                if (c3849pe.g != i8) {
                    c3849pe.g = i8;
                    c3849pe.j(false);
                }
                if (c3849pe.f != gravity) {
                    c3849pe.f = gravity;
                    c3849pe.j(false);
                }
                Rect d = d(rect);
                int i9 = d.left;
                int i10 = d.top;
                int i11 = d.right;
                int i12 = d.bottom;
                Rect rect2 = c3849pe.d;
                if (rect2.left != i9 || rect2.top != i10 || rect2.right != i11 || rect2.bottom != i12) {
                    rect2.set(i9, i10, i11, i12);
                    c3849pe.N = true;
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                int hintMaxLines = getHintMaxLines();
                TextPaint textPaint = c3849pe.P;
                if (hintMaxLines == 1) {
                    textPaint.setTextSize(c3849pe.h);
                    textPaint.setTypeface(c3849pe.v);
                    textPaint.setLetterSpacing(c3849pe.X);
                    descent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(c3849pe.h);
                    textPaint.setTypeface(c3849pe.v);
                    textPaint.setLetterSpacing(c3849pe.X);
                    descent = c3849pe.l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.a0;
                rect3.left = compoundPaddingLeft;
                if (this.P == 1 && this.e.getMinLines() <= 1) {
                    compoundPaddingTop = (int) (rect.centerY() - (descent / 2.0f));
                } else {
                    if (this.P != 0 || getHintMaxLines() == 1) {
                        i5 = 0;
                    } else {
                        textPaint.setTextSize(c3849pe.h);
                        textPaint.setTypeface(c3849pe.v);
                        textPaint.setLetterSpacing(c3849pe.X);
                        i5 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.e.getCompoundPaddingTop() + rect.top) - i5;
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.P != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect3.top + descent);
                rect3.bottom = compoundPaddingBottom;
                int i13 = rect3.left;
                int i14 = rect3.top;
                int i15 = rect3.right;
                Rect rect4 = c3849pe.c;
                if (!(rect4.left == i13 && rect4.top == i14 && rect4.right == i15 && rect4.bottom == compoundPaddingBottom) || true != c3849pe.k0) {
                    rect4.set(i13, i14, i15, compoundPaddingBottom);
                    c3849pe.N = true;
                    c3849pe.k0 = true;
                }
                c3849pe.j(false);
                if (!g() || this.v0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        float f;
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.C0;
        C4097so c4097so = this.c;
        if (!z) {
            c4097so.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        if (this.u != null && (editText = this.e) != null) {
            this.u.setGravity(editText.getGravity());
            this.u.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        c4097so.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.e.getMeasuredWidth() - this.e.getCompoundPaddingLeft()) - this.e.getCompoundPaddingRight();
        C3849pe c3849pe = this.w0;
        TextPaint textPaint = c3849pe.P;
        textPaint.setTextSize(c3849pe.i);
        textPaint.setTypeface(c3849pe.s);
        textPaint.setLetterSpacing(c3849pe.W);
        float f2 = measuredWidth;
        c3849pe.i0 = c3849pe.e(c3849pe.f0, textPaint, c3849pe.B, (c3849pe.i / c3849pe.h) * f2, c3849pe.D).getHeight();
        textPaint.setTextSize(c3849pe.h);
        textPaint.setTypeface(c3849pe.v);
        textPaint.setLetterSpacing(c3849pe.X);
        c3849pe.j0 = c3849pe.e(c3849pe.e0, textPaint, c3849pe.B, f2, c3849pe.D).getHeight();
        EditText editText2 = this.e;
        Rect rect = this.W;
        AbstractC2984el.a(this, editText2, rect);
        Rect d = d(rect);
        int i3 = d.left;
        int i4 = d.top;
        int i5 = d.right;
        int i6 = d.bottom;
        Rect rect2 = c3849pe.d;
        if (rect2.left != i3 || rect2.top != i4 || rect2.right != i5 || rect2.bottom != i6) {
            rect2.set(i3, i4, i5, i6);
            c3849pe.N = true;
        }
        v();
        a();
        if (this.e == null) {
            return;
        }
        int i7 = c3849pe.j0;
        if (i7 != -1) {
            f = i7;
        } else {
            TextPaint textPaint2 = c3849pe.P;
            textPaint2.setTextSize(c3849pe.h);
            textPaint2.setTypeface(c3849pe.v);
            textPaint2.setLetterSpacing(c3849pe.X);
            f = -textPaint2.ascent();
        }
        if (this.s != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.u.getPaint());
            textPaint3.setTextSize(this.u.getTextSize());
            textPaint3.setTypeface(this.u.getTypeface());
            textPaint3.setLetterSpacing(this.u.getLetterSpacing());
            C0727aV c0727aV = new C0727aV(this.s, textPaint3, measuredWidth);
            c0727aV.k = getLayoutDirection() == 1;
            c0727aV.j = true;
            float lineSpacingExtra = this.u.getLineSpacingExtra();
            float lineSpacingMultiplier = this.u.getLineSpacingMultiplier();
            c0727aV.g = lineSpacingExtra;
            c0727aV.h = lineSpacingMultiplier;
            c0727aV.m = new C3290ic(this, 20);
            r3 = (this.P == 1 ? c3849pe.f() + this.Q + this.d : 0.0f) + c0727aV.a().getHeight();
        }
        float max = Math.max(f, r3);
        if (this.e.getMeasuredHeight() < max) {
            this.e.setMinimumHeight(Math.round(max));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof FW)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        FW fw = (FW) parcelable;
        super.onRestoreInstanceState(fw.a);
        setError(fw.c);
        if (fw.d) {
            post(new S7(this, 22));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.N) {
            InterfaceC0509Tg interfaceC0509Tg = this.M.e;
            RectF rectF = this.b0;
            float a = interfaceC0509Tg.a(rectF);
            float a2 = this.M.f.a(rectF);
            float a3 = this.M.h.a(rectF);
            float a4 = this.M.g.a(rectF);
            C4464xS c4464xS = this.M;
            W80 w80 = c4464xS.a;
            W80 w802 = c4464xS.b;
            W80 w803 = c4464xS.d;
            W80 w804 = c4464xS.c;
            C4254un c4254un = new C4254un(0);
            C4254un c4254un2 = new C4254un(0);
            C4254un c4254un3 = new C4254un(0);
            C4254un c4254un4 = new C4254un(0);
            C4385wS.b(w802);
            C4385wS.b(w80);
            C4385wS.b(w804);
            C4385wS.b(w803);
            C3317j c3317j = new C3317j(a2);
            C3317j c3317j2 = new C3317j(a);
            C3317j c3317j3 = new C3317j(a4);
            C3317j c3317j4 = new C3317j(a3);
            C4464xS c4464xS2 = new C4464xS();
            c4464xS2.a = w802;
            c4464xS2.b = w80;
            c4464xS2.c = w803;
            c4464xS2.d = w804;
            c4464xS2.e = c3317j;
            c4464xS2.f = c3317j2;
            c4464xS2.g = c3317j4;
            c4464xS2.h = c3317j3;
            c4464xS2.i = c4254un;
            c4464xS2.j = c4254un2;
            c4464xS2.k = c4254un3;
            c4464xS2.l = c4254un4;
            this.N = z;
            setShapeAppearanceModel(c4464xS2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        FW fw = new FW(super.onSaveInstanceState());
        if (o()) {
            fw.c = getError();
        }
        C4097so c4097so = this.c;
        fw.d = c4097so.i != 0 && c4097so.g.d;
        return fw;
    }

    public final void p(Editable editable) {
        ((CP) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.n;
        int i = this.m;
        String str = null;
        if (i == -1) {
            this.p.setText(String.valueOf(length));
            this.p.setContentDescription(null);
            this.n = false;
        } else {
            this.n = length > i;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.n ? dastan.prince.bdfreevpn.R.string.character_counter_overflowed_content_description : dastan.prince.bdfreevpn.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.m)));
            if (z != this.n) {
                q();
            }
            String str2 = C0010Aa.b;
            C0010Aa c0010Aa = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? C0010Aa.e : C0010Aa.d;
            T5 t5 = this.p;
            String string = getContext().getString(dastan.prince.bdfreevpn.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m));
            if (string == null) {
                c0010Aa.getClass();
            } else {
                c0010Aa.getClass();
                C0270Ka c0270Ka = AbstractC4626zW.a;
                str = c0010Aa.c(string).toString();
            }
            t5.setText(str);
        }
        if (this.e == null || z == this.n) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        T5 t5 = this.p;
        if (t5 != null) {
            n(t5, this.n ? this.q : this.r);
            if (!this.n && (colorStateList2 = this.z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.A) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    public final void r() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.B;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue Y = AbstractC0731aZ.Y(context, dastan.prince.bdfreevpn.R.attr.colorControlActivated);
            if (Y != null) {
                int i = Y.resourceId;
                if (i != 0) {
                    colorStateList2 = AbstractC3131gc0.u(context, i);
                } else {
                    int i2 = Y.data;
                    if (i2 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i2);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.e;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.e.getTextCursorDrawable();
            Drawable mutate = textCursorDrawable2.mutate();
            if ((o() || (this.p != null && this.n)) && (colorStateList = this.C) != null) {
                colorStateList2 = colorStateList;
            }
            mutate.setTintList(colorStateList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s() {
        boolean z;
        C4097so c4097so;
        Drawable[] compoundDrawablesRelative;
        ColorDrawable colorDrawable;
        Drawable drawable;
        ColorDrawable colorDrawable2;
        if (this.e == null) {
            return false;
        }
        CheckableImageButton checkableImageButton = null;
        boolean z2 = true;
        if (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) {
            NU nu = this.b;
            if (nu.getMeasuredWidth() > 0) {
                int measuredWidth = nu.getMeasuredWidth() - this.e.getPaddingLeft();
                if (this.d0 == null || this.e0 != measuredWidth) {
                    ColorDrawable colorDrawable3 = new ColorDrawable();
                    this.d0 = colorDrawable3;
                    this.e0 = measuredWidth;
                    colorDrawable3.setBounds(0, 0, measuredWidth, 1);
                }
                Drawable[] compoundDrawablesRelative2 = this.e.getCompoundDrawablesRelative();
                Drawable drawable2 = compoundDrawablesRelative2[0];
                ColorDrawable colorDrawable4 = this.d0;
                if (drawable2 != colorDrawable4) {
                    this.e.setCompoundDrawablesRelative(colorDrawable4, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                    z = true;
                    c4097so = this.c;
                    if ((!c4097so.e() || ((c4097so.i != 0 && c4097so.d()) || c4097so.p != null)) && c4097so.getMeasuredWidth() > 0) {
                        int measuredWidth2 = c4097so.q.getMeasuredWidth() - this.e.getPaddingRight();
                        if (!c4097so.e()) {
                            checkableImageButton = c4097so.c;
                        } else if (c4097so.i != 0 && c4097so.d()) {
                            checkableImageButton = c4097so.g;
                        }
                        if (checkableImageButton != null) {
                            measuredWidth2 = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth() + measuredWidth2;
                        }
                        compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
                        colorDrawable = this.g0;
                        if (colorDrawable == null && this.h0 != measuredWidth2) {
                            this.h0 = measuredWidth2;
                            colorDrawable.setBounds(0, 0, measuredWidth2, 1);
                            this.e.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.g0, compoundDrawablesRelative[3]);
                            return true;
                        }
                        if (colorDrawable == null) {
                            ColorDrawable colorDrawable5 = new ColorDrawable();
                            this.g0 = colorDrawable5;
                            this.h0 = measuredWidth2;
                            colorDrawable5.setBounds(0, 0, measuredWidth2, 1);
                        }
                        drawable = compoundDrawablesRelative[2];
                        colorDrawable2 = this.g0;
                        if (drawable != colorDrawable2) {
                            this.i0 = drawable;
                            this.e.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], colorDrawable2, compoundDrawablesRelative[3]);
                            return true;
                        }
                    } else if (this.g0 != null) {
                        Drawable[] compoundDrawablesRelative3 = this.e.getCompoundDrawablesRelative();
                        if (compoundDrawablesRelative3[2] == this.g0) {
                            this.e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.i0, compoundDrawablesRelative3[3]);
                        } else {
                            z2 = z;
                        }
                        this.g0 = null;
                        return z2;
                    }
                    return z;
                }
                z = false;
                c4097so = this.c;
                if (c4097so.e()) {
                }
                int measuredWidth22 = c4097so.q.getMeasuredWidth() - this.e.getPaddingRight();
                if (!c4097so.e()) {
                }
                if (checkableImageButton != null) {
                }
                compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
                colorDrawable = this.g0;
                if (colorDrawable == null) {
                }
                if (colorDrawable == null) {
                }
                drawable = compoundDrawablesRelative[2];
                colorDrawable2 = this.g0;
                if (drawable != colorDrawable2) {
                }
                return z;
            }
        }
        if (this.d0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.e.getCompoundDrawablesRelative();
            this.e.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.d0 = null;
            z = true;
            c4097so = this.c;
            if (c4097so.e()) {
            }
            int measuredWidth222 = c4097so.q.getMeasuredWidth() - this.e.getPaddingRight();
            if (!c4097so.e()) {
            }
            if (checkableImageButton != null) {
            }
            compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
            colorDrawable = this.g0;
            if (colorDrawable == null) {
            }
            if (colorDrawable == null) {
            }
            drawable = compoundDrawablesRelative[2];
            colorDrawable2 = this.g0;
            if (drawable != colorDrawable2) {
            }
            return z;
        }
        z = false;
        c4097so = this.c;
        if (c4097so.e()) {
        }
        int measuredWidth2222 = c4097so.q.getMeasuredWidth() - this.e.getPaddingRight();
        if (!c4097so.e()) {
        }
        if (checkableImageButton != null) {
        }
        compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
        colorDrawable = this.g0;
        if (colorDrawable == null) {
        }
        if (colorDrawable == null) {
        }
        drawable = compoundDrawablesRelative[2];
        colorDrawable2 = this.g0;
        if (drawable != colorDrawable2) {
        }
        return z;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.V != i) {
            this.V = i;
            this.p0 = i;
            this.r0 = i;
            this.s0 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.p0 = defaultColor;
        this.V = defaultColor;
        this.q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.s0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.P) {
            return;
        }
        this.P = i;
        if (this.e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.Q = i;
    }

    public void setBoxCornerFamily(int i) {
        C4385wS f = this.M.f();
        InterfaceC0509Tg interfaceC0509Tg = this.M.e;
        W80 k = AbstractC3131gc0.k(i);
        f.a = k;
        C4385wS.b(k);
        f.e = interfaceC0509Tg;
        InterfaceC0509Tg interfaceC0509Tg2 = this.M.f;
        W80 k2 = AbstractC3131gc0.k(i);
        f.b = k2;
        C4385wS.b(k2);
        f.f = interfaceC0509Tg2;
        InterfaceC0509Tg interfaceC0509Tg3 = this.M.h;
        W80 k3 = AbstractC3131gc0.k(i);
        f.d = k3;
        C4385wS.b(k3);
        f.h = interfaceC0509Tg3;
        InterfaceC0509Tg interfaceC0509Tg4 = this.M.g;
        W80 k4 = AbstractC3131gc0.k(i);
        f.c = k4;
        C4385wS.b(k4);
        f.g = interfaceC0509Tg4;
        this.M = f.a();
        c();
    }

    public void setBoxStrokeColor(int i) {
        if (this.n0 != i) {
            this.n0 = i;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.l0 = colorStateList.getDefaultColor();
            this.t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.m0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.n0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.n0 != colorStateList.getDefaultColor()) {
            this.n0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.o0 != colorStateList) {
            this.o0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.S = i;
        z();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.T = i;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            C3554lx c3554lx = this.k;
            if (z) {
                T5 t5 = new T5(getContext(), null);
                this.p = t5;
                t5.setId(dastan.prince.bdfreevpn.R.id.textinput_counter);
                Typeface typeface = this.c0;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                c3554lx.a(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.p != null) {
                    EditText editText = this.e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                c3554lx.g(this.p, 2);
                this.p = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i > 0) {
                this.m = i;
            } else {
                this.m = -1;
            }
            if (!this.l || this.p == null) {
                return;
            }
            EditText editText = this.e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.r != i) {
            this.r = i;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (o() || (this.p != null && this.n)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.j0 = colorStateList;
        this.k0 = colorStateList;
        if (this.e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.c.g.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.c.g.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        C4097so c4097so = this.c;
        CharSequence text = i != 0 ? c4097so.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = c4097so.g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        C4097so c4097so = this.c;
        Drawable k = i != 0 ? XE.k(c4097so.getContext(), i) : null;
        CheckableImageButton checkableImageButton = c4097so.g;
        checkableImageButton.setImageDrawable(k);
        if (k != null) {
            ColorStateList colorStateList = c4097so.k;
            PorterDuff.Mode mode = c4097so.l;
            TextInputLayout textInputLayout = c4097so.a;
            AbstractC0641Yi.c(textInputLayout, checkableImageButton, colorStateList, mode);
            AbstractC0641Yi.U(textInputLayout, checkableImageButton, c4097so.k);
        }
    }

    public void setEndIconMinSize(int i) {
        C4097so c4097so = this.c;
        if (i < 0) {
            c4097so.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != c4097so.m) {
            c4097so.m = i;
            CheckableImageButton checkableImageButton = c4097so.g;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = c4097so.c;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.c.g(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        C4097so c4097so = this.c;
        View.OnLongClickListener onLongClickListener = c4097so.o;
        CheckableImageButton checkableImageButton = c4097so.g;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C4097so c4097so = this.c;
        c4097so.o = onLongClickListener;
        CheckableImageButton checkableImageButton = c4097so.g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        C4097so c4097so = this.c;
        c4097so.n = scaleType;
        c4097so.g.setScaleType(scaleType);
        c4097so.c.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        C4097so c4097so = this.c;
        if (c4097so.k != colorStateList) {
            c4097so.k = colorStateList;
            AbstractC0641Yi.c(c4097so.a, c4097so.g, colorStateList, c4097so.l);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        C4097so c4097so = this.c;
        if (c4097so.l != mode) {
            c4097so.l = mode;
            AbstractC0641Yi.c(c4097so.a, c4097so.g, c4097so.k, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.c.h(z);
    }

    public void setError(CharSequence charSequence) {
        C3554lx c3554lx = this.k;
        if (!c3554lx.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            c3554lx.f();
            return;
        }
        c3554lx.c();
        c3554lx.p = charSequence;
        c3554lx.r.setText(charSequence);
        int i = c3554lx.n;
        if (i != 1) {
            c3554lx.o = 1;
        }
        c3554lx.i(i, c3554lx.o, c3554lx.h(c3554lx.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        C3554lx c3554lx = this.k;
        c3554lx.t = i;
        T5 t5 = c3554lx.r;
        if (t5 != null) {
            t5.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        C3554lx c3554lx = this.k;
        c3554lx.s = charSequence;
        T5 t5 = c3554lx.r;
        if (t5 != null) {
            t5.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        C3554lx c3554lx = this.k;
        if (c3554lx.q == z) {
            return;
        }
        c3554lx.c();
        TextInputLayout textInputLayout = c3554lx.h;
        if (z) {
            T5 t5 = new T5(c3554lx.g, null);
            c3554lx.r = t5;
            t5.setId(dastan.prince.bdfreevpn.R.id.textinput_error);
            c3554lx.r.setTextAlignment(5);
            Typeface typeface = c3554lx.B;
            if (typeface != null) {
                c3554lx.r.setTypeface(typeface);
            }
            int i = c3554lx.u;
            c3554lx.u = i;
            T5 t52 = c3554lx.r;
            if (t52 != null) {
                textInputLayout.n(t52, i);
            }
            ColorStateList colorStateList = c3554lx.v;
            c3554lx.v = colorStateList;
            T5 t53 = c3554lx.r;
            if (t53 != null && colorStateList != null) {
                t53.setTextColor(colorStateList);
            }
            CharSequence charSequence = c3554lx.s;
            c3554lx.s = charSequence;
            T5 t54 = c3554lx.r;
            if (t54 != null) {
                t54.setContentDescription(charSequence);
            }
            int i2 = c3554lx.t;
            c3554lx.t = i2;
            T5 t55 = c3554lx.r;
            if (t55 != null) {
                t55.setAccessibilityLiveRegion(i2);
            }
            c3554lx.r.setVisibility(4);
            c3554lx.a(c3554lx.r, 0);
        } else {
            c3554lx.f();
            c3554lx.g(c3554lx.r, 0);
            c3554lx.r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        c3554lx.q = z;
    }

    public void setErrorIconDrawable(int i) {
        C4097so c4097so = this.c;
        c4097so.i(i != 0 ? XE.k(c4097so.getContext(), i) : null);
        AbstractC0641Yi.U(c4097so.a, c4097so.c, c4097so.d);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        C4097so c4097so = this.c;
        CheckableImageButton checkableImageButton = c4097so.c;
        View.OnLongClickListener onLongClickListener = c4097so.f;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        C4097so c4097so = this.c;
        c4097so.f = onLongClickListener;
        CheckableImageButton checkableImageButton = c4097so.c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        C4097so c4097so = this.c;
        if (c4097so.d != colorStateList) {
            c4097so.d = colorStateList;
            AbstractC0641Yi.c(c4097so.a, c4097so.c, colorStateList, c4097so.e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        C4097so c4097so = this.c;
        if (c4097so.e != mode) {
            c4097so.e = mode;
            AbstractC0641Yi.c(c4097so.a, c4097so.c, c4097so.d, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        C3554lx c3554lx = this.k;
        c3554lx.u = i;
        T5 t5 = c3554lx.r;
        if (t5 != null) {
            c3554lx.h.n(t5, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        C3554lx c3554lx = this.k;
        c3554lx.v = colorStateList;
        T5 t5 = c3554lx.r;
        if (t5 == null || colorStateList == null) {
            return;
        }
        t5.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.x0 != z) {
            this.x0 = z;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        C3554lx c3554lx = this.k;
        if (isEmpty) {
            if (c3554lx.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!c3554lx.x) {
            setHelperTextEnabled(true);
        }
        c3554lx.c();
        c3554lx.w = charSequence;
        c3554lx.y.setText(charSequence);
        int i = c3554lx.n;
        if (i != 2) {
            c3554lx.o = 2;
        }
        c3554lx.i(i, c3554lx.o, c3554lx.h(c3554lx.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        C3554lx c3554lx = this.k;
        c3554lx.A = colorStateList;
        T5 t5 = c3554lx.y;
        if (t5 == null || colorStateList == null) {
            return;
        }
        t5.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        C3554lx c3554lx = this.k;
        if (c3554lx.x == z) {
            return;
        }
        c3554lx.c();
        if (z) {
            T5 t5 = new T5(c3554lx.g, null);
            c3554lx.y = t5;
            t5.setId(dastan.prince.bdfreevpn.R.id.textinput_helper_text);
            c3554lx.y.setTextAlignment(5);
            Typeface typeface = c3554lx.B;
            if (typeface != null) {
                c3554lx.y.setTypeface(typeface);
            }
            c3554lx.y.setVisibility(4);
            c3554lx.y.setAccessibilityLiveRegion(1);
            int i = c3554lx.z;
            c3554lx.z = i;
            T5 t52 = c3554lx.y;
            if (t52 != null) {
                t52.setTextAppearance(i);
            }
            ColorStateList colorStateList = c3554lx.A;
            c3554lx.A = colorStateList;
            T5 t53 = c3554lx.y;
            if (t53 != null && colorStateList != null) {
                t53.setTextColor(colorStateList);
            }
            c3554lx.a(c3554lx.y, 1);
            c3554lx.y.setAccessibilityDelegate(new C3474kx(c3554lx));
        } else {
            c3554lx.c();
            int i2 = c3554lx.n;
            if (i2 == 2) {
                c3554lx.o = 0;
            }
            c3554lx.i(i2, c3554lx.o, c3554lx.h(c3554lx.y, ""));
            c3554lx.g(c3554lx.y, 1);
            c3554lx.y = null;
            TextInputLayout textInputLayout = c3554lx.h;
            textInputLayout.t();
            textInputLayout.z();
        }
        c3554lx.x = z;
    }

    public void setHelperTextTextAppearance(int i) {
        C3554lx c3554lx = this.k;
        c3554lx.z = i;
        T5 t5 = c3554lx.y;
        if (t5 != null) {
            t5.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.y0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.D) {
            this.D = z;
            if (z) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i) {
        C3849pe c3849pe = this.w0;
        if (i != c3849pe.f0) {
            c3849pe.f0 = i;
            c3849pe.j(false);
        }
        if (i != c3849pe.e0) {
            c3849pe.e0 = i;
            c3849pe.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        C3849pe c3849pe = this.w0;
        TextInputLayout textInputLayout = c3849pe.a;
        C4547yW c4547yW = new C4547yW(textInputLayout.getContext(), i);
        ColorStateList colorStateList = c4547yW.k;
        if (colorStateList != null) {
            c3849pe.k = colorStateList;
        }
        float f = c4547yW.l;
        if (f != 0.0f) {
            c3849pe.i = f;
        }
        ColorStateList colorStateList2 = c4547yW.a;
        if (colorStateList2 != null) {
            c3849pe.V = colorStateList2;
        }
        c3849pe.T = c4547yW.f;
        c3849pe.U = c4547yW.g;
        c3849pe.S = c4547yW.h;
        c3849pe.W = c4547yW.j;
        C0504Tb c0504Tb = c3849pe.z;
        if (c0504Tb != null) {
            c0504Tb.s = true;
        }
        C2835cv c2835cv = new C2835cv(c3849pe, 10);
        c4547yW.a();
        c3849pe.z = new C0504Tb(c2835cv, c4547yW.p);
        c4547yW.b(textInputLayout.getContext(), c3849pe.z);
        c3849pe.j(false);
        this.k0 = c3849pe.k;
        if (this.e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.k0 != colorStateList) {
            if (this.j0 == null) {
                C3849pe c3849pe = this.w0;
                if (c3849pe.k != colorStateList) {
                    c3849pe.k = colorStateList;
                    c3849pe.j(false);
                }
            }
            this.k0 = colorStateList;
            if (this.e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(EW ew) {
        this.o = ew;
    }

    public void setMaxEms(int i) {
        this.h = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.j = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.g = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.i = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        C4097so c4097so = this.c;
        c4097so.g.setContentDescription(i != 0 ? c4097so.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        C4097so c4097so = this.c;
        c4097so.g.setImageDrawable(i != 0 ? XE.k(c4097so.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        C4097so c4097so = this.c;
        if (z && c4097so.i != 1) {
            c4097so.g(1);
        } else if (z) {
            c4097so.getClass();
        } else {
            c4097so.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        C4097so c4097so = this.c;
        c4097so.k = colorStateList;
        AbstractC0641Yi.c(c4097so.a, c4097so.g, colorStateList, c4097so.l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        C4097so c4097so = this.c;
        c4097so.l = mode;
        AbstractC0641Yi.c(c4097so.a, c4097so.g, c4097so.k, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.u == null) {
            T5 t5 = new T5(getContext(), null);
            this.u = t5;
            t5.setId(dastan.prince.bdfreevpn.R.id.textinput_placeholder);
            this.u.setImportantForAccessibility(1);
            this.u.setAccessibilityLiveRegion(1);
            C0492Sp f = f();
            this.x = f;
            f.b = 67L;
            this.y = f();
            setPlaceholderTextAppearance(this.w);
            setPlaceholderTextColor(this.v);
            AbstractC2925e20.m(this.u, new C0618Xl(5));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.t) {
                setPlaceholderTextEnabled(true);
            }
            this.s = charSequence;
        }
        EditText editText = this.e;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.w = i;
        T5 t5 = this.u;
        if (t5 != null) {
            t5.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            T5 t5 = this.u;
            if (t5 == null || colorStateList == null) {
                return;
            }
            t5.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        NU nu = this.b;
        nu.getClass();
        nu.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        nu.b.setText(charSequence);
        nu.e();
    }

    public void setPrefixTextAppearance(int i) {
        this.b.b.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.b.b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(C4464xS c4464xS) {
        JE je = this.G;
        if (je == null || je.b.a == c4464xS) {
            return;
        }
        this.M = c4464xS;
        c();
    }

    public void setStartIconCheckable(boolean z) {
        this.b.d.setCheckable(z);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.b.d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? XE.k(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        NU nu = this.b;
        if (i < 0) {
            nu.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != nu.g) {
            nu.g = i;
            CheckableImageButton checkableImageButton = nu.d;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        NU nu = this.b;
        View.OnLongClickListener onLongClickListener = nu.i;
        CheckableImageButton checkableImageButton = nu.d;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        NU nu = this.b;
        nu.i = onLongClickListener;
        CheckableImageButton checkableImageButton = nu.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        NU nu = this.b;
        nu.h = scaleType;
        nu.d.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        NU nu = this.b;
        if (nu.e != colorStateList) {
            nu.e = colorStateList;
            AbstractC0641Yi.c(nu.a, nu.d, colorStateList, nu.f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        NU nu = this.b;
        if (nu.f != mode) {
            nu.f = mode;
            AbstractC0641Yi.c(nu.a, nu.d, nu.e, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.b.c(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        C4097so c4097so = this.c;
        c4097so.getClass();
        c4097so.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        c4097so.q.setText(charSequence);
        c4097so.n();
    }

    public void setSuffixTextAppearance(int i) {
        this.c.q.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.c.q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(DW dw) {
        EditText editText = this.e;
        if (editText != null) {
            AbstractC2925e20.m(editText, dw);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.c0) {
            this.c0 = typeface;
            this.w0.n(typeface);
            C3554lx c3554lx = this.k;
            if (typeface != c3554lx.B) {
                c3554lx.B = typeface;
                T5 t5 = c3554lx.r;
                if (t5 != null) {
                    t5.setTypeface(typeface);
                }
                T5 t52 = c3554lx.y;
                if (t52 != null) {
                    t52.setTypeface(typeface);
                }
            }
            T5 t53 = this.p;
            if (t53 != null) {
                t53.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        T5 t5;
        EditText editText = this.e;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = AbstractC0540Ul.a;
        Drawable mutate = background.mutate();
        if (o()) {
            mutate.setColorFilter(C3408k5.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (t5 = this.p) != null) {
            mutate.setColorFilter(C3408k5.c(t5.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            mutate.clearColorFilter();
            this.e.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.e;
        if (editText == null || this.G == null) {
            return;
        }
        if ((this.J || editText.getBackground() == null) && this.P != 0) {
            this.e.setBackground(getEditTextBoxBackground());
            this.J = true;
        }
    }

    public final void v() {
        if (this.P != 1) {
            FrameLayout frameLayout = this.a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int e = e();
            if (e != layoutParams.topMargin) {
                layoutParams.topMargin = e;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z, boolean z2) {
        ColorStateList colorStateList;
        T5 t5;
        boolean isEnabled = isEnabled();
        EditText editText = this.e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.j0;
        C3849pe c3849pe = this.w0;
        if (colorStateList2 != null) {
            c3849pe.k(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.j0;
            c3849pe.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.t0) : this.t0));
        } else if (o()) {
            T5 t52 = this.k.r;
            c3849pe.k(t52 != null ? t52.getTextColors() : null);
        } else if (this.n && (t5 = this.p) != null) {
            c3849pe.k(t5.getTextColors());
        } else if (z4 && (colorStateList = this.k0) != null && c3849pe.k != colorStateList) {
            c3849pe.k = colorStateList;
            c3849pe.j(false);
        }
        C4097so c4097so = this.c;
        NU nu = this.b;
        if (z3 || !this.x0 || (isEnabled() && z4)) {
            if (z2 || this.v0) {
                ValueAnimator valueAnimator = this.z0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.z0.cancel();
                }
                if (z && this.y0) {
                    b(1.0f);
                } else {
                    c3849pe.m(1.0f);
                }
                this.v0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.e;
                x(editText3 != null ? editText3.getText() : null);
                nu.j = false;
                nu.e();
                c4097so.r = false;
                c4097so.n();
                return;
            }
            return;
        }
        if (z2 || !this.v0) {
            ValueAnimator valueAnimator2 = this.z0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.z0.cancel();
            }
            if (z && this.y0) {
                b(0.0f);
            } else {
                c3849pe.m(0.0f);
            }
            if (g() && !((C0329Mi) this.G).H.r.isEmpty() && g()) {
                ((C0329Mi) this.G).t(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.v0 = true;
            T5 t53 = this.u;
            if (t53 != null && this.t) {
                t53.setText((CharSequence) null);
                XX.a(this.a, this.y);
                this.u.setVisibility(4);
            }
            nu.j = true;
            nu.e();
            c4097so.r = true;
            c4097so.n();
        }
    }

    public final void x(Editable editable) {
        ((CP) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.a;
        if (length != 0 || this.v0) {
            T5 t5 = this.u;
            if (t5 == null || !this.t) {
                return;
            }
            t5.setText((CharSequence) null);
            XX.a(frameLayout, this.y);
            this.u.setVisibility(4);
            return;
        }
        if (this.u == null || !this.t || TextUtils.isEmpty(this.s)) {
            return;
        }
        this.u.setText(this.s);
        XX.a(frameLayout, this.x);
        this.u.setVisibility(0);
        this.u.bringToFront();
    }

    public final void y(boolean z, boolean z2) {
        int defaultColor = this.o0.getDefaultColor();
        int colorForState = this.o0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.o0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.U = colorForState2;
        } else if (z2) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    public final void z() {
        T5 t5;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.P == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.U = this.t0;
        } else if (o()) {
            if (this.o0 != null) {
                y(z2, z);
            } else {
                this.U = getErrorCurrentTextColors();
            }
        } else if (!this.n || (t5 = this.p) == null) {
            if (z2) {
                this.U = this.n0;
            } else if (z) {
                this.U = this.m0;
            } else {
                this.U = this.l0;
            }
        } else if (this.o0 != null) {
            y(z2, z);
        } else {
            this.U = t5.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        C4097so c4097so = this.c;
        c4097so.l();
        CheckableImageButton checkableImageButton = c4097so.c;
        ColorStateList colorStateList = c4097so.d;
        TextInputLayout textInputLayout = c4097so.a;
        AbstractC0641Yi.U(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = c4097so.k;
        CheckableImageButton checkableImageButton2 = c4097so.g;
        AbstractC0641Yi.U(textInputLayout, checkableImageButton2, colorStateList2);
        if (c4097so.b() instanceof C3780om) {
            if (!textInputLayout.o() || checkableImageButton2.getDrawable() == null) {
                AbstractC0641Yi.c(textInputLayout, checkableImageButton2, c4097so.k, c4097so.l);
            } else {
                Drawable mutate = checkableImageButton2.getDrawable().mutate();
                mutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(mutate);
            }
        }
        NU nu = this.b;
        AbstractC0641Yi.U(nu.a, nu.d, nu.e);
        if (this.P == 2) {
            int i = this.R;
            if (z2 && isEnabled()) {
                this.R = this.T;
            } else {
                this.R = this.S;
            }
            if (this.R != i && g() && !this.v0) {
                if (g()) {
                    ((C0329Mi) this.G).t(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.P == 1) {
            if (!isEnabled()) {
                this.V = this.q0;
            } else if (z && !z2) {
                this.V = this.s0;
            } else if (z2) {
                this.V = this.r0;
            } else {
                this.V = this.p0;
            }
        }
        c();
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.b.b(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.c.g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.c.g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.c.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.c.g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        C4097so c4097so = this.c;
        CheckableImageButton checkableImageButton = c4097so.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = c4097so.k;
            PorterDuff.Mode mode = c4097so.l;
            TextInputLayout textInputLayout = c4097so.a;
            AbstractC0641Yi.c(textInputLayout, checkableImageButton, colorStateList, mode);
            AbstractC0641Yi.U(textInputLayout, checkableImageButton, c4097so.k);
        }
    }
}
