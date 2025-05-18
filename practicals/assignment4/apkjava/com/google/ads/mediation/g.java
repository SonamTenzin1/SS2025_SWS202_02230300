package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* loaded from: classes2.dex */
final class g extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.a.zzmh;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.a.zzmi;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.a.zzmh;
                Bundle adMetadata = interstitialAd2.getAdMetadata();
                mediationRewardedVideoAdListener2 = this.a.zzmi;
                mediationRewardedVideoAdListener2.zzb(adMetadata);
            }
        }
    }
}
