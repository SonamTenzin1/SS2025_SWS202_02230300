package kotlin.reflect.y.internal.j0.d.a.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.l0.l.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: util.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final List<i1> a(Collection<? extends e0> collection, Collection<? extends i1> collection2, a aVar) {
        List<Pair> L0;
        int u;
        m.f(collection, "newValueParameterTypes");
        m.f(collection2, "oldValueParameters");
        m.f(aVar, "newOwner");
        collection.size();
        collection2.size();
        L0 = c0.L0(collection, collection2);
        u = v.u(L0, 10);
        ArrayList arrayList = new ArrayList(u);
        for (Pair pair : L0) {
            e0 e0Var = (e0) pair.a();
            i1 i1Var = (i1) pair.b();
            int g2 = i1Var.g();
            g annotations = i1Var.getAnnotations();
            f name = i1Var.getName();
            m.e(name, "oldParameter.name");
            boolean u0 = i1Var.u0();
            boolean b0 = i1Var.b0();
            boolean Y = i1Var.Y();
            e0 k2 = i1Var.l0() != null ? kotlin.reflect.y.internal.j0.i.t.a.l(aVar).o().k(e0Var) : null;
            z0 t = i1Var.t();
            m.e(t, "oldParameter.source");
            arrayList.add(new l0(aVar, null, g2, annotations, name, e0Var, u0, b0, Y, k2, t));
        }
        return arrayList;
    }

    public static final k b(e eVar) {
        m.f(eVar, "<this>");
        e p = kotlin.reflect.y.internal.j0.i.t.a.p(eVar);
        if (p == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.i.w.h S = p.S();
        k kVar = S instanceof k ? (k) S : null;
        return kVar == null ? b(p) : kVar;
    }
}
