package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzabp f12608f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzabp zzabpVar) {
        this.f12608f = zzabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzyz zzyzVar;
        zzyz zzyzVar2;
        zzyzVar = this.f12608f.f13779f;
        if (zzyzVar != null) {
            try {
                zzyzVar2 = this.f12608f.f13779f;
                zzyzVar2.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
