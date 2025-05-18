package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.c.b.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

@zzard
/* loaded from: classes2.dex */
public final class zzapl implements MediationInterstitialAdapter {
    private Activity a;

    /* renamed from: b, reason: collision with root package name */
    private MediationInterstitialListener f14034b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f14035c;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbad.e("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbad.e("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbad.e("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f14034b = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzbad.i("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzbad.i("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f14034b.onAdFailedToLoad(this, 0);
            return;
        }
        if (!(PlatformVersion.b() && zzads.a(context))) {
            zzbad.i("Default browser does not support custom tabs. Bailing out.");
            this.f14034b.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzbad.i("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.f14034b.onAdFailedToLoad(this, 0);
        } else {
            this.a = (Activity) context;
            this.f14035c = Uri.parse(string);
            this.f14034b.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        c.c.b.c c2 = new c.a().c();
        c2.a.setData(this.f14035c);
        zzaxi.a.post(new g3(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(c2.a), null, new f3(this), null, new zzbai(0, 0, false))));
        zzk.zzlk().n();
    }
}
