package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.b.q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectKotlinClass.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final kotlin.reflect.y.internal.j0.i.r.f a(Class<?> cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
            kotlin.jvm.internal.m.e(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (kotlin.jvm.internal.m.a(cls, Void.TYPE)) {
                kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(k.a.f23205f.l());
                kotlin.jvm.internal.m.e(m, "topLevel(StandardNames.FqNames.unit.toSafe())");
                return new kotlin.reflect.y.internal.j0.i.r.f(m, i2);
            }
            kotlin.reflect.y.internal.j0.b.i x = kotlin.reflect.y.internal.j0.i.u.e.k(cls.getName()).x();
            kotlin.jvm.internal.m.e(x, "get(currentClass.name).primitiveType");
            if (i2 > 0) {
                kotlin.reflect.y.internal.j0.f.b m2 = kotlin.reflect.y.internal.j0.f.b.m(x.k());
                kotlin.jvm.internal.m.e(m2, "topLevel(primitiveType.arrayTypeFqName)");
                return new kotlin.reflect.y.internal.j0.i.r.f(m2, i2 - 1);
            }
            kotlin.reflect.y.internal.j0.f.b m3 = kotlin.reflect.y.internal.j0.f.b.m(x.u());
            kotlin.jvm.internal.m.e(m3, "topLevel(primitiveType.typeFqName)");
            return new kotlin.reflect.y.internal.j0.i.r.f(m3, i2);
        }
        kotlin.reflect.y.internal.j0.f.b a2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(cls);
        kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
        kotlin.reflect.y.internal.j0.f.c b2 = a2.b();
        kotlin.jvm.internal.m.e(b2, "javaClassId.asSingleFqName()");
        kotlin.reflect.y.internal.j0.f.b m4 = cVar.m(b2);
        if (m4 != null) {
            a2 = m4;
        }
        return new kotlin.reflect.y.internal.j0.i.r.f(a2, i2);
    }

    private final void c(Class<?> cls, q.d dVar) {
        Constructor<?>[] constructorArr;
        int i2;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        kotlin.jvm.internal.m.e(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i3 = 0;
        while (i3 < length) {
            Constructor<?> constructor = declaredConstructors[i3];
            kotlin.reflect.y.internal.j0.f.f fVar = kotlin.reflect.y.internal.j0.f.h.f24223i;
            m mVar = m.a;
            kotlin.jvm.internal.m.e(constructor, "constructor");
            q.e b2 = dVar.b(fVar, mVar.a(constructor));
            if (b2 == null) {
                constructorArr = declaredConstructors;
                i2 = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "constructor.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(b2, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                kotlin.jvm.internal.m.e(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i4 = 0; i4 < length3; i4++) {
                        Annotation[] annotationArr = parameterAnnotations[i4];
                        kotlin.jvm.internal.m.e(annotationArr, "annotations");
                        int length4 = annotationArr.length;
                        int i5 = 0;
                        while (i5 < length4) {
                            Annotation annotation2 = annotationArr[i5];
                            Class<?> b3 = kotlin.jvm.a.b(kotlin.jvm.a.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i6 = length;
                            kotlin.reflect.y.internal.j0.f.b a2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(b3);
                            int i7 = length2;
                            kotlin.jvm.internal.m.e(annotation2, "annotation");
                            q.a c2 = b2.c(i4 + length2, a2, new b(annotation2));
                            if (c2 != null) {
                                a.h(c2, annotation2, b3);
                            }
                            i5++;
                            declaredConstructors = constructorArr2;
                            length = i6;
                            length2 = i7;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                b2.a();
            }
            i3++;
            declaredConstructors = constructorArr;
            length = i2;
        }
    }

    private final void d(Class<?> cls, q.d dVar) {
        Field[] declaredFields = cls.getDeclaredFields();
        kotlin.jvm.internal.m.e(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(field.getName());
            kotlin.jvm.internal.m.e(x, "identifier(field.name)");
            m mVar = m.a;
            kotlin.jvm.internal.m.e(field, "field");
            q.c a2 = dVar.a(x, mVar.b(field), null);
            if (a2 != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "field.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(a2, annotation);
                }
                a2.a();
            }
        }
    }

    private final void e(Class<?> cls, q.d dVar) {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(method.getName());
            kotlin.jvm.internal.m.e(x, "identifier(method.name)");
            m mVar = m.a;
            kotlin.jvm.internal.m.e(method, "method");
            q.e b2 = dVar.b(x, mVar.c(method));
            if (b2 == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                kotlin.jvm.internal.m.e(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    kotlin.jvm.internal.m.e(annotation, "annotation");
                    f(b2, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                kotlin.jvm.internal.m.e(parameterAnnotations, "method.parameterAnnotations");
                int length2 = parameterAnnotations.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    kotlin.jvm.internal.m.e(annotationArr, "annotations");
                    int length3 = annotationArr.length;
                    int i4 = 0;
                    while (i4 < length3) {
                        Annotation annotation2 = annotationArr[i4];
                        Class<?> b3 = kotlin.jvm.a.b(kotlin.jvm.a.a(annotation2));
                        kotlin.reflect.y.internal.j0.f.b a2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(b3);
                        Method[] methodArr2 = declaredMethods;
                        kotlin.jvm.internal.m.e(annotation2, "annotation");
                        q.a c2 = b2.c(i3, a2, new b(annotation2));
                        if (c2 != null) {
                            a.h(c2, annotation2, b3);
                        }
                        i4++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                b2.a();
            }
            i2++;
            declaredMethods = methodArr;
        }
    }

    private final void f(q.c cVar, Annotation annotation) {
        Class<?> b2 = kotlin.jvm.a.b(kotlin.jvm.a.a(annotation));
        q.a b3 = cVar.b(kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(b2), new b(annotation));
        if (b3 != null) {
            a.h(b3, annotation, b2);
        }
    }

    private final void g(q.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!kotlin.jvm.internal.m.a(cls, Class.class)) {
            set = i.a;
            if (set.contains(cls)) {
                aVar.c(fVar, obj);
                return;
            }
            if (kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.g(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                kotlin.jvm.internal.m.e(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                kotlin.reflect.y.internal.j0.f.b a2 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(cls);
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(((Enum) obj).name());
                kotlin.jvm.internal.m.e(x, "identifier((value as Enum<*>).name)");
                aVar.d(fVar, a2, x);
                return;
            }
            if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                kotlin.jvm.internal.m.e(interfaces, "clazz.interfaces");
                Class<?> cls2 = (Class) kotlin.collections.j.N(interfaces);
                kotlin.jvm.internal.m.e(cls2, "annotationClass");
                q.a e2 = aVar.e(fVar, kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(cls2));
                if (e2 == null) {
                    return;
                }
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Annotation");
                h(e2, (Annotation) obj, cls2);
                return;
            }
            if (cls.isArray()) {
                q.b f2 = aVar.f(fVar);
                if (f2 == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i2 = 0;
                if (componentType.isEnum()) {
                    kotlin.jvm.internal.m.e(componentType, "componentType");
                    kotlin.reflect.y.internal.j0.f.b a3 = kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(componentType);
                    kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i2 < length) {
                        Object obj2 = objArr[i2];
                        kotlin.jvm.internal.m.d(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        kotlin.reflect.y.internal.j0.f.f x2 = kotlin.reflect.y.internal.j0.f.f.x(((Enum) obj2).name());
                        kotlin.jvm.internal.m.e(x2, "identifier((element as Enum<*>).name)");
                        f2.c(a3, x2);
                        i2++;
                    }
                } else if (kotlin.jvm.internal.m.a(componentType, Class.class)) {
                    kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i2 < length2) {
                        Object obj3 = objArr2[i2];
                        kotlin.jvm.internal.m.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        f2.e(a((Class) obj3));
                        i2++;
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i2 < length3) {
                        Object obj4 = objArr3[i2];
                        kotlin.jvm.internal.m.e(componentType, "componentType");
                        q.a d2 = f2.d(kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(componentType));
                        if (d2 != null) {
                            kotlin.jvm.internal.m.d(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            h(d2, (Annotation) obj4, componentType);
                        }
                        i2++;
                    }
                } else {
                    kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i2 < length4) {
                        f2.b(objArr4[i2]);
                        i2++;
                    }
                }
                f2.a();
                return;
            }
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type java.lang.Class<*>");
        aVar.b(fVar, a((Class) obj));
    }

    private final void h(q.a aVar, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                kotlin.jvm.internal.m.c(invoke);
                kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(method.getName());
                kotlin.jvm.internal.m.e(x, "identifier(method.name)");
                g(aVar, x, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void b(Class<?> cls, q.c cVar) {
        kotlin.jvm.internal.m.f(cls, "klass");
        kotlin.jvm.internal.m.f(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        kotlin.jvm.internal.m.e(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            kotlin.jvm.internal.m.e(annotation, "annotation");
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void i(Class<?> cls, q.d dVar) {
        kotlin.jvm.internal.m.f(cls, "klass");
        kotlin.jvm.internal.m.f(dVar, "memberVisitor");
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
