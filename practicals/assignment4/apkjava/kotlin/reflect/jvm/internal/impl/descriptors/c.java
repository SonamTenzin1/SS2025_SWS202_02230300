package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: typeParameterUtils.kt */
/* loaded from: classes2.dex */
public final class c implements e1 {

    /* renamed from: f, reason: collision with root package name */
    private final e1 f25126f;

    /* renamed from: g, reason: collision with root package name */
    private final m f25127g;

    /* renamed from: h, reason: collision with root package name */
    private final int f25128h;

    public c(e1 e1Var, m mVar, int i2) {
        kotlin.jvm.internal.m.f(e1Var, "originalDescriptor");
        kotlin.jvm.internal.m.f(mVar, "declarationDescriptor");
        this.f25126f = e1Var;
        this.f25127g = mVar;
        this.f25128h = i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public boolean F() {
        return this.f25126f.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return (R) this.f25126f.L(oVar, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public m b() {
        return this.f25127g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public int g() {
        return this.f25128h + this.f25126f.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return this.f25126f.getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i0
    public kotlin.reflect.y.internal.j0.f.f getName() {
        return this.f25126f.getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public List<kotlin.reflect.y.internal.j0.l.e0> getUpperBounds() {
        return this.f25126f.getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1, kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        return this.f25126f.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public kotlin.reflect.y.internal.j0.k.n h0() {
        return this.f25126f.h0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public r1 n() {
        return this.f25126f.n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public boolean o0() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.m0 s() {
        return this.f25126f.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        return this.f25126f.t();
    }

    public String toString() {
        return this.f25126f + "[inner-copy]";
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public e1 a() {
        e1 a = this.f25126f.a();
        kotlin.jvm.internal.m.e(a, "originalDescriptor.original");
        return a;
    }
}
