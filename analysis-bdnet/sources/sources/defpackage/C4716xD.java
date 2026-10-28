package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import app.vpn.amtunnellite.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;

/* renamed from: xD, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4716xD extends C4778y4 {
    public final JB e;
    public final AccessibilityManager f;
    public final Rect g;
    public final int h;
    public final float i;
    public ColorStateList j;
    public int k;
    public ColorStateList l;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4716xD(Context context, AttributeSet attributeSet) {
        super(AbstractC4817ya0.f0(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.g = new Rect();
        Context context2 = getContext();
        TypedArray B = AbstractC4702x40.B(context2, attributeSet, CL.k, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (B.hasValue(0) && B.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.h = B.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.i = B.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (B.hasValue(2)) {
            this.j = ColorStateList.valueOf(B.getColor(2, 0));
        }
        this.k = B.getColor(4, 0);
        this.l = AbstractC3411gE.d0(context2, B, 5);
        this.f = (AccessibilityManager) context2.getSystemService("accessibility");
        JB jb = new JB(context2, null, R.attr.listPopupWindowStyle, 0);
        this.e = jb;
        jb.y = true;
        jb.z.setFocusable(true);
        jb.o = this;
        jb.z.setInputMethodMode(2);
        jb.p(getAdapter());
        jb.p = new C4318s5(this, 1);
        if (B.hasValue(6)) {
            setSimpleItems(B.getResourceId(6, 0));
        }
        B.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) != null) {
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    if (accessibilityServiceInfo.getSettingsActivityName() == null || !accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getDropDownBackgroundTintList() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b = b();
        if (b != null && b.F) {
            return b.getHint();
        }
        return super.getHint();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getPopupElevation() {
        return this.i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSimpleItemSelectedColor() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        TextInputLayout b = b();
        if (b != null && b.F && super.getHint() == null) {
            String str2 = Build.MANUFACTURER;
            if (str2 == null) {
                str = "";
            } else {
                str = str2.toLowerCase(Locale.ENGLISH);
            }
            if (str.equals("meizu")) {
                setHint("");
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int selectedItemPosition;
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b = b();
            int i3 = 0;
            if (adapter != null && b != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                JB jb = this.e;
                if (!jb.z.isShowing()) {
                    selectedItemPosition = -1;
                } else {
                    selectedItemPosition = jb.c.getSelectedItemPosition();
                }
                int min = Math.min(adapter.getCount(), Math.max(0, selectedItemPosition) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, b);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable background = jb.z.getBackground();
                if (background != null) {
                    Rect rect = this.g;
                    background.getPadding(rect);
                    i4 += rect.left + rect.right;
                }
                i3 = b.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.e.p(getAdapter());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        JB jb = this.e;
        if (jb != null) {
            jb.h(drawable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDropDownBackgroundTint(int i) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof UD) {
            ((UD) dropDownBackground).o(this.j);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.e.q = getOnItemSelectedListener();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setRawInputType(int i) {
        super.setRawInputType(i);
        TextInputLayout b = b();
        if (b != null) {
            b.u();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSimpleItemSelectedColor(int i) {
        this.k = i;
        if (getAdapter() instanceof C4639wD) {
            ((C4639wD) getAdapter()).a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.l = colorStateList;
        if (getAdapter() instanceof C4639wD) {
            ((C4639wD) getAdapter()).a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSimpleItems(int i) {
        setSimpleItems(getResources().getStringArray(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.e.show();
        } else {
            super.showDropDown();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSimpleItems(String[] strArr) {
        setAdapter(new C4639wD(this, getContext(), this.h, strArr));
    }
}
