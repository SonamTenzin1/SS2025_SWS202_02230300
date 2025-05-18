package c.g.b;

import c.g.b.i;
import c.g.b.k.d;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f2996b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2997c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f2998d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f2999e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f3000f = 1000;

    /* renamed from: g, reason: collision with root package name */
    public static e f3001g;

    /* renamed from: h, reason: collision with root package name */
    public static long f3002h;

    /* renamed from: i, reason: collision with root package name */
    public static long f3003i;
    private a m;
    c.g.b.b[] p;
    final c w;
    private a z;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3004j = false;

    /* renamed from: k, reason: collision with root package name */
    int f3005k = 0;
    private HashMap<String, i> l = null;
    private int n = 32;
    private int o = 32;
    public boolean q = false;
    public boolean r = false;
    private boolean[] s = new boolean[32];
    int t = 1;
    int u = 0;
    private int v = 32;
    private i[] x = new i[f3000f];
    private int y = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public class b extends c.g.b.b {
        public b(c cVar) {
            this.f2991e = new j(this, cVar);
        }
    }

    public d() {
        this.p = null;
        this.p = new c.g.b.b[32];
        C();
        c cVar = new c();
        this.w = cVar;
        this.m = new h(cVar);
        if (f2999e) {
            this.z = new b(cVar);
        } else {
            this.z = new c.g.b.b(cVar);
        }
    }

    private final int B(a aVar, boolean z) {
        if (f3001g != null) {
            throw null;
        }
        for (int i2 = 0; i2 < this.t; i2++) {
            this.s[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            if (f3001g == null) {
                i3++;
                if (i3 >= this.t * 2) {
                    return i3;
                }
                if (aVar.getKey() != null) {
                    this.s[aVar.getKey().f3019d] = true;
                }
                i b2 = aVar.b(this, this.s);
                if (b2 != null) {
                    boolean[] zArr = this.s;
                    int i4 = b2.f3019d;
                    if (zArr[i4]) {
                        return i3;
                    }
                    zArr[i4] = true;
                }
                if (b2 != null) {
                    float f2 = Float.MAX_VALUE;
                    int i5 = -1;
                    for (int i6 = 0; i6 < this.u; i6++) {
                        c.g.b.b bVar = this.p[i6];
                        if (bVar.a.f3026k != i.a.UNRESTRICTED && !bVar.f2992f && bVar.t(b2)) {
                            float f3 = bVar.f2991e.f(b2);
                            if (f3 < 0.0f) {
                                float f4 = (-bVar.f2988b) / f3;
                                if (f4 < f2) {
                                    i5 = i6;
                                    f2 = f4;
                                }
                            }
                        }
                    }
                    if (i5 > -1) {
                        c.g.b.b bVar2 = this.p[i5];
                        bVar2.a.f3020e = -1;
                        if (f3001g == null) {
                            bVar2.x(b2);
                            i iVar = bVar2.a;
                            iVar.f3020e = i5;
                            iVar.g(this, bVar2);
                        } else {
                            throw null;
                        }
                    } else {
                        continue;
                    }
                } else {
                    z2 = true;
                }
            } else {
                throw null;
            }
        }
        return i3;
    }

    private void C() {
        int i2 = 0;
        if (f2999e) {
            while (i2 < this.u) {
                c.g.b.b bVar = this.p[i2];
                if (bVar != null) {
                    this.w.a.a(bVar);
                }
                this.p[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.u) {
            c.g.b.b bVar2 = this.p[i2];
            if (bVar2 != null) {
                this.w.f2993b.a(bVar2);
            }
            this.p[i2] = null;
            i2++;
        }
    }

    private i a(i.a aVar, String str) {
        i b2 = this.w.f2994c.b();
        if (b2 == null) {
            b2 = new i(aVar, str);
            b2.f(aVar, str);
        } else {
            b2.d();
            b2.f(aVar, str);
        }
        int i2 = this.y;
        int i3 = f3000f;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            f3000f = i4;
            this.x = (i[]) Arrays.copyOf(this.x, i4);
        }
        i[] iVarArr = this.x;
        int i5 = this.y;
        this.y = i5 + 1;
        iVarArr[i5] = b2;
        return b2;
    }

    private final void l(c.g.b.b bVar) {
        int i2;
        if (f2997c && bVar.f2992f) {
            bVar.a.e(this, bVar.f2988b);
        } else {
            c.g.b.b[] bVarArr = this.p;
            int i3 = this.u;
            bVarArr[i3] = bVar;
            i iVar = bVar.a;
            iVar.f3020e = i3;
            this.u = i3 + 1;
            iVar.g(this, bVar);
        }
        if (f2997c && this.f3004j) {
            int i4 = 0;
            while (i4 < this.u) {
                if (this.p[i4] == null) {
                    System.out.println("WTF");
                }
                c.g.b.b[] bVarArr2 = this.p;
                if (bVarArr2[i4] != null && bVarArr2[i4].f2992f) {
                    c.g.b.b bVar2 = bVarArr2[i4];
                    bVar2.a.e(this, bVar2.f2988b);
                    if (f2999e) {
                        this.w.a.a(bVar2);
                    } else {
                        this.w.f2993b.a(bVar2);
                    }
                    this.p[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.u;
                        if (i5 >= i2) {
                            break;
                        }
                        c.g.b.b[] bVarArr3 = this.p;
                        int i7 = i5 - 1;
                        bVarArr3[i7] = bVarArr3[i5];
                        if (bVarArr3[i7].a.f3020e == i5) {
                            bVarArr3[i7].a.f3020e = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.p[i6] = null;
                    }
                    this.u = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.f3004j = false;
        }
    }

    private void n() {
        for (int i2 = 0; i2 < this.u; i2++) {
            c.g.b.b bVar = this.p[i2];
            bVar.a.f3022g = bVar.f2988b;
        }
    }

    public static c.g.b.b s(d dVar, i iVar, i iVar2, float f2) {
        return dVar.r().j(iVar, iVar2, f2);
    }

    private int u(a aVar) throws Exception {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.u) {
                z = false;
                break;
            }
            c.g.b.b[] bVarArr = this.p;
            if (bVarArr[i2].a.f3026k != i.a.UNRESTRICTED && bVarArr[i2].f2988b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            if (f3001g == null) {
                i3++;
                float f2 = Float.MAX_VALUE;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                for (int i7 = 0; i7 < this.u; i7++) {
                    c.g.b.b bVar = this.p[i7];
                    if (bVar.a.f3026k != i.a.UNRESTRICTED && !bVar.f2992f && bVar.f2988b < 0.0f) {
                        int i8 = 9;
                        if (f2998d) {
                            int a2 = bVar.f2991e.a();
                            int i9 = 0;
                            while (i9 < a2) {
                                i b2 = bVar.f2991e.b(i9);
                                float f3 = bVar.f2991e.f(b2);
                                if (f3 > 0.0f) {
                                    int i10 = 0;
                                    while (i10 < i8) {
                                        float f4 = b2.f3024i[i10] / f3;
                                        if ((f4 < f2 && i10 == i6) || i10 > i6) {
                                            i5 = b2.f3019d;
                                            i6 = i10;
                                            i4 = i7;
                                            f2 = f4;
                                        }
                                        i10++;
                                        i8 = 9;
                                    }
                                }
                                i9++;
                                i8 = 9;
                            }
                        } else {
                            for (int i11 = 1; i11 < this.t; i11++) {
                                i iVar = this.w.f2995d[i11];
                                float f5 = bVar.f2991e.f(iVar);
                                if (f5 > 0.0f) {
                                    for (int i12 = 0; i12 < 9; i12++) {
                                        float f6 = iVar.f3024i[i12] / f5;
                                        if ((f6 < f2 && i12 == i6) || i12 > i6) {
                                            i5 = i11;
                                            i6 = i12;
                                            i4 = i7;
                                            f2 = f6;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i4 != -1) {
                    c.g.b.b bVar2 = this.p[i4];
                    bVar2.a.f3020e = -1;
                    if (f3001g == null) {
                        bVar2.x(this.w.f2995d[i5]);
                        i iVar2 = bVar2.a;
                        iVar2.f3020e = i4;
                        iVar2.g(this, bVar2);
                    } else {
                        throw null;
                    }
                } else {
                    z2 = true;
                }
                if (i3 > this.t / 2) {
                    z2 = true;
                }
            } else {
                throw null;
            }
        }
        return i3;
    }

    public static e w() {
        return f3001g;
    }

    private void y() {
        int i2 = this.n * 2;
        this.n = i2;
        this.p = (c.g.b.b[]) Arrays.copyOf(this.p, i2);
        c cVar = this.w;
        cVar.f2995d = (i[]) Arrays.copyOf(cVar.f2995d, this.n);
        int i3 = this.n;
        this.s = new boolean[i3];
        this.o = i3;
        this.v = i3;
        if (f3001g != null) {
            throw null;
        }
    }

    void A(a aVar) throws Exception {
        if (f3001g == null) {
            u(aVar);
            B(aVar, false);
            n();
            return;
        }
        throw null;
    }

    public void D() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.w;
            i[] iVarArr = cVar.f2995d;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.d();
            }
            i2++;
        }
        cVar.f2994c.c(this.x, this.y);
        this.y = 0;
        Arrays.fill(this.w.f2995d, (Object) null);
        HashMap<String, i> hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f3005k = 0;
        this.m.clear();
        this.t = 1;
        for (int i3 = 0; i3 < this.u; i3++) {
            c.g.b.b[] bVarArr = this.p;
            if (bVarArr[i3] != null) {
                bVarArr[i3].f2989c = false;
            }
        }
        C();
        this.u = 0;
        if (f2999e) {
            this.z = new b(this.w);
        } else {
            this.z = new c.g.b.b(this.w);
        }
    }

    public void b(c.g.b.k.e eVar, c.g.b.k.e eVar2, float f2, int i2) {
        d.b bVar = d.b.LEFT;
        i q = q(eVar.m(bVar));
        d.b bVar2 = d.b.TOP;
        i q2 = q(eVar.m(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q3 = q(eVar.m(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q4 = q(eVar.m(bVar4));
        i q5 = q(eVar2.m(bVar));
        i q6 = q(eVar2.m(bVar2));
        i q7 = q(eVar2.m(bVar3));
        i q8 = q(eVar2.m(bVar4));
        c.g.b.b r = r();
        double d2 = f2;
        double sin = Math.sin(d2);
        double d3 = i2;
        Double.isNaN(d3);
        r.q(q2, q4, q6, q8, (float) (sin * d3));
        d(r);
        c.g.b.b r2 = r();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        r2.q(q, q3, q5, q7, (float) (cos * d3));
        d(r2);
    }

    public void c(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        c.g.b.b r = r();
        r.h(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 8) {
            r.d(this, i4);
        }
        d(r);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(c.g.b.b bVar) {
        i v;
        if (bVar == null) {
            return;
        }
        if (f3001g == null) {
            boolean z = true;
            if (this.u + 1 >= this.v || this.t + 1 >= this.o) {
                y();
            }
            boolean z2 = false;
            if (!bVar.f2992f) {
                bVar.D(this);
                if (bVar.isEmpty()) {
                    return;
                }
                bVar.r();
                if (bVar.f(this)) {
                    i p = p();
                    bVar.a = p;
                    int i2 = this.u;
                    l(bVar);
                    if (this.u == i2 + 1) {
                        this.z.c(bVar);
                        B(this.z, true);
                        if (p.f3020e == -1) {
                            if (bVar.a == p && (v = bVar.v(p)) != null) {
                                if (f3001g == null) {
                                    bVar.x(v);
                                } else {
                                    throw null;
                                }
                            }
                            if (!bVar.f2992f) {
                                bVar.a.g(this, bVar);
                            }
                            if (f2999e) {
                                this.w.a.a(bVar);
                            } else {
                                this.w.f2993b.a(bVar);
                            }
                            this.u--;
                        }
                        if (bVar.s()) {
                            return;
                        } else {
                            z2 = z;
                        }
                    }
                }
                z = false;
                if (bVar.s()) {
                }
            }
            if (z2) {
                return;
            }
            l(bVar);
            return;
        }
        throw null;
    }

    public c.g.b.b e(i iVar, i iVar2, int i2, int i3) {
        if (f2996b && i3 == 8 && iVar2.f3023h && iVar.f3020e == -1) {
            iVar.e(this, iVar2.f3022g + i2);
            return null;
        }
        c.g.b.b r = r();
        r.n(iVar, iVar2, i2);
        if (i3 != 8) {
            r.d(this, i3);
        }
        d(r);
        return r;
    }

    public void f(i iVar, int i2) {
        if (f2996b && iVar.f3020e == -1) {
            float f2 = i2;
            iVar.e(this, f2);
            for (int i3 = 0; i3 < this.f3005k + 1; i3++) {
                i iVar2 = this.w.f2995d[i3];
                if (iVar2 != null && iVar2.o && iVar2.p == iVar.f3019d) {
                    iVar2.e(this, iVar2.q + f2);
                }
            }
            return;
        }
        int i4 = iVar.f3020e;
        if (i4 != -1) {
            c.g.b.b bVar = this.p[i4];
            if (bVar.f2992f) {
                bVar.f2988b = i2;
                return;
            }
            if (bVar.f2991e.a() == 0) {
                bVar.f2992f = true;
                bVar.f2988b = i2;
                return;
            } else {
                c.g.b.b r = r();
                r.m(iVar, i2);
                d(r);
                return;
            }
        }
        c.g.b.b r2 = r();
        r2.i(iVar, i2);
        d(r2);
    }

    public void g(i iVar, i iVar2, int i2, boolean z) {
        c.g.b.b r = r();
        i t = t();
        t.f3021f = 0;
        r.o(iVar, iVar2, t, i2);
        d(r);
    }

    public void h(i iVar, i iVar2, int i2, int i3) {
        c.g.b.b r = r();
        i t = t();
        t.f3021f = 0;
        r.o(iVar, iVar2, t, i2);
        if (i3 != 8) {
            m(r, (int) (r.f2991e.f(t) * (-1.0f)), i3);
        }
        d(r);
    }

    public void i(i iVar, i iVar2, int i2, boolean z) {
        c.g.b.b r = r();
        i t = t();
        t.f3021f = 0;
        r.p(iVar, iVar2, t, i2);
        d(r);
    }

    public void j(i iVar, i iVar2, int i2, int i3) {
        c.g.b.b r = r();
        i t = t();
        t.f3021f = 0;
        r.p(iVar, iVar2, t, i2);
        if (i3 != 8) {
            m(r, (int) (r.f2991e.f(t) * (-1.0f)), i3);
        }
        d(r);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        c.g.b.b r = r();
        r.k(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 8) {
            r.d(this, i2);
        }
        d(r);
    }

    void m(c.g.b.b bVar, int i2, int i3) {
        bVar.e(o(i3, null), i2);
    }

    public i o(int i2, String str) {
        if (f3001g == null) {
            if (this.t + 1 >= this.o) {
                y();
            }
            i a2 = a(i.a.ERROR, str);
            int i3 = this.f3005k + 1;
            this.f3005k = i3;
            this.t++;
            a2.f3019d = i3;
            a2.f3021f = i2;
            this.w.f2995d[i3] = a2;
            this.m.a(a2);
            return a2;
        }
        throw null;
    }

    public i p() {
        if (f3001g == null) {
            if (this.t + 1 >= this.o) {
                y();
            }
            i a2 = a(i.a.SLACK, null);
            int i2 = this.f3005k + 1;
            this.f3005k = i2;
            this.t++;
            a2.f3019d = i2;
            this.w.f2995d[i2] = a2;
            return a2;
        }
        throw null;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.t + 1 >= this.o) {
            y();
        }
        if (obj instanceof c.g.b.k.d) {
            c.g.b.k.d dVar = (c.g.b.k.d) obj;
            iVar = dVar.h();
            if (iVar == null) {
                dVar.r(this.w);
                iVar = dVar.h();
            }
            int i2 = iVar.f3019d;
            if (i2 == -1 || i2 > this.f3005k || this.w.f2995d[i2] == null) {
                if (i2 != -1) {
                    iVar.d();
                }
                int i3 = this.f3005k + 1;
                this.f3005k = i3;
                this.t++;
                iVar.f3019d = i3;
                iVar.f3026k = i.a.UNRESTRICTED;
                this.w.f2995d[i3] = iVar;
            }
        }
        return iVar;
    }

    public c.g.b.b r() {
        c.g.b.b b2;
        if (f2999e) {
            b2 = this.w.a.b();
            if (b2 == null) {
                b2 = new b(this.w);
                f3003i++;
            } else {
                b2.y();
            }
        } else {
            b2 = this.w.f2993b.b();
            if (b2 == null) {
                b2 = new c.g.b.b(this.w);
                f3002h++;
            } else {
                b2.y();
            }
        }
        i.b();
        return b2;
    }

    public i t() {
        if (f3001g == null) {
            if (this.t + 1 >= this.o) {
                y();
            }
            i a2 = a(i.a.SLACK, null);
            int i2 = this.f3005k + 1;
            this.f3005k = i2;
            this.t++;
            a2.f3019d = i2;
            this.w.f2995d[i2] = a2;
            return a2;
        }
        throw null;
    }

    public c v() {
        return this.w;
    }

    public int x(Object obj) {
        i h2 = ((c.g.b.k.d) obj).h();
        if (h2 != null) {
            return (int) (h2.f3022g + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        if (f3001g != null) {
            throw null;
        }
        if (this.m.isEmpty()) {
            n();
            return;
        }
        if (!this.q && !this.r) {
            A(this.m);
            return;
        }
        if (f3001g != null) {
            throw null;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.u) {
                z = true;
                break;
            } else if (!this.p[i2].f2992f) {
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            A(this.m);
        } else {
            if (f3001g == null) {
                n();
                return;
            }
            throw null;
        }
    }
}
