package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.j0.k;
import kotlin.reflect.y.internal.j0.d.a.m;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: LazyJavaClassDescriptor.kt */
/* loaded from: classes2.dex */
public final class f extends g implements kotlin.reflect.y.internal.j0.d.a.k0.c {
    public static final a n = new a(null);
    private static final Set<String> o;
    private final x0<g> A;
    private final kotlin.reflect.y.internal.j0.i.w.f B;
    private final k C;
    private final kotlin.reflect.jvm.internal.impl.descriptors.n1.g D;
    private final i<List<e1>> E;
    private final kotlin.reflect.y.internal.j0.d.a.l0.g p;
    private final kotlin.reflect.y.internal.j0.d.a.n0.g q;
    private final kotlin.reflect.jvm.internal.impl.descriptors.e r;
    private final kotlin.reflect.y.internal.j0.d.a.l0.g s;
    private final Lazy t;
    private final kotlin.reflect.jvm.internal.impl.descriptors.f u;
    private final d0 v;
    private final m1 w;
    private final boolean x;
    private final b y;
    private final g z;

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: classes2.dex */
    public final class b extends kotlin.reflect.y.internal.j0.l.b {

        /* renamed from: d, reason: collision with root package name */
        private final i<List<e1>> f23499d;

        /* compiled from: LazyJavaClassDescriptor.kt */
        /* loaded from: classes2.dex */
        static final class a extends Lambda implements Function0<List<? extends e1>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f23501f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f23501f = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends e1> invoke() {
                return f1.d(this.f23501f);
            }
        }

        public b() {
            super(f.this.s.e());
            this.f23499d = f.this.s.e().d(new a(f.this));
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            if ((!r0.d() && r0.i(kotlin.reflect.y.internal.j0.b.k.q)) != false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final e0 x() {
            kotlin.reflect.y.internal.j0.f.c cVar;
            int u;
            ArrayList arrayList;
            int u2;
            kotlin.reflect.y.internal.j0.f.c y = y();
            if (y != null) {
            }
            y = null;
            if (y == null) {
                cVar = m.a.b(kotlin.reflect.y.internal.j0.i.t.a.h(f.this));
                if (cVar == null) {
                    return null;
                }
            } else {
                cVar = y;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e r = kotlin.reflect.y.internal.j0.i.t.a.r(f.this.s.d(), cVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_JAVA_LOADER);
            if (r == null) {
                return null;
            }
            int size = r.h().getParameters().size();
            List<e1> parameters = f.this.h().getParameters();
            kotlin.jvm.internal.m.e(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                u2 = v.u(parameters, 10);
                arrayList = new ArrayList(u2);
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new i1(r1.INVARIANT, ((e1) it.next()).s()));
                }
            } else {
                if (size2 != 1 || size <= 1 || y != null) {
                    return null;
                }
                i1 i1Var = new i1(r1.INVARIANT, ((e1) s.s0(parameters)).s());
                IntRange intRange = new IntRange(1, size);
                u = v.u(intRange, 10);
                ArrayList arrayList2 = new ArrayList(u);
                Iterator<Integer> it2 = intRange.iterator();
                while (it2.hasNext()) {
                    ((IntIterator) it2).b();
                    arrayList2.add(i1Var);
                }
                arrayList = arrayList2;
            }
            return f0.g(a1.f24676g.h(), r, arrayList);
        }

        private final kotlin.reflect.y.internal.j0.f.c y() {
            String b2;
            kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = f.this.getAnnotations();
            kotlin.reflect.y.internal.j0.f.c cVar = a0.q;
            kotlin.jvm.internal.m.e(cVar, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.n1.c l = annotations.l(cVar);
            if (l == null) {
                return null;
            }
            Object t0 = s.t0(l.a().values());
            kotlin.reflect.y.internal.j0.i.r.v vVar = t0 instanceof kotlin.reflect.y.internal.j0.i.r.v ? (kotlin.reflect.y.internal.j0.i.r.v) t0 : null;
            if (vVar == null || (b2 = vVar.b()) == null || !kotlin.reflect.y.internal.j0.f.e.e(b2)) {
                return null;
            }
            return new kotlin.reflect.y.internal.j0.f.c(b2);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            return this.f23499d.invoke();
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected Collection<e0> l() {
            List e2;
            List E0;
            int u;
            Collection<j> a2 = f.this.Q0().a();
            ArrayList arrayList = new ArrayList(a2.size());
            ArrayList<x> arrayList2 = new ArrayList(0);
            e0 x = x();
            Iterator<j> it = a2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                e0 h2 = f.this.s.a().r().h(f.this.s.g().o(next, kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(k.SUPERTYPE, false, null, 3, null)), f.this.s);
                if (h2.O0().w() instanceof j0.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.m.a(h2.O0(), x != null ? x.O0() : null) && !h.b0(h2)) {
                    arrayList.add(h2);
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = f.this.r;
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, eVar != null ? kotlin.reflect.y.internal.j0.b.q.j.a(eVar, f.this).c().p(eVar.s(), r1.INVARIANT) : null);
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, x);
            if (!arrayList2.isEmpty()) {
                r c2 = f.this.s.a().c();
                kotlin.reflect.jvm.internal.impl.descriptors.e w = w();
                u = v.u(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(u);
                for (x xVar : arrayList2) {
                    kotlin.jvm.internal.m.d(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((j) xVar).p());
                }
                c2.b(w, arrayList3);
            }
            if (!arrayList.isEmpty()) {
                E0 = c0.E0(arrayList);
                return E0;
            }
            e2 = t.e(f.this.s.d().o().i());
            return e2;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected c1 q() {
            return f.this.s.a().v();
        }

        public String toString() {
            String k2 = f.this.getName().k();
            kotlin.jvm.internal.m.e(k2, "name.asString()");
            return k2;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m, kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.jvm.internal.impl.descriptors.e w() {
            return f.this;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<List<? extends e1>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends e1> invoke() {
            int u;
            List<y> typeParameters = f.this.Q0().getTypeParameters();
            f fVar = f.this;
            u = v.u(typeParameters, 10);
            ArrayList arrayList = new ArrayList(u);
            for (y yVar : typeParameters) {
                e1 a = fVar.s.f().a(yVar);
                if (a == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.Q0() + ", so it must be resolved");
                }
                arrayList.add(a);
            }
            return arrayList;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.comparisons.b.a(kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.reflect.jvm.internal.impl.descriptors.e) t).b(), kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.reflect.jvm.internal.impl.descriptors.e) t2).b());
            return a;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements Function0<List<? extends kotlin.reflect.y.internal.j0.d.a.n0.a>> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.y.internal.j0.d.a.n0.a> invoke() {
            kotlin.reflect.y.internal.j0.f.b g2 = kotlin.reflect.y.internal.j0.i.t.a.g(f.this);
            if (g2 != null) {
                return f.this.S0().a().f().a(g2);
            }
            return null;
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.l0.l.f$f, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0332f extends Lambda implements Function1<kotlin.reflect.y.internal.j0.l.t1.g, g> {
        C0332f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g invoke(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            kotlin.jvm.internal.m.f(gVar, "it");
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar2 = f.this.s;
            f fVar = f.this;
            return new g(gVar2, fVar, fVar.Q0(), f.this.r != null, f.this.z);
        }
    }

    static {
        Set<String> i2;
        i2 = w0.i("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
        o = i2;
    }

    public /* synthetic */ f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, int i2, kotlin.jvm.internal.g gVar3) {
        this(gVar, mVar, gVar2, (i2 & 8) != 0 ? null : eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> J() {
        List j2;
        List x0;
        if (this.v == d0.SEALED) {
            kotlin.reflect.y.internal.j0.d.a.l0.m.a d2 = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(k.COMMON, false, null, 3, null);
            Collection<j> N = this.q.N();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = N.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.h w = this.s.g().o((j) it.next(), d2).O0().w();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVar = w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) w : null;
                if (eVar != null) {
                    arrayList.add(eVar);
                }
            }
            x0 = c0.x0(arrayList, new d());
            return x0;
        }
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    public final f O0(kotlin.reflect.y.internal.j0.d.a.j0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(gVar, "javaResolverCache");
        kotlin.reflect.y.internal.j0.d.a.l0.g gVar2 = this.s;
        kotlin.reflect.y.internal.j0.d.a.l0.g i2 = kotlin.reflect.y.internal.j0.d.a.l0.a.i(gVar2, gVar2.a().x(gVar));
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = b();
        kotlin.jvm.internal.m.e(b2, "containingDeclaration");
        return new f(i2, b2, this.q, eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        return this.z.w0().invoke();
    }

    public final kotlin.reflect.y.internal.j0.d.a.n0.g Q0() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d R() {
        return null;
    }

    public final List<kotlin.reflect.y.internal.j0.d.a.n0.a> R0() {
        return (List) this.t.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        return this.C;
    }

    public final kotlin.reflect.y.internal.j0.d.a.l0.g S0() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public g D0() {
        kotlin.reflect.y.internal.j0.i.w.h D0 = super.D0();
        kotlin.jvm.internal.m.d(D0, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (g) D0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e U() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public g H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        return this.A.c(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        if (kotlin.jvm.internal.m.a(this.w, kotlin.reflect.jvm.internal.impl.descriptors.t.a) && this.q.i() == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.y.internal.j0.d.a.r.a;
            kotlin.jvm.internal.m.e(uVar, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
            return uVar;
        }
        return i0.c(this.w);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f i() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return this.x;
    }

    public String toString() {
        return "Lazy Java class " + kotlin.reflect.y.internal.j0.i.t.a.i(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        return this.E.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h y0() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public g1<m0> z0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        super(gVar.e(), mVar, gVar2.getName(), gVar.a().t().a(gVar2), false);
        Lazy b2;
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar;
        d0 d0Var;
        kotlin.jvm.internal.m.f(gVar, "outerContext");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar2, "jClass");
        this.p = gVar;
        this.q = gVar2;
        this.r = eVar;
        kotlin.reflect.y.internal.j0.d.a.l0.g d2 = kotlin.reflect.y.internal.j0.d.a.l0.a.d(gVar, this, gVar2, 0, 4, null);
        this.s = d2;
        d2.a().h().c(gVar2, this);
        gVar2.I();
        b2 = kotlin.i.b(new e());
        this.t = b2;
        if (gVar2.r()) {
            fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS;
        } else if (gVar2.H()) {
            fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
        } else {
            fVar = gVar2.B() ? kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS : kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        }
        this.u = fVar;
        if (!gVar2.r() && !gVar2.B()) {
            d0Var = d0.f25129f.a(gVar2.o(), gVar2.o() || gVar2.isAbstract() || gVar2.H(), !gVar2.isFinal());
        } else {
            d0Var = d0.FINAL;
        }
        this.v = d0Var;
        this.w = gVar2.getVisibility();
        this.x = (gVar2.i() == null || gVar2.Q()) ? false : true;
        this.y = new b();
        g gVar3 = new g(d2, this, gVar2, eVar != null, null, 16, null);
        this.z = gVar3;
        this.A = x0.a.a(this, d2.e(), d2.a().k().c(), new C0332f());
        this.B = new kotlin.reflect.y.internal.j0.i.w.f(gVar3);
        this.C = new k(d2, gVar2, this);
        this.D = kotlin.reflect.y.internal.j0.d.a.l0.e.a(d2, gVar2);
        this.E = d2.e().d(new c());
    }
}
