package kotlin.reflect.y.internal.j0.f;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.s;

/* compiled from: StandardClassIds.kt */
/* loaded from: classes3.dex */
public final class j {
    private static final c a;

    /* renamed from: b, reason: collision with root package name */
    private static final c f24236b;

    static {
        c cVar = new c("java.lang");
        a = cVar;
        c c2 = cVar.c(f.x("annotation"));
        m.e(c2, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        f24236b = c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b j(String str) {
        return new b(i.a.b(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b k(String str) {
        return new b(i.a.e(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b l(String str) {
        return new b(i.a.c(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b m(String str) {
        return new b(i.a.d(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> n(Map<K, ? extends V> map) {
        int u;
        int e2;
        int b2;
        Set<Map.Entry<K, ? extends V>> entrySet = map.entrySet();
        u = v.u(entrySet, 10);
        e2 = p0.e(u);
        b2 = l.b(e2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair a2 = s.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(a2.c(), a2.d());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b o(f fVar) {
        i iVar = i.a;
        return new b(iVar.a().h(), f.x(fVar.u() + iVar.a().j().u()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b p(String str) {
        return new b(i.a.f(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b q(String str) {
        return new b(i.a.g(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b r(b bVar) {
        return new b(i.a.e(), f.x('U' + bVar.j().u()));
    }
}
