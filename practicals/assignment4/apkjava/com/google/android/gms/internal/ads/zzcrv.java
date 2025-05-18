package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcrv implements zzcva<zzcuz<Bundle>> {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final zzawm f15582b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrv(Executor executor, zzawm zzawmVar) {
        this.a = executor;
        this.f15582b = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> b() {
        if (((Boolean) zzyt.e().c(zzacu.p2)).booleanValue()) {
            return zzbar.o(null);
        }
        return zzbar.d(this.f15582b.s(), un.a, this.a);
    }
}
