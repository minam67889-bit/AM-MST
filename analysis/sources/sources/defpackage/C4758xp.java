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
import app.vpn.amtunnellite.R;
import java.util.HashMap;

/* renamed from: xp, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4758xp extends XW {
    public static final String[] C = {"android:visibility:visibility", "android:visibility:parent"};
    public final int B;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4758xp() {
        this.B = 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void J(C3430gX c3430gX) {
        int visibility = c3430gX.b.getVisibility();
        HashMap hashMap = c3430gX.a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = c3430gX.b;
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float L(C3430gX c3430gX, float f) {
        Float f2;
        if (c3430gX != null && (f2 = (Float) c3430gX.a.get("android:fade:transitionAlpha")) != null) {
            return f2.floatValue();
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r9 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        if (r0.e == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
    
        if (r0.c == 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0058 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static G10 M(C3430gX c3430gX, C3430gX c3430gX2) {
        G10 g10 = new G10();
        g10.a = false;
        g10.b = false;
        ViewGroup viewGroup = null;
        if (c3430gX != null) {
            HashMap hashMap = c3430gX.a;
            if (hashMap.containsKey("android:visibility:visibility")) {
                g10.c = ((Integer) hashMap.get("android:visibility:visibility")).intValue();
                g10.e = (ViewGroup) hashMap.get("android:visibility:parent");
                if (c3430gX2 != null) {
                    HashMap hashMap2 = c3430gX2.a;
                    if (hashMap2.containsKey("android:visibility:visibility")) {
                        g10.d = ((Integer) hashMap2.get("android:visibility:visibility")).intValue();
                        viewGroup = (ViewGroup) hashMap2.get("android:visibility:parent");
                        g10.f = viewGroup;
                        if (c3430gX == null && c3430gX2 != null) {
                            int i = g10.c;
                            int i2 = g10.d;
                            if (i == i2 && g10.e == g10.f) {
                                return g10;
                            }
                            if (i != i2) {
                                if (i != 0) {
                                }
                                g10.b = false;
                            } else {
                                if (g10.f != null) {
                                }
                                g10.b = false;
                            }
                        } else {
                            if (c3430gX == null || g10.d != 0) {
                                if (c3430gX2 == null) {
                                }
                                return g10;
                            }
                            g10.b = true;
                        }
                        g10.a = true;
                        return g10;
                    }
                }
                g10.d = -1;
                g10.f = viewGroup;
                if (c3430gX == null) {
                }
                if (c3430gX == null) {
                }
                if (c3430gX2 == null) {
                }
                return g10;
            }
        }
        g10.c = -1;
        g10.e = null;
        if (c3430gX2 != null) {
        }
        g10.d = -1;
        g10.f = viewGroup;
        if (c3430gX == null) {
        }
        if (c3430gX == null) {
        }
        if (c3430gX2 == null) {
        }
        return g10;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ObjectAnimator K(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        AbstractC4234r10.a.i(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AbstractC4234r10.b, f2);
        C4681wp c4681wp = new C4681wp(view);
        ofFloat.addListener(c4681wp);
        o().a(c4681wp);
        return ofFloat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.XW
    public final void d(C3430gX c3430gX) {
        J(c3430gX);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.XW
    public final void g(C3430gX c3430gX) {
        float f;
        J(c3430gX);
        View view = c3430gX.b;
        Float f2 = (Float) view.getTag(R.id.transition_pause_alpha);
        if (f2 == null) {
            if (view.getVisibility() == 0) {
                f = AbstractC4234r10.a.h(view);
            } else {
                f = 0.0f;
            }
            f2 = Float.valueOf(f);
        }
        c3430gX.a.put("android:fade:transitionAlpha", f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (M(n(r3, false), r(r3, false)).a != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.XW
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Animator k(ViewGroup viewGroup, C3430gX c3430gX, C3430gX c3430gX2) {
        View view;
        boolean z;
        View view2;
        int i;
        View view3;
        View view4;
        ViewGroup viewGroup2;
        int i2;
        Bitmap bitmap;
        int i3 = this.B;
        G10 M = M(c3430gX, c3430gX2);
        if (!M.a || (M.e == null && M.f == null)) {
            return null;
        }
        boolean z2 = false;
        if (M.b) {
            if ((i3 & 1) == 1 && c3430gX2 != null) {
                View view5 = c3430gX2.b;
                if (c3430gX == null) {
                    View view6 = (View) view5.getParent();
                }
                AbstractC4234r10.a.getClass();
                return K(view5, L(c3430gX, 0.0f), 1.0f);
            }
            return null;
        }
        int i4 = M.d;
        if ((i3 & 2) == 2 && c3430gX != null) {
            if (c3430gX2 != null) {
                view = c3430gX2.b;
            } else {
                view = null;
            }
            View view7 = c3430gX.b;
            View view8 = (View) view7.getTag(R.id.save_overlay_view);
            if (view8 != null) {
                i = i4;
                z2 = true;
                view4 = null;
            } else {
                if (view != null && view.getParent() != null) {
                    if (i4 == 4 || view7 == view) {
                        view2 = view;
                        z = false;
                        view = null;
                        if (z) {
                        }
                        i = i4;
                        view3 = view2;
                        view8 = view;
                        view4 = view3;
                        z2 = false;
                    }
                } else if (view != null) {
                    z = false;
                    view2 = null;
                    if (z) {
                        if (view7.getParent() == null) {
                            i = i4;
                            view4 = view2;
                            view8 = view7;
                        } else if (view7.getParent() instanceof View) {
                            View view9 = (View) view7.getParent();
                            if (!M(r(view9, true), n(view9, true)).a) {
                                boolean z3 = AbstractC3353fX.a;
                                Matrix matrix = new Matrix();
                                matrix.setTranslate(-view9.getScrollX(), -view9.getScrollY());
                                C4850z10 c4850z10 = AbstractC4234r10.a;
                                c4850z10.l(view7, matrix);
                                c4850z10.m(viewGroup, matrix);
                                RectF rectF = new RectF(0.0f, 0.0f, view7.getWidth(), view7.getHeight());
                                matrix.mapRect(rectF);
                                int round = Math.round(rectF.left);
                                int round2 = Math.round(rectF.top);
                                int round3 = Math.round(rectF.right);
                                int round4 = Math.round(rectF.bottom);
                                ImageView imageView = new ImageView(view7.getContext());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                boolean z4 = !view7.isAttachedToWindow();
                                boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
                                if (z4) {
                                    if (!isAttachedToWindow) {
                                        i = i4;
                                        view3 = view2;
                                        bitmap = null;
                                        if (bitmap != null) {
                                            imageView.setImageBitmap(bitmap);
                                        }
                                        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                        imageView.layout(round, round2, round3, round4);
                                        view8 = imageView;
                                        view4 = view3;
                                        z2 = false;
                                    } else {
                                        ViewGroup viewGroup3 = (ViewGroup) view7.getParent();
                                        int indexOfChild = viewGroup3.indexOfChild(view7);
                                        viewGroup.getOverlay().add(view7);
                                        viewGroup2 = viewGroup3;
                                        view3 = view2;
                                        i2 = indexOfChild;
                                    }
                                } else {
                                    view3 = view2;
                                    viewGroup2 = null;
                                    i2 = 0;
                                }
                                i = i4;
                                int round5 = Math.round(rectF.width());
                                int round6 = Math.round(rectF.height());
                                if (round5 > 0 && round6 > 0) {
                                    float min = Math.min(1.0f, 1048576.0f / (round5 * round6));
                                    int round7 = Math.round(round5 * min);
                                    int round8 = Math.round(round6 * min);
                                    matrix.postTranslate(-rectF.left, -rectF.top);
                                    matrix.postScale(min, min);
                                    if (AbstractC3353fX.a) {
                                        Picture picture = new Picture();
                                        Canvas beginRecording = picture.beginRecording(round7, round8);
                                        beginRecording.concat(matrix);
                                        view7.draw(beginRecording);
                                        picture.endRecording();
                                        bitmap = AbstractC3276eX.a(picture);
                                    } else {
                                        bitmap = Bitmap.createBitmap(round7, round8, Bitmap.Config.ARGB_8888);
                                        Canvas canvas = new Canvas(bitmap);
                                        canvas.concat(matrix);
                                        view7.draw(canvas);
                                    }
                                } else {
                                    bitmap = null;
                                }
                                if (z4) {
                                    viewGroup.getOverlay().remove(view7);
                                    viewGroup2.addView(view7, i2);
                                }
                                if (bitmap != null) {
                                }
                                imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
                                imageView.layout(round, round2, round3, round4);
                                view8 = imageView;
                                view4 = view3;
                                z2 = false;
                            } else {
                                i = i4;
                                view3 = view2;
                                int id = view9.getId();
                                if (view9.getParent() == null && id != -1) {
                                    viewGroup.findViewById(id);
                                }
                                view8 = view;
                                view4 = view3;
                                z2 = false;
                            }
                        }
                    }
                    i = i4;
                    view3 = view2;
                    view8 = view;
                    view4 = view3;
                    z2 = false;
                }
                z = true;
                view = null;
                view2 = null;
                if (z) {
                }
                i = i4;
                view3 = view2;
                view8 = view;
                view4 = view3;
                z2 = false;
            }
            if (view8 != null) {
                if (!z2) {
                    int[] iArr = (int[]) c3430gX.a.get("android:visibility:screenLocation");
                    int i5 = iArr[0];
                    int i6 = iArr[1];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr2);
                    view8.offsetLeftAndRight((i5 - iArr2[0]) - view8.getLeft());
                    view8.offsetTopAndBottom((i6 - iArr2[1]) - view8.getTop());
                    viewGroup.getOverlay().add(view8);
                }
                C4850z10 c4850z102 = AbstractC4234r10.a;
                c4850z102.getClass();
                ObjectAnimator K = K(view8, L(c3430gX, 1.0f), 0.0f);
                if (K == null) {
                    c4850z102.i(view8, L(c3430gX2, 1.0f));
                }
                if (!z2) {
                    if (K == null) {
                        viewGroup.getOverlay().remove(view8);
                        return K;
                    }
                    view7.setTag(R.id.save_overlay_view, view8);
                    F10 f10 = new F10(this, viewGroup, view8, view7);
                    K.addListener(f10);
                    K.addPauseListener(f10);
                    o().a(f10);
                    return K;
                }
                return K;
            }
            if (view4 != null) {
                int visibility = view4.getVisibility();
                AbstractC4234r10.b(view4, 0);
                C4850z10 c4850z103 = AbstractC4234r10.a;
                c4850z103.getClass();
                ObjectAnimator K2 = K(view4, L(c3430gX, 1.0f), 0.0f);
                if (K2 == null) {
                    c4850z103.i(view4, L(c3430gX2, 1.0f));
                }
                if (K2 != null) {
                    E10 e10 = new E10(view4, i);
                    K2.addListener(e10);
                    o().a(e10);
                } else {
                    AbstractC4234r10.b(view4, visibility);
                }
                return K2;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.XW
    public final String[] q() {
        return C;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.XW
    public final boolean s(C3430gX c3430gX, C3430gX c3430gX2) {
        if (c3430gX == null && c3430gX2 == null) {
            return false;
        }
        if (c3430gX != null && c3430gX2 != null && c3430gX2.a.containsKey("android:visibility:visibility") != c3430gX.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        G10 M = M(c3430gX, c3430gX2);
        if (!M.a) {
            return false;
        }
        if (M.c != 0 && M.d != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4758xp(int i) {
        this();
        this.B = i;
    }
}
