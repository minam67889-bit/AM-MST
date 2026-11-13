package com.wireguard.android.backend;

import com.liapp.y;
import com.wireguard.util.NonNullForAll;
import java.util.regex.Pattern;

@NonNullForAll
/* loaded from: classes.dex */
public interface Tunnel {
    public static final int NAME_MAX_LENGTH = 15;
    public static final Pattern NAME_PATTERN = Pattern.compile(y.گ֮۬۲ݮ(2086588891));

    public enum State {
        DOWN,
        TOGGLE,
        UP;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static State of(boolean z) {
            return z ? UP : DOWN;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isNameInvalid(CharSequence charSequence) {
        return !NAME_PATTERN.matcher(charSequence).matches();
    }

    String getName();

    void onStateChange(State state);
}
