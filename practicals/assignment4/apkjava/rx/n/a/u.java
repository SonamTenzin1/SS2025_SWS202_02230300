package rx.n.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: OnSubscribeFromIterable.java */
/* loaded from: classes3.dex */
public final class u<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    final Iterable<? extends T> f26500f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFromIterable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicLong implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        private final rx.j<? super T> f26501f;

        /* renamed from: g, reason: collision with root package name */
        private final Iterator<? extends T> f26502g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.j<? super T> jVar, Iterator<? extends T> it) {
            this.f26501f = jVar;
            this.f26502g = it;
        }

        void a() {
            rx.j<? super T> jVar = this.f26501f;
            Iterator<? extends T> it = this.f26502g;
            while (!jVar.isUnsubscribed()) {
                try {
                    jVar.onNext(it.next());
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            jVar.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, jVar);
                        return;
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, jVar);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        
            r9 = rx.n.a.a.c(r8, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void b(long j2) {
            rx.j<? super T> jVar = this.f26501f;
            Iterator<? extends T> it = this.f26502g;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            jVar.onNext(it.next());
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (jVar.isUnsubscribed()) {
                                        return;
                                    }
                                    jVar.onCompleted();
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                rx.exceptions.a.f(th, jVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.f(th2, jVar);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            break;
                        }
                    }
                }
            } while (j2 != 0);
        }

        @Override // rx.g
        public void request(long j2) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                a();
            } else {
                if (j2 <= 0 || rx.n.a.a.b(this, j2) != 0) {
                    return;
                }
                b(j2);
            }
        }
    }

    public u(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f26500f = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        try {
            Iterator<? extends T> it = this.f26500f.iterator();
            boolean hasNext = it.hasNext();
            if (jVar.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                jVar.onCompleted();
            } else {
                jVar.setProducer(new a(jVar, it));
            }
        } catch (Throwable th) {
            rx.exceptions.a.f(th, jVar);
        }
    }
}
