package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxo extends zzdrr<zzxo> {

    /* renamed from: c, reason: collision with root package name */
    public Integer f16951c = null;

    /* renamed from: d, reason: collision with root package name */
    public Integer f16952d = null;

    /* renamed from: e, reason: collision with root package name */
    public Integer f16953e = null;

    public zzxo() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        Integer num = this.f16951c;
        if (num != null) {
            zzdrpVar.x(1, num.intValue());
        }
        Integer num2 = this.f16952d;
        if (num2 != null) {
            zzdrpVar.x(2, num2.intValue());
        }
        Integer num3 = this.f16953e;
        if (num3 != null) {
            zzdrpVar.x(3, num3.intValue());
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int e2 = super.e();
        Integer num = this.f16951c;
        if (num != null) {
            e2 += zzdrp.d(1, num.intValue());
        }
        Integer num2 = this.f16952d;
        if (num2 != null) {
            e2 += zzdrp.d(2, num2.intValue());
        }
        Integer num3 = this.f16953e;
        return num3 != null ? e2 + zzdrp.d(3, num3.intValue()) : e2;
    }
}
