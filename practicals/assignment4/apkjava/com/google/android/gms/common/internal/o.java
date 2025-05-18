package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class o extends GmsClientSupervisor {

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f12042f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Context f12043g;

    /* renamed from: h, reason: collision with root package name */
    private volatile Handler f12044h;

    /* renamed from: i, reason: collision with root package name */
    private final n f12045i;

    /* renamed from: j, reason: collision with root package name */
    private final ConnectionTracker f12046j;

    /* renamed from: k, reason: collision with root package name */
    private final long f12047k;
    private final long l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, Looper looper) {
        n nVar = new n(this, null);
        this.f12045i = nVar;
        this.f12043g = context.getApplicationContext();
        this.f12044h = new com.google.android.gms.internal.common.zzi(looper, nVar);
        this.f12046j = ConnectionTracker.b();
        this.f12047k = 5000L;
        this.l = LocalNotificationSyncManager.FIVE_MINUTES;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void d(zzn zznVar, ServiceConnection serviceConnection, String str) {
        Preconditions.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f12042f) {
            m mVar = (m) this.f12042f.get(zznVar);
            if (mVar != null) {
                if (mVar.h(serviceConnection)) {
                    mVar.f(serviceConnection, str);
                    if (mVar.i()) {
                        this.f12044h.sendMessageDelayed(this.f12044h.obtainMessage(0, zznVar), this.f12047k);
                    }
                } else {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zznVar.toString());
                }
            } else {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zznVar.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean f(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j2;
        Preconditions.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f12042f) {
            m mVar = (m) this.f12042f.get(zznVar);
            if (mVar == null) {
                mVar = new m(this, zznVar);
                mVar.d(serviceConnection, serviceConnection, str);
                mVar.e(str, executor);
                this.f12042f.put(zznVar, mVar);
            } else {
                this.f12044h.removeMessages(0, zznVar);
                if (!mVar.h(serviceConnection)) {
                    mVar.d(serviceConnection, serviceConnection, str);
                    int a = mVar.a();
                    if (a == 1) {
                        serviceConnection.onServiceConnected(mVar.b(), mVar.c());
                    } else if (a == 2) {
                        mVar.e(str, executor);
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zznVar.toString());
                }
            }
            j2 = mVar.j();
        }
        return j2;
    }
}
