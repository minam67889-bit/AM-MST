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
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public abstract class HM extends ConstraintLayout {
    public final RunnableC3954r1 s;
    public int t;
    public final JE u;

    public HM(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        JE je = new JE();
        this.u = je;
        UN un = new UN(0.5f);
        C4385wS f = je.b.a.f();
        f.e = un;
        f.f = un;
        f.g = un;
        f.h = un;
        je.setShapeAppearanceModel(f.a());
        this.u.n(ColorStateList.valueOf(-1));
        setBackground(this.u);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.y, R.attr.materialClockStyle, 0);
        this.t = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.s = new RunnableC3954r1(this, 11);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC3954r1 runnableC3954r1 = this.s;
            handler.removeCallbacks(runnableC3954r1);
            handler.post(runnableC3954r1);
        }
    }

    public abstract void m();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            RunnableC3954r1 runnableC3954r1 = this.s;
            handler.removeCallbacks(runnableC3954r1);
            handler.post(runnableC3954r1);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.u.n(ColorStateList.valueOf(i));
    }
}
