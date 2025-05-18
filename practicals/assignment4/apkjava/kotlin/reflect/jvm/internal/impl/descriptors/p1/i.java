package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* compiled from: CompositePackageFragmentProvider.kt */
/* loaded from: classes2.dex */
public final class i implements o0 {
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.l0> a;

    /* renamed from: b, reason: collision with root package name */
    private final String f25243b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.l0> list, String str) {
        Set I0;
        kotlin.jvm.internal.m.f(list, "providers");
        kotlin.jvm.internal.m.f(str, "debugName");
        this.a = list;
        this.f25243b = str;
        list.size();
        I0 = kotlin.collections.c0.I0(list);
        I0.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.k0> a(kotlin.reflect.y.internal.j0.f.c cVar) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.k0> E0;
        kotlin.jvm.internal.m.f(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.l0> it = this.a.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.n0.a(it.next(), cVar, arrayList);
        }
        E0 = kotlin.collections.c0.E0(arrayList);
        return E0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public void b(kotlin.reflect.y.internal.j0.f.c cVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.k0> collection) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(collection, "packageFragments");
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.l0> it = this.a.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.n0.a(it.next(), cVar, collection);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public boolean c(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        List<kotlin.reflect.jvm.internal.impl.descriptors.l0> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!kotlin.reflect.jvm.internal.impl.descriptors.n0.b((kotlin.reflect.jvm.internal.impl.descriptors.l0) it.next(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public Collection<kotlin.reflect.y.internal.j0.f.c> p(kotlin.reflect.y.internal.j0.f.c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.l0> it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().p(cVar, function1));
        }
        return hashSet;
    }

    public String toString() {
        return this.f25243b;
    }
}
