package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class c5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f17724f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17725g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c5(zzhc zzhcVar, Bundle bundle) {
        this.f17725g = zzhcVar;
        this.f17724f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17725g.A0(this.f17724f);
    }
}
