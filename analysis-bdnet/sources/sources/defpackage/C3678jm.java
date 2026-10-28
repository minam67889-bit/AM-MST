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
import app.vpn.amtunnellite.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: jm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3678jm extends AbstractC3297eo {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final ViewOnClickListenerC4360sd i;
    public final ViewOnFocusChangeListenerC4437td j;
    public final AccessibilityManagerTouchExplorationStateChangeListenerC3602im k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    /* JADX WARN: Type inference failed for: r0v2, types: [im] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3678jm(Cdo cdo) {
        super(cdo);
        int i = 1;
        this.i = new ViewOnClickListenerC4360sd(this, i);
        this.j = new ViewOnFocusChangeListenerC4437td(this, i);
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: im
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                int i2;
                C3678jm c3678jm = C3678jm.this;
                AutoCompleteTextView autoCompleteTextView = c3678jm.h;
                if (autoCompleteTextView != null && !I70.y(autoCompleteTextView)) {
                    if (z) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    c3678jm.d.setImportantForAccessibility(i2);
                }
            }
        };
        this.o = Long.MAX_VALUE;
        this.f = AbstractC0363Nj.z(cdo.getContext(), R.attr.motionDurationShort3, 67);
        this.e = AbstractC0363Nj.z(cdo.getContext(), R.attr.motionDurationShort3, 50);
        this.g = AbstractC0363Nj.A(cdo.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC3778l4.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && I70.y(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new RunnableC4080p1(this, 7));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnClickListener f() {
        return this.i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final boolean i(int i) {
        if (i != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final boolean j() {
        return this.l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final boolean l() {
        return this.n;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void m(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            this.h = autoCompleteTextView;
            autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC3449gm(this, 0));
            this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: hm
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    C3678jm c3678jm = C3678jm.this;
                    c3678jm.m = true;
                    c3678jm.o = SystemClock.uptimeMillis();
                    c3678jm.t(false);
                }
            });
            this.h.setThreshold(0);
            TextInputLayout textInputLayout = this.a;
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!I70.y(editText) && this.p.isTouchExplorationEnabled()) {
                this.d.setImportantForAccessibility(2);
            }
            textInputLayout.setEndIconVisible(true);
            return;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void n(G0 g0) {
        boolean e;
        if (!I70.y(this.h)) {
            g0.i(Spinner.class.getName());
        }
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = g0.a;
        if (i >= 26) {
            e = accessibilityNodeInfo.isShowingHintText();
        } else {
            e = g0.e(4);
        }
        if (e) {
            if (i >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void o(AccessibilityEvent accessibilityEvent) {
        boolean z;
        if (this.p.isEnabled() && !I70.y(this.h)) {
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z) {
                u();
                this.m = true;
                this.o = SystemClock.uptimeMillis();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void r() {
        int i = 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f);
        ofFloat.addUpdateListener(new C4514ud(this, i));
        this.r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.e);
        ofFloat2.addUpdateListener(new C4514ud(this, i));
        this.q = ofFloat2;
        ofFloat2.addListener(new U0(this, i));
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void t(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void u() {
        boolean z;
        if (this.h == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.o;
        if (uptimeMillis >= 0 && uptimeMillis <= 300) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.m = false;
        }
        if (!this.m) {
            t(!this.n);
            if (this.n) {
                this.h.requestFocus();
                this.h.showDropDown();
                return;
            } else {
                this.h.dismissDropDown();
                return;
            }
        }
        this.m = false;
    }
}
