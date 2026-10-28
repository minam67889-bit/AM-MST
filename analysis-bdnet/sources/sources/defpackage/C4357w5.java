package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import dastan.prince.bdfreevpn.R;

/* renamed from: w5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4357w5 extends SeekBar {
    public final C4436x5 a;

    public C4357w5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        JW.a(this, getContext());
        C4436x5 c4436x5 = new C4436x5(this);
        this.a = c4436x5;
        c4436x5.n(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C4436x5 c4436x5 = this.a;
        Drawable drawable = c4436x5.k;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        C4357w5 c4357w5 = c4436x5.j;
        if (drawable.setState(c4357w5.getDrawableState())) {
            c4357w5.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.D(canvas);
    }
}
