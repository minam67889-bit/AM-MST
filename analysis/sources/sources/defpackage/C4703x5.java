package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* renamed from: x5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4703x5 extends Spinner {
    public static final int[] i = {R.attr.spinnerMode};
    public final C4855z4 a;
    public final Context b;
    public final C3934n5 c;
    public SpinnerAdapter d;
    public final boolean e;
    public final InterfaceC4626w5 f;
    public int g;
    public final Rect h;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if (r7 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C4703x5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, app.vpn.amtunnellite.R.attr.spinnerStyle);
        TypedArray typedArray;
        this.h = new Rect();
        QV.a(this, getContext());
        int[] iArr = EL.u;
        LQ j = LQ.j(app.vpn.amtunnellite.R.attr.spinnerStyle, 0, context, attributeSet, iArr);
        this.a = new C4855z4(this);
        TypedArray typedArray2 = (TypedArray) j.b;
        int resourceId = typedArray2.getResourceId(4, 0);
        if (resourceId != 0) {
            this.b = new C4364sg(context, resourceId);
        } else {
            this.b = context;
        }
        int i2 = -1;
        TypedArray typedArray3 = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, i, app.vpn.amtunnellite.R.attr.spinnerStyle, 0);
            try {
                try {
                    if (typedArray.hasValue(0)) {
                        i2 = typedArray.getInt(0, 0);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                }
            } catch (Throwable th) {
                th = th;
                typedArray3 = typedArray;
                if (typedArray3 != null) {
                    typedArray3.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            typedArray = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray3 != null) {
            }
            throw th;
        }
        typedArray.recycle();
        if (i2 != 0) {
            if (i2 == 1) {
                C4472u5 c4472u5 = new C4472u5(this, this.b, attributeSet);
                LQ j2 = LQ.j(app.vpn.amtunnellite.R.attr.spinnerStyle, 0, this.b, attributeSet, iArr);
                this.g = ((TypedArray) j2.b).getLayoutDimension(3, -2);
                c4472u5.h(j2.e(1));
                c4472u5.C = typedArray2.getString(2);
                j2.m();
                this.f = c4472u5;
                this.c = new C3934n5(this, this, c4472u5);
            }
        } else {
            DialogInterfaceOnClickListenerC4165q5 dialogInterfaceOnClickListenerC4165q5 = new DialogInterfaceOnClickListenerC4165q5(this);
            this.f = dialogInterfaceOnClickListenerC4165q5;
            dialogInterfaceOnClickListenerC4165q5.c = typedArray2.getString(2);
        }
        CharSequence[] textArray = typedArray2.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter.setDropDownViewResource(app.vpn.amtunnellite.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        j.m();
        this.e = true;
        SpinnerAdapter spinnerAdapter = this.d;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.d = null;
        }
        this.a.u(attributeSet, app.vpn.amtunnellite.R.attr.spinnerStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.h;
            drawable.getPadding(rect);
            return i3 + rect.left + rect.right;
        }
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            return interfaceC4626w5.c();
        }
        return super.getDropDownHorizontalOffset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            return interfaceC4626w5.n();
        }
        return super.getDropDownVerticalOffset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f != null) {
            return this.g;
        }
        return super.getDropDownWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InterfaceC4626w5 getInternalPopup() {
        return this.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            return interfaceC4626w5.d();
        }
        return super.getPopupBackground();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            return interfaceC4626w5.o();
        }
        return super.getPrompt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportBackgroundTintList() {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            return c4855z4.s();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            return c4855z4.t();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null && interfaceC4626w5.b()) {
            interfaceC4626w5.dismiss();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        C4549v5 c4549v5 = (C4549v5) parcelable;
        super.onRestoreInstanceState(c4549v5.getSuperState());
        if (c4549v5.a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC4011o5(this, 0));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        C4549v5 c4549v5 = new C4549v5(super.onSaveInstanceState());
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null && interfaceC4626w5.b()) {
            z = true;
        } else {
            z = false;
        }
        c4549v5.a = z;
        return c4549v5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C3934n5 c3934n5 = this.c;
        if (c3934n5 != null && c3934n5.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            if (!interfaceC4626w5.b()) {
                this.f.m(getTextDirection(), getTextAlignment());
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.v();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.w(i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            interfaceC4626w5.k(i2);
            interfaceC4626w5.l(i2);
        } else {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            interfaceC4626w5.j(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f != null) {
            this.g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            interfaceC4626w5.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(AbstractC4766xx.D(getPopupContext(), i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            interfaceC4626w5.e(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.y(colorStateList);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.z(mode);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.e) {
            this.d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        InterfaceC4626w5 interfaceC4626w5 = this.f;
        if (interfaceC4626w5 != null) {
            Context context = this.b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            C4241r5 c4241r5 = new C4241r5();
            c4241r5.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                c4241r5.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                AbstractC4088p5.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            interfaceC4626w5.p(c4241r5);
        }
    }
}
