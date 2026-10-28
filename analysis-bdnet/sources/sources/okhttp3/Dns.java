package okhttp3;

import defpackage.AbstractC3634my;
import defpackage.I6;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes2.dex */
public interface Dns {
    public static final Dns a;

    public static final class Companion {
        public static final /* synthetic */ int a = 0;

        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public final List a(String str) {
                AbstractC3634my.g(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    AbstractC3634my.f(allByName, "getAllByName(hostname)");
                    return I6.d0(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException(AbstractC3634my.I(str, "Broken system behaviour for dns lookup of "));
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        static {
            new Companion();
        }

        private Companion() {
        }
    }

    static {
        int i = Companion.a;
        a = new Companion.DnsSystem();
    }

    List a(String str);
}
