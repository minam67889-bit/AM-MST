package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.lsposed.lsparanoid.DeobfuscatorHelper;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class OF implements InterfaceC4620zQ {
    public static final int[] n = new int[0];
    public static final Unsafe o = AbstractC0846c00.j();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final AbstractC0766b0 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final C0714aI j;
    public final C3738oC k;
    public final BZ l;
    public final C0710aE m;

    public OF(int[] iArr, Object[] objArr, int i, int i2, AbstractC0766b0 abstractC0766b0, int[] iArr2, int i3, int i4, C0714aI c0714aI, C3738oC c3738oC, BZ bz, C3862pp c3862pp, C0710aE c0710aE) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = abstractC0766b0 instanceof AbstractC0367Nu;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = c0714aI;
        this.k = c3738oC;
        this.l = bz;
        this.e = abstractC0766b0;
        this.m = c0710aE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static OF A(MM mm, C0714aI c0714aI, C3738oC c3738oC, BZ bz, C3862pp c3862pp, C0710aE c0710aE) {
        int i;
        int charAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char charAt2;
        int i9;
        char charAt3;
        int i10;
        char charAt4;
        int i11;
        char charAt5;
        int i12;
        char charAt6;
        int i13;
        char charAt7;
        int i14;
        char charAt8;
        int i15;
        char charAt9;
        int i16;
        int i17;
        int[] iArr2;
        int i18;
        int i19;
        int objectFieldOffset;
        int i20;
        int i21;
        int i22;
        int i23;
        Field M;
        char charAt10;
        int i24;
        int i25;
        Field M2;
        Field M3;
        int i26;
        char charAt11;
        int i27;
        int i28;
        char charAt12;
        int i29;
        char charAt13;
        int i30;
        char charAt14;
        String str = mm.b;
        int length = str.length();
        int i31 = 55296;
        if (str.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (str.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int charAt15 = str.charAt(i);
        if (charAt15 >= 55296) {
            int i34 = charAt15 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
            int i35 = 13;
            while (true) {
                i30 = i33 + 1;
                charAt14 = str.charAt(i33);
                if (charAt14 < 55296) {
                    break;
                }
                i34 |= (charAt14 & 8191) << i35;
                i35 += 13;
                i33 = i30;
            }
            charAt15 = i34 | (charAt14 << i35);
            i33 = i30;
        }
        if (charAt15 == 0) {
            i3 = 0;
            i6 = 0;
            charAt = 0;
            i2 = 0;
            i5 = 0;
            i7 = 0;
            iArr = n;
            i4 = 0;
        } else {
            int i36 = i33 + 1;
            int charAt16 = str.charAt(i33);
            if (charAt16 >= 55296) {
                int i37 = charAt16 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    charAt9 = str.charAt(i36);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i37 |= (charAt9 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                charAt16 = i37 | (charAt9 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int charAt17 = str.charAt(i36);
            if (charAt17 >= 55296) {
                int i40 = charAt17 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    charAt8 = str.charAt(i39);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i40 |= (charAt8 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                charAt17 = i40 | (charAt8 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int charAt18 = str.charAt(i39);
            if (charAt18 >= 55296) {
                int i43 = charAt18 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    charAt7 = str.charAt(i42);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i43 |= (charAt7 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                charAt18 = i43 | (charAt7 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int charAt19 = str.charAt(i42);
            if (charAt19 >= 55296) {
                int i46 = charAt19 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    charAt6 = str.charAt(i45);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i46 |= (charAt6 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                charAt19 = i46 | (charAt6 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            charAt = str.charAt(i45);
            if (charAt >= 55296) {
                int i49 = charAt & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    charAt5 = str.charAt(i48);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i49 |= (charAt5 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                charAt = i49 | (charAt5 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int charAt20 = str.charAt(i48);
            if (charAt20 >= 55296) {
                int i52 = charAt20 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    charAt4 = str.charAt(i51);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i52 |= (charAt4 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                charAt20 = i52 | (charAt4 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int charAt21 = str.charAt(i51);
            if (charAt21 >= 55296) {
                int i55 = charAt21 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    charAt3 = str.charAt(i54);
                    if (charAt3 < 55296) {
                        break;
                    }
                    i55 |= (charAt3 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                charAt21 = i55 | (charAt3 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int charAt22 = str.charAt(i54);
            if (charAt22 >= 55296) {
                int i58 = charAt22 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    charAt2 = str.charAt(i57);
                    if (charAt2 < 55296) {
                        break;
                    }
                    i58 |= (charAt2 & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                charAt22 = i58 | (charAt2 << i59);
                i57 = i8;
            }
            int[] iArr3 = new int[charAt22 + charAt20 + charAt21];
            int i60 = (charAt16 * 2) + charAt17;
            int i61 = charAt20;
            i2 = charAt18;
            i3 = i61;
            i4 = charAt16;
            i33 = i57;
            iArr = iArr3;
            i5 = charAt19;
            i6 = i60;
            i7 = charAt22;
        }
        Unsafe unsafe = o;
        Class<?> cls = mm.a.getClass();
        int[] iArr4 = new int[charAt * 3];
        Object[] objArr = new Object[charAt * 2];
        int i62 = i7 + i3;
        int i63 = i62;
        int i64 = i7;
        int i65 = 0;
        int i66 = 0;
        while (i33 < length) {
            int i67 = i33 + 1;
            int charAt23 = str.charAt(i33);
            if (charAt23 >= i31) {
                int i68 = charAt23 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i29 = i69 + 1;
                    charAt13 = str.charAt(i69);
                    i16 = length;
                    if (charAt13 < 55296) {
                        break;
                    }
                    i68 |= (charAt13 & 8191) << i70;
                    i70 += 13;
                    i69 = i29;
                    length = i16;
                }
                charAt23 = i68 | (charAt13 << i70);
                i17 = i29;
            } else {
                i16 = length;
                i17 = i67;
            }
            int i71 = i17 + 1;
            int charAt24 = str.charAt(i17);
            int i72 = charAt23;
            char c = 55296;
            if (charAt24 >= 55296) {
                int i73 = charAt24 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                int i74 = 13;
                while (true) {
                    i28 = i71 + 1;
                    charAt12 = str.charAt(i71);
                    if (charAt12 < c) {
                        break;
                    }
                    i73 |= (charAt12 & 8191) << i74;
                    i74 += 13;
                    i71 = i28;
                    c = 55296;
                }
                charAt24 = i73 | (charAt12 << i74);
                i71 = i28;
            }
            int i75 = charAt24 & 255;
            int i76 = i4;
            if ((charAt24 & UserVerificationMethods.USER_VERIFY_ALL) != 0) {
                iArr[i66] = i65;
                i66++;
            }
            Object[] objArr2 = mm.c;
            if (i75 >= 51) {
                int i77 = i71 + 1;
                int charAt25 = str.charAt(i71);
                if (charAt25 >= 55296) {
                    int i78 = charAt25 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i26 = i79 + 1;
                        charAt11 = str.charAt(i79);
                        i27 = i78;
                        if (charAt11 < 55296) {
                            break;
                        }
                        i78 = i27 | ((charAt11 & 8191) << i80);
                        i80 += 13;
                        i79 = i26;
                    }
                    charAt25 = i27 | (charAt11 << i80);
                    i25 = i26;
                } else {
                    i25 = i77;
                }
                int i81 = charAt25;
                int i82 = i75 - 51;
                int i83 = i25;
                if (i82 == 9 || i82 == 17) {
                    iArr2 = iArr4;
                    objArr[W50.b(i65, 3, 2, 1)] = objArr2[i6];
                    i6++;
                } else {
                    if (i82 == 12 && (ZT.h(mm.a(), 1) || (charAt24 & 2048) != 0)) {
                        iArr2 = iArr4;
                        objArr[W50.b(i65, 3, 2, 1)] = objArr2[i6];
                        i6++;
                    }
                    iArr2 = iArr4;
                }
                int i84 = i81 * 2;
                Object obj = objArr2[i84];
                if (obj instanceof Field) {
                    M2 = (Field) obj;
                } else {
                    M2 = M(cls, (String) obj);
                    objArr2[i84] = M2;
                }
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(M2);
                int i85 = i84 + 1;
                Object obj2 = objArr2[i85];
                if (obj2 instanceof Field) {
                    M3 = (Field) obj2;
                } else {
                    M3 = M(cls, (String) obj2);
                    objArr2[i85] = M3;
                }
                i18 = i62;
                i23 = objectFieldOffset2;
                i21 = i83;
                i20 = (int) unsafe.objectFieldOffset(M3);
                i22 = 0;
            } else {
                iArr2 = iArr4;
                int i86 = i6 + 1;
                Field M4 = M(cls, (String) objArr2[i6]);
                if (i75 == 9 || i75 == 17) {
                    i18 = i62;
                    objArr[W50.b(i65, 3, 2, 1)] = M4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i18 = i62;
                        i24 = i6 + 2;
                        objArr[W50.b(i65, 3, 2, 1)] = objArr2[i86];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i18 = i62;
                        if (mm.a() == 1 || (charAt24 & 2048) != 0) {
                            i24 = i6 + 2;
                            objArr[W50.b(i65, 3, 2, 1)] = objArr2[i86];
                        }
                    } else if (i75 == 50) {
                        int i87 = i64 + 1;
                        iArr[i64] = i65;
                        int i88 = (i65 / 3) * 2;
                        int i89 = i6 + 2;
                        objArr[i88] = objArr2[i86];
                        if ((charAt24 & 2048) != 0) {
                            i19 = i6 + 3;
                            objArr[i88 + 1] = objArr2[i89];
                            i18 = i62;
                            i64 = i87;
                        } else {
                            i19 = i89;
                            i64 = i87;
                            i18 = i62;
                        }
                        objectFieldOffset = (int) unsafe.objectFieldOffset(M4);
                        if ((charAt24 & 4096) != 0 || i75 > 17) {
                            i20 = 1048575;
                            i21 = i71;
                            i22 = 0;
                        } else {
                            int i90 = i71 + 1;
                            int charAt26 = str.charAt(i71);
                            if (charAt26 >= 55296) {
                                int i91 = charAt26 & DeobfuscatorHelper.MAX_CHUNK_LENGTH;
                                int i92 = 13;
                                while (true) {
                                    i21 = i90 + 1;
                                    charAt10 = str.charAt(i90);
                                    if (charAt10 < 55296) {
                                        break;
                                    }
                                    i91 |= (charAt10 & 8191) << i92;
                                    i92 += 13;
                                    i90 = i21;
                                }
                                charAt26 = i91 | (charAt10 << i92);
                            } else {
                                i21 = i90;
                            }
                            int i93 = (charAt26 / 32) + (i76 * 2);
                            Object obj3 = objArr2[i93];
                            if (obj3 instanceof Field) {
                                M = (Field) obj3;
                            } else {
                                M = M(cls, (String) obj3);
                                objArr2[i93] = M;
                            }
                            i20 = (int) unsafe.objectFieldOffset(M);
                            i22 = charAt26 % 32;
                        }
                        if (i75 >= 18 && i75 <= 49) {
                            iArr[i63] = objectFieldOffset;
                            i63++;
                        }
                        i6 = i19;
                        i23 = objectFieldOffset;
                    } else {
                        i18 = i62;
                    }
                    i19 = i24;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(M4);
                    if ((charAt24 & 4096) != 0) {
                    }
                    i20 = 1048575;
                    i21 = i71;
                    i22 = 0;
                    if (i75 >= 18) {
                        iArr[i63] = objectFieldOffset;
                        i63++;
                    }
                    i6 = i19;
                    i23 = objectFieldOffset;
                }
                i19 = i86;
                objectFieldOffset = (int) unsafe.objectFieldOffset(M4);
                if ((charAt24 & 4096) != 0) {
                }
                i20 = 1048575;
                i21 = i71;
                i22 = 0;
                if (i75 >= 18) {
                }
                i6 = i19;
                i23 = objectFieldOffset;
            }
            int i94 = i65 + 1;
            iArr2[i65] = i72;
            int i95 = i65 + 2;
            String str2 = str;
            iArr2[i94] = ((charAt24 & UserVerificationMethods.USER_VERIFY_NONE) != 0 ? 536870912 : 0) | ((charAt24 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 ? 268435456 : 0) | ((charAt24 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | i23;
            i65 += 3;
            iArr2[i95] = (i22 << 20) | i20;
            str = str2;
            i4 = i76;
            length = i16;
            i33 = i21;
            i62 = i18;
            iArr4 = iArr2;
            i31 = 55296;
        }
        return new OF(iArr4, objArr, i2, i5, mm.a, iArr, i7, i62, c0714aI, c3738oC, bz, c3862pp, c0710aE);
    }

    public static long B(int i) {
        return i & 1048575;
    }

    public static int C(long j, Object obj) {
        return ((Integer) AbstractC0846c00.c.i(j, obj)).intValue();
    }

    public static long D(long j, Object obj) {
        return ((Long) AbstractC0846c00.c.i(j, obj)).longValue();
    }

    public static Field M(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder x = W50.x("Field ", str, " for ");
            x.append(cls.getName());
            x.append(" not found. Known fields are ");
            x.append(Arrays.toString(declaredFields));
            throw new RuntimeException(x.toString(), e);
        }
    }

    public static int S(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void l(Object obj) {
        if (s(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    public static boolean s(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0367Nu) {
            return ((AbstractC0367Nu) obj).n();
        }
        return true;
    }

    public final void E(int i, long j, Object obj) {
        Unsafe unsafe = o;
        Object o2 = o(i);
        Object object = unsafe.getObject(obj, j);
        this.m.getClass();
        if (!((XD) object).a) {
            XD c = XD.b.c();
            C0710aE.a(c, object);
            unsafe.putObject(obj, j, c);
        }
        W50.z(o2);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0149, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r7;
        r7 = r13;
        r13 = r4;
        r4 = r33;
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0294, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r4;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r4 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x04a5, code lost:
    
        if (r8 == 1048575) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x04a7, code lost:
    
        r15.putInt(r10, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x04ab, code lost:
    
        r0 = r6.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x04af, code lost:
    
        if (r0 >= r6.i) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x04b1, code lost:
    
        r6.m(r6.g[r0], r10, r32);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x04bd, code lost:
    
        if (r34 != 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x04bf, code lost:
    
        if (r5 != r4) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x04c6, code lost:
    
        throw defpackage.C4107sy.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x04cb, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x04c7, code lost:
    
        if (r5 > r4) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x04c9, code lost:
    
        if (r12 != r34) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x04d0, code lost:
    
        throw defpackage.C4107sy.d();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int F(Object obj, byte[] bArr, int i, int i2, int i3, C4201u6 c4201u6) {
        OF of;
        Unsafe unsafe;
        Object obj2;
        Object obj3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        char c;
        int i10;
        Unsafe unsafe2;
        Object obj4;
        int i11;
        byte[] bArr2;
        int i12;
        byte[] bArr3;
        C4201u6 c4201u62;
        Unsafe unsafe3;
        Object obj5;
        C4201u6 c4201u63;
        int i13;
        byte[] bArr4;
        int n2;
        int i14;
        byte[] bArr5;
        Object obj6;
        C4201u6 c4201u64;
        int f;
        Object obj7;
        int i15;
        int i16;
        int i17;
        OF of2 = this;
        Object obj8 = obj;
        byte[] bArr6 = bArr;
        int i18 = i2;
        C4201u6 c4201u65 = c4201u6;
        l(obj8);
        Unsafe unsafe4 = o;
        int i19 = i;
        int i20 = -1;
        int i21 = 0;
        int i22 = 1048575;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            int i25 = 1048575;
            while (true) {
                if (i19 < i18) {
                    int i26 = i19 + 1;
                    int i27 = bArr6[i19];
                    if (i27 < 0) {
                        i26 = S50.k(i27, bArr6, i26, c4201u65);
                        i27 = c4201u65.a;
                    }
                    int i28 = i26;
                    i24 = i27;
                    i19 = i28;
                    obj3 = null;
                    i4 = i24 >>> 3;
                    int i29 = i24 & 7;
                    int i30 = of2.d;
                    int i31 = of2.c;
                    if (i4 > i20) {
                        i6 = (i4 < i31 || i4 > i30) ? -1 : of2.P(i4, i21 / 3);
                        i5 = 0;
                    } else if (i4 < i31 || i4 > i30) {
                        i5 = 0;
                        i6 = -1;
                    } else {
                        i5 = 0;
                        i6 = of2.P(i4, 0);
                    }
                    if (i6 == -1) {
                        i21 = i5;
                        i7 = i4;
                        of = of2;
                        unsafe = unsafe4;
                        obj2 = obj8;
                        i8 = i24;
                    } else {
                        int[] iArr = of2.a;
                        int i32 = iArr[i6 + 1];
                        int i33 = i5;
                        int S = S(i32);
                        long j = i32 & i25;
                        if (S <= 17) {
                            int i34 = iArr[i6 + 2];
                            int i35 = 1 << (i34 >>> 20);
                            int i36 = i34 & i25;
                            if (i36 != i22) {
                                int i37 = i25;
                                if (i22 != i37) {
                                    unsafe4.putInt(obj8, i22, i23);
                                    i37 = 1048575;
                                }
                                i23 = i36 == i37 ? i33 : unsafe4.getInt(obj8, i36);
                                i9 = i36;
                            } else {
                                i9 = i22;
                            }
                            int i38 = i23;
                            switch (S) {
                                case 0:
                                    unsafe2 = unsafe4;
                                    C4201u6 c4201u66 = c4201u65;
                                    i11 = i19;
                                    c = 65535;
                                    i10 = i6;
                                    if (i29 != 1) {
                                        obj4 = obj8;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        AbstractC0846c00.c.m(obj8, j, Double.longBitsToDouble(S50.h(i11, bArr)));
                                        i19 = i11 + 8;
                                        c4201u65 = c4201u66;
                                        i21 = i10;
                                        i18 = i2;
                                        bArr6 = bArr;
                                        i20 = i4;
                                        i22 = i9;
                                        i25 = 1048575;
                                        i23 = i38 | i35;
                                        obj8 = obj8;
                                        unsafe4 = unsafe2;
                                    }
                                case 1:
                                    bArr2 = bArr;
                                    unsafe2 = unsafe4;
                                    C4201u6 c4201u67 = c4201u65;
                                    i11 = i19;
                                    c = 65535;
                                    i10 = i6;
                                    if (i29 != 5) {
                                        obj4 = obj8;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        AbstractC0846c00.c.n(obj8, j, Float.intBitsToFloat(S50.g(i11, bArr2)));
                                        i19 = i11 + 4;
                                        i12 = i38 | i35;
                                        c4201u65 = c4201u67;
                                        i21 = i10;
                                        i18 = i2;
                                        bArr6 = bArr2;
                                        i20 = i4;
                                        i22 = i9;
                                        i25 = 1048575;
                                        i23 = i12;
                                        unsafe4 = unsafe2;
                                    }
                                case 2:
                                case 3:
                                    bArr2 = bArr;
                                    C4201u6 c4201u68 = c4201u65;
                                    i11 = i19;
                                    c = 65535;
                                    i10 = i6;
                                    if (i29 != 0) {
                                        unsafe2 = unsafe4;
                                        obj4 = obj8;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        int n3 = S50.n(bArr2, i11, c4201u68);
                                        unsafe4.putLong(obj8, j, c4201u68.b);
                                        unsafe2 = unsafe4;
                                        i12 = i38 | i35;
                                        c4201u65 = c4201u68;
                                        i21 = i10;
                                        i18 = i2;
                                        i19 = n3;
                                        bArr6 = bArr2;
                                        i20 = i4;
                                        i22 = i9;
                                        i25 = 1048575;
                                        i23 = i12;
                                        unsafe4 = unsafe2;
                                    }
                                case 4:
                                case 11:
                                    bArr3 = bArr;
                                    c4201u62 = c4201u65;
                                    i11 = i19;
                                    c = 65535;
                                    i10 = i6;
                                    if (i29 == 0) {
                                        i19 = S50.l(bArr3, i11, c4201u62);
                                        unsafe4.putInt(obj8, j, c4201u62.a);
                                        break;
                                    }
                                    unsafe2 = unsafe4;
                                    obj4 = obj8;
                                    of = of2;
                                    i19 = i11;
                                    i8 = i24;
                                    i21 = i10;
                                    i22 = i9;
                                    i23 = i38;
                                    i7 = i4;
                                    unsafe = unsafe2;
                                    obj2 = obj4;
                                    break;
                                case 5:
                                case 14:
                                    bArr3 = bArr;
                                    Unsafe unsafe5 = unsafe4;
                                    Object obj9 = obj8;
                                    C4201u6 c4201u69 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    if (i29 != 1) {
                                        i11 = i19;
                                        unsafe2 = unsafe5;
                                        obj4 = obj9;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        c4201u62 = c4201u69;
                                        unsafe4 = unsafe5;
                                        obj8 = obj9;
                                        unsafe4.putLong(obj8, j, S50.h(i19, bArr3));
                                        i19 += 8;
                                        break;
                                    }
                                case 6:
                                case 13:
                                    unsafe3 = unsafe4;
                                    obj5 = obj8;
                                    c4201u63 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 != 5) {
                                        obj4 = obj5;
                                        unsafe2 = unsafe3;
                                        i11 = i13;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        unsafe3.putInt(obj5, j, S50.g(i13, bArr));
                                        i19 = i13 + 4;
                                        i18 = i2;
                                        bArr6 = bArr;
                                        i21 = i10;
                                        i20 = i4;
                                        i25 = 1048575;
                                        c4201u65 = c4201u63;
                                        i23 = i38 | i35;
                                        unsafe4 = unsafe3;
                                        obj8 = obj5;
                                        i22 = i9;
                                    }
                                case 7:
                                    bArr4 = bArr;
                                    unsafe3 = unsafe4;
                                    obj5 = obj8;
                                    c4201u63 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 != 0) {
                                        obj4 = obj5;
                                        unsafe2 = unsafe3;
                                        i11 = i13;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        n2 = S50.n(bArr4, i13, c4201u63);
                                        AbstractC0846c00.c.k(obj5, j, c4201u63.b != 0 ? 1 : i33);
                                        byte[] bArr7 = bArr4;
                                        i23 = i38 | i35;
                                        bArr6 = bArr7;
                                        i18 = i2;
                                        i19 = n2;
                                        obj8 = obj5;
                                        i21 = i10;
                                        i20 = i4;
                                        i25 = 1048575;
                                        c4201u65 = c4201u63;
                                        unsafe4 = unsafe3;
                                        i22 = i9;
                                    }
                                case 8:
                                    bArr4 = bArr;
                                    unsafe3 = unsafe4;
                                    obj5 = obj8;
                                    c4201u63 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 != 2) {
                                        obj4 = obj5;
                                        unsafe2 = unsafe3;
                                        i11 = i13;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else if ((536870912 & i32) != 0) {
                                        n2 = S50.l(bArr4, i13, c4201u63);
                                        i14 = c4201u63.a;
                                        if (i14 < 0) {
                                            throw C4107sy.c();
                                        }
                                        if (i14 == 0) {
                                            c4201u63.c = "";
                                            unsafe3.putObject(obj5, j, c4201u63.c);
                                            byte[] bArr72 = bArr4;
                                            i23 = i38 | i35;
                                            bArr6 = bArr72;
                                            i18 = i2;
                                            i19 = n2;
                                            obj8 = obj5;
                                            i21 = i10;
                                            i20 = i4;
                                            i25 = 1048575;
                                            c4201u65 = c4201u63;
                                            unsafe4 = unsafe3;
                                            i22 = i9;
                                        } else {
                                            c4201u63.c = AbstractC4269v00.a.n(bArr4, n2, i14);
                                            n2 += i14;
                                            unsafe3.putObject(obj5, j, c4201u63.c);
                                            byte[] bArr722 = bArr4;
                                            i23 = i38 | i35;
                                            bArr6 = bArr722;
                                            i18 = i2;
                                            i19 = n2;
                                            obj8 = obj5;
                                            i21 = i10;
                                            i20 = i4;
                                            i25 = 1048575;
                                            c4201u65 = c4201u63;
                                            unsafe4 = unsafe3;
                                            i22 = i9;
                                        }
                                    } else {
                                        n2 = S50.l(bArr4, i13, c4201u63);
                                        i14 = c4201u63.a;
                                        if (i14 < 0) {
                                            throw C4107sy.c();
                                        }
                                        if (i14 == 0) {
                                            c4201u63.c = "";
                                            unsafe3.putObject(obj5, j, c4201u63.c);
                                            byte[] bArr7222 = bArr4;
                                            i23 = i38 | i35;
                                            bArr6 = bArr7222;
                                            i18 = i2;
                                            i19 = n2;
                                            obj8 = obj5;
                                            i21 = i10;
                                            i20 = i4;
                                            i25 = 1048575;
                                            c4201u65 = c4201u63;
                                            unsafe4 = unsafe3;
                                            i22 = i9;
                                        } else {
                                            c4201u63.c = new String(bArr4, n2, i14, AbstractC0656Yx.a);
                                            n2 += i14;
                                            unsafe3.putObject(obj5, j, c4201u63.c);
                                            byte[] bArr72222 = bArr4;
                                            i23 = i38 | i35;
                                            bArr6 = bArr72222;
                                            i18 = i2;
                                            i19 = n2;
                                            obj8 = obj5;
                                            i21 = i10;
                                            i20 = i4;
                                            i25 = 1048575;
                                            c4201u65 = c4201u63;
                                            unsafe4 = unsafe3;
                                            i22 = i9;
                                        }
                                    }
                                case 9:
                                    obj5 = obj8;
                                    C4201u6 c4201u610 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 != 2) {
                                        unsafe3 = unsafe4;
                                        c4201u63 = c4201u610;
                                        obj4 = obj5;
                                        unsafe2 = unsafe3;
                                        i11 = i13;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        Unsafe unsafe6 = unsafe4;
                                        Object y = of2.y(i10, obj5);
                                        unsafe3 = unsafe6;
                                        n2 = S50.B(y, of2.p(i10), bArr, i13, i2, c4201u610);
                                        bArr4 = bArr;
                                        c4201u63 = c4201u610;
                                        of2.Q(i10, obj5, y);
                                        byte[] bArr722222 = bArr4;
                                        i23 = i38 | i35;
                                        bArr6 = bArr722222;
                                        i18 = i2;
                                        i19 = n2;
                                        obj8 = obj5;
                                        i21 = i10;
                                        i20 = i4;
                                        i25 = 1048575;
                                        c4201u65 = c4201u63;
                                        unsafe4 = unsafe3;
                                        i22 = i9;
                                    }
                                case 10:
                                    bArr5 = bArr;
                                    obj6 = obj8;
                                    c4201u64 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 == 2) {
                                        f = S50.f(bArr5, i13, c4201u64);
                                        unsafe4.putObject(obj6, j, c4201u64.c);
                                        break;
                                    }
                                    Object obj10 = obj6;
                                    unsafe2 = unsafe4;
                                    obj4 = obj10;
                                    i11 = i13;
                                    of = of2;
                                    i19 = i11;
                                    i8 = i24;
                                    i21 = i10;
                                    i22 = i9;
                                    i23 = i38;
                                    i7 = i4;
                                    unsafe = unsafe2;
                                    obj2 = obj4;
                                    break;
                                case 12:
                                    bArr5 = bArr;
                                    obj6 = obj8;
                                    c4201u64 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 == 0) {
                                        f = S50.l(bArr5, i13, c4201u64);
                                        int i39 = c4201u64.a;
                                        of2.n(i10);
                                        unsafe4.putInt(obj6, j, i39);
                                        break;
                                    }
                                    Object obj102 = obj6;
                                    unsafe2 = unsafe4;
                                    obj4 = obj102;
                                    i11 = i13;
                                    of = of2;
                                    i19 = i11;
                                    i8 = i24;
                                    i21 = i10;
                                    i22 = i9;
                                    i23 = i38;
                                    i7 = i4;
                                    unsafe = unsafe2;
                                    obj2 = obj4;
                                    break;
                                case 15:
                                    bArr5 = bArr;
                                    obj6 = obj8;
                                    c4201u64 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 == 0) {
                                        f = S50.l(bArr5, i13, c4201u64);
                                        unsafe4.putInt(obj6, j, C0662Zd.a(c4201u64.a));
                                        break;
                                    }
                                    Object obj1022 = obj6;
                                    unsafe2 = unsafe4;
                                    obj4 = obj1022;
                                    i11 = i13;
                                    of = of2;
                                    i19 = i11;
                                    i8 = i24;
                                    i21 = i10;
                                    i22 = i9;
                                    i23 = i38;
                                    i7 = i4;
                                    unsafe = unsafe2;
                                    obj2 = obj4;
                                    break;
                                case 16:
                                    C4201u6 c4201u611 = c4201u65;
                                    c = 65535;
                                    i10 = i6;
                                    i13 = i19;
                                    if (i29 != 0) {
                                        unsafe2 = unsafe4;
                                        obj4 = obj8;
                                        i11 = i13;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        int n4 = S50.n(bArr, i13, c4201u611);
                                        unsafe4.putLong(obj8, j, C0662Zd.b(c4201u611.b));
                                        obj2 = obj8;
                                        i18 = i2;
                                        bArr6 = bArr;
                                        i19 = n4;
                                        i21 = i10;
                                        i20 = i4;
                                        i22 = i9;
                                        i25 = 1048575;
                                        c4201u65 = c4201u611;
                                        i23 = i38 | i35;
                                        obj8 = obj2;
                                    }
                                case 17:
                                    if (i29 != 3) {
                                        c = 65535;
                                        i10 = i6;
                                        unsafe2 = unsafe4;
                                        obj4 = obj8;
                                        i11 = i19;
                                        of = of2;
                                        i19 = i11;
                                        i8 = i24;
                                        i21 = i10;
                                        i22 = i9;
                                        i23 = i38;
                                        i7 = i4;
                                        unsafe = unsafe2;
                                        obj2 = obj4;
                                        break;
                                    } else {
                                        Object y2 = of2.y(i6, obj8);
                                        C4201u6 c4201u612 = c4201u65;
                                        int i40 = i6;
                                        int A = S50.A(y2, of2.p(i6), bArr, i19, i2, (i4 << 3) | 4, c4201u612);
                                        of2.Q(i40, obj8, y2);
                                        i23 = i38 | i35;
                                        bArr6 = bArr;
                                        i21 = i40;
                                        c4201u65 = c4201u612;
                                        i19 = A;
                                        i20 = i4;
                                        i22 = i9;
                                        i25 = 1048575;
                                        i18 = i2;
                                    }
                                default:
                                    unsafe2 = unsafe4;
                                    obj4 = obj8;
                                    i11 = i19;
                                    c = 65535;
                                    i10 = i6;
                                    of = of2;
                                    i19 = i11;
                                    i8 = i24;
                                    i21 = i10;
                                    i22 = i9;
                                    i23 = i38;
                                    i7 = i4;
                                    unsafe = unsafe2;
                                    obj2 = obj4;
                                    break;
                            }
                        } else {
                            Object obj11 = obj8;
                            Unsafe unsafe7 = unsafe4;
                            int i41 = i6;
                            if (S != 27) {
                                i8 = i24;
                                if (S <= 49) {
                                    int i42 = i22;
                                    int i43 = i23;
                                    i7 = i4;
                                    unsafe = unsafe7;
                                    int H = of2.H(obj, bArr, i19, i2, i8, i29, i41, i32, S, j, c4201u6);
                                    i8 = i8;
                                    if (H != i19) {
                                        bArr6 = bArr;
                                        i18 = i2;
                                        c4201u65 = c4201u6;
                                        i19 = H;
                                        i21 = i41;
                                        i23 = i43;
                                        i20 = i7;
                                        i22 = i42;
                                        i25 = 1048575;
                                        i24 = i8;
                                        obj8 = obj;
                                        unsafe4 = unsafe;
                                    } else {
                                        obj2 = obj;
                                        i19 = H;
                                        i21 = i41;
                                        i23 = i43;
                                        i22 = i42;
                                        of = of2;
                                    }
                                } else {
                                    obj7 = obj;
                                    i15 = i22;
                                    i16 = i23;
                                    i7 = i4;
                                    unsafe = unsafe7;
                                    i17 = i41;
                                    if (S == 50) {
                                        if (i29 == 2) {
                                            of2.E(i17, j, obj7);
                                            throw null;
                                        }
                                        of = of2;
                                        obj2 = obj7;
                                        i19 = i19;
                                    } else {
                                        int G = of2.G(obj7, bArr, i19, i2, i8, i7, i29, i32, S, j, i17, c4201u6);
                                        obj2 = obj7;
                                        i8 = i8;
                                        of = of2;
                                        if (G != i19) {
                                            bArr6 = bArr;
                                            i18 = i2;
                                            c4201u65 = c4201u6;
                                            of2 = of;
                                            i19 = G;
                                            i21 = i17;
                                            unsafe4 = unsafe;
                                            i23 = i16;
                                            i20 = i7;
                                            i22 = i15;
                                            i25 = 1048575;
                                            i24 = i8;
                                            obj8 = obj2;
                                        } else {
                                            i19 = G;
                                        }
                                    }
                                }
                            } else if (i29 == 2) {
                                InterfaceC0578Vx interfaceC0578Vx = (InterfaceC0578Vx) unsafe7.getObject(obj11, j);
                                if (!((AbstractC3160h0) interfaceC0578Vx).a) {
                                    int size = interfaceC0578Vx.size();
                                    interfaceC0578Vx = interfaceC0578Vx.g(size == 0 ? 10 : size * 2);
                                    unsafe7.putObject(obj11, j, interfaceC0578Vx);
                                }
                                bArr6 = bArr;
                                int i44 = S50.i(of2.p(i41), i24, bArr6, i19, i2, interfaceC0578Vx, c4201u6);
                                i18 = i2;
                                i19 = i44;
                                unsafe4 = unsafe7;
                                i21 = i41;
                                i20 = i4;
                                i25 = 1048575;
                                c4201u65 = c4201u6;
                                i24 = i24;
                                obj8 = obj;
                            } else {
                                i8 = i24;
                                obj7 = obj;
                                i15 = i22;
                                i16 = i23;
                                i7 = i4;
                                unsafe = unsafe7;
                                i17 = i41;
                                of = of2;
                                obj2 = obj7;
                                i19 = i19;
                            }
                            i21 = i17;
                            i23 = i16;
                            i22 = i15;
                        }
                    }
                    if (i8 != i3 || i3 == 0) {
                        AbstractC0367Nu abstractC0367Nu = (AbstractC0367Nu) obj2;
                        C4550yZ c4550yZ = abstractC0367Nu.unknownFields;
                        if (c4550yZ == C4550yZ.f) {
                            c4550yZ = C4550yZ.c();
                            abstractC0367Nu.unknownFields = c4550yZ;
                        }
                        int i45 = i8;
                        int j2 = S50.j(i45, bArr, i19, i2, c4550yZ, c4201u6);
                        i18 = i2;
                        bArr6 = bArr;
                        c4201u65 = c4201u6;
                        i24 = i45;
                        of2 = of;
                        unsafe4 = unsafe;
                        i20 = i7;
                        i25 = 1048575;
                        i19 = j2;
                        obj8 = obj2;
                    } else {
                        i18 = i2;
                        i24 = i8;
                    }
                } else {
                    of = of2;
                    unsafe = unsafe4;
                    obj2 = obj8;
                    obj3 = null;
                }
            }
            i20 = i4;
            i22 = i9;
        }
    }

    public final int G(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C4201u6 c4201u6) {
        int i9;
        Unsafe unsafe = o;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(S50.h(i, bArr))));
                int i10 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(S50.g(i, bArr))));
                int i11 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int n2 = S50.n(bArr, i, c4201u6);
                unsafe.putObject(obj, j, Long.valueOf(c4201u6.b));
                unsafe.putInt(obj, j2, i4);
                return n2;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int l = S50.l(bArr, i, c4201u6);
                unsafe.putObject(obj, j, Integer.valueOf(c4201u6.a));
                unsafe.putInt(obj, j2, i4);
                return l;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(S50.h(i, bArr)));
                int i12 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(S50.g(i, bArr)));
                int i13 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i13;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int n3 = S50.n(bArr, i, c4201u6);
                unsafe.putObject(obj, j, Boolean.valueOf(c4201u6.b != 0));
                unsafe.putInt(obj, j2, i4);
                return n3;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int l2 = S50.l(bArr, i, c4201u6);
                int i14 = c4201u6.a;
                if (i14 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0) {
                        if (AbstractC4269v00.a.Q(bArr, l2, l2 + i14) != 0) {
                            throw C4107sy.a();
                        }
                    }
                    unsafe.putObject(obj, j, new String(bArr, l2, i14, AbstractC0656Yx.a));
                    l2 += i14;
                }
                unsafe.putInt(obj, j2, i4);
                return l2;
            case 60:
                i9 = i;
                if (i5 == 2) {
                    Object z = z(obj, i4, i8);
                    int B = S50.B(z, p(i8), bArr, i9, i2, c4201u6);
                    R(obj, i4, i8, z);
                    return B;
                }
                break;
            case 61:
                i9 = i;
                if (i5 == 2) {
                    int f = S50.f(bArr, i9, c4201u6);
                    unsafe.putObject(obj, j, c4201u6.c);
                    unsafe.putInt(obj, j2, i4);
                    return f;
                }
                break;
            case 63:
                i9 = i;
                if (i5 == 0) {
                    int l3 = S50.l(bArr, i9, c4201u6);
                    int i15 = c4201u6.a;
                    n(i8);
                    unsafe.putObject(obj, j, Integer.valueOf(i15));
                    unsafe.putInt(obj, j2, i4);
                    return l3;
                }
                break;
            case 66:
                i9 = i;
                if (i5 == 0) {
                    int l4 = S50.l(bArr, i9, c4201u6);
                    unsafe.putObject(obj, j, Integer.valueOf(C0662Zd.a(c4201u6.a)));
                    unsafe.putInt(obj, j2, i4);
                    return l4;
                }
                break;
            case 67:
                i9 = i;
                if (i5 == 0) {
                    int n4 = S50.n(bArr, i9, c4201u6);
                    unsafe.putObject(obj, j, Long.valueOf(C0662Zd.b(c4201u6.b)));
                    unsafe.putInt(obj, j2, i4);
                    return n4;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object z2 = z(obj, i4, i8);
                    int A = S50.A(z2, p(i8), bArr, i, i2, (i3 & (-8)) | 4, c4201u6);
                    R(obj, i4, i8, z2);
                    return A;
                }
            default:
                return i;
        }
        return i9;
    }

    public final int H(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, C4201u6 c4201u6) {
        int i7;
        int m;
        Unsafe unsafe = o;
        InterfaceC0578Vx interfaceC0578Vx = (InterfaceC0578Vx) unsafe.getObject(obj, j2);
        if (!((AbstractC3160h0) interfaceC0578Vx).a) {
            interfaceC0578Vx = interfaceC0578Vx.g(interfaceC0578Vx.size() * 2);
            unsafe.putObject(obj, j2, interfaceC0578Vx);
        }
        InterfaceC0578Vx interfaceC0578Vx2 = interfaceC0578Vx;
        switch (i6) {
            case 18:
            case 35:
                if (i4 != 2) {
                    if (i4 != 1) {
                        return i;
                    }
                    AbstractC0255Jl abstractC0255Jl = (AbstractC0255Jl) interfaceC0578Vx2;
                    abstractC0255Jl.b(Double.longBitsToDouble(S50.h(i, bArr)));
                    int i8 = i + 8;
                    while (i8 < i2) {
                        int l = S50.l(bArr, i8, c4201u6);
                        if (i3 != c4201u6.a) {
                            return i8;
                        }
                        abstractC0255Jl.b(Double.longBitsToDouble(S50.h(l, bArr)));
                        i8 = l + 8;
                    }
                    return i8;
                }
                AbstractC0255Jl abstractC0255Jl2 = (AbstractC0255Jl) interfaceC0578Vx2;
                int l2 = S50.l(bArr, i, c4201u6);
                int i9 = c4201u6.a;
                int i10 = l2 + i9;
                if (i10 > bArr.length) {
                    throw C4107sy.e();
                }
                abstractC0255Jl2.getClass();
                int i11 = (i9 / 8) + 0;
                double[] dArr = abstractC0255Jl2.b;
                if (i11 > dArr.length) {
                    if (dArr.length == 0) {
                        abstractC0255Jl2.b = new double[Math.max(i11, 10)];
                    } else {
                        int length = dArr.length;
                        while (length < i11) {
                            length = W50.c(length, 3, 2, 1, 10);
                        }
                        abstractC0255Jl2.b = Arrays.copyOf(abstractC0255Jl2.b, length);
                    }
                }
                while (l2 < i10) {
                    abstractC0255Jl2.b(Double.longBitsToDouble(S50.h(l2, bArr)));
                    l2 += 8;
                }
                if (l2 == i10) {
                    return l2;
                }
                throw C4107sy.e();
            case 19:
            case 36:
                if (i4 != 2) {
                    if (i4 != 5) {
                        return i;
                    }
                    Lr lr = (Lr) interfaceC0578Vx2;
                    lr.b(Float.intBitsToFloat(S50.g(i, bArr)));
                    int i12 = i + 4;
                    while (i12 < i2) {
                        int l3 = S50.l(bArr, i12, c4201u6);
                        if (i3 != c4201u6.a) {
                            return i12;
                        }
                        lr.b(Float.intBitsToFloat(S50.g(l3, bArr)));
                        i12 = l3 + 4;
                    }
                    return i12;
                }
                Lr lr2 = (Lr) interfaceC0578Vx2;
                int l4 = S50.l(bArr, i, c4201u6);
                int i13 = c4201u6.a;
                int i14 = l4 + i13;
                if (i14 > bArr.length) {
                    throw C4107sy.e();
                }
                lr2.getClass();
                int i15 = (i13 / 4) + 0;
                float[] fArr = lr2.b;
                if (i15 > fArr.length) {
                    if (fArr.length == 0) {
                        lr2.b = new float[Math.max(i15, 10)];
                    } else {
                        int length2 = fArr.length;
                        while (length2 < i15) {
                            length2 = W50.c(length2, 3, 2, 1, 10);
                        }
                        lr2.b = Arrays.copyOf(lr2.b, length2);
                    }
                }
                while (l4 < i14) {
                    lr2.b(Float.intBitsToFloat(S50.g(l4, bArr)));
                    l4 += 4;
                }
                if (l4 == i14) {
                    return l4;
                }
                throw C4107sy.e();
            case 20:
            case 21:
            case 37:
            case 38:
                if (i4 == 2) {
                    AbstractC4291vD abstractC4291vD = (AbstractC4291vD) interfaceC0578Vx2;
                    int l5 = S50.l(bArr, i, c4201u6);
                    int i16 = c4201u6.a + l5;
                    while (l5 < i16) {
                        l5 = S50.n(bArr, l5, c4201u6);
                        abstractC4291vD.b(c4201u6.b);
                    }
                    if (l5 == i16) {
                        return l5;
                    }
                    throw C4107sy.e();
                }
                if (i4 != 0) {
                    return i;
                }
                AbstractC4291vD abstractC4291vD2 = (AbstractC4291vD) interfaceC0578Vx2;
                int n2 = S50.n(bArr, i, c4201u6);
                abstractC4291vD2.b(c4201u6.b);
                while (n2 < i2) {
                    int l6 = S50.l(bArr, n2, c4201u6);
                    if (i3 != c4201u6.a) {
                        return n2;
                    }
                    n2 = S50.n(bArr, l6, c4201u6);
                    abstractC4291vD2.b(c4201u6.b);
                }
                return n2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i4 != 2) {
                    return i4 == 0 ? S50.m(i3, bArr, i, i2, interfaceC0578Vx2, c4201u6) : i;
                }
                AbstractC0085Cx abstractC0085Cx = (AbstractC0085Cx) interfaceC0578Vx2;
                int l7 = S50.l(bArr, i, c4201u6);
                int i17 = c4201u6.a + l7;
                while (l7 < i17) {
                    l7 = S50.l(bArr, l7, c4201u6);
                    abstractC0085Cx.b(c4201u6.a);
                }
                if (l7 == i17) {
                    return l7;
                }
                throw C4107sy.e();
            case 23:
            case 32:
            case 40:
            case 46:
                if (i4 != 2) {
                    if (i4 != 1) {
                        return i;
                    }
                    AbstractC4291vD abstractC4291vD3 = (AbstractC4291vD) interfaceC0578Vx2;
                    abstractC4291vD3.b(S50.h(i, bArr));
                    int i18 = i + 8;
                    while (i18 < i2) {
                        int l8 = S50.l(bArr, i18, c4201u6);
                        if (i3 != c4201u6.a) {
                            return i18;
                        }
                        abstractC4291vD3.b(S50.h(l8, bArr));
                        i18 = l8 + 8;
                    }
                    return i18;
                }
                AbstractC4291vD abstractC4291vD4 = (AbstractC4291vD) interfaceC0578Vx2;
                int l9 = S50.l(bArr, i, c4201u6);
                int i19 = c4201u6.a;
                int i20 = l9 + i19;
                if (i20 > bArr.length) {
                    throw C4107sy.e();
                }
                abstractC4291vD4.getClass();
                int i21 = (i19 / 8) + 0;
                long[] jArr = abstractC4291vD4.b;
                if (i21 > jArr.length) {
                    if (jArr.length == 0) {
                        abstractC4291vD4.b = new long[Math.max(i21, 10)];
                    } else {
                        int length3 = jArr.length;
                        while (length3 < i21) {
                            length3 = W50.c(length3, 3, 2, 1, 10);
                        }
                        abstractC4291vD4.b = Arrays.copyOf(abstractC4291vD4.b, length3);
                    }
                }
                while (l9 < i20) {
                    abstractC4291vD4.b(S50.h(l9, bArr));
                    l9 += 8;
                }
                if (l9 == i20) {
                    return l9;
                }
                throw C4107sy.e();
            case 24:
            case 31:
            case 41:
            case 45:
                if (i4 != 2) {
                    if (i4 != 5) {
                        return i;
                    }
                    AbstractC0085Cx abstractC0085Cx2 = (AbstractC0085Cx) interfaceC0578Vx2;
                    abstractC0085Cx2.b(S50.g(i, bArr));
                    int i22 = i + 4;
                    while (i22 < i2) {
                        int l10 = S50.l(bArr, i22, c4201u6);
                        if (i3 != c4201u6.a) {
                            return i22;
                        }
                        abstractC0085Cx2.b(S50.g(l10, bArr));
                        i22 = l10 + 4;
                    }
                    return i22;
                }
                AbstractC0085Cx abstractC0085Cx3 = (AbstractC0085Cx) interfaceC0578Vx2;
                int l11 = S50.l(bArr, i, c4201u6);
                int i23 = c4201u6.a;
                int i24 = l11 + i23;
                if (i24 > bArr.length) {
                    throw C4107sy.e();
                }
                abstractC0085Cx3.getClass();
                int i25 = (i23 / 4) + 0;
                int[] iArr = abstractC0085Cx3.b;
                if (i25 > iArr.length) {
                    if (iArr.length == 0) {
                        abstractC0085Cx3.b = new int[Math.max(i25, 10)];
                    } else {
                        int length4 = iArr.length;
                        while (length4 < i25) {
                            length4 = W50.c(length4, 3, 2, 1, 10);
                        }
                        abstractC0085Cx3.b = Arrays.copyOf(abstractC0085Cx3.b, length4);
                    }
                }
                while (l11 < i24) {
                    abstractC0085Cx3.b(S50.g(l11, bArr));
                    l11 += 4;
                }
                if (l11 == i24) {
                    return l11;
                }
                throw C4107sy.e();
            case 25:
            case 42:
                if (i4 == 2) {
                    AbstractC0114Ea abstractC0114Ea = (AbstractC0114Ea) interfaceC0578Vx2;
                    int l12 = S50.l(bArr, i, c4201u6);
                    int i26 = c4201u6.a + l12;
                    while (l12 < i26) {
                        l12 = S50.n(bArr, l12, c4201u6);
                        abstractC0114Ea.b(c4201u6.b != 0);
                    }
                    if (l12 == i26) {
                        return l12;
                    }
                    throw C4107sy.e();
                }
                if (i4 != 0) {
                    return i;
                }
                AbstractC0114Ea abstractC0114Ea2 = (AbstractC0114Ea) interfaceC0578Vx2;
                int n3 = S50.n(bArr, i, c4201u6);
                abstractC0114Ea2.b(c4201u6.b != 0);
                while (n3 < i2) {
                    int l13 = S50.l(bArr, n3, c4201u6);
                    if (i3 != c4201u6.a) {
                        return n3;
                    }
                    n3 = S50.n(bArr, l13, c4201u6);
                    abstractC0114Ea2.b(c4201u6.b != 0);
                }
                return n3;
            case 26:
                if (i4 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    int l14 = S50.l(bArr, i, c4201u6);
                    int i27 = c4201u6.a;
                    if (i27 < 0) {
                        throw C4107sy.c();
                    }
                    if (i27 == 0) {
                        interfaceC0578Vx2.add("");
                    } else {
                        interfaceC0578Vx2.add(new String(bArr, l14, i27, AbstractC0656Yx.a));
                        l14 += i27;
                    }
                    while (l14 < i2) {
                        int l15 = S50.l(bArr, l14, c4201u6);
                        if (i3 != c4201u6.a) {
                            return l14;
                        }
                        l14 = S50.l(bArr, l15, c4201u6);
                        int i28 = c4201u6.a;
                        if (i28 < 0) {
                            throw C4107sy.c();
                        }
                        if (i28 == 0) {
                            interfaceC0578Vx2.add("");
                        } else {
                            interfaceC0578Vx2.add(new String(bArr, l14, i28, AbstractC0656Yx.a));
                            l14 += i28;
                        }
                    }
                    return l14;
                }
                int l16 = S50.l(bArr, i, c4201u6);
                int i29 = c4201u6.a;
                if (i29 < 0) {
                    throw C4107sy.c();
                }
                if (i29 == 0) {
                    interfaceC0578Vx2.add("");
                } else {
                    int i30 = l16 + i29;
                    if (AbstractC4269v00.a.Q(bArr, l16, i30) != 0) {
                        throw C4107sy.a();
                    }
                    interfaceC0578Vx2.add(new String(bArr, l16, i29, AbstractC0656Yx.a));
                    l16 = i30;
                }
                while (l16 < i2) {
                    int l17 = S50.l(bArr, l16, c4201u6);
                    if (i3 != c4201u6.a) {
                        return l16;
                    }
                    l16 = S50.l(bArr, l17, c4201u6);
                    int i31 = c4201u6.a;
                    if (i31 < 0) {
                        throw C4107sy.c();
                    }
                    if (i31 == 0) {
                        interfaceC0578Vx2.add("");
                    } else {
                        int i32 = l16 + i31;
                        if (AbstractC4269v00.a.Q(bArr, l16, i32) != 0) {
                            throw C4107sy.a();
                        }
                        interfaceC0578Vx2.add(new String(bArr, l16, i31, AbstractC0656Yx.a));
                        l16 = i32;
                    }
                }
                return l16;
            case 27:
                i7 = i;
                if (i4 == 2) {
                    return S50.i(p(i5), i3, bArr, i7, i2, interfaceC0578Vx2, c4201u6);
                }
                break;
            case 28:
                i7 = i;
                if (i4 == 2) {
                    int l18 = S50.l(bArr, i7, c4201u6);
                    int i33 = c4201u6.a;
                    if (i33 < 0) {
                        throw C4107sy.c();
                    }
                    if (i33 > bArr.length - l18) {
                        throw C4107sy.e();
                    }
                    if (i33 == 0) {
                        interfaceC0578Vx2.add(AbstractC4158tb.b);
                    } else {
                        interfaceC0578Vx2.add(AbstractC4158tb.d(bArr, l18, i33));
                        l18 += i33;
                    }
                    while (l18 < i2) {
                        int l19 = S50.l(bArr, l18, c4201u6);
                        if (i3 != c4201u6.a) {
                            return l18;
                        }
                        l18 = S50.l(bArr, l19, c4201u6);
                        int i34 = c4201u6.a;
                        if (i34 < 0) {
                            throw C4107sy.c();
                        }
                        if (i34 > bArr.length - l18) {
                            throw C4107sy.e();
                        }
                        if (i34 == 0) {
                            interfaceC0578Vx2.add(AbstractC4158tb.b);
                        } else {
                            interfaceC0578Vx2.add(AbstractC4158tb.d(bArr, l18, i34));
                            l18 += i34;
                        }
                    }
                    return l18;
                }
                break;
            case 30:
            case 44:
                i7 = i;
                if (i4 == 2) {
                    AbstractC0085Cx abstractC0085Cx4 = (AbstractC0085Cx) interfaceC0578Vx2;
                    m = S50.l(bArr, i7, c4201u6);
                    int i35 = c4201u6.a + m;
                    while (m < i35) {
                        m = S50.l(bArr, m, c4201u6);
                        abstractC0085Cx4.b(c4201u6.a);
                    }
                    if (m != i35) {
                        throw C4107sy.e();
                    }
                } else if (i4 == 0) {
                    m = S50.m(i3, bArr, i7, i2, interfaceC0578Vx2, c4201u6);
                }
                n(i5);
                Class cls = EQ.a;
                return m;
            case 33:
            case 47:
                i7 = i;
                if (i4 == 2) {
                    AbstractC0085Cx abstractC0085Cx5 = (AbstractC0085Cx) interfaceC0578Vx2;
                    int l20 = S50.l(bArr, i7, c4201u6);
                    int i36 = c4201u6.a + l20;
                    while (l20 < i36) {
                        l20 = S50.l(bArr, l20, c4201u6);
                        abstractC0085Cx5.b(C0662Zd.a(c4201u6.a));
                    }
                    if (l20 == i36) {
                        return l20;
                    }
                    throw C4107sy.e();
                }
                if (i4 == 0) {
                    AbstractC0085Cx abstractC0085Cx6 = (AbstractC0085Cx) interfaceC0578Vx2;
                    int l21 = S50.l(bArr, i7, c4201u6);
                    abstractC0085Cx6.b(C0662Zd.a(c4201u6.a));
                    while (l21 < i2) {
                        int l22 = S50.l(bArr, l21, c4201u6);
                        if (i3 != c4201u6.a) {
                            return l21;
                        }
                        l21 = S50.l(bArr, l22, c4201u6);
                        abstractC0085Cx6.b(C0662Zd.a(c4201u6.a));
                    }
                    return l21;
                }
                break;
            case 34:
            case 48:
                i7 = i;
                if (i4 == 2) {
                    AbstractC4291vD abstractC4291vD5 = (AbstractC4291vD) interfaceC0578Vx2;
                    int l23 = S50.l(bArr, i7, c4201u6);
                    int i37 = c4201u6.a + l23;
                    while (l23 < i37) {
                        l23 = S50.n(bArr, l23, c4201u6);
                        abstractC4291vD5.b(C0662Zd.b(c4201u6.b));
                    }
                    if (l23 == i37) {
                        return l23;
                    }
                    throw C4107sy.e();
                }
                if (i4 == 0) {
                    AbstractC4291vD abstractC4291vD6 = (AbstractC4291vD) interfaceC0578Vx2;
                    int n4 = S50.n(bArr, i7, c4201u6);
                    abstractC4291vD6.b(C0662Zd.b(c4201u6.b));
                    while (n4 < i2) {
                        int l24 = S50.l(bArr, n4, c4201u6);
                        if (i3 != c4201u6.a) {
                            return n4;
                        }
                        n4 = S50.n(bArr, l24, c4201u6);
                        abstractC4291vD6.b(C0662Zd.b(c4201u6.b));
                    }
                    return n4;
                }
                break;
            case 49:
                if (i4 == 3) {
                    InterfaceC4620zQ p = p(i5);
                    int i38 = (i3 & (-8)) | 4;
                    Object d = p.d();
                    int A = S50.A(d, p, bArr, i, i2, i38, c4201u6);
                    byte[] bArr2 = bArr;
                    int i39 = i2;
                    int i40 = i38;
                    C4201u6 c4201u62 = c4201u6;
                    p.b(d);
                    c4201u62.c = d;
                    interfaceC0578Vx2.add(d);
                    while (A < i39) {
                        int l25 = S50.l(bArr2, A, c4201u62);
                        if (i3 != c4201u62.a) {
                            return A;
                        }
                        Object d2 = p.d();
                        byte[] bArr3 = bArr2;
                        int i41 = i39;
                        C4201u6 c4201u63 = c4201u62;
                        int i42 = i40;
                        A = S50.A(d2, p, bArr3, l25, i41, i42, c4201u63);
                        p.b(d2);
                        c4201u63.c = d2;
                        interfaceC0578Vx2.add(d2);
                        i40 = i42;
                        bArr2 = bArr3;
                        i39 = i41;
                        c4201u62 = c4201u63;
                    }
                    return A;
                }
            default:
                return i;
        }
        return i7;
    }

    public final void I(Object obj, long j, R9 r9, InterfaceC4620zQ interfaceC4620zQ, C3625mp c3625mp) {
        int l;
        this.k.getClass();
        InterfaceC0578Vx a = C3738oC.a(j, obj);
        int i = r9.b;
        if ((i & 7) != 3) {
            throw C4107sy.b();
        }
        do {
            Object d = interfaceC4620zQ.d();
            r9.e(d, interfaceC4620zQ, c3625mp);
            interfaceC4620zQ.b(d);
            a.add(d);
            C0662Zd c0662Zd = (C0662Zd) r9.e;
            if (c0662Zd.d() || r9.d != 0) {
                return;
            } else {
                l = c0662Zd.l();
            }
        } while (l == i);
        r9.d = l;
    }

    public final void J(Object obj, int i, R9 r9, InterfaceC4620zQ interfaceC4620zQ, C3625mp c3625mp) {
        int l;
        this.k.getClass();
        InterfaceC0578Vx a = C3738oC.a(i & 1048575, obj);
        int i2 = r9.b;
        if ((i2 & 7) != 2) {
            throw C4107sy.b();
        }
        do {
            Object d = interfaceC4620zQ.d();
            r9.h(d, interfaceC4620zQ, c3625mp);
            interfaceC4620zQ.b(d);
            a.add(d);
            C0662Zd c0662Zd = (C0662Zd) r9.e;
            if (c0662Zd.d() || r9.d != 0) {
                return;
            } else {
                l = c0662Zd.l();
            }
        } while (l == i2);
        r9.d = l;
    }

    public final void K(int i, R9 r9, Object obj) {
        if ((536870912 & i) != 0) {
            AbstractC0846c00.p(i & 1048575, obj, r9.g0());
        } else if (this.f) {
            AbstractC0846c00.p(i & 1048575, obj, r9.c0());
        } else {
            AbstractC0846c00.p(i & 1048575, obj, r9.n());
        }
    }

    public final void L(int i, R9 r9, Object obj) {
        boolean z = (536870912 & i) != 0;
        C3738oC c3738oC = this.k;
        if (z) {
            c3738oC.getClass();
            r9.d0(C3738oC.a(i & 1048575, obj), true);
        } else {
            c3738oC.getClass();
            r9.d0(C3738oC.a(i & 1048575, obj), false);
        }
    }

    public final void N(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        AbstractC0846c00.n((1 << (i2 >>> 20)) | AbstractC0846c00.c.g(j, obj), j, obj);
    }

    public final void O(Object obj, int i, int i2) {
        AbstractC0846c00.n(i, this.a[i2 + 2] & 1048575, obj);
    }

    public final int P(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final void Q(int i, Object obj, Object obj2) {
        o.putObject(obj, T(i) & 1048575, obj2);
        N(i, obj);
    }

    public final void R(Object obj, int i, int i2, Object obj2) {
        o.putObject(obj, T(i2) & 1048575, obj2);
        O(obj, i, i2);
    }

    public final int T(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v41 */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v43 */
    public final void U(Object obj, C2835cv c2835cv) {
        int i;
        int i2;
        boolean z;
        OF of = this;
        int i3 = 1;
        int[] iArr = of.a;
        int length = iArr.length;
        Unsafe unsafe = o;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int T = of.T(i6);
            int i8 = iArr[i6];
            int S = S(T);
            if (S <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = T;
                i2 = i3 << (i9 >>> 20);
            } else {
                i = T;
                i2 = 0;
            }
            ?? r15 = i3;
            int[] iArr2 = iArr;
            long j = i & i4;
            switch (S) {
                case 0:
                    if (of.r(obj, i6, i5, i7, i2)) {
                        double e = AbstractC0846c00.c.e(j, obj);
                        AbstractC3612me abstractC3612me = (AbstractC3612me) c2835cv.b;
                        abstractC3612me.getClass();
                        abstractC3612me.c0(i8, Double.doubleToRawLongBits(e));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 1:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        float f = AbstractC0846c00.c.f(j, obj);
                        AbstractC3612me abstractC3612me2 = (AbstractC3612me) c2835cv.b;
                        abstractC3612me2.getClass();
                        abstractC3612me2.a0(i8, Float.floatToRawIntBits(f));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 2:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).k0(i8, unsafe.getLong(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 3:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).k0(i8, unsafe.getLong(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 4:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).e0(i8, unsafe.getInt(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 5:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).c0(i8, unsafe.getLong(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 6:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).a0(i8, unsafe.getInt(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 7:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).Y(i8, AbstractC0846c00.c.c(j, obj));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 8:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            ((AbstractC3612me) c2835cv.b).g0(i8, (String) object);
                            r15 = r15;
                        } else {
                            ((AbstractC3612me) c2835cv.b).Z(i8, (AbstractC4158tb) object);
                            r15 = r15;
                        }
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 9:
                    if (of.r(obj, i6, i5, i7, i2)) {
                        c2835cv.N(i8, unsafe.getObject(obj, j), of.p(i6));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 10:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).Z(i8, (AbstractC4158tb) unsafe.getObject(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 11:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).i0(i8, unsafe.getInt(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 12:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).e0(i8, unsafe.getInt(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 13:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).a0(i8, unsafe.getInt(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 14:
                    r15 = r15;
                    if (of.r(obj, i6, i5, i7, i2)) {
                        ((AbstractC3612me) c2835cv.b).c0(i8, unsafe.getLong(obj, j));
                        r15 = r15;
                    }
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 15:
                    if (of.r(obj, i6, i5, i7, i2)) {
                        int i11 = unsafe.getInt(obj, j);
                        r15 = 1;
                        ((AbstractC3612me) c2835cv.b).i0(i8, (i11 >> 31) ^ (i11 << 1));
                        of = this;
                        i6 += 3;
                        i3 = r15;
                        iArr = iArr2;
                        i4 = 1048575;
                    }
                    r15 = 1;
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 16:
                    if (of.r(obj, i6, i5, i7, i2)) {
                        long j2 = unsafe.getLong(obj, j);
                        ((AbstractC3612me) c2835cv.b).k0(i8, (j2 << 1) ^ (j2 >> 63));
                    }
                    r15 = 1;
                    of = this;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 17:
                    if (of.r(obj, i6, i5, i7, i2)) {
                        c2835cv.M(i8, unsafe.getObject(obj, j), of.p(i6));
                    }
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 18:
                    EQ.n(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 19:
                    EQ.r(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 20:
                    EQ.t(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 21:
                    EQ.z(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 22:
                    EQ.s(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 23:
                    EQ.q(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 24:
                    EQ.p(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 25:
                    EQ.m(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 26:
                    int i12 = iArr2[i6];
                    List list = (List) unsafe.getObject(obj, j);
                    Class cls = EQ.a;
                    if (list != null && !list.isEmpty()) {
                        c2835cv.getClass();
                        boolean z2 = list instanceof ZA;
                        AbstractC3612me abstractC3612me3 = (AbstractC3612me) c2835cv.b;
                        if (z2) {
                            ZA za = (ZA) list;
                            for (int i13 = 0; i13 < list.size(); i13++) {
                                Object f2 = za.f();
                                if (f2 instanceof String) {
                                    abstractC3612me3.g0(i12, (String) f2);
                                } else {
                                    abstractC3612me3.Z(i12, (AbstractC4158tb) f2);
                                }
                            }
                        } else {
                            for (int i14 = 0; i14 < list.size(); i14++) {
                                abstractC3612me3.g0(i12, (String) list.get(i14));
                            }
                        }
                    }
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                    break;
                case 27:
                    int i15 = iArr2[i6];
                    List list2 = (List) unsafe.getObject(obj, j);
                    InterfaceC4620zQ p = of.p(i6);
                    Class cls2 = EQ.a;
                    if (list2 != null && !list2.isEmpty()) {
                        c2835cv.getClass();
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            c2835cv.N(i15, list2.get(i16), p);
                        }
                    }
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                    break;
                case 28:
                    int i17 = iArr2[i6];
                    List list3 = (List) unsafe.getObject(obj, j);
                    Class cls3 = EQ.a;
                    if (list3 != null && !list3.isEmpty()) {
                        c2835cv.getClass();
                        for (int i18 = 0; i18 < list3.size(); i18++) {
                            ((AbstractC3612me) c2835cv.b).Z(i17, (AbstractC4158tb) list3.get(i18));
                        }
                    }
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                    break;
                case 29:
                    z = false;
                    EQ.y(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 30:
                    z = false;
                    EQ.o(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 31:
                    z = false;
                    EQ.u(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 32:
                    z = false;
                    EQ.v(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 33:
                    z = false;
                    EQ.w(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 34:
                    z = false;
                    EQ.x(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, false);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 35:
                    EQ.n(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    r15 = 1;
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 36:
                    EQ.r(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 37:
                    EQ.t(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 38:
                    EQ.z(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 39:
                    EQ.s(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 40:
                    EQ.q(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 41:
                    EQ.p(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 42:
                    EQ.m(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 43:
                    EQ.y(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 44:
                    EQ.o(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 45:
                    EQ.u(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 46:
                    EQ.v(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 47:
                    EQ.w(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 48:
                    EQ.x(iArr2[i6], (List) unsafe.getObject(obj, j), c2835cv, r15);
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 49:
                    int i19 = iArr2[i6];
                    List list4 = (List) unsafe.getObject(obj, j);
                    InterfaceC4620zQ p2 = of.p(i6);
                    Class cls4 = EQ.a;
                    if (list4 != null && !list4.isEmpty()) {
                        c2835cv.getClass();
                        for (int i20 = 0; i20 < list4.size(); i20 += r15 == true ? 1 : 0) {
                            c2835cv.M(i19, list4.get(i20), p2);
                        }
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        Object o2 = of.o(i6);
                        of.m.getClass();
                        W50.z(o2);
                        throw null;
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 51:
                    if (of.t(obj, i8, i6)) {
                        double doubleValue = ((Double) AbstractC0846c00.c.i(j, obj)).doubleValue();
                        AbstractC3612me abstractC3612me4 = (AbstractC3612me) c2835cv.b;
                        abstractC3612me4.getClass();
                        abstractC3612me4.c0(i8, Double.doubleToRawLongBits(doubleValue));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 52:
                    if (of.t(obj, i8, i6)) {
                        float floatValue = ((Float) AbstractC0846c00.c.i(j, obj)).floatValue();
                        AbstractC3612me abstractC3612me5 = (AbstractC3612me) c2835cv.b;
                        abstractC3612me5.getClass();
                        abstractC3612me5.a0(i8, Float.floatToRawIntBits(floatValue));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 53:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).k0(i8, D(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 54:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).k0(i8, D(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 55:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).e0(i8, C(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 56:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).c0(i8, D(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 57:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).a0(i8, C(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 58:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).Y(i8, ((Boolean) AbstractC0846c00.c.i(j, obj)).booleanValue());
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 59:
                    if (of.t(obj, i8, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof String) {
                            ((AbstractC3612me) c2835cv.b).g0(i8, (String) object2);
                        } else {
                            ((AbstractC3612me) c2835cv.b).Z(i8, (AbstractC4158tb) object2);
                        }
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 60:
                    if (of.t(obj, i8, i6)) {
                        c2835cv.N(i8, unsafe.getObject(obj, j), of.p(i6));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 61:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).Z(i8, (AbstractC4158tb) unsafe.getObject(obj, j));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 62:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).i0(i8, C(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 63:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).e0(i8, C(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 64:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).a0(i8, C(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 65:
                    if (of.t(obj, i8, i6)) {
                        ((AbstractC3612me) c2835cv.b).c0(i8, D(j, obj));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 66:
                    if (of.t(obj, i8, i6)) {
                        int C = C(j, obj);
                        ((AbstractC3612me) c2835cv.b).i0(i8, (C >> 31) ^ (C << 1));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 67:
                    if (of.t(obj, i8, i6)) {
                        long D = D(j, obj);
                        ((AbstractC3612me) c2835cv.b).k0(i8, (D << (r15 == true ? 1L : 0L)) ^ (D >> 63));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                case 68:
                    if (of.t(obj, i8, i6)) {
                        c2835cv.M(i8, unsafe.getObject(obj, j), of.p(i6));
                    }
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
                default:
                    i6 += 3;
                    i3 = r15;
                    iArr = iArr2;
                    i4 = 1048575;
            }
        }
        of.l.getClass();
        ((AbstractC0367Nu) obj).unknownFields.e(c2835cv);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.InterfaceC4620zQ
    public final void a(Object obj, Object obj2) {
        Object obj3;
        l(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                EQ.k(this.l, obj, obj2);
                return;
            }
            int T = T(i);
            long j = 1048575 & T;
            int i2 = iArr[i];
            switch (S(T)) {
                case 0:
                    if (q(i, obj2)) {
                        ZZ zz = AbstractC0846c00.c;
                        obj3 = obj;
                        zz.m(obj3, j, zz.e(j, obj2));
                        N(i, obj3);
                        break;
                    }
                    obj3 = obj;
                    break;
                case 1:
                    if (q(i, obj2)) {
                        ZZ zz2 = AbstractC0846c00.c;
                        zz2.n(obj, j, zz2.f(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (q(i, obj2)) {
                        AbstractC0846c00.o(obj, j, AbstractC0846c00.c.h(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (q(i, obj2)) {
                        AbstractC0846c00.o(obj, j, AbstractC0846c00.c.h(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (q(i, obj2)) {
                        AbstractC0846c00.o(obj, j, AbstractC0846c00.c.h(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (q(i, obj2)) {
                        ZZ zz3 = AbstractC0846c00.c;
                        zz3.k(obj, j, zz3.c(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (q(i, obj2)) {
                        AbstractC0846c00.p(j, obj, AbstractC0846c00.c.i(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    w(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (q(i, obj2)) {
                        AbstractC0846c00.p(j, obj, AbstractC0846c00.c.i(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (q(i, obj2)) {
                        AbstractC0846c00.o(obj, j, AbstractC0846c00.c.h(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (q(i, obj2)) {
                        AbstractC0846c00.n(AbstractC0846c00.c.g(j, obj2), j, obj);
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (q(i, obj2)) {
                        AbstractC0846c00.o(obj, j, AbstractC0846c00.c.h(j, obj2));
                        N(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    w(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.k.getClass();
                    ZZ zz4 = AbstractC0846c00.c;
                    InterfaceC0578Vx interfaceC0578Vx = (InterfaceC0578Vx) zz4.i(j, obj);
                    InterfaceC0578Vx interfaceC0578Vx2 = (InterfaceC0578Vx) zz4.i(j, obj2);
                    int size = interfaceC0578Vx.size();
                    int size2 = interfaceC0578Vx2.size();
                    if (size > 0 && size2 > 0) {
                        if (!((AbstractC3160h0) interfaceC0578Vx).a) {
                            interfaceC0578Vx = interfaceC0578Vx.g(size2 + size);
                        }
                        interfaceC0578Vx.addAll(interfaceC0578Vx2);
                    }
                    if (size > 0) {
                        interfaceC0578Vx2 = interfaceC0578Vx;
                    }
                    AbstractC0846c00.p(j, obj, interfaceC0578Vx2);
                    obj3 = obj;
                    break;
                case 50:
                    Class cls = EQ.a;
                    ZZ zz5 = AbstractC0846c00.c;
                    Object i3 = zz5.i(j, obj);
                    Object i4 = zz5.i(j, obj2);
                    this.m.getClass();
                    AbstractC0846c00.p(j, obj, C0710aE.a(i3, i4));
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (t(obj2, i2, i)) {
                        AbstractC0846c00.p(j, obj, AbstractC0846c00.c.i(j, obj2));
                        O(obj, i2, i);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    x(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (t(obj2, i2, i)) {
                        AbstractC0846c00.p(j, obj, AbstractC0846c00.c.i(j, obj2));
                        O(obj, i2, i);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    x(i, obj, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i += 3;
            obj = obj3;
        }
    }

    @Override // defpackage.InterfaceC4620zQ
    public final void b(Object obj) {
        if (s(obj)) {
            if (obj instanceof AbstractC0367Nu) {
                AbstractC0367Nu abstractC0367Nu = (AbstractC0367Nu) obj;
                abstractC0367Nu.u(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                abstractC0367Nu.memoizedHashCode = 0;
                abstractC0367Nu.o();
            }
            int[] iArr = this.a;
            int length = iArr.length;
            for (int i = 0; i < length; i += 3) {
                int T = T(i);
                long j = 1048575 & T;
                int S = S(T);
                if (S != 9) {
                    if (S != 60 && S != 68) {
                        switch (S) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.k.getClass();
                                AbstractC3160h0 abstractC3160h0 = (AbstractC3160h0) ((InterfaceC0578Vx) AbstractC0846c00.c.i(j, obj));
                                if (abstractC3160h0.a) {
                                    abstractC3160h0.a = false;
                                    break;
                                } else {
                                    break;
                                }
                            case 50:
                                Unsafe unsafe = o;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    this.m.getClass();
                                    ((XD) object).a = false;
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (t(obj, iArr[i], i)) {
                        p(i).b(o.getObject(obj, j));
                    }
                }
                if (q(i, obj)) {
                    p(i).b(o.getObject(obj, j));
                }
            }
            this.l.getClass();
            C4550yZ c4550yZ = ((AbstractC0367Nu) obj).unknownFields;
            if (c4550yZ.e) {
                c4550yZ.e = false;
            }
        }
    }

    @Override // defpackage.InterfaceC4620zQ
    public final boolean c(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.h) {
            int i7 = this.g[i6];
            int[] iArr = this.a;
            int i8 = iArr[i7];
            int T = T(i7);
            int i9 = iArr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = o.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i5;
                i = i10;
            } else {
                int i12 = i5;
                i = i4;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & T) == 0 || r(obj, i2, i, i3, i11)) {
                int S = S(T);
                if (S == 9 || S == 17) {
                    if (r(obj, i2, i, i3, i11)) {
                        if (!p(i2).c(AbstractC0846c00.c.i(T & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i6++;
                    i4 = i;
                    i5 = i3;
                } else {
                    if (S != 27) {
                        if (S == 60 || S == 68) {
                            if (t(obj, i8, i2)) {
                                if (!p(i2).c(AbstractC0846c00.c.i(T & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                        } else if (S != 49) {
                            if (S != 50) {
                                continue;
                            } else {
                                Object i13 = AbstractC0846c00.c.i(T & 1048575, obj);
                                this.m.getClass();
                                if (!((XD) i13).isEmpty()) {
                                    W50.z(o(i2));
                                    throw null;
                                }
                            }
                        }
                        i6++;
                        i4 = i;
                        i5 = i3;
                    }
                    List list = (List) AbstractC0846c00.c.i(T & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        InterfaceC4620zQ p = p(i2);
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            if (p.c(list.get(i14))) {
                            }
                        }
                    }
                    i6++;
                    i4 = i;
                    i5 = i3;
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.InterfaceC4620zQ
    public final Object d() {
        this.j.getClass();
        return ((AbstractC0367Nu) this.e).q();
    }

    @Override // defpackage.InterfaceC4620zQ
    public final void e(Object obj, R9 r9, C3625mp c3625mp) {
        c3625mp.getClass();
        l(obj);
        u(this.l, obj, r9, c3625mp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0216, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00df, code lost:
    
        if (r4 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r8 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e2, code lost:
    
        r3 = r8 + r3;
     */
    @Override // defpackage.InterfaceC4620zQ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f(AbstractC0367Nu abstractC0367Nu) {
        int i;
        int b;
        int i2;
        int[] iArr = this.a;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int T = T(i4);
            int i5 = iArr[i4];
            long j = 1048575 & T;
            int i6 = 1237;
            int i7 = 37;
            switch (S(T)) {
                case 0:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(Double.doubleToLongBits(AbstractC0846c00.c.e(j, abstractC0367Nu)));
                    i3 = b + i;
                    break;
                case 1:
                    i = i3 * 53;
                    b = Float.floatToIntBits(AbstractC0846c00.c.f(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 2:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(AbstractC0846c00.c.h(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 3:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(AbstractC0846c00.c.h(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 4:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 5:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(AbstractC0846c00.c.h(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 6:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    boolean c = AbstractC0846c00.c.c(j, abstractC0367Nu);
                    Charset charset = AbstractC0656Yx.a;
                    break;
                case 8:
                    i = i3 * 53;
                    b = ((String) AbstractC0846c00.c.i(j, abstractC0367Nu)).hashCode();
                    i3 = b + i;
                    break;
                case 9:
                    Object i8 = AbstractC0846c00.c.i(j, abstractC0367Nu);
                    if (i8 != null) {
                        i7 = i8.hashCode();
                    }
                    i3 = (i3 * 53) + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                    i3 = b + i;
                    break;
                case 11:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 12:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 13:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 14:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(AbstractC0846c00.c.h(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 15:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.g(j, abstractC0367Nu);
                    i3 = b + i;
                    break;
                case 16:
                    i = i3 * 53;
                    b = AbstractC0656Yx.b(AbstractC0846c00.c.h(j, abstractC0367Nu));
                    i3 = b + i;
                    break;
                case 17:
                    Object i9 = AbstractC0846c00.c.i(j, abstractC0367Nu);
                    if (i9 != null) {
                        i7 = i9.hashCode();
                    }
                    i3 = (i3 * 53) + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                    i3 = b + i;
                    break;
                case 50:
                    i = i3 * 53;
                    b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                    i3 = b + i;
                    break;
                case 51:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(Double.doubleToLongBits(((Double) AbstractC0846c00.c.i(j, abstractC0367Nu)).doubleValue()));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = Float.floatToIntBits(((Float) AbstractC0846c00.c.i(j, abstractC0367Nu)).floatValue());
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(D(j, abstractC0367Nu));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(D(j, abstractC0367Nu));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(D(j, abstractC0367Nu));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i2 = i3 * 53;
                        boolean booleanValue = ((Boolean) AbstractC0846c00.c.i(j, abstractC0367Nu)).booleanValue();
                        Charset charset2 = AbstractC0656Yx.a;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = ((String) AbstractC0846c00.c.i(j, abstractC0367Nu)).hashCode();
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(D(j, abstractC0367Nu));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = C(j, abstractC0367Nu);
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0656Yx.b(D(j, abstractC0367Nu));
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (t(abstractC0367Nu, i5, i4)) {
                        i = i3 * 53;
                        b = AbstractC0846c00.c.i(j, abstractC0367Nu).hashCode();
                        i3 = b + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.l.getClass();
        return abstractC0367Nu.unknownFields.hashCode() + (i3 * 53);
    }

    @Override // defpackage.InterfaceC4620zQ
    public final void g(Object obj, byte[] bArr, int i, int i2, C4201u6 c4201u6) {
        F(obj, bArr, i, i2, 0, c4201u6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.InterfaceC4620zQ
    public final int h(AbstractC0367Nu abstractC0367Nu) {
        int i;
        int i2;
        int T;
        int T2;
        int T3;
        int V;
        int T4;
        int V2;
        int T5;
        int T6;
        int O;
        int T7;
        int size;
        int i3;
        int T8;
        int T9;
        int size2;
        int T10;
        int U;
        int i4;
        int T11;
        int T12;
        int T13;
        int V3;
        int T14;
        int V4;
        int T15;
        int U2;
        OF of = this;
        AbstractC0367Nu abstractC0367Nu2 = abstractC0367Nu;
        int i5 = 1;
        Unsafe unsafe = o;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        while (true) {
            int[] iArr = of.a;
            if (i6 >= iArr.length) {
                of.l.getClass();
                return abstractC0367Nu2.unknownFields.b() + i8;
            }
            int T16 = of.T(i6);
            int S = S(T16);
            int i10 = iArr[i6];
            int i11 = iArr[i6 + 2];
            int i12 = i11 & 1048575;
            if (S <= 17) {
                if (i12 != i9) {
                    i7 = i12 == 1048575 ? 0 : unsafe.getInt(abstractC0367Nu2, i12);
                    i9 = i12;
                }
                i = i5 << (i11 >>> 20);
            } else {
                i = 0;
            }
            long j = T16 & 1048575;
            if (S >= EnumC3705nq.b.a) {
                int i13 = EnumC3705nq.c.a;
            }
            switch (S) {
                case 0:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T = AbstractC3612me.T(i10) + 8;
                        i8 += T;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 1:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T2 = AbstractC3612me.T(i10);
                        T6 = T2 + 4;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 2:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        long j2 = unsafe.getLong(abstractC0367Nu2, j);
                        T3 = AbstractC3612me.T(i10);
                        V = AbstractC3612me.V(j2);
                        i8 += V + T3;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 3:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        long j3 = unsafe.getLong(abstractC0367Nu2, j);
                        T3 = AbstractC3612me.T(i10);
                        V = AbstractC3612me.V(j3);
                        i8 += V + T3;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 4:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        int i14 = unsafe.getInt(abstractC0367Nu2, j);
                        T4 = AbstractC3612me.T(i10);
                        V2 = AbstractC3612me.V(i14);
                        O = V2 + T4;
                        i8 += O;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 5:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T5 = AbstractC3612me.T(i10);
                        T6 = T5 + 8;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 6:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T2 = AbstractC3612me.T(i10);
                        T6 = T2 + 4;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 7:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T6 = AbstractC3612me.T(i10) + 1;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 8:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        Object object = unsafe.getObject(abstractC0367Nu2, j);
                        i8 = (object instanceof AbstractC4158tb ? AbstractC3612me.O(i10, (AbstractC4158tb) object) : AbstractC3612me.S((String) object) + AbstractC3612me.T(i10)) + i8;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 9:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        Object object2 = unsafe.getObject(abstractC0367Nu2, j);
                        InterfaceC4620zQ p = of.p(i6);
                        Class cls = EQ.a;
                        int T17 = AbstractC3612me.T(i10);
                        int a = ((AbstractC0766b0) object2).a(p);
                        i8 += AbstractC3612me.U(a) + a + T17;
                    }
                    i6 += 3;
                    i5 = i2;
                case 10:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        O = AbstractC3612me.O(i10, (AbstractC4158tb) unsafe.getObject(abstractC0367Nu2, j));
                        i8 += O;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 11:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        int i15 = unsafe.getInt(abstractC0367Nu2, j);
                        T4 = AbstractC3612me.T(i10);
                        V2 = AbstractC3612me.U(i15);
                        O = V2 + T4;
                        i8 += O;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 12:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        int i16 = unsafe.getInt(abstractC0367Nu2, j);
                        T4 = AbstractC3612me.T(i10);
                        V2 = AbstractC3612me.V(i16);
                        O = V2 + T4;
                        i8 += O;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 13:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T2 = AbstractC3612me.T(i10);
                        T6 = T2 + 4;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 14:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T5 = AbstractC3612me.T(i10);
                        T6 = T5 + 8;
                        i8 += T6;
                    }
                    of = this;
                    abstractC0367Nu2 = abstractC0367Nu;
                    i6 += 3;
                    i5 = i2;
                case 15:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        int i17 = unsafe.getInt(abstractC0367Nu2, j);
                        T4 = AbstractC3612me.T(i10);
                        V2 = AbstractC3612me.Q(i17);
                        O = V2 + T4;
                        i8 += O;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 16:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        long j4 = unsafe.getLong(abstractC0367Nu2, j);
                        T3 = AbstractC3612me.T(i10);
                        V = AbstractC3612me.R(j4);
                        i8 += V + T3;
                    }
                    of = this;
                    i6 += 3;
                    i5 = i2;
                case 17:
                    i2 = i5;
                    if (of.r(abstractC0367Nu2, i6, i9, i7, i)) {
                        T = ((AbstractC0766b0) unsafe.getObject(abstractC0367Nu2, j)).a(of.p(i6)) + (AbstractC3612me.T(i10) * 2);
                        i8 += T;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 18:
                    i2 = i5;
                    T = EQ.c(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 19:
                    i2 = i5;
                    T = EQ.b(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 20:
                    i2 = i5;
                    List list = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls2 = EQ.a;
                    if (list.size() != 0) {
                        T7 = (AbstractC3612me.T(i10) * list.size()) + EQ.e(list);
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 21:
                    i2 = i5;
                    List list2 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls3 = EQ.a;
                    size = list2.size();
                    if (size != 0) {
                        i3 = EQ.i(list2);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 22:
                    i2 = i5;
                    List list3 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls4 = EQ.a;
                    size = list3.size();
                    if (size != 0) {
                        i3 = EQ.d(list3);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 23:
                    i2 = i5;
                    T = EQ.c(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 24:
                    i2 = i5;
                    T = EQ.b(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 25:
                    i2 = i5;
                    List list4 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls5 = EQ.a;
                    int size3 = list4.size();
                    i8 += size3 == 0 ? 0 : (AbstractC3612me.T(i10) + 1) * size3;
                    i6 += 3;
                    i5 = i2;
                case 26:
                    i2 = i5;
                    List list5 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls6 = EQ.a;
                    int size4 = list5.size();
                    if (size4 != 0) {
                        T7 = AbstractC3612me.T(i10) * size4;
                        if (list5 instanceof ZA) {
                            ZA za = (ZA) list5;
                            for (int i18 = 0; i18 < size4; i18++) {
                                Object f = za.f();
                                T7 = (f instanceof AbstractC4158tb ? AbstractC3612me.P((AbstractC4158tb) f) : AbstractC3612me.S((String) f)) + T7;
                            }
                        } else {
                            for (int i19 = 0; i19 < size4; i19++) {
                                Object obj = list5.get(i19);
                                T7 = (obj instanceof AbstractC4158tb ? AbstractC3612me.P((AbstractC4158tb) obj) : AbstractC3612me.S((String) obj)) + T7;
                            }
                        }
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 27:
                    i2 = i5;
                    List list6 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    InterfaceC4620zQ p2 = of.p(i6);
                    Class cls7 = EQ.a;
                    int size5 = list6.size();
                    if (size5 == 0) {
                        T9 = 0;
                    } else {
                        T9 = AbstractC3612me.T(i10) * size5;
                        for (int i20 = 0; i20 < size5; i20++) {
                            int a2 = ((AbstractC0766b0) list6.get(i20)).a(p2);
                            T9 += AbstractC3612me.U(a2) + a2;
                        }
                    }
                    i8 += T9;
                    i6 += 3;
                    i5 = i2;
                case 28:
                    i2 = i5;
                    List list7 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls8 = EQ.a;
                    int size6 = list7.size();
                    if (size6 != 0) {
                        T7 = AbstractC3612me.T(i10) * size6;
                        for (int i21 = 0; i21 < list7.size(); i21++) {
                            T7 += AbstractC3612me.P((AbstractC4158tb) list7.get(i21));
                        }
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 29:
                    i2 = i5;
                    List list8 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls9 = EQ.a;
                    size = list8.size();
                    if (size != 0) {
                        i3 = EQ.h(list8);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 30:
                    i2 = i5;
                    List list9 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls10 = EQ.a;
                    size = list9.size();
                    if (size != 0) {
                        i3 = EQ.a(list9);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 31:
                    i2 = i5;
                    T = EQ.b(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 32:
                    i2 = i5;
                    T = EQ.c(i10, (List) unsafe.getObject(abstractC0367Nu2, j));
                    i8 += T;
                    i6 += 3;
                    i5 = i2;
                case 33:
                    i2 = i5;
                    List list10 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls11 = EQ.a;
                    size = list10.size();
                    if (size != 0) {
                        i3 = EQ.f(list10);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 34:
                    i2 = i5;
                    List list11 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls12 = EQ.a;
                    size = list11.size();
                    if (size != 0) {
                        i3 = EQ.g(list11);
                        T8 = AbstractC3612me.T(i10);
                        T7 = (T8 * size) + i3;
                        i8 += T7;
                        i6 += 3;
                        i5 = i2;
                    }
                    T7 = 0;
                    i8 += T7;
                    i6 += 3;
                    i5 = i2;
                case 35:
                    i2 = i5;
                    List list12 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls13 = EQ.a;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 36:
                    i2 = i5;
                    List list13 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls14 = EQ.a;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 37:
                    i2 = i5;
                    size2 = EQ.e((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 38:
                    i2 = i5;
                    size2 = EQ.i((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 39:
                    i2 = i5;
                    size2 = EQ.d((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 40:
                    i2 = i5;
                    List list14 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls15 = EQ.a;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 41:
                    i2 = i5;
                    List list15 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls16 = EQ.a;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 42:
                    i2 = i5;
                    List list16 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls17 = EQ.a;
                    size2 = list16.size();
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 43:
                    i2 = i5;
                    size2 = EQ.h((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 44:
                    i2 = i5;
                    size2 = EQ.a((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 45:
                    i2 = i5;
                    List list17 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls18 = EQ.a;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 46:
                    i2 = i5;
                    List list18 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    Class cls19 = EQ.a;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 47:
                    i2 = i5;
                    size2 = EQ.f((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 48:
                    i2 = i5;
                    size2 = EQ.g((List) unsafe.getObject(abstractC0367Nu2, j));
                    if (size2 > 0) {
                        T10 = AbstractC3612me.T(i10);
                        U = AbstractC3612me.U(size2);
                        i8 += U + T10 + size2;
                        i6 += 3;
                        i5 = i2;
                    } else {
                        i6 += 3;
                        i5 = i2;
                    }
                case 49:
                    List list19 = (List) unsafe.getObject(abstractC0367Nu2, j);
                    InterfaceC4620zQ p3 = of.p(i6);
                    Class cls20 = EQ.a;
                    int size7 = list19.size();
                    if (size7 == 0) {
                        i4 = 0;
                    } else {
                        int i22 = 0;
                        i4 = 0;
                        while (i22 < size7) {
                            i4 += ((AbstractC0766b0) list19.get(i22)).a(p3) + (AbstractC3612me.T(i10) * 2);
                            i22++;
                            i5 = i5;
                        }
                    }
                    i2 = i5;
                    i8 += i4;
                    i6 += 3;
                    i5 = i2;
                case 50:
                    Object object3 = unsafe.getObject(abstractC0367Nu2, j);
                    Object o2 = of.o(i6);
                    of.m.getClass();
                    XD xd = (XD) object3;
                    if (o2 != null) {
                        throw new ClassCastException();
                    }
                    if (!xd.isEmpty()) {
                        Iterator it = xd.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 51:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T11 = AbstractC3612me.T(i10);
                        T15 = T11 + 8;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 52:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T12 = AbstractC3612me.T(i10);
                        T15 = T12 + 4;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 53:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        long D = D(j, abstractC0367Nu2);
                        T13 = AbstractC3612me.T(i10);
                        V3 = AbstractC3612me.V(D);
                        U2 = V3 + T13;
                        i8 += U2;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 54:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        long D2 = D(j, abstractC0367Nu2);
                        T13 = AbstractC3612me.T(i10);
                        V3 = AbstractC3612me.V(D2);
                        U2 = V3 + T13;
                        i8 += U2;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 55:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        int C = C(j, abstractC0367Nu2);
                        T14 = AbstractC3612me.T(i10);
                        V4 = AbstractC3612me.V(C);
                        T15 = V4 + T14;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 56:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T11 = AbstractC3612me.T(i10);
                        T15 = T11 + 8;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 57:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T12 = AbstractC3612me.T(i10);
                        T15 = T12 + 4;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 58:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T15 = AbstractC3612me.T(i10) + i5;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 59:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        Object object4 = unsafe.getObject(abstractC0367Nu2, j);
                        i8 = (object4 instanceof AbstractC4158tb ? AbstractC3612me.O(i10, (AbstractC4158tb) object4) : AbstractC3612me.S((String) object4) + AbstractC3612me.T(i10)) + i8;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 60:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        Object object5 = unsafe.getObject(abstractC0367Nu2, j);
                        InterfaceC4620zQ p4 = of.p(i6);
                        Class cls21 = EQ.a;
                        int T18 = AbstractC3612me.T(i10);
                        int a3 = ((AbstractC0766b0) object5).a(p4);
                        U2 = AbstractC3612me.U(a3) + a3 + T18;
                        i8 += U2;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 61:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T15 = AbstractC3612me.O(i10, (AbstractC4158tb) unsafe.getObject(abstractC0367Nu2, j));
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 62:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        int C2 = C(j, abstractC0367Nu2);
                        T14 = AbstractC3612me.T(i10);
                        V4 = AbstractC3612me.U(C2);
                        T15 = V4 + T14;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 63:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        int C3 = C(j, abstractC0367Nu2);
                        T14 = AbstractC3612me.T(i10);
                        V4 = AbstractC3612me.V(C3);
                        T15 = V4 + T14;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 64:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T12 = AbstractC3612me.T(i10);
                        T15 = T12 + 4;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 65:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T11 = AbstractC3612me.T(i10);
                        T15 = T11 + 8;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 66:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        int C4 = C(j, abstractC0367Nu2);
                        T14 = AbstractC3612me.T(i10);
                        V4 = AbstractC3612me.Q(C4);
                        T15 = V4 + T14;
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 67:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        long D3 = D(j, abstractC0367Nu2);
                        T13 = AbstractC3612me.T(i10);
                        V3 = AbstractC3612me.R(D3);
                        U2 = V3 + T13;
                        i8 += U2;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                case 68:
                    if (of.t(abstractC0367Nu2, i10, i6)) {
                        T15 = ((AbstractC0766b0) unsafe.getObject(abstractC0367Nu2, j)).a(of.p(i6)) + (AbstractC3612me.T(i10) * 2);
                        i8 += T15;
                    }
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
                default:
                    i2 = i5;
                    i6 += 3;
                    i5 = i2;
            }
        }
    }

    @Override // defpackage.InterfaceC4620zQ
    public final void i(Object obj, C2835cv c2835cv) {
        c2835cv.getClass();
        U(obj, c2835cv);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (defpackage.EQ.l(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (defpackage.EQ.l(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (defpackage.EQ.l(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        if (defpackage.EQ.l(r5.i(r7, r12), r5.i(r7, r13)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014c, code lost:
    
        if (r5.c(r7, r12) == r5.c(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        if (r5.g(r7, r12) == r5.g(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019f, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        if (r5.h(r7, r12) == r5.h(r7, r13)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
    
        if (java.lang.Float.floatToIntBits(r5.f(r7, r12)) == java.lang.Float.floatToIntBits(r5.f(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
    
        if (java.lang.Double.doubleToLongBits(r5.e(r7, r12)) == java.lang.Double.doubleToLongBits(r5.e(r7, r13))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (defpackage.EQ.l(r9.i(r7, r12), r9.i(r7, r13)) != false) goto L105;
     */
    @Override // defpackage.InterfaceC4620zQ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j(AbstractC0367Nu abstractC0367Nu, AbstractC0367Nu abstractC0367Nu2) {
        int[] iArr = this.a;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int T = T(i);
                long j = T & 1048575;
                switch (S(T)) {
                    case 0:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz2 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz3 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz4 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz5 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz6 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz7 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz8 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz9 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz10 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz11 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz12 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz13 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz14 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz15 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz16 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz17 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (k(abstractC0367Nu, abstractC0367Nu2, i)) {
                            ZZ zz18 = AbstractC0846c00.c;
                            break;
                        }
                        z = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        ZZ zz19 = AbstractC0846c00.c;
                        z = EQ.l(zz19.i(j, abstractC0367Nu), zz19.i(j, abstractC0367Nu2));
                        break;
                    case 50:
                        ZZ zz20 = AbstractC0846c00.c;
                        z = EQ.l(zz20.i(j, abstractC0367Nu), zz20.i(j, abstractC0367Nu2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        ZZ zz21 = AbstractC0846c00.c;
                        if (zz21.g(j2, abstractC0367Nu) == zz21.g(j2, abstractC0367Nu2)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (z) {
                    i += 3;
                }
            } else {
                this.l.getClass();
                if (abstractC0367Nu.unknownFields.equals(abstractC0367Nu2.unknownFields)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean k(AbstractC0367Nu abstractC0367Nu, AbstractC0367Nu abstractC0367Nu2, int i) {
        return q(i, abstractC0367Nu) == q(i, abstractC0367Nu2);
    }

    public final void m(int i, Object obj, Object obj2) {
        int i2 = this.a[i];
        if (AbstractC0846c00.c.i(T(i) & 1048575, obj) == null) {
            return;
        }
        n(i);
    }

    public final void n(int i) {
        if (this.b[W50.b(i, 3, 2, 1)] != null) {
            throw new ClassCastException();
        }
    }

    public final Object o(int i) {
        return this.b[(i / 3) * 2];
    }

    public final InterfaceC4620zQ p(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        InterfaceC4620zQ interfaceC4620zQ = (InterfaceC4620zQ) objArr[i2];
        if (interfaceC4620zQ != null) {
            return interfaceC4620zQ;
        }
        InterfaceC4620zQ a = OL.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = a;
        return a;
    }

    public final boolean q(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int T = T(i);
            long j2 = T & 1048575;
            switch (S(T)) {
                case 0:
                    if (Double.doubleToRawLongBits(AbstractC0846c00.c.e(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(AbstractC0846c00.c.f(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (AbstractC0846c00.c.h(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (AbstractC0846c00.c.h(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (AbstractC0846c00.c.h(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return AbstractC0846c00.c.c(j2, obj);
                case 8:
                    Object i3 = AbstractC0846c00.c.i(j2, obj);
                    if (i3 instanceof String) {
                        return !((String) i3).isEmpty();
                    }
                    if (i3 instanceof AbstractC4158tb) {
                        return !AbstractC4158tb.b.equals(i3);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (AbstractC0846c00.c.i(j2, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !AbstractC4158tb.b.equals(AbstractC0846c00.c.i(j2, obj));
                case 11:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (AbstractC0846c00.c.h(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (AbstractC0846c00.c.g(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (AbstractC0846c00.c.h(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (AbstractC0846c00.c.i(j2, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i2 >>> 20)) & AbstractC0846c00.c.g(j, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean r(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? q(i, obj) : (i3 & i4) != 0;
    }

    public final boolean t(Object obj, int i, int i2) {
        return AbstractC0846c00.c.g((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:192:0x0064, code lost:
    
        if (r13 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
    
        if (r13 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        ((defpackage.AbstractC0367Nu) r2).unknownFields = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x06c4 A[Catch: all -> 0x0438, TryCatch #7 {all -> 0x0438, blocks: (B:37:0x06bf, B:39:0x06c4, B:40:0x06c9, B:140:0x0433, B:143:0x043b, B:144:0x0450, B:145:0x0465, B:146:0x047a, B:147:0x048f, B:148:0x04a4, B:149:0x04b9, B:150:0x04ce, B:151:0x04e3, B:152:0x04fe, B:153:0x051a, B:154:0x0537, B:155:0x0550, B:156:0x0569, B:157:0x0585, B:158:0x059e, B:159:0x05b3, B:160:0x05ce, B:161:0x05db, B:162:0x05f6, B:163:0x060f, B:164:0x0628, B:165:0x0641, B:166:0x065a, B:167:0x0673, B:168:0x0691, B:173:0x06af), top: B:36:0x06bf }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x06d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x06f0 A[LOOP:3: B:55:0x06ee->B:56:0x06f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x06fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(BZ bz, Object obj, R9 r9, C3625mp c3625mp) {
        OF of;
        int i;
        int i2;
        R9 r92;
        int S;
        C0662Zd c0662Zd;
        C3738oC c3738oC;
        OF of2 = this;
        Object obj2 = obj;
        R9 r93 = r9;
        C3625mp c3625mp2 = c3625mp;
        int[] iArr = of2.g;
        int i3 = of2.i;
        int i4 = of2.h;
        C4550yZ c4550yZ = null;
        while (true) {
            try {
                int d = r93.d();
                int P = (d < of2.c || d > of2.d) ? -1 : of2.P(d, 0);
                if (P >= 0) {
                    int T = of2.T(P);
                    try {
                        S = S(T);
                        c0662Zd = (C0662Zd) r93.e;
                        c3738oC = of2.k;
                    } catch (C3871py unused) {
                        of = of2;
                        i = i4;
                    }
                    switch (S) {
                        case 0:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B = B(T);
                            r92.o0(1);
                            Object obj3 = obj2;
                            try {
                                AbstractC0846c00.c.m(obj3, B, Double.longBitsToDouble(c0662Zd.h()));
                                obj2 = obj3;
                                of.N(P, obj2);
                            } catch (C3871py unused2) {
                                obj2 = obj3;
                                try {
                                    bz.getClass();
                                    if (c4550yZ == null) {
                                    }
                                    if (!BZ.b(0, r92, c4550yZ)) {
                                    }
                                    of2 = of;
                                    r93 = r92;
                                    i4 = i;
                                    c3625mp2 = c3625mp;
                                } catch (Throwable th) {
                                    th = th;
                                    for (i2 = i; i2 < i3; i2++) {
                                        of.m(iArr[i2], obj2, c4550yZ);
                                    }
                                    if (c4550yZ != null) {
                                        bz.getClass();
                                        ((AbstractC0367Nu) obj2).unknownFields = c4550yZ;
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                obj2 = obj3;
                                while (i2 < i3) {
                                }
                                if (c4550yZ != null) {
                                }
                                throw th;
                            }
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                            break;
                        case 1:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B2 = B(T);
                            r92.o0(5);
                            AbstractC0846c00.c.n(obj2, B2, Float.intBitsToFloat(c0662Zd.g()));
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 2:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B3 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.o(obj2, B3, c0662Zd.j());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 3:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B4 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.o(obj2, B4, c0662Zd.j());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 4:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B5 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.n(c0662Zd.i(), B5, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 5:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B6 = B(T);
                            r92.o0(1);
                            AbstractC0846c00.o(obj2, B6, c0662Zd.h());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 6:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B7 = B(T);
                            r92.o0(5);
                            AbstractC0846c00.n(c0662Zd.g(), B7, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 7:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B8 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.c.k(obj2, B8, c0662Zd.f());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 8:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            of.K(T, r92, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 9:
                            C3625mp c3625mp3 = c3625mp2;
                            i = i4;
                            of = of2;
                            r92 = r93;
                            AbstractC0766b0 abstractC0766b0 = (AbstractC0766b0) of.y(P, obj2);
                            InterfaceC4620zQ p = of.p(P);
                            r92.o0(2);
                            r92.h(abstractC0766b0, p, c3625mp3);
                            of.Q(P, obj2, abstractC0766b0);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 10:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            AbstractC0846c00.p(B(T), obj2, r92.n());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 11:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B9 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.n(c0662Zd.i(), B9, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 12:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            r92.o0(0);
                            int i5 = c0662Zd.i();
                            of.n(P);
                            AbstractC0846c00.n(i5, B(T), obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 13:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B10 = B(T);
                            r92.o0(5);
                            AbstractC0846c00.n(c0662Zd.g(), B10, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 14:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B11 = B(T);
                            r92.o0(1);
                            AbstractC0846c00.o(obj2, B11, c0662Zd.h());
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 15:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B12 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.n(C0662Zd.a(c0662Zd.i()), B12, obj2);
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 16:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B13 = B(T);
                            r92.o0(0);
                            AbstractC0846c00.o(obj2, B13, C0662Zd.b(c0662Zd.j()));
                            of.N(P, obj2);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 17:
                            C3625mp c3625mp4 = c3625mp2;
                            i = i4;
                            of = of2;
                            r92 = r93;
                            AbstractC0766b0 abstractC0766b02 = (AbstractC0766b0) of.y(P, obj2);
                            InterfaceC4620zQ p2 = of.p(P);
                            r92.o0(3);
                            r92.e(abstractC0766b02, p2, c3625mp4);
                            of.Q(P, obj2, abstractC0766b02);
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 18:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B14 = B(T);
                            c3738oC.getClass();
                            r92.t(C3738oC.a(B14, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 19:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B15 = B(T);
                            c3738oC.getClass();
                            r92.H(C3738oC.a(B15, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 20:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B16 = B(T);
                            c3738oC.getClass();
                            r92.N(C3738oC.a(B16, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 21:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B17 = B(T);
                            c3738oC.getClass();
                            r92.k0(C3738oC.a(B17, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 22:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B18 = B(T);
                            c3738oC.getClass();
                            r92.K(C3738oC.a(B18, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 23:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B19 = B(T);
                            c3738oC.getClass();
                            r92.E(C3738oC.a(B19, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 24:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B20 = B(T);
                            c3738oC.getClass();
                            r92.B(C3738oC.a(B20, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 25:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            long B21 = B(T);
                            c3738oC.getClass();
                            r92.k(C3738oC.a(B21, obj2));
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 26:
                            i = i4;
                            of = of2;
                            r92 = r93;
                            try {
                                of.L(T, r92, obj2);
                            } catch (C3871py unused3) {
                                bz.getClass();
                                if (c4550yZ == null) {
                                }
                                if (!BZ.b(0, r92, c4550yZ)) {
                                }
                                of2 = of;
                                r93 = r92;
                                i4 = i;
                                c3625mp2 = c3625mp;
                            }
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                            break;
                        case 27:
                            i = i4;
                            try {
                            } catch (C3871py unused4) {
                                of = of2;
                                r92 = r93;
                                bz.getClass();
                                if (c4550yZ == null) {
                                }
                                if (!BZ.b(0, r92, c4550yZ)) {
                                }
                                of2 = of;
                                r93 = r92;
                                i4 = i;
                                c3625mp2 = c3625mp;
                            }
                            try {
                                of2.J(obj2, T, r93, of2.p(P), c3625mp);
                                r92 = r93;
                                of = of2;
                            } catch (C3871py unused5) {
                                r92 = r93;
                                of = of2;
                                bz.getClass();
                                if (c4550yZ == null) {
                                }
                                if (!BZ.b(0, r92, c4550yZ)) {
                                }
                                of2 = of;
                                r93 = r92;
                                i4 = i;
                                c3625mp2 = c3625mp;
                            }
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                            break;
                        case 28:
                            i = i4;
                            long B22 = B(T);
                            c3738oC.getClass();
                            r93.q(C3738oC.a(B22, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 29:
                            i = i4;
                            long B23 = B(T);
                            c3738oC.getClass();
                            r93.h0(C3738oC.a(B23, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 30:
                            i = i4;
                            long B24 = B(T);
                            c3738oC.getClass();
                            InterfaceC0578Vx a = C3738oC.a(B24, obj2);
                            r93.w(a);
                            of2.n(P);
                            EQ.j(obj2, d, a, c4550yZ, bz);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 31:
                            i = i4;
                            long B25 = B(T);
                            c3738oC.getClass();
                            r93.Q(C3738oC.a(B25, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 32:
                            i = i4;
                            long B26 = B(T);
                            c3738oC.getClass();
                            r93.T(C3738oC.a(B26, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 33:
                            i = i4;
                            long B27 = B(T);
                            c3738oC.getClass();
                            r93.W(C3738oC.a(B27, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 34:
                            i = i4;
                            long B28 = B(T);
                            c3738oC.getClass();
                            r93.Z(C3738oC.a(B28, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 35:
                            i = i4;
                            long B29 = B(T);
                            c3738oC.getClass();
                            r93.t(C3738oC.a(B29, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 36:
                            i = i4;
                            long B30 = B(T);
                            c3738oC.getClass();
                            r93.H(C3738oC.a(B30, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 37:
                            i = i4;
                            long B31 = B(T);
                            c3738oC.getClass();
                            r93.N(C3738oC.a(B31, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 38:
                            i = i4;
                            long B32 = B(T);
                            c3738oC.getClass();
                            r93.k0(C3738oC.a(B32, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 39:
                            i = i4;
                            long B33 = B(T);
                            c3738oC.getClass();
                            r93.K(C3738oC.a(B33, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 40:
                            i = i4;
                            long B34 = B(T);
                            c3738oC.getClass();
                            r93.E(C3738oC.a(B34, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 41:
                            i = i4;
                            long B35 = B(T);
                            c3738oC.getClass();
                            r93.B(C3738oC.a(B35, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 42:
                            i = i4;
                            long B36 = B(T);
                            c3738oC.getClass();
                            r93.k(C3738oC.a(B36, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 43:
                            i = i4;
                            long B37 = B(T);
                            c3738oC.getClass();
                            r93.h0(C3738oC.a(B37, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 44:
                            i = i4;
                            long B38 = B(T);
                            c3738oC.getClass();
                            InterfaceC0578Vx a2 = C3738oC.a(B38, obj2);
                            r93.w(a2);
                            of2.n(P);
                            EQ.j(obj2, d, a2, c4550yZ, bz);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 45:
                            i = i4;
                            long B39 = B(T);
                            c3738oC.getClass();
                            r93.Q(C3738oC.a(B39, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 46:
                            i = i4;
                            long B40 = B(T);
                            c3738oC.getClass();
                            r93.T(C3738oC.a(B40, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 47:
                            i = i4;
                            long B41 = B(T);
                            c3738oC.getClass();
                            r93.W(C3738oC.a(B41, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 48:
                            i = i4;
                            long B42 = B(T);
                            c3738oC.getClass();
                            r93.Z(C3738oC.a(B42, obj2));
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 49:
                            i = i4;
                            try {
                                try {
                                    of2.I(obj2, B(T), r9, of2.p(P), c3625mp);
                                    r93 = r9;
                                    of = of2;
                                    r92 = r93;
                                } catch (C3871py unused6) {
                                    of = of2;
                                    r92 = r9;
                                    bz.getClass();
                                    if (c4550yZ == null) {
                                        c4550yZ = BZ.a(obj2);
                                    }
                                    if (!BZ.b(0, r92, c4550yZ)) {
                                        for (int i6 = i; i6 < i3; i6++) {
                                            of.m(iArr[i6], obj2, c4550yZ);
                                        }
                                        if (c4550yZ != null) {
                                            ((AbstractC0367Nu) obj2).unknownFields = c4550yZ;
                                            return;
                                        }
                                        return;
                                    }
                                    of2 = of;
                                    r93 = r92;
                                    i4 = i;
                                    c3625mp2 = c3625mp;
                                }
                            } catch (C3871py unused7) {
                                r92 = r9;
                                of = of2;
                                bz.getClass();
                                if (c4550yZ == null) {
                                }
                                if (!BZ.b(0, r92, c4550yZ)) {
                                }
                                of2 = of;
                                r93 = r92;
                                i4 = i;
                                c3625mp2 = c3625mp;
                            }
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 50:
                            i = i4;
                            of2.v(P, obj2, of2.o(P));
                            throw null;
                            break;
                        case 51:
                            i = i4;
                            long B43 = B(T);
                            r93.o0(1);
                            AbstractC0846c00.p(B43, obj2, Double.valueOf(Double.longBitsToDouble(c0662Zd.h())));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 52:
                            i = i4;
                            long B44 = B(T);
                            r93.o0(5);
                            AbstractC0846c00.p(B44, obj2, Float.valueOf(Float.intBitsToFloat(c0662Zd.g())));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 53:
                            i = i4;
                            long B45 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B45, obj2, Long.valueOf(c0662Zd.j()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 54:
                            i = i4;
                            long B46 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B46, obj2, Long.valueOf(c0662Zd.j()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 55:
                            i = i4;
                            long B47 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B47, obj2, Integer.valueOf(c0662Zd.i()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 56:
                            i = i4;
                            long B48 = B(T);
                            r93.o0(1);
                            AbstractC0846c00.p(B48, obj2, Long.valueOf(c0662Zd.h()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 57:
                            i = i4;
                            long B49 = B(T);
                            r93.o0(5);
                            AbstractC0846c00.p(B49, obj2, Integer.valueOf(c0662Zd.g()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 58:
                            i = i4;
                            long B50 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B50, obj2, Boolean.valueOf(c0662Zd.f()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 59:
                            i = i4;
                            of2.K(T, r93, obj2);
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 60:
                            i = i4;
                            AbstractC0766b0 abstractC0766b03 = (AbstractC0766b0) of2.z(obj2, d, P);
                            InterfaceC4620zQ p3 = of2.p(P);
                            r93.o0(2);
                            r93.h(abstractC0766b03, p3, c3625mp2);
                            of2.R(obj2, d, P, abstractC0766b03);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 61:
                            i = i4;
                            AbstractC0846c00.p(B(T), obj2, r93.n());
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 62:
                            i = i4;
                            long B51 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B51, obj2, Integer.valueOf(c0662Zd.i()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 63:
                            i = i4;
                            r93.o0(0);
                            int i7 = c0662Zd.i();
                            of2.n(P);
                            AbstractC0846c00.p(B(T), obj2, Integer.valueOf(i7));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 64:
                            i = i4;
                            long B52 = B(T);
                            r93.o0(5);
                            AbstractC0846c00.p(B52, obj2, Integer.valueOf(c0662Zd.g()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 65:
                            i = i4;
                            long B53 = B(T);
                            r93.o0(1);
                            AbstractC0846c00.p(B53, obj2, Long.valueOf(c0662Zd.h()));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 66:
                            i = i4;
                            long B54 = B(T);
                            r93.o0(0);
                            AbstractC0846c00.p(B54, obj2, Integer.valueOf(C0662Zd.a(c0662Zd.i())));
                            of2.O(obj2, d, P);
                            of = of2;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        case 67:
                            i = i4;
                            try {
                                try {
                                    long B55 = B(T);
                                    r93.o0(0);
                                    AbstractC0846c00.p(B55, obj2, Long.valueOf(C0662Zd.b(c0662Zd.j())));
                                    of2.O(obj2, d, P);
                                    of = of2;
                                    r92 = r93;
                                } catch (C3871py unused8) {
                                    of = of2;
                                    r92 = r93;
                                    bz.getClass();
                                    if (c4550yZ == null) {
                                    }
                                    if (!BZ.b(0, r92, c4550yZ)) {
                                    }
                                    of2 = of;
                                    r93 = r92;
                                    i4 = i;
                                    c3625mp2 = c3625mp;
                                }
                                of2 = of;
                                r93 = r92;
                                i4 = i;
                                c3625mp2 = c3625mp;
                            } catch (Throwable th3) {
                                th = th3;
                                of = of2;
                                while (i2 < i3) {
                                }
                                if (c4550yZ != null) {
                                }
                                throw th;
                            }
                            break;
                        case 68:
                            AbstractC0766b0 abstractC0766b04 = (AbstractC0766b0) of2.z(obj2, d, P);
                            InterfaceC4620zQ p4 = of2.p(P);
                            r93.o0(3);
                            r93.e(abstractC0766b04, p4, c3625mp2);
                            of2.R(obj2, d, P, abstractC0766b04);
                            of = of2;
                            i = i4;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                        default:
                            if (c4550yZ == null) {
                                try {
                                    bz.getClass();
                                    c4550yZ = BZ.a(obj2);
                                } catch (C3871py unused9) {
                                    of = of2;
                                    i = i4;
                                    r92 = r93;
                                    bz.getClass();
                                    if (c4550yZ == null) {
                                    }
                                    if (!BZ.b(0, r92, c4550yZ)) {
                                    }
                                    of2 = of;
                                    r93 = r92;
                                    i4 = i;
                                    c3625mp2 = c3625mp;
                                }
                            }
                            bz.getClass();
                            if (!BZ.b(0, r93, c4550yZ)) {
                                while (i4 < i3) {
                                    of2.m(iArr[i4], obj2, c4550yZ);
                                    i4++;
                                }
                                break;
                            }
                            of = of2;
                            i = i4;
                            r92 = r93;
                            of2 = of;
                            r93 = r92;
                            i4 = i;
                            c3625mp2 = c3625mp;
                            break;
                    }
                } else if (d == Integer.MAX_VALUE) {
                    while (i4 < i3) {
                        of2.m(iArr[i4], obj2, c4550yZ);
                        i4++;
                    }
                    if (c4550yZ != null) {
                        bz.getClass();
                    }
                } else {
                    bz.getClass();
                    if (c4550yZ == null) {
                        c4550yZ = BZ.a(obj2);
                    }
                    if (!BZ.b(0, r93, c4550yZ)) {
                        while (i4 < i3) {
                            of2.m(iArr[i4], obj2, c4550yZ);
                            i4++;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                of = of2;
                i = i4;
            }
        }
    }

    public final void v(int i, Object obj, Object obj2) {
        long T = T(i) & 1048575;
        Object i2 = AbstractC0846c00.c.i(T, obj);
        C0710aE c0710aE = this.m;
        if (i2 != null) {
            c0710aE.getClass();
            if (!((XD) i2).a) {
                XD c = XD.b.c();
                C0710aE.a(c, i2);
                AbstractC0846c00.p(T, obj, c);
                i2 = c;
            }
        } else {
            c0710aE.getClass();
            i2 = XD.b.c();
            AbstractC0846c00.p(T, obj, i2);
        }
        c0710aE.getClass();
        W50.z(obj2);
        throw null;
    }

    public final void w(int i, Object obj, Object obj2) {
        if (q(i, obj2)) {
            long T = T(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, T);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.a[i] + " is present but null: " + obj2);
            }
            InterfaceC4620zQ p = p(i);
            if (!q(i, obj)) {
                if (s(object)) {
                    Object d = p.d();
                    p.a(d, object);
                    unsafe.putObject(obj, T, d);
                } else {
                    unsafe.putObject(obj, T, object);
                }
                N(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, T);
            if (!s(object2)) {
                Object d2 = p.d();
                p.a(d2, object2);
                unsafe.putObject(obj, T, d2);
                object2 = d2;
            }
            p.a(object2, object);
        }
    }

    public final void x(int i, Object obj, Object obj2) {
        int[] iArr = this.a;
        int i2 = iArr[i];
        if (t(obj2, i2, i)) {
            long T = T(i) & 1048575;
            Unsafe unsafe = o;
            Object object = unsafe.getObject(obj2, T);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            InterfaceC4620zQ p = p(i);
            if (!t(obj, i2, i)) {
                if (s(object)) {
                    Object d = p.d();
                    p.a(d, object);
                    unsafe.putObject(obj, T, d);
                } else {
                    unsafe.putObject(obj, T, object);
                }
                O(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, T);
            if (!s(object2)) {
                Object d2 = p.d();
                p.a(d2, object2);
                unsafe.putObject(obj, T, d2);
                object2 = d2;
            }
            p.a(object2, object);
        }
    }

    public final Object y(int i, Object obj) {
        InterfaceC4620zQ p = p(i);
        long T = T(i) & 1048575;
        if (!q(i, obj)) {
            return p.d();
        }
        Object object = o.getObject(obj, T);
        if (s(object)) {
            return object;
        }
        Object d = p.d();
        if (object != null) {
            p.a(d, object);
        }
        return d;
    }

    public final Object z(Object obj, int i, int i2) {
        InterfaceC4620zQ p = p(i2);
        if (!t(obj, i, i2)) {
            return p.d();
        }
        Object object = o.getObject(obj, T(i2) & 1048575);
        if (s(object)) {
            return object;
        }
        Object d = p.d();
        if (object != null) {
            p.a(d, object);
        }
        return d;
    }
}
