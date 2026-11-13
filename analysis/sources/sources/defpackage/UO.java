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
public final class UO implements InterfaceC0057Bo, InterfaceC3198dV, InterfaceC4745xd {
    public static final C0679Zn f = new C0679Zn("proto");
    public final FP a;
    public final MZ b;
    public final MZ c;
    public final H8 d;
    public final InterfaceC0890cL e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UO(MZ mz, MZ mz2, H8 h8, FP fp, InterfaceC0890cL interfaceC0890cL) {
        this.a = fp;
        this.b = mz;
        this.c = mz2;
        this.d = h8;
        this.e = interfaceC0890cL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object B(Cursor cursor, SO so) {
        try {
            return so.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Long h(SQLiteDatabase sQLiteDatabase, C3559i9 c3559i9) {
        Long valueOf;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(c3559i9.a, String.valueOf(AbstractC3954nK.a(c3559i9.c))));
        byte[] bArr = c3559i9.b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(query.getLong(0));
            }
            return valueOf;
        } finally {
            query.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String z(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((V8) it.next()).a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SQLiteDatabase f() {
        FP fp = this.a;
        Objects.requireNonNull(fp);
        MZ mz = this.c;
        long a = mz.a();
        while (true) {
            try {
                return fp.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (mz.a() < this.d.c + a) {
                    SystemClock.sleep(50L);
                } else {
                    throw new C0823bV("Timed out while trying to open db.", e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object j(SO so) {
        SQLiteDatabase f2 = f();
        f2.beginTransaction();
        try {
            Object apply = so.apply(f2);
            f2.setTransactionSuccessful();
            return apply;
        } finally {
            f2.endTransaction();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ArrayList k(SQLiteDatabase sQLiteDatabase, C3559i9 c3559i9, int i) {
        ArrayList arrayList = new ArrayList();
        Long h = h(sQLiteDatabase, c3559i9);
        if (h == null) {
            return arrayList;
        }
        B(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{h.toString()}, null, null, null, String.valueOf(i)), new C0569Vh(this, arrayList, c3559i9, 4));
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void r(long j, EnumC4484uC enumC4484uC, String str) {
        j(new QO(str, j, enumC4484uC));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object w(InterfaceC0900cV interfaceC0900cV) {
        SQLiteDatabase f2 = f();
        MZ mz = this.c;
        long a = mz.a();
        while (true) {
            try {
                f2.beginTransaction();
                try {
                    Object e = interfaceC0900cV.e();
                    f2.setTransactionSuccessful();
                    return e;
                } finally {
                    f2.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e2) {
                if (mz.a() < this.d.c + a) {
                    SystemClock.sleep(50L);
                } else {
                    throw new C0823bV("Timed out while trying to acquire the lock.", e2);
                }
            }
        }
    }
}
