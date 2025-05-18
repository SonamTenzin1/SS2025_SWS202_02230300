package kotlin.reflect.y.internal.j0.b.q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* compiled from: mappingUtil.kt */
/* loaded from: classes2.dex */
public final class j {
    public static final f1 a(e eVar, e eVar2) {
        int u;
        int u2;
        List L0;
        Map q;
        m.f(eVar, "from");
        m.f(eVar2, "to");
        eVar.w().size();
        eVar2.w().size();
        f1.a aVar = f1.f24727c;
        List<e1> w = eVar.w();
        m.e(w, "from.declaredTypeParameters");
        u = v.u(w, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = w.iterator();
        while (it.hasNext()) {
            arrayList.add(((e1) it.next()).h());
        }
        List<e1> w2 = eVar2.w();
        m.e(w2, "to.declaredTypeParameters");
        u2 = v.u(w2, 10);
        ArrayList arrayList2 = new ArrayList(u2);
        Iterator<T> it2 = w2.iterator();
        while (it2.hasNext()) {
            m0 s = ((e1) it2.next()).s();
            m.e(s, "it.defaultType");
            arrayList2.add(a.a(s));
        }
        L0 = c0.L0(arrayList, arrayList2);
        q = q0.q(L0);
        return f1.a.e(aVar, q, false, 2, null);
    }
}
