package rx.s;

import rx.e;
import rx.f;

/* compiled from: Subject.java */
/* loaded from: classes.dex */
public abstract class d<T, R> extends rx.e<R> implements f<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(e.a<R> aVar) {
        super(aVar);
    }

    public final c<T, R> f1() {
        if (getClass() == c.class) {
            return (c) this;
        }
        return new c<>(this);
    }
}
