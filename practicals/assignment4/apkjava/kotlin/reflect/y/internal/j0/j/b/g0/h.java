package kotlin.reflect.y.internal.j0.j.b.g0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.collections.x0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.y;
import kotlin.ranges.l;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.i.w.i;
import kotlin.reflect.y.internal.j0.j.b.m;
import kotlin.reflect.y.internal.j0.j.b.w;
import kotlin.reflect.y.internal.j0.j.b.x;
import kotlin.reflect.y.internal.j0.k.g;
import kotlin.reflect.y.internal.j0.k.j;
import kotlin.sequences.Sequence;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public abstract class h extends i {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f24524b = {g0.h(new y(g0.b(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), g0.h(new y(g0.b(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* renamed from: c, reason: collision with root package name */
    private final m f24525c;

    /* renamed from: d, reason: collision with root package name */
    private final a f24526d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f24527e;

    /* renamed from: f, reason: collision with root package name */
    private final j f24528f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public interface a {
        Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar);

        Set<f> b();

        Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar);

        Set<f> d();

        Set<f> e();

        void f(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1, kotlin.reflect.y.internal.j0.c.b.b bVar);

        d1 g(f fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public final class b implements a {
        static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), g0.h(new y(g0.b(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), g0.h(new y(g0.b(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), g0.h(new y(g0.b(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), g0.h(new y(g0.b(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), g0.h(new y(g0.b(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), g0.h(new y(g0.b(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), g0.h(new y(g0.b(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), g0.h(new y(g0.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), g0.h(new y(g0.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: b, reason: collision with root package name */
        private final List<kotlin.reflect.y.internal.j0.e.i> f24529b;

        /* renamed from: c, reason: collision with root package name */
        private final List<n> f24530c;

        /* renamed from: d, reason: collision with root package name */
        private final List<r> f24531d;

        /* renamed from: e, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24532e;

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24533f;

        /* renamed from: g, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24534g;

        /* renamed from: h, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24535h;

        /* renamed from: i, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24536i;

        /* renamed from: j, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24537j;

        /* renamed from: k, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24538k;
        private final kotlin.reflect.y.internal.j0.k.i l;
        private final kotlin.reflect.y.internal.j0.k.i m;
        private final kotlin.reflect.y.internal.j0.k.i n;
        final /* synthetic */ h o;

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function0<List<? extends y0>> {
            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends y0> invoke() {
                List<? extends y0> o0;
                o0 = c0.o0(b.this.D(), b.this.t());
                return o0;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: kotlin.f0.y.e.j0.j.b.g0.h$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0388b extends Lambda implements Function0<List<? extends t0>> {
            C0388b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends t0> invoke() {
                List<? extends t0> o0;
                o0 = c0.o0(b.this.E(), b.this.u());
                return o0;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class c extends Lambda implements Function0<List<? extends d1>> {
            c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends d1> invoke() {
                return b.this.z();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class d extends Lambda implements Function0<List<? extends y0>> {
            d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends y0> invoke() {
                return b.this.v();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class e extends Lambda implements Function0<List<? extends t0>> {
            e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends t0> invoke() {
                return b.this.y();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class f extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f24545g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.f24545g = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                Set<kotlin.reflect.y.internal.j0.f.f> l;
                b bVar = b.this;
                List list = bVar.f24529b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(x.b(hVar.p().g(), ((kotlin.reflect.y.internal.j0.e.i) ((o) it.next())).e0()));
                }
                l = x0.l(linkedHashSet, this.f24545g.t());
                return l;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class g extends Lambda implements Function0<Map<kotlin.reflect.y.internal.j0.f.f, ? extends List<? extends y0>>> {
            g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Map<kotlin.reflect.y.internal.j0.f.f, List<y0>> invoke() {
                List A = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : A) {
                    kotlin.reflect.y.internal.j0.f.f name = ((y0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: kotlin.f0.y.e.j0.j.b.g0.h$b$h, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0389h extends Lambda implements Function0<Map<kotlin.reflect.y.internal.j0.f.f, ? extends List<? extends t0>>> {
            C0389h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Map<kotlin.reflect.y.internal.j0.f.f, List<t0>> invoke() {
                List B = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : B) {
                    kotlin.reflect.y.internal.j0.f.f name = ((t0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class i extends Lambda implements Function0<Map<kotlin.reflect.y.internal.j0.f.f, ? extends d1>> {
            i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Map<kotlin.reflect.y.internal.j0.f.f, d1> invoke() {
                int u;
                int e2;
                int b2;
                List C = b.this.C();
                u = v.u(C, 10);
                e2 = p0.e(u);
                b2 = l.b(e2, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                for (Object obj : C) {
                    kotlin.reflect.y.internal.j0.f.f name = ((d1) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class j extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f24550g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(h hVar) {
                super(0);
                this.f24550g = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                Set<kotlin.reflect.y.internal.j0.f.f> l;
                b bVar = b.this;
                List list = bVar.f24530c;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(x.b(hVar.p().g(), ((n) ((o) it.next())).d0()));
                }
                l = x0.l(linkedHashSet, this.f24550g.u());
                return l;
            }
        }

        public b(h hVar, List<kotlin.reflect.y.internal.j0.e.i> list, List<n> list2, List<r> list3) {
            kotlin.jvm.internal.m.f(list, "functionList");
            kotlin.jvm.internal.m.f(list2, "propertyList");
            kotlin.jvm.internal.m.f(list3, "typeAliasList");
            this.o = hVar;
            this.f24529b = list;
            this.f24530c = list2;
            this.f24531d = hVar.p().c().g().f() ? list3 : u.j();
            this.f24532e = hVar.p().h().d(new d());
            this.f24533f = hVar.p().h().d(new e());
            this.f24534g = hVar.p().h().d(new c());
            this.f24535h = hVar.p().h().d(new a());
            this.f24536i = hVar.p().h().d(new C0388b());
            this.f24537j = hVar.p().h().d(new i());
            this.f24538k = hVar.p().h().d(new g());
            this.l = hVar.p().h().d(new C0389h());
            this.m = hVar.p().h().d(new f(hVar));
            this.n = hVar.p().h().d(new j(hVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<y0> A() {
            return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24535h, this, a[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<t0> B() {
            return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24536i, this, a[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<d1> C() {
            return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24534g, this, a[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<y0> D() {
            return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24532e, this, a[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<t0> E() {
            return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24533f, this, a[1]);
        }

        private final Map<kotlin.reflect.y.internal.j0.f.f, Collection<y0>> F() {
            return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f24538k, this, a[6]);
        }

        private final Map<kotlin.reflect.y.internal.j0.f.f, Collection<t0>> G() {
            return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.l, this, a[7]);
        }

        private final Map<kotlin.reflect.y.internal.j0.f.f, d1> H() {
            return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f24537j, this, a[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<y0> t() {
            Set<kotlin.reflect.y.internal.j0.f.f> t = this.o.t();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = t.iterator();
            while (it.hasNext()) {
                z.z(arrayList, w((kotlin.reflect.y.internal.j0.f.f) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<t0> u() {
            Set<kotlin.reflect.y.internal.j0.f.f> u = this.o.u();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = u.iterator();
            while (it.hasNext()) {
                z.z(arrayList, x((kotlin.reflect.y.internal.j0.f.f) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<y0> v() {
            List<kotlin.reflect.y.internal.j0.e.i> list = this.f24529b;
            h hVar = this.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                y0 j2 = hVar.p().f().j((kotlin.reflect.y.internal.j0.e.i) ((o) it.next()));
                if (!hVar.x(j2)) {
                    j2 = null;
                }
                if (j2 != null) {
                    arrayList.add(j2);
                }
            }
            return arrayList;
        }

        private final List<y0> w(kotlin.reflect.y.internal.j0.f.f fVar) {
            List<y0> D = D();
            h hVar = this.o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : D) {
                if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.k(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<t0> x(kotlin.reflect.y.internal.j0.f.f fVar) {
            List<t0> E = E();
            h hVar = this.o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : E) {
                if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            hVar.l(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<t0> y() {
            List<n> list = this.f24530c;
            h hVar = this.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                t0 l = hVar.p().f().l((n) ((o) it.next()));
                if (l != null) {
                    arrayList.add(l);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<d1> z() {
            List<r> list = this.f24531d;
            h hVar = this.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                d1 m = hVar.p().f().m((r) ((o) it.next()));
                if (m != null) {
                    arrayList.add(m);
                }
            }
            return arrayList;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Collection<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            List j2;
            List j3;
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (!b().contains(fVar)) {
                j3 = u.j();
                return j3;
            }
            Collection<y0> collection = F().get(fVar);
            if (collection != null) {
                return collection;
            }
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> b() {
            return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.m, this, a[8]);
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Collection<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            List j2;
            List j3;
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (!d().contains(fVar)) {
                j3 = u.j();
                return j3;
            }
            Collection<t0> collection = G().get(fVar);
            if (collection != null) {
                return collection;
            }
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> d() {
            return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.n, this, a[9]);
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> e() {
            List<r> list = this.f24531d;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            h hVar = this.o;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(x.b(hVar.p().g(), ((r) ((o) it.next())).X()));
            }
            return linkedHashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public void f(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            kotlin.jvm.internal.m.f(collection, "result");
            kotlin.jvm.internal.m.f(dVar, "kindFilter");
            kotlin.jvm.internal.m.f(function1, "nameFilter");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.i())) {
                for (Object obj : B()) {
                    kotlin.reflect.y.internal.j0.f.f name = ((t0) obj).getName();
                    kotlin.jvm.internal.m.e(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.d())) {
                for (Object obj2 : A()) {
                    kotlin.reflect.y.internal.j0.f.f name2 = ((y0) obj2).getName();
                    kotlin.jvm.internal.m.e(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public d1 g(kotlin.reflect.y.internal.j0.f.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "name");
            return H().get(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public final class c implements a {
        static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), g0.h(new y(g0.b(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: b, reason: collision with root package name */
        private final Map<kotlin.reflect.y.internal.j0.f.f, byte[]> f24551b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<kotlin.reflect.y.internal.j0.f.f, byte[]> f24552c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<kotlin.reflect.y.internal.j0.f.f, byte[]> f24553d;

        /* renamed from: e, reason: collision with root package name */
        private final g<kotlin.reflect.y.internal.j0.f.f, Collection<y0>> f24554e;

        /* renamed from: f, reason: collision with root package name */
        private final g<kotlin.reflect.y.internal.j0.f.f, Collection<t0>> f24555f;

        /* renamed from: g, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, d1> f24556g;

        /* renamed from: h, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24557h;

        /* renamed from: i, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.k.i f24558i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ h f24559j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: Add missing generic type declarations: [M] */
        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        public static final class a<M> extends Lambda implements Function0<M> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ q<M> f24560f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ ByteArrayInputStream f24561g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ h f24562h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(q<M> qVar, ByteArrayInputStream byteArrayInputStream, h hVar) {
                super(0);
                this.f24560f = qVar;
                this.f24561g = byteArrayInputStream;
                this.f24562h = hVar;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final o invoke() {
                return (o) this.f24560f.c(this.f24561g, this.f24562h.p().c().j());
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class b extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f24564g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h hVar) {
                super(0);
                this.f24564g = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                Set<kotlin.reflect.y.internal.j0.f.f> l;
                l = x0.l(c.this.f24551b.keySet(), this.f24564g.t());
                return l;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: kotlin.f0.y.e.j0.j.b.g0.h$c$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0390c extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
            C0390c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
                kotlin.jvm.internal.m.f(fVar, "it");
                return c.this.m(fVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class d extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends t0>> {
            d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Collection<t0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
                kotlin.jvm.internal.m.f(fVar, "it");
                return c.this.n(fVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class e extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, d1> {
            e() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
                kotlin.jvm.internal.m.f(fVar, "it");
                return c.this.o(fVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: classes3.dex */
        static final class f extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f24569g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(h hVar) {
                super(0);
                this.f24569g = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                Set<kotlin.reflect.y.internal.j0.f.f> l;
                l = x0.l(c.this.f24552c.keySet(), this.f24569g.u());
                return l;
            }
        }

        public c(h hVar, List<kotlin.reflect.y.internal.j0.e.i> list, List<n> list2, List<r> list3) {
            Map<kotlin.reflect.y.internal.j0.f.f, byte[]> i2;
            kotlin.jvm.internal.m.f(list, "functionList");
            kotlin.jvm.internal.m.f(list2, "propertyList");
            kotlin.jvm.internal.m.f(list3, "typeAliasList");
            this.f24559j = hVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                kotlin.reflect.y.internal.j0.f.f b2 = x.b(hVar.p().g(), ((kotlin.reflect.y.internal.j0.e.i) ((o) obj)).e0());
                Object obj2 = linkedHashMap.get(b2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b2, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.f24551b = p(linkedHashMap);
            h hVar2 = this.f24559j;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                kotlin.reflect.y.internal.j0.f.f b3 = x.b(hVar2.p().g(), ((n) ((o) obj3)).d0());
                Object obj4 = linkedHashMap2.get(b3);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b3, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.f24552c = p(linkedHashMap2);
            if (this.f24559j.p().c().g().f()) {
                h hVar3 = this.f24559j;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : list3) {
                    kotlin.reflect.y.internal.j0.f.f b4 = x.b(hVar3.p().g(), ((r) ((o) obj5)).X());
                    Object obj6 = linkedHashMap3.get(b4);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b4, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                i2 = p(linkedHashMap3);
            } else {
                i2 = q0.i();
            }
            this.f24553d = i2;
            this.f24554e = this.f24559j.p().h().h(new C0390c());
            this.f24555f = this.f24559j.p().h().h(new d());
            this.f24556g = this.f24559j.p().h().i(new e());
            this.f24557h = this.f24559j.p().h().d(new b(this.f24559j));
            this.f24558i = this.f24559j.p().h().d(new f(this.f24559j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0027, code lost:
        
            if (r0 != null) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Collection<y0> m(kotlin.reflect.y.internal.j0.f.f fVar) {
            List<kotlin.reflect.y.internal.j0.e.i> j2;
            Sequence g2;
            Map<kotlin.reflect.y.internal.j0.f.f, byte[]> map = this.f24551b;
            q<kotlin.reflect.y.internal.j0.e.i> qVar = kotlin.reflect.y.internal.j0.e.i.f24004i;
            kotlin.jvm.internal.m.e(qVar, "PARSER");
            h hVar = this.f24559j;
            byte[] bArr = map.get(fVar);
            if (bArr != null) {
                g2 = kotlin.sequences.l.g(new a(qVar, new ByteArrayInputStream(bArr), this.f24559j));
                j2 = kotlin.sequences.n.A(g2);
            }
            j2 = u.j();
            ArrayList arrayList = new ArrayList(j2.size());
            for (kotlin.reflect.y.internal.j0.e.i iVar : j2) {
                w f2 = hVar.p().f();
                kotlin.jvm.internal.m.e(iVar, "it");
                y0 j3 = f2.j(iVar);
                if (!hVar.x(j3)) {
                    j3 = null;
                }
                if (j3 != null) {
                    arrayList.add(j3);
                }
            }
            hVar.k(fVar, arrayList);
            return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0027, code lost:
        
            if (r0 != null) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Collection<t0> n(kotlin.reflect.y.internal.j0.f.f fVar) {
            List<n> j2;
            Sequence g2;
            Map<kotlin.reflect.y.internal.j0.f.f, byte[]> map = this.f24552c;
            q<n> qVar = n.f24037i;
            kotlin.jvm.internal.m.e(qVar, "PARSER");
            h hVar = this.f24559j;
            byte[] bArr = map.get(fVar);
            if (bArr != null) {
                g2 = kotlin.sequences.l.g(new a(qVar, new ByteArrayInputStream(bArr), this.f24559j));
                j2 = kotlin.sequences.n.A(g2);
            }
            j2 = u.j();
            ArrayList arrayList = new ArrayList(j2.size());
            for (n nVar : j2) {
                w f2 = hVar.p().f();
                kotlin.jvm.internal.m.e(nVar, "it");
                t0 l = f2.l(nVar);
                if (l != null) {
                    arrayList.add(l);
                }
            }
            hVar.l(fVar, arrayList);
            return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d1 o(kotlin.reflect.y.internal.j0.f.f fVar) {
            r o0;
            byte[] bArr = this.f24553d.get(fVar);
            if (bArr == null || (o0 = r.o0(new ByteArrayInputStream(bArr), this.f24559j.p().c().j())) == null) {
                return null;
            }
            return this.f24559j.p().f().m(o0);
        }

        private final Map<kotlin.reflect.y.internal.j0.f.f, byte[]> p(Map<kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) {
            int e2;
            int u;
            e2 = p0.e(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(e2);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                u = v.u(iterable, 10);
                ArrayList arrayList = new ArrayList(u);
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it2.next()).i(byteArrayOutputStream);
                    arrayList.add(kotlin.u.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Collection<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            List j2;
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (b().contains(fVar)) {
                return this.f24554e.invoke(fVar);
            }
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> b() {
            return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.f24557h, this, a[0]);
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Collection<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            List j2;
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (d().contains(fVar)) {
                return this.f24555f.invoke(fVar);
            }
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> d() {
            return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.f24558i, this, a[1]);
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public Set<kotlin.reflect.y.internal.j0.f.f> e() {
            return this.f24553d.keySet();
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public void f(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1, kotlin.reflect.y.internal.j0.c.b.b bVar) {
            kotlin.jvm.internal.m.f(collection, "result");
            kotlin.jvm.internal.m.f(dVar, "kindFilter");
            kotlin.jvm.internal.m.f(function1, "nameFilter");
            kotlin.jvm.internal.m.f(bVar, "location");
            if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.i())) {
                Set<kotlin.reflect.y.internal.j0.f.f> d2 = d();
                ArrayList arrayList = new ArrayList();
                for (kotlin.reflect.y.internal.j0.f.f fVar : d2) {
                    if (function1.invoke(fVar).booleanValue()) {
                        arrayList.addAll(c(fVar, bVar));
                    }
                }
                kotlin.reflect.y.internal.j0.i.g gVar = kotlin.reflect.y.internal.j0.i.g.f24326f;
                kotlin.jvm.internal.m.e(gVar, "INSTANCE");
                kotlin.collections.y.y(arrayList, gVar);
                collection.addAll(arrayList);
            }
            if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.d())) {
                Set<kotlin.reflect.y.internal.j0.f.f> b2 = b();
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.reflect.y.internal.j0.f.f fVar2 : b2) {
                    if (function1.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(a(fVar2, bVar));
                    }
                }
                kotlin.reflect.y.internal.j0.i.g gVar2 = kotlin.reflect.y.internal.j0.i.g.f24326f;
                kotlin.jvm.internal.m.e(gVar2, "INSTANCE");
                kotlin.collections.y.y(arrayList2, gVar2);
                collection.addAll(arrayList2);
            }
        }

        @Override // kotlin.f0.y.e.j0.j.b.g0.h.a
        public d1 g(kotlin.reflect.y.internal.j0.f.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "name");
            return this.f24556g.invoke(fVar);
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function0<Set<? extends f>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Collection<f>> f24570f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function0<? extends Collection<f>> function0) {
            super(0);
            this.f24570f = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<f> invoke() {
            Set<f> I0;
            I0 = c0.I0(this.f24570f.invoke());
            return I0;
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function0<Set<? extends f>> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<f> invoke() {
            Set l;
            Set<f> l2;
            Set<f> s = h.this.s();
            if (s == null) {
                return null;
            }
            l = x0.l(h.this.q(), h.this.f24526d.e());
            l2 = x0.l(l, s);
            return l2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(m mVar, List<kotlin.reflect.y.internal.j0.e.i> list, List<n> list2, List<r> list3, Function0<? extends Collection<f>> function0) {
        kotlin.jvm.internal.m.f(mVar, "c");
        kotlin.jvm.internal.m.f(list, "functionList");
        kotlin.jvm.internal.m.f(list2, "propertyList");
        kotlin.jvm.internal.m.f(list3, "typeAliasList");
        kotlin.jvm.internal.m.f(function0, "classNames");
        this.f24525c = mVar;
        this.f24526d = n(list, list2, list3);
        this.f24527e = mVar.h().d(new d(function0));
        this.f24528f = mVar.h().f(new e());
    }

    private final a n(List<kotlin.reflect.y.internal.j0.e.i> list, List<n> list2, List<r> list3) {
        if (this.f24525c.c().g().a()) {
            return new b(this, list, list2, list3);
        }
        return new c(this, list, list2, list3);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e o(f fVar) {
        return this.f24525c.c().b(m(fVar));
    }

    private final Set<f> r() {
        return (Set) kotlin.reflect.y.internal.j0.k.m.b(this.f24528f, this, f24524b[1]);
    }

    private final d1 v(f fVar) {
        return this.f24526d.g(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        return this.f24526d.a(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> b() {
        return this.f24526d.b();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        return this.f24526d.c(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> d() {
        return this.f24526d.d();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Set<f> e() {
        return r();
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        if (w(fVar)) {
            return o(fVar);
        }
        if (this.f24526d.e().contains(fVar)) {
            return v(fVar);
        }
        return null;
    }

    protected abstract void i(Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collection, Function1<? super f, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> j(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        kotlin.jvm.internal.m.f(bVar, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = kotlin.reflect.y.internal.j0.i.w.d.a;
        if (dVar.a(aVar.g())) {
            i(arrayList, function1);
        }
        this.f24526d.f(arrayList, dVar, function1, bVar);
        if (dVar.a(aVar.c())) {
            for (f fVar : q()) {
                if (function1.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, o(fVar));
                }
            }
        }
        if (dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.h())) {
            for (f fVar2 : this.f24526d.e()) {
                if (function1.invoke(fVar2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, this.f24526d.g(fVar2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    protected void k(f fVar, List<y0> list) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(list, "functions");
    }

    protected void l(f fVar, List<t0> list) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(list, "descriptors");
    }

    protected abstract kotlin.reflect.y.internal.j0.f.b m(f fVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final m p() {
        return this.f24525c;
    }

    public final Set<f> q() {
        return (Set) kotlin.reflect.y.internal.j0.k.m.a(this.f24527e, this, f24524b[0]);
    }

    protected abstract Set<f> s();

    protected abstract Set<f> t();

    protected abstract Set<f> u();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(f fVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        return q().contains(fVar);
    }

    protected boolean x(y0 y0Var) {
        kotlin.jvm.internal.m.f(y0Var, "function");
        return true;
    }
}
