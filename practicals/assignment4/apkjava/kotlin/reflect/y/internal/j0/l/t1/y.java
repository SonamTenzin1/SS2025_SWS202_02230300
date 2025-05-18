package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.i.q.a.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.y1.b;

/* compiled from: utils.kt */
/* loaded from: classes3.dex */
public final class y {
    private static final e0 a(e0 e0Var) {
        return b.a(e0Var).d();
    }

    private static final String b(e1 e1Var) {
        StringBuilder sb = new StringBuilder();
        c("type: " + e1Var, sb);
        c("hashCode: " + e1Var.hashCode(), sb);
        c("javaClass: " + e1Var.getClass().getCanonicalName(), sb);
        for (m c2 = e1Var.c(); c2 != null; c2 = c2.b()) {
            c("fqName: " + c.f24252g.q(c2), sb);
            c("javaClass: " + c2.getClass().getCanonicalName(), sb);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        kotlin.jvm.internal.m.f(str, "<this>");
        sb.append(str);
        kotlin.jvm.internal.m.e(sb, "append(value)");
        sb.append('\n');
        kotlin.jvm.internal.m.e(sb, "append('\\n')");
        return sb;
    }

    public static final e0 d(e0 e0Var, e0 e0Var2, v vVar) {
        boolean z;
        kotlin.jvm.internal.m.f(e0Var, "subtype");
        kotlin.jvm.internal.m.f(e0Var2, "supertype");
        kotlin.jvm.internal.m.f(vVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(e0Var, null));
        e1 O0 = e0Var2.O0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            e0 b2 = sVar.b();
            e1 O02 = b2.O0();
            if (vVar.a(O02, O0)) {
                boolean P0 = b2.P0();
                for (s a = sVar.a(); a != null; a = a.a()) {
                    e0 b3 = a.b();
                    List<g1> M0 = b3.M0();
                    if (!(M0 instanceof Collection) || !M0.isEmpty()) {
                        Iterator<T> it = M0.iterator();
                        while (it.hasNext()) {
                            if (((g1) it.next()).a() != r1.INVARIANT) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        e0 n = d.f(f1.f24727c.a(b3), false, 1, null).c().n(b2, r1.INVARIANT);
                        kotlin.jvm.internal.m.e(n, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        b2 = a(n);
                    } else {
                        b2 = f1.f24727c.a(b3).c().n(b2, r1.INVARIANT);
                        kotlin.jvm.internal.m.e(b2, "{\n                    Ty…ARIANT)\n                }");
                    }
                    P0 = P0 || b3.P0();
                }
                e1 O03 = b2.O0();
                if (vVar.a(O03, O0)) {
                    return n1.p(b2, P0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(O03) + ", \n\nsupertype: " + b(O0) + " \n" + vVar.a(O03, O0));
            }
            for (e0 e0Var3 : O02.a()) {
                kotlin.jvm.internal.m.e(e0Var3, "immediateSupertype");
                arrayDeque.add(new s(e0Var3, sVar));
            }
        }
        return null;
    }
}
