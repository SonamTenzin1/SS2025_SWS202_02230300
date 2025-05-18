package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes3.dex */
public final class h {
    private static final f0<p<x>> a = new f0<>("KotlinTypeRefiner");

    public static final f0<p<x>> a() {
        return a;
    }

    public static final List<e0> b(g gVar, Iterable<? extends e0> iterable) {
        int u;
        m.f(gVar, "<this>");
        m.f(iterable, "types");
        u = v.u(iterable, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<? extends e0> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a(it.next()));
        }
        return arrayList;
    }
}
