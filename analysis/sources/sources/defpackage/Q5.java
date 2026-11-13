package defpackage;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class Q5 {
    public static final Class[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {R.attr.onClick};
    public static final int[] d = {R.attr.accessibilityHeading};
    public static final int[] e = {R.attr.accessibilityPaneTitle};
    public static final int[] f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};
    public static final DS h = new DS();
    public final Object[] a = new Object[2];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4778y4 a(Context context, AttributeSet attributeSet) {
        return new C4778y4(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public A4 b(Context context, AttributeSet attributeSet) {
        return new A4(context, attributeSet, app.vpn.amtunnellite.R.attr.buttonStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4 c(Context context, AttributeSet attributeSet) {
        return new C4(context, attributeSet, app.vpn.amtunnellite.R.attr.checkboxStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3551i5 d(Context context, AttributeSet attributeSet) {
        return new C3551i5(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public I5 e(Context context, AttributeSet attributeSet) {
        return new I5(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final View f(Context context, String str, String str2) {
        String concat;
        DS ds = h;
        Constructor constructor = (Constructor) ds.get(str);
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
            ds.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.a);
    }
}
