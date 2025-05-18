package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzamt extends zzfn implements zzams {
    public zzamt() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzamv zzamvVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper P = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzyd zzydVar = (zzyd) zzfo.b(parcel, zzyd.CREATOR);
                zzxz zzxzVar = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder);
                    }
                }
                y2(P, zzydVar, zzxzVar, readString, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper x1 = x1();
                parcel2.writeNoException();
                zzfo.c(parcel2, x1);
                return true;
            case 3:
                IObjectWrapper P2 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar2 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface2;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder2);
                    }
                }
                Y2(P2, zzxzVar2, readString2, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper P3 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzyd zzydVar2 = (zzyd) zzfo.b(parcel, zzyd.CREATOR);
                zzxz zzxzVar3 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface3;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder3);
                    }
                }
                s4(P3, zzydVar2, zzxzVar3, readString3, readString4, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper P4 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar4 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface4;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder4);
                    }
                }
                c6(P4, zzxzVar4, readString5, readString6, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                h4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString(), zzatl.h7(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                o6((zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzfo.a(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper P5 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar5 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface5;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder5);
                    }
                }
                M3(P5, zzxzVar5, readString7, readString8, zzamvVar, (zzady) zzfo.b(parcel, zzady.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzana b7 = b7();
                parcel2.writeNoException();
                zzfo.c(parcel2, b7);
                return true;
            case 16:
                zzand e6 = e6();
                parcel2.writeNoException();
                zzfo.c(parcel2, e6);
                return true;
            case 17:
                Bundle zzsh = zzsh();
                parcel2.writeNoException();
                zzfo.g(parcel2, zzsh);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzfo.g(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle r4 = r4();
                parcel2.writeNoException();
                zzfo.g(parcel2, r4);
                return true;
            case 20:
                Q2((zzxz) zzfo.b(parcel, zzxz.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                w0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean x3 = x3();
                parcel2.writeNoException();
                zzfo.a(parcel2, x3);
                return true;
            case 23:
                H4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzatl.h7(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafe F2 = F2();
                parcel2.writeNoException();
                zzfo.c(parcel2, F2);
                return true;
            case 25:
                setImmersiveMode(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 27:
                zzang P1 = P1();
                parcel2.writeNoException();
                zzfo.c(parcel2, P1);
                return true;
            case 28:
                IObjectWrapper P6 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                zzxz zzxzVar6 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface6;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder6);
                    }
                }
                f2(P6, zzxzVar6, readString9, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                a4(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                G4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzair.h7(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaiw.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
