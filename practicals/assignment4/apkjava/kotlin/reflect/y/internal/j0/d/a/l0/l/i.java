package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.l0.l.b;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.d.b.c0.a;
import kotlin.reflect.y.internal.j0.d.b.o;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.k.h;
import kotlin.reflect.y.internal.j0.k.j;

/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: classes2.dex */
public final class i extends l {
    private final u n;
    private final h o;
    private final j<Set<String>> p;
    private final h<a, e> q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final f a;

        /* renamed from: b, reason: collision with root package name */
        private final g f23520b;

        public a(f fVar, g gVar) {
            m.f(fVar, "name");
            this.a = fVar;
            this.f23520b = gVar;
        }

        public final g a() {
            return this.f23520b;
        }

        public final f b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && m.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: classes2.dex */
    public static abstract class b {

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: classes2.dex */
        public static final class a extends b {
            private final e a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(null);
                m.f(eVar, "descriptor");
                this.a = eVar;
            }

            public final e a() {
                return this.a;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: kotlin.f0.y.e.j0.d.a.l0.l.i$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0334b extends b {
            public static final C0334b a = new C0334b();

            private C0334b() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* loaded from: classes2.dex */
        public static final class c extends b {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function1<a, e> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23522g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(1);
            this.f23522g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e invoke(a aVar) {
            o.a c2;
            byte[] bArr;
            m.f(aVar, "request");
            kotlin.reflect.y.internal.j0.f.b bVar = new kotlin.reflect.y.internal.j0.f.b(i.this.C().d(), aVar.b());
            if (aVar.a() != null) {
                c2 = this.f23522g.a().j().a(aVar.a());
            } else {
                c2 = this.f23522g.a().j().c(bVar);
            }
            q a = c2 != null ? c2.a() : null;
            kotlin.reflect.y.internal.j0.f.b e2 = a != null ? a.e() : null;
            if (e2 != null && (e2.l() || e2.k())) {
                return null;
            }
            b R = i.this.R(a);
            if (R instanceof b.a) {
                return ((b.a) R).a();
            }
            if (R instanceof b.c) {
                return null;
            }
            if (R instanceof b.C0334b) {
                g a2 = aVar.a();
                if (a2 == null) {
                    kotlin.reflect.y.internal.j0.d.a.o d2 = this.f23522g.a().d();
                    if (c2 != null) {
                        if (!(c2 instanceof o.a.C0351a)) {
                            c2 = null;
                        }
                        o.a.C0351a c0351a = (o.a.C0351a) c2;
                        if (c0351a != null) {
                            bArr = c0351a.b();
                            a2 = d2.a(new o.b(bVar, bArr, null, 4, null));
                        }
                    }
                    bArr = null;
                    a2 = d2.a(new o.b(bVar, bArr, null, 4, null));
                }
                g gVar = a2;
                if ((gVar != null ? gVar.I() : null) != d0.BINARY) {
                    kotlin.reflect.y.internal.j0.f.c d3 = gVar != null ? gVar.d() : null;
                    if (d3 == null || d3.d() || !m.a(d3.e(), i.this.C().d())) {
                        return null;
                    }
                    f fVar = new f(this.f23522g, i.this.C(), gVar, null, 8, null);
                    this.f23522g.a().e().a(fVar);
                    return fVar;
                }
                throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + p.a(this.f23522g.a().j(), gVar) + "\nfindKotlinClass(ClassId) = " + p.b(this.f23522g.a().j(), bVar) + '\n');
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function0<Set<? extends String>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23523f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f23524g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, i iVar) {
            super(0);
            this.f23523f = gVar;
            this.f23524g = iVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<String> invoke() {
            return this.f23523f.a().d().b(this.f23524g.C().d());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, u uVar, h hVar) {
        super(gVar);
        m.f(gVar, "c");
        m.f(uVar, "jPackage");
        m.f(hVar, "ownerDescriptor");
        this.n = uVar;
        this.o = hVar;
        this.p = gVar.e().f(new d(gVar, this));
        this.q = gVar.e().i(new c(gVar));
    }

    private final e N(f fVar, g gVar) {
        if (!kotlin.reflect.y.internal.j0.f.h.a.a(fVar)) {
            return null;
        }
        Set<String> invoke = this.p.invoke();
        if (gVar != null || invoke == null || invoke.contains(fVar.k())) {
            return this.q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b R(q qVar) {
        if (qVar == null) {
            return b.C0334b.a;
        }
        if (qVar.a().c() == a.EnumC0345a.CLASS) {
            e k2 = w().a().b().k(qVar);
            return k2 != null ? new b.a(k2) : b.C0334b.a;
        }
        return b.c.a;
    }

    public final e O(g gVar) {
        m.f(gVar, "javaClass");
        return N(gVar.getName(), gVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public e f(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return N(fVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public h C() {
        return this.o;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        List j2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        j2 = kotlin.collections.u.j();
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[SYNTHETIC] */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        boolean z;
        List j2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        d.a aVar = kotlin.reflect.y.internal.j0.i.w.d.a;
        if (!dVar.a(aVar.e() | aVar.c())) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke = v().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : invoke) {
            kotlin.reflect.jvm.internal.impl.descriptors.m mVar = (kotlin.reflect.jvm.internal.impl.descriptors.m) obj;
            if (mVar instanceof e) {
                f name = ((e) mVar).getName();
                m.e(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z = true;
                    if (!z) {
                        arrayList.add(obj);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> d2;
        m.f(dVar, "kindFilter");
        if (!dVar.a(kotlin.reflect.y.internal.j0.i.w.d.a.e())) {
            d2 = w0.d();
            return d2;
        }
        Set<String> invoke = this.p.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = invoke.iterator();
            while (it.hasNext()) {
                hashSet.add(f.x((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.n;
        if (function1 == null) {
            function1 = kotlin.reflect.jvm.internal.impl.utils.d.a();
        }
        Collection<g> q = uVar.q(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (g gVar : q) {
            f name = gVar.I() == d0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> d2;
        m.f(dVar, "kindFilter");
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected kotlin.reflect.y.internal.j0.d.a.l0.l.b p() {
        return b.a.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        Set<f> d2;
        m.f(dVar, "kindFilter");
        d2 = w0.d();
        return d2;
    }
}
