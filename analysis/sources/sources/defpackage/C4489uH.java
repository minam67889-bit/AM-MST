package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import app.vpn.amtunnellite.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Iterator;
import org.achartengine.ChartFactory;

/* renamed from: uH, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4489uH {
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public IconCompat h;
    public int i;
    public int j;
    public AbstractC4566vH l;
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4489uH(Context context, String str) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence b(String str) {
        if (str == null) {
            return str;
        }
        if (str.length() > 5120) {
            return str.subSequence(0, 5120);
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Notification a() {
        Notification.Builder builder;
        boolean z;
        boolean z2;
        boolean z3;
        Icon f;
        Bundle bundle;
        int i;
        Bundle bundle2;
        int i2;
        ArrayList arrayList;
        Icon icon;
        Bundle bundle3;
        int i3;
        RW rw = new RW();
        new ArrayList();
        rw.d = new Bundle();
        rw.c = this;
        Context context = this.a;
        rw.a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            builder = AbstractC3855m4.a(context, this.q);
        } else {
            builder = new Notification.Builder(this.a);
        }
        rw.b = builder;
        Notification notification = this.s;
        Notification.Builder lights = ((Notification.Builder) rw.b).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        int i4 = 0;
        boolean z4 = true;
        if ((notification.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z);
        if ((notification.flags & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z2);
        if ((notification.flags & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z3).setDefaults(notification.defaults).setContentTitle(this.e).setContentText(this.f).setContentInfo(null).setContentIntent(this.g).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & UserVerificationMethods.USER_VERIFY_PATTERN) == 0) {
            z4 = false;
        }
        deleteIntent.setFullScreenIntent(null, z4).setNumber(this.i).setProgress(0, 0, false);
        Notification.Builder builder2 = (Notification.Builder) rw.b;
        IconCompat iconCompat = this.h;
        if (iconCompat == null) {
            f = null;
        } else {
            f = iconCompat.f(context);
        }
        builder2.setLargeIcon(f);
        ((Notification.Builder) rw.b).setSubText(null).setUsesChronometer(false).setPriority(this.j);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            C4028oH c4028oH = (C4028oH) it.next();
            int i5 = Build.VERSION.SDK_INT;
            if (c4028oH.b == null && (i3 = c4028oH.e) != 0) {
                c4028oH.b = IconCompat.b(i3);
            }
            IconCompat iconCompat2 = c4028oH.b;
            if (iconCompat2 != null) {
                icon = iconCompat2.f(null);
            } else {
                icon = null;
            }
            Notification.Action.Builder builder3 = new Notification.Action.Builder(icon, c4028oH.f, c4028oH.g);
            Bundle bundle4 = c4028oH.a;
            if (bundle4 != null) {
                bundle3 = new Bundle(bundle4);
            } else {
                bundle3 = new Bundle();
            }
            boolean z5 = c4028oH.c;
            bundle3.putBoolean("android.support.allowGeneratedReplies", z5);
            builder3.setAllowGeneratedReplies(z5);
            bundle3.putInt("android.support.action.semanticAction", 0);
            if (i5 >= 28) {
                AbstractC4753xk.p(builder3);
            }
            if (i5 >= 29) {
                W5.g(builder3);
            }
            if (i5 >= 31) {
                AbstractC4643wH.a(builder3);
            }
            bundle3.putBoolean("android.support.action.showsUserInterface", c4028oH.d);
            builder3.addExtras(bundle3);
            ((Notification.Builder) rw.b).addAction(builder3.build());
        }
        Bundle bundle5 = this.n;
        if (bundle5 != null) {
            ((Bundle) rw.d).putAll(bundle5);
        }
        int i6 = Build.VERSION.SDK_INT;
        ((Notification.Builder) rw.b).setShowWhen(this.k);
        ((Notification.Builder) rw.b).setLocalOnly(this.m);
        ((Notification.Builder) rw.b).setGroup(null);
        ((Notification.Builder) rw.b).setSortKey(null);
        ((Notification.Builder) rw.b).setGroupSummary(false);
        ((Notification.Builder) rw.b).setCategory(null);
        ((Notification.Builder) rw.b).setColor(this.o);
        ((Notification.Builder) rw.b).setVisibility(this.p);
        ((Notification.Builder) rw.b).setPublicVersion(null);
        ((Notification.Builder) rw.b).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList2 = this.t;
        ArrayList arrayList3 = this.c;
        if (i6 < 28) {
            if (arrayList3 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList3.size());
                Iterator it2 = arrayList3.iterator();
                if (it2.hasNext()) {
                    AbstractC4575vQ.B(it2.next());
                    throw null;
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    C3936n6 c3936n6 = new C3936n6(arrayList2.size() + arrayList.size());
                    c3936n6.addAll(arrayList);
                    c3936n6.addAll(arrayList2);
                    arrayList2 = new ArrayList(c3936n6);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ((Notification.Builder) rw.b).addPerson((String) it3.next());
            }
        }
        ArrayList arrayList4 = this.d;
        if (arrayList4.size() > 0) {
            if (this.n == null) {
                this.n = new Bundle();
            }
            Bundle bundle6 = this.n.getBundle("android.car.EXTENSIONS");
            if (bundle6 == null) {
                bundle6 = new Bundle();
            }
            Bundle bundle7 = new Bundle(bundle6);
            Bundle bundle8 = new Bundle();
            int i7 = 0;
            while (i7 < arrayList4.size()) {
                String num = Integer.toString(i7);
                C4028oH c4028oH2 = (C4028oH) arrayList4.get(i7);
                Bundle bundle9 = new Bundle();
                if (c4028oH2.b == null && (i2 = c4028oH2.e) != 0) {
                    c4028oH2.b = IconCompat.b(i2);
                }
                IconCompat iconCompat3 = c4028oH2.b;
                if (iconCompat3 != null) {
                    i = iconCompat3.c();
                } else {
                    i = i4;
                }
                bundle9.putInt("icon", i);
                bundle9.putCharSequence(ChartFactory.TITLE, c4028oH2.f);
                bundle9.putParcelable("actionIntent", c4028oH2.g);
                Bundle bundle10 = c4028oH2.a;
                if (bundle10 != null) {
                    bundle2 = new Bundle(bundle10);
                } else {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("android.support.allowGeneratedReplies", c4028oH2.c);
                bundle9.putBundle("extras", bundle2);
                bundle9.putParcelableArray("remoteInputs", null);
                bundle9.putBoolean("showsUserInterface", c4028oH2.d);
                bundle9.putInt("semanticAction", 0);
                bundle8.putBundle(num, bundle9);
                i7++;
                i4 = 0;
            }
            bundle6.putBundle("invisible_actions", bundle8);
            bundle7.putBundle("invisible_actions", bundle8);
            if (this.n == null) {
                this.n = new Bundle();
            }
            this.n.putBundle("android.car.EXTENSIONS", bundle6);
            ((Bundle) rw.d).putBundle("android.car.EXTENSIONS", bundle7);
        }
        int i8 = Build.VERSION.SDK_INT;
        ((Notification.Builder) rw.b).setExtras(this.n);
        ((Notification.Builder) rw.b).setRemoteInputHistory(null);
        if (i8 >= 26) {
            AbstractC3855m4.i((Notification.Builder) rw.b);
            AbstractC3855m4.o((Notification.Builder) rw.b);
            AbstractC3855m4.p((Notification.Builder) rw.b);
            AbstractC3855m4.q((Notification.Builder) rw.b);
            AbstractC3855m4.k((Notification.Builder) rw.b);
            if (!TextUtils.isEmpty(this.q)) {
                ((Notification.Builder) rw.b).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i8 >= 28) {
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                AbstractC4575vQ.B(it4.next());
                throw null;
            }
        }
        if (i8 >= 29) {
            W5.e((Notification.Builder) rw.b, this.r);
            W5.f((Notification.Builder) rw.b);
        }
        C4489uH c4489uH = (C4489uH) rw.c;
        AbstractC4566vH abstractC4566vH = c4489uH.l;
        if (abstractC4566vH != null) {
            abstractC4566vH.b(rw);
        }
        int i9 = Build.VERSION.SDK_INT;
        Notification build = ((Notification.Builder) rw.b).build();
        if (abstractC4566vH != null) {
            c4489uH.l.getClass();
        }
        if (abstractC4566vH != null && (bundle = build.extras) != null) {
            abstractC4566vH.a(bundle);
        }
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(AbstractC4566vH abstractC4566vH) {
        if (this.l != abstractC4566vH) {
            this.l = abstractC4566vH;
            if (((C4489uH) abstractC4566vH.a) != this) {
                abstractC4566vH.a = this;
                d(abstractC4566vH);
            }
        }
    }
}
