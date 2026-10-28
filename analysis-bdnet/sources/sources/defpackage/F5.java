package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class F5 extends BC implements H5 {
    public CharSequence C;
    public C5 D;
    public final Rect E;
    public int F;
    public final /* synthetic */ I5 G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F5(I5 i5, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle);
        this.G = i5;
        this.E = new Rect();
        this.o = i5;
        this.y = true;
        this.z.setFocusable(true);
        this.p = new D5(this, 0);
    }

    @Override // defpackage.H5
    public final void d(CharSequence charSequence) {
        this.C = charSequence;
    }

    @Override // defpackage.H5
    public final void j(int i) {
        this.F = i;
    }

    @Override // defpackage.H5
    public final void l(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        C4041s5 c4041s5 = this.z;
        boolean isShowing = c4041s5.isShowing();
        r();
        this.z.setInputMethodMode(2);
        show();
        C3304im c3304im = this.c;
        c3304im.setChoiceMode(1);
        c3304im.setTextDirection(i);
        c3304im.setTextAlignment(i2);
        I5 i5 = this.G;
        int selectedItemPosition = i5.getSelectedItemPosition();
        C3304im c3304im2 = this.c;
        if (c4041s5.isShowing() && c3304im2 != null) {
            c3304im2.setListSelectionHidden(false);
            c3304im2.setSelection(selectedItemPosition);
            if (c3304im2.getChoiceMode() != 0) {
                c3304im2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (isShowing || (viewTreeObserver = i5.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC4594z5 viewTreeObserverOnGlobalLayoutListenerC4594z5 = new ViewTreeObserverOnGlobalLayoutListenerC4594z5(this, 1);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC4594z5);
        this.z.setOnDismissListener(new E5(this, viewTreeObserverOnGlobalLayoutListenerC4594z5));
    }

    @Override // defpackage.H5
    public final CharSequence n() {
        return this.C;
    }

    @Override // defpackage.BC, defpackage.H5
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.D = (C5) listAdapter;
    }

    public final void r() {
        int i;
        C4041s5 c4041s5 = this.z;
        Drawable background = c4041s5.getBackground();
        I5 i5 = this.G;
        if (background != null) {
            background.getPadding(i5.h);
            boolean z = G20.a;
            int layoutDirection = i5.getLayoutDirection();
            Rect rect = i5.h;
            i = layoutDirection == 1 ? rect.right : -rect.left;
        } else {
            Rect rect2 = i5.h;
            rect2.right = 0;
            rect2.left = 0;
            i = 0;
        }
        int paddingLeft = i5.getPaddingLeft();
        int paddingRight = i5.getPaddingRight();
        int width = i5.getWidth();
        int i2 = i5.g;
        if (i2 == -2) {
            int a = i5.a(this.D, c4041s5.getBackground());
            int i3 = i5.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = i5.h;
            int i4 = (i3 - rect3.left) - rect3.right;
            if (a > i4) {
                a = i4;
            }
            q(Math.max(a, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            q((width - paddingLeft) - paddingRight);
        } else {
            q(i2);
        }
        boolean z2 = G20.a;
        this.f = i5.getLayoutDirection() == 1 ? (((width - paddingRight) - this.e) - this.F) + i : paddingLeft + this.F + i;
    }
}
