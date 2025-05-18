package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class ik implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final zzbgz f12774f;

    private ik(zzbgz zzbgzVar) {
        this.f12774f = zzbgzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbgz zzbgzVar) {
        return new ik(zzbgzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12774f.l0();
    }
}
