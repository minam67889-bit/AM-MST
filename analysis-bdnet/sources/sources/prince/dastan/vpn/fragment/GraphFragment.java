package prince.dastan.vpn.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.LineChart;
import dastan.prince.bdfreevpn.R;
import defpackage.A50;
import defpackage.AbstractC2972ed;
import defpackage.C0807bV;
import defpackage.C0886cV;
import defpackage.C2882dV;
import defpackage.C3973rB;
import defpackage.C4273v20;
import defpackage.C4650zo;
import defpackage.G00;
import defpackage.LB;
import defpackage.N50;
import defpackage.PB;
import defpackage.RB;
import defpackage.S7;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GraphFragment extends Fragment {
    public LineChart a;
    public boolean b = false;
    public C0886cV c;
    public ArrayList d;
    public ArrayList e;
    public ArrayList f;
    public ArrayList g;

    public final void a() {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f;
        AbstractC2972ed abstractC2972ed = (PB) this.a.getData();
        toString();
        if (abstractC2972ed != null) {
            C0886cV c0886cV = this.c;
            synchronized (c0886cV) {
                c0886cV.a();
                ArrayList arrayList3 = c0886cV.f;
                arrayList = new ArrayList();
                for (int i = 0; i < arrayList3.size(); i++) {
                    arrayList.add(Long.valueOf(((C0807bV) arrayList3.get(i)).b));
                }
            }
            this.f = arrayList;
            C0886cV c0886cV2 = this.c;
            synchronized (c0886cV2) {
                c0886cV2.a();
                ArrayList arrayList4 = c0886cV2.f;
                arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < arrayList4.size(); i2++) {
                    arrayList2.add(Long.valueOf(((C0807bV) arrayList4.get(i2)).a));
                }
            }
            this.g = arrayList2;
            this.d = new ArrayList();
            this.e = new ArrayList();
            float f2 = 0.0f;
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                float longValue = ((Long) this.f.get(i3)).longValue() / 1024.0f;
                float longValue2 = ((Long) this.g.get(i3)).longValue() / 1024.0f;
                float f3 = i3;
                this.d.add(new C4650zo(f3, longValue));
                this.e.add(new C4650zo(f3, longValue2));
                if (f2 < longValue) {
                    f2 = longValue;
                }
                if (f2 < longValue2) {
                    f2 = longValue2;
                }
            }
            float f4 = 256.0f;
            if (f2 > 224.0f) {
                if (f2 > 256.0f) {
                    if (f2 <= 896.0f) {
                        f4 = 1024.0f;
                    } else {
                        f4 = 2048.0f;
                        f = (f2 >= 1024.0f && f2 >= 1792.0f) ? f2 < 3584.0f ? 4096.0f : f2 < 7168.0f ? 8192.0f : f2 < 14336.0f ? 16384.0f : 32768.0f : 512.0f;
                    }
                }
                f4 = f;
            }
            RB rb = new RB("Download", this.e);
            rb.z = 3;
            rb.E = 0.2f;
            rb.y = true;
            rb.j = false;
            rb.v = Color.parseColor("#FF0000");
            rb.w = 5000;
            rb.h(0.5f);
            rb.f(0.5f);
            rb.j = false;
            rb.g(Color.parseColor("#0000FF"));
            rb.e();
            rb.B = 0;
            rb.H = false;
            RB rb2 = new RB("Upload", this.d);
            rb2.z = 3;
            rb2.E = 0.2f;
            rb2.y = true;
            rb2.j = false;
            rb2.v = Color.parseColor("#0000FF");
            rb2.w = 5000;
            rb2.h(0.5f);
            rb2.f(0.5f);
            rb2.g(Color.parseColor("#FF0000"));
            rb2.e();
            rb2.B = 0;
            rb2.r = Color.rgb(0, 102, 0);
            rb2.j = false;
            rb2.H = false;
            toString();
            LB lb = new LB();
            lb.g = 0.0f;
            lb.h = 2.0f;
            lb.i = Color.rgb(237, 91, 91);
            lb.j = Paint.Style.FILL_AND_STROKE;
            lb.l = null;
            lb.m = 3;
            lb.g = f2;
            lb.k = "";
            lb.h = G00.c(1.0f);
            lb.l = new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
            lb.m = 1;
            lb.a();
            lb.f = Color.parseColor("#428EAE");
            lb.i = 0;
            Typeface typeface = Typeface.DEFAULT;
            lb.d = typeface;
            A50 xAxis = this.a.getXAxis();
            xAxis.x = 2;
            xAxis.n = true;
            xAxis.l = 2;
            xAxis.m = true;
            xAxis.a();
            xAxis.r = true;
            xAxis.u = 0.0f;
            xAxis.v = Math.abs(xAxis.t - 0.0f);
            xAxis.d = typeface;
            xAxis.f = Color.parseColor("#428EAE");
            xAxis.a = false;
            xAxis.o = new DashPathEffect(new float[]{5.0f, 5.0f}, 1.0f);
            N50 axisLeft = this.a.getAxisLeft();
            axisLeft.getClass();
            axisLeft.l = 2;
            axisLeft.m = true;
            axisLeft.s = true;
            axisLeft.t = f4;
            axisLeft.v = Math.abs(f4 - axisLeft.u);
            axisLeft.r = true;
            axisLeft.u = 0.0f;
            axisLeft.v = Math.abs(axisLeft.t - 0.0f);
            axisLeft.o = new DashPathEffect(new float[]{5.0f, 5.0f}, 1.0f);
            axisLeft.p.clear();
            ArrayList arrayList5 = axisLeft.p;
            arrayList5.add(lb);
            if (arrayList5.size() > 6) {
                Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
            }
            axisLeft.q = true;
            axisLeft.f = Color.parseColor("#428EAE");
            axisLeft.a();
            axisLeft.a = false;
            this.a.getAxisRight().a = true;
            N50 axisRight = this.a.getAxisRight();
            axisRight.getClass();
            axisRight.l = 10;
            axisRight.m = true;
            float f5 = f4 / 1024.0f;
            axisRight.s = true;
            axisRight.t = f5;
            axisRight.v = Math.abs(f5 - axisRight.u);
            axisRight.r = true;
            axisRight.u = 0.0f;
            axisRight.v = Math.abs(axisRight.t - 0.0f);
            axisRight.o = new DashPathEffect(new float[]{5.0f, 5.0f}, 1.0f);
            axisRight.n = false;
            axisRight.a();
            axisRight.f = Color.parseColor("#428EAE");
            abstractC2972ed.g(0);
            abstractC2972ed.g(1);
            ArrayList arrayList6 = abstractC2972ed.i;
            if (arrayList6 != null) {
                arrayList6.clear();
            }
            abstractC2972ed.a();
            abstractC2972ed.b(rb2);
            abstractC2972ed.i.add(rb2);
            abstractC2972ed.b(rb);
            abstractC2972ed.i.add(rb);
            abstractC2972ed.a();
            C3973rB legend = this.a.getLegend();
            legend.a();
            legend.d = Typeface.SERIF;
            legend.f = 0;
            legend.h = 1;
            legend.i = 3;
            legend.j = 1;
            legend.k = false;
            legend.a = false;
            this.a.getDescription().a = false;
            this.a.setData(abstractC2972ed);
            this.a.getViewPortHandler().e(5.0f);
            C4273v20 viewPortHandler = this.a.getViewPortHandler();
            viewPortHandler.f = 5.0f;
            viewPortHandler.c(viewPortHandler.a, viewPortHandler.b);
            this.a.d();
            this.a.invalidate();
        }
    }

    public final void b() {
        new DecimalFormat("#.##");
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        float f = 0.0f;
        for (int i = 0; i < this.f.size(); i++) {
            toString();
            float longValue = ((Long) this.f.get(i)).longValue() / 1024.0f;
            float longValue2 = ((Long) this.g.get(i)).longValue() / 1024.0f;
            float f2 = i;
            this.d.add(new C4650zo(f2, longValue));
            this.e.add(new C4650zo(f2, longValue2));
            if (f < longValue) {
                f = longValue;
            }
            if (f < longValue2) {
                f = longValue2;
            }
        }
        RB rb = new RB("Download", this.d);
        rb.h(0.0f);
        rb.f(0.0f);
        rb.j = false;
        rb.g(-16711936);
        rb.e();
        rb.B = 0;
        RB rb2 = new RB("Upload", this.e);
        rb2.h(0.0f);
        rb2.f(0.0f);
        rb2.j = false;
        rb2.g(-65536);
        rb2.e();
        rb2.B = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(rb2);
        arrayList.add(rb);
        toString();
        Color.rgb(237, 91, 91);
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        G00.c(1.0f);
        new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
        G00.c(6.0f);
        Typeface typeface = Typeface.DEFAULT;
        A50 xAxis = this.a.getXAxis();
        xAxis.x = 2;
        xAxis.h = -16711936;
        this.a.getAxisLeft().a = false;
        this.a.getAxisRight().a = false;
        LineChart lineChart = this.a;
        PB pb = new PB();
        pb.a = -3.4028235E38f;
        pb.b = Float.MAX_VALUE;
        pb.c = -3.4028235E38f;
        pb.d = Float.MAX_VALUE;
        pb.e = -3.4028235E38f;
        pb.f = Float.MAX_VALUE;
        pb.g = -3.4028235E38f;
        pb.h = Float.MAX_VALUE;
        pb.i = arrayList;
        pb.a();
        lineChart.setData(pb);
        this.a.setDrawGridBackground(true);
        this.a.setGridBackgroundColor(0);
        this.a.setTouchEnabled(false);
        this.a.getViewPortHandler().e(5.0f);
        C4273v20 viewPortHandler = this.a.getViewPortHandler();
        viewPortHandler.f = 5.0f;
        viewPortHandler.c(viewPortHandler.a, viewPortHandler.b);
        this.a.getDescription().a = false;
        this.a.getLegend().a = false;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.graph, viewGroup, false);
        this.a = (LineChart) inflate.findViewById(R.id.chart);
        this.c = C2882dV.y().x();
        try {
            b();
            this.b = true;
            new Thread(new S7(this, 13)).start();
        } catch (Exception unused) {
        }
        return inflate;
    }
}
