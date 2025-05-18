package rx.p;

import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observers.java */
/* loaded from: classes3.dex */
public final class a {
    private static final rx.f<Object> a = new C0465a();

    /* compiled from: Observers.java */
    /* renamed from: rx.p.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0465a implements rx.f<Object> {
        C0465a() {
        }

        @Override // rx.f
        public final void onCompleted() {
        }

        @Override // rx.f
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.f
        public final void onNext(Object obj) {
        }
    }

    public static <T> rx.f<T> a() {
        return (rx.f<T>) a;
    }
}
