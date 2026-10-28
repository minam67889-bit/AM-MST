package prince.dastan.vpn.service.vpn.logger;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Locale;
import java.util.UnknownFormatConversionException;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class LogItem implements Parcelable {
    public static final Parcelable.Creator<LogItem> CREATOR = new Parcelable.Creator<LogItem>() { // from class: prince.dastan.vpn.service.vpn.logger.LogItem.1
        @Override // android.os.Parcelable.Creator
        public LogItem createFromParcel(Parcel parcel) {
            return new LogItem(parcel);
        }

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

    public LogItem(int i, Object... objArr) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mResourceId = i;
        this.mArgs = objArr;
    }

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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SkStatus.LogLevel getLogLevel() {
        return this.mLevel;
    }

    public long getLogtime() {
        return this.logtime;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getString(Context context) {
        try {
            String str = this.mMessage;
            if (str != null) {
                return str;
            }
            if (context != null) {
                Object[] objArr = this.mArgs;
                return objArr == null ? context.getString(this.mResourceId) : context.getString(this.mResourceId, objArr);
            }
            Locale locale = Locale.ENGLISH;
            String str2 = "Log (no context) resid " + this.mResourceId;
            if (this.mArgs == null) {
                return str2;
            }
            return str2 + join("|", this.mArgs);
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

    public int getVerbosityLevel() {
        int i = this.mVerbosityLevel;
        return i == -1 ? this.mLevel.getInt() : i;
    }

    public String toString() {
        return getString(null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.mArgs);
        parcel.writeString(this.mMessage);
        parcel.writeInt(this.mResourceId);
        parcel.writeInt(this.mLevel.getInt());
        parcel.writeLong(this.logtime);
    }

    public LogItem(SkStatus.LogLevel logLevel, int i, String str) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mLevel = logLevel;
        this.mMessage = str;
        this.mVerbosityLevel = i;
    }

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

    public LogItem(SkStatus.LogLevel logLevel, String str) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mLevel = logLevel;
        this.mMessage = str;
    }

    public LogItem(SkStatus.LogLevel logLevel, int i) {
        this.mArgs = null;
        this.mMessage = null;
        this.mLevel = SkStatus.LogLevel.INFO;
        this.logtime = System.currentTimeMillis();
        this.mVerbosityLevel = -1;
        this.mResourceId = i;
        this.mLevel = logLevel;
    }

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
}
