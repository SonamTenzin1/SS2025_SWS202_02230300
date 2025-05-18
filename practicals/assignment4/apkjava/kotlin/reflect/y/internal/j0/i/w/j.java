package kotlin.reflect.y.internal.j0.i.w;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public final class j {
    public static final Set<f> a(Iterable<? extends h> iterable) {
        m.f(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends h> it = iterable.iterator();
        while (it.hasNext()) {
            Set<f> e2 = it.next().e();
            if (e2 == null) {
                return null;
            }
            z.z(hashSet, e2);
        }
        return hashSet;
    }
}
