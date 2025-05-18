package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.i.w.c;

/* compiled from: SubpackagesScope.kt */
/* loaded from: classes2.dex */
public class h0 extends kotlin.reflect.y.internal.j0.i.w.i {

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.g0 f25241b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f25242c;

    public h0(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(g0Var, "moduleDescriptor");
        kotlin.jvm.internal.m.f(cVar, "fqName");
        this.f25241b = g0Var;
        this.f25242c = cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> e() {
        Set<kotlin.reflect.y.internal.j0.f.f> d2;
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List j2;
        List j3;
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        if (!dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.f())) {
            j3 = kotlin.collections.u.j();
            return j3;
        }
        if (this.f25242c.d() && dVar.l().contains(c.b.a)) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        Collection<kotlin.reflect.y.internal.j0.f.c> p = this.f25241b.p(this.f25242c, function1);
        ArrayList arrayList = new ArrayList(p.size());
        Iterator<kotlin.reflect.y.internal.j0.f.c> it = p.iterator();
        while (it.hasNext()) {
            kotlin.reflect.y.internal.j0.f.f g2 = it.next().g();
            kotlin.jvm.internal.m.e(g2, "subFqName.shortName()");
            if (function1.invoke(g2).booleanValue()) {
                kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, h(g2));
            }
        }
        return arrayList;
    }

    protected final p0 h(kotlin.reflect.y.internal.j0.f.f fVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        if (fVar.y()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var = this.f25241b;
        kotlin.reflect.y.internal.j0.f.c c2 = this.f25242c.c(fVar);
        kotlin.jvm.internal.m.e(c2, "fqName.child(name)");
        p0 N = g0Var.N(c2);
        if (N.isEmpty()) {
            return null;
        }
        return N;
    }

    public String toString() {
        return "subpackages of " + this.f25242c + " from " + this.f25241b;
    }
}
