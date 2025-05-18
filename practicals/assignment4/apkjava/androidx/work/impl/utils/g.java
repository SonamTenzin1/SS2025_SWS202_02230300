package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: SerialExecutor.java */
/* loaded from: classes.dex */
public class g implements Executor {

    /* renamed from: g, reason: collision with root package name */
    private final Executor f2571g;

    /* renamed from: i, reason: collision with root package name */
    private volatile Runnable f2573i;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<a> f2570f = new ArrayDeque<>();

    /* renamed from: h, reason: collision with root package name */
    private final Object f2572h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SerialExecutor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final g f2574f;

        /* renamed from: g, reason: collision with root package name */
        final Runnable f2575g;

        a(g gVar, Runnable runnable) {
            this.f2574f = gVar;
            this.f2575g = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f2575g.run();
            } finally {
                this.f2574f.b();
            }
        }
    }

    public g(Executor executor) {
        this.f2571g = executor;
    }

    public boolean a() {
        boolean z;
        synchronized (this.f2572h) {
            z = !this.f2570f.isEmpty();
        }
        return z;
    }

    void b() {
        synchronized (this.f2572h) {
            a poll = this.f2570f.poll();
            this.f2573i = poll;
            if (poll != null) {
                this.f2571g.execute(this.f2573i);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f2572h) {
            this.f2570f.add(new a(this, runnable));
            if (this.f2573i == null) {
                b();
            }
        }
    }
}
