package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class oy implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13126f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f13127g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzdy f13128h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public oy(zzdy zzdyVar, int i2, boolean z) {
        this.f13128h = zzdyVar;
        this.f13126f = i2;
        this.f13127g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean h2;
        zzbp.zza l = this.f13128h.l(this.f13126f, this.f13127g);
        this.f13128h.f16191k = l;
        h2 = zzdy.h(this.f13126f, l);
        if (h2) {
            this.f13128h.e(this.f13126f + 1, this.f13127g);
        }
    }
}
