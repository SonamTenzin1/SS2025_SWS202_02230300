package rx.n.e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory.java */
/* loaded from: classes3.dex */
public final class i extends AtomicLong implements ThreadFactory {

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f26748f = new a();

    /* renamed from: g, reason: collision with root package name */
    final String f26749g;

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes3.dex */
    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public i(String str) {
        this.f26749g = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f26749g + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
