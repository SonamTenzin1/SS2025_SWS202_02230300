package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzabx f12788f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzabx zzabxVar) {
        this.f12788f = zzabxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatb zzatbVar;
        zzatb zzatbVar2;
        zzatbVar = this.f12788f.f13781f;
        if (zzatbVar != null) {
            try {
                zzatbVar2 = this.f12788f.f13781f;
                zzatbVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
