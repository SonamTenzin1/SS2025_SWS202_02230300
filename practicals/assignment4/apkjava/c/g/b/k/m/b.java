package c.g.b.k.m;

import c.g.b.k.d;
import c.g.b.k.e;
import java.util.ArrayList;

/* compiled from: BasicMeasure.java */
/* loaded from: classes.dex */
public class b {
    private final ArrayList<c.g.b.k.e> a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private a f3083b = new a();

    /* renamed from: c, reason: collision with root package name */
    private c.g.b.k.f f3084c;

    /* compiled from: BasicMeasure.java */
    /* loaded from: classes.dex */
    public static class a {
        public static int a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static int f3085b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static int f3086c = 2;

        /* renamed from: d, reason: collision with root package name */
        public e.b f3087d;

        /* renamed from: e, reason: collision with root package name */
        public e.b f3088e;

        /* renamed from: f, reason: collision with root package name */
        public int f3089f;

        /* renamed from: g, reason: collision with root package name */
        public int f3090g;

        /* renamed from: h, reason: collision with root package name */
        public int f3091h;

        /* renamed from: i, reason: collision with root package name */
        public int f3092i;

        /* renamed from: j, reason: collision with root package name */
        public int f3093j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f3094k;
        public boolean l;
        public int m;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: c.g.b.k.m.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070b {
        void a();

        void b(c.g.b.k.e eVar, a aVar);
    }

    public b(c.g.b.k.f fVar) {
        this.f3084c = fVar;
    }

    private boolean a(InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar, int i2) {
        this.f3083b.f3087d = eVar.y();
        this.f3083b.f3088e = eVar.O();
        this.f3083b.f3089f = eVar.R();
        this.f3083b.f3090g = eVar.v();
        a aVar = this.f3083b;
        aVar.l = false;
        aVar.m = i2;
        e.b bVar = aVar.f3087d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z = bVar == bVar2;
        boolean z2 = aVar.f3088e == bVar2;
        boolean z3 = z && eVar.X > 0.0f;
        boolean z4 = z2 && eVar.X > 0.0f;
        if (z3 && eVar.s[0] == 4) {
            aVar.f3087d = e.b.FIXED;
        }
        if (z4 && eVar.s[1] == 4) {
            aVar.f3088e = e.b.FIXED;
        }
        interfaceC0070b.b(eVar, aVar);
        eVar.U0(this.f3083b.f3091h);
        eVar.v0(this.f3083b.f3092i);
        eVar.u0(this.f3083b.f3094k);
        eVar.k0(this.f3083b.f3093j);
        a aVar2 = this.f3083b;
        aVar2.m = a.a;
        return aVar2.l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008d, code lost:
    
        if (r8 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
    
        if (r5.X <= 0.0f) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(c.g.b.k.f fVar) {
        l lVar;
        n nVar;
        int size = fVar.D0.size();
        boolean B1 = fVar.B1(64);
        InterfaceC0070b r1 = fVar.r1();
        for (int i2 = 0; i2 < size; i2++) {
            c.g.b.k.e eVar = fVar.D0.get(i2);
            if (!(eVar instanceof c.g.b.k.g) && !(eVar instanceof c.g.b.k.a) && !eVar.c0() && (!B1 || (lVar = eVar.f3071f) == null || (nVar = eVar.f3072g) == null || !lVar.f3145e.f3112j || !nVar.f3145e.f3112j)) {
                e.b s = eVar.s(0);
                boolean z = true;
                e.b s2 = eVar.s(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z2 = s == bVar && eVar.q != 1 && s2 == bVar && eVar.r != 1;
                if (!z2 && fVar.B1(1) && !(eVar instanceof c.g.b.k.k)) {
                    if (s == bVar && eVar.q == 0 && s2 != bVar && !eVar.Z()) {
                        z2 = true;
                    }
                    if (s2 == bVar && eVar.r == 0 && s != bVar && !eVar.Z()) {
                        z2 = true;
                    }
                    if (s != bVar) {
                    }
                }
                z = z2;
                if (z) {
                    continue;
                } else {
                    a(r1, eVar, a.a);
                    if (fVar.I0 != null) {
                        throw null;
                    }
                }
            }
        }
        r1.a();
    }

    private void c(c.g.b.k.f fVar, String str, int i2, int i3) {
        int G = fVar.G();
        int F = fVar.F();
        fVar.K0(0);
        fVar.J0(0);
        fVar.U0(i2);
        fVar.v0(i3);
        fVar.K0(G);
        fVar.J0(F);
        this.f3084c.b1();
    }

    public long d(c.g.b.k.f fVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        boolean z;
        int i11;
        int i12;
        boolean z2;
        boolean z3;
        boolean z4;
        int i13;
        boolean z5;
        int i14;
        int i15;
        boolean z6;
        InterfaceC0070b r1 = fVar.r1();
        int size = fVar.D0.size();
        int R = fVar.R();
        int v = fVar.v();
        boolean b2 = c.g.b.k.j.b(i2, 128);
        boolean z7 = b2 || c.g.b.k.j.b(i2, 64);
        if (z7) {
            for (int i16 = 0; i16 < size; i16++) {
                c.g.b.k.e eVar = fVar.D0.get(i16);
                e.b y = eVar.y();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z8 = (y == bVar) && (eVar.O() == bVar) && eVar.t() > 0.0f;
                if ((eVar.Z() && z8) || ((eVar.b0() && z8) || (eVar instanceof c.g.b.k.k) || eVar.Z() || eVar.b0())) {
                    z7 = false;
                    break;
                }
            }
        }
        if (z7 && c.g.b.d.f3001g != null) {
            throw null;
        }
        boolean z9 = z7 & ((i5 == 1073741824 && i7 == 1073741824) || b2);
        if (z9) {
            int min = Math.min(fVar.E(), i6);
            int min2 = Math.min(fVar.D(), i8);
            if (i5 == 1073741824 && fVar.R() != min) {
                fVar.U0(min);
                fVar.u1();
            }
            if (i7 == 1073741824 && fVar.v() != min2) {
                fVar.v0(min2);
                fVar.u1();
            }
            if (i5 == 1073741824 && i7 == 1073741824) {
                z = fVar.o1(b2);
                i11 = 2;
            } else {
                boolean p1 = fVar.p1(b2);
                if (i5 == 1073741824) {
                    p1 &= fVar.q1(b2, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i7 == 1073741824) {
                    z = fVar.q1(b2, 1) & p1;
                    i11++;
                } else {
                    z = p1;
                }
            }
            if (z) {
                fVar.Y0(i5 == 1073741824, i7 == 1073741824);
            }
        } else {
            z = false;
            i11 = 0;
        }
        if (z && i11 == 2) {
            return 0L;
        }
        int s1 = fVar.s1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = this.a.size();
        if (size > 0) {
            c(fVar, "First pass", R, v);
        }
        if (size2 > 0) {
            e.b y2 = fVar.y();
            e.b bVar2 = e.b.WRAP_CONTENT;
            boolean z10 = y2 == bVar2;
            boolean z11 = fVar.O() == bVar2;
            int max = Math.max(fVar.R(), this.f3084c.G());
            int max2 = Math.max(fVar.v(), this.f3084c.F());
            int i17 = 0;
            boolean z12 = false;
            while (i17 < size2) {
                c.g.b.k.e eVar2 = this.a.get(i17);
                if (eVar2 instanceof c.g.b.k.k) {
                    int R2 = eVar2.R();
                    i14 = s1;
                    int v2 = eVar2.v();
                    i15 = R;
                    boolean a2 = a(r1, eVar2, a.f3085b) | z12;
                    if (fVar.I0 == null) {
                        int R3 = eVar2.R();
                        int v3 = eVar2.v();
                        if (R3 != R2) {
                            eVar2.U0(R3);
                            if (z10 && eVar2.K() > max) {
                                max = Math.max(max, eVar2.K() + eVar2.m(d.b.RIGHT).e());
                            }
                            z6 = true;
                        } else {
                            z6 = a2;
                        }
                        if (v3 != v2) {
                            eVar2.v0(v3);
                            if (z11 && eVar2.p() > max2) {
                                max2 = Math.max(max2, eVar2.p() + eVar2.m(d.b.BOTTOM).e());
                            }
                            z6 = true;
                        }
                        z12 = z6 | ((c.g.b.k.k) eVar2).d1();
                    } else {
                        throw null;
                    }
                } else {
                    i14 = s1;
                    i15 = R;
                }
                i17++;
                s1 = i14;
                R = i15;
            }
            int i18 = s1;
            int i19 = R;
            int i20 = 0;
            int i21 = 2;
            while (i20 < i21) {
                int i22 = 0;
                while (i22 < size2) {
                    c.g.b.k.e eVar3 = this.a.get(i22);
                    if (((eVar3 instanceof c.g.b.k.h) && !(eVar3 instanceof c.g.b.k.k)) || (eVar3 instanceof c.g.b.k.g) || eVar3.Q() == 8 || ((z9 && eVar3.f3071f.f3145e.f3112j && eVar3.f3072g.f3145e.f3112j) || (eVar3 instanceof c.g.b.k.k))) {
                        z4 = z9;
                        i13 = size2;
                    } else {
                        int R4 = eVar3.R();
                        int v4 = eVar3.v();
                        z4 = z9;
                        int n = eVar3.n();
                        int i23 = a.f3085b;
                        i13 = size2;
                        if (i20 == 1) {
                            i23 = a.f3086c;
                        }
                        boolean a3 = a(r1, eVar3, i23) | z12;
                        if (fVar.I0 == null) {
                            int R5 = eVar3.R();
                            int v5 = eVar3.v();
                            if (R5 != R4) {
                                eVar3.U0(R5);
                                if (z10 && eVar3.K() > max) {
                                    max = Math.max(max, eVar3.K() + eVar3.m(d.b.RIGHT).e());
                                }
                                z5 = true;
                            } else {
                                z5 = a3;
                            }
                            if (v5 != v4) {
                                eVar3.v0(v5);
                                if (z11 && eVar3.p() > max2) {
                                    max2 = Math.max(max2, eVar3.p() + eVar3.m(d.b.BOTTOM).e());
                                }
                                z5 = true;
                            }
                            z12 = (!eVar3.U() || n == eVar3.n()) ? z5 : true;
                        } else {
                            throw null;
                        }
                    }
                    i22++;
                    size2 = i13;
                    z9 = z4;
                }
                boolean z13 = z9;
                int i24 = size2;
                if (!z12) {
                    break;
                }
                c(fVar, "intermediate pass", i19, v);
                i20++;
                size2 = i24;
                z9 = z13;
                i21 = 2;
                z12 = false;
            }
            if (z12) {
                c(fVar, "2nd pass", i19, v);
                if (fVar.R() < max) {
                    fVar.U0(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (fVar.v() < max2) {
                    fVar.v0(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    c(fVar, "3rd pass", i19, v);
                }
            }
            i12 = i18;
        } else {
            i12 = s1;
        }
        fVar.E1(i12);
        return 0L;
    }

    public void e(c.g.b.k.f fVar) {
        this.a.clear();
        int size = fVar.D0.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.g.b.k.e eVar = fVar.D0.get(i2);
            e.b y = eVar.y();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (y == bVar || eVar.O() == bVar) {
                this.a.add(eVar);
            }
        }
        fVar.u1();
    }
}
