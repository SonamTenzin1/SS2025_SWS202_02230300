package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* compiled from: ReflectJavaRecordComponent.kt */
/* loaded from: classes2.dex */
public final class y extends t implements kotlin.reflect.y.internal.j0.d.a.n0.w {
    private final Object a;

    public y(Object obj) {
        kotlin.jvm.internal.m.f(obj, "recordComponent");
        this.a = obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.t
    public Member U() {
        Method c2 = a.a.c(this.a);
        if (c2 != null) {
            return c2;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.w
    public kotlin.reflect.y.internal.j0.d.a.n0.x getType() {
        Class<?> d2 = a.a.d(this.a);
        if (d2 != null) {
            return new n(d2);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.w
    public boolean h() {
        return false;
    }
}
