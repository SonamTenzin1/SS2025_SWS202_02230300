package rx.n.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.h;
import rx.schedulers.Schedulers;

/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public final class y<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    static final rx.m.e<rx.e<? extends rx.d<?>>, rx.e<?>> f26545f = new a();

    /* renamed from: g, reason: collision with root package name */
    final rx.e<T> f26546g;

    /* renamed from: h, reason: collision with root package name */
    private final rx.m.e<? super rx.e<? extends rx.d<?>>, ? extends rx.e<?>> f26547h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f26548i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f26549j;

    /* renamed from: k, reason: collision with root package name */
    private final rx.h f26550k;

    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    static class a implements rx.m.e<rx.e<? extends rx.d<?>>, rx.e<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.n.a.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0450a implements rx.m.e<rx.d<?>, rx.d<?>> {
            C0450a() {
            }

            @Override // rx.m.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public rx.d<?> call(rx.d<?> dVar) {
                return rx.d.c(null);
            }
        }

        a() {
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.e<?> call(rx.e<? extends rx.d<?>> eVar) {
            return eVar.X(new C0450a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class b implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.j f26552f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.s.d f26553g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.n.b.a f26554h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AtomicLong f26555i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.t.d f26556j;

        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        class a extends rx.j<T> {

            /* renamed from: f, reason: collision with root package name */
            boolean f26558f;

            a() {
            }

            private void c() {
                long j2;
                do {
                    j2 = b.this.f26555i.get();
                    if (j2 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f26555i.compareAndSet(j2, j2 - 1));
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f26558f) {
                    return;
                }
                this.f26558f = true;
                unsubscribe();
                b.this.f26553g.onNext(rx.d.a());
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (this.f26558f) {
                    return;
                }
                this.f26558f = true;
                unsubscribe();
                b.this.f26553g.onNext(rx.d.b(th));
            }

            @Override // rx.f
            public void onNext(T t) {
                if (this.f26558f) {
                    return;
                }
                b.this.f26552f.onNext(t);
                c();
                b.this.f26554h.b(1L);
            }

            @Override // rx.j
            public void setProducer(rx.g gVar) {
                b.this.f26554h.c(gVar);
            }
        }

        b(rx.j jVar, rx.s.d dVar, rx.n.b.a aVar, AtomicLong atomicLong, rx.t.d dVar2) {
            this.f26552f = jVar;
            this.f26553g = dVar;
            this.f26554h = aVar;
            this.f26555i = atomicLong;
            this.f26556j = dVar2;
        }

        @Override // rx.m.a
        public void call() {
            if (this.f26552f.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f26556j.b(aVar);
            y.this.f26546g.c1(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class c implements e.b<rx.d<?>, rx.d<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        public class a extends rx.j<rx.d<?>> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.j f26561f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.j jVar, rx.j jVar2) {
                super(jVar);
                this.f26561f = jVar2;
            }

            @Override // rx.f
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onNext(rx.d<?> dVar) {
                if (dVar.i() && y.this.f26548i) {
                    this.f26561f.onCompleted();
                } else if (dVar.j() && y.this.f26549j) {
                    this.f26561f.onError(dVar.e());
                } else {
                    this.f26561f.onNext(dVar);
                }
            }

            @Override // rx.f
            public void onCompleted() {
                this.f26561f.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f26561f.onError(th);
            }

            @Override // rx.j
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        c() {
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.j<? super rx.d<?>> call(rx.j<? super rx.d<?>> jVar) {
            return new a(jVar, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class d implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.e f26563f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.j f26564g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicLong f26565h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f26566i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26567j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f26568k;

        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        class a extends rx.j<Object> {
            a(rx.j jVar) {
                super(jVar);
            }

            @Override // rx.f
            public void onCompleted() {
                d.this.f26564g.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                d.this.f26564g.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                if (d.this.f26564g.isUnsubscribed()) {
                    return;
                }
                if (d.this.f26565h.get() > 0) {
                    d dVar = d.this;
                    dVar.f26566i.c(dVar.f26567j);
                } else {
                    d.this.f26568k.compareAndSet(false, true);
                }
            }

            @Override // rx.j
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        d(rx.e eVar, rx.j jVar, AtomicLong atomicLong, h.a aVar, rx.m.a aVar2, AtomicBoolean atomicBoolean) {
            this.f26563f = eVar;
            this.f26564g = jVar;
            this.f26565h = atomicLong;
            this.f26566i = aVar;
            this.f26567j = aVar2;
            this.f26568k = atomicBoolean;
        }

        @Override // rx.m.a
        public void call() {
            this.f26563f.c1(new a(this.f26564g));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class e implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicLong f26570f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.n.b.a f26571g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f26572h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f26573i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26574j;

        e(AtomicLong atomicLong, rx.n.b.a aVar, AtomicBoolean atomicBoolean, h.a aVar2, rx.m.a aVar3) {
            this.f26570f = atomicLong;
            this.f26571g = aVar;
            this.f26572h = atomicBoolean;
            this.f26573i = aVar2;
            this.f26574j = aVar3;
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 > 0) {
                rx.n.a.a.b(this.f26570f, j2);
                this.f26571g.request(j2);
                if (this.f26572h.compareAndSet(true, false)) {
                    this.f26573i.c(this.f26574j);
                }
            }
        }
    }

    private y(rx.e<T> eVar, rx.m.e<? super rx.e<? extends rx.d<?>>, ? extends rx.e<?>> eVar2, boolean z, boolean z2, rx.h hVar) {
        this.f26546g = eVar;
        this.f26547h = eVar2;
        this.f26548i = z;
        this.f26549j = z2;
        this.f26550k = hVar;
    }

    public static <T> rx.e<T> b(rx.e<T> eVar) {
        return c(eVar, f26545f);
    }

    public static <T> rx.e<T> c(rx.e<T> eVar, rx.m.e<? super rx.e<? extends rx.d<?>>, ? extends rx.e<?>> eVar2) {
        return rx.e.b1(new y(eVar, eVar2, true, false, Schedulers.trampoline()));
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        h.a createWorker = this.f26550k.createWorker();
        jVar.add(createWorker);
        rx.t.d dVar = new rx.t.d();
        jVar.add(dVar);
        rx.s.c<T, T> f1 = rx.s.a.g1().f1();
        f1.E0(rx.p.f.a());
        rx.n.b.a aVar = new rx.n.b.a();
        b bVar = new b(jVar, f1, aVar, atomicLong, dVar);
        createWorker.c(new d(this.f26547h.call(f1.W(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}
