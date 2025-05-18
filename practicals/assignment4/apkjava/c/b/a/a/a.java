package c.b.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {
    private static volatile a a;

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f2842b = new ExecutorC0063a();

    /* renamed from: c, reason: collision with root package name */
    private static final Executor f2843c = new b();

    /* renamed from: d, reason: collision with root package name */
    private c f2844d;

    /* renamed from: e, reason: collision with root package name */
    private c f2845e;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: c.b.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0063a implements Executor {
        ExecutorC0063a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().c(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* loaded from: classes.dex */
    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    private a() {
        c.b.a.a.b bVar = new c.b.a.a.b();
        this.f2845e = bVar;
        this.f2844d = bVar;
    }

    public static Executor d() {
        return f2843c;
    }

    public static a e() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    @Override // c.b.a.a.c
    public void a(Runnable runnable) {
        this.f2844d.a(runnable);
    }

    @Override // c.b.a.a.c
    public boolean b() {
        return this.f2844d.b();
    }

    @Override // c.b.a.a.c
    public void c(Runnable runnable) {
        this.f2844d.c(runnable);
    }
}
