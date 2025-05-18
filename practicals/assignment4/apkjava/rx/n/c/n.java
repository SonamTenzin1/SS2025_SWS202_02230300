package rx.n.c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class n extends rx.h {
    public static final n a = new n();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends h.a implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f26713f = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        final PriorityBlockingQueue<b> f26714g = new PriorityBlockingQueue<>();

        /* renamed from: h, reason: collision with root package name */
        private final rx.t.a f26715h = new rx.t.a();

        /* renamed from: i, reason: collision with root package name */
        private final AtomicInteger f26716i = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: rx.n.c.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0462a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f26717f;

            C0462a(b bVar) {
                this.f26717f = bVar;
            }

            @Override // rx.m.a
            public void call() {
                a.this.f26714g.remove(this.f26717f);
            }
        }

        a() {
        }

        private rx.k f(rx.m.a aVar, long j2) {
            if (this.f26715h.isUnsubscribed()) {
                return rx.t.e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j2), this.f26713f.incrementAndGet());
            this.f26714g.add(bVar);
            if (this.f26716i.getAndIncrement() != 0) {
                return rx.t.e.a(new C0462a(bVar));
            }
            do {
                b poll = this.f26714g.poll();
                if (poll != null) {
                    poll.f26719f.call();
                }
            } while (this.f26716i.decrementAndGet() > 0);
            return rx.t.e.c();
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            return f(aVar, b());
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            long b2 = b() + timeUnit.toMillis(j2);
            return f(new m(aVar, this, b2), b2);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26715h.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26715h.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: f, reason: collision with root package name */
        final rx.m.a f26719f;

        /* renamed from: g, reason: collision with root package name */
        final Long f26720g;

        /* renamed from: h, reason: collision with root package name */
        final int f26721h;

        b(rx.m.a aVar, Long l, int i2) {
            this.f26719f = aVar;
            this.f26720g = l;
            this.f26721h = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int compareTo = this.f26720g.compareTo(bVar.f26720g);
            return compareTo == 0 ? n.a(this.f26721h, bVar.f26721h) : compareTo;
        }
    }

    private n() {
    }

    static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    @Override // rx.h
    public h.a createWorker() {
        return new a();
    }
}
