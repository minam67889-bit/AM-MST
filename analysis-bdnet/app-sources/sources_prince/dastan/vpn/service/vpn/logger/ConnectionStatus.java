package prince.dastan.vpn.service.vpn.logger;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public enum ConnectionStatus implements Parcelable {
    LEVEL_CONNECTED,
    LEVEL_CONNECTING_SERVER_REPLIED,
    LEVEL_CONNECTING_NO_SERVER_REPLY_YET,
    LEVEL_NONETWORK,
    LEVEL_NOTCONNECTED,
    LEVEL_START,
    LEVEL_AUTH_FAILED,
    LEVEL_WAITING_FOR_USER_INPUT,
    UNKNOWN_LEVEL;

    public static final Parcelable.Creator<ConnectionStatus> CREATOR = new Parcelable.Creator<ConnectionStatus>() { // from class: prince.dastan.vpn.service.vpn.logger.ConnectionStatus.1
        @Override // android.os.Parcelable.Creator
        public ConnectionStatus createFromParcel(Parcel parcel) {
            return ConnectionStatus.values()[parcel.readInt()];
        }

        @Override // android.os.Parcelable.Creator
        public ConnectionStatus[] newArray(int i) {
            return new ConnectionStatus[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
