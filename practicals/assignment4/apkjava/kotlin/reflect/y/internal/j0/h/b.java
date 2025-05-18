package kotlin.reflect.y.internal.j0.h;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.a0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import okhttp3.HttpUrl;

/* compiled from: ClassifierNamePolicy.kt */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: classes3.dex */
    public static final class a implements b {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            if (hVar instanceof e1) {
                f name = ((e1) hVar).getName();
                m.e(name, "classifier.name");
                return cVar.v(name, false);
            }
            d m = kotlin.reflect.y.internal.j0.i.d.m(hVar);
            m.e(m, "getFqName(classifier)");
            return cVar.u(m);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* renamed from: kotlin.f0.y.e.j0.h.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0372b implements b {
        public static final C0372b a = new C0372b();

        private C0372b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.h] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.m, kotlin.reflect.jvm.internal.impl.descriptors.i0] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            List F;
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            if (hVar instanceof e1) {
                f name = ((e1) hVar).getName();
                m.e(name, "classifier.name");
                return cVar.v(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(hVar.getName());
                hVar = hVar.b();
            } while (hVar instanceof e);
            F = a0.F(arrayList);
            return n.c(F);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: classes3.dex */
    public static final class c implements b {
        public static final c a = new c();

        private c() {
        }

        private final String b(h hVar) {
            f name = hVar.getName();
            m.e(name, "descriptor.name");
            String b2 = n.b(name);
            if (hVar instanceof e1) {
                return b2;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.m b3 = hVar.b();
            m.e(b3, "descriptor.containingDeclaration");
            String c2 = c(b3);
            if (c2 == null || m.a(c2, HttpUrl.FRAGMENT_ENCODE_SET)) {
                return b2;
            }
            return c2 + '.' + b2;
        }

        private final String c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar instanceof e) {
                return b((h) mVar);
            }
            if (!(mVar instanceof k0)) {
                return null;
            }
            d j2 = ((k0) mVar).d().j();
            m.e(j2, "descriptor.fqName.toUnsafe()");
            return n.a(j2);
        }

        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            return b(hVar);
        }
    }

    String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar);
}
