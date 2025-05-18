package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzc implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f17019f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17020g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(IBinder iBinder, String str) {
        this.f17019f = iBinder;
        this.f17020g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel H() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17020g);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f17019f.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17019f;
    }
}
