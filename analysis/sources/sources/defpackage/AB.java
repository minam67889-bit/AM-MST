package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import app.vpn.amtunnellite.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AB extends BaseAdapter {
    public int a = -1;
    public final /* synthetic */ BB b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AB(BB bb) {
        this.b = bb;
        a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a() {
        MenuC3948nE menuC3948nE = this.b.c;
        C4563vE c4563vE = menuC3948nE.v;
        if (c4563vE != null) {
            menuC3948nE.i();
            ArrayList arrayList = menuC3948nE.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((C4563vE) arrayList.get(i)) == c4563vE) {
                    this.a = i;
                    return;
                }
            }
        }
        this.a = -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C4563vE getItem(int i) {
        BB bb = this.b;
        MenuC3948nE menuC3948nE = bb.c;
        menuC3948nE.i();
        ArrayList arrayList = menuC3948nE.j;
        bb.getClass();
        int i2 = this.a;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (C4563vE) arrayList.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final int getCount() {
        BB bb = this.b;
        MenuC3948nE menuC3948nE = bb.c;
        menuC3948nE.i();
        int size = menuC3948nE.j.size();
        bb.getClass();
        if (this.a < 0) {
            return size;
        }
        return size - 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((KE) view).c(getItem(i));
        return view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
