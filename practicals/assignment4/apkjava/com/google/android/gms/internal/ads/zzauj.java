package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzauj {
    public static zzatt a(Context context, String str, zzamp zzampVar) {
        try {
            IBinder L6 = ((zzatz) zzbae.a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", w3.a)).L6(ObjectWrapper.E0(context), str, zzampVar, 15000000);
            if (L6 == null) {
                return null;
            }
            IInterface queryLocalInterface = L6.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzatt) {
                return (zzatt) queryLocalInterface;
            }
            return new zzatv(L6);
        } catch (RemoteException | zzbag e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
