package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public interface IFragmentWrapper extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            switch (i2) {
                case 2:
                    IObjectWrapper s = s();
                    parcel2.writeNoException();
                    zzc.f(parcel2, s);
                    return true;
                case 3:
                    Bundle d2 = d();
                    parcel2.writeNoException();
                    zzc.e(parcel2, d2);
                    return true;
                case 4:
                    int b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 5:
                    IFragmentWrapper e2 = e();
                    parcel2.writeNoException();
                    zzc.f(parcel2, e2);
                    return true;
                case 6:
                    IObjectWrapper m = m();
                    parcel2.writeNoException();
                    zzc.f(parcel2, m);
                    return true;
                case 7:
                    boolean x = x();
                    parcel2.writeNoException();
                    zzc.c(parcel2, x);
                    return true;
                case 8:
                    String v = v();
                    parcel2.writeNoException();
                    parcel2.writeString(v);
                    return true;
                case 9:
                    IFragmentWrapper q = q();
                    parcel2.writeNoException();
                    zzc.f(parcel2, q);
                    return true;
                case 10:
                    int c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2);
                    return true;
                case 11:
                    boolean y = y();
                    parcel2.writeNoException();
                    zzc.c(parcel2, y);
                    return true;
                case 12:
                    IObjectWrapper l = l();
                    parcel2.writeNoException();
                    zzc.f(parcel2, l);
                    return true;
                case 13:
                    boolean G = G();
                    parcel2.writeNoException();
                    zzc.c(parcel2, G);
                    return true;
                case 14:
                    boolean A0 = A0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, A0);
                    return true;
                case 15:
                    boolean f0 = f0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, f0);
                    return true;
                case 16:
                    boolean l0 = l0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, l0);
                    return true;
                case 17:
                    boolean U = U();
                    parcel2.writeNoException();
                    zzc.c(parcel2, U);
                    return true;
                case 18:
                    boolean X = X();
                    parcel2.writeNoException();
                    zzc.c(parcel2, X);
                    return true;
                case 19:
                    boolean Z6 = Z6();
                    parcel2.writeNoException();
                    zzc.c(parcel2, Z6);
                    return true;
                case 20:
                    IObjectWrapper P = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    zzc.b(parcel);
                    s0(P);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean g2 = zzc.g(parcel);
                    zzc.b(parcel);
                    P0(g2);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean g3 = zzc.g(parcel);
                    zzc.b(parcel);
                    r1(g3);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean g4 = zzc.g(parcel);
                    zzc.b(parcel);
                    b2(g4);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean g5 = zzc.g(parcel);
                    zzc.b(parcel);
                    h6(g5);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) zzc.a(parcel, Intent.CREATOR);
                    zzc.b(parcel);
                    w2(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) zzc.a(parcel, Intent.CREATOR);
                    int readInt = parcel.readInt();
                    zzc.b(parcel);
                    D2(intent2, readInt);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper P2 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    zzc.b(parcel);
                    w0(P2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean A0() throws RemoteException;

    void D2(Intent intent, int i2) throws RemoteException;

    boolean G() throws RemoteException;

    void P0(boolean z) throws RemoteException;

    boolean U() throws RemoteException;

    boolean X() throws RemoteException;

    boolean Z6() throws RemoteException;

    int b() throws RemoteException;

    void b2(boolean z) throws RemoteException;

    int c() throws RemoteException;

    Bundle d() throws RemoteException;

    IFragmentWrapper e() throws RemoteException;

    boolean f0() throws RemoteException;

    void h6(boolean z) throws RemoteException;

    IObjectWrapper l() throws RemoteException;

    boolean l0() throws RemoteException;

    IObjectWrapper m() throws RemoteException;

    IFragmentWrapper q() throws RemoteException;

    void r1(boolean z) throws RemoteException;

    IObjectWrapper s() throws RemoteException;

    void s0(IObjectWrapper iObjectWrapper) throws RemoteException;

    String v() throws RemoteException;

    void w0(IObjectWrapper iObjectWrapper) throws RemoteException;

    void w2(Intent intent) throws RemoteException;

    boolean x() throws RemoteException;

    boolean y() throws RemoteException;
}
