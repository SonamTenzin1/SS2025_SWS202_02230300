package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.x0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.e0;
import kotlin.reflect.y.internal.j0.d.a.h0;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.j0.j;
import kotlin.reflect.y.internal.j0.d.a.l0.l.j;
import kotlin.reflect.y.internal.j0.d.a.n0.k;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.d.a.o0.l;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.l.n1;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes2.dex */
public final class g extends kotlin.reflect.y.internal.j0.d.a.l0.l.j {
    private final kotlin.reflect.jvm.internal.impl.descriptors.e n;
    private final kotlin.reflect.y.internal.j0.d.a.n0.g o;
    private final boolean p;
    private final kotlin.reflect.y.internal.j0.k.i<List<kotlin.reflect.jvm.internal.impl.descriptors.d>> q;
    private final kotlin.reflect.y.internal.j0.k.i<Set<kotlin.reflect.y.internal.j0.f.f>> r;
    private final kotlin.reflect.y.internal.j0.k.i<Map<kotlin.reflect.y.internal.j0.f.f, n>> s;
    private final kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.jvm.internal.impl.descriptors.p1.g> t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<q, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23505f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q qVar) {
            m.f(qVar, "it");
            return Boolean.valueOf(!qVar.Q());
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends kotlin.jvm.internal.i implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "p0");
            return ((g) this.receiver).I0(fVar);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class c extends kotlin.jvm.internal.i implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        c(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "p0");
            return ((g) this.receiver).J0(fVar);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "it");
            return g.this.I0(fVar);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "it");
            return g.this.J0(fVar);
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements Function0<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.d>> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23509g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(0);
            this.f23509g = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.d> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.d> E0;
            ?? n;
            Collection<k> k2 = g.this.o.k();
            ArrayList arrayList = new ArrayList(k2.size());
            Iterator<k> it = k2.iterator();
            while (it.hasNext()) {
                arrayList.add(g.this.G0(it.next()));
            }
            if (g.this.o.t()) {
                kotlin.reflect.jvm.internal.impl.descriptors.d e0 = g.this.e0();
                boolean z = false;
                String c2 = v.c(e0, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (m.a(v.c((kotlin.reflect.jvm.internal.impl.descriptors.d) it2.next(), false, false, 2, null), c2)) {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    arrayList.add(e0);
                    this.f23509g.a().h().b(g.this.o, e0);
                }
            }
            this.f23509g.a().w().c(g.this.C(), arrayList);
            l r = this.f23509g.a().r();
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar = this.f23509g;
            g gVar2 = g.this;
            boolean isEmpty = arrayList.isEmpty();
            ArrayList arrayList2 = arrayList;
            if (isEmpty) {
                n = u.n(gVar2.d0());
                arrayList2 = n;
            }
            E0 = c0.E0(r.g(gVar, arrayList2));
            return E0;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.l0.l.g$g, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0333g extends Lambda implements Function0<Map<kotlin.reflect.y.internal.j0.f.f, ? extends n>> {
        C0333g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<kotlin.reflect.y.internal.j0.f.f, n> invoke() {
            int u;
            int e2;
            int b2;
            Collection<n> D = g.this.o.D();
            ArrayList arrayList = new ArrayList();
            for (Object obj : D) {
                if (((n) obj).G()) {
                    arrayList.add(obj);
                }
            }
            u = kotlin.collections.v.u(arrayList, 10);
            e2 = p0.e(u);
            b2 = kotlin.ranges.l.b(e2, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    public static final class h extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ y0 f23511f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f23512g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(y0 y0Var, g gVar) {
            super(1);
            this.f23511f = y0Var;
            this.f23512g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            List o0;
            List e2;
            m.f(fVar, "accessorName");
            if (!m.a(this.f23511f.getName(), fVar)) {
                o0 = c0.o0(this.f23512g.I0(fVar), this.f23512g.J0(fVar));
                return o0;
            }
            e2 = t.e(this.f23511f);
            return e2;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    static final class i extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
            Set<kotlin.reflect.y.internal.j0.f.f> I0;
            I0 = c0.I0(g.this.o.K());
            return I0;
        }
    }

    /* compiled from: LazyJavaClassMemberScope.kt */
    /* loaded from: classes2.dex */
    static final class j extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.jvm.internal.impl.descriptors.p1.g> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23515g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LazyJavaClassMemberScope.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f23516f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.f23516f = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                Set<kotlin.reflect.y.internal.j0.f.f> l;
                l = x0.l(this.f23516f.b(), this.f23516f.d());
                return l;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(1);
            this.f23515g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.p1.g invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "name");
            if (!((Set) g.this.r.invoke()).contains(fVar)) {
                n nVar = (n) ((Map) g.this.s.invoke()).get(fVar);
                if (nVar == null) {
                    return null;
                }
                return kotlin.reflect.jvm.internal.impl.descriptors.p1.n.M0(this.f23515g.e(), g.this.C(), fVar, this.f23515g.e().d(new a(g.this)), kotlin.reflect.y.internal.j0.d.a.l0.e.a(this.f23515g, nVar), this.f23515g.a().t().a(nVar));
            }
            o d2 = this.f23515g.a().d();
            kotlin.reflect.y.internal.j0.f.b g2 = kotlin.reflect.y.internal.j0.i.t.a.g(g.this.C());
            m.c(g2);
            kotlin.reflect.y.internal.j0.f.b d3 = g2.d(fVar);
            m.e(d3, "ownerDescriptor.classId!…createNestedClassId(name)");
            kotlin.reflect.y.internal.j0.d.a.n0.g a2 = d2.a(new o.b(d3, null, g.this.o, 2, null));
            if (a2 == null) {
                return null;
            }
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar = this.f23515g;
            kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar2 = new kotlin.reflect.y.internal.j0.d.a.l0.l.f(gVar, g.this.C(), a2, null, 8, null);
            gVar.a().e().a(fVar2);
            return fVar2;
        }
    }

    public /* synthetic */ g(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, boolean z, g gVar3, int i2, kotlin.jvm.internal.g gVar4) {
        this(gVar, eVar, gVar2, z, (i2 & 16) != 0 ? null : gVar3);
    }

    private final boolean A0(y0 y0Var, y yVar) {
        String c2 = v.c(y0Var, false, false, 2, null);
        y a2 = yVar.a();
        m.e(a2, "builtinWithErasedParameters.original");
        return m.a(c2, v.c(a2, false, false, 2, null)) && !o0(y0Var, yVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
    
        if (kotlin.reflect.y.internal.j0.d.a.z.d(r4) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:1: B:31:0x003f->B:45:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean B0(y0 y0Var) {
        boolean z;
        boolean z2;
        boolean z3;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "function.name");
        List<kotlin.reflect.y.internal.j0.f.f> a2 = e0.a(name);
        if (!(a2 instanceof Collection) || !a2.isEmpty()) {
            Iterator<T> it = a2.iterator();
            while (it.hasNext()) {
                Set<t0> z0 = z0((kotlin.reflect.y.internal.j0.f.f) it.next());
                if (!(z0 instanceof Collection) || !z0.isEmpty()) {
                    for (t0 t0Var : z0) {
                        if (n0(t0Var, new h(y0Var, this))) {
                            if (!t0Var.j0()) {
                                String k2 = y0Var.getName().k();
                                m.e(k2, "function.name.asString()");
                            }
                            z = true;
                            if (!z) {
                                z2 = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        return (z3 || p0(y0Var) || K0(y0Var) || r0(y0Var)) ? false : true;
    }

    private final y0 C0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1, Collection<? extends y0> collection) {
        y0 g0;
        y k2 = kotlin.reflect.y.internal.j0.d.a.f.k(y0Var);
        if (k2 == null || (g0 = g0(k2, function1)) == null) {
            return null;
        }
        if (!B0(g0)) {
            g0 = null;
        }
        if (g0 != null) {
            return f0(g0, k2, collection);
        }
        return null;
    }

    private final y0 D0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1, kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection) {
        y0 y0Var2 = (y0) kotlin.reflect.y.internal.j0.d.a.g0.d(y0Var);
        if (y0Var2 == null) {
            return null;
        }
        String b2 = kotlin.reflect.y.internal.j0.d.a.g0.b(y0Var2);
        m.c(b2);
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(b2);
        m.e(x, "identifier(nameInJava)");
        Iterator<? extends y0> it = function1.invoke(x).iterator();
        while (it.hasNext()) {
            y0 l0 = l0(it.next(), fVar);
            if (q0(y0Var2, l0)) {
                return f0(l0, y0Var2, collection);
            }
        }
        return null;
    }

    private final y0 E0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        if (!y0Var.isSuspend()) {
            return null;
        }
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "descriptor.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (it.hasNext()) {
            y0 m0 = m0((y0) it.next());
            if (m0 == null || !o0(m0, y0Var)) {
                m0 = null;
            }
            if (m0 != null) {
                return m0;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.d.a.k0.b G0(k kVar) {
        int u;
        List<e1> o0;
        kotlin.reflect.jvm.internal.impl.descriptors.e C = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b u1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(C, kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), kVar), false, w().a().t().a(kVar));
        m.e(u1, "createJavaConstructor(\n …ce(constructor)\n        )");
        kotlin.reflect.y.internal.j0.d.a.l0.g e2 = kotlin.reflect.y.internal.j0.d.a.l0.a.e(w(), u1, kVar, C.w().size());
        j.b K = K(e2, u1, kVar.f());
        List<e1> w = C.w();
        m.e(w, "classDescriptor.declaredTypeParameters");
        List<kotlin.reflect.y.internal.j0.d.a.n0.y> typeParameters = kVar.getTypeParameters();
        u = kotlin.collections.v.u(typeParameters, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            e1 a2 = e2.f().a((kotlin.reflect.y.internal.j0.d.a.n0.y) it.next());
            m.c(a2);
            arrayList.add(a2);
        }
        o0 = c0.o0(w, arrayList);
        u1.s1(K.a(), i0.c(kVar.getVisibility()), o0);
        u1.Z0(false);
        u1.a1(K.b());
        u1.h1(C.s());
        e2.a().h().b(kVar, u1);
        return u1;
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.e H0(w wVar) {
        List<w0> j2;
        List<? extends e1> j3;
        List<i1> j4;
        kotlin.reflect.y.internal.j0.d.a.k0.e q1 = kotlin.reflect.y.internal.j0.d.a.k0.e.q1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), wVar), wVar.getName(), w().a().t().a(wVar), true);
        m.e(q1, "createJavaMethod(\n      …omponent), true\n        )");
        kotlin.reflect.y.internal.j0.l.e0 o = w().g().o(wVar.getType(), kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 2, null));
        w0 z = z();
        j2 = u.j();
        j3 = u.j();
        j4 = u.j();
        q1.p1(null, z, j2, j3, j4, o, d0.f25129f.a(false, false, true), kotlin.reflect.jvm.internal.impl.descriptors.t.f25368e, null);
        q1.t1(false, false);
        w().a().h().e(wVar, q1);
        return q1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<y0> I0(kotlin.reflect.y.internal.j0.f.f fVar) {
        int u;
        Collection<r> f2 = y().invoke().f(fVar);
        u = kotlin.collections.v.u(f2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = f2.iterator();
        while (it.hasNext()) {
            arrayList.add(I((r) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<y0> J0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Set<y0> x0 = x0(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : x0) {
            y0 y0Var = (y0) obj;
            if (!(kotlin.reflect.y.internal.j0.d.a.g0.a(y0Var) || kotlin.reflect.y.internal.j0.d.a.f.k(y0Var) != null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean K0(y0 y0Var) {
        kotlin.reflect.y.internal.j0.d.a.f fVar = kotlin.reflect.y.internal.j0.d.a.f.n;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        if (!fVar.l(name)) {
            return false;
        }
        kotlin.reflect.y.internal.j0.f.f name2 = y0Var.getName();
        m.e(name2, "name");
        Set<y0> x0 = x0(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = x0.iterator();
        while (it.hasNext()) {
            y k2 = kotlin.reflect.y.internal.j0.d.a.f.k((y0) it.next());
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (A0(y0Var, (y) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final void U(List<i1> list, kotlin.reflect.jvm.internal.impl.descriptors.l lVar, int i2, r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, kotlin.reflect.y.internal.j0.l.e0 e0Var2) {
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g b2 = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        kotlin.reflect.y.internal.j0.f.f name = rVar.getName();
        kotlin.reflect.y.internal.j0.l.e0 n = n1.n(e0Var);
        m.e(n, "makeNotNullable(returnType)");
        list.add(new l0(lVar, null, i2, b2, name, n, rVar.L(), false, false, e0Var2 != null ? n1.n(e0Var2) : null, w().a().t().a(rVar)));
    }

    private final void V(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection2, boolean z) {
        List o0;
        int u;
        Collection<? extends y0> d2 = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, collection2, collection, C(), w().a().c(), w().a().k().a());
        m.e(d2, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z) {
            collection.addAll(d2);
            return;
        }
        o0 = c0.o0(collection, d2);
        u = kotlin.collections.v.u(d2, 10);
        ArrayList arrayList = new ArrayList(u);
        for (y0 y0Var : d2) {
            y0 y0Var2 = (y0) kotlin.reflect.y.internal.j0.d.a.g0.e(y0Var);
            if (y0Var2 == null) {
                m.e(y0Var, "resolvedOverride");
            } else {
                m.e(y0Var, "resolvedOverride");
                y0Var = f0(y0Var, y0Var2, o0);
            }
            arrayList.add(y0Var);
        }
        collection.addAll(arrayList);
    }

    private final void W(kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection, Collection<? extends y0> collection2, Collection<y0> collection3, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        for (y0 y0Var : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, D0(y0Var, function1, fVar, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, C0(y0Var, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, E0(y0Var, function1));
        }
    }

    private final void X(Set<? extends t0> set, Collection<t0> collection, Set<t0> set2, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        for (t0 t0Var : set) {
            kotlin.reflect.y.internal.j0.d.a.k0.f h0 = h0(t0Var, function1);
            if (h0 != null) {
                collection.add(h0);
                if (set2 != null) {
                    set2.add(t0Var);
                    return;
                }
                return;
            }
        }
    }

    private final void Y(kotlin.reflect.y.internal.j0.f.f fVar, Collection<t0> collection) {
        r rVar = (r) s.t0(y().invoke().f(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(j0(this, rVar, null, d0.FINAL, 2, null));
    }

    private final Collection<kotlin.reflect.y.internal.j0.l.e0> b0() {
        if (!this.p) {
            return w().a().k().c().g(C());
        }
        Collection<kotlin.reflect.y.internal.j0.l.e0> a2 = C().h().a();
        m.e(a2, "ownerDescriptor.typeConstructor.supertypes");
        return a2;
    }

    private final List<i1> c0(kotlin.reflect.jvm.internal.impl.descriptors.p1.f fVar) {
        Pair pair;
        Collection<r> M = this.o.M();
        ArrayList arrayList = new ArrayList(M.size());
        kotlin.reflect.y.internal.j0.d.a.l0.m.a d2 = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : M) {
            if (m.a(((r) obj).getName(), a0.f23325c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.a();
        List<r> list2 = (List) pair2.b();
        list.size();
        r rVar = (r) s.W(list);
        if (rVar != null) {
            x returnType = rVar.getReturnType();
            if (returnType instanceof kotlin.reflect.y.internal.j0.d.a.n0.f) {
                kotlin.reflect.y.internal.j0.d.a.n0.f fVar2 = (kotlin.reflect.y.internal.j0.d.a.n0.f) returnType;
                pair = new Pair(w().g().k(fVar2, d2, true), w().g().o(fVar2.n(), d2));
            } else {
                pair = new Pair(w().g().o(returnType, d2), null);
            }
            U(arrayList, fVar, 0, rVar, (kotlin.reflect.y.internal.j0.l.e0) pair.a(), (kotlin.reflect.y.internal.j0.l.e0) pair.b());
        }
        int i2 = 0;
        int i3 = rVar == null ? 0 : 1;
        for (r rVar2 : list2) {
            U(arrayList, fVar, i2 + i3, rVar2, w().g().o(rVar2.getReturnType(), d2), null);
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d d0() {
        List<i1> emptyList;
        boolean r = this.o.r();
        if ((this.o.H() || !this.o.u()) && !r) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e C = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b u1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(C, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), true, w().a().t().a(this.o));
        m.e(u1, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (r) {
            emptyList = c0(u1);
        } else {
            emptyList = Collections.emptyList();
        }
        u1.a1(false);
        u1.r1(emptyList, v0(C));
        u1.Z0(true);
        u1.h1(C.s());
        w().a().h().b(this.o, u1);
        return u1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d e0() {
        kotlin.reflect.jvm.internal.impl.descriptors.e C = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b u1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(C, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), true, w().a().t().a(this.o));
        m.e(u1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<i1> k0 = k0(u1);
        u1.a1(false);
        u1.r1(k0, v0(C));
        u1.Z0(false);
        u1.h1(C.s());
        return u1;
    }

    private final y0 f0(y0 y0Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends y0> collection) {
        boolean z = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (y0 y0Var2 : collection) {
                if (!m.a(y0Var, y0Var2) && y0Var2.d0() == null && o0(y0Var2, aVar)) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return y0Var;
        }
        y0 c2 = y0Var.u().q().c();
        m.c(c2);
        return c2;
    }

    private final y0 g0(y yVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        Object obj;
        int u;
        kotlin.reflect.y.internal.j0.f.f name = yVar.getName();
        m.e(name, "overridden.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (A0((y0) obj, yVar)) {
                break;
            }
        }
        y0 y0Var = (y0) obj;
        if (y0Var == null) {
            return null;
        }
        y.a<? extends y0> u2 = y0Var.u();
        List<i1> f2 = yVar.f();
        m.e(f2, "overridden.valueParameters");
        u = kotlin.collections.v.u(f2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it2 = f2.iterator();
        while (it2.hasNext()) {
            arrayList.add(((i1) it2.next()).getType());
        }
        List<i1> f3 = y0Var.f();
        m.e(f3, "override.valueParameters");
        u2.b(kotlin.reflect.y.internal.j0.d.a.k0.h.a(arrayList, f3, yVar));
        u2.u();
        u2.f();
        u2.n(kotlin.reflect.y.internal.j0.d.a.k0.e.K, Boolean.TRUE);
        return u2.c();
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.f h0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0Var;
        List<? extends e1> j2;
        List<w0> j3;
        kotlin.reflect.jvm.internal.impl.descriptors.p1.e0 e0Var = null;
        if (!n0(t0Var, function1)) {
            return null;
        }
        y0 t0 = t0(t0Var, function1);
        m.c(t0);
        if (t0Var.j0()) {
            y0Var = u0(t0Var, function1);
            m.c(y0Var);
        } else {
            y0Var = null;
        }
        if (y0Var != null) {
            y0Var.j();
            t0.j();
        }
        kotlin.reflect.y.internal.j0.d.a.k0.d dVar = new kotlin.reflect.y.internal.j0.d.a.k0.d(C(), t0, y0Var, t0Var);
        kotlin.reflect.y.internal.j0.l.e0 returnType = t0.getReturnType();
        m.c(returnType);
        j2 = u.j();
        w0 z = z();
        j3 = u.j();
        dVar.c1(returnType, j2, z, null, j3);
        kotlin.reflect.jvm.internal.impl.descriptors.p1.d0 j4 = kotlin.reflect.y.internal.j0.i.c.j(dVar, t0.getAnnotations(), false, false, false, t0.t());
        j4.O0(t0);
        j4.R0(dVar.getType());
        m.e(j4, "createGetter(\n          …escriptor.type)\n        }");
        if (y0Var != null) {
            List<i1> f2 = y0Var.f();
            m.e(f2, "setterMethod.valueParameters");
            i1 i1Var = (i1) s.W(f2);
            if (i1Var != null) {
                e0Var = kotlin.reflect.y.internal.j0.i.c.l(dVar, y0Var.getAnnotations(), i1Var.getAnnotations(), false, false, false, y0Var.getVisibility(), y0Var.t());
                e0Var.O0(y0Var);
            } else {
                throw new AssertionError("No parameter found for " + y0Var);
            }
        }
        dVar.V0(j4, e0Var);
        return dVar;
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.f i0(r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, d0 d0Var) {
        List<? extends e1> j2;
        List<w0> j3;
        kotlin.reflect.y.internal.j0.d.a.k0.f g1 = kotlin.reflect.y.internal.j0.d.a.k0.f.g1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), rVar), d0Var, i0.c(rVar.getVisibility()), false, rVar.getName(), w().a().t().a(rVar), false);
        m.e(g1, "create(\n            owne…inal = */ false\n        )");
        kotlin.reflect.jvm.internal.impl.descriptors.p1.d0 d2 = kotlin.reflect.y.internal.j0.i.c.d(g1, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
        m.e(d2, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        g1.V0(d2, null);
        kotlin.reflect.y.internal.j0.l.e0 q = e0Var == null ? q(rVar, kotlin.reflect.y.internal.j0.d.a.l0.a.f(w(), g1, rVar, 0, 4, null)) : e0Var;
        j2 = u.j();
        w0 z = z();
        j3 = u.j();
        g1.c1(q, j2, z, null, j3);
        d2.R0(q);
        return g1;
    }

    static /* synthetic */ kotlin.reflect.y.internal.j0.d.a.k0.f j0(g gVar, r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, d0 d0Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            e0Var = null;
        }
        return gVar.i0(rVar, e0Var, d0Var);
    }

    private final List<i1> k0(kotlin.reflect.jvm.internal.impl.descriptors.p1.f fVar) {
        Collection<w> j2 = this.o.j();
        ArrayList arrayList = new ArrayList(j2.size());
        kotlin.reflect.y.internal.j0.l.e0 e0Var = null;
        kotlin.reflect.y.internal.j0.d.a.l0.m.a d2 = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 2, null);
        int i2 = 0;
        for (w wVar : j2) {
            int i3 = i2 + 1;
            kotlin.reflect.y.internal.j0.l.e0 o = w().g().o(wVar.getType(), d2);
            arrayList.add(new l0(fVar, null, i2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), wVar.getName(), o, false, false, false, wVar.h() ? w().a().m().o().k(o) : e0Var, w().a().t().a(wVar)));
            i2 = i3;
            e0Var = null;
        }
        return arrayList;
    }

    private final y0 l0(y0 y0Var, kotlin.reflect.y.internal.j0.f.f fVar) {
        y.a<? extends y0> u = y0Var.u();
        u.t(fVar);
        u.u();
        u.f();
        y0 c2 = u.c();
        m.c(c2);
        return c2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final y0 m0(y0 y0Var) {
        kotlin.reflect.y.internal.j0.f.c cVar;
        List<i1> N;
        kotlin.reflect.y.internal.j0.f.d i2;
        List<i1> f2 = y0Var.f();
        m.e(f2, "valueParameters");
        i1 i1Var = (i1) s.i0(f2);
        if (i1Var != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.h w = i1Var.getType().O0().w();
            if (w != null && (i2 = kotlin.reflect.y.internal.j0.i.t.a.i(w)) != null) {
                if (!i2.f()) {
                    i2 = null;
                }
                if (i2 != null) {
                    cVar = i2.l();
                    if (!m.a(cVar, kotlin.reflect.y.internal.j0.b.k.m)) {
                        i1Var = null;
                    }
                    if (i1Var != null) {
                        y.a<? extends y0> u = y0Var.u();
                        List<i1> f3 = y0Var.f();
                        m.e(f3, "valueParameters");
                        N = c0.N(f3, 1);
                        y0 c2 = u.b(N).g(i1Var.getType().M0().get(0).getType()).c();
                        kotlin.reflect.jvm.internal.impl.descriptors.p1.g0 g0Var = (kotlin.reflect.jvm.internal.impl.descriptors.p1.g0) c2;
                        if (g0Var != null) {
                            g0Var.i1(true);
                        }
                        return c2;
                    }
                }
            }
            cVar = null;
            if (!m.a(cVar, kotlin.reflect.y.internal.j0.b.k.m)) {
            }
            if (i1Var != null) {
            }
        }
        return null;
    }

    private final boolean n0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        if (kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var)) {
            return false;
        }
        y0 t0 = t0(t0Var, function1);
        y0 u0 = u0(t0Var, function1);
        if (t0 == null) {
            return false;
        }
        if (t0Var.j0()) {
            return u0 != null && u0.j() == t0.j();
        }
        return true;
    }

    private final boolean o0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        j.i.a c2 = kotlin.reflect.y.internal.j0.i.j.f24327b.F(aVar2, aVar, true).c();
        m.e(c2, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return c2 == j.i.a.OVERRIDABLE && !kotlin.reflect.y.internal.j0.d.a.s.a.a(aVar2, aVar);
    }

    private final boolean p0(y0 y0Var) {
        h0.a aVar = h0.a;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        kotlin.reflect.y.internal.j0.f.f b2 = aVar.b(name);
        if (b2 == null) {
            return false;
        }
        Set<y0> x0 = x0(b2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : x0) {
            if (kotlin.reflect.y.internal.j0.d.a.g0.a((y0) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        y0 l0 = l0(y0Var, b2);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (q0((y0) it.next(), l0)) {
                return true;
            }
        }
        return false;
    }

    private final boolean q0(y0 y0Var, y yVar) {
        if (kotlin.reflect.y.internal.j0.d.a.e.n.k(y0Var)) {
            yVar = yVar.a();
        }
        m.e(yVar, "if (superDescriptor.isRe…iginal else subDescriptor");
        return o0(yVar, y0Var);
    }

    private final boolean r0(y0 y0Var) {
        y0 m0 = m0(y0Var);
        if (m0 == null) {
            return false;
        }
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        Set<y0> x0 = x0(name);
        if ((x0 instanceof Collection) && x0.isEmpty()) {
            return false;
        }
        for (y0 y0Var2 : x0) {
            if (y0Var2.isSuspend() && o0(m0, y0Var2)) {
                return true;
            }
        }
        return false;
    }

    private final y0 s0(t0 t0Var, String str, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0Var;
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(str);
        m.e(x, "identifier(getterName)");
        Iterator<T> it = function1.invoke(x).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.f().size() == 0) {
                kotlin.reflect.y.internal.j0.l.t1.e eVar = kotlin.reflect.y.internal.j0.l.t1.e.a;
                kotlin.reflect.y.internal.j0.l.e0 returnType = y0Var2.getReturnType();
                if (returnType == null ? false : eVar.d(returnType, t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    private final y0 t0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        u0 getter = t0Var.getGetter();
        u0 u0Var = getter != null ? (u0) kotlin.reflect.y.internal.j0.d.a.g0.d(getter) : null;
        String a2 = u0Var != null ? kotlin.reflect.y.internal.j0.d.a.i.a.a(u0Var) : null;
        if (a2 != null && !kotlin.reflect.y.internal.j0.d.a.g0.f(C(), u0Var)) {
            return s0(t0Var, a2, function1);
        }
        String k2 = t0Var.getName().k();
        m.e(k2, "name.asString()");
        return s0(t0Var, z.b(k2), function1);
    }

    private final y0 u0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0Var;
        kotlin.reflect.y.internal.j0.l.e0 returnType;
        String k2 = t0Var.getName().k();
        m.e(k2, "name.asString()");
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(z.e(k2));
        m.e(x, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(x).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.f().size() == 1 && (returnType = y0Var2.getReturnType()) != null && kotlin.reflect.y.internal.j0.b.h.B0(returnType)) {
                kotlin.reflect.y.internal.j0.l.t1.e eVar = kotlin.reflect.y.internal.j0.l.t1.e.a;
                List<i1> f2 = y0Var2.f();
                m.e(f2, "descriptor.valueParameters");
                if (eVar.b(((i1) s.s0(f2)).getType(), t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.u v0(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility = eVar.getVisibility();
        m.e(visibility, "classDescriptor.visibility");
        if (!m.a(visibility, kotlin.reflect.y.internal.j0.d.a.r.f23685b)) {
            return visibility;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.y.internal.j0.d.a.r.f23686c;
        m.e(uVar, "PROTECTED_AND_PACKAGE");
        return uVar;
    }

    private final Set<y0> x0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Collection<kotlin.reflect.y.internal.j0.l.e0> b0 = b0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = b0.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().a(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<t0> z0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Set<t0> I0;
        int u;
        Collection<kotlin.reflect.y.internal.j0.l.e0> b0 = b0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = b0.iterator();
        while (it.hasNext()) {
            Collection<? extends t0> c2 = ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().c(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS);
            u = kotlin.collections.v.u(c2, 10);
            ArrayList arrayList2 = new ArrayList(u);
            Iterator<T> it2 = c2.iterator();
            while (it2.hasNext()) {
                arrayList2.add((t0) it2.next());
            }
            kotlin.collections.z.z(arrayList, arrayList2);
        }
        I0 = c0.I0(arrayList);
        return I0;
    }

    public void F0(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.y.internal.j0.c.a.a(w().a().l(), bVar, C(), fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected boolean G(kotlin.reflect.y.internal.j0.d.a.k0.e eVar) {
        m.f(eVar, "<this>");
        if (this.o.r()) {
            return false;
        }
        return B0(eVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected j.a H(r rVar, List<? extends e1> list, kotlin.reflect.y.internal.j0.l.e0 e0Var, List<? extends i1> list2) {
        m.f(rVar, "method");
        m.f(list, "methodTypeParameters");
        m.f(e0Var, "returnType");
        m.f(list2, "valueParameters");
        j.b a2 = w().a().s().a(rVar, C(), e0Var, null, list2, list);
        m.e(a2, "c.components.signaturePr…dTypeParameters\n        )");
        kotlin.reflect.y.internal.j0.l.e0 d2 = a2.d();
        m.e(d2, "propagated.returnType");
        kotlin.reflect.y.internal.j0.l.e0 c2 = a2.c();
        List<i1> f2 = a2.f();
        m.e(f2, "propagated.valueParameters");
        List<e1> e2 = a2.e();
        m.e(e2, "propagated.typeParameters");
        boolean g2 = a2.g();
        List<String> b2 = a2.b();
        m.e(b2, "propagated.errors");
        return new j.a(d2, c2, f2, e2, g2, b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<kotlin.reflect.y.internal.j0.f.f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        Collection<kotlin.reflect.y.internal.j0.l.e0> a2 = C().h().a();
        m.e(a2, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<kotlin.reflect.y.internal.j0.f.f> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().b());
        }
        linkedHashSet.addAll(y().invoke().a());
        linkedHashSet.addAll(y().invoke().d());
        linkedHashSet.addAll(l(dVar, function1));
        linkedHashSet.addAll(w().a().w().d(C()));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        return super.a(fVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.d.a.l0.l.a p() {
        return new kotlin.reflect.y.internal.j0.d.a.l0.l.a(this.o, a.f23505f);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        return super.c(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.jvm.internal.impl.descriptors.p1.g> hVar;
        kotlin.reflect.jvm.internal.impl.descriptors.p1.g invoke;
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        g gVar = (g) B();
        return (gVar == null || (hVar = gVar.t) == null || (invoke = hVar.invoke(fVar)) == null) ? this.t.invoke(fVar) : invoke;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<kotlin.reflect.y.internal.j0.f.f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        Set<kotlin.reflect.y.internal.j0.f.f> l;
        m.f(dVar, "kindFilter");
        l = x0.l(this.r.invoke(), this.s.invoke().keySet());
        return l;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void o(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        if (this.o.t() && y().invoke().b(fVar) != null) {
            boolean z = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((y0) it.next()).f().isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                w b2 = y().invoke().b(fVar);
                m.c(b2);
                collection.add(H0(b2));
            }
        }
        w().a().w().b(C(), fVar, collection);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar) {
        List j2;
        List o0;
        boolean z;
        m.f(collection, "result");
        m.f(fVar, "name");
        Set<y0> x0 = x0(fVar);
        if (!h0.a.k(fVar) && !kotlin.reflect.y.internal.j0.d.a.f.n.l(fVar)) {
            if (!(x0 instanceof Collection) || !x0.isEmpty()) {
                Iterator<T> it = x0.iterator();
                while (it.hasNext()) {
                    if (((y) it.next()).isSuspend()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : x0) {
                    if (B0((y0) obj)) {
                        arrayList.add(obj);
                    }
                }
                V(collection, fVar, arrayList, false);
                return;
            }
        }
        kotlin.reflect.jvm.internal.impl.utils.f a2 = kotlin.reflect.jvm.internal.impl.utils.f.f25524f.a();
        j2 = u.j();
        Collection<? extends y0> d2 = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, x0, j2, C(), kotlin.reflect.y.internal.j0.j.b.r.a, w().a().k().a());
        m.e(d2, "resolveOverridesForNonSt….overridingUtil\n        )");
        W(fVar, collection, d2, collection, new b(this));
        W(fVar, collection, d2, a2, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : x0) {
            if (B0((y0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        o0 = c0.o0(arrayList2, a2);
        V(collection, fVar, o0, true);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void s(kotlin.reflect.y.internal.j0.f.f fVar, Collection<t0> collection) {
        Set<? extends t0> j2;
        Set l;
        m.f(fVar, "name");
        m.f(collection, "result");
        if (this.o.r()) {
            Y(fVar, collection);
        }
        Set<t0> z0 = z0(fVar);
        if (z0.isEmpty()) {
            return;
        }
        f.b bVar = kotlin.reflect.jvm.internal.impl.utils.f.f25524f;
        kotlin.reflect.jvm.internal.impl.utils.f a2 = bVar.a();
        kotlin.reflect.jvm.internal.impl.utils.f a3 = bVar.a();
        X(z0, collection, a2, new d());
        j2 = x0.j(z0, a2);
        X(j2, a3, null, new e());
        l = x0.l(z0, a3);
        Collection<? extends t0> d2 = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, l, collection, C(), w().a().c(), w().a().k().a());
        m.e(d2, "resolveOverridesForNonSt…rridingUtil\n            )");
        collection.addAll(d2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<kotlin.reflect.y.internal.j0.f.f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        if (this.o.r()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(y().invoke().e());
        Collection<kotlin.reflect.y.internal.j0.l.e0> a2 = C().h().a();
        m.e(a2, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    public String toString() {
        return "Lazy Java member scope for " + this.o.d();
    }

    public final kotlin.reflect.y.internal.j0.k.i<List<kotlin.reflect.jvm.internal.impl.descriptors.d>> w0() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e C() {
        return this.n;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected w0 z() {
        return kotlin.reflect.y.internal.j0.i.d.l(C());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, boolean z, g gVar3) {
        super(gVar, gVar3);
        m.f(gVar, "c");
        m.f(eVar, "ownerDescriptor");
        m.f(gVar2, "jClass");
        this.n = eVar;
        this.o = gVar2;
        this.p = z;
        this.q = gVar.e().d(new f(gVar));
        this.r = gVar.e().d(new i());
        this.s = gVar.e().d(new C0333g());
        this.t = gVar.e().i(new j(gVar));
    }
}
