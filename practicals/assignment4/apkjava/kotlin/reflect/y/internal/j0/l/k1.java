package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.l;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public final class k1 {
    public static final m0 a(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 R0 = e0Var.R0();
        m0 m0Var = R0 instanceof m0 ? (m0) R0 : null;
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalStateException(("This is should be simple type: " + e0Var).toString());
    }

    public static final e0 b(e0 e0Var, List<? extends g1> list, g gVar) {
        m.f(e0Var, "<this>");
        m.f(list, "newArguments");
        m.f(gVar, "newAnnotations");
        return e(e0Var, list, gVar, null, 4, null);
    }

    public static final e0 c(e0 e0Var, List<? extends g1> list, g gVar, List<? extends g1> list2) {
        m.f(e0Var, "<this>");
        m.f(list, "newArguments");
        m.f(gVar, "newAnnotations");
        m.f(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == e0Var.M0()) && gVar == e0Var.getAnnotations()) {
            return e0Var;
        }
        a1 N0 = e0Var.N0();
        if ((gVar instanceof l) && gVar.isEmpty()) {
            gVar = g.f25179c.b();
        }
        a1 a = b1.a(N0, gVar);
        q1 R0 = e0Var.R0();
        if (R0 instanceof y) {
            y yVar = (y) R0;
            return f0.d(d(yVar.W0(), list, a), d(yVar.X0(), list2, a));
        }
        if (R0 instanceof m0) {
            return d((m0) R0, list, a);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final m0 d(m0 m0Var, List<? extends g1> list, a1 a1Var) {
        m.f(m0Var, "<this>");
        m.f(list, "newArguments");
        m.f(a1Var, "newAttributes");
        if (list.isEmpty() && a1Var == m0Var.N0()) {
            return m0Var;
        }
        if (list.isEmpty()) {
            return m0Var.U0(a1Var);
        }
        return f0.i(a1Var, m0Var.O0(), list, m0Var.P0(), null, 16, null);
    }

    public static /* synthetic */ e0 e(e0 e0Var, List list, g gVar, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = e0Var.M0();
        }
        if ((i2 & 2) != 0) {
            gVar = e0Var.getAnnotations();
        }
        if ((i2 & 4) != 0) {
            list2 = list;
        }
        return c(e0Var, list, gVar, list2);
    }

    public static /* synthetic */ m0 f(m0 m0Var, List list, a1 a1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = m0Var.M0();
        }
        if ((i2 & 2) != 0) {
            a1Var = m0Var.N0();
        }
        return d(m0Var, list, a1Var);
    }
}
