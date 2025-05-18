package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
final class e0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f11750f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.b f11751g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(GoogleApiManager.b bVar, ConnectionResult connectionResult) {
        this.f11751g = bVar;
        this.f11750f = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zai zaiVar;
        Api.Client client;
        zai zaiVar2;
        Api.Client client2;
        if (!this.f11750f.e0()) {
            Map map = GoogleApiManager.this.r;
            zaiVar = this.f11751g.f11718b;
            ((GoogleApiManager.zaa) map.get(zaiVar)).E0(this.f11750f);
            return;
        }
        GoogleApiManager.b.e(this.f11751g, true);
        client = this.f11751g.a;
        if (client.requiresSignIn()) {
            this.f11751g.g();
            return;
        }
        try {
            client2 = this.f11751g.a;
            client2.getRemoteService(null, Collections.emptySet());
        } catch (SecurityException e2) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
            Map map2 = GoogleApiManager.this.r;
            zaiVar2 = this.f11751g.f11718b;
            ((GoogleApiManager.zaa) map2.get(zaiVar2)).E0(new ConnectionResult(10));
        }
    }
}
