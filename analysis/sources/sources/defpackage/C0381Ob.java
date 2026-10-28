package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import app.vpn.amtunnellite.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: Ob, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0381Ob extends AbstractC0725aM {
    public final Paint a;
    public final List b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C0381Ob() {
        Paint paint = new Paint();
        this.a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC0725aM
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        float b;
        float c;
        float f;
        Canvas canvas2;
        float f2;
        Paint paint = this.a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (AbstractC0146Ez abstractC0146Ez : this.b) {
            abstractC0146Ez.getClass();
            ThreadLocal threadLocal = AbstractC4132pe.a;
            float f3 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f3)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f3)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f3)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f3))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).G0()) {
                f2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.e();
                f = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.a();
                c = 0.0f;
                abstractC0146Ez.getClass();
                canvas2 = canvas;
                b = 0.0f;
            } else {
                b = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.b();
                c = ((CarouselLayoutManager) recyclerView.getLayoutManager()).q.c();
                f = 0.0f;
                abstractC0146Ez.getClass();
                canvas2 = canvas;
                f2 = 0.0f;
            }
            canvas2.drawLine(b, f2, c, f, paint);
        }
    }
}
