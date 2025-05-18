package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxn extends zzdrr<zzxn> {

    /* renamed from: c, reason: collision with root package name */
    private Integer f16942c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f16943d = null;

    /* renamed from: e, reason: collision with root package name */
    private Integer f16944e = null;

    /* renamed from: f, reason: collision with root package name */
    private zzwx f16945f = null;

    /* renamed from: g, reason: collision with root package name */
    private zzxo f16946g = null;

    /* renamed from: h, reason: collision with root package name */
    public long[] f16947h = zzdry.f16080b;

    /* renamed from: i, reason: collision with root package name */
    public zzxl f16948i = null;

    /* renamed from: j, reason: collision with root package name */
    private zzxm f16949j = null;

    /* renamed from: k, reason: collision with root package name */
    private zzwt.zzg f16950k = null;
    public zzxj l = null;
    public zzwt.zzi m = null;
    public zzwt.zzv n = null;

    public zzxn() {
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16943d;
        if (str != null) {
            zzdrpVar.k(10, str);
        }
        long[] jArr = this.f16947h;
        if (jArr != null && jArr.length > 0) {
            int i2 = 0;
            while (true) {
                long[] jArr2 = this.f16947h;
                if (i2 >= jArr2.length) {
                    break;
                }
                long j2 = jArr2[i2];
                zzdrpVar.w(14, 0);
                zzdrpVar.l(j2);
                i2++;
            }
        }
        zzxl zzxlVar = this.f16948i;
        if (zzxlVar != null) {
            zzdrpVar.b(15, zzxlVar);
        }
        zzxj zzxjVar = this.l;
        if (zzxjVar != null) {
            zzdrpVar.b(18, zzxjVar);
        }
        zzwt.zzi zziVar = this.m;
        if (zziVar != null) {
            zzdrpVar.j(19, zziVar);
        }
        zzwt.zzv zzvVar = this.n;
        if (zzvVar != null) {
            zzdrpVar.j(20, zzvVar);
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        long[] jArr;
        int e2 = super.e();
        String str = this.f16943d;
        if (str != null) {
            e2 += zzdrp.n(10, str);
        }
        long[] jArr2 = this.f16947h;
        if (jArr2 != null && jArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                jArr = this.f16947h;
                if (i2 >= jArr.length) {
                    break;
                }
                i3 += zzdrp.m(jArr[i2]);
                i2++;
            }
            e2 = e2 + i3 + (jArr.length * 1);
        }
        zzxl zzxlVar = this.f16948i;
        if (zzxlVar != null) {
            e2 += zzdrp.g(15, zzxlVar);
        }
        zzxj zzxjVar = this.l;
        if (zzxjVar != null) {
            e2 += zzdrp.g(18, zzxjVar);
        }
        zzwt.zzi zziVar = this.m;
        if (zziVar != null) {
            e2 += zzdni.K(19, zziVar);
        }
        zzwt.zzv zzvVar = this.n;
        return zzvVar != null ? e2 + zzdni.K(20, zzvVar) : e2;
    }
}
