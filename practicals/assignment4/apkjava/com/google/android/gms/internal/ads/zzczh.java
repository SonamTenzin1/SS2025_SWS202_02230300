package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzczh {
    private final E a;

    /* renamed from: b, reason: collision with root package name */
    private final List<zzbbh<?>> f15796b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzczf f15797c;

    private zzczh(zzczf zzczfVar, E e2, List<zzbbh<?>> list) {
        this.f15797c = zzczfVar;
        this.a = e2;
        this.f15796b = list;
    }

    public final <O> zzczl<O> a(Callable<O> callable) {
        zzbbl zzbblVar;
        zzbbc n = zzbar.n(this.f15796b);
        zzbbh a = n.a(eq.f12542f, zzbbm.f14331b);
        zzczf zzczfVar = this.f15797c;
        E e2 = this.a;
        List<zzbbh<?>> list = this.f15796b;
        zzbblVar = zzczfVar.f15793b;
        return new zzczl<>(zzczfVar, e2, a, list, n.a(callable, zzbblVar));
    }
}
