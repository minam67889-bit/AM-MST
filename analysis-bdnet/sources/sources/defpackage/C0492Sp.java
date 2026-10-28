package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import dastan.prince.bdfreevpn.R;
import java.util.HashMap;

/* renamed from: Sp, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0492Sp extends TX {
    public static final String[] C = {"android:visibility:visibility", "android:visibility:parent"};
    public final int B;

    public C0492Sp(int i) {
        this();
        this.B = i;
    }

    public static void J(C0889cY c0889cY) {
        int visibility = c0889cY.b.getVisibility();
        HashMap hashMap = c0889cY.a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = c0889cY.b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    public static float L(C0889cY c0889cY, float f) {
        Float f2;
        return (c0889cY == null || (f2 = (Float) c0889cY.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static T20 M(C0889cY c0889cY, C0889cY c0889cY2) {
        T20 t20 = new T20();
        t20.a = false;
        t20.b = false;
        if (c0889cY != null) {
            HashMap hashMap = c0889cY.a;
            if (hashMap.containsKey("android:visibility:visibility")) {
                t20.c = ((Integer) hashMap.get("android:visibility:visibility")).intValue();
                t20.e = (ViewGroup) hashMap.get("android:visibility:parent");
                if (c0889cY2 != null) {
                    HashMap hashMap2 = c0889cY2.a;
                    if (hashMap2.containsKey("android:visibility:visibility")) {
                        t20.d = ((Integer) hashMap2.get("android:visibility:visibility")).intValue();
                        t20.f = (ViewGroup) hashMap2.get("android:visibility:parent");
                        if (c0889cY == null && c0889cY2 != null) {
                            int i = t20.c;
                            int i2 = t20.d;
                            if (i != i2 || t20.e != t20.f) {
                                if (i != i2) {
                                    if (i == 0) {
                                        t20.b = false;
                                        t20.a = true;
                                        return t20;
                                    }
                                    if (i2 == 0) {
                                        t20.b = true;
                                        t20.a = true;
                                        return t20;
                                    }
                                } else {
                                    if (t20.f == null) {
                                        t20.b = false;
                                        t20.a = true;
                                        return t20;
                                    }
                                    if (t20.e == null) {
                                        t20.b = true;
                                        t20.a = true;
                                        return t20;
                                    }
                                }
                            }
                        } else {
                            if (c0889cY != null && t20.d == 0) {
                                t20.b = true;
                                t20.a = true;
                                return t20;
                            }
                            if (c0889cY2 == null && t20.c == 0) {
                                t20.b = false;
                                t20.a = true;
                            }
                        }
                        return t20;
                    }
                }
                t20.d = -1;
                t20.f = null;
                if (c0889cY == null) {
                }
                if (c0889cY != null) {
                }
                if (c0889cY2 == null) {
                    t20.b = false;
                    t20.a = true;
                }
                return t20;
            }
        }
        t20.c = -1;
        t20.e = null;
        if (c0889cY2 != null) {
        }
        t20.d = -1;
        t20.f = null;
        if (c0889cY == null) {
        }
        if (c0889cY != null) {
        }
        if (c0889cY2 == null) {
        }
        return t20;
    }

    public final ObjectAnimator K(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        E20.a.m(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, E20.b, f2);
        C0466Rp c0466Rp = new C0466Rp(view);
        ofFloat.addListener(c0466Rp);
        o().a(c0466Rp);
        return ofFloat;
    }

    @Override // defpackage.TX
    public final void d(C0889cY c0889cY) {
        J(c0889cY);
    }

    @Override // defpackage.TX
    public final void g(C0889cY c0889cY) {
        J(c0889cY);
        View view = c0889cY.b;
        Float f = (Float) view.getTag(R.id.transition_pause_alpha);
        if (f == null) {
            f = view.getVisibility() == 0 ? Float.valueOf(E20.a.l(view)) : Float.valueOf(0.0f);
        }
        c0889cY.a.put("android:fade:transitionAlpha", f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (M(n(r3, false), r(r3, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0  */
    @Override // defpackage.TX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Animator k(ViewGroup viewGroup, C0889cY c0889cY, C0889cY c0889cY2) {
        boolean z;
        View view;
        int i;
        int i2;
        char c;
        View view2;
        Animator animator;
        View view3;
        boolean z2;
        ViewGroup viewGroup2;
        int i3;
        Bitmap bitmap;
        int i4 = this.B;
        T20 M = M(c0889cY, c0889cY2);
        if (M.a && (M.e != null || M.f != null)) {
            int i5 = 0;
            if (!M.b) {
                int i6 = M.d;
                if ((i4 & 2) == 2 && c0889cY != null) {
                    View view4 = c0889cY2 != null ? c0889cY2.b : null;
                    View view5 = c0889cY.b;
                    View view6 = (View) view5.getTag(R.id.save_overlay_view);
                    if (view6 != null) {
                        i = i6;
                        i2 = 0;
                        i5 = 1;
                        c = 1;
                        view3 = null;
                        animator = null;
                    } else {
                        if (view4 == null || view4.getParent() == null) {
                            if (view4 != null) {
                                z = false;
                                view = null;
                                if (z) {
                                    if (view5.getParent() == null) {
                                        i = i6;
                                        i2 = 0;
                                        c = 1;
                                        view3 = view;
                                        animator = null;
                                        view6 = view5;
                                    } else if (view5.getParent() instanceof View) {
                                        View view7 = (View) view5.getParent();
                                        animator = null;
                                        i2 = 0;
                                        if (M(r(view7, true), n(view7, true)).a) {
                                            i = i6;
                                            c = 1;
                                            view2 = view;
                                            int id = view7.getId();
                                            if (view7.getParent() == null && id != -1) {
                                                viewGroup.findViewById(id);
                                            }
                                            view6 = view4;
                                            i5 = i2;
                                            view3 = view2;
                                        } else {
                                            boolean z3 = AbstractC0810bY.a;
                                            Matrix matrix = new Matrix();
                                            matrix.setTranslate(-view7.getScrollX(), -view7.getScrollY());
                                            M20 m20 = E20.a;
                                            m20.p(view5, matrix);
                                            m20.q(viewGroup, matrix);
                                            RectF rectF = new RectF(0.0f, 0.0f, view5.getWidth(), view5.getHeight());
                                            matrix.mapRect(rectF);
                                            int round = Math.round(rectF.left);
                                            int round2 = Math.round(rectF.top);
                                            c = 1;
                                            int round3 = Math.round(rectF.right);
                                            int round4 = Math.round(rectF.bottom);
                                            ImageView imageView = new ImageView(view5.getContext());
                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            boolean isAttachedToWindow = view5.isAttachedToWindow();
                                            boolean z4 = viewGroup != null && viewGroup.isAttachedToWindow();
                                            if (isAttachedToWindow) {
                                                z2 = isAttachedToWindow;
                                                viewGroup2 = null;
                                                i3 = 0;
                                            } else if (z4) {
                                                viewGroup2 = (ViewGroup) view5.getParent();
                                                int indexOfChild = viewGroup2.indexOfChild(view5);
                                                z2 = isAttachedToWindow;
                                                viewGroup.getOverlay().add(view5);
                                                i3 = indexOfChild;
                                            } else {
                                                i = i6;
                                                view2 = view;
                                                bitmap = null;
                                                if (bitmap != null) {
                                                    imageView.setImageBitmap(bitmap);
                                                }
                                                imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                                imageView.layout(round, round2, round3, round4);
                                                view6 = imageView;
                                                i5 = i2;
                                                view3 = view2;
                                            }
                                            view2 = view;
                                            int round5 = Math.round(rectF.width());
                                            i = i6;
                                            int round6 = Math.round(rectF.height());
                                            if (round5 <= 0 || round6 <= 0) {
                                                bitmap = null;
                                            } else {
                                                float min = Math.min(1.0f, 1048576.0f / (round5 * round6));
                                                int round7 = Math.round(round5 * min);
                                                int round8 = Math.round(round6 * min);
                                                matrix.postTranslate(-rectF.left, -rectF.top);
                                                matrix.postScale(min, min);
                                                if (AbstractC0810bY.a) {
                                                    Picture picture = new Picture();
                                                    Canvas beginRecording = picture.beginRecording(round7, round8);
                                                    beginRecording.concat(matrix);
                                                    view5.draw(beginRecording);
                                                    picture.endRecording();
                                                    bitmap = AbstractC0730aY.a(picture);
                                                } else {
                                                    bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                                                    Canvas canvas = new Canvas(bitmap);
                                                    canvas.concat(matrix);
                                                    view5.draw(canvas);
                                                }
                                            }
                                            if (!z2) {
                                                viewGroup.getOverlay().remove(view5);
                                                viewGroup2.addView(view5, i3);
                                            }
                                            if (bitmap != null) {
                                            }
                                            imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                            imageView.layout(round, round2, round3, round4);
                                            view6 = imageView;
                                            i5 = i2;
                                            view3 = view2;
                                        }
                                    }
                                }
                                i = i6;
                                i2 = 0;
                                c = 1;
                                view2 = view;
                                animator = null;
                                view6 = view4;
                                i5 = i2;
                                view3 = view2;
                            }
                        } else if (i6 == 4 || view5 == view4) {
                            view = view4;
                            z = false;
                            view4 = null;
                            if (z) {
                            }
                            i = i6;
                            i2 = 0;
                            c = 1;
                            view2 = view;
                            animator = null;
                            view6 = view4;
                            i5 = i2;
                            view3 = view2;
                        }
                        z = true;
                        view4 = null;
                        view = null;
                        if (z) {
                        }
                        i = i6;
                        i2 = 0;
                        c = 1;
                        view2 = view;
                        animator = null;
                        view6 = view4;
                        i5 = i2;
                        view3 = view2;
                    }
                    if (view6 == null) {
                        if (view3 == null) {
                            return animator;
                        }
                        int visibility = view3.getVisibility();
                        E20.b(view3, i2);
                        M20 m202 = E20.a;
                        m202.getClass();
                        ObjectAnimator K = K(view3, L(c0889cY, 1.0f), 0.0f);
                        if (K == null) {
                            m202.m(view3, L(c0889cY2, 1.0f));
                        }
                        if (K == null) {
                            E20.b(view3, visibility);
                            return K;
                        }
                        R20 r20 = new R20(view3, i);
                        K.addListener(r20);
                        o().a(r20);
                        return K;
                    }
                    if (i5 == 0) {
                        int[] iArr = (int[]) c0889cY.a.get("android:visibility:screenLocation");
                        int i7 = iArr[i2];
                        int i8 = iArr[c];
                        int[] iArr2 = new int[2];
                        viewGroup.getLocationOnScreen(iArr2);
                        view6.offsetLeftAndRight((i7 - iArr2[i2]) - view6.getLeft());
                        view6.offsetTopAndBottom((i8 - iArr2[c]) - view6.getTop());
                        viewGroup.getOverlay().add(view6);
                    }
                    M20 m203 = E20.a;
                    m203.getClass();
                    ObjectAnimator K2 = K(view6, L(c0889cY, 1.0f), 0.0f);
                    if (K2 == null) {
                        m203.m(view6, L(c0889cY2, 1.0f));
                    }
                    if (i5 == 0) {
                        if (K2 == null) {
                            viewGroup.getOverlay().remove(view6);
                            return K2;
                        }
                        view5.setTag(R.id.save_overlay_view, view6);
                        S20 s20 = new S20(this, viewGroup, view6, view5);
                        K2.addListener(s20);
                        K2.addPauseListener(s20);
                        o().a(s20);
                    }
                    return K2;
                }
            } else if ((i4 & 1) == 1 && c0889cY2 != null) {
                View view8 = c0889cY2.b;
                if (c0889cY == null) {
                    View view9 = (View) view8.getParent();
                }
                E20.a.getClass();
                return K(view8, L(c0889cY, 0.0f), 1.0f);
            }
        }
        return null;
    }

    @Override // defpackage.TX
    public final String[] q() {
        return C;
    }

    @Override // defpackage.TX
    public final boolean s(C0889cY c0889cY, C0889cY c0889cY2) {
        if (c0889cY == null && c0889cY2 == null) {
            return false;
        }
        if (c0889cY != null && c0889cY2 != null && c0889cY2.a.containsKey("android:visibility:visibility") != c0889cY.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        T20 M = M(c0889cY, c0889cY2);
        if (M.a) {
            return M.c == 0 || M.d == 0;
        }
        return false;
    }

    public C0492Sp() {
        this.B = 3;
    }
}
