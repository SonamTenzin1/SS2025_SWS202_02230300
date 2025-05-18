package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzard
/* loaded from: classes2.dex */
public final class zzxy extends zzzq {

    /* renamed from: f, reason: collision with root package name */
    private final AdMetadataListener f16967f;

    public zzxy(AdMetadataListener adMetadataListener) {
        this.f16967f = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.f16967f;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
