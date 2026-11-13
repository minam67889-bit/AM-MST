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
import app.vpn.amtunnellite.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: do, reason: invalid class name */
/* loaded from: classes.dex */
public final class Cdo extends LinearLayout {
    public final TextInputLayout a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public View.OnLongClickListener f;
    public final CheckableImageButton g;
    public final C0458Ra h;
    public int i;
    public final LinkedHashSet j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence p;
    public final I5 q;
    public boolean r;
    public EditText s;
    public final AccessibilityManager t;
    public AccessibilityManager.TouchExplorationStateChangeListener u;
    public final C0847bo v;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Cdo(TextInputLayout textInputLayout, LQ lq) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.i = 0;
        this.j = new LinkedHashSet();
        this.v = new C0847bo(this);
        C0923co c0923co = new C0923co(this);
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
        this.h = new C0458Ra(this, lq);
        I5 i5 = new I5(getContext(), null);
        this.q = i5;
        TypedArray typedArray = (TypedArray) lq.b;
        if (typedArray.hasValue(38)) {
            this.d = AbstractC3411gE.c0(getContext(), lq, 38);
        }
        if (typedArray.hasValue(39)) {
            this.e = AbstractC4311s10.r(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(lq.e(37));
        }
        a.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        a.setImportantForAccessibility(2);
        a.setClickable(false);
        a.setPressable(false);
        a.setCheckable(false);
        a.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.k = AbstractC3411gE.c0(getContext(), lq, 32);
            }
            if (typedArray.hasValue(33)) {
                this.l = AbstractC4311s10.r(typedArray.getInt(33, -1), null);
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
                this.k = AbstractC3411gE.c0(getContext(), lq, 55);
            }
            if (typedArray.hasValue(56)) {
                this.l = AbstractC4311s10.r(typedArray.getInt(56, -1), null);
            }
            g(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (a2.getContentDescription() != text2) {
                a2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.m) {
                this.m = dimensionPixelSize;
                a2.setMinimumWidth(dimensionPixelSize);
                a2.setMinimumHeight(dimensionPixelSize);
                a.setMinimumWidth(dimensionPixelSize);
                a.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(31)) {
                ImageView.ScaleType u = AbstractC4747xe.u(typedArray.getInt(31, -1));
                this.n = u;
                a2.setScaleType(u);
                a.setScaleType(u);
            }
            i5.setVisibility(8);
            i5.setId(R.id.textinput_suffix_text);
            i5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
            i5.setAccessibilityLiveRegion(1);
            i5.setTextAppearance(typedArray.getResourceId(73, 0));
            if (typedArray.hasValue(74)) {
                i5.setTextColor(lq.d(74));
            }
            CharSequence text3 = typedArray.getText(72);
            this.p = TextUtils.isEmpty(text3) ? null : text3;
            i5.setText(text3);
            n();
            frameLayout.addView(a2);
            addView(i5);
            addView(frameLayout);
            addView(a);
            textInputLayout.f0.add(c0923co);
            if (textInputLayout.e != null) {
                c0923co.a(textInputLayout);
            }
            addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0433Qb(this, 1));
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (AbstractC3411gE.x0(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AbstractC3297eo b() {
        AbstractC3297eo c3522hi;
        int i = this.i;
        C0458Ra c0458Ra = this.h;
        SparseArray sparseArray = (SparseArray) c0458Ra.c;
        AbstractC3297eo abstractC3297eo = (AbstractC3297eo) sparseArray.get(i);
        if (abstractC3297eo == null) {
            Cdo cdo = (Cdo) c0458Ra.d;
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                c3522hi = new C3678jm(cdo);
                            } else {
                                throw new IllegalArgumentException(T60.w(i, "Invalid end icon mode: "));
                            }
                        } else {
                            c3522hi = new C4668wd(cdo);
                        }
                    } else {
                        abstractC3297eo = new WI(cdo, c0458Ra.b);
                        sparseArray.append(i, abstractC3297eo);
                    }
                } else {
                    c3522hi = new C3522hi(cdo, 1);
                }
            } else {
                c3522hi = new C3522hi(cdo, 0);
            }
            abstractC3297eo = c3522hi;
            sparseArray.append(i, abstractC3297eo);
        }
        return abstractC3297eo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int c() {
        int marginStart;
        if (!d() && !e()) {
            marginStart = 0;
        } else {
            CheckableImageButton checkableImageButton = this.g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        }
        return this.q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean d() {
        if (this.b.getVisibility() == 0 && this.g.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean e() {
        if (this.c.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f(boolean z) {
        boolean z2;
        boolean isActivated;
        boolean z3;
        AbstractC3297eo b = b();
        boolean k = b.k();
        CheckableImageButton checkableImageButton = this.g;
        boolean z4 = true;
        if (k && (z3 = checkableImageButton.d) != b.l()) {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        } else {
            z2 = false;
        }
        if ((b instanceof C3678jm) && (isActivated = checkableImageButton.isActivated()) != b.j()) {
            checkableImageButton.setActivated(!isActivated);
        } else {
            z4 = z2;
        }
        if (z || z4) {
            AbstractC4747xe.T(this.a, checkableImageButton, this.k);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(int i) {
        boolean z;
        Drawable drawable;
        if (this.i == i) {
            return;
        }
        AbstractC3297eo b = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.u;
        AccessibilityManager accessibilityManager = this.t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        CharSequence charSequence = null;
        this.u = null;
        b.s();
        this.i = i;
        Iterator it = this.j.iterator();
        if (!it.hasNext()) {
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            h(z);
            AbstractC3297eo b2 = b();
            int i2 = this.h.a;
            if (i2 == 0) {
                i2 = b2.d();
            }
            if (i2 != 0) {
                drawable = AbstractC4766xx.D(getContext(), i2);
            } else {
                drawable = null;
            }
            CheckableImageButton checkableImageButton = this.g;
            checkableImageButton.setImageDrawable(drawable);
            TextInputLayout textInputLayout = this.a;
            if (drawable != null) {
                AbstractC4747xe.e(textInputLayout, checkableImageButton, this.k, this.l);
                AbstractC4747xe.T(textInputLayout, checkableImageButton, this.k);
            }
            int c = b2.c();
            if (c != 0) {
                charSequence = getResources().getText(c);
            }
            if (checkableImageButton.getContentDescription() != charSequence) {
                checkableImageButton.setContentDescription(charSequence);
            }
            checkableImageButton.setCheckable(b2.k());
            if (b2.i(textInputLayout.getBoxBackgroundMode())) {
                b2.r();
                AccessibilityManager.TouchExplorationStateChangeListener h = b2.h();
                this.u = h;
                if (h != null && accessibilityManager != null && isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(this.u);
                }
                View.OnClickListener f = b2.f();
                View.OnLongClickListener onLongClickListener = this.o;
                checkableImageButton.setOnClickListener(f);
                AbstractC4747xe.V(checkableImageButton, onLongClickListener);
                EditText editText = this.s;
                if (editText != null) {
                    b2.m(editText);
                    j(b2);
                }
                AbstractC4747xe.e(textInputLayout, checkableImageButton, this.k, this.l);
                f(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        AbstractC4575vQ.B(it.next());
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void h(boolean z) {
        int i;
        if (d() != z) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            this.g.setVisibility(i);
            k();
            m();
            this.a.s();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        AbstractC4747xe.e(this.a, checkableImageButton, this.d, this.e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void j(AbstractC3297eo abstractC3297eo) {
        if (this.s == null) {
            return;
        }
        if (abstractC3297eo.e() != null) {
            this.s.setOnFocusChangeListener(abstractC3297eo.e());
        }
        if (abstractC3297eo.g() != null) {
            this.g.setOnFocusChangeListener(abstractC3297eo.g());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void k() {
        int i;
        boolean z;
        int i2 = 8;
        if (this.g.getVisibility() == 0 && !e()) {
            i = 0;
        } else {
            i = 8;
        }
        this.b.setVisibility(i);
        if (this.p != null && !this.r) {
            z = false;
        } else {
            z = 8;
        }
        if (d() || e() || !z) {
            i2 = 0;
        }
        setVisibility(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void l() {
        int i;
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.a;
        if (drawable != null && textInputLayout.k.q && textInputLayout.o()) {
            i = 0;
        } else {
            i = 8;
        }
        checkableImageButton.setVisibility(i);
        k();
        m();
        if (this.i == 0) {
            textInputLayout.s();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void m() {
        int i;
        TextInputLayout textInputLayout = this.a;
        if (textInputLayout.e == null) {
            return;
        }
        if (!d() && !e()) {
            i = textInputLayout.e.getPaddingEnd();
        } else {
            i = 0;
        }
        this.q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.e.getPaddingTop(), i, textInputLayout.e.getPaddingBottom());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void n() {
        int i;
        I5 i5 = this.q;
        int visibility = i5.getVisibility();
        boolean z = false;
        if (this.p != null && !this.r) {
            i = 0;
        } else {
            i = 8;
        }
        if (visibility != i) {
            AbstractC3297eo b = b();
            if (i == 0) {
                z = true;
            }
            b.p(z);
        }
        k();
        i5.setVisibility(i);
        this.a.s();
    }
}
