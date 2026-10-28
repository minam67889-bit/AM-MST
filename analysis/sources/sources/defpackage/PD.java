package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import prince.udp.vpn.view.MaterialEditText;

/* loaded from: classes2.dex */
public final class PD implements TextWatcher {
    public final /* synthetic */ MaterialEditText a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PD(MaterialEditText materialEditText) {
        this.a = materialEditText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        int length = charSequence.length();
        MaterialEditText materialEditText = this.a;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        materialEditText.c(z);
    }
}
