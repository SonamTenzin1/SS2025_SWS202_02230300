package rx.n.a;

import java.util.NoSuchElementException;
import rx.Single;

/* compiled from: OnSubscribeSingle.java */
/* loaded from: classes3.dex */
public class a0<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    private final rx.e<T> f26106f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSingle.java */
    /* loaded from: classes3.dex */
    public class a extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private boolean f26107f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f26108g;

        /* renamed from: h, reason: collision with root package name */
        private T f26109h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.i f26110i;

        a(rx.i iVar) {
            this.f26110i = iVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26107f) {
                return;
            }
            if (this.f26108g) {
                this.f26110i.c(this.f26109h);
            } else {
                this.f26110i.onError(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26110i.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26108g) {
                this.f26107f = true;
                this.f26110i.onError(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
            } else {
                this.f26108g = true;
                this.f26109h = t;
            }
        }

        @Override // rx.j
        public void onStart() {
            request(2L);
        }
    }

    public a0(rx.e<T> eVar) {
        this.f26106f = eVar;
    }

    public static <T> a0<T> b(rx.e<T> eVar) {
        return new a0<>(eVar);
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.b(aVar);
        this.f26106f.c1(aVar);
    }
}
