package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import app.vpn.amtunnellite.R;
import com.google.android.material.snackbar.SnackbarContentLayout;

/* loaded from: classes.dex */
public final class US extends Z9 {
    public static final int[] C = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public final AccessibilityManager A;
    public boolean B;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public US(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.A = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }
}
