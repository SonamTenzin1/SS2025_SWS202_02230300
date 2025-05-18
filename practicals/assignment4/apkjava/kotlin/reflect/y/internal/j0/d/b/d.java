package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.y.internal.j0.b.g;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.t1.q;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.x;
import kotlin.text.u;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final String a(e eVar, y<?> yVar) {
        String z;
        m.f(eVar, "klass");
        m.f(yVar, "typeMappingConfiguration");
        String b2 = yVar.b(eVar);
        if (b2 != null) {
            return b2;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b3 = eVar.b();
        m.e(b3, "klass.containingDeclaration");
        String u = h.b(eVar.getName()).u();
        m.e(u, "safeIdentifier(klass.name).identifier");
        if (b3 instanceof k0) {
            c d2 = ((k0) b3).d();
            if (d2.d()) {
                return u;
            }
            StringBuilder sb = new StringBuilder();
            String b4 = d2.b();
            m.e(b4, "fqName.asString()");
            z = u.z(b4, '.', '/', false, 4, null);
            sb.append(z);
            sb.append('/');
            sb.append(u);
            return sb.toString();
        }
        e eVar2 = b3 instanceof e ? (e) b3 : null;
        if (eVar2 != null) {
            String d3 = yVar.d(eVar2);
            if (d3 == null) {
                d3 = a(eVar2, yVar);
            }
            return d3 + '$' + u;
        }
        throw new IllegalArgumentException("Unexpected container: " + b3 + " for " + eVar);
    }

    public static /* synthetic */ String b(e eVar, y yVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            yVar = z.a;
        }
        return a(eVar, yVar);
    }

    public static final boolean c(a aVar) {
        m.f(aVar, "descriptor");
        if (aVar instanceof l) {
            return true;
        }
        e0 returnType = aVar.getReturnType();
        m.c(returnType);
        if (kotlin.reflect.y.internal.j0.b.h.B0(returnType)) {
            e0 returnType2 = aVar.getReturnType();
            m.c(returnType2);
            if (!n1.l(returnType2) && !(aVar instanceof u0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, java.lang.Object] */
    public static final <T> T d(e0 e0Var, m<T> mVar, a0 a0Var, y<? extends T> yVar, j<T> jVar, Function3<? super e0, ? super T, ? super a0, kotlin.u> function3) {
        T t;
        e0 e0Var2;
        Object d2;
        m.f(e0Var, "kotlinType");
        m.f(mVar, "factory");
        m.f(a0Var, "mode");
        m.f(yVar, "typeMappingConfiguration");
        m.f(function3, "writeGenericType");
        e0 e2 = yVar.e(e0Var);
        if (e2 != null) {
            return (T) d(e2, mVar, a0Var, yVar, jVar, function3);
        }
        if (g.q(e0Var)) {
            return (T) d(kotlin.reflect.y.internal.j0.b.l.a(e0Var), mVar, a0Var, yVar, jVar, function3);
        }
        q qVar = q.a;
        Object b2 = b0.b(qVar, e0Var, mVar, a0Var);
        if (b2 != null) {
            ?? r11 = (Object) b0.a(mVar, b2, a0Var.d());
            function3.d(e0Var, r11, a0Var);
            return r11;
        }
        e1 O0 = e0Var.O0();
        if (O0 instanceof d0) {
            d0 d0Var = (d0) O0;
            e0 i2 = d0Var.i();
            if (i2 == null) {
                i2 = yVar.c(d0Var.a());
            }
            return (T) d(kotlin.reflect.y.internal.j0.l.x1.a.w(i2), mVar, a0Var, yVar, jVar, function3);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h w = O0.w();
        if (w != null) {
            if (k.m(w)) {
                T t2 = (T) mVar.c("error/NonExistentClass");
                yVar.f(e0Var, (e) w);
                if (jVar == null) {
                    return t2;
                }
                throw null;
            }
            boolean z = w instanceof e;
            if (z && kotlin.reflect.y.internal.j0.b.h.c0(e0Var)) {
                if (e0Var.M0().size() == 1) {
                    g1 g1Var = e0Var.M0().get(0);
                    e0 type = g1Var.getType();
                    m.e(type, "memberProjection.type");
                    if (g1Var.a() == r1.IN_VARIANCE) {
                        d2 = mVar.c("java/lang/Object");
                        if (jVar != null) {
                            throw null;
                        }
                    } else if (jVar == null) {
                        r1 a = g1Var.a();
                        m.e(a, "memberProjection.projectionKind");
                        d2 = d(type, mVar, a0Var.f(a, true), yVar, jVar, function3);
                        if (jVar != null) {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                    return (T) mVar.b('[' + mVar.a(d2));
                }
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            if (z) {
                if (f.b(w) && !a0Var.c() && (e0Var2 = (e0) x.a(qVar, e0Var)) != null) {
                    return (T) d(e0Var2, mVar, a0Var.g(), yVar, jVar, function3);
                }
                if (a0Var.e() && kotlin.reflect.y.internal.j0.b.h.k0((e) w)) {
                    t = (Object) mVar.e();
                } else {
                    e eVar = (e) w;
                    e a2 = eVar.a();
                    m.e(a2, "descriptor.original");
                    T a3 = yVar.a(a2);
                    if (a3 == null) {
                        if (eVar.i() == kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY) {
                            kotlin.reflect.jvm.internal.impl.descriptors.m b3 = eVar.b();
                            m.d(b3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            eVar = (e) b3;
                        }
                        e a4 = eVar.a();
                        m.e(a4, "enumClassIfEnumEntry.original");
                        t = (Object) mVar.c(a(a4, yVar));
                    } else {
                        t = (Object) a3;
                    }
                }
                function3.d(e0Var, t, a0Var);
                return t;
            }
            if (w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) {
                e0 i3 = kotlin.reflect.y.internal.j0.l.x1.a.i((kotlin.reflect.jvm.internal.impl.descriptors.e1) w);
                if (e0Var.P0()) {
                    i3 = kotlin.reflect.y.internal.j0.l.x1.a.t(i3);
                }
                T t3 = (T) d(i3, mVar, a0Var, yVar, null, kotlin.reflect.jvm.internal.impl.utils.d.b());
                if (jVar == null) {
                    return t3;
                }
                m.e(w.getName(), "descriptor.getName()");
                throw null;
            }
            if ((w instanceof d1) && a0Var.b()) {
                return (T) d(((d1) w).W(), mVar, a0Var, yVar, jVar, function3);
            }
            throw new UnsupportedOperationException("Unknown type " + e0Var);
        }
        throw new UnsupportedOperationException("no descriptor for type constructor of " + e0Var);
    }

    public static /* synthetic */ Object e(e0 e0Var, m mVar, a0 a0Var, y yVar, j jVar, Function3 function3, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function3 = kotlin.reflect.jvm.internal.impl.utils.d.b();
        }
        return d(e0Var, mVar, a0Var, yVar, jVar, function3);
    }
}
