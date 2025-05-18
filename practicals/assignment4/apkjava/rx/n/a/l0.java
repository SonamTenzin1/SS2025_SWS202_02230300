package rx.n.a;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: OperatorDelay.java */
/* loaded from: classes3.dex */
public final class l0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    final long f26319f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f26320g;

    /* renamed from: h, reason: collision with root package name */
    final rx.h f26321h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDelay.java */
    /* loaded from: classes3.dex */
    public class a extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        boolean f26322f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ h.a f26323g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26324h;

        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.n.a.l0$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0444a implements rx.m.a {
            C0444a() {
            }

            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26322f = true;
                aVar.f26324h.onCompleted();
            }
        }

        /* compiled from: OperatorDelay.java */
        /* loaded from: classes3.dex */
        class b implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Throwable f26327f;

            b(Throwable th) {
                this.f26327f = th;
            }

            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26322f = true;
                aVar.f26324h.onError(this.f26327f);
                a.this.f26323g.unsubscribe();
            }
        }

        /* compiled from: OperatorDelay.java */
        /* loaded from: classes3.dex */
        class c implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f26329f;

            c(Object obj) {
                this.f26329f = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.m.a
            public void call() {
                a aVar = a.this;
                if (aVar.f26322f) {
                    return;
                }
                aVar.f26324h.onNext(this.f26329f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.j jVar, h.a aVar, rx.j jVar2) {
            super(jVar);
            this.f26323g = aVar;
            this.f26324h = jVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            h.a aVar = this.f26323g;
            C0444a c0444a = new C0444a();
            l0 l0Var = l0.this;
            aVar.d(c0444a, l0Var.f26319f, l0Var.f26320g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26323g.c(new b(th));
        }

        @Override // rx.f
        public void onNext(T t) {
            h.a aVar = this.f26323g;
            c cVar = new c(t);
            l0 l0Var = l0.this;
            aVar.d(cVar, l0Var.f26319f, l0Var.f26320g);
        }
    }

    public l0(long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26319f = j2;
        this.f26320g = timeUnit;
        this.f26321h = hVar;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        h.a createWorker = this.f26321h.createWorker();
        jVar.add(createWorker);
        return new a(jVar, createWorker, jVar);
    }
}
