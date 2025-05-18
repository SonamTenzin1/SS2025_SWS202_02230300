package kotlin.reflect.y.internal.j0.l.t1;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.w1.b;
import kotlin.reflect.y.internal.j0.l.w1.d;

/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
public final class i extends m0 implements d {

    /* renamed from: g, reason: collision with root package name */
    private final b f24788g;

    /* renamed from: h, reason: collision with root package name */
    private final j f24789h;

    /* renamed from: i, reason: collision with root package name */
    private final q1 f24790i;

    /* renamed from: j, reason: collision with root package name */
    private final a1 f24791j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f24792k;
    private final boolean l;

    public /* synthetic */ i(b bVar, j jVar, q1 q1Var, a1 a1Var, boolean z, boolean z2, int i2, g gVar) {
        this(bVar, jVar, q1Var, (i2 & 8) != 0 ? a1.f24676g.h() : a1Var, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        List<g1> j2;
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return this.f24791j;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return this.f24792k;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new i(this.f24788g, O0(), this.f24790i, a1Var, P0(), this.l);
    }

    public final b X0() {
        return this.f24788g;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public j O0() {
        return this.f24789h;
    }

    public final q1 Z0() {
        return this.f24790i;
    }

    public final boolean a1() {
        return this.l;
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public i S0(boolean z) {
        return new i(this.f24788g, O0(), this.f24790i, N0(), z, false, 32, null);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public i Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        b bVar = this.f24788g;
        j b2 = O0().b(gVar);
        q1 q1Var = this.f24790i;
        return new i(bVar, b2, q1Var != null ? gVar.a(q1Var).R0() : null, N0(), P0(), false, 32, null);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return k.a(kotlin.reflect.y.internal.j0.l.u1.g.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public i(b bVar, j jVar, q1 q1Var, a1 a1Var, boolean z, boolean z2) {
        m.f(bVar, "captureStatus");
        m.f(jVar, "constructor");
        m.f(a1Var, "attributes");
        this.f24788g = bVar;
        this.f24789h = jVar;
        this.f24790i = q1Var;
        this.f24791j = a1Var;
        this.f24792k = z;
        this.l = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(b bVar, q1 q1Var, g1 g1Var, e1 e1Var) {
        this(bVar, new j(g1Var, null, null, e1Var, 6, null), q1Var, null, false, false, 56, null);
        m.f(bVar, "captureStatus");
        m.f(g1Var, "projection");
        m.f(e1Var, "typeParameter");
    }
}
