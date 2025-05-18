package rx.n.a;

import java.util.NoSuchElementException;
import rx.e;

/* compiled from: OperatorSingle.java */
/* loaded from: classes3.dex */
public final class w0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    private final boolean f26528f;

    /* renamed from: g, reason: collision with root package name */
    private final T f26529g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSingle.java */
    /* loaded from: classes3.dex */
    public static final class a {
        static final w0<?> a = new w0<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSingle.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private final rx.j<? super T> f26530f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f26531g;

        /* renamed from: h, reason: collision with root package name */
        private final T f26532h;

        /* renamed from: i, reason: collision with root package name */
        private T f26533i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f26534j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f26535k;

        b(rx.j<? super T> jVar, boolean z, T t) {
            this.f26530f = jVar;
            this.f26531g = z;
            this.f26532h = t;
            request(2L);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26535k) {
                return;
            }
            if (this.f26534j) {
                this.f26530f.setProducer(new rx.n.b.c(this.f26530f, this.f26533i));
            } else if (this.f26531g) {
                this.f26530f.setProducer(new rx.n.b.c(this.f26530f, this.f26532h));
            } else {
                this.f26530f.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26535k) {
                rx.q.c.j(th);
            } else {
                this.f26530f.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26535k) {
                return;
            }
            if (this.f26534j) {
                this.f26535k = true;
                this.f26530f.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            } else {
                this.f26533i = t;
                this.f26534j = true;
            }
        }
    }

    w0() {
        this(false, null);
    }

    public static <T> w0<T> b() {
        return (w0<T>) a.a;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.f26528f, this.f26529g);
        jVar.add(bVar);
        return bVar;
    }

    private w0(boolean z, T t) {
        this.f26528f = z;
        this.f26529g = t;
    }
}
