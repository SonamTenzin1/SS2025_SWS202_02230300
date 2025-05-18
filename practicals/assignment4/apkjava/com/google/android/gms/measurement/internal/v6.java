package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class v6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17996f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjl f17997g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v6(zzjl zzjlVar, long j2) {
        this.f17997g = zzjlVar;
        this.f17996f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17997g.B(this.f17996f);
    }
}
