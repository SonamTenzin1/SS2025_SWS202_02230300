package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ e f12551f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f12551f = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzabl.h7(this.f12551f.f12490f) != null) {
            try {
                zzabl.h7(this.f12551f.f12490f).onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
