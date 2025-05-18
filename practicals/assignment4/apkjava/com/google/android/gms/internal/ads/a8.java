package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class a8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f12230f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbcq f12231g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a8(zzbcq zzbcqVar, boolean z) {
        this.f12231g = zzbcqVar;
        this.f12230f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12231g.x("windowVisibilityChanged", "isVisible", String.valueOf(this.f12230f));
    }
}
