package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.w1.f;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* compiled from: dynamicTypes.kt */
/* loaded from: classes3.dex */
public final class v extends y implements f {

    /* renamed from: i, reason: collision with root package name */
    private final a1 f24859i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v(h hVar, a1 a1Var) {
        super(r0, r3);
        m.f(hVar, "builtIns");
        m.f(a1Var, "attributes");
        m0 H = hVar.H();
        m.e(H, "builtIns.nothingType");
        m0 I = hVar.I();
        m.e(I, "builtIns.nullableAnyType");
        this.f24859i = a1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.y, kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return this.f24859i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.y, kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public m0 V0() {
        return X0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String Y0(c cVar, kotlin.reflect.y.internal.j0.h.f fVar) {
        m.f(cVar, "renderer");
        m.f(fVar, "options");
        return "dynamic";
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public v S0(boolean z) {
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public v Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public v U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new v(a.h(V0()), a1Var);
    }
}
