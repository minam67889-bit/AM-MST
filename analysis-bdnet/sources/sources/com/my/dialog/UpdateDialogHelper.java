package com.my.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;
import org.achartengine.renderer.DefaultRenderer;

/* loaded from: classes.dex */
public class UpdateDialogHelper {
    public static void fetchUpdateInfoAndShowDialog(Context context) {
        new FetchUpdateTask(context).execute("https://raw.githubusercontent.com/vpnmarket/dialog15/refs/heads/main/BD%20106");
    }

    public static void showUpdateDialog(final Context context, final UpdateInfo updateInfo) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, 0, 0, 24);
        linearLayout.setGravity(1);
        linearLayout.setBackgroundColor(-1);
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, 200));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            imageView.setImageBitmap(BitmapFactory.decodeStream(context.getAssets().open("image.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(4, DefaultRenderer.BACKGROUND_COLOR);
        imageView.setBackground(gradientDrawable);
        linearLayout.addView(imageView);
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), "font.ttf");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize(20.0f);
        textView.setTypeface(createFromAsset, 1);
        textView.setTextColor(DefaultRenderer.BACKGROUND_COLOR);
        textView.setGravity(17);
        textView.setText(updateInfo.getTitle());
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setPadding(15, 15, 15, 15);
        textView2.setTypeface(createFromAsset);
        textView2.setTextColor(DefaultRenderer.BACKGROUND_COLOR);
        textView2.setGravity(17);
        textView2.setText(updateInfo.getDescription());
        linearLayout.addView(textView2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(15, 15, 15, 15);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 40, 0, 15);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setGravity(17);
        TextView textView3 = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(200, 100);
        layoutParams2.setMargins(0, 0, 60, 0);
        textView3.setLayoutParams(layoutParams2);
        textView3.setTypeface(createFromAsset);
        textView3.setTextColor(-1);
        textView3.setGravity(17);
        textView3.setPadding(10, 10, 10, 10);
        textView3.setText("پیوستن");
        textView3.setMinHeight(50);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#008000"));
        gradientDrawable2.setCornerRadius(50.0f);
        gradientDrawable2.setStroke(2, DefaultRenderer.BACKGROUND_COLOR);
        textView3.setBackground(gradientDrawable2);
        linearLayout2.addView(textView3);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(-1);
        gradientDrawable3.setCornerRadius(50.0f);
        linearLayout.setBackground(gradientDrawable3);
        final AlertDialog create = new AlertDialog.Builder(context).setView(linearLayout).setCancelable(false).create();
        create.getWindow().setBackgroundDrawable(gradientDrawable3);
        create.getWindow().setDimAmount(0.5f);
        if ("yes".equals(updateInfo.getButtonno())) {
            TextView textView4 = new TextView(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(200, 100);
            textView4.setLayoutParams(layoutParams3);
            textView4.setTypeface(createFromAsset);
            textView4.setTextColor(-1);
            textView4.setGravity(17);
            textView4.setPadding(10, 10, 10, 10);
            layoutParams3.setMargins(60, 0, 0, 0);
            textView4.setText("بستن");
            textView4.setMinHeight(50);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setColor(Color.parseColor("#FF0000"));
            gradientDrawable4.setCornerRadius(50.0f);
            gradientDrawable4.setStroke(2, DefaultRenderer.BACKGROUND_COLOR);
            textView4.setBackground(gradientDrawable4);
            linearLayout2.addView(textView4);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.my.dialog.UpdateDialogHelper.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
        }
        linearLayout.addView(linearLayout2);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.my.dialog.UpdateDialogHelper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UpdateInfo.this.getDownload())));
                create.dismiss();
            }
        });
        create.show();
    }
}
