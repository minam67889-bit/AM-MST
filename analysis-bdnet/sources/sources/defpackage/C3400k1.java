package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import dastan.prince.bdfreevpn.R;

/* renamed from: k1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3400k1 extends C3884q5 implements InterfaceC3560m1 {
    public final /* synthetic */ C3480l1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3400k1(C3480l1 c3480l1, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.d = c3480l1;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        S50.F(this, getContentDescription());
        setOnTouchListener(new C3002f1(this, this));
    }

    @Override // defpackage.InterfaceC3560m1
    public final boolean a() {
        return false;
    }

    @Override // defpackage.InterfaceC3560m1
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.d.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
