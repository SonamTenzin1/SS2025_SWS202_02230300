package c.g.b;

import c.g.b.b;
import java.util.Arrays;

/* compiled from: SolverVariableValues.java */
/* loaded from: classes.dex */
public class j implements b.a {
    private static float a = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final int f3033b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f3034c = 16;

    /* renamed from: d, reason: collision with root package name */
    private int f3035d = 16;

    /* renamed from: e, reason: collision with root package name */
    int[] f3036e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    int[] f3037f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    int[] f3038g = new int[16];

    /* renamed from: h, reason: collision with root package name */
    float[] f3039h = new float[16];

    /* renamed from: i, reason: collision with root package name */
    int[] f3040i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    int[] f3041j = new int[16];

    /* renamed from: k, reason: collision with root package name */
    int f3042k = 0;
    int l = -1;
    private final b m;
    protected final c n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, c cVar) {
        this.m = bVar;
        this.n = cVar;
        clear();
    }

    private void l(i iVar, int i2) {
        int[] iArr;
        int i3 = iVar.f3019d % this.f3035d;
        int[] iArr2 = this.f3036e;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f3037f;
                if (iArr[i4] == -1) {
                    break;
                } else {
                    i4 = iArr[i4];
                }
            }
            iArr[i4] = i2;
        }
        this.f3037f[i2] = -1;
    }

    private void m(int i2, i iVar, float f2) {
        this.f3038g[i2] = iVar.f3019d;
        this.f3039h[i2] = f2;
        this.f3040i[i2] = -1;
        this.f3041j[i2] = -1;
        iVar.a(this.m);
        iVar.n++;
        this.f3042k++;
    }

    private int n() {
        for (int i2 = 0; i2 < this.f3034c; i2++) {
            if (this.f3038g[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void o() {
        int i2 = this.f3034c * 2;
        this.f3038g = Arrays.copyOf(this.f3038g, i2);
        this.f3039h = Arrays.copyOf(this.f3039h, i2);
        this.f3040i = Arrays.copyOf(this.f3040i, i2);
        this.f3041j = Arrays.copyOf(this.f3041j, i2);
        this.f3037f = Arrays.copyOf(this.f3037f, i2);
        for (int i3 = this.f3034c; i3 < i2; i3++) {
            this.f3038g[i3] = -1;
            this.f3037f[i3] = -1;
        }
        this.f3034c = i2;
    }

    private void q(int i2, i iVar, float f2) {
        int n = n();
        m(n, iVar, f2);
        if (i2 != -1) {
            this.f3040i[n] = i2;
            int[] iArr = this.f3041j;
            iArr[n] = iArr[i2];
            iArr[i2] = n;
        } else {
            this.f3040i[n] = -1;
            if (this.f3042k > 0) {
                this.f3041j[n] = this.l;
                this.l = n;
            } else {
                this.f3041j[n] = -1;
            }
        }
        int[] iArr2 = this.f3041j;
        if (iArr2[n] != -1) {
            this.f3040i[iArr2[n]] = n;
        }
        l(iVar, n);
    }

    private void r(i iVar) {
        int[] iArr;
        int i2 = iVar.f3019d;
        int i3 = i2 % this.f3035d;
        int[] iArr2 = this.f3036e;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.f3038g[i4] == i2) {
            int[] iArr3 = this.f3037f;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.f3037f;
            if (iArr[i4] == -1 || this.f3038g[iArr[i4]] == i2) {
                break;
            } else {
                i4 = iArr[i4];
            }
        }
        int i5 = iArr[i4];
        if (i5 == -1 || this.f3038g[i5] != i2) {
            return;
        }
        iArr[i4] = iArr[i5];
        iArr[i5] = -1;
    }

    @Override // c.g.b.b.a
    public int a() {
        return this.f3042k;
    }

    @Override // c.g.b.b.a
    public i b(int i2) {
        int i3 = this.f3042k;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.l;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.n.f2995d[this.f3038g[i4]];
            }
            i4 = this.f3041j[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // c.g.b.b.a
    public void c() {
        int i2 = this.f3042k;
        int i3 = this.l;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f3039h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f3041j[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // c.g.b.b.a
    public void clear() {
        int i2 = this.f3042k;
        for (int i3 = 0; i3 < i2; i3++) {
            i b2 = b(i3);
            if (b2 != null) {
                b2.c(this.m);
            }
        }
        for (int i4 = 0; i4 < this.f3034c; i4++) {
            this.f3038g[i4] = -1;
            this.f3037f[i4] = -1;
        }
        for (int i5 = 0; i5 < this.f3035d; i5++) {
            this.f3036e[i5] = -1;
        }
        this.f3042k = 0;
        this.l = -1;
    }

    @Override // c.g.b.b.a
    public float d(int i2) {
        int i3 = this.f3042k;
        int i4 = this.l;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f3039h[i4];
            }
            i4 = this.f3041j[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // c.g.b.b.a
    public void e(i iVar, float f2, boolean z) {
        float f3 = a;
        if (f2 <= (-f3) || f2 >= f3) {
            int p = p(iVar);
            if (p == -1) {
                i(iVar, f2);
                return;
            }
            float[] fArr = this.f3039h;
            fArr[p] = fArr[p] + f2;
            float f4 = fArr[p];
            float f5 = a;
            if (f4 <= (-f5) || fArr[p] >= f5) {
                return;
            }
            fArr[p] = 0.0f;
            j(iVar, z);
        }
    }

    @Override // c.g.b.b.a
    public float f(i iVar) {
        int p = p(iVar);
        if (p != -1) {
            return this.f3039h[p];
        }
        return 0.0f;
    }

    @Override // c.g.b.b.a
    public boolean g(i iVar) {
        return p(iVar) != -1;
    }

    @Override // c.g.b.b.a
    public float h(b bVar, boolean z) {
        float f2 = f(bVar.a);
        j(bVar.a, z);
        j jVar = (j) bVar.f2991e;
        int a2 = jVar.a();
        int i2 = 0;
        int i3 = 0;
        while (i2 < a2) {
            int[] iArr = jVar.f3038g;
            if (iArr[i3] != -1) {
                e(this.n.f2995d[iArr[i3]], jVar.f3039h[i3] * f2, z);
                i2++;
            }
            i3++;
        }
        return f2;
    }

    @Override // c.g.b.b.a
    public void i(i iVar, float f2) {
        float f3 = a;
        if (f2 > (-f3) && f2 < f3) {
            j(iVar, true);
            return;
        }
        if (this.f3042k == 0) {
            m(0, iVar, f2);
            l(iVar, 0);
            this.l = 0;
            return;
        }
        int p = p(iVar);
        if (p != -1) {
            this.f3039h[p] = f2;
            return;
        }
        if (this.f3042k + 1 >= this.f3034c) {
            o();
        }
        int i2 = this.f3042k;
        int i3 = this.l;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            int[] iArr = this.f3038g;
            int i6 = iArr[i3];
            int i7 = iVar.f3019d;
            if (i6 == i7) {
                this.f3039h[i3] = f2;
                return;
            }
            if (iArr[i3] < i7) {
                i4 = i3;
            }
            i3 = this.f3041j[i3];
            if (i3 == -1) {
                break;
            }
        }
        q(i4, iVar, f2);
    }

    @Override // c.g.b.b.a
    public float j(i iVar, boolean z) {
        int p = p(iVar);
        if (p == -1) {
            return 0.0f;
        }
        r(iVar);
        float f2 = this.f3039h[p];
        if (this.l == p) {
            this.l = this.f3041j[p];
        }
        this.f3038g[p] = -1;
        int[] iArr = this.f3040i;
        if (iArr[p] != -1) {
            int[] iArr2 = this.f3041j;
            iArr2[iArr[p]] = iArr2[p];
        }
        int[] iArr3 = this.f3041j;
        if (iArr3[p] != -1) {
            iArr[iArr3[p]] = iArr[p];
        }
        this.f3042k--;
        iVar.n--;
        if (z) {
            iVar.c(this.m);
        }
        return f2;
    }

    @Override // c.g.b.b.a
    public void k(float f2) {
        int i2 = this.f3042k;
        int i3 = this.l;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f3039h;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f3041j[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    public int p(i iVar) {
        int[] iArr;
        if (this.f3042k != 0 && iVar != null) {
            int i2 = iVar.f3019d;
            int i3 = this.f3036e[i2 % this.f3035d];
            if (i3 == -1) {
                return -1;
            }
            if (this.f3038g[i3] == i2) {
                return i3;
            }
            while (true) {
                iArr = this.f3037f;
                if (iArr[i3] == -1 || this.f3038g[iArr[i3]] == i2) {
                    break;
                }
                i3 = iArr[i3];
            }
            if (iArr[i3] != -1 && this.f3038g[iArr[i3]] == i2) {
                return iArr[i3];
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i2 = this.f3042k;
        for (int i3 = 0; i3 < i2; i3++) {
            i b2 = b(i3);
            if (b2 != null) {
                String str2 = str + b2 + " = " + d(i3) + " ";
                int p = p(b2);
                String str3 = str2 + "[p: ";
                String str4 = (this.f3040i[p] != -1 ? str3 + this.n.f2995d[this.f3038g[this.f3040i[p]]] : str3 + "none") + ", n: ";
                str = (this.f3041j[p] != -1 ? str4 + this.n.f2995d[this.f3038g[this.f3041j[p]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
