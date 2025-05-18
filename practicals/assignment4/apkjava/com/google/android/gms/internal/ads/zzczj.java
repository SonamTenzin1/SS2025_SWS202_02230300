package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzczj {
    private final E a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzczf f15798b;

    private zzczj(zzczf zzczfVar, E e2) {
        this.f15798b = zzczfVar;
        this.a = e2;
    }

    private final <O> zzczl<O> b(Callable<O> callable, zzbbl zzbblVar) {
        zzbbh zzbbhVar;
        zzczf zzczfVar = this.f15798b;
        E e2 = this.a;
        zzbbhVar = zzczf.a;
        return new zzczl<>(zzczfVar, e2, zzbbhVar, Collections.emptyList(), zzbblVar.submit(callable));
    }

    public final zzczl<?> a(final zzczd zzczdVar, zzbbl zzbblVar) {
        return b(new Callable(zzczdVar) { // from class: com.google.android.gms.internal.ads.fq

            /* renamed from: f, reason: collision with root package name */
            private final zzczd f12605f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12605f = zzczdVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f12605f.run();
                return null;
            }
        }, zzbblVar);
    }

    public final <O> zzczl<O> c(zzbbh<O> zzbbhVar) {
        zzbbh zzbbhVar2;
        zzczf zzczfVar = this.f15798b;
        E e2 = this.a;
        zzbbhVar2 = zzczf.a;
        return new zzczl<>(zzczfVar, e2, zzbbhVar2, Collections.emptyList(), zzbbhVar);
    }

    public final <O> zzczl<O> d(Callable<O> callable) {
        zzbbl zzbblVar;
        zzbblVar = this.f15798b.f15793b;
        return b(callable, zzbblVar);
    }
}
