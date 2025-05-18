package e.e.b.a.i;

import java.util.concurrent.Executor;

/* compiled from: SafeLoggingExecutor.java */
/* loaded from: classes2.dex */
class o implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Executor f20839f;

    /* compiled from: SafeLoggingExecutor.java */
    /* loaded from: classes2.dex */
    static class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f20840f;

        a(Runnable runnable) {
            this.f20840f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f20840f.run();
            } catch (Exception e2) {
                e.e.b.a.i.z.a.d("Executor", "Background execution failure.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Executor executor) {
        this.f20839f = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f20839f.execute(new a(runnable));
    }
}
