package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzand extends IInterface {
    void A(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean C() throws RemoteException;

    void C0(IObjectWrapper iObjectWrapper) throws RemoteException;

    void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzaei D0() throws RemoteException;

    IObjectWrapper I() throws RemoteException;

    IObjectWrapper K() throws RemoteException;

    boolean M() throws RemoteException;

    void N(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzaea f() throws RemoteException;

    String g() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    String h() throws RemoteException;

    String i() throws RemoteException;

    IObjectWrapper j() throws RemoteException;

    List k() throws RemoteException;

    void recordImpression() throws RemoteException;

    String w() throws RemoteException;
}
