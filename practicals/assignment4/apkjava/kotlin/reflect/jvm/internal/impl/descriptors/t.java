package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.l1;
import kotlin.reflect.y.internal.j0.m.l;

/* compiled from: DescriptorVisibilities.java */
/* loaded from: classes2.dex */
public class t {
    public static final u a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f25365b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f25366c;

    /* renamed from: d, reason: collision with root package name */
    public static final u f25367d;

    /* renamed from: e, reason: collision with root package name */
    public static final u f25368e;

    /* renamed from: f, reason: collision with root package name */
    public static final u f25369f;

    /* renamed from: g, reason: collision with root package name */
    public static final u f25370g;

    /* renamed from: h, reason: collision with root package name */
    public static final u f25371h;

    /* renamed from: i, reason: collision with root package name */
    public static final u f25372i;

    /* renamed from: j, reason: collision with root package name */
    public static final Set<u> f25373j;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<u, Integer> f25374k;
    public static final u l;
    private static final kotlin.reflect.y.internal.j0.i.w.o.f m;
    public static final kotlin.reflect.y.internal.j0.i.w.o.f n;

    @Deprecated
    public static final kotlin.reflect.y.internal.j0.i.w.o.f o;
    private static final kotlin.reflect.y.internal.j0.m.l p;
    private static final Map<m1, u> q;

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class a implements kotlin.reflect.y.internal.j0.i.w.o.f {
        a() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.o.f
        public kotlin.reflect.y.internal.j0.l.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class b implements kotlin.reflect.y.internal.j0.i.w.o.f {
        b() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.o.f
        public kotlin.reflect.y.internal.j0.l.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class c implements kotlin.reflect.y.internal.j0.i.w.o.f {
        c() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.o.f
        public kotlin.reflect.y.internal.j0.l.e0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class d extends r {
        d(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "what";
            } else if (i2 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i2 == 1 || i2 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(m mVar) {
            if (mVar == null) {
                g(0);
            }
            return kotlin.reflect.y.internal.j0.i.d.j(mVar) != a1.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.q] */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == 0) {
                g(1);
            }
            if (mVar == null) {
                g(2);
            }
            if (kotlin.reflect.y.internal.j0.i.d.J(qVar) && h(mVar)) {
                return t.f(qVar, mVar);
            }
            if (qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) {
                kotlin.reflect.jvm.internal.impl.descriptors.i b2 = ((kotlin.reflect.jvm.internal.impl.descriptors.l) qVar).b();
                if (z && kotlin.reflect.y.internal.j0.i.d.G(b2) && kotlin.reflect.y.internal.j0.i.d.J(b2) && (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) && kotlin.reflect.y.internal.j0.i.d.J(mVar.b()) && t.f(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.b();
                if (((qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && !kotlin.reflect.y.internal.j0.i.d.x(qVar)) || (qVar instanceof k0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof k0) {
                    return (qVar instanceof k0) && qVar.d().equals(((k0) mVar).d()) && kotlin.reflect.y.internal.j0.i.d.b(mVar, qVar);
                }
                mVar = mVar.b();
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class e extends r {
        e(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            m q;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (t.a.e(fVar, qVar, mVar, z)) {
                if (fVar == t.n) {
                    return true;
                }
                if (fVar != t.m && (q = kotlin.reflect.y.internal.j0.i.d.q(qVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class)) != null && (fVar instanceof kotlin.reflect.y.internal.j0.i.w.o.h)) {
                    return ((kotlin.reflect.y.internal.j0.i.w.o.h) fVar).r().a().equals(q.a());
                }
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class f extends r {
        f(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "from";
            } else if (i2 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i2 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i2 == 2 || i2 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            if (qVar == null) {
                g(2);
            }
            if (eVar == null) {
                g(3);
            }
            if (fVar == t.o) {
                return false;
            }
            if (!(qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) || (qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) || fVar == t.n) {
                return true;
            }
            if (fVar == t.m || fVar == null) {
                return false;
            }
            kotlin.reflect.y.internal.j0.l.e0 a = fVar instanceof kotlin.reflect.y.internal.j0.i.w.o.g ? ((kotlin.reflect.y.internal.j0.i.w.o.g) fVar).a() : fVar.getType();
            return kotlin.reflect.y.internal.j0.i.d.I(a, eVar) || kotlin.reflect.y.internal.j0.l.w.a(a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.y.internal.j0.i.d.q(qVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class);
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar3 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.y.internal.j0.i.d.r(mVar, kotlin.reflect.jvm.internal.impl.descriptors.e.class, false);
            if (eVar3 == null) {
                return false;
            }
            if (eVar2 != null && kotlin.reflect.y.internal.j0.i.d.x(eVar2) && (eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.y.internal.j0.i.d.q(eVar2, kotlin.reflect.jvm.internal.impl.descriptors.e.class)) != null && kotlin.reflect.y.internal.j0.i.d.H(eVar3, eVar)) {
                return true;
            }
            q M = kotlin.reflect.y.internal.j0.i.d.M(qVar);
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar4 = (kotlin.reflect.jvm.internal.impl.descriptors.e) kotlin.reflect.y.internal.j0.i.d.q(M, kotlin.reflect.jvm.internal.impl.descriptors.e.class);
            if (eVar4 == null) {
                return false;
            }
            if (kotlin.reflect.y.internal.j0.i.d.H(eVar3, eVar4) && h(fVar, M, eVar3)) {
                return true;
            }
            return e(fVar, qVar, eVar3.b(), z);
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class g extends r {
        g(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (kotlin.reflect.y.internal.j0.i.d.g(mVar).e0(kotlin.reflect.y.internal.j0.i.d.g(qVar))) {
                return t.p.a(qVar, mVar);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class h extends r {
        h(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return true;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class i extends r {
        i(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class j extends r {
        j(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class k extends r {
        k(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class l extends r {
        l(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        Set i2;
        d dVar = new d(l1.e.f25157c);
        a = dVar;
        e eVar = new e(l1.f.f25158c);
        f25365b = eVar;
        f fVar = new f(l1.g.f25159c);
        f25366c = fVar;
        g gVar = new g(l1.b.f25154c);
        f25367d = gVar;
        h hVar = new h(l1.h.f25160c);
        f25368e = hVar;
        i iVar = new i(l1.d.f25156c);
        f25369f = iVar;
        j jVar = new j(l1.a.f25153c);
        f25370g = jVar;
        k kVar = new k(l1.c.f25155c);
        f25371h = kVar;
        l lVar = new l(l1.i.f25161c);
        f25372i = lVar;
        i2 = kotlin.collections.w0.i(dVar, eVar, gVar, iVar);
        f25373j = Collections.unmodifiableSet(i2);
        HashMap e2 = kotlin.reflect.jvm.internal.impl.utils.a.e(4);
        e2.put(eVar, 0);
        e2.put(dVar, 0);
        e2.put(gVar, 1);
        e2.put(fVar, 1);
        e2.put(hVar, 2);
        f25374k = Collections.unmodifiableMap(e2);
        l = hVar;
        m = new a();
        n = new b();
        o = new c();
        Iterator it = ServiceLoader.load(kotlin.reflect.y.internal.j0.m.l.class, kotlin.reflect.y.internal.j0.m.l.class.getClassLoader()).iterator();
        p = it.hasNext() ? (kotlin.reflect.y.internal.j0.m.l) it.next() : l.a.a;
        q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            if (i2 == 16) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
            } else {
                objArr[1] = "toDescriptorVisibility";
            }
            switch (i2) {
                case 2:
                case 3:
                    objArr[2] = "isVisibleIgnoringReceiver";
                    break;
                case 4:
                case 5:
                    objArr[2] = "isVisibleWithAnyReceiver";
                    break;
                case 6:
                case 7:
                    objArr[2] = "inSameFile";
                    break;
                case 8:
                case 9:
                    objArr[2] = "findInvisibleMember";
                    break;
                case 10:
                case 11:
                    objArr[2] = "compareLocal";
                    break;
                case 12:
                case 13:
                    objArr[2] = "compare";
                    break;
                case 14:
                    objArr[2] = "isPrivate";
                    break;
                case 15:
                    objArr[2] = "toDescriptorVisibility";
                    break;
                case 16:
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 != 16) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "from";
        if (i2 == 16) {
        }
        switch (i2) {
        }
        String format2 = String.format(str, objArr);
        if (i2 != 16) {
        }
    }

    public static Integer d(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
        }
        if (uVar2 == null) {
            a(13);
        }
        Integer a2 = uVar.a(uVar2);
        if (a2 != null) {
            return a2;
        }
        Integer a3 = uVar2.a(uVar);
        if (a3 != null) {
            return Integer.valueOf(-a3.intValue());
        }
        return null;
    }

    public static q e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z) {
        q e2;
        if (qVar == null) {
            a(8);
        }
        if (mVar == null) {
            a(9);
        }
        for (q qVar2 = (q) qVar.a(); qVar2 != null && qVar2.getVisibility() != f25369f; qVar2 = (q) kotlin.reflect.y.internal.j0.i.d.q(qVar2, q.class)) {
            if (!qVar2.getVisibility().e(fVar, qVar2, mVar, z)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.p1.i0) || (e2 = e(fVar, ((kotlin.reflect.jvm.internal.impl.descriptors.p1.i0) qVar).p0(), mVar, z)) == null) {
            return null;
        }
        return e2;
    }

    public static boolean f(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
        }
        if (mVar2 == null) {
            a(7);
        }
        a1 j2 = kotlin.reflect.y.internal.j0.i.d.j(mVar2);
        if (j2 != a1.a) {
            return j2.equals(kotlin.reflect.y.internal.j0.i.d.j(mVar));
        }
        return false;
    }

    public static boolean g(u uVar) {
        if (uVar == null) {
            a(14);
        }
        return uVar == a || uVar == f25365b;
    }

    public static boolean h(q qVar, m mVar, boolean z) {
        if (qVar == null) {
            a(2);
        }
        if (mVar == null) {
            a(3);
        }
        return e(n, qVar, mVar, z) == null;
    }

    private static void i(u uVar) {
        q.put(uVar.b(), uVar);
    }

    public static u j(m1 m1Var) {
        if (m1Var == null) {
            a(15);
        }
        u uVar = q.get(m1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + m1Var);
    }
}
