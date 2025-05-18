package rx.n.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.h;

/* compiled from: SchedulerWhen.java */
/* loaded from: classes3.dex */
public class l extends rx.h implements rx.k {

    /* renamed from: f, reason: collision with root package name */
    static final rx.k f26691f = new c();

    /* renamed from: g, reason: collision with root package name */
    static final rx.k f26692g = rx.t.e.c();

    /* renamed from: h, reason: collision with root package name */
    private final rx.h f26693h;

    /* renamed from: i, reason: collision with root package name */
    private final rx.f<rx.e<rx.b>> f26694i;

    /* renamed from: j, reason: collision with root package name */
    private final rx.k f26695j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    public class a implements rx.m.e<g, rx.b> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h.a f26696f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SchedulerWhen.java */
        /* renamed from: rx.n.c.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0461a implements b.w {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f26698f;

            C0461a(g gVar) {
                this.f26698f = gVar;
            }

            @Override // rx.m.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(rx.c cVar) {
                cVar.a(this.f26698f);
                this.f26698f.b(a.this.f26696f, cVar);
            }
        }

        a(h.a aVar) {
            this.f26696f = aVar;
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.b call(g gVar) {
            return rx.b.h(new C0461a(gVar));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    class b extends h.a {

        /* renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f26700f = new AtomicBoolean();

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ h.a f26701g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.f f26702h;

        b(h.a aVar, rx.f fVar) {
            this.f26701g = aVar;
            this.f26702h = fVar;
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            e eVar = new e(aVar);
            this.f26702h.onNext(eVar);
            return eVar;
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            d dVar = new d(aVar, j2, timeUnit);
            this.f26702h.onNext(dVar);
            return dVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26700f.get();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.f26700f.compareAndSet(false, true)) {
                this.f26701g.unsubscribe();
                this.f26702h.onCompleted();
            }
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    static class c implements rx.k {
        c() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.k
        public void unsubscribe() {
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    static class d extends g {

        /* renamed from: f, reason: collision with root package name */
        private final rx.m.a f26704f;

        /* renamed from: g, reason: collision with root package name */
        private final long f26705g;

        /* renamed from: h, reason: collision with root package name */
        private final TimeUnit f26706h;

        public d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            this.f26704f = aVar;
            this.f26705g = j2;
            this.f26706h = timeUnit;
        }

        @Override // rx.n.c.l.g
        protected rx.k c(h.a aVar, rx.c cVar) {
            return aVar.d(new f(this.f26704f, cVar), this.f26705g, this.f26706h);
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    static class e extends g {

        /* renamed from: f, reason: collision with root package name */
        private final rx.m.a f26707f;

        public e(rx.m.a aVar) {
            this.f26707f = aVar;
        }

        @Override // rx.n.c.l.g
        protected rx.k c(h.a aVar, rx.c cVar) {
            return aVar.c(new f(this.f26707f, cVar));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    static class f implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        private rx.c f26708f;

        /* renamed from: g, reason: collision with root package name */
        private rx.m.a f26709g;

        public f(rx.m.a aVar, rx.c cVar) {
            this.f26709g = aVar;
            this.f26708f = cVar;
        }

        @Override // rx.m.a
        public void call() {
            try {
                this.f26709g.call();
            } finally {
                this.f26708f.onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: classes3.dex */
    public static abstract class g extends AtomicReference<rx.k> implements rx.k {
        public g() {
            super(l.f26691f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(h.a aVar, rx.c cVar) {
            rx.k kVar;
            rx.k kVar2 = get();
            if (kVar2 != l.f26692g && kVar2 == (kVar = l.f26691f)) {
                rx.k c2 = c(aVar, cVar);
                if (compareAndSet(kVar, c2)) {
                    return;
                }
                c2.unsubscribe();
            }
        }

        protected abstract rx.k c(h.a aVar, rx.c cVar);

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            rx.k kVar;
            rx.k kVar2 = l.f26692g;
            do {
                kVar = get();
                if (kVar == l.f26692g) {
                    return;
                }
            } while (!compareAndSet(kVar, kVar2));
            if (kVar != l.f26691f) {
                kVar.unsubscribe();
            }
        }
    }

    public l(rx.m.e<rx.e<rx.e<rx.b>>, rx.b> eVar, rx.h hVar) {
        this.f26693h = hVar;
        rx.s.b g1 = rx.s.b.g1();
        this.f26694i = new rx.p.d(g1);
        this.f26695j = eVar.call(g1.m0()).H();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.h
    public h.a createWorker() {
        h.a createWorker = this.f26693h.createWorker();
        rx.n.a.b g1 = rx.n.a.b.g1();
        rx.p.d dVar = new rx.p.d(g1);
        Object X = g1.X(new a(createWorker));
        b bVar = new b(createWorker, dVar);
        this.f26694i.onNext(X);
        return bVar;
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26695j.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26695j.unsubscribe();
    }
}
