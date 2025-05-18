package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* loaded from: classes2.dex */
public final class zzv extends com.google.android.gms.internal.p000authapi.zzc implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void B3(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.p000authapi.zze.b(H, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.c(H, googleSignInOptions);
        P(103, H);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    public final void i3(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.p000authapi.zze.b(H, zzsVar);
        com.google.android.gms.internal.p000authapi.zze.c(H, googleSignInOptions);
        P(102, H);
    }
}
