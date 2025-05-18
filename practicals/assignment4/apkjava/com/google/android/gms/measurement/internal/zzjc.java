package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzjc implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f18199f;

    /* renamed from: g, reason: collision with root package name */
    private volatile zzeu f18200g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzik f18201h;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjc(zzik zzikVar) {
        this.f18201h = zzikVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(zzjc zzjcVar, boolean z) {
        zzjcVar.f18199f = false;
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        Preconditions.f("MeasurementServiceConnection.onConnectionFailed");
        zzet C = this.f18201h.a.C();
        if (C != null) {
            C.K().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f18199f = false;
            this.f18200g = null;
        }
        this.f18201h.g().z(new p6(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        Preconditions.f("MeasurementServiceConnection.onConnectionSuspended");
        this.f18201h.h().O().a("Service connection suspended");
        this.f18201h.g().z(new q6(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        Preconditions.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f18201h.g().z(new n6(this, this.f18200g.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f18200g = null;
                this.f18199f = false;
            }
        }
    }

    public final void a() {
        if (this.f18200g != null && (this.f18200g.isConnected() || this.f18200g.isConnecting())) {
            this.f18200g.disconnect();
        }
        this.f18200g = null;
    }

    public final void b(Intent intent) {
        zzjc zzjcVar;
        this.f18201h.d();
        Context f2 = this.f18201h.f();
        ConnectionTracker b2 = ConnectionTracker.b();
        synchronized (this) {
            if (this.f18199f) {
                this.f18201h.h().P().a("Connection attempt already in progress");
                return;
            }
            this.f18201h.h().P().a("Using local app measurement service");
            this.f18199f = true;
            zzjcVar = this.f18201h.f18192c;
            b2.a(f2, intent, zzjcVar, 129);
        }
    }

    public final void d() {
        this.f18201h.d();
        Context f2 = this.f18201h.f();
        synchronized (this) {
            if (this.f18199f) {
                this.f18201h.h().P().a("Connection attempt already in progress");
                return;
            }
            if (this.f18200g != null && (this.f18200g.isConnecting() || this.f18200g.isConnected())) {
                this.f18201h.h().P().a("Already awaiting connection attempt");
                return;
            }
            this.f18200g = new zzeu(f2, Looper.getMainLooper(), this, this);
            this.f18201h.h().P().a("Connecting to remote service");
            this.f18199f = true;
            this.f18200g.checkAvailabilityAndConnect();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzjc zzjcVar;
        zzel zzenVar;
        Preconditions.f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f18199f = false;
                this.f18201h.h().H().a("Service connected with null binder");
                return;
            }
            zzel zzelVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof zzel) {
                        zzenVar = (zzel) queryLocalInterface;
                    } else {
                        zzenVar = new zzen(iBinder);
                    }
                    zzelVar = zzenVar;
                    this.f18201h.h().P().a("Bound to IMeasurementService interface");
                } else {
                    this.f18201h.h().H().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f18201h.h().H().a("Service connect failed to get IMeasurementService");
            }
            if (zzelVar == null) {
                this.f18199f = false;
                try {
                    ConnectionTracker b2 = ConnectionTracker.b();
                    Context f2 = this.f18201h.f();
                    zzjcVar = this.f18201h.f18192c;
                    b2.c(f2, zzjcVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f18201h.g().z(new m6(this, zzelVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.f("MeasurementServiceConnection.onServiceDisconnected");
        this.f18201h.h().O().a("Service disconnected");
        this.f18201h.g().z(new o6(this, componentName));
    }
}
