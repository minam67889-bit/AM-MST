package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import app.vpn.amtunnellite.R;

/* renamed from: u5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4472u5 extends JB implements InterfaceC4626w5 {
    public CharSequence C;
    public ListAdapter D;
    public final Rect E;
    public int F;
    public final /* synthetic */ C4703x5 G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4472u5(C4703x5 c4703x5, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.G = c4703x5;
        this.E = new Rect();
        this.o = c4703x5;
        this.y = true;
        this.z.setFocusable(true);
        this.p = new C4318s5(this, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4626w5
    public final void e(CharSequence charSequence) {
        this.C = charSequence;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4626w5
    public final void k(int i) {
        this.F = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4626w5
    public final void m(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        C3474h5 c3474h5 = this.z;
        boolean isShowing = c3474h5.isShowing();
        r();
        this.z.setInputMethodMode(2);
        show();
        C3219dm c3219dm = this.c;
        c3219dm.setChoiceMode(1);
        c3219dm.setTextDirection(i);
        c3219dm.setTextAlignment(i2);
        C4703x5 c4703x5 = this.G;
        int selectedItemPosition = c4703x5.getSelectedItemPosition();
        C3219dm c3219dm2 = this.c;
        if (c3474h5.isShowing() && c3219dm2 != null) {
            c3219dm2.setListSelectionHidden(false);
            c3219dm2.setSelection(selectedItemPosition);
            if (c3219dm2.getChoiceMode() != 0) {
                c3219dm2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing && (viewTreeObserver = c4703x5.getViewTreeObserver()) != null) {
            ViewTreeObserverOnGlobalLayoutListenerC4011o5 viewTreeObserverOnGlobalLayoutListenerC4011o5 = new ViewTreeObserverOnGlobalLayoutListenerC4011o5(this, 1);
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC4011o5);
            this.z.setOnDismissListener(new C4395t5(this, viewTreeObserverOnGlobalLayoutListenerC4011o5));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4626w5
    public final CharSequence o() {
        return this.C;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.JB, defpackage.InterfaceC4626w5
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.D = listAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r() {
        int i;
        int i2;
        int i3;
        C3474h5 c3474h5 = this.z;
        Drawable background = c3474h5.getBackground();
        C4703x5 c4703x5 = this.G;
        if (background != null) {
            background.getPadding(c4703x5.h);
            boolean z = AbstractC4388t10.a;
            int layoutDirection = c4703x5.getLayoutDirection();
            Rect rect = c4703x5.h;
            if (layoutDirection == 1) {
                i = rect.right;
            } else {
                i = -rect.left;
            }
        } else {
            Rect rect2 = c4703x5.h;
            rect2.right = 0;
            rect2.left = 0;
            i = 0;
        }
        int paddingLeft = c4703x5.getPaddingLeft();
        int paddingRight = c4703x5.getPaddingRight();
        int width = c4703x5.getWidth();
        int i4 = c4703x5.g;
        if (i4 == -2) {
            int a = c4703x5.a((SpinnerAdapter) this.D, c3474h5.getBackground());
            int i5 = c4703x5.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = c4703x5.h;
            int i6 = (i5 - rect3.left) - rect3.right;
            if (a > i6) {
                a = i6;
            }
            i2 = Math.max(a, (width - paddingLeft) - paddingRight);
        } else if (i4 == -1) {
            i2 = (width - paddingLeft) - paddingRight;
        } else {
            q(i4);
            boolean z2 = AbstractC4388t10.a;
            if (c4703x5.getLayoutDirection() != 1) {
                i3 = (((width - paddingRight) - this.e) - this.F) + i;
            } else {
                i3 = paddingLeft + this.F + i;
            }
            this.f = i3;
        }
        q(i2);
        boolean z22 = AbstractC4388t10.a;
        if (c4703x5.getLayoutDirection() != 1) {
        }
        this.f = i3;
    }
}
