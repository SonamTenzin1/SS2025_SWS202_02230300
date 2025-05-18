package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzxw extends RemoteCreator<zzzi> {
    public zzxw() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzzi a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzzi) {
            return (zzzi) queryLocalInterface;
        }
        return new zzzj(iBinder);
    }

    public final zzzf c(Context context, String str, zzamp zzampVar) {
        try {
            IBinder i6 = b(context).i6(ObjectWrapper.E0(context), str, zzampVar, 15000000);
            if (i6 == null) {
                return null;
            }
            IInterface queryLocalInterface = i6.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                return (zzzf) queryLocalInterface;
            }
            return new zzzh(i6);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.d("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }
}
