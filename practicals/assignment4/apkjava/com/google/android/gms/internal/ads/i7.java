package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class i7<T> implements zzban<T> {
    private final /* synthetic */ zzbbw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i7(zzbbw zzbbwVar) {
        this.a = zzbbwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.a.f14340b;
        atomicInteger.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.a.f14340b;
        atomicInteger.set(1);
    }
}
