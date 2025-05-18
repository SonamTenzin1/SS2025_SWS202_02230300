package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzard
/* loaded from: classes2.dex */
public final class zzagp extends zzafs {

    /* renamed from: f, reason: collision with root package name */
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener f13884f;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f13884f = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void M4(zzafe zzafeVar) {
        this.f13884f.onCustomTemplateAdLoaded(zzafh.a(zzafeVar));
    }
}
