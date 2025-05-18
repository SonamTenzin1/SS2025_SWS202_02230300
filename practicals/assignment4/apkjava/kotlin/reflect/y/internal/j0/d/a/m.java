package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.i;
import kotlin.s;

/* compiled from: FakePureImplementationsProvider.kt */
/* loaded from: classes2.dex */
public final class m {
    public static final m a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<b, b> f23595b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<c, c> f23596c;

    static {
        Map<c, c> q;
        m mVar = new m();
        a = mVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f23595b = linkedHashMap;
        i iVar = i.a;
        mVar.c(iVar.j(), mVar.a("java.util.ArrayList", "java.util.LinkedList"));
        mVar.c(iVar.l(), mVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        mVar.c(iVar.k(), mVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b m = b.m(new c("java.util.function.Function"));
        kotlin.jvm.internal.m.e(m, "topLevel(FqName(\"java.util.function.Function\"))");
        mVar.c(m, mVar.a("java.util.function.UnaryOperator"));
        b m2 = b.m(new c("java.util.function.BiFunction"));
        kotlin.jvm.internal.m.e(m2, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        mVar.c(m2, mVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(s.a(((b) entry.getKey()).b(), ((b) entry.getValue()).b()));
        }
        q = q0.q(arrayList);
        f23596c = q;
    }

    private m() {
    }

    private final List<b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(b.m(new c(str)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c(b bVar, List<b> list) {
        Map<b, b> map = f23595b;
        for (Object obj : list) {
            map.put(obj, bVar);
        }
    }

    public final c b(c cVar) {
        kotlin.jvm.internal.m.f(cVar, "classFqName");
        return f23596c.get(cVar);
    }
}
