package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class RJ extends AbstractC4176to {
    public final int e;
    public EditText f;
    public final ViewOnClickListenerC0169Gd g;

    public RJ(C4097so c4097so, int i) {
        super(c4097so);
        this.e = R.drawable.design_password_eye;
        this.g = new ViewOnClickListenerC0169Gd(this, 3);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // defpackage.AbstractC4176to
    public final void b() {
        q();
    }

    @Override // defpackage.AbstractC4176to
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // defpackage.AbstractC4176to
    public final int d() {
        return this.e;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // defpackage.AbstractC4176to
    public final boolean k() {
        return true;
    }

    @Override // defpackage.AbstractC4176to
    public final boolean l() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // defpackage.AbstractC4176to
    public final void m(EditText editText) {
        this.f = editText;
        q();
    }

    @Override // defpackage.AbstractC4176to
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // defpackage.AbstractC4176to
    public final void s() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
