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
import defpackage.AbstractC3224ds;
import defpackage.AbstractC4766xx;
import defpackage.C0714aB;
import defpackage.C4563vE;
import defpackage.CN;
import defpackage.KE;
import defpackage.T00;
import defpackage.V9;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends AbstractC3224ds implements KE {
    public static final int[] G = {R.attr.state_checked};
    public FrameLayout A;
    public C4563vE B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final V9 F;
    public int v;
    public boolean w;
    public boolean x;
    public final boolean y;
    public final CheckedTextView z;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = true;
        V9 v9 = new V9(this, 4);
        this.F = v9;
        setOrientation(0);
        LayoutInflater.from(context).inflate(app.vpn.amtunnellite.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(app.vpn.amtunnellite.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(app.vpn.amtunnellite.R.id.design_menu_item_text);
        this.z = checkedTextView;
        T00.l(checkedTextView, v9);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(app.vpn.amtunnellite.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.KE
    public final void c(C4563vE c4563vE) {
        C0714aB c0714aB;
        int i;
        StateListDrawable stateListDrawable;
        this.B = c4563vE;
        int i2 = c4563vE.a;
        if (i2 > 0) {
            setId(i2);
        }
        setVisibility(c4563vE.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(app.vpn.amtunnellite.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(c4563vE.isCheckable());
        setChecked(c4563vE.isChecked());
        setEnabled(c4563vE.isEnabled());
        setTitle(c4563vE.e);
        setIcon(c4563vE.getIcon());
        setActionView(c4563vE.getActionView());
        setContentDescription(c4563vE.q);
        AbstractC4766xx.W(this, c4563vE.r);
        C4563vE c4563vE2 = this.B;
        CharSequence charSequence = c4563vE2.e;
        CheckedTextView checkedTextView = this.z;
        if (charSequence == null && c4563vE2.getIcon() == null && this.B.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                return;
            }
            c0714aB = (C0714aB) frameLayout.getLayoutParams();
            i = -1;
        } else {
            checkedTextView.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                return;
            }
            c0714aB = (C0714aB) frameLayout2.getLayoutParams();
            i = -2;
        }
        ((LinearLayout.LayoutParams) c0714aB).width = i;
        this.A.setLayoutParams(c0714aB);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.KE
    public C4563vE getItemData() {
        return this.B;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        C4563vE c4563vE = this.B;
        if (c4563vE != null && c4563vE.isCheckable() && this.B.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.x != z) {
            this.x = z;
            this.F.h(this.z, 2048);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.z;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.y) ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
                ThreadLocal threadLocal = CN.a;
                Drawable drawable2 = resources.getDrawable(app.vpn.amtunnellite.R.drawable.navigation_empty_icon, theme);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconSize(int i) {
        this.v = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        C4563vE c4563vE = this.B;
        if (c4563vE != null) {
            setIcon(c4563vE.getIcon());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxLines(int i) {
        this.z.setMaxLines(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNeedsEmptyIcon(boolean z) {
        this.w = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextAppearance(int i) {
        this.z.setTextAppearance(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
