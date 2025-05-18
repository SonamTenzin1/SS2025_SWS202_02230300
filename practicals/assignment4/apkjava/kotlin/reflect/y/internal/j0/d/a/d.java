package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.b;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.t.a;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: classes2.dex */
public final class d extends a<c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(w wVar) {
        super(wVar);
        m.f(wVar, "javaTypeEnhancementState");
    }

    private final List<String> y(g<?> gVar) {
        List<String> j2;
        List<String> e2;
        if (gVar instanceof b) {
            List<? extends g<?>> b2 = ((b) gVar).b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = b2.iterator();
            while (it.hasNext()) {
                z.z(arrayList, y((g) it.next()));
            }
            return arrayList;
        }
        if (gVar instanceof j) {
            e2 = t.e(((j) gVar).c().u());
            return e2;
        }
        j2 = u.j();
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Iterable<String> b(c cVar, boolean z) {
        List<String> y;
        m.f(cVar, "<this>");
        Map<f, g<?>> a = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<f, g<?>> entry : a.entrySet()) {
            f key = entry.getKey();
            g<?> value = entry.getValue();
            if (z && !m.a(key, a0.f23325c)) {
                y = u.j();
            } else {
                y = y(value);
            }
            z.z(arrayList, y);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.f.c i(c cVar) {
        m.f(cVar, "<this>");
        return cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Object j(c cVar) {
        m.f(cVar, "<this>");
        e e2 = a.e(cVar);
        m.c(e2);
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable<c> k(c cVar) {
        List j2;
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations;
        m.f(cVar, "<this>");
        e e2 = a.e(cVar);
        if (e2 != null && (annotations = e2.getAnnotations()) != null) {
            return annotations;
        }
        j2 = u.j();
        return j2;
    }
}
