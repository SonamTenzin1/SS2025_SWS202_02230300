package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsp extends zzdrr<zzdsp> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile zzdsp[] f16131c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f16132d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f16133e = null;

    /* renamed from: f, reason: collision with root package name */
    public zzdsm f16134f = null;

    /* renamed from: g, reason: collision with root package name */
    private zzdsn f16135g = null;

    /* renamed from: h, reason: collision with root package name */
    private Integer f16136h = null;

    /* renamed from: i, reason: collision with root package name */
    private int[] f16137i = zzdry.a;

    /* renamed from: j, reason: collision with root package name */
    private String f16138j = null;

    /* renamed from: k, reason: collision with root package name */
    public Integer f16139k = null;
    public String[] l = zzdry.f16084f;

    public zzdsp() {
        this.f16072b = null;
        this.a = -1;
    }

    public static zzdsp[] f() {
        if (f16131c == null) {
            synchronized (zzdrv.f16079c) {
                if (f16131c == null) {
                    f16131c = new zzdsp[0];
                }
            }
        }
        return f16131c;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        zzdrpVar.x(1, this.f16132d.intValue());
        String str = this.f16133e;
        if (str != null) {
            zzdrpVar.k(2, str);
        }
        zzdsm zzdsmVar = this.f16134f;
        if (zzdsmVar != null) {
            zzdrpVar.b(3, zzdsmVar);
        }
        int[] iArr = this.f16137i;
        int i2 = 0;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f16137i;
                if (i3 >= iArr2.length) {
                    break;
                }
                zzdrpVar.x(6, iArr2[i3]);
                i3++;
            }
        }
        Integer num = this.f16139k;
        if (num != null) {
            zzdrpVar.x(8, num.intValue());
        }
        String[] strArr = this.l;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.l;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i2];
                if (str2 != null) {
                    zzdrpVar.k(9, str2);
                }
                i2++;
            }
        }
        super.a(zzdrpVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final int e() {
        int[] iArr;
        int e2 = super.e() + zzdrp.d(1, this.f16132d.intValue());
        String str = this.f16133e;
        if (str != null) {
            e2 += zzdrp.n(2, str);
        }
        zzdsm zzdsmVar = this.f16134f;
        if (zzdsmVar != null) {
            e2 += zzdrp.g(3, zzdsmVar);
        }
        int[] iArr2 = this.f16137i;
        int i2 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                iArr = this.f16137i;
                if (i3 >= iArr.length) {
                    break;
                }
                i4 += zzdrp.p(iArr[i3]);
                i3++;
            }
            e2 = e2 + i4 + (iArr.length * 1);
        }
        Integer num = this.f16139k;
        if (num != null) {
            e2 += zzdrp.d(8, num.intValue());
        }
        String[] strArr = this.l;
        if (strArr == null || strArr.length <= 0) {
            return e2;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr2 = this.l;
            if (i2 >= strArr2.length) {
                return e2 + i5 + (i6 * 1);
            }
            String str2 = strArr2[i2];
            if (str2 != null) {
                i6++;
                i5 += zzdrp.r(str2);
            }
            i2++;
        }
    }
}
