package defpackage;

import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import org.chromium.net.impl.JavaUploadDataSinkBase;
import prince.dastan.vpn.tethering.ProxyService;

/* renamed from: Mc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0323Mc {
    public C0116Ec a;
    public C0116Ec b;

    public static SocketChannel b(int i, String str) {
        Log.d("ChannelPair", "connect " + str + ":" + i);
        try {
            SocketChannel open = SocketChannel.open();
            open.configureBlocking(false);
            if (open.connect(new InetSocketAddress(InetAddress.getByName(str), i))) {
                Log.e("ChannelPair", "connect channel failed");
                return null;
            }
            for (int i2 = 0; i2 < 200; i2++) {
                Thread.sleep(50L);
                if (open.finishConnect()) {
                    return open;
                }
            }
            Log.w("ChannelPair", "abort connection for timeout");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a() {
        Log.d("ChannelPair", "close pair socket " + this);
        C0116Ec c0116Ec = this.a;
        if (c0116Ec != null) {
            c0116Ec.a();
        }
        C0116Ec c0116Ec2 = this.b;
        if (c0116Ec2 != null) {
            c0116Ec2.a();
        }
    }

    public final void c(SelectionKey selectionKey) {
        if (!selectionKey.isValid()) {
            Log.d("ChannelPair", "close invalid socket.");
            a();
            return;
        }
        if (!selectionKey.isAcceptable()) {
            C0116Ec c0116Ec = this.a;
            if (c0116Ec != null && selectionKey.equals(c0116Ec.b)) {
                this.a.d();
                return;
            }
            C0116Ec c0116Ec2 = this.b;
            if (c0116Ec2 == null || !selectionKey.equals(c0116Ec2.b)) {
                return;
            }
            this.b.d();
            this.a.f();
            return;
        }
        try {
            if (!selectionKey.isAcceptable()) {
                Log.w("ChannelPair", "invalid accept key");
                return;
            }
            SocketChannel accept = ((ServerSocketChannel) selectionKey.channel()).accept();
            Log.d("ChannelPair", "connRequest " + accept.socket().getInetAddress());
            C0116Ec c0116Ec3 = new C0116Ec(true);
            this.a = c0116Ec3;
            c0116Ec3.m = this;
            c0116Ec3.a = accept;
            accept.configureBlocking(false);
            this.a.b = accept.register(ProxyService.g.e, 1, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(C0116Ec c0116Ec) {
        boolean z = c0116Ec.i;
        if (z && this.b != null) {
            if (c0116Ec.c == null) {
                c0116Ec.c = ByteBuffer.allocate(JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE);
            }
            this.b.g(c0116Ec.c);
            return;
        }
        if (z || this.a == null) {
            return;
        }
        if (c0116Ec.c == null) {
            c0116Ec.c = ByteBuffer.allocate(JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE);
        }
        this.a.g(c0116Ec.c);
    }
}
