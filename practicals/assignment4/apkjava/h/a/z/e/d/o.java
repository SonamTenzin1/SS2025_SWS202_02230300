package h.a.z.e.d;

import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class o<T> extends h.a.z.e.d.a<T, T> {

    /* renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super Throwable, ? extends T> f21582g;

    /* compiled from: ObservableOnErrorReturn.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements h.a.q<T>, h.a.x.c {

        /* renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21583f;

        /* renamed from: g, reason: collision with root package name */
        final h.a.y.f<? super Throwable, ? extends T> f21584g;

        /* renamed from: h, reason: collision with root package name */
        h.a.x.c f21585h;

        a(h.a.q<? super T> qVar, h.a.y.f<? super Throwable, ? extends T> fVar) {
            this.f21583f = qVar;
            this.f21584g = fVar;
        }

        @Override // h.a.q
        public void a() {
            this.f21583f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21585h, cVar)) {
                this.f21585h = cVar;
                this.f21583f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            this.f21585h.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            try {
                T a = this.f21584g.a(th);
                if (a == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f21583f.onError(nullPointerException);
                } else {
                    this.f21583f.onNext(a);
                    this.f21583f.a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.a(th2);
                this.f21583f.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            this.f21583f.onNext(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21585h.q();
        }
    }

    public o(h.a.p<T> pVar, h.a.y.f<? super Throwable, ? extends T> fVar) {
        super(pVar);
        this.f21582g = fVar;
    }

    @Override // h.a.m
    public void x(h.a.q<? super T> qVar) {
        this.f21503f.a(new a(qVar, this.f21582g));
    }
}
