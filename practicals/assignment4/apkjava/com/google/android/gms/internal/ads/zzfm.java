package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zzfm implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f16226f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16227g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzfm(IBinder iBinder, String str) {
        this.f16226f = iBinder;
        this.f16227g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E0(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f16226f.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel H() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f16227g);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel P(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f16226f.transact(i2, parcel, obtain, 0);
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

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f16226f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k0(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f16226f.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
