package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import defpackage.BF;
import defpackage.C0495Sl;
import defpackage.OD;
import defpackage.RZ;
import defpackage.T00;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final boolean a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        RZ.d(null);
        if (OD.i(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(app.vpn.amtunnellite.R.id.cancel_button);
            setNextFocusRightId(app.vpn.amtunnellite.R.id.confirm_button);
        }
        this.a = OD.i(getContext(), app.vpn.amtunnellite.R.attr.nestedScrollable);
        T00.l(this, new C0495Sl(3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final BF a() {
        return (BF) super.getAdapter();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (BF) super.getAdapter();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((BF) super.getAdapter()).notifyDataSetChanged();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        BF bf = (BF) super.getAdapter();
        bf.getClass();
        int max = Math.max(bf.a(), getFirstVisiblePosition());
        int min = Math.min(bf.c(), getLastVisiblePosition());
        bf.getItem(max);
        bf.getItem(min);
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int a;
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            a = ((BF) super.getAdapter()).c();
        } else {
            if (i != 130) {
                super.onFocusChanged(true, i, rect);
                return;
            }
            a = ((BF) super.getAdapter()).a();
        }
        setSelection(a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((BF) super.getAdapter()).a() && selectedItemPosition <= ((BF) super.getAdapter()).c())) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((BF) super.getAdapter()).a());
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.a) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((BF) super.getAdapter()).a()) {
            i = ((BF) super.getAdapter()).a();
        }
        super.setSelection(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (BF) super.getAdapter();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof BF)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), BF.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
