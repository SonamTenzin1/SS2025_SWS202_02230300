package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class z4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f18045f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18046g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(zzhc zzhcVar, Bundle bundle) {
        this.f18046g = zzhcVar;
        this.f18045f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18046g.x0(this.f18045f);
    }
}
