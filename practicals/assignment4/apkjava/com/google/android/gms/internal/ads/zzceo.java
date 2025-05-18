package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzceo implements zzdti<Set<zzbuz<zzczz>>> {
    private final zzdtu<Executor> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcex> f15146b;

    private zzceo(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15146b = zzdtuVar2;
    }

    public static zzceo a(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        return new zzceo(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set emptySet;
        Executor executor = this.a.get();
        zzcex zzcexVar = this.f15146b.get();
        if (((Boolean) zzyt.e().c(zzacu.S3)).booleanValue()) {
            emptySet = Collections.singleton(new zzbuz(zzcexVar, executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdto.b(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
