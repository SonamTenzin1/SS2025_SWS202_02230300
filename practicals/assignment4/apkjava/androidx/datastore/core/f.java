package androidx.datastore.core;

import java.io.File;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DataStoreFactory.kt */
/* loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final <T> e<T> a(j<T> jVar, androidx.datastore.core.o.b<T> bVar, List<? extends c<T>> list, CoroutineScope coroutineScope, Function0<? extends File> function0) {
        List e2;
        kotlin.jvm.internal.m.f(jVar, "serializer");
        kotlin.jvm.internal.m.f(list, "migrations");
        kotlin.jvm.internal.m.f(coroutineScope, "scope");
        kotlin.jvm.internal.m.f(function0, "produceFile");
        if (bVar == null) {
            bVar = (androidx.datastore.core.o.b<T>) new androidx.datastore.core.o.a();
        }
        androidx.datastore.core.o.b<T> bVar2 = bVar;
        e2 = t.e(d.a.b(list));
        return new l(function0, jVar, e2, bVar2, coroutineScope);
    }
}
