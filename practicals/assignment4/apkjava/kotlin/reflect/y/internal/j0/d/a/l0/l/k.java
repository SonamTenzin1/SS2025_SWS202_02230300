package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.sequences.Sequence;
import kotlin.sequences.n;
import kotlin.u;

/* compiled from: LazyJavaStaticClassScope.kt */
/* loaded from: classes2.dex */
public final class k extends l {
    private final g n;
    private final f o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<q, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23557f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q qVar) {
            m.f(qVar, "it");
            return Boolean.valueOf(qVar.Q());
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<h, Collection<? extends t0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f23558f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(1);
            this.f23558f = fVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<? extends t0> invoke(h hVar) {
            m.f(hVar, "it");
            return hVar.c(this.f23558f, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function1<h, Collection<? extends f>> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f23559f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<f> invoke(h hVar) {
            m.f(hVar, "it");
            return hVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: classes2.dex */
    public static final class d<N> implements b.c {
        public static final d<N> a = new d<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LazyJavaStaticClassScope.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function1<e0, kotlin.reflect.jvm.internal.impl.descriptors.e> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f23560f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke(e0 e0Var) {
                kotlin.reflect.jvm.internal.impl.descriptors.h w = e0Var.O0().w();
                if (w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                    return (kotlin.reflect.jvm.internal.impl.descriptors.e) w;
                }
                return null;
            }
        }

        d() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.reflect.jvm.internal.impl.descriptors.e> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            Sequence J;
            Sequence v;
            Iterable<kotlin.reflect.jvm.internal.impl.descriptors.e> i2;
            Collection<e0> a2 = eVar.h().a();
            m.e(a2, "it.typeConstructor.supertypes");
            J = c0.J(a2);
            v = n.v(J, a.f23560f);
            i2 = n.i(v);
            return i2;
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* loaded from: classes2.dex */
    public static final class e extends b.AbstractC0417b<kotlin.reflect.jvm.internal.impl.descriptors.e, u> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f23561b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<h, Collection<R>> f23562c;

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, Function1<? super h, ? extends Collection<? extends R>> function1) {
            this.a = eVar;
            this.f23561b = set;
            this.f23562c = function1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return u.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            m.f(eVar, "current");
            if (eVar == this.a) {
                return true;
            }
            h S = eVar.S();
            m.e(S, "current.staticScope");
            if (!(S instanceof l)) {
                return true;
            }
            this.f23561b.addAll((Collection) this.f23562c.invoke(S));
            return false;
        }

        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, g gVar2, f fVar) {
        super(gVar);
        m.f(gVar, "c");
        m.f(gVar2, "jClass");
        m.f(fVar, "ownerDescriptor");
        this.n = gVar2;
        this.o = fVar;
    }

    private final <R> Set<R> N(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Set<R> set, Function1<? super h, ? extends Collection<? extends R>> function1) {
        List e2;
        e2 = t.e(eVar);
        kotlin.reflect.jvm.internal.impl.utils.b.b(e2, d.a, new e(eVar, set, function1));
        return set;
    }

    private final t0 P(t0 t0Var) {
        int u;
        List L;
        if (t0Var.i().g()) {
            return t0Var;
        }
        Collection<? extends t0> e2 = t0Var.e();
        m.e(e2, "this.overriddenDescriptors");
        u = v.u(e2, 10);
        ArrayList arrayList = new ArrayList(u);
        for (t0 t0Var2 : e2) {
            m.e(t0Var2, "it");
            arrayList.add(P(t0Var2));
        }
        L = c0.L(arrayList);
        return (t0) s.s0(L);
    }

    private final Set<y0> Q(f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        Set<y0> I0;
        Set<y0> d2;
        k b2 = kotlin.reflect.y.internal.j0.d.a.k0.h.b(eVar);
        if (b2 == null) {
            d2 = w0.d();
            return d2;
        }
        I0 = c0.I0(b2.a(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS));
        return I0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.d.a.l0.l.a p() {
        return new kotlin.reflect.y.internal.j0.d.a.l0.l.a(this.n, a.f23557f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public f C() {
        return this.o;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> d2;
        m.f(dVar, "kindFilter");
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> H0;
        List m;
        m.f(dVar, "kindFilter");
        H0 = c0.H0(y().invoke().a());
        k b2 = kotlin.reflect.y.internal.j0.d.a.k0.h.b(C());
        Set<f> b3 = b2 != null ? b2.b() : null;
        if (b3 == null) {
            b3 = w0.d();
        }
        H0.addAll(b3);
        if (this.n.B()) {
            m = kotlin.collections.u.m(kotlin.reflect.y.internal.j0.b.k.f23194e, kotlin.reflect.y.internal.j0.b.k.f23193d);
            H0.addAll(m);
        }
        H0.addAll(w().a().w().a(C()));
        return H0;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void o(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        w().a().w().e(C(), fVar, collection);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        Collection<? extends y0> e2 = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, Q(fVar, C()), collection, C(), w().a().c(), w().a().k().a());
        m.e(e2, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(e2);
        if (this.n.B()) {
            if (m.a(fVar, kotlin.reflect.y.internal.j0.b.k.f23194e)) {
                y0 f2 = kotlin.reflect.y.internal.j0.i.c.f(C());
                m.e(f2, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(f2);
            } else if (m.a(fVar, kotlin.reflect.y.internal.j0.b.k.f23193d)) {
                y0 g2 = kotlin.reflect.y.internal.j0.i.c.g(C());
                m.e(g2, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(g2);
            }
        }
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.l, kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void s(f fVar, Collection<t0> collection) {
        m.f(fVar, "name");
        m.f(collection, "result");
        Set N = N(C(), new LinkedHashSet(), new b(fVar));
        if (!collection.isEmpty()) {
            Collection<? extends t0> e2 = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, N, collection, C(), w().a().c(), w().a().k().a());
            m.e(e2, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(e2);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : N) {
            t0 P = P((t0) obj);
            Object obj2 = linkedHashMap.get(P);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(P, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection e3 = kotlin.reflect.y.internal.j0.d.a.j0.a.e(fVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, C(), w().a().c(), w().a().k().a());
            m.e(e3, "resolveOverridesForStati…ingUtil\n                )");
            z.z(arrayList, e3);
        }
        collection.addAll(arrayList);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> H0;
        m.f(dVar, "kindFilter");
        H0 = c0.H0(y().invoke().e());
        N(C(), H0, c.f23559f);
        return H0;
    }
}
