package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: classes2.dex */
public final class m0 implements o0 {
    private final Collection<k0> a;

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<k0, kotlin.reflect.y.internal.j0.f.c> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f25162f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.c invoke(k0 k0Var) {
            kotlin.jvm.internal.m.f(k0Var, "it");
            return k0Var.d();
        }
    }

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.c, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.c f25163f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.y.internal.j0.f.c cVar) {
            super(1);
            this.f25163f = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            kotlin.jvm.internal.m.f(cVar, "it");
            return Boolean.valueOf(!cVar.d() && kotlin.jvm.internal.m.a(cVar.e(), this.f25163f));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(Collection<? extends k0> collection) {
        kotlin.jvm.internal.m.f(collection, "packageFragments");
        this.a = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public List<k0> a(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        Collection<k0> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.m.a(((k0) obj).d(), cVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public void b(kotlin.reflect.y.internal.j0.f.c cVar, Collection<k0> collection) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(collection, "packageFragments");
        for (Object obj : this.a) {
            if (kotlin.jvm.internal.m.a(((k0) obj).d(), cVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public boolean c(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        Collection<k0> collection = this.a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(((k0) it.next()).d(), cVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public Collection<kotlin.reflect.y.internal.j0.f.c> p(kotlin.reflect.y.internal.j0.f.c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        Sequence J;
        Sequence u;
        Sequence l;
        List A;
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        J = kotlin.collections.c0.J(this.a);
        u = kotlin.sequences.n.u(J, a.f25162f);
        l = kotlin.sequences.n.l(u, new b(cVar));
        A = kotlin.sequences.n.A(l);
        return A;
    }
}
