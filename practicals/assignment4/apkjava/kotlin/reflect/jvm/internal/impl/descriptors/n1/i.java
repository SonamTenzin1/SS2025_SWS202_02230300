package kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* compiled from: Annotations.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final g a(g gVar, g gVar2) {
        kotlin.jvm.internal.m.f(gVar, "first");
        kotlin.jvm.internal.m.f(gVar2, "second");
        return gVar.isEmpty() ? gVar2 : gVar2.isEmpty() ? gVar : new k(gVar, gVar2);
    }
}
