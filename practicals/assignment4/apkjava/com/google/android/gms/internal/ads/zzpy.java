package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzpy implements zzqx {

    /* renamed from: f, reason: collision with root package name */
    private final zzqx[] f16599f;

    public zzpy(zzqx[] zzqxVarArr) {
        this.f16599f = zzqxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final long a() {
        long j2 = Long.MAX_VALUE;
        for (zzqx zzqxVar : this.f16599f) {
            long a = zzqxVar.a();
            if (a != Long.MIN_VALUE) {
                j2 = Math.min(j2, a);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final boolean b(long j2) {
        boolean z;
        boolean z2 = false;
        do {
            long a = a();
            if (a == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzqx zzqxVar : this.f16599f) {
                if (zzqxVar.a() == a) {
                    z |= zzqxVar.b(j2);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
