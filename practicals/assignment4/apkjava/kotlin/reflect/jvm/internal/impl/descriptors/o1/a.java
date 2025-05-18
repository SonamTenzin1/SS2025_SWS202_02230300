package kotlin.reflect.jvm.internal.impl.descriptors.o1;

import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: AdditionalClassPartsProvider.kt */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.o1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0408a implements a {
        public static final C0408a a = new C0408a();

        private C0408a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            List j2;
            m.f(eVar, "classDescriptor");
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<y0> b(f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            List j2;
            m.f(fVar, "name");
            m.f(eVar, "classDescriptor");
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<e0> d(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            List j2;
            m.f(eVar, "classDescriptor");
            j2 = u.j();
            return j2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<f> e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            List j2;
            m.f(eVar, "classDescriptor");
            j2 = u.j();
            return j2;
        }
    }

    Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<y0> b(f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<e0> d(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<f> e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);
}
