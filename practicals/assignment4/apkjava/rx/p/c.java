package rx.p;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.j;

/* compiled from: SafeSubscriber.java */
/* loaded from: classes3.dex */
public class c<T> extends j<T> {

    /* renamed from: f, reason: collision with root package name */
    private final j<? super T> f26833f;

    /* renamed from: g, reason: collision with root package name */
    boolean f26834g;

    public c(j<? super T> jVar) {
        super(jVar);
        this.f26833f = jVar;
    }

    protected void c(Throwable th) {
        rx.q.f.c().b().a(th);
        try {
            this.f26833f.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                rx.q.c.j(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e2) {
            try {
                unsubscribe();
                throw e2;
            } catch (Throwable th3) {
                rx.q.c.j(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            rx.q.c.j(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                rx.q.c.j(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // rx.f
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f26834g) {
            return;
        }
        this.f26834g = true;
        try {
            this.f26833f.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                rx.exceptions.a.e(th);
                rx.q.c.j(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f26834g) {
            return;
        }
        this.f26834g = true;
        c(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        try {
            if (this.f26834g) {
                return;
            }
            this.f26833f.onNext(t);
        } catch (Throwable th) {
            rx.exceptions.a.f(th, this);
        }
    }
}
