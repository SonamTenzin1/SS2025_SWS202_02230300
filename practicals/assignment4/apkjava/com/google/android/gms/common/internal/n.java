package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class n implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ o f12041f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(o oVar, zzp zzpVar) {
        this.f12041f = oVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i2 = message.what;
        if (i2 == 0) {
            hashMap = this.f12041f.f12042f;
            synchronized (hashMap) {
                zzn zznVar = (zzn) message.obj;
                hashMap2 = this.f12041f.f12042f;
                m mVar = (m) hashMap2.get(zznVar);
                if (mVar != null && mVar.i()) {
                    if (mVar.j()) {
                        mVar.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f12041f.f12042f;
                    hashMap3.remove(zznVar);
                }
            }
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        hashMap4 = this.f12041f.f12042f;
        synchronized (hashMap4) {
            zzn zznVar2 = (zzn) message.obj;
            hashMap5 = this.f12041f.f12042f;
            m mVar2 = (m) hashMap5.get(zznVar2);
            if (mVar2 != null && mVar2.a() == 3) {
                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(zznVar2), new Exception());
                ComponentName b2 = mVar2.b();
                if (b2 == null) {
                    b2 = zznVar2.b();
                }
                if (b2 == null) {
                    String d2 = zznVar2.d();
                    Preconditions.k(d2);
                    b2 = new ComponentName(d2, "unknown");
                }
                mVar2.onServiceDisconnected(b2);
            }
        }
        return true;
    }
}
