package c.g.b.k.m;

import c.g.b.k.d;
import c.g.b.k.e;
import c.g.b.k.m.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Direct.java */
/* loaded from: classes.dex */
public class h {
    private static b.a a = new b.a();

    private static boolean a(c.g.b.k.e eVar) {
        e.b y = eVar.y();
        e.b O = eVar.O();
        c.g.b.k.f fVar = eVar.I() != null ? (c.g.b.k.f) eVar.I() : null;
        if (fVar != null) {
            fVar.y();
            e.b bVar = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.O();
            e.b bVar2 = e.b.FIXED;
        }
        e.b bVar3 = e.b.FIXED;
        boolean z = y == bVar3 || y == e.b.WRAP_CONTENT || (y == e.b.MATCH_CONSTRAINT && eVar.q == 0 && eVar.X == 0.0f && eVar.V(0)) || eVar.e0();
        boolean z2 = O == bVar3 || O == e.b.WRAP_CONTENT || (O == e.b.MATCH_CONSTRAINT && eVar.r == 0 && eVar.X == 0.0f && eVar.V(1)) || eVar.f0();
        if (eVar.X <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    private static void b(c.g.b.k.e eVar, b.InterfaceC0070b interfaceC0070b, boolean z) {
        c.g.b.k.d dVar;
        c.g.b.k.d dVar2;
        c.g.b.k.d dVar3;
        c.g.b.k.d dVar4;
        c.g.b.k.d dVar5;
        if (!(eVar instanceof c.g.b.k.f) && eVar.d0() && a(eVar)) {
            c.g.b.k.f.A1(eVar, interfaceC0070b, new b.a(), b.a.a);
        }
        c.g.b.k.d m = eVar.m(d.b.LEFT);
        c.g.b.k.d m2 = eVar.m(d.b.RIGHT);
        int d2 = m.d();
        int d3 = m2.d();
        if (m.c() != null && m.m()) {
            Iterator<c.g.b.k.d> it = m.c().iterator();
            while (it.hasNext()) {
                c.g.b.k.d next = it.next();
                c.g.b.k.e eVar2 = next.f3055d;
                boolean a2 = a(eVar2);
                if (eVar2.d0() && a2) {
                    c.g.b.k.f.A1(eVar2, interfaceC0070b, new b.a(), b.a.a);
                }
                e.b y = eVar2.y();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (y == bVar && !a2) {
                    if (eVar2.y() == bVar && eVar2.u >= 0 && eVar2.t >= 0 && (eVar2.Q() == 8 || (eVar2.q == 0 && eVar2.t() == 0.0f))) {
                        if (!eVar2.Z() && !eVar2.c0()) {
                            if (((next == eVar2.I && (dVar5 = eVar2.K.f3057f) != null && dVar5.m()) || (next == eVar2.K && (dVar4 = eVar2.I.f3057f) != null && dVar4.m())) && !eVar2.Z()) {
                                e(eVar, interfaceC0070b, eVar2, z);
                            }
                        }
                    }
                } else if (!eVar2.d0()) {
                    c.g.b.k.d dVar6 = eVar2.I;
                    if (next == dVar6 && eVar2.K.f3057f == null) {
                        int e2 = dVar6.e() + d2;
                        eVar2.p0(e2, eVar2.R() + e2);
                        b(eVar2, interfaceC0070b, z);
                    } else {
                        c.g.b.k.d dVar7 = eVar2.K;
                        if (next == dVar7 && dVar6.f3057f == null) {
                            int e3 = d2 - dVar7.e();
                            eVar2.p0(e3 - eVar2.R(), e3);
                            b(eVar2, interfaceC0070b, z);
                        } else if (next == dVar6 && (dVar3 = dVar7.f3057f) != null && dVar3.m() && !eVar2.Z()) {
                            d(interfaceC0070b, eVar2, z);
                        }
                    }
                }
            }
        }
        if ((eVar instanceof c.g.b.k.g) || m2.c() == null || !m2.m()) {
            return;
        }
        Iterator<c.g.b.k.d> it2 = m2.c().iterator();
        while (it2.hasNext()) {
            c.g.b.k.d next2 = it2.next();
            c.g.b.k.e eVar3 = next2.f3055d;
            boolean a3 = a(eVar3);
            if (eVar3.d0() && a3) {
                c.g.b.k.f.A1(eVar3, interfaceC0070b, new b.a(), b.a.a);
            }
            boolean z2 = (next2 == eVar3.I && (dVar2 = eVar3.K.f3057f) != null && dVar2.m()) || (next2 == eVar3.K && (dVar = eVar3.I.f3057f) != null && dVar.m());
            e.b y2 = eVar3.y();
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (y2 == bVar2 && !a3) {
                if (eVar3.y() == bVar2 && eVar3.u >= 0 && eVar3.t >= 0 && (eVar3.Q() == 8 || (eVar3.q == 0 && eVar3.t() == 0.0f))) {
                    if (!eVar3.Z() && !eVar3.c0() && z2 && !eVar3.Z()) {
                        e(eVar, interfaceC0070b, eVar3, z);
                    }
                }
            } else if (!eVar3.d0()) {
                c.g.b.k.d dVar8 = eVar3.I;
                if (next2 == dVar8 && eVar3.K.f3057f == null) {
                    int e4 = dVar8.e() + d3;
                    eVar3.p0(e4, eVar3.R() + e4);
                    b(eVar3, interfaceC0070b, z);
                } else {
                    c.g.b.k.d dVar9 = eVar3.K;
                    if (next2 == dVar9 && dVar8.f3057f == null) {
                        int e5 = d3 - dVar9.e();
                        eVar3.p0(e5 - eVar3.R(), e5);
                        b(eVar3, interfaceC0070b, z);
                    } else if (z2 && !eVar3.Z()) {
                        d(interfaceC0070b, eVar3, z);
                    }
                }
            }
        }
    }

    private static void c(c.g.b.k.a aVar, b.InterfaceC0070b interfaceC0070b, int i2, boolean z) {
        if (aVar.c1()) {
            if (i2 == 0) {
                b(aVar, interfaceC0070b, z);
            } else {
                i(aVar, interfaceC0070b);
            }
        }
    }

    private static void d(b.InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar, boolean z) {
        float w = eVar.w();
        int d2 = eVar.I.f3057f.d();
        int d3 = eVar.K.f3057f.d();
        int e2 = eVar.I.e() + d2;
        int e3 = d3 - eVar.K.e();
        if (d2 == d3) {
            w = 0.5f;
        } else {
            d2 = e2;
            d3 = e3;
        }
        int R = eVar.R();
        int i2 = (d3 - d2) - R;
        if (d2 > d3) {
            i2 = (d2 - d3) - R;
        }
        int i3 = ((int) ((w * i2) + 0.5f)) + d2;
        int i4 = i3 + R;
        if (d2 > d3) {
            i4 = i3 - R;
        }
        eVar.p0(i3, i4);
        b(eVar, interfaceC0070b, z);
    }

    private static void e(c.g.b.k.e eVar, b.InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar2, boolean z) {
        int R;
        float w = eVar2.w();
        int d2 = eVar2.I.f3057f.d() + eVar2.I.e();
        int d3 = eVar2.K.f3057f.d() - eVar2.K.e();
        if (d3 >= d2) {
            int R2 = eVar2.R();
            if (eVar2.Q() != 8) {
                int i2 = eVar2.q;
                if (i2 == 2) {
                    if (eVar instanceof c.g.b.k.f) {
                        R = eVar.R();
                    } else {
                        R = eVar.I().R();
                    }
                    R2 = (int) (eVar2.w() * 0.5f * R);
                } else if (i2 == 0) {
                    R2 = d3 - d2;
                }
                R2 = Math.max(eVar2.t, R2);
                int i3 = eVar2.u;
                if (i3 > 0) {
                    R2 = Math.min(i3, R2);
                }
            }
            int i4 = d2 + ((int) ((w * ((d3 - d2) - R2)) + 0.5f));
            eVar2.p0(i4, R2 + i4);
            b(eVar2, interfaceC0070b, z);
        }
    }

    private static void f(b.InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar) {
        float M = eVar.M();
        int d2 = eVar.J.f3057f.d();
        int d3 = eVar.L.f3057f.d();
        int e2 = eVar.J.e() + d2;
        int e3 = d3 - eVar.L.e();
        if (d2 == d3) {
            M = 0.5f;
        } else {
            d2 = e2;
            d3 = e3;
        }
        int v = eVar.v();
        int i2 = (d3 - d2) - v;
        if (d2 > d3) {
            i2 = (d2 - d3) - v;
        }
        int i3 = (int) ((M * i2) + 0.5f);
        int i4 = d2 + i3;
        int i5 = i4 + v;
        if (d2 > d3) {
            i4 = d2 - i3;
            i5 = i4 - v;
        }
        eVar.s0(i4, i5);
        i(eVar, interfaceC0070b);
    }

    private static void g(c.g.b.k.e eVar, b.InterfaceC0070b interfaceC0070b, c.g.b.k.e eVar2) {
        int v;
        float M = eVar2.M();
        int d2 = eVar2.J.f3057f.d() + eVar2.J.e();
        int d3 = eVar2.L.f3057f.d() - eVar2.L.e();
        if (d3 >= d2) {
            int v2 = eVar2.v();
            if (eVar2.Q() != 8) {
                int i2 = eVar2.r;
                if (i2 == 2) {
                    if (eVar instanceof c.g.b.k.f) {
                        v = eVar.v();
                    } else {
                        v = eVar.I().v();
                    }
                    v2 = (int) (M * 0.5f * v);
                } else if (i2 == 0) {
                    v2 = d3 - d2;
                }
                v2 = Math.max(eVar2.w, v2);
                int i3 = eVar2.x;
                if (i3 > 0) {
                    v2 = Math.min(i3, v2);
                }
            }
            int i4 = d2 + ((int) ((M * ((d3 - d2) - v2)) + 0.5f));
            eVar2.s0(i4, v2 + i4);
            i(eVar2, interfaceC0070b);
        }
    }

    public static void h(c.g.b.k.f fVar, b.InterfaceC0070b interfaceC0070b) {
        e.b y = fVar.y();
        e.b O = fVar.O();
        fVar.i0();
        ArrayList<c.g.b.k.e> a1 = fVar.a1();
        int size = a1.size();
        for (int i2 = 0; i2 < size; i2++) {
            a1.get(i2).i0();
        }
        boolean x1 = fVar.x1();
        if (y == e.b.FIXED) {
            fVar.p0(0, fVar.R());
        } else {
            fVar.q0(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            c.g.b.k.e eVar = a1.get(i3);
            if (eVar instanceof c.g.b.k.g) {
                c.g.b.k.g gVar = (c.g.b.k.g) eVar;
                if (gVar.b1() == 1) {
                    if (gVar.c1() != -1) {
                        gVar.f1(gVar.c1());
                    } else if (gVar.d1() != -1 && fVar.e0()) {
                        gVar.f1(fVar.R() - gVar.d1());
                    } else if (fVar.e0()) {
                        gVar.f1((int) ((gVar.e1() * fVar.R()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((eVar instanceof c.g.b.k.a) && ((c.g.b.k.a) eVar).g1() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                c.g.b.k.e eVar2 = a1.get(i4);
                if (eVar2 instanceof c.g.b.k.g) {
                    c.g.b.k.g gVar2 = (c.g.b.k.g) eVar2;
                    if (gVar2.b1() == 1) {
                        b(gVar2, interfaceC0070b, x1);
                    }
                }
            }
        }
        b(fVar, interfaceC0070b, x1);
        if (z2) {
            for (int i5 = 0; i5 < size; i5++) {
                c.g.b.k.e eVar3 = a1.get(i5);
                if (eVar3 instanceof c.g.b.k.a) {
                    c.g.b.k.a aVar = (c.g.b.k.a) eVar3;
                    if (aVar.g1() == 0) {
                        c(aVar, interfaceC0070b, 0, x1);
                    }
                }
            }
        }
        if (O == e.b.FIXED) {
            fVar.s0(0, fVar.v());
        } else {
            fVar.r0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            c.g.b.k.e eVar4 = a1.get(i6);
            if (eVar4 instanceof c.g.b.k.g) {
                c.g.b.k.g gVar3 = (c.g.b.k.g) eVar4;
                if (gVar3.b1() == 0) {
                    if (gVar3.c1() != -1) {
                        gVar3.f1(gVar3.c1());
                    } else if (gVar3.d1() != -1 && fVar.f0()) {
                        gVar3.f1(fVar.v() - gVar3.d1());
                    } else if (fVar.f0()) {
                        gVar3.f1((int) ((gVar3.e1() * fVar.v()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((eVar4 instanceof c.g.b.k.a) && ((c.g.b.k.a) eVar4).g1() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i7 = 0; i7 < size; i7++) {
                c.g.b.k.e eVar5 = a1.get(i7);
                if (eVar5 instanceof c.g.b.k.g) {
                    c.g.b.k.g gVar4 = (c.g.b.k.g) eVar5;
                    if (gVar4.b1() == 0) {
                        i(gVar4, interfaceC0070b);
                    }
                }
            }
        }
        i(fVar, interfaceC0070b);
        if (z4) {
            for (int i8 = 0; i8 < size; i8++) {
                c.g.b.k.e eVar6 = a1.get(i8);
                if (eVar6 instanceof c.g.b.k.a) {
                    c.g.b.k.a aVar2 = (c.g.b.k.a) eVar6;
                    if (aVar2.g1() == 1) {
                        c(aVar2, interfaceC0070b, 1, x1);
                    }
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            c.g.b.k.e eVar7 = a1.get(i9);
            if (eVar7.d0() && a(eVar7)) {
                c.g.b.k.f.A1(eVar7, interfaceC0070b, a, b.a.a);
                b(eVar7, interfaceC0070b, x1);
                i(eVar7, interfaceC0070b);
            }
        }
    }

    private static void i(c.g.b.k.e eVar, b.InterfaceC0070b interfaceC0070b) {
        c.g.b.k.d dVar;
        c.g.b.k.d dVar2;
        c.g.b.k.d dVar3;
        c.g.b.k.d dVar4;
        c.g.b.k.d dVar5;
        if (!(eVar instanceof c.g.b.k.f) && eVar.d0() && a(eVar)) {
            c.g.b.k.f.A1(eVar, interfaceC0070b, new b.a(), b.a.a);
        }
        c.g.b.k.d m = eVar.m(d.b.TOP);
        c.g.b.k.d m2 = eVar.m(d.b.BOTTOM);
        int d2 = m.d();
        int d3 = m2.d();
        if (m.c() != null && m.m()) {
            Iterator<c.g.b.k.d> it = m.c().iterator();
            while (it.hasNext()) {
                c.g.b.k.d next = it.next();
                c.g.b.k.e eVar2 = next.f3055d;
                boolean a2 = a(eVar2);
                if (eVar2.d0() && a2) {
                    c.g.b.k.f.A1(eVar2, interfaceC0070b, new b.a(), b.a.a);
                }
                e.b O = eVar2.O();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (O == bVar && !a2) {
                    if (eVar2.O() == bVar && eVar2.x >= 0 && eVar2.w >= 0 && (eVar2.Q() == 8 || (eVar2.r == 0 && eVar2.t() == 0.0f))) {
                        if (!eVar2.b0() && !eVar2.c0()) {
                            if (((next == eVar2.J && (dVar5 = eVar2.L.f3057f) != null && dVar5.m()) || (next == eVar2.L && (dVar4 = eVar2.J.f3057f) != null && dVar4.m())) && !eVar2.b0()) {
                                g(eVar, interfaceC0070b, eVar2);
                            }
                        }
                    }
                } else if (!eVar2.d0()) {
                    c.g.b.k.d dVar6 = eVar2.J;
                    if (next == dVar6 && eVar2.L.f3057f == null) {
                        int e2 = dVar6.e() + d2;
                        eVar2.s0(e2, eVar2.v() + e2);
                        i(eVar2, interfaceC0070b);
                    } else {
                        c.g.b.k.d dVar7 = eVar2.L;
                        if (next == dVar7 && dVar7.f3057f == null) {
                            int e3 = d2 - dVar7.e();
                            eVar2.s0(e3 - eVar2.v(), e3);
                            i(eVar2, interfaceC0070b);
                        } else if (next == dVar6 && (dVar3 = dVar7.f3057f) != null && dVar3.m()) {
                            f(interfaceC0070b, eVar2);
                        }
                    }
                }
            }
        }
        if (eVar instanceof c.g.b.k.g) {
            return;
        }
        if (m2.c() != null && m2.m()) {
            Iterator<c.g.b.k.d> it2 = m2.c().iterator();
            while (it2.hasNext()) {
                c.g.b.k.d next2 = it2.next();
                c.g.b.k.e eVar3 = next2.f3055d;
                boolean a3 = a(eVar3);
                if (eVar3.d0() && a3) {
                    c.g.b.k.f.A1(eVar3, interfaceC0070b, new b.a(), b.a.a);
                }
                boolean z = (next2 == eVar3.J && (dVar2 = eVar3.L.f3057f) != null && dVar2.m()) || (next2 == eVar3.L && (dVar = eVar3.J.f3057f) != null && dVar.m());
                e.b O2 = eVar3.O();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (O2 == bVar2 && !a3) {
                    if (eVar3.O() == bVar2 && eVar3.x >= 0 && eVar3.w >= 0 && (eVar3.Q() == 8 || (eVar3.r == 0 && eVar3.t() == 0.0f))) {
                        if (!eVar3.b0() && !eVar3.c0() && z && !eVar3.b0()) {
                            g(eVar, interfaceC0070b, eVar3);
                        }
                    }
                } else if (!eVar3.d0()) {
                    c.g.b.k.d dVar8 = eVar3.J;
                    if (next2 == dVar8 && eVar3.L.f3057f == null) {
                        int e4 = dVar8.e() + d3;
                        eVar3.s0(e4, eVar3.v() + e4);
                        i(eVar3, interfaceC0070b);
                    } else {
                        c.g.b.k.d dVar9 = eVar3.L;
                        if (next2 == dVar9 && dVar8.f3057f == null) {
                            int e5 = d3 - dVar9.e();
                            eVar3.s0(e5 - eVar3.v(), e5);
                            i(eVar3, interfaceC0070b);
                        } else if (z && !eVar3.b0()) {
                            f(interfaceC0070b, eVar3);
                        }
                    }
                }
            }
        }
        c.g.b.k.d m3 = eVar.m(d.b.BASELINE);
        if (m3.c() == null || !m3.m()) {
            return;
        }
        int d4 = m3.d();
        Iterator<c.g.b.k.d> it3 = m3.c().iterator();
        while (it3.hasNext()) {
            c.g.b.k.d next3 = it3.next();
            c.g.b.k.e eVar4 = next3.f3055d;
            boolean a4 = a(eVar4);
            if (eVar4.d0() && a4) {
                c.g.b.k.f.A1(eVar4, interfaceC0070b, new b.a(), b.a.a);
            }
            if (eVar4.O() != e.b.MATCH_CONSTRAINT || a4) {
                if (!eVar4.d0() && next3 == eVar4.M) {
                    eVar4.o0(d4);
                    i(eVar4, interfaceC0070b);
                }
            }
        }
    }
}
