package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsm extends zzdrr<zzdsm> {

    /* renamed from: c, reason: collision with root package name */
    private zzdrz.zzb.zzd.C0182zzb f16123c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzdsl[] f16124d = zzdsl.f();

    /* renamed from: e, reason: collision with root package name */
    private byte[] f16125e = null;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f16126f = null;

    /* renamed from: g, reason: collision with root package name */
    private Integer f16127g = null;

    public zzdsm() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        zzdsl[] zzdslVarArr = this.f16124d;
        if (zzdslVarArr != null && zzdslVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdsl[] zzdslVarArr2 = this.f16124d;
                if (i2 >= zzdslVarArr2.length) {
                    break;
                }
                zzdsl zzdslVar = zzdslVarArr2[i2];
                if (zzdslVar != null) {
                    zzdrpVar.b(2, zzdslVar);
                }
                i2++;
            }
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int e2 = super.e();
        zzdsl[] zzdslVarArr = this.f16124d;
        if (zzdslVarArr != null && zzdslVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdsl[] zzdslVarArr2 = this.f16124d;
                if (i2 >= zzdslVarArr2.length) {
                    break;
                }
                zzdsl zzdslVar = zzdslVarArr2[i2];
                if (zzdslVar != null) {
                    e2 += zzdrp.g(2, zzdslVar);
                }
                i2++;
            }
        }
        return e2;
    }
}
