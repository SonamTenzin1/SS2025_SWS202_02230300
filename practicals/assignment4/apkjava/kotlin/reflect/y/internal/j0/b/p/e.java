package kotlin.reflect.y.internal.j0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.m.q;

/* compiled from: FunctionInvokeDescriptor.kt */
/* loaded from: classes2.dex */
public final class e extends g0 {
    public static final a J = new a(null);

    /* compiled from: FunctionInvokeDescriptor.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final i1 b(e eVar, int i2, e1 e1Var) {
            String lowerCase;
            String k2 = e1Var.getName().k();
            m.e(k2, "typeParameter.name.asString()");
            if (m.a(k2, "T")) {
                lowerCase = "instance";
            } else if (m.a(k2, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = k2.toLowerCase(Locale.ROOT);
                m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            kotlin.reflect.jvm.internal.impl.descriptors.n1.g b2 = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
            f x = f.x(lowerCase);
            m.e(x, "identifier(name)");
            m0 s = e1Var.s();
            m.e(s, "typeParameter.defaultType");
            z0 z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
            return new l0(eVar, null, i2, b2, x, s, false, false, false, null, z0Var);
        }

        public final e a(b bVar, boolean z) {
            List<w0> j2;
            List<? extends e1> j3;
            Iterable<IndexedValue> K0;
            int u;
            m.f(bVar, "functionClass");
            List<e1> w = bVar.w();
            e eVar = new e(bVar, null, b.a.DECLARATION, z, null);
            w0 K02 = bVar.K0();
            j2 = u.j();
            j3 = u.j();
            ArrayList arrayList = new ArrayList();
            for (Object obj : w) {
                if (!(((e1) obj).n() == r1.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            K0 = c0.K0(arrayList);
            u = v.u(K0, 10);
            ArrayList arrayList2 = new ArrayList(u);
            for (IndexedValue indexedValue : K0) {
                arrayList2.add(e.J.b(eVar, indexedValue.c(), (e1) indexedValue.d()));
            }
            eVar.S0(null, K02, j2, j3, arrayList2, ((e1) s.g0(w)).s(), d0.ABSTRACT, t.f25368e);
            eVar.a1(true);
            return eVar;
        }
    }

    private e(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, e eVar, b.a aVar, boolean z) {
        super(mVar, eVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), q.f24924i, aVar, z0.a);
        g1(true);
        i1(z);
        Z0(false);
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, e eVar, b.a aVar, boolean z, g gVar) {
        this(mVar, eVar, aVar, z);
    }

    private final y q1(List<f> list) {
        int u;
        f fVar;
        List<Pair> L0;
        boolean z;
        int size = f().size() - list.size();
        boolean z2 = true;
        if (size == 0) {
            List<i1> f2 = f();
            m.e(f2, "valueParameters");
            L0 = c0.L0(list, f2);
            if (!(L0 instanceof Collection) || !L0.isEmpty()) {
                for (Pair pair : L0) {
                    if (!m.a((f) pair.a(), ((i1) pair.b()).getName())) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return this;
            }
        }
        List<i1> f3 = f();
        m.e(f3, "valueParameters");
        u = v.u(f3, 10);
        ArrayList arrayList = new ArrayList(u);
        for (i1 i1Var : f3) {
            f name = i1Var.getName();
            m.e(name, "it.name");
            int g2 = i1Var.g();
            int i2 = g2 - size;
            if (i2 >= 0 && (fVar = list.get(i2)) != null) {
                name = fVar;
            }
            arrayList.add(i1Var.G0(this, name, g2));
        }
        p.c T0 = T0(l1.a);
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((f) it.next()) == null) {
                    break;
                }
            }
        }
        z2 = false;
        p.c h2 = T0.H(z2).b(arrayList).h(a());
        m.e(h2, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        y N0 = super.N0(h2);
        m.c(N0);
        return N0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.reflect.jvm.internal.impl.descriptors.p1.p
    protected p M0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, y yVar, b.a aVar, f fVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        m.f(mVar, "newOwner");
        m.f(aVar, "kind");
        m.f(gVar, "annotations");
        m.f(z0Var, "source");
        return new e(mVar, (e) yVar, aVar, isSuspend());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p
    public y N0(p.c cVar) {
        int u;
        m.f(cVar, "configuration");
        e eVar = (e) super.N0(cVar);
        if (eVar == null) {
            return null;
        }
        List<i1> f2 = eVar.f();
        m.e(f2, "substituted.valueParameters");
        boolean z = false;
        if (!(f2 instanceof Collection) || !f2.isEmpty()) {
            Iterator<T> it = f2.iterator();
            while (it.hasNext()) {
                e0 type = ((i1) it.next()).getType();
                m.e(type, "it.type");
                if (kotlin.reflect.y.internal.j0.b.g.d(type) != null) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return eVar;
        }
        List<i1> f3 = eVar.f();
        m.e(f3, "substituted.valueParameters");
        u = v.u(f3, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it2 = f3.iterator();
        while (it2.hasNext()) {
            e0 type2 = ((i1) it2.next()).getType();
            m.e(type2, "it.type");
            arrayList.add(kotlin.reflect.y.internal.j0.b.g.d(type2));
        }
        return eVar.q1(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean P() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return false;
    }
}
