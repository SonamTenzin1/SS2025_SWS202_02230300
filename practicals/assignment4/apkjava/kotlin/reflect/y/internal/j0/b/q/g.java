package kotlin.reflect.y.internal.j0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.z;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.utils.b;
import kotlin.reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.y.internal.j0.b.q.f;
import kotlin.reflect.y.internal.j0.d.b.u;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.h0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes2.dex */
public final class g implements kotlin.reflect.jvm.internal.impl.descriptors.o1.a, kotlin.reflect.jvm.internal.impl.descriptors.o1.c {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), g0.h(new y(g0.b(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), g0.h(new y(g0.b(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.g0 f23279b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.b.q.d f23280c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23281d;

    /* renamed from: e, reason: collision with root package name */
    private final e0 f23282e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23283f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.a<kotlin.reflect.y.internal.j0.f.c, kotlin.reflect.jvm.internal.impl.descriptors.e> f23284g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23285h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<m0> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23292g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.f23292g = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            return x.c(g.this.s().a(), kotlin.reflect.y.internal.j0.b.q.e.a.a(), new j0(this.f23292g, g.this.s().a())).s();
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class d extends z {
        d(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, kotlin.reflect.y.internal.j0.f.c cVar) {
            super(g0Var, cVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
        /* renamed from: A0, reason: merged with bridge method [inline-methods] */
        public h.b q() {
            return h.b.f24422b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function0<e0> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            m0 i2 = g.this.f23279b.o().i();
            m.e(i2, "moduleDescriptor.builtIns.anyType");
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements Function0<kotlin.reflect.jvm.internal.impl.descriptors.e> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.l.f f23294f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f23295g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            super(0);
            this.f23294f = fVar;
            this.f23295g = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke() {
            kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar = this.f23294f;
            kotlin.reflect.y.internal.j0.d.a.j0.g gVar = kotlin.reflect.y.internal.j0.d.a.j0.g.a;
            m.e(gVar, "EMPTY");
            return fVar.O0(gVar, this.f23295g);
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: kotlin.f0.y.e.j0.b.q.g$g, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0325g extends Lambda implements Function1<kotlin.reflect.y.internal.j0.i.w.h, Collection<? extends y0>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.f f23296f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0325g(kotlin.reflect.y.internal.j0.f.f fVar) {
            super(1);
            this.f23296f = fVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.i.w.h hVar) {
            m.f(hVar, "it");
            return hVar.a(this.f23296f, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class h<N> implements b.c {
        h() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.reflect.jvm.internal.impl.descriptors.e> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            Collection<e0> a = eVar.h().a();
            m.e(a, "it.typeConstructor.supertypes");
            g gVar = g.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.h w = ((e0) it.next()).O0().w();
                kotlin.reflect.jvm.internal.impl.descriptors.h a2 = w != null ? w.a() : null;
                kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = a2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) a2 : null;
                kotlin.reflect.y.internal.j0.d.a.l0.l.f p = eVar2 != null ? gVar.p(eVar2) : null;
                if (p != null) {
                    arrayList.add(p);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class i extends b.AbstractC0417b<kotlin.reflect.jvm.internal.impl.descriptors.e, a> {
        final /* synthetic */ String a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0<a> f23297b;

        i(String str, f0<a> f0Var) {
            this.a = str;
            this.f23297b = f0Var;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.f0.y.e.j0.b.q.g$a, T] */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.f0.y.e.j0.b.q.g$a, T] */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.f0.y.e.j0.b.q.g$a, T] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            m.f(eVar, "javaClassDescriptor");
            String a = u.a(kotlin.reflect.y.internal.j0.d.b.x.a, eVar, this.a);
            kotlin.reflect.y.internal.j0.b.q.i iVar = kotlin.reflect.y.internal.j0.b.q.i.a;
            if (iVar.e().contains(a)) {
                this.f23297b.f22943f = a.HIDDEN;
            } else if (iVar.h().contains(a)) {
                this.f23297b.f22943f = a.VISIBLE;
            } else if (iVar.c().contains(a)) {
                this.f23297b.f22943f = a.DROP;
            }
            return this.f23297b.f22943f == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = this.f23297b.f22943f;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class j<N> implements b.c {
        public static final j<N> a = new j<>();

        j() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.reflect.jvm.internal.impl.descriptors.b> a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar.a().e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    public static final class k extends Lambda implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {
        k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z;
            if (bVar.i() == b.a.DECLARATION) {
                kotlin.reflect.y.internal.j0.b.q.d dVar = g.this.f23280c;
                kotlin.reflect.jvm.internal.impl.descriptors.m b2 = bVar.b();
                m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (dVar.c((kotlin.reflect.jvm.internal.impl.descriptors.e) b2)) {
                    z = true;
                    return Boolean.valueOf(z);
                }
            }
            z = false;
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* loaded from: classes2.dex */
    static final class l extends Lambda implements Function0<kotlin.reflect.jvm.internal.impl.descriptors.n1.g> {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.n1.g invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> e2;
            kotlin.reflect.jvm.internal.impl.descriptors.n1.c b2 = kotlin.reflect.jvm.internal.impl.descriptors.n1.f.b(g.this.f23279b.o(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
            g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
            e2 = t.e(b2);
            return aVar.a(e2);
        }
    }

    public g(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, n nVar, Function0<f.b> function0) {
        m.f(g0Var, "moduleDescriptor");
        m.f(nVar, "storageManager");
        m.f(function0, "settingsComputation");
        this.f23279b = g0Var;
        this.f23280c = kotlin.reflect.y.internal.j0.b.q.d.a;
        this.f23281d = nVar.d(function0);
        this.f23282e = k(nVar);
        this.f23283f = nVar.d(new c(nVar));
        this.f23284g = nVar.b();
        this.f23285h = nVar.d(new l());
    }

    private final y0 j(kotlin.reflect.y.internal.j0.j.b.g0.d dVar, y0 y0Var) {
        y.a<? extends y0> u = y0Var.u();
        u.p(dVar);
        u.o(kotlin.reflect.jvm.internal.impl.descriptors.t.f25368e);
        u.g(dVar.s());
        u.e(dVar.K0());
        y0 c2 = u.c();
        m.c(c2);
        return c2;
    }

    private final e0 k(n nVar) {
        List e2;
        Set<kotlin.reflect.jvm.internal.impl.descriptors.d> d2;
        d dVar = new d(this.f23279b, new kotlin.reflect.y.internal.j0.f.c("java.io"));
        e2 = t.e(new h0(nVar, new e()));
        kotlin.reflect.jvm.internal.impl.descriptors.p1.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.p1.h(dVar, kotlin.reflect.y.internal.j0.f.f.x("Serializable"), d0.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE, e2, z0.a, false, nVar);
        h.b bVar = h.b.f24422b;
        d2 = w0.d();
        hVar.L0(bVar, d2, null);
        m0 s = hVar.s();
        m.e(s, "mockSerializableClass.defaultType");
        return s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
    
        if (t(r3, r10) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<y0> l(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Function1<? super kotlin.reflect.y.internal.j0.i.w.h, ? extends Collection<? extends y0>> function1) {
        int u;
        boolean z;
        List j2;
        List j3;
        kotlin.reflect.y.internal.j0.d.a.l0.l.f p = p(eVar);
        if (p == null) {
            j3 = kotlin.collections.u.j();
            return j3;
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> g2 = this.f23280c.g(kotlin.reflect.y.internal.j0.i.t.a.h(p), kotlin.reflect.y.internal.j0.b.q.b.f23241h.a());
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) s.h0(g2);
        if (eVar2 == null) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        f.b bVar = kotlin.reflect.jvm.internal.impl.utils.f.f25524f;
        u = v.u(g2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = g2.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.reflect.jvm.internal.impl.descriptors.e) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.utils.f b2 = bVar.b(arrayList);
        boolean c2 = this.f23280c.c(eVar);
        kotlin.reflect.y.internal.j0.i.w.h D0 = this.f23284g.b(kotlin.reflect.y.internal.j0.i.t.a.h(p), new f(p, eVar2)).D0();
        m.e(D0, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends y0> invoke = function1.invoke(D0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : invoke) {
            y0 y0Var = (y0) obj;
            boolean z2 = true;
            if (y0Var.i() == b.a.DECLARATION && y0Var.getVisibility().d() && !kotlin.reflect.y.internal.j0.b.h.j0(y0Var)) {
                Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> e2 = y0Var.e();
                m.e(e2, "analogueMember.overriddenDescriptors");
                if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                    Iterator<T> it2 = e2.iterator();
                    while (it2.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.m b3 = ((kotlin.reflect.jvm.internal.impl.descriptors.y) it2.next()).b();
                        m.e(b3, "it.containingDeclaration");
                        if (b2.contains(kotlin.reflect.y.internal.j0.i.t.a.h(b3))) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            z2 = false;
            if (z2) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final m0 m() {
        return (m0) kotlin.reflect.y.internal.j0.k.m.a(this.f23283f, this, a[1]);
    }

    private static final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, l1 l1Var, kotlin.reflect.jvm.internal.impl.descriptors.l lVar2) {
        return kotlin.reflect.y.internal.j0.i.j.x(lVar, lVar2.c(l1Var)) == j.i.a.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.d.a.l0.l.f p(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.reflect.y.internal.j0.f.b n;
        kotlin.reflect.y.internal.j0.f.c b2;
        if (kotlin.reflect.y.internal.j0.b.h.a0(eVar) || !kotlin.reflect.y.internal.j0.b.h.A0(eVar)) {
            return null;
        }
        kotlin.reflect.y.internal.j0.f.d i2 = kotlin.reflect.y.internal.j0.i.t.a.i(eVar);
        if (!i2.f() || (n = kotlin.reflect.y.internal.j0.b.q.c.a.n(i2)) == null || (b2 = n.b()) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e c2 = kotlin.reflect.jvm.internal.impl.descriptors.s.c(s().a(), b2, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        if (c2 instanceof kotlin.reflect.y.internal.j0.d.a.l0.l.f) {
            return (kotlin.reflect.y.internal.j0.d.a.l0.l.f) c2;
        }
        return null;
    }

    private final a q(kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        List e2;
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = yVar.b();
        m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String c2 = kotlin.reflect.y.internal.j0.d.b.v.c(yVar, false, false, 3, null);
        f0 f0Var = new f0();
        e2 = t.e((kotlin.reflect.jvm.internal.impl.descriptors.e) b2);
        Object b3 = kotlin.reflect.jvm.internal.impl.utils.b.b(e2, new h(), new i(c2, f0Var));
        m.e(b3, "private fun FunctionDesc…ERED\n            })\n    }");
        return (a) b3;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.n1.g r() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.n1.g) kotlin.reflect.y.internal.j0.k.m.a(this.f23285h, this, a[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f.b s() {
        return (f.b) kotlin.reflect.y.internal.j0.k.m.a(this.f23281d, this, a[0]);
    }

    private final boolean t(y0 y0Var, boolean z) {
        List e2;
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = y0Var.b();
        m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String c2 = kotlin.reflect.y.internal.j0.d.b.v.c(y0Var, false, false, 3, null);
        if (z ^ kotlin.reflect.y.internal.j0.b.q.i.a.f().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, (kotlin.reflect.jvm.internal.impl.descriptors.e) b2, c2))) {
            return true;
        }
        e2 = t.e(y0Var);
        Boolean e3 = kotlin.reflect.jvm.internal.impl.utils.b.e(e2, j.a, new k());
        m.e(e3, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return e3.booleanValue();
    }

    private final boolean u(kotlin.reflect.jvm.internal.impl.descriptors.l lVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (lVar.f().size() == 1) {
            List<i1> f2 = lVar.f();
            m.e(f2, "valueParameters");
            kotlin.reflect.jvm.internal.impl.descriptors.h w = ((i1) s.s0(f2)).getType().O0().w();
            if (m.a(w != null ? kotlin.reflect.y.internal.j0.i.t.a.i(w) : null, kotlin.reflect.y.internal.j0.i.t.a.i(eVar))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        List j2;
        int u;
        boolean z;
        List j3;
        List j4;
        m.f(eVar, "classDescriptor");
        if (eVar.i() == kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS && s().b()) {
            kotlin.reflect.y.internal.j0.d.a.l0.l.f p = p(eVar);
            if (p == null) {
                j4 = kotlin.collections.u.j();
                return j4;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e f2 = kotlin.reflect.y.internal.j0.b.q.d.f(this.f23280c, kotlin.reflect.y.internal.j0.i.t.a.h(p), kotlin.reflect.y.internal.j0.b.q.b.f23241h.a(), null, 4, null);
            if (f2 == null) {
                j3 = kotlin.collections.u.j();
                return j3;
            }
            l1 c2 = kotlin.reflect.y.internal.j0.b.q.j.a(f2, p).c();
            List<kotlin.reflect.jvm.internal.impl.descriptors.d> k2 = p.k();
            ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.d> arrayList = new ArrayList();
            Iterator<T> it = k2.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) next;
                if (dVar.getVisibility().d()) {
                    Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k3 = f2.k();
                    m.e(k3, "defaultKotlinVersion.constructors");
                    if (!(k3 instanceof Collection) || !k3.isEmpty()) {
                        for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 : k3) {
                            m.e(dVar2, "it");
                            if (n(dVar2, c2, dVar)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z && !u(dVar, eVar) && !kotlin.reflect.y.internal.j0.b.h.j0(dVar) && !kotlin.reflect.y.internal.j0.b.q.i.a.d().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, p, kotlin.reflect.y.internal.j0.d.b.v.c(dVar, false, false, 3, null)))) {
                        z2 = true;
                    }
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            u = v.u(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(u);
            for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar3 : arrayList) {
                y.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> u2 = dVar3.u();
                u2.p(eVar);
                u2.g(eVar.s());
                u2.f();
                u2.l(c2.j());
                if (!kotlin.reflect.y.internal.j0.b.q.i.a.g().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, p, kotlin.reflect.y.internal.j0.d.b.v.c(dVar3, false, false, 3, null)))) {
                    u2.s(r());
                }
                kotlin.reflect.jvm.internal.impl.descriptors.y c3 = u2.c();
                m.d(c3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.d) c3);
            }
            return arrayList2;
        }
        j2 = kotlin.collections.u.j();
        return j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fc, code lost:
    
        if (r2 != 3) goto L42;
     */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<y0> b(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        List j2;
        List e2;
        List j3;
        m.f(fVar, "name");
        m.f(eVar, "classDescriptor");
        boolean z = true;
        if (m.a(fVar, kotlin.reflect.y.internal.j0.b.q.a.f23239e.a()) && (eVar instanceof kotlin.reflect.y.internal.j0.j.b.g0.d) && kotlin.reflect.y.internal.j0.b.h.d0(eVar)) {
            kotlin.reflect.y.internal.j0.j.b.g0.d dVar = (kotlin.reflect.y.internal.j0.j.b.g0.d) eVar;
            List<kotlin.reflect.y.internal.j0.e.i> I0 = dVar.c1().I0();
            m.e(I0, "classDescriptor.classProto.functionList");
            if (!(I0 instanceof Collection) || !I0.isEmpty()) {
                Iterator<T> it = I0.iterator();
                while (it.hasNext()) {
                    if (m.a(kotlin.reflect.y.internal.j0.j.b.x.b(dVar.b1().g(), ((kotlin.reflect.y.internal.j0.e.i) it.next()).e0()), kotlin.reflect.y.internal.j0.b.q.a.f23239e.a())) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                j3 = kotlin.collections.u.j();
                return j3;
            }
            e2 = t.e(j(dVar, (y0) s.r0(m().q().a(fVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS))));
            return e2;
        }
        if (!s().b()) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        Collection<y0> l2 = l(eVar, new C0325g(fVar));
        ArrayList arrayList = new ArrayList();
        for (y0 y0Var : l2) {
            kotlin.reflect.jvm.internal.impl.descriptors.m b2 = y0Var.b();
            m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.y c2 = y0Var.c(kotlin.reflect.y.internal.j0.b.q.j.a((kotlin.reflect.jvm.internal.impl.descriptors.e) b2, eVar).c());
            m.d(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            y.a<? extends y0> u = ((y0) c2).u();
            u.p(eVar);
            u.e(eVar.K0());
            u.f();
            int i2 = b.a[q(y0Var).ordinal()];
            y0 y0Var2 = null;
            if (i2 == 1) {
                if (!kotlin.reflect.jvm.internal.impl.descriptors.e0.a(eVar)) {
                    u.i();
                    y0 c3 = u.c();
                    m.c(c3);
                    y0Var2 = c3;
                }
            } else {
                if (i2 == 2) {
                    u.s(r());
                }
                y0 c32 = u.c();
                m.c(c32);
                y0Var2 = c32;
            }
            if (y0Var2 != null) {
                arrayList.add(y0Var2);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.c
    public boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, y0 y0Var) {
        m.f(eVar, "classDescriptor");
        m.f(y0Var, "functionDescriptor");
        kotlin.reflect.y.internal.j0.d.a.l0.l.f p = p(eVar);
        if (p == null || !y0Var.getAnnotations().R0(kotlin.reflect.jvm.internal.impl.descriptors.o1.d.a())) {
            return true;
        }
        if (!s().b()) {
            return false;
        }
        String c2 = kotlin.reflect.y.internal.j0.d.b.v.c(y0Var, false, false, 3, null);
        kotlin.reflect.y.internal.j0.d.a.l0.l.g D0 = p.D0();
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "functionDescriptor.name");
        Collection<y0> a2 = D0.a(name, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        if (!(a2 instanceof Collection) || !a2.isEmpty()) {
            Iterator<T> it = a2.iterator();
            while (it.hasNext()) {
                if (m.a(kotlin.reflect.y.internal.j0.d.b.v.c((y0) it.next(), false, false, 3, null), c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
    public Collection<e0> d(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        List j2;
        List e2;
        List m;
        m.f(eVar, "classDescriptor");
        kotlin.reflect.y.internal.j0.f.d i2 = kotlin.reflect.y.internal.j0.i.t.a.i(eVar);
        kotlin.reflect.y.internal.j0.b.q.i iVar = kotlin.reflect.y.internal.j0.b.q.i.a;
        if (iVar.i(i2)) {
            m0 m2 = m();
            m.e(m2, "cloneableType");
            m = kotlin.collections.u.m(m2, this.f23282e);
            return m;
        }
        if (iVar.j(i2)) {
            e2 = t.e(this.f23282e);
            return e2;
        }
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.y.internal.j0.f.f> e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        Set<kotlin.reflect.y.internal.j0.f.f> d2;
        kotlin.reflect.y.internal.j0.d.a.l0.l.g D0;
        Set<kotlin.reflect.y.internal.j0.f.f> b2;
        Set<kotlin.reflect.y.internal.j0.f.f> d3;
        m.f(eVar, "classDescriptor");
        if (!s().b()) {
            d3 = w0.d();
            return d3;
        }
        kotlin.reflect.y.internal.j0.d.a.l0.l.f p = p(eVar);
        if (p != null && (D0 = p.D0()) != null && (b2 = D0.b()) != null) {
            return b2;
        }
        d2 = w0.d();
        return d2;
    }
}
