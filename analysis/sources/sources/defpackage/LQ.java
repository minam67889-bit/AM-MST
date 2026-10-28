package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.ads.mobile.sdk.banner.AdView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class LQ implements K1 {
    public static LQ d;
    public Object a;
    public Object b;
    public Object c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LQ(UN un, int i) {
        this.a = un;
        switch (i) {
            case 8:
                new AtomicBoolean(false);
                this.b = new C3888mV(un, 1);
                this.c = new C3888mV(un, 2);
                break;
            default:
                this.b = new C0598Wk(un, 2);
                this.c = new C3888mV(un, 0);
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object a(Task task) {
        try {
            return Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e2);
            }
            throw ((IOException) cause);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LQ j(int i, int i2, Context context, AttributeSet attributeSet, int[] iArr) {
        return new LQ(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized ArrayList b() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll((ArrayList) this.c);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c(Runnable runnable) {
        ((AQ) this.a).execute(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList d(int i) {
        int resourceId;
        ColorStateList y;
        TypedArray typedArray = (TypedArray) this.b;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (y = AbstractC4673wh.y((Context) this.a, resourceId)) != null) {
            return y;
        }
        return typedArray.getColorStateList(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable e(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.b;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0) {
            return AbstractC4766xx.D((Context) this.a, resourceId);
        }
        return typedArray.getDrawable(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable f(int i) {
        int resourceId;
        Drawable f;
        if (((TypedArray) this.b).hasValue(i) && (resourceId = ((TypedArray) this.b).getResourceId(i, 0)) != 0) {
            Z4 a = Z4.a();
            Context context = (Context) this.a;
            synchronized (a) {
                f = a.a.f(context, resourceId, true);
            }
            return f;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Typeface g(int i, int i2, C4857z5 c4857z5) {
        int resourceId = ((TypedArray) this.b).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.c) == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.c;
        ThreadLocal threadLocal = CN.a;
        Context context = (Context) this.a;
        if (context.isRestricted()) {
            return null;
        }
        return CN.a(context, resourceId, typedValue, i2, c4857z5, true, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3811lV h(String str) {
        C3811lV c3811lV;
        VN j = VN.j(1, "SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?");
        if (str == null) {
            j.r(1);
        } else {
            j.w(1, str);
        }
        UN un = (UN) this.a;
        un.b();
        Cursor g = un.g(j);
        try {
            int C = AbstractC4766xx.C(g, "work_spec_id");
            int C2 = AbstractC4766xx.C(g, "system_id");
            if (g.moveToFirst()) {
                c3811lV = new C3811lV(g.getString(C), g.getInt(C2));
            } else {
                c3811lV = null;
            }
            return c3811lV;
        } finally {
            g.close();
            j.release();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void i(C3811lV c3811lV) {
        UN un = (UN) this.a;
        un.b();
        un.c();
        try {
            ((C0598Wk) this.b).e(c3811lV);
            un.h();
        } finally {
            un.f();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void k(String str, String str2, String str3, String str4) {
        if (str2 != null && str3 != null) {
            C4374sq c4374sq = (C4374sq) this.b;
            c4374sq.a();
            C0422Pq c0422Pq = c4374sq.c;
            String str5 = c0422Pq.h;
            c4374sq.a();
            String str6 = c0422Pq.a;
            if (str5 != null) {
                URL url = new URL(F40.h(AbstractC4575vQ.z("https://fcmregistrations.googleapis.com/v1/projects/", str5, "/registrations/", str3, "/topicSubscriptions/"), str, ":", str4));
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder z = AbstractC4575vQ.z("Topic ", str4, " for: ", str, " with url: ");
                    z.append(url);
                    Log.d("FirebaseMessaging", z.toString());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("x-goog-api-key", str6);
                httpURLConnection.setRequestProperty("x-goog-firebase-installations-auth", str2);
                httpURLConnection.setDoOutput(false);
                try {
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        String responseMessage = httpURLConnection.getResponseMessage();
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException unused) {
                        }
                        try {
                            InputStream errorStream = httpURLConnection.getErrorStream();
                            if (errorStream != null) {
                                errorStream.close();
                            }
                        } catch (IOException unused2) {
                        }
                        httpURLConnection.disconnect();
                        if (responseCode >= 200 && responseCode < 300) {
                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                Log.d("FirebaseMessaging", T60.y("Topic ", str4, " for: ", str, " succeeded."));
                                return;
                            }
                            return;
                        }
                        if (responseCode != 404 && responseCode != 403) {
                            if (responseCode >= 500) {
                                throw new IOException("INTERNAL_SERVER_ERROR");
                            }
                            throw new IOException("Topic " + str4 + " failed with status: " + responseCode);
                        }
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            Log.d("FirebaseMessaging", "Topic " + str4 + " failed: " + responseMessage);
                        }
                        throw new IOException(T60.x("Topic ", str4, " failed: ", responseMessage));
                    } catch (IOException e) {
                        throw new IOException("SERVICE_NOT_AVAILABLE", e);
                    }
                } catch (Throwable th) {
                    try {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (IOException unused3) {
                    }
                    try {
                        InputStream errorStream2 = httpURLConnection.getErrorStream();
                        if (errorStream2 != null) {
                            errorStream2.close();
                        }
                    } catch (IOException unused4) {
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            }
            throw new IOException("Project ID or API Key is missing");
        }
        throw new IOException("FIS auth token or FIS ID is empty");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void l(JA ja) {
        RunnableC4522uk runnableC4522uk = (RunnableC4522uk) this.c;
        if (runnableC4522uk != null) {
            runnableC4522uk.run();
        }
        RunnableC4522uk runnableC4522uk2 = new RunnableC4522uk((TA) this.a, ja);
        this.c = runnableC4522uk2;
        ((Handler) this.b).postAtFrontOfQueue(runnableC4522uk2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void m() {
        ((TypedArray) this.b).recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void n(String str) {
        UN un = (UN) this.a;
        un.b();
        C3888mV c3888mV = (C3888mV) this.c;
        C3839lt a = c3888mV.a();
        if (str == null) {
            a.r(1);
        } else {
            a.w(1, str);
        }
        un.c();
        try {
            a.J();
            un.h();
        } finally {
            un.f();
            c3888mV.c(a);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.K1
    public void onAdFailedToLoad(ZB zb) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.K1
    public void onAdLoaded(Object obj) {
        ((UDPClient) this.c).runOnUiThread(new RunnableC4699x3(13, (ViewGroup) this.a, (AdView) this.b));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LQ(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }
}
