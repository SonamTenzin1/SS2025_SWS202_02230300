package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x5 extends zzax {
    private final /* synthetic */ byte[] w;
    private final /* synthetic */ Map x;
    private final /* synthetic */ zzazx y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(zzayu zzayuVar, int i2, String str, zzaa zzaaVar, zzz zzzVar, byte[] bArr, Map map, zzazx zzazxVar) {
        super(i2, str, zzaaVar, zzzVar);
        this.w = bArr;
        this.x = map;
        this.y = zzazxVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzax, com.google.android.gms.internal.ads.zzr
    public final /* synthetic */ void F(String str) {
        F(str);
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final byte[] O() throws zza {
        byte[] bArr = this.w;
        return bArr == null ? super.O() : bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzax
    /* renamed from: V */
    public final void F(String str) {
        this.y.p(str);
        super.F(str);
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final Map<String, String> g() throws zza {
        Map<String, String> map = this.x;
        return map == null ? super.g() : map;
    }
}
