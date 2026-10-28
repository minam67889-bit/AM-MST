package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import app.vpn.amtunnellite.R;

/* renamed from: l5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3780l5 extends SeekBar {
    public final C3857m5 a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3780l5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        QV.a(this, getContext());
        C3857m5 c3857m5 = new C3857m5(this);
        this.a = c3857m5;
        c3857m5.s(attributeSet, R.attr.seekBarStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C3857m5 c3857m5 = this.a;
        Drawable drawable = c3857m5.k;
        if (drawable != null && drawable.isStateful()) {
            SeekBar seekBar = c3857m5.j;
            if (drawable.setState(seekBar.getDrawableState())) {
                seekBar.invalidateDrawable(drawable);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.E(canvas);
    }
}
