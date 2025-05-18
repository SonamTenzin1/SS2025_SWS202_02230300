package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
final class y9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbfq f13616f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y9(zzbfq zzbfqVar) {
        this.f13616f = zzbfqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzk.zzmc().f(this.f13616f);
    }
}
