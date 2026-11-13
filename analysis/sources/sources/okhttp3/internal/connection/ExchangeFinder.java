package okhttp3.internal.connection;

import com.google.android.gms.common.internal.ImagesContract;
import defpackage.AbstractC0440Qi;
import defpackage.AbstractC3901me;
import defpackage.AbstractC4766xx;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes.dex */
public final class ExchangeFinder {
    public final RealConnectionPool a;
    public final Address b;
    public final RealCall c;
    public final EventListener d;
    public RouteSelector.Selection e;
    public RouteSelector f;
    public int g;
    public int h;
    public int i;
    public Route j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        AbstractC4766xx.p(realConnectionPool, "connectionPool");
        AbstractC4766xx.p(eventListener, "eventListener");
        this.a = realConnectionPool;
        this.b = address;
        this.c = realCall;
        this.d = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RealConnection a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        ArrayList arrayList;
        RealCall realCall;
        String str;
        int i5;
        List list;
        boolean contains;
        String str2;
        RouteDatabase routeDatabase;
        Socket h;
        while (!this.c.p) {
            RealConnection realConnection = this.c.j;
            if (realConnection != null) {
                synchronized (realConnection) {
                    try {
                        if (!realConnection.j && b(realConnection.b.a.i)) {
                            h = null;
                        }
                        h = this.c.h();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.c.j != null) {
                    if (h != null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (realConnection.i(z2)) {
                        return realConnection;
                    }
                    realConnection.k();
                    if (this.j == null) {
                        RouteSelector.Selection selection = this.e;
                        if (selection == null ? true : selection.a()) {
                            continue;
                        } else {
                            RouteSelector routeSelector = this.f;
                            if (!(routeSelector == null ? true : routeSelector.a())) {
                                throw new IOException("exhausted all routes");
                            }
                        }
                    }
                } else {
                    if (h != null) {
                        Util.c(h);
                    }
                    EventListener eventListener = this.d;
                    RealCall realCall2 = this.c;
                    eventListener.getClass();
                    AbstractC4766xx.p(realCall2, "call");
                }
            }
            this.g = 0;
            this.h = 0;
            this.i = 0;
            if (this.a.a(this.b, this.c, null, false)) {
                realConnection = this.c.j;
                AbstractC4766xx.m(realConnection);
                EventListener eventListener2 = this.d;
                realCall = this.c;
                eventListener2.getClass();
            } else {
                Route route = this.j;
                try {
                    if (route != null) {
                        this.j = null;
                    } else {
                        RouteSelector.Selection selection2 = this.e;
                        if (selection2 == null || !selection2.a()) {
                            RouteSelector routeSelector2 = this.f;
                            if (routeSelector2 == null) {
                                Address address = this.b;
                                RealCall realCall3 = this.c;
                                routeSelector2 = new RouteSelector(address, realCall3.a.D, realCall3, this.d);
                                this.f = routeSelector2;
                            }
                            if (!routeSelector2.a()) {
                                throw new NoSuchElementException();
                            }
                            arrayList = new ArrayList();
                            while (routeSelector2.f < routeSelector2.e.size()) {
                                boolean z3 = routeSelector2.f < routeSelector2.e.size();
                                Address address2 = routeSelector2.a;
                                if (!z3) {
                                    throw new SocketException("No route to " + address2.i.d + "; exhausted proxy configurations: " + routeSelector2.e);
                                }
                                List list2 = routeSelector2.e;
                                int i6 = routeSelector2.f;
                                routeSelector2.f = i6 + 1;
                                Proxy proxy = (Proxy) list2.get(i6);
                                ArrayList arrayList2 = new ArrayList();
                                routeSelector2.g = arrayList2;
                                if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                    HttpUrl httpUrl = address2.i;
                                    str = httpUrl.d;
                                    i5 = httpUrl.e;
                                } else {
                                    SocketAddress address3 = proxy.address();
                                    if (!(address3 instanceof InetSocketAddress)) {
                                        throw new IllegalArgumentException(AbstractC4766xx.Y(address3.getClass(), "Proxy.address() is not an InetSocketAddress: ").toString());
                                    }
                                    AbstractC4766xx.o(address3, "proxyAddress");
                                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address3;
                                    RouteSelector.i.getClass();
                                    AbstractC4766xx.p(inetSocketAddress, "<this>");
                                    InetAddress address4 = inetSocketAddress.getAddress();
                                    if (address4 == null) {
                                        str = inetSocketAddress.getHostName();
                                        str2 = "hostName";
                                    } else {
                                        str = address4.getHostAddress();
                                        str2 = "address.hostAddress";
                                    }
                                    AbstractC4766xx.o(str, str2);
                                    i5 = inetSocketAddress.getPort();
                                }
                                if (1 > i5 || i5 >= 65536) {
                                    throw new SocketException("No route to " + str + ':' + i5 + "; port is out of range");
                                }
                                if (proxy.type() == Proxy.Type.SOCKS) {
                                    arrayList2.add(InetSocketAddress.createUnresolved(str, i5));
                                } else {
                                    byte[] bArr = Util.a;
                                    AbstractC4766xx.p(str, "<this>");
                                    if (Util.f.b(str)) {
                                        list = AbstractC0440Qi.x(InetAddress.getByName(str));
                                    } else {
                                        routeSelector2.d.getClass();
                                        AbstractC4766xx.p(routeSelector2.c, "call");
                                        List a = address2.a.a(str);
                                        if (a.isEmpty()) {
                                            throw new UnknownHostException(address2.a + " returned no addresses for " + str);
                                        }
                                        list = a;
                                    }
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(new InetSocketAddress((InetAddress) it.next(), i5));
                                    }
                                }
                                Iterator it2 = routeSelector2.g.iterator();
                                while (it2.hasNext()) {
                                    Route route2 = new Route(routeSelector2.a, proxy, (InetSocketAddress) it2.next());
                                    RouteDatabase routeDatabase2 = routeSelector2.b;
                                    synchronized (routeDatabase2) {
                                        contains = routeDatabase2.a.contains(route2);
                                    }
                                    if (contains) {
                                        routeSelector2.h.add(route2);
                                    } else {
                                        arrayList.add(route2);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    break;
                                }
                            }
                            if (arrayList.isEmpty()) {
                                AbstractC3901me.X(routeSelector2.h, arrayList);
                                routeSelector2.h.clear();
                            }
                            RouteSelector.Selection selection3 = new RouteSelector.Selection(arrayList);
                            this.e = selection3;
                            if (this.c.p) {
                                throw new IOException("Canceled");
                            }
                            if (this.a.a(this.b, this.c, arrayList, false)) {
                                realConnection = this.c.j;
                                AbstractC4766xx.m(realConnection);
                                EventListener eventListener3 = this.d;
                                realCall = this.c;
                                eventListener3.getClass();
                            } else {
                                if (!selection3.a()) {
                                    throw new NoSuchElementException();
                                }
                                int i7 = selection3.b;
                                selection3.b = i7 + 1;
                                route = (Route) arrayList.get(i7);
                                realConnection = new RealConnection(this.a, route);
                                this.c.r = realConnection;
                                realConnection.c(i, i2, i3, i4, z, this.c, this.d);
                                this.c.r = null;
                                routeDatabase = this.c.a.D;
                                Route route3 = realConnection.b;
                                synchronized (routeDatabase) {
                                    AbstractC4766xx.p(route3, "route");
                                    routeDatabase.a.remove(route3);
                                }
                                if (this.a.a(this.b, this.c, arrayList, true)) {
                                    RealConnection realConnection2 = this.c.j;
                                    AbstractC4766xx.m(realConnection2);
                                    this.j = route;
                                    Socket socket = realConnection.d;
                                    AbstractC4766xx.m(socket);
                                    Util.c(socket);
                                    EventListener eventListener4 = this.d;
                                    RealCall realCall4 = this.c;
                                    eventListener4.getClass();
                                    AbstractC4766xx.p(realCall4, "call");
                                    realConnection = realConnection2;
                                    if (realConnection.i(z2)) {
                                    }
                                } else {
                                    synchronized (realConnection) {
                                        RealConnectionPool realConnectionPool = this.a;
                                        realConnectionPool.getClass();
                                        byte[] bArr2 = Util.a;
                                        realConnectionPool.e.add(realConnection);
                                        realConnectionPool.c.c(realConnectionPool.d, 0L);
                                        this.c.b(realConnection);
                                    }
                                    EventListener eventListener5 = this.d;
                                    realCall = this.c;
                                    eventListener5.getClass();
                                }
                            }
                        } else {
                            RouteSelector.Selection selection4 = this.e;
                            AbstractC4766xx.m(selection4);
                            if (!selection4.a()) {
                                throw new NoSuchElementException();
                            }
                            int i8 = selection4.b;
                            selection4.b = i8 + 1;
                            route = (Route) selection4.a.get(i8);
                        }
                    }
                    realConnection.c(i, i2, i3, i4, z, this.c, this.d);
                    this.c.r = null;
                    routeDatabase = this.c.a.D;
                    Route route32 = realConnection.b;
                    synchronized (routeDatabase) {
                    }
                } catch (Throwable th2) {
                    this.c.r = null;
                    throw th2;
                }
                arrayList = null;
                realConnection = new RealConnection(this.a, route);
                this.c.r = realConnection;
            }
            AbstractC4766xx.p(realCall, "call");
            if (realConnection.i(z2)) {
            }
        }
        throw new IOException("Canceled");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean b(HttpUrl httpUrl) {
        AbstractC4766xx.p(httpUrl, ImagesContract.URL);
        HttpUrl httpUrl2 = this.b.i;
        return httpUrl.e == httpUrl2.e && AbstractC4766xx.d(httpUrl.d, httpUrl2.d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(IOException iOException) {
        AbstractC4766xx.p(iOException, "e");
        this.j = null;
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).a == ErrorCode.REFUSED_STREAM) {
                this.g++;
                return;
            }
        }
        if (iOException instanceof ConnectionShutdownException) {
            this.h++;
        } else {
            this.i++;
        }
    }
}
