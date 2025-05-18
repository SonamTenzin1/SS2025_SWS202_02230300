package kotlin.reflect.y.internal.j0.d.a;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.w.o.f;

/* compiled from: JavaDescriptorVisibilities.java */
/* loaded from: classes2.dex */
public class r {
    public static final u a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f23685b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f23686c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<m1, u> f23687d;

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        a(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.d(qVar, mVar);
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class b extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        b(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.e(fVar, qVar, mVar);
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    /* loaded from: classes2.dex */
    static class c extends kotlin.reflect.jvm.internal.impl.descriptors.r {
        c(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
        public boolean e(f fVar, q qVar, m mVar, boolean z) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.e(fVar, qVar, mVar);
        }
    }

    static {
        a aVar = new a(kotlin.reflect.jvm.internal.impl.descriptors.q1.a.f25308c);
        a = aVar;
        b bVar = new b(kotlin.reflect.jvm.internal.impl.descriptors.q1.c.f25310c);
        f23685b = bVar;
        c cVar = new c(kotlin.reflect.jvm.internal.impl.descriptors.q1.b.f25309c);
        f23686c = cVar;
        f23687d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i2 == 5 || i2 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i2 == 2 || i2 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i2 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i2 != 5 && i2 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(m mVar, m mVar2) {
        if (mVar == null) {
            a(2);
        }
        if (mVar2 == null) {
            a(3);
        }
        k0 k0Var = (k0) d.r(mVar, k0.class, false);
        k0 k0Var2 = (k0) d.r(mVar2, k0.class, false);
        return (k0Var2 == null || k0Var == null || !k0Var.d().equals(k0Var2.d())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(f fVar, q qVar, m mVar) {
        if (qVar == null) {
            a(0);
        }
        if (mVar == null) {
            a(1);
        }
        if (d(d.M(qVar), mVar)) {
            return true;
        }
        return t.f25366c.e(fVar, qVar, mVar, false);
    }

    private static void f(u uVar) {
        f23687d.put(uVar.b(), uVar);
    }

    public static u g(m1 m1Var) {
        if (m1Var == null) {
            a(4);
        }
        u uVar = f23687d.get(m1Var);
        if (uVar != null) {
            return uVar;
        }
        u j2 = t.j(m1Var);
        if (j2 == null) {
            a(5);
        }
        return j2;
    }
}
