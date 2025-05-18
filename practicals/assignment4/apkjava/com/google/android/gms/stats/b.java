package com.google.android.gms.stats;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ WakeLock f18309f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WakeLock wakeLock) {
        this.f18309f = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18309f.f(0);
    }
}
