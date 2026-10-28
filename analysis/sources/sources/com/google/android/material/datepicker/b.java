package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC4340sM;
import defpackage.H00;
import defpackage.T00;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b extends AbstractC4340sM {
    public final TextView u;
    public final MaterialCalendarGridView v;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public b(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.u = textView;
        WeakHashMap weakHashMap = T00.a;
        new H00(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 2).E(textView, Boolean.TRUE);
        this.v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
