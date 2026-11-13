package ads_mobile_sdk;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.InterfaceC3669jd0;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* loaded from: classes.dex */
public enum s11 implements InterfaceC3669jd0 {
    CUI_NAME_UNKNOWN(0),
    CUI_NAME_SDKINIT(1),
    CUI_NAME_SDKINIT_LOAD_FLAGS(25),
    CUI_NAME_SDKINIT_ACTIVITY_TRACKER(33),
    CUI_NAME_SDKINIT_CLD(2),
    CUI_NAME_SDKINIT_INITIAL_CLD(178),
    CUI_NAME_SDKINIT_OVERALL_ADAPTER_INIT(133),
    CUI_NAME_SDKINIT_ADAPTERINIT(3),
    CUI_NAME_SDKINIT_SDKCORE(4),
    CUI_NAME_SDKINIT_SDKCORE_LOAD_URL(54),
    CUI_NAME_SDKINIT_SDKCORE_REQUEST(68),
    CUI_NAME_SDKINIT_SDKCORE_LOAD_HTML(67),
    CUI_NAME_SDKINIT_SDKCORE_JS_LOADED(55),
    CUI_NAME_SDKINIT_INIT_CONSENT_STATE(28),
    CUI_NAME_SDKINIT_INIT_OMID(31),
    CUI_NAME_SDKINIT_INIT_SPAM(38),
    CUI_NAME_SDKINIT_INIT_CRYPTO(62),
    CUI_NAME_SDKINIT_INIT_AD_ID_PERMISSION(63),
    CUI_NAME_SDKINIT_INIT_APP_PERMISSIONS(64),
    CUI_NAME_SDKINIT_INIT_ENVIRONMENT_SIGNAL(65),
    CUI_NAME_SDKINIT_INIT_DEVICE_SIGNAL(66),
    CUI_NAME_SDKINIT_INIT_NATIVE_AD_SETTINGS(70),
    CUI_NAME_SDKINIT_INIT_AD_INSPECTOR(71),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_UNINITIALIZE_SDK(165),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_UNINITIALIZE_SDK(166),
    CUI_NAME_AD_INSPECTOR_DISABLED(169),
    CUI_NAME_AD_INSPECTOR_GLOBAL_ALLOWLIST_OVERRIDE(170),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(24),
    CUI_NAME_DEVICE_PROPERTIES_INIT_TASK(30),
    CUI_NAME_UPDATE_FLAGS(22),
    CUI_NAME_ADREQUEST(5),
    CUI_NAME_ADREQUEST_SIGNALS(6),
    CUI_NAME_ADREQUEST_BUILDURL(7),
    CUI_NAME_ADREQUEST_REQUEST(8),
    CUI_NAME_ADREQUEST_NORMALIZE_RESPONSE(26),
    CUI_NAME_ADREQUEST_PARSERESPONSE(9),
    CUI_NAME_ADREQUEST_MEDIATION(29),
    CUI_NAME_ADREQUEST_MEDIATION_ADAPTER(10),
    CUI_NAME_ADREQUEST_WAIT_FOR_RESPONSE(161),
    CUI_NAME_WEBVIEW_USER_AGENT(69),
    CUI_NAME_WEBVIEW_INITIALIZATION(36),
    CUI_NAME_CREATIVE_WEBVIEW_INITIALIZATION(111),
    CUI_NAME_WEBVIEW_LOAD(37),
    CUI_NAME_CREATIVE_WEBVIEW_LOAD(110),
    CUI_NAME_STARTUP_WEBVIEW(113),
    CUI_NAME_WEBVIEW_PROFILE_INIT(115),
    CUI_NAME_WEBVIEW_PROFILE_SET(121),
    CUI_NAME_WEBVIEW_PROFILE_PRECONNECT(130),
    CUI_NAME_WEBVIEW_PROFILE_QUIC_HINTS(131),
    CUI_NAME_WEBVIEW_PROFILE_PREFETCH_RESOURCES(132),
    CUI_NAME_WEBVIEW_PRERENDER_RESOURCES(168),
    CUI_NAME_GET_WEBVIEW_VARIATIONS(120),
    CUI_NAME_ADSHOW(11),
    CUI_NAME_ADSHOW_WITH_VIEW(167),
    CUI_NAME_NETWORK_CONNECTIVITY_MANAGER_STATE(32),
    CUI_NAME_PRESENTATION(114),
    CUI_NAME_IMPRESSION(34),
    CUI_NAME_VIEW_SIGNALS(39),
    CUI_NAME_CLICK(35),
    CUI_NAME_CLICK_SIGNALS(40),
    CUI_NAME_NATIVE_AD_HANDLE_CLICK(44),
    CUI_NAME_NATIVE_AD_HANDLE_IMPRESSION(45),
    CUI_NAME_NATIVE_AD_SIGNAL(46),
    CUI_NAME_NATIVE_AD_HANDLE_MEDIA_VIEW_READY(123),
    CUI_NAME_NATIVE_AD_VIDEO_LOAD(58),
    CUI_NAME_NATIVE_AD_MEDIA_LOAD(61),
    CUI_NAME_LOAD_NATIVE_ASSETS(90),
    CUI_NAME_LOAD_NATIVE_IMAGE(91),
    CUI_NAME_LOAD_NATIVE_ICON(92),
    CUI_NAME_LOAD_NATIVE_ATTRIBUTION_INFO(93),
    CUI_NAME_LOAD_NATIVE_CUSTOM_ASSETS(94),
    CUI_NAME_LOAD_NATIVE_JS_ENGINE(59),
    CUI_NAME_LOAD_NATIVE_JSON_FROM_ARRAY(108),
    CUI_NAME_CONSENT_ALLOWLIST_UPDATE(42),
    CUI_NAME_CONSENT_STRING_READING(43),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(12),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(13),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(14),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(15),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(16),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(17),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(18),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(57),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(19),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(20),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(21),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(41),
    CUI_NAME_RTB_ADAPTER_SIGNALS(81),
    CUI_NAME_INSTALL_CRONET(82),
    CUI_NAME_CUSTOM_TABS_NAVIGATION_EVENT(83),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(84),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(85),
    CUI_NAME_LOG_EVENT_TO_FIREBASE_ANALYTICS(86),
    CUI_NAME_INIT_FIREBASE_ANALYTICS(87),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(118),
    CUI_NAME_PING_AND_EMIT_PAID_EVENT(122),
    CUI_NAME_POST_CLICK_LIFECYCLE_MONITORING(124),
    CUI_NAME_POST_CLICK_LIFECYCLE_MONITORING_INTERACTION(174),
    CUI_NAME_TWO_PIECE_EXPANDABLE_LOAD(126),
    CUI_NAME_INSTALL_REFERRER_TASK(UserVerificationMethods.USER_VERIFY_PATTERN),
    CUI_NAME_INSTALL_REFERRER_DETAILS(129),
    CUI_NAME_SIGNAL(23),
    CUI_NAME_SIGNAL_UPDATE_SIGNALS(112),
    CUI_NAME_SIGNAL_CACHE_REFRESH(116),
    CUI_NAME_GMSG(27),
    CUI_NAME_DEBUG_MENU(47),
    CUI_NAME_DEBUG_MENU_CREATIVE_PREVIEW(48),
    CUI_NAME_CREATIVE_PREVIEW_LINKING(49),
    CUI_NAME_DEBUG_MENU_DEBUG_SIGNALS(50),
    CUI_NAME_DEBUG_SIGNALS_LINKING(51),
    CUI_NAME_DEBUG_MENU_AD_INFO(52),
    CUI_NAME_DEBUG_MENU_INSPECTOR_SETTINGS(53),
    CUI_NAME_MRAID_STORE_PICTURE(56),
    CUI_NAME_LOAD_OMID_NATIVE_WEBVIEW(60),
    CUI_NAME_GET_TRUSTLESS_TOKEN(72),
    CUI_NAME_SHOW_AD_INSPECTOR(73),
    CUI_NAME_NATIVE_1_5_CLICK_WEBVIEW_CREATE(88),
    CUI_NAME_NATIVE_1_5_CLICK_WEBVIEW_LOAD(89),
    CUI_NAME_NATIVE_POLICY_VALIDATOR_WEBVIEW_CREATE(95),
    CUI_NAME_NATIVE_POLICY_VALIDATOR_WEBVIEW_LOAD(96),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(74),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(75),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(76),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(77),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(78),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(79),
    CUI_NAME_WEBVIEW_CALL_JS(80),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(137),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(138),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(97),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(98),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(99),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(100),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(101),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(102),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(103),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(139),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(125),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(134),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(135),
    CUI_NAME_CENTRALIZED_MANAGER_LIMIT_REACHED(136),
    CUI_NAME_CENTRALIZED_MANAGER_PAUSE_FOR_AD_SHOW(156),
    CUI_NAME_CENTRALIZED_MANAGER_RESUME_FOR_AD_CLOSE(157),
    CUI_NAME_PRELOAD_AD_CLOSE_TIMEOUT(158),
    CUI_NAME_OFFLINE_OPEN(104),
    CUI_NAME_BLOB_ENCRYPTION(105),
    CUI_NAME_ADREQUEST_BUILDURL_CLIENT(106),
    CUI_NAME_CONSENT_UPDATE_FOR_CSRB(107),
    CUI_NAME_LOAD_CONSENT_FROM_DISK(109),
    CUI_NAME_PLAY_PREWARM(117),
    CUI_NAME_ANR_DETECTED(119),
    CUI_NAME_LOAD_NATIVE_IMMERSIVE_VIDEO_MEDIA_DATA(ScopedSysTraceEvent.MAX_SECTION_NAME_LEN),
    CUI_NAME_ADREQUEST_CLIENT_REQUEST(140),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(141),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(142),
    CUI_NAME_PERSISTENT_CACHE_INIT(143),
    CUI_NAME_PERSISTENT_CACHE_LOAD(144),
    CUI_NAME_PERSISTENT_CACHE_METADATA_READ(145),
    CUI_NAME_PERSISTENT_CACHE_FILE_READ(146),
    CUI_NAME_PERSISTENT_CACHE_PUT(147),
    CUI_NAME_PERSISTENT_CACHE_METADATA_WRITE(148),
    CUI_NAME_PERSISTENT_CACHE_FILE_WRITE(149),
    CUI_NAME_PERSISTENT_CACHE_EVICT(150),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(151),
    CUI_NAME_PERSISTENT_CACHE_FILE_DELETE(152),
    CUI_NAME_PERSISTENT_CACHE_KEY_GENERATE(153),
    CUI_NAME_PERSISTENT_CACHE_EXPIRE(154),
    CUI_NAME_PERSISTENT_CACHE_CLEAR(155),
    CUI_NAME_PERSISTENT_CACHE_FILL_CHECK(159),
    CUI_NAME_PERSISTENT_CACHE_FILL(AdSize.WIDE_SKYSCRAPER_WIDTH),
    CUI_NAME_PERSISTENT_CACHE_AUTO_REFRESH(173),
    CUI_NAME_HSDP_SERVICE(162),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(163),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(164),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(171),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(172),
    /* JADX INFO: Fake field, exist only in values array */
    CUI_NAME_PRELOAD_VALIDATOR(175),
    CUI_NAME_AQM_URL_MACRO_EXPAND(176),
    CUI_NAME_AQM_URL_PING(177),
    UNRECOGNIZED(-1);

    public final int a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    s11(int i) {
        this.a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC3669jd0
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        yh1.a();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(s11.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(getNumber());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }
}
