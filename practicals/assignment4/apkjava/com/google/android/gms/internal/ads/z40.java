package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z40 implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvv f13680f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13681g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzwb f13682h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z40(zzwb zzwbVar, zzvv zzvvVar, zzbbr zzbbrVar) {
        this.f13682h = zzwbVar;
        this.f13680f = zzvvVar;
        this.f13681g = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        Object obj;
        boolean z;
        final zzvu zzvuVar;
        obj = this.f13682h.f16871d;
        synchronized (obj) {
            z = this.f13682h.f16869b;
            if (z) {
                return;
            }
            zzwb.c(this.f13682h, true);
            zzvuVar = this.f13682h.a;
            if (zzvuVar == null) {
                return;
            }
            final zzvv zzvvVar = this.f13680f;
            final zzbbr zzbbrVar = this.f13681g;
            final zzbbh<?> b2 = zzaxg.b(new Runnable(this, zzvuVar, zzvvVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.a50

                /* renamed from: f, reason: collision with root package name */
                private final z40 f12219f;

                /* renamed from: g, reason: collision with root package name */
                private final zzvu f12220g;

                /* renamed from: h, reason: collision with root package name */
                private final zzvv f12221h;

                /* renamed from: i, reason: collision with root package name */
                private final zzbbr f12222i;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12219f = this;
                    this.f12220g = zzvuVar;
                    this.f12221h = zzvvVar;
                    this.f12222i = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    z40 z40Var = this.f12219f;
                    zzvu zzvuVar2 = this.f12220g;
                    zzvv zzvvVar2 = this.f12221h;
                    zzbbr zzbbrVar2 = this.f12222i;
                    try {
                        zzvs F4 = zzvuVar2.e().F4(zzvvVar2);
                        if (!F4.y()) {
                            zzbbrVar2.c(new RuntimeException("No entry contents."));
                            z40Var.f13682h.a();
                            return;
                        }
                        c50 c50Var = new c50(z40Var, F4.z(), 1);
                        int read = c50Var.read();
                        if (read != -1) {
                            c50Var.unread(read);
                            zzbbrVar2.a(c50Var);
                            return;
                        }
                        throw new IOException("Unable to read from cache.");
                    } catch (RemoteException | IOException e2) {
                        zzbad.c("Unable to obtain a cache service instance.", e2);
                        zzbbrVar2.c(e2);
                        z40Var.f13682h.a();
                    }
                }
            });
            final zzbbr zzbbrVar2 = this.f13681g;
            zzbbrVar2.k(new Runnable(zzbbrVar2, b2) { // from class: com.google.android.gms.internal.ads.b50

                /* renamed from: f, reason: collision with root package name */
                private final zzbbr f12316f;

                /* renamed from: g, reason: collision with root package name */
                private final Future f12317g;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12316f = zzbbrVar2;
                    this.f12317g = b2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbr zzbbrVar3 = this.f12316f;
                    Future future = this.f12317g;
                    if (zzbbrVar3.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzbbm.f14331b);
        }
    }
}
