package defpackage;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;

/* renamed from: b6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0778b6 {
    public static final Class[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {R.attr.onClick};
    public static final int[] d = {R.attr.accessibilityHeading};
    public static final int[] e = {R.attr.accessibilityPaneTitle};
    public static final int[] f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};
    public static final C4386wT h = new C4386wT(0);
    public final Object[] a = new Object[2];

    public J4 a(Context context, AttributeSet attributeSet) {
        return new J4(context, attributeSet);
    }

    public L4 b(Context context, AttributeSet attributeSet) {
        return new L4(context, attributeSet, dastan.prince.bdfreevpn.R.attr.buttonStyle);
    }

    public N4 c(Context context, AttributeSet attributeSet) {
        return new N4(context, attributeSet, dastan.prince.bdfreevpn.R.attr.checkboxStyle);
    }

    public C4120t5 d(Context context, AttributeSet attributeSet) {
        return new C4120t5(context, attributeSet);
    }

    public T5 e(Context context, AttributeSet attributeSet) {
        return new T5(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String concat;
        C4386wT c4386wT = h;
        Constructor constructor = (Constructor) c4386wT.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            c4386wT.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.a);
    }
}
