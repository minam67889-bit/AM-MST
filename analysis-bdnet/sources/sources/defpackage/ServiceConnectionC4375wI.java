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

/* renamed from: wI, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ServiceConnectionC4375wI implements Handler.Callback, ServiceConnection {
    public final Context a;
    public final Handler b;
    public final HashMap c = new HashMap();
    public HashSet d = new HashSet();

    public ServiceConnectionC4375wI(Context context) {
        this.a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(C4296vI c4296vI) {
        boolean z;
        ArrayDeque arrayDeque;
        boolean isLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = c4296vI.a;
        if (isLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + c4296vI.d.size() + " queued tasks");
        }
        if (c4296vI.d.isEmpty()) {
            return;
        }
        if (c4296vI.b) {
            z = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.a;
            boolean bindService = context.bindService(component, this, 33);
            c4296vI.b = bindService;
            if (bindService) {
                c4296vI.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z = c4296vI.b;
        }
        if (!z || c4296vI.c == null) {
            b(c4296vI);
            return;
        }
        while (true) {
            arrayDeque = c4296vI.d;
            C4138tI c4138tI = (C4138tI) arrayDeque.peek();
            if (c4138tI == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + c4138tI);
                }
                c4138tI.a(c4296vI.c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        b(c4296vI);
    }

    public final void b(C4296vI c4296vI) {
        Handler handler = this.b;
        ComponentName componentName = c4296vI.a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = c4296vI.e;
        int i2 = i + 1;
        c4296vI.e = i2;
        if (i2 <= 6) {
            int i3 = (1 << i) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i3);
            return;
        }
        StringBuilder sb = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = c4296vI.d;
        sb.append(arrayDeque.size());
        sb.append(" tasks to ");
        sb.append(componentName);
        sb.append(" after ");
        sb.append(c4296vI.e);
        sb.append(" retries");
        Log.w("NotifManCompat", sb.toString());
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i = message.what;
        InterfaceC4263uw interfaceC4263uw = null;
        if (i == 0) {
            C4138tI c4138tI = (C4138tI) message.obj;
            String string = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
            synchronized (C4454xI.b) {
                if (string != null) {
                    try {
                        if (!string.equals(C4454xI.c)) {
                            String[] split = string.split(":", -1);
                            HashSet hashSet2 = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet2.add(unflattenFromString.getPackageName());
                                }
                            }
                            C4454xI.d = hashSet2;
                            C4454xI.c = string;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hashSet = C4454xI.d;
            }
            if (!hashSet.equals(this.d)) {
                this.d = hashSet;
                List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet hashSet3 = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet3.add(componentName);
                        }
                    }
                }
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    ComponentName componentName2 = (ComponentName) it.next();
                    if (!this.c.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.c.put(componentName2, new C4296vI(componentName2));
                    }
                }
                Iterator it2 = this.c.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        C4296vI c4296vI = (C4296vI) entry.getValue();
                        if (c4296vI.b) {
                            this.a.unbindService(this);
                            c4296vI.b = false;
                        }
                        c4296vI.c = null;
                        it2.remove();
                    }
                }
            }
            for (C4296vI c4296vI2 : this.c.values()) {
                c4296vI2.d.add(c4138tI);
                a(c4296vI2);
            }
        } else if (i == 1) {
            C4217uI c4217uI = (C4217uI) message.obj;
            ComponentName componentName3 = c4217uI.a;
            IBinder iBinder = c4217uI.b;
            C4296vI c4296vI3 = (C4296vI) this.c.get(componentName3);
            if (c4296vI3 != null) {
                int i2 = AbstractBinderC4184tw.a;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC4263uw.Ao);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC4263uw)) {
                        C4105sw c4105sw = new C4105sw();
                        c4105sw.a = iBinder;
                        interfaceC4263uw = c4105sw;
                    } else {
                        interfaceC4263uw = (InterfaceC4263uw) queryLocalInterface;
                    }
                }
                c4296vI3.c = interfaceC4263uw;
                c4296vI3.e = 0;
                a(c4296vI3);
                return true;
            }
        } else if (i == 2) {
            C4296vI c4296vI4 = (C4296vI) this.c.get((ComponentName) message.obj);
            if (c4296vI4 != null) {
                if (c4296vI4.b) {
                    this.a.unbindService(this);
                    c4296vI4.b = false;
                }
                c4296vI4.c = null;
                return true;
            }
        } else {
            if (i != 3) {
                return false;
            }
            C4296vI c4296vI5 = (C4296vI) this.c.get((ComponentName) message.obj);
            if (c4296vI5 != null) {
                a(c4296vI5);
                return true;
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.b.obtainMessage(1, new C4217uI(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.b.obtainMessage(2, componentName).sendToTarget();
    }
}
