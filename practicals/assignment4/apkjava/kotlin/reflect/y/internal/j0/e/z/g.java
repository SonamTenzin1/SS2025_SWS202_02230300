package kotlin.reflect.y.internal.j0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.t;

/* compiled from: TypeTable.kt */
/* loaded from: classes3.dex */
public final class g {
    private final List<q> a;

    public g(t tVar) {
        int u;
        m.f(tVar, "typeTable");
        List<q> A = tVar.A();
        if (tVar.B()) {
            int x = tVar.x();
            List<q> A2 = tVar.A();
            m.e(A2, "typeTable.typeList");
            u = v.u(A2, 10);
            ArrayList arrayList = new ArrayList(u);
            int i2 = 0;
            for (Object obj : A2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    u.t();
                }
                q qVar = (q) obj;
                if (i2 >= x) {
                    qVar = qVar.d().M(true).c();
                }
                arrayList.add(qVar);
                i2 = i3;
            }
            A = arrayList;
        }
        m.e(A, "run {\n        val origin… else originalTypes\n    }");
        this.a = A;
    }

    public final q a(int i2) {
        return this.a.get(i2);
    }
}
