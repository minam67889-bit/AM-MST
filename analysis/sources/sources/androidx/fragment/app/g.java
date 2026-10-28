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
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0450Qs;
import defpackage.AbstractC4607vs;
import defpackage.AbstractC4766xx;
import defpackage.C0191Gs;
import defpackage.C0338Mk;
import defpackage.C0424Ps;
import defpackage.C3754kl;
import defpackage.C7;
import defpackage.DialogC3365ff;
import defpackage.DialogInterfaceOnCancelListenerC3601il;
import defpackage.DialogInterfaceOnDismissListenerC3677jl;
import defpackage.MH;
import defpackage.T60;
import defpackage.UB;
import defpackage.VB;
import defpackage.WB;
import defpackage.XB;

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
    private Runnable mDismissRunnable = new C7(this, 6);
    private DialogInterface.OnCancelListener mOnCancelListener = new DialogInterfaceOnCancelListenerC3601il(this);
    private DialogInterface.OnDismissListener mOnDismissListener = new DialogInterfaceOnDismissListenerC3677jl(this);
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mCancelable = true;
    private boolean mShowsDialog = true;
    private int mBackStackId = -1;
    private MH mObserver = new C0338Mk(this);
    private boolean mDialogCreated = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public AbstractC4607vs createFragmentContainer() {
        return new C3754kl(this, super.createFragmentContainer());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dismiss() {
        f(false, false, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dismissAllowingStateLoss() {
        f(true, false, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dismissNow() {
        f(false, false, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
                    throw new IllegalArgumentException(T60.w(i, "Bad id: "));
                }
                parentFragmentManager.M(i, 1);
            } else {
                t parentFragmentManager2 = getParentFragmentManager();
                int i2 = this.mBackStackId;
                parentFragmentManager2.getClass();
                if (i2 < 0) {
                    throw new IllegalArgumentException(T60.w(i2, "Bad id: "));
                }
                parentFragmentManager2.v(new C0191Gs(parentFragmentManager2, i2), z);
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
        aVar.b(new C0424Ps(this, 3));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dialog getDialog() {
        return this.mDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getTheme() {
        return this.mTheme;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCancelable() {
        return this.mCancelable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void onAttach(Context context) {
        super.onAttach(context);
        XB viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        MH mh = this.mObserver;
        viewLifecycleOwnerLiveData.getClass();
        XB.a("observeForever");
        UB ub = new UB(viewLifecycleOwnerLiveData, mh);
        WB wb = (WB) viewLifecycleOwnerLiveData.b.a(mh, ub);
        if (wb instanceof VB) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (wb == null) {
            ub.a(true);
        }
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCancel(DialogInterface dialogInterface) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dialog onCreateDialog(Bundle bundle) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new DialogC3365ff(requireContext(), getTheme());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().g(this.mObserver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        f(true, true, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.mShowsDialog;
        if (!z || this.mCreatingDialog) {
            if (Log.isLoggable("FragmentManager", 2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                StringBuilder sb = !this.mShowsDialog ? new StringBuilder("mShowsDialog = false: ") : new StringBuilder("mCreatingDialog = true: ");
                sb.append(str);
                Log.d("FragmentManager", sb.toString());
            }
            return onGetLayoutInflater;
        }
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
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.mDialog;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onHasView() {
        return this.mDialogCreated;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            AbstractC4766xx.p(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStyle(int i, int i2) {
        if (Log.isLoggable("FragmentManager", 2)) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int show(AbstractC0450Qs abstractC0450Qs, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        abstractC0450Qs.c(0, this, str, 1);
        this.mViewDestroyed = false;
        int e = ((a) abstractC0450Qs).e(false);
        this.mBackStackId = e;
        return e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show(t tVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        tVar.getClass();
        a aVar = new a(tVar);
        aVar.o = true;
        aVar.c(0, this, str, 1);
        aVar.e(false);
    }
}
