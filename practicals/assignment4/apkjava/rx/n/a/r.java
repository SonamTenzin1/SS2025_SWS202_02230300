package rx.n.a;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.n.a.u;

/* compiled from: OnSubscribeFlattenIterable.java */
/* loaded from: classes3.dex */
public final class r<T, R> implements e.a<R> {

    /* renamed from: f, reason: collision with root package name */
    final rx.e<? extends T> f26436f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends Iterable<? extends R>> f26437g;

    /* renamed from: h, reason: collision with root package name */
    final int f26438h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: classes3.dex */
    public class a implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f26439f;

        a(b bVar) {
            this.f26439f = bVar;
        }

        @Override // rx.g
        public void request(long j2) {
            this.f26439f.e(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26441f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends Iterable<? extends R>> f26442g;

        /* renamed from: h, reason: collision with root package name */
        final long f26443h;

        /* renamed from: i, reason: collision with root package name */
        final Queue<Object> f26444i;
        volatile boolean m;
        long n;
        Iterator<? extends R> o;

        /* renamed from: j, reason: collision with root package name */
        final AtomicReference<Throwable> f26445j = new AtomicReference<>();
        final AtomicInteger l = new AtomicInteger();

        /* renamed from: k, reason: collision with root package name */
        final AtomicLong f26446k = new AtomicLong();

        public b(rx.j<? super R> jVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar, int i2) {
            this.f26441f = jVar;
            this.f26442g = eVar;
            if (i2 == Integer.MAX_VALUE) {
                this.f26443h = Long.MAX_VALUE;
                this.f26444i = new rx.n.e.n.g(rx.n.e.h.f26744f);
            } else {
                this.f26443h = i2 - (i2 >> 2);
                if (rx.n.e.o.z.b()) {
                    this.f26444i = new rx.n.e.o.s(i2);
                } else {
                    this.f26444i = new rx.n.e.n.e(i2);
                }
            }
            request(i2);
        }

        boolean c(boolean z, boolean z2, rx.j<?> jVar, Queue<?> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                this.o = null;
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.f26445j.get() == null) {
                if (!z2) {
                    return false;
                }
                jVar.onCompleted();
                return true;
            }
            Throwable q = rx.n.e.e.q(this.f26445j);
            unsubscribe();
            queue.clear();
            this.o = null;
            jVar.onError(q);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0010 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x00cf A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d() {
            int i2;
            if (this.l.getAndIncrement() != 0) {
                return;
            }
            rx.j<? super R> jVar = this.f26441f;
            Queue<?> queue = this.f26444i;
            int i3 = 1;
            while (true) {
                Iterator<? extends R> it = this.o;
                boolean z = false;
                if (it == null) {
                    boolean z2 = this.m;
                    Object poll = queue.poll();
                    boolean z3 = poll == null;
                    if (c(z2, z3, jVar, queue)) {
                        return;
                    }
                    if (!z3) {
                        long j2 = this.n + 1;
                        i2 = i3;
                        if (j2 == this.f26443h) {
                            this.n = 0L;
                            request(j2);
                        } else {
                            this.n = j2;
                        }
                        try {
                            it = this.f26442g.call((Object) h.e(poll)).iterator();
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            onError(th);
                        }
                        if (it.hasNext()) {
                            this.o = it;
                            if (it == null) {
                                long j3 = this.f26446k.get();
                                long j4 = 0;
                                while (j4 != j3) {
                                    if (c(this.m, false, jVar, queue)) {
                                        return;
                                    }
                                    try {
                                        jVar.onNext(it.next());
                                    } catch (Throwable th2) {
                                        rx.exceptions.a.e(th2);
                                        this.o = null;
                                        onError(th2);
                                    }
                                    if (c(this.m, false, jVar, queue)) {
                                        return;
                                    }
                                    j4++;
                                    try {
                                    } catch (Throwable th3) {
                                        rx.exceptions.a.e(th3);
                                        this.o = null;
                                        onError(th3);
                                    }
                                    if (!it.hasNext()) {
                                        this.o = null;
                                        it = null;
                                        break;
                                    }
                                }
                                if (j4 == j3) {
                                    boolean z4 = this.m;
                                    if (queue.isEmpty() && it == null) {
                                        z = true;
                                    }
                                    if (c(z4, z, jVar, queue)) {
                                        return;
                                    }
                                }
                                if (j4 != 0) {
                                    rx.n.a.a.c(this.f26446k, j4);
                                }
                                if (it == null) {
                                    i3 = i2;
                                }
                            }
                            i3 = this.l.addAndGet(-i2);
                            if (i3 != 0) {
                                return;
                            }
                        } else {
                            i3 = i2;
                        }
                    }
                }
                i2 = i3;
                if (it == null) {
                }
                i3 = this.l.addAndGet(-i2);
                if (i3 != 0) {
                }
            }
        }

        void e(long j2) {
            if (j2 > 0) {
                rx.n.a.a.b(this.f26446k, j2);
                d();
            } else {
                if (j2 >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j2);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.m = true;
            d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (rx.n.e.e.g(this.f26445j, th)) {
                this.m = true;
                d();
            } else {
                rx.q.c.j(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (!this.f26444i.offer(h.g(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlattenIterable.java */
    /* loaded from: classes3.dex */
    public static final class c<T, R> implements e.a<R> {

        /* renamed from: f, reason: collision with root package name */
        final T f26447f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends Iterable<? extends R>> f26448g;

        public c(T t, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar) {
            this.f26447f = t;
            this.f26448g = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super R> jVar) {
            try {
                Iterator<? extends R> it = this.f26448g.call(this.f26447f).iterator();
                if (!it.hasNext()) {
                    jVar.onCompleted();
                } else {
                    jVar.setProducer(new u.a(jVar, it));
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, jVar, this.f26447f);
            }
        }
    }

    protected r(rx.e<? extends T> eVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar2, int i2) {
        this.f26436f = eVar;
        this.f26437g = eVar2;
        this.f26438h = i2;
    }

    public static <T, R> rx.e<R> b(rx.e<? extends T> eVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar2, int i2) {
        if (eVar instanceof rx.n.e.j) {
            return rx.e.b1(new c(((rx.n.e.j) eVar).h1(), eVar2));
        }
        return rx.e.b1(new r(eVar, eVar2, i2));
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        b bVar = new b(jVar, this.f26437g, this.f26438h);
        jVar.add(bVar);
        jVar.setProducer(new a(bVar));
        this.f26436f.c1(bVar);
    }
}
