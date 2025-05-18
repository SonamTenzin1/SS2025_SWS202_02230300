package rx.n.c;

import java.util.concurrent.ThreadFactory;
import rx.h;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class g extends rx.h {
    private final ThreadFactory a;

    public g(ThreadFactory threadFactory) {
        this.a = threadFactory;
    }

    @Override // rx.h
    public h.a createWorker() {
        return new h(this.a);
    }
}
