package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.w;
import kotlin.reflect.y.internal.j0.l.y;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final q1 a(List<? extends q1> list) {
        int u;
        int u2;
        m0 W0;
        m.f(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size != 1) {
            u = v.u(list, 10);
            ArrayList arrayList = new ArrayList(u);
            boolean z = false;
            boolean z2 = false;
            for (q1 q1Var : list) {
                z = z || g0.a(q1Var);
                if (q1Var instanceof m0) {
                    W0 = (m0) q1Var;
                } else if (q1Var instanceof y) {
                    if (w.a(q1Var)) {
                        return q1Var;
                    }
                    W0 = ((y) q1Var).W0();
                    z2 = true;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(W0);
            }
            if (z) {
                return k.d(j.y0, list.toString());
            }
            if (!z2) {
                return w.a.c(arrayList);
            }
            u2 = v.u(list, 10);
            ArrayList arrayList2 = new ArrayList(u2);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b0.d((q1) it.next()));
            }
            w wVar = w.a;
            return f0.d(wVar.c(arrayList), wVar.c(arrayList2));
        }
        return (q1) s.s0(list);
    }
}
