package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* loaded from: classes2.dex */
final class x implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ PublisherAdView f13534f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzzk f13535g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzagq f13536h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(zzagq zzagqVar, PublisherAdView publisherAdView, zzzk zzzkVar) {
        this.f13536h = zzagqVar;
        this.f13534f = publisherAdView;
        this.f13535g = zzzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (this.f13534f.zza(this.f13535g)) {
            onPublisherAdViewLoadedListener = this.f13536h.f13885f;
            onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.f13534f);
        } else {
            zzbad.i("Could not bind.");
        }
    }
}
