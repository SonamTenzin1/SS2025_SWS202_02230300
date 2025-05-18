package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.s;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<c, f> f23371b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<f, List<f>> f23372c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<c> f23373d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<f> f23374e;

    static {
        c d2;
        c d3;
        c c2;
        c c3;
        c d4;
        c c4;
        c c5;
        c c6;
        Map<c, f> l;
        int u;
        int e2;
        int u2;
        Set<f> I0;
        List L;
        d dVar = k.a.s;
        d2 = h.d(dVar, "name");
        d3 = h.d(dVar, "ordinal");
        c2 = h.c(k.a.U, "size");
        c cVar = k.a.Y;
        c3 = h.c(cVar, "size");
        d4 = h.d(k.a.f23206g, "length");
        c4 = h.c(cVar, "keys");
        c5 = h.c(cVar, "values");
        c6 = h.c(cVar, "entries");
        l = q0.l(s.a(d2, f.x("name")), s.a(d3, f.x("ordinal")), s.a(c2, f.x("size")), s.a(c3, f.x("size")), s.a(d4, f.x("length")), s.a(c4, f.x("keySet")), s.a(c5, f.x("values")), s.a(c6, f.x("entrySet")));
        f23371b = l;
        Set<Map.Entry<c, f>> entrySet = l.entrySet();
        u = v.u(entrySet, 10);
        ArrayList<Pair> arrayList = new ArrayList(u);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((c) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            f fVar = (f) pair.d();
            Object obj = linkedHashMap.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(fVar, obj);
            }
            ((List) obj).add((f) pair.c());
        }
        e2 = p0.e(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            L = c0.L((Iterable) entry2.getValue());
            linkedHashMap2.put(key, L);
        }
        f23372c = linkedHashMap2;
        Set<c> keySet = f23371b.keySet();
        f23373d = keySet;
        u2 = v.u(keySet, 10);
        ArrayList arrayList2 = new ArrayList(u2);
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((c) it2.next()).g());
        }
        I0 = c0.I0(arrayList2);
        f23374e = I0;
    }

    private g() {
    }

    public final Map<c, f> a() {
        return f23371b;
    }

    public final List<f> b(f fVar) {
        List<f> j2;
        m.f(fVar, "name1");
        List<f> list = f23372c.get(fVar);
        if (list != null) {
            return list;
        }
        j2 = u.j();
        return j2;
    }

    public final Set<c> c() {
        return f23373d;
    }

    public final Set<f> d() {
        return f23374e;
    }
}
