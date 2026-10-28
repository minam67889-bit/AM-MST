package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: cc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0895cc extends AbstractC0878cN {
    public final Paint a;
    public final List b;

    public C0895cc() {
        Paint paint = new Paint();
        this.a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // defpackage.AbstractC0878cN
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        int E;
        int F;
        int i;
        int i2;
        Paint paint = this.a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((AbstractC4051sA) it.next()).getClass();
            ThreadLocal threadLocal = AbstractC0118Ee.a;
            float f = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).C0()) {
                C2891dc c2891dc = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (c2891dc.b) {
                    case 0:
                        i = 0;
                        break;
                    default:
                        i = c2891dc.c.G();
                        break;
                }
                float f2 = i;
                C2891dc c2891dc2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (c2891dc2.b) {
                    case 0:
                        i2 = c2891dc2.c.o;
                        break;
                    default:
                        CarouselLayoutManager carouselLayoutManager = c2891dc2.c;
                        i2 = carouselLayoutManager.o - carouselLayoutManager.D();
                        break;
                }
                canvas2 = canvas;
                canvas2.drawLine(0.0f, f2, 0.0f, i2, paint);
            } else {
                canvas2 = canvas;
                C2891dc c2891dc3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (c2891dc3.b) {
                    case 0:
                        E = c2891dc3.c.E();
                        break;
                    default:
                        E = 0;
                        break;
                }
                float f3 = E;
                C2891dc c2891dc4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q;
                switch (c2891dc4.b) {
                    case 0:
                        CarouselLayoutManager carouselLayoutManager2 = c2891dc4.c;
                        F = carouselLayoutManager2.n - carouselLayoutManager2.F();
                        break;
                    default:
                        F = c2891dc4.c.n;
                        break;
                }
                canvas2.drawLine(f3, 0.0f, F, 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
