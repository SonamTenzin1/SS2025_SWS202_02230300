package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ez implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12547f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12548g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12549h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgr f12550i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(zzgr zzgrVar, String str, long j2, long j3) {
        this.f12550i = zzgrVar;
        this.f12547f = str;
        this.f12548g = j2;
        this.f12549h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.f12550i.f16260j;
        zzgwVar.c(this.f12547f, this.f12548g, this.f12549h);
    }
}
