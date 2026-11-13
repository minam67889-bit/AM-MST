package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* renamed from: Zu, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0679Zu {
    public final ArrayList a;
    public final Object b;

    public C0679Zu(ArrayList arrayList, List list) {
        this.a = arrayList;
        this.b = list;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0679Zu)) {
            return false;
        }
        ArrayList arrayList = this.a;
        C0679Zu c0679Zu = (C0679Zu) obj;
        if (arrayList.size() != c0679Zu.a.size()) {
            return false;
        }
        ?? r1 = this.b;
        int size = r1.size();
        ?? r3 = c0679Zu.b;
        return size == r3.size() && new HashSet(arrayList).equals(new HashSet(c0679Zu.a)) && new HashSet((Collection) r1).equals(new HashSet((Collection) r3));
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    public final String toString() {
        return "GetTopicsResponse: Topics=" + this.a + ", EncryptedTopics=" + this.b;
    }
}
