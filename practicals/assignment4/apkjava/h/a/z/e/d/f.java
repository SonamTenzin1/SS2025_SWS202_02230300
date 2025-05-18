package h.a.z.e.d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMap.java */
/* loaded from: classes2.dex */
public final class f<T, U> extends h.a.z.e.d.a<T, U> {

    /* renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.p<? extends U>> f21518g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f21519h;

    /* renamed from: i, reason: collision with root package name */
    final int f21520i;

    /* renamed from: j, reason: collision with root package name */
    final int f21521j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes2.dex */
    public static final class a<T, U> extends AtomicReference<h.a.x.c> implements h.a.q<U> {

        /* renamed from: f, reason: collision with root package name */
        final long f21522f;

        /* renamed from: g, reason: collision with root package name */
        final b<T, U> f21523g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f21524h;

        /* renamed from: i, reason: collision with root package name */
        volatile h.a.z.c.f<U> f21525i;

        /* renamed from: j, reason: collision with root package name */
        int f21526j;

        a(b<T, U> bVar, long j2) {
            this.f21522f = j2;
            this.f21523g = bVar;
        }

        @Override // h.a.q
        public void a() {
            this.f21524h = true;
            this.f21523g.f();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.A(this, cVar) && (cVar instanceof h.a.z.c.b)) {
                h.a.z.c.b bVar = (h.a.z.c.b) cVar;
                int g2 = bVar.g(7);
                if (g2 == 1) {
                    this.f21526j = g2;
                    this.f21525i = bVar;
                    this.f21524h = true;
                    this.f21523g.f();
                    return;
                }
                if (g2 == 2) {
                    this.f21526j = g2;
                    this.f21525i = bVar;
                }
            }
        }

        public void c() {
            h.a.z.a.c.g(this);
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (this.f21523g.o.a(th)) {
                b<T, U> bVar = this.f21523g;
                if (!bVar.f21531j) {
                    bVar.e();
                }
                this.f21524h = true;
                this.f21523g.f();
                return;
            }
            h.a.a0.a.o(th);
        }

        @Override // h.a.q
        public void onNext(U u) {
            if (this.f21526j == 0) {
                this.f21523g.j(u, this);
            } else {
                this.f21523g.f();
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes2.dex */
    static final class b<T, U> extends AtomicInteger implements h.a.x.c, h.a.q<T> {

        /* renamed from: f, reason: collision with root package name */
        static final a<?, ?>[] f21527f = new a[0];

        /* renamed from: g, reason: collision with root package name */
        static final a<?, ?>[] f21528g = new a[0];

        /* renamed from: h, reason: collision with root package name */
        final h.a.q<? super U> f21529h;

        /* renamed from: i, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.p<? extends U>> f21530i;

        /* renamed from: j, reason: collision with root package name */
        final boolean f21531j;

        /* renamed from: k, reason: collision with root package name */
        final int f21532k;
        final int l;
        volatile h.a.z.c.e<U> m;
        volatile boolean n;
        final h.a.z.j.a o = new h.a.z.j.a();
        volatile boolean p;
        final AtomicReference<a<?, ?>[]> q;
        h.a.x.c r;
        long s;
        long t;
        int u;
        Queue<h.a.p<? extends U>> v;
        int w;

        b(h.a.q<? super U> qVar, h.a.y.f<? super T, ? extends h.a.p<? extends U>> fVar, boolean z, int i2, int i3) {
            this.f21529h = qVar;
            this.f21530i = fVar;
            this.f21531j = z;
            this.f21532k = i2;
            this.l = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.v = new ArrayDeque(i2);
            }
            this.q = new AtomicReference<>(f21527f);
        }

        @Override // h.a.q
        public void a() {
            if (this.n) {
                return;
            }
            this.n = true;
            f();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.r, cVar)) {
                this.r = cVar;
                this.f21529h.b(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean c(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.q.get();
                if (aVarArr == f21528g) {
                    aVar.c();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.q.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean d() {
            if (this.p) {
                return true;
            }
            Throwable th = this.o.get();
            if (this.f21531j || th == null) {
                return false;
            }
            e();
            Throwable b2 = this.o.b();
            if (b2 != h.a.z.j.c.a) {
                this.f21529h.onError(b2);
            }
            return true;
        }

        boolean e() {
            a<?, ?>[] andSet;
            this.r.k();
            a<?, ?>[] aVarArr = this.q.get();
            a<?, ?>[] aVarArr2 = f21528g;
            if (aVarArr == aVarArr2 || (andSet = this.q.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.c();
            }
            return true;
        }

        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:131:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
        
            if (r11 != null) goto L110;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
        
            r11 = r10.f21524h;
            r12 = r10.f21525i;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00d7, code lost:
        
            if (r11 == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:
        
            if (r12 == null) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:
        
            if (r12.isEmpty() == false) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00e1, code lost:
        
            h(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:
        
            if (d() == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00eb, code lost:
        
            r4 = r4 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ea, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ed, code lost:
        
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
        
            if (r7 != r6) goto L133;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00f1, code lost:
        
            r7 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f2, code lost:
        
            r3 = r3 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a5, code lost:
        
            r12 = r11.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00a9, code lost:
        
            if (r12 != null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
        
            r0.onNext(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00b3, code lost:
        
            if (d() == false) goto L135;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b5, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00b6, code lost:
        
            r11 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00b7, code lost:
        
            io.reactivex.exceptions.a.a(r11);
            r10.c();
            r14.o.a(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x00c6, code lost:
        
            if (d() != false) goto L119;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:
        
            h(r10);
            r4 = r4 + 1;
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00d0, code lost:
        
            if (r7 != r6) goto L132;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x00c8, code lost:
        
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void g() {
            int i2;
            h.a.q<? super U> qVar = this.f21529h;
            int i3 = 1;
            while (!d()) {
                h.a.z.c.e<U> eVar = this.m;
                if (eVar != null) {
                    while (!d()) {
                        U poll = eVar.poll();
                        if (poll != null) {
                            qVar.onNext(poll);
                        }
                    }
                    return;
                }
                boolean z = this.n;
                h.a.z.c.e<U> eVar2 = this.m;
                a<?, ?>[] aVarArr = this.q.get();
                int length = aVarArr.length;
                int i4 = 0;
                if (this.f21532k != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i2 = this.v.size();
                    }
                } else {
                    i2 = 0;
                }
                if (z && ((eVar2 == null || eVar2.isEmpty()) && length == 0 && i2 == 0)) {
                    Throwable b2 = this.o.b();
                    if (b2 != h.a.z.j.c.a) {
                        if (b2 == null) {
                            qVar.a();
                            return;
                        } else {
                            qVar.onError(b2);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j2 = this.t;
                    int i5 = this.u;
                    if (length <= i5 || aVarArr[i5].f21522f != j2) {
                        if (length <= i5) {
                            i5 = 0;
                        }
                        for (int i6 = 0; i6 < length && aVarArr[i5].f21522f != j2; i6++) {
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.u = i5;
                        this.t = aVarArr[i5].f21522f;
                    }
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < length) {
                        if (d()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr[i5];
                        h.a.z.c.f<U> fVar = aVar.f21525i;
                    }
                    this.u = i5;
                    this.t = aVarArr[i5].f21522f;
                    i4 = i8;
                }
                if (i4 != 0) {
                    if (this.f21532k != Integer.MAX_VALUE) {
                        while (true) {
                            int i9 = i4 - 1;
                            if (i4 != 0) {
                                synchronized (this) {
                                    h.a.p<? extends U> poll2 = this.v.poll();
                                    if (poll2 == null) {
                                        this.w--;
                                    } else {
                                        i(poll2);
                                    }
                                }
                                i4 = i9;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void h(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.q.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f21527f;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.q.compareAndSet(aVarArr, aVarArr2));
        }

        void i(h.a.p<? extends U> pVar) {
            h.a.p<? extends U> poll;
            while (pVar instanceof Callable) {
                if (!l((Callable) pVar) || this.f21532k == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    poll = this.v.poll();
                    if (poll == null) {
                        this.w--;
                        z = true;
                    }
                }
                if (z) {
                    f();
                    return;
                }
                pVar = poll;
            }
            long j2 = this.s;
            this.s = 1 + j2;
            a<T, U> aVar = new a<>(this, j2);
            if (c(aVar)) {
                pVar.a(aVar);
            }
        }

        void j(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f21529h.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.a.z.c.f fVar = aVar.f21525i;
                if (fVar == null) {
                    fVar = new h.a.z.f.c(this.l);
                    aVar.f21525i = fVar;
                }
                fVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        @Override // h.a.x.c
        public void k() {
            Throwable b2;
            if (this.p) {
                return;
            }
            this.p = true;
            if (!e() || (b2 = this.o.b()) == null || b2 == h.a.z.j.c.a) {
                return;
            }
            h.a.a0.a.o(b2);
        }

        boolean l(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f21529h.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    h.a.z.c.e<U> eVar = this.m;
                    if (eVar == null) {
                        if (this.f21532k == Integer.MAX_VALUE) {
                            eVar = new h.a.z.f.c<>(this.l);
                        } else {
                            eVar = new h.a.z.f.b<>(this.f21532k);
                        }
                        this.m = eVar;
                    }
                    if (!eVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                g();
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.o.a(th);
                f();
                return true;
            }
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (this.n) {
                h.a.a0.a.o(th);
            } else if (this.o.a(th)) {
                this.n = true;
                f();
            } else {
                h.a.a0.a.o(th);
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            try {
                h.a.p<? extends U> pVar = (h.a.p) h.a.z.b.b.c(this.f21530i.a(t), "The mapper returned a null ObservableSource");
                if (this.f21532k != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i2 = this.w;
                        if (i2 == this.f21532k) {
                            this.v.offer(pVar);
                            return;
                        }
                        this.w = i2 + 1;
                    }
                }
                i(pVar);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.r.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.p;
        }
    }

    public f(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.p<? extends U>> fVar, boolean z, int i2, int i3) {
        super(pVar);
        this.f21518g = fVar;
        this.f21519h = z;
        this.f21520i = i2;
        this.f21521j = i3;
    }

    @Override // h.a.m
    public void x(h.a.q<? super U> qVar) {
        if (p.b(this.f21503f, qVar, this.f21518g)) {
            return;
        }
        this.f21503f.a(new b(qVar, this.f21518g, this.f21519h, this.f21520i, this.f21521j));
    }
}
