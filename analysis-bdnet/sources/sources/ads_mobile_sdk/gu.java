package ads_mobile_sdk;

import ads_mobile_sdk.gu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3634my;
import defpackage.I20;
import defpackage.InterfaceC0470Rt;

/* loaded from: classes.dex */
public final class gu extends FrameLayout {
    public InterfaceC0470Rt a;
    public final ImageButton b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gu(Context context, String str, hu huVar) {
        super(context);
        Drawable drawable;
        AbstractC3634my.g(context, "context");
        AbstractC3634my.g(str, "closeButtonAsset");
        AbstractC3634my.g(huVar, "config");
        this.b = new ImageButton(context);
        Resources resources = context.getResources();
        Drawable drawable2 = null;
        if (!str.equals("white")) {
            drawable = str.equals("black") ? resources.getDrawable(R.drawable.admob_close_button_black_circle_white_cross, null) : drawable;
            if (drawable2 != null) {
                this.b.setImageResource(android.R.drawable.btn_dialog);
            } else {
                this.b.setImageDrawable(drawable2);
                this.b.setScaleType(ImageView.ScaleType.CENTER);
            }
            this.b.setBackgroundColor(0);
            this.b.setPadding(I20.b(context, huVar.a), I20.b(context, 0), I20.b(context, huVar.b), I20.b(context, huVar.c));
            this.b.setContentDescription("Fullscreen ad close button");
            final int i = 0;
            setOnClickListener(new View.OnClickListener(this) { // from class: F80
                public final /* synthetic */ gu b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            gu.a(this.b, view);
                            break;
                        default:
                            gu.b(this.b, view);
                            break;
                    }
                }
            });
            final int i2 = 1;
            this.b.setOnClickListener(new View.OnClickListener(this) { // from class: F80
                public final /* synthetic */ gu b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            gu.a(this.b, view);
                            break;
                        default:
                            gu.b(this.b, view);
                            break;
                    }
                }
            });
            addView(this.b, new FrameLayout.LayoutParams(I20.b(context, huVar.a + 50 + huVar.b), I20.b(context, huVar.c + 50)));
        }
        drawable = resources.getDrawable(R.drawable.admob_close_button_white_circle_black_cross, null);
        drawable2 = drawable;
        if (drawable2 != null) {
        }
        this.b.setBackgroundColor(0);
        this.b.setPadding(I20.b(context, huVar.a), I20.b(context, 0), I20.b(context, huVar.b), I20.b(context, huVar.c));
        this.b.setContentDescription("Fullscreen ad close button");
        final int i3 = 0;
        setOnClickListener(new View.OnClickListener(this) { // from class: F80
            public final /* synthetic */ gu b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        gu.a(this.b, view);
                        break;
                    default:
                        gu.b(this.b, view);
                        break;
                }
            }
        });
        final int i22 = 1;
        this.b.setOnClickListener(new View.OnClickListener(this) { // from class: F80
            public final /* synthetic */ gu b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i22) {
                    case 0:
                        gu.a(this.b, view);
                        break;
                    default:
                        gu.b(this.b, view);
                        break;
                }
            }
        });
        addView(this.b, new FrameLayout.LayoutParams(I20.b(context, huVar.a + 50 + huVar.b), I20.b(context, huVar.c + 50)));
    }

    public static final void a(gu guVar, View view) {
        AbstractC3634my.g(guVar, "this$0");
        InterfaceC0470Rt interfaceC0470Rt = guVar.a;
        if (interfaceC0470Rt != null) {
            interfaceC0470Rt.invoke();
        }
    }

    public static final void b(gu guVar, View view) {
        AbstractC3634my.g(guVar, "this$0");
        InterfaceC0470Rt interfaceC0470Rt = guVar.a;
        if (interfaceC0470Rt != null) {
            interfaceC0470Rt.invoke();
        }
    }
}
