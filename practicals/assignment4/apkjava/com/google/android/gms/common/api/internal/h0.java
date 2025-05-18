package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class h0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Result f11759f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zacm f11760g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(zacm zacmVar, Result result) {
        this.f11760g = zacmVar;
        this.f11759f = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        ResultTransform resultTransform;
        i0 unused;
        i0 unused2;
        i0 unused3;
        i0 unused4;
        try {
            try {
                BasePendingResult.a.set(Boolean.TRUE);
                resultTransform = this.f11760g.a;
                resultTransform.b(this.f11759f);
                unused = this.f11760g.f11848g;
                unused2 = this.f11760g.f11848g;
                throw null;
            } catch (RuntimeException unused5) {
                unused3 = this.f11760g.f11848g;
                unused4 = this.f11760g.f11848g;
                throw null;
            }
        } catch (Throwable th) {
            BasePendingResult.a.set(Boolean.FALSE);
            zacm zacmVar = this.f11760g;
            zacm.c(this.f11759f);
            weakReference = this.f11760g.f11847f;
            GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
            if (googleApiClient != null) {
                googleApiClient.v(this.f11760g);
            }
            throw th;
        }
    }
}
