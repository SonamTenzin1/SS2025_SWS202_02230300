package kotlin.reflect.y.internal.j0.i.w;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.y.internal.j0.c.b.b;

/* compiled from: InnerClassesScopeWrapper.kt */
/* loaded from: classes3.dex */
public final class f extends i {

    /* renamed from: b, reason: collision with root package name */
    private final h f24417b;

    public f(h hVar) {
        m.f(hVar, "workerScope");
        this.f24417b = hVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> b() {
        return this.f24417b.b();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> d() {
        return this.f24417b.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> e() {
        return this.f24417b.e();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public h f(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        h f2 = this.f24417b.f(fVar, bVar);
        if (f2 == null) {
            return null;
        }
        e eVar = f2 instanceof e ? (e) f2 : null;
        if (eVar != null) {
            return eVar;
        }
        if (f2 instanceof d1) {
            return (d1) f2;
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<h> g(d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List<h> j2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        d n = dVar.n(d.a.c());
        if (n == null) {
            j2 = u.j();
            return j2;
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g2 = this.f24417b.g(n, function1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : g2) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "Classes from " + this.f24417b;
    }
}
