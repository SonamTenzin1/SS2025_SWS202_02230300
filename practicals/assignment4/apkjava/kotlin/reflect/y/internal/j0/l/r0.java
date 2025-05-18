package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: classes3.dex */
public final class r0 extends h1 {
    private final e0 a;

    public r0(h hVar) {
        m.f(hVar, "kotlinBuiltIns");
        m0 I = hVar.I();
        m.e(I, "kotlinBuiltIns.nullableAnyType");
        this.a = I;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public r1 a() {
        return r1.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public g1 b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public boolean c() {
        return true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g1
    public e0 getType() {
        return this.a;
    }
}
