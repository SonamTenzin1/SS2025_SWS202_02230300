package kotlin.reflect.y.internal.j0.d.a.l0.m;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.b.q.d;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.k;
import kotlin.reflect.y.internal.j0.d.a.n0.a0;
import kotlin.reflect.y.internal.j0.d.a.n0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.i;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.n0.y;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.h0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes2.dex */
public final class c {
    private final g a;

    /* renamed from: b, reason: collision with root package name */
    private final k f23571b;

    /* renamed from: c, reason: collision with root package name */
    private final g f23572c;

    /* renamed from: d, reason: collision with root package name */
    private final e f23573d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaTypeResolver.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function0<e0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e1 f23575g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f23576h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.m.a f23577i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.l.e1 f23578j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e1 e1Var, j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.l.e1 e1Var2) {
            super(0);
            this.f23575g = e1Var;
            this.f23576h = jVar;
            this.f23577i = aVar;
            this.f23578j = e1Var2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            g gVar = c.this.f23572c;
            e1 e1Var = this.f23575g;
            boolean x = this.f23576h.x();
            kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar = this.f23577i;
            h w = this.f23578j.w();
            e0 c2 = gVar.c(e1Var, x, aVar.h(w != null ? w.s() : null));
            m.e(c2, "typeParameterUpperBoundE…efaultType)\n            )");
            return c2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(g gVar, k kVar) {
        m.f(gVar, "c");
        m.f(kVar, "typeParameterResolver");
        this.a = gVar;
        this.f23571b = kVar;
        g gVar2 = new g(null, 1, 0 == true ? 1 : 0);
        this.f23572c = gVar2;
        this.f23573d = new e(gVar2);
    }

    private final boolean b(j jVar, e eVar) {
        r1 n;
        if (!a0.a((x) s.i0(jVar.F()))) {
            return false;
        }
        List<e1> parameters = d.a.b(eVar).h().getParameters();
        m.e(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        e1 e1Var = (e1) s.i0(parameters);
        return (e1Var == null || (n = e1Var.n()) == null || n == r1.OUT_VARIANCE) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if ((!r0.isEmpty()) != false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<g1> c(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.l.e1 e1Var) {
        boolean z;
        Iterable<IndexedValue> K0;
        int u;
        List<g1> E0;
        int u2;
        List<g1> E02;
        if (!jVar.x()) {
            if (jVar.F().isEmpty()) {
                m.e(e1Var.getParameters(), "constructor.parameters");
            }
            z = false;
            List<e1> parameters = e1Var.getParameters();
            m.e(parameters, "constructor.parameters");
            if (!z) {
                return d(jVar, parameters, e1Var, aVar);
            }
            if (parameters.size() != jVar.F().size()) {
                u2 = v.u(parameters, 10);
                ArrayList arrayList = new ArrayList(u2);
                for (e1 e1Var2 : parameters) {
                    kotlin.reflect.y.internal.j0.l.u1.j jVar2 = kotlin.reflect.y.internal.j0.l.u1.j.Z;
                    String k2 = e1Var2.getName().k();
                    m.e(k2, "p.name.asString()");
                    arrayList.add(new i1(kotlin.reflect.y.internal.j0.l.u1.k.d(jVar2, k2)));
                }
                E02 = c0.E0(arrayList);
                return E02;
            }
            K0 = c0.K0(jVar.F());
            u = v.u(K0, 10);
            ArrayList arrayList2 = new ArrayList(u);
            for (IndexedValue indexedValue : K0) {
                int index = indexedValue.getIndex();
                x xVar = (x) indexedValue.b();
                parameters.size();
                e1 e1Var3 = parameters.get(index);
                kotlin.reflect.y.internal.j0.d.a.l0.m.a d2 = d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null);
                m.e(e1Var3, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                arrayList2.add(p(xVar, d2, e1Var3));
            }
            E0 = c0.E0(arrayList2);
            return E0;
        }
        z = true;
        List<e1> parameters2 = e1Var.getParameters();
        m.e(parameters2, "constructor.parameters");
        if (!z) {
        }
    }

    private final List<g1> d(j jVar, List<? extends e1> list, kotlin.reflect.y.internal.j0.l.e1 e1Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        int u;
        g1 j2;
        u = v.u(list, 10);
        ArrayList arrayList = new ArrayList(u);
        for (e1 e1Var2 : list) {
            if (kotlin.reflect.y.internal.j0.l.x1.a.k(e1Var2, null, aVar.f())) {
                j2 = d.b(e1Var2, aVar);
            } else {
                j2 = this.f23573d.j(e1Var2, jVar.x() ? aVar : aVar.i(b.INFLEXIBLE), new h0(this.a.e(), new a(e1Var2, jVar, aVar, e1Var)));
            }
            arrayList.add(j2);
        }
        return arrayList;
    }

    private final m0 e(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, m0 m0Var) {
        a1 b2;
        if (m0Var == null || (b2 = m0Var.N0()) == null) {
            b2 = b1.b(new kotlin.reflect.y.internal.j0.d.a.l0.d(this.a, jVar, false, 4, null));
        }
        a1 a1Var = b2;
        kotlin.reflect.y.internal.j0.l.e1 f2 = f(jVar, aVar);
        if (f2 == null) {
            return null;
        }
        boolean i2 = i(aVar);
        if (m.a(m0Var != null ? m0Var.O0() : null, f2) && !jVar.x() && i2) {
            return m0Var.S0(true);
        }
        return f0.i(a1Var, f2, c(jVar, aVar, f2), i2, null, 16, null);
    }

    private final kotlin.reflect.y.internal.j0.l.e1 f(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        kotlin.reflect.y.internal.j0.l.e1 h2;
        i c2 = jVar.c();
        if (c2 == null) {
            return g(jVar);
        }
        if (c2 instanceof kotlin.reflect.y.internal.j0.d.a.n0.g) {
            kotlin.reflect.y.internal.j0.d.a.n0.g gVar = (kotlin.reflect.y.internal.j0.d.a.n0.g) c2;
            kotlin.reflect.y.internal.j0.f.c d2 = gVar.d();
            if (d2 != null) {
                e j2 = j(jVar, aVar, d2);
                if (j2 == null) {
                    j2 = this.a.a().n().a(gVar);
                }
                return (j2 == null || (h2 = j2.h()) == null) ? g(jVar) : h2;
            }
            throw new AssertionError("Class type should have a FQ name: " + c2);
        }
        if (c2 instanceof y) {
            e1 a2 = this.f23571b.a((y) c2);
            if (a2 != null) {
                return a2.h();
            }
            return null;
        }
        throw new IllegalStateException("Unknown classifier kind: " + c2);
    }

    private final kotlin.reflect.y.internal.j0.l.e1 g(j jVar) {
        List<Integer> e2;
        b m = b.m(new kotlin.reflect.y.internal.j0.f.c(jVar.y()));
        m.e(m, "topLevel(FqName(javaType.classifierQualifiedName))");
        j0 q = this.a.a().b().d().q();
        e2 = t.e(0);
        kotlin.reflect.y.internal.j0.l.e1 h2 = q.d(m, e2).h();
        m.e(h2, "c.components.deserialize…istOf(0)).typeConstructor");
        return h2;
    }

    private final boolean h(r1 r1Var, e1 e1Var) {
        return (e1Var.n() == r1.INVARIANT || r1Var == e1Var.n()) ? false : true;
    }

    private final boolean i(kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        return (aVar.d() == b.FLEXIBLE_LOWER_BOUND || aVar.g() || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE) ? false : true;
    }

    private final e j(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, kotlin.reflect.y.internal.j0.f.c cVar) {
        if (aVar.g() && m.a(cVar, d.a())) {
            return this.a.a().p().c();
        }
        d dVar = d.a;
        e f2 = d.f(dVar, cVar, this.a.d().o(), null, 4, null);
        if (f2 == null) {
            return null;
        }
        return (dVar.d(f2) && (aVar.d() == b.FLEXIBLE_LOWER_BOUND || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE || b(jVar, f2))) ? dVar.b(f2) : f2;
    }

    public static /* synthetic */ e0 l(c cVar, f fVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return cVar.k(fVar, aVar, z);
    }

    private final e0 m(j jVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        boolean z = (aVar.g() || aVar.e() == kotlin.reflect.y.internal.j0.d.a.j0.k.SUPERTYPE) ? false : true;
        boolean x = jVar.x();
        if (!x && !z) {
            m0 e2 = e(jVar, aVar, null);
            return e2 != null ? e2 : n(jVar);
        }
        m0 e3 = e(jVar, aVar.i(b.FLEXIBLE_LOWER_BOUND), null);
        if (e3 == null) {
            return n(jVar);
        }
        m0 e4 = e(jVar, aVar.i(b.FLEXIBLE_UPPER_BOUND), e3);
        if (e4 == null) {
            return n(jVar);
        }
        if (x) {
            return new f(e3, e4);
        }
        return f0.d(e3, e4);
    }

    private static final kotlin.reflect.y.internal.j0.l.u1.h n(j jVar) {
        return kotlin.reflect.y.internal.j0.l.u1.k.d(kotlin.reflect.y.internal.j0.l.u1.j.f24850i, jVar.p());
    }

    private final g1 p(x xVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, e1 e1Var) {
        if (xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.c0) {
            kotlin.reflect.y.internal.j0.d.a.n0.c0 c0Var = (kotlin.reflect.y.internal.j0.d.a.n0.c0) xVar;
            x C = c0Var.C();
            r1 r1Var = c0Var.J() ? r1.OUT_VARIANCE : r1.IN_VARIANCE;
            if (C != null && !h(r1Var, e1Var)) {
                return kotlin.reflect.y.internal.j0.l.x1.a.e(o(C, d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 3, null)), r1Var, e1Var);
            }
            return d.b(e1Var, aVar);
        }
        return new i1(r1.INVARIANT, o(xVar, aVar));
    }

    public final e0 k(f fVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, boolean z) {
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> m0;
        m.f(fVar, "arrayType");
        m.f(aVar, "attr");
        x n = fVar.n();
        kotlin.reflect.y.internal.j0.d.a.n0.v vVar = n instanceof kotlin.reflect.y.internal.j0.d.a.n0.v ? (kotlin.reflect.y.internal.j0.d.a.n0.v) n : null;
        kotlin.reflect.y.internal.j0.b.i type = vVar != null ? vVar.getType() : null;
        kotlin.reflect.y.internal.j0.d.a.l0.d dVar = new kotlin.reflect.y.internal.j0.d.a.l0.d(this.a, fVar, true);
        if (type != null) {
            m0 O = this.a.d().o().O(type);
            m.e(O, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            g.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
            m0 = c0.m0(dVar, O.getAnnotations());
            kotlin.reflect.y.internal.j0.l.x1.a.u(O, aVar2.a(m0));
            return aVar.g() ? O : f0.d(O, O.S0(true));
        }
        e0 o = o(n, d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, aVar.g(), null, 2, null));
        if (aVar.g()) {
            m0 m = this.a.d().o().m(z ? r1.OUT_VARIANCE : r1.INVARIANT, o, dVar);
            m.e(m, "c.module.builtIns.getArr…mponentType, annotations)");
            return m;
        }
        m0 m2 = this.a.d().o().m(r1.INVARIANT, o, dVar);
        m.e(m2, "c.module.builtIns.getArr…mponentType, annotations)");
        return f0.d(m2, this.a.d().o().m(r1.OUT_VARIANCE, o, dVar).S0(true));
    }

    public final e0 o(x xVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        e0 o;
        m0 Z;
        m.f(aVar, "attr");
        if (xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.v) {
            kotlin.reflect.y.internal.j0.b.i type = ((kotlin.reflect.y.internal.j0.d.a.n0.v) xVar).getType();
            if (type != null) {
                Z = this.a.d().o().R(type);
            } else {
                Z = this.a.d().o().Z();
            }
            m.e(Z, "{\n                val pr…ns.unitType\n            }");
            return Z;
        }
        if (xVar instanceof j) {
            return m((j) xVar, aVar);
        }
        if (xVar instanceof f) {
            return l(this, (f) xVar, aVar, false, 4, null);
        }
        if (xVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.c0) {
            x C = ((kotlin.reflect.y.internal.j0.d.a.n0.c0) xVar).C();
            if (C != null && (o = o(C, aVar)) != null) {
                return o;
            }
            m0 y = this.a.d().o().y();
            m.e(y, "c.module.builtIns.defaultBound");
            return y;
        }
        if (xVar == null) {
            m0 y2 = this.a.d().o().y();
            m.e(y2, "c.module.builtIns.defaultBound");
            return y2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }
}
