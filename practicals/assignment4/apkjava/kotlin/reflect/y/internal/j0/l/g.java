package kotlin.reflect.y.internal.j0.l;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.t1.h;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.u;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
public abstract class g extends m {

    /* renamed from: b, reason: collision with root package name */
    private final i<b> f24730b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f24731c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public final class a implements e1 {
        private final kotlin.reflect.y.internal.j0.l.t1.g a;

        /* renamed from: b, reason: collision with root package name */
        private final Lazy f24732b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f24733c;

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: kotlin.f0.y.e.j0.l.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0396a extends Lambda implements Function0<List<? extends e0>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ g f24735g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0396a(g gVar) {
                super(0);
                this.f24735g = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends e0> invoke() {
                return h.b(a.this.a, this.f24735g.a());
            }
        }

        public a(g gVar, kotlin.reflect.y.internal.j0.l.t1.g gVar2) {
            Lazy a;
            m.f(gVar2, "kotlinTypeRefiner");
            this.f24733c = gVar;
            this.a = gVar2;
            a = kotlin.i.a(LazyThreadSafetyMode.PUBLICATION, new C0396a(gVar));
            this.f24732b = a;
        }

        private final List<e0> h() {
            return (List) this.f24732b.getValue();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public e1 b(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            return this.f24733c.b(gVar);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        /* renamed from: c */
        public kotlin.reflect.jvm.internal.impl.descriptors.h w() {
            return this.f24733c.w();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return this.f24733c.e();
        }

        public boolean equals(Object obj) {
            return this.f24733c.equals(obj);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            List<e1> parameters = this.f24733c.getParameters();
            m.e(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f24733c.hashCode();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public List<e0> a() {
            return h();
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.b.h o() {
            kotlin.reflect.y.internal.j0.b.h o = this.f24733c.o();
            m.e(o, "this@AbstractTypeConstructor.builtIns");
            return o;
        }

        public String toString() {
            return this.f24733c.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private final Collection<e0> a;

        /* renamed from: b, reason: collision with root package name */
        private List<? extends e0> f24736b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends e0> collection) {
            List<? extends e0> e2;
            m.f(collection, "allSupertypes");
            this.a = collection;
            e2 = t.e(k.a.l());
            this.f24736b = e2;
        }

        public final Collection<e0> a() {
            return this.a;
        }

        public final List<e0> b() {
            return this.f24736b;
        }

        public final void c(List<? extends e0> list) {
            m.f(list, "<set-?>");
            this.f24736b = list;
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function0<b> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(g.this.l());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Boolean, b> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f24738f = new d();

        d() {
            super(1);
        }

        public final b b(boolean z) {
            List e2;
            e2 = t.e(k.a.l());
            return new b(e2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return b(bool.booleanValue());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<b, u> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<e1, Iterable<? extends e0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24740f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(1);
                this.f24740f = gVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<e0> invoke(e1 e1Var) {
                m.f(e1Var, "it");
                return this.f24740f.k(e1Var, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<e0, u> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24741f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(g gVar) {
                super(1);
                this.f24741f = gVar;
            }

            public final void b(e0 e0Var) {
                m.f(e0Var, "it");
                this.f24741f.t(e0Var);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(e0 e0Var) {
                b(e0Var);
                return u.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public static final class c extends Lambda implements Function1<e1, Iterable<? extends e0>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24742f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(g gVar) {
                super(1);
                this.f24742f = gVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterable<e0> invoke(e1 e1Var) {
                m.f(e1Var, "it");
                return this.f24742f.k(e1Var, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public static final class d extends Lambda implements Function1<e0, u> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f24743f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(g gVar) {
                super(1);
                this.f24743f = gVar;
            }

            public final void b(e0 e0Var) {
                m.f(e0Var, "it");
                this.f24743f.u(e0Var);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(e0 e0Var) {
                b(e0Var);
                return u.a;
            }
        }

        e() {
            super(1);
        }

        public final void b(b bVar) {
            m.f(bVar, "supertypes");
            Collection<e0> a2 = g.this.q().a(g.this, bVar.a(), new c(g.this), new d(g.this));
            if (a2.isEmpty()) {
                e0 m = g.this.m();
                a2 = m != null ? t.e(m) : null;
                if (a2 == null) {
                    a2 = kotlin.collections.u.j();
                }
            }
            if (g.this.p()) {
                c1 q = g.this.q();
                g gVar = g.this;
                q.a(gVar, a2, new a(gVar), new b(g.this));
            }
            g gVar2 = g.this;
            List<e0> list = a2 instanceof List ? (List) a2 : null;
            if (list == null) {
                list = c0.E0(a2);
            }
            bVar.c(gVar2.s(list));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(b bVar) {
            b(bVar);
            return u.a;
        }
    }

    public g(n nVar) {
        m.f(nVar, "storageManager");
        this.f24730b = nVar.g(new c(), d.f24738f, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r4 = kotlin.collections.c0.o0(r0.f24730b.invoke().a(), r0.n(r4));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<e0> k(e1 e1Var, boolean z) {
        List o0;
        g gVar = e1Var instanceof g ? (g) e1Var : null;
        if (gVar != null && o0 != null) {
            return o0;
        }
        Collection<e0> a2 = e1Var.a();
        m.e(a2, "supertypes");
        return a2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return new a(this, gVar);
    }

    protected abstract Collection<e0> l();

    protected e0 m() {
        return null;
    }

    protected Collection<e0> n(boolean z) {
        List j2;
        j2 = kotlin.collections.u.j();
        return j2;
    }

    protected boolean p() {
        return this.f24731c;
    }

    protected abstract c1 q();

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public List<e0> a() {
        return this.f24730b.invoke().b();
    }

    protected List<e0> s(List<e0> list) {
        m.f(list, "supertypes");
        return list;
    }

    protected void t(e0 e0Var) {
        m.f(e0Var, "type");
    }

    protected void u(e0 e0Var) {
        m.f(e0Var, "type");
    }
}
