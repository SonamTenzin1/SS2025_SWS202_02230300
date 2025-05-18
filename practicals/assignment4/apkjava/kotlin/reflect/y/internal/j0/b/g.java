package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.n0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.j;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.b.p.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.v;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* compiled from: functionTypes.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final int a(e0 e0Var) {
        m.f(e0Var, "<this>");
        c l = e0Var.getAnnotations().l(k.a.D);
        if (l == null) {
            return 0;
        }
        kotlin.reflect.y.internal.j0.i.r.g gVar = (kotlin.reflect.y.internal.j0.i.r.g) n0.j(l.a(), k.f23198i);
        m.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.reflect.y.internal.j0.i.r.m) gVar).b().intValue();
    }

    public static final m0 b(h hVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, e0 e0Var, List<? extends e0> list, List<? extends e0> list2, List<f> list3, e0 e0Var2, boolean z) {
        m.f(hVar, "builtIns");
        m.f(gVar, "annotations");
        m.f(list, "contextReceiverTypes");
        m.f(list2, "parameterTypes");
        m.f(e0Var2, "returnType");
        List<g1> g2 = g(e0Var, list, list2, list3, e0Var2, hVar);
        e f2 = f(hVar, list2.size() + list.size() + (e0Var == null ? 0 : 1), z);
        if (e0Var != null) {
            gVar = t(gVar, hVar);
        }
        if (!list.isEmpty()) {
            gVar = s(gVar, hVar, list.size());
        }
        return f0.g(b1.b(gVar), f2, g2);
    }

    public static final f d(e0 e0Var) {
        String b2;
        m.f(e0Var, "<this>");
        c l = e0Var.getAnnotations().l(k.a.E);
        if (l == null) {
            return null;
        }
        Object t0 = s.t0(l.a().values());
        v vVar = t0 instanceof v ? (v) t0 : null;
        if (vVar != null && (b2 = vVar.b()) != null) {
            if (!f.A(b2)) {
                b2 = null;
            }
            if (b2 != null) {
                return f.x(b2);
            }
        }
        return null;
    }

    public static final List<e0> e(e0 e0Var) {
        int u;
        List<e0> j2;
        m.f(e0Var, "<this>");
        o(e0Var);
        int a = a(e0Var);
        if (a == 0) {
            j2 = u.j();
            return j2;
        }
        List<g1> subList = e0Var.M0().subList(0, a);
        u = kotlin.collections.v.u(subList, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = subList.iterator();
        while (it.hasNext()) {
            e0 type = ((g1) it.next()).getType();
            m.e(type, "it.type");
            arrayList.add(type);
        }
        return arrayList;
    }

    public static final e f(h hVar, int i2, boolean z) {
        m.f(hVar, "builtIns");
        e X = z ? hVar.X(i2) : hVar.C(i2);
        m.e(X, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return X;
    }

    public static final List<g1> g(e0 e0Var, List<? extends e0> list, List<? extends e0> list2, List<f> list3, e0 e0Var2, h hVar) {
        int u;
        f fVar;
        Map f2;
        List<? extends c> n0;
        m.f(list, "contextReceiverTypes");
        m.f(list2, "parameterTypes");
        m.f(e0Var2, "returnType");
        m.f(hVar, "builtIns");
        int i2 = 0;
        ArrayList arrayList = new ArrayList(list2.size() + list.size() + (e0Var != null ? 1 : 0) + 1);
        u = kotlin.collections.v.u(list, 10);
        ArrayList arrayList2 = new ArrayList(u);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(a.a((e0) it.next()));
        }
        arrayList.addAll(arrayList2);
        kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, e0Var != null ? a.a(e0Var) : null);
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            e0 e0Var3 = (e0) obj;
            if (list3 == null || (fVar = list3.get(i2)) == null || fVar.y()) {
                fVar = null;
            }
            if (fVar != null) {
                kotlin.reflect.y.internal.j0.f.c cVar = k.a.E;
                f x = f.x("name");
                String k2 = fVar.k();
                m.e(k2, "name.asString()");
                f2 = p0.f(kotlin.s.a(x, new v(k2)));
                j jVar = new j(hVar, cVar, f2);
                g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
                n0 = c0.n0(e0Var3.getAnnotations(), jVar);
                e0Var3 = a.u(e0Var3, aVar.a(n0));
            }
            arrayList.add(a.a(e0Var3));
            i2 = i3;
        }
        arrayList.add(a.a(e0Var2));
        return arrayList;
    }

    public static final kotlin.reflect.y.internal.j0.b.p.c h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        if ((mVar instanceof e) && h.A0(mVar)) {
            return i(kotlin.reflect.y.internal.j0.i.t.a.i(mVar));
        }
        return null;
    }

    private static final kotlin.reflect.y.internal.j0.b.p.c i(d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        c.a aVar = kotlin.reflect.y.internal.j0.b.p.c.f23232f;
        String k2 = dVar.i().k();
        m.e(k2, "shortName().asString()");
        kotlin.reflect.y.internal.j0.f.c e2 = dVar.l().e();
        m.e(e2, "toSafe().parent()");
        return aVar.b(k2, e2);
    }

    public static final e0 j(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        if (!r(e0Var)) {
            return null;
        }
        return e0Var.M0().get(a(e0Var)).getType();
    }

    public static final e0 k(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        e0 type = ((g1) s.g0(e0Var.M0())).getType();
        m.e(type, "arguments.last().type");
        return type;
    }

    public static final List<g1> l(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        return e0Var.M0().subList(a(e0Var) + (m(e0Var) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean m(e0 e0Var) {
        m.f(e0Var, "<this>");
        return o(e0Var) && r(e0Var);
    }

    public static final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.reflect.y.internal.j0.b.p.c h2 = h(mVar);
        return h2 == kotlin.reflect.y.internal.j0.b.p.c.f23233g || h2 == kotlin.reflect.y.internal.j0.b.p.c.f23234h;
    }

    public static final boolean o(e0 e0Var) {
        m.f(e0Var, "<this>");
        h w = e0Var.O0().w();
        return w != null && n(w);
    }

    public static final boolean p(e0 e0Var) {
        m.f(e0Var, "<this>");
        h w = e0Var.O0().w();
        return (w != null ? h(w) : null) == kotlin.reflect.y.internal.j0.b.p.c.f23233g;
    }

    public static final boolean q(e0 e0Var) {
        m.f(e0Var, "<this>");
        h w = e0Var.O0().w();
        return (w != null ? h(w) : null) == kotlin.reflect.y.internal.j0.b.p.c.f23234h;
    }

    private static final boolean r(e0 e0Var) {
        return e0Var.getAnnotations().l(k.a.C) != null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.n1.g s(kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, h hVar, int i2) {
        Map f2;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> n0;
        m.f(gVar, "<this>");
        m.f(hVar, "builtIns");
        kotlin.reflect.y.internal.j0.f.c cVar = k.a.D;
        if (gVar.R0(cVar)) {
            return gVar;
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
        f2 = p0.f(kotlin.s.a(k.f23198i, new kotlin.reflect.y.internal.j0.i.r.m(i2)));
        n0 = c0.n0(gVar, new j(hVar, cVar, f2));
        return aVar.a(n0);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.n1.g t(kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, h hVar) {
        Map i2;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> n0;
        m.f(gVar, "<this>");
        m.f(hVar, "builtIns");
        kotlin.reflect.y.internal.j0.f.c cVar = k.a.C;
        if (gVar.R0(cVar)) {
            return gVar;
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
        i2 = q0.i();
        n0 = c0.n0(gVar, new j(hVar, cVar, i2));
        return aVar.a(n0);
    }
}
