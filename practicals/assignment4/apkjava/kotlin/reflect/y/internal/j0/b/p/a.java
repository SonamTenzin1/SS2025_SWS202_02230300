package kotlin.reflect.y.internal.j0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.b;
import kotlin.reflect.y.internal.j0.b.p.c;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.text.u;
import kotlin.text.v;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* loaded from: classes2.dex */
public final class a implements b {
    private final n a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f23229b;

    public a(n nVar, g0 g0Var) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        this.a = nVar;
        this.f23229b = g0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public Collection<e> a(c cVar) {
        Set d2;
        m.f(cVar, "packageFqName");
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public boolean b(c cVar, f fVar) {
        boolean E;
        boolean E2;
        boolean E3;
        boolean E4;
        m.f(cVar, "packageFqName");
        m.f(fVar, "name");
        String k2 = fVar.k();
        m.e(k2, "name.asString()");
        E = u.E(k2, "Function", false, 2, null);
        if (!E) {
            E2 = u.E(k2, "KFunction", false, 2, null);
            if (!E2) {
                E3 = u.E(k2, "SuspendFunction", false, 2, null);
                if (!E3) {
                    E4 = u.E(k2, "KSuspendFunction", false, 2, null);
                    if (!E4) {
                        return false;
                    }
                }
            }
        }
        return c.f23232f.c(k2, cVar) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public e c(kotlin.reflect.y.internal.j0.f.b bVar) {
        boolean J;
        m.f(bVar, "classId");
        if (bVar.k() || bVar.l()) {
            return null;
        }
        String b2 = bVar.i().b();
        m.e(b2, "classId.relativeClassName.asString()");
        J = v.J(b2, "Function", false, 2, null);
        if (!J) {
            return null;
        }
        c h2 = bVar.h();
        m.e(h2, "classId.packageFqName");
        c.a.C0323a c2 = c.f23232f.c(b2, h2);
        if (c2 == null) {
            return null;
        }
        c a = c2.a();
        int b3 = c2.b();
        List<k0> I = this.f23229b.N(h2).I();
        ArrayList arrayList = new ArrayList();
        for (Object obj : I) {
            if (obj instanceof kotlin.reflect.y.internal.j0.b.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof kotlin.reflect.y.internal.j0.b.f) {
                arrayList2.add(obj2);
            }
        }
        k0 k0Var = (kotlin.reflect.y.internal.j0.b.f) s.W(arrayList2);
        if (k0Var == null) {
            k0Var = (kotlin.reflect.y.internal.j0.b.b) s.U(arrayList);
        }
        return new b(this.a, k0Var, a, b3);
    }
}
