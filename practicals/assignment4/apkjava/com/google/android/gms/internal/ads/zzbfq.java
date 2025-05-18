package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzbfq extends zzawv {
    final zzbdf a;

    /* renamed from: b, reason: collision with root package name */
    final zzbft f14426b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14427c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f14428d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfq(zzbdf zzbdfVar, zzbft zzbftVar, String str, String[] strArr) {
        this.a = zzbdfVar;
        this.f14426b = zzbftVar;
        this.f14427c = str;
        this.f14428d = strArr;
        zzk.zzmc().c(this);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        try {
            this.f14426b.x(this.f14427c, this.f14428d);
        } finally {
            zzaxi.a.post(new y9(this));
        }
    }
}
