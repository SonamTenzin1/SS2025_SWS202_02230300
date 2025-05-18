package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class h5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17804f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17805g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(zzhc zzhcVar, boolean z) {
        this.f17805g = zzhcVar;
        this.f17804f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17805g.B0(this.f17804f);
    }
}
