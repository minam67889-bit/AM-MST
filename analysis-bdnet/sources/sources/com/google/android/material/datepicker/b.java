package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC4143tN;
import defpackage.S10;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b extends AbstractC4143tN {
    public final TextView u;
    public final MaterialCalendarGridView v;

    public b(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.u = textView;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        new S10(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(textView, Boolean.TRUE);
        this.v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
