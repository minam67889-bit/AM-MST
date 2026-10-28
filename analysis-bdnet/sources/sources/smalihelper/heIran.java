package smalihelper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class heIran {
    private static AlertDialog alert;
    private static TextView but;
    private static TextView but1;
    private static LinearLayout button;
    private static LinearLayout dialog;
    private static TextView message;
    private static int showTime = 3;
    private static TextView title;

    private static SecretKey generateKey(String str) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return new SecretKeySpec(messageDigest.digest(), "AES");
    }

    public static String decrypt(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = (SecretKeySpec) generateKey(str2);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            return "";
        }
    }

    private static LinearLayout.LayoutParams param() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        return layoutParams;
    }

    private static void designTexts() {
        title.setPadding(5, 10, 0, 50);
        title.setGravity(17);
        title.setTextSize(18.0f);
        title.setTextColor(Color.parseColor("#FF5AFF00"));
        title.setLayoutParams(param());
        message.setLayoutParams(param());
        message.setGravity(17);
        message.setPadding(5, 10, 0, 50);
        message.setTextSize(16.0f);
        message.setTextColor(Color.parseColor("#FFF7FFEF"));
        but.setTextSize(13.0f);
        but.setPadding(20, 0, 30, 0);
        but.setLayoutParams(param());
        but.setGravity(3);
        but.setTextColor(Color.parseColor("#FFFF4000"));
        but1.setTextSize(13.0f);
        but1.setPadding(20, 0, 30, 0);
        but1.setTextColor(Color.parseColor("#FFF5FF00"));
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [smalihelper.heIran$1] */
    private static void designLayouts() {
        button.setLayoutParams(param());
        button.setPadding(0, 10, 0, 0);
        dialog.setPadding(50, 50, 50, 50);
        dialog.setElevation(0.0f);
        dialog.setOrientation(1);
        dialog.setBackgroundDrawable(new GradientDrawable() { // from class: smalihelper.heIran.1
            public GradientDrawable getIns(int i, String str) {
                setCornerRadius(i);
                setColor(Color.parseColor(str));
                return this;
            }
        }.getIns(0, "#FF000000"));
        dialog.setLayoutParams(param());
        alert.getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 20));
    }

    public static void get(final Context context) {
        if (context.getSharedPreferences("", 0).getInt("hUZDQljTR", 0) != showTime) {
            context.getSharedPreferences("", 0).edit().putInt("hUZDQljTR", context.getSharedPreferences("", 0).getInt("hUZDQljTR", 0) + 1).commit();
            alert = new AlertDialog.Builder(context).create();
            dialog = new LinearLayout(context);
            title = new TextView(context);
            message = new TextView(context);
            button = new LinearLayout(context);
            but = new TextView(context);
            but1 = new TextView(context);
            String decrypt = decrypt("UMJzYkbRE9oPcrax4HSi3A==", "VPN MARKET ");
            String decrypt2 = decrypt("zGdATvgUrFPi7qpd1t+yr5X79+APU7t2uyr/eDm/U0rpbTzU52jC3gymi+3zseTlHzmkh4cB0f/NTqUx1D7Zt+BN5XwNMMq22KSyJCxq1GuUcbGi5OZV0PMxmPiId3TAdgOECGc9NhBotdY94Q65wImp2DnGdmoSSTDZP8tABmjc7Oz87jbuPGq15BG0tWR70BZN29ooionIEKsjL1Qm30SaDrVmP39e4bt6Z+/XBhQxyutI24XYy8w5l6b35X/d", "کاربر گرامی، برای استفاده از این فیلترشکن و دریافت فیلترشکن های بیشتر در کانال تلگرامی ما عضو شوید");
            String decrypt3 = decrypt("enVS/V4HtS0+vZy0f+iZhg==", "الان نه");
            String decrypt4 = decrypt("MxNL2vkTArrBQu4saghUPYDVVQq2T+QR4Nez4n85HuSDa5bD+zoY2oQN6mVLwubx", "عضویت در کانال تلگرام");
            try {
                title.setTypeface(Typeface.createFromAsset(context.getAssets(), "title.ttf"), 1);
                message.setTypeface(Typeface.createFromAsset(context.getAssets(), "message.ttf"), 0);
                but.setTypeface(Typeface.createFromAsset(context.getAssets(), "button.ttf"), 0);
                but1.setTypeface(Typeface.createFromAsset(context.getAssets(), "button.ttf"), 0);
            } catch (Exception e) {
                title.setTypeface(Typeface.SANS_SERIF, 1);
                message.setTypeface(Typeface.SANS_SERIF, 0);
                but.setTypeface(Typeface.SANS_SERIF, 0);
                but1.setTypeface(Typeface.SANS_SERIF, 0);
            }
            designLayouts();
            designTexts();
            button.addView(but, 0);
            button.addView(but1, 1);
            dialog.addView(title, 0);
            dialog.addView(message, 1);
            dialog.addView(button, 2);
            alert.setView(dialog);
            but1.setOnClickListener(new View.OnClickListener() { // from class: smalihelper.heIran.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    heIran.alert.dismiss();
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(heIran.decrypt("QPJt8X4OTUsx8rb2SYdU7oKCpzqXj3dRBvWYVjCey28=", "https://t.me/anty_filter"))));
                }
            });
            but.setOnClickListener(new View.OnClickListener() { // from class: smalihelper.heIran.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    heIran.alert.dismiss();
                }
            });
            title.setText(decrypt);
            message.setText(decrypt2);
            but.setText(decrypt3);
            but1.setText(decrypt4);
            alert.show();
        }
    }
}
