package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* loaded from: classes2.dex */
final class pm implements zzf {
    private final /* synthetic */ zzbbr a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcxu f13178b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzcxm f13179c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzcoz f13180d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzcor f13181e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pm(zzcor zzcorVar, zzbbr zzbbrVar, zzcxu zzcxuVar, zzcxm zzcxmVar, zzcoz zzcozVar) {
        this.f13181e = zzcorVar;
        this.a = zzbbrVar;
        this.f13178b = zzcxuVar;
        this.f13179c = zzcxmVar;
        this.f13180d = zzcozVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzg(View view) {
        zzcou zzcouVar;
        zzbbr zzbbrVar = this.a;
        zzcouVar = this.f13181e.f15483d;
        zzbbrVar.a(zzcouVar.a(this.f13178b, this.f13179c, view, this.f13180d));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzky() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzkz() {
    }
}
