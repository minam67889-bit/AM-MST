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
import android.view.WindowInsetsController;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.g;
import app.vpn.amtunnellite.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.achartengine.renderer.DefaultRenderer;

/* loaded from: classes.dex */
public class OD<S> extends g {
    public final LinkedHashSet a;
    public final LinkedHashSet b;
    public int c;
    public AbstractC3339fJ d;
    public C4203qb e;
    public ID f;
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
    public UD v;
    public boolean w;
    public CharSequence x;
    public CharSequence y;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OD() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int h(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar c = RZ.c();
        c.set(5, 1);
        Calendar b = RZ.b(c);
        b.get(2);
        b.get(1);
        int maximum = b.getMaximum(7);
        b.getActualMaximum(5);
        b.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean i(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AbstractC0427Pv.O(context, R.attr.materialCalendarStyle, ID.class.getCanonicalName()).data, new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g() {
        F40.n(getArguments().getParcelable("DATE_SELECTOR_KEY"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.c = bundle.getInt("OVERRIDE_THEME_RES_ID");
        F40.n(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.e = (C4203qb) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        F40.n(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        requireContext();
        int i = this.c;
        if (i != 0) {
            Dialog dialog = new Dialog(requireContext, i);
            Context context = dialog.getContext();
            this.i = i(context, android.R.attr.windowFullscreen);
            this.v = new UD(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, CL.o, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
            int color = obtainStyledAttributes.getColor(1, 0);
            obtainStyledAttributes.recycle();
            this.v.l(context);
            this.v.o(ColorStateList.valueOf(color));
            this.v.n(dialog.getWindow().getDecorView().getElevation());
            return dialog;
        }
        g();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        View findViewById;
        LinearLayout.LayoutParams layoutParams;
        int i2;
        if (this.i) {
            i = R.layout.mtrl_picker_fullscreen;
        } else {
            i = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i, viewGroup);
        Context context = inflate.getContext();
        if (this.i) {
            findViewById = inflate.findViewById(R.id.mtrl_calendar_frame);
            layoutParams = new LinearLayout.LayoutParams(h(context), -2);
        } else {
            findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            layoutParams = new LinearLayout.LayoutParams(h(context), -1);
        }
        findViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.t = textView;
        textView.setAccessibilityLiveRegion(1);
        this.u = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.s = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.u.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.u;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AbstractC4766xx.D(context, R.drawable.material_ic_calendar_black_24dp));
        boolean z = false;
        stateListDrawable.addState(new int[0], AbstractC4766xx.D(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.u;
        if (this.j != 0) {
            z = true;
        }
        checkableImageButton2.setChecked(z);
        T00.l(this.u, null);
        CheckableImageButton checkableImageButton3 = this.u;
        int i3 = this.j;
        Context context2 = checkableImageButton3.getContext();
        if (i3 == 1) {
            i2 = R.string.mtrl_picker_toggle_to_calendar_input_mode;
        } else {
            i2 = R.string.mtrl_picker_toggle_to_text_input_mode;
        }
        this.u.setContentDescription(context2.getString(i2));
        this.u.setOnClickListener(new ViewOnClickListenerC4360sd(this, 2));
        g();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onSaveInstanceState(Bundle bundle) {
        AF af;
        AF b;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.c);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        C4203qb c4203qb = this.e;
        C4126pb c4126pb = new C4126pb();
        int i = C4126pb.b;
        int i2 = C4126pb.b;
        long j = c4203qb.a.f;
        long j2 = c4203qb.b.f;
        c4126pb.a = Long.valueOf(c4203qb.d.f);
        ID id = this.f;
        if (id == null) {
            af = null;
        } else {
            af = id.d;
        }
        if (af != null) {
            c4126pb.a = Long.valueOf(af.f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", c4203qb.c);
        AF b2 = AF.b(j);
        AF b3 = AF.b(j2);
        C0286Kj c0286Kj = (C0286Kj) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = c4126pb.a;
        if (l == null) {
            b = null;
        } else {
            b = AF.b(l.longValue());
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new C4203qb(b2, b3, c0286Kj, b, c4203qb.e));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21, types: [d30] */
    /* JADX WARN: Type inference failed for: r4v24, types: [d30] */
    /* JADX WARN: Type inference failed for: r8v10, types: [d30] */
    /* JADX WARN: Type inference failed for: r8v13, types: [d30] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onStart() {
        CharSequence charSequence;
        Integer num;
        boolean z;
        int i;
        boolean z2;
        WindowInsetsController insetsController;
        C0789b30 c0789b30;
        WindowInsetsController insetsController2;
        C0789b30 c0789b302;
        WindowInsetsController insetsController3;
        WindowInsetsController insetsController4;
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.i) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.v);
            if (!this.w) {
                View findViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList r = AbstractC0427Pv.r(findViewById.getBackground());
                if (r != null) {
                    num = Integer.valueOf(r.getDefaultColor());
                } else {
                    num = null;
                }
                boolean z3 = false;
                if (num != null && num.intValue() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                int A = AbstractC4766xx.A(window.getContext(), android.R.attr.colorBackground, DefaultRenderer.BACKGROUND_COLOR);
                if (z) {
                    num = Integer.valueOf(A);
                }
                C20.q(window, false);
                window.getContext();
                Context context = window.getContext();
                if (Build.VERSION.SDK_INT < 27) {
                    i = AbstractC4132pe.d(AbstractC4766xx.A(context, android.R.attr.navigationBarColor, DefaultRenderer.BACKGROUND_COLOR), UserVerificationMethods.USER_VERIFY_PATTERN);
                } else {
                    i = 0;
                }
                window.setStatusBarColor(0);
                window.setNavigationBarColor(i);
                boolean G = AbstractC4766xx.G(num.intValue());
                if (!AbstractC4766xx.G(0) && !G) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                VP vp = new VP(window.getDecorView());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 35) {
                    insetsController4 = window.getInsetsController();
                    ?? c3240e30 = new C3240e30(insetsController4, vp);
                    c3240e30.g = window;
                    c0789b30 = c3240e30;
                } else if (i2 >= 30) {
                    insetsController = window.getInsetsController();
                    ?? c3164d30 = new C3164d30(insetsController, vp);
                    c3164d30.g = window;
                    c0789b30 = c3164d30;
                } else if (i2 >= 26) {
                    c0789b30 = new C0866c30(window, vp);
                } else {
                    c0789b30 = new C0789b30(window, vp);
                }
                c0789b30.i(z2);
                boolean G2 = AbstractC4766xx.G(A);
                if (AbstractC4766xx.G(i) || (i == 0 && G2)) {
                    z3 = true;
                }
                VP vp2 = new VP(window.getDecorView());
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 35) {
                    insetsController3 = window.getInsetsController();
                    ?? c3240e302 = new C3240e30(insetsController3, vp2);
                    c3240e302.g = window;
                    c0789b302 = c3240e302;
                } else if (i3 >= 30) {
                    insetsController2 = window.getInsetsController();
                    ?? c3164d302 = new C3164d30(insetsController2, vp2);
                    c3164d302.g = window;
                    c0789b302 = c3164d302;
                } else if (i3 >= 26) {
                    c0789b302 = new C0866c30(window, vp2);
                } else {
                    c0789b302 = new C0789b30(window, vp2);
                }
                c0789b302.h(z3);
                ND nd = new ND(findViewById, findViewById.getLayoutParams().height, findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight());
                WeakHashMap weakHashMap = T00.a;
                L00.k(findViewById, nd);
                this.w = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.v, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC0195Gw(requireDialog(), rect));
        }
        requireContext();
        int i4 = this.c;
        if (i4 != 0) {
            g();
            C4203qb c4203qb = this.e;
            ID id = new ID();
            Bundle bundle = new Bundle();
            bundle.putInt("THEME_RES_ID_KEY", i4);
            bundle.putParcelable("GRID_SELECTOR_KEY", null);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c4203qb);
            bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
            bundle.putParcelable("CURRENT_MONTH_KEY", c4203qb.d);
            id.setArguments(bundle);
            this.f = id;
            AbstractC3339fJ abstractC3339fJ = id;
            if (this.j == 1) {
                g();
                C4203qb c4203qb2 = this.e;
                AbstractC3339fJ vd = new VD();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("THEME_RES_ID_KEY", i4);
                bundle2.putParcelable("DATE_SELECTOR_KEY", null);
                bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", c4203qb2);
                vd.setArguments(bundle2);
                abstractC3339fJ = vd;
            }
            this.d = abstractC3339fJ;
            TextView textView = this.s;
            if (this.j == 1 && getResources().getConfiguration().orientation == 2) {
                charSequence = this.y;
            } else {
                charSequence = this.x;
            }
            textView.setText(charSequence);
            g();
            getContext();
            throw null;
        }
        g();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.g, androidx.fragment.app.l
    public final void onStop() {
        this.d.a.clear();
        super.onStop();
    }
}
