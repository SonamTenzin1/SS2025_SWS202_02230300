package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final e a(Annotation[] annotationArr, kotlin.reflect.y.internal.j0.f.c cVar) {
        Annotation annotation;
        kotlin.jvm.internal.m.f(annotationArr, "<this>");
        kotlin.jvm.internal.m.f(cVar, "fqName");
        int length = annotationArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i2];
            if (kotlin.jvm.internal.m.a(d.a(kotlin.jvm.a.b(kotlin.jvm.a.a(annotation))).b(), cVar)) {
                break;
            }
            i2++;
        }
        if (annotation != null) {
            return new e(annotation);
        }
        return null;
    }

    public static final List<e> b(Annotation[] annotationArr) {
        kotlin.jvm.internal.m.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new e(annotation));
        }
        return arrayList;
    }
}
