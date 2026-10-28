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
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3717o00;
import defpackage.C0618Xl;
import defpackage.C3900qG;
import defpackage.FE;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final boolean a;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AbstractC3717o00.c(null);
        if (FE.i(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(dastan.prince.bdfreevpn.R.id.cancel_button);
            setNextFocusRightId(dastan.prince.bdfreevpn.R.id.confirm_button);
        }
        this.a = FE.i(getContext(), dastan.prince.bdfreevpn.R.attr.nestedScrollable);
        AbstractC2925e20.m(this, new C0618Xl(3));
    }

    public final C3900qG a() {
        return (C3900qG) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (C3900qG) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((C3900qG) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C3900qG c3900qG = (C3900qG) super.getAdapter();
        c3900qG.getClass();
        int max = Math.max(c3900qG.a(), getFirstVisiblePosition());
        int min = Math.min(c3900qG.c(), getLastVisiblePosition());
        c3900qG.getItem(max);
        c3900qG.getItem(min);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((C3900qG) super.getAdapter()).c());
        } else if (i == 130) {
            setSelection(((C3900qG) super.getAdapter()).a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((C3900qG) super.getAdapter()).a() && selectedItemPosition <= ((C3900qG) super.getAdapter()).c())) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((C3900qG) super.getAdapter()).a());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.a) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((C3900qG) super.getAdapter()).a()) {
            super.setSelection(((C3900qG) super.getAdapter()).a());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (C3900qG) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C3900qG)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C3900qG.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
