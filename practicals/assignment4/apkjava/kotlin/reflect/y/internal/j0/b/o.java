package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.s;

/* compiled from: UnsignedType.kt */
/* loaded from: classes2.dex */
public final class o {
    public static final o a = new o();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<f> f23223b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<f> f23224c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<b, b> f23225d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<b, b> f23226e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<m, f> f23227f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<f> f23228g;

    static {
        Set<f> I0;
        Set<f> I02;
        HashMap<m, f> k2;
        n[] values = n.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (n nVar : values) {
            arrayList.add(nVar.u());
        }
        I0 = c0.I0(arrayList);
        f23223b = I0;
        m[] values2 = m.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (m mVar : values2) {
            arrayList2.add(mVar.k());
        }
        I02 = c0.I0(arrayList2);
        f23224c = I02;
        f23225d = new HashMap<>();
        f23226e = new HashMap<>();
        k2 = q0.k(s.a(m.f23211f, f.x("ubyteArrayOf")), s.a(m.f23212g, f.x("ushortArrayOf")), s.a(m.f23213h, f.x("uintArrayOf")), s.a(m.f23214i, f.x("ulongArrayOf")));
        f23227f = k2;
        n[] values3 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar2 : values3) {
            linkedHashSet.add(nVar2.k().j());
        }
        f23228g = linkedHashSet;
        for (n nVar3 : n.values()) {
            f23225d.put(nVar3.k(), nVar3.q());
            f23226e.put(nVar3.q(), nVar3.k());
        }
    }

    private o() {
    }

    public static final boolean d(e0 e0Var) {
        h w;
        m.f(e0Var, "type");
        if (n1.v(e0Var) || (w = e0Var.O0().w()) == null) {
            return false;
        }
        return a.c(w);
    }

    public final b a(b bVar) {
        m.f(bVar, "arrayClassId");
        return f23225d.get(bVar);
    }

    public final boolean b(f fVar) {
        m.f(fVar, "name");
        return f23228g.contains(fVar);
    }

    public final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = mVar.b();
        return (b2 instanceof k0) && m.a(((k0) b2).d(), k.r) && f23223b.contains(mVar.getName());
    }
}
