package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public class u1 extends v1 {

    /* renamed from: j, reason: collision with root package name */
    protected final byte[] f17261j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(byte[] bArr) {
        bArr.getClass();
        this.f17261j = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.v1
    final boolean A(zzdu zzduVar, int i2, int i3) {
        if (i3 <= zzduVar.f()) {
            if (i3 <= zzduVar.f()) {
                if (zzduVar instanceof u1) {
                    u1 u1Var = (u1) zzduVar;
                    byte[] bArr = this.f17261j;
                    byte[] bArr2 = u1Var.f17261j;
                    int C = C() + i3;
                    int C2 = C();
                    int C3 = u1Var.C();
                    while (C2 < C) {
                        if (bArr[C2] != bArr2[C3]) {
                            return false;
                        }
                        C2++;
                        C3++;
                    }
                    return true;
                }
                return zzduVar.i(0, i3).equals(i(0, i3));
            }
            int f2 = zzduVar.f();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i3);
            sb.append(", ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        }
        int f3 = f();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(f3);
        throw new IllegalArgumentException(sb2.toString());
    }

    protected int C() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte c(int i2) {
        return this.f17261j[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdu) || f() != ((zzdu) obj).f()) {
            return false;
        }
        if (f() == 0) {
            return true;
        }
        if (obj instanceof u1) {
            u1 u1Var = (u1) obj;
            int z = z();
            int z2 = u1Var.z();
            if (z == 0 || z2 == 0 || z == z2) {
                return A(u1Var, 0, f());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public int f() {
        return this.f17261j.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final int h(int i2, int i3, int i4) {
        return zzff.a(i2, this.f17261j, C(), i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final zzdu i(int i2, int i3) {
        int v = zzdu.v(0, i3, f());
        if (v == 0) {
            return zzdu.f17368f;
        }
        return new s1(this.f17261j, C(), v);
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    protected final String r(Charset charset) {
        return new String(this.f17261j, C(), f(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void s(zzdv zzdvVar) throws IOException {
        zzdvVar.a(this.f17261j, C(), f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdu
    public byte t(int i2) {
        return this.f17261j[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final boolean y() {
        int C = C();
        return n4.g(this.f17261j, C, f() + C);
    }
}
