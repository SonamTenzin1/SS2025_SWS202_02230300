package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.t;

/* compiled from: VisibilityUtil.kt */
/* loaded from: classes3.dex */
public final class p {
    public static final b a(Collection<? extends b> collection) {
        Integer d2;
        m.f(collection, "descriptors");
        collection.isEmpty();
        b bVar = null;
        for (b bVar2 : collection) {
            if (bVar == null || ((d2 = t.d(bVar.getVisibility(), bVar2.getVisibility())) != null && d2.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        m.c(bVar);
        return bVar;
    }
}
