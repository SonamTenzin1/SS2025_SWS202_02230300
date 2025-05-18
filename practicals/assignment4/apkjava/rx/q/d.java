package rx.q;

import rx.e;
import rx.k;

/* compiled from: RxJavaObservableExecutionHook.java */
/* loaded from: classes3.dex */
public abstract class d {
    @Deprecated
    public <T> e.a<T> onCreate(e.a<T> aVar) {
        return aVar;
    }

    @Deprecated
    public <T, R> e.b<? extends R, ? super T> onLift(e.b<? extends R, ? super T> bVar) {
        return bVar;
    }

    @Deprecated
    public <T> Throwable onSubscribeError(Throwable th) {
        return th;
    }

    @Deprecated
    public <T> k onSubscribeReturn(k kVar) {
        return kVar;
    }

    @Deprecated
    public <T> e.a<T> onSubscribeStart(rx.e<? extends T> eVar, e.a<T> aVar) {
        return aVar;
    }
}
