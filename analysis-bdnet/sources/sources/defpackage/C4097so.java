package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import dastan.prince.bdfreevpn.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: so, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4097so extends LinearLayout {
    public final TextInputLayout a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public View.OnLongClickListener f;
    public final CheckableImageButton g;
    public final C3048fb h;
    public int i;
    public final LinkedHashSet j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence p;
    public final T5 q;
    public boolean r;
    public EditText s;
    public final AccessibilityManager t;
    public AccessibilityManager.TouchExplorationStateChangeListener u;
    public final C3940qo v;

    public C4097so(TextInputLayout textInputLayout, C4452xG c4452xG) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.i = 0;
        this.j = new LinkedHashSet();
        this.v = new C3940qo(this);
        C4018ro c4018ro = new C4018ro(this);
        this.t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a = a(this, from, R.id.text_input_error_icon);
        this.c = a;
        CheckableImageButton a2 = a(frameLayout, from, R.id.text_input_end_icon);
        this.g = a2;
        this.h = new C3048fb(this, c4452xG);
        T5 t5 = new T5(getContext(), null);
        this.q = t5;
        TypedArray typedArray = (TypedArray) c4452xG.c;
        if (typedArray.hasValue(38)) {
            this.d = W80.r(getContext(), c4452xG, 38);
        }
        if (typedArray.hasValue(39)) {
            this.e = F20.k(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(c4452xG.i(37));
        }
        a.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        a.setImportantForAccessibility(2);
        a.setClickable(false);
        a.setPressable(false);
        a.setCheckable(false);
        a.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.k = W80.r(getContext(), c4452xG, 32);
            }
            if (typedArray.hasValue(33)) {
                this.l = F20.k(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && a2.getContentDescription() != (text = typedArray.getText(27))) {
                a2.setContentDescription(text);
            }
            a2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.k = W80.r(getContext(), c4452xG, 55);
            }
            if (typedArray.hasValue(56)) {
                this.l = F20.k(typedArray.getInt(56, -1), null);
            }
            g(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (a2.getContentDescription() != text2) {
                a2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.m) {
            this.m = dimensionPixelSize;
            a2.setMinimumWidth(dimensionPixelSize);
            a2.setMinimumHeight(dimensionPixelSize);
            a.setMinimumWidth(dimensionPixelSize);
            a.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType n = AbstractC0641Yi.n(typedArray.getInt(31, -1));
            this.n = n;
            a2.setScaleType(n);
            a.setScaleType(n);
        }
        t5.setVisibility(8);
        t5.setId(R.id.textinput_suffix_text);
        t5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        t5.setAccessibilityLiveRegion(1);
        t5.setTextAppearance(typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            t5.setTextColor(c4452xG.h(74));
        }
        CharSequence text3 = typedArray.getText(72);
        this.p = TextUtils.isEmpty(text3) ? null : text3;
        t5.setText(text3);
        n();
        frameLayout.addView(a2);
        addView(t5);
        addView(frameLayout);
        addView(a);
        textInputLayout.f0.add(c4018ro);
        if (textInputLayout.e != null) {
            c4018ro.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2970ec(this, 1));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (W80.J(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final AbstractC4176to b() {
        AbstractC4176to c4091si;
        int i = this.i;
        C3048fb c3048fb = this.h;
        SparseArray sparseArray = (SparseArray) c3048fb.c;
        AbstractC4176to abstractC4176to = (AbstractC4176to) sparseArray.get(i);
        if (abstractC4176to != null) {
            return abstractC4176to;
        }
        C4097so c4097so = (C4097so) c3048fb.d;
        if (i == -1) {
            c4091si = new C4091si(c4097so, 0);
        } else if (i == 0) {
            c4091si = new C4091si(c4097so, 1);
        } else if (i == 1) {
            c4091si = new RJ(c4097so, c3048fb.b);
        } else if (i == 2) {
            c4091si = new C0273Kd(c4097so);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(W50.i(i, "Invalid end icon mode: "));
            }
            c4091si = new C3780om(c4097so);
        }
        sparseArray.append(i, c4091si);
        return c4091si;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z2;
        boolean isActivated;
        boolean z3;
        AbstractC4176to b = b();
        boolean k = b.k();
        CheckableImageButton checkableImageButton = this.g;
        boolean z4 = true;
        if (!k || (z3 = checkableImageButton.d) == b.l()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(b instanceof C3780om) || (isActivated = checkableImageButton.isActivated()) == b.j()) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z || z4) {
            AbstractC0641Yi.U(this.a, checkableImageButton, this.k);
        }
    }

    public final void g(int i) {
        if (this.i == i) {
            return;
        }
        AbstractC4176to b = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.u;
        AccessibilityManager accessibilityManager = this.t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.u = null;
        b.s();
        this.i = i;
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            throw W50.f(it);
        }
        h(i != 0);
        AbstractC4176to b2 = b();
        int i2 = this.h.a;
        if (i2 == 0) {
            i2 = b2.d();
        }
        Drawable k = i2 != 0 ? XE.k(getContext(), i2) : null;
        CheckableImageButton checkableImageButton = this.g;
        checkableImageButton.setImageDrawable(k);
        TextInputLayout textInputLayout = this.a;
        if (k != null) {
            AbstractC0641Yi.c(textInputLayout, checkableImageButton, this.k, this.l);
            AbstractC0641Yi.U(textInputLayout, checkableImageButton, this.k);
        }
        int c = b2.c();
        CharSequence text = c != 0 ? getResources().getText(c) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(b2.k());
        if (!b2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        b2.r();
        AccessibilityManager.TouchExplorationStateChangeListener h = b2.h();
        this.u = h;
        if (h != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.u);
        }
        View.OnClickListener f = b2.f();
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(f);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
        EditText editText = this.s;
        if (editText != null) {
            b2.m(editText);
            j(b2);
        }
        AbstractC0641Yi.c(textInputLayout, checkableImageButton, this.k, this.l);
        f(true);
    }

    public final void h(boolean z) {
        if (d() != z) {
            this.g.setVisibility(z ? 0 : 8);
            k();
            m();
            this.a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        AbstractC0641Yi.c(this.a, checkableImageButton, this.d, this.e);
    }

    public final void j(AbstractC4176to abstractC4176to) {
        if (this.s == null) {
            return;
        }
        if (abstractC4176to.e() != null) {
            this.s.setOnFocusChangeListener(abstractC4176to.e());
        }
        if (abstractC4176to.g() != null) {
            this.g.setOnFocusChangeListener(abstractC4176to.g());
        }
    }

    public final void k() {
        this.b.setVisibility((this.g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.p == null || this.r) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.k.q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.i != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.a;
        if (textInputLayout.e == null) {
            return;
        }
        this.q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.e.getPaddingEnd(), textInputLayout.e.getPaddingBottom());
    }

    public final void n() {
        T5 t5 = this.q;
        int visibility = t5.getVisibility();
        int i = (this.p == null || this.r) ? 8 : 0;
        if (visibility != i) {
            b().p(i == 0);
        }
        k();
        t5.setVisibility(i);
        this.a.s();
    }
}
