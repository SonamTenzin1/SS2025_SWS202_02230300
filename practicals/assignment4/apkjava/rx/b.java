package rx;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.e;
import rx.exceptions.CompositeException;
import rx.h;
import rx.schedulers.Schedulers;

/* compiled from: Completable.java */
/* loaded from: classes.dex */
public class b {
    static final b a = new b(new f(), false);

    /* renamed from: b, reason: collision with root package name */
    static final b f26004b = new b(new m(), false);

    /* renamed from: c, reason: collision with root package name */
    private final w f26005c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public static class a implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.e f26006f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0430a extends rx.j<Object> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.c f26007f;

            C0430a(rx.c cVar) {
                this.f26007f = cVar;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f26007f.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f26007f.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
            }
        }

        a(rx.e eVar) {
            this.f26006f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            C0430a c0430a = new C0430a(cVar);
            cVar.a(c0430a);
            this.f26006f.c1(c0430a);
        }
    }

    /* compiled from: Completable.java */
    /* renamed from: rx.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0431b implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Single f26009f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$b$a */
        /* loaded from: classes3.dex */
        public class a extends rx.i<Object> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.c f26010g;

            a(rx.c cVar) {
                this.f26010g = cVar;
            }

            @Override // rx.i
            public void c(Object obj) {
                this.f26010g.onCompleted();
            }

            @Override // rx.i
            public void onError(Throwable th) {
                this.f26010g.onError(th);
            }
        }

        C0431b(Single single) {
            this.f26009f = single;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            a aVar = new a(cVar);
            cVar.a(aVar);
            this.f26009f.t(aVar);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class c implements rx.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f26012f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Throwable[] f26013g;

        c(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f26012f = countDownLatch;
            this.f26013g = thArr;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
        }

        @Override // rx.c
        public void onCompleted() {
            this.f26012f.countDown();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.f26013g[0] = th;
            this.f26012f.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class d implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h f26015f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f26016g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TimeUnit f26017h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f26018i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.t.b f26020f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h.a f26021g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ rx.c f26022h;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0432a implements rx.m.a {
                C0432a() {
                }

                @Override // rx.m.a
                public void call() {
                    try {
                        a.this.f26022h.onCompleted();
                    } finally {
                        a.this.f26021g.unsubscribe();
                    }
                }
            }

            /* compiled from: Completable.java */
            /* renamed from: rx.b$d$a$b, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0433b implements rx.m.a {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Throwable f26025f;

                C0433b(Throwable th) {
                    this.f26025f = th;
                }

                @Override // rx.m.a
                public void call() {
                    try {
                        a.this.f26022h.onError(this.f26025f);
                    } finally {
                        a.this.f26021g.unsubscribe();
                    }
                }
            }

            a(rx.t.b bVar, h.a aVar, rx.c cVar) {
                this.f26020f = bVar;
                this.f26021g = aVar;
                this.f26022h = cVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                this.f26020f.a(kVar);
                this.f26022h.a(this.f26020f);
            }

            @Override // rx.c
            public void onCompleted() {
                rx.t.b bVar = this.f26020f;
                h.a aVar = this.f26021g;
                C0432a c0432a = new C0432a();
                d dVar = d.this;
                bVar.a(aVar.d(c0432a, dVar.f26016g, dVar.f26017h));
            }

            @Override // rx.c
            public void onError(Throwable th) {
                if (d.this.f26018i) {
                    rx.t.b bVar = this.f26020f;
                    h.a aVar = this.f26021g;
                    C0433b c0433b = new C0433b(th);
                    d dVar = d.this;
                    bVar.a(aVar.d(c0433b, dVar.f26016g, dVar.f26017h));
                    return;
                }
                this.f26022h.onError(th);
            }
        }

        d(rx.h hVar, long j2, TimeUnit timeUnit, boolean z) {
            this.f26015f = hVar;
            this.f26016g = j2;
            this.f26017h = timeUnit;
            this.f26018i = z;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            rx.t.b bVar = new rx.t.b();
            h.a createWorker = this.f26015f.createWorker();
            bVar.a(createWorker);
            b.this.P(new a(bVar, createWorker, cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class e implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26027f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26028g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.m.b f26029h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.m.b f26030i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26031j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.c f26033f;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0434a implements rx.m.a {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ rx.k f26035f;

                C0434a(rx.k kVar) {
                    this.f26035f = kVar;
                }

                @Override // rx.m.a
                public void call() {
                    try {
                        e.this.f26031j.call();
                    } catch (Throwable th) {
                        rx.q.c.j(th);
                    }
                    this.f26035f.unsubscribe();
                }
            }

            a(rx.c cVar) {
                this.f26033f = cVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                try {
                    e.this.f26030i.call(kVar);
                    this.f26033f.a(rx.t.e.a(new C0434a(kVar)));
                } catch (Throwable th) {
                    kVar.unsubscribe();
                    this.f26033f.a(rx.t.e.c());
                    this.f26033f.onError(th);
                }
            }

            @Override // rx.c
            public void onCompleted() {
                try {
                    e.this.f26027f.call();
                    this.f26033f.onCompleted();
                    try {
                        e.this.f26028g.call();
                    } catch (Throwable th) {
                        rx.q.c.j(th);
                    }
                } catch (Throwable th2) {
                    this.f26033f.onError(th2);
                }
            }

            @Override // rx.c
            public void onError(Throwable th) {
                try {
                    e.this.f26029h.call(th);
                } catch (Throwable th2) {
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                this.f26033f.onError(th);
                try {
                    e.this.f26028g.call();
                } catch (Throwable th3) {
                    rx.q.c.j(th3);
                }
            }
        }

        e(rx.m.a aVar, rx.m.a aVar2, rx.m.b bVar, rx.m.b bVar2, rx.m.a aVar3) {
            this.f26027f = aVar;
            this.f26028g = aVar2;
            this.f26029h = bVar;
            this.f26030i = bVar2;
            this.f26031j = aVar3;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            b.this.P(new a(cVar));
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class f implements w {
        f() {
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            cVar.a(rx.t.e.c());
            cVar.onCompleted();
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class g implements rx.m.b<Throwable> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26037f;

        g(rx.m.a aVar) {
            this.f26037f = aVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            this.f26037f.call();
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class h implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h f26039f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ h.a f26041f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.c f26042g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ rx.n.e.l f26043h;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0435a implements rx.m.a {
                C0435a() {
                }

                @Override // rx.m.a
                public void call() {
                    try {
                        a.this.f26042g.onCompleted();
                    } finally {
                        a.this.f26043h.unsubscribe();
                    }
                }
            }

            /* compiled from: Completable.java */
            /* renamed from: rx.b$h$a$b, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0436b implements rx.m.a {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Throwable f26046f;

                C0436b(Throwable th) {
                    this.f26046f = th;
                }

                @Override // rx.m.a
                public void call() {
                    try {
                        a.this.f26042g.onError(this.f26046f);
                    } finally {
                        a.this.f26043h.unsubscribe();
                    }
                }
            }

            a(h.a aVar, rx.c cVar, rx.n.e.l lVar) {
                this.f26041f = aVar;
                this.f26042g = cVar;
                this.f26043h = lVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                this.f26043h.a(kVar);
            }

            @Override // rx.c
            public void onCompleted() {
                this.f26041f.c(new C0435a());
            }

            @Override // rx.c
            public void onError(Throwable th) {
                this.f26041f.c(new C0436b(th));
            }
        }

        h(rx.h hVar) {
            this.f26039f = hVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            rx.n.e.l lVar = new rx.n.e.l();
            h.a createWorker = this.f26039f.createWorker();
            lVar.a(createWorker);
            cVar.a(lVar);
            b.this.P(new a(createWorker, cVar, lVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class i implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26048f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.c f26050f;

            a(rx.c cVar) {
                this.f26050f = cVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                this.f26050f.a(kVar);
            }

            @Override // rx.c
            public void onCompleted() {
                this.f26050f.onCompleted();
            }

            @Override // rx.c
            public void onError(Throwable th) {
                boolean z = false;
                try {
                    z = ((Boolean) i.this.f26048f.call(th)).booleanValue();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                if (z) {
                    this.f26050f.onCompleted();
                } else {
                    this.f26050f.onError(th);
                }
            }
        }

        i(rx.m.e eVar) {
            this.f26048f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            b.this.P(new a(cVar));
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class j implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26052f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.c f26054f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.t.d f26055g;

            /* compiled from: Completable.java */
            /* renamed from: rx.b$j$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0437a implements rx.c {
                C0437a() {
                }

                @Override // rx.c
                public void a(rx.k kVar) {
                    a.this.f26055g.b(kVar);
                }

                @Override // rx.c
                public void onCompleted() {
                    a.this.f26054f.onCompleted();
                }

                @Override // rx.c
                public void onError(Throwable th) {
                    a.this.f26054f.onError(th);
                }
            }

            a(rx.c cVar, rx.t.d dVar) {
                this.f26054f = cVar;
                this.f26055g = dVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                this.f26055g.b(kVar);
            }

            @Override // rx.c
            public void onCompleted() {
                this.f26054f.onCompleted();
            }

            @Override // rx.c
            public void onError(Throwable th) {
                try {
                    b bVar = (b) j.this.f26052f.call(th);
                    if (bVar == null) {
                        this.f26054f.onError(new CompositeException(Arrays.asList(th, new NullPointerException("The completable returned is null"))));
                    } else {
                        bVar.P(new C0437a());
                    }
                } catch (Throwable th2) {
                    this.f26054f.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        j(rx.m.e eVar) {
            this.f26052f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            rx.t.d dVar = new rx.t.d();
            cVar.a(dVar);
            b.this.P(new a(cVar, dVar));
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class k implements rx.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.t.c f26058f;

        k(rx.t.c cVar) {
            this.f26058f = cVar;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
            this.f26058f.a(kVar);
        }

        @Override // rx.c
        public void onCompleted() {
            this.f26058f.unsubscribe();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            rx.q.c.j(th);
            this.f26058f.unsubscribe();
            b.l(th);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class l implements rx.c {

        /* renamed from: f, reason: collision with root package name */
        boolean f26060f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26061g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.t.c f26062h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.m.b f26063i;

        l(rx.m.a aVar, rx.t.c cVar, rx.m.b bVar) {
            this.f26061g = aVar;
            this.f26062h = cVar;
            this.f26063i = bVar;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
            this.f26062h.a(kVar);
        }

        void b(Throwable th) {
            try {
                this.f26063i.call(th);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.c
        public void onCompleted() {
            if (this.f26060f) {
                return;
            }
            this.f26060f = true;
            try {
                this.f26061g.call();
                this.f26062h.unsubscribe();
            } catch (Throwable th) {
                b(th);
            }
        }

        @Override // rx.c
        public void onError(Throwable th) {
            if (!this.f26060f) {
                this.f26060f = true;
                b(th);
            } else {
                rx.q.c.j(th);
                b.l(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class m implements w {
        m() {
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            cVar.a(rx.t.e.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class n implements rx.c {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.j f26065f;

        n(rx.j jVar) {
            this.f26065f = jVar;
        }

        @Override // rx.c
        public void a(rx.k kVar) {
            this.f26065f.add(kVar);
        }

        @Override // rx.c
        public void onCompleted() {
            this.f26065f.onCompleted();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.f26065f.onError(th);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class o implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h f26067f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.c f26069f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h.a f26070g;

            a(rx.c cVar, h.a aVar) {
                this.f26069f = cVar;
                this.f26070g = aVar;
            }

            @Override // rx.m.a
            public void call() {
                try {
                    b.this.P(this.f26069f);
                } finally {
                    this.f26070g.unsubscribe();
                }
            }
        }

        o(rx.h hVar) {
            this.f26067f = hVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            h.a createWorker = this.f26067f.createWorker();
            createWorker.c(new a(cVar, createWorker));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class p<T> implements e.a<T> {
        p() {
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            b.this.Q(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class q<T> implements Single.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.d f26073f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.c {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.i f26075f;

            a(rx.i iVar) {
                this.f26075f = iVar;
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                this.f26075f.b(kVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.c
            public void onCompleted() {
                try {
                    Object call = q.this.f26073f.call();
                    if (call == null) {
                        this.f26075f.onError(new NullPointerException("The value supplied is null"));
                    } else {
                        this.f26075f.c(call);
                    }
                } catch (Throwable th) {
                    this.f26075f.onError(th);
                }
            }

            @Override // rx.c
            public void onError(Throwable th) {
                this.f26075f.onError(th);
            }
        }

        q(rx.m.d dVar) {
            this.f26073f = dVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            b.this.P(new a(iVar));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class r<T> implements rx.m.d<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f26077f;

        r(Object obj) {
            this.f26077f = obj;
        }

        @Override // rx.m.d, java.util.concurrent.Callable
        public T call() {
            return (T) this.f26077f;
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class s implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.d f26079f;

        s(rx.m.d dVar) {
            this.f26079f = dVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            try {
                b bVar = (b) this.f26079f.call();
                if (bVar == null) {
                    cVar.a(rx.t.e.c());
                    cVar.onError(new NullPointerException("The completable returned is null"));
                } else {
                    bVar.P(cVar);
                }
            } catch (Throwable th) {
                cVar.a(rx.t.e.c());
                cVar.onError(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class t implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Throwable f26080f;

        t(Throwable th) {
            this.f26080f = th;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            cVar.a(rx.t.e.c());
            cVar.onError(this.f26080f);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class u implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.a f26081f;

        u(rx.m.a aVar) {
            this.f26081f = aVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            rx.t.a aVar = new rx.t.a();
            cVar.a(aVar);
            try {
                this.f26081f.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                cVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                cVar.onError(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class v implements w {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Callable f26082f;

        v(Callable callable) {
            this.f26082f = callable;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.c cVar) {
            rx.t.a aVar = new rx.t.a();
            cVar.a(aVar);
            try {
                this.f26082f.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                cVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                cVar.onError(th);
            }
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public interface w extends rx.m.b<rx.c> {
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public interface x extends rx.m.e<rx.c, rx.c> {
    }

    protected b(w wVar) {
        this.f26005c = rx.q.c.g(wVar);
    }

    static <T> T D(T t2) {
        t2.getClass();
        return t2;
    }

    static NullPointerException L(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    private <T> void R(rx.j<T> jVar, boolean z) {
        D(jVar);
        if (z) {
            try {
                jVar.onStart();
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                Throwable m2 = rx.q.c.m(th);
                rx.q.c.j(m2);
                throw L(m2);
            }
        }
        P(new n(jVar));
        rx.q.c.o(jVar);
    }

    public static b e() {
        b bVar = a;
        w g2 = rx.q.c.g(bVar.f26005c);
        return g2 == bVar.f26005c ? bVar : new b(g2, false);
    }

    public static b f(b... bVarArr) {
        D(bVarArr);
        if (bVarArr.length == 0) {
            return e();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return h(new rx.n.a.d(bVarArr));
    }

    public static b h(w wVar) {
        D(wVar);
        try {
            return new b(wVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            rx.q.c.j(th);
            throw L(th);
        }
    }

    public static b i(rx.m.d<? extends b> dVar) {
        D(dVar);
        return h(new s(dVar));
    }

    static void l(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static b s(Throwable th) {
        D(th);
        return h(new t(th));
    }

    public static b t(rx.m.a aVar) {
        D(aVar);
        return h(new u(aVar));
    }

    public static b u(Callable<?> callable) {
        D(callable);
        return h(new v(callable));
    }

    public static b v(rx.e<?> eVar) {
        D(eVar);
        return h(new a(eVar));
    }

    public static b w(Single<?> single) {
        D(single);
        return h(new C0431b(single));
    }

    public static b x(b... bVarArr) {
        D(bVarArr);
        return h(new rx.n.a.f(bVarArr));
    }

    public static b y() {
        b bVar = f26004b;
        w g2 = rx.q.c.g(bVar.f26005c);
        return g2 == bVar.f26005c ? bVar : new b(g2, false);
    }

    public final b A() {
        return B(rx.n.e.m.a());
    }

    public final b B(rx.m.e<? super Throwable, Boolean> eVar) {
        D(eVar);
        return h(new i(eVar));
    }

    public final b C(rx.m.e<? super Throwable, ? extends b> eVar) {
        D(eVar);
        return h(new j(eVar));
    }

    public final b E() {
        return v(M().s0());
    }

    public final b F(rx.m.e<? super rx.e<? extends Throwable>, ? extends rx.e<?>> eVar) {
        return v(M().t0(eVar));
    }

    public final b G(b bVar) {
        D(bVar);
        return f(bVar, this);
    }

    public final rx.k H() {
        rx.t.c cVar = new rx.t.c();
        P(new k(cVar));
        return cVar;
    }

    public final rx.k I(rx.m.a aVar, rx.m.b<? super Throwable> bVar) {
        D(aVar);
        D(bVar);
        rx.t.c cVar = new rx.t.c();
        P(new l(aVar, cVar, bVar));
        return cVar;
    }

    public final void J(rx.c cVar) {
        if (!(cVar instanceof rx.p.b)) {
            cVar = new rx.p.b(cVar);
        }
        P(cVar);
    }

    public final b K(rx.h hVar) {
        D(hVar);
        return h(new o(hVar));
    }

    public final <T> rx.e<T> M() {
        return rx.e.b1(new p());
    }

    public final <T> Single<T> N(rx.m.d<? extends T> dVar) {
        D(dVar);
        return Single.b(new q(dVar));
    }

    public final <T> Single<T> O(T t2) {
        D(t2);
        return N(new r(t2));
    }

    public final void P(rx.c cVar) {
        D(cVar);
        try {
            rx.q.c.e(this, this.f26005c).call(cVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            Throwable d2 = rx.q.c.d(th);
            rx.q.c.j(d2);
            throw L(d2);
        }
    }

    public final <T> void Q(rx.j<T> jVar) {
        R(jVar, true);
    }

    public final b a(b bVar) {
        return g(bVar);
    }

    public final <T> rx.e<T> b(rx.e<T> eVar) {
        D(eVar);
        return eVar.s(M());
    }

    public final <T> Single<T> c(Single<T> single) {
        D(single);
        return single.d(M());
    }

    public final void d() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        P(new c(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                rx.exceptions.a.c(thArr[0]);
            }
        } else {
            try {
                countDownLatch.await();
                if (thArr[0] != null) {
                    rx.exceptions.a.c(thArr[0]);
                }
            } catch (InterruptedException e2) {
                throw rx.exceptions.a.c(e2);
            }
        }
    }

    public final b g(b bVar) {
        D(bVar);
        return f(this, bVar);
    }

    public final b j(long j2, TimeUnit timeUnit) {
        return k(j2, timeUnit, Schedulers.computation(), false);
    }

    public final b k(long j2, TimeUnit timeUnit, rx.h hVar, boolean z) {
        D(timeUnit);
        D(hVar);
        return h(new d(hVar, j2, timeUnit, z));
    }

    public final b m(rx.m.a aVar) {
        return o(rx.m.c.a(), rx.m.c.a(), aVar, rx.m.c.a(), rx.m.c.a());
    }

    public final b n(rx.m.b<? super Throwable> bVar) {
        return o(rx.m.c.a(), bVar, rx.m.c.a(), rx.m.c.a(), rx.m.c.a());
    }

    protected final b o(rx.m.b<? super rx.k> bVar, rx.m.b<? super Throwable> bVar2, rx.m.a aVar, rx.m.a aVar2, rx.m.a aVar3) {
        D(bVar);
        D(bVar2);
        D(aVar);
        D(aVar2);
        D(aVar3);
        return h(new e(aVar, aVar2, bVar2, bVar, aVar3));
    }

    public final b p(rx.m.b<? super rx.k> bVar) {
        return o(bVar, rx.m.c.a(), rx.m.c.a(), rx.m.c.a(), rx.m.c.a());
    }

    public final b q(rx.m.a aVar) {
        return o(rx.m.c.a(), new g(aVar), aVar, rx.m.c.a(), rx.m.c.a());
    }

    public final b r(rx.m.a aVar) {
        return o(rx.m.c.a(), rx.m.c.a(), rx.m.c.a(), rx.m.c.a(), aVar);
    }

    public final b z(rx.h hVar) {
        D(hVar);
        return h(new h(hVar));
    }

    protected b(w wVar, boolean z) {
        this.f26005c = z ? rx.q.c.g(wVar) : wVar;
    }
}
