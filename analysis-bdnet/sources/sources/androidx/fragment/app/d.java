package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import dastan.prince.bdfreevpn.R;
import defpackage.C0595Wo;
import defpackage.XE;

/* loaded from: classes.dex */
public final class d extends e {
    public boolean c;
    public boolean d;
    public C0595Wo e;

    public final C0595Wo c(Context context) {
        Animation loadAnimation;
        C0595Wo c0595Wo;
        if (this.d) {
            return this.e;
        }
        z zVar = this.a;
        boolean z = zVar.a == 2;
        l lVar = zVar.c;
        int nextTransition = lVar.getNextTransition();
        int popEnterAnim = this.c ? z ? lVar.getPopEnterAnim() : lVar.getPopExitAnim() : z ? lVar.getEnterAnim() : lVar.getExitAnim();
        lVar.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = lVar.mContainer;
        C0595Wo c0595Wo2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            lVar.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = lVar.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = lVar.onCreateAnimation(nextTransition, z, popEnterAnim);
            if (onCreateAnimation != null) {
                c0595Wo2 = new C0595Wo(onCreateAnimation, 3);
            } else {
                Animator onCreateAnimator = lVar.onCreateAnimator(nextTransition, z, popEnterAnim);
                if (onCreateAnimator != null) {
                    c0595Wo2 = new C0595Wo(onCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z ? XE.y(context, android.R.attr.activityOpenEnterAnimation) : XE.y(context, android.R.attr.activityOpenExitAnimation) : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z ? XE.y(context, android.R.attr.activityCloseEnterAnimation) : XE.y(context, android.R.attr.activityCloseExitAnimation) : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean equals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        try {
                            if (equals) {
                                try {
                                    loadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                }
                                if (loadAnimation != null) {
                                    c0595Wo = new C0595Wo(loadAnimation, 3);
                                    c0595Wo2 = c0595Wo;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                            if (loadAnimator != null) {
                                c0595Wo = new C0595Wo(loadAnimator);
                                c0595Wo2 = c0595Wo;
                            }
                        } catch (RuntimeException e2) {
                            if (equals) {
                                throw e2;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                            if (loadAnimation2 != null) {
                                c0595Wo2 = new C0595Wo(loadAnimation2, 3);
                            }
                        }
                    }
                }
            }
        }
        this.e = c0595Wo2;
        this.d = true;
        return c0595Wo2;
    }
}
