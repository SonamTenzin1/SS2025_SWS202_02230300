package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [O] */
/* loaded from: classes2.dex */
final class kq<O> implements zzban<O> {
    private final /* synthetic */ zzcze a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzczl f12894b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kq(zzczl zzczlVar, zzcze zzczeVar) {
        this.f12894b = zzczlVar;
        this.a = zzczeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzczf.f(this.f12894b.f15803f).F(this.a, th);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void b(O o) {
        zzczf.f(this.f12894b.f15803f).B(this.a);
    }
}
