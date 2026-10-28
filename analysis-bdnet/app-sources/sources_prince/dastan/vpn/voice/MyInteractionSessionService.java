package prince.dastan.vpn.voice;

import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;
import defpackage.C3425kH;

/* loaded from: classes2.dex */
public class MyInteractionSessionService extends VoiceInteractionSessionService {
    @Override // android.service.voice.VoiceInteractionSessionService
    public final VoiceInteractionSession onNewSession(Bundle bundle) {
        C3425kH c3425kH = new C3425kH(this);
        c3425kH.a = bundle;
        return c3425kH;
    }
}
