package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.q.a.d;
import kotlin.reflect.y.internal.j0.i.w.k;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;

/* compiled from: SubstitutingScope.kt */
/* loaded from: classes3.dex */
public final class m implements h {

    /* renamed from: b, reason: collision with root package name */
    private final h f24427b;

    /* renamed from: c, reason: collision with root package name */
    private final l1 f24428c;

    /* renamed from: d, reason: collision with root package name */
    private Map<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m> f24429d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f24430e;

    /* compiled from: SubstitutingScope.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
            m mVar = m.this;
            return mVar.k(k.a.a(mVar.f24427b, null, null, 3, null));
        }
    }

    public m(h hVar, l1 l1Var) {
        Lazy b2;
        kotlin.jvm.internal.m.f(hVar, "workerScope");
        kotlin.jvm.internal.m.f(l1Var, "givenSubstitutor");
        this.f24427b = hVar;
        j1 j2 = l1Var.j();
        kotlin.jvm.internal.m.e(j2, "givenSubstitutor.substitution");
        this.f24428c = d.f(j2, false, 1, null).c();
        b2 = i.b(new a());
        this.f24430e = b2;
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> j() {
        return (Collection) this.f24430e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> Collection<D> k(Collection<? extends D> collection) {
        if (this.f24428c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g2 = kotlin.reflect.jvm.internal.impl.utils.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g2.add(l((kotlin.reflect.jvm.internal.impl.descriptors.m) it.next()));
        }
        return g2;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> D l(D d2) {
        if (this.f24428c.k()) {
            return d2;
        }
        if (this.f24429d == null) {
            this.f24429d = new HashMap();
        }
        Map<kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.m> map = this.f24429d;
        kotlin.jvm.internal.m.c(map);
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = map.get(d2);
        if (mVar == null) {
            if (!(d2 instanceof b1)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d2).toString());
            }
            mVar = ((b1) d2).c(this.f24428c);
            if (mVar != null) {
                map.put(d2, mVar);
            } else {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
            }
        }
        D d3 = (D) mVar;
        kotlin.jvm.internal.m.d(d3, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d3;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends y0> a(f fVar, b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        return k(this.f24427b.a(fVar, bVar));
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        return this.f24427b.b();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<? extends t0> c(f fVar, b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        return k(this.f24427b.c(fVar, bVar));
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        return this.f24427b.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return this.f24427b.e();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public h f(f fVar, b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        h f2 = this.f24427b.f(fVar, bVar);
        if (f2 != null) {
            return (h) l(f2);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        return j();
    }
}
