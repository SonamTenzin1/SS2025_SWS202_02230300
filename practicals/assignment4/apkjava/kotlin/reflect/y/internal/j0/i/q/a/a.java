package kotlin.reflect.y.internal.j0.i.q.a;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.w1.d;
import okhttp3.HttpUrl;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class a extends m0 implements d {

    /* renamed from: g, reason: collision with root package name */
    private final g1 f24351g;

    /* renamed from: h, reason: collision with root package name */
    private final b f24352h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f24353i;

    /* renamed from: j, reason: collision with root package name */
    private final a1 f24354j;

    public /* synthetic */ a(g1 g1Var, b bVar, boolean z, a1 a1Var, int i2, g gVar) {
        this(g1Var, (i2 & 2) != 0 ? new c(g1Var) : bVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? a1.f24676g.h() : a1Var);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        List<g1> j2;
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return this.f24354j;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return this.f24353i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new a(this.f24351g, O0(), P0(), a1Var);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public b O0() {
        return this.f24352h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public a S0(boolean z) {
        return z == P0() ? this : new a(this.f24351g, O0(), z, N0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public a Y0(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        g1 b2 = this.f24351g.b(gVar);
        m.e(b2, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(b2, O0(), P0(), N0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return k.a(kotlin.reflect.y.internal.j0.l.u1.g.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.f24351g);
        sb.append(')');
        sb.append(P0() ? "?" : HttpUrl.FRAGMENT_ENCODE_SET);
        return sb.toString();
    }

    public a(g1 g1Var, b bVar, boolean z, a1 a1Var) {
        m.f(g1Var, "typeProjection");
        m.f(bVar, "constructor");
        m.f(a1Var, "attributes");
        this.f24351g = g1Var;
        this.f24352h = bVar;
        this.f24353i = z;
        this.f24354j = a1Var;
    }
}
