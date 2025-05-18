package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.reflect.y.internal.j0.d.b.c0.a;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;

/* compiled from: PackagePartScopeCache.kt */
/* loaded from: classes2.dex */
public final class a {
    private final kotlin.reflect.y.internal.j0.d.b.g a;

    /* renamed from: b, reason: collision with root package name */
    private final g f25313b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.i.w.h> f25314c;

    public a(kotlin.reflect.y.internal.j0.d.b.g gVar, g gVar2) {
        kotlin.jvm.internal.m.f(gVar, "resolver");
        kotlin.jvm.internal.m.f(gVar2, "kotlinClassFinder");
        this.a = gVar;
        this.f25313b = gVar2;
        this.f25314c = new ConcurrentHashMap<>();
    }

    public final kotlin.reflect.y.internal.j0.i.w.h a(f fVar) {
        Collection e2;
        List E0;
        kotlin.jvm.internal.m.f(fVar, "fileClass");
        ConcurrentHashMap<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.i.w.h> concurrentHashMap = this.f25314c;
        kotlin.reflect.y.internal.j0.f.b e3 = fVar.e();
        kotlin.reflect.y.internal.j0.i.w.h hVar = concurrentHashMap.get(e3);
        if (hVar == null) {
            kotlin.reflect.y.internal.j0.f.c h2 = fVar.e().h();
            kotlin.jvm.internal.m.e(h2, "fileClass.classId.packageFqName");
            if (fVar.a().c() == a.EnumC0345a.MULTIFILE_CLASS) {
                List<String> f2 = fVar.a().f();
                e2 = new ArrayList();
                Iterator<T> it = f2.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(kotlin.reflect.y.internal.j0.i.u.d.d((String) it.next()).e());
                    kotlin.jvm.internal.m.e(m, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    q b2 = p.b(this.f25313b, m);
                    if (b2 != null) {
                        e2.add(b2);
                    }
                }
            } else {
                e2 = t.e(fVar);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.p1.m mVar = new kotlin.reflect.jvm.internal.impl.descriptors.p1.m(this.a.d().p(), h2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = e2.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.y.internal.j0.i.w.h b3 = this.a.b(mVar, (q) it2.next());
                if (b3 != null) {
                    arrayList.add(b3);
                }
            }
            E0 = c0.E0(arrayList);
            kotlin.reflect.y.internal.j0.i.w.h a = kotlin.reflect.y.internal.j0.i.w.b.f24397b.a("package " + h2 + " (" + fVar + ')', E0);
            kotlin.reflect.y.internal.j0.i.w.h putIfAbsent = concurrentHashMap.putIfAbsent(e3, a);
            hVar = putIfAbsent == null ? a : putIfAbsent;
        }
        kotlin.jvm.internal.m.e(hVar, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return hVar;
    }
}
