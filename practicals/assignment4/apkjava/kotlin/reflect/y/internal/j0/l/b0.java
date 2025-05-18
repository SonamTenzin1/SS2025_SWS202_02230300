package kotlin.reflect.y.internal.j0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;

/* compiled from: flexibleTypes.kt */
/* loaded from: classes3.dex */
public final class b0 {
    public static final y a(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 R0 = e0Var.R0();
        m.d(R0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (y) R0;
    }

    public static final boolean b(e0 e0Var) {
        m.f(e0Var, "<this>");
        return e0Var.R0() instanceof y;
    }

    public static final m0 c(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 R0 = e0Var.R0();
        if (R0 instanceof y) {
            return ((y) R0).W0();
        }
        if (R0 instanceof m0) {
            return (m0) R0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final m0 d(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 R0 = e0Var.R0();
        if (R0 instanceof y) {
            return ((y) R0).X0();
        }
        if (R0 instanceof m0) {
            return (m0) R0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
