package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxj extends zzdrr<zzxj> {

    /* renamed from: c, reason: collision with root package name */
    public Integer f16920c = null;

    /* renamed from: d, reason: collision with root package name */
    private zzwx f16921d = null;

    /* renamed from: e, reason: collision with root package name */
    private zzwt.zzb f16922e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzxk f16923f = null;

    /* renamed from: g, reason: collision with root package name */
    private zzwt.zza[] f16924g = new zzwt.zza[0];

    /* renamed from: h, reason: collision with root package name */
    private zzwt.zzc f16925h = null;

    /* renamed from: i, reason: collision with root package name */
    private zzwt.zzj f16926i = null;

    /* renamed from: j, reason: collision with root package name */
    private zzwt.zzh f16927j = null;

    /* renamed from: k, reason: collision with root package name */
    private zzwt.zze f16928k = null;
    private zzwt.zzf l = null;
    private zzxp[] m = zzxp.f();

    public zzxj() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        Integer num = this.f16920c;
        if (num != null) {
            zzdrpVar.x(7, num.intValue());
        }
        zzxk zzxkVar = this.f16923f;
        if (zzxkVar != null) {
            zzdrpVar.b(10, zzxkVar);
        }
        zzwt.zza[] zzaVarArr = this.f16924g;
        int i2 = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.f16924g;
                if (i3 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i3];
                if (zzaVar != null) {
                    zzdrpVar.j(11, zzaVar);
                }
                i3++;
            }
        }
        zzxp[] zzxpVarArr = this.m;
        if (zzxpVarArr != null && zzxpVarArr.length > 0) {
            while (true) {
                zzxp[] zzxpVarArr2 = this.m;
                if (i2 >= zzxpVarArr2.length) {
                    break;
                }
                zzxp zzxpVar = zzxpVarArr2[i2];
                if (zzxpVar != null) {
                    zzdrpVar.b(17, zzxpVar);
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
        Integer num = this.f16920c;
        if (num != null) {
            e2 += zzdrp.d(7, num.intValue());
        }
        zzxk zzxkVar = this.f16923f;
        if (zzxkVar != null) {
            e2 += zzdrp.g(10, zzxkVar);
        }
        zzwt.zza[] zzaVarArr = this.f16924g;
        int i2 = 0;
        if (zzaVarArr != null && zzaVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzwt.zza[] zzaVarArr2 = this.f16924g;
                if (i3 >= zzaVarArr2.length) {
                    break;
                }
                zzwt.zza zzaVar = zzaVarArr2[i3];
                if (zzaVar != null) {
                    e2 += zzdni.K(11, zzaVar);
                }
                i3++;
            }
        }
        zzxp[] zzxpVarArr = this.m;
        if (zzxpVarArr != null && zzxpVarArr.length > 0) {
            while (true) {
                zzxp[] zzxpVarArr2 = this.m;
                if (i2 >= zzxpVarArr2.length) {
                    break;
                }
                zzxp zzxpVar = zzxpVarArr2[i2];
                if (zzxpVar != null) {
                    e2 += zzdrp.g(17, zzxpVar);
                }
                i2++;
            }
        }
        return e2;
    }
}
