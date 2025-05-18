package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x40 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvn f13555f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x40(zzvn zzvnVar) {
        this.f13555f = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        Object obj;
        zzvu zzvuVar;
        Object obj2;
        obj = this.f13555f.f16858b;
        synchronized (obj) {
            this.f13555f.f16861e = null;
            zzvuVar = this.f13555f.f16859c;
            if (zzvuVar != null) {
                zzvn.f(this.f13555f, null);
            }
            obj2 = this.f13555f.f16858b;
            obj2.notifyAll();
        }
    }
}
