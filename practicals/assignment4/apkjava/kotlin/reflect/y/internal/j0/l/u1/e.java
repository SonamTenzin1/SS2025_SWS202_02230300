package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;

/* compiled from: ErrorPropertyDescriptor.kt */
/* loaded from: classes3.dex */
public final class e implements t0 {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ c0 f24831f;

    public e() {
        List<? extends e1> j2;
        List<w0> j3;
        k kVar = k.a;
        c0 P0 = c0.P0(kVar.h(), g.f25179c.b(), d0.OPEN, t.f25368e, true, f.D(b.ERROR_PROPERTY.k()), b.a.DECLARATION, z0.a, false, false, false, false, false, false);
        e0 k2 = kVar.k();
        j2 = u.j();
        j3 = u.j();
        P0.c1(k2, j2, null, null, j3);
        this.f24831f = P0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return this.f24831f.E0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean G() {
        return this.f24831f.G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return (R) this.f24831f.L(oVar, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return this.f24831f.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k1
    public boolean O() {
        return this.f24831f.O();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public kotlin.reflect.y.internal.j0.i.r.g<?> X() {
        return this.f24831f.X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public t0 a() {
        return this.f24831f.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public m b() {
        return this.f24831f.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    public t0 c(l1 l1Var) {
        kotlin.jvm.internal.m.f(l1Var, "substitutor");
        return this.f24831f.c(l1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends t0> e() {
        return this.f24831f.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        return this.f24831f.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public w0 f0() {
        return this.f24831f.f0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public g getAnnotations() {
        g annotations = this.f24831f.getAnnotations();
        kotlin.jvm.internal.m.e(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public u0 getGetter() {
        return this.f24831f.getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        return this.f24831f.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public e0 getReturnType() {
        return this.f24831f.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public v0 getSetter() {
        return this.f24831f.getSetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1
    public e0 getType() {
        return this.f24831f.getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<e1> getTypeParameters() {
        return this.f24831f.getTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        return this.f24831f.getVisibility();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public b.a i() {
        return this.f24831f.i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V i0(a.InterfaceC0406a<V> interfaceC0406a) {
        return (V) this.f24831f.i0(interfaceC0406a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean isConst() {
        return this.f24831f.isConst();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        return this.f24831f.j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean j0() {
        return this.f24831f.j0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public b k0(m mVar, d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, b.a aVar, boolean z) {
        return this.f24831f.k0(mVar, d0Var, uVar, aVar, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public w0 m0() {
        return this.f24831f.m0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public w n0() {
        return this.f24831f.n0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public w q0() {
        return this.f24831f.q0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<w0> r0() {
        return this.f24831f.r0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean s0() {
        return this.f24831f.s0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        return this.f24831f.t();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t0
    public List<s0> x() {
        return this.f24831f.x();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b
    public void x0(Collection<? extends b> collection) {
        kotlin.jvm.internal.m.f(collection, "overriddenDescriptors");
        this.f24831f.x0(collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return this.f24831f.z();
    }
}
