package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import app.vpn.amtunnellite.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class T00 {
    public static WeakHashMap a;
    public static Field b;
    public static boolean c;
    public static final int[] d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final G00 e = new G00();
    public static final I00 f = new I00();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C3619j10 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        C3619j10 c3619j10 = (C3619j10) a.get(view);
        if (c3619j10 == null) {
            C3619j10 c3619j102 = new C3619j10(view);
            a.put(view, c3619j102);
            return c3619j102;
        }
        return c3619j10;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = S00.d;
        S00 s00 = (S00) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (s00 == null) {
            s00 = new S00();
            s00.a = null;
            s00.b = null;
            s00.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, s00);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = s00.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = S00.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (s00.a == null) {
                            s00.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = S00.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                s00.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    s00.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a2 = s00.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (s00.b == null) {
                    s00.b = new SparseArray();
                }
                s00.b.put(keyCode, new WeakReference(a2));
            }
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return P00.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        Object obj = b.get(view);
        if (!(obj instanceof View.AccessibilityDelegate)) {
            return null;
        }
        return (View.AccessibilityDelegate) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence d(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = O00.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String[] f(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return R00.a(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void g(View view, int i) {
        boolean z;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (d(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        int i2 = 32;
        if (view.getAccessibilityLiveRegion() == 0 && !z) {
            if (i == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(d(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                    return;
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z) {
            i2 = 2048;
        }
        obtain2.setEventType(i2);
        obtain2.setContentChangeTypes(i);
        if (z) {
            obtain2.getText().add(d(view));
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C3903mg h(View view, C3903mg c3903mg) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c3903mg + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return R00.b(view, c3903mg);
        }
        OV ov = (OV) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC3644jI interfaceC3644jI = e;
        if (ov != null) {
            C3903mg a2 = OV.a(view, c3903mg);
            if (a2 == null) {
                return null;
            }
            if (view instanceof InterfaceC3644jI) {
                interfaceC3644jI = (InterfaceC3644jI) view;
            }
            return interfaceC3644jI.a(a2);
        }
        if (view instanceof InterfaceC3644jI) {
            interfaceC3644jI = (InterfaceC3644jI) view;
        }
        return interfaceC3644jI.a(c3903mg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void i(View view, int i) {
        ArrayList e2 = e(view);
        for (int i2 = 0; i2 < e2.size(); i2++) {
            if (((C0) e2.get(i2)).a() == i) {
                e2.remove(i2);
                return;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void j(View view, C0 c0, R0 r0) {
        C4539v0 c4539v0;
        if (r0 == null) {
            i(view, c0.a());
            g(view, 0);
            return;
        }
        C0 c02 = new C0(null, c0.b, null, r0, c0.c);
        View.AccessibilityDelegate c2 = c(view);
        if (c2 == null) {
            c4539v0 = null;
        } else if (c2 instanceof C4462u0) {
            c4539v0 = ((C4462u0) c2).a;
        } else {
            c4539v0 = new C4539v0(c2);
        }
        if (c4539v0 == null) {
            c4539v0 = new C4539v0();
        }
        l(view, c4539v0);
        i(view, c02.a());
        e(view).add(c02);
        g(view, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void k(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            P00.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void l(View view, C4539v0 c4539v0) {
        C4462u0 c4462u0;
        if (c4539v0 == null && (c(view) instanceof C4462u0)) {
            c4539v0 = new C4539v0();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        if (c4539v0 == null) {
            c4462u0 = null;
        } else {
            c4462u0 = c4539v0.b;
        }
        view.setAccessibilityDelegate(c4462u0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void m(View view, CharSequence charSequence) {
        boolean z;
        new H00(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).E(view, charSequence);
        I00 i00 = f;
        if (charSequence != null) {
            WeakHashMap weakHashMap = i00.a;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z));
            view.addOnAttachStateChangeListener(i00);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(i00);
                return;
            }
            return;
        }
        i00.a.remove(view);
        view.removeOnAttachStateChangeListener(i00);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(i00);
    }
}
