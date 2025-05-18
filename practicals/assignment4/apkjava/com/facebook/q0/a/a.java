package com.facebook.q0.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IReceiverService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IReceiverService.java */
    /* renamed from: com.facebook.q0.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0154a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IReceiverService.java */
        /* renamed from: com.facebook.q0.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0155a implements a {

            /* renamed from: f, reason: collision with root package name */
            public static a f10561f;

            /* renamed from: g, reason: collision with root package name */
            private IBinder f10562g;

            C0155a(IBinder iBinder) {
                this.f10562g = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10562g;
            }

            @Override // com.facebook.q0.a.a
            public int u1(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f10562g.transact(1, obtain, obtain2, 0) && AbstractBinderC0154a.P() != null) {
                        return AbstractBinderC0154a.P().u1(bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0155a(iBinder);
        }

        public static a P() {
            return C0155a.f10561f;
        }
    }

    int u1(Bundle bundle) throws RemoteException;
}
