package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* loaded from: classes2.dex */
public final class zzccw extends VideoController.VideoLifecycleCallbacks {
    private final zzbyt a;

    public zzccw(zzbyt zzbytVar) {
        this.a = zzbytVar;
    }

    private static zzaau a(zzbyt zzbytVar) {
        zzaar m = zzbytVar.m();
        if (m == null) {
            return null;
        }
        try {
            return m.a5();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzaau a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.n0();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzaau a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.onVideoPause();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzaau a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.onVideoStart();
        } catch (RemoteException e2) {
            zzbad.d("Unable to call onVideoEnd()", e2);
        }
    }
}
