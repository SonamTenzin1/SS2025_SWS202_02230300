package rx.q;

import rx.Single;
import rx.e;
import rx.k;

/* compiled from: RxJavaSingleExecutionHook.java */
/* loaded from: classes3.dex */
public abstract class h {
    @Deprecated
    public <T> Single.j<T> a(Single.j<T> jVar) {
        return jVar;
    }

    @Deprecated
    public <T, R> e.b<? extends R, ? super T> b(e.b<? extends R, ? super T> bVar) {
        return bVar;
    }

    @Deprecated
    public <T> Throwable c(Throwable th) {
        return th;
    }

    @Deprecated
    public <T> k d(k kVar) {
        return kVar;
    }

    @Deprecated
    public <T> e.a<T> e(Single<? extends T> single, e.a<T> aVar) {
        return aVar;
    }
}
