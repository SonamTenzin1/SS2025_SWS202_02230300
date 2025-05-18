package rx.n.a;

import rx.e;

/* compiled from: OperatorSkipWhile.java */
/* loaded from: classes3.dex */
public final class y0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    final rx.m.f<? super T, Integer, Boolean> f26576f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipWhile.java */
    /* loaded from: classes3.dex */
    public class a extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        boolean f26577f;

        /* renamed from: g, reason: collision with root package name */
        int f26578g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.j f26579h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.j jVar, rx.j jVar2) {
            super(jVar);
            this.f26579h = jVar2;
            this.f26577f = true;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26579h.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26579h.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (!this.f26577f) {
                this.f26579h.onNext(t);
                return;
            }
            try {
                rx.m.f<? super T, Integer, Boolean> fVar = y0.this.f26576f;
                int i2 = this.f26578g;
                this.f26578g = i2 + 1;
                if (!fVar.a(t, Integer.valueOf(i2)).booleanValue()) {
                    this.f26577f = false;
                    this.f26579h.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f26579h, t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSkipWhile.java */
    /* loaded from: classes3.dex */
    public static class b implements rx.m.f<T, Integer, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26581f;

        b(rx.m.e eVar) {
            this.f26581f = eVar;
        }

        @Override // rx.m.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(T t, Integer num) {
            return (Boolean) this.f26581f.call(t);
        }
    }

    public y0(rx.m.f<? super T, Integer, Boolean> fVar) {
        this.f26576f = fVar;
    }

    public static <T> rx.m.f<T, Integer, Boolean> b(rx.m.e<? super T, Boolean> eVar) {
        return new b(eVar);
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        return new a(jVar, jVar);
    }
}
