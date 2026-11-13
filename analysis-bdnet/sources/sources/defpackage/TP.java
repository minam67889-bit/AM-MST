package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class TP implements InterfaceC0439Qo, XV, InterfaceC0299Ld {
    public static final C3703no f = new C3703no("proto");
    public final DQ a;
    public final C4227uS b;
    public final C4227uS c;
    public final U8 d;
    public final YL e;

    public TP(C4227uS c4227uS, C4227uS c4227uS2, U8 u8, DQ dq, YL yl) {
        this.a = dq;
        this.b = c4227uS;
        this.c = c4227uS2;
        this.d = u8;
        this.e = yl;
    }

    public static Long d(SQLiteDatabase sQLiteDatabase, C4286v9 c4286v9) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(c4286v9.a, String.valueOf(AbstractC3349jL.a(c4286v9.c))));
        byte[] bArr = c4286v9.b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !query.moveToNext() ? null : Long.valueOf(query.getLong(0));
        } finally {
            query.close();
        }
    }

    public static String k(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((C3258i9) it.next()).a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object m(Cursor cursor, RP rp) {
        try {
            return rp.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase b() {
        DQ dq = this.a;
        Objects.requireNonNull(dq);
        C4227uS c4227uS = this.c;
        long c = c4227uS.c();
        while (true) {
            try {
                return dq.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (c4227uS.c() >= this.d.c + c) {
                    throw new VV("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    public final Object f(RP rp) {
        SQLiteDatabase b = b();
        b.beginTransaction();
        try {
            Object apply = rp.apply(b);
            b.setTransactionSuccessful();
            return apply;
        } finally {
            b.endTransaction();
        }
    }

    public final ArrayList g(SQLiteDatabase sQLiteDatabase, C4286v9 c4286v9, int i) {
        ArrayList arrayList = new ArrayList();
        Long d = d(sQLiteDatabase, c4286v9);
        if (d == null) {
            return arrayList;
        }
        m(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{d.toString()}, null, null, null, String.valueOf(i)), new C3061fi(this, arrayList, c4286v9, 3));
        return arrayList;
    }

    public final void h(long j, EnumC3581mD enumC3581mD, String str) {
        f(new C0017Ah(j, str, enumC3581mD));
    }

    public final Object i(WV wv) {
        SQLiteDatabase b = b();
        C4227uS c4227uS = this.c;
        long c = c4227uS.c();
        while (true) {
            try {
                b.beginTransaction();
                try {
                    Object c2 = wv.c();
                    b.setTransactionSuccessful();
                    return c2;
                } finally {
                    b.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (c4227uS.c() >= this.d.c + c) {
                    throw new VV("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
