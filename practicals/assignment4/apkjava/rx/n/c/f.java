package rx.n.c;

import java.util.concurrent.TimeUnit;
import rx.h;

/* compiled from: ImmediateScheduler.java */
/* loaded from: classes3.dex */
public final class f extends rx.h {
    public static final f a = new f();

    /* compiled from: ImmediateScheduler.java */
    /* loaded from: classes3.dex */
    final class a extends h.a implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        final rx.t.a f26669f = new rx.t.a();

        a() {
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            aVar.call();
            return rx.t.e.c();
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            return c(new m(aVar, this, f.this.now() + timeUnit.toMillis(j2)));
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26669f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26669f.unsubscribe();
        }
    }

    private f() {
    }

    @Override // rx.h
    public h.a createWorker() {
        return new a();
    }
}
