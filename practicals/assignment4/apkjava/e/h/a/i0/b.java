package e.h.a.i0;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import e.h.a.i0.a;

/* compiled from: IFileDownloadIPCService.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: IFileDownloadIPCService.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: IFileDownloadIPCService.java */
        /* renamed from: e.h.a.i0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0280a implements b {

            /* renamed from: f, reason: collision with root package name */
            private IBinder f21347f;

            C0280a(IBinder iBinder) {
                this.f21347f = iBinder;
            }

            @Override // e.h.a.i0.b
            public byte Q(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f21347f.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i5 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (fileDownloadHeader != null) {
                        obtain.writeInt(1);
                        fileDownloadHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i5 = 0;
                    }
                    obtain.writeInt(i5);
                    this.f21347f.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void V4(e.h.a.i0.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f21347f.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void Y6() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f21347f.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public boolean a0(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f21347f.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21347f;
            }

            @Override // e.h.a.i0.b
            public boolean o0(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f21347f.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void t0(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f21347f.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // e.h.a.i0.b
            public void v1(e.h.a.i0.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f21347f.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        public static b E0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0280a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        v1(a.AbstractBinderC0278a.H(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        V4(a.AbstractBinderC0278a.H(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean I2 = I2(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(I2 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        S(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? FileDownloadHeader.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean a0 = a0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a0 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        Y6();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean Z2 = Z2(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(Z2 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        long u5 = u5(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(u5);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        long p4 = p4(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(p4);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        byte Q = Q(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(Q);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean Z4 = Z4();
                        parcel2.writeNoException();
                        parcel2.writeInt(Z4 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        E6(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        t0(parcel.readInt() != 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean o0 = o0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(o0 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        l2();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            return true;
        }
    }

    void E6(int i2, Notification notification) throws RemoteException;

    boolean I2(String str, String str2) throws RemoteException;

    byte Q(int i2) throws RemoteException;

    void S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) throws RemoteException;

    void V4(e.h.a.i0.a aVar) throws RemoteException;

    void Y6() throws RemoteException;

    boolean Z2(int i2) throws RemoteException;

    boolean Z4() throws RemoteException;

    boolean a0(int i2) throws RemoteException;

    void l2() throws RemoteException;

    boolean o0(int i2) throws RemoteException;

    long p4(int i2) throws RemoteException;

    void t0(boolean z) throws RemoteException;

    long u5(int i2) throws RemoteException;

    void v1(e.h.a.i0.a aVar) throws RemoteException;
}
