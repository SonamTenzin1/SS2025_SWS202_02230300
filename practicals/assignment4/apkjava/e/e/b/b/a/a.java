package e.e.b.b.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IGetInstallReferrerService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IGetInstallReferrerService.java */
    /* renamed from: e.e.b.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0258a extends Binder implements a {

        /* compiled from: IGetInstallReferrerService.java */
        /* renamed from: e.e.b.b.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0259a implements a {

            /* renamed from: f, reason: collision with root package name */
            private IBinder f20884f;

            C0259a(IBinder iBinder) {
                this.f20884f = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f20884f;
            }

            @Override // e.e.b.b.a.a
            public Bundle e3(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f20884f.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
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
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0259a(iBinder);
        }
    }

    Bundle e3(Bundle bundle) throws RemoteException;
}
