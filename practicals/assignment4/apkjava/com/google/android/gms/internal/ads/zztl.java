package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zztl {
    private final u30 a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16765b;

    /* renamed from: c, reason: collision with root package name */
    private final long f16766c;

    /* renamed from: d, reason: collision with root package name */
    private final long f16767d;

    /* renamed from: e, reason: collision with root package name */
    private long f16768e;

    /* renamed from: f, reason: collision with root package name */
    private long f16769f;

    /* renamed from: g, reason: collision with root package name */
    private long f16770g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16771h;

    /* renamed from: i, reason: collision with root package name */
    private long f16772i;

    /* renamed from: j, reason: collision with root package name */
    private long f16773j;

    /* renamed from: k, reason: collision with root package name */
    private long f16774k;

    public zztl() {
        this(-1.0d);
    }

    private final boolean d(long j2, long j3) {
        return Math.abs((j3 - this.f16772i) - (j2 - this.f16773j)) > 20000000;
    }

    public final void a() {
        if (this.f16765b) {
            this.a.c();
        }
    }

    public final void b() {
        this.f16771h = false;
        if (this.f16765b) {
            this.a.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long c(long j2, long j3) {
        long j4;
        long j5;
        u30 u30Var;
        long j6;
        long j7 = 1000 * j2;
        if (this.f16771h) {
            if (j2 != this.f16768e) {
                this.f16774k++;
                this.f16769f = this.f16770g;
            }
            long j8 = this.f16774k;
            if (j8 >= 6) {
                j5 = this.f16769f + ((j7 - this.f16773j) / j8);
                if (d(j5, j3)) {
                    this.f16771h = false;
                } else {
                    j4 = (this.f16772i + j5) - this.f16773j;
                    if (!this.f16771h) {
                        this.f16773j = j7;
                        this.f16772i = j3;
                        this.f16774k = 0L;
                        this.f16771h = true;
                    }
                    this.f16768e = j2;
                    this.f16770g = j5;
                    u30Var = this.a;
                    if (u30Var != null || u30Var.f13380g == 0) {
                        return j4;
                    }
                    long j9 = this.a.f13380g;
                    long j10 = this.f16766c;
                    long j11 = j9 + (((j4 - j9) / j10) * j10);
                    if (j4 <= j11) {
                        j6 = j11 - j10;
                    } else {
                        j11 = j10 + j11;
                        j6 = j11;
                    }
                    if (j11 - j4 >= j4 - j6) {
                        j11 = j6;
                    }
                    return j11 - this.f16767d;
                }
            } else if (d(j7, j3)) {
                this.f16771h = false;
            }
        }
        j4 = j3;
        j5 = j7;
        if (!this.f16771h) {
        }
        this.f16768e = j2;
        this.f16770g = j5;
        u30Var = this.a;
        if (u30Var != null) {
        }
        return j4;
    }

    public zztl(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zztl(double d2) {
        boolean z = d2 != -1.0d;
        this.f16765b = z;
        if (z) {
            this.a = u30.a();
            long j2 = (long) (1.0E9d / d2);
            this.f16766c = j2;
            this.f16767d = (j2 * 80) / 100;
            return;
        }
        this.a = null;
        this.f16766c = -1L;
        this.f16767d = -1L;
    }
}
