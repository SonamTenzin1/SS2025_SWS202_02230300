package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q00 {
    public final zzqj a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13200b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13201c;

    /* renamed from: d, reason: collision with root package name */
    public final zzqw[] f13202d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean[] f13203e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13204f;

    /* renamed from: g, reason: collision with root package name */
    public int f13205g;

    /* renamed from: h, reason: collision with root package name */
    public long f13206h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13207i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13208j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13209k;
    public q00 l;
    public zzrr m;
    private final zzlo[] n;
    private final zzlp[] o;
    private final zzrp p;
    private final zzll q;
    private final zzql r;
    private zzrr s;

    public q00(zzlo[] zzloVarArr, zzlp[] zzlpVarArr, long j2, zzrp zzrpVar, zzll zzllVar, zzql zzqlVar, Object obj, int i2, int i3, boolean z, long j3) {
        this.n = zzloVarArr;
        this.o = zzlpVarArr;
        this.f13204f = j2;
        this.p = zzrpVar;
        this.q = zzllVar;
        this.r = zzqlVar;
        this.f13200b = zzsk.d(obj);
        this.f13201c = i2;
        this.f13205g = i3;
        this.f13207i = z;
        this.f13206h = j3;
        this.f13202d = new zzqw[zzloVarArr.length];
        this.f13203e = new boolean[zzloVarArr.length];
        this.a = zzqlVar.b(i3, zzllVar.b());
    }

    public final void a() {
        try {
            this.r.c(this.a);
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
        }
    }

    public final long b(long j2, boolean z, boolean[] zArr) {
        zzro zzroVar = this.m.f16676b;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= zzroVar.a) {
                break;
            }
            boolean[] zArr2 = this.f13203e;
            if (z || !this.m.a(this.s, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        long c2 = this.a.c(zzroVar.b(), this.f13203e, this.f13202d, zArr, j2);
        this.s = this.m;
        this.f13209k = false;
        int i3 = 0;
        while (true) {
            zzqw[] zzqwVarArr = this.f13202d;
            if (i3 < zzqwVarArr.length) {
                if (zzqwVarArr[i3] != null) {
                    zzsk.e(zzroVar.a(i3) != null);
                    this.f13209k = true;
                } else {
                    zzsk.e(zzroVar.a(i3) == null);
                }
                i3++;
            } else {
                this.q.g(this.n, this.m.a, zzroVar);
                return c2;
            }
        }
    }

    public final void c(int i2, boolean z) {
        this.f13205g = i2;
        this.f13207i = z;
    }

    public final long d(long j2, boolean z) {
        return b(j2, false, new boolean[this.n.length]);
    }

    public final long e() {
        return this.f13204f - this.f13206h;
    }

    public final boolean f() {
        if (this.f13208j) {
            return !this.f13209k || this.a.r() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g() throws zzku {
        boolean z;
        zzrr b2 = this.p.b(this.o, this.a.l());
        zzrr zzrrVar = this.s;
        if (zzrrVar != null) {
            for (int i2 = 0; i2 < b2.f16676b.a; i2++) {
                if (b2.a(zzrrVar, i2)) {
                }
            }
            z = true;
            if (!z) {
                return false;
            }
            this.m = b2;
            return true;
        }
        z = false;
        if (!z) {
        }
    }
}
