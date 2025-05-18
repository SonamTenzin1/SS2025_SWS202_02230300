package com.google.zxing.common.reedsolomon;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericGFPoly.java */
/* loaded from: classes2.dex */
public final class b {
    private final a a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f20319b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.a = aVar;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i2 = 1;
                while (i2 < length && iArr[i2] == 0) {
                    i2++;
                }
                if (i2 == length) {
                    this.f20319b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i2];
                this.f20319b = iArr2;
                System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
                return;
            }
            this.f20319b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    b a(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (f()) {
                return bVar;
            }
            if (bVar.f()) {
                return this;
            }
            int[] iArr = this.f20319b;
            int[] iArr2 = bVar.f20319b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
            }
            return new b(this.a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b[] b(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (!bVar.f()) {
                b e2 = this.a.e();
                int f2 = this.a.f(bVar.c(bVar.e()));
                b bVar2 = this;
                while (bVar2.e() >= bVar.e() && !bVar2.f()) {
                    int e3 = bVar2.e() - bVar.e();
                    int h2 = this.a.h(bVar2.c(bVar2.e()), f2);
                    b h3 = bVar.h(e3, h2);
                    e2 = e2.a(this.a.b(e3, h2));
                    bVar2 = bVar2.a(h3);
                }
                return new b[]{e2, bVar2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    int c(int i2) {
        return this.f20319b[(r0.length - 1) - i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() {
        return this.f20319b;
    }

    int e() {
        return this.f20319b.length - 1;
    }

    boolean f() {
        return this.f20319b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (!f() && !bVar.f()) {
                int[] iArr = this.f20319b;
                int length = iArr.length;
                int[] iArr2 = bVar.f20319b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        iArr3[i5] = a.a(iArr3[i5], this.a.h(i3, iArr2[i4]));
                    }
                }
                return new b(this.a, iArr3);
            }
            return this.a.e();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.e();
        }
        int length = this.f20319b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.h(this.f20319b[i4], i3);
        }
        return new b(this.a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int e2 = e(); e2 >= 0; e2--) {
            int c2 = c(e2);
            if (c2 != 0) {
                if (c2 < 0) {
                    sb.append(" - ");
                    c2 = -c2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (e2 == 0 || c2 != 1) {
                    int g2 = this.a.g(c2);
                    if (g2 == 0) {
                        sb.append('1');
                    } else if (g2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(g2);
                    }
                }
                if (e2 != 0) {
                    if (e2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(e2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
