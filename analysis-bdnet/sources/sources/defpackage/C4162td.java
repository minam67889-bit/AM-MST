package defpackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.material.chip.Chip;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* renamed from: td, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4162td extends C4505y0 {
    public static final Rect o = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final C0213Hv p = new C0213Hv(18);
    public static final C4254un q = new C4254un(19);
    public final AccessibilityManager h;
    public final Chip i;
    public C3068fp j;
    public final /* synthetic */ Chip n;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    public C4162td(Chip chip, Chip chip2) {
        this.n = chip;
        this.i = chip2;
        this.h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
        chip2.setFocusable(true);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        if (chip2.getImportantForAccessibility() == 0) {
            chip2.setImportantForAccessibility(1);
        }
    }

    @Override // defpackage.C4505y0
    public final C2835cv b(View view) {
        if (this.j == null) {
            this.j = new C3068fp(this);
        }
        return this.j;
    }

    @Override // defpackage.C4505y0
    public final void d(View view, L0 l0) {
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        AccessibilityNodeInfo accessibilityNodeInfo = l0.a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.n;
        C4320vd c4320vd = chip.e;
        accessibilityNodeInfo.setCheckable(c4320vd != null && c4320vd.a0);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        l0.i(chip.getAccessibilityClassName());
        l0.k(chip.getText());
    }

    public final boolean j(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        o(i, false);
        q(i, 8);
        return true;
    }

    public final L0 k(int i) {
        Rect closeIconTouchBoundsInt;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        L0 l0 = new L0(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        l0.i("android.view.View");
        Rect rect = o;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        Chip chip = this.i;
        obtain.setParent(chip);
        AccessibilityNodeInfo accessibilityNodeInfo = l0.a;
        if (i == 1) {
            Chip chip2 = this.n;
            CharSequence closeIconContentDescription = chip2.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip2.getText();
                accessibilityNodeInfo.setContentDescription(chip2.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            closeIconTouchBoundsInt = chip2.getCloseIconTouchBoundsInt();
            accessibilityNodeInfo.setBoundsInParent(closeIconTouchBoundsInt);
            l0.b(F0.g);
            accessibilityNodeInfo.setEnabled(chip2.isEnabled());
            l0.i(Button.class.getName());
        } else {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.w);
        }
        if (l0.g() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.e;
        l0.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & UserVerificationMethods.USER_VERIFY_PATTERN) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(chip.getContext().getPackageName());
        l0.b = i;
        obtain.setSource(chip, i);
        if (this.k == i) {
            obtain.setAccessibilityFocused(true);
            l0.a(UserVerificationMethods.USER_VERIFY_PATTERN);
        } else {
            obtain.setAccessibilityFocused(false);
            l0.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            l0.a(2);
        } else if (obtain.isFocusable()) {
            l0.a(1);
        }
        obtain.setFocused(z);
        int[] iArr = this.g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.d;
        obtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            l0.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                obtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            l0.a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return l0;
    }

    public final void l(ArrayList arrayList) {
        C4320vd c4320vd;
        arrayList.add(0);
        Rect rect = Chip.w;
        Chip chip = this.n;
        if (!chip.c() || (c4320vd = chip.e) == null || !c4320vd.U || chip.h == null) {
            return;
        }
        arrayList.add(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m(int i, Rect rect) {
        int i2;
        int i3;
        Object obj;
        L0 l0;
        Object obj2;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        C3120gU c3120gU = new C3120gU();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            c3120gU.c(((Integer) arrayList.get(i7)).intValue(), k(((Integer) arrayList.get(i7)).intValue()));
        }
        int i8 = this.l;
        int i9 = Integer.MIN_VALUE;
        L0 l02 = i8 == Integer.MIN_VALUE ? null : (L0) c3120gU.b(i8);
        C0213Hv c0213Hv = p;
        C4254un c4254un = q;
        Chip chip = this.i;
        if (i == 1 || i == 2) {
            i2 = 0;
            i3 = -1;
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            boolean z = chip.getLayoutDirection() == 1;
            c4254un.getClass();
            int i10 = c3120gU.c;
            ArrayList arrayList2 = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList2.add((L0) c3120gU.d(i11));
            }
            Collections.sort(arrayList2, new C3944qs(c0213Hv, z));
            if (i == 1) {
                int size = arrayList2.size();
                if (l02 != null) {
                    size = arrayList2.indexOf(l02);
                }
                int i12 = size - 1;
                if (i12 >= 0) {
                    obj2 = arrayList2.get(i12);
                    obj = obj2;
                }
                obj = null;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int size2 = arrayList2.size();
                int lastIndexOf = (l02 == null ? -1 : arrayList2.lastIndexOf(l02)) + 1;
                if (lastIndexOf < size2) {
                    obj2 = arrayList2.get(lastIndexOf);
                    obj = obj2;
                }
                obj = null;
            }
            l0 = (L0) obj;
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.l;
            if (i13 != Integer.MIN_VALUE) {
                n(i13).f(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = chip.getWidth();
                int height = chip.getHeight();
                if (i == 17) {
                    i3 = -1;
                    rect2.set(width, 0, width, height);
                } else if (i == 33) {
                    i3 = -1;
                    rect2.set(0, height, width, height);
                } else if (i == 66) {
                    rect2.set(-1, 0, -1, height);
                    i3 = -1;
                } else {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect2.set(0, -1, width, -1);
                    i3 = -1;
                }
                Rect rect3 = new Rect(rect2);
                if (i != 17) {
                    i2 = 0;
                    rect3.offset(rect2.width() + 1, 0);
                } else if (i == 33) {
                    i2 = 0;
                    rect3.offset(0, rect2.height() + 1);
                } else if (i == 66) {
                    i2 = 0;
                    rect3.offset(-(rect2.width() + 1), 0);
                } else {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i2 = 0;
                    rect3.offset(0, -(rect2.height() + 1));
                }
                c4254un.getClass();
                i5 = c3120gU.c;
                Rect rect4 = new Rect();
                l0 = null;
                for (i6 = i2; i6 < i5; i6++) {
                    L0 l03 = (L0) c3120gU.d(i6);
                    if (l03 != l02) {
                        c0213Hv.getClass();
                        l03.f(rect4);
                        if (AbstractC0538Uj.y(i, rect2, rect4)) {
                            if (AbstractC0538Uj.y(i, rect2, rect3) && !AbstractC0538Uj.b(i, rect2, rect4, rect3)) {
                                if (!AbstractC0538Uj.b(i, rect2, rect3, rect4)) {
                                    int B = AbstractC0538Uj.B(i, rect2, rect4);
                                    int E = AbstractC0538Uj.E(i, rect2, rect4);
                                    int i14 = (E * E) + (B * 13 * B);
                                    int B2 = AbstractC0538Uj.B(i, rect2, rect3);
                                    int E2 = AbstractC0538Uj.E(i, rect2, rect3);
                                    if (i14 >= (E2 * E2) + (B2 * 13 * B2)) {
                                    }
                                }
                            }
                            rect3.set(rect4);
                            l0 = l03;
                        }
                    }
                }
            }
            i3 = -1;
            Rect rect32 = new Rect(rect2);
            if (i != 17) {
            }
            c4254un.getClass();
            i5 = c3120gU.c;
            Rect rect42 = new Rect();
            l0 = null;
            while (i6 < i5) {
            }
        }
        L0 l04 = l0;
        if (l04 != null) {
            int i15 = c3120gU.c;
            int i16 = i2;
            while (true) {
                if (i16 >= i15) {
                    i4 = i3;
                    break;
                }
                if (c3120gU.b[i16] == l04) {
                    i4 = i16;
                    break;
                }
                i16++;
            }
            i9 = c3120gU.a[i4];
        }
        return p(i9);
    }

    public final L0 n(int i) {
        if (i != -1) {
            return k(i);
        }
        Chip chip = this.i;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(chip);
        L0 l0 = new L0(obtain);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        chip.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            l0.a.addChild(chip, ((Integer) arrayList.get(i2)).intValue());
        }
        return l0;
    }

    public final void o(int i, boolean z) {
        Chip chip = this.n;
        if (i == 1) {
            chip.m = z;
        }
        C4320vd c4320vd = chip.e;
        boolean z2 = chip.m;
        boolean z3 = false;
        if (c4320vd.V != null) {
            z3 = c4320vd.R(z2 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : C4320vd.P0);
        }
        if (z3) {
            chip.refreshDrawableState();
        }
    }

    public final boolean p(int i) {
        int i2;
        Chip chip = this.i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            j(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        o(i, true);
        q(i, 8);
        return true;
    }

    public final void q(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        if (i != -1) {
            obtain = AccessibilityEvent.obtain(i2);
            L0 n = n(i);
            obtain.getText().add(n.g());
            AccessibilityNodeInfo accessibilityNodeInfo = n.a;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            obtain.setSource(view, i);
            obtain.setPackageName(view.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(view, obtain);
    }
}
