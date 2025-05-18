package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class c implements g {

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f23609f;

    public c(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqNameToMatch");
        this.f23609f = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b l(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        if (m.a(cVar, this.f23609f)) {
            return b.a;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.n1.c> iterator() {
        List j2;
        j2 = u.j();
        return j2.iterator();
    }
}
