package androidx.datastore.core;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
final class g<T> extends m<T> {
    private final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Throwable th) {
        super(null);
        kotlin.jvm.internal.m.f(th, "finalException");
        this.a = th;
    }

    public final Throwable a() {
        return this.a;
    }
}
