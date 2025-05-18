package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

@zzard
/* loaded from: classes2.dex */
public final class zzagn extends zzafm {

    /* renamed from: f, reason: collision with root package name */
    private final NativeContentAd.OnContentAdLoadedListener f13882f;

    public zzagn(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f13882f = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafl
    public final void t2(zzafa zzafaVar) {
        this.f13882f.onContentAdLoaded(new zzafd(zzafaVar));
    }
}
