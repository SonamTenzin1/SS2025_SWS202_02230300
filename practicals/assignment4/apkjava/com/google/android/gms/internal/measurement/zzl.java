package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class zzl extends zzc implements zzm {
    public zzl() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzm asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzm) {
            return (zzm) queryLocalInterface;
        }
        return new zzo(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzn zzpVar;
        zzn zznVar;
        zzn zznVar2 = null;
        zzn zznVar3 = null;
        zzn zznVar4 = null;
        zzs zzsVar = null;
        zzs zzsVar2 = null;
        zzs zzsVar3 = null;
        zzn zznVar5 = null;
        zzn zznVar6 = null;
        zzn zznVar7 = null;
        zzn zznVar8 = null;
        zzn zznVar9 = null;
        zzn zznVar10 = null;
        zzt zztVar = null;
        zzn zznVar11 = null;
        zzn zznVar12 = null;
        zzn zznVar13 = null;
        zzn zznVar14 = null;
        switch (i2) {
            case 1:
                initialize(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzv) zzb.a(parcel, zzv.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzb.a(parcel, Bundle.CREATOR), zzb.e(parcel), zzb.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzb.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zznVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzn) {
                        zzpVar = (zzn) queryLocalInterface;
                    } else {
                        zzpVar = new zzp(readStrongBinder);
                    }
                    zznVar = zzpVar;
                }
                logEventAndBundle(readString, readString2, bundle, zznVar, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzb.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean e2 = zzb.e(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzn) {
                        zznVar2 = (zzn) queryLocalInterface2;
                    } else {
                        zznVar2 = new zzp(readStrongBinder2);
                    }
                }
                getUserProperties(readString3, readString4, e2, zznVar2);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzn) {
                        zznVar14 = (zzn) queryLocalInterface3;
                    } else {
                        zznVar14 = new zzp(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString5, zznVar14);
                parcel2.writeNoException();
                return true;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 8:
                setConditionalUserProperty((Bundle) zzb.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzb.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzn) {
                        zznVar13 = (zzn) queryLocalInterface4;
                    } else {
                        zznVar13 = new zzp(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString6, readString7, zznVar13);
                parcel2.writeNoException();
                return true;
            case 11:
                setMeasurementEnabled(zzb.e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 12:
                resetAnalyticsData(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 15:
                setCurrentScreen(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzn) {
                        zznVar12 = (zzn) queryLocalInterface5;
                    } else {
                        zznVar12 = new zzp(readStrongBinder5);
                    }
                }
                getCurrentScreenName(zznVar12);
                parcel2.writeNoException();
                return true;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzn) {
                        zznVar11 = (zzn) queryLocalInterface6;
                    } else {
                        zznVar11 = new zzp(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(zznVar11);
                parcel2.writeNoException();
                return true;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzt) {
                        zztVar = (zzt) queryLocalInterface7;
                    } else {
                        zztVar = new zzw(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(zztVar);
                parcel2.writeNoException();
                return true;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzn) {
                        zznVar10 = (zzn) queryLocalInterface8;
                    } else {
                        zznVar10 = new zzp(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(zznVar10);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzn) {
                        zznVar9 = (zzn) queryLocalInterface9;
                    } else {
                        zznVar9 = new zzp(readStrongBinder9);
                    }
                }
                getAppInstanceId(zznVar9);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzn) {
                        zznVar8 = (zzn) queryLocalInterface10;
                    } else {
                        zznVar8 = new zzp(readStrongBinder10);
                    }
                }
                getGmpAppId(zznVar8);
                parcel2.writeNoException();
                return true;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzn) {
                        zznVar7 = (zzn) queryLocalInterface11;
                    } else {
                        zznVar7 = new zzp(readStrongBinder11);
                    }
                }
                generateEventId(zznVar7);
                parcel2.writeNoException();
                return true;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 25:
                onActivityStarted(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 26:
                onActivityStopped(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 27:
                onActivityCreated(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (Bundle) zzb.a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 28:
                onActivityDestroyed(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 29:
                onActivityPaused(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 30:
                onActivityResumed(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper P = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzn) {
                        zznVar6 = (zzn) queryLocalInterface12;
                    } else {
                        zznVar6 = new zzp(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(P, zznVar6, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 32:
                Bundle bundle2 = (Bundle) zzb.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzn) {
                        zznVar5 = (zzn) queryLocalInterface13;
                    } else {
                        zznVar5 = new zzp(readStrongBinder13);
                    }
                }
                performAction(bundle2, zznVar5, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzs) {
                        zzsVar3 = (zzs) queryLocalInterface14;
                    } else {
                        zzsVar3 = new zzu(readStrongBinder14);
                    }
                }
                setEventInterceptor(zzsVar3);
                parcel2.writeNoException();
                return true;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzs) {
                        zzsVar2 = (zzs) queryLocalInterface15;
                    } else {
                        zzsVar2 = new zzu(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(zzsVar2);
                parcel2.writeNoException();
                return true;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzs) {
                        zzsVar = (zzs) queryLocalInterface16;
                    } else {
                        zzsVar = new zzu(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(zzsVar);
                parcel2.writeNoException();
                return true;
            case 37:
                initForTests(zzb.f(parcel));
                parcel2.writeNoException();
                return true;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzn) {
                        zznVar4 = (zzn) queryLocalInterface17;
                    } else {
                        zznVar4 = new zzp(readStrongBinder17);
                    }
                }
                getTestFlag(zznVar4, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 39:
                setDataCollectionEnabled(zzb.e(parcel));
                parcel2.writeNoException();
                return true;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzn) {
                        zznVar3 = (zzn) queryLocalInterface18;
                    } else {
                        zznVar3 = new zzp(readStrongBinder18);
                    }
                }
                isDataCollectionEnabled(zznVar3);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
