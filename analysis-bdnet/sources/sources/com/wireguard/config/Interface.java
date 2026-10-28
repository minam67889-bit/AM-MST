package com.wireguard.config;

import com.liapp.y;
import com.wireguard.config.BadConfigException;
import com.wireguard.crypto.Key;
import com.wireguard.crypto.KeyFormatException;
import com.wireguard.crypto.KeyPair;
import com.wireguard.util.NonNullForAll;
import defpackage.AbstractC4575vQ;
import defpackage.C0636Xw;
import defpackage.C0662Yw;
import defpackage.C3214dh;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NonNullForAll
/* loaded from: classes.dex */
public final class Interface {
    private static final int MAX_UDP_PORT = 65535;
    private static final int MIN_UDP_PORT = 0;
    private final Set<InetNetwork> addresses;
    private final Set<String> dnsSearchDomains;
    private final Set<InetAddress> dnsServers;
    private final Set<String> excludedApplications;
    private final Set<String> includedApplications;
    private final KeyPair keyPair;
    private final Optional<Integer> listenPort;
    private final Optional<Integer> mtu;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ BadConfigException lambda$parse$0(CharSequence charSequence) {
        return new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.TOP_LEVEL, BadConfigException.Reason.SYNTAX_ERROR, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void lambda$toString$1(StringBuilder sb, Integer num) {
        sb.append(y.ܴٳݴܯޫ(-170234647));
        sb.append(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void lambda$toWgQuickString$2(StringBuilder sb, Integer num) {
        sb.append(y.ۮخݳ٬ۨ(1835660678));
        sb.append(num);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void lambda$toWgQuickString$3(StringBuilder sb, Integer num) {
        sb.append(y.ڮڴجۭݩ(1256637341));
        sb.append(num);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void lambda$toWgUserspaceString$4(StringBuilder sb, Integer num) {
        sb.append(y.گ֮۬۲ݮ(2086558683));
        sb.append(num);
        sb.append('\n');
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Interface parse(Iterable<? extends CharSequence> iterable) {
        Builder builder = new Builder();
        for (CharSequence charSequence : iterable) {
            Attribute orElseThrow = Attribute.parse(charSequence).orElseThrow(new C0662Yw(charSequence, 0));
            String lowerCase = orElseThrow.getKey().toLowerCase(Locale.ENGLISH);
            lowerCase.getClass();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -2018040851:
                    if (lowerCase.equals(y.׬ܮ֮ڱܭ(1520097712))) {
                        c = 0;
                        break;
                    }
                    break;
                case -1876040196:
                    if (lowerCase.equals(y.׬ܮ֮ڱܭ(1520097296))) {
                        c = 1;
                        break;
                    }
                    break;
                case -1147692044:
                    if (lowerCase.equals(y.ܴ٭׮ڱܭ(-366218324))) {
                        c = 2;
                        break;
                    }
                    break;
                case 99625:
                    if (lowerCase.equals(y.گ֮۬۲ݮ(2086559075))) {
                        c = 3;
                        break;
                    }
                    break;
                case 108462:
                    if (lowerCase.equals(y.ڮڴجۭݩ(1256637917))) {
                        c = 4;
                        break;
                    }
                    break;
                case 496413663:
                    if (lowerCase.equals(y.ش۳ֲ׬٨(1672462498))) {
                        c = 5;
                        break;
                    }
                    break;
                case 874736328:
                    if (lowerCase.equals(y.ܴ٭׮ڱܭ(-366217972))) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.parseExcludedApplications(orElseThrow.getValue());
                    break;
                case 1:
                    builder.parsePrivateKey(orElseThrow.getValue());
                    break;
                case 2:
                    builder.parseAddresses(orElseThrow.getValue());
                    break;
                case 3:
                    builder.parseDnsServers(orElseThrow.getValue());
                    break;
                case 4:
                    builder.parseMtu(orElseThrow.getValue());
                    break;
                case 5:
                    builder.parseIncludedApplications(orElseThrow.getValue());
                    break;
                case 6:
                    builder.parseListenPort(orElseThrow.getValue());
                    break;
                default:
                    throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.TOP_LEVEL, BadConfigException.Reason.UNKNOWN_ATTRIBUTE, orElseThrow.getKey());
            }
        }
        return builder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof Interface)) {
            return false;
        }
        Interface r4 = (Interface) obj;
        return this.addresses.equals(r4.addresses) && this.dnsServers.equals(r4.dnsServers) && this.dnsSearchDomains.equals(r4.dnsSearchDomains) && this.excludedApplications.equals(r4.excludedApplications) && this.includedApplications.equals(r4.includedApplications) && this.keyPair.equals(r4.keyPair) && this.listenPort.equals(r4.listenPort) && this.mtu.equals(r4.mtu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<InetNetwork> getAddresses() {
        return this.addresses;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getDnsSearchDomains() {
        return this.dnsSearchDomains;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<InetAddress> getDnsServers() {
        return this.dnsServers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getExcludedApplications() {
        return this.excludedApplications;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> getIncludedApplications() {
        return this.includedApplications;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Integer> getListenPort() {
        return this.listenPort;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Integer> getMtu() {
        return this.mtu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mtu.hashCode() + ((this.listenPort.hashCode() + ((this.keyPair.hashCode() + ((this.includedApplications.hashCode() + ((this.excludedApplications.hashCode() + ((this.dnsServers.hashCode() + ((this.addresses.hashCode() + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(y.ܴ٭׮ڱܭ(-366218684));
        sb.append(this.keyPair.getPublicKey().toBase64());
        this.listenPort.ifPresent(new C0636Xw(0, sb));
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toWgQuickString() {
        StringBuilder sb = new StringBuilder();
        if (!this.addresses.isEmpty()) {
            sb.append(y.گ֮۬۲ݮ(2086559563));
            sb.append(Attribute.join(this.addresses));
            sb.append('\n');
        }
        if (!this.dnsServers.isEmpty()) {
            List list = (List) this.dnsServers.stream().map(new C3214dh(2)).collect(Collectors.toList());
            list.addAll(this.dnsSearchDomains);
            sb.append(y.ۮخݳ٬ۨ(1835659822));
            sb.append(Attribute.join(list));
            sb.append('\n');
        }
        if (!this.excludedApplications.isEmpty()) {
            sb.append(y.۳׭خ۲ݮ(1787227783));
            sb.append(Attribute.join(this.excludedApplications));
            sb.append('\n');
        }
        if (!this.includedApplications.isEmpty()) {
            sb.append(y.ܴٳݴܯޫ(-170235175));
            sb.append(Attribute.join(this.includedApplications));
            sb.append('\n');
        }
        this.listenPort.ifPresent(new C0636Xw(1, sb));
        this.mtu.ifPresent(new C0636Xw(2, sb));
        sb.append(y.ۮخݳ٬ۨ(1835662366));
        sb.append(this.keyPair.getPrivateKey().toBase64());
        sb.append('\n');
        return sb.toString();
    }

    public static final class Builder {
        private KeyPair keyPair;
        private final Set<InetNetwork> addresses = new LinkedHashSet();
        private final Set<InetAddress> dnsServers = new LinkedHashSet();
        private final Set<String> dnsSearchDomains = new LinkedHashSet();
        private final Set<String> excludedApplications = new LinkedHashSet();
        private final Set<String> includedApplications = new LinkedHashSet();
        private Optional<Integer> listenPort = Optional.empty();
        private Optional<Integer> mtu = Optional.empty();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAddress(InetNetwork inetNetwork) {
            this.addresses.add(inetNetwork);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAddresses(Collection<InetNetwork> collection) {
            this.addresses.addAll(collection);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addDnsSearchDomain(String str) {
            this.dnsSearchDomains.add(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addDnsSearchDomains(Collection<String> collection) {
            this.dnsSearchDomains.addAll(collection);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addDnsServer(InetAddress inetAddress) {
            this.dnsServers.add(inetAddress);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addDnsServers(Collection<? extends InetAddress> collection) {
            this.dnsServers.addAll(collection);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Interface build() {
            if (this.keyPair == null) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.PRIVATE_KEY, BadConfigException.Reason.MISSING_ATTRIBUTE, (CharSequence) null);
            }
            if (this.includedApplications.isEmpty() || this.excludedApplications.isEmpty()) {
                return new Interface(this, 0);
            }
            throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.INCLUDED_APPLICATIONS, BadConfigException.Reason.INVALID_KEY, (CharSequence) null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder excludeApplication(String str) {
            this.excludedApplications.add(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder excludeApplications(Collection<String> collection) {
            this.excludedApplications.addAll(collection);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder includeApplication(String str) {
            this.includedApplications.add(str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder includeApplications(Collection<String> collection) {
            this.includedApplications.addAll(collection);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseAddresses(CharSequence charSequence) {
            try {
                for (String str : Attribute.split(charSequence)) {
                    addAddress(InetNetwork.parse(str));
                }
                return this;
            } catch (ParseException e) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.ADDRESS, e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseDnsServers(CharSequence charSequence) {
            try {
                for (String str : Attribute.split(charSequence)) {
                    try {
                        addDnsServer(InetAddresses.parse(str));
                    } catch (ParseException e) {
                        if (e.getParsingClass() != InetAddress.class || !InetAddresses.isHostname(str)) {
                            throw e;
                        }
                        addDnsSearchDomain(str);
                    }
                }
                return this;
            } catch (ParseException e2) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.DNS, e2);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseListenPort(String str) {
            try {
                return setListenPort(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.LISTEN_PORT, str, e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseMtu(String str) {
            try {
                return setMtu(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.MTU, str, e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parsePrivateKey(String str) {
            try {
                return setKeyPair(new KeyPair(Key.fromBase64(str)));
            } catch (KeyFormatException e) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.PRIVATE_KEY, e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setKeyPair(KeyPair keyPair) {
            this.keyPair = keyPair;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setListenPort(int i) {
            if (i < 0 || i > Interface.MAX_UDP_PORT) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.LISTEN_PORT, BadConfigException.Reason.INVALID_VALUE, String.valueOf(i));
            }
            this.listenPort = i == 0 ? Optional.empty() : Optional.of(Integer.valueOf(i));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMtu(int i) {
            if (i < 0) {
                throw new BadConfigException(BadConfigException.Section.INTERFACE, BadConfigException.Location.LISTEN_PORT, BadConfigException.Reason.INVALID_VALUE, String.valueOf(i));
            }
            this.mtu = i == 0 ? Optional.empty() : Optional.of(Integer.valueOf(i));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseExcludedApplications(CharSequence charSequence) {
            String[] split = Attribute.split(charSequence);
            ArrayList arrayList = new ArrayList(split.length);
            for (String str : split) {
                Objects.requireNonNull(str);
                arrayList.add(str);
            }
            return excludeApplications(Collections.unmodifiableList(arrayList));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder parseIncludedApplications(CharSequence charSequence) {
            String[] split = Attribute.split(charSequence);
            ArrayList arrayList = new ArrayList(split.length);
            for (String str : split) {
                Objects.requireNonNull(str);
                arrayList.add(str);
            }
            return includeApplications(Collections.unmodifiableList(arrayList));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Interface(Builder builder) {
        this.addresses = Collections.unmodifiableSet(new LinkedHashSet(builder.addresses));
        this.dnsServers = Collections.unmodifiableSet(new LinkedHashSet(builder.dnsServers));
        this.dnsSearchDomains = Collections.unmodifiableSet(new LinkedHashSet(builder.dnsSearchDomains));
        this.excludedApplications = Collections.unmodifiableSet(new LinkedHashSet(builder.excludedApplications));
        this.includedApplications = Collections.unmodifiableSet(new LinkedHashSet(builder.includedApplications));
        KeyPair keyPair = builder.keyPair;
        Objects.requireNonNull(keyPair, y.ش۳ֲ׬٨(1672463210));
        this.keyPair = keyPair;
        this.listenPort = builder.listenPort;
        this.mtu = builder.mtu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toWgUserspaceString() {
        StringBuilder w = AbstractC4575vQ.w(y.ڮڴجۭݩ(1256638741));
        w.append(this.keyPair.getPrivateKey().toHex());
        w.append('\n');
        this.listenPort.ifPresent(new C0636Xw(3, w));
        return w.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ Interface(Builder builder, int i) {
        this(builder);
    }
}
