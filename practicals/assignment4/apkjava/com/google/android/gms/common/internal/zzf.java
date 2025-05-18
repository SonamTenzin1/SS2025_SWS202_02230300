package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzf extends i {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f12062g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12063h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i2, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i2, bundle);
        this.f12063h = baseGmsClient;
        this.f12062g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void f(ConnectionResult connectionResult) {
        if (this.f12063h.zzx != null) {
            this.f12063h.zzx.E0(connectionResult);
        }
        this.f12063h.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean g() {
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        try {
            IBinder iBinder = this.f12062g;
            Preconditions.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f12063h.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f12063h.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = this.f12063h.createServiceInterface(this.f12062g);
            if (createServiceInterface == null || !(BaseGmsClient.zzn(this.f12063h, 2, 4, createServiceInterface) || BaseGmsClient.zzn(this.f12063h, 3, 4, createServiceInterface))) {
                return false;
            }
            this.f12063h.zzB = null;
            Bundle connectionHint = this.f12063h.getConnectionHint();
            BaseGmsClient baseGmsClient = this.f12063h;
            baseConnectionCallbacks = baseGmsClient.zzw;
            if (baseConnectionCallbacks == null) {
                return true;
            }
            baseConnectionCallbacks2 = baseGmsClient.zzw;
            baseConnectionCallbacks2.P(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
