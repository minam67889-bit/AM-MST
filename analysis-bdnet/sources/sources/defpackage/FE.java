package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.g;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.material.internal.CheckableImageButton;
import dastan.prince.bdfreevpn.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.achartengine.renderer.DefaultRenderer;

/* loaded from: classes.dex */
public class FE<S> extends g {
    public final LinkedHashSet a;
    public final LinkedHashSet b;
    public int c;
    public AbstractC0716aK d;
    public C0115Eb e;
    public C4608zE f;
    public int g;
    public CharSequence h;
    public boolean i;
    public int j;
    public int k;
    public CharSequence l;
    public int m;
    public CharSequence n;
    public int o;
    public CharSequence p;
    public int q;
    public CharSequence r;
    public TextView s;
    public TextView t;
    public CheckableImageButton u;
    public JE v;
    public boolean w;
    public CharSequence x;
    public CharSequence y;

    public FE() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
    }

    public static int h(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar b = AbstractC3717o00.b();
        b.set(5, 1);
        Calendar a = AbstractC3717o00.a(b);
        a.get(2);
        a.get(1);
        int maximum = a.getMaximum(7);
        a.getActualMaximum(5);
        a.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean i(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AbstractC0731aZ.c0(context, R.attr.materialCalendarStyle, C4608zE.class.getCanonicalName()).data, new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void g() {
        if (getArguments().getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.g, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.c = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.e = (C0115Eb) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.g = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.h = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.j = bundle.getInt("INPUT_MODE_KEY");
        this.k = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.l = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.m = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.n = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.o = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.p = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.q = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.r = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.h;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.g);
        }
        this.x = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.y = charSequence;
    }

    @Override // androidx.fragment.app.g
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        requireContext();
        int i = this.c;
        if (i == 0) {
            g();
            throw null;
        }
        Dialog dialog = new Dialog(requireContext, i);
        Context context = dialog.getContext();
        this.i = i(context, android.R.attr.windowFullscreen);
        this.v = new JE(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, FM.o, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.v.k(context);
        this.v.n(ColorStateList.valueOf(color));
        this.v.m(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.l
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.i ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.i) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(h(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(h(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.t = textView;
        textView.setAccessibilityLiveRegion(1);
        this.u = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.s = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.u.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.u;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, XE.k(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], XE.k(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.u.setChecked(this.j != 0);
        AbstractC2925e20.m(this.u, null);
        CheckableImageButton checkableImageButton2 = this.u;
        this.u.setContentDescription(this.j == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.u.setOnClickListener(new ViewOnClickListenerC0169Gd(this, 2));
        g();
        throw null;
    }

    @Override // androidx.fragment.app.g, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.c);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        C0115Eb c0115Eb = this.e;
        C0089Db c0089Db = new C0089Db();
        int i = C0089Db.b;
        int i2 = C0089Db.b;
        long j = c0115Eb.a.f;
        long j2 = c0115Eb.b.f;
        c0089Db.a = Long.valueOf(c0115Eb.d.f);
        C4608zE c4608zE = this.f;
        C3821pG c3821pG = c4608zE == null ? null : c4608zE.d;
        if (c3821pG != null) {
            c0089Db.a = Long.valueOf(c3821pG.f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", c0115Eb.c);
        C3821pG b = C3821pG.b(j);
        C3821pG b2 = C3821pG.b(j2);
        C0460Rj c0460Rj = (C0460Rj) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = c0089Db.a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new C0115Eb(b, b2, c0460Rj, l == null ? null : C3821pG.b(l.longValue()), c0115Eb.e));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.g);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.h);
        bundle.putInt("INPUT_MODE_KEY", this.j);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.k);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.l);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.m);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.n);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.o);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.p);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.q);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.r);
    }

    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.i) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.v);
            if (!this.w) {
                View findViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList o = AbstractC3634my.o(findViewById.getBackground());
                Integer valueOf = o != null ? Integer.valueOf(o.getDefaultColor()) : null;
                boolean z = false;
                boolean z2 = valueOf == null || valueOf.intValue() == 0;
                int t = S50.t(window.getContext(), android.R.attr.colorBackground, DefaultRenderer.BACKGROUND_COLOR);
                if (z2) {
                    valueOf = Integer.valueOf(t);
                }
                M30.g(window, false);
                window.getContext();
                int d = Build.VERSION.SDK_INT < 27 ? AbstractC0118Ee.d(S50.t(window.getContext(), android.R.attr.navigationBarColor, DefaultRenderer.BACKGROUND_COLOR), UserVerificationMethods.USER_VERIFY_PATTERN) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(d);
                boolean z3 = S50.x(0) || S50.x(valueOf.intValue());
                QO qo = new QO(window.getDecorView());
                int i = Build.VERSION.SDK_INT;
                (i >= 35 ? new C4435x40(window, qo) : i >= 30 ? new C4356w40(window, qo) : i >= 26 ? new C4277v40(window, qo) : new C4198u40(window, qo)).q(z3);
                boolean x = S50.x(t);
                if (S50.x(d) || (d == 0 && x)) {
                    z = true;
                }
                QO qo2 = new QO(window.getDecorView());
                int i2 = Build.VERSION.SDK_INT;
                (i2 >= 35 ? new C4435x40(window, qo2) : i2 >= 30 ? new C4356w40(window, qo2) : i2 >= 26 ? new C4277v40(window, qo2) : new C4198u40(window, qo2)).p(z);
                EE ee = new EE(findViewById, findViewById.getLayoutParams().height, findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight());
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                W10.c(findViewById, ee);
                this.w = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.v, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC4422wx(requireDialog(), rect));
        }
        requireContext();
        int i3 = this.c;
        if (i3 == 0) {
            g();
            throw null;
        }
        g();
        C0115Eb c0115Eb = this.e;
        C4608zE c4608zE = new C4608zE();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i3);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0115Eb);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", c0115Eb.d);
        c4608zE.setArguments(bundle);
        this.f = c4608zE;
        AbstractC0716aK abstractC0716aK = c4608zE;
        if (this.j == 1) {
            g();
            C0115Eb c0115Eb2 = this.e;
            AbstractC0716aK ke = new KE();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i3);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0115Eb2);
            ke.setArguments(bundle2);
            abstractC0716aK = ke;
        }
        this.d = abstractC0716aK;
        this.s.setText((this.j == 1 && getResources().getConfiguration().orientation == 2) ? this.y : this.x);
        g();
        getContext();
        throw null;
    }

    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onStop() {
        this.d.a.clear();
        super.onStop();
    }
}
