package g.a.a.a;

import rx.b;
import rx.k;

/* compiled from: CompletableV2ToCompletableV1.java */
/* loaded from: classes2.dex */
final class b implements b.w {

    /* renamed from: f, reason: collision with root package name */
    final h.a.f f21411f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableV2ToCompletableV1.java */
    /* loaded from: classes2.dex */
    public static final class a implements h.a.d, k {

        /* renamed from: f, reason: collision with root package name */
        final rx.c f21412f;

        /* renamed from: g, reason: collision with root package name */
        h.a.x.c f21413g;

        a(rx.c cVar) {
            this.f21412f = cVar;
        }

        @Override // h.a.d
        public void a() {
            this.f21412f.onCompleted();
        }

        @Override // h.a.d
        public void b(h.a.x.c cVar) {
            this.f21413g = cVar;
            this.f21412f.a(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f21413g.q();
        }

        @Override // h.a.d
        public void onError(Throwable th) {
            this.f21412f.onError(th);
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f21413g.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(h.a.f fVar) {
        this.f21411f = fVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.c cVar) {
        this.f21411f.b(new a(cVar));
    }
}
