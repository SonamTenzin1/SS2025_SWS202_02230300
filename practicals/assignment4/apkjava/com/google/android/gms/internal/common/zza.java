package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public class zza implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f17071f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17072g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(IBinder iBinder, String str) {
        this.f17071f = iBinder;
        this.f17072g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel H(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f17071f.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f17071f.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f17071f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel k0() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17072g);
        return obtain;
    }
}
