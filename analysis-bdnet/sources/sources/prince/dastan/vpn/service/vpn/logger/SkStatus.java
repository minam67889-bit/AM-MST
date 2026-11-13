package prince.dastan.vpn.service.vpn.logger;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import dastan.prince.bdfreevpn.R;
import defpackage.W50;
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
    private static String mLaststate = "NOPROCESS";
    private static int mLastStateresid = R.string.state_noprocess;
    private static Intent mLastIntent = null;
    private static final LinkedList<LogItem> logbuffer = new LinkedList<>();
    private static Vector<LogListener> logListener = new Vector<>();
    private static Vector<StateListener> stateListener = new Vector<>();

    /* renamed from: prince.dastan.vpn.service.vpn.logger.SkStatus$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$prince$dastan$vpn$service$vpn$logger$ConnectionStatus;

        static {
            int[] iArr = new int[ConnectionStatus.values().length];
            $SwitchMap$prince$dastan$vpn$service$vpn$logger$ConnectionStatus = iArr;
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

        LogLevel(int i) {
            this.mValue = i;
        }

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

    static {
        logInformation();
    }

    public static synchronized void addLogListener(LogListener logListener2) {
        synchronized (SkStatus.class) {
            if (!logListener.contains(logListener2)) {
                logListener.add(logListener2);
            }
        }
    }

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

    public static String getLastCleanLogMessage(Context context) {
        String str = mLaststatemsg;
        if (AnonymousClass1.$SwitchMap$prince$dastan$vpn$service$vpn$logger$ConnectionStatus[mLastLevel.ordinal()] == 1) {
            String[] split = mLaststatemsg.split(",");
            if (split.length >= 7) {
                Locale locale = Locale.US;
                str = W50.n(split[1], " ", split[6]);
            }
        }
        while (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        String str2 = mLaststate;
        if (str2.equals("NOPROCESS")) {
            return str;
        }
        int i = mLastStateresid;
        if (i == R.string.state_waitconnectretry) {
            return context.getString(R.string.state_waitconnectretry, mLaststatemsg);
        }
        String string = context.getString(i);
        if (mLastStateresid == R.string.unknown_state) {
            str = str2.concat(str);
        }
        if (str.length() > 0) {
            string = W50.C(string, ": ");
        }
        return W50.C(string, str);
    }

    public static String getLastState() {
        return mLaststate;
    }

    private static ConnectionStatus getLevel(String str) {
        String[] strArr = {SSH_STARTING, SSH_CONNECTING, SSH_WAITING, SSH_RECONECTANDO, "RESOLVE", "TCP_CONNECT"};
        String[] strArr2 = {SSH_AUTHENTICATING, "GET_CONFIG", "ASSIGN_IP", "ADD_ROUTES", "AUTH_PENDING"};
        String[] strArr3 = {SSH_CONNECTED};
        String[] strArr4 = {SSH_DISCONNECTED};
        for (int i = 0; i < 6; i++) {
            if (str.equals(strArr[i])) {
                return ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET;
            }
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (str.equals(strArr2[i2])) {
                return ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED;
            }
        }
        return str.equals(strArr3[0]) ? ConnectionStatus.LEVEL_CONNECTED : str.equals(strArr4[0]) ? ConnectionStatus.LEVEL_NOTCONNECTED : ConnectionStatus.UNKNOWN_LEVEL;
    }

    public static int getLocalizedState(String str) {
        str.getClass();
        switch (str) {
            case "CONNECTED":
                return R.string.state_connected;
            case "STOPPING":
                return R.string.state_stopping;
            case "AUTHENTICATING":
                return R.string.state_auth;
            case "RECONECTANDO":
                return R.string.state_reconnecting;
            case "AUTH_PENDING":
                return R.string.state_auth_pending;
            case "GET_CONFIG":
                return R.string.state_get_config;
            case "CONNECTING":
                return R.string.state_connecting;
            case "ASSIGN_IP":
                return R.string.state_assign_ip;
            case "TCP_CONNECT":
                return R.string.state_tcp_connect;
            case "ADD_ROUTES":
                return R.string.state_add_routes;
            case "DISCONNECTED":
                return R.string.state_disconnected;
            case "RESOLVE":
                return R.string.state_resolve;
            case "WAITING":
                return R.string.state_nonetwork;
            case "STARTING":
                return R.string.connecting;
            default:
                return R.string.unknown_state;
        }
    }

    public static synchronized LogItem[] getlogbuffer() {
        LogItem[] logItemArr;
        synchronized (SkStatus.class) {
            LinkedList<LogItem> linkedList = logbuffer;
            logItemArr = (LogItem[]) linkedList.toArray(new LogItem[linkedList.size()]);
        }
        return logItemArr;
    }

    public static boolean isTunnelActive() {
        return (mLastLevel == ConnectionStatus.LEVEL_AUTH_FAILED || mLastLevel == ConnectionStatus.LEVEL_NOTCONNECTED) ? false : true;
    }

    public static void logDebug(String str) {
        newLogItem(new LogItem(LogLevel.DEBUG, str));
    }

    public static void logError(String str) {
        newLogItem(new LogItem(LogLevel.ERROR, str));
    }

    public static void logException(String str, Exception exc) {
        logException(LogLevel.ERROR, str, exc);
    }

    public static void logInfo(String str) {
        newLogItem(new LogItem(LogLevel.INFO, str));
    }

    private static void logInformation() {
        logInfo(R.string.mobile_info, Build.MODEL, Build.BOARD, Build.BRAND, Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE);
    }

    public static void logWarning(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.WARNING, i, objArr));
    }

    public static void newLogItem(LogItem logItem) {
        newLogItem(logItem, false);
    }

    public static synchronized void removeLogListener(LogListener logListener2) {
        synchronized (SkStatus.class) {
            if (logListener.contains(logListener2)) {
                logListener.remove(logListener2);
            }
        }
    }

    public static synchronized void removeStateListener(StateListener stateListener2) {
        synchronized (SkStatus.class) {
            if (stateListener.contains(stateListener2)) {
                stateListener.remove(stateListener2);
            }
        }
    }

    public static void updateStateString(String str, String str2) {
        updateStateString(str, str2, getLocalizedState(str), getLevel(str));
    }

    public static void logDebug(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.DEBUG, i, objArr));
    }

    public static void logError(int i) {
        newLogItem(new LogItem(LogLevel.ERROR, i));
    }

    public static void logException(LogLevel logLevel, String str, Exception exc) {
        LogItem logItem;
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        if (str != null) {
            logItem = new LogItem(logLevel, str + ": " + exc.getMessage() + ", " + stringWriter.toString());
        } else {
            logItem = new LogItem(logLevel, W50.o("Erro: ", exc.getMessage(), ", ", stringWriter.toString()));
        }
        newLogItem(logItem);
    }

    public static void logInfo(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.INFO, i, objArr));
    }

    public static void logWarning(String str) {
        newLogItem(new LogItem(LogLevel.WARNING, str));
    }

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

    public static void logError(int i, Object... objArr) {
        newLogItem(new LogItem(LogLevel.ERROR, i, objArr));
    }

    public static synchronized void updateStateString(String str, String str2, int i, ConnectionStatus connectionStatus) {
        synchronized (SkStatus.class) {
            updateStateString(str, str2, i, connectionStatus, null);
        }
    }

    public static synchronized void updateStateString(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        synchronized (SkStatus.class) {
            if (mLastLevel == ConnectionStatus.LEVEL_CONNECTED && str.equals(SSH_AUTHENTICATING)) {
                newLogItem(new LogItem(LogLevel.DEBUG, "Ignoring SocksHttp Status in CONNECTED state (" + str + "->" + connectionStatus.toString() + "): " + str2));
                return;
            }
            mLaststate = str;
            mLaststatemsg = str2;
            mLastStateresid = i;
            mLastLevel = connectionStatus;
            mLastIntent = intent;
            Iterator<StateListener> it = stateListener.iterator();
            while (it.hasNext()) {
                String str3 = str;
                String str4 = str2;
                int i2 = i;
                ConnectionStatus connectionStatus2 = connectionStatus;
                Intent intent2 = intent;
                it.next().updateState(str3, str4, i2, connectionStatus2, intent2);
                str = str3;
                str2 = str4;
                i = i2;
                connectionStatus = connectionStatus2;
                intent = intent2;
            }
        }
    }

    public static void logException(Exception exc) {
        logException(LogLevel.ERROR, null, exc);
    }
}
