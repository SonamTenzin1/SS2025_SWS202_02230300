package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbah f13216f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13217g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(zzaqx zzaqxVar, zzbah zzbahVar, String str) {
        this.f13216f = zzbahVar;
        this.f13217g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13216f.a(this.f13217g);
    }
}
