package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class b5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17702f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17703g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17704h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17705i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzhc f17706j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b5(zzhc zzhcVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f17706j = zzhcVar;
        this.f17702f = atomicReference;
        this.f17703g = str;
        this.f17704h = str2;
        this.f17705i = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17706j.a.R().T(this.f17702f, this.f17703g, this.f17704h, this.f17705i);
    }
}
