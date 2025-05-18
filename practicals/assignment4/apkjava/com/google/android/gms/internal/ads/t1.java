package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t1 implements zzbbt {
    private final /* synthetic */ zzala a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakh f13341b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(zzakh zzakhVar, zzala zzalaVar) {
        this.f13341b = zzakhVar;
        this.a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        Object obj;
        obj = this.f13341b.a;
        synchronized (obj) {
            this.f13341b.f13938h = 1;
            zzawz.m("Failed loading new engine. Marking new engine destroyable.");
            this.a.i();
        }
    }
}
