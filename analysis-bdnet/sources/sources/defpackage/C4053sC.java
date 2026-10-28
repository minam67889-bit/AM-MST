package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;

/* renamed from: sC, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4053sC extends BaseAdapter {
    public int a = -1;
    public final /* synthetic */ C4132tC b;

    public C4053sC(C4132tC c4132tC) {
        this.b = c4132tC;
        a();
    }

    public final void a() {
        MenuC2945eF menuC2945eF = this.b.c;
        C3503lF c3503lF = menuC2945eF.v;
        if (c3503lF != null) {
            menuC2945eF.i();
            ArrayList arrayList = menuC2945eF.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((C3503lF) arrayList.get(i)) == c3503lF) {
                    this.a = i;
                    return;
                }
            }
        }
        this.a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C3503lF getItem(int i) {
        C4132tC c4132tC = this.b;
        MenuC2945eF menuC2945eF = c4132tC.c;
        menuC2945eF.i();
        ArrayList arrayList = menuC2945eF.j;
        c4132tC.getClass();
        int i2 = this.a;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (C3503lF) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        C4132tC c4132tC = this.b;
        MenuC2945eF menuC2945eF = c4132tC.c;
        menuC2945eF.i();
        int size = menuC2945eF.j.size();
        c4132tC.getClass();
        return this.a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((AF) view).c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
