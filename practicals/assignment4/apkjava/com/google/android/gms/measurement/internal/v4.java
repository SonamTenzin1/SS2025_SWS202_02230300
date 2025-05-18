package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class v4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17989f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17990g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f17991h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Bundle f17992i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f17993j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ boolean f17994k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ String m;
    private final /* synthetic */ zzhc n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v4(zzhc zzhcVar, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.n = zzhcVar;
        this.f17989f = str;
        this.f17990g = str2;
        this.f17991h = j2;
        this.f17992i = bundle;
        this.f17993j = z;
        this.f17994k = z2;
        this.l = z3;
        this.m = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.Q(this.f17989f, this.f17990g, this.f17991h, this.f17992i, this.f17993j, this.f17994k, this.l, this.m);
    }
}
