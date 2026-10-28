package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import com.liapp.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class VpnUtils {
    private static final String DEFAULT_PRIMARY_DNS_SERVER = "8.8.8.8";
    private static final String DEFAULT_SECONDARY_DNS_SERVER = "1.1.0.0";
    private static final Pattern IPV4_PATTERN = Pattern.compile(y.ۮخݳ٬ۨ(1835888150));
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile(y.گ֮۬۲ݮ(2086323499));
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile(y.ܴٳݴܯޫ(-169938815));

    public static class PrivateAddress {
        public final String mIpAddress;
        public final int mPrefixLength;
        public final String mRouter;
        public final String mSubnet;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PrivateAddress(String str, String str2, int i, String str3) {
            this.mIpAddress = str;
            this.mSubnet = str2;
            this.mPrefixLength = i;
            this.mRouter = str3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int findAvailablePort(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (isPortAvailable(i3)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findProcessId(String str) {
        String[] strArr = {y.۳׭خ۲ݮ(1786931535), y.ܴ٭׮ڱܭ(-365988052), y.گ֮۬۲ݮ(2086328387)};
        int i = 0;
        while (i < 3) {
            Process exec = Runtime.getRuntime().exec(strArr[i]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains(y.ܴ٭׮ڱܭ(-365988284)) && readLine.contains(str)) {
                        String[] split = readLine.split("\\s+");
                        try {
                            try {
                                return Integer.parseInt(split[1]);
                            } finally {
                                try {
                                    exec.destroy();
                                } catch (Exception unused) {
                                }
                            }
                        } catch (NumberFormatException unused2) {
                            int parseInt = Integer.parseInt(split[0]);
                            try {
                                exec.destroy();
                            } catch (Exception unused3) {
                            }
                            return parseInt;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> getActiveNetworkDnsResolver(Context context) {
        Collection<InetAddress> activeNetworkDnsResolvers = getActiveNetworkDnsResolvers(context);
        if (activeNetworkDnsResolvers.isEmpty()) {
            throw new Exception(y.ܴٳݴܯޫ(-169939839));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<InetAddress> it = activeNetworkDnsResolvers.iterator();
        int i = 2;
        while (it.hasNext()) {
            String obj = it.next().toString();
            if (obj.startsWith(y.گ֮۬۲ݮ(2086642387))) {
                obj = obj.substring(1);
            }
            if (!obj.contains(y.ܴٳݴܯޫ(-170209159))) {
                arrayList.add(obj);
                i--;
                if (i <= 0) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Collection<InetAddress> getActiveNetworkDnsResolvers(Context context) {
        String str = y.۳׭خ۲ݮ(1786931943);
        ArrayList arrayList = new ArrayList();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Class.forName("android.net.LinkProperties");
            Object invoke = ConnectivityManager.class.getMethod("getActiveLinkProperties", null).invoke(connectivityManager, null);
            if (invoke != null) {
                Iterator<InetAddress> it = ((LinkProperties) invoke).getDnsServers().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        } catch (ClassNotFoundException e) {
            throw new Exception(str, e);
        } catch (IllegalAccessException e2) {
            throw new Exception(str, e2);
        } catch (IllegalArgumentException e3) {
            throw new Exception(str, e3);
        } catch (NoSuchMethodException e4) {
            throw new Exception(str, e4);
        } catch (NullPointerException e5) {
            throw new Exception(str, e5);
        } catch (InvocationTargetException e6) {
            throw new Exception(str, e6);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> getNetworkDnsServer(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            return getActiveNetworkDnsResolver(context);
        } catch (Exception unused) {
            arrayList.add(DEFAULT_PRIMARY_DNS_SERVER);
            arrayList.add(DEFAULT_SECONDARY_DNS_SERVER);
            return arrayList;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isIPv4Address(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isIPv6Address(String str) {
        return isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isIPv6HexCompressedAddress(String str) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(str).matches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isIPv6StdAddress(String str) {
        return IPV6_STD_PATTERN.matcher(str).matches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isPortAvailable(int i) {
        Socket socket = new Socket();
        try {
            try {
                try {
                    socket.connect(new InetSocketAddress(y.۳׭خ۲ݮ(1786932287), i), 1000);
                    try {
                        socket.close();
                    } catch (IOException unused) {
                    }
                    return false;
                } catch (IOException unused2) {
                    return false;
                }
            } catch (IOException unused3) {
                return true;
            }
        } catch (SocketTimeoutException unused4) {
            socket.close();
            return false;
        } catch (IOException unused5) {
            socket.close();
            return true;
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (IOException unused6) {
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PrivateAddress selectPrivateAddress() {
        HashMap hashMap = new HashMap();
        PrivateAddress privateAddress = new PrivateAddress(y.۳׭خ۲ݮ(1786932935), y.ܴ٭׮ڱܭ(-365989700), 8, y.׬ܮ֮ڱܭ(1520327192));
        String str = y.ڮڴجۭݩ(1256343117);
        hashMap.put(str, privateAddress);
        PrivateAddress privateAddress2 = new PrivateAddress(y.ܴ٭׮ڱܭ(-365985812), y.گ֮۬۲ݮ(2086326571), 12, y.ܴٳݴܯޫ(-169940255));
        String str2 = y.׬ܮ֮ڱܭ(1520325736);
        hashMap.put(str2, privateAddress2);
        PrivateAddress privateAddress3 = new PrivateAddress(y.ڮڴجۭݩ(1256343741), y.ܴ٭׮ڱܭ(-365986268), 16, y.ۮخݳ٬ۨ(1835892054));
        String str3 = y.ܴ٭׮ڱܭ(-365986356);
        hashMap.put(str3, privateAddress3);
        hashMap.put(y.ܴٳݴܯޫ(-169941311), new PrivateAddress(y.ܴٳݴܯޫ(-169941103), y.۳׭خ۲ݮ(1786929935), 24, y.گ֮۬۲ݮ(2086327091)));
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.startsWith(y.ܴ٭׮ڱܭ(-365986764))) {
                            hashMap.remove(str);
                        } else if (hostAddress.length() >= 6 && hostAddress.substring(0, 6).compareTo(y.׬ܮ֮ڱܭ(1520326488)) >= 0 && hostAddress.substring(0, 6).compareTo(y.ڮڴجۭݩ(1256345085)) <= 0) {
                            hashMap.remove(str2);
                        } else if (hostAddress.startsWith(y.׬ܮ֮ڱܭ(1520324824))) {
                            hashMap.remove(str3);
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                return (PrivateAddress) hashMap.values().iterator().next();
            }
            throw new Exception(y.׬ܮ֮ڱܭ(1520324608));
        } catch (SocketException e) {
            e.printStackTrace();
            throw new Exception(y.ش۳ֲ׬٨(1672171098), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int killProcess(File file, String str) {
        String str2 = y.ۮخݳ٬ۨ(1835629062);
        String str3 = y.ܴٳݴܯޫ(-169940735);
        int i = 0;
        do {
            int findProcessId = findProcessId(file.getName());
            if (findProcessId == -1) {
                return findProcessId;
            }
            i++;
            String valueOf = String.valueOf(findProcessId);
            String[] strArr = {"", y.ش۳ֲ׬٨(1672169298), y.گ֮۬۲ݮ(2086329771)};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    Runtime.getRuntime().exec(strArr[i2] + str3 + str + str2 + file.getName());
                } catch (IOException unused) {
                }
                try {
                    Runtime.getRuntime().exec(strArr[i2] + str3 + str + str2 + file.getCanonicalPath());
                } catch (IOException unused2) {
                }
            }
            killProcess(valueOf, str);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused3) {
            }
        } while (i <= 4);
        throw new Exception(y.ش۳ֲ׬٨(1672169138) + file.getAbsolutePath());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void killProcess(File file) {
        killProcess(file, y.׬ܮ֮ڱܭ(1520327024));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void killProcess(String str, String str2) {
        String[] strArr = {"", y.گ֮۬۲ݮ(2086329771), y.ش۳ֲ׬٨(1672169298)};
        for (int i = 0; i < 3; i++) {
            try {
                Runtime.getRuntime().exec(strArr[i] + "kill " + str2 + " " + str);
            } catch (IOException e) {
                SkStatus.logDebug(y.ܴ٭׮ڱܭ(-365989356) + str + y.گ֮۬۲ݮ(2086592147) + e.getMessage());
            }
        }
    }
}
