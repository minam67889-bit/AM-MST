package defpackage;

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;
import prince.udp.vpn.service.SocksDNSService;

/* loaded from: classes.dex */
public final class PF extends Binder implements IInterface {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Service b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PF(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.b = multiInstanceInvalidationService;
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(String[] strArr, int i) {
        synchronized (((MultiInstanceInvalidationService) this.b).c) {
            try {
                String str = (String) ((MultiInstanceInvalidationService) this.b).b.get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = ((MultiInstanceInvalidationService) this.b).c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        Integer num = (Integer) ((MultiInstanceInvalidationService) this.b).c.getBroadcastCookie(i2);
                        int intValue = num.intValue();
                        String str2 = (String) ((MultiInstanceInvalidationService) this.b).b.get(num);
                        if (i != intValue && str.equals(str2)) {
                            try {
                                ((C0220Hv) ((MultiInstanceInvalidationService) this.b).c.getBroadcastItem(i2)).a(strArr);
                            } catch (RemoteException e) {
                                Log.w("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                    } finally {
                        ((MultiInstanceInvalidationService) this.b).c.finishBroadcast();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.a;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int b(C0220Hv c0220Hv, String str) {
        if (str == null) {
            return 0;
        }
        synchronized (((MultiInstanceInvalidationService) this.b).c) {
            try {
                MultiInstanceInvalidationService multiInstanceInvalidationService = (MultiInstanceInvalidationService) this.b;
                int i = multiInstanceInvalidationService.a + 1;
                multiInstanceInvalidationService.a = i;
                if (multiInstanceInvalidationService.c.register(c0220Hv, Integer.valueOf(i))) {
                    ((MultiInstanceInvalidationService) this.b).b.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = (MultiInstanceInvalidationService) this.b;
                multiInstanceInvalidationService2.a--;
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.a) {
            case 0:
                C0220Hv c0220Hv = null;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 1598968902) {
                                return super.onTransact(i, parcel, parcel2, i2);
                            }
                            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                            return true;
                        }
                        parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                        a(parcel.createStringArray(), parcel.readInt());
                        return true;
                    }
                    parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                        if (queryLocalInterface != null && (queryLocalInterface instanceof C0220Hv)) {
                            c0220Hv = (C0220Hv) queryLocalInterface;
                        } else {
                            c0220Hv = new C0220Hv();
                            c0220Hv.a = readStrongBinder;
                        }
                    }
                    int readInt = parcel.readInt();
                    synchronized (((MultiInstanceInvalidationService) this.b).c) {
                        ((MultiInstanceInvalidationService) this.b).c.unregister(c0220Hv);
                        ((MultiInstanceInvalidationService) this.b).b.remove(Integer.valueOf(readInt));
                    }
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                    if (queryLocalInterface2 != null && (queryLocalInterface2 instanceof C0220Hv)) {
                        c0220Hv = (C0220Hv) queryLocalInterface2;
                    } else {
                        c0220Hv = new C0220Hv();
                        c0220Hv.a = readStrongBinder2;
                    }
                }
                int b = b(c0220Hv, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            default:
                if (i >= 1 && i <= 16777215) {
                    parcel.enforceInterface("prince.udp.vpn.aidl.IUltraSSHServiceInternal");
                }
                if (i != 1598968902) {
                    if (i != 1) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    this.b.f();
                    parcel2.writeNoException();
                    return true;
                }
                parcel2.writeString("prince.udp.vpn.aidl.IUltraSSHServiceInternal");
                return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PF(SocksDNSService socksDNSService) {
        this.b = socksDNSService;
        attachInterface(this, "prince.udp.vpn.aidl.IUltraSSHServiceInternal");
    }
}
