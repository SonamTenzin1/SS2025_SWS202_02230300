package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.List;
import java.util.Set;

/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes2.dex */
public final class w implements v {
    private final List<x> a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<x> f25297b;

    /* renamed from: c, reason: collision with root package name */
    private final List<x> f25298c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<x> f25299d;

    public w(List<x> list, Set<x> set, List<x> list2, Set<x> set2) {
        kotlin.jvm.internal.m.f(list, "allDependencies");
        kotlin.jvm.internal.m.f(set, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.m.f(list2, "directExpectedByDependencies");
        kotlin.jvm.internal.m.f(set2, "allExpectedByDependencies");
        this.a = list;
        this.f25297b = set;
        this.f25298c = list2;
        this.f25299d = set2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.v
    public List<x> a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.v
    public Set<x> b() {
        return this.f25297b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.v
    public List<x> c() {
        return this.f25298c;
    }
}
