package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: CycleDetector.java */
/* loaded from: classes2.dex */
class u {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CycleDetector.java */
    /* loaded from: classes2.dex */
    public static class b {
        private final n<?> a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<b> f18910b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set<b> f18911c = new HashSet();

        b(n<?> nVar) {
            this.a = nVar;
        }

        void a(b bVar) {
            this.f18910b.add(bVar);
        }

        void b(b bVar) {
            this.f18911c.add(bVar);
        }

        n<?> c() {
            return this.a;
        }

        Set<b> d() {
            return this.f18910b;
        }

        boolean e() {
            return this.f18910b.isEmpty();
        }

        boolean f() {
            return this.f18911c.isEmpty();
        }

        void g(b bVar) {
            this.f18911c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CycleDetector.java */
    /* loaded from: classes2.dex */
    public static class c {
        private final b0<?> a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f18912b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a.equals(this.a) && cVar.f18912b == this.f18912b;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f18912b).hashCode();
        }

        private c(b0<?> b0Var, boolean z) {
            this.a = b0Var;
            this.f18912b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<n<?>> list) {
        Set<b> c2 = c(list);
        Set<b> b2 = b(c2);
        int i2 = 0;
        while (!b2.isEmpty()) {
            b next = b2.iterator().next();
            b2.remove(next);
            i2++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b2.add(bVar);
                }
            }
        }
        if (i2 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c2) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<n<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<n<?>> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                n<?> next = it.next();
                b bVar = new b(next);
                for (b0<? super Object> b0Var : next.h()) {
                    c cVar = new c(b0Var, !next.n());
                    if (!hashMap.containsKey(cVar)) {
                        hashMap.put(cVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar);
                    if (!set2.isEmpty() && !cVar.f18912b) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                    }
                    set2.add(bVar);
                }
            } else {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar2 : (Set) it2.next()) {
                        for (v vVar : bVar2.c().e()) {
                            if (vVar.e() && (set = (Set) hashMap.get(new c(vVar.c(), vVar.g()))) != null) {
                                for (b bVar3 : set) {
                                    bVar2.a(bVar3);
                                    bVar3.b(bVar2);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
        }
    }
}
