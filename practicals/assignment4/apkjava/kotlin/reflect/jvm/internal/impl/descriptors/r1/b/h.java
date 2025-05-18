package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: classes2.dex */
public interface h extends kotlin.reflect.y.internal.j0.d.a.n0.d {

    /* compiled from: ReflectJavaAnnotationOwner.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static e a(h hVar, kotlin.reflect.y.internal.j0.f.c cVar) {
            Annotation[] declaredAnnotations;
            kotlin.jvm.internal.m.f(cVar, "fqName");
            AnnotatedElement w = hVar.w();
            if (w == null || (declaredAnnotations = w.getDeclaredAnnotations()) == null) {
                return null;
            }
            return i.a(declaredAnnotations, cVar);
        }

        public static List<e> b(h hVar) {
            List<e> j2;
            Annotation[] declaredAnnotations;
            List<e> b2;
            AnnotatedElement w = hVar.w();
            if (w != null && (declaredAnnotations = w.getDeclaredAnnotations()) != null && (b2 = i.b(declaredAnnotations)) != null) {
                return b2;
            }
            j2 = kotlin.collections.u.j();
            return j2;
        }

        public static boolean c(h hVar) {
            return false;
        }
    }

    AnnotatedElement w();
}
