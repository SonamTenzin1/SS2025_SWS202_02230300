package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.b;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.i;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.r.k;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.i.r.r;
import kotlin.reflect.y.internal.j0.i.r.w;
import kotlin.reflect.y.internal.j0.i.r.y;
import kotlin.reflect.y.internal.j0.i.r.z;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: AnnotationDeserializer.kt */
/* loaded from: classes3.dex */
public final class e {
    private final g0 a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f24488b;

    /* compiled from: AnnotationDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.C0361b.c.EnumC0364c.values().length];
            iArr[b.C0361b.c.EnumC0364c.BYTE.ordinal()] = 1;
            iArr[b.C0361b.c.EnumC0364c.CHAR.ordinal()] = 2;
            iArr[b.C0361b.c.EnumC0364c.SHORT.ordinal()] = 3;
            iArr[b.C0361b.c.EnumC0364c.INT.ordinal()] = 4;
            iArr[b.C0361b.c.EnumC0364c.LONG.ordinal()] = 5;
            iArr[b.C0361b.c.EnumC0364c.FLOAT.ordinal()] = 6;
            iArr[b.C0361b.c.EnumC0364c.DOUBLE.ordinal()] = 7;
            iArr[b.C0361b.c.EnumC0364c.BOOLEAN.ordinal()] = 8;
            iArr[b.C0361b.c.EnumC0364c.STRING.ordinal()] = 9;
            iArr[b.C0361b.c.EnumC0364c.CLASS.ordinal()] = 10;
            iArr[b.C0361b.c.EnumC0364c.ENUM.ordinal()] = 11;
            iArr[b.C0361b.c.EnumC0364c.ANNOTATION.ordinal()] = 12;
            iArr[b.C0361b.c.EnumC0364c.ARRAY.ordinal()] = 13;
            a = iArr;
        }
    }

    public e(g0 g0Var, j0 j0Var) {
        m.f(g0Var, "module");
        m.f(j0Var, "notFoundClasses");
        this.a = g0Var;
        this.f24488b = j0Var;
    }

    private final boolean b(g<?> gVar, e0 e0Var, b.C0361b.c cVar) {
        Iterable k2;
        b.C0361b.c.EnumC0364c S = cVar.S();
        int i2 = S == null ? -1 : a.a[S.ordinal()];
        if (i2 == 10) {
            h w = e0Var.O0().w();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) w : null;
            if (eVar != null && !kotlin.reflect.y.internal.j0.b.h.k0(eVar)) {
                return false;
            }
        } else {
            if (i2 != 13) {
                return m.a(gVar.a(this.a), e0Var);
            }
            if ((gVar instanceof kotlin.reflect.y.internal.j0.i.r.b) && ((kotlin.reflect.y.internal.j0.i.r.b) gVar).b().size() == cVar.J().size()) {
                e0 k3 = c().k(e0Var);
                m.e(k3, "builtIns.getArrayElementType(expectedType)");
                kotlin.reflect.y.internal.j0.i.r.b bVar = (kotlin.reflect.y.internal.j0.i.r.b) gVar;
                k2 = u.k(bVar.b());
                if (!(k2 instanceof Collection) || !((Collection) k2).isEmpty()) {
                    Iterator it = k2.iterator();
                    while (it.hasNext()) {
                        int b2 = ((IntIterator) it).b();
                        g<?> gVar2 = bVar.b().get(b2);
                        b.C0361b.c H = cVar.H(b2);
                        m.e(H, "value.getArrayElement(i)");
                        if (!b(gVar2, k3, H)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
            }
        }
        return true;
    }

    private final kotlin.reflect.y.internal.j0.b.h c() {
        return this.a.o();
    }

    private final Pair<f, g<?>> d(b.C0361b c0361b, Map<f, ? extends i1> map, c cVar) {
        i1 i1Var = map.get(x.b(cVar, c0361b.w()));
        if (i1Var == null) {
            return null;
        }
        f b2 = x.b(cVar, c0361b.w());
        e0 type = i1Var.getType();
        m.e(type, "parameter.type");
        b.C0361b.c x = c0361b.x();
        m.e(x, "proto.value");
        return new Pair<>(b2, g(type, x, cVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e e(kotlin.reflect.y.internal.j0.f.b bVar) {
        return x.c(this.a, bVar, this.f24488b);
    }

    private final g<?> g(e0 e0Var, b.C0361b.c cVar, c cVar2) {
        g<?> f2 = f(e0Var, cVar, cVar2);
        if (!b(f2, e0Var, cVar)) {
            f2 = null;
        }
        if (f2 != null) {
            return f2;
        }
        return k.f24364b.a("Unexpected argument value: actual type " + cVar.S() + " != expected type " + e0Var);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.n1.c a(b bVar, c cVar) {
        Map i2;
        int u;
        int e2;
        int b2;
        m.f(bVar, "proto");
        m.f(cVar, "nameResolver");
        kotlin.reflect.jvm.internal.impl.descriptors.e e3 = e(x.a(cVar, bVar.A()));
        i2 = q0.i();
        if (bVar.x() != 0 && !kotlin.reflect.y.internal.j0.l.u1.k.m(e3) && d.t(e3)) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k2 = e3.k();
            m.e(k2, "annotationClass.constructors");
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) s.t0(k2);
            if (dVar != null) {
                List<i1> f2 = dVar.f();
                m.e(f2, "constructor.valueParameters");
                u = v.u(f2, 10);
                e2 = p0.e(u);
                b2 = l.b(e2, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                for (Object obj : f2) {
                    linkedHashMap.put(((i1) obj).getName(), obj);
                }
                List<b.C0361b> y = bVar.y();
                m.e(y, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (b.C0361b c0361b : y) {
                    m.e(c0361b, "it");
                    Pair<f, g<?>> d2 = d(c0361b, linkedHashMap, cVar);
                    if (d2 != null) {
                        arrayList.add(d2);
                    }
                }
                i2 = q0.q(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.n1.d(e3.s(), i2, z0.a);
    }

    public final g<?> f(e0 e0Var, b.C0361b.c cVar, c cVar2) {
        g<?> eVar;
        int u;
        m.f(e0Var, "expectedType");
        m.f(cVar, "value");
        m.f(cVar2, "nameResolver");
        Boolean d2 = kotlin.reflect.y.internal.j0.e.z.b.O.d(cVar.O());
        m.e(d2, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = d2.booleanValue();
        b.C0361b.c.EnumC0364c S = cVar.S();
        switch (S == null ? -1 : a.a[S.ordinal()]) {
            case 1:
                byte Q = (byte) cVar.Q();
                return booleanValue ? new w(Q) : new kotlin.reflect.y.internal.j0.i.r.d(Q);
            case 2:
                eVar = new kotlin.reflect.y.internal.j0.i.r.e((char) cVar.Q());
                break;
            case 3:
                short Q2 = (short) cVar.Q();
                return booleanValue ? new z(Q2) : new kotlin.reflect.y.internal.j0.i.r.u(Q2);
            case 4:
                int Q3 = (int) cVar.Q();
                if (booleanValue) {
                    eVar = new kotlin.reflect.y.internal.j0.i.r.x(Q3);
                    break;
                } else {
                    eVar = new kotlin.reflect.y.internal.j0.i.r.m(Q3);
                    break;
                }
            case 5:
                long Q4 = cVar.Q();
                return booleanValue ? new y(Q4) : new r(Q4);
            case 6:
                eVar = new kotlin.reflect.y.internal.j0.i.r.l(cVar.P());
                break;
            case 7:
                eVar = new i(cVar.M());
                break;
            case 8:
                eVar = new kotlin.reflect.y.internal.j0.i.r.c(cVar.Q() != 0);
                break;
            case 9:
                eVar = new kotlin.reflect.y.internal.j0.i.r.v(cVar2.getString(cVar.R()));
                break;
            case 10:
                eVar = new q(x.a(cVar2, cVar.K()), cVar.G());
                break;
            case 11:
                eVar = new j(x.a(cVar2, cVar.K()), x.b(cVar2, cVar.N()));
                break;
            case 12:
                b F = cVar.F();
                m.e(F, "value.annotation");
                eVar = new kotlin.reflect.y.internal.j0.i.r.a(a(F, cVar2));
                break;
            case 13:
                List<b.C0361b.c> J = cVar.J();
                m.e(J, "value.arrayElementList");
                u = v.u(J, 10);
                ArrayList arrayList = new ArrayList(u);
                for (b.C0361b.c cVar3 : J) {
                    m0 i2 = c().i();
                    m.e(i2, "builtIns.anyType");
                    m.e(cVar3, "it");
                    arrayList.add(f(i2, cVar3, cVar2));
                }
                return new n(arrayList, e0Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.S() + " (expected " + e0Var + ')').toString());
        }
        return eVar;
    }
}
