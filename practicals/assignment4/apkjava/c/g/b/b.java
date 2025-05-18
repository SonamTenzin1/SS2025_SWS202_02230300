package c.g.b;

import c.g.b.d;
import c.g.b.i;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f2991e;
    i a = null;

    /* renamed from: b, reason: collision with root package name */
    float f2988b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    boolean f2989c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<i> f2990d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    boolean f2992f = false;

    /* compiled from: ArrayRow.java */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        i b(int i2);

        void c();

        void clear();

        float d(int i2);

        void e(i iVar, float f2, boolean z);

        float f(i iVar);

        boolean g(i iVar);

        float h(b bVar, boolean z);

        void i(i iVar, float f2);

        float j(i iVar, boolean z);

        void k(float f2);
    }

    public b() {
    }

    private boolean u(i iVar, d dVar) {
        return iVar.n <= 1;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int a2 = this.f2991e.a();
        i iVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < a2; i2++) {
            float d2 = this.f2991e.d(i2);
            if (d2 < 0.0f) {
                i b2 = this.f2991e.b(i2);
                if ((zArr == null || !zArr[b2.f3019d]) && b2 != iVar && (((aVar = b2.f3026k) == i.a.SLACK || aVar == i.a.ERROR) && d2 < f2)) {
                    f2 = d2;
                    iVar2 = b2;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z) {
        if (iVar.f3023h) {
            this.f2988b += iVar.f3022g * this.f2991e.f(iVar);
            this.f2991e.j(iVar, z);
            if (z) {
                iVar.c(this);
            }
            if (d.f2997c && this.f2991e.a() == 0) {
                this.f2992f = true;
                dVar.f3004j = true;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z) {
        this.f2988b += bVar.f2988b * this.f2991e.h(bVar, z);
        if (z) {
            bVar.a.c(this);
        }
        if (d.f2997c && this.a != null && this.f2991e.a() == 0) {
            this.f2992f = true;
            dVar.f3004j = true;
        }
    }

    public void C(d dVar, i iVar, boolean z) {
        if (iVar.o) {
            float f2 = this.f2991e.f(iVar);
            this.f2988b += iVar.q * f2;
            this.f2991e.j(iVar, z);
            if (z) {
                iVar.c(this);
            }
            this.f2991e.e(dVar.w.f2995d[iVar.p], f2, z);
            if (d.f2997c && this.f2991e.a() == 0) {
                this.f2992f = true;
                dVar.f3004j = true;
            }
        }
    }

    public void D(d dVar) {
        if (dVar.p.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int a2 = this.f2991e.a();
            for (int i2 = 0; i2 < a2; i2++) {
                i b2 = this.f2991e.b(i2);
                if (b2.f3020e != -1 || b2.f3023h || b2.o) {
                    this.f2990d.add(b2);
                }
            }
            int size = this.f2990d.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = this.f2990d.get(i3);
                    if (iVar.f3023h) {
                        A(dVar, iVar, true);
                    } else if (iVar.o) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.p[iVar.f3020e], true);
                    }
                }
                this.f2990d.clear();
            } else {
                z = true;
            }
        }
        if (d.f2997c && this.a != null && this.f2991e.a() == 0) {
            this.f2992f = true;
            dVar.f3004j = true;
        }
    }

    @Override // c.g.b.d.a
    public void a(i iVar) {
        int i2 = iVar.f3021f;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2991e.i(iVar, f2);
    }

    @Override // c.g.b.d.a
    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // c.g.b.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.a = null;
            this.f2991e.clear();
            for (int i2 = 0; i2 < bVar.f2991e.a(); i2++) {
                this.f2991e.e(bVar.f2991e.b(i2), bVar.f2991e.d(i2), true);
            }
        }
    }

    @Override // c.g.b.d.a
    public void clear() {
        this.f2991e.clear();
        this.a = null;
        this.f2988b = 0.0f;
    }

    public b d(d dVar, int i2) {
        this.f2991e.i(dVar.o(i2, "ep"), 1.0f);
        this.f2991e.i(dVar.o(i2, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i2) {
        this.f2991e.i(iVar, i2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z;
        i g2 = g(dVar);
        if (g2 == null) {
            z = true;
        } else {
            x(g2);
            z = false;
        }
        if (this.f2991e.a() == 0) {
            this.f2992f = true;
        }
        return z;
    }

    i g(d dVar) {
        boolean u;
        boolean u2;
        int a2 = this.f2991e.a();
        i iVar = null;
        i iVar2 = null;
        boolean z = false;
        boolean z2 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < a2; i2++) {
            float d2 = this.f2991e.d(i2);
            i b2 = this.f2991e.b(i2);
            if (b2.f3026k == i.a.UNRESTRICTED) {
                if (iVar == null) {
                    u2 = u(b2, dVar);
                } else if (f2 > d2) {
                    u2 = u(b2, dVar);
                } else if (!z && u(b2, dVar)) {
                    f2 = d2;
                    iVar = b2;
                    z = true;
                }
                z = u2;
                f2 = d2;
                iVar = b2;
            } else if (iVar == null && d2 < 0.0f) {
                if (iVar2 == null) {
                    u = u(b2, dVar);
                } else if (f3 > d2) {
                    u = u(b2, dVar);
                } else if (!z2 && u(b2, dVar)) {
                    f3 = d2;
                    iVar2 = b2;
                    z2 = true;
                }
                z2 = u;
                f3 = d2;
                iVar2 = b2;
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // c.g.b.d.a
    public i getKey() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar4, 1.0f);
            this.f2991e.i(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
            this.f2991e.i(iVar3, -1.0f);
            this.f2991e.i(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f2988b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.f2991e.i(iVar, -1.0f);
            this.f2991e.i(iVar2, 1.0f);
            this.f2988b = i2;
        } else if (f2 >= 1.0f) {
            this.f2991e.i(iVar4, -1.0f);
            this.f2991e.i(iVar3, 1.0f);
            this.f2988b = -i3;
        } else {
            float f3 = 1.0f - f2;
            this.f2991e.i(iVar, f3 * 1.0f);
            this.f2991e.i(iVar2, f3 * (-1.0f));
            this.f2991e.i(iVar3, (-1.0f) * f2);
            this.f2991e.i(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f2988b = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, int i2) {
        this.a = iVar;
        float f2 = i2;
        iVar.f3022g = f2;
        this.f2988b = f2;
        this.f2992f = true;
        return this;
    }

    @Override // c.g.b.d.a
    public boolean isEmpty() {
        return this.a == null && this.f2988b == 0.0f && this.f2991e.a() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f2) {
        this.f2991e.i(iVar, -1.0f);
        this.f2991e.i(iVar2, f2);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2991e.i(iVar, -1.0f);
        this.f2991e.i(iVar2, 1.0f);
        this.f2991e.i(iVar3, f2);
        this.f2991e.i(iVar4, -f2);
        return this;
    }

    public b l(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f2988b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
            this.f2991e.i(iVar4, 1.0f);
            this.f2991e.i(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f2991e.i(iVar3, 1.0f);
            this.f2991e.i(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
            this.f2991e.i(iVar4, f5);
            this.f2991e.i(iVar3, -f5);
        }
        return this;
    }

    public b m(i iVar, int i2) {
        if (i2 < 0) {
            this.f2988b = i2 * (-1);
            this.f2991e.i(iVar, 1.0f);
        } else {
            this.f2988b = i2;
            this.f2991e.i(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2988b = i2;
        }
        if (!z) {
            this.f2991e.i(iVar, -1.0f);
            this.f2991e.i(iVar2, 1.0f);
        } else {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2988b = i2;
        }
        if (!z) {
            this.f2991e.i(iVar, -1.0f);
            this.f2991e.i(iVar2, 1.0f);
            this.f2991e.i(iVar3, 1.0f);
        } else {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
            this.f2991e.i(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2988b = i2;
        }
        if (!z) {
            this.f2991e.i(iVar, -1.0f);
            this.f2991e.i(iVar2, 1.0f);
            this.f2991e.i(iVar3, -1.0f);
        } else {
            this.f2991e.i(iVar, 1.0f);
            this.f2991e.i(iVar2, -1.0f);
            this.f2991e.i(iVar3, 1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2991e.i(iVar3, 0.5f);
        this.f2991e.i(iVar4, 0.5f);
        this.f2991e.i(iVar, -0.5f);
        this.f2991e.i(iVar2, -0.5f);
        this.f2988b = -f2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f2 = this.f2988b;
        if (f2 < 0.0f) {
            this.f2988b = f2 * (-1.0f);
            this.f2991e.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.a;
        return iVar != null && (iVar.f3026k == i.a.UNRESTRICTED || this.f2988b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f2991e.g(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(i iVar) {
        i iVar2 = this.a;
        if (iVar2 != null) {
            this.f2991e.i(iVar2, -1.0f);
            this.a.f3020e = -1;
            this.a = null;
        }
        float j2 = this.f2991e.j(iVar, true) * (-1.0f);
        this.a = iVar;
        if (j2 == 1.0f) {
            return;
        }
        this.f2988b /= j2;
        this.f2991e.k(j2);
    }

    public void y() {
        this.a = null;
        this.f2991e.clear();
        this.f2988b = 0.0f;
        this.f2992f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String z() {
        boolean z;
        String str = (this.a == null ? HttpUrl.FRAGMENT_ENCODE_SET + "0" : HttpUrl.FRAGMENT_ENCODE_SET + this.a) + " = ";
        if (this.f2988b != 0.0f) {
            str = str + this.f2988b;
            z = true;
        } else {
            z = false;
        }
        int a2 = this.f2991e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            i b2 = this.f2991e.b(i2);
            if (b2 != null) {
                float d2 = this.f2991e.d(i2);
                if (d2 != 0.0f) {
                    String iVar = b2.toString();
                    if (!z) {
                        if (d2 < 0.0f) {
                            str = str + "- ";
                            d2 *= -1.0f;
                        }
                        str = d2 == 1.0f ? str + iVar : str + d2 + " " + iVar;
                        z = true;
                    } else if (d2 > 0.0f) {
                        str = str + " + ";
                        if (d2 == 1.0f) {
                        }
                        z = true;
                    } else {
                        str = str + " - ";
                        d2 *= -1.0f;
                        if (d2 == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    public b(c cVar) {
        this.f2991e = new c.g.b.a(this, cVar);
    }
}
