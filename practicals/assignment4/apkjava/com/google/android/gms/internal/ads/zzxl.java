package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxl extends zzdrr<zzxl> {

    /* renamed from: c, reason: collision with root package name */
    public String f16934c = null;

    /* renamed from: d, reason: collision with root package name */
    private zzwt.zzn f16935d = null;

    /* renamed from: e, reason: collision with root package name */
    private Integer f16936e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzxo f16937f = null;

    /* renamed from: g, reason: collision with root package name */
    private Integer f16938g = null;

    /* renamed from: h, reason: collision with root package name */
    private zzwx f16939h = null;

    /* renamed from: i, reason: collision with root package name */
    private zzwx f16940i = null;

    /* renamed from: j, reason: collision with root package name */
    private zzwx f16941j = null;

    public zzxl() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16934c;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        zzxo zzxoVar = this.f16937f;
        if (zzxoVar != null) {
            zzdrpVar.b(4, zzxoVar);
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int e2 = super.e();
        String str = this.f16934c;
        if (str != null) {
            e2 += zzdrp.n(1, str);
        }
        zzxo zzxoVar = this.f16937f;
        return zzxoVar != null ? e2 + zzdrp.g(4, zzxoVar) : e2;
    }
}
