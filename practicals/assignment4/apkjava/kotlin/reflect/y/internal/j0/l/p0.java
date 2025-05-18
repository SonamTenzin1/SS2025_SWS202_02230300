package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: classes3.dex */
public final class p0 extends r implements o1 {

    /* renamed from: g, reason: collision with root package name */
    private final m0 f24774g;

    /* renamed from: h, reason: collision with root package name */
    private final e0 f24775h;

    public p0(m0 m0Var, e0 e0Var) {
        m.f(m0Var, "delegate");
        m.f(e0Var, "enhancement");
        this.f24774g = m0Var;
        this.f24775h = e0Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    public e0 H() {
        return this.f24775h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: V0 */
    public m0 S0(boolean z) {
        q1 d2 = p1.d(v().S0(z), H().R0().S0(z));
        m.d(d2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) d2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        q1 d2 = p1.d(v().U0(a1Var), H());
        m.d(d2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) d2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    protected m0 X0() {
        return this.f24774g;
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public m0 v() {
        return X0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public p0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 a = gVar.a(X0());
        m.d(a, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new p0((m0) a, gVar.a(H()));
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public p0 Z0(m0 m0Var) {
        m.f(m0Var, "delegate");
        return new p0(m0Var, H());
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    public String toString() {
        return "[@EnhancedForWarnings(" + H() + ")] " + v();
    }
}
