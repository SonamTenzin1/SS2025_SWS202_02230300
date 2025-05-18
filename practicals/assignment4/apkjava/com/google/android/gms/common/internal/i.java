package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
abstract class i extends zzc {

    /* renamed from: d, reason: collision with root package name */
    public final int f12031d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f12032e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12033f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(BaseGmsClient baseGmsClient, int i2, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.f12033f = baseGmsClient;
        this.f12031d = i2;
        this.f12032e = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f12031d != 0) {
            this.f12033f.zzp(1, null);
            Bundle bundle = this.f12032e;
            f(new ConnectionResult(this.f12031d, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (g()) {
                return;
            }
            this.f12033f.zzp(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzc
    public final void b() {
    }

    protected abstract void f(ConnectionResult connectionResult);

    protected abstract boolean g();
}
