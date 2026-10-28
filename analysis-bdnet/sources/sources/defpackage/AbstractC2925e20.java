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
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import dastan.prince.bdfreevpn.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: e20, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC2925e20 {
    public static WeakHashMap a;
    public static Field b;
    public static boolean c;
    public static final int[] d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final R10 e = new R10();
    public static final T10 f = new T10();

    public static C4352w20 a(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        C4352w20 c4352w20 = (C4352w20) a.get(view);
        if (c4352w20 != null) {
            return c4352w20;
        }
        C4352w20 c4352w202 = new C4352w20(view);
        a.put(view, c4352w202);
        return c4352w202;
    }

    public static void b(View view, C4119t40 c4119t40) {
        WindowInsets f2 = c4119t40.f();
        if (f2 != null) {
            WindowInsets a2 = Build.VERSION.SDK_INT >= 30 ? AbstractC0771b20.a(view, f2) : U10.a(view, f2);
            if (a2.equals(f2)) {
                return;
            }
            C4119t40.g(view, a2);
        }
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = C2846d20.d;
        C2846d20 c2846d20 = (C2846d20) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (c2846d20 == null) {
            c2846d20 = new C2846d20();
            c2846d20.a = null;
            c2846d20.b = null;
            c2846d20.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, c2846d20);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = c2846d20.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = C2846d20.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (c2846d20.a == null) {
                            c2846d20.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = C2846d20.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                c2846d20.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    c2846d20.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a2 = c2846d20.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (c2846d20.b == null) {
                    c2846d20.b = new SparseArray();
                }
                c2846d20.b.put(keyCode, new WeakReference(a2));
            }
        }
        return a2 != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return AbstractC0691a20.a(view);
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
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Z10.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(C3568m5 c3568m5) {
        return Build.VERSION.SDK_INT >= 31 ? AbstractC0850c20.a(c3568m5) : (String[]) c3568m5.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i != 32) {
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
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            obtain2.setContentChangeTypes(i);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(e(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0042Bg i(View view, C0042Bg c0042Bg) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0042Bg + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0850c20.b(view, c0042Bg);
        }
        HW hw = (HW) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC3347jJ interfaceC3347jJ = e;
        if (hw == null) {
            if (view instanceof InterfaceC3347jJ) {
                interfaceC3347jJ = (InterfaceC3347jJ) view;
            }
            return interfaceC3347jJ.a(c0042Bg);
        }
        C0042Bg a2 = HW.a(view, c0042Bg);
        if (a2 == null) {
            return null;
        }
        if (view instanceof InterfaceC3347jJ) {
            interfaceC3347jJ = (InterfaceC3347jJ) view;
        }
        return interfaceC3347jJ.a(a2);
    }

    public static void j(View view, int i) {
        ArrayList f2 = f(view);
        for (int i2 = 0; i2 < f2.size(); i2++) {
            if (((F0) f2.get(i2)).a() == i) {
                f2.remove(i2);
                return;
            }
        }
    }

    public static void k(View view, F0 f0, V0 v0) {
        if (v0 == null) {
            j(view, f0.a());
            h(view, 0);
            return;
        }
        F0 f02 = new F0(null, f0.b, null, v0, f0.c);
        View.AccessibilityDelegate d2 = d(view);
        C4505y0 c4505y0 = d2 == null ? null : d2 instanceof C4426x0 ? ((C4426x0) d2).a : new C4505y0(d2);
        if (c4505y0 == null) {
            c4505y0 = new C4505y0();
        }
        m(view, c4505y0);
        j(view, f02.a());
        f(view).add(f02);
        h(view, 0);
    }

    public static void l(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0691a20.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void m(View view, C4505y0 c4505y0) {
        if (c4505y0 == null && (d(view) instanceof C4426x0)) {
            c4505y0 = new C4505y0();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(c4505y0 == null ? null : c4505y0.b);
    }

    public static void n(View view, CharSequence charSequence) {
        new S10(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        T10 t10 = f;
        if (charSequence == null) {
            t10.a.remove(view);
            view.removeOnAttachStateChangeListener(t10);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(t10);
        } else {
            t10.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(t10);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(t10);
            }
        }
    }

    public static void o(View view, C4580yx c4580yx) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new T30(c4580yx));
            return;
        }
        PathInterpolator pathInterpolator = S30.e;
        View.OnApplyWindowInsetsListener r30 = new R30(view, c4580yx);
        view.setTag(R.id.tag_window_insets_animation_callback, r30);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(r30);
        }
    }
}
