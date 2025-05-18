package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class y {
    private final b a;

    /* renamed from: b, reason: collision with root package name */
    private final z f1784b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: b, reason: collision with root package name */
        private static a f1785b;

        /* renamed from: c, reason: collision with root package name */
        private Application f1786c;

        public a(Application application) {
            this.f1786c = application;
        }

        public static a c(Application application) {
            if (f1785b == null) {
                f1785b = new a(application);
            }
            return f1785b;
        }

        @Override // androidx.lifecycle.y.d, androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            if (androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.f1786c);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                }
            }
            return (T) super.a(cls);
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        <T extends x> T a(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static abstract class c extends e implements b {
        public <T extends x> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends x> T c(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class d implements b {
        private static d a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static d b() {
            if (a == null) {
                a = new d();
            }
            return a;
        }

        @Override // androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class e {
        e() {
        }

        void b(x xVar) {
        }
    }

    public y(z zVar, b bVar) {
        this.a = bVar;
        this.f1784b = zVar;
    }

    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends x> T b(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f1784b.b(str);
        if (cls.isInstance(t2)) {
            Object obj = this.a;
            if (obj instanceof e) {
                ((e) obj).b(t2);
            }
            return t2;
        }
        b bVar = this.a;
        if (bVar instanceof c) {
            t = (T) ((c) bVar).c(str, cls);
        } else {
            t = (T) bVar.a(cls);
        }
        this.f1784b.d(str, t);
        return t;
    }
}
