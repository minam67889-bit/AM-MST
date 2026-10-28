package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.util.ArrayMap;
import com.liapp.y;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TunnelUtils {
    public static Map<String, CharSequence> BBCODES_LIST;
    private static Map<Integer, Integer> lastRotateList = new ArrayMap();
    private static String lastPayload = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatCustomPayload(String str, int i, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        BBCODES_LIST = arrayMap;
        arrayMap.put(y.۳׭خ۲ݮ(1787134991), y.ڮڴجۭݩ(1256566101));
        BBCODES_LIST.put(y.׬ܮ֮ڱܭ(1520021624), str);
        BBCODES_LIST.put(y.ۮخݳ٬ۨ(1835702622), Integer.toString(i));
        Map<String, CharSequence> map = BBCODES_LIST;
        Object[] objArr = {str, Integer.valueOf(i)};
        String str3 = y.׬ܮ֮ڱܭ(1520022008);
        map.put(y.ڮڴجۭݩ(1256565845), String.format(str3, objArr));
        BBCODES_LIST.put(y.׬ܮ֮ڱܭ(1520021848), y.گ֮۬۲ݮ(2086483739));
        BBCODES_LIST.put("[ssh]", String.format(str3, str, Integer.valueOf(i)));
        BBCODES_LIST.put("[crlf]", y.ڮڴجۭݩ(1256717501));
        Map<String, CharSequence> map2 = BBCODES_LIST;
        String str4 = y.ڮڴجۭݩ(1256502285);
        map2.put("[cr]", str4);
        Map<String, CharSequence> map3 = BBCODES_LIST;
        String str5 = y.ڮڴجۭݩ(1256649469);
        map3.put("[lf]", str5);
        BBCODES_LIST.put("[lfcr]", y.׬ܮ֮ڱܭ(1520022056));
        BBCODES_LIST.put("\\n", str5);
        BBCODES_LIST.put("\\r", str4);
        String property = System.getProperty("http.agent");
        Map<String, CharSequence> map4 = BBCODES_LIST;
        if (property == null) {
            property = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36";
        }
        map4.put(y.ش۳ֲ׬٨(1672260930), property);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
            return y.ܴ٭׮ڱܭ(-366438116);
        } catch (SocketException unused) {
            return y.ܴٳݴܯޫ(-170327511);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean injectSimpleSplit(String str, OutputStream outputStream) {
        String str2 = y.ۮخݳ٬ۨ(1835885638);
        if (!str.contains(str2)) {
            return false;
        }
        String[] split = str.split(Pattern.quote(str2));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean injectSplitPayload(String str, OutputStream outputStream) {
        String str2 = y.׬ܮ֮ڱܭ(1520323816);
        if (!str.contains(str2)) {
            return injectSimpleSplit(str, outputStream);
        }
        String[] split = str.split(Pattern.quote(str2));
        for (int i = 0; i < split.length; i++) {
            String str3 = split[i];
            if (!injectSimpleSplit(str3, outputStream)) {
                try {
                    outputStream.write(str3.getBytes("ISO-8859-1"));
                } catch (UnsupportedEncodingException unused) {
                    outputStream.write(str3.getBytes());
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isActiveVpn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(y.ۮخݳ٬ۨ(1835582446));
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasTransport(4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isNetworkOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(y.ۮخݳ٬ۨ(1835582446))).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String parseRotate(String str) {
        int i;
        Matcher matcher = Pattern.compile(y.ۮخݳ٬ۨ(1835885702)).matcher(str);
        if (!lastPayload.equals(str)) {
            lastRotateList.clear();
            lastPayload = str;
        }
        int i2 = 0;
        while (matcher.find()) {
            String[] split = matcher.group(1).split(y.ܴٳݴܯޫ(-170202591));
            if (split.length > 0) {
                if (!lastRotateList.containsKey(Integer.valueOf(i2)) || (i = lastRotateList.get(Integer.valueOf(i2)).intValue() + 1) >= split.length) {
                    i = 0;
                }
                str = str.replace(matcher.group(0), split[i]);
                lastRotateList.put(Integer.valueOf(i2), Integer.valueOf(i));
                i2++;
            }
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void restartRotate() {
        lastRotateList.clear();
    }
}
