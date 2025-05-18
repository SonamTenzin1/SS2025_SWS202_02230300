package rx.n.a;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: OperatorDebounceWithTime.java */
/* loaded from: classes3.dex */
public final class k0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    final long f26299f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f26300g;

    /* renamed from: h, reason: collision with root package name */
    final rx.h f26301h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: classes3.dex */
    public class a extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final b<T> f26302f;

        /* renamed from: g, reason: collision with root package name */
        final rx.j<?> f26303g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.t.d f26304h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f26305i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ rx.p.e f26306j;

        /* compiled from: OperatorDebounceWithTime.java */
        /* renamed from: rx.n.a.k0$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0443a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f26308f;

            C0443a(int i2) {
                this.f26308f = i2;
            }

            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                aVar.f26302f.b(this.f26308f, aVar.f26306j, aVar.f26303g);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.j jVar, rx.t.d dVar, h.a aVar, rx.p.e eVar) {
            super(jVar);
            this.f26304h = dVar;
            this.f26305i = aVar;
            this.f26306j = eVar;
            this.f26302f = new b<>();
            this.f26303g = this;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26302f.c(this.f26306j, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26306j.onError(th);
            unsubscribe();
            this.f26302f.a();
        }

        @Override // rx.f
        public void onNext(T t) {
            int d2 = this.f26302f.d(t);
            rx.t.d dVar = this.f26304h;
            h.a aVar = this.f26305i;
            C0443a c0443a = new C0443a(d2);
            k0 k0Var = k0.this;
            dVar.b(aVar.d(c0443a, k0Var.f26299f, k0Var.f26300g));
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: classes3.dex */
    static final class b<T> {
        int a;

        /* renamed from: b, reason: collision with root package name */
        T f26310b;

        /* renamed from: c, reason: collision with root package name */
        boolean f26311c;

        /* renamed from: d, reason: collision with root package name */
        boolean f26312d;

        /* renamed from: e, reason: collision with root package name */
        boolean f26313e;

        b() {
        }

        public synchronized void a() {
            this.a++;
            this.f26310b = null;
            this.f26311c = false;
        }

        public void b(int i2, rx.j<T> jVar, rx.j<?> jVar2) {
            synchronized (this) {
                if (!this.f26313e && this.f26311c && i2 == this.a) {
                    T t = this.f26310b;
                    this.f26310b = null;
                    this.f26311c = false;
                    this.f26313e = true;
                    try {
                        jVar.onNext(t);
                        synchronized (this) {
                            if (!this.f26312d) {
                                this.f26313e = false;
                            } else {
                                jVar.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, jVar2, t);
                    }
                }
            }
        }

        public void c(rx.j<T> jVar, rx.j<?> jVar2) {
            synchronized (this) {
                if (this.f26313e) {
                    this.f26312d = true;
                    return;
                }
                T t = this.f26310b;
                boolean z = this.f26311c;
                this.f26310b = null;
                this.f26311c = false;
                this.f26313e = true;
                if (z) {
                    try {
                        jVar.onNext(t);
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, jVar2, t);
                        return;
                    }
                }
                jVar.onCompleted();
            }
        }

        public synchronized int d(T t) {
            int i2;
            this.f26310b = t;
            this.f26311c = true;
            i2 = this.a + 1;
            this.a = i2;
            return i2;
        }
    }

    public k0(long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26299f = j2;
        this.f26300g = timeUnit;
        this.f26301h = hVar;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        h.a createWorker = this.f26301h.createWorker();
        rx.p.e eVar = new rx.p.e(jVar);
        rx.t.d dVar = new rx.t.d();
        eVar.add(createWorker);
        eVar.add(dVar);
        return new a(jVar, dVar, createWorker, eVar);
    }
}
