package defpackage;

import android.R;
import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public final class GE extends C4120t5 {
    public static final int[][] g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList e;
    public boolean f;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int u = S50.u(this, dastan.prince.bdfreevpn.R.attr.colorControlActivated);
            int u2 = S50.u(this, dastan.prince.bdfreevpn.R.attr.colorOnSurface);
            int u3 = S50.u(this, dastan.prince.bdfreevpn.R.attr.colorSurface);
            this.e = new ColorStateList(g, new int[]{S50.z(u3, u, 1.0f), S50.z(u3, u2, 0.54f), S50.z(u3, u2, 0.38f), S50.z(u3, u2, 0.38f)});
        }
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
