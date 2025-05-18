package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;

/* compiled from: PropertyDescriptor.java */
/* loaded from: classes2.dex */
public interface t0 extends b, k1 {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.m
    t0 a();

    t0 c(kotlin.reflect.y.internal.j0.l.l1 l1Var);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends t0> e();

    u0 getGetter();

    v0 getSetter();

    w n0();

    w q0();

    List<s0> x();
}
