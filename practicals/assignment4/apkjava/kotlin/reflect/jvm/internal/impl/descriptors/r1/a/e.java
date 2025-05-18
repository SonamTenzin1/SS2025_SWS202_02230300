package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

/* compiled from: ReflectJavaClassFinder.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final Class<?> a(ClassLoader classLoader, String str) {
        kotlin.jvm.internal.m.f(classLoader, "<this>");
        kotlin.jvm.internal.m.f(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
