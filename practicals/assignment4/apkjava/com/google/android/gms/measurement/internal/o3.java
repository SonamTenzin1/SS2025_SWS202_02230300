package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class o3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17892f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p3 f17893g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(p3 p3Var, boolean z) {
        this.f17893g = p3Var;
        this.f17892f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkcVar = this.f17893g.f17899b;
        zzkcVar.B(this.f17892f);
    }
}
