package prince.udp.vpn.service.vpn.logger;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import defpackage.AbstractC4575vQ;
import defpackage.T60;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Vector;

/* loaded from: classes2.dex */
public class SkStatus {
    static final int MAXLOGENTRIES = 1000;
    public static final String SSH_AUTHENTICATING = "AUTHENTICATING";
    public static final String SSH_CONNECTED = "CONNECTED";
    public static final String SSH_CONNECTING = "CONNECTING";
    public static final String SSH_DISCONNECTED = "DISCONNECTED";
    public static final String SSH_RECONECTANDO = "RECONECTANDO";
    public static final String SSH_STARTING = "STARTING";
    public static final String SSH_STOPPING = "STOPPING";
    public static final String SSH_WAITING = "WAITING";
    private static ConnectionStatus mLastLevel = ConnectionStatus.LEVEL_NOTCONNECTED;
    private static String mLaststatemsg = "";
    private static String mLaststate = y.ܴٳݴܯޫ(-169944127);
    private static int mLastStateresid = R.string.state_noprocess;
    private static Intent mLastIntent = null;
    private static final LinkedList<LogItem> logbuffer = new LinkedList<>();
    private static Vector<LogListener> logListener = new Vector<>();
    private static Vector<StateListener> stateListener = new Vector<>();

    /* renamed from: prince.udp.vpn.service.vpn.logger.SkStatus$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$prince$udp$vpn$service$vpn$logger$ConnectionStatus;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[ConnectionStatus.values().length];
            $SwitchMap$prince$udp$vpn$service$vpn$logger$ConnectionStatus = iArr;
            try {
                iArr[ConnectionStatus.LEVEL_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum LogLevel {
        INFO(2),
        ERROR(-2),
        WARNING(1),
        VERBOSE(3),
        DEBUG(4);

        protected int mValue;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LogLevel(int i) {
            this.mValue = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LogLevel getEnumByValue(int i) {
            if (i == -2) {
                return ERROR;
            }
            if (i == 1) {
                return WARNING;
            }
            if (i == 2) {
                return INFO;
            }
            if (i == 3) {
                return VERBOSE;
            }
            if (i != 4) {
                return null;
            }
            return DEBUG;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getInt() {
            return this.mValue;
        }
    }

    public interface LogListener {
        void newLog(LogItem logItem);

        void onClear();
    }

    public interface StateListener {
        void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        logInformation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void addLogListener(LogListener logListener2) {
        synchronized (SkStatus.class) {
            if (!logListener.contains(logListener2)) {
                logListener.add(logListener2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void addStateListener(StateListener stateListener2) {
        synchronized (SkStatus.class) {
            if (!stateListener.contains(stateListener2)) {
                stateListener.add(stateListener2);
                String str = mLaststate;
                if (str != null) {
                    stateListener2.updateState(str, mLaststatemsg, mLastStateresid, mLastLevel, mLastIntent);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void clearLog() {
        synchronized (SkStatus.class) {
            logbuffer.clear();
            logInformation();
            logInfo(R.string.clear_logs, new Object[0]);
            Iterator<LogListener> it = logListener.iterator();
            while (it.hasNext()) {
                it.next().onClear();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getLastState() {
        return mLaststate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ConnectionStatus getLevel(String str) {
        String[] strArr = {y.۳׭خ۲ݮ(1786929055), y.ܴٳݴܯޫ(-169944407), y.ܴٳݴܯޫ(-170325831), y.گ֮۬۲ݮ(2086485411), y.ܴ٭׮ڱܭ(-366001916), y.ش۳ֲ׬٨(1672180930)};
        String[] strArr2 = {y.ܴ٭׮ڱܭ(-365998372), y.׬ܮ֮ڱܭ(1520330008), y.گ֮۬۲ݮ(2086331227), y.ۮخݳ٬ۨ(1835879990), y.۳׭خ۲ݮ(1786925167), y.ܴ٭׮ڱܭ(-365998284)};
        String[] strArr3 = {y.ش۳ֲ׬٨(1672263594)};
        String[] strArr4 = {y.ۮخݳ٬ۨ(1835700438)};
        for (int i = 0; i < 6; i++) {
            if (str.equals(strArr[i])) {
                return ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET;
            }
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (str.equals(strArr2[i2])) {
                return ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED;
            }
        }
        return str.equals(strArr3[0]) ? ConnectionStatus.LEVEL_CONNECTED : str.equals(strArr4[0]) ? ConnectionStatus.LEVEL_NOTCONNECTED : ConnectionStatus.UNKNOWN_LEVEL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLocalizedState(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2087582999:
                if (str.equals(y.ش۳ֲ׬٨(1672263594))) {
                    c = 0;
                    break;
                }
                break;
            case -1796691852:
                if (str.equals(y.ۮخݳ٬ۨ(1835704246))) {
                    c = 1;
                    break;
                }
                break;
            case -1750284718:
                if (str.equals(y.ܴ٭׮ڱܭ(-365998372))) {
                    c = 2;
                    break;
                }
                break;
            case -1465988929:
                if (str.equals(y.گ֮۬۲ݮ(2086485411))) {
                    c = 3;
                    break;
                }
                break;
            case -1366796965:
                if (str.equals(y.ڮڴجۭݩ(1256356629))) {
                    c = 4;
                    break;
                }
                break;
            case -837916192:
                if (str.equals(y.۳׭خ۲ݮ(1786925167))) {
                    c = 5;
                    break;
                }
                break;
            case -453674901:
                if (str.equals(y.׬ܮ֮ڱܭ(1520330008))) {
                    c = 6;
                    break;
                }
                break;
            case -290559304:
                if (str.equals(y.ܴٳݴܯޫ(-169944407))) {
                    c = 7;
                    break;
                }
                break;
            case -89776521:
                if (str.equals(y.گ֮۬۲ݮ(2086331227))) {
                    c = '\b';
                    break;
                }
                break;
            case 263560780:
                if (str.equals(y.ش۳ֲ׬٨(1672180930))) {
                    c = '\t';
                    break;
                }
                break;
            case 847358152:
                if (str.equals(y.ۮخݳ٬ۨ(1835879990))) {
                    c = '\n';
                    break;
                }
                break;
            case 935892539:
                if (str.equals(y.ۮخݳ٬ۨ(1835700438))) {
                    c = 11;
                    break;
                }
                break;
            case 1815350732:
                if (str.equals(y.ܴ٭׮ڱܭ(-366001916))) {
                    c = '\f';
                    break;
                }
                break;
            case 1834295853:
                if (str.equals(y.ܴٳݴܯޫ(-170325831))) {
                    c = '\r';
                    break;
                }
                break;
            case 2099433536:
                if (str.equals(y.۳׭خ۲ݮ(1786929055))) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return R.string.state_connected;
            case 1:
                return R.string.state_stopping;
            case 2:
                return R.string.state_auth;
            case 3:
                return R.string.state_reconnecting;
            case 4:
                return R.string.state_finalizing;
            case 5:
                return R.string.state_auth_pending;
            case 6:
                return R.string.state_get_config;
            case 7:
                return R.string.state_connecting;
            case '\b':
                return R.string.state_assign_ip;
            case '\t':
                return R.string.state_tcp_connect;
            case '\n':
                return R.string.state_add_routes;
            case 11:
                return R.string.state_disconnected;
            case '\f':
                return R.string.state_resolve;
            case '\r':
                return R.string.state_nonetwork;
            case 14:
                return R.string.connecting;
            default:
                return R.string.unknown_state;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized LogItem[] getlogbuffer() {
        LogItem[] logItemArr;
        synchronized (SkStatus.class) {
            LinkedList<LogItem> linkedList = logbuffer;
            logItemArr = (LogItem[]) linkedList.toArray(new LogItem[linkedList.size()]);
        }
        return logItemArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isTunnelActive() {
        return (mLastLevel == ConnectionStatus.LEVEL_AUTH_FAILED || mLastLevel == ConnectionStatus.LEVEL_NOTCONNECTED) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void logInformation() {
        logInfo(R.string.mobile_info, Build.MODEL, Build.BOARD, Build.BRAND, Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void removeLogListener(LogListener logListener2) {
        synchronized (SkStatus.class) {
            if (logListener.contains(logListener2)) {
                logListener.remove(logListener2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void removeStateListener(StateListener stateListener2) {
        synchronized (SkStatus.class) {
            if (stateListener.contains(stateListener2)) {
                stateListener.remove(stateListener2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getLastCleanLogMessage(Context context) {
        String str = mLaststatemsg;
        int i = AnonymousClass1.$SwitchMap$prince$udp$vpn$service$vpn$logger$ConnectionStatus[mLastLevel.ordinal()];
        String str2 = y.ش۳ֲ׬٨(1672455554);
        if (i == 1) {
            String[] split = mLaststatemsg.split(str2);
            if (split.length >= 7) {
                Locale locale = Locale.US;
                str = AbstractC4575vQ.s(split[1], y.ۮخݳ٬ۨ(1835629062), split[6]);
            }
        }
        while (str.endsWith(str2)) {
            str = str.substring(0, str.length() - 1);
        }
        String str3 = mLaststate;
        if (str3.equals(y.ܴٳݴܯޫ(-169944127))) {
            return str;
        }
        int i2 = mLastStateresid;
        if (i2 == R.string.state_waitconnectretry) {
            return context.getString(R.string.state_waitconnectretry, mLaststatemsg);
        }
        String string = context.getString(i2);
        if (mLastStateresid == R.string.unknown_state) {
            str = str3.concat(str);
        }
        if (str.length() > 0) {
            string = AbstractC4575vQ.D(string, y.ڮڴجۭݩ(1256699333));
        }
        return AbstractC4575vQ.D(string, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logDebug(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.DEBUG, i, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logError(int i) {
        newLogItem(new LogItem(LogLevel.ERROR, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logException(Exception exc) {
        logException(LogLevel.ERROR, null, exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logInfo(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.INFO, i, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logWarning(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.WARNING, i, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void newLogItem(LogItem logItem) {
        newLogItem(logItem, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void updateStateString(String str, String str2) {
        updateStateString(str, str2, getLocalizedState(str), getLevel(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logDebug(String str) {
        newLogItem(new LogItem(LogLevel.DEBUG, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logError(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.ERROR, i, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logException(String str, Exception exc) {
        logException(LogLevel.ERROR, str, exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logInfo(String str) {
        newLogItem(new LogItem(LogLevel.INFO, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logWarning(String str) {
        newLogItem(new LogItem(LogLevel.WARNING, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void newLogItem(LogItem logItem, boolean z) {
        synchronized (SkStatus.class) {
            try {
                if (z) {
                    logbuffer.addFirst(logItem);
                } else {
                    logbuffer.addLast(logItem);
                }
                if (logbuffer.size() > 1500) {
                    while (true) {
                        LinkedList<LogItem> linkedList = logbuffer;
                        if (linkedList.size() <= 1000) {
                            break;
                        } else {
                            linkedList.removeFirst();
                        }
                    }
                }
                Iterator<LogListener> it = logListener.iterator();
                while (it.hasNext()) {
                    it.next().newLog(logItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void updateStateString(String str, String str2, int i, ConnectionStatus connectionStatus) {
        synchronized (SkStatus.class) {
            updateStateString(str, str2, i, connectionStatus, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logError(String str) {
        newLogItem(new LogItem(LogLevel.ERROR, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logException(LogLevel logLevel, String str, Exception exc) {
        LogItem logItem;
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String str2 = y.گ֮۬۲ݮ(2086592147);
        if (str != null) {
            logItem = new LogItem(logLevel, str + ": " + exc.getMessage() + str2 + stringWriter.toString());
        } else {
            logItem = new LogItem(logLevel, T60.x(y.گ֮۬۲ݮ(2086330995), exc.getMessage(), str2, stringWriter.toString()));
        }
        newLogItem(logItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void updateStateString(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        String str3 = y.گ֮۬۲ݮ(2086330931);
        synchronized (SkStatus.class) {
            if (mLastLevel != ConnectionStatus.LEVEL_CONNECTED || !str.equals(SSH_AUTHENTICATING)) {
                mLaststate = str;
                mLaststatemsg = str2;
                mLastStateresid = i;
                mLastLevel = connectionStatus;
                mLastIntent = intent;
                Iterator<StateListener> it = stateListener.iterator();
                while (it.hasNext()) {
                    it.next().updateState(str, str2, i, connectionStatus, intent);
                }
                return;
            }
            newLogItem(new LogItem(LogLevel.DEBUG, str3 + str + "->" + connectionStatus.toString() + "): " + str2));
        }
    }
}
