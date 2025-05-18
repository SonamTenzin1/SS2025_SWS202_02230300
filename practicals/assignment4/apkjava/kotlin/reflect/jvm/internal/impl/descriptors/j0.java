package kotlin.reflect.jvm.internal.impl.descriptors;

import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: NotFoundClasses.kt */
/* loaded from: classes2.dex */
public final class j0 {
    private final kotlin.reflect.y.internal.j0.k.n a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f25145b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.c, k0> f25146c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.g<a, e> f25147d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final kotlin.reflect.y.internal.j0.f.b a;

        /* renamed from: b, reason: collision with root package name */
        private final List<Integer> f25148b;

        public a(kotlin.reflect.y.internal.j0.f.b bVar, List<Integer> list) {
            kotlin.jvm.internal.m.f(bVar, "classId");
            kotlin.jvm.internal.m.f(list, "typeParametersCount");
            this.a = bVar;
            this.f25148b = list;
        }

        public final kotlin.reflect.y.internal.j0.f.b a() {
            return this.a;
        }

        public final List<Integer> b() {
            return this.f25148b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.m.a(this.a, aVar.a) && kotlin.jvm.internal.m.a(this.f25148b, aVar.f25148b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f25148b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.f25148b + ')';
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.p1.g {
        private final boolean n;
        private final List<e1> o;
        private final kotlin.reflect.y.internal.j0.l.l p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.y.internal.j0.k.n nVar, m mVar, kotlin.reflect.y.internal.j0.f.f fVar, boolean z, int i2) {
            super(nVar, mVar, fVar, z0.a, false);
            IntRange k2;
            int u;
            Set c2;
            kotlin.jvm.internal.m.f(nVar, "storageManager");
            kotlin.jvm.internal.m.f(mVar, "container");
            kotlin.jvm.internal.m.f(fVar, "name");
            this.n = z;
            k2 = kotlin.ranges.l.k(0, i2);
            u = kotlin.collections.v.u(k2, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<Integer> it = k2.iterator();
            while (it.hasNext()) {
                int b2 = ((IntIterator) it).b();
                kotlin.reflect.jvm.internal.impl.descriptors.n1.g b3 = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
                r1 r1Var = r1.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(b2);
                arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.p1.k0.S0(this, b3, false, r1Var, kotlin.reflect.y.internal.j0.f.f.x(sb.toString()), b2, nVar));
            }
            this.o = arrayList;
            List<e1> d2 = f1.d(this);
            c2 = kotlin.collections.v0.c(kotlin.reflect.y.internal.j0.i.t.a.l(this).o().i());
            this.p = new kotlin.reflect.y.internal.j0.l.l(this, d2, c2, nVar);
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
        public Collection<e> J() {
            List j2;
            j2 = kotlin.collections.u.j();
            return j2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean J0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        /* renamed from: L0, reason: merged with bridge method [inline-methods] */
        public h.b S() {
            return h.b.f24422b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public boolean M() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
        /* renamed from: M0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.l h() {
            return this.p;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
        /* renamed from: N0, reason: merged with bridge method [inline-methods] */
        public h.b H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
            return h.b.f24422b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public kotlin.reflect.jvm.internal.impl.descriptors.d R() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public e U() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
        public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
            return kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
        public u getVisibility() {
            u uVar = t.f25368e;
            kotlin.jvm.internal.m.e(uVar, Store.PUBLIC_ACCESS);
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public f i() {
            return f.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.c0
        public d0 j() {
            return d0.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
            Set d2;
            d2 = kotlin.collections.w0.d();
            return d2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public boolean l() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
        public boolean m() {
            return this.n;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
        public List<e1> w() {
            return this.o;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.g, kotlin.reflect.jvm.internal.impl.descriptors.c0
        public boolean z() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
        public g1<kotlin.reflect.y.internal.j0.l.m0> z0() {
            return null;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function1<a, e> {
        c() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
        
            if (r1 != null) goto L10;
         */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final e invoke(a aVar) {
            m mVar;
            List<Integer> M;
            kotlin.jvm.internal.m.f(aVar, "<name for destructuring parameter 0>");
            kotlin.reflect.y.internal.j0.f.b a = aVar.a();
            List<Integer> b2 = aVar.b();
            if (!a.k()) {
                kotlin.reflect.y.internal.j0.f.b g2 = a.g();
                if (g2 != null) {
                    j0 j0Var = j0.this;
                    M = kotlin.collections.c0.M(b2, 1);
                    mVar = j0Var.d(g2, M);
                }
                kotlin.reflect.y.internal.j0.k.g gVar = j0.this.f25146c;
                kotlin.reflect.y.internal.j0.f.c h2 = a.h();
                kotlin.jvm.internal.m.e(h2, "classId.packageFqName");
                mVar = (g) gVar.invoke(h2);
                m mVar2 = mVar;
                boolean l = a.l();
                kotlin.reflect.y.internal.j0.k.n nVar = j0.this.a;
                kotlin.reflect.y.internal.j0.f.f j2 = a.j();
                kotlin.jvm.internal.m.e(j2, "classId.shortClassName");
                Integer num = (Integer) kotlin.collections.s.W(b2);
                return new b(nVar, mVar2, j2, l, num != null ? num.intValue() : 0);
            }
            throw new UnsupportedOperationException("Unresolved local class: " + a);
        }
    }

    /* compiled from: NotFoundClasses.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.c, k0> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            kotlin.jvm.internal.m.f(cVar, "fqName");
            return new kotlin.reflect.jvm.internal.impl.descriptors.p1.m(j0.this.f25145b, cVar);
        }
    }

    public j0(kotlin.reflect.y.internal.j0.k.n nVar, g0 g0Var) {
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(g0Var, "module");
        this.a = nVar;
        this.f25145b = g0Var;
        this.f25146c = nVar.h(new d());
        this.f25147d = nVar.h(new c());
    }

    public final e d(kotlin.reflect.y.internal.j0.f.b bVar, List<Integer> list) {
        kotlin.jvm.internal.m.f(bVar, "classId");
        kotlin.jvm.internal.m.f(list, "typeParametersCount");
        return this.f25147d.invoke(new a(bVar, list));
    }
}
