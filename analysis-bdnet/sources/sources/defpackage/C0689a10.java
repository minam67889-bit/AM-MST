package defpackage;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;

/* renamed from: a10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0689a10 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;

    public C0689a10(View view, EditText editText, EditText editText2) {
        this.a = view;
        this.b = editText;
        this.c = editText2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean isChecked = compoundButton.isChecked();
        View view = this.a;
        if (isChecked) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        if (z) {
            return;
        }
        try {
            this.b.setText(Deobfuscator$BDNETVPN$app.getString(-19077576619915L));
            this.c.setText(Deobfuscator$BDNETVPN$app.getString(-19081871587211L));
        } catch (Exception unused) {
        }
    }
}
