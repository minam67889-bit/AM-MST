package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import app.vpn.amtunnellite.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* loaded from: classes.dex */
public final class V9 extends C4539v0 {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ V9(Object obj, int i) {
        this.d = i;
        this.e = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C4539v0
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        int i = this.d;
        super.c(view, accessibilityEvent);
        switch (i) {
            case 1:
                accessibilityEvent.setChecked(((CheckableImageButton) this.e).d);
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C4539v0
    public final void d(View view, G0 g0) {
        int i;
        int i2;
        Object obj = this.e;
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        switch (this.d) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = g0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                g0.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo2 = g0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.e);
                accessibilityNodeInfo2.setChecked(checkableImageButton.d);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo3 = g0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                int i3 = MaterialButtonToggleGroup.q;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i4 = 0;
                    for (int i5 = 0; i5 < materialButtonToggleGroup.getChildCount(); i5++) {
                        if (materialButtonToggleGroup.getChildAt(i5) == view) {
                            i = i4;
                            accessibilityNodeInfo3.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i, 1, false, ((MaterialButton) view).o));
                            break;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i5).getVisibility() != 8) {
                                i4++;
                            }
                        }
                    }
                }
                i = -1;
                accessibilityNodeInfo3.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i, 1, false, ((MaterialButton) view).o));
                break;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, g0.a);
                ID id = (ID) obj;
                if (id.l.getVisibility() == 0) {
                    i2 = R.string.mtrl_picker_toggle_to_year_selection;
                } else {
                    i2 = R.string.mtrl_picker_toggle_to_day_selection;
                }
                g0.b(new C0(16, id.getString(i2)));
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo4 = g0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                accessibilityNodeInfo4.setCheckable(((NavigationMenuItemView) obj).x);
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C4539v0
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.d) {
            case 0:
                if (i != 1048576) {
                    break;
                } else {
                    ((US) ((Z9) this.e)).a(3);
                    break;
                }
        }
        return super.g(view, i, bundle);
    }
}
