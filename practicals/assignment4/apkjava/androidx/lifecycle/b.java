package androidx.lifecycle;

import androidx.lifecycle.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
final class b {
    static b a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, a> f1745b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1746c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class a {
        final Map<g.b, List<C0038b>> a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<C0038b, g.b> f1747b;

        a(Map<C0038b, g.b> map) {
            this.f1747b = map;
            for (Map.Entry<C0038b, g.b> entry : map.entrySet()) {
                g.b value = entry.getValue();
                List<C0038b> list = this.a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<C0038b> list, k kVar, g.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(kVar, bVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(k kVar, g.b bVar, Object obj) {
            b(this.a.get(bVar), kVar, bVar, obj);
            b(this.a.get(g.b.ON_ANY), kVar, bVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0038b {
        final int a;

        /* renamed from: b, reason: collision with root package name */
        final Method f1748b;

        C0038b(int i2, Method method) {
            this.a = i2;
            this.f1748b = method;
            method.setAccessible(true);
        }

        void a(k kVar, g.b bVar, Object obj) {
            try {
                int i2 = this.a;
                if (i2 == 0) {
                    this.f1748b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f1748b.invoke(obj, kVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f1748b.invoke(obj, kVar, bVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0038b)) {
                return false;
            }
            C0038b c0038b = (C0038b) obj;
            return this.a == c0038b.a && this.f1748b.getName().equals(c0038b.f1748b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.f1748b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i2;
        a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.f1747b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0038b, g.b> entry : c(cls2).f1747b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            s sVar = (s) method.getAnnotation(s.class);
            if (sVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(k.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                g.b value = sVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(g.b.class)) {
                        if (value != g.b.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new C0038b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f1745b.put(cls, aVar);
        this.f1746c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<C0038b, g.b> map, C0038b c0038b, g.b bVar, Class<?> cls) {
        g.b bVar2 = map.get(c0038b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0038b, bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0038b.f1748b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar2 + ", new value " + bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f1745b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f1746c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((s) method.getAnnotation(s.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f1746c.put(cls, Boolean.FALSE);
        return false;
    }
}
