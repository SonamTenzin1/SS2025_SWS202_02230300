package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class uf implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final zzbzb f13396f;

    private uf(zzbzb zzbzbVar) {
        this.f13396f = zzbzbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbzb zzbzbVar) {
        return new uf(zzbzbVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13396f.d();
    }
}
