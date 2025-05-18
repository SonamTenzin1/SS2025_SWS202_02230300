package rx;

/* compiled from: Observer.java */
/* loaded from: classes.dex */
public interface f<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
