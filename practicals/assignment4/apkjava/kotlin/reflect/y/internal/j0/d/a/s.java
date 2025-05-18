package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.jvm.internal.g;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.d.a.h0;
import kotlin.reflect.y.internal.j0.d.a.k0.c;
import kotlin.reflect.y.internal.j0.d.b.l;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.e;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* loaded from: classes2.dex */
public final class s implements e {
    public static final a a = new a(null);

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final boolean b(y yVar) {
            if (yVar.f().size() != 1) {
                return false;
            }
            m b2 = yVar.b();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = b2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) b2 : null;
            if (eVar == null) {
                return false;
            }
            List<i1> f2 = yVar.f();
            kotlin.jvm.internal.m.e(f2, "f.valueParameters");
            h w = ((i1) kotlin.collections.s.s0(f2)).getType().O0().w();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) w : null;
            return eVar2 != null && kotlin.reflect.y.internal.j0.b.h.q0(eVar) && kotlin.jvm.internal.m.a(kotlin.reflect.y.internal.j0.i.t.a.h(eVar), kotlin.reflect.y.internal.j0.i.t.a.h(eVar2));
        }

        private final l c(y yVar, i1 i1Var) {
            if (!v.e(yVar) && !b(yVar)) {
                e0 type = i1Var.getType();
                kotlin.jvm.internal.m.e(type, "valueParameterDescriptor.type");
                return v.g(type);
            }
            e0 type2 = i1Var.getType();
            kotlin.jvm.internal.m.e(type2, "valueParameterDescriptor.type");
            return v.g(kotlin.reflect.y.internal.j0.l.x1.a.t(type2));
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            List<Pair> L0;
            kotlin.jvm.internal.m.f(aVar, "superDescriptor");
            kotlin.jvm.internal.m.f(aVar2, "subDescriptor");
            if ((aVar2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e) && (aVar instanceof y)) {
                kotlin.reflect.y.internal.j0.d.a.k0.e eVar = (kotlin.reflect.y.internal.j0.d.a.k0.e) aVar2;
                eVar.f().size();
                y yVar = (y) aVar;
                yVar.f().size();
                List<i1> f2 = eVar.a().f();
                kotlin.jvm.internal.m.e(f2, "subDescriptor.original.valueParameters");
                List<i1> f3 = yVar.a().f();
                kotlin.jvm.internal.m.e(f3, "superDescriptor.original.valueParameters");
                L0 = c0.L0(f2, f3);
                for (Pair pair : L0) {
                    i1 i1Var = (i1) pair.a();
                    i1 i1Var2 = (i1) pair.b();
                    kotlin.jvm.internal.m.e(i1Var, "subParameter");
                    boolean z = c((y) aVar2, i1Var) instanceof l.d;
                    kotlin.jvm.internal.m.e(i1Var2, "superParameter");
                    if (z != (c(yVar, i1Var2) instanceof l.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if ((aVar instanceof b) && (aVar2 instanceof y) && !kotlin.reflect.y.internal.j0.b.h.f0(aVar2)) {
            f fVar = f.n;
            y yVar = (y) aVar2;
            f name = yVar.getName();
            kotlin.jvm.internal.m.e(name, "subDescriptor.name");
            if (!fVar.l(name)) {
                h0.a aVar3 = h0.a;
                f name2 = yVar.getName();
                kotlin.jvm.internal.m.e(name2, "subDescriptor.name");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            b e2 = g0.e((b) aVar);
            boolean z = aVar instanceof y;
            y yVar2 = z ? (y) aVar : null;
            if ((!(yVar2 != null && yVar.w0() == yVar2.w0())) && (e2 == null || !yVar.w0())) {
                return true;
            }
            if ((eVar instanceof c) && yVar.d0() == null && e2 != null && !g0.f(eVar, e2)) {
                if ((e2 instanceof y) && z && f.k((y) e2) != null) {
                    String c2 = v.c(yVar, false, false, 2, null);
                    y a2 = ((y) aVar).a();
                    kotlin.jvm.internal.m.e(a2, "superDescriptor.original");
                    if (kotlin.jvm.internal.m.a(c2, v.c(a2, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.i.e
    public e.a a() {
        return e.a.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.y.internal.j0.i.e
    public e.b b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(aVar, "superDescriptor");
        kotlin.jvm.internal.m.f(aVar2, "subDescriptor");
        if (c(aVar, aVar2, eVar)) {
            return e.b.INCOMPATIBLE;
        }
        if (a.a(aVar, aVar2)) {
            return e.b.INCOMPATIBLE;
        }
        return e.b.UNKNOWN;
    }
}
