package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcfb implements zzbro, zzbsr, zzbtk {

    /* renamed from: f, reason: collision with root package name */
    private final zzcfi f15158f;

    /* renamed from: g, reason: collision with root package name */
    private final String f15159g = (String) zzyt.e().c(zzacu.f0);

    /* renamed from: h, reason: collision with root package name */
    private final zzdae f15160h;

    public zzcfb(zzcfi zzcfiVar, zzdae zzdaeVar) {
        this.f15158f = zzcfiVar;
        this.f15160h = zzdaeVar;
    }

    private final void a(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.f15159g).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (((Boolean) zzyt.e().c(zzacu.e0)).booleanValue()) {
            this.f15160h.e(uri);
        }
        zzawz.m(uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void N(zzarx zzarxVar) {
        this.f15158f.b(zzarxVar.f14104f);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i2) {
        a(this.f15158f.c());
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        a(this.f15158f.c());
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void q(zzcxu zzcxuVar) {
        this.f15158f.a(zzcxuVar);
    }
}
