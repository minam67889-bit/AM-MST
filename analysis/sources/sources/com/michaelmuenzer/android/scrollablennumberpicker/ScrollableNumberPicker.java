package com.michaelmuenzer.android.scrollablennumberpicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import defpackage.AbstractC4673wh;
import defpackage.C4363sf;
import defpackage.DL;
import defpackage.LP;
import defpackage.MP;
import defpackage.NP;
import defpackage.OP;
import defpackage.QP;
import defpackage.VP;
import defpackage.WP;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* loaded from: classes.dex */
public class ScrollableNumberPicker extends LinearLayout {
    public boolean A;
    public final Handler B;
    public QP C;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final float i;
    public final int j;
    public final int k;
    public final boolean l;
    public int m;
    public final float n;
    public final int o;
    public final ColorStateList p;
    public final int q;
    public final int r;
    public ImageView s;
    public ImageView t;
    public final TextView u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public boolean z;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setButtonLayoutParams(ImageView imageView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(this.v, this.x, this.w, this.y);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getButtonColorStateList() {
        return this.p;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageView getButtonMinusView() {
        return this.s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageView getButtonPlusView() {
        return this.t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getButtonTouchScaleFactor() {
        return this.n;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxValue() {
        return this.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMinValue() {
        return this.g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getOnLongPressUpdateInterval() {
        return this.m;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.o;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStepSize() {
        return this.h;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getUpdateIntervalMillis() {
        return this.m;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getValue() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getValueMarginEnd() {
        return this.r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getValueMarginStart() {
        return this.q;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextView getValueView() {
        return this.u;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxValue(int i) {
        this.f = i;
        if (i < this.e) {
            this.e = i;
            f();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMinValue(int i) {
        this.g = i;
        if (i > this.e) {
            this.e = i;
            f();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnLongPressUpdateInterval(int i) {
        if (i < 50) {
            i = 50;
        }
        this.m = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStepSize(int i) {
        this.h = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(int i) {
        int i2 = this.f;
        if (i > i2) {
            i = i2;
        }
        int i3 = this.g;
        if (i < i3) {
            i = i3;
        }
        this.e = i;
        f();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScrollableNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 2131230935;
        this.b = 2131230938;
        this.c = 2131230936;
        this.d = 2131230937;
        if (!isInEditMode()) {
            ((LayoutInflater) context.getSystemService(y.׬ܮ֮ڱܭ(1520061240))).inflate(R.layout.number_picker, this);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DL.a);
            Resources resources = getResources();
            this.a = obtainStyledAttributes.getResourceId(1, this.a);
            this.b = obtainStyledAttributes.getResourceId(4, this.b);
            this.c = obtainStyledAttributes.getResourceId(2, this.c);
            this.d = obtainStyledAttributes.getResourceId(3, this.d);
            this.g = obtainStyledAttributes.getInt(11, resources.getInteger(R.integer.default_minValue));
            this.f = obtainStyledAttributes.getInt(10, resources.getInteger(R.integer.default_maxValue));
            this.h = obtainStyledAttributes.getInt(14, resources.getInteger(R.integer.default_stepSize));
            this.m = obtainStyledAttributes.getInt(15, resources.getInteger(R.integer.default_updateInterval));
            this.o = obtainStyledAttributes.getInt(12, 0);
            this.e = obtainStyledAttributes.getInt(16, resources.getInteger(R.integer.default_value));
            this.i = obtainStyledAttributes.getDimension(21, -1.0f);
            this.j = obtainStyledAttributes.getColor(20, -1);
            this.k = obtainStyledAttributes.getResourceId(19, -1);
            this.l = obtainStyledAttributes.getBoolean(13, resources.getBoolean(R.bool.default_scrollEnabled));
            this.p = AbstractC4673wh.y(context, obtainStyledAttributes.getResourceId(0, R.color.btn_tint_selector));
            this.q = (int) obtainStyledAttributes.getDimension(18, resources.getDimension(R.dimen.default_value_margin_start));
            this.r = (int) obtainStyledAttributes.getDimension(18, resources.getDimension(R.dimen.default_value_margin_end));
            this.v = (int) obtainStyledAttributes.getDimension(6, resources.getDimension(R.dimen.default_button_padding_left));
            this.w = (int) obtainStyledAttributes.getDimension(7, resources.getDimension(R.dimen.default_button_padding_right));
            this.x = (int) obtainStyledAttributes.getDimension(8, resources.getDimension(R.dimen.default_button_padding_top));
            this.y = (int) obtainStyledAttributes.getDimension(5, resources.getDimension(R.dimen.default_button_padding_bottom));
            TypedValue typedValue = new TypedValue();
            resources.getValue(R.dimen.default_button_scale_factor, typedValue, true);
            this.n = obtainStyledAttributes.getFloat(9, typedValue.getFloat());
            obtainStyledAttributes.recycle();
            setOrientation(this.o);
            setGravity(17);
            TextView textView = (TextView) findViewById(R.id.text_value);
            this.u = textView;
            int i = this.k;
            if (i != -1) {
                textView.setTextAppearance(i);
            }
            int i2 = this.j;
            if (i2 != -1) {
                this.u.setTextColor(i2);
            }
            float f = this.i;
            if (f != -1.0f) {
                this.u.setTextSize(0, f);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.u.getLayoutParams();
            if (this.o == 0) {
                layoutParams.setMargins(this.q, 0, this.r, 0);
            } else {
                layoutParams.setMargins(0, this.q, 0, this.r);
            }
            this.u.setLayoutParams(layoutParams);
            f();
            e();
            this.t.setOnClickListener(new MP(this, 0));
            this.t.setOnLongClickListener(new NP(this, 0));
            this.t.setOnTouchListener(new OP(this, 0));
            d();
            this.s.setOnClickListener(new MP(this, 1));
            this.s.setOnLongClickListener(new NP(this, 1));
            this.s.setOnTouchListener(new OP(this, 1));
            if (this.l) {
                setOnTouchListener(new LP(this));
            }
            this.z = false;
            this.A = false;
            this.B = new Handler();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(ScrollableNumberPicker scrollableNumberPicker) {
        int i = scrollableNumberPicker.e;
        if (i < scrollableNumberPicker.f) {
            scrollableNumberPicker.setValue(i + scrollableNumberPicker.h);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void b(ScrollableNumberPicker scrollableNumberPicker, ImageView imageView, float f) {
        scrollableNumberPicker.getClass();
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i = (int) (intrinsicWidth * f);
        int i2 = (int) (intrinsicHeight * f);
        if (i < intrinsicWidth && i2 < intrinsicHeight) {
            int i3 = (intrinsicWidth - i) / 2;
            int i4 = (intrinsicHeight - i2) / 2;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.setMargins(i3, i4, i3, i4);
            imageView.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void c(ScrollableNumberPicker scrollableNumberPicker) {
        int i = scrollableNumberPicker.e;
        if (i > scrollableNumberPicker.g) {
            scrollableNumberPicker.setValue(i - scrollableNumberPicker.h);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        ImageView imageView;
        int i;
        int i2 = this.o;
        if (i2 == 1) {
            imageView = (ImageView) findViewById(R.id.button_decrease);
            this.s = imageView;
            i = this.a;
        } else {
            if (i2 == 0) {
                imageView = (ImageView) findViewById(R.id.button_increase);
                this.s = imageView;
                i = this.c;
            }
            ImageView imageView2 = this.s;
            ColorStateList colorStateList = this.p;
            Drawable drawable = imageView2.getDrawable();
            drawable.setTintList(colorStateList);
            imageView2.setImageDrawable(drawable);
            setButtonLayoutParams(this.s);
        }
        imageView.setImageResource(i);
        ImageView imageView22 = this.s;
        ColorStateList colorStateList2 = this.p;
        Drawable drawable2 = imageView22.getDrawable();
        drawable2.setTintList(colorStateList2);
        imageView22.setImageDrawable(drawable2);
        setButtonLayoutParams(this.s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        ImageView imageView;
        int i;
        int i2 = this.o;
        if (i2 == 1) {
            imageView = (ImageView) findViewById(R.id.button_increase);
            this.t = imageView;
            i = this.b;
        } else {
            if (i2 == 0) {
                imageView = (ImageView) findViewById(R.id.button_decrease);
                this.t = imageView;
                i = this.d;
            }
            ImageView imageView2 = this.t;
            ColorStateList colorStateList = this.p;
            Drawable drawable = imageView2.getDrawable();
            drawable.setTintList(colorStateList);
            imageView2.setImageDrawable(drawable);
            setButtonLayoutParams(this.t);
        }
        imageView.setImageResource(i);
        ImageView imageView22 = this.t;
        ColorStateList colorStateList2 = this.p;
        Drawable drawable2 = imageView22.getDrawable();
        drawable2.setTintList(colorStateList2);
        imageView22.setImageDrawable(drawable2);
        setButtonLayoutParams(this.t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f() {
        this.u.setText(String.valueOf(this.e));
        QP qp = this.C;
        if (qp != null) {
            int i = this.e;
            WP wp = ((C4363sf) ((VP) qp).b).b;
            wp.putInt(Deobfuscator$AMTUNNELLITE$app.getString(-207999507435169L), i);
            wp.apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setListener(QP qp) {
        this.C = qp;
    }
}
