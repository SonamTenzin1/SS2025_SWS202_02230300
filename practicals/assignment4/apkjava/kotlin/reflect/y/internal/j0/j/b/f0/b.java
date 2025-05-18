package kotlin.reflect.y.internal.j0.j.b.f0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.c;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.c.b.c;
import kotlin.reflect.y.internal.j0.j.b.d;
import kotlin.reflect.y.internal.j0.j.b.j;
import kotlin.reflect.y.internal.j0.j.b.l;
import kotlin.reflect.y.internal.j0.j.b.o;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.j.b.s;
import kotlin.reflect.y.internal.j0.j.b.v;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: BuiltInsLoaderImpl.kt */
/* loaded from: classes3.dex */
public final class b implements kotlin.reflect.y.internal.j0.b.a {

    /* renamed from: b, reason: collision with root package name */
    private final d f24489b = new d();

    /* compiled from: BuiltInsLoaderImpl.kt */
    /* loaded from: classes3.dex */
    /* synthetic */ class a extends i implements Function1<String, InputStream> {
        a(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(d.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String str) {
            m.f(str, "p0");
            return ((d) this.receiver).a(str);
        }
    }

    @Override // kotlin.reflect.y.internal.j0.b.a
    public l0 a(n nVar, kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.o1.b> iterable, c cVar, kotlin.reflect.jvm.internal.impl.descriptors.o1.a aVar, boolean z) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "builtInsModule");
        m.f(iterable, "classDescriptorFactories");
        m.f(cVar, "platformDependentDeclarationFilter");
        m.f(aVar, "additionalClassPartsProvider");
        return b(nVar, g0Var, k.x, iterable, cVar, aVar, z, new a(this.f24489b));
    }

    public final l0 b(n nVar, kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, Set<kotlin.reflect.y.internal.j0.f.c> set, Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.o1.b> iterable, c cVar, kotlin.reflect.jvm.internal.impl.descriptors.o1.a aVar, boolean z, Function1<? super String, ? extends InputStream> function1) {
        int u;
        List j2;
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        m.f(set, "packageFqNames");
        m.f(iterable, "classDescriptorFactories");
        m.f(cVar, "platformDependentDeclarationFilter");
        m.f(aVar, "additionalClassPartsProvider");
        m.f(function1, "loadResource");
        u = v.u(set, 10);
        ArrayList arrayList = new ArrayList(u);
        for (kotlin.reflect.y.internal.j0.f.c cVar2 : set) {
            String n = kotlin.reflect.y.internal.j0.j.b.f0.a.n.n(cVar2);
            InputStream invoke = function1.invoke(n);
            if (invoke != null) {
                arrayList.add(c.s.a(cVar2, nVar, g0Var, invoke, z));
            } else {
                throw new IllegalStateException("Resource not found in classpath: " + n);
            }
        }
        m0 m0Var = new m0(arrayList);
        j0 j0Var = new j0(nVar, g0Var);
        l.a aVar2 = l.a.a;
        o oVar = new o(m0Var);
        kotlin.reflect.y.internal.j0.j.b.f0.a aVar3 = kotlin.reflect.y.internal.j0.j.b.f0.a.n;
        d dVar = new d(g0Var, j0Var, aVar3);
        v.a aVar4 = v.a.a;
        r rVar = r.a;
        m.e(rVar, "DO_NOTHING");
        c.a aVar5 = c.a.a;
        s.a aVar6 = s.a.a;
        j a2 = j.a.a();
        f e2 = aVar3.e();
        j2 = u.j();
        kotlin.reflect.y.internal.j0.j.b.k kVar = new kotlin.reflect.y.internal.j0.j.b.k(nVar, g0Var, aVar2, oVar, dVar, m0Var, aVar4, rVar, aVar5, aVar6, iterable, j0Var, a2, aVar, cVar, e2, null, new kotlin.reflect.y.internal.j0.i.v.b(nVar, j2), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).M0(kVar);
        }
        return m0Var;
    }
}
