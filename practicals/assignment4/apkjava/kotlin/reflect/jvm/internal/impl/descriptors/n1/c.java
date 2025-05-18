package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: AnnotationDescriptor.kt */
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: AnnotationDescriptor.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static kotlin.reflect.y.internal.j0.f.c a(c cVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.e e2 = kotlin.reflect.y.internal.j0.i.t.a.e(cVar);
            if (e2 == null) {
                return null;
            }
            if (kotlin.reflect.y.internal.j0.l.u1.k.m(e2)) {
                e2 = null;
            }
            if (e2 != null) {
                return kotlin.reflect.y.internal.j0.i.t.a.d(e2);
            }
            return null;
        }
    }

    Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> a();

    kotlin.reflect.y.internal.j0.f.c d();

    e0 getType();

    z0 t();
}
