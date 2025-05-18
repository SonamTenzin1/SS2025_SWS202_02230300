package com.airbnb.epoxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ControllerHelperLookup.java */
/* loaded from: classes.dex */
public class g {
    private static final Map<Class<?>, Constructor<?>> a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final NoOpControllerHelper f8432b = new NoOpControllerHelper();

    private static Constructor<?> a(Class<?> cls) {
        Constructor<?> a2;
        Map<Class<?>, Constructor<?>> map = a;
        Constructor<?> constructor = map.get(cls);
        if (constructor != null || map.containsKey(cls)) {
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            return null;
        }
        try {
            a2 = Class.forName(name + "_EpoxyHelper").getConstructor(cls);
        } catch (ClassNotFoundException unused) {
            a2 = a(cls.getSuperclass());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find Epoxy Helper constructor for " + name, e2);
        }
        a.put(cls, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f b(n nVar) {
        Constructor<?> a2 = a(nVar.getClass());
        if (a2 == null) {
            return f8432b;
        }
        try {
            return (f) a2.newInstance(nVar);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to invoke " + a2, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Unable to invoke " + a2, e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unable to get Epoxy helper class.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }
}
