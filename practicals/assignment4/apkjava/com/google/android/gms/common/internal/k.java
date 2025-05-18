package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class k extends com.google.android.gms.internal.common.zzi {
    final /* synthetic */ BaseGmsClient a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.a = baseGmsClient;
    }

    private static final void a(Message message) {
        zzc zzcVar = (zzc) message.obj;
        zzcVar.b();
        zzcVar.e();
    }

    private static final boolean b(Message message) {
        int i2 = message.what;
        return i2 == 2 || i2 == 1 || i2 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks;
        BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        boolean z;
        if (this.a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 != 1 && i2 != 7 && ((i2 != 4 || this.a.enableLocalFallback()) && message.what != 5)) || this.a.isConnecting()) {
            int i3 = message.what;
            if (i3 == 4) {
                this.a.zzB = new ConnectionResult(message.arg2);
                if (BaseGmsClient.zzo(this.a)) {
                    BaseGmsClient baseGmsClient = this.a;
                    z = baseGmsClient.zzC;
                    if (!z) {
                        baseGmsClient.zzp(3, null);
                        return;
                    }
                }
                BaseGmsClient baseGmsClient2 = this.a;
                connectionResult2 = baseGmsClient2.zzB;
                ConnectionResult connectionResult3 = connectionResult2 != null ? baseGmsClient2.zzB : new ConnectionResult(8);
                this.a.zzc.a(connectionResult3);
                this.a.onConnectionFailed(connectionResult3);
                return;
            }
            if (i3 == 5) {
                BaseGmsClient baseGmsClient3 = this.a;
                connectionResult = baseGmsClient3.zzB;
                ConnectionResult connectionResult4 = connectionResult != null ? baseGmsClient3.zzB : new ConnectionResult(8);
                this.a.zzc.a(connectionResult4);
                this.a.onConnectionFailed(connectionResult4);
                return;
            }
            if (i3 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                this.a.zzc.a(connectionResult5);
                this.a.onConnectionFailed(connectionResult5);
                return;
            }
            if (i3 == 6) {
                this.a.zzp(5, null);
                BaseGmsClient baseGmsClient4 = this.a;
                baseConnectionCallbacks = baseGmsClient4.zzw;
                if (baseConnectionCallbacks != null) {
                    baseConnectionCallbacks2 = baseGmsClient4.zzw;
                    baseConnectionCallbacks2.H(message.arg2);
                }
                this.a.onConnectionSuspended(message.arg2);
                BaseGmsClient.zzn(this.a, 5, 1, null);
                return;
            }
            if (i3 == 2 && !this.a.isConnected()) {
                a(message);
                return;
            }
            if (b(message)) {
                ((zzc) message.obj).c();
                return;
            }
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            return;
        }
        a(message);
    }
}
