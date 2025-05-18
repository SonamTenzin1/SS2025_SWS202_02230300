package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
final class j implements IGmsServiceBroker {

    /* renamed from: f, reason: collision with root package name */
    private final IBinder f12034f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(IBinder iBinder) {
        this.f12034f = iBinder;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    public final void U1(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzm.a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f12034f.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f12034f;
    }
}
