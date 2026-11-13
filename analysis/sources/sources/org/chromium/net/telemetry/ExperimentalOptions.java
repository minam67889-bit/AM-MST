package org.chromium.net.telemetry;

import android.util.Log;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public final class ExperimentalOptions {
    private static final String ASYNC_DNS = "AsyncDNS";
    private static final String QUIC = "QUIC";
    private static final String STALE_DNS = "StaleDNS";
    private static final String TAG = "ExperimentalOptions";
    public static final int UNSET_INT_VALUE = -1;
    public static final Set<String> VALID_CONNECTION_OPTIONS;
    private JSONObject mJson;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExperimentalOptions(String str) {
        this.mJson = new JSONObject();
        if (isNullOrEmpty(str)) {
            return;
        }
        try {
            this.mJson = (JSONObject) new JSONTokener(str).nextValue();
        } catch (ClassCastException | JSONException e) {
            String str2 = TAG;
            if (Log.isLoggable(str2, 2)) {
                Log.v(str2, y.ش۳ֲ׬٨(1672306026) + e.getMessage());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getAllowPortMigration() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ش۳ֲ׬٨(1672461794), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getAsyncDnsEnableOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256628517), y.ܴ٭׮ڱܭ(-366242124), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getCloseSessionsOnIpChangeOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.۳׭خ۲ݮ(1787263591), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getConnectionOptionsOption() {
        return parseExperimentalOptionsString((String) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ܴ٭׮ڱܭ(-366243724), null, String.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getDisableBidirectionalStreamsOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ش۳ֲ׬٨(1672299074), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getDisableIpv6OnWifiOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ܴٳݴܯޫ(-170332183), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getEnableSocketRecvOptimizationOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ܴٳݴܯޫ(-170332615), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getGoawaySessionsOnIpChangeOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.׬ܮ֮ڱܭ(1520127984), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getHostWhitelist() {
        return (String) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ۮخݳ٬ۨ(1835635398), null, String.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIdleConnectionTimeoutSecondsOption() {
        return ((Integer) getOrDefault(y.ڮڴجۭݩ(1256632845), y.گ֮۬۲ݮ(2086549171), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxIdleTimeBeforeCryptoHandshakeSecondsOption() {
        return ((Integer) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ܴ٭׮ڱܭ(-366241044), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxServerConfigsStoredInPropertiesOption() {
        return ((Integer) getOrDefault(y.ڮڴجۭݩ(1256632845), y.׬ܮ֮ڱܭ(1520088520), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxTimeBeforeCryptoHandshakeSecondsOption() {
        return ((Integer) getOrDefault(y.ڮڴجۭݩ(1256632845), y.گ֮۬۲ݮ(2086549443), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getMigrateSessionsEarlyV2() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ۮخݳ٬ۨ(1835633310), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getMigrateSessionsOnNetworkChangeV2Option() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ܴ٭׮ڱܭ(-366246916), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getRaceStaleDnsOnConnection() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ۮخݳ٬ۨ(1835635166), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getStaleDnsAllowOtherNetworkOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.ܴٳݴܯޫ(-170258511), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStaleDnsDelayMillisOption() {
        return ((Integer) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.ڮڴجۭݩ(1256628805), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getStaleDnsEnableOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.ܴ٭׮ڱܭ(-366242124), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStaleDnsMaxExpiredTimeMillisOption() {
        return ((Integer) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.گ֮۬۲ݮ(2086550963), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStaleDnsMaxStaleUsesOption() {
        return ((Integer) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.۳׭خ۲ݮ(1787063383), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStaleDnsPersistDelayMillisOption() {
        return ((Integer) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.ش۳ֲ׬٨(1672454562), -1, Integer.class)).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getStaleDnsPersistToDiskOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.׬ܮ֮ڱܭ(1520090464), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getStaleDnsUseStaleOnNameNotResolvedOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ܴٳݴܯޫ(-170259239), y.ڮڴجۭݩ(1256628789), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OptionalBoolean getStoreServerConfigsInPropertiesOption() {
        return OptionalBoolean.fromBoolean((Boolean) getOrDefault(y.ڮڴجۭݩ(1256632845), y.ڮڴجۭݩ(1256473917), null, Boolean.class));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUserAgentId() {
        return (String) getOrDefault(y.ڮڴجۭݩ(1256632845), y.׬ܮ֮ڱܭ(1520088688), null, String.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String[] strArr = {y.۳׭خ۲ݮ(1787272207), y.۳׭خ۲ݮ(1787272287), y.ܴ٭׮ڱܭ(-366312604), y.׬ܮ֮ڱܭ(1520150640), y.۳׭خ۲ݮ(1787272407), y.ܴٳݴܯޫ(-170190783), y.گ֮۬۲ݮ(2086611995), y.ڮڴجۭݩ(1256699053), y.׬ܮ֮ڱܭ(1520150808), y.ܴ٭׮ڱܭ(-366312916), y.گ֮۬۲ݮ(2086612827), y.׬ܮ֮ڱܭ(1520151176), y.׬ܮ֮ڱܭ(1520151256), y.ۮخݳ٬ۨ(1835565774), y.گ֮۬۲ݮ(2086612891), y.ܴٳݴܯޫ(-170189919), y.ܴ٭׮ڱܭ(-366313252), y.ܴ٭׮ڱܭ(-366313300), y.ܴٳݴܯޫ(-170190127), y.گ֮۬۲ݮ(2086612715), y.۳׭خ۲ݮ(1787273175), y.ش۳ֲ׬٨(1672395746), y.ܴ٭׮ڱܭ(-366309444), y.ܴٳݴܯޫ(-170191583), y.׬ܮ֮ڱܭ(1520149528), y.ۮخݳ٬ۨ(1835568270), y.ش۳ֲ׬٨(1672395506), y.ش۳ֲ׬٨(1672395458), y.׬ܮ֮ڱܭ(1520149976), y.ش۳ֲ׬٨(1672395362), y.۳׭خ۲ݮ(1787269623), y.۳׭خ۲ݮ(1787269575), y.ܴٳݴܯޫ(-170190991), y.ܴ٭׮ڱܭ(-366309972), y.׬ܮ֮ڱܭ(1520150072), y.׬ܮ֮ڱܭ(1520150024), y.ڮڴجۭݩ(1256700733), y.گ֮۬۲ݮ(2086609483), y.ۮخݳ٬ۨ(1835568926), y.ڮڴجۭݩ(1256700589), y.׬ܮ֮ڱܭ(1520150296), y.ܴٳݴܯޫ(-170191231), y.ڮڴجۭݩ(1256701405), y.׬ܮ֮ڱܭ(1520148616), y.׬ܮ֮ڱܭ(1520148696), y.׬ܮ֮ڱܭ(1520148520), y.ܴٳݴܯޫ(-170192495), y.ܴ٭׮ڱܭ(-366310644), y.ܴ٭׮ڱܭ(-366310692), y.ش۳ֲ׬٨(1672396450), y.ܴٳݴܯޫ(-170244439), y.׬ܮ֮ڱܭ(1520148792), y.ܴ٭׮ڱܭ(-366310836), y.ܴ٭׮ڱܭ(-366310884), y.ܴ٭׮ڱܭ(-366310932), y.ڮڴجۭݩ(1256701853), y.ܴ٭׮ڱܭ(-366311028), y.ش۳ֲ׬٨(1672396114), y.۳׭خ۲ݮ(1787270887), y.۳׭خ۲ݮ(1787270967), y.ش۳ֲ׬٨(1672395970), y.ܴٳݴܯޫ(-170192335), y.ۮخݳ٬ۨ(1835568078), y.ش۳ֲ׬٨(1672395826), y.گ֮۬۲ݮ(2086610603), y.ش۳ֲ׬٨(1672389586), y.ش۳ֲ׬٨(1672389538), y.گ֮۬۲ݮ(2086615515), y.۳׭خ۲ݮ(1787267207), y.ڮڴجۭݩ(1256694077), y.ܴٳݴܯޫ(-170193855), y.ܴ٭׮ڱܭ(-366307652), y.ڮڴجۭݩ(1256693933), y.گ֮۬۲ݮ(2086615291), y.ܴٳݴܯޫ(-170193791), y.ڮڴجۭݩ(1256694749), y.گ֮۬۲ݮ(2086615915), y.۳׭خ۲ݮ(1787221407), y.ش۳ֲ׬٨(1672389010), y.ۮخݳ٬ۨ(1835570894), y.۳׭خ۲ݮ(1787267831), y.ۮخݳ٬ۨ(1835570862), y.׬ܮ֮ڱܭ(1520156568), y.۳׭خ۲ݮ(1787267943), y.ش۳ֲ׬٨(1672388722), y.ڮڴجۭݩ(1256694381), y.گ֮۬۲ݮ(2086615739), y.۳׭خ۲ݮ(1787268135), y.ܴٳݴܯޫ(-170194671), y.ڮڴجۭݩ(1256695213), y.۳׭خ۲ݮ(1787268247), y.׬ܮ֮ڱܭ(1520154728), y.׬ܮ֮ڱܭ(1520155064), y.׬ܮ֮ڱܭ(1520155016), y.۳׭خ۲ݮ(1787268439), y.ش۳ֲ׬٨(1672390242), y.گ֮۬۲ݮ(2086616219), y.ܴٳݴܯޫ(-170194783), y.ܴ٭׮ڱܭ(-366308900), y.۳׭خ۲ݮ(1787268711), y.ܴٳݴܯޫ(-170193967), y.ܴٳݴܯޫ(-170193951), y.׬ܮ֮ڱܭ(1520155224), y.ڮڴجۭݩ(1256695501), y.۳׭خ۲ݮ(1787268983), y.گ֮۬۲ݮ(2086616619), y.۳׭خ۲ݮ(1787269015), y.ܴ٭׮ڱܭ(-366309332), y.ۮخݳ٬ۨ(1835572318), y.ܴٳݴܯޫ(-170195615), y.گ֮۬۲ݮ(2086613307), y.ۮخݳ٬ۨ(1835572430), y.۳׭خ۲ݮ(1787265271), y.گ֮۬۲ݮ(2086613419), y.ڮڴجۭݩ(1256696061), y.ش۳ֲ׬٨(1672391330), y.׬ܮ֮ڱܭ(1520153912), y.ܴٳݴܯޫ(-170195743), y.ܴٳݴܯޫ(-170195791), y.ش۳ֲ׬٨(1672391138), y.ۮخݳ٬ۨ(1835572766), y.׬ܮ֮ڱܭ(1520154312), y.ش۳ֲ׬٨(1672390994), y.ۮخݳ٬ۨ(1835572878), y.ܴٳݴܯޫ(-170195375), y.ܴٳݴܯޫ(-170195359), y.׬ܮ֮ڱܭ(1520154584), y.ܴ٭׮ڱܭ(-366306196), y.گ֮۬۲ݮ(2086613659), y.ܴ٭׮ڱܭ(-366306292), y.گ֮۬۲ݮ(2086614395), y.ܴ٭׮ڱܭ(-366306388), y.ۮخݳ٬ۨ(1835571422), y.ܴ٭׮ڱܭ(-366306484), y.ܴٳݴܯޫ(-170196559), y.ڮڴجۭݩ(1256697037), y.۳׭خ۲ݮ(1787266423), y.׬ܮ֮ڱܭ(1520153032), y.ܴٳݴܯޫ(-170196751), y.ۮخݳ٬ۨ(1835571598), y.ܴٳݴܯޫ(-170196143), y.ܴ٭׮ڱܭ(-366306868), y.ܴ٭׮ڱܭ(-366306916), y.ܴٳݴܯޫ(-170196031), y.׬ܮ֮ڱܭ(1520153208), y.ܴٳݴܯޫ(-170196063), y.گ֮۬۲ݮ(2086614651), y.׬ܮ֮ڱܭ(1520153576), y.ش۳ֲ׬٨(1672391794), y.ܴ٭׮ڱܭ(-366307252), y.ش۳ֲ׬٨(1672391698), y.ܴٳݴܯޫ(-170328767), y.ڮڴجۭݩ(1256477085), y.ڮڴجۭݩ(1256477101), y.۳׭خ۲ݮ(1787066519), y.ۮخݳ٬ۨ(1835754638), y.ۮخݳ٬ۨ(1835754846), y.׬ܮ֮ڱܭ(1519930760), y.ش۳ֲ׬٨(1672303250), y.ܴٳݴܯޫ(-170328895), y.ܴ٭׮ڱܭ(-366385604), y.ۮخݳ٬ۨ(1835754926), y.ڮڴجۭݩ(1256477693), y.ش۳ֲ׬٨(1672303010), y.ش۳ֲ׬٨(1672302962), y.۳׭خ۲ݮ(1787067015), y.۳׭خ۲ݮ(1787067095), y.ܴٳݴܯޫ(-170328511), y.۳׭خ۲ݮ(1787067255), y.ܴٳݴܯޫ(-170328543), y.۳׭خ۲ݮ(1787067287), y.ܴٳݴܯޫ(-170328447), y.ڮڴجۭݩ(1256478173), y.گ֮۬۲ݮ(2086456683), y.ش۳ֲ׬٨(1672304530), y.ڮڴجۭݩ(1256478029), y.ڮڴجۭݩ(1256477981), y.ڮڴجۭݩ(1256477997), y.ۮخݳ٬ۨ(1835753854), y.۳׭خ۲ݮ(1787067751), y.ܴٳݴܯޫ(-170329903), y.׬ܮ֮ڱܭ(1519929608), y.׬ܮ֮ڱܭ(1519929688), y.ۮخݳ٬ۨ(1835754062), y.ڮڴجۭݩ(1256478621), y.׬ܮ֮ڱܭ(1519930056), y.ܴ٭׮ڱܭ(-366386852), y.ܴ٭׮ڱܭ(-366386900), y.׬ܮ֮ڱܭ(1519930296), y.۳׭خ۲ݮ(1787068167), y.ڮڴجۭݩ(1256478397), y.ܴ٭׮ڱܭ(-366387092), y.ڮڴجۭݩ(1256478237), y.گ֮۬۲ݮ(2086457003), y.۳׭خ۲ݮ(1787064343), y.۳׭خ۲ݮ(1787064423), y.ش۳ֲ׬٨(1672305522), y.ۮخݳ٬ۨ(1835756782), y.׬ܮ֮ڱܭ(1519928408), y.ܴٳݴܯޫ(-170331071), y.۳׭خ۲ݮ(1787064695), y.׬ܮ֮ڱܭ(1519928768), y.ش۳ֲ׬٨(1672305242), y.ڮڴجۭݩ(1256478725), y.گ֮۬۲ݮ(2086454099), y.ܴ٭׮ڱܭ(-366383676), y.ش۳ֲ׬٨(1672305050), y.׬ܮ֮ڱܭ(1519928864), y.ܴٳݴܯޫ(-170330215), y.׬ܮ֮ڱܭ(1519928896), y.׬ܮ֮ڱܭ(1519929232), y.گ֮۬۲ݮ(2086453763), y.ܴٳݴܯޫ(-170330407), y.׬ܮ֮ڱܭ(1519929088), y.ܴٳݴܯޫ(-170330439), y.ۮخݳ٬ۨ(1835755590), y.׬ܮ֮ڱܭ(1519927536), y.ۮخݳ٬ۨ(1835755558), y.ش۳ֲ׬٨(1672306522), y.׬ܮ֮ڱܭ(1519927392), y.ڮڴجۭݩ(1256479957), y.׬ܮ֮ڱܭ(1519927680), y.ڮڴجۭݩ(1256479925), y.ش۳ֲ׬٨(1672306282), y.گ֮۬۲ݮ(2086454419), y.ܴ٭׮ڱܭ(-366384636), y.ܴٳݴܯޫ(-170331271), y.ڮڴجۭݩ(1256480693)};
        HashSet hashSet = new HashSet(228);
        for (int i = 0; i < 228; i++) {
            String str = strArr[i];
            Objects.requireNonNull(str);
            if (!hashSet.add(str)) {
                throw new IllegalArgumentException(y.گ֮۬۲ݮ(2086590267) + ((Object) str));
            }
        }
        VALID_CONNECTION_OPTIONS = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T getOrDefault(String str, T t, Class<T> cls) {
        if (this.mJson.length() == 0) {
            return t;
        }
        try {
            return cls.cast(this.mJson.get(str));
        } catch (ClassCastException | JSONException e) {
            String str2 = TAG;
            if (!Log.isLoggable(str2, 2)) {
                return t;
            }
            Log.v(str2, y.ܴٳݴܯޫ(-170332799) + str + " options: " + e.getMessage());
            return t;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String parseExperimentalOptionsString(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = y.ش۳ֲ׬٨(1672455554);
        for (String str3 : str.split(str2, -1)) {
            if (VALID_CONNECTION_OPTIONS.contains(str3.toUpperCase(Locale.ROOT).trim())) {
                arrayList.add(str3);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) str2);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T getOrDefault(String str, String str2, T t, Class<T> cls) {
        JSONObject jSONObject;
        String str3 = y.ۮخݳ٬ۨ(1835758862);
        String str4 = y.ܴٳݴܯޫ(-170332799);
        if (this.mJson.length() == 0) {
            return t;
        }
        try {
            jSONObject = this.mJson.getJSONObject(str);
        } catch (JSONException e) {
            String str5 = TAG;
            if (Log.isLoggable(str5, 2)) {
                Log.v(str5, str4 + str + str3 + e.getMessage());
            }
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return t;
        }
        try {
            return cls.cast(jSONObject.get(str2));
        } catch (ClassCastException | JSONException e2) {
            String str6 = TAG;
            if (!Log.isLoggable(str6, 2)) {
                return t;
            }
            Log.v(str6, str4 + str2 + str3 + e2.getMessage());
            return t;
        }
    }
}
