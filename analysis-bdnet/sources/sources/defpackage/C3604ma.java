package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import dastan.prince.bdfreevpn.R;

/* renamed from: ma, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3604ma extends C4505y0 {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ C3604ma(Object obj, int i) {
        this.d = i;
        this.e = obj;
    }

    @Override // defpackage.C4505y0
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.d) {
            case 1:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.e).d);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // defpackage.C4505y0
    public final void d(View view, L0 l0) {
        int i;
        Object obj = this.e;
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        switch (this.d) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = l0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                l0.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo2 = l0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.e);
                accessibilityNodeInfo2.setChecked(checkableImageButton.d);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo3 = l0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                int i2 = MaterialButtonToggleGroup.q;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                if (view instanceof MaterialButton) {
                    i = 0;
                    for (int i3 = 0; i3 < materialButtonToggleGroup.getChildCount(); i3++) {
                        if (materialButtonToggleGroup.getChildAt(i3) == view) {
                            accessibilityNodeInfo3.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i, 1, false, ((MaterialButton) view).o));
                            break;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i3) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i3).getVisibility() != 8) {
                                i++;
                            }
                        }
                    }
                }
                i = -1;
                accessibilityNodeInfo3.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, i, 1, false, ((MaterialButton) view).o));
                break;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, l0.a);
                C4608zE c4608zE = (C4608zE) obj;
                l0.b(new F0(16, c4608zE.l.getVisibility() == 0 ? c4608zE.getString(R.string.mtrl_picker_toggle_to_year_selection) : c4608zE.getString(R.string.mtrl_picker_toggle_to_day_selection)));
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo4 = l0.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                accessibilityNodeInfo4.setCheckable(((NavigationMenuItemView) obj).x);
                break;
        }
    }

    @Override // defpackage.C4505y0
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.d) {
            case 0:
                if (i != 1048576) {
                    break;
                } else {
                    ((MT) ((AbstractC3920qa) this.e)).a(3);
                    break;
                }
        }
        return super.g(view, i, bundle);
    }
}
