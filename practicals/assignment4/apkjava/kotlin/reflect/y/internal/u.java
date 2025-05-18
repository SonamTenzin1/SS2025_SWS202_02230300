package kotlin.reflect.y.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.y.internal.JvmFunctionSignature;
import kotlin.reflect.y.internal.JvmPropertySignature;
import kotlin.reflect.y.internal.KPropertyImpl;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.calls.CallerImpl;
import kotlin.reflect.y.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.y.internal.calls.ThrowingCaller;
import kotlin.reflect.y.internal.calls.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.j.b.g0.j;
import kotlin.reflect.y.internal.j0.l.n1;
import okhttp3.HttpUrl;

/* compiled from: KPropertyImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", HttpUrl.FRAGMENT_ENCODE_SET, "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class u {
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Caller<?> b(KPropertyImpl.a<?, ?> aVar, boolean z) {
        JvmFunctionSignature.e f23040b;
        Method f23034b;
        Caller aVar2;
        a.c C;
        Method y;
        Caller cVar;
        Method f2;
        if (KDeclarationContainerImpl.f23095f.a().b(aVar.n().getN())) {
            return ThrowingCaller.a;
        }
        JvmPropertySignature f3 = RuntimeTypeMapper.a.f(aVar.n().F());
        if (f3 instanceof JvmPropertySignature.c) {
            JvmPropertySignature.c cVar2 = (JvmPropertySignature.c) f3;
            a.d f23036c = cVar2.getF23036c();
            if (z) {
                if (f23036c.G()) {
                    C = f23036c.B();
                    y = C == null ? aVar.n().getF23147k().y(cVar2.getF23037d().getString(C.x()), cVar2.getF23037d().getString(C.w())) : null;
                    if (y != null) {
                        if (f.d(aVar.n().F()) && m.a(aVar.n().F().getVisibility(), t.f25367d)) {
                            Class<?> h2 = h.h(aVar.n().F().b());
                            if (h2 != null && (f2 = h.f(h2, aVar.n().F())) != null) {
                                aVar2 = aVar.E() ? new InternalUnderlyingValOfInlineClass.a(f2, f(aVar)) : new InternalUnderlyingValOfInlineClass.b(f2);
                            } else {
                                throw new KotlinReflectionInternalError("Underlying property of inline class " + aVar.n() + " should have a field");
                            }
                        } else {
                            Field K = aVar.n().K();
                            if (K != null) {
                                aVar2 = c(aVar, z, K);
                            } else {
                                throw new KotlinReflectionInternalError("No accessors or field is found for property " + aVar.n());
                            }
                        }
                    } else {
                        if (!Modifier.isStatic(y.getModifiers())) {
                            cVar = aVar.E() ? new CallerImpl.h.a(y, f(aVar)) : new CallerImpl.h.d(y);
                        } else if (d(aVar)) {
                            cVar = aVar.E() ? new CallerImpl.h.b(y) : new CallerImpl.h.e(y);
                        } else {
                            cVar = aVar.E() ? new CallerImpl.h.c(y, f(aVar)) : new CallerImpl.h.f(y);
                        }
                        aVar2 = cVar;
                    }
                }
                C = null;
                if (C == null) {
                }
                if (y != null) {
                }
            } else {
                if (f23036c.H()) {
                    C = f23036c.C();
                    if (C == null) {
                    }
                    if (y != null) {
                    }
                }
                C = null;
                if (C == null) {
                }
                if (y != null) {
                }
            }
        } else if (f3 instanceof JvmPropertySignature.a) {
            aVar2 = c(aVar, z, ((JvmPropertySignature.a) f3).getA());
        } else if (f3 instanceof JvmPropertySignature.b) {
            if (z) {
                f23034b = ((JvmPropertySignature.b) f3).getA();
            } else {
                JvmPropertySignature.b bVar = (JvmPropertySignature.b) f3;
                f23034b = bVar.getF23034b();
                if (f23034b == null) {
                    throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + bVar.getA());
                }
            }
            aVar2 = aVar.E() ? new CallerImpl.h.a(f23034b, f(aVar)) : new CallerImpl.h.d(f23034b);
        } else {
            if (f3 instanceof JvmPropertySignature.d) {
                if (z) {
                    f23040b = ((JvmPropertySignature.d) f3).getA();
                } else {
                    f23040b = ((JvmPropertySignature.d) f3).getF23040b();
                    if (f23040b == null) {
                        throw new KotlinReflectionInternalError("No setter found for property " + aVar.n());
                    }
                }
                Method y2 = aVar.n().getF23147k().y(f23040b.c(), f23040b.b());
                if (y2 != null) {
                    Modifier.isStatic(y2.getModifiers());
                    return aVar.E() ? new CallerImpl.h.a(y2, f(aVar)) : new CallerImpl.h.d(y2);
                }
                throw new KotlinReflectionInternalError("No accessor found for property " + aVar.n());
            }
            throw new NoWhenBranchMatchedException();
        }
        return h.c(aVar2, aVar.F(), false, 2, null);
    }

    private static final CallerImpl<Field> c(KPropertyImpl.a<?, ?> aVar, boolean z, Field field) {
        CallerImpl<Field> aVar2;
        if (g(aVar.n().F()) || !Modifier.isStatic(field.getModifiers())) {
            if (z) {
                if (!aVar.E()) {
                    return new CallerImpl.f.c(field);
                }
                aVar2 = new CallerImpl.f.a(field, f(aVar));
            } else {
                aVar2 = aVar.E() ? new CallerImpl.g.a(field, e(aVar), f(aVar)) : new CallerImpl.g.c(field, e(aVar));
            }
        } else if (d(aVar)) {
            if (z) {
                return aVar.E() ? new CallerImpl.f.b(field) : new CallerImpl.f.d(field);
            }
            aVar2 = aVar.E() ? new CallerImpl.g.b(field, e(aVar)) : new CallerImpl.g.d(field, e(aVar));
        } else {
            if (z) {
                return new CallerImpl.f.e(field);
            }
            aVar2 = new CallerImpl.g.e(field, e(aVar));
        }
        return aVar2;
    }

    private static final boolean d(KPropertyImpl.a<?, ?> aVar) {
        return aVar.n().F().getAnnotations().R0(g0.j());
    }

    private static final boolean e(KPropertyImpl.a<?, ?> aVar) {
        return !n1.l(aVar.n().F().getType());
    }

    public static final Object f(KPropertyImpl.a<?, ?> aVar) {
        m.f(aVar, "<this>");
        return aVar.n().G();
    }

    private static final boolean g(t0 t0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = t0Var.b();
        m.e(b2, "containingDeclaration");
        if (!d.x(b2)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b3 = b2.b();
        return !(d.C(b3) || d.t(b3)) || ((t0Var instanceof j) && i.f(((j) t0Var).E()));
    }
}
