package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.x0;

/* compiled from: TypeAliasExpander.kt */
/* loaded from: classes3.dex */
public final class v0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final v0 f24860b = new v0(x0.a.a, false);

    /* renamed from: c, reason: collision with root package name */
    private final x0 f24861c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f24862d;

    /* compiled from: TypeAliasExpander.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i2, d1 d1Var) {
            if (i2 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + d1Var.getName());
        }
    }

    public v0(x0 x0Var, boolean z) {
        m.f(x0Var, "reportStrategy");
        this.f24861c = x0Var;
        this.f24862d = z;
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().d());
        }
        for (c cVar : gVar2) {
            if (hashSet.contains(cVar.d())) {
                this.f24861c.a(cVar);
            }
        }
    }

    private final void b(e0 e0Var, e0 e0Var2) {
        l1 f2 = l1.f(e0Var2);
        m.e(f2, "create(substitutedType)");
        int i2 = 0;
        for (Object obj : e0Var2.M0()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            g1 g1Var = (g1) obj;
            if (!g1Var.c()) {
                e0 type = g1Var.getType();
                m.e(type, "substitutedArgument.type");
                if (!kotlin.reflect.y.internal.j0.l.x1.a.d(type)) {
                    g1 g1Var2 = e0Var.M0().get(i2);
                    e1 e1Var = e0Var.O0().getParameters().get(i2);
                    if (this.f24862d) {
                        x0 x0Var = this.f24861c;
                        e0 type2 = g1Var2.getType();
                        m.e(type2, "unsubstitutedArgument.type");
                        e0 type3 = g1Var.getType();
                        m.e(type3, "substitutedArgument.type");
                        m.e(e1Var, "typeParameter");
                        x0Var.c(f2, type2, type3, e1Var);
                    }
                }
            }
            i2 = i3;
        }
    }

    private final v c(v vVar, a1 a1Var) {
        return vVar.U0(h(vVar, a1Var));
    }

    private final m0 d(m0 m0Var, a1 a1Var) {
        return g0.a(m0Var) ? m0Var : k1.f(m0Var, null, h(m0Var, a1Var), 1, null);
    }

    private final m0 e(m0 m0Var, e0 e0Var) {
        m0 r = n1.r(m0Var, e0Var.P0());
        m.e(r, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return r;
    }

    private final m0 f(m0 m0Var, e0 e0Var) {
        return d(e(m0Var, e0Var), e0Var.N0());
    }

    private final m0 g(w0 w0Var, a1 a1Var, boolean z) {
        e1 h2 = w0Var.b().h();
        m.e(h2, "descriptor.typeConstructor");
        return f0.j(a1Var, h2, w0Var.a(), z, h.b.f24422b);
    }

    private final a1 h(e0 e0Var, a1 a1Var) {
        return g0.a(e0Var) ? e0Var.N0() : a1Var.n(e0Var.N0());
    }

    private final g1 j(g1 g1Var, w0 w0Var, int i2) {
        int u;
        q1 R0 = g1Var.getType().R0();
        if (w.a(R0)) {
            return g1Var;
        }
        m0 a2 = k1.a(R0);
        if (g0.a(a2) || !kotlin.reflect.y.internal.j0.l.x1.a.x(a2)) {
            return g1Var;
        }
        e1 O0 = a2.O0();
        kotlin.reflect.jvm.internal.impl.descriptors.h w = O0.w();
        O0.getParameters().size();
        a2.M0().size();
        if (w instanceof e1) {
            return g1Var;
        }
        if (w instanceof d1) {
            d1 d1Var = (d1) w;
            int i3 = 0;
            if (w0Var.d(d1Var)) {
                this.f24861c.d(d1Var);
                r1 r1Var = r1.INVARIANT;
                j jVar = j.v;
                String fVar = d1Var.getName().toString();
                m.e(fVar, "typeDescriptor.name.toString()");
                return new i1(r1Var, k.d(jVar, fVar));
            }
            List<g1> M0 = a2.M0();
            u = v.u(M0, 10);
            ArrayList arrayList = new ArrayList(u);
            for (Object obj : M0) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    u.t();
                }
                arrayList.add(l((g1) obj, w0Var, O0.getParameters().get(i3), i2 + 1));
                i3 = i4;
            }
            m0 k2 = k(w0.a.a(w0Var, d1Var, arrayList), a2.N0(), a2.P0(), i2 + 1, false);
            m0 m = m(a2, w0Var, i2);
            if (!w.a(k2)) {
                k2 = q0.j(k2, m);
            }
            return new i1(g1Var.a(), k2);
        }
        m0 m2 = m(a2, w0Var, i2);
        b(a2, m2);
        return new i1(g1Var.a(), m2);
    }

    private final m0 k(w0 w0Var, a1 a1Var, boolean z, int i2, boolean z2) {
        g1 l = l(new i1(r1.INVARIANT, w0Var.b().g0()), w0Var, null, i2);
        e0 type = l.getType();
        m.e(type, "expandedProjection.type");
        m0 a2 = k1.a(type);
        if (g0.a(a2)) {
            return a2;
        }
        l.a();
        a(a2.getAnnotations(), k.a(a1Var));
        m0 r = n1.r(d(a2, a1Var), z);
        m.e(r, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        return z2 ? q0.j(r, g(w0Var, a1Var, z)) : r;
    }

    private final g1 l(g1 g1Var, w0 w0Var, e1 e1Var, int i2) {
        r1 r1Var;
        e0 f2;
        r1 r1Var2;
        r1 r1Var3;
        a.b(i2, w0Var.b());
        if (g1Var.c()) {
            m.c(e1Var);
            g1 s = n1.s(e1Var);
            m.e(s, "makeStarProjection(typeParameterDescriptor!!)");
            return s;
        }
        e0 type = g1Var.getType();
        m.e(type, "underlyingProjection.type");
        g1 c2 = w0Var.c(type.O0());
        if (c2 == null) {
            return j(g1Var, w0Var, i2);
        }
        if (c2.c()) {
            m.c(e1Var);
            g1 s2 = n1.s(e1Var);
            m.e(s2, "makeStarProjection(typeParameterDescriptor!!)");
            return s2;
        }
        q1 R0 = c2.getType().R0();
        r1 a2 = c2.a();
        m.e(a2, "argument.projectionKind");
        r1 a3 = g1Var.a();
        m.e(a3, "underlyingProjection.projectionKind");
        if (a3 != a2 && a3 != (r1Var3 = r1.INVARIANT)) {
            if (a2 == r1Var3) {
                a2 = a3;
            } else {
                this.f24861c.b(w0Var.b(), e1Var, R0);
            }
        }
        if (e1Var == null || (r1Var = e1Var.n()) == null) {
            r1Var = r1.INVARIANT;
        }
        m.e(r1Var, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (r1Var != a2 && r1Var != (r1Var2 = r1.INVARIANT)) {
            if (a2 == r1Var2) {
                a2 = r1Var2;
            } else {
                this.f24861c.b(w0Var.b(), e1Var, R0);
            }
        }
        a(type.getAnnotations(), R0.getAnnotations());
        if (R0 instanceof v) {
            f2 = c((v) R0, type.N0());
        } else {
            f2 = f(k1.a(R0), type);
        }
        return new i1(a2, f2);
    }

    private final m0 m(m0 m0Var, w0 w0Var, int i2) {
        int u;
        e1 O0 = m0Var.O0();
        List<g1> M0 = m0Var.M0();
        u = v.u(M0, 10);
        ArrayList arrayList = new ArrayList(u);
        int i3 = 0;
        for (Object obj : M0) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                u.t();
            }
            g1 g1Var = (g1) obj;
            g1 l = l(g1Var, w0Var, O0.getParameters().get(i3), i2 + 1);
            if (!l.c()) {
                l = new i1(l.a(), n1.q(l.getType(), g1Var.getType().P0()));
            }
            arrayList.add(l);
            i3 = i4;
        }
        return k1.f(m0Var, arrayList, null, 2, null);
    }

    public final m0 i(w0 w0Var, a1 a1Var) {
        m.f(w0Var, "typeAliasExpansion");
        m.f(a1Var, "attributes");
        return k(w0Var, a1Var, false, 0, true);
    }
}
