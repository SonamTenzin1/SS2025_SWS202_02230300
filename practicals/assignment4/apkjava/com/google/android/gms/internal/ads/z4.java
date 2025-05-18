package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzawv f13679f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(zzawv zzawvVar) {
        this.f13679f = zzawvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13679f.zzdut = Thread.currentThread();
        this.f13679f.zzto();
    }
}
