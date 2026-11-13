package defpackage;

import android.R;
import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public final class QD extends C3551i5 {
    public static final int[][] g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList e;
    public boolean f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.e == null) {
            int B = AbstractC4766xx.B(this, app.vpn.amtunnellite.R.attr.colorControlActivated);
            int B2 = AbstractC4766xx.B(this, app.vpn.amtunnellite.R.attr.colorOnSurface);
            int B3 = AbstractC4766xx.B(this, app.vpn.amtunnellite.R.attr.colorSurface);
            this.e = new ColorStateList(g, new int[]{AbstractC4766xx.K(B3, B, 1.0f), AbstractC4766xx.K(B3, B2, 0.54f), AbstractC4766xx.K(B3, B2, 0.38f), AbstractC4766xx.K(B3, B2, 0.38f)});
        }
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList colorStateList;
        this.f = z;
        if (z) {
            colorStateList = getMaterialThemeColorsTintList();
        } else {
            colorStateList = null;
        }
        setButtonTintList(colorStateList);
    }
}
