package kotlin.reflect.y.internal.j0.b;

import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.i.t.a;

/* compiled from: CompanionObjectMappingUtils.kt */
/* loaded from: classes2.dex */
public final class d {
    public static final boolean a(c cVar, e eVar) {
        boolean K;
        m.f(cVar, "<this>");
        m.f(eVar, "classDescriptor");
        if (kotlin.reflect.y.internal.j0.i.d.x(eVar)) {
            Set<b> b2 = cVar.b();
            b g2 = a.g(eVar);
            K = c0.K(b2, g2 != null ? g2.g() : null);
            if (K) {
                return true;
            }
        }
        return false;
    }
}
