package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class zaa implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f17049f;

    /* renamed from: g, reason: collision with root package name */
    private final String f17050g;

    /* JADX INFO: Access modifiers changed from: protected */
    public zaa(IBinder iBinder, String str) {
        this.f17049f = iBinder;
        this.f17050g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E0(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f17049f.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel H() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17050g);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel P(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f17049f.transact(i2, parcel, obtain, 0);
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
        return this.f17049f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k0(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f17049f.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
