package h.a.z.e.d;

import h.a.r;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes2.dex */
public final class n<T> extends h.a.z.e.d.a<T, T> {

    /* renamed from: g, reason: collision with root package name */
    final h.a.r f21573g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f21574h;

    /* renamed from: i, reason: collision with root package name */
    final int f21575i;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends h.a.z.d.a<T> implements h.a.q<T>, Runnable {

        /* renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21576f;

        /* renamed from: g, reason: collision with root package name */
        final r.b f21577g;

        /* renamed from: h, reason: collision with root package name */
        final boolean f21578h;

        /* renamed from: i, reason: collision with root package name */
        final int f21579i;

        /* renamed from: j, reason: collision with root package name */
        h.a.z.c.f<T> f21580j;

        /* renamed from: k, reason: collision with root package name */
        h.a.x.c f21581k;
        Throwable l;
        volatile boolean m;
        volatile boolean n;
        int o;
        boolean p;

        a(h.a.q<? super T> qVar, r.b bVar, boolean z, int i2) {
            this.f21576f = qVar;
            this.f21577g = bVar;
            this.f21578h = z;
            this.f21579i = i2;
        }

        @Override // h.a.q
        public void a() {
            if (this.m) {
                return;
            }
            this.m = true;
            f();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21581k, cVar)) {
                this.f21581k = cVar;
                if (cVar instanceof h.a.z.c.b) {
                    h.a.z.c.b bVar = (h.a.z.c.b) cVar;
                    int g2 = bVar.g(7);
                    if (g2 == 1) {
                        this.o = g2;
                        this.f21580j = bVar;
                        this.m = true;
                        this.f21576f.b(this);
                        f();
                        return;
                    }
                    if (g2 == 2) {
                        this.o = g2;
                        this.f21580j = bVar;
                        this.f21576f.b(this);
                        return;
                    }
                }
                this.f21580j = new h.a.z.f.c(this.f21579i);
                this.f21576f.b(this);
            }
        }

        boolean c(boolean z, boolean z2, h.a.q<? super T> qVar) {
            if (this.n) {
                this.f21580j.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.l;
            if (this.f21578h) {
                if (!z2) {
                    return false;
                }
                this.n = true;
                if (th != null) {
                    qVar.onError(th);
                } else {
                    qVar.a();
                }
                this.f21577g.k();
                return true;
            }
            if (th != null) {
                this.n = true;
                this.f21580j.clear();
                qVar.onError(th);
                this.f21577g.k();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.n = true;
            qVar.a();
            this.f21577g.k();
            return true;
        }

        @Override // h.a.z.c.f
        public void clear() {
            this.f21580j.clear();
        }

        void d() {
            int i2 = 1;
            while (!this.n) {
                boolean z = this.m;
                Throwable th = this.l;
                if (!this.f21578h && z && th != null) {
                    this.n = true;
                    this.f21576f.onError(this.l);
                    this.f21577g.k();
                    return;
                }
                this.f21576f.onNext(null);
                if (z) {
                    this.n = true;
                    Throwable th2 = this.l;
                    if (th2 != null) {
                        this.f21576f.onError(th2);
                    } else {
                        this.f21576f.a();
                    }
                    this.f21577g.k();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void e() {
            h.a.z.c.f<T> fVar = this.f21580j;
            h.a.q<? super T> qVar = this.f21576f;
            int i2 = 1;
            while (!c(this.m, fVar.isEmpty(), qVar)) {
                while (true) {
                    boolean z = this.m;
                    try {
                        T poll = fVar.poll();
                        boolean z2 = poll == null;
                        if (c(z, z2, qVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        } else {
                            qVar.onNext(poll);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.a(th);
                        this.n = true;
                        this.f21581k.k();
                        fVar.clear();
                        qVar.onError(th);
                        this.f21577g.k();
                        return;
                    }
                }
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                this.f21577g.b(this);
            }
        }

        @Override // h.a.z.c.c
        public int g(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.p = true;
            return 2;
        }

        @Override // h.a.z.c.f
        public boolean isEmpty() {
            return this.f21580j.isEmpty();
        }

        @Override // h.a.x.c
        public void k() {
            if (this.n) {
                return;
            }
            this.n = true;
            this.f21581k.k();
            this.f21577g.k();
            if (this.p || getAndIncrement() != 0) {
                return;
            }
            this.f21580j.clear();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (this.m) {
                h.a.a0.a.o(th);
                return;
            }
            this.l = th;
            this.m = true;
            f();
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (this.m) {
                return;
            }
            if (this.o != 2) {
                this.f21580j.offer(t);
            }
            f();
        }

        @Override // h.a.z.c.f
        public T poll() throws Exception {
            return this.f21580j.poll();
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.n;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.p) {
                d();
            } else {
                e();
            }
        }
    }

    public n(h.a.p<T> pVar, h.a.r rVar, boolean z, int i2) {
        super(pVar);
        this.f21573g = rVar;
        this.f21574h = z;
        this.f21575i = i2;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super T> qVar) {
        h.a.r rVar = this.f21573g;
        if (rVar instanceof h.a.z.g.m) {
            this.f21503f.a(qVar);
        } else {
            this.f21503f.a(new a(qVar, rVar.a(), this.f21574h, this.f21575i));
        }
    }
}
