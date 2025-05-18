package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import kotlin.reflect.y.internal.g0;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import okhttp3.HttpUrl;

/* compiled from: InlineClassAwareCaller.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", HttpUrl.FRAGMENT_ENCODE_SET, "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    public static final Object a(Object obj, b bVar) {
        e0 e2;
        Class<?> i2;
        Method f2;
        m.f(bVar, "descriptor");
        return (((bVar instanceof t0) && f.d((j1) bVar)) || (e2 = e(bVar)) == null || (i2 = i(e2)) == null || (f2 = f(i2, bVar)) == null) ? obj : f2.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> b(Caller<? extends M> caller, b bVar, boolean z) {
        boolean z2;
        m.f(caller, "<this>");
        m.f(bVar, "descriptor");
        boolean z3 = true;
        if (!f.a(bVar)) {
            List<i1> f2 = bVar.f();
            m.e(f2, "descriptor.valueParameters");
            if (!(f2 instanceof Collection) || !f2.isEmpty()) {
                Iterator<T> it = f2.iterator();
                while (it.hasNext()) {
                    e0 type = ((i1) it.next()).getType();
                    m.e(type, "it.type");
                    if (f.c(type)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                e0 returnType = bVar.getReturnType();
                if (!(returnType != null && f.c(returnType)) && ((caller instanceof BoundCaller) || !g(bVar))) {
                    z3 = false;
                }
            }
        }
        return z3 ? new InlineClassAwareCaller(bVar, caller, z) : caller;
    }

    public static /* synthetic */ Caller c(Caller caller, b bVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(caller, bVar, z);
    }

    public static final Method d(Class<?> cls, b bVar) {
        m.f(cls, "<this>");
        m.f(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, bVar).getReturnType());
            m.e(declaredMethod, "{\n        getDeclaredMet…riptor).returnType)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final e0 e(b bVar) {
        w0 m0 = bVar.m0();
        w0 f0 = bVar.f0();
        if (m0 != null) {
            return m0.getType();
        }
        if (f0 == null) {
            return null;
        }
        if (bVar instanceof l) {
            return f0.getType();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = bVar.b();
        e eVar = b2 instanceof e ? (e) b2 : null;
        if (eVar != null) {
            return eVar.s();
        }
        return null;
    }

    public static final Method f(Class<?> cls, b bVar) {
        m.f(cls, "<this>");
        m.f(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            m.e(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
        }
    }

    private static final boolean g(b bVar) {
        e0 e2 = e(bVar);
        return e2 != null && f.c(e2);
    }

    public static final Class<?> h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (!(mVar instanceof e) || !f.b(mVar)) {
            return null;
        }
        e eVar = (e) mVar;
        Class<?> p = g0.p(eVar);
        if (p != null) {
            return p;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + eVar.getName() + " cannot be found (classId=" + a.g((kotlin.reflect.jvm.internal.impl.descriptors.h) mVar) + ')');
    }

    public static final Class<?> i(e0 e0Var) {
        m.f(e0Var, "<this>");
        Class<?> h2 = h(e0Var.O0().w());
        if (h2 == null) {
            return null;
        }
        if (!n1.l(e0Var)) {
            return h2;
        }
        e0 e2 = f.e(e0Var);
        if (e2 == null || n1.l(e2) || kotlin.reflect.y.internal.j0.b.h.r0(e2)) {
            return null;
        }
        return h2;
    }
}
