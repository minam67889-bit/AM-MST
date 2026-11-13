package defpackage;

import android.view.MotionEvent;
import android.view.View;
import app.vpn.amtunnellite.R;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

/* loaded from: classes.dex */
public final class LP implements View.OnTouchListener {
    public float a = 0.0f;
    public float b = 0.0f;
    public final int c;
    public final /* synthetic */ ScrollableNumberPicker d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LP(ScrollableNumberPicker scrollableNumberPicker) {
        this.d = scrollableNumberPicker;
        this.c = scrollableNumberPicker.getResources().getDimensionPixelSize(R.dimen.default_scroll_offset);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if ((r3 * (-1)) > r7) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if ((r3 * (-1)) > r7) goto L14;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float abs;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            ScrollableNumberPicker scrollableNumberPicker = this.d;
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                int i = scrollableNumberPicker.o;
                int i2 = this.c;
                if (i == 0) {
                    float f = x - this.a;
                    if (f <= i2) {
                    }
                    ScrollableNumberPicker.a(scrollableNumberPicker);
                } else {
                    float f2 = y - this.b;
                    if (f2 <= i2) {
                    }
                    ScrollableNumberPicker.c(scrollableNumberPicker);
                }
            } else {
                int dimensionPixelSize = scrollableNumberPicker.getResources().getDimensionPixelSize(R.dimen.default_scroll_repeat_length);
                if (scrollableNumberPicker.o == 0) {
                    float f3 = x - this.a;
                    if (f3 > 0.0f) {
                        scrollableNumberPicker.z = true;
                    } else {
                        scrollableNumberPicker.A = true;
                    }
                    abs = Math.abs(f3);
                } else {
                    float f4 = y - this.b;
                    if (f4 > 0.0f) {
                        scrollableNumberPicker.A = true;
                    } else {
                        scrollableNumberPicker.z = true;
                    }
                    abs = Math.abs(f4);
                }
                scrollableNumberPicker.B.post(new PP(scrollableNumberPicker, (int) (abs / dimensionPixelSize), scrollableNumberPicker.m));
            }
            return true;
        }
        this.a = x;
        this.b = y;
        return true;
    }
}
