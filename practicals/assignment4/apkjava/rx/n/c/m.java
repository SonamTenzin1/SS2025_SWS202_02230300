package rx.n.c;

import rx.h;

/* compiled from: SleepingAction.java */
/* loaded from: classes3.dex */
class m implements rx.m.a {

    /* renamed from: f, reason: collision with root package name */
    private final rx.m.a f26710f;

    /* renamed from: g, reason: collision with root package name */
    private final h.a f26711g;

    /* renamed from: h, reason: collision with root package name */
    private final long f26712h;

    public m(rx.m.a aVar, h.a aVar2, long j2) {
        this.f26710f = aVar;
        this.f26711g = aVar2;
        this.f26712h = j2;
    }

    @Override // rx.m.a
    public void call() {
        if (this.f26711g.isUnsubscribed()) {
            return;
        }
        long b2 = this.f26712h - this.f26711g.b();
        if (b2 > 0) {
            try {
                Thread.sleep(b2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                rx.exceptions.a.c(e2);
            }
        }
        if (this.f26711g.isUnsubscribed()) {
            return;
        }
        this.f26710f.call();
    }
}
