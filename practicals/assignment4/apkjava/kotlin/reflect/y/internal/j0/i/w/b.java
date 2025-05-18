package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;

/* compiled from: ChainedMemberScope.kt */
/* loaded from: classes3.dex */
public final class b implements h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f24397b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final String f24398c;

    /* renamed from: d, reason: collision with root package name */
    private final h[] f24399d;

    /* compiled from: ChainedMemberScope.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(String str, Iterable<? extends h> iterable) {
            m.f(str, "debugName");
            m.f(iterable, "scopes");
            e eVar = new e();
            for (h hVar : iterable) {
                if (hVar != h.b.f24422b) {
                    if (hVar instanceof b) {
                        z.A(eVar, ((b) hVar).f24399d);
                    } else {
                        eVar.add(hVar);
                    }
                }
            }
            return b(str, eVar);
        }

        public final h b(String str, List<? extends h> list) {
            m.f(str, "debugName");
            m.f(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return h.b.f24422b;
            }
            if (size != 1) {
                Object[] array = list.toArray(new h[0]);
                m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return new b(str, (h[]) array, null);
            }
            return list.get(0);
        }
    }

    private b(String str, h[] hVarArr) {
        this.f24398c = str;
        this.f24399d = hVarArr;
    }

    public /* synthetic */ b(String str, h[] hVarArr, g gVar) {
        this(str, hVarArr);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        List j2;
        Set d2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            j2 = u.j();
            return j2;
        }
        if (length != 1) {
            Collection<y0> collection = null;
            for (h hVar : hVarArr) {
                collection = kotlin.reflect.y.internal.j0.m.v.a.a(collection, hVar.a(fVar, bVar));
            }
            if (collection != null) {
                return collection;
            }
            d2 = w0.d();
            return d2;
        }
        return hVarArr[0].a(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        h[] hVarArr = this.f24399d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            z.z(linkedHashSet, hVar.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        List j2;
        Set d2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            j2 = u.j();
            return j2;
        }
        if (length != 1) {
            Collection<t0> collection = null;
            for (h hVar : hVarArr) {
                collection = kotlin.reflect.y.internal.j0.m.v.a.a(collection, hVar.c(fVar, bVar));
            }
            if (collection != null) {
                return collection;
            }
            d2 = w0.d();
            return d2;
        }
        return hVarArr[0].c(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        h[] hVarArr = this.f24399d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : hVarArr) {
            z.z(linkedHashSet, hVar.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        Iterable q;
        q = n.q(this.f24399d);
        return j.a(q);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = null;
        for (h hVar2 : this.f24399d) {
            kotlin.reflect.jvm.internal.impl.descriptors.h f2 = hVar2.f(fVar, bVar);
            if (f2 != null) {
                if (!(f2 instanceof i) || !((i) f2).M()) {
                    return f2;
                }
                if (hVar == null) {
                    hVar = f2;
                }
            }
        }
        return hVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super f, Boolean> function1) {
        List j2;
        Set d2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        h[] hVarArr = this.f24399d;
        int length = hVarArr.length;
        if (length == 0) {
            j2 = u.j();
            return j2;
        }
        if (length != 1) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection = null;
            for (h hVar : hVarArr) {
                collection = kotlin.reflect.y.internal.j0.m.v.a.a(collection, hVar.g(dVar, function1));
            }
            if (collection != null) {
                return collection;
            }
            d2 = w0.d();
            return d2;
        }
        return hVarArr[0].g(dVar, function1);
    }

    public String toString() {
        return this.f24398c;
    }
}
