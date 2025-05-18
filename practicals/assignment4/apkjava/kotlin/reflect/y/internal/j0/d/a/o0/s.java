package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.x0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.l.m1;
import kotlin.reflect.y.internal.j0.l.w1.i;

/* compiled from: typeEnhancementUtils.kt */
/* loaded from: classes3.dex */
public final class s {
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
    
        if (r6 != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final e a(e eVar, Collection<e> collection, boolean z, boolean z2, boolean z3) {
        Set I0;
        h hVar;
        Set I02;
        boolean z4;
        boolean z5;
        Set I03;
        m.f(eVar, "<this>");
        m.f(collection, "superQualifiers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            h b2 = b((e) it.next());
            if (b2 != null) {
                arrayList.add(b2);
            }
        }
        I0 = c0.I0(arrayList);
        h e2 = e(I0, b(eVar), z);
        if (e2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                h d2 = ((e) it2.next()).d();
                if (d2 != null) {
                    arrayList2.add(d2);
                }
            }
            I03 = c0.I0(arrayList2);
            hVar = e(I03, eVar.d(), z);
        } else {
            hVar = e2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            f c2 = ((e) it3.next()).c();
            if (c2 != null) {
                arrayList3.add(c2);
            }
        }
        I02 = c0.I0(arrayList3);
        f fVar = (f) d(I02, f.MUTABLE, f.READ_ONLY, eVar.c(), z);
        h hVar2 = null;
        if (hVar != null) {
            if (!(z3 || (z2 && hVar == h.NULLABLE))) {
                hVar2 = hVar;
            }
        }
        if (hVar2 == h.NOT_NULL) {
            if (!eVar.b()) {
                if (!collection.isEmpty()) {
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        if (((e) it4.next()).b()) {
                            z5 = true;
                            break;
                        }
                    }
                }
                z5 = false;
            }
            z4 = true;
            return new e(hVar2, fVar, z4, hVar2 == null && e2 != hVar);
        }
        z4 = false;
        return new e(hVar2, fVar, z4, hVar2 == null && e2 != hVar);
    }

    private static final h b(e eVar) {
        if (eVar.e()) {
            return null;
        }
        return eVar.d();
    }

    public static final boolean c(m1 m1Var, i iVar) {
        m.f(m1Var, "<this>");
        m.f(iVar, "type");
        c cVar = a0.u;
        m.e(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return m1Var.l0(iVar, cVar);
    }

    private static final <T> T d(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set m;
        Set<? extends T> I0;
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (m.a(t4, t) && m.a(t3, t2)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 != null) {
            m = x0.m(set, t3);
            I0 = c0.I0(m);
            if (I0 != null) {
                set = I0;
            }
        }
        return (T) kotlin.collections.s.t0(set);
    }

    private static final h e(Set<? extends h> set, h hVar, boolean z) {
        h hVar2 = h.FORCE_FLEXIBILITY;
        return hVar == hVar2 ? hVar2 : (h) d(set, h.NOT_NULL, h.NULLABLE, hVar, z);
    }
}
