package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class AH implements Handler.Callback, ServiceConnection {
    public final Context a;
    public final Handler b;
    public final HashMap c = new HashMap();
    public HashSet d = new HashSet();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AH(Context context) {
        this.a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(C4874zH c4874zH) {
        boolean z;
        ArrayDeque arrayDeque;
        boolean isLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = c4874zH.a;
        if (isLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + c4874zH.d.size() + " queued tasks");
        }
        if (c4874zH.d.isEmpty()) {
            return;
        }
        if (c4874zH.b) {
            z = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.a;
            boolean bindService = context.bindService(component, this, 33);
            c4874zH.b = bindService;
            if (bindService) {
                c4874zH.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z = c4874zH.b;
        }
        if (z && c4874zH.c != null) {
            while (true) {
                arrayDeque = c4874zH.d;
                C4720xH c4720xH = (C4720xH) arrayDeque.peek();
                if (c4720xH == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + c4720xH);
                    }
                    c4720xH.a(c4874zH.c);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + componentName);
                    }
                } catch (RemoteException e) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
                }
            }
            if (!arrayDeque.isEmpty()) {
                b(c4874zH);
                return;
            }
            return;
        }
        b(c4874zH);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(C4874zH c4874zH) {
        Handler handler = this.b;
        ComponentName componentName = c4874zH.a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = c4874zH.e;
        int i2 = i + 1;
        c4874zH.e = i2;
        if (i2 > 6) {
            StringBuilder sb = new StringBuilder("Giving up on delivering ");
            ArrayDeque arrayDeque = c4874zH.d;
            sb.append(arrayDeque.size());
            sb.append(" tasks to ");
            sb.append(componentName);
            sb.append(" after ");
            sb.append(c4874zH.e);
            sb.append(" retries");
            Log.w("NotifManCompat", sb.toString());
            arrayDeque.clear();
            return;
        }
        int i3 = (1 << i) * 1000;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
        }
        handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i = message.what;
        InterfaceC0298Kv interfaceC0298Kv = null;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    C4874zH c4874zH = (C4874zH) this.c.get((ComponentName) message.obj);
                    if (c4874zH != null) {
                        a(c4874zH);
                    }
                    return true;
                }
                C4874zH c4874zH2 = (C4874zH) this.c.get((ComponentName) message.obj);
                if (c4874zH2 != null) {
                    if (c4874zH2.b) {
                        this.a.unbindService(this);
                        c4874zH2.b = false;
                    }
                    c4874zH2.c = null;
                }
                return true;
            }
            C4797yH c4797yH = (C4797yH) message.obj;
            ComponentName componentName = c4797yH.a;
            IBinder iBinder = c4797yH.b;
            C4874zH c4874zH3 = (C4874zH) this.c.get(componentName);
            if (c4874zH3 != null) {
                int i2 = AbstractBinderC0272Jv.a;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC0298Kv.So);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC0298Kv)) {
                        interfaceC0298Kv = (InterfaceC0298Kv) queryLocalInterface;
                    } else {
                        C0246Iv c0246Iv = new C0246Iv();
                        c0246Iv.a = iBinder;
                        interfaceC0298Kv = c0246Iv;
                    }
                }
                c4874zH3.c = interfaceC0298Kv;
                c4874zH3.e = 0;
                a(c4874zH3);
            }
            return true;
        }
        C4720xH c4720xH = (C4720xH) message.obj;
        String string = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
        synchronized (BH.b) {
            if (string != null) {
                try {
                    if (!string.equals(BH.c)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet2.add(unflattenFromString.getPackageName());
                            }
                        }
                        BH.d = hashSet2;
                        BH.c = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = BH.d;
        }
        if (!hashSet.equals(this.d)) {
            this.d = hashSet;
            List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet hashSet3 = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName2 = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName2 + ", not adding listener record.");
                    } else {
                        hashSet3.add(componentName2);
                    }
                }
            }
            Iterator it = hashSet3.iterator();
            while (it.hasNext()) {
                ComponentName componentName3 = (ComponentName) it.next();
                if (!this.c.containsKey(componentName3)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName3);
                    }
                    this.c.put(componentName3, new C4874zH(componentName3));
                }
            }
            Iterator it2 = this.c.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet3.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    C4874zH c4874zH4 = (C4874zH) entry.getValue();
                    if (c4874zH4.b) {
                        this.a.unbindService(this);
                        c4874zH4.b = false;
                    }
                    c4874zH4.c = null;
                    it2.remove();
                }
            }
        }
        for (C4874zH c4874zH5 : this.c.values()) {
            c4874zH5.d.add(c4720xH);
            a(c4874zH5);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.b.obtainMessage(1, new C4797yH(componentName, iBinder)).sendToTarget();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.b.obtainMessage(2, componentName).sendToTarget();
    }
}
