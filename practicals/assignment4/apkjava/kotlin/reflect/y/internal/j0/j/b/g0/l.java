package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.d;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.k1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: classes3.dex */
public final class l extends d implements g {
    private final n m;
    private final r n;
    private final c o;
    private final g p;
    private final h q;
    private final f r;
    private Collection<? extends i0> s;
    private m0 t;
    private m0 u;
    private List<? extends e1> v;
    private m0 w;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l(n nVar, m mVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, u uVar, r rVar, c cVar, g gVar2, h hVar, f fVar2) {
        super(mVar, gVar, fVar, r4, uVar);
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar, "annotations");
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(uVar, "visibility");
        kotlin.jvm.internal.m.f(rVar, "proto");
        kotlin.jvm.internal.m.f(cVar, "nameResolver");
        kotlin.jvm.internal.m.f(gVar2, "typeTable");
        kotlin.jvm.internal.m.f(hVar, "versionRequirementTable");
        z0 z0Var = z0.a;
        kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
        this.m = nVar;
        this.n = rVar;
        this.o = cVar;
        this.p = gVar2;
        this.q = hVar;
        this.r = fVar2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.d
    protected List<e1> N0() {
        List list = this.v;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.m.w("typeConstructorParameters");
        return null;
    }

    public r P0() {
        return this.n;
    }

    public h Q0() {
        return this.q;
    }

    public final void R0(List<? extends e1> list, m0 m0Var, m0 m0Var2) {
        kotlin.jvm.internal.m.f(list, "declaredTypeParameters");
        kotlin.jvm.internal.m.f(m0Var, "underlyingType");
        kotlin.jvm.internal.m.f(m0Var2, "expandedType");
        O0(list);
        this.t = m0Var;
        this.u = m0Var2;
        this.v = f1.d(this);
        this.w = A0();
        this.s = M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public d1 c(l1 l1Var) {
        kotlin.jvm.internal.m.f(l1Var, "substitutor");
        if (l1Var.k()) {
            return this;
        }
        n h0 = h0();
        m b2 = b();
        kotlin.jvm.internal.m.e(b2, "containingDeclaration");
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = getAnnotations();
        kotlin.jvm.internal.m.e(annotations, "annotations");
        f name = getName();
        kotlin.jvm.internal.m.e(name, "name");
        l lVar = new l(h0, b2, annotations, name, getVisibility(), P0(), Z(), T(), Q0(), c0());
        List<e1> w = w();
        m0 g0 = g0();
        r1 r1Var = r1.INVARIANT;
        e0 n = l1Var.n(g0, r1Var);
        kotlin.jvm.internal.m.e(n, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        m0 a = k1.a(n);
        e0 n2 = l1Var.n(W(), r1Var);
        kotlin.jvm.internal.m.e(n2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        lVar.R0(w, a, k1.a(n2));
        return lVar;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public g T() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public m0 W() {
        m0 m0Var = this.u;
        if (m0Var != null) {
            return m0Var;
        }
        kotlin.jvm.internal.m.w("expandedType");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public c Z() {
        return this.o;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.g
    public f c0() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public m0 g0() {
        m0 m0Var = this.t;
        if (m0Var != null) {
            return m0Var;
        }
        kotlin.jvm.internal.m.w("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.d
    protected n h0() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public e r() {
        if (g0.a(W())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h w = W().O0().w();
        if (w instanceof e) {
            return (e) w;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public m0 s() {
        m0 m0Var = this.w;
        if (m0Var != null) {
            return m0Var;
        }
        kotlin.jvm.internal.m.w("defaultTypeImpl");
        return null;
    }
}
