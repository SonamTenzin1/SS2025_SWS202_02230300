package kotlin.reflect.y.internal.j0.d.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.f0.y.e.j0.d.b.b.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.d.b.t;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.d;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.j.b.f;
import kotlin.reflect.y.internal.j0.j.b.z;
import kotlin.text.v;

/* compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* loaded from: classes3.dex */
public abstract class b<A, S extends a<? extends A>> implements f<A> {
    private final o a;

    /* compiled from: AbstractBinaryClassAnnotationLoader.kt */
    /* loaded from: classes3.dex */
    public static abstract class a<A> {
        public abstract Map<t, List<A>> a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBinaryClassAnnotationLoader.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0342b {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* compiled from: AbstractBinaryClassAnnotationLoader.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.reflect.y.internal.j0.j.b.b.values().length];
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_GETTER.ordinal()] = 1;
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_SETTER.ordinal()] = 2;
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationLoader.kt */
    /* loaded from: classes3.dex */
    public static final class d implements q.c {
        final /* synthetic */ b<A, S> a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f23736b;

        d(b<A, S> bVar, ArrayList<A> arrayList) {
            this.a = bVar;
            this.f23736b = arrayList;
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public void a() {
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public q.a b(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var) {
            m.f(bVar, "classId");
            m.f(z0Var, "source");
            return this.a.y(bVar, z0Var, this.f23736b);
        }
    }

    public b(o oVar) {
        m.f(oVar, "kotlinClassFinder");
        this.a = oVar;
    }

    private final q B(z.a aVar) {
        z0 c2 = aVar.c();
        s sVar = c2 instanceof s ? (s) c2 : null;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    private final int l(z zVar, o oVar) {
        if (oVar instanceof i) {
            if (kotlin.reflect.y.internal.j0.e.z.f.d((i) oVar)) {
                return 1;
            }
        } else if (oVar instanceof n) {
            if (kotlin.reflect.y.internal.j0.e.z.f.e((n) oVar)) {
                return 1;
            }
        } else if (oVar instanceof kotlin.reflect.y.internal.j0.e.d) {
            m.d(zVar, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            z.a aVar = (z.a) zVar;
            if (aVar.g() == c.EnumC0365c.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported message: " + oVar.getClass());
        }
        return 0;
    }

    private final List<A> m(z zVar, t tVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        List<A> j2;
        List<A> j3;
        q o = o(zVar, v(zVar, z, z2, bool, z3));
        if (o == null) {
            j3 = u.j();
            return j3;
        }
        List<A> list = p(o).a().get(tVar);
        if (list != null) {
            return list;
        }
        j2 = u.j();
        return j2;
    }

    static /* synthetic */ List n(b bVar, z zVar, t tVar, boolean z, boolean z2, Boolean bool, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return bVar.m(zVar, tVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ t s(b bVar, o oVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, kotlin.reflect.y.internal.j0.j.b.b bVar2, boolean z, int i2, Object obj) {
        if (obj == null) {
            return bVar.r(oVar, cVar, gVar, bVar2, (i2 & 16) != 0 ? false : z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ t u(b bVar, n nVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return bVar.t(nVar, cVar, gVar, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final List<A> z(z zVar, n nVar, EnumC0342b enumC0342b) {
        boolean J;
        List<A> j2;
        List<A> j3;
        List<A> j4;
        Boolean d2 = kotlin.reflect.y.internal.j0.e.z.b.A.d(nVar.b0());
        m.e(d2, "IS_CONST.get(proto.flags)");
        boolean booleanValue = d2.booleanValue();
        boolean f2 = kotlin.reflect.y.internal.j0.e.a0.b.i.f(nVar);
        if (enumC0342b == EnumC0342b.PROPERTY) {
            t u = u(this, nVar, zVar.b(), zVar.d(), false, true, false, 40, null);
            if (u != null) {
                return n(this, zVar, u, true, false, Boolean.valueOf(booleanValue), f2, 8, null);
            }
            j4 = u.j();
            return j4;
        }
        t u2 = u(this, nVar, zVar.b(), zVar.d(), true, false, false, 48, null);
        if (u2 == null) {
            j3 = u.j();
            return j3;
        }
        J = v.J(u2.a(), "$delegate", false, 2, null);
        if (J == (enumC0342b == EnumC0342b.DELEGATE_FIELD)) {
            return m(zVar, u2, true, true, Boolean.valueOf(booleanValue), f2);
        }
        j2 = u.j();
        return j2;
    }

    protected abstract A A(kotlin.reflect.y.internal.j0.e.b bVar, kotlin.reflect.y.internal.j0.e.z.c cVar);

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> a(s sVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        int u;
        m.f(sVar, "proto");
        m.f(cVar, "nameResolver");
        Object u2 = sVar.u(kotlin.reflect.y.internal.j0.e.a0.a.f23827h);
        m.e(u2, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<kotlin.reflect.y.internal.j0.e.b> iterable = (Iterable) u2;
        u = kotlin.collections.v.u(iterable, 10);
        ArrayList arrayList = new ArrayList(u);
        for (kotlin.reflect.y.internal.j0.e.b bVar : iterable) {
            m.e(bVar, "it");
            arrayList.add(A(bVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> b(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar, int i2, kotlin.reflect.y.internal.j0.e.u uVar) {
        List<A> j2;
        m.f(zVar, "container");
        m.f(oVar, "callableProto");
        m.f(bVar, "kind");
        m.f(uVar, "proto");
        t s = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        if (s != null) {
            return n(this, zVar, t.a.e(s, i2 + l(zVar, oVar)), false, false, null, false, 60, null);
        }
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> c(z.a aVar) {
        m.f(aVar, "container");
        q B = B(aVar);
        if (B != null) {
            ArrayList arrayList = new ArrayList(1);
            B.b(new d(this, arrayList), q(B));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + aVar.a()).toString());
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> d(kotlin.reflect.y.internal.j0.e.q qVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        int u;
        m.f(qVar, "proto");
        m.f(cVar, "nameResolver");
        Object u2 = qVar.u(kotlin.reflect.y.internal.j0.e.a0.a.f23825f);
        m.e(u2, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<kotlin.reflect.y.internal.j0.e.b> iterable = (Iterable) u2;
        u = kotlin.collections.v.u(iterable, 10);
        ArrayList arrayList = new ArrayList(u);
        for (kotlin.reflect.y.internal.j0.e.b bVar : iterable) {
            m.e(bVar, "it");
            arrayList.add(A(bVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> f(z zVar, kotlin.reflect.y.internal.j0.e.g gVar) {
        m.f(zVar, "container");
        m.f(gVar, "proto");
        t.a aVar = t.a;
        String string = zVar.b().getString(gVar.F());
        String c2 = ((z.a) zVar).e().c();
        m.e(c2, "container as ProtoContai…Class).classId.asString()");
        return n(this, zVar, aVar.a(string, kotlin.reflect.y.internal.j0.e.a0.b.b.b(c2)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> g(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return z(zVar, nVar, EnumC0342b.BACKING_FIELD);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> h(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        List<A> j2;
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        t s = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        if (s != null) {
            return n(this, zVar, t.a.e(s, 0), false, false, null, false, 60, null);
        }
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> i(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return z(zVar, nVar, EnumC0342b.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> j(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        List<A> j2;
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        if (bVar == kotlin.reflect.y.internal.j0.j.b.b.PROPERTY) {
            return z(zVar, (n) oVar, EnumC0342b.PROPERTY);
        }
        t s = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        if (s != null) {
            return n(this, zVar, s, false, false, null, false, 60, null);
        }
        j2 = u.j();
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final q o(z zVar, q qVar) {
        m.f(zVar, "container");
        if (qVar != null) {
            return qVar;
        }
        if (zVar instanceof z.a) {
            return B((z.a) zVar);
        }
        return null;
    }

    protected abstract S p(q qVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] q(q qVar) {
        m.f(qVar, "kotlinClass");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t r(o oVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, kotlin.reflect.y.internal.j0.j.b.b bVar, boolean z) {
        m.f(oVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        m.f(bVar, "kind");
        if (oVar instanceof kotlin.reflect.y.internal.j0.e.d) {
            t.a aVar = t.a;
            d.b b2 = kotlin.reflect.y.internal.j0.e.a0.b.i.a.b((kotlin.reflect.y.internal.j0.e.d) oVar, cVar, gVar);
            if (b2 == null) {
                return null;
            }
            return aVar.b(b2);
        }
        if (oVar instanceof i) {
            t.a aVar2 = t.a;
            d.b e2 = kotlin.reflect.y.internal.j0.e.a0.b.i.a.e((i) oVar, cVar, gVar);
            if (e2 == null) {
                return null;
            }
            return aVar2.b(e2);
        }
        if (!(oVar instanceof n)) {
            return null;
        }
        h.f<n, a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
        m.e(fVar, "propertySignature");
        a.d dVar = (a.d) e.a((h.d) oVar, fVar);
        if (dVar == null) {
            return null;
        }
        int i2 = c.a[bVar.ordinal()];
        if (i2 == 1) {
            if (!dVar.G()) {
                return null;
            }
            t.a aVar3 = t.a;
            a.c B = dVar.B();
            m.e(B, "signature.getter");
            return aVar3.c(cVar, B);
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return t((n) oVar, cVar, gVar, true, true, z);
        }
        if (!dVar.H()) {
            return null;
        }
        t.a aVar4 = t.a;
        a.c C = dVar.C();
        m.e(C, "signature.setter");
        return aVar4.c(cVar, C);
    }

    protected final t t(n nVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, boolean z, boolean z2, boolean z3) {
        m.f(nVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<n, a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
        m.e(fVar, "propertySignature");
        a.d dVar = (a.d) e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        if (z) {
            d.a c2 = kotlin.reflect.y.internal.j0.e.a0.b.i.a.c(nVar, cVar, gVar, z3);
            if (c2 == null) {
                return null;
            }
            return t.a.b(c2);
        }
        if (!z2 || !dVar.I()) {
            return null;
        }
        t.a aVar = t.a;
        a.c D = dVar.D();
        m.e(D, "signature.syntheticMethod");
        return aVar.c(cVar, D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final q v(z zVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        z.a h2;
        String z4;
        m.f(zVar, "container");
        if (z) {
            if (bool != null) {
                if (zVar instanceof z.a) {
                    z.a aVar = (z.a) zVar;
                    if (aVar.g() == c.EnumC0365c.INTERFACE) {
                        o oVar = this.a;
                        kotlin.reflect.y.internal.j0.f.b d2 = aVar.e().d(kotlin.reflect.y.internal.j0.f.f.x("DefaultImpls"));
                        m.e(d2, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                        return p.b(oVar, d2);
                    }
                }
                if (bool.booleanValue() && (zVar instanceof z.b)) {
                    z0 c2 = zVar.c();
                    k kVar = c2 instanceof k ? (k) c2 : null;
                    kotlin.reflect.y.internal.j0.i.u.d f2 = kVar != null ? kVar.f() : null;
                    if (f2 != null) {
                        o oVar2 = this.a;
                        String f3 = f2.f();
                        m.e(f3, "facadeClassName.internalName");
                        z4 = kotlin.text.u.z(f3, '/', '.', false, 4, null);
                        kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(new kotlin.reflect.y.internal.j0.f.c(z4));
                        m.e(m, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                        return p.b(oVar2, m);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + zVar + ')').toString());
            }
        }
        if (z2 && (zVar instanceof z.a)) {
            z.a aVar2 = (z.a) zVar;
            if (aVar2.g() == c.EnumC0365c.COMPANION_OBJECT && (h2 = aVar2.h()) != null && (h2.g() == c.EnumC0365c.CLASS || h2.g() == c.EnumC0365c.ENUM_CLASS || (z3 && (h2.g() == c.EnumC0365c.INTERFACE || h2.g() == c.EnumC0365c.ANNOTATION_CLASS)))) {
                return B(h2);
            }
        }
        if (!(zVar instanceof z.b) || !(zVar.c() instanceof k)) {
            return null;
        }
        z0 c3 = zVar.c();
        m.d(c3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        k kVar2 = (k) c3;
        q g2 = kVar2.g();
        return g2 == null ? p.b(this.a, kVar2.d()) : g2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean w(kotlin.reflect.y.internal.j0.f.b bVar) {
        q b2;
        m.f(bVar, "classId");
        return bVar.g() != null && m.a(bVar.j().k(), "Container") && (b2 = p.b(this.a, bVar)) != null && kotlin.reflect.y.internal.j0.a.a.c(b2);
    }

    protected abstract q.a x(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var, List<A> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public final q.a y(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var, List<A> list) {
        m.f(bVar, "annotationClassId");
        m.f(z0Var, "source");
        m.f(list, "result");
        if (kotlin.reflect.y.internal.j0.a.a.b().contains(bVar)) {
            return null;
        }
        return x(bVar, z0Var, list);
    }
}
