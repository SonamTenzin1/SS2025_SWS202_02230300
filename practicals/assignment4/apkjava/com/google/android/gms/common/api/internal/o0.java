package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes2.dex */
final class o0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final n0 f11776f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ zal f11777g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(zal zalVar, n0 n0Var) {
        this.f11777g = zalVar;
        this.f11776f = n0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11777g.f11872g) {
            ConnectionResult a = this.f11776f.a();
            if (a.Y()) {
                zal zalVar = this.f11777g;
                zalVar.f11734f.startActivityForResult(GoogleApiActivity.b(zalVar.b(), a.W(), this.f11776f.b(), false), 1);
            } else if (this.f11777g.f11875j.m(a.y())) {
                zal zalVar2 = this.f11777g;
                zalVar2.f11875j.z(zalVar2.b(), this.f11777g.f11734f, a.y(), 2, this.f11777g);
            } else {
                if (a.y() == 18) {
                    Dialog t = GoogleApiAvailability.t(this.f11777g.b(), this.f11777g);
                    zal zalVar3 = this.f11777g;
                    zalVar3.f11875j.v(zalVar3.b().getApplicationContext(), new p0(this, t));
                    return;
                }
                this.f11777g.l(a, this.f11776f.b());
            }
        }
    }
}
