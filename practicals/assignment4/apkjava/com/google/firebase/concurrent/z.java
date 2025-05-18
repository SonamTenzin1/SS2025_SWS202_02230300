package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequentialExecutor.java */
/* loaded from: classes2.dex */
public final class z implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f18972f = Logger.getLogger(z.class.getName());

    /* renamed from: g, reason: collision with root package name */
    private final Executor f18973g;

    /* renamed from: h, reason: collision with root package name */
    private final Deque<Runnable> f18974h = new ArrayDeque();

    /* renamed from: i, reason: collision with root package name */
    private c f18975i = c.IDLE;

    /* renamed from: j, reason: collision with root package name */
    private long f18976j = 0;

    /* renamed from: k, reason: collision with root package name */
    private final b f18977k = new b(this, null);

    /* compiled from: SequentialExecutor.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f18978f;

        a(Runnable runnable) {
            this.f18978f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18978f.run();
        }

        public String toString() {
            return this.f18978f.toString();
        }
    }

    /* compiled from: SequentialExecutor.java */
    /* loaded from: classes2.dex */
    private final class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        Runnable f18980f;

        private b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
        
            r8.f18980f.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        
            com.google.firebase.concurrent.z.f18972f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f18980f, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
        
            r8.f18980f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a() {
            boolean z = false;
            boolean z2 = false;
            while (true) {
                try {
                    synchronized (z.this.f18974h) {
                        if (!z) {
                            c cVar = z.this.f18975i;
                            c cVar2 = c.RUNNING;
                            if (cVar != cVar2) {
                                z.d(z.this);
                                z.this.f18975i = cVar2;
                                z = true;
                            }
                        }
                        Runnable runnable = (Runnable) z.this.f18974h.poll();
                        this.f18980f = runnable;
                        if (runnable == null) {
                            z.this.f18975i = c.IDLE;
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } finally {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e2) {
                synchronized (z.this.f18974h) {
                    z.this.f18975i = c.IDLE;
                    throw e2;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f18980f;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + z.this.f18975i + "}";
        }

        /* synthetic */ b(z zVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SequentialExecutor.java */
    /* loaded from: classes2.dex */
    public enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Executor executor) {
        this.f18973g = (Executor) Preconditions.k(executor);
    }

    static /* synthetic */ long d(z zVar) {
        long j2 = zVar.f18976j;
        zVar.f18976j = 1 + j2;
        return j2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        Preconditions.k(runnable);
        synchronized (this.f18974h) {
            c cVar2 = this.f18975i;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j2 = this.f18976j;
                a aVar = new a(runnable);
                this.f18974h.add(aVar);
                c cVar3 = c.QUEUING;
                this.f18975i = cVar3;
                try {
                    this.f18973g.execute(this.f18977k);
                    if (this.f18975i != cVar3) {
                        return;
                    }
                    synchronized (this.f18974h) {
                        if (this.f18976j == j2 && this.f18975i == cVar3) {
                            this.f18975i = cVar;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e2) {
                    synchronized (this.f18974h) {
                        c cVar4 = this.f18975i;
                        if ((cVar4 != c.IDLE && cVar4 != c.QUEUING) || !this.f18974h.removeLastOccurrence(aVar)) {
                            r0 = false;
                        }
                        if (!(e2 instanceof RejectedExecutionException) || r0) {
                            throw e2;
                        }
                    }
                    return;
                }
            }
            this.f18974h.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f18973g + "}";
    }
}
