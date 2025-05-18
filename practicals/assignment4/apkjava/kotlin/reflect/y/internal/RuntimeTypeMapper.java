package kotlin.reflect.y.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.u;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.JvmFunctionSignature;
import kotlin.reflect.y.internal.JvmPropertySignature;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.b.q.a;
import kotlin.reflect.y.internal.j0.d.a.g0;
import kotlin.reflect.y.internal.j0.d.a.k0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.l;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.d;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.reflect.y.internal.j0.j.b.g0.j;
import okhttp3.HttpUrl;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: kotlin.f0.y.e.d0, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper a = new RuntimeTypeMapper();

    /* renamed from: b, reason: collision with root package name */
    private static final b f23033b;

    static {
        b m = b.m(new c("java.lang.Void"));
        m.e(m, "topLevel(FqName(\"java.lang.Void\"))");
        f23033b = m;
    }

    private RuntimeTypeMapper() {
    }

    private final i a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return e.k(cls.getSimpleName()).x();
        }
        return null;
    }

    private final boolean b(y yVar) {
        if (kotlin.reflect.y.internal.j0.i.c.o(yVar) || kotlin.reflect.y.internal.j0.i.c.p(yVar)) {
            return true;
        }
        return m.a(yVar.getName(), a.f23239e.a()) && yVar.f().isEmpty();
    }

    private final JvmFunctionSignature.e d(y yVar) {
        return new JvmFunctionSignature.e(new d.b(e(yVar), v.c(yVar, false, false, 1, null)));
    }

    private final String e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        String b2 = g0.b(bVar);
        if (b2 != null) {
            return b2;
        }
        if (bVar instanceof u0) {
            String k2 = kotlin.reflect.y.internal.j0.i.t.a.o(bVar).getName().k();
            m.e(k2, "descriptor.propertyIfAccessor.name.asString()");
            return z.b(k2);
        }
        if (bVar instanceof v0) {
            String k3 = kotlin.reflect.y.internal.j0.i.t.a.o(bVar).getName().k();
            m.e(k3, "descriptor.propertyIfAccessor.name.asString()");
            return z.e(k3);
        }
        String k4 = bVar.getName().k();
        m.e(k4, "descriptor.name.asString()");
        return k4;
    }

    public final b c(Class<?> cls) {
        m.f(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            m.e(componentType, "klass.componentType");
            i a2 = a(componentType);
            if (a2 != null) {
                return new b(k.r, a2.q());
            }
            b m = b.m(k.a.f23208i.l());
            m.e(m, "topLevel(StandardNames.FqNames.array.toSafe())");
            return m;
        }
        if (m.a(cls, Void.TYPE)) {
            return f23033b;
        }
        i a3 = a(cls);
        if (a3 != null) {
            return new b(k.r, a3.v());
        }
        b a4 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(cls);
        if (!a4.k()) {
            kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
            c b2 = a4.b();
            m.e(b2, "classId.asSingleFqName()");
            b m2 = cVar.m(b2);
            if (m2 != null) {
                return m2;
            }
        }
        return a4;
    }

    public final JvmPropertySignature f(t0 t0Var) {
        m.f(t0Var, "possiblyOverriddenProperty");
        t0 a2 = ((t0) kotlin.reflect.y.internal.j0.i.d.L(t0Var)).a();
        m.e(a2, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (a2 instanceof j) {
            j jVar = (j) a2;
            n E = jVar.E();
            h.f<n, a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
            m.e(fVar, "propertySignature");
            a.d dVar = (a.d) kotlin.reflect.y.internal.j0.e.z.e.a(E, fVar);
            if (dVar != null) {
                return new JvmPropertySignature.c(a2, E, dVar, jVar.Z(), jVar.T());
            }
        } else if (a2 instanceof f) {
            z0 t = ((f) a2).t();
            kotlin.reflect.y.internal.j0.d.a.m0.a aVar = t instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) t : null;
            l b2 = aVar != null ? aVar.b() : null;
            if (b2 instanceof r) {
                return new JvmPropertySignature.a(((r) b2).U());
            }
            if (b2 instanceof u) {
                Method U = ((u) b2).U();
                v0 setter = a2.getSetter();
                z0 t2 = setter != null ? setter.t() : null;
                kotlin.reflect.y.internal.j0.d.a.m0.a aVar2 = t2 instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) t2 : null;
                l b3 = aVar2 != null ? aVar2.b() : null;
                u uVar = b3 instanceof u ? (u) b3 : null;
                return new JvmPropertySignature.b(U, uVar != null ? uVar.U() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + a2 + " (source = " + b2 + ')');
        }
        u0 getter = a2.getGetter();
        m.c(getter);
        JvmFunctionSignature.e d2 = d(getter);
        v0 setter2 = a2.getSetter();
        return new JvmPropertySignature.d(d2, setter2 != null ? d(setter2) : null);
    }

    public final JvmFunctionSignature g(y yVar) {
        Method U;
        d.b b2;
        d.b e2;
        m.f(yVar, "possiblySubstitutedFunction");
        y a2 = ((y) kotlin.reflect.y.internal.j0.i.d.L(yVar)).a();
        m.e(a2, "unwrapFakeOverride(possi…titutedFunction).original");
        if (a2 instanceof kotlin.reflect.y.internal.j0.j.b.g0.b) {
            kotlin.reflect.y.internal.j0.j.b.g0.b bVar = (kotlin.reflect.y.internal.j0.j.b.g0.b) a2;
            o E = bVar.E();
            if ((E instanceof kotlin.reflect.y.internal.j0.e.i) && (e2 = kotlin.reflect.y.internal.j0.e.a0.b.i.a.e((kotlin.reflect.y.internal.j0.e.i) E, bVar.Z(), bVar.T())) != null) {
                return new JvmFunctionSignature.e(e2);
            }
            if ((E instanceof kotlin.reflect.y.internal.j0.e.d) && (b2 = kotlin.reflect.y.internal.j0.e.a0.b.i.a.b((kotlin.reflect.y.internal.j0.e.d) E, bVar.Z(), bVar.T())) != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.m b3 = yVar.b();
                m.e(b3, "possiblySubstitutedFunction.containingDeclaration");
                if (kotlin.reflect.y.internal.j0.i.f.b(b3)) {
                    return new JvmFunctionSignature.e(b2);
                }
                return new JvmFunctionSignature.d(b2);
            }
            return d(a2);
        }
        if (a2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e) {
            z0 t = ((kotlin.reflect.y.internal.j0.d.a.k0.e) a2).t();
            kotlin.reflect.y.internal.j0.d.a.m0.a aVar = t instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) t : null;
            l b4 = aVar != null ? aVar.b() : null;
            u uVar = b4 instanceof u ? (u) b4 : null;
            if (uVar != null && (U = uVar.U()) != null) {
                return new JvmFunctionSignature.c(U);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + a2);
        }
        if (a2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.b) {
            z0 t2 = ((kotlin.reflect.y.internal.j0.d.a.k0.b) a2).t();
            kotlin.reflect.y.internal.j0.d.a.m0.a aVar2 = t2 instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) t2 : null;
            l b5 = aVar2 != null ? aVar2.b() : null;
            if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r1.b.o) {
                return new JvmFunctionSignature.b(((kotlin.reflect.jvm.internal.impl.descriptors.r1.b.o) b5).U());
            }
            if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r1.b.l) {
                kotlin.reflect.jvm.internal.impl.descriptors.r1.b.l lVar = (kotlin.reflect.jvm.internal.impl.descriptors.r1.b.l) b5;
                if (lVar.r()) {
                    return new JvmFunctionSignature.a(lVar.w());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + a2 + " (" + b5 + ')');
        }
        if (b(a2)) {
            return d(a2);
        }
        throw new KotlinReflectionInternalError("Unknown origin of " + a2 + " (" + a2.getClass() + ')');
    }
}
