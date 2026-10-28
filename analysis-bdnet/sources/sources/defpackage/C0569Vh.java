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

/* renamed from: Vh, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0569Vh implements Continuation, InterfaceC0900cV, InterfaceC0252Jb, SO {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ C0569Vh(XW xw, RunnableC3389g1 runnableC3389g1) {
        this.a = 2;
        this.b = null;
        this.c = xw;
        this.d = runnableC3389g1;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.SO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object apply(Object obj) {
        long insert;
        boolean z;
        byte[] bArr;
        int i;
        C0679Zn c0679Zn;
        UO uo;
        C0679Zn c0679Zn2;
        EnumC4484uC enumC4484uC;
        EnumC4484uC enumC4484uC2;
        int i2 = 5;
        int i3 = 4;
        int i4 = 3;
        EnumC4484uC enumC4484uC3 = EnumC4484uC.CACHE_FULL;
        int i5 = 2;
        Object obj2 = this.d;
        Object obj3 = this.c;
        int i6 = 0;
        Object obj4 = this.b;
        int i7 = 1;
        switch (this.a) {
            case 3:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                UO uo2 = (UO) obj4;
                long simpleQueryForLong = uo2.f().compileStatement("PRAGMA page_size").simpleQueryForLong() * uo2.f().compileStatement("PRAGMA page_count").simpleQueryForLong();
                H8 h8 = uo2.d;
                G8 g8 = (G8) obj3;
                if (simpleQueryForLong >= h8.a) {
                    uo2.r(1L, enumC4484uC3, g8.a);
                    return -1L;
                }
                C3559i9 c3559i9 = (C3559i9) obj2;
                Long h = UO.h(sQLiteDatabase, c3559i9);
                if (h != null) {
                    insert = h.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", c3559i9.a);
                    contentValues.put("priority", Integer.valueOf(AbstractC3954nK.a(c3559i9.c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr2 = c3559i9.b;
                    if (bArr2 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr2, 0));
                    }
                    insert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                byte[] bArr3 = g8.c.b;
                int length = bArr3.length;
                int i8 = h8.e;
                if (length <= i8) {
                    z = true;
                } else {
                    z = false;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(insert));
                contentValues2.put("transport_name", g8.a);
                contentValues2.put("timestamp_ms", Long.valueOf(g8.d));
                contentValues2.put("uptime_ms", Long.valueOf(g8.e));
                contentValues2.put("payload_encoding", g8.c.a.a);
                contentValues2.put("code", g8.b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                if (z) {
                    bArr = bArr3;
                } else {
                    bArr = new byte[0];
                }
                contentValues2.put("payload", bArr);
                contentValues2.put("product_id", g8.g);
                contentValues2.put("pseudonymous_id", g8.h);
                contentValues2.put("experiment_ids_clear_blob", g8.i);
                contentValues2.put("experiment_ids_encrypted_blob", g8.j);
                long insert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int ceil = (int) Math.ceil(bArr3.length / i8);
                    for (int i9 = 1; i9 <= ceil; i9++) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr3, (i9 - 1) * i8, Math.min(i9 * i8, bArr3.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i9));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(g8.f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert2));
                    contentValues4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, (String) entry.getKey());
                    contentValues4.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert2);
            case 4:
                Cursor cursor = (Cursor) obj;
                UO uo3 = (UO) obj4;
                uo3.getClass();
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(0);
                    if (cursor.getInt(7) != 0) {
                        i = i7;
                    } else {
                        i = 0;
                    }
                    F8 f8 = new F8();
                    f8.h = new HashMap();
                    String string = cursor.getString(i7);
                    if (string != null) {
                        f8.a = string;
                        f8.f = Long.valueOf(cursor.getLong(i5));
                        f8.g = Long.valueOf(cursor.getLong(3));
                        if (i != 0) {
                            String string2 = cursor.getString(4);
                            if (string2 == null) {
                                c0679Zn2 = UO.f;
                            } else {
                                c0679Zn2 = new C0679Zn(string2);
                            }
                            f8.d(new C0601Wn(c0679Zn2, cursor.getBlob(5)));
                            uo = uo3;
                        } else {
                            String string3 = cursor.getString(4);
                            if (string3 == null) {
                                c0679Zn = UO.f;
                            } else {
                                c0679Zn = new C0679Zn(string3);
                            }
                            Cursor query = uo3.f().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                            try {
                                ArrayList arrayList = new ArrayList();
                                int i10 = 0;
                                while (query.moveToNext()) {
                                    byte[] blob = query.getBlob(0);
                                    arrayList.add(blob);
                                    i10 += blob.length;
                                }
                                byte[] bArr4 = new byte[i10];
                                int i11 = 0;
                                int i12 = 0;
                                while (i11 < arrayList.size()) {
                                    byte[] bArr5 = (byte[]) arrayList.get(i11);
                                    ArrayList arrayList2 = arrayList;
                                    UO uo4 = uo3;
                                    System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                                    i12 += bArr5.length;
                                    i11++;
                                    arrayList = arrayList2;
                                    uo3 = uo4;
                                }
                                uo = uo3;
                                query.close();
                                f8.d(new C0601Wn(c0679Zn, bArr4));
                            } catch (Throwable th) {
                                query.close();
                                throw th;
                            }
                        }
                        if (!cursor.isNull(6)) {
                            f8.c = Integer.valueOf(cursor.getInt(6));
                        }
                        if (!cursor.isNull(8)) {
                            f8.d = Integer.valueOf(cursor.getInt(8));
                        }
                        if (!cursor.isNull(9)) {
                            f8.b = cursor.getString(9);
                        }
                        if (!cursor.isNull(10)) {
                            f8.i = cursor.getBlob(10);
                        }
                        if (!cursor.isNull(11)) {
                            f8.j = cursor.getBlob(11);
                        }
                        ((List) obj3).add(new V8(j, (C3559i9) obj2, f8.c()));
                        uo3 = uo;
                        i5 = 2;
                        i7 = 1;
                    } else {
                        throw new NullPointerException("Null transportName");
                    }
                }
                return null;
            default:
                Cursor cursor2 = (Cursor) obj;
                UO uo5 = (UO) obj4;
                uo5.getClass();
                while (true) {
                    Map map = (Map) obj3;
                    if (cursor2.moveToNext()) {
                        String string4 = cursor2.getString(i6);
                        int i13 = cursor2.getInt(1);
                        EnumC4484uC enumC4484uC4 = EnumC4484uC.REASON_UNKNOWN;
                        if (i13 != 0) {
                            if (i13 == 1) {
                                enumC4484uC4 = EnumC4484uC.MESSAGE_TOO_OLD;
                            } else if (i13 == 2) {
                                enumC4484uC = enumC4484uC3;
                                enumC4484uC2 = enumC4484uC;
                                long j2 = cursor2.getLong(2);
                                if (map.containsKey(string4)) {
                                    map.put(string4, new ArrayList());
                                }
                                ((List) map.get(string4)).add(new C4561vC(j2, enumC4484uC));
                                enumC4484uC3 = enumC4484uC2;
                                i2 = 5;
                                i3 = 4;
                                i4 = 3;
                                i6 = 0;
                            } else if (i13 == i4) {
                                enumC4484uC4 = EnumC4484uC.PAYLOAD_TOO_BIG;
                            } else if (i13 == i3) {
                                enumC4484uC4 = EnumC4484uC.MAX_RETRIES_REACHED;
                            } else if (i13 == i2) {
                                enumC4484uC4 = EnumC4484uC.INVALID_PAYLOD;
                            } else if (i13 == 6) {
                                enumC4484uC4 = EnumC4484uC.SERVER_ERROR;
                            } else {
                                AbstractC0440Qi.f("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i13));
                            }
                        }
                        enumC4484uC2 = enumC4484uC3;
                        enumC4484uC = enumC4484uC4;
                        long j22 = cursor2.getLong(2);
                        if (map.containsKey(string4)) {
                        }
                        ((List) map.get(string4)).add(new C4561vC(j22, enumC4484uC));
                        enumC4484uC3 = enumC4484uC2;
                        i2 = 5;
                        i3 = 4;
                        i4 = 3;
                        i6 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            RW rw = (RW) obj2;
                            if (it.hasNext()) {
                                Map.Entry entry2 = (Map.Entry) it.next();
                                int i14 = C4715xC.c;
                                new ArrayList();
                                ((ArrayList) rw.b).add(new C4715xC((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                            } else {
                                final long a = uo5.b.a();
                                SQLiteDatabase f = uo5.f();
                                f.beginTransaction();
                                try {
                                    C3275eW c3275eW = (C3275eW) UO.B(f.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new SO() { // from class: RO
                                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                        @Override // defpackage.SO
                                        public final Object apply(Object obj5) {
                                            Cursor cursor3 = (Cursor) obj5;
                                            cursor3.moveToNext();
                                            return new C3275eW(cursor3.getLong(0), a);
                                        }
                                    });
                                    f.setTransactionSuccessful();
                                    f.endTransaction();
                                    rw.a = c3275eW;
                                    rw.c = new C4609vu(new C3350fU(uo5.f().compileStatement("PRAGMA page_size").simpleQueryForLong() * uo5.f().compileStatement("PRAGMA page_count").simpleQueryForLong(), H8.f.a));
                                    rw.d = (String) uo5.e.get();
                                    return new C0020Ad((C3275eW) rw.a, Collections.unmodifiableList((ArrayList) rw.b), (C4609vu) rw.c, (String) rw.d);
                                } catch (Throwable th2) {
                                    f.endTransaction();
                                    throw th2;
                                }
                            }
                        }
                    }
                }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC0252Jb
    public void c() {
        Runnable runnable = (Runnable) this.b;
        if (runnable == null) {
            ((XW) this.c).cancel();
            runnable = (Runnable) this.d;
        }
        runnable.run();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC0900cV
    public Object e() {
        C4215qk c4215qk = (C4215qk) this.b;
        UO uo = (UO) c4215qk.d;
        uo.getClass();
        C3559i9 c3559i9 = (C3559i9) this.c;
        EnumC3800lK enumC3800lK = c3559i9.c;
        G8 g8 = (G8) this.d;
        String str = g8.a;
        String r = AbstractC0440Qi.r("SQLiteEventStore");
        if (Log.isLoggable(r, 3)) {
            Log.d(r, "Storing event with priority=" + enumC3800lK + ", name=" + str + " for destination " + c3559i9.a);
        }
        ((Long) uo.j(new C0569Vh(uo, g8, c3559i9, 3))).getClass();
        c4215qk.a.a(c3559i9, 1, false);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ C0569Vh(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }
}
