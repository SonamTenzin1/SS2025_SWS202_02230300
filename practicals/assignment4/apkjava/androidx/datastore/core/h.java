package androidx.datastore.core;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: InitializerApi.kt */
/* loaded from: classes.dex */
public interface h<T> {
    Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);
}
