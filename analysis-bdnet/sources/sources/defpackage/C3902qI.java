package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.achartengine.ChartFactory;

/* renamed from: qI, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3902qI {
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public IconCompat h;
    public int i;
    public int j;
    public AbstractC3980rI l;
    public Bundle n;
    public String q;
    public final boolean r;
    public final Notification s;
    public final ArrayList t;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public boolean k = true;
    public boolean m = false;
    public int o = 0;
    public int p = 0;

    public C3902qI(Context context, String str) {
        Notification notification = new Notification();
        this.s = notification;
        this.a = context;
        this.q = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.j = 0;
        this.t = new ArrayList();
        this.r = true;
    }

    public static CharSequence b(String str) {
        return str == null ? str : str.length() > 5120 ? str.subSequence(0, 5120) : str;
    }

    public final Notification a() {
        Bundle bundle;
        int i;
        ArrayList arrayList;
        int i2;
        FR fr = new FR();
        fr.d = new Bundle();
        fr.c = this;
        Context context = this.a;
        fr.a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            fr.b = AbstractC4513y4.a(context, this.q);
        } else {
            fr.b = new Notification.Builder(this.a);
        }
        Notification notification = this.s;
        int i3 = 0;
        ((Notification.Builder) fr.b).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(this.e).setContentText(this.f).setContentInfo(null).setContentIntent(this.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & UserVerificationMethods.USER_VERIFY_PATTERN) != 0).setNumber(this.i).setProgress(0, 0, false);
        Notification.Builder builder = (Notification.Builder) fr.b;
        IconCompat iconCompat = this.h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.f(context));
        ((Notification.Builder) fr.b).setSubText(null).setUsesChronometer(false).setPriority(this.j);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            C3586mI c3586mI = (C3586mI) it.next();
            if (c3586mI.b == null && (i2 = c3586mI.e) != 0) {
                c3586mI.b = IconCompat.b(i2);
            }
            IconCompat iconCompat2 = c3586mI.b;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat2 != null ? iconCompat2.f(null) : null, c3586mI.f, c3586mI.g);
            Bundle bundle2 = c3586mI.a;
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle2) : new Bundle();
            boolean z = c3586mI.c;
            bundle3.putBoolean("android.support.allowGeneratedReplies", z);
            int i4 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z);
            bundle3.putInt("android.support.action.semanticAction", 0);
            if (i4 >= 28) {
                AbstractC0072Ck.p(builder2);
            }
            if (i4 >= 29) {
                AbstractC3728o6.g(builder2);
            }
            if (i4 >= 31) {
                AbstractC4059sI.a(builder2);
            }
            bundle3.putBoolean("android.support.action.showsUserInterface", c3586mI.d);
            builder2.addExtras(bundle3);
            ((Notification.Builder) fr.b).addAction(builder2.build());
        }
        Bundle bundle4 = this.n;
        if (bundle4 != null) {
            ((Bundle) fr.d).putAll(bundle4);
        }
        ((Notification.Builder) fr.b).setShowWhen(this.k);
        ((Notification.Builder) fr.b).setLocalOnly(this.m);
        ((Notification.Builder) fr.b).setGroup(null);
        ((Notification.Builder) fr.b).setSortKey(null);
        ((Notification.Builder) fr.b).setGroupSummary(false);
        ((Notification.Builder) fr.b).setCategory(null);
        ((Notification.Builder) fr.b).setColor(this.o);
        ((Notification.Builder) fr.b).setVisibility(this.p);
        ((Notification.Builder) fr.b).setPublicVersion(null);
        ((Notification.Builder) fr.b).setSound(notification.sound, notification.audioAttributes);
        int i5 = Build.VERSION.SDK_INT;
        ArrayList arrayList2 = this.t;
        ArrayList arrayList3 = this.c;
        if (i5 < 28) {
            if (arrayList3 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList3.size());
                Iterator it2 = arrayList3.iterator();
                if (it2.hasNext()) {
                    throw W50.f(it2);
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    F6 f6 = new F6(arrayList2.size() + arrayList.size());
                    f6.addAll(arrayList);
                    f6.addAll(arrayList2);
                    arrayList2 = new ArrayList(f6);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ((Notification.Builder) fr.b).addPerson((String) it3.next());
            }
        }
        ArrayList arrayList4 = this.d;
        if (arrayList4.size() > 0) {
            if (this.n == null) {
                this.n = new Bundle();
            }
            Bundle bundle5 = this.n.getBundle("android.car.EXTENSIONS");
            if (bundle5 == null) {
                bundle5 = new Bundle();
            }
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i6 = 0;
            while (i6 < arrayList4.size()) {
                String num = Integer.toString(i6);
                C3586mI c3586mI2 = (C3586mI) arrayList4.get(i6);
                Bundle bundle8 = new Bundle();
                if (c3586mI2.b == null && (i = c3586mI2.e) != 0) {
                    c3586mI2.b = IconCompat.b(i);
                }
                IconCompat iconCompat3 = c3586mI2.b;
                bundle8.putInt("icon", iconCompat3 != null ? iconCompat3.c() : i3);
                bundle8.putCharSequence(ChartFactory.TITLE, c3586mI2.f);
                bundle8.putParcelable("actionIntent", c3586mI2.g);
                Bundle bundle9 = c3586mI2.a;
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean("android.support.allowGeneratedReplies", c3586mI2.c);
                bundle8.putBundle("extras", bundle10);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", c3586mI2.d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(num, bundle8);
                i6++;
                i3 = 0;
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (this.n == null) {
                this.n = new Bundle();
            }
            this.n.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) fr.d).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i7 = Build.VERSION.SDK_INT;
        ((Notification.Builder) fr.b).setExtras(this.n);
        ((Notification.Builder) fr.b).setRemoteInputHistory(null);
        if (i7 >= 26) {
            AbstractC4513y4.i((Notification.Builder) fr.b);
            AbstractC4513y4.o((Notification.Builder) fr.b);
            AbstractC4513y4.p((Notification.Builder) fr.b);
            AbstractC4513y4.q((Notification.Builder) fr.b);
            AbstractC4513y4.k((Notification.Builder) fr.b);
            if (!TextUtils.isEmpty(this.q)) {
                ((Notification.Builder) fr.b).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                throw W50.f(it4);
            }
        }
        if (i7 >= 29) {
            AbstractC3728o6.e((Notification.Builder) fr.b, this.r);
            AbstractC3728o6.f((Notification.Builder) fr.b);
        }
        if (i7 >= 36) {
            J0.e((Notification.Builder) fr.b);
        }
        C3902qI c3902qI = (C3902qI) fr.c;
        AbstractC3980rI abstractC3980rI = c3902qI.l;
        if (abstractC3980rI != null) {
            abstractC3980rI.a(fr);
        }
        int i8 = Build.VERSION.SDK_INT;
        Notification.Builder builder3 = (Notification.Builder) fr.b;
        Notification build = i8 >= 26 ? builder3.build() : builder3.build();
        if (abstractC3980rI != null) {
            c3902qI.l.getClass();
        }
        if (abstractC3980rI != null && (bundle = build.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", abstractC3980rI.b());
        }
        return build;
    }

    public final void c(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.k;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.b = bitmap;
            iconCompat = iconCompat2;
        }
        this.h = iconCompat;
    }

    public final void d(AbstractC3980rI abstractC3980rI) {
        if (this.l != abstractC3980rI) {
            this.l = abstractC3980rI;
            if (((C3902qI) abstractC3980rI.a) != this) {
                abstractC3980rI.a = this;
                d(abstractC3980rI);
            }
        }
    }
}
