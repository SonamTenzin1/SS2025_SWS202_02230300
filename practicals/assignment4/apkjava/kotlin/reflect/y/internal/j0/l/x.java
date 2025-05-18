package kotlin.reflect.y.internal.j0.l;

import java.util.HashSet;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.o;

/* compiled from: expandedTypeUtils.kt */
/* loaded from: classes3.dex */
public final class x {
    public static final i a(m1 m1Var, i iVar) {
        m.f(m1Var, "<this>");
        m.f(iVar, "inlineClassType");
        return b(m1Var, iVar, new HashSet());
    }

    private static final i b(m1 m1Var, i iVar, HashSet<n> hashSet) {
        i b2;
        i C0;
        n w = m1Var.w(iVar);
        if (!hashSet.add(w)) {
            return null;
        }
        o F = m1Var.F(w);
        if (F != null) {
            i m = m1Var.m(F);
            b2 = b(m1Var, m, hashSet);
            if (b2 == null) {
                return null;
            }
            boolean z = m1Var.a0(m1Var.w(m)) || ((m instanceof k) && m1Var.E0((k) m));
            if ((b2 instanceof k) && m1Var.E0((k) b2) && m1Var.p0(iVar) && z) {
                C0 = m1Var.C0(m);
            } else if (!m1Var.p0(b2) && m1Var.o0(iVar)) {
                C0 = m1Var.C0(b2);
            }
            return C0;
        }
        if (!m1Var.a0(w)) {
            return iVar;
        }
        i b0 = m1Var.b0(iVar);
        if (b0 == null || (b2 = b(m1Var, b0, hashSet)) == null) {
            return null;
        }
        if (m1Var.p0(iVar)) {
            return m1Var.p0(b2) ? iVar : ((b2 instanceof k) && m1Var.E0((k) b2)) ? iVar : m1Var.C0(b2);
        }
        return b2;
    }
}
