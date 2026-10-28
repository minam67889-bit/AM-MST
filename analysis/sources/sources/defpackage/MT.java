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
import app.vpn.amtunnellite.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class MT extends LinearLayout {
    public final TextInputLayout a;
    public final I5 b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public int g;
    public ImageView.ScaleType h;
    public View.OnLongClickListener i;
    public boolean j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MT(TextInputLayout textInputLayout, LQ lq) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        I5 i5 = new I5(getContext(), null);
        this.b = i5;
        if (AbstractC3411gE.x0(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        AbstractC4747xe.V(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC4747xe.V(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) lq.b;
        if (typedArray.hasValue(70)) {
            this.e = AbstractC3411gE.c0(getContext(), lq, 70);
        }
        if (typedArray.hasValue(71)) {
            this.f = AbstractC4311s10.r(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            b(lq.e(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.g) {
                this.g = dimensionPixelSize;
                checkableImageButton.setMinimumWidth(dimensionPixelSize);
                checkableImageButton.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(69)) {
                ImageView.ScaleType u = AbstractC4747xe.u(typedArray.getInt(69, -1));
                this.h = u;
                checkableImageButton.setScaleType(u);
            }
            i5.setVisibility(8);
            i5.setId(R.id.textinput_prefix_text);
            i5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            i5.setAccessibilityLiveRegion(1);
            i5.setTextAppearance(typedArray.getResourceId(61, 0));
            if (typedArray.hasValue(62)) {
                i5.setTextColor(lq.d(62));
            }
            CharSequence text2 = typedArray.getText(60);
            this.c = TextUtils.isEmpty(text2) ? null : text2;
            i5.setText(text2);
            e();
            addView(checkableImageButton);
            addView(i5);
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.e;
            PorterDuff.Mode mode = this.f;
            TextInputLayout textInputLayout = this.a;
            AbstractC4747xe.e(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            AbstractC4747xe.T(textInputLayout, checkableImageButton, this.e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        AbstractC4747xe.V(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC4747xe.V(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(boolean z) {
        boolean z2;
        CheckableImageButton checkableImageButton = this.d;
        int i = 0;
        if (checkableImageButton.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            d();
            e();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        int paddingStart;
        EditText editText = this.a.e;
        if (editText == null) {
            return;
        }
        if (this.d.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            paddingStart = editText.getPaddingStart();
        }
        this.b.setPaddingRelative(paddingStart, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        int i;
        int i2 = 8;
        if (this.c != null && !this.j) {
            i = 0;
        } else {
            i = 8;
        }
        if (this.d.getVisibility() == 0 || i == 0) {
            i2 = 0;
        }
        setVisibility(i2);
        this.b.setVisibility(i);
        this.a.s();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }
}
