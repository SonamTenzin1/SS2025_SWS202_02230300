package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13668f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13669g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z00(zzma zzmaVar, int i2) {
        this.f13669g = zzmaVar;
        this.f13668f = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.f13669g.f16456b;
        zzlzVar.a(this.f13668f);
    }
}
