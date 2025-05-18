package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.j.b.g;

/* compiled from: JavaClassDataFinder.kt */
/* loaded from: classes3.dex */
public final class h implements kotlin.reflect.y.internal.j0.j.b.h {
    private final o a;

    /* renamed from: b, reason: collision with root package name */
    private final g f23794b;

    public h(o oVar, g gVar) {
        m.f(oVar, "kotlinClassFinder");
        m.f(gVar, "deserializedDescriptorResolver");
        this.a = oVar;
        this.f23794b = gVar;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.h
    public g a(b bVar) {
        m.f(bVar, "classId");
        q b2 = p.b(this.a, bVar);
        if (b2 == null) {
            return null;
        }
        m.a(b2.e(), bVar);
        return this.f23794b.i(b2);
    }
}
