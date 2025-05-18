package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zaak f11754f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zaak zaakVar) {
        this.f11754f = zaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        googleApiAvailabilityLight = this.f11754f.f11807d;
        context = this.f11754f.f11806c;
        googleApiAvailabilityLight.a(context);
    }
}
