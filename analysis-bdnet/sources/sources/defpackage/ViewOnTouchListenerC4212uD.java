package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import dastan.prince.bdfreevpn.R;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.vpn.logger.LogItem;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: uD, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnTouchListenerC4212uD extends XM implements SkStatus.LogListener, Handler.Callback, View.OnTouchListener {
    public Vector d;
    public Vector e;
    public Handler f;
    public VPNClient g;
    public C0910cm h;
    public LinearLayoutManager i;
    public Vector j;
    public int k;
    public int l;

    @Override // defpackage.XM
    public final int a() {
        return this.e.size();
    }

    @Override // defpackage.XM
    public final long b(int i) {
        return this.e.get(i).hashCode();
    }

    @Override // defpackage.XM
    public final void c(AbstractC4143tN abstractC4143tN, int i) {
        String str;
        C4133tD c4133tD = (C4133tD) abstractC4143tN;
        VPNClient vPNClient = this.g;
        try {
            LogItem logItem = (LogItem) this.e.get(i);
            String string = logItem.getString(vPNClient);
            int i2 = this.k;
            String str2 = "";
            if (i2 != 0) {
                str = (i2 == 2 ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()) : i2 == 1 ? new SimpleDateFormat("HH:mm") : DateFormat.getTimeFormat(vPNClient)).format(new Date(logItem.getLogtime()));
            } else {
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            if (!str.isEmpty()) {
                str2 = "[" + str + "] ";
            }
            sb.append(str2);
            sb.append(string);
            String sb2 = sb.toString();
            c4133tD.u.setText(Html.fromHtml(sb2));
            ViewOnClickListenerC2840d viewOnClickListenerC2840d = new ViewOnClickListenerC2840d(this, i, sb2);
            TextView textView = c4133tD.u;
            textView.setOnClickListener(viewOnClickListenerC2840d);
            textView.setOnLongClickListener(new ViewOnLongClickListenerC4054sD(this, i, sb2));
        } catch (Exception e) {
            SkStatus.logException(e);
        }
    }

    @Override // defpackage.XM
    public final AbstractC4143tN d(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_log_drawer, viewGroup, false);
        inflate.setOnTouchListener(this);
        C4133tD c4133tD = new C4133tD(inflate);
        c4133tD.u = (TextView) inflate.findViewById(R.id.textLog);
        return c4133tD;
    }

    @Override // defpackage.XM
    public final void e(C3591mN c3591mN) {
        super.e(c3591mN);
        this.j.add(c3591mN);
    }

    @Override // defpackage.XM
    public final void f(C3591mN c3591mN) {
        super.f(c3591mN);
        this.j.remove(c3591mN);
    }

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
                ((C3591mN) it.next()).a();
            }
            LinearLayoutManager linearLayoutManager = this.i;
            linearLayoutManager.o0(linearLayoutManager.B() - 1);
            return true;
        }
        if (i == 1) {
            Iterator it2 = vector.iterator();
            while (it2.hasNext()) {
                ((C3591mN) it2.next()).a();
            }
            this.d.clear();
            Collections.addAll(this.d, SkStatus.getlogbuffer());
            g();
            return true;
        }
        if (i == 2) {
            Iterator it3 = vector.iterator();
            while (it3.hasNext()) {
                ((C3591mN) it3.next()).a();
            }
        } else if (i == 3) {
            g();
            Iterator it4 = vector.iterator();
            while (it4.hasNext()) {
                ((C3591mN) it4.next()).a();
            }
        }
        return true;
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.LogListener
    public final void newLog(LogItem logItem) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putParcelable("logmessage", logItem);
        obtain.setData(bundle);
        this.f.sendMessage(obtain);
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.LogListener
    public final void onClear() {
        this.f.sendEmptyMessage(1);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
