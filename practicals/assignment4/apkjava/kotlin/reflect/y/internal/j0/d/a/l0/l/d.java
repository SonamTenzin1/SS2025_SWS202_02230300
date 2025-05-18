package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.j;
import kotlin.reflect.y.internal.j0.k.i;

/* compiled from: JvmPackageScope.kt */
/* loaded from: classes2.dex */
public final class d implements h {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23482b = {g0.h(new y(g0.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: c, reason: collision with root package name */
    private final g f23483c;

    /* renamed from: d, reason: collision with root package name */
    private final h f23484d;

    /* renamed from: e, reason: collision with root package name */
    private final i f23485e;

    /* renamed from: f, reason: collision with root package name */
    private final i f23486f;

    /* compiled from: JvmPackageScope.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<h[]> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h[] invoke() {
            Collection<q> values = d.this.f23484d.N0().values();
            d dVar = d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                h b2 = dVar.f23483c.a().b().b(dVar.f23484d, (q) it.next());
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            Object[] array = kotlin.reflect.y.internal.j0.m.v.a.b(arrayList).toArray(new h[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (h[]) array;
        }
    }

    public d(g gVar, u uVar, h hVar) {
        m.f(gVar, "c");
        m.f(uVar, "jPackage");
        m.f(hVar, "packageFragment");
        this.f23483c = gVar;
        this.f23484d = hVar;
        this.f23485e = new i(gVar, uVar, hVar);
        this.f23486f = gVar.e().d(new a());
    }

    private final h[] k() {
        return (h[]) kotlin.reflect.y.internal.j0.k.m.a(this.f23486f, this, f23482b[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, b bVar) {
        Set d2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        i iVar = this.f23485e;
        h[] k2 = k();
        Collection<? extends y0> a2 = iVar.a(fVar, bVar);
        int length = k2.length;
        int i2 = 0;
        Collection collection = a2;
        while (i2 < length) {
            Collection a3 = kotlin.reflect.y.internal.j0.m.v.a.a(collection, k2[i2].a(fVar, bVar));
            i2++;
            collection = a3;
        }
        if (collection != null) {
            return collection;
        }
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        h[] k2 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : k2) {
            z.z(linkedHashSet, hVar.b());
        }
        linkedHashSet.addAll(this.f23485e.b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, b bVar) {
        Set d2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        i iVar = this.f23485e;
        h[] k2 = k();
        Collection<? extends t0> c2 = iVar.c(fVar, bVar);
        int length = k2.length;
        int i2 = 0;
        Collection collection = c2;
        while (i2 < length) {
            Collection a2 = kotlin.reflect.y.internal.j0.m.v.a.a(collection, k2[i2].c(fVar, bVar));
            i2++;
            collection = a2;
        }
        if (collection != null) {
            return collection;
        }
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        h[] k2 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (h hVar : k2) {
            z.z(linkedHashSet, hVar.d());
        }
        linkedHashSet.addAll(this.f23485e.d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        Iterable q;
        q = n.q(k());
        Set<f> a2 = j.a(q);
        if (a2 == null) {
            return null;
        }
        a2.addAll(this.f23485e.e());
        return a2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        l(fVar, bVar);
        e f2 = this.f23485e.f(fVar, bVar);
        if (f2 != null) {
            return f2;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = null;
        for (h hVar2 : k()) {
            kotlin.reflect.jvm.internal.impl.descriptors.h f3 = hVar2.f(fVar, bVar);
            if (f3 != null) {
                if (!(f3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i) || !((kotlin.reflect.jvm.internal.impl.descriptors.i) f3).M()) {
                    return f3;
                }
                if (hVar == null) {
                    hVar = f3;
                }
            }
        }
        return hVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set d2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        i iVar = this.f23485e;
        h[] k2 = k();
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g2 = iVar.g(dVar, function1);
        for (h hVar : k2) {
            g2 = kotlin.reflect.y.internal.j0.m.v.a.a(g2, hVar.g(dVar, function1));
        }
        if (g2 != null) {
            return g2;
        }
        d2 = w0.d();
        return d2;
    }

    public final i j() {
        return this.f23485e;
    }

    public void l(f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.y.internal.j0.c.a.b(this.f23483c.a().l(), bVar, this.f23484d, fVar);
    }

    public String toString() {
        return "scope for " + this.f23484d;
    }
}
