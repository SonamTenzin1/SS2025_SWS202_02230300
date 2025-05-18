package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzhp implements zzgf {
    private int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() throws zzgd {
        zzkh.d(this.a == 2);
        this.a = 1;
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean d();

    protected void e() throws zzgd {
    }

    @Override // com.google.android.gms.internal.ads.zzgf
    public void f(int i2, Object obj) throws zzgd {
    }

    protected void g() throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() throws zzgd {
        int i2 = this.a;
        zzkh.d((i2 == 2 || i2 == 3 || i2 == -2) ? false : true);
        this.a = -2;
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void i(long j2) throws zzgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() throws zzgd {
        zzkh.d(this.a == 2);
        this.a = 3;
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() throws zzgd {
        zzkh.d(this.a == 3);
        this.a = 2;
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void l(long j2, long j3) throws zzgd;

    protected void m(long j2, boolean z) throws zzgd {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(long j2, boolean z) throws zzgd {
        zzkh.d(this.a == 1);
        this.a = 2;
        m(j2, z);
    }

    protected abstract int o(long j2) throws zzgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int p(long j2) throws zzgd {
        zzkh.d(this.a == 0);
        int o = o(j2);
        this.a = o;
        zzkh.d(o == 0 || o == 1 || o == -1);
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long q();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean s();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long t();

    protected void u() throws zzgd {
    }

    protected void v() throws zzgd {
    }
}
