package rx.l;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.k;

/* compiled from: MainThreadSubscription.java */
/* loaded from: classes3.dex */
public abstract class a implements k {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    /* compiled from: MainThreadSubscription.java */
    /* renamed from: rx.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0438a implements rx.m.a {
        C0438a() {
        }

        @Override // rx.m.a
        public void call() {
            a.this.onUnsubscribe();
        }
    }

    public static void verifyMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    @Override // rx.k
    public final boolean isUnsubscribed() {
        return this.unsubscribed.get();
    }

    protected abstract void onUnsubscribe();

    @Override // rx.k
    public final void unsubscribe() {
        if (this.unsubscribed.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                onUnsubscribe();
            } else {
                rx.l.c.a.b().createWorker().c(new C0438a());
            }
        }
    }
}
