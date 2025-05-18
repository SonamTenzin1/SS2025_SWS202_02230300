package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzxx extends RemoteCreator<zzzn> {
    @VisibleForTesting
    public zzxx() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzzn a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzzn) {
            return (zzzn) queryLocalInterface;
        }
        return new zzzo(iBinder);
    }

    public final zzzk c(Context context, zzyd zzydVar, String str, zzamp zzampVar, int i2) {
        try {
            IBinder o5 = b(context).o5(ObjectWrapper.E0(context), zzydVar, str, zzampVar, 15000000, i2);
            if (o5 == null) {
                return null;
            }
            IInterface queryLocalInterface = o5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                return (zzzk) queryLocalInterface;
            }
            return new zzzm(o5);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.b("Could not create remote AdManager.", e2);
            return null;
        }
    }
}
