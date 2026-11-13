package ads_mobile_sdk;

import ads_mobile_sdk.dy;
import ads_mobile_sdk.ov;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC4311s10;
import defpackage.AbstractC4766xx;

/* loaded from: classes.dex */
public final class dy extends FrameLayout {
    public ov a;
    public final ImageButton b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public dy(Context context, String str, ey eyVar) {
        super(context);
        Drawable drawable;
        AbstractC4766xx.p(context, "context");
        AbstractC4766xx.p(str, "closeButtonAsset");
        this.b = new ImageButton(context);
        Resources resources = context.getResources();
        Drawable drawable2 = null;
        if (!AbstractC4766xx.d(str, "white")) {
            drawable = AbstractC4766xx.d(str, "black") ? resources.getDrawable(R.drawable.admob_close_button_black_circle_white_cross, null) : drawable;
            ImageButton imageButton = this.b;
            if (drawable2 != null) {
                imageButton.setImageResource(android.R.drawable.btn_dialog);
            } else {
                imageButton.setImageDrawable(drawable2);
                this.b.setScaleType(ImageView.ScaleType.CENTER);
            }
            this.b.setBackgroundColor(0);
            ImageButton imageButton2 = this.b;
            int i = eyVar.a;
            int b = AbstractC4311s10.b(context, i);
            int b2 = AbstractC4311s10.b(context, 0);
            int i2 = eyVar.b;
            int b3 = AbstractC4311s10.b(context, i2);
            int i3 = eyVar.c;
            imageButton2.setPadding(b, b2, b3, AbstractC4311s10.b(context, i3));
            this.b.setContentDescription("Fullscreen ad close button");
            final int i4 = 0;
            setOnClickListener(new View.OnClickListener(this) { // from class: b60
                public final /* synthetic */ dy b;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.b = this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            dy dyVar = this.b;
                            AbstractC4766xx.p(dyVar, "this$0");
                            ov ovVar = dyVar.a;
                            if (ovVar != null) {
                                ovVar.invoke();
                                break;
                            }
                            break;
                        default:
                            dy dyVar2 = this.b;
                            AbstractC4766xx.p(dyVar2, "this$0");
                            ov ovVar2 = dyVar2.a;
                            if (ovVar2 != null) {
                                ovVar2.invoke();
                                break;
                            }
                            break;
                    }
                }
            });
            final int i5 = 1;
            this.b.setOnClickListener(new View.OnClickListener(this) { // from class: b60
                public final /* synthetic */ dy b;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.b = this;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            dy dyVar = this.b;
                            AbstractC4766xx.p(dyVar, "this$0");
                            ov ovVar = dyVar.a;
                            if (ovVar != null) {
                                ovVar.invoke();
                                break;
                            }
                            break;
                        default:
                            dy dyVar2 = this.b;
                            AbstractC4766xx.p(dyVar2, "this$0");
                            ov ovVar2 = dyVar2.a;
                            if (ovVar2 != null) {
                                ovVar2.invoke();
                                break;
                            }
                            break;
                    }
                }
            });
            addView(this.b, new FrameLayout.LayoutParams(AbstractC4311s10.b(context, i + 50 + i2), AbstractC4311s10.b(context, i3 + 50)));
        }
        drawable = resources.getDrawable(R.drawable.admob_close_button_white_circle_black_cross, null);
        drawable2 = drawable;
        ImageButton imageButton3 = this.b;
        if (drawable2 != null) {
        }
        this.b.setBackgroundColor(0);
        ImageButton imageButton22 = this.b;
        int i6 = eyVar.a;
        int b4 = AbstractC4311s10.b(context, i6);
        int b22 = AbstractC4311s10.b(context, 0);
        int i22 = eyVar.b;
        int b32 = AbstractC4311s10.b(context, i22);
        int i32 = eyVar.c;
        imageButton22.setPadding(b4, b22, b32, AbstractC4311s10.b(context, i32));
        this.b.setContentDescription("Fullscreen ad close button");
        final int i42 = 0;
        setOnClickListener(new View.OnClickListener(this) { // from class: b60
            public final /* synthetic */ dy b;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.b = this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i42) {
                    case 0:
                        dy dyVar = this.b;
                        AbstractC4766xx.p(dyVar, "this$0");
                        ov ovVar = dyVar.a;
                        if (ovVar != null) {
                            ovVar.invoke();
                            break;
                        }
                        break;
                    default:
                        dy dyVar2 = this.b;
                        AbstractC4766xx.p(dyVar2, "this$0");
                        ov ovVar2 = dyVar2.a;
                        if (ovVar2 != null) {
                            ovVar2.invoke();
                            break;
                        }
                        break;
                }
            }
        });
        final int i52 = 1;
        this.b.setOnClickListener(new View.OnClickListener(this) { // from class: b60
            public final /* synthetic */ dy b;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.b = this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i52) {
                    case 0:
                        dy dyVar = this.b;
                        AbstractC4766xx.p(dyVar, "this$0");
                        ov ovVar = dyVar.a;
                        if (ovVar != null) {
                            ovVar.invoke();
                            break;
                        }
                        break;
                    default:
                        dy dyVar2 = this.b;
                        AbstractC4766xx.p(dyVar2, "this$0");
                        ov ovVar2 = dyVar2.a;
                        if (ovVar2 != null) {
                            ovVar2.invoke();
                            break;
                        }
                        break;
                }
            }
        });
        addView(this.b, new FrameLayout.LayoutParams(AbstractC4311s10.b(context, i6 + 50 + i22), AbstractC4311s10.b(context, i32 + 50)));
    }
}
