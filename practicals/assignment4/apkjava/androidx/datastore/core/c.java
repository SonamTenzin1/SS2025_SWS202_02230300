package androidx.datastore.core;

import kotlin.coroutines.Continuation;
import kotlin.u;

/* compiled from: DataMigration.kt */
/* loaded from: classes.dex */
public interface c<T> {
    Object a(Continuation<? super u> continuation);

    Object b(T t, Continuation<? super Boolean> continuation);

    Object c(T t, Continuation<? super T> continuation);
}
