package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.utils.d;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: MemberScopeImpl.kt */
/* loaded from: classes3.dex */
public abstract class i implements h {
    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends y0> a(f fVar, b bVar) {
        List j2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g2 = g(d.t, d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : g2) {
            if (obj instanceof y0) {
                f name = ((y0) obj).getName();
                m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends t0> c(f fVar, b bVar) {
        List j2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g2 = g(d.u, d.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : g2) {
            if (obj instanceof y0) {
                f name = ((y0) obj).getName();
                m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        List j2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        j2 = u.j();
        return j2;
    }
}
