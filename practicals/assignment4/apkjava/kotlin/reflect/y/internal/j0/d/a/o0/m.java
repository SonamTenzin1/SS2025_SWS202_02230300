package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.collections.n;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.s;
import kotlin.u;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes3.dex */
final class m {
    private final Map<String, k> a = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    /* loaded from: classes3.dex */
    public final class a {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f23670b;

        /* compiled from: predefinedEnhancementInfo.kt */
        /* renamed from: kotlin.f0.y.e.j0.d.a.o0.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0339a {
            private final String a;

            /* renamed from: b, reason: collision with root package name */
            private final List<Pair<String, q>> f23671b;

            /* renamed from: c, reason: collision with root package name */
            private Pair<String, q> f23672c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f23673d;

            public C0339a(a aVar, String str) {
                kotlin.jvm.internal.m.f(str, "functionName");
                this.f23673d = aVar;
                this.a = str;
                this.f23671b = new ArrayList();
                this.f23672c = s.a("V", null);
            }

            public final Pair<String, k> a() {
                int u;
                int u2;
                x xVar = x.a;
                String b2 = this.f23673d.b();
                String str = this.a;
                List<Pair<String, q>> list = this.f23671b;
                u = v.u(list, 10);
                ArrayList arrayList = new ArrayList(u);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).c());
                }
                String k2 = xVar.k(b2, xVar.j(str, arrayList, this.f23672c.c()));
                q d2 = this.f23672c.d();
                List<Pair<String, q>> list2 = this.f23671b;
                u2 = v.u(list2, 10);
                ArrayList arrayList2 = new ArrayList(u2);
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((q) ((Pair) it2.next()).d());
                }
                return s.a(k2, new k(d2, arrayList2));
            }

            public final void b(String str, e... eVarArr) {
                Iterable<IndexedValue> m0;
                int u;
                int e2;
                int b2;
                q qVar;
                kotlin.jvm.internal.m.f(str, "type");
                kotlin.jvm.internal.m.f(eVarArr, "qualifiers");
                List<Pair<String, q>> list = this.f23671b;
                if (eVarArr.length == 0) {
                    qVar = null;
                } else {
                    m0 = n.m0(eVarArr);
                    u = v.u(m0, 10);
                    e2 = p0.e(u);
                    b2 = l.b(e2, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                    for (IndexedValue indexedValue : m0) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                    }
                    qVar = new q(linkedHashMap);
                }
                list.add(s.a(str, qVar));
            }

            public final void c(String str, e... eVarArr) {
                Iterable<IndexedValue> m0;
                int u;
                int e2;
                int b2;
                kotlin.jvm.internal.m.f(str, "type");
                kotlin.jvm.internal.m.f(eVarArr, "qualifiers");
                m0 = n.m0(eVarArr);
                u = v.u(m0, 10);
                e2 = p0.e(u);
                b2 = l.b(e2, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                for (IndexedValue indexedValue : m0) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.c()), (e) indexedValue.d());
                }
                this.f23672c = s.a(str, new q(linkedHashMap));
            }

            public final void d(e eVar) {
                kotlin.jvm.internal.m.f(eVar, "type");
                String u = eVar.u();
                kotlin.jvm.internal.m.e(u, "type.desc");
                this.f23672c = s.a(u, null);
            }
        }

        public a(m mVar, String str) {
            kotlin.jvm.internal.m.f(str, "className");
            this.f23670b = mVar;
            this.a = str;
        }

        public final void a(String str, Function1<? super C0339a, u> function1) {
            kotlin.jvm.internal.m.f(str, "name");
            kotlin.jvm.internal.m.f(function1, "block");
            Map map = this.f23670b.a;
            C0339a c0339a = new C0339a(this, str);
            function1.invoke(c0339a);
            Pair<String, k> a = c0339a.a();
            map.put(a.c(), a.d());
        }

        public final String b() {
            return this.a;
        }
    }

    public final Map<String, k> b() {
        return this.a;
    }
}
