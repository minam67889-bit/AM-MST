package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import defpackage.AF;
import defpackage.AbstractC0210Hs;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC4618zO;
import defpackage.C3503lF;
import defpackage.C3604ma;
import defpackage.S50;
import defpackage.SB;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends AbstractC0210Hs implements AF {
    public static final int[] G = {R.attr.state_checked};
    public FrameLayout A;
    public C3503lF B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final C3604ma F;
    public int v;
    public boolean w;
    public boolean x;
    public final boolean y;
    public final CheckedTextView z;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = true;
        C3604ma c3604ma = new C3604ma(this, 4);
        this.F = c3604ma;
        setOrientation(0);
        LayoutInflater.from(context).inflate(dastan.prince.bdfreevpn.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(dastan.prince.bdfreevpn.R.id.design_menu_item_text);
        this.z = checkedTextView;
        AbstractC2925e20.m(checkedTextView, c3604ma);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(dastan.prince.bdfreevpn.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // defpackage.AF
    public final void c(C3503lF c3503lF) {
        StateListDrawable stateListDrawable;
        this.B = c3503lF;
        int i = c3503lF.a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(c3503lF.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(dastan.prince.bdfreevpn.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(c3503lF.isCheckable());
        setChecked(c3503lF.isChecked());
        setEnabled(c3503lF.isEnabled());
        setTitle(c3503lF.e);
        setIcon(c3503lF.getIcon());
        setActionView(c3503lF.getActionView());
        setContentDescription(c3503lF.q);
        S50.F(this, c3503lF.r);
        C3503lF c3503lF2 = this.B;
        CharSequence charSequence = c3503lF2.e;
        CheckedTextView checkedTextView = this.z;
        if (charSequence == null && c3503lF2.getIcon() == null && this.B.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                SB sb = (SB) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) sb).width = -1;
                this.A.setLayoutParams(sb);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            SB sb2 = (SB) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) sb2).width = -2;
            this.A.setLayoutParams(sb2);
        }
    }

    @Override // defpackage.AF
    public C3503lF getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        C3503lF c3503lF = this.B;
        if (c3503lF != null && c3503lF.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.x != z) {
            this.x = z;
            this.F.h(this.z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.z;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.y) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.C);
            }
            int i = this.v;
            drawable.setBounds(0, 0, i, i);
        } else if (this.w) {
            if (this.E == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = AbstractC4618zO.a;
                Drawable drawable2 = resources.getDrawable(dastan.prince.bdfreevpn.R.drawable.navigation_empty_icon, theme);
                this.E = drawable2;
                if (drawable2 != null) {
                    int i2 = this.v;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        this.z.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.v = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        C3503lF c3503lF = this.B;
        if (c3503lF != null) {
            setIcon(c3503lF.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.z.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.w = z;
    }

    public void setTextAppearance(int i) {
        this.z.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
