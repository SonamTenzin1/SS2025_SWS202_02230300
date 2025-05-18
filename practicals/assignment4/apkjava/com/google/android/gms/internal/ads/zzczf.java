package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public abstract class zzczf<E> {
    private static final zzbbh<?> a = zzbar.o(null);

    /* renamed from: b */
    private final zzbbl f15793b;

    /* renamed from: c */
    private final ScheduledExecutorService f15794c;

    /* renamed from: d */
    private final zzczr<E> f15795d;

    public zzczf(zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, zzczr<E> zzczrVar) {
        this.f15793b = zzbblVar;
        this.f15794c = scheduledExecutorService;
        this.f15795d = zzczrVar;
    }

    public static /* synthetic */ zzczr f(zzczf zzczfVar) {
        return zzczfVar.f15795d;
    }

    public final zzczh b(E e2, zzbbh<?>... zzbbhVarArr) {
        return new zzczh(this, e2, Arrays.asList(zzbbhVarArr));
    }

    public final <I> zzczl<I> c(E e2, zzbbh<I> zzbbhVar) {
        return new zzczl<>(this, e2, zzbbhVar, Collections.singletonList(zzbbhVar), zzbbhVar);
    }

    public final zzczj g(E e2) {
        return new zzczj(this, e2);
    }

    public abstract String h(E e2);
}
