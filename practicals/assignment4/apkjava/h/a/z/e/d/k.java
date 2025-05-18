package h.a.z.e.d;

import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes2.dex */
public final class k<T> extends h.a.m<T> {

    /* renamed from: f, reason: collision with root package name */
    final Iterable<? extends T> f21564f;

    /* compiled from: ObservableFromIterable.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends h.a.z.d.b<T> {

        /* renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21565f;

        /* renamed from: g, reason: collision with root package name */
        final Iterator<? extends T> f21566g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f21567h;

        /* renamed from: i, reason: collision with root package name */
        boolean f21568i;

        /* renamed from: j, reason: collision with root package name */
        boolean f21569j;

        /* renamed from: k, reason: collision with root package name */
        boolean f21570k;

        a(h.a.q<? super T> qVar, Iterator<? extends T> it) {
            this.f21565f = qVar;
            this.f21566g = it;
        }

        void a() {
            while (!q()) {
                try {
                    this.f21565f.onNext(h.a.z.b.b.c(this.f21566g.next(), "The iterator returned a null value"));
                    if (q()) {
                        return;
                    }
                    try {
                        if (!this.f21566g.hasNext()) {
                            if (q()) {
                                return;
                            }
                            this.f21565f.a();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.a(th);
                        this.f21565f.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.a(th2);
                    this.f21565f.onError(th2);
                    return;
                }
            }
        }

        @Override // h.a.z.c.f
        public void clear() {
            this.f21569j = true;
        }

        @Override // h.a.z.c.c
        public int g(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f21568i = true;
            return 1;
        }

        @Override // h.a.z.c.f
        public boolean isEmpty() {
            return this.f21569j;
        }

        @Override // h.a.x.c
        public void k() {
            this.f21567h = true;
        }

        @Override // h.a.z.c.f
        public T poll() {
            if (this.f21569j) {
                return null;
            }
            if (this.f21570k) {
                if (!this.f21566g.hasNext()) {
                    this.f21569j = true;
                    return null;
                }
            } else {
                this.f21570k = true;
            }
            return (T) h.a.z.b.b.c(this.f21566g.next(), "The iterator returned a null value");
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21567h;
        }
    }

    public k(Iterable<? extends T> iterable) {
        this.f21564f = iterable;
    }

    @Override // h.a.m
    public void x(h.a.q<? super T> qVar) {
        try {
            Iterator<? extends T> it = this.f21564f.iterator();
            try {
                if (!it.hasNext()) {
                    h.a.z.a.d.v(qVar);
                    return;
                }
                a aVar = new a(qVar, it);
                qVar.b(aVar);
                if (aVar.f21568i) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                h.a.z.a.d.x(th, qVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.a(th2);
            h.a.z.a.d.x(th2, qVar);
        }
    }
}
