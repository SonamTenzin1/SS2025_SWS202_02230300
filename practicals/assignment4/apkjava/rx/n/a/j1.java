package rx.n.a;

import java.util.concurrent.Callable;
import rx.Single;

/* compiled from: SingleFromCallable.java */
/* loaded from: classes3.dex */
public final class j1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final Callable<? extends T> f26281f;

    public j1(Callable<? extends T> callable) {
        this.f26281f = callable;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        try {
            iVar.c(this.f26281f.call());
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            iVar.onError(th);
        }
    }
}
