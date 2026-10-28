package org.chromium.net;

import org.chromium.net.ExperimentalOptionsTranslator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements ExperimentalOptionsTranslator.JsonPatch {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ a(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.ExperimentalOptionsTranslator.JsonPatch
    public final void applyTo(JSONObject jSONObject) {
        switch (this.a) {
            case 0:
                ExperimentalOptionsTranslator.quicOptionsToJson(jSONObject, (QuicOptions) this.b);
                break;
            case 1:
                ExperimentalOptionsTranslator.connectionMigrationOptionsToJson(jSONObject, (ConnectionMigrationOptions) this.b);
                break;
            default:
                ExperimentalOptionsTranslator.dnsOptionsToJson(jSONObject, (DnsOptions) this.b);
                break;
        }
    }
}
