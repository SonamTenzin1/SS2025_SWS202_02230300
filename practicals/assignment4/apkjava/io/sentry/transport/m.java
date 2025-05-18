package io.sentry.transport;

import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.a1;
import io.sentry.h4;
import io.sentry.n1;
import io.sentry.p3;
import io.sentry.s4;
import io.sentry.transport.m;
import io.sentry.util.m;
import io.sentry.w1;
import io.sentry.x4;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncHttpTransport.java */
/* loaded from: classes2.dex */
public final class m implements r {

    /* renamed from: f, reason: collision with root package name */
    private final x f22730f;

    /* renamed from: g, reason: collision with root package name */
    private final io.sentry.cache.r f22731g;

    /* renamed from: h, reason: collision with root package name */
    private final x4 f22732h;

    /* renamed from: i, reason: collision with root package name */
    private final y f22733i;

    /* renamed from: j, reason: collision with root package name */
    private final s f22734j;

    /* renamed from: k, reason: collision with root package name */
    private final p f22735k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncHttpTransport.java */
    /* loaded from: classes2.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: f, reason: collision with root package name */
        private int f22736f;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryAsyncConnection-");
            int i2 = this.f22736f;
            this.f22736f = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncHttpTransport.java */
    /* loaded from: classes2.dex */
    public final class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final h4 f22737f;

        /* renamed from: g, reason: collision with root package name */
        private final n1 f22738g;

        /* renamed from: h, reason: collision with root package name */
        private final io.sentry.cache.r f22739h;

        /* renamed from: i, reason: collision with root package name */
        private final a0 f22740i = a0.a();

        c(h4 h4Var, n1 n1Var, io.sentry.cache.r rVar) {
            this.f22737f = (h4) io.sentry.util.q.c(h4Var, "Envelope is required.");
            this.f22738g = n1Var;
            this.f22739h = (io.sentry.cache.r) io.sentry.util.q.c(rVar, "EnvelopeCache is required.");
        }

        private a0 c() {
            a0 a0Var = this.f22740i;
            this.f22737f.b().d(null);
            this.f22739h.Z(this.f22737f, this.f22738g);
            io.sentry.util.m.k(this.f22738g, io.sentry.hints.g.class, new m.a() { // from class: io.sentry.transport.c
                @Override // io.sentry.util.m.a
                public final void a(Object obj) {
                    m.c.this.e((io.sentry.hints.g) obj);
                }
            });
            if (m.this.f22734j.isConnected()) {
                final h4 c2 = m.this.f22732h.getClientReportRecorder().c(this.f22737f);
                try {
                    c2.b().d(a1.j(m.this.f22732h.getDateProvider().a().x()));
                    a0 h2 = m.this.f22735k.h(c2);
                    if (h2.d()) {
                        this.f22739h.p(this.f22737f);
                        return h2;
                    }
                    String str = "The transport failed to send the envelope with response code " + h2.c();
                    m.this.f22732h.getLogger().c(s4.ERROR, str, new Object[0]);
                    if (h2.c() >= 400 && h2.c() != 429) {
                        io.sentry.util.m.j(this.f22738g, io.sentry.hints.k.class, new m.c() { // from class: io.sentry.transport.b
                            @Override // io.sentry.util.m.c
                            public final void a(Object obj) {
                                m.c.this.g(c2, obj);
                            }
                        });
                    }
                    throw new IllegalStateException(str);
                } catch (IOException e2) {
                    io.sentry.util.m.l(this.f22738g, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.e
                        @Override // io.sentry.util.m.a
                        public final void a(Object obj) {
                            ((io.sentry.hints.k) obj).d(true);
                        }
                    }, new m.b() { // from class: io.sentry.transport.a
                        @Override // io.sentry.util.m.b
                        public final void a(Object obj, Class cls) {
                            m.c.this.j(c2, obj, cls);
                        }
                    });
                    throw new IllegalStateException("Sending the event failed.", e2);
                }
            }
            io.sentry.util.m.l(this.f22738g, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.f
                @Override // io.sentry.util.m.a
                public final void a(Object obj) {
                    ((io.sentry.hints.k) obj).d(true);
                }
            }, new m.b() { // from class: io.sentry.transport.d
                @Override // io.sentry.util.m.b
                public final void a(Object obj, Class cls) {
                    m.c.this.m(obj, cls);
                }
            });
            return a0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(io.sentry.hints.g gVar) {
            gVar.b();
            m.this.f22732h.getLogger().c(s4.DEBUG, "Disk flush envelope fired", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(h4 h4Var, Object obj) {
            m.this.f22732h.getClientReportRecorder().b(io.sentry.clientreport.e.NETWORK_ERROR, h4Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j(h4 h4Var, Object obj, Class cls) {
            io.sentry.util.p.a(cls, obj, m.this.f22732h.getLogger());
            m.this.f22732h.getClientReportRecorder().b(io.sentry.clientreport.e.NETWORK_ERROR, h4Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void m(Object obj, Class cls) {
            io.sentry.util.p.a(cls, obj, m.this.f22732h.getLogger());
            m.this.f22732h.getClientReportRecorder().b(io.sentry.clientreport.e.NETWORK_ERROR, this.f22737f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void o(a0 a0Var, io.sentry.hints.p pVar) {
            m.this.f22732h.getLogger().c(s4.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(a0Var.d()));
            pVar.c(a0Var.d());
        }

        @Override // java.lang.Runnable
        public void run() {
            final a0 a0Var = this.f22740i;
            try {
                a0Var = c();
                m.this.f22732h.getLogger().c(s4.DEBUG, "Envelope flushed", new Object[0]);
            } finally {
            }
        }
    }

    public m(x4 x4Var, y yVar, s sVar, p3 p3Var) {
        this(d(x4Var.getMaxQueueSize(), x4Var.getEnvelopeDiskCache(), x4Var.getLogger()), x4Var, yVar, sVar, new p(x4Var, p3Var, yVar));
    }

    private static x d(int i2, final io.sentry.cache.r rVar, final w1 w1Var) {
        return new x(1, i2, new b(), new RejectedExecutionHandler() { // from class: io.sentry.transport.h
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                m.e(io.sentry.cache.r.this, w1Var, runnable, threadPoolExecutor);
            }
        }, w1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(io.sentry.cache.r rVar, w1 w1Var, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            if (!io.sentry.util.m.d(cVar.f22738g, io.sentry.hints.f.class)) {
                rVar.Z(cVar.f22737f, cVar.f22738g);
            }
            k(cVar.f22738g, true);
            w1Var.c(s4.WARNING, "Envelope rejected", new Object[0]);
        }
    }

    private static void k(n1 n1Var, final boolean z) {
        io.sentry.util.m.k(n1Var, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.i
            @Override // io.sentry.util.m.a
            public final void a(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.k(n1Var, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.j
            @Override // io.sentry.util.m.a
            public final void a(Object obj) {
                ((io.sentry.hints.k) obj).d(z);
            }
        });
    }

    @Override // io.sentry.transport.r
    public void V(h4 h4Var, n1 n1Var) throws IOException {
        io.sentry.cache.r rVar = this.f22731g;
        boolean z = false;
        if (io.sentry.util.m.d(n1Var, io.sentry.hints.f.class)) {
            rVar = t.c();
            this.f22732h.getLogger().c(s4.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z = true;
        }
        h4 b2 = this.f22733i.b(h4Var, n1Var);
        if (b2 == null) {
            if (z) {
                this.f22731g.p(h4Var);
                return;
            }
            return;
        }
        if (io.sentry.util.m.d(n1Var, UncaughtExceptionHandlerIntegration.a.class)) {
            b2 = this.f22732h.getClientReportRecorder().c(b2);
        }
        Future<?> submit = this.f22730f.submit(new c(b2, n1Var, rVar));
        if (submit == null || !submit.isCancelled()) {
            return;
        }
        this.f22732h.getClientReportRecorder().b(io.sentry.clientreport.e.QUEUE_OVERFLOW, b2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22730f.shutdown();
        this.f22732h.getLogger().c(s4.DEBUG, "Shutting down", new Object[0]);
        try {
            if (this.f22730f.awaitTermination(1L, TimeUnit.MINUTES)) {
                return;
            }
            this.f22732h.getLogger().c(s4.WARNING, "Failed to shutdown the async connection async sender within 1 minute. Trying to force it now.", new Object[0]);
            this.f22730f.shutdownNow();
        } catch (InterruptedException unused) {
            this.f22732h.getLogger().c(s4.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.sentry.transport.r
    public void h(long j2) {
        this.f22730f.b(j2);
    }

    public m(x xVar, x4 x4Var, y yVar, s sVar, p pVar) {
        this.f22730f = (x) io.sentry.util.q.c(xVar, "executor is required");
        this.f22731g = (io.sentry.cache.r) io.sentry.util.q.c(x4Var.getEnvelopeDiskCache(), "envelopeCache is required");
        this.f22732h = (x4) io.sentry.util.q.c(x4Var, "options is required");
        this.f22733i = (y) io.sentry.util.q.c(yVar, "rateLimiter is required");
        this.f22734j = (s) io.sentry.util.q.c(sVar, "transportGate is required");
        this.f22735k = (p) io.sentry.util.q.c(pVar, "httpConnection is required");
    }
}
