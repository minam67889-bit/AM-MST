package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class WI extends AbstractC3297eo {
    public final int e;
    public EditText f;
    public final ViewOnClickListenerC4360sd g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WI(Cdo cdo, int i) {
        super(cdo);
        this.e = R.drawable.design_password_eye;
        this.g = new ViewOnClickListenerC4360sd(this, 3);
        if (i != 0) {
            this.e = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void b() {
        q();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int d() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnClickListener f() {
        return this.g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final boolean k() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final boolean l() {
        boolean z;
        EditText editText = this.f;
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void m(EditText editText) {
        this.f = editText;
        q();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void s() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
