package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class n20 {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f13013b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f13014c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13015d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f13016e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f13017f;

    public n20(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        zzsk.a(iArr.length == jArr2.length);
        zzsk.a(jArr.length == jArr2.length);
        zzsk.a(iArr2.length == jArr2.length);
        this.f13013b = jArr;
        this.f13014c = iArr;
        this.f13015d = i2;
        this.f13016e = jArr2;
        this.f13017f = iArr2;
        this.a = jArr.length;
    }

    public final int a(long j2) {
        for (int b2 = zzsy.b(this.f13016e, j2, true, false); b2 >= 0; b2--) {
            if ((this.f13017f[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }

    public final int b(long j2) {
        for (int k2 = zzsy.k(this.f13016e, j2, true, false); k2 < this.f13016e.length; k2++) {
            if ((this.f13017f[k2] & 1) != 0) {
                return k2;
            }
        }
        return -1;
    }
}
