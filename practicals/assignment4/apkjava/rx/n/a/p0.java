package rx.n.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: OperatorEagerConcatMap.java */
/* loaded from: classes3.dex */
public final class p0<T, R> implements e.b<R, T> {

    /* renamed from: f, reason: collision with root package name */
    final rx.m.e<? super T, ? extends rx.e<? extends R>> f26385f;

    /* renamed from: g, reason: collision with root package name */
    final int f26386g;

    /* renamed from: h, reason: collision with root package name */
    private final int f26387h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final c<?, T> f26388f;

        /* renamed from: g, reason: collision with root package name */
        final Queue<Object> f26389g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f26390h;

        /* renamed from: i, reason: collision with root package name */
        Throwable f26391i;

        public a(c<?, T> cVar, int i2) {
            Queue<Object> eVar;
            this.f26388f = cVar;
            if (rx.n.e.o.z.b()) {
                eVar = new rx.n.e.o.s<>(i2);
            } else {
                eVar = new rx.n.e.n.e<>(i2);
            }
            this.f26389g = eVar;
            request(i2);
        }

        void c(long j2) {
            request(j2);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26390h = true;
            this.f26388f.d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26391i = th;
            this.f26390h = true;
            this.f26388f.d();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26389g.offer(h.g(t));
            this.f26388f.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class b extends AtomicLong implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final c<?, ?> f26392f;

        public b(c<?, ?> cVar) {
            this.f26392f = cVar;
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j2);
            }
            if (j2 > 0) {
                rx.n.a.a.b(this, j2);
                this.f26392f.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class c<T, R> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.m.e<? super T, ? extends rx.e<? extends R>> f26393f;

        /* renamed from: g, reason: collision with root package name */
        final int f26394g;

        /* renamed from: h, reason: collision with root package name */
        final rx.j<? super R> f26395h;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f26397j;

        /* renamed from: k, reason: collision with root package name */
        Throwable f26398k;
        volatile boolean l;
        private b n;

        /* renamed from: i, reason: collision with root package name */
        final Queue<a<R>> f26396i = new LinkedList();
        final AtomicInteger m = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorEagerConcatMap.java */
        /* loaded from: classes3.dex */
        public class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                c.this.l = true;
                if (c.this.m.getAndIncrement() == 0) {
                    c.this.c();
                }
            }
        }

        public c(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar, int i2, int i3, rx.j<? super R> jVar) {
            this.f26393f = eVar;
            this.f26394g = i2;
            this.f26395h = jVar;
            request(i3 == Integer.MAX_VALUE ? Long.MAX_VALUE : i3);
        }

        void c() {
            ArrayList arrayList;
            synchronized (this.f26396i) {
                arrayList = new ArrayList(this.f26396i);
                this.f26396i.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((rx.k) it.next()).unsubscribe();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x0087, code lost:
        
            if (r12 == 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
        
            if (r8 == Long.MAX_VALUE) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
        
            rx.n.a.a.c(r0, r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
        
            if (r6 != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0097, code lost:
        
            r7.c(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009a, code lost:
        
            if (r6 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
        
            r4 = r17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d() {
            a<R> peek;
            int i2;
            if (this.m.getAndIncrement() != 0) {
                return;
            }
            b bVar = this.n;
            rx.j<? super R> jVar = this.f26395h;
            int i3 = 1;
            while (!this.l) {
                boolean z = this.f26397j;
                synchronized (this.f26396i) {
                    peek = this.f26396i.peek();
                }
                boolean z2 = false;
                boolean z3 = peek == null;
                if (z) {
                    Throwable th = this.f26398k;
                    if (th != null) {
                        c();
                        jVar.onError(th);
                        return;
                    } else if (z3) {
                        jVar.onCompleted();
                        return;
                    }
                }
                if (!z3) {
                    long j2 = bVar.get();
                    Queue<Object> queue = peek.f26389g;
                    long j3 = 0;
                    while (true) {
                        boolean z4 = peek.f26390h;
                        Object peek2 = queue.peek();
                        i2 = i3;
                        boolean z5 = peek2 == null;
                        if (z4) {
                            Throwable th2 = peek.f26391i;
                            if (th2 == null) {
                                if (z5) {
                                    synchronized (this.f26396i) {
                                        this.f26396i.poll();
                                    }
                                    peek.unsubscribe();
                                    request(1L);
                                    z2 = true;
                                    break;
                                }
                            } else {
                                c();
                                jVar.onError(th2);
                                return;
                            }
                        }
                        if (z5 || j2 == j3) {
                            break;
                        }
                        queue.poll();
                        try {
                            jVar.onNext((Object) h.e(peek2));
                            j3++;
                            i3 = i2;
                        } catch (Throwable th3) {
                            rx.exceptions.a.g(th3, jVar, peek2);
                            return;
                        }
                    }
                } else {
                    i2 = i3;
                }
                i3 = this.m.addAndGet(-i2);
                if (i3 == 0) {
                    return;
                }
            }
            c();
        }

        void e() {
            this.n = new b(this);
            add(rx.t.e.a(new a()));
            this.f26395h.add(this);
            this.f26395h.setProducer(this.n);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26397j = true;
            d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26398k = th;
            this.f26397j = true;
            d();
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                rx.e<? extends R> call = this.f26393f.call(t);
                if (this.l) {
                    return;
                }
                a<R> aVar = new a<>(this, this.f26394g);
                synchronized (this.f26396i) {
                    if (this.l) {
                        return;
                    }
                    this.f26396i.add(aVar);
                    if (this.l) {
                        return;
                    }
                    call.c1(aVar);
                    d();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f26395h, t);
            }
        }
    }

    public p0(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar, int i2, int i3) {
        this.f26385f = eVar;
        this.f26386g = i2;
        this.f26387h = i3;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super R> jVar) {
        c cVar = new c(this.f26385f, this.f26386g, this.f26387h, jVar);
        cVar.e();
        return cVar;
    }
}
