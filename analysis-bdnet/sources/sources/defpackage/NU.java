package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class NU extends LinearLayout {
    public final TextInputLayout a;
    public final T5 b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public int g;
    public ImageView.ScaleType h;
    public View.OnLongClickListener i;
    public boolean j;

    public NU(TextInputLayout textInputLayout, C4452xG c4452xG) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        T5 t5 = new T5(getContext(), null);
        this.b = t5;
        if (W80.J(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC0641Yi.Z(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) c4452xG.c;
        if (typedArray.hasValue(70)) {
            this.e = W80.r(getContext(), c4452xG, 70);
        }
        if (typedArray.hasValue(71)) {
            this.f = F20.k(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            b(c4452xG.i(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.g) {
            this.g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType n = AbstractC0641Yi.n(typedArray.getInt(69, -1));
            this.h = n;
            checkableImageButton.setScaleType(n);
        }
        t5.setVisibility(8);
        t5.setId(R.id.textinput_prefix_text);
        t5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        t5.setAccessibilityLiveRegion(1);
        t5.setTextAppearance(typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            t5.setTextColor(c4452xG.h(62));
        }
        CharSequence text2 = typedArray.getText(60);
        this.c = TextUtils.isEmpty(text2) ? null : text2;
        t5.setText(text2);
        e();
        addView(checkableImageButton);
        addView(t5);
    }

    public final int a() {
        int i;
        CheckableImageButton checkableImageButton = this.d;
        if (checkableImageButton.getVisibility() == 0) {
            i = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            i = 0;
        }
        return this.b.getPaddingStart() + getPaddingStart() + i;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.e;
            PorterDuff.Mode mode = this.f;
            TextInputLayout textInputLayout = this.a;
            AbstractC0641Yi.c(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            AbstractC0641Yi.U(textInputLayout, checkableImageButton, this.e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        AbstractC0641Yi.Z(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC0641Yi.Z(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.a.e;
        if (editText == null) {
            return;
        }
        this.b.setPaddingRelative(this.d.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i = (this.c == null || this.j) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.a.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }
}
