package defpackage;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import java.util.ArrayList;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class KI implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ UDPClient b;

    public /* synthetic */ KI(UDPClient uDPClient, int i) {
        this.a = i;
        this.b = uDPClient;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final int i = 1;
        final int i2 = 0;
        switch (this.a) {
            case 0:
                String str = UDPClient.Z;
                final UDPClient uDPClient = this.b;
                final C2507db a = C2507db.a(uDPClient.getApplicationContext());
                C3114p1 c3114p1 = new C3114p1(uDPClient, 2132017475);
                String string = "Select DNS";
                C2902l1 c2902l1 = (C2902l1) c3114p1.c;
                c2902l1.e = string;
                c2902l1.n = false;
                View inflate = LayoutInflater.from(uDPClient.getApplicationContext()).inflate(2131558466, (ViewGroup) null);
                c2902l1.r = inflate;
                final Spinner spinner = (Spinner) inflate.findViewById(2131362036);
                TextView textView = (TextView) inflate.findViewById(2131361984);
                TextView textView2 = (TextView) inflate.findViewById(2131361983);
                final EditText editText = (EditText) inflate.findViewById(2131361982);
                uDPClient.F = new ArrayList();
                C2481d1 c2481d1 = new C2481d1(uDPClient, uDPClient.F);
                uDPClient.G = c2481d1;
                spinner.setAdapter((SpinnerAdapter) c2481d1);
                spinner.setOnTouchListener(new View.OnTouchListener() { // from class: CI
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        Spinner spinner2 = spinner;
                        UDPClient uDPClient2 = uDPClient;
                        switch (i2) {
                            case 0:
                                String str2 = UDPClient.Z;
                                uDPClient2.getClass();
                                if (motionEvent.getAction() == 1) {
                                    uDPClient2.y(spinner2, "ocspdoq");
                                }
                                return true;
                            default:
                                String str3 = UDPClient.Z;
                                uDPClient2.getClass();
                                if (motionEvent.getAction() == 1) {
                                    uDPClient2.y(spinner2, "ocsslow");
                                }
                                return true;
                        }
                    }
                });
                uDPClient.s("ocspdoq");
                try {
                    a.getClass();
                    spinner.setSelection(a.a.getInt("NETWORK_SELECTED_POSITION", 0));
                } catch (IndexOutOfBoundsException unused) {
                    spinner.setSelection(0);
                }
                textView.setVisibility(8);
                textView2.setVisibility(8);
                editText.setVisibility(8);
                spinner.setOnItemSelectedListener(new QI(uDPClient, textView, textView2, editText, a, 0));
                final int i3 = 1;
                c3114p1.f("Cancel", new DialogInterface.OnClickListener() { // from class: yI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        switch (i3) {
                            case 0:
                                String str2 = UDPClient.Z;
                                dialogInterface.dismiss();
                                return;
                            default:
                                String str3 = UDPClient.Z;
                                dialogInterface.dismiss();
                                return;
                        }
                    }
                });
                c2902l1.h = "OK";
                c2902l1.i = null;
                final DialogInterfaceC3167q1 a2 = c3114p1.a();
                final int i4 = 1;
                a2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zI
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        switch (i4) {
                            case 0:
                                String str2 = UDPClient.Z;
                                final UDPClient uDPClient2 = uDPClient;
                                uDPClient2.getClass();
                                final DialogInterfaceC3167q1 dialogInterfaceC3167q1 = a2;
                                Button button = dialogInterfaceC3167q1.f.k;
                                final C2507db c2507db = a;
                                final Spinner spinner2 = spinner;
                                final EditText editText2 = editText;
                                final int i5 = 1;
                                button.setOnClickListener(new View.OnClickListener() { // from class: BI
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        long j;
                                        switch (i5) {
                                            case 0:
                                                UDPClient uDPClient3 = uDPClient2;
                                                boolean z = uDPClient3.V;
                                                C2507db c2507db2 = c2507db;
                                                if (z) {
                                                    String obj = editText2.getText().toString();
                                                    if (!UDPClient.q(obj)) {
                                                        j = 750675802870804980L;
                                                    } else if (obj.endsWith(";")) {
                                                        j = 750675721266426356L;
                                                    } else {
                                                        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = c2507db2.b;
                                                        sharedPreferencesEditorC2544eC.putString("PDOQ_CUSTOM_DNS", obj);
                                                        sharedPreferencesEditorC2544eC.apply();
                                                        c2507db2.g(true);
                                                    }
                                                    uDPClient3.f(Deobfuscator$AMTUNNELLITE$app.getString(j));
                                                    return;
                                                }
                                                if (!uDPClient3.U) {
                                                    AbstractC2879kf.V(uDPClient3.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition = spinner2.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC2 = c2507db2.b;
                                                sharedPreferencesEditorC2544eC2.putInt("NETWORK_SELECTED_POSITION", selectedItemPosition);
                                                sharedPreferencesEditorC2544eC2.apply();
                                                dialogInterfaceC3167q1.dismiss();
                                                return;
                                            default:
                                                UDPClient uDPClient4 = uDPClient2;
                                                boolean z2 = uDPClient4.W;
                                                C2507db c2507db3 = c2507db;
                                                if (z2) {
                                                    String obj2 = editText2.getText().toString();
                                                    if (!UDPClient.o(obj2)) {
                                                        uDPClient4.f("Invalid DNS Protocol!");
                                                        return;
                                                    }
                                                    SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC3 = c2507db3.b;
                                                    sharedPreferencesEditorC2544eC3.putString("SUPER_CUSTOM_DNS", obj2);
                                                    sharedPreferencesEditorC2544eC3.apply();
                                                    c2507db3.h(true);
                                                } else if (!uDPClient4.U) {
                                                    AbstractC2879kf.V(uDPClient4.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition2 = spinner2.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC4 = c2507db3.b;
                                                sharedPreferencesEditorC2544eC4.putInt("SUPER_NETWORK_SELECTED_POSITION", selectedItemPosition2);
                                                sharedPreferencesEditorC2544eC4.apply();
                                                dialogInterfaceC3167q1.dismiss();
                                                return;
                                        }
                                    }
                                });
                                return;
                            default:
                                String str3 = UDPClient.Z;
                                final UDPClient uDPClient3 = uDPClient;
                                uDPClient3.getClass();
                                final DialogInterfaceC3167q1 dialogInterfaceC3167q12 = a2;
                                Button button2 = dialogInterfaceC3167q12.f.k;
                                final C2507db c2507db2 = a;
                                final Spinner spinner3 = spinner;
                                final EditText editText3 = editText;
                                final int i6 = 0;
                                button2.setOnClickListener(new View.OnClickListener() { // from class: BI
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        long j;
                                        switch (i6) {
                                            case 0:
                                                UDPClient uDPClient32 = uDPClient3;
                                                boolean z = uDPClient32.V;
                                                C2507db c2507db22 = c2507db2;
                                                if (z) {
                                                    String obj = editText3.getText().toString();
                                                    if (!UDPClient.q(obj)) {
                                                        j = 750675802870804980L;
                                                    } else if (obj.endsWith(";")) {
                                                        j = 750675721266426356L;
                                                    } else {
                                                        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = c2507db22.b;
                                                        sharedPreferencesEditorC2544eC.putString("PDOQ_CUSTOM_DNS", obj);
                                                        sharedPreferencesEditorC2544eC.apply();
                                                        c2507db22.g(true);
                                                    }
                                                    uDPClient32.f(Deobfuscator$AMTUNNELLITE$app.getString(j));
                                                    return;
                                                }
                                                if (!uDPClient32.U) {
                                                    AbstractC2879kf.V(uDPClient32.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition = spinner3.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC2 = c2507db22.b;
                                                sharedPreferencesEditorC2544eC2.putInt("NETWORK_SELECTED_POSITION", selectedItemPosition);
                                                sharedPreferencesEditorC2544eC2.apply();
                                                dialogInterfaceC3167q12.dismiss();
                                                return;
                                            default:
                                                UDPClient uDPClient4 = uDPClient3;
                                                boolean z2 = uDPClient4.W;
                                                C2507db c2507db3 = c2507db2;
                                                if (z2) {
                                                    String obj2 = editText3.getText().toString();
                                                    if (!UDPClient.o(obj2)) {
                                                        uDPClient4.f("Invalid DNS Protocol!");
                                                        return;
                                                    }
                                                    SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC3 = c2507db3.b;
                                                    sharedPreferencesEditorC2544eC3.putString("SUPER_CUSTOM_DNS", obj2);
                                                    sharedPreferencesEditorC2544eC3.apply();
                                                    c2507db3.h(true);
                                                } else if (!uDPClient4.U) {
                                                    AbstractC2879kf.V(uDPClient4.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition2 = spinner3.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC4 = c2507db3.b;
                                                sharedPreferencesEditorC2544eC4.putInt("SUPER_NETWORK_SELECTED_POSITION", selectedItemPosition2);
                                                sharedPreferencesEditorC2544eC4.apply();
                                                dialogInterfaceC3167q12.dismiss();
                                                return;
                                        }
                                    }
                                });
                                return;
                        }
                    }
                });
                a2.show();
                return;
            default:
                String str2 = UDPClient.Z;
                final UDPClient uDPClient2 = this.b;
                final C2507db a3 = C2507db.a(uDPClient2.getApplicationContext());
                C3114p1 c3114p12 = new C3114p1(uDPClient2, 2132017475);
                String string2 = "Select DNS";
                C2902l1 c2902l12 = (C2902l1) c3114p12.c;
                c2902l12.e = string2;
                c2902l12.n = false;
                View inflate2 = LayoutInflater.from(uDPClient2.getApplicationContext()).inflate(2131558467, (ViewGroup) null);
                c2902l12.r = inflate2;
                final Spinner spinner2 = (Spinner) inflate2.findViewById(2131362489);
                TextView textView3 = (TextView) inflate2.findViewById(2131361995);
                TextView textView4 = (TextView) inflate2.findViewById(2131361994);
                final EditText editText2 = (EditText) inflate2.findViewById(2131361993);
                ScrollableNumberPicker scrollableNumberPicker = (ScrollableNumberPicker) inflate2.findViewById(2131362113);
                scrollableNumberPicker.setListener(new C2701hA(a3, 7));
                try {
                    a3.getClass();
                    scrollableNumberPicker.setValue(a3.a.getInt("SUPER_DNS_FREQUENCY", 0));
                } catch (IndexOutOfBoundsException unused2) {
                    scrollableNumberPicker.setValue(0);
                }
                uDPClient2.F = new ArrayList();
                C2481d1 c2481d12 = new C2481d1(uDPClient2, uDPClient2.F);
                uDPClient2.G = c2481d12;
                spinner2.setAdapter((SpinnerAdapter) c2481d12);
                spinner2.setOnTouchListener(new View.OnTouchListener() { // from class: CI
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        Spinner spinner22 = spinner2;
                        UDPClient uDPClient22 = uDPClient2;
                        switch (i) {
                            case 0:
                                String str22 = UDPClient.Z;
                                uDPClient22.getClass();
                                if (motionEvent.getAction() == 1) {
                                    uDPClient22.y(spinner22, "ocspdoq");
                                }
                                return true;
                            default:
                                String str3 = UDPClient.Z;
                                uDPClient22.getClass();
                                if (motionEvent.getAction() == 1) {
                                    uDPClient22.y(spinner22, "ocsslow");
                                }
                                return true;
                        }
                    }
                });
                uDPClient2.s("ocsslow");
                try {
                    a3.getClass();
                    spinner2.setSelection(a3.a.getInt("SUPER_NETWORK_SELECTED_POSITION", 0));
                } catch (IndexOutOfBoundsException unused3) {
                    spinner2.setSelection(0);
                }
                textView3.setVisibility(8);
                textView4.setVisibility(8);
                editText2.setVisibility(8);
                spinner2.setOnItemSelectedListener(new QI(uDPClient2, textView3, textView4, editText2, a3, 1));
                c3114p12.f("Cancel", new DialogInterface.OnClickListener() { // from class: yI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i42) {
                        switch (i2) {
                            case 0:
                                String str22 = UDPClient.Z;
                                dialogInterface.dismiss();
                                return;
                            default:
                                String str3 = UDPClient.Z;
                                dialogInterface.dismiss();
                                return;
                        }
                    }
                });
                c2902l12.h = "OK";
                c2902l12.i = null;
                final DialogInterfaceC3167q1 a4 = c3114p12.a();
                final int i5 = 0;
                a4.setOnShowListener(new DialogInterface.OnShowListener() { // from class: zI
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        switch (i5) {
                            case 0:
                                String str22 = UDPClient.Z;
                                final UDPClient uDPClient22 = uDPClient2;
                                uDPClient22.getClass();
                                final DialogInterfaceC3167q1 dialogInterfaceC3167q1 = a4;
                                Button button = dialogInterfaceC3167q1.f.k;
                                final C2507db c2507db = a3;
                                final Spinner spinner22 = spinner2;
                                final EditText editText22 = editText2;
                                final int i52 = 1;
                                button.setOnClickListener(new View.OnClickListener() { // from class: BI
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        long j;
                                        switch (i52) {
                                            case 0:
                                                UDPClient uDPClient32 = uDPClient22;
                                                boolean z = uDPClient32.V;
                                                C2507db c2507db22 = c2507db;
                                                if (z) {
                                                    String obj = editText22.getText().toString();
                                                    if (!UDPClient.q(obj)) {
                                                        j = 750675802870804980L;
                                                    } else if (obj.endsWith(";")) {
                                                        j = 750675721266426356L;
                                                    } else {
                                                        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = c2507db22.b;
                                                        sharedPreferencesEditorC2544eC.putString("PDOQ_CUSTOM_DNS", obj);
                                                        sharedPreferencesEditorC2544eC.apply();
                                                        c2507db22.g(true);
                                                    }
                                                    uDPClient32.f(Deobfuscator$AMTUNNELLITE$app.getString(j));
                                                    return;
                                                }
                                                if (!uDPClient32.U) {
                                                    AbstractC2879kf.V(uDPClient32.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition = spinner22.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC2 = c2507db22.b;
                                                sharedPreferencesEditorC2544eC2.putInt("NETWORK_SELECTED_POSITION", selectedItemPosition);
                                                sharedPreferencesEditorC2544eC2.apply();
                                                dialogInterfaceC3167q1.dismiss();
                                                return;
                                            default:
                                                UDPClient uDPClient4 = uDPClient22;
                                                boolean z2 = uDPClient4.W;
                                                C2507db c2507db3 = c2507db;
                                                if (z2) {
                                                    String obj2 = editText22.getText().toString();
                                                    if (!UDPClient.o(obj2)) {
                                                        uDPClient4.f("Invalid DNS Protocol!");
                                                        return;
                                                    }
                                                    SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC3 = c2507db3.b;
                                                    sharedPreferencesEditorC2544eC3.putString("SUPER_CUSTOM_DNS", obj2);
                                                    sharedPreferencesEditorC2544eC3.apply();
                                                    c2507db3.h(true);
                                                } else if (!uDPClient4.U) {
                                                    AbstractC2879kf.V(uDPClient4.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition2 = spinner22.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC4 = c2507db3.b;
                                                sharedPreferencesEditorC2544eC4.putInt("SUPER_NETWORK_SELECTED_POSITION", selectedItemPosition2);
                                                sharedPreferencesEditorC2544eC4.apply();
                                                dialogInterfaceC3167q1.dismiss();
                                                return;
                                        }
                                    }
                                });
                                return;
                            default:
                                String str3 = UDPClient.Z;
                                final UDPClient uDPClient3 = uDPClient2;
                                uDPClient3.getClass();
                                final DialogInterfaceC3167q1 dialogInterfaceC3167q12 = a4;
                                Button button2 = dialogInterfaceC3167q12.f.k;
                                final C2507db c2507db2 = a3;
                                final Spinner spinner3 = spinner2;
                                final EditText editText3 = editText2;
                                final int i6 = 0;
                                button2.setOnClickListener(new View.OnClickListener() { // from class: BI
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        long j;
                                        switch (i6) {
                                            case 0:
                                                UDPClient uDPClient32 = uDPClient3;
                                                boolean z = uDPClient32.V;
                                                C2507db c2507db22 = c2507db2;
                                                if (z) {
                                                    String obj = editText3.getText().toString();
                                                    if (!UDPClient.q(obj)) {
                                                        j = 750675802870804980L;
                                                    } else if (obj.endsWith(";")) {
                                                        j = 750675721266426356L;
                                                    } else {
                                                        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = c2507db22.b;
                                                        sharedPreferencesEditorC2544eC.putString("PDOQ_CUSTOM_DNS", obj);
                                                        sharedPreferencesEditorC2544eC.apply();
                                                        c2507db22.g(true);
                                                    }
                                                    uDPClient32.f(Deobfuscator$AMTUNNELLITE$app.getString(j));
                                                    return;
                                                }
                                                if (!uDPClient32.U) {
                                                    AbstractC2879kf.V(uDPClient32.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition = spinner3.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC2 = c2507db22.b;
                                                sharedPreferencesEditorC2544eC2.putInt("NETWORK_SELECTED_POSITION", selectedItemPosition);
                                                sharedPreferencesEditorC2544eC2.apply();
                                                dialogInterfaceC3167q12.dismiss();
                                                return;
                                            default:
                                                UDPClient uDPClient4 = uDPClient3;
                                                boolean z2 = uDPClient4.W;
                                                C2507db c2507db3 = c2507db2;
                                                if (z2) {
                                                    String obj2 = editText3.getText().toString();
                                                    if (!UDPClient.o(obj2)) {
                                                        uDPClient4.f("Invalid DNS Protocol!");
                                                        return;
                                                    }
                                                    SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC3 = c2507db3.b;
                                                    sharedPreferencesEditorC2544eC3.putString("SUPER_CUSTOM_DNS", obj2);
                                                    sharedPreferencesEditorC2544eC3.apply();
                                                    c2507db3.h(true);
                                                } else if (!uDPClient4.U) {
                                                    AbstractC2879kf.V(uDPClient4.getApplicationContext(), "No DNS found!");
                                                    return;
                                                }
                                                int selectedItemPosition2 = spinner3.getSelectedItemPosition();
                                                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC4 = c2507db3.b;
                                                sharedPreferencesEditorC2544eC4.putInt("SUPER_NETWORK_SELECTED_POSITION", selectedItemPosition2);
                                                sharedPreferencesEditorC2544eC4.apply();
                                                dialogInterfaceC3167q12.dismiss();
                                                return;
                                        }
                                    }
                                });
                                return;
                        }
                    }
                });
                a4.show();
                return;
        }
    }
}
