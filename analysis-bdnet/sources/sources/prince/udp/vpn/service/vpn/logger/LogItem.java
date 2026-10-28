package prince.udp.vpn.service.vpn.logger;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.liapp.y;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Locale;
import java.util.UnknownFormatConversionException;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class LogItem implements Parcelable {
    public static final Parcelable.Creator<LogItem> CREATOR = new Parcelable.Creator<LogItem>() { // from class: prince.udp.vpn.service.vpn.logger.LogItem.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public LogItem createFromParcel(Parcel parcel) {
            return new LogItem(parcel);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public LogItem[] newArray(int i) {
            return new LogItem[i];
        }
    };
    private long logtime;
    private Object[] mArgs;
    SkStatus.LogLevel mLevel;
    private String mMessage;
    private int mResourceId;
    private int mVerbosityLevel;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String join(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SkStatus.LogLevel getLogLevel() {
        return this.mLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLogtime() {
        return this.logtime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMessage() {
        return this.mMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getString(Context context) {
        String str = y.ܴ٭׮ڱܭ(-366001364);
        try {
            String str2 = this.mMessage;
            if (str2 != null) {
                return str2;
            }
            if (context != null) {
                Object[] objArr = this.mArgs;
                return objArr == null ? context.getString(this.mResourceId) : context.getString(this.mResourceId, objArr);
            }
            Locale locale = Locale.ENGLISH;
            String str3 = str + this.mResourceId;
            if (this.mArgs == null) {
                return str3;
            }
            return str3 + join("|", this.mArgs);
        } catch (FormatFlagsConversionMismatchException e) {
            if (context == null) {
                throw e;
            }
            throw new FormatFlagsConversionMismatchException(e.getLocalizedMessage() + getString(null), e.getConversion());
        } catch (UnknownFormatConversionException e2) {
            if (context == null) {
                throw e2;
            }
            throw new UnknownFormatConversionException(e2.getLocalizedMessage() + getString(null));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getVerbosityLevel() {
        int i = this.mVerbosityLevel;
        return i == -1 ? this.mLevel.getInt() : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return getString(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.mArgs);
        parcel.writeString(this.mMessage);
        parcel.writeInt(this.mResourceId);
        parcel.writeInt(this.mLevel.getInt());
        parcel.writeLong(this.logtime);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(int i, Object... objArr) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mResourceId = i;
        this.mArgs = objArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(Parcel parcel) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mArgs = parcel.readArray(Object.class.getClassLoader());
        this.mMessage = parcel.readString();
        this.mResourceId = parcel.readInt();
        this.mLevel = SkStatus.LogLevel.getEnumByValue(parcel.readInt());
        this.logtime = parcel.readLong();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(SkStatus.LogLevel logLevel, int i) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mResourceId = i;
        this.mLevel = logLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(SkStatus.LogLevel logLevel, int i, String str) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mLevel = logLevel;
        this.mMessage = str;
        this.mVerbosityLevel = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(SkStatus.LogLevel logLevel, int i, Object... objArr) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mLevel = logLevel;
        this.mResourceId = i;
        this.mArgs = objArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LogItem(SkStatus.LogLevel logLevel, String str) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mLevel = logLevel;
        this.mMessage = str;
    }
}
