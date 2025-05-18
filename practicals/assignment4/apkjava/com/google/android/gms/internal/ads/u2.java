package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class u2 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e.e.a.a f13377f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzanu f13378g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(zzanu zzanuVar, e.e.a.a aVar) {
        this.f13378g = zzanuVar;
        this.f13377f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.f13378g.a;
            zzamvVar.onAdFailedToLoad(zzaog.a(this.f13377f));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
