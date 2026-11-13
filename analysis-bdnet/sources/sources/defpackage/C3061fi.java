package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: fi, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C3061fi implements Continuation, WV, RP {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ C3061fi(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c A[SYNTHETIC] */
    @Override // defpackage.RP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object apply(Object obj) {
        long insert;
        Cursor cursor;
        int i;
        EnumC3581mD enumC3581mD;
        EnumC3581mD enumC3581mD2;
        int i2 = 5;
        int i3 = 4;
        int i4 = 3;
        EnumC3581mD enumC3581mD3 = EnumC3581mD.CACHE_FULL;
        int i5 = 2;
        Object obj2 = this.d;
        int i6 = 0;
        Object obj3 = this.c;
        Object obj4 = this.b;
        int i7 = 1;
        switch (this.a) {
            case 2:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                TP tp = (TP) obj4;
                long simpleQueryForLong = tp.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * tp.b().compileStatement("PRAGMA page_count").simpleQueryForLong();
                U8 u8 = tp.d;
                long j = u8.a;
                T8 t8 = (T8) obj3;
                String str = t8.a;
                if (simpleQueryForLong >= j) {
                    tp.h(1L, enumC3581mD3, str);
                    return -1L;
                }
                C4286v9 c4286v9 = (C4286v9) obj2;
                Long d = TP.d(sQLiteDatabase, c4286v9);
                if (d != null) {
                    insert = d.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", c4286v9.a);
                    contentValues.put("priority", Integer.valueOf(AbstractC3349jL.a(c4286v9.c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = c4286v9.b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    insert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                C3465ko c3465ko = t8.c;
                byte[] bArr2 = c3465ko.b;
                int length = bArr2.length;
                int i8 = u8.e;
                boolean z = length <= i8;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(insert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(t8.d));
                contentValues2.put("uptime_ms", Long.valueOf(t8.e));
                contentValues2.put("payload_encoding", c3465ko.a.a);
                contentValues2.put("code", t8.b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr2 : new byte[0]);
                contentValues2.put("product_id", t8.g);
                contentValues2.put("pseudonymous_id", t8.h);
                contentValues2.put("experiment_ids_clear_blob", t8.i);
                contentValues2.put("experiment_ids_encrypted_blob", t8.j);
                long insert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int ceil = (int) Math.ceil(bArr2.length / i8);
                    for (int i9 = 1; i9 <= ceil; i9++) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr2, (i9 - 1) * i8, Math.min(i9 * i8, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i9));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(t8.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert2));
                    contentValues4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, (String) entry.getKey());
                    contentValues4.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert2);
            case 3:
                Cursor cursor2 = (Cursor) obj;
                TP tp2 = (TP) obj4;
                tp2.getClass();
                while (cursor2.moveToNext()) {
                    long j2 = cursor2.getLong(0);
                    int i10 = cursor2.getInt(7) != 0 ? i7 : 0;
                    S8 s8 = new S8();
                    s8.f = new HashMap();
                    String string = cursor2.getString(i7);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    s8.a = string;
                    s8.d = Long.valueOf(cursor2.getLong(i5));
                    s8.e = Long.valueOf(cursor2.getLong(3));
                    if (i10 != 0) {
                        String string2 = cursor2.getString(4);
                        s8.c = new C3465ko(string2 == null ? TP.f : new C3703no(string2), cursor2.getBlob(5));
                        i = i7;
                    } else {
                        String string3 = cursor2.getString(4);
                        C3703no c3703no = string3 == null ? TP.f : new C3703no(string3);
                        Cursor query = tp2.b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList = new ArrayList();
                            int i11 = 0;
                            while (query.moveToNext()) {
                                int i12 = i7;
                                byte[] blob = query.getBlob(0);
                                arrayList.add(blob);
                                i11 += blob.length;
                                i7 = i12;
                            }
                            i = i7;
                            byte[] bArr3 = new byte[i11];
                            int i13 = 0;
                            int i14 = 0;
                            while (i13 < arrayList.size()) {
                                byte[] bArr4 = (byte[]) arrayList.get(i13);
                                cursor = query;
                                try {
                                    ArrayList arrayList2 = arrayList;
                                    System.arraycopy(bArr4, 0, bArr3, i14, bArr4.length);
                                    i14 += bArr4.length;
                                    i13++;
                                    query = cursor;
                                    arrayList = arrayList2;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            query.close();
                            s8.c = new C3465ko(c3703no, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        s8.b = Integer.valueOf(cursor2.getInt(6));
                    }
                    if (!cursor2.isNull(8)) {
                        s8.g = Integer.valueOf(cursor2.getInt(8));
                    }
                    if (!cursor2.isNull(9)) {
                        s8.h = cursor2.getString(9);
                    }
                    if (!cursor2.isNull(10)) {
                        s8.i = cursor2.getBlob(10);
                    }
                    if (!cursor2.isNull(11)) {
                        s8.j = cursor2.getBlob(11);
                    }
                    ((ArrayList) obj3).add(new C3258i9(j2, (C4286v9) obj2, s8.b()));
                    i7 = i;
                    i5 = 2;
                }
                return null;
            default:
                Cursor cursor3 = (Cursor) obj;
                TP tp3 = (TP) obj4;
                tp3.getClass();
                while (true) {
                    HashMap hashMap = (HashMap) obj3;
                    if (cursor3.moveToNext()) {
                        String string4 = cursor3.getString(i6);
                        int i15 = cursor3.getInt(1);
                        EnumC3581mD enumC3581mD4 = EnumC3581mD.REASON_UNKNOWN;
                        if (i15 != 0) {
                            if (i15 == 1) {
                                enumC3581mD4 = EnumC3581mD.MESSAGE_TOO_OLD;
                            } else if (i15 == 2) {
                                enumC3581mD = enumC3581mD3;
                                enumC3581mD2 = enumC3581mD;
                                long j3 = cursor3.getLong(2);
                                if (hashMap.containsKey(string4)) {
                                    hashMap.put(string4, new ArrayList());
                                }
                                ((List) hashMap.get(string4)).add(new C3660nD(j3, enumC3581mD));
                                enumC3581mD3 = enumC3581mD2;
                                i2 = 5;
                                i3 = 4;
                                i4 = 3;
                                i6 = 0;
                            } else if (i15 == i4) {
                                enumC3581mD4 = EnumC3581mD.PAYLOAD_TOO_BIG;
                            } else if (i15 == i3) {
                                enumC3581mD4 = EnumC3581mD.MAX_RETRIES_REACHED;
                            } else if (i15 == i2) {
                                enumC3581mD4 = EnumC3581mD.INVALID_PAYLOD;
                            } else if (i15 == 6) {
                                enumC3581mD4 = EnumC3581mD.SERVER_ERROR;
                            } else {
                                AbstractC3634my.j("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i15));
                            }
                        }
                        enumC3581mD2 = enumC3581mD3;
                        enumC3581mD = enumC3581mD4;
                        long j32 = cursor3.getLong(2);
                        if (hashMap.containsKey(string4)) {
                        }
                        ((List) hashMap.get(string4)).add(new C3660nD(j32, enumC3581mD));
                        enumC3581mD3 = enumC3581mD2;
                        i2 = 5;
                        i3 = 4;
                        i4 = 3;
                        i6 = 0;
                    } else {
                        Iterator it = hashMap.entrySet().iterator();
                        while (true) {
                            FR fr = (FR) obj2;
                            if (!it.hasNext()) {
                                long c = tp3.b.c();
                                SQLiteDatabase b = tp3.b();
                                b.beginTransaction();
                                try {
                                    Cursor rawQuery = b.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                                    try {
                                        rawQuery.moveToNext();
                                        XW xw = new XW(rawQuery.getLong(0), c);
                                        rawQuery.close();
                                        b.setTransactionSuccessful();
                                        b.endTransaction();
                                        fr.b = xw;
                                        fr.d = new C2914dv(new C3041fV(tp3.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * tp3.b().compileStatement("PRAGMA page_count").simpleQueryForLong(), U8.f.a));
                                        fr.a = (String) tp3.e.get();
                                        return new C0376Od((XW) fr.b, Collections.unmodifiableList((ArrayList) fr.c), (C2914dv) fr.d, (String) fr.a);
                                    } catch (Throwable th3) {
                                        rawQuery.close();
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    b.endTransaction();
                                    throw th4;
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i16 = C3818pD.c;
                            new ArrayList();
                            ((ArrayList) fr.c).add(new C3818pD((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                        }
                    }
                }
        }
    }

    @Override // defpackage.WV
    public Object c() {
        C4409wk c4409wk = (C4409wk) this.b;
        TP tp = (TP) c4409wk.d;
        tp.getClass();
        C4286v9 c4286v9 = (C4286v9) this.c;
        T8 t8 = (T8) this.d;
        String t = AbstractC3634my.t("SQLiteEventStore");
        if (Log.isLoggable(t, 3)) {
            Log.d(t, "Storing event with priority=" + c4286v9.c + ", name=" + t8.a + " for destination " + c4286v9.a);
        }
        ((Long) tp.f(new C3061fi(tp, t8, c4286v9, 2))).getClass();
        c4409wk.a.a(c4286v9, 1, false);
        return null;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean isSuccessful = task.isSuccessful();
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.b;
        if (isSuccessful) {
            taskCompletionSource.trySetResult(task.getResult());
        } else if (task.getException() != null) {
            taskCompletionSource.trySetException(task.getException());
        } else if (((AtomicBoolean) this.c).getAndSet(true)) {
            ((CancellationTokenSource) this.d).cancel();
        }
        return Tasks.forResult(null);
    }
}
