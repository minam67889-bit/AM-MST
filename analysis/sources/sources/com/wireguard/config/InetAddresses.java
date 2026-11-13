package com.wireguard.config;

import android.os.Build;
import com.liapp.y;
import com.wireguard.util.NonNullForAll;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

@NonNullForAll
/* loaded from: classes.dex */
public final class InetAddresses {
    private static final Method PARSER_METHOD;
    private static final Pattern WONT_TOUCH_RESOLVER = Pattern.compile(y.۳׭خ۲ݮ(1787174015));
    private static final Pattern VALID_HOSTNAME = Pattern.compile(y.۳׭خ۲ݮ(1787228407));

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Method method = null;
        try {
            if (Build.VERSION.SDK_INT < 29) {
                method = InetAddress.class.getMethod("parseNumericAddress", String.class);
            }
        } catch (Exception unused) {
        }
        PARSER_METHOD = method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InetAddresses() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isHostname(CharSequence charSequence) {
        return VALID_HOSTNAME.matcher(charSequence).matches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InetAddress parse(String str) {
        InetAddress parseNumericAddress;
        if (str.isEmpty()) {
            throw new ParseException((Class<?>) InetAddress.class, str, y.ܴ٭׮ڱܭ(-366220492));
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                parseNumericAddress = android.net.InetAddresses.parseNumericAddress(str);
                return parseNumericAddress;
            }
            Method method = PARSER_METHOD;
            if (method != null) {
                return (InetAddress) method.invoke(null, str);
            }
            throw new NoSuchMethodException("parseNumericAddress");
        } catch (IllegalArgumentException e) {
            throw new ParseException((Class<?>) InetAddress.class, str, e);
        } catch (Exception e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IllegalArgumentException) {
                throw new ParseException((Class<?>) InetAddress.class, str, cause);
            }
            try {
                if (WONT_TOUCH_RESOLVER.matcher(str).matches()) {
                    return InetAddress.getByName(str);
                }
                throw new ParseException((Class<?>) InetAddress.class, str, "Not an IP address");
            } catch (UnknownHostException e3) {
                throw new ParseException((Class<?>) InetAddress.class, str, e3);
            }
        }
    }
}
