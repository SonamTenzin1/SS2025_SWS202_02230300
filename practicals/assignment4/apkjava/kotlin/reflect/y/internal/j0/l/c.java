package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.d1;
import kotlin.reflect.y.internal.j0.l.w1.d;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.p;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final boolean c(d1 d1Var, k kVar, n nVar) {
        p j2 = d1Var.j();
        if (j2.f0(kVar)) {
            return true;
        }
        if (j2.W(kVar)) {
            return false;
        }
        if (d1Var.n() && j2.n0(kVar)) {
            return true;
        }
        return j2.A0(j2.c(kVar), nVar);
    }

    private final boolean e(d1 d1Var, k kVar, k kVar2) {
        p j2 = d1Var.j();
        if (f.f24705b) {
            if (!j2.b(kVar) && !j2.Z(j2.c(kVar))) {
                d1Var.l(kVar);
            }
            if (!j2.b(kVar2)) {
                d1Var.l(kVar2);
            }
        }
        if (j2.W(kVar2) || j2.C(kVar) || j2.I(kVar)) {
            return true;
        }
        if ((kVar instanceof d) && j2.k((d) kVar)) {
            return true;
        }
        c cVar = a;
        if (cVar.a(d1Var, kVar, d1.c.b.a)) {
            return true;
        }
        if (j2.C(kVar2) || cVar.a(d1Var, kVar2, d1.c.d.a) || j2.v0(kVar)) {
            return false;
        }
        return cVar.b(d1Var, kVar, j2.c(kVar2));
    }

    public final boolean a(d1 d1Var, k kVar, d1.c cVar) {
        String e0;
        m.f(d1Var, "<this>");
        m.f(kVar, "type");
        m.f(cVar, "supertypesPolicy");
        p j2 = d1Var.j();
        if (!((j2.v0(kVar) && !j2.W(kVar)) || j2.C(kVar))) {
            d1Var.k();
            ArrayDeque<k> h2 = d1Var.h();
            m.c(h2);
            Set<k> i2 = d1Var.i();
            m.c(i2);
            h2.push(kVar);
            while (!h2.isEmpty()) {
                if (i2.size() <= 1000) {
                    k pop = h2.pop();
                    m.e(pop, "current");
                    if (i2.add(pop)) {
                        d1.c cVar2 = j2.W(pop) ? d1.c.C0394c.a : cVar;
                        if (!(!m.a(cVar2, d1.c.C0394c.a))) {
                            cVar2 = null;
                        }
                        if (cVar2 == null) {
                            continue;
                        } else {
                            p j3 = d1Var.j();
                            Iterator<i> it = j3.t(j3.c(pop)).iterator();
                            while (it.hasNext()) {
                                k a2 = cVar2.a(d1Var, it.next());
                                if ((j2.v0(a2) && !j2.W(a2)) || j2.C(a2)) {
                                    d1Var.e();
                                } else {
                                    h2.add(a2);
                                }
                            }
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many supertypes for type: ");
                    sb.append(kVar);
                    sb.append(". Supertypes = ");
                    e0 = c0.e0(i2, null, null, null, 0, null, null, 63, null);
                    sb.append(e0);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            d1Var.e();
            return false;
        }
        return true;
    }

    public final boolean b(d1 d1Var, k kVar, n nVar) {
        String e0;
        m.f(d1Var, "state");
        m.f(kVar, "start");
        m.f(nVar, "end");
        p j2 = d1Var.j();
        if (a.c(d1Var, kVar, nVar)) {
            return true;
        }
        d1Var.k();
        ArrayDeque<k> h2 = d1Var.h();
        m.c(h2);
        Set<k> i2 = d1Var.i();
        m.c(i2);
        h2.push(kVar);
        while (!h2.isEmpty()) {
            if (i2.size() <= 1000) {
                k pop = h2.pop();
                m.e(pop, "current");
                if (i2.add(pop)) {
                    d1.c cVar = j2.W(pop) ? d1.c.C0394c.a : d1.c.b.a;
                    if (!(!m.a(cVar, d1.c.C0394c.a))) {
                        cVar = null;
                    }
                    if (cVar == null) {
                        continue;
                    } else {
                        p j3 = d1Var.j();
                        Iterator<i> it = j3.t(j3.c(pop)).iterator();
                        while (it.hasNext()) {
                            k a2 = cVar.a(d1Var, it.next());
                            if (a.c(d1Var, a2, nVar)) {
                                d1Var.e();
                                return true;
                            }
                            h2.add(a2);
                        }
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(kVar);
                sb.append(". Supertypes = ");
                e0 = c0.e0(i2, null, null, null, 0, null, null, 63, null);
                sb.append(e0);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        d1Var.e();
        return false;
    }

    public final boolean d(d1 d1Var, k kVar, k kVar2) {
        m.f(d1Var, "state");
        m.f(kVar, "subType");
        m.f(kVar2, "superType");
        return e(d1Var, kVar, kVar2);
    }
}
