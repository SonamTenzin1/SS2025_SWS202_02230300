package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.b;

/* compiled from: CompanionObjectMapping.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<b> f23156b;

    static {
        int u;
        List p0;
        List p02;
        List p03;
        Set<i> set = i.f23173g;
        u = v.u(set, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.c((i) it.next()));
        }
        kotlin.reflect.y.internal.j0.f.c l = k.a.f23207h.l();
        m.e(l, "string.toSafe()");
        p0 = c0.p0(arrayList, l);
        kotlin.reflect.y.internal.j0.f.c l2 = k.a.f23209j.l();
        m.e(l2, "_boolean.toSafe()");
        p02 = c0.p0(p0, l2);
        kotlin.reflect.y.internal.j0.f.c l3 = k.a.s.l();
        m.e(l3, "_enum.toSafe()");
        p03 = c0.p0(p02, l3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = p03.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(b.m((kotlin.reflect.y.internal.j0.f.c) it2.next()));
        }
        f23156b = linkedHashSet;
    }

    private c() {
    }

    public final Set<b> a() {
        return f23156b;
    }

    public final Set<b> b() {
        return f23156b;
    }
}
