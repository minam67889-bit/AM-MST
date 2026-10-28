package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.vpn.amtunnellite.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import prince.udp.vpn.service.vpn.logger.LogItem;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class DC extends VL implements SkStatus.LogListener, Handler.Callback, View.OnTouchListener {
    public Vector d;
    public Vector e;
    public Handler f;
    public Context g;
    public BC h;
    public LinearLayoutManager i;
    public Vector j;
    public int k;
    public int l;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final int a() {
        return this.e.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final long b(int i) {
        return this.e.get(i).hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final void c(AbstractC4340sM abstractC4340sM, int i) {
        String str;
        DateFormat timeFormat;
        CC cc = (CC) abstractC4340sM;
        Context context = this.g;
        try {
            LogItem logItem = (LogItem) this.e.get(i);
            String string = logItem.getString(context);
            int i2 = this.k;
            String str2 = "";
            if (i2 == 0) {
                str = "";
            } else {
                Date date = new Date(logItem.getLogtime());
                if (i2 == 2) {
                    timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                } else if (i2 == 1) {
                    timeFormat = new SimpleDateFormat("HH:mm");
                } else {
                    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
                }
                str = timeFormat.format(date);
            }
            StringBuilder sb = new StringBuilder();
            if (!str.isEmpty()) {
                str2 = "[" + str + "] ";
            }
            sb.append(str2);
            sb.append(string);
            String sb2 = sb.toString();
            cc.u.setText(Html.fromHtml(sb2));
            T0 t0 = new T0(this, i, sb2);
            TextView textView = cc.u;
            textView.setOnClickListener(t0);
            textView.setOnLongClickListener(new AC(this, i, sb2));
        } catch (Exception e) {
            SkStatus.logException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final AbstractC4340sM d(RecyclerView recyclerView) {
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.list_item_log_drawer, (ViewGroup) recyclerView, false);
        inflate.setOnTouchListener(this);
        CC cc = new CC(inflate);
        cc.u = (TextView) inflate.findViewById(R.id.textLog);
        return cc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final void e(C3802lM c3802lM) {
        super.e(c3802lM);
        this.j.add(c3802lM);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final void f(C3802lM c3802lM) {
        super.f(c3802lM);
        this.j.remove(c3802lM);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g() {
        Vector vector = this.e;
        vector.clear();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            LogItem logItem = (LogItem) it.next();
            if (logItem.getLogLevel().getInt() <= this.l) {
                vector.add(logItem);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        Vector vector = this.j;
        if (i == 0) {
            LogItem logItem = (LogItem) message.getData().getParcelable("logmessage");
            this.d.add(logItem);
            if (this.d.size() > 1000) {
                Vector vector2 = this.d;
                this.d = new Vector(this.d.size());
                for (int i2 = 50; i2 < vector2.size(); i2++) {
                    this.d.add((LogItem) vector2.elementAt(i2));
                }
                g();
            } else if (logItem.getLogLevel().getInt() <= this.l) {
                this.e.add(logItem);
            }
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                ((C3802lM) it.next()).a();
            }
            LinearLayoutManager linearLayoutManager = this.i;
            linearLayoutManager.p0(linearLayoutManager.B() - 1);
        } else if (i == 1) {
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((C3802lM) it2.next()).a();
            }
            this.d.clear();
            Collections.addAll(this.d, SkStatus.getlogbuffer());
            g();
        } else if (i == 2) {
            Iterator it3 = vector.iterator();
            while (it3.hasNext()) {
                ((C3802lM) it3.next()).a();
            }
        } else if (i == 3) {
            g();
            Iterator it4 = vector.iterator();
            while (it4.hasNext()) {
                ((C3802lM) it4.next()).a();
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.logger.SkStatus.LogListener
    public final void newLog(LogItem logItem) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putParcelable("logmessage", logItem);
        obtain.setData(bundle);
        this.f.sendMessage(obtain);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.logger.SkStatus.LogListener
    public final void onClear() {
        this.f.sendEmptyMessage(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
