package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13674f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f13675g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f13676h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ float f13677i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzto f13678j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z30(zzto zztoVar, int i2, int i3, int i4, float f2) {
        this.f13678j = zztoVar;
        this.f13674f = i2;
        this.f13675g = i3;
        this.f13676h = i4;
        this.f13677i = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f13678j.f16775b;
        zztnVar.m(this.f13674f, this.f13675g, this.f13676h, this.f13677i);
    }
}
