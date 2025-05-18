package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

@zzard
/* loaded from: classes2.dex */
public final class zzags extends zzafy {

    /* renamed from: f, reason: collision with root package name */
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener f13886f;

    public zzags(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.f13886f = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void u6(zzagg zzaggVar) {
        this.f13886f.onUnifiedNativeAdLoaded(new zzagj(zzaggVar));
    }
}
