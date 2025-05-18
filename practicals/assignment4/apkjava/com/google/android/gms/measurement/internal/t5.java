package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class t5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzig f17965f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzif f17966g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t5(zzif zzifVar, zzig zzigVar) {
        this.f17966g = zzifVar;
        this.f17965f = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17966g.J(this.f17965f, false);
        zzif zzifVar = this.f17966g;
        zzifVar.f18183c = null;
        zzifVar.r().N(null);
    }
}
