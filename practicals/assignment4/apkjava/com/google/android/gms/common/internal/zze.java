package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zze implements ServiceConnection {

    /* renamed from: f, reason: collision with root package name */
    private final int f12060f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12061g;

    public zze(BaseGmsClient baseGmsClient, int i2) {
        this.f12061g = baseGmsClient;
        this.f12060f = i2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        IGmsServiceBroker jVar;
        BaseGmsClient baseGmsClient = this.f12061g;
        if (iBinder == null) {
            BaseGmsClient.zzk(baseGmsClient, 16);
            return;
        }
        obj = baseGmsClient.zzq;
        synchronized (obj) {
            BaseGmsClient baseGmsClient2 = this.f12061g;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                jVar = (IGmsServiceBroker) queryLocalInterface;
            } else {
                jVar = new j(iBinder);
            }
            baseGmsClient2.zzr = jVar;
        }
        this.f12061g.zzl(0, null, this.f12060f);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f12061g.zzq;
        synchronized (obj) {
            this.f12061g.zzr = null;
        }
        Handler handler = this.f12061g.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.f12060f, 1));
    }
}
