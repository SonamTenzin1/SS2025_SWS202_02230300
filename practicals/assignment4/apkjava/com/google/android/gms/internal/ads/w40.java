package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w40 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvn f13495f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w40(zzvn zzvnVar) {
        this.f13495f = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        Object obj;
        Object obj2;
        obj = this.f13495f.f16858b;
        synchronized (obj) {
            this.f13495f.f16861e = null;
            obj2 = this.f13495f.f16858b;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        Object obj;
        Object obj2;
        zzvu zzvuVar;
        zzvu zzvuVar2;
        obj = this.f13495f.f16858b;
        synchronized (obj) {
            try {
                zzvuVar = this.f13495f.f16859c;
                if (zzvuVar != null) {
                    zzvn zzvnVar = this.f13495f;
                    zzvuVar2 = zzvnVar.f16859c;
                    zzvnVar.f16861e = zzvuVar2.e();
                }
            } catch (DeadObjectException e2) {
                zzbad.c("Unable to obtain a cache service instance.", e2);
                this.f13495f.b();
            }
            obj2 = this.f13495f.f16858b;
            obj2.notifyAll();
        }
    }
}
