package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsq extends zzdrr<zzdsq> {

    /* renamed from: c, reason: collision with root package name */
    public String f16140c = null;

    /* renamed from: d, reason: collision with root package name */
    public Long f16141d = null;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f16142e = null;

    public zzdsq() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16140c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        Long l = this.f16141d;
        if (l != null) {
            long longValue = l.longValue();
            zzdrpVar.w(2, 0);
            zzdrpVar.l(longValue);
        }
        Boolean bool = this.f16142e;
        if (bool != null) {
            zzdrpVar.u(3, bool.booleanValue());
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int e2 = super.e();
        String str = this.f16140c;
        if (str != null) {
            e2 += zzdrp.n(1, str);
        }
        Long l = this.f16141d;
        if (l != null) {
            e2 += zzdrp.o(2) + zzdrp.m(l.longValue());
        }
        Boolean bool = this.f16142e;
        if (bool == null) {
            return e2;
        }
        bool.booleanValue();
        return e2 + zzdrp.o(3) + 1;
    }
}
