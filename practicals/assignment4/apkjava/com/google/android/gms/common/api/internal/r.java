package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class r implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f11780f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f11781g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zaaw f11782h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zaaw zaawVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f11782h = zaawVar;
        this.f11780f = atomicReference;
        this.f11781g = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        this.f11782h.z((GoogleApiClient) this.f11780f.get(), this.f11781g, true);
    }
}
