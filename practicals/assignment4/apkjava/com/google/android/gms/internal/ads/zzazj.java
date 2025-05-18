package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzazj {
    private long a;

    /* renamed from: b, reason: collision with root package name */
    private long f14299b = Long.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private final Object f14300c = new Object();

    public zzazj(long j2) {
        this.a = j2;
    }

    public final boolean a() {
        synchronized (this.f14300c) {
            long b2 = zzk.zzln().b();
            if (this.f14299b + this.a > b2) {
                return false;
            }
            this.f14299b = b2;
            return true;
        }
    }

    public final void b(long j2) {
        synchronized (this.f14300c) {
            this.a = j2;
        }
    }
}
