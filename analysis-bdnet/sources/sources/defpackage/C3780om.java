package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import dastan.prince.bdfreevpn.R;

/* renamed from: om, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3780om extends AbstractC4176to {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final ViewOnClickListenerC0169Gd i;
    public final ViewOnFocusChangeListenerC0195Hd j;
    public final AccessibilityManagerTouchExplorationStateChangeListenerC3701nm k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    /* JADX WARN: Type inference failed for: r0v2, types: [nm] */
    public C3780om(C4097so c4097so) {
        super(c4097so);
        int i = 1;
        this.i = new ViewOnClickListenerC0169Gd(this, i);
        this.j = new ViewOnFocusChangeListenerC0195Hd(this, i);
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: nm
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                C3780om c3780om = C3780om.this;
                AutoCompleteTextView autoCompleteTextView = c3780om.h;
                if (autoCompleteTextView == null || AbstractC3131gc0.x(autoCompleteTextView)) {
                    return;
                }
                c3780om.d.setImportantForAccessibility(z ? 2 : 1);
            }
        };
        this.o = Long.MAX_VALUE;
        this.f = AbstractC0731aZ.a0(c4097so.getContext(), R.attr.motionDurationShort3, 67);
        this.e = AbstractC0731aZ.a0(c4097so.getContext(), R.attr.motionDurationShort3, 50);
        this.g = AbstractC0731aZ.b0(c4097so.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC4434x4.a);
    }

    @Override // defpackage.AbstractC4176to
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && AbstractC3131gc0.x(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new RunnableC3954r1(this, 6));
    }

    @Override // defpackage.AbstractC4176to
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // defpackage.AbstractC4176to
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // defpackage.AbstractC4176to
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.k;
    }

    @Override // defpackage.AbstractC4176to
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // defpackage.AbstractC4176to
    public final boolean j() {
        return this.l;
    }

    @Override // defpackage.AbstractC4176to
    public final boolean l() {
        return this.n;
    }

    @Override // defpackage.AbstractC4176to
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC3543lm(this, 0));
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: mm
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                C3780om c3780om = C3780om.this;
                c3780om.m = true;
                c3780om.o = SystemClock.uptimeMillis();
                c3780om.t(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!AbstractC3131gc0.x(editText) && this.p.isTouchExplorationEnabled()) {
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // defpackage.AbstractC4176to
    public final void n(L0 l0) {
        if (!AbstractC3131gc0.x(this.h)) {
            l0.i(Spinner.class.getName());
        }
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = l0.a;
        if (i >= 26 ? accessibilityNodeInfo.isShowingHintText() : l0.e(4)) {
            if (i >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    @Override // defpackage.AbstractC4176to
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.p.isEnabled() || AbstractC3131gc0.x(this.h)) {
            return;
        }
        boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            u();
            this.m = true;
            this.o = SystemClock.uptimeMillis();
        }
    }

    @Override // defpackage.AbstractC4176to
    public final void r() {
        int i = 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f);
        ofFloat.addUpdateListener(new C0221Id(this, i));
        this.r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.e);
        ofFloat2.addUpdateListener(new C0221Id(this, i));
        this.q = ofFloat2;
        ofFloat2.addListener(new X0(this, i));
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // defpackage.AbstractC4176to
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void u() {
        if (this.h == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.o;
        if (uptimeMillis < 0 || uptimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        t(!this.n);
        if (!this.n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
