package g.a.a.a;

import rx.k;

/* compiled from: CompletableV1ToCompletableV2.java */
/* loaded from: classes2.dex */
final class a extends h.a.b {
    final rx.b a;

    /* compiled from: CompletableV1ToCompletableV2.java */
    /* renamed from: g.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0289a implements rx.c, h.a.x.c {

        /* renamed from: f, reason: collision with root package name */
        final h.a.d f21409f;

        /* renamed from: g, reason: collision with root package name */
        k f21410g;

        C0289a(h.a.d dVar) {
            this.f21409f = dVar;
        }

        @Override // rx.c
        public void a(k kVar) {
            this.f21410g = kVar;
            this.f21409f.b(this);
        }

        @Override // h.a.x.c
        public void k() {
            this.f21410g.unsubscribe();
        }

        @Override // rx.c
        public void onCompleted() {
            this.f21409f.a();
        }

        @Override // rx.c
        public void onError(Throwable th) {
            this.f21409f.onError(th);
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21410g.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(rx.b bVar) {
        this.a = bVar;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        this.a.J(new C0289a(dVar));
    }
}
