package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends zzyv {

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzabb f12206c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzabb zzabbVar) {
        this.f12206c = zzabbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i2) {
        VideoController videoController;
        videoController = this.f12206c.f13754d;
        videoController.zza(this.f12206c.D());
        super.onAdFailedToLoad(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.f12206c.f13754d;
        videoController.zza(this.f12206c.D());
        super.onAdLoaded();
    }
}
