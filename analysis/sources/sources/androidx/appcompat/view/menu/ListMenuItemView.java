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
import app.vpn.amtunnellite.R;
import defpackage.C4563vE;
import defpackage.EL;
import defpackage.KE;
import defpackage.LQ;
import defpackage.MenuC3948nE;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements KE, AbsListView.SelectionBoundsAdjuster {
    public C4563vE a;
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LQ j = LQ.j(R.attr.listMenuViewStyle, 0, getContext(), attributeSet, EL.r);
        this.j = j.e(5);
        TypedArray typedArray = (TypedArray) j.b;
        this.k = typedArray.getResourceId(1, -1);
        this.m = typedArray.getBoolean(7, false);
        this.l = context;
        this.n = j.e(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        j.m();
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
    /* JADX WARN: Removed duplicated region for block: B:50:0x0118  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.KE
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(C4563vE c4563vE) {
        boolean z;
        int i;
        String sb;
        boolean z2;
        this.a = c4563vE;
        int i2 = 0;
        setVisibility(c4563vE.isVisible() ? 0 : 8);
        setTitle(c4563vE.e);
        setCheckable(c4563vE.isCheckable());
        if (c4563vE.n.o()) {
            if ((c4563vE.n.n() ? c4563vE.j : c4563vE.h) != 0) {
                z = true;
                c4563vE.n.n();
                if (z) {
                    C4563vE c4563vE2 = this.a;
                    if (c4563vE2.n.o()) {
                        if ((c4563vE2.n.n() ? c4563vE2.j : c4563vE2.h) != 0) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                i2 = 8;
                if (i2 == 0) {
                    TextView textView = this.f;
                    C4563vE c4563vE3 = this.a;
                    char c = c4563vE3.n.n() ? c4563vE3.j : c4563vE3.h;
                    if (c == 0) {
                        sb = "";
                    } else {
                        MenuC3948nE menuC3948nE = c4563vE3.n;
                        Resources resources = menuC3948nE.a.getResources();
                        StringBuilder sb2 = new StringBuilder();
                        if (ViewConfiguration.get(menuC3948nE.a).hasPermanentMenuKey()) {
                            sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
                        }
                        int i3 = menuC3948nE.n() ? c4563vE3.k : c4563vE3.i;
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_meta_shortcut_label), i3, 65536);
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_ctrl_shortcut_label), i3, 4096);
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_alt_shortcut_label), i3, 2);
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_shift_shortcut_label), i3, 1);
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_sym_shortcut_label), i3, 4);
                        C4563vE.b(sb2, resources.getString(R.string.abc_menu_function_shortcut_label), i3, 8);
                        if (c == '\b') {
                            i = R.string.abc_menu_delete_shortcut_label;
                        } else if (c == '\n') {
                            i = R.string.abc_menu_enter_shortcut_label;
                        } else if (c != ' ') {
                            sb2.append(c);
                            sb = sb2.toString();
                        } else {
                            i = R.string.abc_menu_space_shortcut_label;
                        }
                        sb2.append(resources.getString(i));
                        sb = sb2.toString();
                    }
                    textView.setText(sb);
                }
                if (this.f.getVisibility() != i2) {
                    this.f.setVisibility(i2);
                }
                setIcon(c4563vE.getIcon());
                setEnabled(c4563vE.isEnabled());
                setSubMenuArrowVisible(c4563vE.hasSubMenu());
                setContentDescription(c4563vE.q);
            }
        }
        z = false;
        c4563vE.n.n();
        if (z) {
        }
        i2 = 8;
        if (i2 == 0) {
        }
        if (this.f.getVisibility() != i2) {
        }
        setIcon(c4563vE.getIcon());
        setEnabled(c4563vE.isEnabled());
        setSubMenuArrowVisible(c4563vE.hasSubMenu());
        setContentDescription(c4563vE.q);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.KE
    public C4563vE getItemData() {
        return this.a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.m = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() == 0) {
                return;
            }
            textView = this.d;
            i = 0;
        } else {
            i = 8;
            if (this.d.getVisibility() == 8) {
                return;
            } else {
                textView = this.d;
            }
        }
        textView.setVisibility(i);
    }
}
