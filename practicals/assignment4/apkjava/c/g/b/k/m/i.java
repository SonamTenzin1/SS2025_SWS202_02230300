package c.g.b.k.m;

import c.g.b.k.d;
import c.g.b.k.e;
import c.g.b.k.m.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Grouping.java */
/* loaded from: classes.dex */
public class i {
    public static o a(c.g.b.k.e eVar, int i2, ArrayList<o> arrayList, o oVar) {
        int i3;
        int b1;
        if (i2 == 0) {
            i3 = eVar.B0;
        } else {
            i3 = eVar.C0;
        }
        if (i3 != -1 && (oVar == null || i3 != oVar.f3130c)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i4);
                if (oVar2.c() == i3) {
                    if (oVar != null) {
                        oVar.g(i2, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i4++;
                }
            }
        } else if (i3 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof c.g.b.k.i) && (b1 = ((c.g.b.k.i) eVar).b1(i2)) != -1) {
                int i5 = 0;
                while (true) {
                    if (i5 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i5);
                    if (oVar3.c() == b1) {
                        oVar = oVar3;
                        break;
                    }
                    i5++;
                }
            }
            if (oVar == null) {
                oVar = new o(i2);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof c.g.b.k.g) {
                c.g.b.k.g gVar = (c.g.b.k.g) eVar;
                gVar.a1().b(gVar.b1() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i2 == 0) {
                eVar.B0 = oVar.c();
                eVar.I.b(i2, arrayList, oVar);
                eVar.K.b(i2, arrayList, oVar);
            } else {
                eVar.C0 = oVar.c();
                eVar.J.b(i2, arrayList, oVar);
                eVar.M.b(i2, arrayList, oVar);
                eVar.L.b(i2, arrayList, oVar);
            }
            eVar.P.b(i2, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = arrayList.get(i3);
            if (i2 == oVar.f3130c) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0384 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0380  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(c.g.b.k.f fVar, b.InterfaceC0070b interfaceC0070b) {
        o oVar;
        o oVar2;
        ArrayList<c.g.b.k.e> a1 = fVar.a1();
        int size = a1.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.g.b.k.e eVar = a1.get(i2);
            if (!d(fVar.y(), fVar.O(), eVar.y(), eVar.O())) {
                return false;
            }
        }
        if (fVar.I0 != null) {
            throw null;
        }
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        for (int i3 = 0; i3 < size; i3++) {
            c.g.b.k.e eVar2 = a1.get(i3);
            if (!d(fVar.y(), fVar.O(), eVar2.y(), eVar2.O())) {
                c.g.b.k.f.A1(eVar2, interfaceC0070b, fVar.g1, b.a.a);
            }
            boolean z = eVar2 instanceof c.g.b.k.g;
            if (z) {
                c.g.b.k.g gVar = (c.g.b.k.g) eVar2;
                if (gVar.b1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(gVar);
                }
                if (gVar.b1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(gVar);
                }
            }
            if (eVar2 instanceof c.g.b.k.i) {
                if (eVar2 instanceof c.g.b.k.a) {
                    c.g.b.k.a aVar = (c.g.b.k.a) eVar2;
                    if (aVar.g1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.g1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    c.g.b.k.i iVar = (c.g.b.k.i) eVar2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(iVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(iVar);
                }
            }
            if (eVar2.I.f3057f == null && eVar2.K.f3057f == null && !z && !(eVar2 instanceof c.g.b.k.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(eVar2);
            }
            if (eVar2.J.f3057f == null && eVar2.L.f3057f == null && eVar2.M.f3057f == null && !z && !(eVar2 instanceof c.g.b.k.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(eVar2);
            }
        }
        ArrayList<o> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((c.g.b.k.g) it.next(), 0, arrayList7, null);
            }
        }
        int i4 = 0;
        o oVar3 = null;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c.g.b.k.i iVar2 = (c.g.b.k.i) it2.next();
                o a = a(iVar2, i4, arrayList7, oVar3);
                iVar2.a1(arrayList7, i4, a);
                a.b(arrayList7);
                i4 = 0;
                oVar3 = null;
            }
        }
        c.g.b.k.d m = fVar.m(d.b.LEFT);
        if (m.c() != null) {
            Iterator<c.g.b.k.d> it3 = m.c().iterator();
            while (it3.hasNext()) {
                a(it3.next().f3055d, 0, arrayList7, null);
            }
        }
        c.g.b.k.d m2 = fVar.m(d.b.RIGHT);
        if (m2.c() != null) {
            Iterator<c.g.b.k.d> it4 = m2.c().iterator();
            while (it4.hasNext()) {
                a(it4.next().f3055d, 0, arrayList7, null);
            }
        }
        c.g.b.k.d m3 = fVar.m(d.b.CENTER);
        if (m3.c() != null) {
            Iterator<c.g.b.k.d> it5 = m3.c().iterator();
            while (it5.hasNext()) {
                a(it5.next().f3055d, 0, arrayList7, null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                a((c.g.b.k.e) it6.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it7 = arrayList3.iterator();
            while (it7.hasNext()) {
                a((c.g.b.k.g) it7.next(), 1, arrayList7, null);
            }
        }
        if (arrayList4 != null) {
            Iterator it8 = arrayList4.iterator();
            while (it8.hasNext()) {
                c.g.b.k.i iVar3 = (c.g.b.k.i) it8.next();
                o a2 = a(iVar3, 1, arrayList7, oVar4);
                iVar3.a1(arrayList7, 1, a2);
                a2.b(arrayList7);
                oVar4 = null;
            }
        }
        c.g.b.k.d m4 = fVar.m(d.b.TOP);
        if (m4.c() != null) {
            Iterator<c.g.b.k.d> it9 = m4.c().iterator();
            while (it9.hasNext()) {
                a(it9.next().f3055d, 1, arrayList7, null);
            }
        }
        c.g.b.k.d m5 = fVar.m(d.b.BASELINE);
        if (m5.c() != null) {
            Iterator<c.g.b.k.d> it10 = m5.c().iterator();
            while (it10.hasNext()) {
                a(it10.next().f3055d, 1, arrayList7, null);
            }
        }
        c.g.b.k.d m6 = fVar.m(d.b.BOTTOM);
        if (m6.c() != null) {
            Iterator<c.g.b.k.d> it11 = m6.c().iterator();
            while (it11.hasNext()) {
                a(it11.next().f3055d, 1, arrayList7, null);
            }
        }
        c.g.b.k.d m7 = fVar.m(d.b.CENTER);
        if (m7.c() != null) {
            Iterator<c.g.b.k.d> it12 = m7.c().iterator();
            while (it12.hasNext()) {
                a(it12.next().f3055d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it13 = arrayList6.iterator();
            while (it13.hasNext()) {
                a((c.g.b.k.e) it13.next(), 1, arrayList7, null);
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            c.g.b.k.e eVar3 = a1.get(i5);
            if (eVar3.g0()) {
                o b2 = b(arrayList7, eVar3.B0);
                o b3 = b(arrayList7, eVar3.C0);
                if (b2 != null && b3 != null) {
                    b2.g(0, b3);
                    b3.i(2);
                    arrayList7.remove(b2);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (fVar.y() == e.b.WRAP_CONTENT) {
            Iterator<o> it14 = arrayList7.iterator();
            int i6 = 0;
            oVar = null;
            while (it14.hasNext()) {
                o next = it14.next();
                if (next.d() != 1) {
                    next.h(false);
                    int f2 = next.f(fVar.t1(), 0);
                    if (f2 > i6) {
                        oVar = next;
                        i6 = f2;
                    }
                }
            }
            if (oVar != null) {
                fVar.z0(e.b.FIXED);
                fVar.U0(i6);
                oVar.h(true);
                if (fVar.O() != e.b.WRAP_CONTENT) {
                    Iterator<o> it15 = arrayList7.iterator();
                    o oVar5 = null;
                    int i7 = 0;
                    while (it15.hasNext()) {
                        o next2 = it15.next();
                        if (next2.d() != 0) {
                            next2.h(false);
                            int f3 = next2.f(fVar.t1(), 1);
                            if (f3 > i7) {
                                oVar5 = next2;
                                i7 = f3;
                            }
                        }
                    }
                    if (oVar5 != null) {
                        fVar.Q0(e.b.FIXED);
                        fVar.v0(i7);
                        oVar5.h(true);
                        oVar2 = oVar5;
                        return oVar == null || oVar2 != null;
                    }
                }
                oVar2 = null;
                if (oVar == null) {
                }
            }
        }
        oVar = null;
        if (fVar.O() != e.b.WRAP_CONTENT) {
        }
        oVar2 = null;
        if (oVar == null) {
        }
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
