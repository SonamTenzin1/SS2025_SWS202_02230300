package kotlin.reflect.y.internal.j0.b.q;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.t.a;

/* compiled from: JavaToKotlinClassMapper.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public static /* synthetic */ e f(d dVar, c cVar, h hVar, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return dVar.e(cVar, hVar, num);
    }

    public final e a(e eVar) {
        m.f(eVar, "mutable");
        c o = c.a.o(kotlin.reflect.y.internal.j0.i.d.m(eVar));
        if (o != null) {
            e o2 = a.f(eVar).o(o);
            m.e(o2, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return o2;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a mutable collection");
    }

    public final e b(e eVar) {
        m.f(eVar, "readOnly");
        c p = c.a.p(kotlin.reflect.y.internal.j0.i.d.m(eVar));
        if (p != null) {
            e o = a.f(eVar).o(p);
            m.e(o, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return o;
        }
        throw new IllegalArgumentException("Given class " + eVar + " is not a read-only collection");
    }

    public final boolean c(e eVar) {
        m.f(eVar, "mutable");
        return c.a.k(kotlin.reflect.y.internal.j0.i.d.m(eVar));
    }

    public final boolean d(e eVar) {
        m.f(eVar, "readOnly");
        return c.a.l(kotlin.reflect.y.internal.j0.i.d.m(eVar));
    }

    public final e e(c cVar, h hVar, Integer num) {
        m.f(cVar, "fqName");
        m.f(hVar, "builtIns");
        b m = (num == null || !m.a(cVar, c.a.h())) ? c.a.m(cVar) : k.a(num.intValue());
        if (m != null) {
            return hVar.o(m.b());
        }
        return null;
    }

    public final Collection<e> g(c cVar, h hVar) {
        List m;
        Set c2;
        Set d2;
        m.f(cVar, "fqName");
        m.f(hVar, "builtIns");
        e f2 = f(this, cVar, hVar, null, 4, null);
        if (f2 == null) {
            d2 = w0.d();
            return d2;
        }
        c p = c.a.p(a.i(f2));
        if (p == null) {
            c2 = v0.c(f2);
            return c2;
        }
        e o = hVar.o(p);
        m.e(o, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        m = u.m(f2, o);
        return m;
    }
}
