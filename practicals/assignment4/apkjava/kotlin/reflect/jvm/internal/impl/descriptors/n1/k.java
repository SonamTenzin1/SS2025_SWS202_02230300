package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
/* loaded from: classes2.dex */
public final class k implements g {

    /* renamed from: f, reason: collision with root package name */
    private final List<g> f25186f;

    /* compiled from: Annotations.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<g, c> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.c f25187f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.y.internal.j0.f.c cVar) {
            super(1);
            this.f25187f = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c invoke(g gVar) {
            kotlin.jvm.internal.m.f(gVar, "it");
            return gVar.l(this.f25187f);
        }
    }

    /* compiled from: Annotations.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<g, Sequence<? extends c>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f25188f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<c> invoke(g gVar) {
            Sequence<c> J;
            kotlin.jvm.internal.m.f(gVar, "it");
            J = c0.J(gVar);
            return J;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        kotlin.jvm.internal.m.f(list, "delegates");
        this.f25186f = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        Sequence J;
        kotlin.jvm.internal.m.f(cVar, "fqName");
        J = c0.J(this.f25186f);
        Iterator it = J.iterator();
        while (it.hasNext()) {
            if (((g) it.next()).R0(cVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        List<g> list = this.f25186f;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        Sequence J;
        Sequence p;
        J = c0.J(this.f25186f);
        p = kotlin.sequences.n.p(J, b.f25188f);
        return p.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.g
    public c l(kotlin.reflect.y.internal.j0.f.c cVar) {
        Sequence J;
        Sequence v;
        kotlin.jvm.internal.m.f(cVar, "fqName");
        J = c0.J(this.f25186f);
        v = kotlin.sequences.n.v(J, new a(cVar));
        return (c) kotlin.sequences.i.o(v);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(g... gVarArr) {
        this((List<? extends g>) r2);
        List Z;
        kotlin.jvm.internal.m.f(gVarArr, "delegates");
        Z = kotlin.collections.n.Z(gVarArr);
    }
}
