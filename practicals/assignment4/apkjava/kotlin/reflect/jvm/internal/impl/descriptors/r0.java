package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes2.dex */
public final class r0 {
    private final i a;

    /* renamed from: b, reason: collision with root package name */
    private final List<kotlin.reflect.y.internal.j0.l.g1> f25311b;

    /* renamed from: c, reason: collision with root package name */
    private final r0 f25312c;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(i iVar, List<? extends kotlin.reflect.y.internal.j0.l.g1> list, r0 r0Var) {
        kotlin.jvm.internal.m.f(iVar, "classifierDescriptor");
        kotlin.jvm.internal.m.f(list, "arguments");
        this.a = iVar;
        this.f25311b = list;
        this.f25312c = r0Var;
    }

    public final List<kotlin.reflect.y.internal.j0.l.g1> a() {
        return this.f25311b;
    }

    public final i b() {
        return this.a;
    }

    public final r0 c() {
        return this.f25312c;
    }
}
