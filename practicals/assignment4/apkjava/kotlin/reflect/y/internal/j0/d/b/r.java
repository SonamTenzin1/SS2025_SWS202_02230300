package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.l0.l.h;

/* compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* loaded from: classes3.dex */
public final class r implements z0 {

    /* renamed from: b, reason: collision with root package name */
    private final h f23814b;

    public r(h hVar) {
        m.f(hVar, "packageFragment");
        this.f23814b = hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    public String toString() {
        return this.f23814b + ": " + this.f23814b.N0().keySet();
    }
}
