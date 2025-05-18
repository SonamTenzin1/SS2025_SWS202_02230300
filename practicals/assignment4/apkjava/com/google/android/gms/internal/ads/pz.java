package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes2.dex */
final class pz implements zzkc {
    private final Uri a;

    /* renamed from: b, reason: collision with root package name */
    private final zzjp f13191b;

    /* renamed from: c, reason: collision with root package name */
    private final zzid f13192c;

    /* renamed from: d, reason: collision with root package name */
    private final zzjr f13193d;

    /* renamed from: e, reason: collision with root package name */
    private final int f13194e;

    /* renamed from: f, reason: collision with root package name */
    private final zzij f13195f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f13196g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13197h;

    public pz(Uri uri, zzjp zzjpVar, zzid zzidVar, zzjr zzjrVar, int i2, long j2) {
        this.a = (Uri) zzkh.c(uri);
        this.f13191b = (zzjp) zzkh.c(zzjpVar);
        this.f13192c = (zzid) zzkh.c(zzidVar);
        this.f13193d = (zzjr) zzkh.c(zzjrVar);
        this.f13194e = i2;
        zzij zzijVar = new zzij();
        this.f13195f = zzijVar;
        zzijVar.a = j2;
        this.f13197h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean a() {
        return this.f13196g;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void b() {
        this.f13196g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void c() throws IOException, InterruptedException {
        if (this.f13197h) {
            this.f13192c.e();
            this.f13197h = false;
        }
        int i2 = 0;
        while (i2 == 0 && !this.f13196g) {
            zzib zzibVar = null;
            try {
                long j2 = this.f13195f.a;
                long a = this.f13191b.a(new zzjq(this.a, j2, -1L, null));
                if (a != -1) {
                    a += j2;
                }
                zzib zzibVar2 = new zzib(this.f13191b, j2, a);
                while (i2 == 0) {
                    try {
                        if (this.f13196g) {
                            break;
                        }
                        this.f13193d.d(this.f13194e);
                        i2 = this.f13192c.c(zzibVar2, this.f13195f);
                    } catch (Throwable th) {
                        th = th;
                        zzibVar = zzibVar2;
                        if (i2 != 1 && zzibVar != null) {
                            this.f13195f.a = zzibVar.getPosition();
                        }
                        this.f13191b.close();
                        throw th;
                    }
                }
                if (i2 == 1) {
                    i2 = 0;
                } else {
                    this.f13195f.a = zzibVar2.getPosition();
                }
                this.f13191b.close();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
