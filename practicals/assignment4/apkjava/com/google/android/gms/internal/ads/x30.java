package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzlh f13551f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f13552g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x30(zzto zztoVar, zzlh zzlhVar) {
        this.f13552g = zztoVar;
        this.f13551f = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f13552g.f16775b;
        zztnVar.q(this.f13551f);
    }
}
