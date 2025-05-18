package rx.n.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.h;

/* compiled from: OperatorObserveOn.java */
/* loaded from: classes3.dex */
public final class r0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    private final rx.h f26449f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f26450g;

    /* renamed from: h, reason: collision with root package name */
    private final int f26451h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorObserveOn.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26452f;

        /* renamed from: g, reason: collision with root package name */
        final h.a f26453g;

        /* renamed from: h, reason: collision with root package name */
        final boolean f26454h;

        /* renamed from: i, reason: collision with root package name */
        final Queue<Object> f26455i;

        /* renamed from: j, reason: collision with root package name */
        final int f26456j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f26457k;
        final AtomicLong l = new AtomicLong();
        final AtomicLong m = new AtomicLong();
        Throwable n;
        long o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorObserveOn.java */
        /* renamed from: rx.n.a.r0$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0447a implements rx.g {
            C0447a() {
            }

            @Override // rx.g
            public void request(long j2) {
                if (j2 > 0) {
                    rx.n.a.a.b(a.this.l, j2);
                    a.this.e();
                }
            }
        }

        public a(rx.h hVar, rx.j<? super T> jVar, boolean z, int i2) {
            this.f26452f = jVar;
            this.f26453g = hVar.createWorker();
            this.f26454h = z;
            i2 = i2 <= 0 ? rx.n.e.h.f26744f : i2;
            this.f26456j = i2 - (i2 >> 2);
            if (rx.n.e.o.z.b()) {
                this.f26455i = new rx.n.e.o.s(i2);
            } else {
                this.f26455i = new rx.n.e.n.e(i2);
            }
            request(i2);
        }

        boolean c(boolean z, boolean z2, rx.j<? super T> jVar, Queue<Object> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.f26454h) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.n;
                try {
                    if (th != null) {
                        jVar.onError(th);
                    } else {
                        jVar.onCompleted();
                    }
                    return false;
                } finally {
                }
            }
            Throwable th2 = this.n;
            if (th2 != null) {
                queue.clear();
                try {
                    jVar.onError(th2);
                    return true;
                } finally {
                }
            }
            if (!z2) {
                return false;
            }
            try {
                jVar.onCompleted();
                return true;
            } finally {
            }
        }

        @Override // rx.m.a
        public void call() {
            long j2 = this.o;
            Queue<Object> queue = this.f26455i;
            rx.j<? super T> jVar = this.f26452f;
            long j3 = 1;
            do {
                long j4 = this.l.get();
                while (j4 != j2) {
                    boolean z = this.f26457k;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (c(z, z2, jVar, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    jVar.onNext((Object) h.e(poll));
                    j2++;
                    if (j2 == this.f26456j) {
                        j4 = rx.n.a.a.c(this.l, j2);
                        request(j2);
                        j2 = 0;
                    }
                }
                if (j4 == j2 && c(this.f26457k, queue.isEmpty(), jVar, queue)) {
                    return;
                }
                this.o = j2;
                j3 = this.m.addAndGet(-j3);
            } while (j3 != 0);
        }

        void d() {
            rx.j<? super T> jVar = this.f26452f;
            jVar.setProducer(new C0447a());
            jVar.add(this.f26453g);
            jVar.add(this);
        }

        protected void e() {
            if (this.m.getAndIncrement() == 0) {
                this.f26453g.c(this);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (isUnsubscribed() || this.f26457k) {
                return;
            }
            this.f26457k = true;
            e();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!isUnsubscribed() && !this.f26457k) {
                this.n = th;
                this.f26457k = true;
                e();
                return;
            }
            rx.q.c.j(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (isUnsubscribed() || this.f26457k) {
                return;
            }
            if (!this.f26455i.offer(h.g(t))) {
                onError(new MissingBackpressureException());
            } else {
                e();
            }
        }
    }

    public r0(rx.h hVar, boolean z, int i2) {
        this.f26449f = hVar;
        this.f26450g = z;
        this.f26451h = i2 <= 0 ? rx.n.e.h.f26744f : i2;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.h hVar = this.f26449f;
        if ((hVar instanceof rx.n.c.f) || (hVar instanceof rx.n.c.n)) {
            return jVar;
        }
        a aVar = new a(hVar, jVar, this.f26450g, this.f26451h);
        aVar.d();
        return aVar;
    }
}
