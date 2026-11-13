package prince.udp.vpn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import defpackage.C3551i5;

/* loaded from: classes2.dex */
public class TunnelRadioButton extends C3551i5 {
    public final Paint e;
    public Drawable f;
    public String g;
    public final int h;
    public final int i;
    public final int j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        float f = getResources().getDisplayMetrics().density;
        float f2 = f * 18.0f;
        float f3 = isChecked() ? f * 2.0f : 1.0f * f;
        Paint paint = this.e;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        if (isChecked()) {
            paint.setColor(Color.rgb(255, 248, 252));
        } else {
            paint.setColor(-1);
        }
        canvas.drawRoundRect(f3, f3, width - f3, height - f3, f2, f2, paint);
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint.setStrokeWidth(f3);
        boolean isChecked = isChecked();
        int i = this.h;
        if (isChecked) {
            paint.setColor(i);
        } else {
            paint.setColor(this.j);
        }
        float f4 = f3 / 2.0f;
        canvas.drawRoundRect(f4, f4, width - f4, height - f4, f2, f2, paint);
        paint.setStyle(style);
        Drawable drawable = this.f;
        if (drawable != null) {
            int i2 = (int) (42.0f * f);
            int i3 = (int) ((width - i2) / 2.0f);
            int i4 = (int) (12.0f * f);
            drawable.setBounds(i3, i4, i3 + i2, i2 + i4);
            this.f.draw(canvas);
        }
        paint.setColor(this.i);
        paint.setTextSize(14.0f * f);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextAlign(Paint.Align.CENTER);
        float f5 = width / 2.0f;
        canvas.drawText(this.g, f5, 72.0f * f, paint);
        float f6 = 10.0f * f;
        float f7 = height - f2;
        paint.setStyle(style);
        paint.setColor(-1);
        canvas.drawCircle(f5, f7, f6, paint);
        paint.setStyle(style2);
        paint.setStrokeWidth((isChecked() ? 3 : 2) * f);
        paint.setColor(isChecked() ? i : Color.rgb(110, 110, 110));
        canvas.drawCircle(f5, f7, f6, paint);
        if (isChecked()) {
            paint.setStyle(style);
            paint.setColor(i);
            canvas.drawCircle(f5, f7, f * 5.0f, paint);
        }
        paint.setStyle(style);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitle(String str) {
        this.g = str;
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TunnelRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.e = paint;
        this.g = "";
        this.h = Color.rgb(236, 0, 140);
        this.i = Color.rgb(7, 20, 61);
        this.j = Color.rgb(220, 220, 220);
        setButtonDrawable((Drawable) null);
        setText((CharSequence) null);
        setClickable(true);
        setFocusable(true);
        paint.setAntiAlias(true);
        setPadding(0, 0, 0, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIcon(int i) {
        this.f = getContext().getDrawable(i);
        invalidate();
    }
}
