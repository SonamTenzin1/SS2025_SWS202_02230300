package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzard
/* loaded from: classes2.dex */
public final class zzadr extends zzadp {

    /* renamed from: f, reason: collision with root package name */
    private final OnCustomRenderedAdLoadedListener f13831f;

    public zzadr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f13831f = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void O2(zzadl zzadlVar) {
        this.f13831f.onCustomRenderedAdLoaded(new zzadk(zzadlVar));
    }
}
