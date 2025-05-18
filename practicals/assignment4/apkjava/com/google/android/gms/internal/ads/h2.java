package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h2 implements zzbbt {
    private final /* synthetic */ zzbbr a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakw f12681b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h2(zzalu zzaluVar, zzbbr zzbbrVar, zzakw zzakwVar) {
        this.a = zzbbrVar;
        this.f12681b = zzakwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        this.a.c(new zzali("Unable to obtain a JavascriptEngine."));
        this.f12681b.f();
    }
}
