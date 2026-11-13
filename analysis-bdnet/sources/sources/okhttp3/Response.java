package okhttp3;

import defpackage.AbstractC3634my;
import java.io.Closeable;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;

/* loaded from: classes2.dex */
public final class Response implements Closeable {
    public final Request a;
    public final Protocol b;
    public final String c;
    public final int d;
    public final Handshake e;
    public final Headers f;
    public final ResponseBody g;
    public final Response h;
    public final Response i;
    public final Response j;
    public final long k;
    public final long l;
    public final Exchange m;

    public static class Builder {
        public Request a;
        public Protocol b;
        public String d;
        public Handshake e;
        public ResponseBody g;
        public Response h;
        public Response i;
        public Response j;
        public long k;
        public long l;
        public Exchange m;
        public int c = -1;
        public Headers.Builder f = new Headers.Builder();

        public static void b(String str, Response response) {
            if (response == null) {
                return;
            }
            if (response.g != null) {
                throw new IllegalArgumentException(AbstractC3634my.I(".body != null", str).toString());
            }
            if (response.h != null) {
                throw new IllegalArgumentException(AbstractC3634my.I(".networkResponse != null", str).toString());
            }
            if (response.i != null) {
                throw new IllegalArgumentException(AbstractC3634my.I(".cacheResponse != null", str).toString());
            }
            if (response.j != null) {
                throw new IllegalArgumentException(AbstractC3634my.I(".priorResponse != null", str).toString());
            }
        }

        public final Response a() {
            int i = this.c;
            if (i < 0) {
                throw new IllegalStateException(AbstractC3634my.I(Integer.valueOf(i), "code < 0: ").toString());
            }
            Request request = this.a;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.d;
            if (str != null) {
                return new Response(request, protocol, str, i, this.e, this.f.b(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null");
        }
    }

    public Response(Request request, Protocol protocol, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        AbstractC3634my.g(request, "request");
        AbstractC3634my.g(protocol, "protocol");
        AbstractC3634my.g(str, "message");
        this.a = request;
        this.b = protocol;
        this.c = str;
        this.d = i;
        this.e = handshake;
        this.f = headers;
        this.g = responseBody;
        this.h = response;
        this.i = response2;
        this.j = response3;
        this.k = j;
        this.l = j2;
        this.m = exchange;
    }

    public static String b(String str, Response response) {
        response.getClass();
        String a = response.f.a(str);
        if (a == null) {
            return null;
        }
        return a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ResponseBody responseBody = this.g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public final Builder d() {
        Builder builder = new Builder();
        builder.a = this.a;
        builder.b = this.b;
        builder.c = this.d;
        builder.d = this.c;
        builder.e = this.e;
        builder.f = this.f.c();
        builder.g = this.g;
        builder.h = this.h;
        builder.i = this.i;
        builder.j = this.j;
        builder.k = this.k;
        builder.l = this.l;
        builder.m = this.m;
        return builder;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.d + ", message=" + this.c + ", url=" + this.a.a + '}';
    }
}
