package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzks implements zzlo, zzlp {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private zzlq f16400b;

    /* renamed from: c, reason: collision with root package name */
    private int f16401c;

    /* renamed from: d, reason: collision with root package name */
    private int f16402d;

    /* renamed from: e, reason: collision with root package name */
    private zzqw f16403e;

    /* renamed from: f, reason: collision with root package name */
    private long f16404f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f16405g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16406h;

    public zzks(int i2) {
        this.a = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void D(int i2) {
        this.f16401c = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzlo, com.google.android.gms.internal.ads.zzlp
    public final int E() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void F(zzlq zzlqVar, zzlh[] zzlhVarArr, zzqw zzqwVar, long j2, boolean z, long j3) throws zzku {
        zzsk.e(this.f16402d == 0);
        this.f16400b = zzlqVar;
        this.f16402d = 1;
        o(z);
        P(zzlhVarArr, zzqwVar, j3);
        l(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzlp G() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public zzso H() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void I() throws IOException {
        this.f16403e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void J() {
        this.f16406h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final boolean K() {
        return this.f16406h;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void L() {
        zzsk.e(this.f16402d == 1);
        this.f16402d = 0;
        this.f16403e = null;
        this.f16406h = false;
        n();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void M(long j2) throws zzku {
        this.f16406h = false;
        this.f16405g = false;
        l(j2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final zzqw N() {
        return this.f16403e;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void P(zzlh[] zzlhVarArr, zzqw zzqwVar, long j2) throws zzku {
        zzsk.e(!this.f16406h);
        this.f16403e = zzqwVar;
        this.f16405g = false;
        this.f16404f = j2;
        k(zzlhVarArr, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final boolean Q() {
        return this.f16405g;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public int a() throws zzku {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public void f(int i2, Object obj) throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.f16401c;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final int getState() {
        return this.f16402d;
    }

    protected void h() throws zzku {
    }

    protected void i() throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int j(zzlj zzljVar, zznd zzndVar, boolean z) {
        int c2 = this.f16403e.c(zzljVar, zzndVar, z);
        if (c2 == -4) {
            if (zzndVar.f()) {
                this.f16405g = true;
                return this.f16406h ? -4 : -3;
            }
            zzndVar.f16503d += this.f16404f;
        } else if (c2 == -5) {
            zzlh zzlhVar = zzljVar.a;
            long j2 = zzlhVar.B;
            if (j2 != Long.MAX_VALUE) {
                zzljVar.a = zzlhVar.l(j2 + this.f16404f);
            }
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(zzlh[] zzlhVarArr, long j2) throws zzku {
    }

    protected void l(long j2, boolean z) throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(long j2) {
        this.f16403e.b(j2 - this.f16404f);
    }

    protected void n() {
    }

    protected void o(boolean z) throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlq p() {
        return this.f16400b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean q() {
        return this.f16405g ? this.f16406h : this.f16403e.B();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void start() throws zzku {
        zzsk.e(this.f16402d == 1);
        this.f16402d = 2;
        h();
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void stop() throws zzku {
        zzsk.e(this.f16402d == 2);
        this.f16402d = 1;
        i();
    }
}
