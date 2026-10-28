package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.AF;
import defpackage.C3503lF;
import defpackage.C4452xG;
import defpackage.GM;
import defpackage.MenuC2945eF;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AF, AbsListView.SelectionBoundsAdjuster {
    public C3503lF a;
    public ImageView b;
    public RadioButton c;
    public TextView d;
    public CheckBox e;
    public TextView f;
    public ImageView g;
    public ImageView h;
    public LinearLayout i;
    public final Drawable j;
    public final int k;
    public final Context l;
    public boolean m;
    public final Drawable n;
    public final boolean o;
    public LayoutInflater p;
    public boolean q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C4452xG n = C4452xG.n(getContext(), attributeSet, GM.r, R.attr.listMenuViewStyle);
        this.j = n.i(5);
        TypedArray typedArray = (TypedArray) n.c;
        this.k = typedArray.getResourceId(1, -1);
        this.m = typedArray.getBoolean(7, false);
        this.l = context;
        this.n = n.i(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        n.q();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        rect.top = this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    @Override // defpackage.AF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(C3503lF c3503lF) {
        boolean z;
        String sb;
        boolean z2;
        this.a = c3503lF;
        int i = 0;
        setVisibility(c3503lF.isVisible() ? 0 : 8);
        setTitle(c3503lF.e);
        setCheckable(c3503lF.isCheckable());
        if (c3503lF.n.o()) {
            if ((c3503lF.n.n() ? c3503lF.j : c3503lF.h) != 0) {
                z = true;
                c3503lF.n.n();
                if (z) {
                    C3503lF c3503lF2 = this.a;
                    if (c3503lF2.n.o()) {
                        if ((c3503lF2.n.n() ? c3503lF2.j : c3503lF2.h) != 0) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                i = 8;
                if (i == 0) {
                    TextView textView = this.f;
                    C3503lF c3503lF3 = this.a;
                    char c = c3503lF3.n.n() ? c3503lF3.j : c3503lF3.h;
                    if (c == 0) {
                        sb = "";
                    } else {
                        MenuC2945eF menuC2945eF = c3503lF3.n;
                        Resources resources = menuC2945eF.a.getResources();
                        StringBuilder sb2 = new StringBuilder();
                        if (ViewConfiguration.get(menuC2945eF.a).hasPermanentMenuKey()) {
                            sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
                        }
                        int i2 = menuC2945eF.n() ? c3503lF3.k : c3503lF3.i;
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_meta_shortcut_label), i2, 65536);
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_ctrl_shortcut_label), i2, 4096);
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_alt_shortcut_label), i2, 2);
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_shift_shortcut_label), i2, 1);
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_sym_shortcut_label), i2, 4);
                        C3503lF.c(sb2, resources.getString(R.string.abc_menu_function_shortcut_label), i2, 8);
                        if (c == '\b') {
                            sb2.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                        } else if (c == '\n') {
                            sb2.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                        } else if (c != ' ') {
                            sb2.append(c);
                        } else {
                            sb2.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                        }
                        sb = sb2.toString();
                    }
                    textView.setText(sb);
                }
                if (this.f.getVisibility() != i) {
                    this.f.setVisibility(i);
                }
                setIcon(c3503lF.getIcon());
                setEnabled(c3503lF.isEnabled());
                setSubMenuArrowVisible(c3503lF.hasSubMenu());
                setContentDescription(c3503lF.q);
            }
        }
        z = false;
        c3503lF.n.n();
        if (z) {
        }
        i = 8;
        if (i == 0) {
        }
        if (this.f.getVisibility() != i) {
        }
        setIcon(c3503lF.getIcon());
        setEnabled(c3503lF.isEnabled());
        setSubMenuArrowVisible(c3503lF.hasSubMenu());
        setContentDescription(c3503lF.q);
    }

    @Override // defpackage.AF
    public C3503lF getItemData() {
        return this.a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.d = textView;
        int i = this.k;
        if (i != -1) {
            textView.setTextAppearance(this.l, i);
        }
        this.f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(R.id.group_divider);
        this.i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.c == null && this.e == null) {
            return;
        }
        if ((this.a.x & 4) != 0) {
            if (this.c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.c = radioButton;
                LinearLayout linearLayout = this.i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.c;
            view = this.e;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
            view = this.c;
        }
        if (z) {
            compoundButton.setChecked(this.a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.a.x & 4) != 0) {
            if (this.c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.c = radioButton;
                LinearLayout linearLayout = this.i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.a.n.getClass();
        boolean z = this.q;
        if (z || this.m) {
            ImageView imageView = this.b;
            if (imageView == null && drawable == null && !this.m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.b = imageView2;
                LinearLayout linearLayout = this.i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.m) {
                this.b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.d.getVisibility() != 8) {
                this.d.setVisibility(8);
            }
        } else {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
    }
}
