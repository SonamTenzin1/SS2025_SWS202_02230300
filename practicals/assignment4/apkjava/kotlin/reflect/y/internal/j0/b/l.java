package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.y;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* compiled from: suspendFunctionTypes.kt */
/* loaded from: classes2.dex */
public final class l {
    private static final y a;

    static {
        List<e1> e2;
        m mVar = new m(k.a.i(), k.f23199j);
        f fVar = f.INTERFACE;
        kotlin.reflect.y.internal.j0.f.f g2 = k.m.g();
        z0 z0Var = z0.a;
        n nVar = kotlin.reflect.y.internal.j0.k.f.f24650b;
        y yVar = new y(mVar, fVar, false, false, g2, z0Var, nVar);
        yVar.N0(d0.ABSTRACT);
        yVar.P0(t.f25368e);
        e2 = kotlin.collections.t.e(k0.S0(yVar, g.f25179c.b(), false, r1.IN_VARIANCE, kotlin.reflect.y.internal.j0.f.f.x("T"), 0, nVar));
        yVar.O0(e2);
        yVar.L0();
        a = yVar;
    }

    public static final m0 a(e0 e0Var) {
        int u;
        List e2;
        List p0;
        m0 b2;
        kotlin.jvm.internal.m.f(e0Var, "suspendFunType");
        g.q(e0Var);
        h h2 = a.h(e0Var);
        g annotations = e0Var.getAnnotations();
        e0 j2 = g.j(e0Var);
        List<e0> e3 = g.e(e0Var);
        List<g1> l = g.l(e0Var);
        u = v.u(l, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = l.iterator();
        while (it.hasNext()) {
            arrayList.add(((g1) it.next()).getType());
        }
        a1 h3 = a1.f24676g.h();
        kotlin.reflect.y.internal.j0.l.e1 h4 = a.h();
        kotlin.jvm.internal.m.e(h4, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        e2 = kotlin.collections.t.e(a.a(g.k(e0Var)));
        p0 = c0.p0(arrayList, f0.i(h3, h4, e2, false, null, 16, null));
        m0 I = a.h(e0Var).I();
        kotlin.jvm.internal.m.e(I, "suspendFunType.builtIns.nullableAnyType");
        b2 = g.b(h2, annotations, j2, e3, p0, null, I, (r17 & 128) != 0 ? false : false);
        return b2.S0(e0Var.P0());
    }
}
