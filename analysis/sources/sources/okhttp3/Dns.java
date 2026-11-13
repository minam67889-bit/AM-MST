package okhttp3;

import defpackage.AbstractC4167q6;
import defpackage.AbstractC4766xx;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes.dex */
public interface Dns {
    public static final Dns a;

    public static final class Companion {
        public static final /* synthetic */ int a = 0;

        public static final class DnsSystem implements Dns {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // okhttp3.Dns
            public final List a(String str) {
                AbstractC4766xx.p(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    AbstractC4766xx.o(allByName, "getAllByName(hostname)");
                    return AbstractC4167q6.Z(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException(AbstractC4766xx.Y(str, "Broken system behaviour for dns lookup of "));
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            new Companion();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int i = Companion.a;
        a = new Companion.DnsSystem();
    }

    List a(String str);
}
