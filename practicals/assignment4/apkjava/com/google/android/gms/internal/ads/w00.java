package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzlh f13486f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13487g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w00(zzma zzmaVar, zzlh zzlhVar) {
        this.f13487g = zzmaVar;
        this.f13486f = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.f13487g.f16456b;
        zzlzVar.f(this.f13486f);
    }
}
