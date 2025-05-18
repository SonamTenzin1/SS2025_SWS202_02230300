package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzzl extends zzfn implements zzzk {
    public zzzl() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzzk h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzzk) {
            return (zzzk) queryLocalInterface;
        }
        return new zzzm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzyz zzyzVar = null;
        zzzp zzzpVar = null;
        zzzy zzzyVar = null;
        zzyw zzywVar = null;
        zzzs zzzsVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper S0 = S0();
                parcel2.writeNoException();
                zzfo.c(parcel2, S0);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean B = B();
                parcel2.writeNoException();
                zzfo.a(parcel2, B);
                return true;
            case 4:
                boolean J4 = J4((zzxz) zzfo.b(parcel, zzxz.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, J4);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzyz) {
                        zzyzVar = (zzyz) queryLocalInterface;
                    } else {
                        zzyzVar = new zzzb(readStrongBinder);
                    }
                }
                L0(zzyzVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzzs) {
                        zzzsVar = (zzzs) queryLocalInterface2;
                    } else {
                        zzzsVar = new zzzu(readStrongBinder2);
                    }
                }
                P5(zzzsVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                k4();
                parcel2.writeNoException();
                return true;
            case 11:
                x6();
                parcel2.writeNoException();
                return true;
            case 12:
                zzyd C5 = C5();
                parcel2.writeNoException();
                zzfo.g(parcel2, C5);
                return true;
            case 13:
                C2((zzyd) zzfo.b(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                U5(zzaqo.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                C3(zzaqu.h7(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                H6(zzadp.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzyw) {
                        zzywVar = (zzyw) queryLocalInterface3;
                    } else {
                        zzywVar = new zzyy(readStrongBinder3);
                    }
                }
                w4(zzywVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzzy) {
                        zzzyVar = (zzzy) queryLocalInterface4;
                    } else {
                        zzzyVar = new zzaaa(readStrongBinder4);
                    }
                }
                v4(zzzyVar);
                parcel2.writeNoException();
                return true;
            case 22:
                t1(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean p0 = p0();
                parcel2.writeNoException();
                zzfo.a(parcel2, p0);
                return true;
            case 24:
                h0(zzatc.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 29:
                W6((zzacd) zzfo.b(parcel, zzacd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                X5((zzaax) zzfo.b(parcel, zzaax.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String f6 = f6();
                parcel2.writeNoException();
                parcel2.writeString(f6);
                return true;
            case 32:
                zzzs I4 = I4();
                parcel2.writeNoException();
                zzfo.c(parcel2, I4);
                return true;
            case 33:
                zzyz x5 = x5();
                parcel2.writeNoException();
                zzfo.c(parcel2, x5);
                return true;
            case 34:
                setImmersiveMode(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String c0 = c0();
                parcel2.writeNoException();
                parcel2.writeString(c0);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzzp) {
                        zzzpVar = (zzzp) queryLocalInterface5;
                    } else {
                        zzzpVar = new zzzr(readStrongBinder5);
                    }
                }
                z0(zzzpVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzfo.g(parcel2, adMetadata);
                return true;
            case 38:
                m4(parcel.readString());
                parcel2.writeNoException();
                return true;
        }
    }
}
