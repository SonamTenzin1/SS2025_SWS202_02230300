package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.List;
import kotlin.reflect.y.internal.j0.j.b.r;

/* compiled from: RuntimeErrorReporter.kt */
/* loaded from: classes2.dex */
public final class j implements r {

    /* renamed from: b, reason: collision with root package name */
    public static final j f25319b = new j();

    private j() {
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.r
    public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.r
    public void b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<String> list) {
        kotlin.jvm.internal.m.f(eVar, "descriptor");
        kotlin.jvm.internal.m.f(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + eVar.getName() + ", unresolved classes " + list);
    }
}
