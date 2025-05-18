package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Method;

/* compiled from: ReflectJavaRecordComponent.kt */
/* loaded from: classes2.dex */
final class a {
    public static final a a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static C0412a f25323b;

    /* compiled from: ReflectJavaRecordComponent.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.r1.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0412a {
        private final Method a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f25324b;

        public C0412a(Method method, Method method2) {
            this.a = method;
            this.f25324b = method2;
        }

        public final Method a() {
            return this.f25324b;
        }

        public final Method b() {
            return this.a;
        }
    }

    private a() {
    }

    private final C0412a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0412a(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C0412a(null, null);
        }
    }

    private final C0412a b(Object obj) {
        C0412a c0412a = f25323b;
        if (c0412a != null) {
            return c0412a;
        }
        C0412a a2 = a(obj);
        f25323b = a2;
        return a2;
    }

    public final Method c(Object obj) {
        kotlin.jvm.internal.m.f(obj, "recordComponent");
        Method a2 = b(obj).a();
        if (a2 == null) {
            return null;
        }
        Object invoke = a2.invoke(obj, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) invoke;
    }

    public final Class<?> d(Object obj) {
        kotlin.jvm.internal.m.f(obj, "recordComponent");
        Method b2 = b(obj).b();
        if (b2 == null) {
            return null;
        }
        Object invoke = b2.invoke(obj, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) invoke;
    }
}
