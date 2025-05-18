package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class i {
    private static final c.e.g<ClassLoader, c.e.g<String, Class<?>>> a = new c.e.g<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        c.e.g<ClassLoader, c.e.g<String, Class<?>>> gVar = a;
        c.e.g<String, Class<?>> gVar2 = gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new c.e.g<>();
            gVar.put(classLoader, gVar2);
        }
        Class<?> cls = gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        } catch (ClassNotFoundException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }
}
