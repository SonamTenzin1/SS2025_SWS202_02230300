package androidx.datastore.core.o;

import androidx.datastore.core.CorruptionException;
import java.io.IOException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

/* compiled from: ReplaceFileCorruptionHandler.kt */
/* loaded from: classes.dex */
public final class b<T> implements androidx.datastore.core.a<T> {
    private final Function1<CorruptionException, T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super CorruptionException, ? extends T> function1) {
        m.f(function1, "produceNewData");
        this.a = function1;
    }

    @Override // androidx.datastore.core.a
    public Object a(CorruptionException corruptionException, Continuation<? super T> continuation) throws IOException {
        return this.a.invoke(corruptionException);
    }
}
