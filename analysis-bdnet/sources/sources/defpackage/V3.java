package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import dastan.prince.bdfreevpn.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class V3 extends DialogC4403wf implements DialogInterface, M4 {
    public LayoutInflaterFactory2C3250i5 e;
    public final C3328j5 f;
    public final T3 g;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v2, types: [j5] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V3(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, r2);
        int i2;
        int f = f(contextThemeWrapper, i);
        if (f == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = f;
        }
        this.f = new InterfaceC3180hA() { // from class: j5
            @Override // defpackage.InterfaceC3180hA
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return V3.this.h(keyEvent);
            }
        };
        U4 d = d();
        if (f == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            f = typedValue2.resourceId;
        }
        ((LayoutInflaterFactory2C3250i5) d).T = f;
        d.d();
        this.g = new T3(getContext(), this, getWindow());
    }

    public static int f(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // defpackage.DialogC4403wf, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) d();
        layoutInflaterFactory2C3250i5.w();
        ((ViewGroup) layoutInflaterFactory2C3250i5.A.findViewById(android.R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C3250i5.m.a(layoutInflaterFactory2C3250i5.l.getCallback());
    }

    public final Button c(int i) {
        T3 t3 = this.g;
        if (i == -3) {
            return t3.o;
        }
        if (i == -2) {
            return t3.l;
        }
        if (i == -1) {
            return t3.i;
        }
        t3.getClass();
        return null;
    }

    public final U4 d() {
        if (this.e == null) {
            T4 t4 = U4.a;
            this.e = new LayoutInflaterFactory2C3250i5(getContext(), getWindow(), this, this);
        }
        return this.e;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        d().e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return S50.q(this.f, getWindow().getDecorView(), this, keyEvent);
    }

    public final void e(Bundle bundle) {
        d().a();
        super.onCreate(bundle);
        d().d();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) d();
        layoutInflaterFactory2C3250i5.w();
        return layoutInflaterFactory2C3250i5.l.findViewById(i);
    }

    public final void g(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().l(charSequence);
    }

    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        d().b();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d2  */
    @Override // defpackage.DialogC4403wf, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCreate(Bundle bundle) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        AlertController$RecycleListView alertController$RecycleListView;
        AlertController$RecycleListView alertController$RecycleListView2;
        ListAdapter listAdapter;
        View findViewById;
        e(bundle);
        T3 t3 = this.g;
        t3.b.setContentView(t3.A);
        Window window = t3.c;
        View findViewById2 = window.findViewById(R.id.parentPanel);
        View findViewById3 = findViewById2.findViewById(R.id.topPanel);
        View findViewById4 = findViewById2.findViewById(R.id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        View view = t3.g;
        if (view == null) {
            view = null;
        }
        boolean z3 = view != null;
        if (!z3 || !T3.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z3) {
            i = 2;
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (t3.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (t3.f != null) {
                ((LinearLayout.LayoutParams) ((SB) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            i = 2;
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(R.id.topPanel);
        View findViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup b = T3.b(findViewById6, findViewById3);
        ViewGroup b2 = T3.b(findViewById7, findViewById4);
        ViewGroup b3 = T3.b(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        t3.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        t3.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b2.findViewById(android.R.id.message);
        t3.w = textView;
        if (textView != null) {
            String str = t3.e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                t3.r.removeView(t3.w);
                if (t3.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) t3.r.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(t3.r);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(t3.f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    b2.setVisibility(8);
                }
            }
        }
        Button button = (Button) b3.findViewById(android.R.id.button1);
        t3.i = button;
        ViewOnClickListenerC2840d viewOnClickListenerC2840d = t3.G;
        button.setOnClickListener(viewOnClickListenerC2840d);
        if (TextUtils.isEmpty(t3.j)) {
            t3.i.setVisibility(8);
            i2 = 0;
        } else {
            t3.i.setText(t3.j);
            t3.i.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) b3.findViewById(android.R.id.button2);
        t3.l = button2;
        button2.setOnClickListener(viewOnClickListenerC2840d);
        if (TextUtils.isEmpty(t3.m)) {
            t3.l.setVisibility(8);
        } else {
            t3.l.setText(t3.m);
            t3.l.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) b3.findViewById(android.R.id.button3);
        t3.o = button3;
        button3.setOnClickListener(viewOnClickListenerC2840d);
        if (TextUtils.isEmpty(t3.p)) {
            t3.o.setVisibility(8);
        } else {
            t3.o.setText(t3.p);
            t3.o.setVisibility(0);
            i2 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        t3.a.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i2 != 1) {
                i3 = i;
                if (i2 == i3) {
                    Button button4 = t3.l;
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                    layoutParams.gravity = 1;
                    layoutParams.weight = 0.5f;
                    button4.setLayoutParams(layoutParams);
                } else if (i2 == 4) {
                    Button button5 = t3.o;
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                    layoutParams2.gravity = 1;
                    layoutParams2.weight = 0.5f;
                    button5.setLayoutParams(layoutParams2);
                }
                if (i2 == 0) {
                    b3.setVisibility(8);
                }
                if (t3.x == null) {
                    b.addView(t3.x, 0, new ViewGroup.LayoutParams(-1, -2));
                    window.findViewById(R.id.title_template).setVisibility(8);
                } else {
                    t3.u = (ImageView) window.findViewById(android.R.id.icon);
                    if (TextUtils.isEmpty(t3.d) || !t3.E) {
                        window.findViewById(R.id.title_template).setVisibility(8);
                        t3.u.setVisibility(8);
                        b.setVisibility(8);
                    } else {
                        TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                        t3.v = textView2;
                        textView2.setText(t3.d);
                        int i5 = t3.s;
                        if (i5 != 0) {
                            t3.u.setImageResource(i5);
                        } else {
                            Drawable drawable = t3.t;
                            if (drawable != null) {
                                t3.u.setImageDrawable(drawable);
                            } else {
                                t3.v.setPadding(t3.u.getPaddingLeft(), t3.u.getPaddingTop(), t3.u.getPaddingRight(), t3.u.getPaddingBottom());
                                t3.u.setVisibility(8);
                            }
                        }
                    }
                }
                z = viewGroup.getVisibility() == 8;
                i4 = (b != null || b.getVisibility() == 8) ? 0 : 1;
                z2 = b3.getVisibility() == 8;
                if (!z2 && (findViewById = b2.findViewById(R.id.textSpacerNoButtons)) != null) {
                    findViewById.setVisibility(0);
                }
                if (i4 == 0) {
                    NestedScrollView nestedScrollView2 = t3.r;
                    if (nestedScrollView2 != null) {
                        nestedScrollView2.setClipToPadding(true);
                    }
                    View findViewById9 = (t3.e == null && t3.f == null) ? null : b.findViewById(R.id.titleDividerNoCustom);
                    if (findViewById9 != null) {
                        findViewById9.setVisibility(0);
                    }
                } else {
                    View findViewById10 = b2.findViewById(R.id.textSpacerNoTitle);
                    if (findViewById10 != null) {
                        findViewById10.setVisibility(0);
                    }
                }
                alertController$RecycleListView = t3.f;
                if (alertController$RecycleListView != null && (!z2 || i4 == 0)) {
                    alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i4 == 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.a, alertController$RecycleListView.getPaddingRight(), !z2 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.b);
                }
                if (!z) {
                    View view2 = t3.f;
                    if (view2 == null) {
                        view2 = t3.r;
                    }
                    if (view2 != null) {
                        int i6 = i4 | (z2 ? i3 : 0);
                        View findViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                        View findViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                        WeakHashMap weakHashMap = AbstractC2925e20.a;
                        view2.setScrollIndicators(i6, 3);
                        if (findViewById11 != null) {
                            b2.removeView(findViewById11);
                        }
                        if (findViewById12 != null) {
                            b2.removeView(findViewById12);
                        }
                    }
                }
                alertController$RecycleListView2 = t3.f;
                if (alertController$RecycleListView2 != null || (listAdapter = t3.y) == null) {
                }
                alertController$RecycleListView2.setAdapter(listAdapter);
                int i7 = t3.z;
                if (i7 > -1) {
                    alertController$RecycleListView2.setItemChecked(i7, true);
                    alertController$RecycleListView2.setSelection(i7);
                    return;
                }
                return;
            }
            Button button6 = t3.i;
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
            layoutParams3.gravity = 1;
            layoutParams3.weight = 0.5f;
            button6.setLayoutParams(layoutParams3);
        }
        i3 = i;
        if (i2 == 0) {
        }
        if (t3.x == null) {
        }
        if (viewGroup.getVisibility() == 8) {
        }
        if (b != null) {
        }
        if (b3.getVisibility() == 8) {
        }
        if (!z2) {
            findViewById.setVisibility(0);
        }
        if (i4 == 0) {
        }
        alertController$RecycleListView = t3.f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i4 == 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.a, alertController$RecycleListView.getPaddingRight(), !z2 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.b);
        }
        if (!z) {
        }
        alertController$RecycleListView2 = t3.f;
        if (alertController$RecycleListView2 != null) {
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.r;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.g.r;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // defpackage.DialogC4403wf, android.app.Dialog
    public final void onStop() {
        super.onStop();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) d();
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 != null) {
            p30.D = false;
            C4431x20 c4431x20 = p30.C;
            if (c4431x20 != null) {
                c4431x20.a();
            }
        }
    }

    @Override // defpackage.DialogC4403wf, android.app.Dialog
    public final void setContentView(int i) {
        b();
        d().h(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        d().l(getContext().getString(i));
    }

    @Override // defpackage.DialogC4403wf, android.app.Dialog
    public final void setContentView(View view) {
        b();
        d().j(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        g(charSequence);
        T3 t3 = this.g;
        t3.d = charSequence;
        TextView textView = t3.v;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // defpackage.DialogC4403wf, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        d().k(view, layoutParams);
    }
}
