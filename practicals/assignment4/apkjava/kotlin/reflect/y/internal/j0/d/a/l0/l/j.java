package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.n0.b0;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.i.w.c;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.s;

/* compiled from: LazyJavaScope.kt */
/* loaded from: classes2.dex */
public abstract class j extends kotlin.reflect.y.internal.j0.i.w.i {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23525b = {g0.h(new y(g0.b(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), g0.h(new y(g0.b(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), g0.h(new y(g0.b(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.l0.g f23526c;

    /* renamed from: d, reason: collision with root package name */
    private final j f23527d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> f23528e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.d.a.l0.l.b> f23529f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.f, Collection<y0>> f23530g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, t0> f23531h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.f, Collection<y0>> f23532i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23533j;

    /* renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23534k;
    private final kotlin.reflect.y.internal.j0.k.i l;
    private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.f, List<t0>> m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final e0 a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f23535b;

        /* renamed from: c, reason: collision with root package name */
        private final List<i1> f23536c;

        /* renamed from: d, reason: collision with root package name */
        private final List<e1> f23537d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f23538e;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f23539f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(e0 e0Var, e0 e0Var2, List<? extends i1> list, List<? extends e1> list2, boolean z, List<String> list3) {
            kotlin.jvm.internal.m.f(e0Var, "returnType");
            kotlin.jvm.internal.m.f(list, "valueParameters");
            kotlin.jvm.internal.m.f(list2, "typeParameters");
            kotlin.jvm.internal.m.f(list3, "errors");
            this.a = e0Var;
            this.f23535b = e0Var2;
            this.f23536c = list;
            this.f23537d = list2;
            this.f23538e = z;
            this.f23539f = list3;
        }

        public final List<String> a() {
            return this.f23539f;
        }

        public final boolean b() {
            return this.f23538e;
        }

        public final e0 c() {
            return this.f23535b;
        }

        public final e0 d() {
            return this.a;
        }

        public final List<e1> e() {
            return this.f23537d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.a, aVar.a) && kotlin.jvm.internal.m.a(this.f23535b, aVar.f23535b) && kotlin.jvm.internal.m.a(this.f23536c, aVar.f23536c) && kotlin.jvm.internal.m.a(this.f23537d, aVar.f23537d) && this.f23538e == aVar.f23538e && kotlin.jvm.internal.m.a(this.f23539f, aVar.f23539f);
        }

        public final List<i1> f() {
            return this.f23536c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            e0 e0Var = this.f23535b;
            int hashCode2 = (((((hashCode + (e0Var == null ? 0 : e0Var.hashCode())) * 31) + this.f23536c.hashCode()) * 31) + this.f23537d.hashCode()) * 31;
            boolean z = this.f23538e;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return ((hashCode2 + i2) * 31) + this.f23539f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=" + this.f23535b + ", valueParameters=" + this.f23536c + ", typeParameters=" + this.f23537d + ", hasStableParameterNames=" + this.f23538e + ", errors=" + this.f23539f + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private final List<i1> a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f23540b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends i1> list, boolean z) {
            kotlin.jvm.internal.m.f(list, "descriptors");
            this.a = list;
            this.f23540b = z;
        }

        public final List<i1> a() {
            return this.a;
        }

        public final boolean b() {
            return this.f23540b;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.m>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
            return j.this.m(kotlin.reflect.y.internal.j0.i.w.d.m, kotlin.reflect.y.internal.j0.i.w.h.a.a());
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
            return j.this.l(kotlin.reflect.y.internal.j0.i.w.d.r, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, t0> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final t0 invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "name");
            if (j.this.B() != null) {
                return (t0) j.this.B().f23531h.invoke(fVar);
            }
            n c2 = j.this.y().invoke().c(fVar);
            if (c2 == null || c2.G()) {
                return null;
            }
            return j.this.J(c2);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "name");
            if (j.this.B() != null) {
                return (Collection) j.this.B().f23530g.invoke(fVar);
            }
            ArrayList arrayList = new ArrayList();
            for (r rVar : j.this.y().invoke().f(fVar)) {
                kotlin.reflect.y.internal.j0.d.a.k0.e I = j.this.I(rVar);
                if (j.this.G(I)) {
                    j.this.w().a().h().e(rVar, I);
                    arrayList.add(I);
                }
            }
            j.this.o(arrayList, fVar);
            return arrayList;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class g extends Lambda implements Function0<kotlin.reflect.y.internal.j0.d.a.l0.l.b> {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.d.a.l0.l.b invoke() {
            return j.this.p();
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class h extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
            return j.this.n(kotlin.reflect.y.internal.j0.i.w.d.t, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class i extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            List E0;
            kotlin.jvm.internal.m.f(fVar, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) j.this.f23530g.invoke(fVar));
            j.this.L(linkedHashSet);
            j.this.r(linkedHashSet, fVar);
            E0 = c0.E0(j.this.w().a().r().g(j.this.w(), linkedHashSet));
            return E0;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.l0.l.j$j, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0335j extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, List<? extends t0>> {
        C0335j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List<t0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            List<t0> E0;
            List<t0> E02;
            kotlin.jvm.internal.m.f(fVar, "name");
            ArrayList arrayList = new ArrayList();
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, j.this.f23531h.invoke(fVar));
            j.this.s(fVar, arrayList);
            if (kotlin.reflect.y.internal.j0.i.d.t(j.this.C())) {
                E02 = c0.E0(arrayList);
                return E02;
            }
            E0 = c0.E0(j.this.w().a().r().g(j.this.w(), arrayList));
            return E0;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    static final class k extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
            return j.this.t(kotlin.reflect.y.internal.j0.i.w.d.u, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    public static final class l extends Lambda implements Function0<kotlin.reflect.y.internal.j0.k.j<? extends kotlin.reflect.y.internal.j0.i.r.g<?>>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23551g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 f23552h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LazyJavaScope.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function0<kotlin.reflect.y.internal.j0.i.r.g<?>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ j f23553f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ n f23554g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 f23555h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(j jVar, n nVar, kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 c0Var) {
                super(0);
                this.f23553f = jVar;
                this.f23554g = nVar;
                this.f23555h = c0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.y.internal.j0.i.r.g<?> invoke() {
                return this.f23553f.w().a().g().a(this.f23554g, this.f23555h);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(n nVar, kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 c0Var) {
            super(0);
            this.f23551g = nVar;
            this.f23552h = c0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.k.j<kotlin.reflect.y.internal.j0.i.r.g<?>> invoke() {
            return j.this.w().e().f(new a(j.this, this.f23551g, this.f23552h));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaScope.kt */
    /* loaded from: classes2.dex */
    public static final class m extends Lambda implements Function1<y0, kotlin.reflect.jvm.internal.impl.descriptors.a> {

        /* renamed from: f, reason: collision with root package name */
        public static final m f23556f = new m();

        m() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.a invoke(y0 y0Var) {
            kotlin.jvm.internal.m.f(y0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return y0Var;
        }
    }

    public /* synthetic */ j(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, j jVar, int i2, kotlin.jvm.internal.g gVar2) {
        this(gVar, (i2 & 2) != 0 ? null : jVar);
    }

    private final Set<kotlin.reflect.y.internal.j0.f.f> A() {
        return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.f23533j, this, f23525b[0]);
    }

    private final Set<kotlin.reflect.y.internal.j0.f.f> D() {
        return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.f23534k, this, f23525b[1]);
    }

    private final e0 E(n nVar) {
        boolean z = false;
        e0 o = this.f23526c.g().o(nVar.getType(), kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null));
        if ((kotlin.reflect.y.internal.j0.b.h.r0(o) || kotlin.reflect.y.internal.j0.b.h.u0(o)) && F(nVar) && nVar.O()) {
            z = true;
        }
        if (!z) {
            return o;
        }
        e0 n = n1.n(o);
        kotlin.jvm.internal.m.e(n, "makeNotNullable(propertyType)");
        return n;
    }

    private final boolean F(n nVar) {
        return nVar.isFinal() && nVar.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t0 J(n nVar) {
        List<? extends e1> j2;
        List<w0> j3;
        kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 u = u(nVar);
        u.W0(null, null, null, null);
        e0 E = E(nVar);
        j2 = u.j();
        w0 z = z();
        j3 = u.j();
        u.c1(E, j2, z, null, j3);
        if (kotlin.reflect.y.internal.j0.i.d.K(u, u.getType())) {
            u.M0(new l(nVar, u));
        }
        this.f23526c.a().h().d(nVar, u);
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(Set<y0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c2 = v.c((y0) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c2, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends y0> a2 = kotlin.reflect.y.internal.j0.i.l.a(list, m.f23556f);
                set.removeAll(list);
                set.addAll(a2);
            }
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.p1.c0 u(n nVar) {
        kotlin.reflect.y.internal.j0.d.a.k0.f g1 = kotlin.reflect.y.internal.j0.d.a.k0.f.g1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(this.f23526c, nVar), d0.FINAL, i0.c(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f23526c.a().t().a(nVar), F(nVar));
        kotlin.jvm.internal.m.e(g1, "create(\n            owne…d.isFinalStatic\n        )");
        return g1;
    }

    private final Set<kotlin.reflect.y.internal.j0.f.f> x() {
        return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.l, this, f23525b[2]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j B() {
        return this.f23527d;
    }

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.m C();

    protected boolean G(kotlin.reflect.y.internal.j0.d.a.k0.e eVar) {
        kotlin.jvm.internal.m.f(eVar, "<this>");
        return true;
    }

    protected abstract a H(r rVar, List<? extends e1> list, e0 e0Var, List<? extends i1> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.y.internal.j0.d.a.k0.e I(r rVar) {
        int u;
        List<w0> j2;
        Map<? extends a.InterfaceC0406a<?>, ?> i2;
        kotlin.jvm.internal.m.f(rVar, "method");
        kotlin.reflect.y.internal.j0.d.a.k0.e q1 = kotlin.reflect.y.internal.j0.d.a.k0.e.q1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(this.f23526c, rVar), rVar.getName(), this.f23526c.a().t().a(rVar), this.f23529f.invoke().b(rVar.getName()) != null && rVar.f().isEmpty());
        kotlin.jvm.internal.m.e(q1, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        kotlin.reflect.y.internal.j0.d.a.l0.g f2 = kotlin.reflect.y.internal.j0.d.a.l0.a.f(this.f23526c, q1, rVar, 0, 4, null);
        List<kotlin.reflect.y.internal.j0.d.a.n0.y> typeParameters = rVar.getTypeParameters();
        u = kotlin.collections.v.u(typeParameters, 10);
        List<? extends e1> arrayList = new ArrayList<>(u);
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            e1 a2 = f2.f().a((kotlin.reflect.y.internal.j0.d.a.n0.y) it.next());
            kotlin.jvm.internal.m.c(a2);
            arrayList.add(a2);
        }
        b K = K(f2, q1, rVar.f());
        a H = H(rVar, arrayList, q(rVar, f2), K.a());
        e0 c2 = H.c();
        w0 h2 = c2 != null ? kotlin.reflect.y.internal.j0.i.c.h(q1, c2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b()) : null;
        w0 z = z();
        j2 = u.j();
        List<e1> e2 = H.e();
        List<i1> f3 = H.f();
        e0 d2 = H.d();
        d0 a3 = d0.f25129f.a(false, rVar.isAbstract(), !rVar.isFinal());
        kotlin.reflect.jvm.internal.impl.descriptors.u c3 = i0.c(rVar.getVisibility());
        if (H.c() != null) {
            i2 = p0.f(s.a(kotlin.reflect.y.internal.j0.d.a.k0.e.J, kotlin.collections.s.U(K.a())));
        } else {
            i2 = q0.i();
        }
        q1.p1(h2, z, j2, e2, f3, d2, a3, c3, i2);
        q1.t1(H.b(), K.b());
        if (!H.a().isEmpty()) {
            f2.a().s().b(q1, H.a());
        }
        return q1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b K(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, List<? extends b0> list) {
        Iterable<IndexedValue> K0;
        int u;
        List E0;
        Pair a2;
        kotlin.reflect.y.internal.j0.f.f name;
        kotlin.reflect.y.internal.j0.d.a.l0.g gVar2 = gVar;
        kotlin.jvm.internal.m.f(gVar2, "c");
        kotlin.jvm.internal.m.f(yVar, "function");
        kotlin.jvm.internal.m.f(list, "jValueParameters");
        K0 = c0.K0(list);
        u = kotlin.collections.v.u(K0, 10);
        ArrayList arrayList = new ArrayList(u);
        boolean z = false;
        boolean z2 = false;
        for (IndexedValue indexedValue : K0) {
            int index = indexedValue.getIndex();
            b0 b0Var = (b0) indexedValue.b();
            kotlin.reflect.jvm.internal.impl.descriptors.n1.g a3 = kotlin.reflect.y.internal.j0.d.a.l0.e.a(gVar2, b0Var);
            kotlin.reflect.y.internal.j0.d.a.l0.m.a d2 = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, z, null, 3, null);
            if (b0Var.h()) {
                x type = b0Var.getType();
                kotlin.reflect.y.internal.j0.d.a.n0.f fVar = type instanceof kotlin.reflect.y.internal.j0.d.a.n0.f ? (kotlin.reflect.y.internal.j0.d.a.n0.f) type : null;
                if (fVar != null) {
                    e0 k2 = gVar.g().k(fVar, d2, true);
                    a2 = s.a(k2, gVar.d().o().k(k2));
                } else {
                    throw new AssertionError("Vararg parameter should be an array: " + b0Var);
                }
            } else {
                a2 = s.a(gVar.g().o(b0Var.getType(), d2), null);
            }
            e0 e0Var = (e0) a2.a();
            e0 e0Var2 = (e0) a2.b();
            if (kotlin.jvm.internal.m.a(yVar.getName().k(), "equals") && list.size() == 1 && kotlin.jvm.internal.m.a(gVar.d().o().I(), e0Var)) {
                name = kotlin.reflect.y.internal.j0.f.f.x("other");
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z2 = true;
                }
                if (name == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('p');
                    sb.append(index);
                    name = kotlin.reflect.y.internal.j0.f.f.x(sb.toString());
                    kotlin.jvm.internal.m.e(name, "identifier(\"p$index\")");
                }
            }
            kotlin.reflect.y.internal.j0.f.f fVar2 = name;
            kotlin.jvm.internal.m.e(fVar2, "if (function.name.asStri…(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new l0(yVar, null, index, a3, fVar2, e0Var, false, false, false, e0Var2, gVar.a().t().a(b0Var)));
            arrayList = arrayList2;
            z2 = z2;
            z = false;
            gVar2 = gVar;
        }
        E0 = c0.E0(arrayList);
        return new b(E0, z2);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        List j2;
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        if (b().contains(fVar)) {
            return this.f23532i.invoke(fVar);
        }
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> b() {
        return A();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        List j2;
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        if (d().contains(fVar)) {
            return this.m.invoke(fVar);
        }
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> d() {
        return D();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> e() {
        return x();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        return this.f23528e.invoke();
    }

    protected abstract Set<kotlin.reflect.y.internal.j0.f.f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1);

    protected final List<kotlin.reflect.jvm.internal.impl.descriptors.m> m(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.m> E0;
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        kotlin.reflect.y.internal.j0.c.b.d dVar2 = kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.c())) {
            for (kotlin.reflect.y.internal.j0.f.f fVar : l(dVar, function1)) {
                if (function1.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(linkedHashSet, f(fVar, dVar2));
                }
            }
        }
        if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.d()) && !dVar.l().contains(c.a.a)) {
            for (kotlin.reflect.y.internal.j0.f.f fVar2 : n(dVar, function1)) {
                if (function1.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(a(fVar2, dVar2));
                }
            }
        }
        if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.i()) && !dVar.l().contains(c.a.a)) {
            for (kotlin.reflect.y.internal.j0.f.f fVar3 : t(dVar, function1)) {
                if (function1.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(c(fVar3, dVar2));
                }
            }
        }
        E0 = c0.E0(linkedHashSet);
        return E0;
    }

    protected abstract Set<kotlin.reflect.y.internal.j0.f.f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1);

    protected void o(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar) {
        kotlin.jvm.internal.m.f(collection, "result");
        kotlin.jvm.internal.m.f(fVar, "name");
    }

    protected abstract kotlin.reflect.y.internal.j0.d.a.l0.l.b p();

    /* JADX INFO: Access modifiers changed from: protected */
    public final e0 q(r rVar, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        kotlin.jvm.internal.m.f(rVar, "method");
        kotlin.jvm.internal.m.f(gVar, "c");
        return gVar.g().o(rVar.getReturnType(), kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, rVar.P().r(), null, 2, null));
    }

    protected abstract void r(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar);

    protected abstract void s(kotlin.reflect.y.internal.j0.f.f fVar, Collection<t0> collection);

    protected abstract Set<kotlin.reflect.y.internal.j0.f.f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1);

    public String toString() {
        return "Lazy scope for " + C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.y.internal.j0.k.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> v() {
        return this.f23528e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.y.internal.j0.d.a.l0.g w() {
        return this.f23526c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.d.a.l0.l.b> y() {
        return this.f23529f;
    }

    protected abstract w0 z();

    public j(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, j jVar) {
        List j2;
        kotlin.jvm.internal.m.f(gVar, "c");
        this.f23526c = gVar;
        this.f23527d = jVar;
        kotlin.reflect.y.internal.j0.k.n e2 = gVar.e();
        c cVar = new c();
        j2 = u.j();
        this.f23528e = e2.c(cVar, j2);
        this.f23529f = gVar.e().d(new g());
        this.f23530g = gVar.e().h(new f());
        this.f23531h = gVar.e().i(new e());
        this.f23532i = gVar.e().h(new i());
        this.f23533j = gVar.e().d(new h());
        this.f23534k = gVar.e().d(new k());
        this.l = gVar.e().d(new d());
        this.m = gVar.e().h(new C0335j());
    }
}
