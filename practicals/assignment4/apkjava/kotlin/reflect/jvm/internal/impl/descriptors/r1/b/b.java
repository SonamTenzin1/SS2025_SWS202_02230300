package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Method;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes2.dex */
final class b {
    public static final b a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static a f25325b;

    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final Method a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f25326b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f25327c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f25328d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.a = method;
            this.f25326b = method2;
            this.f25327c = method3;
            this.f25328d = method4;
        }

        public final Method a() {
            return this.f25326b;
        }

        public final Method b() {
            return this.f25328d;
        }

        public final Method c() {
            return this.f25327c;
        }

        public final Method d() {
            return this.a;
        }
    }

    private b() {
    }

    private final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    private final a b() {
        a aVar = f25325b;
        if (aVar != null) {
            return aVar;
        }
        a a2 = a();
        f25325b = a2;
        return a2;
    }

    public final Class<?>[] c(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        Method a2 = b().a();
        if (a2 == null) {
            return null;
        }
        Object invoke = a2.invoke(cls, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    public final Object[] d(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        Method b2 = b().b();
        if (b2 == null) {
            return null;
        }
        return (Object[]) b2.invoke(cls, new Object[0]);
    }

    public final Boolean e(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        Method c2 = b().c();
        if (c2 == null) {
            return null;
        }
        Object invoke = c2.invoke(cls, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    public final Boolean f(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "clazz");
        Method d2 = b().d();
        if (d2 == null) {
            return null;
        }
        Object invoke = d2.invoke(cls, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }
}
