package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import dastan.prince.bdfreevpn.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class T3 {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final boolean E;
    public final R3 F;
    public final Context a;
    public final V3 b;
    public final Window c;
    public CharSequence d;
    public String e;
    public AlertController$RecycleListView f;
    public View g;
    public Button i;
    public String j;
    public Message k;
    public Button l;
    public String m;
    public Message n;
    public Button o;
    public String p;
    public Message q;
    public NestedScrollView r;
    public Drawable t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public View x;
    public ListAdapter y;
    public boolean h = false;
    public int s = 0;
    public int z = -1;
    public final ViewOnClickListenerC2840d G = new ViewOnClickListenerC2840d(this, 3);

    public T3(Context context, V3 v3, Window window) {
        this.a = context;
        this.b = v3;
        this.c = window;
        R3 r3 = new R3();
        r3.b = new WeakReference(v3);
        this.F = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, GM.e, R.attr.alertDialogStyle, 0);
        this.A = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.B = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.C = obtainStyledAttributes.getResourceId(7, 0);
        this.D = obtainStyledAttributes.getResourceId(3, 0);
        this.E = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        v3.d().g(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, String str, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.F.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.p = str;
            this.q = obtainMessage;
        } else if (i == -2) {
            this.m = str;
            this.n = obtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.j = str;
            this.k = obtainMessage;
        }
    }
}
