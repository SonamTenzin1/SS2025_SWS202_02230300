package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsl extends zzdrr<zzdsl> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile zzdsl[] f16120c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f16121d = null;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f16122e = null;

    public zzdsl() {
        this.f16072b = null;
        this.a = -1;
    }

    public static zzdsl[] f() {
        if (f16120c == null) {
            synchronized (zzdrv.f16079c) {
                if (f16120c == null) {
                    f16120c = new zzdsl[0];
                }
            }
        }
        return f16120c;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        zzdrpVar.c(1, this.f16121d);
        byte[] bArr = this.f16122e;
        if (bArr != null) {
            zzdrpVar.c(2, bArr);
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int e2 = super.e() + zzdrp.h(1, this.f16121d);
        byte[] bArr = this.f16122e;
        return bArr != null ? e2 + zzdrp.h(2, bArr) : e2;
    }
}
