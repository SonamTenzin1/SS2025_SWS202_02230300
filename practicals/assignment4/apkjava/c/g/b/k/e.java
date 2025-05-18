package c.g.b.k;

import c.g.b.k.d;
import c.g.b.k.m.n;
import c.g.b.k.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class e {
    public static float a = 0.5f;
    e A0;
    public int B0;
    public int C0;
    private boolean E;
    public d P;
    public d[] Q;
    protected ArrayList<d> R;
    private boolean[] S;
    public b[] T;
    public e U;
    int V;
    int W;
    public float X;
    protected int Y;
    protected int Z;
    protected int a0;
    int b0;
    int c0;

    /* renamed from: d, reason: collision with root package name */
    public c.g.b.k.m.c f3069d;
    protected int d0;

    /* renamed from: e, reason: collision with root package name */
    public c.g.b.k.m.c f3070e;
    protected int e0;
    int f0;
    protected int g0;
    protected int h0;
    float i0;
    float j0;
    private Object k0;
    private int l0;
    private int m0;
    private String n0;
    private String o0;
    boolean p0;
    boolean q0;
    boolean r0;
    int s0;
    int t0;
    boolean u0;
    boolean v0;
    public float[] w0;
    protected e[] x0;
    protected e[] y0;
    e z0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3067b = false;

    /* renamed from: c, reason: collision with root package name */
    public p[] f3068c = new p[2];

    /* renamed from: f, reason: collision with root package name */
    public c.g.b.k.m.l f3071f = null;

    /* renamed from: g, reason: collision with root package name */
    public n f3072g = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f3073h = {true, true};

    /* renamed from: i, reason: collision with root package name */
    boolean f3074i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3075j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3076k = false;
    private boolean l = true;
    private boolean m = false;
    private boolean n = false;
    public int o = -1;
    public int p = -1;
    public int q = 0;
    public int r = 0;
    public int[] s = new int[2];
    public int t = 0;
    public int u = 0;
    public float v = 1.0f;
    public int w = 0;
    public int x = 0;
    public float y = 1.0f;
    int z = -1;
    float A = 1.0f;
    private int[] B = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float C = 0.0f;
    private boolean D = false;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    public d I = new d(this, d.b.LEFT);
    public d J = new d(this, d.b.TOP);
    public d K = new d(this, d.b.RIGHT);
    public d L = new d(this, d.b.BOTTOM);
    public d M = new d(this, d.b.BASELINE);
    d N = new d(this, d.b.CENTER_X);
    d O = new d(this, d.b.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3077b;

        static {
            int[] iArr = new int[b.values().length];
            f3077b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3077b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3077b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3077b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.P = dVar;
        this.Q = new d[]{this.I, this.K, this.J, this.L, this.M, dVar};
        this.R = new ArrayList<>();
        this.S = new boolean[2];
        b bVar = b.FIXED;
        this.T = new b[]{bVar, bVar};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        float f2 = a;
        this.i0 = f2;
        this.j0 = f2;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = null;
        this.o0 = null;
        this.r0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.w0 = new float[]{-1.0f, -1.0f};
        this.x0 = new e[]{null, null};
        this.y0 = new e[]{null, null};
        this.z0 = null;
        this.A0 = null;
        this.B0 = -1;
        this.C0 = -1;
        d();
    }

    private boolean Y(int i2) {
        int i3 = i2 * 2;
        d[] dVarArr = this.Q;
        if (dVarArr[i3].f3057f != null && dVarArr[i3].f3057f.f3057f != dVarArr[i3]) {
            int i4 = i3 + 1;
            if (dVarArr[i4].f3057f != null && dVarArr[i4].f3057f.f3057f == dVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.R.add(this.I);
        this.R.add(this.J);
        this.R.add(this.K);
        this.R.add(this.L);
        this.R.add(this.N);
        this.R.add(this.O);
        this.R.add(this.P);
        this.R.add(this.M);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x051d, code lost:
    
        if (r1[r30] == r6) goto L348;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0384 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0419 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04b3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(c.g.b.d dVar, boolean z, boolean z2, boolean z3, boolean z4, c.g.b.i iVar, c.g.b.i iVar2, b bVar, boolean z5, d dVar2, d dVar3, int i2, int i3, int i4, int i5, float f2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f3, boolean z11) {
        int i10;
        boolean z12;
        int i11;
        c.g.b.i iVar3;
        int i12;
        int i13;
        int i14;
        c.g.b.i iVar4;
        c.g.b.i iVar5;
        c.g.b.i iVar6;
        int i15;
        int i16;
        boolean z13;
        boolean z14;
        c.g.b.i q;
        c.g.b.i q2;
        c.g.b.i iVar7;
        c.g.b.i iVar8;
        c.g.b.i iVar9;
        c.g.b.i iVar10;
        int i17;
        int i18;
        char c2;
        int i19;
        d dVar4;
        c.g.b.i iVar11;
        boolean z15;
        boolean z16;
        c.g.b.i iVar12;
        int i20;
        boolean z17;
        int i21;
        int i22;
        int i23;
        boolean z18;
        c.g.b.i iVar13;
        e eVar;
        e eVar2;
        c.g.b.i iVar14;
        int i24;
        e eVar3;
        boolean z19;
        boolean z20;
        c.g.b.i iVar15;
        int i25;
        int i26;
        int i27;
        e eVar4;
        int i28;
        boolean z21;
        int i29;
        int i30;
        boolean z22;
        boolean z23;
        boolean z24;
        int i31;
        int i32;
        e eVar5;
        e eVar6;
        c.g.b.i q3 = dVar.q(dVar2);
        c.g.b.i q4 = dVar.q(dVar3);
        c.g.b.i q5 = dVar.q(dVar2.i());
        c.g.b.i q6 = dVar.q(dVar3.i());
        if (c.g.b.d.w() == null) {
            boolean n = dVar2.n();
            boolean n2 = dVar3.n();
            boolean n3 = this.P.n();
            int i33 = n2 ? (n ? 1 : 0) + 1 : n ? 1 : 0;
            if (n3) {
                i33++;
            }
            int i34 = z6 ? 3 : i6;
            int i35 = a.f3077b[bVar.ordinal()];
            if (i35 == 1 || i35 == 2 || i35 == 3 || i35 != 4) {
                i10 = i34;
            } else {
                i10 = i34;
                if (i10 != 4) {
                    z12 = true;
                    if (this.m0 != 8) {
                        i11 = 0;
                        z12 = false;
                    } else {
                        i11 = i3;
                    }
                    if (z11) {
                        if (!n && !n2 && !n3) {
                            dVar.f(q3, i2);
                        } else if (n && !n2) {
                            iVar3 = q6;
                            i12 = 8;
                            dVar.e(q3, q5, dVar2.e(), 8);
                            if (!z12) {
                                if (z5) {
                                    dVar.e(q4, q3, 0, 3);
                                    if (i4 > 0) {
                                        dVar.h(q4, q3, i4, 8);
                                    }
                                    if (i5 < Integer.MAX_VALUE) {
                                        dVar.j(q4, q3, i5, 8);
                                    }
                                } else {
                                    dVar.e(q4, q3, i11, i12);
                                }
                                i16 = i8;
                                i13 = i9;
                                iVar4 = q5;
                                iVar5 = q4;
                            } else {
                                if (i33 != 2 && !z6 && (i10 == 1 || i10 == 0)) {
                                    int max = Math.max(i8, i11);
                                    if (i9 > 0) {
                                        max = Math.min(i9, max);
                                    }
                                    dVar.e(q4, q3, max, 8);
                                    z14 = z4;
                                    i16 = i8;
                                    i13 = i9;
                                    iVar4 = q5;
                                    iVar5 = q4;
                                    iVar6 = iVar3;
                                    z13 = false;
                                    i15 = i33;
                                    if (!z11) {
                                    }
                                    if (i19 < i18) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                int i36 = i8 == -2 ? i11 : i8;
                                i13 = i9 == -2 ? i11 : i9;
                                if (i11 > 0 && i10 != 1) {
                                    i11 = 0;
                                }
                                if (i36 > 0) {
                                    dVar.h(q4, q3, i36, 8);
                                    i11 = Math.max(i11, i36);
                                }
                                if (i13 > 0) {
                                    if ((z2 && i10 == 1) ? false : true) {
                                        i14 = 8;
                                        dVar.j(q4, q3, i13, 8);
                                    } else {
                                        i14 = 8;
                                    }
                                    i11 = Math.min(i11, i13);
                                } else {
                                    i14 = 8;
                                }
                                if (i10 != 1) {
                                    if (i10 == 2) {
                                        d.b j2 = dVar2.j();
                                        d.b bVar2 = d.b.TOP;
                                        if (j2 != bVar2 && dVar2.j() != d.b.BOTTOM) {
                                            q = dVar.q(this.U.m(d.b.LEFT));
                                            q2 = dVar.q(this.U.m(d.b.RIGHT));
                                        } else {
                                            q = dVar.q(this.U.m(bVar2));
                                            q2 = dVar.q(this.U.m(d.b.BOTTOM));
                                        }
                                        int i37 = i36;
                                        iVar6 = iVar3;
                                        iVar4 = q5;
                                        i15 = i33;
                                        iVar5 = q4;
                                        dVar.d(dVar.r().k(q4, q3, q2, q, f3));
                                        z14 = z4;
                                        i16 = i37;
                                        z13 = false;
                                    } else {
                                        iVar4 = q5;
                                        iVar5 = q4;
                                        int i38 = i36;
                                        iVar6 = iVar3;
                                        i15 = i33;
                                        i16 = i38;
                                        z13 = z12;
                                        z14 = true;
                                    }
                                    if (!z11) {
                                        iVar7 = iVar2;
                                        iVar8 = iVar5;
                                        iVar9 = q3;
                                        iVar10 = iVar;
                                        i17 = 0;
                                        i18 = 2;
                                        c2 = 1;
                                        i19 = i15;
                                    } else if (z8) {
                                        iVar7 = iVar2;
                                        iVar8 = iVar5;
                                        iVar9 = q3;
                                        iVar10 = iVar;
                                        i19 = i15;
                                        i17 = 0;
                                        i18 = 2;
                                        c2 = 1;
                                    } else {
                                        if ((n || n2 || n3) && (!n || n2)) {
                                            if (!n && n2) {
                                                dVar.e(iVar5, iVar6, -dVar3.e(), 8);
                                                if (z2) {
                                                    if (this.f3076k && q3.f3023h && (eVar5 = this.U) != null) {
                                                        f fVar = (f) eVar5;
                                                        if (z) {
                                                            fVar.i1(dVar2);
                                                        } else {
                                                            fVar.n1(dVar2);
                                                        }
                                                    } else {
                                                        dVar.h(q3, iVar, 0, 5);
                                                    }
                                                }
                                            } else if (n && n2) {
                                                e eVar7 = dVar2.f3057f.f3055d;
                                                e eVar8 = dVar3.f3057f.f3055d;
                                                e I = I();
                                                int i39 = 6;
                                                if (!z13) {
                                                    if (iVar4.f3023h && iVar6.f3023h) {
                                                        dVar.c(q3, iVar4, dVar2.e(), f2, iVar6, iVar5, dVar3.e(), 8);
                                                        if (z2 && z14) {
                                                            if (dVar3.f3057f != null) {
                                                                i20 = dVar3.e();
                                                                iVar12 = iVar2;
                                                            } else {
                                                                iVar12 = iVar2;
                                                                i20 = 0;
                                                            }
                                                            if (iVar6 != iVar12) {
                                                                dVar.h(iVar12, iVar5, i20, 5);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    iVar11 = iVar2;
                                                    z15 = true;
                                                    z16 = false;
                                                } else {
                                                    if (i10 == 0) {
                                                        if (i13 != 0 || i16 != 0) {
                                                            z22 = true;
                                                            z23 = false;
                                                            z24 = true;
                                                            i31 = 5;
                                                            i32 = 5;
                                                        } else if (iVar4.f3023h && iVar6.f3023h) {
                                                            dVar.e(q3, iVar4, dVar2.e(), 8);
                                                            dVar.e(iVar5, iVar6, -dVar3.e(), 8);
                                                            return;
                                                        } else {
                                                            z22 = false;
                                                            z23 = true;
                                                            z24 = false;
                                                            i31 = 8;
                                                            i32 = 8;
                                                        }
                                                        if ((eVar7 instanceof c.g.b.k.a) || (eVar8 instanceof c.g.b.k.a)) {
                                                            z17 = z24;
                                                            i23 = i31;
                                                            i21 = 6;
                                                            i22 = 4;
                                                        } else {
                                                            z17 = z24;
                                                            i23 = i31;
                                                            i22 = i32;
                                                            i21 = 6;
                                                        }
                                                        z15 = z22;
                                                        z16 = z23;
                                                    } else {
                                                        if (i10 == 1) {
                                                            iVar11 = iVar2;
                                                            z15 = true;
                                                            z16 = false;
                                                            z17 = true;
                                                            i21 = 6;
                                                            i22 = 4;
                                                        } else if (i10 == 3) {
                                                            if (this.z == -1) {
                                                                if (z9) {
                                                                    iVar11 = iVar2;
                                                                    z15 = true;
                                                                    z16 = true;
                                                                    z17 = true;
                                                                    i21 = z2 ? 5 : 4;
                                                                } else {
                                                                    iVar11 = iVar2;
                                                                    z15 = true;
                                                                    z16 = true;
                                                                    z17 = true;
                                                                    i21 = 8;
                                                                }
                                                                i22 = 5;
                                                            } else {
                                                                if (!z6) {
                                                                    if (i13 > 0) {
                                                                        iVar11 = iVar2;
                                                                        z15 = true;
                                                                        z16 = true;
                                                                        z17 = true;
                                                                        i21 = 6;
                                                                        i22 = 5;
                                                                    } else if (i13 != 0 || i16 != 0) {
                                                                        iVar11 = iVar2;
                                                                        z15 = true;
                                                                        z16 = true;
                                                                    } else {
                                                                        if (z9) {
                                                                            iVar11 = iVar2;
                                                                            i23 = (eVar7 == I || eVar8 == I) ? 5 : 4;
                                                                            z15 = true;
                                                                            z16 = true;
                                                                            z17 = true;
                                                                            i21 = 6;
                                                                            i22 = 4;
                                                                            if (z17 || iVar4 != iVar6 || eVar7 == I) {
                                                                                z18 = true;
                                                                            } else {
                                                                                z17 = false;
                                                                                z18 = false;
                                                                            }
                                                                            if (z15) {
                                                                                iVar13 = iVar5;
                                                                                eVar = I;
                                                                                eVar2 = eVar7;
                                                                                iVar14 = q3;
                                                                                i24 = i10;
                                                                                eVar3 = eVar8;
                                                                                z19 = z2;
                                                                            } else {
                                                                                if (z13 || z7 || z9 || iVar4 != iVar || iVar6 != iVar11) {
                                                                                    z19 = z2;
                                                                                } else {
                                                                                    z19 = false;
                                                                                    i21 = 8;
                                                                                    i23 = 8;
                                                                                    z18 = false;
                                                                                }
                                                                                c.g.b.i iVar16 = iVar5;
                                                                                i24 = i10;
                                                                                eVar3 = eVar8;
                                                                                iVar13 = iVar16;
                                                                                eVar2 = eVar7;
                                                                                eVar = I;
                                                                                iVar14 = q3;
                                                                                dVar.c(q3, iVar4, dVar2.e(), f2, iVar6, iVar16, dVar3.e(), i21);
                                                                            }
                                                                            z20 = z18;
                                                                            if (this.m0 == 8 || dVar3.l()) {
                                                                                if (z17) {
                                                                                    iVar15 = iVar13;
                                                                                } else {
                                                                                    int i40 = (!z19 || iVar4 == iVar6 || z13 || !((eVar2 instanceof c.g.b.k.a) || (eVar3 instanceof c.g.b.k.a))) ? i23 : 6;
                                                                                    dVar.h(iVar14, iVar4, dVar2.e(), i40);
                                                                                    iVar15 = iVar13;
                                                                                    dVar.j(iVar15, iVar6, -dVar3.e(), i40);
                                                                                    i23 = i40;
                                                                                }
                                                                                if (z19 || !z10 || (eVar2 instanceof c.g.b.k.a) || (eVar3 instanceof c.g.b.k.a)) {
                                                                                    i25 = i22;
                                                                                    i26 = i23;
                                                                                } else {
                                                                                    i25 = 6;
                                                                                    z20 = true;
                                                                                    i26 = 6;
                                                                                }
                                                                                if (z20) {
                                                                                    if (!z16 || (z9 && !z3)) {
                                                                                        eVar4 = eVar;
                                                                                    } else {
                                                                                        eVar4 = eVar;
                                                                                        if (eVar2 != eVar4 && eVar3 != eVar4) {
                                                                                            i39 = i25;
                                                                                        }
                                                                                        if ((eVar2 instanceof g) || (eVar3 instanceof g)) {
                                                                                            i39 = 5;
                                                                                        }
                                                                                        if ((eVar2 instanceof c.g.b.k.a) || (eVar3 instanceof c.g.b.k.a)) {
                                                                                            i39 = 5;
                                                                                        }
                                                                                        i25 = Math.max(z9 ? 5 : i39, i25);
                                                                                    }
                                                                                    if (z19) {
                                                                                        i25 = Math.min(i26, i25);
                                                                                        if (z6 && !z9 && (eVar2 == eVar4 || eVar3 == eVar4)) {
                                                                                            i28 = 4;
                                                                                            dVar.e(iVar14, iVar4, dVar2.e(), i28);
                                                                                            dVar.e(iVar15, iVar6, -dVar3.e(), i28);
                                                                                        }
                                                                                    }
                                                                                    i28 = i25;
                                                                                    dVar.e(iVar14, iVar4, dVar2.e(), i28);
                                                                                    dVar.e(iVar15, iVar6, -dVar3.e(), i28);
                                                                                }
                                                                                if (z19) {
                                                                                    int e2 = iVar == iVar4 ? dVar2.e() : 0;
                                                                                    if (iVar4 != iVar) {
                                                                                        dVar.h(iVar14, iVar, e2, 5);
                                                                                    }
                                                                                }
                                                                                if (z19 || !z13 || i4 != 0 || i16 != 0) {
                                                                                    i27 = 0;
                                                                                } else if (z13 && i24 == 3) {
                                                                                    i27 = 0;
                                                                                    dVar.h(iVar15, iVar14, 0, 8);
                                                                                } else {
                                                                                    i27 = 0;
                                                                                    dVar.h(iVar15, iVar14, 0, 5);
                                                                                }
                                                                                if (z19 && z14) {
                                                                                    if (dVar3.f3057f != null) {
                                                                                        i27 = dVar3.e();
                                                                                    }
                                                                                    if (iVar6 != iVar2) {
                                                                                        if (this.f3076k && iVar15.f3023h && (eVar6 = this.U) != null) {
                                                                                            f fVar2 = (f) eVar6;
                                                                                            if (z) {
                                                                                                fVar2.h1(dVar3);
                                                                                                return;
                                                                                            } else {
                                                                                                fVar2.m1(dVar3);
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        dVar.h(iVar2, iVar15, i27, 5);
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        iVar11 = iVar2;
                                                                        z15 = true;
                                                                        z16 = true;
                                                                        z17 = true;
                                                                        i21 = 6;
                                                                        i22 = 8;
                                                                    }
                                                                    i23 = 5;
                                                                    if (z17) {
                                                                    }
                                                                    z18 = true;
                                                                    if (z15) {
                                                                    }
                                                                    z20 = z18;
                                                                    if (this.m0 == 8) {
                                                                    }
                                                                    if (z17) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    i25 = i22;
                                                                    i26 = i23;
                                                                    if (z20) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    i27 = 0;
                                                                    if (z19) {
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                if (i7 != 2 && i7 != 1) {
                                                                    z21 = false;
                                                                    if (z21) {
                                                                        i29 = 8;
                                                                        i30 = 5;
                                                                    } else {
                                                                        i29 = 5;
                                                                        i30 = 4;
                                                                    }
                                                                    i23 = i29;
                                                                    i22 = i30;
                                                                    z15 = true;
                                                                    z16 = true;
                                                                    z17 = true;
                                                                    i21 = 6;
                                                                }
                                                                z21 = true;
                                                                if (z21) {
                                                                }
                                                                i23 = i29;
                                                                i22 = i30;
                                                                z15 = true;
                                                                z16 = true;
                                                                z17 = true;
                                                                i21 = 6;
                                                            }
                                                        } else {
                                                            iVar11 = iVar2;
                                                            z15 = false;
                                                            z16 = false;
                                                            z17 = false;
                                                            i21 = 6;
                                                            i22 = 4;
                                                            i23 = 5;
                                                            if (z17) {
                                                            }
                                                            z18 = true;
                                                            if (z15) {
                                                            }
                                                            z20 = z18;
                                                            if (this.m0 == 8) {
                                                            }
                                                            if (z17) {
                                                            }
                                                            if (z19) {
                                                            }
                                                            i25 = i22;
                                                            i26 = i23;
                                                            if (z20) {
                                                            }
                                                            if (z19) {
                                                            }
                                                            if (z19) {
                                                            }
                                                            i27 = 0;
                                                            if (z19) {
                                                            }
                                                        }
                                                        i23 = 8;
                                                        if (z17) {
                                                        }
                                                        z18 = true;
                                                        if (z15) {
                                                        }
                                                        z20 = z18;
                                                        if (this.m0 == 8) {
                                                        }
                                                        if (z17) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        i25 = i22;
                                                        i26 = i23;
                                                        if (z20) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        if (z19) {
                                                        }
                                                        i27 = 0;
                                                        if (z19) {
                                                        }
                                                    }
                                                    iVar11 = iVar2;
                                                    if (z17) {
                                                    }
                                                    z18 = true;
                                                    if (z15) {
                                                    }
                                                    z20 = z18;
                                                    if (this.m0 == 8) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    i25 = i22;
                                                    i26 = i23;
                                                    if (z20) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    i27 = 0;
                                                    if (z19) {
                                                    }
                                                }
                                                z17 = true;
                                                i21 = 6;
                                                i22 = 4;
                                                i23 = 5;
                                                if (z17) {
                                                }
                                                z18 = true;
                                                if (z15) {
                                                }
                                                z20 = z18;
                                                if (this.m0 == 8) {
                                                }
                                                if (z17) {
                                                }
                                                if (z19) {
                                                }
                                                i25 = i22;
                                                i26 = i23;
                                                if (z20) {
                                                }
                                                if (z19) {
                                                }
                                                if (z19) {
                                                }
                                                i27 = 0;
                                                if (z19) {
                                                }
                                            }
                                        }
                                        iVar15 = iVar5;
                                        i27 = 0;
                                        z19 = z2;
                                        if (z19) {
                                        }
                                    }
                                    if (i19 < i18 && z2 && z14) {
                                        dVar.h(iVar9, iVar10, i17, 8);
                                        char c3 = (z || this.M.f3057f == null) ? (char) 1 : (char) 0;
                                        if (z || (dVar4 = this.M.f3057f) == null) {
                                            c2 = c3;
                                        } else {
                                            e eVar9 = dVar4.f3055d;
                                            if (eVar9.X != 0.0f) {
                                                b[] bVarArr = eVar9.T;
                                                b bVar3 = bVarArr[i17];
                                                b bVar4 = b.MATCH_CONSTRAINT;
                                                if (bVar3 == bVar4) {
                                                }
                                            }
                                            c2 = 0;
                                        }
                                        if (c2 != 0) {
                                            dVar.h(iVar7, iVar8, i17, 8);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (z2) {
                                    dVar.e(q4, q3, i11, i14);
                                } else if (z8) {
                                    dVar.e(q4, q3, i11, 5);
                                    dVar.j(q4, q3, i11, i14);
                                } else {
                                    dVar.e(q4, q3, i11, 5);
                                    dVar.j(q4, q3, i11, i14);
                                }
                                iVar4 = q5;
                                iVar5 = q4;
                                i16 = i36;
                            }
                            z13 = z12;
                            iVar6 = iVar3;
                            z14 = z4;
                            i15 = i33;
                            if (!z11) {
                            }
                            if (i19 < i18) {
                            }
                        }
                    }
                    iVar3 = q6;
                    i12 = 8;
                    if (!z12) {
                    }
                    z13 = z12;
                    iVar6 = iVar3;
                    z14 = z4;
                    i15 = i33;
                    if (!z11) {
                    }
                    if (i19 < i18) {
                    }
                }
            }
            z12 = false;
            if (this.m0 != 8) {
            }
            if (z11) {
            }
            iVar3 = q6;
            i12 = 8;
            if (!z12) {
            }
            z13 = z12;
            iVar6 = iVar3;
            z14 = z4;
            i15 = i33;
            if (!z11) {
            }
            if (i19 < i18) {
            }
        } else {
            c.g.b.d.w();
            throw null;
        }
    }

    public int A() {
        return this.G;
    }

    public void A0(int i2, int i3, int i4, float f2) {
        this.q = i2;
        this.t = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.u = i4;
        this.v = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.q = 2;
    }

    public int B() {
        return this.H;
    }

    public void B0(float f2) {
        this.w0[0] = f2;
    }

    public int C(int i2) {
        if (i2 == 0) {
            return R();
        }
        if (i2 == 1) {
            return v();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C0(int i2, boolean z) {
        this.S[i2] = z;
    }

    public int D() {
        return this.B[1];
    }

    public void D0(boolean z) {
        this.E = z;
    }

    public int E() {
        return this.B[0];
    }

    public void E0(boolean z) {
        this.F = z;
    }

    public int F() {
        return this.h0;
    }

    public void F0(int i2, int i3) {
        this.G = i2;
        this.H = i3;
        I0(false);
    }

    public int G() {
        return this.g0;
    }

    public void G0(int i2) {
        this.B[1] = i2;
    }

    public e H(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.L).f3057f) != null && dVar2.f3057f == dVar) {
                return dVar2.f3055d;
            }
            return null;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f3057f;
        if (dVar4 == null || dVar4.f3057f != dVar3) {
            return null;
        }
        return dVar4.f3055d;
    }

    public void H0(int i2) {
        this.B[0] = i2;
    }

    public e I() {
        return this.U;
    }

    public void I0(boolean z) {
        this.f3075j = z;
    }

    public e J(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.J).f3057f) != null && dVar2.f3057f == dVar) {
                return dVar2.f3055d;
            }
            return null;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f3057f;
        if (dVar4 == null || dVar4.f3057f != dVar3) {
            return null;
        }
        return dVar4.f3055d;
    }

    public void J0(int i2) {
        if (i2 < 0) {
            this.h0 = 0;
        } else {
            this.h0 = i2;
        }
    }

    public int K() {
        return S() + this.V;
    }

    public void K0(int i2) {
        if (i2 < 0) {
            this.g0 = 0;
        } else {
            this.g0 = i2;
        }
    }

    public p L(int i2) {
        if (i2 == 0) {
            return this.f3071f;
        }
        if (i2 == 1) {
            return this.f3072g;
        }
        return null;
    }

    public void L0(int i2, int i3) {
        this.Z = i2;
        this.a0 = i3;
    }

    public float M() {
        return this.j0;
    }

    public void M0(e eVar) {
        this.U = eVar;
    }

    public int N() {
        return this.t0;
    }

    public void N0(float f2) {
        this.j0 = f2;
    }

    public b O() {
        return this.T[1];
    }

    public void O0(int i2) {
        this.t0 = i2;
    }

    public int P() {
        int i2 = this.I != null ? 0 + this.J.f3058g : 0;
        return this.K != null ? i2 + this.L.f3058g : i2;
    }

    public void P0(int i2, int i3) {
        this.a0 = i2;
        int i4 = i3 - i2;
        this.W = i4;
        int i5 = this.h0;
        if (i4 < i5) {
            this.W = i5;
        }
    }

    public int Q() {
        return this.m0;
    }

    public void Q0(b bVar) {
        this.T[1] = bVar;
    }

    public int R() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.V;
    }

    public void R0(int i2, int i3, int i4, float f2) {
        this.r = i2;
        this.w = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.x = i4;
        this.y = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.r = 2;
    }

    public int S() {
        e eVar = this.U;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).K0 + this.Z;
        }
        return this.Z;
    }

    public void S0(float f2) {
        this.w0[1] = f2;
    }

    public int T() {
        e eVar = this.U;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).L0 + this.a0;
        }
        return this.a0;
    }

    public void T0(int i2) {
        this.m0 = i2;
    }

    public boolean U() {
        return this.D;
    }

    public void U0(int i2) {
        this.V = i2;
        int i3 = this.g0;
        if (i2 < i3) {
            this.V = i3;
        }
    }

    public boolean V(int i2) {
        if (i2 == 0) {
            return (this.I.f3057f != null ? 1 : 0) + (this.K.f3057f != null ? 1 : 0) < 2;
        }
        return ((this.J.f3057f != null ? 1 : 0) + (this.L.f3057f != null ? 1 : 0)) + (this.M.f3057f != null ? 1 : 0) < 2;
    }

    public void V0(int i2) {
        this.Z = i2;
    }

    public boolean W() {
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.R.get(i2).l()) {
                return true;
            }
        }
        return false;
    }

    public void W0(int i2) {
        this.a0 = i2;
    }

    public void X(d.b bVar, e eVar, d.b bVar2, int i2, int i3) {
        m(bVar).a(eVar.m(bVar2), i2, i3, true);
    }

    public void X0(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.z == -1) {
            if (z3 && !z4) {
                this.z = 0;
            } else if (!z3 && z4) {
                this.z = 1;
                if (this.Y == -1) {
                    this.A = 1.0f / this.A;
                }
            }
        }
        if (this.z == 0 && (!this.J.n() || !this.L.n())) {
            this.z = 1;
        } else if (this.z == 1 && (!this.I.n() || !this.K.n())) {
            this.z = 0;
        }
        if (this.z == -1 && (!this.J.n() || !this.L.n() || !this.I.n() || !this.K.n())) {
            if (this.J.n() && this.L.n()) {
                this.z = 0;
            } else if (this.I.n() && this.K.n()) {
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
        if (this.z == -1) {
            int i2 = this.t;
            if (i2 > 0 && this.w == 0) {
                this.z = 0;
            } else {
                if (i2 != 0 || this.w <= 0) {
                    return;
                }
                this.A = 1.0f / this.A;
                this.z = 1;
            }
        }
    }

    public void Y0(boolean z, boolean z2) {
        int i2;
        int i3;
        boolean k2 = z & this.f3071f.k();
        boolean k3 = z2 & this.f3072g.k();
        c.g.b.k.m.l lVar = this.f3071f;
        int i4 = lVar.f3148h.f3109g;
        n nVar = this.f3072g;
        int i5 = nVar.f3148h.f3109g;
        int i6 = lVar.f3149i.f3109g;
        int i7 = nVar.f3149i.f3109g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (k2) {
            this.Z = i4;
        }
        if (k3) {
            this.a0 = i5;
        }
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        if (k2) {
            if (this.T[0] == b.FIXED && i9 < (i3 = this.V)) {
                i9 = i3;
            }
            this.V = i9;
            int i11 = this.g0;
            if (i9 < i11) {
                this.V = i11;
            }
        }
        if (k3) {
            if (this.T[1] == b.FIXED && i10 < (i2 = this.W)) {
                i10 = i2;
            }
            this.W = i10;
            int i12 = this.h0;
            if (i10 < i12) {
                this.W = i12;
            }
        }
    }

    public boolean Z() {
        d dVar = this.I;
        d dVar2 = dVar.f3057f;
        if (dVar2 != null && dVar2.f3057f == dVar) {
            return true;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f3057f;
        return dVar4 != null && dVar4.f3057f == dVar3;
    }

    public void Z0(c.g.b.d dVar, boolean z) {
        n nVar;
        c.g.b.k.m.l lVar;
        int x = dVar.x(this.I);
        int x2 = dVar.x(this.J);
        int x3 = dVar.x(this.K);
        int x4 = dVar.x(this.L);
        if (z && (lVar = this.f3071f) != null) {
            c.g.b.k.m.f fVar = lVar.f3148h;
            if (fVar.f3112j) {
                c.g.b.k.m.f fVar2 = lVar.f3149i;
                if (fVar2.f3112j) {
                    x = fVar.f3109g;
                    x3 = fVar2.f3109g;
                }
            }
        }
        if (z && (nVar = this.f3072g) != null) {
            c.g.b.k.m.f fVar3 = nVar.f3148h;
            if (fVar3.f3112j) {
                c.g.b.k.m.f fVar4 = nVar.f3149i;
                if (fVar4.f3112j) {
                    x2 = fVar3.f3109g;
                    x4 = fVar4.f3109g;
                }
            }
        }
        int i2 = x4 - x2;
        if (x3 - x < 0 || i2 < 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE || x2 == Integer.MIN_VALUE || x2 == Integer.MAX_VALUE || x3 == Integer.MIN_VALUE || x3 == Integer.MAX_VALUE || x4 == Integer.MIN_VALUE || x4 == Integer.MAX_VALUE) {
            x4 = 0;
            x = 0;
            x2 = 0;
            x3 = 0;
        }
        t0(x, x2, x3, x4);
    }

    public boolean a0() {
        return this.E;
    }

    public boolean b0() {
        d dVar = this.J;
        d dVar2 = dVar.f3057f;
        if (dVar2 != null && dVar2.f3057f == dVar) {
            return true;
        }
        d dVar3 = this.L;
        d dVar4 = dVar3.f3057f;
        return dVar4 != null && dVar4.f3057f == dVar3;
    }

    public boolean c0() {
        return this.F;
    }

    public boolean d0() {
        return this.f3075j && this.m0 != 8;
    }

    public void e(f fVar, c.g.b.d dVar, HashSet<e> hashSet, int i2, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.B1(64));
        }
        if (i2 == 0) {
            HashSet<d> c2 = this.I.c();
            if (c2 != null) {
                Iterator<d> it = c2.iterator();
                while (it.hasNext()) {
                    it.next().f3055d.e(fVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<d> c3 = this.K.c();
            if (c3 != null) {
                Iterator<d> it2 = c3.iterator();
                while (it2.hasNext()) {
                    it2.next().f3055d.e(fVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<d> c4 = this.J.c();
        if (c4 != null) {
            Iterator<d> it3 = c4.iterator();
            while (it3.hasNext()) {
                it3.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> c5 = this.L.c();
        if (c5 != null) {
            Iterator<d> it4 = c5.iterator();
            while (it4.hasNext()) {
                it4.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> c6 = this.M.c();
        if (c6 != null) {
            Iterator<d> it5 = c6.iterator();
            while (it5.hasNext()) {
                it5.next().f3055d.e(fVar, dVar, hashSet, i2, true);
            }
        }
    }

    public boolean e0() {
        return this.m || (this.I.m() && this.K.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof k) || (this instanceof g);
    }

    public boolean f0() {
        return this.n || (this.J.m() && this.L.m());
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(c.g.b.d dVar, boolean z) {
        boolean z2;
        boolean z3;
        e eVar;
        e eVar2;
        boolean z4;
        boolean z5;
        c.g.b.i iVar;
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z6;
        int i6;
        boolean z7;
        b bVar;
        boolean z8;
        int i7;
        boolean z9;
        boolean z10;
        boolean z11;
        b bVar2;
        b bVar3;
        boolean z12;
        c.g.b.i iVar2;
        c.g.b.i iVar3;
        c.g.b.i iVar4;
        c.g.b.i iVar5;
        boolean z13;
        int i8;
        int i9;
        char c3;
        e eVar3;
        c.g.b.d dVar2;
        c.g.b.i iVar6;
        c.g.b.i iVar7;
        c.g.b.i iVar8;
        boolean z14;
        c.g.b.i iVar9;
        c.g.b.i iVar10;
        e eVar4;
        boolean z15;
        c.g.b.k.m.l lVar;
        c.g.b.k.m.f fVar;
        int i10;
        int i11;
        boolean Z;
        boolean b0;
        c.g.b.k.m.l lVar2;
        n nVar;
        c.g.b.i q = dVar.q(this.I);
        c.g.b.i q2 = dVar.q(this.K);
        c.g.b.i q3 = dVar.q(this.J);
        c.g.b.i q4 = dVar.q(this.L);
        c.g.b.i q5 = dVar.q(this.M);
        e eVar5 = this.U;
        if (eVar5 != null) {
            boolean z16 = eVar5 != null && eVar5.T[0] == b.WRAP_CONTENT;
            z3 = eVar5 != null && eVar5.T[1] == b.WRAP_CONTENT;
            z2 = z16;
        } else {
            z2 = false;
            z3 = false;
        }
        if (this.m0 == 8 && !W()) {
            boolean[] zArr = this.S;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z17 = this.m;
        if (z17 || this.n) {
            if (z17) {
                dVar.f(q, this.Z);
                dVar.f(q2, this.Z + this.V);
                if (z2 && (eVar2 = this.U) != null) {
                    if (this.l) {
                        f fVar2 = (f) eVar2;
                        fVar2.n1(this.I);
                        fVar2.h1(this.K);
                    } else {
                        dVar.h(dVar.q(eVar2.K), q2, 0, 5);
                    }
                }
            }
            if (this.n) {
                dVar.f(q3, this.a0);
                dVar.f(q4, this.a0 + this.W);
                if (this.M.l()) {
                    dVar.f(q5, this.a0 + this.f0);
                }
                if (z3 && (eVar = this.U) != null) {
                    if (this.l) {
                        f fVar3 = (f) eVar;
                        fVar3.n1(this.J);
                        fVar3.m1(this.L);
                    } else {
                        dVar.h(dVar.q(eVar.L), q4, 0, 5);
                    }
                }
            }
            if (this.m && this.n) {
                this.m = false;
                this.n = false;
                return;
            }
        }
        c.g.b.e eVar6 = c.g.b.d.f3001g;
        if (eVar6 != null) {
            throw null;
        }
        if (z && (lVar2 = this.f3071f) != null && (nVar = this.f3072g) != null) {
            c.g.b.k.m.f fVar4 = lVar2.f3148h;
            if (fVar4.f3112j && lVar2.f3149i.f3112j && nVar.f3148h.f3112j && nVar.f3149i.f3112j) {
                if (eVar6 == null) {
                    dVar.f(q, fVar4.f3109g);
                    dVar.f(q2, this.f3071f.f3149i.f3109g);
                    dVar.f(q3, this.f3072g.f3148h.f3109g);
                    dVar.f(q4, this.f3072g.f3149i.f3109g);
                    dVar.f(q5, this.f3072g.f3128k.f3109g);
                    if (this.U != null) {
                        if (z2 && this.f3073h[0] && !Z()) {
                            dVar.h(dVar.q(this.U.K), q2, 0, 8);
                        }
                        if (z3 && this.f3073h[1] && !b0()) {
                            dVar.h(dVar.q(this.U.L), q4, 0, 8);
                        }
                    }
                    this.m = false;
                    this.n = false;
                    return;
                }
                throw null;
            }
        }
        if (eVar6 == null) {
            if (this.U != null) {
                if (Y(0)) {
                    ((f) this.U).e1(this, 0);
                    Z = true;
                } else {
                    Z = Z();
                }
                if (Y(1)) {
                    ((f) this.U).e1(this, 1);
                    b0 = true;
                } else {
                    b0 = b0();
                }
                if (!Z && z2 && this.m0 != 8 && this.I.f3057f == null && this.K.f3057f == null) {
                    dVar.h(dVar.q(this.U.K), q2, 0, 1);
                }
                if (!b0 && z3 && this.m0 != 8 && this.J.f3057f == null && this.L.f3057f == null && this.M == null) {
                    dVar.h(dVar.q(this.U.L), q4, 0, 1);
                }
                z5 = Z;
                z4 = b0;
            } else {
                z4 = false;
                z5 = false;
            }
            int i12 = this.V;
            int i13 = this.g0;
            if (i12 >= i13) {
                i13 = i12;
            }
            int i14 = this.W;
            int i15 = this.h0;
            if (i14 >= i15) {
                i15 = i14;
            }
            b[] bVarArr = this.T;
            b bVar4 = bVarArr[0];
            b bVar5 = b.MATCH_CONSTRAINT;
            int i16 = i13;
            boolean z18 = bVar4 != bVar5;
            int i17 = i15;
            boolean z19 = bVarArr[1] != bVar5;
            int i18 = this.Y;
            this.z = i18;
            float f2 = this.X;
            this.A = f2;
            int i19 = this.q;
            int i20 = this.r;
            c.g.b.i iVar11 = q2;
            if (f2 > 0.0f) {
                iVar = q;
                if (this.m0 != 8) {
                    if (bVarArr[0] == bVar5 && i19 == 0) {
                        i19 = 3;
                    }
                    if (bVarArr[1] == bVar5 && i20 == 0) {
                        i20 = 3;
                    }
                    if (bVarArr[0] == bVar5 && bVarArr[1] == bVar5) {
                        i11 = 3;
                        if (i19 == 3 && i20 == 3) {
                            X0(z2, z3, z18, z19);
                            c2 = 0;
                            i2 = i19;
                            i3 = i20;
                            i4 = i16;
                            i5 = i17;
                            z6 = true;
                            int[] iArr = this.s;
                            iArr[c2] = i2;
                            iArr[1] = i3;
                            this.f3074i = z6;
                            if (z6) {
                                int i21 = this.z;
                                i6 = -1;
                                if (i21 == 0 || i21 == -1) {
                                    z7 = true;
                                    boolean z20 = !z6 && ((i10 = this.z) == 1 || i10 == i6);
                                    b bVar6 = this.T[0];
                                    bVar = b.WRAP_CONTENT;
                                    z8 = bVar6 != bVar && (this instanceof f);
                                    i7 = !z8 ? 0 : i4;
                                    z9 = !this.P.n();
                                    boolean[] zArr2 = this.S;
                                    z10 = zArr2[0];
                                    boolean z21 = zArr2[1];
                                    if (this.o != 2 && !this.m) {
                                        if (z && (lVar = this.f3071f) != null) {
                                            fVar = lVar.f3148h;
                                            if (fVar.f3112j && lVar.f3149i.f3112j) {
                                                if (!z) {
                                                    c.g.b.i iVar12 = iVar;
                                                    dVar.f(iVar12, fVar.f3109g);
                                                    dVar.f(iVar11, this.f3071f.f3149i.f3109g);
                                                    if (this.U != null && z2 && this.f3073h[0] && !Z()) {
                                                        dVar.h(dVar.q(this.U.K), iVar11, 0, 8);
                                                    }
                                                    z11 = z2;
                                                    z13 = z3;
                                                    bVar2 = bVar5;
                                                    iVar11 = iVar11;
                                                    iVar5 = iVar12;
                                                    bVar3 = bVar;
                                                    z12 = z6;
                                                    iVar2 = q5;
                                                    iVar3 = q4;
                                                    iVar4 = q3;
                                                    if (z) {
                                                        eVar3 = this;
                                                        n nVar2 = eVar3.f3072g;
                                                        if (nVar2 != null) {
                                                            c.g.b.k.m.f fVar5 = nVar2.f3148h;
                                                            if (fVar5.f3112j && nVar2.f3149i.f3112j) {
                                                                dVar2 = dVar;
                                                                iVar8 = iVar4;
                                                                dVar2.f(iVar8, fVar5.f3109g);
                                                                iVar7 = iVar3;
                                                                dVar2.f(iVar7, eVar3.f3072g.f3149i.f3109g);
                                                                iVar6 = iVar2;
                                                                dVar2.f(iVar6, eVar3.f3072g.f3128k.f3109g);
                                                                e eVar7 = eVar3.U;
                                                                if (eVar7 == null || z4 || !z13) {
                                                                    i8 = 8;
                                                                    i9 = 0;
                                                                    c3 = 1;
                                                                } else {
                                                                    c3 = 1;
                                                                    if (eVar3.f3073h[1]) {
                                                                        i8 = 8;
                                                                        i9 = 0;
                                                                        dVar2.h(dVar2.q(eVar7.L), iVar7, 0, 8);
                                                                    } else {
                                                                        i8 = 8;
                                                                        i9 = 0;
                                                                    }
                                                                }
                                                                z14 = false;
                                                                if ((eVar3.p != 2 ? false : z14) || eVar3.n) {
                                                                    iVar9 = iVar7;
                                                                    iVar10 = iVar8;
                                                                } else {
                                                                    boolean z22 = eVar3.T[c3] == bVar3 && (eVar3 instanceof f);
                                                                    if (z22) {
                                                                        i5 = 0;
                                                                    }
                                                                    e eVar8 = eVar3.U;
                                                                    c.g.b.i q6 = eVar8 != null ? dVar2.q(eVar8.L) : null;
                                                                    e eVar9 = eVar3.U;
                                                                    c.g.b.i q7 = eVar9 != null ? dVar2.q(eVar9.J) : null;
                                                                    if (eVar3.f0 > 0 || eVar3.m0 == i8) {
                                                                        if (eVar3.M.f3057f != null) {
                                                                            dVar2.e(iVar6, iVar8, n(), i8);
                                                                            dVar2.e(iVar6, dVar2.q(eVar3.M.f3057f), i9, i8);
                                                                            if (z13) {
                                                                                dVar2.h(q6, dVar2.q(eVar3.L), i9, 5);
                                                                            }
                                                                            z15 = false;
                                                                            boolean z23 = eVar3.f3073h[c3];
                                                                            b[] bVarArr2 = eVar3.T;
                                                                            iVar9 = iVar7;
                                                                            iVar10 = iVar8;
                                                                            i(dVar, false, z13, z11, z23, q7, q6, bVarArr2[c3], z22, eVar3.J, eVar3.L, eVar3.a0, i5, eVar3.h0, eVar3.B[c3], eVar3.j0, z20, bVarArr2[0] != bVar2, z4, z5, z21, i3, i2, eVar3.w, eVar3.x, eVar3.y, z15);
                                                                        } else if (eVar3.m0 == i8) {
                                                                            dVar2.e(iVar6, iVar8, i9, i8);
                                                                        } else {
                                                                            dVar2.e(iVar6, iVar8, n(), i8);
                                                                        }
                                                                    }
                                                                    z15 = z9;
                                                                    boolean z232 = eVar3.f3073h[c3];
                                                                    b[] bVarArr22 = eVar3.T;
                                                                    iVar9 = iVar7;
                                                                    iVar10 = iVar8;
                                                                    i(dVar, false, z13, z11, z232, q7, q6, bVarArr22[c3], z22, eVar3.J, eVar3.L, eVar3.a0, i5, eVar3.h0, eVar3.B[c3], eVar3.j0, z20, bVarArr22[0] != bVar2, z4, z5, z21, i3, i2, eVar3.w, eVar3.x, eVar3.y, z15);
                                                                }
                                                                if (z12) {
                                                                    eVar4 = this;
                                                                } else {
                                                                    eVar4 = this;
                                                                    if (eVar4.z == 1) {
                                                                        dVar.k(iVar9, iVar10, iVar11, iVar5, eVar4.A, 8);
                                                                    } else {
                                                                        dVar.k(iVar11, iVar5, iVar9, iVar10, eVar4.A, 8);
                                                                    }
                                                                }
                                                                if (eVar4.P.n()) {
                                                                    dVar.b(eVar4, eVar4.P.i().g(), (float) Math.toRadians(eVar4.C + 90.0f), eVar4.P.e());
                                                                }
                                                                eVar4.m = false;
                                                                eVar4.n = false;
                                                                return;
                                                            }
                                                        }
                                                        dVar2 = dVar;
                                                        iVar6 = iVar2;
                                                        iVar7 = iVar3;
                                                        iVar8 = iVar4;
                                                        i8 = 8;
                                                        i9 = 0;
                                                        c3 = 1;
                                                    } else {
                                                        i8 = 8;
                                                        i9 = 0;
                                                        c3 = 1;
                                                        eVar3 = this;
                                                        dVar2 = dVar;
                                                        iVar6 = iVar2;
                                                        iVar7 = iVar3;
                                                        iVar8 = iVar4;
                                                    }
                                                    z14 = true;
                                                    if (eVar3.p != 2 ? false : z14) {
                                                    }
                                                    iVar9 = iVar7;
                                                    iVar10 = iVar8;
                                                    if (z12) {
                                                    }
                                                    if (eVar4.P.n()) {
                                                    }
                                                    eVar4.m = false;
                                                    eVar4.n = false;
                                                    return;
                                                }
                                            }
                                        }
                                        c.g.b.i iVar13 = iVar;
                                        e eVar10 = this.U;
                                        c.g.b.i q8 = eVar10 == null ? dVar.q(eVar10.K) : null;
                                        e eVar11 = this.U;
                                        c.g.b.i q9 = eVar11 == null ? dVar.q(eVar11.I) : null;
                                        boolean z24 = this.f3073h[0];
                                        b[] bVarArr3 = this.T;
                                        z11 = z2;
                                        z13 = z3;
                                        bVar2 = bVar5;
                                        iVar2 = q5;
                                        iVar3 = q4;
                                        iVar4 = q3;
                                        iVar11 = iVar11;
                                        bVar3 = bVar;
                                        iVar5 = iVar13;
                                        z12 = z6;
                                        i(dVar, true, z2, z3, z24, q9, q8, bVarArr3[0], z8, this.I, this.K, this.Z, i7, this.g0, this.B[0], this.i0, z7, bVarArr3[1] != bVar5, z5, z4, z10, i2, i3, this.t, this.u, this.v, z9);
                                        if (z) {
                                        }
                                        z14 = true;
                                        if (eVar3.p != 2 ? false : z14) {
                                        }
                                        iVar9 = iVar7;
                                        iVar10 = iVar8;
                                        if (z12) {
                                        }
                                        if (eVar4.P.n()) {
                                        }
                                        eVar4.m = false;
                                        eVar4.n = false;
                                        return;
                                    }
                                    z11 = z2;
                                    bVar2 = bVar5;
                                    bVar3 = bVar;
                                    z12 = z6;
                                    iVar2 = q5;
                                    iVar3 = q4;
                                    iVar4 = q3;
                                    iVar5 = iVar;
                                    z13 = z3;
                                    if (z) {
                                    }
                                    z14 = true;
                                    if (eVar3.p != 2 ? false : z14) {
                                    }
                                    iVar9 = iVar7;
                                    iVar10 = iVar8;
                                    if (z12) {
                                    }
                                    if (eVar4.P.n()) {
                                    }
                                    eVar4.m = false;
                                    eVar4.n = false;
                                    return;
                                }
                            } else {
                                i6 = -1;
                            }
                            z7 = false;
                            if (z6) {
                            }
                            b bVar62 = this.T[0];
                            bVar = b.WRAP_CONTENT;
                            if (bVar62 != bVar) {
                            }
                            if (!z8) {
                            }
                            z9 = !this.P.n();
                            boolean[] zArr22 = this.S;
                            z10 = zArr22[0];
                            boolean z212 = zArr22[1];
                            if (this.o != 2) {
                                if (z) {
                                    fVar = lVar.f3148h;
                                    if (fVar.f3112j) {
                                        if (!z) {
                                        }
                                    }
                                }
                                c.g.b.i iVar132 = iVar;
                                e eVar102 = this.U;
                                if (eVar102 == null) {
                                }
                                e eVar112 = this.U;
                                if (eVar112 == null) {
                                }
                                boolean z242 = this.f3073h[0];
                                b[] bVarArr32 = this.T;
                                z11 = z2;
                                z13 = z3;
                                bVar2 = bVar5;
                                iVar2 = q5;
                                iVar3 = q4;
                                iVar4 = q3;
                                iVar11 = iVar11;
                                bVar3 = bVar;
                                iVar5 = iVar132;
                                z12 = z6;
                                i(dVar, true, z2, z3, z242, q9, q8, bVarArr32[0], z8, this.I, this.K, this.Z, i7, this.g0, this.B[0], this.i0, z7, bVarArr32[1] != bVar5, z5, z4, z10, i2, i3, this.t, this.u, this.v, z9);
                                if (z) {
                                }
                                z14 = true;
                                if (eVar3.p != 2 ? false : z14) {
                                }
                                iVar9 = iVar7;
                                iVar10 = iVar8;
                                if (z12) {
                                }
                                if (eVar4.P.n()) {
                                }
                                eVar4.m = false;
                                eVar4.n = false;
                                return;
                            }
                            z11 = z2;
                            bVar2 = bVar5;
                            bVar3 = bVar;
                            z12 = z6;
                            iVar2 = q5;
                            iVar3 = q4;
                            iVar4 = q3;
                            iVar5 = iVar;
                            z13 = z3;
                            if (z) {
                            }
                            z14 = true;
                            if (eVar3.p != 2 ? false : z14) {
                            }
                            iVar9 = iVar7;
                            iVar10 = iVar8;
                            if (z12) {
                            }
                            if (eVar4.P.n()) {
                            }
                            eVar4.m = false;
                            eVar4.n = false;
                            return;
                        }
                    } else {
                        i11 = 3;
                    }
                    if (bVarArr[0] == bVar5 && i19 == i11) {
                        this.z = 0;
                        i4 = (int) (f2 * i14);
                        if (bVarArr[1] != bVar5) {
                            i3 = i20;
                            i5 = i17;
                            c2 = 0;
                            z6 = false;
                            i2 = 4;
                            int[] iArr2 = this.s;
                            iArr2[c2] = i2;
                            iArr2[1] = i3;
                            this.f3074i = z6;
                            if (z6) {
                            }
                            z7 = false;
                            if (z6) {
                            }
                            b bVar622 = this.T[0];
                            bVar = b.WRAP_CONTENT;
                            if (bVar622 != bVar) {
                            }
                            if (!z8) {
                            }
                            z9 = !this.P.n();
                            boolean[] zArr222 = this.S;
                            z10 = zArr222[0];
                            boolean z2122 = zArr222[1];
                            if (this.o != 2) {
                            }
                            z11 = z2;
                            bVar2 = bVar5;
                            bVar3 = bVar;
                            z12 = z6;
                            iVar2 = q5;
                            iVar3 = q4;
                            iVar4 = q3;
                            iVar5 = iVar;
                            z13 = z3;
                            if (z) {
                            }
                            z14 = true;
                            if (eVar3.p != 2 ? false : z14) {
                            }
                            iVar9 = iVar7;
                            iVar10 = iVar8;
                            if (z12) {
                            }
                            if (eVar4.P.n()) {
                            }
                            eVar4.m = false;
                            eVar4.n = false;
                            return;
                        }
                        i2 = i19;
                        i3 = i20;
                        i5 = i17;
                        c2 = 0;
                        z6 = true;
                        int[] iArr22 = this.s;
                        iArr22[c2] = i2;
                        iArr22[1] = i3;
                        this.f3074i = z6;
                        if (z6) {
                        }
                        z7 = false;
                        if (z6) {
                        }
                        b bVar6222 = this.T[0];
                        bVar = b.WRAP_CONTENT;
                        if (bVar6222 != bVar) {
                        }
                        if (!z8) {
                        }
                        z9 = !this.P.n();
                        boolean[] zArr2222 = this.S;
                        z10 = zArr2222[0];
                        boolean z21222 = zArr2222[1];
                        if (this.o != 2) {
                        }
                        z11 = z2;
                        bVar2 = bVar5;
                        bVar3 = bVar;
                        z12 = z6;
                        iVar2 = q5;
                        iVar3 = q4;
                        iVar4 = q3;
                        iVar5 = iVar;
                        z13 = z3;
                        if (z) {
                        }
                        z14 = true;
                        if (eVar3.p != 2 ? false : z14) {
                        }
                        iVar9 = iVar7;
                        iVar10 = iVar8;
                        if (z12) {
                        }
                        if (eVar4.P.n()) {
                        }
                        eVar4.m = false;
                        eVar4.n = false;
                        return;
                    }
                    if (bVarArr[1] == bVar5 && i20 == 3) {
                        this.z = 1;
                        if (i18 == -1) {
                            this.A = 1.0f / f2;
                        }
                        int i22 = (int) (this.A * i12);
                        c2 = 0;
                        i5 = i22;
                        i2 = i19;
                        if (bVarArr[0] != bVar5) {
                            i4 = i16;
                            z6 = false;
                            i3 = 4;
                            int[] iArr222 = this.s;
                            iArr222[c2] = i2;
                            iArr222[1] = i3;
                            this.f3074i = z6;
                            if (z6) {
                            }
                            z7 = false;
                            if (z6) {
                            }
                            b bVar62222 = this.T[0];
                            bVar = b.WRAP_CONTENT;
                            if (bVar62222 != bVar) {
                            }
                            if (!z8) {
                            }
                            z9 = !this.P.n();
                            boolean[] zArr22222 = this.S;
                            z10 = zArr22222[0];
                            boolean z212222 = zArr22222[1];
                            if (this.o != 2) {
                            }
                            z11 = z2;
                            bVar2 = bVar5;
                            bVar3 = bVar;
                            z12 = z6;
                            iVar2 = q5;
                            iVar3 = q4;
                            iVar4 = q3;
                            iVar5 = iVar;
                            z13 = z3;
                            if (z) {
                            }
                            z14 = true;
                            if (eVar3.p != 2 ? false : z14) {
                            }
                            iVar9 = iVar7;
                            iVar10 = iVar8;
                            if (z12) {
                            }
                            if (eVar4.P.n()) {
                            }
                            eVar4.m = false;
                            eVar4.n = false;
                            return;
                        }
                        i3 = i20;
                        i4 = i16;
                        z6 = true;
                        int[] iArr2222 = this.s;
                        iArr2222[c2] = i2;
                        iArr2222[1] = i3;
                        this.f3074i = z6;
                        if (z6) {
                        }
                        z7 = false;
                        if (z6) {
                        }
                        b bVar622222 = this.T[0];
                        bVar = b.WRAP_CONTENT;
                        if (bVar622222 != bVar) {
                        }
                        if (!z8) {
                        }
                        z9 = !this.P.n();
                        boolean[] zArr222222 = this.S;
                        z10 = zArr222222[0];
                        boolean z2122222 = zArr222222[1];
                        if (this.o != 2) {
                        }
                        z11 = z2;
                        bVar2 = bVar5;
                        bVar3 = bVar;
                        z12 = z6;
                        iVar2 = q5;
                        iVar3 = q4;
                        iVar4 = q3;
                        iVar5 = iVar;
                        z13 = z3;
                        if (z) {
                        }
                        z14 = true;
                        if (eVar3.p != 2 ? false : z14) {
                        }
                        iVar9 = iVar7;
                        iVar10 = iVar8;
                        if (z12) {
                        }
                        if (eVar4.P.n()) {
                        }
                        eVar4.m = false;
                        eVar4.n = false;
                        return;
                    }
                    c2 = 0;
                    i2 = i19;
                    i3 = i20;
                    i4 = i16;
                    i5 = i17;
                    z6 = true;
                    int[] iArr22222 = this.s;
                    iArr22222[c2] = i2;
                    iArr22222[1] = i3;
                    this.f3074i = z6;
                    if (z6) {
                    }
                    z7 = false;
                    if (z6) {
                    }
                    b bVar6222222 = this.T[0];
                    bVar = b.WRAP_CONTENT;
                    if (bVar6222222 != bVar) {
                    }
                    if (!z8) {
                    }
                    z9 = !this.P.n();
                    boolean[] zArr2222222 = this.S;
                    z10 = zArr2222222[0];
                    boolean z21222222 = zArr2222222[1];
                    if (this.o != 2) {
                    }
                    z11 = z2;
                    bVar2 = bVar5;
                    bVar3 = bVar;
                    z12 = z6;
                    iVar2 = q5;
                    iVar3 = q4;
                    iVar4 = q3;
                    iVar5 = iVar;
                    z13 = z3;
                    if (z) {
                    }
                    z14 = true;
                    if (eVar3.p != 2 ? false : z14) {
                    }
                    iVar9 = iVar7;
                    iVar10 = iVar8;
                    if (z12) {
                    }
                    if (eVar4.P.n()) {
                    }
                    eVar4.m = false;
                    eVar4.n = false;
                    return;
                }
            } else {
                iVar = q;
            }
            c2 = 0;
            i2 = i19;
            i3 = i20;
            i4 = i16;
            i5 = i17;
            z6 = false;
            int[] iArr222222 = this.s;
            iArr222222[c2] = i2;
            iArr222222[1] = i3;
            this.f3074i = z6;
            if (z6) {
            }
            z7 = false;
            if (z6) {
            }
            b bVar62222222 = this.T[0];
            bVar = b.WRAP_CONTENT;
            if (bVar62222222 != bVar) {
            }
            if (!z8) {
            }
            z9 = !this.P.n();
            boolean[] zArr22222222 = this.S;
            z10 = zArr22222222[0];
            boolean z212222222 = zArr22222222[1];
            if (this.o != 2) {
            }
            z11 = z2;
            bVar2 = bVar5;
            bVar3 = bVar;
            z12 = z6;
            iVar2 = q5;
            iVar3 = q4;
            iVar4 = q3;
            iVar5 = iVar;
            z13 = z3;
            if (z) {
            }
            z14 = true;
            if (eVar3.p != 2 ? false : z14) {
            }
            iVar9 = iVar7;
            iVar10 = iVar8;
            if (z12) {
            }
            if (eVar4.P.n()) {
            }
            eVar4.m = false;
            eVar4.n = false;
            return;
        }
        throw null;
    }

    public boolean g0() {
        b[] bVarArr = this.T;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public boolean h() {
        return this.m0 != 8;
    }

    public void h0() {
        this.I.p();
        this.J.p();
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.U = null;
        this.C = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        float f2 = a;
        this.i0 = f2;
        this.j0 = f2;
        b[] bVarArr = this.T;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.o0 = null;
        this.p0 = false;
        this.q0 = false;
        this.s0 = 0;
        this.t0 = 0;
        this.u0 = false;
        this.v0 = false;
        float[] fArr = this.w0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr = this.B;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.q = 0;
        this.r = 0;
        this.v = 1.0f;
        this.y = 1.0f;
        this.u = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.t = 0;
        this.w = 0;
        this.f3074i = false;
        this.z = -1;
        this.A = 1.0f;
        this.r0 = false;
        boolean[] zArr = this.f3073h;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3075j = true;
    }

    public void i0() {
        this.m = false;
        this.n = false;
        int size = this.R.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.R.get(i2).q();
        }
    }

    public void j(e eVar, float f2, int i2) {
        d.b bVar = d.b.CENTER;
        X(bVar, eVar, bVar, i2, 0);
        this.C = f2;
    }

    public void j0(c.g.b.c cVar) {
        this.I.r(cVar);
        this.J.r(cVar);
        this.K.r(cVar);
        this.L.r(cVar);
        this.M.r(cVar);
        this.P.r(cVar);
        this.N.r(cVar);
        this.O.r(cVar);
    }

    public void k(c.g.b.d dVar) {
        dVar.q(this.I);
        dVar.q(this.J);
        dVar.q(this.K);
        dVar.q(this.L);
        if (this.f0 > 0) {
            dVar.q(this.M);
        }
    }

    public void k0(int i2) {
        this.f0 = i2;
        this.D = i2 > 0;
    }

    public void l() {
        if (this.f3071f == null) {
            this.f3071f = new c.g.b.k.m.l(this);
        }
        if (this.f3072g == null) {
            this.f3072g = new n(this);
        }
    }

    public void l0(Object obj) {
        this.k0 = obj;
    }

    public d m(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void m0(String str) {
        this.n0 = str;
    }

    public int n() {
        return this.f0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please report as a decompilation issue!!! */
    public void n0(String str) {
        float f2;
        int i2 = 0;
        if (str != null && str.length() != 0) {
            int i3 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i4 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i4, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i3 == 1) {
                            f2 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f2 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f2 = 0.0f;
            } else {
                String substring4 = str.substring(i4);
                if (substring4.length() > 0) {
                    f2 = Float.parseFloat(substring4);
                }
                f2 = 0.0f;
            }
            i2 = (f2 > i2 ? 1 : (f2 == i2 ? 0 : -1));
            if (i2 > 0) {
                this.X = f2;
                this.Y = i3;
                return;
            }
            return;
        }
        this.X = 0.0f;
    }

    public float o(int i2) {
        if (i2 == 0) {
            return this.i0;
        }
        if (i2 == 1) {
            return this.j0;
        }
        return -1.0f;
    }

    public void o0(int i2) {
        if (this.D) {
            int i3 = i2 - this.f0;
            int i4 = this.W + i3;
            this.a0 = i3;
            this.J.s(i3);
            this.L.s(i4);
            this.M.s(i2);
            this.n = true;
        }
    }

    public int p() {
        return T() + this.W;
    }

    public void p0(int i2, int i3) {
        this.I.s(i2);
        this.K.s(i3);
        this.Z = i2;
        this.V = i3 - i2;
        this.m = true;
    }

    public Object q() {
        return this.k0;
    }

    public void q0(int i2) {
        this.I.s(i2);
        this.Z = i2;
    }

    public String r() {
        return this.n0;
    }

    public void r0(int i2) {
        this.J.s(i2);
        this.a0 = i2;
    }

    public b s(int i2) {
        if (i2 == 0) {
            return y();
        }
        if (i2 == 1) {
            return O();
        }
        return null;
    }

    public void s0(int i2, int i3) {
        this.J.s(i2);
        this.L.s(i3);
        this.a0 = i2;
        this.W = i3 - i2;
        if (this.D) {
            this.M.s(i2 + this.f0);
        }
        this.n = true;
    }

    public float t() {
        return this.X;
    }

    public void t0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.Z = i2;
        this.a0 = i3;
        if (this.m0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        b[] bVarArr = this.T;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i8 < (i7 = this.V)) {
            i8 = i7;
        }
        if (bVarArr[1] == bVar2 && i9 < (i6 = this.W)) {
            i9 = i6;
        }
        this.V = i8;
        this.W = i9;
        int i10 = this.h0;
        if (i9 < i10) {
            this.W = i10;
        }
        int i11 = this.g0;
        if (i8 < i11) {
            this.V = i11;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.o0;
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (str2 != null) {
            str = "type: " + this.o0 + " ";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (this.n0 != null) {
            str3 = "id: " + this.n0 + " ";
        }
        sb.append(str3);
        sb.append("(");
        sb.append(this.Z);
        sb.append(", ");
        sb.append(this.a0);
        sb.append(") - (");
        sb.append(this.V);
        sb.append(" x ");
        sb.append(this.W);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.Y;
    }

    public void u0(boolean z) {
        this.D = z;
    }

    public int v() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.W;
    }

    public void v0(int i2) {
        this.W = i2;
        int i3 = this.h0;
        if (i2 < i3) {
            this.W = i3;
        }
    }

    public float w() {
        return this.i0;
    }

    public void w0(float f2) {
        this.i0 = f2;
    }

    public int x() {
        return this.s0;
    }

    public void x0(int i2) {
        this.s0 = i2;
    }

    public b y() {
        return this.T[0];
    }

    public void y0(int i2, int i3) {
        this.Z = i2;
        int i4 = i3 - i2;
        this.V = i4;
        int i5 = this.g0;
        if (i4 < i5) {
            this.V = i5;
        }
    }

    public int z() {
        d dVar = this.I;
        int i2 = dVar != null ? 0 + dVar.f3058g : 0;
        d dVar2 = this.K;
        return dVar2 != null ? i2 + dVar2.f3058g : i2;
    }

    public void z0(b bVar) {
        this.T[0] = bVar;
    }
}
