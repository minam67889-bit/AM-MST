package org.chromium.net;

import com.liapp.y;
import defpackage.AbstractC4575vQ;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.net.DnsOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class ExperimentalOptionsTranslator {

    @FunctionalInterface
    public interface JsonPatch {
        void applyTo(JSONObject jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ExperimentalOptionsTranslator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JSONObject applyJsonPatches(JSONObject jSONObject, List<JsonPatch> list) {
        if (jSONObject == null && list.isEmpty()) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Iterator<JsonPatch> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().applyTo(jSONObject);
            } catch (JSONException e) {
                throw new IllegalStateException(y.ش۳ֲ׬٨(1672458506), e);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void connectionMigrationOptionsToJson(JSONObject jSONObject, ConnectionMigrationOptions connectionMigrationOptions) {
        JSONObject createDefaultIfAbsent = createDefaultIfAbsent(jSONObject, y.ڮڴجۭݩ(1256632845));
        Boolean enableDefaultNetworkMigration = connectionMigrationOptions.getEnableDefaultNetworkMigration();
        String str = y.ܴ٭׮ڱܭ(-366246916);
        if (enableDefaultNetworkMigration != null) {
            createDefaultIfAbsent.put(str, connectionMigrationOptions.getEnableDefaultNetworkMigration());
        }
        if (connectionMigrationOptions.getAllowServerMigration() != null) {
            createDefaultIfAbsent.put(y.گ֮۬۲ݮ(2086546451), connectionMigrationOptions.getAllowServerMigration());
        }
        if (connectionMigrationOptions.getMigrateIdleConnections() != null) {
            createDefaultIfAbsent.put(y.ۮخݳ٬ۨ(1835631190), connectionMigrationOptions.getMigrateIdleConnections());
        }
        if (connectionMigrationOptions.getIdleMigrationPeriodSeconds() != null) {
            createDefaultIfAbsent.put(y.ܴ٭׮ڱܭ(-366247604), connectionMigrationOptions.getIdleMigrationPeriodSeconds());
        }
        if (connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork() != null) {
            createDefaultIfAbsent.put(y.ܴ٭׮ڱܭ(-366247932), connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork());
        }
        if (connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds() != null) {
            createDefaultIfAbsent.put(y.ܴ٭׮ڱܭ(-366244180), connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds());
        }
        if (connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount() != null) {
            createDefaultIfAbsent.put(y.ڮڴجۭݩ(1256635253), connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount() != null) {
            createDefaultIfAbsent.put(y.۳׭خ۲ݮ(1787204695), connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getEnablePathDegradationMigration() != null) {
            boolean booleanValue = connectionMigrationOptions.getEnablePathDegradationMigration().booleanValue();
            createDefaultIfAbsent.put(y.ش۳ֲ׬٨(1672461794), booleanValue);
            if (connectionMigrationOptions.getAllowNonDefaultNetworkUsage() != null) {
                boolean booleanValue2 = connectionMigrationOptions.getAllowNonDefaultNetworkUsage().booleanValue();
                if (!booleanValue && booleanValue2) {
                    throw new IllegalArgumentException("Unable to turn on non-default network usage without path degradation migration!");
                }
                String str2 = y.ۮخݳ٬ۨ(1835633310);
                if (!booleanValue || !booleanValue2) {
                    createDefaultIfAbsent.put(str2, false);
                } else {
                    createDefaultIfAbsent.put(str2, true);
                    createDefaultIfAbsent.put(str, true);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void dnsOptionsToJson(JSONObject jSONObject, DnsOptions dnsOptions) {
        JSONObject createDefaultIfAbsent = createDefaultIfAbsent(jSONObject, y.ڮڴجۭݩ(1256628517));
        Boolean useBuiltInDnsResolver = dnsOptions.getUseBuiltInDnsResolver();
        String str = y.ܴ٭׮ڱܭ(-366242124);
        if (useBuiltInDnsResolver != null) {
            createDefaultIfAbsent.put(str, dnsOptions.getUseBuiltInDnsResolver());
        }
        JSONObject createDefaultIfAbsent2 = createDefaultIfAbsent(jSONObject, y.ܴٳݴܯޫ(-170259239));
        if (dnsOptions.getEnableStaleDns() != null) {
            createDefaultIfAbsent2.put(str, dnsOptions.getEnableStaleDns());
        }
        if (dnsOptions.getPersistHostCache() != null) {
            createDefaultIfAbsent2.put(y.׬ܮ֮ڱܭ(1520090464), dnsOptions.getPersistHostCache());
        }
        if (dnsOptions.getPersistHostCachePeriodMillis() != null) {
            createDefaultIfAbsent2.put(y.ش۳ֲ׬٨(1672454562), dnsOptions.getPersistHostCachePeriodMillis());
        }
        if (dnsOptions.getStaleDnsOptions() != null) {
            DnsOptions.StaleDnsOptions staleDnsOptions = dnsOptions.getStaleDnsOptions();
            if (staleDnsOptions.getAllowCrossNetworkUsage() != null) {
                createDefaultIfAbsent2.put(y.ܴٳݴܯޫ(-170258511), staleDnsOptions.getAllowCrossNetworkUsage());
            }
            if (staleDnsOptions.getFreshLookupTimeoutMillis() != null) {
                createDefaultIfAbsent2.put(y.ڮڴجۭݩ(1256628805), staleDnsOptions.getFreshLookupTimeoutMillis());
            }
            if (staleDnsOptions.getUseStaleOnNameNotResolved() != null) {
                createDefaultIfAbsent2.put(y.ڮڴجۭݩ(1256628789), staleDnsOptions.getUseStaleOnNameNotResolved());
            }
            if (staleDnsOptions.getMaxExpiredDelayMillis() != null) {
                createDefaultIfAbsent2.put(y.گ֮۬۲ݮ(2086550963), staleDnsOptions.getMaxExpiredDelayMillis());
            }
        }
        JSONObject createDefaultIfAbsent3 = createDefaultIfAbsent(jSONObject, y.ڮڴجۭݩ(1256632845));
        if (dnsOptions.getPreestablishConnectionsToStaleDnsResults() != null) {
            createDefaultIfAbsent3.put(y.ۮخݳ٬ۨ(1835635166), dnsOptions.getPreestablishConnectionsToStaleDnsResults());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static JSONObject toJsonExperimentalOptions(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            throw new IllegalArgumentException(y.ܴ٭׮ڱܭ(-366317692), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static JSONObject createDefaultIfAbsent(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                jSONObject.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalArgumentException(AbstractC4575vQ.E(y.گ֮۬۲ݮ(2086545139), str, y.ܴ٭׮ڱܭ(-366252012)), e);
            }
        }
        return optJSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void quicOptionsToJson(JSONObject jSONObject, QuicOptions quicOptions) {
        JSONObject createDefaultIfAbsent = createDefaultIfAbsent(jSONObject, y.ڮڴجۭݩ(1256632845));
        boolean isEmpty = quicOptions.getQuicHostAllowlist().isEmpty();
        String str = y.ش۳ֲ׬٨(1672455554);
        if (!isEmpty) {
            Set<String> quicHostAllowlist = quicOptions.getQuicHostAllowlist();
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = quicHostAllowlist.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    } else {
                        sb.append((CharSequence) str);
                    }
                }
            }
            createDefaultIfAbsent.put(y.ۮخݳ٬ۨ(1835635398), sb.toString());
        }
        if (!quicOptions.getEnabledQuicVersions().isEmpty()) {
            Set<String> enabledQuicVersions = quicOptions.getEnabledQuicVersions();
            StringBuilder sb2 = new StringBuilder();
            Iterator<T> it2 = enabledQuicVersions.iterator();
            if (it2.hasNext()) {
                while (true) {
                    sb2.append((CharSequence) it2.next());
                    if (!it2.hasNext()) {
                        break;
                    } else {
                        sb2.append((CharSequence) str);
                    }
                }
            }
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520090016), sb2.toString());
        }
        if (!quicOptions.getConnectionOptions().isEmpty()) {
            Set<String> connectionOptions = quicOptions.getConnectionOptions();
            StringBuilder sb3 = new StringBuilder();
            Iterator<T> it3 = connectionOptions.iterator();
            if (it3.hasNext()) {
                while (true) {
                    sb3.append((CharSequence) it3.next());
                    if (!it3.hasNext()) {
                        break;
                    } else {
                        sb3.append((CharSequence) str);
                    }
                }
            }
            createDefaultIfAbsent.put(y.ܴ٭׮ڱܭ(-366243724), sb3.toString());
        }
        if (!quicOptions.getClientConnectionOptions().isEmpty()) {
            Set<String> clientConnectionOptions = quicOptions.getClientConnectionOptions();
            StringBuilder sb4 = new StringBuilder();
            Iterator<T> it4 = clientConnectionOptions.iterator();
            if (it4.hasNext()) {
                while (true) {
                    sb4.append((CharSequence) it4.next());
                    if (!it4.hasNext()) {
                        break;
                    } else {
                        sb4.append((CharSequence) str);
                    }
                }
            }
            createDefaultIfAbsent.put(y.گ֮۬۲ݮ(2086547827), sb4.toString());
        }
        if (!quicOptions.getExtraQuicheFlags().isEmpty()) {
            Set<String> extraQuicheFlags = quicOptions.getExtraQuicheFlags();
            StringBuilder sb5 = new StringBuilder();
            Iterator<T> it5 = extraQuicheFlags.iterator();
            if (it5.hasNext()) {
                while (true) {
                    sb5.append((CharSequence) it5.next());
                    if (!it5.hasNext()) {
                        break;
                    } else {
                        sb5.append((CharSequence) str);
                    }
                }
            }
            createDefaultIfAbsent.put(y.ۮخݳ٬ۨ(1835637934), sb5.toString());
        }
        if (quicOptions.getInMemoryServerConfigsCacheSize() != null) {
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520088520), quicOptions.getInMemoryServerConfigsCacheSize());
        }
        if (quicOptions.getHandshakeUserAgent() != null) {
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520088688), quicOptions.getHandshakeUserAgent());
        }
        if (quicOptions.getRetryWithoutAltSvcOnQuicErrors() != null) {
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520088968), quicOptions.getRetryWithoutAltSvcOnQuicErrors());
        }
        if (quicOptions.getEnableTlsZeroRtt() != null) {
            createDefaultIfAbsent.put(y.ڮڴجۭݩ(1256631741), !quicOptions.getEnableTlsZeroRtt().booleanValue());
        }
        if (quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds() != null) {
            createDefaultIfAbsent.put(y.ܴ٭׮ڱܭ(-366241044), quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds());
        }
        if (quicOptions.getCryptoHandshakeTimeoutSeconds() != null) {
            createDefaultIfAbsent.put(y.گ֮۬۲ݮ(2086549443), quicOptions.getCryptoHandshakeTimeoutSeconds());
        }
        if (quicOptions.getIdleConnectionTimeoutSeconds() != null) {
            createDefaultIfAbsent.put(y.گ֮۬۲ݮ(2086549171), quicOptions.getIdleConnectionTimeoutSeconds());
        }
        if (quicOptions.getRetransmittableOnWireTimeoutMillis() != null) {
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520127064), quicOptions.getRetransmittableOnWireTimeoutMillis());
        }
        if (quicOptions.getCloseSessionsOnIpChange() != null) {
            createDefaultIfAbsent.put(y.۳׭خ۲ݮ(1787263591), quicOptions.getCloseSessionsOnIpChange());
        }
        if (quicOptions.getGoawaySessionsOnIpChange() != null) {
            createDefaultIfAbsent.put(y.׬ܮ֮ڱܭ(1520127984), quicOptions.getGoawaySessionsOnIpChange());
        }
        if (quicOptions.getInitialBrokenServicePeriodSeconds() != null) {
            createDefaultIfAbsent.put(y.ڮڴجۭݩ(1256674789), quicOptions.getInitialBrokenServicePeriodSeconds());
        }
        if (quicOptions.getIncreaseBrokenServicePeriodExponentially() != null) {
            createDefaultIfAbsent.put(y.ۮخݳ٬ۨ(1835557302), quicOptions.getIncreaseBrokenServicePeriodExponentially());
        }
        if (quicOptions.getDelayJobsWithAvailableSpdySession() != null) {
            createDefaultIfAbsent.put(y.ش۳ֲ׬٨(1672369386), quicOptions.getDelayJobsWithAvailableSpdySession());
        }
    }
}
