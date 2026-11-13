package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import prince.dastan.vpn.activities.AppListActivity;
import prince.dastan.vpn.view.MaterialEditText;

/* renamed from: h6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3172h6 implements TextWatcher {
    public final /* synthetic */ int a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ C3172h6(KeyEvent.Callback callback, int i) {
        this.a = i;
        this.b = callback;
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.a;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        switch (this.a) {
            case 0:
                ((AppListActivity) this.b).b.b(charSequence.toString());
                break;
            default:
                int length = charSequence.length();
                MaterialEditText materialEditText = (MaterialEditText) this.b;
                if (length <= 0) {
                    materialEditText.b(false);
                    break;
                } else {
                    materialEditText.b(true);
                    break;
                }
        }
    }
}
