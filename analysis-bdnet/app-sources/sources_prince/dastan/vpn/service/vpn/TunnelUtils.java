package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.util.ArrayMap;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TunnelUtils {
    public static Map<String, CharSequence> BBCODES_LIST;

    public static String formatCustomPayload(String str, int i, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        BBCODES_LIST = arrayMap;
        arrayMap.put("[method]", "CONNECT");
        BBCODES_LIST.put("[host]", str);
        BBCODES_LIST.put("[port]", Integer.toString(i));
        BBCODES_LIST.put("[host_port]", String.format("%s:%d", str, Integer.valueOf(i)));
        BBCODES_LIST.put("[protocol]", "HTTP/1.0");
        BBCODES_LIST.put("[ssh]", String.format("%s:%d", str, Integer.valueOf(i)));
        BBCODES_LIST.put("[crlf]", "\r\n");
        BBCODES_LIST.put("[cr]", "\r");
        BBCODES_LIST.put("[lf]", "\n");
        BBCODES_LIST.put("[lfcr]", "\n\r");
        BBCODES_LIST.put("\\n", "\n");
        BBCODES_LIST.put("\\r", "\r");
        String property = System.getProperty("http.agent");
        Map<String, CharSequence> map = BBCODES_LIST;
        if (property == null) {
            property = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36";
        }
        map.put("[ua]", property);
        if (str2.isEmpty()) {
            return str2;
        }
        Iterator<String> it = BBCODES_LIST.keySet().iterator();
        while (it.hasNext()) {
            String lowerCase = it.next().toLowerCase();
            str2 = str2.replace(lowerCase, BBCODES_LIST.get(lowerCase));
        }
        return parseRotate(str2);
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "No IP Available";
        } catch (SocketException unused) {
            return "ERROR Obtaining IP";
        }
    }

    private static boolean injectSimpleSplit(String str, OutputStream outputStream) {
        if (!str.contains("[split]")) {
            return false;
        }
        String[] split = str.split(Pattern.quote("[split]"));
        for (int i = 0; i < split.length; i++) {
            try {
                outputStream.write(split[i].getBytes("ISO-8859-1"));
            } catch (UnsupportedEncodingException unused) {
                outputStream.write(split[i].getBytes());
            }
            outputStream.flush();
        }
        return true;
    }

    public static boolean injectSplitPayload(String str, OutputStream outputStream) {
        if (!str.contains("[delay_split]")) {
            return injectSimpleSplit(str, outputStream);
        }
        String[] split = str.split(Pattern.quote("[delay_split]"));
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i];
            if (!injectSimpleSplit(str2, outputStream)) {
                try {
                    outputStream.write(str2.getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException unused) {
                    outputStream.write(str2.getBytes());
                }
                outputStream.flush();
            }
            try {
                if (i != split.length - 1) {
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException unused2) {
            }
        }
        return true;
    }

    public static boolean isActiveVpn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasTransport(4);
    }

    public static boolean isNetworkOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static String parseRotate(String str) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str);
        int indexOf2 = sb.indexOf("[rotate=");
        while (indexOf2 != -1 && (indexOf = sb.indexOf("]", indexOf2)) != -1) {
            String[] split = sb.substring(indexOf2 + 8, indexOf).split(";");
            if (split.length == 0) {
                indexOf2 = sb.indexOf("[rotate=", indexOf);
            } else {
                String selectRandomURL = selectRandomURL(split);
                sb.replace(indexOf2, indexOf + 1, selectRandomURL);
                indexOf2 = sb.indexOf("[rotate=", selectRandomURL.length() + indexOf2);
            }
        }
        return sb.toString();
    }

    public static String selectRandomURL(String[] strArr) {
        return strArr[new Random().nextInt(strArr.length)];
    }
}
