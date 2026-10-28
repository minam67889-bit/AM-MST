package defpackage;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import app.vpn.amtunnellite.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4539v0 {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate a;
    public final C4462u0 b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4539v0() {
        this(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public J0 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new J0(accessibilityNodeProvider, 0);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void d(View view, G0 g0) {
        this.a.onInitializeAccessibilityNodeInfo(view, g0.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean g(View view, int i, Bundle bundle) {
        ClickableSpan[] clickableSpanArr;
        boolean z;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            clickableSpanArr = null;
            if (i2 >= list.size()) {
                break;
            }
            C0 c0 = (C0) list.get(i2);
            if (c0.a() == i) {
                R0 r0 = c0.d;
                if (r0 != null) {
                    Class cls = c0.c;
                    if (cls != null) {
                        try {
                            AbstractC4575vQ.B(cls.getDeclaredConstructor(null).newInstance(null));
                            throw null;
                        } catch (Exception e) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e);
                        }
                    }
                    z = r0.a(view);
                }
            } else {
                i2++;
            }
        }
        z = false;
        if (!z) {
            z = this.a.performAccessibilityAction(view, i, bundle);
        }
        if (!z && i == R.id.accessibility_action_clickable_span && bundle != null) {
            int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i3)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                }
                int i4 = 0;
                while (true) {
                    if (clickableSpanArr == null || i4 >= clickableSpanArr.length) {
                        break;
                    }
                    if (clickableSpan.equals(clickableSpanArr[i4])) {
                        clickableSpan.onClick(view);
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            return z2;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void h(View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4539v0(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new C4462u0(this);
    }
}
