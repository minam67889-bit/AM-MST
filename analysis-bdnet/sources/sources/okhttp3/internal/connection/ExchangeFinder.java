package okhttp3.internal.connection;

import com.google.android.gms.common.internal.ImagesContract;
import defpackage.AbstractC0014Ae;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC3634my;
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

/* loaded from: classes2.dex */
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

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        AbstractC3634my.g(realConnectionPool, "connectionPool");
        AbstractC3634my.g(realCall, "call");
        AbstractC3634my.g(eventListener, "eventListener");
        this.a = realConnectionPool;
        this.b = address;
        this.c = realCall;
        this.d = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RealConnection a(int i, boolean z, boolean z2, int i2, int i3) {
        ArrayList arrayList;
        String str;
        int i4;
        List list;
        boolean contains;
        RouteDatabase routeDatabase;
        Socket h;
        while (!this.c.n) {
            RealConnection realConnection = this.c.i;
            if (realConnection != null) {
                synchronized (realConnection) {
                    try {
                        if (!realConnection.j && b(realConnection.b.a.h)) {
                            h = null;
                        }
                        h = this.c.h();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.c.i != null) {
                    if (h != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!realConnection.i(z2)) {
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
                    RealCall realCall = this.c;
                    eventListener.getClass();
                    AbstractC3634my.g(realCall, "call");
                }
            }
            this.g = 0;
            this.h = 0;
            this.i = 0;
            if (this.a.a(this.b, this.c, null, false)) {
                realConnection = this.c.i;
                AbstractC3634my.d(realConnection);
                EventListener eventListener2 = this.d;
                RealCall realCall2 = this.c;
                eventListener2.getClass();
                AbstractC3634my.g(realCall2, "call");
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
                                routeSelector2 = new RouteSelector(address, realCall3.a.A, realCall3, this.d);
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
                                    throw new SocketException("No route to " + address2.h.d + "; exhausted proxy configurations: " + routeSelector2.e);
                                }
                                List list2 = routeSelector2.e;
                                int i5 = routeSelector2.f;
                                routeSelector2.f = i5 + 1;
                                Proxy proxy = (Proxy) list2.get(i5);
                                ArrayList arrayList2 = new ArrayList();
                                routeSelector2.g = arrayList2;
                                if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                    HttpUrl httpUrl = address2.h;
                                    str = httpUrl.d;
                                    i4 = httpUrl.e;
                                } else {
                                    SocketAddress address3 = proxy.address();
                                    if (!(address3 instanceof InetSocketAddress)) {
                                        throw new IllegalArgumentException(AbstractC3634my.I(address3.getClass(), "Proxy.address() is not an InetSocketAddress: ").toString());
                                    }
                                    AbstractC3634my.f(address3, "proxyAddress");
                                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address3;
                                    RouteSelector.i.getClass();
                                    AbstractC3634my.g(inetSocketAddress, "<this>");
                                    InetAddress address4 = inetSocketAddress.getAddress();
                                    if (address4 == null) {
                                        str = inetSocketAddress.getHostName();
                                        AbstractC3634my.f(str, "hostName");
                                    } else {
                                        str = address4.getHostAddress();
                                        AbstractC3634my.f(str, "address.hostAddress");
                                    }
                                    i4 = inetSocketAddress.getPort();
                                }
                                if (1 > i4 || i4 >= 65536) {
                                    throw new SocketException("No route to " + str + ':' + i4 + "; port is out of range");
                                }
                                if (proxy.type() == Proxy.Type.SOCKS) {
                                    arrayList2.add(InetSocketAddress.createUnresolved(str, i4));
                                } else {
                                    byte[] bArr = Util.a;
                                    AbstractC3634my.g(str, "<this>");
                                    if (Util.f.b(str)) {
                                        list = AbstractC0641Yi.C(InetAddress.getByName(str));
                                    } else {
                                        routeSelector2.d.getClass();
                                        AbstractC3634my.g(routeSelector2.c, "call");
                                        List a = address2.a.a(str);
                                        if (a.isEmpty()) {
                                            throw new UnknownHostException(address2.a + " returned no addresses for " + str);
                                        }
                                        list = a;
                                    }
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(new InetSocketAddress((InetAddress) it.next(), i4));
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
                                AbstractC0014Ae.o0(routeSelector2.h, arrayList);
                                routeSelector2.h.clear();
                            }
                            RouteSelector.Selection selection3 = new RouteSelector.Selection(arrayList);
                            this.e = selection3;
                            if (this.c.n) {
                                throw new IOException("Canceled");
                            }
                            if (this.a.a(this.b, this.c, arrayList, false)) {
                                realConnection = this.c.i;
                                AbstractC3634my.d(realConnection);
                                EventListener eventListener3 = this.d;
                                RealCall realCall4 = this.c;
                                eventListener3.getClass();
                                AbstractC3634my.g(realCall4, "call");
                            } else {
                                if (!selection3.a()) {
                                    throw new NoSuchElementException();
                                }
                                int i6 = selection3.b;
                                selection3.b = i6 + 1;
                                route = (Route) arrayList.get(i6);
                                RealConnection realConnection2 = new RealConnection(this.a, route);
                                this.c.p = realConnection2;
                                realConnection2.c(i, i2, i3, z, this.c, this.d);
                                this.c.p = null;
                                routeDatabase = this.c.a.A;
                                Route route3 = realConnection2.b;
                                synchronized (routeDatabase) {
                                    AbstractC3634my.g(route3, "route");
                                    routeDatabase.a.remove(route3);
                                }
                                if (this.a.a(this.b, this.c, arrayList, true)) {
                                    realConnection = this.c.i;
                                    AbstractC3634my.d(realConnection);
                                    this.j = route;
                                    Socket socket = realConnection2.d;
                                    AbstractC3634my.d(socket);
                                    Util.c(socket);
                                    EventListener eventListener4 = this.d;
                                    RealCall realCall5 = this.c;
                                    eventListener4.getClass();
                                    AbstractC3634my.g(realCall5, "call");
                                } else {
                                    synchronized (realConnection2) {
                                        RealConnectionPool realConnectionPool = this.a;
                                        realConnectionPool.getClass();
                                        byte[] bArr2 = Util.a;
                                        realConnectionPool.e.add(realConnection2);
                                        realConnectionPool.c.c(realConnectionPool.d, 0L);
                                        this.c.b(realConnection2);
                                    }
                                    EventListener eventListener5 = this.d;
                                    RealCall realCall6 = this.c;
                                    eventListener5.getClass();
                                    AbstractC3634my.g(realCall6, "call");
                                    realConnection = realConnection2;
                                }
                            }
                        } else {
                            RouteSelector.Selection selection4 = this.e;
                            AbstractC3634my.d(selection4);
                            if (!selection4.a()) {
                                throw new NoSuchElementException();
                            }
                            int i7 = selection4.b;
                            selection4.b = i7 + 1;
                            route = (Route) selection4.a.get(i7);
                        }
                    }
                    realConnection2.c(i, i2, i3, z, this.c, this.d);
                    this.c.p = null;
                    routeDatabase = this.c.a.A;
                    Route route32 = realConnection2.b;
                    synchronized (routeDatabase) {
                    }
                } catch (Throwable th2) {
                    this.c.p = null;
                    throw th2;
                }
                arrayList = null;
                RealConnection realConnection22 = new RealConnection(this.a, route);
                this.c.p = realConnection22;
            }
            if (!realConnection.i(z2)) {
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(HttpUrl httpUrl) {
        AbstractC3634my.g(httpUrl, ImagesContract.URL);
        HttpUrl httpUrl2 = this.b.h;
        return httpUrl.e == httpUrl2.e && AbstractC3634my.a(httpUrl.d, httpUrl2.d);
    }

    public final void c(IOException iOException) {
        AbstractC3634my.g(iOException, "e");
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
