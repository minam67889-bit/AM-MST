package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
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
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class VpnUtils {
    private static final String DEFAULT_PRIMARY_DNS_SERVER = "8.8.8.8";
    private static final String DEFAULT_SECONDARY_DNS_SERVER = "1.1.0.0";
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static class PrivateAddress {
        public final String mIpAddress;
        public final int mPrefixLength;
        public final String mRouter;
        public final String mSubnet;

        public PrivateAddress(String str, String str2, int i, String str3) {
            this.mIpAddress = str;
            this.mSubnet = str2;
            this.mPrefixLength = i;
            this.mRouter = str3;
        }
    }

    public static int findAvailablePort(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (isPortAvailable(i3)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findProcessId(String str) {
        String[] strArr = {"ps -ef", "ps -A", "toolbox ps"};
        int i = 0;
        while (i < 3) {
            Process exec = Runtime.getRuntime().exec(strArr[i]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains("PID") && readLine.contains(str)) {
                        String[] split = readLine.split("\\s+");
                        try {
                            try {
                                return Integer.parseInt(split[1]);
                            } catch (NumberFormatException unused) {
                                int parseInt = Integer.parseInt(split[0]);
                                try {
                                    exec.destroy();
                                } catch (Exception unused2) {
                                }
                                return parseInt;
                            }
                        } finally {
                            try {
                                exec.destroy();
                            } catch (Exception unused3) {
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static List<String> getActiveNetworkDnsResolver(Context context) {
        Collection<InetAddress> activeNetworkDnsResolvers = getActiveNetworkDnsResolvers(context);
        if (activeNetworkDnsResolvers.isEmpty()) {
            throw new Exception("no active network DNS resolver");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<InetAddress> it = activeNetworkDnsResolvers.iterator();
        int i = 2;
        while (it.hasNext()) {
            String obj = it.next().toString();
            if (obj.startsWith("/")) {
                obj = obj.substring(1);
            }
            if (!obj.contains(":")) {
                arrayList.add(obj);
                i--;
                if (i <= 0) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private static Collection<InetAddress> getActiveNetworkDnsResolvers(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Class.forName("android.net.LinkProperties");
            Object invoke = ConnectivityManager.class.getMethod("getActiveLinkProperties", new Class[0]).invoke(connectivityManager, new Object[0]);
            if (invoke != null) {
                Iterator<InetAddress> it = ((LinkProperties) invoke).getDnsServers().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            return arrayList;
        } catch (ClassNotFoundException e) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e);
        } catch (IllegalAccessException e2) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e2);
        } catch (IllegalArgumentException e3) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e3);
        } catch (NoSuchMethodException e4) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e4);
        } catch (NullPointerException e5) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e5);
        } catch (InvocationTargetException e6) {
            throw new Exception("getActiveNetworkDnsResolvers failed", e6);
        }
    }

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

    public static boolean isIPv4Address(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6Address(String str) {
        return isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str);
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6StdAddress(String str) {
        return IPV6_STD_PATTERN.matcher(str).matches();
    }

    private static boolean isPortAvailable(int i) {
        Socket socket = new Socket();
        try {
            try {
                try {
                    socket.connect(new InetSocketAddress("127.0.0.1", i), 1000);
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

    public static void killProcess(File file) {
        killProcess(file, "-9");
    }

    public static PrivateAddress selectPrivateAddress() {
        HashMap hashMap = new HashMap();
        hashMap.put("10", new PrivateAddress("10.0.0.1", "10.0.0.0", 8, "10.0.0.2"));
        hashMap.put("172", new PrivateAddress("172.16.0.1", "172.16.0.0", 12, "172.16.0.2"));
        hashMap.put("192", new PrivateAddress("192.168.0.1", "192.168.0.0", 16, "192.168.0.2"));
        hashMap.put("169", new PrivateAddress("169.254.1.1", "169.254.1.0", 24, "169.254.1.2"));
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.startsWith("10.")) {
                            hashMap.remove("10");
                        } else if (hostAddress.length() >= 6 && hostAddress.substring(0, 6).compareTo("172.16") >= 0 && hostAddress.substring(0, 6).compareTo("172.31") <= 0) {
                            hashMap.remove("172");
                        } else if (hostAddress.startsWith("192.168")) {
                            hashMap.remove("192");
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                return (PrivateAddress) hashMap.values().iterator().next();
            }
            throw new Exception("no private address available");
        } catch (SocketException e) {
            e.printStackTrace();
            throw new Exception("selectPrivateAddress failed", e);
        }
    }

    public static int killProcess(File file, String str) {
        int i = 0;
        do {
            int findProcessId = findProcessId(file.getName());
            if (findProcessId == -1) {
                return findProcessId;
            }
            i++;
            String valueOf = String.valueOf(findProcessId);
            String[] strArr = {"", "busybox ", "toolbox "};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    Runtime.getRuntime().exec(strArr[i2] + "killall " + str + " " + file.getName());
                } catch (IOException unused) {
                }
                try {
                    Runtime.getRuntime().exec(strArr[i2] + "killall " + str + " " + file.getCanonicalPath());
                } catch (IOException unused2) {
                }
            }
            killProcess(valueOf, str);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused3) {
            }
        } while (i <= 4);
        throw new Exception("Cannot kill: " + file.getAbsolutePath());
    }

    public static void killProcess(String str, String str2) {
        String[] strArr = {"", "toolbox ", "busybox "};
        for (int i = 0; i < 3; i++) {
            try {
                Runtime.getRuntime().exec(strArr[i] + "kill " + str2 + " " + str);
            } catch (IOException e) {
                SkStatus.logDebug("error killing process: " + str + ", " + e.getMessage());
            }
        }
    }
}
