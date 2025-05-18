package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* compiled from: Annotations.kt */
/* loaded from: classes2.dex */
public final class l implements g {

    /* renamed from: f, reason: collision with root package name */
    private final g f25189f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f25190g;

    /* renamed from: h, reason: collision with root package name */
    private final Function1<kotlin.reflect.y.internal.j0.f.c, Boolean> f25191h;

    /* JADX WARN: Multi-variable type inference failed */
    public l(g gVar, boolean z, Function1<? super kotlin.reflect.y.internal.j0.f.c, Boolean> function1) {
        kotlin.jvm.internal.m.f(gVar, "delegate");
        kotlin.jvm.internal.m.f(function1, "fqNameFilter");
        this.f25189f = gVar;
        this.f25190g = z;
        this.f25191h = function1;
    }

    private final boolean c(c cVar) {
        kotlin.reflect.y.internal.j0.f.c d2 = cVar.d();
        return d2 != null && this.f25191h.invoke(d2).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        if (this.f25191h.invoke(cVar).booleanValue()) {
            return this.f25189f.R0(cVar);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        boolean z;
        g gVar = this.f25189f;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                if (c(it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return this.f25190g ? !z : z;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.f25189f;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (c(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public c l(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        if (this.f25191h.invoke(cVar).booleanValue()) {
            return this.f25189f.l(cVar);
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(g gVar, Function1<? super kotlin.reflect.y.internal.j0.f.c, Boolean> function1) {
        this(gVar, false, function1);
        kotlin.jvm.internal.m.f(gVar, "delegate");
        kotlin.jvm.internal.m.f(function1, "fqNameFilter");
    }
}
