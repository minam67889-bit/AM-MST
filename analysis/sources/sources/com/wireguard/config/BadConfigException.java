package com.wireguard.config;

import com.liapp.y;
import com.wireguard.crypto.KeyFormatException;
import com.wireguard.util.NonNullForAll;

@NonNullForAll
/* loaded from: classes.dex */
public class BadConfigException extends Exception {
    private final Location location;
    private final Reason reason;
    private final Section section;
    private final CharSequence text;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DNS' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class Location {
        private static final /* synthetic */ Location[] $VALUES;
        public static final Location DNS;
        public static final Location ENDPOINT;
        public static final Location EXCLUDED_APPLICATIONS;
        public static final Location INCLUDED_APPLICATIONS;
        public static final Location LISTEN_PORT;
        public static final Location MTU;
        public static final Location PERSISTENT_KEEPALIVE;
        public static final Location PRE_SHARED_KEY;
        public static final Location PRIVATE_KEY;
        public static final Location PUBLIC_KEY;
        private final String name;
        public static final Location TOP_LEVEL = new Location(y.۳׭خ۲ݮ(1787177103), 0, "");
        public static final Location ADDRESS = new Location(y.ڮڴجۭݩ(1256587397), 1, y.ش۳ֲ׬٨(1672413938));
        public static final Location ALLOWED_IPS = new Location(y.ڮڴجۭݩ(1256587309), 2, y.ܴٳݴܯޫ(-170218303));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static /* synthetic */ Location[] $values() {
            return new Location[]{TOP_LEVEL, ADDRESS, ALLOWED_IPS, DNS, ENDPOINT, EXCLUDED_APPLICATIONS, INCLUDED_APPLICATIONS, LISTEN_PORT, MTU, PERSISTENT_KEEPALIVE, PRE_SHARED_KEY, PRIVATE_KEY, PUBLIC_KEY};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            String str = y.ۮخݳ٬ۨ(1835611702);
            DNS = new Location(str, 3, str);
            ENDPOINT = new Location(y.ش۳ֲ׬٨(1672413474), 4, y.׬ܮ֮ڱܭ(1520049720));
            EXCLUDED_APPLICATIONS = new Location(y.ش۳ֲ׬٨(1672413218), 5, y.ش۳ֲ׬٨(1672413394));
            INCLUDED_APPLICATIONS = new Location(y.ܴ٭׮ڱܭ(-366267724), 6, y.ܴٳݴܯޫ(-170219063));
            LISTEN_PORT = new Location(y.ܴ٭׮ڱܭ(-366267988), 7, y.ܴٳݴܯޫ(-170219359));
            String str2 = y.ڮڴجۭݩ(1256589077);
            MTU = new Location(str2, 8, str2);
            PERSISTENT_KEEPALIVE = new Location(y.گ֮۬۲ݮ(2086575811), 9, y.׬ܮ֮ڱܭ(1520048728));
            PRE_SHARED_KEY = new Location(y.׬ܮ֮ڱܭ(1520047104), 10, y.׬ܮ֮ڱܭ(1520047344));
            PRIVATE_KEY = new Location(y.ܴٳݴܯޫ(-170220343), 11, y.׬ܮ֮ڱܭ(1520047488));
            PUBLIC_KEY = new Location(y.ܴٳݴܯޫ(-170219767), 12, y.ش۳ֲ׬٨(1672415746));
            $VALUES = $values();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Location(String str, int i, String str2) {
            this.name = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Location valueOf(String str) {
            return (Location) Enum.valueOf(Location.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Location[] values() {
            return (Location[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getName() {
            return this.name;
        }
    }

    public enum Reason {
        INVALID_KEY,
        INVALID_NUMBER,
        INVALID_VALUE,
        MISSING_ATTRIBUTE,
        MISSING_SECTION,
        SYNTAX_ERROR,
        UNKNOWN_ATTRIBUTE,
        UNKNOWN_SECTION
    }

    public enum Section {
        CONFIG(y.ܴٳݴܯޫ(-170220647)),
        INTERFACE(y.ش۳ֲ׬٨(1672416442)),
        PEER(y.ܴ٭׮ڱܭ(-366266364));

        private final String name;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Section(String str) {
            this.name = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getName() {
            return this.name;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Location getLocation() {
        return this.location;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Reason getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Section getSection() {
        return this.section;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BadConfigException(Section section, Location location, Reason reason, CharSequence charSequence) {
        this(section, location, reason, charSequence, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BadConfigException(Section section, Location location, Reason reason, CharSequence charSequence, Throwable th) {
        super(th);
        this.section = section;
        this.location = location;
        this.reason = reason;
        this.text = charSequence;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BadConfigException(Section section, Location location, ParseException parseException) {
        this(section, location, Reason.INVALID_VALUE, parseException.getText(), parseException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BadConfigException(Section section, Location location, KeyFormatException keyFormatException) {
        this(section, location, Reason.INVALID_KEY, null, keyFormatException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BadConfigException(Section section, Location location, CharSequence charSequence, NumberFormatException numberFormatException) {
        this(section, location, Reason.INVALID_NUMBER, charSequence, numberFormatException);
    }
}
