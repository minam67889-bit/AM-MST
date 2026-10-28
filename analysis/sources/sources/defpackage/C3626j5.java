package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import app.vpn.amtunnellite.R;

/* renamed from: j5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3626j5 extends RatingBar {
    public final QK a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3626j5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        QV.a(this, getContext());
        QK qk = new QK(this);
        this.a = qk;
        qk.s(attributeSet, R.attr.ratingBarStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = (Bitmap) this.a.c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
