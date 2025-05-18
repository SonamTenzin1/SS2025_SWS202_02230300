package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
final class c30 implements zzsh {
    private final Uri a;

    /* renamed from: b, reason: collision with root package name */
    private final zzrv f12385b;

    /* renamed from: c, reason: collision with root package name */
    private final d30 f12386c;

    /* renamed from: d, reason: collision with root package name */
    private final zzsm f12387d;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f12389f;

    /* renamed from: h, reason: collision with root package name */
    private long f12391h;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ x20 f12393j;

    /* renamed from: e, reason: collision with root package name */
    private final zznt f12388e = new zznt();

    /* renamed from: g, reason: collision with root package name */
    private boolean f12390g = true;

    /* renamed from: i, reason: collision with root package name */
    private long f12392i = -1;

    public c30(x20 x20Var, Uri uri, zzrv zzrvVar, d30 d30Var, zzsm zzsmVar) {
        this.f12393j = x20Var;
        this.a = (Uri) zzsk.d(uri);
        this.f12385b = (zzrv) zzsk.d(zzrvVar);
        this.f12386c = (d30) zzsk.d(d30Var);
        this.f12387d = zzsmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final boolean a() {
        return this.f12389f;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void b() {
        this.f12389f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsh
    public final void c() throws IOException, InterruptedException {
        long j2;
        zznm zznmVar;
        int i2 = 0;
        while (i2 == 0 && !this.f12389f) {
            zznm zznmVar2 = null;
            try {
                j2 = this.f12388e.a;
                long a = this.f12385b.a(new zzry(this.a, j2, -1L, x20.B(this.f12393j)));
                this.f12392i = a;
                if (a != -1) {
                    this.f12392i = a + j2;
                }
                zznmVar = new zznm(this.f12385b, j2, this.f12392i);
            } catch (Throwable th) {
                th = th;
            }
            try {
                zznn b2 = this.f12386c.b(zznmVar, this.f12385b.I0());
                if (this.f12390g) {
                    b2.h(j2, this.f12391h);
                    this.f12390g = false;
                }
                while (i2 == 0 && !this.f12389f) {
                    this.f12387d.a();
                    i2 = b2.d(zznmVar, this.f12388e);
                    if (zznmVar.getPosition() > x20.E(this.f12393j) + j2) {
                        j2 = zznmVar.getPosition();
                        this.f12387d.c();
                        x20.G(this.f12393j).post(x20.F(this.f12393j));
                    }
                }
                if (i2 == 1) {
                    i2 = 0;
                } else {
                    this.f12388e.a = zznmVar.getPosition();
                }
                zzsy.e(this.f12385b);
            } catch (Throwable th2) {
                th = th2;
                zznmVar2 = zznmVar;
                if (i2 != 1 && zznmVar2 != null) {
                    this.f12388e.a = zznmVar2.getPosition();
                }
                zzsy.e(this.f12385b);
                throw th;
            }
        }
    }

    public final void e(long j2, long j3) {
        this.f12388e.a = j2;
        this.f12391h = j3;
        this.f12390g = true;
    }
}
