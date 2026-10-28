package ads_mobile_sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3634my;

/* loaded from: classes.dex */
public final class v83 extends TextView {
    public static final /* synthetic */ int a = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v83(Context context) {
        super(context);
        CharSequence charSequence;
        AbstractC3634my.g(context, "context");
        try {
            charSequence = context.getResources().getString(R.string.test_ad);
        } catch (Resources.NotFoundException unused) {
            charSequence = "Test Ad";
        }
        setText(charSequence);
        setTextSize(15.0f);
        setTextColor(-1);
        setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        setBackground(gradientDrawable);
    }
}
