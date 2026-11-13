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
import defpackage.AbstractC0487bc;
import defpackage.C2507db;
import defpackage.C2701hA;
import defpackage.InterfaceC0418aC;
import defpackage.SharedPreferencesEditorC2544eC;
import defpackage.VB;
import defpackage.WB;
import defpackage.XB;
import defpackage.Xy;
import defpackage.YB;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* loaded from: classes2.dex */
public class ScrollableNumberPicker extends LinearLayout {
    public final TextView A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public boolean F;
    public boolean G;
    public final Handler H;
    public InterfaceC0418aC I;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public int e;
    public int f;
    public int m;
    public int n;
    public final float o;
    public final int p;
    public final int q;
    public final boolean r;
    public int s;
    public final float t;
    public final int u;
    public final ColorStateList v;
    public final int w;
    public final int x;
    public ImageView y;
    public ImageView z;

    public ScrollableNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 2131230928;
        this.b = 2131230931;
        this.c = 2131230929;
        this.d = 2131230930;
        if (isInEditMode()) {
            return;
        }
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2131558561, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Xy.a);
        Resources resources = getResources();
        this.a = obtainStyledAttributes.getResourceId(1, this.a);
        this.b = obtainStyledAttributes.getResourceId(4, this.b);
        this.c = obtainStyledAttributes.getResourceId(2, this.c);
        this.d = obtainStyledAttributes.getResourceId(3, this.d);
        this.m = obtainStyledAttributes.getInt(11, resources.getInteger(2131427337));
        this.f = obtainStyledAttributes.getInt(10, resources.getInteger(2131427336));
        this.n = obtainStyledAttributes.getInt(14, resources.getInteger(2131427338));
        this.s = obtainStyledAttributes.getInt(15, resources.getInteger(2131427339));
        this.u = obtainStyledAttributes.getInt(12, 0);
        this.e = obtainStyledAttributes.getInt(16, resources.getInteger(2131427340));
        this.o = obtainStyledAttributes.getDimension(21, -1.0f);
        this.p = obtainStyledAttributes.getColor(20, -1);
        this.q = obtainStyledAttributes.getResourceId(19, -1);
        this.r = obtainStyledAttributes.getBoolean(13, resources.getBoolean(2131034114));
        this.v = AbstractC0487bc.getColorStateList(context, obtainStyledAttributes.getResourceId(0, 2131099700));
        this.w = (int) obtainStyledAttributes.getDimension(18, resources.getDimension(2131165298));
        this.x = (int) obtainStyledAttributes.getDimension(18, resources.getDimension(2131165297));
        this.B = (int) obtainStyledAttributes.getDimension(6, resources.getDimension(2131165288));
        this.C = (int) obtainStyledAttributes.getDimension(7, resources.getDimension(2131165289));
        this.D = (int) obtainStyledAttributes.getDimension(8, resources.getDimension(2131165290));
        this.E = (int) obtainStyledAttributes.getDimension(5, resources.getDimension(2131165287));
        TypedValue typedValue = new TypedValue();
        resources.getValue(2131165291, typedValue, true);
        this.t = obtainStyledAttributes.getFloat(9, typedValue.getFloat());
        obtainStyledAttributes.recycle();
        setOrientation(this.u);
        setGravity(17);
        TextView textView = (TextView) findViewById(2131362516);
        this.A = textView;
        int i = this.q;
        if (i != -1) {
            textView.setTextAppearance(i);
        }
        int i2 = this.p;
        if (i2 != -1) {
            this.A.setTextColor(i2);
        }
        float f = this.o;
        if (f != -1.0f) {
            this.A.setTextSize(0, f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
        if (this.u == 0) {
            layoutParams.setMargins(this.w, 0, this.x, 0);
        } else {
            layoutParams.setMargins(0, this.w, 0, this.x);
        }
        this.A.setLayoutParams(layoutParams);
        f();
        e();
        this.z.setOnClickListener(new WB(this, 0));
        this.z.setOnLongClickListener(new XB(this, 0));
        this.z.setOnTouchListener(new YB(this, 0));
        d();
        this.y.setOnClickListener(new WB(this, 1));
        this.y.setOnLongClickListener(new XB(this, 1));
        this.y.setOnTouchListener(new YB(this, 1));
        if (this.r) {
            setOnTouchListener(new VB(this));
        }
        this.F = false;
        this.G = false;
        this.H = new Handler();
    }

    public static void a(ScrollableNumberPicker scrollableNumberPicker) {
        int i = scrollableNumberPicker.e;
        if (i < scrollableNumberPicker.f) {
            scrollableNumberPicker.setValue(i + scrollableNumberPicker.n);
        }
    }

    public static void b(ScrollableNumberPicker scrollableNumberPicker, ImageView imageView, float f) {
        scrollableNumberPicker.getClass();
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i = (int) (intrinsicWidth * f);
        int i2 = (int) (intrinsicHeight * f);
        if (i >= intrinsicWidth || i2 >= intrinsicHeight) {
            return;
        }
        int i3 = (intrinsicWidth - i) / 2;
        int i4 = (intrinsicHeight - i2) / 2;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.setMargins(i3, i4, i3, i4);
        imageView.setLayoutParams(layoutParams);
    }

    public static void c(ScrollableNumberPicker scrollableNumberPicker) {
        int i = scrollableNumberPicker.e;
        if (i > scrollableNumberPicker.m) {
            scrollableNumberPicker.setValue(i - scrollableNumberPicker.n);
        }
    }

    private void setButtonLayoutParams(ImageView imageView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(this.B, this.D, this.C, this.E);
    }

    public final void d() {
        ImageView imageView;
        int i;
        int i2 = this.u;
        if (i2 != 1) {
            if (i2 == 0) {
                imageView = (ImageView) findViewById(2131361920);
                this.y = imageView;
                i = this.c;
            }
            ImageView imageView2 = this.y;
            ColorStateList colorStateList = this.v;
            Drawable drawable = imageView2.getDrawable();
            drawable.setTintList(colorStateList);
            imageView2.setImageDrawable(drawable);
            setButtonLayoutParams(this.y);
        }
        imageView = (ImageView) findViewById(2131361919);
        this.y = imageView;
        i = this.a;
        imageView.setImageResource(i);
        ImageView imageView22 = this.y;
        ColorStateList colorStateList2 = this.v;
        Drawable drawable2 = imageView22.getDrawable();
        drawable2.setTintList(colorStateList2);
        imageView22.setImageDrawable(drawable2);
        setButtonLayoutParams(this.y);
    }

    public final void e() {
        ImageView imageView;
        int i;
        int i2 = this.u;
        if (i2 != 1) {
            if (i2 == 0) {
                imageView = (ImageView) findViewById(2131361919);
                this.z = imageView;
                i = this.d;
            }
            ImageView imageView2 = this.z;
            ColorStateList colorStateList = this.v;
            Drawable drawable = imageView2.getDrawable();
            drawable.setTintList(colorStateList);
            imageView2.setImageDrawable(drawable);
            setButtonLayoutParams(this.z);
        }
        imageView = (ImageView) findViewById(2131361920);
        this.z = imageView;
        i = this.b;
        imageView.setImageResource(i);
        ImageView imageView22 = this.z;
        ColorStateList colorStateList2 = this.v;
        Drawable drawable2 = imageView22.getDrawable();
        drawable2.setTintList(colorStateList2);
        imageView22.setImageDrawable(drawable2);
        setButtonLayoutParams(this.z);
    }

    public final void f() {
        this.A.setText(String.valueOf(this.e));
        InterfaceC0418aC interfaceC0418aC = this.I;
        if (interfaceC0418aC != null) {
            int i = this.e;
            SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = ((C2507db) ((C2701hA) interfaceC0418aC).b).b;
            sharedPreferencesEditorC2544eC.putInt("#ERR IndexError: list index out of range", i);
            sharedPreferencesEditorC2544eC.apply();
        }
    }

    public ColorStateList getButtonColorStateList() {
        return this.v;
    }

    public ImageView getButtonMinusView() {
        return this.y;
    }

    public ImageView getButtonPlusView() {
        return this.z;
    }

    public float getButtonTouchScaleFactor() {
        return this.t;
    }

    public int getMaxValue() {
        return this.f;
    }

    public int getMinValue() {
        return this.m;
    }

    public long getOnLongPressUpdateInterval() {
        return this.s;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.u;
    }

    public int getStepSize() {
        return this.n;
    }

    public int getUpdateIntervalMillis() {
        return this.s;
    }

    public int getValue() {
        return this.e;
    }

    public int getValueMarginEnd() {
        return this.x;
    }

    public int getValueMarginStart() {
        return this.w;
    }

    public TextView getValueView() {
        return this.A;
    }

    public void setListener(InterfaceC0418aC interfaceC0418aC) {
        this.I = interfaceC0418aC;
    }

    public void setMaxValue(int i) {
        this.f = i;
        if (i < this.e) {
            this.e = i;
            f();
        }
    }

    public void setMinValue(int i) {
        this.m = i;
        if (i > this.e) {
            this.e = i;
            f();
        }
    }

    public void setOnLongPressUpdateInterval(int i) {
        if (i < 50) {
            i = 50;
        }
        this.s = i;
    }

    public void setStepSize(int i) {
        this.n = i;
    }

    public void setValue(int i) {
        int i2 = this.f;
        if (i > i2) {
            i = i2;
        }
        int i3 = this.m;
        if (i < i3) {
            i = i3;
        }
        this.e = i;
        f();
    }
}
