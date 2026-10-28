package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0651Ys;
import defpackage.AbstractC3634my;
import defpackage.AbstractC4181tt;
import defpackage.C0136Ew;
import defpackage.C3390jt;
import defpackage.C3779ol;
import defpackage.C4102st;
import defpackage.DialogC4403wf;
import defpackage.DialogInterfaceOnCancelListenerC3481l10;
import defpackage.DialogInterfaceOnDismissListenerC3700nl;
import defpackage.JI;
import defpackage.MC;
import defpackage.NC;
import defpackage.OC;
import defpackage.PC;
import defpackage.S7;
import defpackage.W50;

/* loaded from: classes.dex */
public class g extends l implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDismissed;
    private Handler mHandler;
    private boolean mShownByMe;
    private boolean mViewDestroyed;
    private Runnable mDismissRunnable = new S7(this, 5);
    private DialogInterface.OnCancelListener mOnCancelListener = new DialogInterfaceOnCancelListenerC3481l10(this, 2);
    private DialogInterface.OnDismissListener mOnDismissListener = new DialogInterfaceOnDismissListenerC3700nl(this);
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mCancelable = true;
    private boolean mShowsDialog = true;
    private int mBackStackId = -1;
    private JI mObserver = new C0136Ew(this, 13);
    private boolean mDialogCreated = false;

    @Override // androidx.fragment.app.l
    public AbstractC0651Ys createFragmentContainer() {
        return new C3779ol(this, super.createFragmentContainer());
    }

    public void dismiss() {
        f(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        f(true, false, false);
    }

    public void dismissNow() {
        f(false, false, true);
    }

    public final void f(boolean z, boolean z2, boolean z3) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            if (z3) {
                t parentFragmentManager = getParentFragmentManager();
                int i = this.mBackStackId;
                if (i < 0) {
                    parentFragmentManager.getClass();
                    throw new IllegalArgumentException(W50.i(i, "Bad id: "));
                }
                parentFragmentManager.N(i, 1);
            } else {
                t parentFragmentManager2 = getParentFragmentManager();
                int i2 = this.mBackStackId;
                parentFragmentManager2.getClass();
                if (i2 < 0) {
                    throw new IllegalArgumentException(W50.i(i2, "Bad id: "));
                }
                parentFragmentManager2.v(new C3390jt(parentFragmentManager2, i2), z);
            }
            this.mBackStackId = -1;
            return;
        }
        t parentFragmentManager3 = getParentFragmentManager();
        parentFragmentManager3.getClass();
        a aVar = new a(parentFragmentManager3);
        aVar.o = true;
        t tVar = this.mFragmentManager;
        t tVar2 = aVar.p;
        if (tVar != null && tVar != tVar2) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new C4102st(this, 3));
        if (z3) {
            if (aVar.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            tVar2.y(aVar, false);
        } else if (z) {
            aVar.e(true);
        } else {
            aVar.e(false);
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.l
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.l
    public void onAttach(Context context) {
        super.onAttach(context);
        PC viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        JI ji = this.mObserver;
        viewLifecycleOwnerLiveData.getClass();
        PC.a("observeForever");
        MC mc = new MC(viewLifecycleOwnerLiveData, ji);
        OC oc = (OC) viewLifecycleOwnerLiveData.b.a(ji, mc);
        if (oc instanceof NC) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (oc == null) {
            mc.a(true);
        }
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.l
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (t.G(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new DialogC4403wf(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.l
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.l
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().g(this.mObserver);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (t.G(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        f(true, true, false);
    }

    public View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.l
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.mShowsDialog;
        if (z && !this.mCreatingDialog) {
            if (z && !this.mDialogCreated) {
                try {
                    this.mCreatingDialog = true;
                    Dialog onCreateDialog = onCreateDialog(bundle);
                    this.mDialog = onCreateDialog;
                    if (this.mShowsDialog) {
                        setupDialog(onCreateDialog, this.mStyle);
                        Context context = getContext();
                        if (context instanceof Activity) {
                            this.mDialog.setOwnerActivity((Activity) context);
                        }
                        this.mDialog.setCancelable(this.mCancelable);
                        this.mDialog.setOnCancelListener(this.mOnCancelListener);
                        this.mDialog.setOnDismissListener(this.mOnDismissListener);
                        this.mDialogCreated = true;
                    } else {
                        this.mDialog = null;
                    }
                    this.mCreatingDialog = false;
                } catch (Throwable th) {
                    this.mCreatingDialog = false;
                    throw th;
                }
            }
            if (t.G(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                return onGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (t.G(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.mShowsDialog) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return onGetLayoutInflater;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.l
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.l
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            AbstractC3634my.g(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.l
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.l
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.l
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public void setStyle(int i, int i2) {
        if (t.G(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = android.R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(t tVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        tVar.getClass();
        a aVar = new a(tVar);
        aVar.o = true;
        aVar.c(0, this, str, 1);
        aVar.e(false);
    }

    public void showNow(t tVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        tVar.getClass();
        a aVar = new a(tVar);
        aVar.o = true;
        aVar.c(0, this, str, 1);
        if (aVar.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        aVar.p.y(aVar, false);
    }

    public int show(AbstractC4181tt abstractC4181tt, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        abstractC4181tt.c(0, this, str, 1);
        this.mViewDestroyed = false;
        int e = ((a) abstractC4181tt).e(false);
        this.mBackStackId = e;
        return e;
    }
}
