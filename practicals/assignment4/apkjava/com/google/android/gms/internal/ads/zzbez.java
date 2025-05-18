package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzbez implements zzll {
    private final zzrz a;

    /* renamed from: b, reason: collision with root package name */
    private long f14414b;

    /* renamed from: c, reason: collision with root package name */
    private long f14415c;

    /* renamed from: d, reason: collision with root package name */
    private long f14416d;

    /* renamed from: e, reason: collision with root package name */
    private long f14417e;

    /* renamed from: f, reason: collision with root package name */
    private int f14418f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14419g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbez() {
        this(15000, 30000, 2500L, 5000L);
    }

    @VisibleForTesting
    private final void l(boolean z) {
        this.f14418f = 0;
        this.f14419g = false;
        if (z) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void a() {
        l(false);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final zzrt b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final synchronized boolean c(long j2, boolean z) {
        long j3;
        j3 = z ? this.f14417e : this.f14416d;
        return j3 <= 0 || j2 >= j3;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final synchronized boolean d(long j2) {
        boolean z;
        z = false;
        char c2 = j2 > this.f14415c ? (char) 0 : j2 < this.f14414b ? (char) 2 : (char) 1;
        boolean z2 = this.a.d() >= this.f14418f;
        if (c2 == 2 || (c2 == 1 && this.f14419g && !z2)) {
            z = true;
        }
        this.f14419g = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void e() {
        l(true);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void f() {
        l(true);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void g(zzlo[] zzloVarArr, zzrb zzrbVar, zzro zzroVar) {
        this.f14418f = 0;
        for (int i2 = 0; i2 < zzloVarArr.length; i2++) {
            if (zzroVar.a(i2) != null) {
                this.f14418f += zzsy.p(zzloVarArr[i2].E());
            }
        }
        this.a.c(this.f14418f);
    }

    public final synchronized void h(int i2) {
        this.f14416d = i2 * 1000;
    }

    public final synchronized void i(int i2) {
        this.f14417e = i2 * 1000;
    }

    public final synchronized void j(int i2) {
        this.f14414b = i2 * 1000;
    }

    public final synchronized void k(int i2) {
        this.f14415c = i2 * 1000;
    }

    private zzbez(int i2, int i3, long j2, long j3) {
        this.a = new zzrz(true, 65536);
        this.f14414b = 15000000L;
        this.f14415c = 30000000L;
        this.f14416d = 2500000L;
        this.f14417e = 5000000L;
    }
}
