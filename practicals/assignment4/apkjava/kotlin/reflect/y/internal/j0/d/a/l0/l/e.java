package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.y.internal.j0.b.q.d;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.k0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.o;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.h;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.j;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.s;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
/* loaded from: classes2.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.n1.c, g {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), g0.h(new y(g0.b(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), g0.h(new y(g0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.l0.g f23488b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.n0.a f23489c;

    /* renamed from: d, reason: collision with root package name */
    private final j f23490d;

    /* renamed from: e, reason: collision with root package name */
    private final i f23491e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.m0.a f23492f;

    /* renamed from: g, reason: collision with root package name */
    private final i f23493g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f23494h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f23495i;

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<Map<f, ? extends kotlin.reflect.y.internal.j0.i.r.g<?>>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> invoke() {
            Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> q;
            Collection<kotlin.reflect.y.internal.j0.d.a.n0.b> b2 = e.this.f23489c.b();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.y.internal.j0.d.a.n0.b bVar : b2) {
                f name = bVar.getName();
                if (name == null) {
                    name = a0.f23325c;
                }
                kotlin.reflect.y.internal.j0.i.r.g l = eVar.l(bVar);
                Pair a = l != null ? s.a(name, l) : null;
                if (a != null) {
                    arrayList.add(a);
                }
            }
            q = q0.q(arrayList);
            return q;
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<kotlin.reflect.y.internal.j0.f.c> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.c invoke() {
            kotlin.reflect.y.internal.j0.f.b e2 = e.this.f23489c.e();
            if (e2 != null) {
                return e2.b();
            }
            return null;
        }
    }

    /* compiled from: LazyJavaAnnotationDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<m0> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            kotlin.reflect.y.internal.j0.f.c d2 = e.this.d();
            if (d2 == null) {
                return k.d(kotlin.reflect.y.internal.j0.l.u1.j.I0, e.this.f23489c.toString());
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e f2 = d.f(d.a, d2, e.this.f23488b.d().o(), null, 4, null);
            if (f2 == null) {
                kotlin.reflect.y.internal.j0.d.a.n0.g z = e.this.f23489c.z();
                f2 = z != null ? e.this.f23488b.a().n().a(z) : null;
                if (f2 == null) {
                    f2 = e.this.h(d2);
                }
            }
            return f2.s();
        }
    }

    public e(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.y.internal.j0.d.a.n0.a aVar, boolean z) {
        m.f(gVar, "c");
        m.f(aVar, "javaAnnotation");
        this.f23488b = gVar;
        this.f23489c = aVar;
        this.f23490d = gVar.e().f(new b());
        this.f23491e = gVar.e().d(new c());
        this.f23492f = gVar.a().t().a(aVar);
        this.f23493g = gVar.e().d(new a());
        this.f23494h = aVar.g();
        this.f23495i = aVar.v() || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e h(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.g0 d2 = this.f23488b.d();
        kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(cVar);
        m.e(m, "topLevel(fqName)");
        return x.c(d2, m, this.f23488b.a().b().d().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.i.r.g<?> l(kotlin.reflect.y.internal.j0.d.a.n0.b bVar) {
        if (bVar instanceof o) {
            return h.a.c(((o) bVar).getValue());
        }
        if (bVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.m) {
            kotlin.reflect.y.internal.j0.d.a.n0.m mVar = (kotlin.reflect.y.internal.j0.d.a.n0.m) bVar;
            return o(mVar.b(), mVar.d());
        }
        if (!(bVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.e)) {
            if (bVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.c) {
                return m(((kotlin.reflect.y.internal.j0.d.a.n0.c) bVar).a());
            }
            if (bVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.h) {
                return p(((kotlin.reflect.y.internal.j0.d.a.n0.h) bVar).c());
            }
            return null;
        }
        kotlin.reflect.y.internal.j0.d.a.n0.e eVar = (kotlin.reflect.y.internal.j0.d.a.n0.e) bVar;
        f name = eVar.getName();
        if (name == null) {
            name = a0.f23325c;
        }
        m.e(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return n(name, eVar.e());
    }

    private final kotlin.reflect.y.internal.j0.i.r.g<?> m(kotlin.reflect.y.internal.j0.d.a.n0.a aVar) {
        return new kotlin.reflect.y.internal.j0.i.r.a(new e(this.f23488b, aVar, false, 4, null));
    }

    private final kotlin.reflect.y.internal.j0.i.r.g<?> n(f fVar, List<? extends kotlin.reflect.y.internal.j0.d.a.n0.b> list) {
        e0 l;
        int u;
        m0 type = getType();
        m.e(type, "type");
        if (kotlin.reflect.y.internal.j0.l.g0.a(type)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e e2 = kotlin.reflect.y.internal.j0.i.t.a.e(this);
        m.c(e2);
        i1 b2 = kotlin.reflect.y.internal.j0.d.a.j0.a.b(fVar, e2);
        if (b2 == null || (l = b2.getType()) == null) {
            l = this.f23488b.a().m().o().l(r1.INVARIANT, k.d(kotlin.reflect.y.internal.j0.l.u1.j.H0, new String[0]));
        }
        m.e(l, "DescriptorResolverUtils.…GUMENT)\n                )");
        u = v.u(list, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.reflect.y.internal.j0.i.r.g<?> l2 = l((kotlin.reflect.y.internal.j0.d.a.n0.b) it.next());
            if (l2 == null) {
                l2 = new kotlin.reflect.y.internal.j0.i.r.s();
            }
            arrayList.add(l2);
        }
        return h.a.b(arrayList, l);
    }

    private final kotlin.reflect.y.internal.j0.i.r.g<?> o(kotlin.reflect.y.internal.j0.f.b bVar, f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new kotlin.reflect.y.internal.j0.i.r.j(bVar, fVar);
    }

    private final kotlin.reflect.y.internal.j0.i.r.g<?> p(kotlin.reflect.y.internal.j0.d.a.n0.x xVar) {
        return q.f24378b.a(this.f23488b.g().o(xVar, kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> a() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f23493g, this, a[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public kotlin.reflect.y.internal.j0.f.c d() {
        return (kotlin.reflect.y.internal.j0.f.c) kotlin.reflect.y.internal.j0.k.m.b(this.f23490d, this, a[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.k0.g
    public boolean g() {
        return this.f23494h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.d.a.m0.a t() {
        return this.f23492f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public m0 getType() {
        return (m0) kotlin.reflect.y.internal.j0.k.m.a(this.f23491e, this, a[1]);
    }

    public final boolean k() {
        return this.f23495i;
    }

    public String toString() {
        return kotlin.reflect.y.internal.j0.h.c.s(kotlin.reflect.y.internal.j0.h.c.f24252g, this, null, 2, null);
    }

    public /* synthetic */ e(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.y.internal.j0.d.a.n0.a aVar, boolean z, int i2, kotlin.jvm.internal.g gVar2) {
        this(gVar, aVar, (i2 & 4) != 0 ? false : z);
    }
}
