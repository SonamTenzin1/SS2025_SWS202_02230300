package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;

/* loaded from: classes2.dex */
final class e implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient.OnConnectionFailedListener f12027f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f12027f = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f12027f.E0(connectionResult);
    }
}
