package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzrg extends zzrj {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f16650f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private final zzrn f16651g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicReference<zzrh> f16652h;

    public zzrg() {
        this(null);
    }

    private static boolean g(zzlh zzlhVar, String str) {
        return str != null && TextUtils.equals(str, zzsy.l(zzlhVar.D));
    }

    private static int h(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    private static boolean i(int i2, boolean z) {
        int i3 = i2 & 3;
        if (i3 != 3) {
            return z && i3 == 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0176, code lost:
    
        if (r10 <= r15) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a0  */
    @Override // com.google.android.gms.internal.ads.zzrj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final zzrm[] e(zzlp[] zzlpVarArr, zzrb[] zzrbVarArr, int[][][] iArr) throws zzku {
        int i2;
        zzrh zzrhVar;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        zzrb zzrbVar;
        int i5;
        zzrm[] zzrmVarArr;
        zzrh zzrhVar2;
        int i6;
        int i7;
        zzra zzraVar;
        boolean z3;
        int i8;
        boolean z4;
        int i9;
        int i10;
        int[] iArr2;
        zzra zzraVar2;
        zzra zzraVar3;
        int i11;
        boolean z5;
        int i12;
        boolean i13;
        boolean z6;
        int h2;
        int i14;
        int i15;
        boolean z7;
        int i16;
        boolean z8;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Point point;
        int i23;
        int i24;
        zzlp[] zzlpVarArr2 = zzlpVarArr;
        int length = zzlpVarArr2.length;
        zzrm[] zzrmVarArr2 = new zzrm[length];
        zzrh zzrhVar3 = this.f16652h.get();
        int i25 = 0;
        boolean z9 = false;
        while (i25 < length) {
            if (2 == zzlpVarArr2[i25].E()) {
                if (z9) {
                    i5 = length;
                    zzrmVarArr = zzrmVarArr2;
                    zzrhVar2 = zzrhVar3;
                    i6 = i25;
                } else {
                    zzrb zzrbVar2 = zzrbVarArr[i25];
                    int[][] iArr3 = iArr[i25];
                    int i26 = zzrhVar3.f16656e;
                    int i27 = zzrhVar3.f16657f;
                    int i28 = zzrhVar3.f16658g;
                    int i29 = zzrhVar3.f16661j;
                    int i30 = zzrhVar3.f16662k;
                    boolean z10 = zzrhVar3.l;
                    boolean z11 = zzrhVar3.f16659h;
                    boolean z12 = zzrhVar3.f16660i;
                    i5 = length;
                    zzrhVar2 = zzrhVar3;
                    int i31 = 0;
                    zzra zzraVar4 = null;
                    int i32 = 0;
                    int i33 = 0;
                    int i34 = -1;
                    int i35 = -1;
                    while (i32 < zzrbVar2.f16641b) {
                        zzra b2 = zzrbVar2.b(i32);
                        zzrb zzrbVar3 = zzrbVar2;
                        zzrm[] zzrmVarArr3 = zzrmVarArr2;
                        ArrayList arrayList = new ArrayList(b2.a);
                        int i36 = i25;
                        for (int i37 = 0; i37 < b2.a; i37++) {
                            arrayList.add(Integer.valueOf(i37));
                        }
                        int i38 = Integer.MAX_VALUE;
                        if (i29 == Integer.MAX_VALUE || i30 == Integer.MAX_VALUE) {
                            i7 = i31;
                            zzraVar = zzraVar4;
                            z3 = z10;
                            i8 = i30;
                            z4 = z11;
                            i9 = i29;
                            i10 = i28;
                        } else {
                            i7 = i31;
                            int i39 = 0;
                            while (i39 < b2.a) {
                                zzlh a = b2.a(i39);
                                zzra zzraVar5 = zzraVar4;
                                int i40 = a.o;
                                if (i40 > 0) {
                                    z8 = z11;
                                    int i41 = a.p;
                                    if (i41 > 0) {
                                        z7 = z10;
                                        if (z10) {
                                            i16 = i30;
                                            if ((i40 > i41) != (i29 > i30)) {
                                                i20 = i29;
                                                i17 = i20;
                                                i19 = i16;
                                                i21 = i40 * i20;
                                                i18 = i28;
                                                i22 = i41 * i19;
                                                if (i21 < i22) {
                                                    point = new Point(i19, zzsy.j(i22, i40));
                                                } else {
                                                    point = new Point(zzsy.j(i21, i41), i20);
                                                }
                                                i23 = a.o;
                                                int i42 = a.p;
                                                i24 = i23 * i42;
                                                if (i23 >= ((int) (point.x * 0.98f)) && i42 >= ((int) (point.y * 0.98f)) && i24 < i38) {
                                                    i38 = i24;
                                                }
                                                i39++;
                                                zzraVar4 = zzraVar5;
                                                z11 = z8;
                                                z10 = z7;
                                                i30 = i16;
                                                i29 = i17;
                                                i28 = i18;
                                            }
                                        } else {
                                            i16 = i30;
                                        }
                                        i19 = i29;
                                        i17 = i19;
                                        i20 = i16;
                                        i21 = i40 * i20;
                                        i18 = i28;
                                        i22 = i41 * i19;
                                        if (i21 < i22) {
                                        }
                                        i23 = a.o;
                                        int i422 = a.p;
                                        i24 = i23 * i422;
                                        if (i23 >= ((int) (point.x * 0.98f))) {
                                            i38 = i24;
                                        }
                                        i39++;
                                        zzraVar4 = zzraVar5;
                                        z11 = z8;
                                        z10 = z7;
                                        i30 = i16;
                                        i29 = i17;
                                        i28 = i18;
                                    } else {
                                        z7 = z10;
                                        i16 = i30;
                                    }
                                } else {
                                    z7 = z10;
                                    i16 = i30;
                                    z8 = z11;
                                }
                                i17 = i29;
                                i18 = i28;
                                i39++;
                                zzraVar4 = zzraVar5;
                                z11 = z8;
                                z10 = z7;
                                i30 = i16;
                                i29 = i17;
                                i28 = i18;
                            }
                            zzraVar = zzraVar4;
                            z3 = z10;
                            i8 = i30;
                            z4 = z11;
                            i9 = i29;
                            i10 = i28;
                            if (i38 != Integer.MAX_VALUE) {
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    int n = b2.a(((Integer) arrayList.get(size)).intValue()).n();
                                    if (n == -1 || n > i38) {
                                        arrayList.remove(size);
                                    }
                                }
                            }
                        }
                        int[] iArr4 = iArr3[i32];
                        int i43 = i33;
                        int i44 = i34;
                        int i45 = i35;
                        zzraVar4 = zzraVar;
                        int i46 = 0;
                        while (i46 < b2.a) {
                            if (i(iArr4[i46], z12)) {
                                zzlh a2 = b2.a(i46);
                                if (!arrayList.contains(Integer.valueOf(i46)) || (((i14 = a2.o) != -1 && i14 > i26) || ((i15 = a2.p) != -1 && i15 > i27))) {
                                    i11 = i10;
                                } else {
                                    int i47 = a2.f16423g;
                                    if (i47 != -1) {
                                        i11 = i10;
                                    } else {
                                        i11 = i10;
                                    }
                                    z5 = true;
                                    if (!z5 || z4) {
                                        zzraVar2 = b2;
                                        zzraVar3 = zzraVar4;
                                        i12 = !z5 ? 2 : 1;
                                        iArr2 = iArr4;
                                        i13 = i(iArr4[i46], false);
                                        if (i13) {
                                            i12 += 1000;
                                        }
                                        z6 = i12 <= i43;
                                        if (i12 == i43) {
                                            if (a2.n() != i44) {
                                                h2 = h(a2.n(), i44);
                                            } else {
                                                h2 = h(a2.f16423g, i45);
                                            }
                                            z6 = !(i13 && z5) ? h2 >= 0 : h2 <= 0;
                                        }
                                        if (z6) {
                                            i45 = a2.f16423g;
                                            i43 = i12;
                                            i7 = i46;
                                            i44 = a2.n();
                                            zzraVar4 = zzraVar2;
                                            i46++;
                                            i10 = i11;
                                            b2 = zzraVar2;
                                            iArr4 = iArr2;
                                        }
                                    } else {
                                        iArr2 = iArr4;
                                        zzraVar2 = b2;
                                        zzraVar3 = zzraVar4;
                                    }
                                }
                                z5 = false;
                                if (z5) {
                                }
                                zzraVar2 = b2;
                                zzraVar3 = zzraVar4;
                                if (!z5) {
                                }
                                iArr2 = iArr4;
                                i13 = i(iArr4[i46], false);
                                if (i13) {
                                }
                                if (i12 <= i43) {
                                }
                                if (i12 == i43) {
                                }
                                if (z6) {
                                }
                            } else {
                                iArr2 = iArr4;
                                zzraVar2 = b2;
                                zzraVar3 = zzraVar4;
                                i11 = i10;
                            }
                            zzraVar4 = zzraVar3;
                            i46++;
                            i10 = i11;
                            b2 = zzraVar2;
                            iArr4 = iArr2;
                        }
                        i28 = i10;
                        i32++;
                        i33 = i43;
                        i35 = i45;
                        zzrbVar2 = zzrbVar3;
                        zzrmVarArr2 = zzrmVarArr3;
                        i31 = i7;
                        z11 = z4;
                        z10 = z3;
                        i30 = i8;
                        i29 = i9;
                        i34 = i44;
                        i25 = i36;
                    }
                    zzrmVarArr = zzrmVarArr2;
                    zzra zzraVar6 = zzraVar4;
                    i6 = i25;
                    zzrmVarArr[i6] = zzraVar6 == null ? null : new zzri(zzraVar6, i31);
                    z9 = zzrmVarArr[i6] != null;
                }
                int i48 = zzrbVarArr[i6].f16641b;
            } else {
                i5 = length;
                zzrmVarArr = zzrmVarArr2;
                zzrhVar2 = zzrhVar3;
                i6 = i25;
            }
            i25 = i6 + 1;
            zzlpVarArr2 = zzlpVarArr;
            zzrhVar3 = zzrhVar2;
            length = i5;
            zzrmVarArr2 = zzrmVarArr;
        }
        zzrm[] zzrmVarArr4 = zzrmVarArr2;
        zzrh zzrhVar4 = zzrhVar3;
        int i49 = length;
        int i50 = 0;
        boolean z13 = false;
        boolean z14 = false;
        while (i50 < i49) {
            int E = zzlpVarArr[i50].E();
            if (E == 1) {
                i2 = i49;
                zzrhVar = zzrhVar4;
                if (!z13) {
                    zzrb zzrbVar4 = zzrbVarArr[i50];
                    int[][] iArr5 = iArr[i50];
                    boolean z15 = zzrhVar.f16660i;
                    int i51 = 0;
                    int i52 = 0;
                    int i53 = -1;
                    int i54 = -1;
                    while (i51 < zzrbVar4.f16641b) {
                        zzra b3 = zzrbVar4.b(i51);
                        int[] iArr6 = iArr5[i51];
                        int i55 = i54;
                        int i56 = i53;
                        int i57 = i52;
                        int i58 = 0;
                        while (i58 < b3.a) {
                            if (i(iArr6[i58], z15)) {
                                zzlh a3 = b3.a(i58);
                                int i59 = iArr6[i58];
                                z2 = z14;
                                boolean z16 = (a3.C & 1) != 0;
                                int i60 = g(a3, null) ? z16 ? 4 : 3 : z16 ? 2 : 1;
                                if (i(i59, false)) {
                                    i60 += 1000;
                                }
                                if (i60 > i57) {
                                    i56 = i51;
                                    i55 = i58;
                                    i57 = i60;
                                }
                            } else {
                                z2 = z14;
                            }
                            i58++;
                            z14 = z2;
                        }
                        i51++;
                        i52 = i57;
                        i53 = i56;
                        i54 = i55;
                        z14 = z14;
                    }
                    z = z14;
                    zzrmVarArr4[i50] = i53 == -1 ? null : new zzri(zzrbVar4.b(i53), i54);
                    z13 = zzrmVarArr4[i50] != null;
                    i50++;
                    zzrhVar4 = zzrhVar;
                    z14 = z;
                    i49 = i2;
                }
            } else if (E == 2) {
                i2 = i49;
                zzrhVar = zzrhVar4;
            } else if (E != 3) {
                zzlpVarArr[i50].E();
                zzrb zzrbVar5 = zzrbVarArr[i50];
                int[][] iArr7 = iArr[i50];
                zzrhVar = zzrhVar4;
                boolean z17 = zzrhVar.f16660i;
                zzra zzraVar7 = null;
                int i61 = 0;
                int i62 = 0;
                for (int i63 = 0; i63 < zzrbVar5.f16641b; i63++) {
                    zzra b4 = zzrbVar5.b(i63);
                    int[] iArr8 = iArr7[i63];
                    int i64 = 0;
                    while (i64 < b4.a) {
                        if (i(iArr8[i64], z17)) {
                            i4 = i49;
                            int i65 = (b4.a(i64).C & 1) != 0 ? 2 : 1;
                            zzrbVar = zzrbVar5;
                            if (i(iArr8[i64], false)) {
                                i65 += 1000;
                            }
                            if (i65 > i62) {
                                i62 = i65;
                                zzraVar7 = b4;
                                i61 = i64;
                            }
                        } else {
                            i4 = i49;
                            zzrbVar = zzrbVar5;
                        }
                        i64++;
                        zzrbVar5 = zzrbVar;
                        i49 = i4;
                    }
                }
                i2 = i49;
                zzrmVarArr4[i50] = zzraVar7 == null ? null : new zzri(zzraVar7, i61);
            } else {
                i2 = i49;
                zzrhVar = zzrhVar4;
                if (!z14) {
                    zzrb zzrbVar6 = zzrbVarArr[i50];
                    int[][] iArr9 = iArr[i50];
                    boolean z18 = zzrhVar.f16660i;
                    int i66 = 0;
                    int i67 = 0;
                    int i68 = 0;
                    zzra zzraVar8 = null;
                    while (i66 < zzrbVar6.f16641b) {
                        zzra b5 = zzrbVar6.b(i66);
                        int[] iArr10 = iArr9[i66];
                        zzra zzraVar9 = zzraVar8;
                        int i69 = i68;
                        int i70 = i67;
                        for (int i71 = 0; i71 < b5.a; i71++) {
                            if (i(iArr10[i71], z18)) {
                                zzlh a4 = b5.a(i71);
                                int i72 = a4.C;
                                boolean z19 = (i72 & 1) != 0;
                                boolean z20 = (i72 & 2) != 0;
                                if (g(a4, null)) {
                                    i3 = z19 ? 6 : !z20 ? 5 : 4;
                                } else if (z19) {
                                    i3 = 3;
                                } else if (z20) {
                                    i3 = g(a4, null) ? 2 : 1;
                                }
                                if (i(iArr10[i71], false)) {
                                    i3 += 1000;
                                }
                                if (i3 > i69) {
                                    i69 = i3;
                                    i70 = i71;
                                    zzraVar9 = b5;
                                }
                            }
                        }
                        i66++;
                        i67 = i70;
                        i68 = i69;
                        zzraVar8 = zzraVar9;
                    }
                    zzrmVarArr4[i50] = zzraVar8 == null ? null : new zzri(zzraVar8, i67);
                    z = zzrmVarArr4[i50] != null;
                    i50++;
                    zzrhVar4 = zzrhVar;
                    z14 = z;
                    i49 = i2;
                }
            }
            z = z14;
            i50++;
            zzrhVar4 = zzrhVar;
            z14 = z;
            i49 = i2;
        }
        return zzrmVarArr4;
    }

    private zzrg(zzrn zzrnVar) {
        this.f16651g = null;
        this.f16652h = new AtomicReference<>(new zzrh());
    }
}
