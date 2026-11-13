package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public abstract class FL extends ConstraintLayout {
    public final RunnableC4080p1 s;
    public int t;
    public final UD u;

    public abstract void m();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FL(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        UD ud = new UD();
        this.u = ud;
        XM xm = new XM(0.5f);
        DR f = ud.b.a.f();
        f.e = xm;
        f.f = xm;
        f.g = xm;
        f.h = xm;
        ud.setShapeAppearanceModel(f.a());
        this.u.o(ColorStateList.valueOf(-1));
        setBackground(this.u);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CL.y, R.attr.materialClockStyle, 0);
        this.t = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.s = new RunnableC4080p1(this, 13);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC4080p1 runnableC4080p1 = this.s;
            handler.removeCallbacks(runnableC4080p1);
            handler.post(runnableC4080p1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC4080p1 runnableC4080p1 = this.s;
            handler.removeCallbacks(runnableC4080p1);
            handler.post(runnableC4080p1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.u.o(ColorStateList.valueOf(i));
    }
}
