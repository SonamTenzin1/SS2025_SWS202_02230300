package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor.java */
/* loaded from: classes.dex */
class r implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Executor f2204f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque<Runnable> f2205g = new ArrayDeque<>();

    /* renamed from: h, reason: collision with root package name */
    private Runnable f2206h;

    /* compiled from: TransactionExecutor.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f2207f;

        a(Runnable runnable) {
            this.f2207f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f2207f.run();
            } finally {
                r.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Executor executor) {
        this.f2204f = executor;
    }

    synchronized void a() {
        Runnable poll = this.f2205g.poll();
        this.f2206h = poll;
        if (poll != null) {
            this.f2204f.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f2205g.offer(new a(runnable));
        if (this.f2206h == null) {
            a();
        }
    }
}
