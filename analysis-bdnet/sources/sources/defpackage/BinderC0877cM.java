package defpackage;

import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;

/* renamed from: cM, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class BinderC0877cM extends Binder implements InterfaceC0084Cw {
    public final /* synthetic */ int a;
    public final /* synthetic */ Service b;

    public BinderC0877cM(Service service, int i) {
        this.a = i;
        this.b = service;
        attachInterface(this, "prince.dastan.vpn.aidl.IUltraSSHServiceInternal");
    }

    @Override // defpackage.InterfaceC0084Cw
    public final void a() {
        switch (this.a) {
            case 0:
                ((PsiphonDNSService) this.b).g();
                break;
            case 1:
                ((SocksDNSService) this.b).j();
                break;
            default:
                ((XRayDNSService) this.b).k();
                break;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("prince.dastan.vpn.aidl.IUltraSSHServiceInternal");
        }
        if (i == 1598968902) {
            parcel2.writeString("prince.dastan.vpn.aidl.IUltraSSHServiceInternal");
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        a();
        parcel2.writeNoException();
        return true;
    }
}
