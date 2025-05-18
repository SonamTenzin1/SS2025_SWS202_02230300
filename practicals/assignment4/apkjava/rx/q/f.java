package rx.q;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public class f {
    private static final f a = new f();

    /* renamed from: b, reason: collision with root package name */
    static final rx.q.b f26853b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicReference<rx.q.b> f26854c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference<d> f26855d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicReference<h> f26856e = new AtomicReference<>();

    /* renamed from: f, reason: collision with root package name */
    private final AtomicReference<rx.q.a> f26857f = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<g> f26858g = new AtomicReference<>();

    /* compiled from: RxJavaPlugins.java */
    /* loaded from: classes3.dex */
    static class a extends rx.q.b {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaPlugins.java */
    /* loaded from: classes3.dex */
    public class b extends rx.q.a {
        b() {
        }
    }

    f() {
    }

    @Deprecated
    public static f c() {
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        r2 = "rxjava.plugin." + r7.substring(0, r7.length() - 6).substring(14) + ".impl";
        r1 = r10.getProperty(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
    
        throw new java.lang.IllegalStateException("Implementing class declaration for " + r0 + " missing: " + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Object e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        break;
                    }
                }
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e3) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e3);
        } catch (ClassNotFoundException e4) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e4);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e5);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e6);
        }
    }

    static Properties h() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public rx.q.a a() {
        if (this.f26857f.get() == null) {
            Object e2 = e(rx.q.a.class, h());
            if (e2 == null) {
                this.f26857f.compareAndSet(null, new b());
            } else {
                this.f26857f.compareAndSet(null, (rx.q.a) e2);
            }
        }
        return this.f26857f.get();
    }

    public rx.q.b b() {
        if (this.f26854c.get() == null) {
            Object e2 = e(rx.q.b.class, h());
            if (e2 == null) {
                this.f26854c.compareAndSet(null, f26853b);
            } else {
                this.f26854c.compareAndSet(null, (rx.q.b) e2);
            }
        }
        return this.f26854c.get();
    }

    public d d() {
        if (this.f26855d.get() == null) {
            Object e2 = e(d.class, h());
            if (e2 == null) {
                this.f26855d.compareAndSet(null, e.a());
            } else {
                this.f26855d.compareAndSet(null, (d) e2);
            }
        }
        return this.f26855d.get();
    }

    public g f() {
        if (this.f26858g.get() == null) {
            Object e2 = e(g.class, h());
            if (e2 == null) {
                this.f26858g.compareAndSet(null, g.h());
            } else {
                this.f26858g.compareAndSet(null, (g) e2);
            }
        }
        return this.f26858g.get();
    }

    public h g() {
        if (this.f26856e.get() == null) {
            Object e2 = e(h.class, h());
            if (e2 == null) {
                this.f26856e.compareAndSet(null, i.f());
            } else {
                this.f26856e.compareAndSet(null, (h) e2);
            }
        }
        return this.f26856e.get();
    }
}
