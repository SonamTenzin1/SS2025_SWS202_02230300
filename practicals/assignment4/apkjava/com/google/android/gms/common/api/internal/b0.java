package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes2.dex */
final class b0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f11744f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f11745g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(GoogleApiManager.zaa zaaVar, ConnectionResult connectionResult) {
        this.f11745g = zaaVar;
        this.f11744f = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11745g.E0(this.f11744f);
    }
}
