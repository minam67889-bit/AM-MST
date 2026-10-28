package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC3411gE;
import defpackage.C4142po;

/* loaded from: classes.dex */
public final class d extends e {
    public boolean c;
    public boolean d;
    public C4142po e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final C4142po c(Context context) {
        Animation loadAnimation;
        C4142po c4142po;
        int i;
        int i2;
        if (this.d) {
            return this.e;
        }
        z zVar = this.a;
        l lVar = zVar.c;
        boolean z = zVar.a == 2;
        int nextTransition = lVar.getNextTransition();
        int popEnterAnim = this.c ? z ? lVar.getPopEnterAnim() : lVar.getPopExitAnim() : z ? lVar.getEnterAnim() : lVar.getExitAnim();
        lVar.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = lVar.mContainer;
        C4142po c4142po2 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            lVar.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = lVar.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation onCreateAnimation = lVar.onCreateAnimation(nextTransition, z, popEnterAnim);
            if (onCreateAnimation != null) {
                c4142po2 = new C4142po(onCreateAnimation);
            } else {
                Animator onCreateAnimator = lVar.onCreateAnimator(nextTransition, z, popEnterAnim);
                if (onCreateAnimator != null) {
                    c4142po2 = new C4142po(onCreateAnimator, 2);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        if (nextTransition == 4097) {
                            i = z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                        } else if (nextTransition != 8194) {
                            if (nextTransition == 8197) {
                                i2 = z ? android.R.attr.activityCloseEnterAnimation : android.R.attr.activityCloseExitAnimation;
                            } else if (nextTransition == 4099) {
                                i = z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                            } else if (nextTransition != 4100) {
                                i = -1;
                            } else {
                                i2 = z ? android.R.attr.activityOpenEnterAnimation : android.R.attr.activityOpenExitAnimation;
                            }
                            i = AbstractC3411gE.K0(context, i2);
                        } else {
                            i = z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                        }
                        popEnterAnim = i;
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
                                    c4142po = new C4142po(loadAnimation);
                                    c4142po2 = c4142po;
                                }
                            }
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                            if (loadAnimator != null) {
                                c4142po = new C4142po(loadAnimator, 2);
                                c4142po2 = c4142po;
                            }
                        } catch (RuntimeException e2) {
                            if (equals) {
                                throw e2;
                            }
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                            if (loadAnimation2 != null) {
                                c4142po2 = new C4142po(loadAnimation2);
                            }
                        }
                    }
                }
            }
        }
        this.e = c4142po2;
        this.d = true;
        return c4142po2;
    }
}
