package defpackage;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.ActionMode;
import android.view.Choreographer;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.t;
import androidx.fragment.app.z;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ML implements InterfaceC4384wR, SuccessContinuation, InterfaceC0608Xb, InterfaceC0516Tn {
    public static N40 f;
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public static final int[] d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    public static final Object e = new Object();
    public static final C0756ar g = new C0756ar(22);
    public static final C3981rJ h = new C3981rJ(23);
    public static final C3903qJ i = new C3903qJ(23);

    public /* synthetic */ ML(int i2, Object obj, Object obj2) {
        this.a = i2;
        this.c = obj;
        this.b = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ML c(Context context) {
        FileChannel fileChannel;
        FileLock fileLock;
        try {
            fileChannel = new RandomAccessFile(new File(context.getFilesDir(), "generatefid.lock"), "rw").getChannel();
            try {
                fileLock = fileChannel.lock();
            } catch (IOException | Error | OverlappingFileLockException e2) {
                e = e2;
                fileLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e3) {
            e = e3;
            fileChannel = null;
            fileLock = null;
        }
        try {
            return new ML(fileChannel, fileLock, 20, false);
        } catch (IOException e4) {
            e = e4;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused2) {
                }
            }
            return null;
        } catch (Error e5) {
            e = e5;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLock != null) {
            }
            if (fileChannel != null) {
            }
            return null;
        } catch (OverlappingFileLockException e6) {
            e = e6;
            Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
            if (fileLock != null) {
            }
            if (fileChannel != null) {
            }
            return null;
        }
    }

    public static Task d(Context context, Intent intent, boolean z) {
        N40 n40;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (e) {
            try {
                if (f == null) {
                    f = new N40(context);
                }
                n40 = f;
            } finally {
            }
        }
        if (!z) {
            return n40.b(intent).continueWith(new ExecutorC3964r6(1), new C0832bn(12));
        }
        if (FR.f().i(context)) {
            synchronized (AbstractC0773b30.b) {
                try {
                    if (AbstractC0773b30.c == null) {
                        WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                        AbstractC0773b30.c = wakeLock;
                        wakeLock.setReferenceCounted(true);
                    }
                    boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                    if (!booleanExtra) {
                        AbstractC0773b30.c.acquire(AbstractC0773b30.a);
                    }
                    n40.b(intent).addOnCompleteListener(new C3290ic(intent, 27));
                } finally {
                }
            }
        } else {
            n40.b(intent);
        }
        return Tasks.forResult(-1);
    }

    public static C0128Eo h() {
        C0128Eo c0128Eo = new C0128Eo();
        c0128Eo.a = new HashMap();
        c0128Eo.b = new HashMap();
        return c0128Eo;
    }

    public static ML i(C3894qA c3894qA) {
        return new ML(0, c3894qA, AbstractC4585z00.c(c3894qA.A()));
    }

    public Drawable A(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.c) == null) {
                this.c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            int id = layerDrawable.getId(i2);
            drawableArr[i2] = A(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            layerDrawable2.setId(i3, layerDrawable.getId(i3));
            layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
            layerDrawable2.setLayerWidth(i3, layerDrawable.getLayerWidth(i3));
            layerDrawable2.setLayerHeight(i3, layerDrawable.getLayerHeight(i3));
            layerDrawable2.setLayerInsetLeft(i3, layerDrawable.getLayerInsetLeft(i3));
            layerDrawable2.setLayerInsetRight(i3, layerDrawable.getLayerInsetRight(i3));
            layerDrawable2.setLayerInsetTop(i3, layerDrawable.getLayerInsetTop(i3));
            layerDrawable2.setLayerInsetBottom(i3, layerDrawable.getLayerInsetBottom(i3));
            layerDrawable2.setLayerInsetStart(i3, layerDrawable.getLayerInsetStart(i3));
            layerDrawable2.setLayerInsetEnd(i3, layerDrawable.getLayerInsetEnd(i3));
        }
        return layerDrawable2;
    }

    public Enum B(Object obj) {
        Enum r0 = (Enum) ((Map) this.c).get(obj);
        if (r0 != null) {
            return r0;
        }
        throw new GeneralSecurityException("Unable to convert object enum: " + obj);
    }

    @Override // defpackage.InterfaceC0516Tn
    public Object a() {
        return (KZ) this.b;
    }

    @Override // defpackage.InterfaceC0516Tn
    public boolean b(CharSequence charSequence, int i2, int i3, C3363jZ c3363jZ) {
        if ((c3363jZ.c & 4) > 0) {
            return true;
        }
        if (((KZ) this.b) == null) {
            this.b = new KZ(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((C4254un) this.c).getClass();
        ((KZ) this.b).setSpan(new C3443kZ(c3363jZ), i2, i3, 33);
        return true;
    }

    @Override // defpackage.InterfaceC0608Xb
    public void e() {
        ((Animator) this.b).end();
        if (t.G(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((z) this.c) + " has been canceled.");
        }
    }

    public E3 f() {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (((R2) this.c) != null) {
            return new E3(num.intValue(), (R2) this.c);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    public C0178Gm g() {
        ECPoint eCPoint;
        C0282Km c0282Km = (C0282Km) this.b;
        if (c0282Km == null) {
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
        TO to = (TO) this.c;
        if (to == null) {
            throw new GeneralSecurityException("Cannot build without a private value");
        }
        C0048Bm c0048Bm = c0282Km.o.b;
        BigInteger order = c0048Bm.b.getOrder();
        BigInteger bigInteger = (BigInteger) to.b;
        if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        ECParameterSpec eCParameterSpec = AbstractC0075Cn.a;
        ECParameterSpec eCParameterSpec2 = c0048Bm.b;
        if (!AbstractC0075Cn.f(eCParameterSpec2, eCParameterSpec) && !AbstractC0075Cn.f(eCParameterSpec2, AbstractC0075Cn.b) && !AbstractC0075Cn.f(eCParameterSpec2, AbstractC0075Cn.c)) {
            throw new GeneralSecurityException("spec must be NIST P256, P384 or P521");
        }
        if (bigInteger.signum() != 1) {
            throw new GeneralSecurityException("k must be positive");
        }
        if (bigInteger.compareTo(eCParameterSpec2.getOrder()) >= 0) {
            throw new GeneralSecurityException("k must be smaller than the order of the generator");
        }
        EllipticCurve curve = eCParameterSpec2.getCurve();
        ECPoint generator = eCParameterSpec2.getGenerator();
        AbstractC0075Cn.b(generator, curve);
        BigInteger a = eCParameterSpec2.getCurve().getA();
        BigInteger d2 = AbstractC0075Cn.d(curve);
        C0049Bn g2 = AbstractC0075Cn.g(ECPoint.POINT_INFINITY, d2);
        C0049Bn g3 = AbstractC0075Cn.g(generator, d2);
        for (int bitLength = bigInteger.bitLength(); bitLength >= 0; bitLength--) {
            if (bigInteger.testBit(bitLength)) {
                g2 = AbstractC0075Cn.a(g2, g3, a, d2);
                g3 = AbstractC0075Cn.c(g3, a, d2);
            } else {
                g3 = AbstractC0075Cn.a(g2, g3, a, d2);
                g2 = AbstractC0075Cn.c(g2, a, d2);
            }
        }
        if (g2.c.equals(BigInteger.ZERO)) {
            eCPoint = ECPoint.POINT_INFINITY;
        } else {
            BigInteger modInverse = g2.c.modInverse(d2);
            BigInteger mod = modInverse.multiply(modInverse).mod(d2);
            eCPoint = new ECPoint(g2.a.multiply(mod).mod(d2), g2.b.multiply(mod).mod(d2).multiply(modInverse).mod(d2));
        }
        AbstractC0075Cn.b(eCPoint, curve);
        if (eCPoint.equals(c0282Km.p)) {
            return new C0178Gm((C0282Km) this.b, (TO) this.c);
        }
        throw new GeneralSecurityException("Invalid private value");
    }

    public void j() {
        String str = (String) this.b;
        try {
            C0156Fq c0156Fq = (C0156Fq) this.c;
            c0156Fq.getClass();
            new File((File) c0156Fq.c, str).createNewFile();
        } catch (IOException e2) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e2);
        }
    }

    public Object k(Enum r4) {
        Object obj = ((Map) this.b).get(r4);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: " + r4);
    }

    public ArrayList l(String str) {
        SO f2 = SO.f(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            f2.h(1);
        } else {
            f2.i(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.b;
        workDatabase_Impl.b();
        Cursor g2 = workDatabase_Impl.g(f2);
        try {
            ArrayList arrayList = new ArrayList(g2.getCount());
            while (g2.moveToNext()) {
                arrayList.add(g2.getString(0));
            }
            return arrayList;
        } finally {
            g2.close();
            f2.release();
        }
    }

    public KeyListener m(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((ML) ((C0136Ew) this.c).b).getClass();
        if (keyListener instanceof C0490Sn) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new C0490Sn(keyListener);
    }

    public void n(AttributeSet attributeSet, int i2) {
        switch (this.a) {
            case 1:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.b;
                C4452xG n = C4452xG.n(absSeekBar.getContext(), attributeSet, d, i2);
                Drawable j = n.j(0);
                if (j != null) {
                    if (j instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) j;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i3 = 0; i3 < numberOfFrames; i3++) {
                            Drawable A = A(animationDrawable.getFrame(i3), true);
                            A.setLevel(10000);
                            animationDrawable2.addFrame(A, animationDrawable.getDuration(i3));
                        }
                        animationDrawable2.setLevel(10000);
                        j = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(j);
                }
                Drawable j2 = n.j(1);
                if (j2 != null) {
                    absSeekBar.setProgressDrawable(A(j2, false));
                }
                n.q();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.b).getContext().obtainStyledAttributes(attributeSet, GM.i, i2, 0);
                try {
                    boolean z = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
                    obtainStyledAttributes.recycle();
                    w(z);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public C0412Pn o(InputConnection inputConnection, EditorInfo editorInfo) {
        C0136Ew c0136Ew = (C0136Ew) this.c;
        if (inputConnection == null) {
            c0136Ew.getClass();
            inputConnection = null;
        } else {
            ML ml = (ML) c0136Ew.b;
            ml.getClass();
            if (!(inputConnection instanceof C0412Pn)) {
                inputConnection = new C0412Pn((EditText) ml.b, inputConnection, editorInfo);
            }
        }
        return (C0412Pn) inputConnection;
    }

    public void p(AbstractC3797p1 abstractC3797p1) {
        FR fr = (FR) this.b;
        ((ActionMode.Callback) fr.a).onDestroyActionMode(fr.d(abstractC3797p1));
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) this.c;
        if (layoutInflaterFactory2C3250i5.w != null) {
            layoutInflaterFactory2C3250i5.l.getDecorView().removeCallbacks(layoutInflaterFactory2C3250i5.x);
        }
        if (layoutInflaterFactory2C3250i5.v != null) {
            C4352w20 c4352w20 = layoutInflaterFactory2C3250i5.y;
            if (c4352w20 != null) {
                c4352w20.b();
            }
            C4352w20 a = AbstractC2925e20.a(layoutInflaterFactory2C3250i5.v);
            a.a(0.0f);
            layoutInflaterFactory2C3250i5.y = a;
            a.d(new X4(this, 2));
        }
        layoutInflaterFactory2C3250i5.u = null;
        ViewGroup viewGroup = layoutInflaterFactory2C3250i5.A;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        viewGroup.requestApplyInsets();
        layoutInflaterFactory2C3250i5.I();
    }

    public void q(int i2, Bundle bundle) {
        Locale locale = Locale.US;
        String str = "Analytics listener received message. ID: " + i2 + ", Extras: " + bundle;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            InterfaceC0853c4 interfaceC0853c4 = "clx".equals(bundle2.getString("_o")) ? (C2853d6) this.b : (C2882dV) this.c;
            if (interfaceC0853c4 == null) {
                return;
            }
            interfaceC0853c4.k(bundle2, string);
        }
    }

    public boolean r(AbstractC3797p1 abstractC3797p1, MenuC2945eF menuC2945eF) {
        ViewGroup viewGroup = ((LayoutInflaterFactory2C3250i5) this.c).A;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        viewGroup.requestApplyInsets();
        FR fr = (FR) this.b;
        JV d2 = fr.d(abstractC3797p1);
        C4386wT c4386wT = (C4386wT) fr.d;
        Menu menu = (Menu) c4386wT.get(menuC2945eF);
        if (menu == null) {
            menu = new CF((Context) fr.b, menuC2945eF);
            c4386wT.put(menuC2945eF, menu);
        }
        return ((ActionMode.Callback) fr.a).onPrepareActionMode(d2, menu);
    }

    public void s(C4575ys c4575ys) {
        int i2 = c4575ys.b;
        ExecutorC2829cp executorC2829cp = (ExecutorC2829cp) this.c;
        WT wt = (WT) this.b;
        if (i2 == 0) {
            executorC2829cp.execute(new RunnableC3320j1(wt, c4575ys.a, 5, false));
        } else {
            executorC2829cp.execute(new RunnableC0322Mb(wt, i2, 0));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x022b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(Context context, XmlResourceParser xmlResourceParser) {
        int eventType;
        C3218hg c3218hg;
        char c;
        C3616mg c3616mg = new C3616mg();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlResourceParser.getAttributeName(i2);
            String attributeValue = xmlResourceParser.getAttributeValue(i2);
            if (attributeName != null && attributeValue != null && FacebookMediationAdapter.KEY_ID.equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), FacebookMediationAdapter.KEY_ID, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    eventType = xmlResourceParser.getEventType();
                    c3218hg = null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (XmlPullParserException e3) {
                    e3.printStackTrace();
                }
                while (eventType != 1) {
                    if (eventType != 0) {
                        char c2 = 3;
                        if (eventType == 2) {
                            String name = xmlResourceParser.getName();
                            switch (name.hashCode()) {
                                case -2025855158:
                                    if (name.equals("Layout")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1984451626:
                                    if (name.equals("Motion")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1962203927:
                                    if (name.equals("ConstraintOverride")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1269513683:
                                    if (name.equals("PropertySet")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1238332596:
                                    if (name.equals("Transform")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -71750448:
                                    if (name.equals("Guideline")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 366511058:
                                    if (name.equals("CustomMethod")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1331510167:
                                    if (name.equals("Barrier")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1791837707:
                                    if (name.equals("CustomAttribute")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1803088381:
                                    if (name.equals("Constraint")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    c3218hg = C3616mg.d(context, Xml.asAttributeSet(xmlResourceParser), false);
                                    break;
                                case 1:
                                    c3218hg = C3616mg.d(context, Xml.asAttributeSet(xmlResourceParser), true);
                                    break;
                                case 2:
                                    c3218hg = C3616mg.d(context, Xml.asAttributeSet(xmlResourceParser), false);
                                    c3218hg.d.a = true;
                                    break;
                                case 3:
                                    c3218hg = C3616mg.d(context, Xml.asAttributeSet(xmlResourceParser), false);
                                    c3218hg.d.g0 = 1;
                                    break;
                                case 4:
                                    if (c3218hg == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    c3218hg.b.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                case 5:
                                    if (c3218hg == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    c3218hg.e.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                case 6:
                                    if (c3218hg == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    c3218hg.d.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                case 7:
                                    if (c3218hg == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    c3218hg.c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                case '\b':
                                case '\t':
                                    if (c3218hg == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    C0586Wf.a(context, xmlResourceParser, c3218hg.f);
                                    break;
                            }
                        } else if (eventType == 3) {
                            String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (lowerCase.equals("guideline")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2146106725:
                                    if (lowerCase.equals("constraintset")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c == 0) {
                                ((SparseArray) this.c).put(identifier, c3616mg);
                                return;
                            } else if (c == 1 || c == 2 || c == 3) {
                                c3616mg.c.put(Integer.valueOf(c3218hg.a), c3218hg);
                                c3218hg = null;
                            }
                        }
                    } else {
                        xmlResourceParser.getName();
                    }
                    eventType = xmlResourceParser.next();
                }
                ((SparseArray) this.c).put(identifier, c3616mg);
                return;
            }
        }
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Boolean bool = (Boolean) obj;
        boolean booleanValue = bool.booleanValue();
        C4169th c4169th = (C4169th) this.c;
        if (booleanValue) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
            }
            boolean booleanValue2 = bool.booleanValue();
            C0589Wi c0589Wi = c4169th.b;
            if (!booleanValue2) {
                c0589Wi.getClass();
                throw new IllegalStateException("An invalid data collection token was used.");
            }
            c0589Wi.f.trySetResult(null);
            return ((Task) this.b).onSuccessTask((ExecutorC3221hi) c4169th.e.b, new C2835cv(this, 12));
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
        }
        Iterator it = C0156Fq.f(((File) c4169th.g.c).listFiles(C4169th.r)).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        C0156Fq c0156Fq = ((C2981ei) c4169th.m.b).b;
        C2981ei.a(C0156Fq.f(((File) c0156Fq.e).listFiles()));
        C2981ei.a(C0156Fq.f(((File) c0156Fq.f).listFiles()));
        C2981ei.a(C0156Fq.f(((File) c0156Fq.g).listFiles()));
        c4169th.q.trySetResult(null);
        return Tasks.forResult(null);
    }

    public Task u(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        boolean isAtLeastO = PlatformVersion.isAtLeastO();
        final Context context = (Context) this.b;
        boolean z = isAtLeastO && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (z && !z2) {
            return d(context, intent, z2);
        }
        ExecutorC3964r6 executorC3964r6 = (ExecutorC3964r6) this.c;
        return Tasks.call(executorC3964r6, new CallableC0674Zp(0, context, intent)).continueWithTask(executorC3964r6, new Continuation() { // from class: aq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? ML.d(context, intent, z2).continueWith(new ExecutorC3964r6(1), new C0832bn(11)) : task;
            }
        });
    }

    public void v() {
        try {
            ((FileLock) this.c).release();
            ((FileChannel) this.b).close();
        } catch (IOException e2) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e2);
        }
    }

    public void w(boolean z) {
        C0646Yn c0646Yn = (C0646Yn) ((ML) ((C0136Ew) this.c).b).c;
        if (c0646Yn.c != z) {
            if (c0646Yn.b != null) {
                C0231In a = C0231In.a();
                C0620Xn c0620Xn = c0646Yn.b;
                a.getClass();
                AbstractC0538Uj.h(c0620Xn, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a.b.remove(c0620Xn);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            c0646Yn.c = z;
            if (z) {
                C0646Yn.a(c0646Yn.a, C0231In.a().b());
            }
        }
    }

    public void x(int i2) {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.b = Integer.valueOf(i2);
    }

    public void y(int i2, int i3, int i4, int i5) {
        CardView cardView = (CardView) this.c;
        cardView.d.set(i2, i3, i4, i5);
        Rect rect = cardView.c;
        super/*android.view.View*/.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
    }

    public void z(XE xe) {
        ((WG) this.b).i(xe);
        boolean z = xe instanceof C3981rJ;
        C3278iS c3278iS = (C3278iS) this.c;
        if (z) {
            c3278iS.i((C3981rJ) xe);
        } else if (xe instanceof C3824pJ) {
            c3278iS.j(((C3824pJ) xe).n);
        }
    }

    public /* synthetic */ ML(int i2, boolean z) {
        this.a = i2;
    }

    public /* synthetic */ ML(Object obj, int i2) {
        this.a = i2;
        this.c = obj;
    }

    public /* synthetic */ ML(Object obj, Object obj2, int i2, boolean z) {
        this.a = i2;
        this.b = obj;
        this.c = obj2;
    }

    public ML(WorkDatabase_Impl workDatabase_Impl) {
        this.a = 23;
        this.b = workDatabase_Impl;
        this.c = new C0830bl(workDatabase_Impl, 0);
    }

    public ML(C0156Fq c0156Fq) {
        this.a = 3;
        this.b = c0156Fq;
        this.c = g;
    }

    public ML(int i2) {
        this.a = i2;
        switch (i2) {
            case 7:
                this.b = Choreographer.getInstance();
                this.c = Looper.myLooper();
                break;
            case 8:
                this.b = new Rect();
                this.c = new Rect();
                break;
            default:
                this.b = new WG();
                this.c = new C3278iS();
                z(i);
                break;
        }
    }

    public ML(AbsSeekBar absSeekBar) {
        this.a = 1;
        this.b = absSeekBar;
    }

    public ML(EditText editText, int i2) {
        this.a = i2;
        switch (i2) {
            case 27:
                this.b = editText;
                C0646Yn c0646Yn = new C0646Yn(editText);
                this.c = c0646Yn;
                editText.addTextChangedListener(c0646Yn);
                if (C0360Nn.b == null) {
                    synchronized (C0360Nn.a) {
                        try {
                            if (C0360Nn.b == null) {
                                C0360Nn c0360Nn = new C0360Nn();
                                try {
                                    C0360Nn.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C0360Nn.class.getClassLoader());
                                } catch (Throwable unused) {
                                }
                                C0360Nn.b = c0360Nn;
                            }
                        } finally {
                        }
                    }
                }
                editText.setEditableFactory(C0360Nn.b);
                return;
            default:
                this.b = editText;
                this.c = new C0136Ew(editText);
                return;
        }
    }

    public ML(Context context, int i2) {
        this.a = i2;
        switch (i2) {
            case 12:
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(AbstractC0731aZ.c0(context, dastan.prince.bdfreevpn.R.attr.materialCalendarStyle, C4608zE.class.getCanonicalName()).data, FM.o);
                C0756ar.l(context, obtainStyledAttributes.getResourceId(4, 0));
                C0756ar.l(context, obtainStyledAttributes.getResourceId(2, 0));
                C0756ar.l(context, obtainStyledAttributes.getResourceId(3, 0));
                C0756ar.l(context, obtainStyledAttributes.getResourceId(5, 0));
                ColorStateList s = W80.s(context, obtainStyledAttributes, 7);
                this.b = C0756ar.l(context, obtainStyledAttributes.getResourceId(9, 0));
                C0756ar.l(context, obtainStyledAttributes.getResourceId(8, 0));
                this.c = C0756ar.l(context, obtainStyledAttributes.getResourceId(10, 0));
                new Paint().setColor(s.getDefaultColor());
                obtainStyledAttributes.recycle();
                break;
            case 15:
                this.b = new ArrayList();
                this.c = context.getApplicationContext();
                break;
            case 24:
                this.b = context;
                this.c = null;
                break;
            default:
                this.b = context;
                this.c = new ExecutorC3964r6(1);
                break;
        }
    }
}
