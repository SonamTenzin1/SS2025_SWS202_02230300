package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: classes2.dex */
final class c {
    public static final c a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static a f25332b;

    /* compiled from: ReflectJavaMember.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final Method a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f25333b;

        public a(Method method, Method method2) {
            this.a = method;
            this.f25333b = method2;
        }

        public final Method a() {
            return this.f25333b;
        }

        public final Method b() {
            return this.a;
        }
    }

    private c() {
    }

    public final a a(Member member) {
        kotlin.jvm.internal.m.f(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), d.e(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member member) {
        Method a2;
        kotlin.jvm.internal.m.f(member, "member");
        a aVar = f25332b;
        if (aVar == null) {
            synchronized (this) {
                c cVar = a;
                a aVar2 = f25332b;
                if (aVar2 == null) {
                    aVar = cVar.a(member);
                    f25332b = aVar;
                } else {
                    aVar = aVar2;
                }
            }
        }
        Method b2 = aVar.b();
        if (b2 == null || (a2 = aVar.a()) == null) {
            return null;
        }
        Object invoke = b2.invoke(member, new Object[0]);
        kotlin.jvm.internal.m.d(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a2.invoke(obj, new Object[0]);
            kotlin.jvm.internal.m.d(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
