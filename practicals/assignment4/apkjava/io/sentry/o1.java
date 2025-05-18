package io.sentry;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HostnameCache.java */
/* loaded from: classes2.dex */
public final class o1 {
    private static final long a = TimeUnit.HOURS.toMillis(5);

    /* renamed from: b, reason: collision with root package name */
    private static final long f22514b = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: c, reason: collision with root package name */
    private static o1 f22515c;

    /* renamed from: d, reason: collision with root package name */
    private final long f22516d;

    /* renamed from: e, reason: collision with root package name */
    private volatile String f22517e;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f22518f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f22519g;

    /* renamed from: h, reason: collision with root package name */
    private final Callable<InetAddress> f22520h;

    /* renamed from: i, reason: collision with root package name */
    private final ExecutorService f22521i;

    /* compiled from: HostnameCache.java */
    /* loaded from: classes2.dex */
    private static final class b implements ThreadFactory {

        /* renamed from: f, reason: collision with root package name */
        private int f22522f;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            int i2 = this.f22522f;
            this.f22522f = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private o1() {
        this(a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o1 c() {
        if (f22515c == null) {
            f22515c = new o1();
        }
        return f22515c;
    }

    private void d() {
        this.f22518f = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }

    private /* synthetic */ Void f() throws Exception {
        try {
            this.f22517e = this.f22520h.call().getCanonicalHostName();
            this.f22518f = System.currentTimeMillis() + this.f22516d;
            this.f22519g.set(false);
            return null;
        } catch (Throwable th) {
            this.f22519g.set(false);
            throw th;
        }
    }

    private void h() {
        try {
            this.f22521i.submit(new Callable() { // from class: io.sentry.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    o1.this.g();
                    return null;
                }
            }).get(f22514b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            d();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f22521i.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        if (this.f22518f < System.currentTimeMillis() && this.f22519g.compareAndSet(false, true)) {
            h();
        }
        return this.f22517e;
    }

    public /* synthetic */ Void g() {
        f();
        return null;
    }

    o1(long j2) {
        this(j2, new Callable() { // from class: io.sentry.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                InetAddress localHost;
                localHost = InetAddress.getLocalHost();
                return localHost;
            }
        });
    }

    o1(long j2, Callable<InetAddress> callable) {
        this.f22519g = new AtomicBoolean(false);
        this.f22521i = Executors.newSingleThreadExecutor(new b());
        this.f22516d = j2;
        this.f22520h = (Callable) io.sentry.util.q.c(callable, "getLocalhost is required");
        h();
    }
}
