package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
final class o implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zaak f11775f;

    private o(zaak zaakVar) {
        this.f11775f = zaakVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean w;
        lock = this.f11775f.f11805b;
        lock.lock();
        try {
            w = this.f11775f.w(connectionResult);
            if (w) {
                this.f11775f.l();
                this.f11775f.j();
            } else {
                this.f11775f.x(connectionResult);
            }
        } finally {
            lock2 = this.f11775f.f11805b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        ClientSettings clientSettings;
        zad zadVar;
        Lock lock;
        Lock lock2;
        zad zadVar2;
        zad zadVar3;
        clientSettings = this.f11775f.r;
        if (clientSettings.m()) {
            lock = this.f11775f.f11805b;
            lock.lock();
            try {
                zadVar2 = this.f11775f.f11814k;
                if (zadVar2 == null) {
                    return;
                }
                zadVar3 = this.f11775f.f11814k;
                zadVar3.d(new m(this.f11775f));
                return;
            } finally {
                lock2 = this.f11775f.f11805b;
                lock2.unlock();
            }
        }
        zadVar = this.f11775f.f11814k;
        zadVar.d(new m(this.f11775f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
