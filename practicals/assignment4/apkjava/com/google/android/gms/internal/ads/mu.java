package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class mu extends lu {

    /* renamed from: j, reason: collision with root package name */
    protected final byte[] f12995j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mu(byte[] bArr) {
        bArr.getClass();
        this.f12995j = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdmr C(int i2, int i3) {
        int y = zzdmr.y(0, i3, size());
        if (y == 0) {
            return zzdmr.f15982f;
        }
        return new hu(this.f12995j, F(), y);
    }

    @Override // com.google.android.gms.internal.ads.lu
    final boolean E(zzdmr zzdmrVar, int i2, int i3) {
        if (i3 <= zzdmrVar.size()) {
            if (i3 <= zzdmrVar.size()) {
                if (zzdmrVar instanceof mu) {
                    mu muVar = (mu) zzdmrVar;
                    byte[] bArr = this.f12995j;
                    byte[] bArr2 = muVar.f12995j;
                    int F = F() + i3;
                    int F2 = F();
                    int F3 = muVar.F();
                    while (F2 < F) {
                        if (bArr[F2] != bArr2[F3]) {
                            return false;
                        }
                        F2++;
                        F3++;
                    }
                    return true;
                }
                return zzdmrVar.C(0, i3).equals(C(0, i3));
            }
            int size = zzdmrVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i3);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int F() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdmr) || size() != ((zzdmr) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof mu) {
            mu muVar = (mu) obj;
            int r = r();
            int r2 = muVar.r();
            if (r == 0 || r2 == 0 || r == r2) {
                return E(muVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final String f(Charset charset) {
        return new String(this.f12995j, F(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdmr
    public final void g(zzdmq zzdmqVar) throws IOException {
        zzdmqVar.a(this.f12995j, F(), size());
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected void h(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f12995j, 0, bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final boolean o() {
        int F = F();
        return jx.k(this.f12995j, F, size() + F);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public final zzdnd q() {
        return zzdnd.v(this.f12995j, F(), size(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public int size() {
        return this.f12995j.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    protected final int u(int i2, int i3, int i4) {
        return zzdod.c(i2, this.f12995j, F(), i4);
    }

    @Override // com.google.android.gms.internal.ads.zzdmr
    public byte v(int i2) {
        return this.f12995j[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdmr
    public byte w(int i2) {
        return this.f12995j[i2];
    }
}
