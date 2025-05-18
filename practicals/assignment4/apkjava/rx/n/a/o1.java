package rx.n.a;

import rx.Single;

/* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class o1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final Single<? extends T> f26366f;

    /* renamed from: g, reason: collision with root package name */
    final rx.e<?> f26367g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    public class a extends rx.i<T> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.i f26368g;

        a(rx.i iVar) {
            this.f26368g = iVar;
        }

        @Override // rx.i
        public void c(T t) {
            this.f26368g.c(t);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.f26368g.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnSubscribeDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    public class b extends rx.j<Object> {

        /* renamed from: f, reason: collision with root package name */
        boolean f26370f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.i f26371g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.t.d f26372h;

        b(rx.i iVar, rx.t.d dVar) {
            this.f26371g = iVar;
            this.f26372h = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26370f) {
                return;
            }
            this.f26370f = true;
            this.f26372h.b(this.f26371g);
            o1.this.f26366f.t(this.f26371g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26370f) {
                rx.q.c.j(th);
            } else {
                this.f26370f = true;
                this.f26371g.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(Object obj) {
            onCompleted();
        }
    }

    public o1(Single<? extends T> single, rx.e<?> eVar) {
        this.f26366f = single;
        this.f26367g = eVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar);
        rx.t.d dVar = new rx.t.d();
        iVar.b(dVar);
        b bVar = new b(aVar, dVar);
        dVar.b(bVar);
        this.f26367g.E0(bVar);
    }
}
