package androidx.datastore.core;

import kotlin.coroutines.Continuation;

/* compiled from: CorruptionHandler.kt */
/* loaded from: classes.dex */
public interface a<T> {
    Object a(CorruptionException corruptionException, Continuation<? super T> continuation);
}
