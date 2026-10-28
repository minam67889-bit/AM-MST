package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.AdSize;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.AppListActivity;
import prince.dastan.vpn.activities.IPHunterActivity;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.activities.VPNShareActivity;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: Kr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0287Kr extends View {
    public InterfaceC0261Jr A;
    public final int a;
    public final Paint b;
    public final Path c;
    public final Camera d;
    public final Matrix e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final int l;
    public final RectF m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final View u;
    public final ArrayList v;
    public final ArrayList w;
    public int x;
    public final ArrayList y;
    public final ObjectAnimator z;

    public C0287Kr(Context context, Window window, View view) {
        super(context);
        this.a = 0;
        this.h = 0;
        this.i = AdSize.MEDIUM_RECTANGLE_WIDTH;
        this.j = 16777215;
        this.k = 0;
        this.l = a(0.4f);
        int a = a(140.0f);
        this.n = a;
        this.o = a(50.0f);
        this.p = a(0.0f);
        this.q = a(50.0f);
        this.r = a(6.0f);
        this.s = a(4.0f);
        int a2 = a(5.0f);
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = 0;
        this.y = new ArrayList();
        this.u = view;
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = getResources().getDisplayMetrics().heightPixels;
        this.m = new RectF(0.0f, 0.0f, i, i2);
        window.addContentView(this, new WindowManager.LayoutParams(-1, -1));
        this.c = new Path();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setTextSize((int) ((10.0f * getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f));
        this.d = new Camera();
        this.e = new Matrix();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.z = ofFloat;
        ofFloat.setDuration(200L);
        this.z.addListener(new C0157Fr(this));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int left = view.getLeft();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[1];
        int i4 = measuredHeight / 2;
        int i5 = i3 - i4;
        int i6 = i4 + i3;
        int i7 = (measuredWidth / 2) + left;
        if (i3 < i2 / 2) {
            this.a = 1;
            int a3 = a(5.0f) + i6;
            this.q = a3;
            this.t = a(6.0f) + a3;
        } else {
            this.a = 2;
            int a4 = i5 - a(5.0f);
            this.q = a4;
            this.t = a4 - a(6.0f);
        }
        int i8 = a / 2;
        if (i8 + i7 > i) {
            this.p = (i - a) - a2;
            return;
        }
        int i9 = i7 - i8;
        if (i9 < 0) {
            this.p = a2;
        } else {
            this.p = i9;
        }
    }

    public final int a(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Canvas canvas, int i) {
        ArrayList arrayList = this.v;
        KS ks = (KS) arrayList.get(i);
        if (ks.c != null) {
            int i2 = this.p + this.n;
            int i3 = this.o;
            int i4 = i3 / 2;
            float a = (i2 - i4) - a(6.0f);
            int i5 = this.a;
            Bitmap bitmap = ks.c;
            if (i5 == 1) {
                float f = (i * i3) + (i3 / 4) + this.t;
                float f2 = i4;
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(a, f, a + f2, f2 + f), this.b);
                return;
            }
            if (i5 == 2) {
                float size = this.t - ((((arrayList.size() - i) - 1) * i3) + (i3 / 4));
                float f3 = i4;
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(a - f3, size - f3, a, size), this.b);
            }
        }
    }

    public final void c(Canvas canvas, int i) {
        KS ks = (KS) this.v.get(i);
        Paint paint = this.b;
        ks.getClass();
        paint.setColor(-1);
        int i2 = this.a;
        int i3 = this.o;
        if (i2 == 1) {
            String str = ks.a;
            float a = a(8.0f) + this.p;
            float f = this.t;
            String str2 = ks.a;
            this.b.getTextBounds(str2, 0, str2.length(), new Rect());
            canvas.drawText(str, a, ((r9.height() / 1.1f) / 2.0f) + f + (i3 / 2) + (i * i3), this.b);
            return;
        }
        if (i2 == 2) {
            String str3 = ks.a;
            float a2 = a(8.0f) + this.p;
            float f2 = this.t;
            String str4 = ks.a;
            this.b.getTextBounds(str4, 0, str4.length(), new Rect());
            canvas.drawText(str3, a2, (((r11.height() / 1.1f) / 2.0f) + f2) - ((((r0.size() - i) - 1) * i3) + (i3 / 2)), this.b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0431  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int i4 = this.a;
        int i5 = this.r;
        int i6 = this.s;
        View view = this.u;
        int i7 = this.o;
        int i8 = this.n;
        ArrayList arrayList = this.v;
        ArrayList arrayList2 = this.w;
        int i9 = 1;
        int i10 = 2;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            this.b.setColor(this.j);
            canvas2.drawRect(this.m, this.b);
            arrayList2.clear();
            int size = arrayList.size() - 1;
            while (size >= 0) {
                canvas2.save();
                this.d.save();
                if (size < (arrayList.size() - this.h) - i9) {
                    this.d.restore();
                    canvas2.restore();
                    i2 = i9;
                    i3 = size;
                } else {
                    if (size == (arrayList.size() - this.h) - i9) {
                        int i11 = this.x;
                        if (i11 == i9) {
                            this.d.rotateY(this.f);
                        } else if (i11 == 0) {
                            this.d.rotateX(this.f);
                        } else if (i11 == i10) {
                            this.d.rotateZ(this.f);
                        }
                    } else {
                        int i12 = this.x;
                        if (i12 == i9) {
                            this.d.rotateY(this.g / 2.0f);
                        } else if (i12 == 0) {
                            this.d.rotateX(this.g);
                        } else if (i12 == i10) {
                            this.d.rotateZ(this.g / 4.0f);
                        }
                    }
                    this.d.getMatrix(this.e);
                    if (this.x == i10) {
                        int i13 = i8 / 2;
                        this.e.preTranslate(-(this.p + i13), (-i7) / i10);
                        this.e.postTranslate(i13 + this.p, i7 / 2);
                    } else {
                        int i14 = i8 / 2;
                        this.e.preTranslate(-(this.p + i14), -(this.q - (((arrayList.size() - size) - 1) * i7)));
                        this.e.postTranslate(i14 + this.p, this.q - (((arrayList.size() - size) - i9) * i7));
                    }
                    canvas2.concat(this.e);
                    this.b.setColor(((KS) arrayList.get(size)).b);
                    if (size == arrayList.size() - i9) {
                        this.c.reset();
                        this.c.moveTo((view.getMeasuredWidth() / i10) + view.getLeft(), this.q);
                        this.c.lineTo(r4 - i6, this.t);
                        this.c.lineTo(r4 + i6, this.t);
                        canvas2.drawPath(this.c, this.b);
                    }
                    int i15 = this.l;
                    if (size == 0) {
                        this.c.reset();
                        this.c.moveTo(this.p, this.t - ((arrayList.size() - 1) * i7));
                        this.c.lineTo(this.p + i8, this.t - ((arrayList.size() - 1) * i7));
                        this.c.lineTo(this.p + i8, ((this.t - ((arrayList.size() - 1) * i7)) - i7) + i5);
                        i2 = i9;
                        this.c.quadTo(this.p + i8, (this.t - ((arrayList.size() - 1) * i7)) - i7, (this.p + i8) - i5, (this.t - ((arrayList.size() - 1) * i7)) - i7);
                        this.c.lineTo(this.p + i5, (this.t - ((arrayList.size() - 1) * i7)) - i7);
                        this.c.quadTo(this.p, (this.t - ((arrayList.size() - 1) * i7)) - i7, this.p, ((this.t - ((arrayList.size() - 1) * i7)) - i7) + i5);
                        this.c.lineTo(this.p, this.t - ((arrayList.size() - 1) * i7));
                        canvas2.drawPath(this.c, this.b);
                        this.b.setColor(this.k);
                        i3 = size;
                        canvas2.drawLine(this.p, (this.t - ((arrayList.size() - 1) * i7)) - i15, this.p + i8, (this.t - ((arrayList.size() - 1) * i7)) - i15, this.b);
                    } else {
                        i2 = i9;
                        i3 = size;
                        if (i3 == arrayList.size() - 1) {
                            this.c.reset();
                            this.c.moveTo(this.p, this.t - ((arrayList.size() - i3) * i7));
                            this.c.lineTo(this.p + i8, this.t - ((arrayList.size() - i3) * i7));
                            this.c.lineTo(this.p + i8, ((this.t - ((arrayList.size() - i3) * i7)) + i7) - i5);
                            this.c.quadTo(this.p + i8, (this.t - ((arrayList.size() - i3) * i7)) + i7, (this.p + i8) - i5, (this.t - ((arrayList.size() - i3) * i7)) + i7);
                            this.c.lineTo(this.p + i5, (this.t - ((arrayList.size() - i3) * i7)) + i7);
                            this.c.quadTo(this.p, (this.t - ((arrayList.size() - i3) * i7)) + i7, this.p, ((this.t - ((arrayList.size() - i3) * i7)) + i7) - i5);
                            this.c.lineTo(this.p, this.t - ((arrayList.size() - i3) * i7));
                            canvas2.drawPath(this.c, this.b);
                        } else {
                            canvas2.drawRect(this.p, (this.t - i7) - (((arrayList.size() - i3) - 1) * i7), this.p + i8, this.t - (((arrayList.size() - i3) - 1) * i7), this.b);
                            this.b.setColor(this.k);
                            canvas2 = canvas;
                            canvas2.drawLine(this.p, (this.t - (((arrayList.size() - i3) - 1) * i7)) - i15, this.p + i8, (this.t - (((arrayList.size() - i3) - 1) * i7)) - i15, this.b);
                        }
                    }
                    int i16 = this.p;
                    int i17 = this.t;
                    int i18 = i3 * i7;
                    arrayList2.add(new RectF(i16, (i17 - i7) - i18, i16 + i8, i17 - i18));
                    c(canvas2, i3);
                    b(canvas2, i3);
                    this.d.restore();
                    canvas2.restore();
                }
                size = i3 - 1;
                i9 = i2;
                i10 = 2;
            }
            return;
        }
        int i19 = 1;
        this.b.setColor(this.j);
        canvas2.drawRect(this.m, this.b);
        arrayList2.clear();
        for (int i20 = 0; i20 < arrayList.size(); i20++) {
            canvas2.save();
            this.d.save();
            int i21 = this.h;
            if (i20 > i21) {
                this.d.restore();
                canvas2.restore();
            } else if (i20 == i21) {
                int i22 = this.x;
                if (i22 == i19) {
                    this.d.rotateY(this.f);
                } else if (i22 == 0) {
                    this.d.rotateX(this.f);
                } else {
                    i = 2;
                    if (i22 == 2) {
                        this.d.rotateZ(this.f);
                    }
                    this.d.getMatrix(this.e);
                    if (this.x != i) {
                        int i23 = i8 / 2;
                        this.e.preTranslate(-(this.p + i23), (-i7) / i);
                        this.e.postTranslate(i23 + this.p, i7 / 2);
                    } else {
                        int i24 = i8 / 2;
                        int i25 = i20 * i7;
                        this.e.preTranslate(-(this.p + i24), -(this.q + i25));
                        this.e.postTranslate(i24 + this.p, i25 + this.q);
                    }
                    canvas2.concat(this.e);
                    this.b.setColor(((KS) arrayList.get(i20)).b);
                    if (i20 != 0) {
                        this.c.reset();
                        this.c.moveTo((view.getMeasuredWidth() / 2) + view.getLeft(), this.q);
                        this.c.lineTo(r3 - i6, this.t);
                        this.c.lineTo(r3 + i6, this.t);
                        canvas2.drawPath(this.c, this.b);
                    }
                    if (i20 != 0) {
                        this.c.reset();
                        this.c.moveTo(this.p, this.t + i7);
                        this.c.lineTo(this.p + i8, this.t + i7);
                        this.c.lineTo(this.p + i8, this.t + i5);
                        Path path = this.c;
                        int i26 = this.p + i8;
                        float f = this.t;
                        path.quadTo(i26, f, i26 - i5, f);
                        this.c.lineTo(this.p + i5, this.t);
                        Path path2 = this.c;
                        float f2 = this.p;
                        path2.quadTo(f2, this.t, f2, r4 + i5);
                        this.c.lineTo(this.p, this.t + i7);
                        canvas2.drawPath(this.c, this.b);
                        i19 = 1;
                    } else {
                        i19 = 1;
                        if (i20 == arrayList.size() - 1) {
                            this.c.reset();
                            int i27 = i20 * i7;
                            this.c.moveTo(this.p, this.t + i27);
                            this.c.lineTo(this.p + i8, this.t + i27);
                            int i28 = (i20 + 1) * i7;
                            this.c.lineTo(this.p + i8, (this.t + i28) - i5);
                            Path path3 = this.c;
                            int i29 = this.p + i8;
                            float f3 = this.t + i28;
                            path3.quadTo(i29, f3, i29 - i5, f3);
                            this.c.lineTo(this.p + i5, this.t + i28);
                            Path path4 = this.c;
                            float f4 = this.p;
                            path4.quadTo(f4, i28 + this.t, f4, r6 - i5);
                            this.c.lineTo(this.p, i27 + this.t);
                            canvas2.drawPath(this.c, this.b);
                        } else {
                            int i30 = this.p;
                            int i31 = this.t;
                            int i32 = i20 * i7;
                            canvas2.drawRect(i30, i32 + i31, i30 + i8, i31 + i7 + i32, this.b);
                        }
                    }
                    int i33 = this.p;
                    int i34 = this.t;
                    int i35 = i20 * i7;
                    arrayList2.add(new RectF(i33, i35 + i34, i33 + i8, i34 + i7 + i35));
                    c(canvas2, i20);
                    b(canvas2, i20);
                    this.d.restore();
                    canvas2.restore();
                }
                i = 2;
                this.d.getMatrix(this.e);
                if (this.x != i) {
                }
                canvas2.concat(this.e);
                this.b.setColor(((KS) arrayList.get(i20)).b);
                if (i20 != 0) {
                }
                if (i20 != 0) {
                }
                int i332 = this.p;
                int i342 = this.t;
                int i352 = i20 * i7;
                arrayList2.add(new RectF(i332, i352 + i342, i332 + i8, i342 + i7 + i352));
                c(canvas2, i20);
                b(canvas2, i20);
                this.d.restore();
                canvas2.restore();
            } else {
                int i36 = this.x;
                if (i36 == 1) {
                    this.d.rotateY(this.g / 2.0f);
                } else if (i36 == 0) {
                    this.d.rotateX(this.g);
                } else {
                    i = 2;
                    if (i36 == 2) {
                        this.d.rotateZ(this.g);
                    }
                    this.d.getMatrix(this.e);
                    if (this.x != i) {
                    }
                    canvas2.concat(this.e);
                    this.b.setColor(((KS) arrayList.get(i20)).b);
                    if (i20 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    int i3322 = this.p;
                    int i3422 = this.t;
                    int i3522 = i20 * i7;
                    arrayList2.add(new RectF(i3322, i3522 + i3422, i3322 + i8, i3422 + i7 + i3522));
                    c(canvas2, i20);
                    b(canvas2, i20);
                    this.d.restore();
                    canvas2.restore();
                }
                i = 2;
                this.d.getMatrix(this.e);
                if (this.x != i) {
                }
                canvas2.concat(this.e);
                this.b.setColor(((KS) arrayList.get(i20)).b);
                if (i20 != 0) {
                }
                if (i20 != 0) {
                }
                int i33222 = this.p;
                int i34222 = this.t;
                int i35222 = i20 * i7;
                arrayList2.add(new RectF(i33222, i35222 + i34222, i33222 + i8, i34222 + i7 + i35222));
                c(canvas2, i20);
                b(canvas2, i20);
                this.d.restore();
                canvas2.restore();
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ObjectAnimator objectAnimator = this.z;
        if (motionEvent.getAction() == 1) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.w;
                if (i < arrayList.size()) {
                    if (this.A != null) {
                        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                        RectF rectF = (RectF) arrayList.get(i);
                        float f = pointF.x;
                        if (f >= rectF.left && f <= rectF.right) {
                            float f2 = pointF.y;
                            if (f2 >= rectF.top && f2 <= rectF.bottom) {
                                VPNClient vPNClient = ((W00) this.A).a;
                                switch (i) {
                                    case 0:
                                        vPNClient.n = true;
                                        SweetToast.info(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-17913640482699L));
                                        vPNClient.s();
                                        break;
                                    case 1:
                                        vPNClient.startActivity(new Intent(Deobfuscator$BDNETVPN$app.getString(-17986654926731L), Uri.parse(Deobfuscator$BDNETVPN$app.getString(-18102619043723L))));
                                        break;
                                    case 2:
                                        vPNClient.startActivity(new Intent(vPNClient.getApplicationContext(), (Class<?>) VPNShareActivity.class));
                                        break;
                                    case 3:
                                        vPNClient.startActivity(new Intent(vPNClient.getApplicationContext(), (Class<?>) AppListActivity.class));
                                        break;
                                    case 4:
                                        vPNClient.startActivity(new Intent(vPNClient.getApplicationContext(), (Class<?>) IPHunterActivity.class));
                                        break;
                                    case 5:
                                        String str = VPNClient.f0;
                                        U3 u3 = new U3(vPNClient, R.style.MyDialogTheme);
                                        String string = Deobfuscator$BDNETVPN$app.getString(-70333716330379L);
                                        Q3 q3 = (Q3) u3.c;
                                        q3.e = string;
                                        q3.g = VPNClient.y();
                                        q3.n = true;
                                        u3.f(Deobfuscator$BDNETVPN$app.getString(-70355191166859L), new DialogInterfaceOnClickListenerC3003f10(vPNClient, 5));
                                        u3.e(Deobfuscator$BDNETVPN$app.getString(-70376666003339L), null);
                                        u3.g();
                                        break;
                                    case 6:
                                        String str2 = VPNClient.f0;
                                        U3 u32 = new U3(vPNClient, R.style.MyDialogTheme);
                                        Q3 q32 = (Q3) u32.c;
                                        q32.n = true;
                                        q32.g = Deobfuscator$BDNETVPN$app.getString(-51135212517259L);
                                        u32.f(Deobfuscator$BDNETVPN$app.getString(-51276946438027L), new DialogInterfaceOnClickListenerC3003f10(vPNClient, 0));
                                        u32.e(Deobfuscator$BDNETVPN$app.getString(-51298421274507L), new DialogInterfaceOnClickListenerC4579yw(1));
                                        String string2 = Deobfuscator$BDNETVPN$app.getString(-51328486045579L);
                                        DialogInterfaceOnClickListenerC3003f10 dialogInterfaceOnClickListenerC3003f10 = new DialogInterfaceOnClickListenerC3003f10(vPNClient, 1);
                                        q32.l = string2;
                                        q32.m = dialogInterfaceOnClickListenerC3003f10;
                                        u32.g();
                                        break;
                                }
                            }
                        }
                    }
                    i++;
                } else {
                    Iterator it = this.y.iterator();
                    while (it.hasNext()) {
                        ((Animator) it.next()).cancel();
                    }
                    if (!objectAnimator.isRunning()) {
                        objectAnimator.start();
                    }
                }
            }
        }
        return true;
    }

    public void setAnimType(int i) {
        this.x = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.j = i;
    }

    public void setItemDuration(int i) {
        this.i = i;
    }

    public void setOnFlipClickListener(InterfaceC0261Jr interfaceC0261Jr) {
        this.A = interfaceC0261Jr;
    }

    public void setSeparateLineColor(int i) {
        this.k = i;
    }

    public void setShareItemList(List<KS> list) {
        ArrayList arrayList = this.v;
        arrayList.clear();
        for (KS ks : list) {
            String str = "";
            if (TextUtils.isEmpty(ks.a)) {
                ks.a = "";
            } else {
                String str2 = ks.a;
                boolean z = ks.c != null;
                int length = str2.length();
                while (true) {
                    if (this.b.measureText(str2.substring(0, length) + "...") <= (this.n - a(10.0f)) - (z ? (this.o / 2) + a(6.0f) : 0)) {
                        break;
                    }
                    length--;
                    str = "...";
                }
                ks.a = str2.substring(0, length) + str;
            }
            arrayList.add(ks);
        }
    }
}
