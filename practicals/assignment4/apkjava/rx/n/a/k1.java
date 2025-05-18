package rx.n.a;

import java.util.NoSuchElementException;
import rx.Single;
import rx.e;

/* compiled from: SingleFromObservable.java */
/* loaded from: classes3.dex */
public final class k1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final e.a<T> f26314f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleFromObservable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.i<? super T> f26315f;

        /* renamed from: g, reason: collision with root package name */
        T f26316g;

        /* renamed from: h, reason: collision with root package name */
        int f26317h;

        a(rx.i<? super T> iVar) {
            this.f26315f = iVar;
        }

        @Override // rx.f
        public void onCompleted() {
            int i2 = this.f26317h;
            if (i2 == 0) {
                this.f26315f.onError(new NoSuchElementException());
            } else if (i2 == 1) {
                this.f26317h = 2;
                T t = this.f26316g;
                this.f26316g = null;
                this.f26315f.c(t);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26317h == 2) {
                rx.q.c.j(th);
            } else {
                this.f26316g = null;
                this.f26315f.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            int i2 = this.f26317h;
            if (i2 == 0) {
                this.f26317h = 1;
                this.f26316g = t;
            } else if (i2 == 1) {
                this.f26317h = 2;
                this.f26315f.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public k1(e.a<T> aVar) {
        this.f26314f = aVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.b(aVar);
        this.f26314f.call(aVar);
    }
}
