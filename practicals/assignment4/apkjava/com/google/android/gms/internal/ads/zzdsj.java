package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdsj extends zzdrr<zzdsj> {

    /* renamed from: c, reason: collision with root package name */
    public Integer f16110c = null;

    /* renamed from: d, reason: collision with root package name */
    private zzdrz.zza.zzc f16111d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f16112e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f16113f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f16114g = null;

    /* renamed from: h, reason: collision with root package name */
    public zzdsk f16115h = null;

    /* renamed from: i, reason: collision with root package name */
    public zzdsp[] f16116i = zzdsp.f();

    /* renamed from: j, reason: collision with root package name */
    public String f16117j = null;

    /* renamed from: k, reason: collision with root package name */
    public zzdso f16118k = null;
    private Boolean l = null;
    private String[] m;
    private String n;
    private Boolean o;
    private Boolean p;
    private byte[] q;
    public zzdsq r;
    public String[] s;
    public String[] t;

    public zzdsj() {
        String[] strArr = zzdry.f16084f;
        this.m = strArr;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = strArr;
        this.t = strArr;
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16112e;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        String str2 = this.f16113f;
        if (str2 != null) {
            zzdrpVar.k(2, str2);
        }
        zzdsp[] zzdspVarArr = this.f16116i;
        int i2 = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.f16116i;
                if (i3 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i3];
                if (zzdspVar != null) {
                    zzdrpVar.b(4, zzdspVar);
                }
                i3++;
            }
        }
        String[] strArr = this.m;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.m;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    zzdrpVar.k(6, str3);
                }
                i4++;
            }
        }
        Integer num = this.f16110c;
        if (num != null) {
            zzdrpVar.x(10, num.intValue());
        }
        zzdsk zzdskVar = this.f16115h;
        if (zzdskVar != null) {
            zzdrpVar.b(12, zzdskVar);
        }
        String str4 = this.f16117j;
        if (str4 != null) {
            zzdrpVar.k(13, str4);
        }
        zzdso zzdsoVar = this.f16118k;
        if (zzdsoVar != null) {
            zzdrpVar.b(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.r;
        if (zzdsqVar != null) {
            zzdrpVar.b(17, zzdsqVar);
        }
        String[] strArr3 = this.s;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.s;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i5];
                if (str5 != null) {
                    zzdrpVar.k(20, str5);
                }
                i5++;
            }
        }
        String[] strArr5 = this.t;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.t;
                if (i2 >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i2];
                if (str6 != null) {
                    zzdrpVar.k(21, str6);
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
        String str = this.f16112e;
        if (str != null) {
            e2 += zzdrp.n(1, str);
        }
        String str2 = this.f16113f;
        if (str2 != null) {
            e2 += zzdrp.n(2, str2);
        }
        zzdsp[] zzdspVarArr = this.f16116i;
        int i2 = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.f16116i;
                if (i3 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i3];
                if (zzdspVar != null) {
                    e2 += zzdrp.g(4, zzdspVar);
                }
                i3++;
            }
        }
        String[] strArr = this.m;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.m;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i6++;
                    i5 += zzdrp.r(str3);
                }
                i4++;
            }
            e2 = e2 + i5 + (i6 * 1);
        }
        Integer num = this.f16110c;
        if (num != null) {
            e2 += zzdrp.d(10, num.intValue());
        }
        zzdsk zzdskVar = this.f16115h;
        if (zzdskVar != null) {
            e2 += zzdrp.g(12, zzdskVar);
        }
        String str4 = this.f16117j;
        if (str4 != null) {
            e2 += zzdrp.n(13, str4);
        }
        zzdso zzdsoVar = this.f16118k;
        if (zzdsoVar != null) {
            e2 += zzdrp.g(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.r;
        if (zzdsqVar != null) {
            e2 += zzdrp.g(17, zzdsqVar);
        }
        String[] strArr3 = this.s;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.s;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i7];
                if (str5 != null) {
                    i9++;
                    i8 += zzdrp.r(str5);
                }
                i7++;
            }
            e2 = e2 + i8 + (i9 * 2);
        }
        String[] strArr5 = this.t;
        if (strArr5 == null || strArr5.length <= 0) {
            return e2;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.t;
            if (i2 >= strArr6.length) {
                return e2 + i10 + (i11 * 2);
            }
            String str6 = strArr6[i2];
            if (str6 != null) {
                i11++;
                i10 += zzdrp.r(str6);
            }
            i2++;
        }
    }
}
