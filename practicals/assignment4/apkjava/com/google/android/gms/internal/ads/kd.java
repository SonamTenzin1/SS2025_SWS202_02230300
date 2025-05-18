package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kd implements zzban<zzbph> {
    private final /* synthetic */ zzban a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbpk f12873b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kd(zzbpk zzbpkVar, zzban zzbanVar) {
        this.f12873b = zzbpkVar;
        this.a = zzbanVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.a(th);
        this.f12873b.g();
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbph zzbphVar) {
        this.f12873b.f(zzbphVar.a, this.a);
    }
}
