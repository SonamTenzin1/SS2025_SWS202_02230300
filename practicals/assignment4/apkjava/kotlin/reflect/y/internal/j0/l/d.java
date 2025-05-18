package kotlin.reflect.y.internal.j0.l;

import kotlin.reflect.y.internal.j0.l.w1.g;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.m;
import kotlin.reflect.y.internal.j0.l.w1.p;

/* compiled from: AbstractStrictEqualityTypeChecker.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    private final boolean a(p pVar, k kVar, k kVar2) {
        if (pVar.j(kVar) == pVar.j(kVar2) && pVar.W(kVar) == pVar.W(kVar2)) {
            if ((pVar.s0(kVar) == null) == (pVar.s0(kVar2) == null) && pVar.A0(pVar.c(kVar), pVar.c(kVar2))) {
                if (pVar.t0(kVar, kVar2)) {
                    return true;
                }
                int j2 = pVar.j(kVar);
                for (int i2 = 0; i2 < j2; i2++) {
                    m g0 = pVar.g0(kVar, i2);
                    m g02 = pVar.g0(kVar2, i2);
                    if (pVar.L(g0) != pVar.L(g02)) {
                        return false;
                    }
                    if (!pVar.L(g0) && (pVar.j0(g0) != pVar.j0(g02) || !c(pVar, pVar.x0(g0), pVar.x0(g02)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(p pVar, i iVar, i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        k a2 = pVar.a(iVar);
        k a3 = pVar.a(iVar2);
        if (a2 != null && a3 != null) {
            return a(pVar, a2, a3);
        }
        g M = pVar.M(iVar);
        g M2 = pVar.M(iVar2);
        return M != null && M2 != null && a(pVar, pVar.g(M), pVar.g(M2)) && a(pVar, pVar.e(M), pVar.e(M2));
    }

    public final boolean b(p pVar, i iVar, i iVar2) {
        kotlin.jvm.internal.m.f(pVar, "context");
        kotlin.jvm.internal.m.f(iVar, "a");
        kotlin.jvm.internal.m.f(iVar2, "b");
        return c(pVar, iVar, iVar2);
    }
}
