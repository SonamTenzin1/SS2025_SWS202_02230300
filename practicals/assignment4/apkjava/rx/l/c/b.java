package rx.l.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.h;
import rx.k;
import rx.q.f;
import rx.t.e;

/* compiled from: LooperScheduler.java */
/* loaded from: classes3.dex */
class b extends h {
    private final Handler a;

    /* compiled from: LooperScheduler.java */
    /* loaded from: classes3.dex */
    static class a extends h.a {

        /* renamed from: f, reason: collision with root package name */
        private final Handler f26099f;

        /* renamed from: g, reason: collision with root package name */
        private final rx.l.b.b f26100g = rx.l.b.a.a().b();

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f26101h;

        a(Handler handler) {
            this.f26099f = handler;
        }

        @Override // rx.h.a
        public k c(rx.m.a aVar) {
            return d(aVar, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.h.a
        public k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f26101h) {
                return e.c();
            }
            RunnableC0439b runnableC0439b = new RunnableC0439b(this.f26100g.c(aVar), this.f26099f);
            Message obtain = Message.obtain(this.f26099f, runnableC0439b);
            obtain.obj = this;
            this.f26099f.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            if (!this.f26101h) {
                return runnableC0439b;
            }
            this.f26099f.removeCallbacks(runnableC0439b);
            return e.c();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26101h;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26101h = true;
            this.f26099f.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LooperScheduler.java */
    /* renamed from: rx.l.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class RunnableC0439b implements Runnable, k {

        /* renamed from: f, reason: collision with root package name */
        private final rx.m.a f26102f;

        /* renamed from: g, reason: collision with root package name */
        private final Handler f26103g;

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f26104h;

        RunnableC0439b(rx.m.a aVar, Handler handler) {
            this.f26102f = aVar;
            this.f26103g = handler;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26104h;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f26102f.call();
            } catch (Throwable th) {
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                f.c().b().a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26104h = true;
            this.f26103g.removeCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Looper looper) {
        this.a = new Handler(looper);
    }

    @Override // rx.h
    public h.a createWorker() {
        return new a(this.a);
    }
}
