package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class my implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzr f12997f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzd f12998g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public my(zzd zzdVar, zzr zzrVar) {
        this.f12998g = zzdVar;
        this.f12997f = zzrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.f12998g.f15812h;
            blockingQueue.put(this.f12997f);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
