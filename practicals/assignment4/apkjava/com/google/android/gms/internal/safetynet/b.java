package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;

/* loaded from: classes2.dex */
final class b extends zzk.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzk zzkVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void s(zzx zzxVar) throws RemoteException {
        ((zzi) zzxVar.getService()).M1(this.s);
    }
}
