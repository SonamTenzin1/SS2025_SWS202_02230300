package c.g.b;

import c.g.b.b;
import java.util.Arrays;
import java.util.Comparator;
import okhttp3.HttpUrl;

/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public class h extends c.g.b.b {

    /* renamed from: g, reason: collision with root package name */
    private int f3008g;

    /* renamed from: h, reason: collision with root package name */
    private i[] f3009h;

    /* renamed from: i, reason: collision with root package name */
    private i[] f3010i;

    /* renamed from: j, reason: collision with root package name */
    private int f3011j;

    /* renamed from: k, reason: collision with root package name */
    b f3012k;
    c l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<i> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f3019d - iVar2.f3019d;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    class b implements Comparable {

        /* renamed from: f, reason: collision with root package name */
        i f3014f;

        /* renamed from: g, reason: collision with root package name */
        h f3015g;

        public b(h hVar) {
            this.f3015g = hVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f3014f.f3019d - ((i) obj).f3019d;
        }

        public boolean g(i iVar, float f2) {
            boolean z = true;
            if (!this.f3014f.f3017b) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float f3 = iVar.f3025j[i2];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f2;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        this.f3014f.f3025j[i2] = f4;
                    } else {
                        this.f3014f.f3025j[i2] = 0.0f;
                    }
                }
                return true;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.f3014f.f3025j;
                fArr[i3] = fArr[i3] + (iVar.f3025j[i3] * f2);
                if (Math.abs(fArr[i3]) < 1.0E-4f) {
                    this.f3014f.f3025j[i3] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                h.this.G(this.f3014f);
            }
            return false;
        }

        public void k(i iVar) {
            this.f3014f = iVar;
        }

        public final boolean q() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.f3014f.f3025j[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (f2 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            String str = "[ ";
            if (this.f3014f != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.f3014f.f3025j[i2] + " ";
                }
            }
            return str + "] " + this.f3014f;
        }

        public final boolean u(i iVar) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = iVar.f3025j[i2];
                float f3 = this.f3014f.f3025j[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public void v() {
            Arrays.fill(this.f3014f.f3025j, 0.0f);
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f3008g = 128;
        this.f3009h = new i[128];
        this.f3010i = new i[128];
        this.f3011j = 0;
        this.f3012k = new b(this);
        this.l = cVar;
    }

    private final void F(i iVar) {
        int i2;
        int i3 = this.f3011j + 1;
        i[] iVarArr = this.f3009h;
        if (i3 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f3009h = iVarArr2;
            this.f3010i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f3009h;
        int i4 = this.f3011j;
        iVarArr3[i4] = iVar;
        int i5 = i4 + 1;
        this.f3011j = i5;
        if (i5 > 1 && iVarArr3[i5 - 1].f3019d > iVar.f3019d) {
            int i6 = 0;
            while (true) {
                i2 = this.f3011j;
                if (i6 >= i2) {
                    break;
                }
                this.f3010i[i6] = this.f3009h[i6];
                i6++;
            }
            Arrays.sort(this.f3010i, 0, i2, new a());
            for (int i7 = 0; i7 < this.f3011j; i7++) {
                this.f3009h[i7] = this.f3010i[i7];
            }
        }
        iVar.f3017b = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i2 = 0;
        while (i2 < this.f3011j) {
            if (this.f3009h[i2] == iVar) {
                while (true) {
                    int i3 = this.f3011j;
                    if (i2 < i3 - 1) {
                        i[] iVarArr = this.f3009h;
                        int i4 = i2 + 1;
                        iVarArr[i2] = iVarArr[i4];
                        i2 = i4;
                    } else {
                        this.f3011j = i3 - 1;
                        iVar.f3017b = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // c.g.b.b
    public void B(d dVar, c.g.b.b bVar, boolean z) {
        i iVar = bVar.a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f2991e;
        int a2 = aVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            i b2 = aVar.b(i2);
            float d2 = aVar.d(i2);
            this.f3012k.k(b2);
            if (this.f3012k.g(iVar, d2)) {
                F(b2);
            }
            this.f2988b += bVar.f2988b * d2;
        }
        G(iVar);
    }

    @Override // c.g.b.b, c.g.b.d.a
    public void a(i iVar) {
        this.f3012k.k(iVar);
        this.f3012k.v();
        iVar.f3025j[iVar.f3021f] = 1.0f;
        F(iVar);
    }

    @Override // c.g.b.b, c.g.b.d.a
    public i b(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f3011j; i3++) {
            i iVar = this.f3009h[i3];
            if (!zArr[iVar.f3019d]) {
                this.f3012k.k(iVar);
                if (i2 == -1) {
                    if (!this.f3012k.q()) {
                    }
                    i2 = i3;
                } else {
                    if (!this.f3012k.u(this.f3009h[i2])) {
                    }
                    i2 = i3;
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f3009h[i2];
    }

    @Override // c.g.b.b, c.g.b.d.a
    public void clear() {
        this.f3011j = 0;
        this.f2988b = 0.0f;
    }

    @Override // c.g.b.b, c.g.b.d.a
    public boolean isEmpty() {
        return this.f3011j == 0;
    }

    @Override // c.g.b.b
    public String toString() {
        String str = HttpUrl.FRAGMENT_ENCODE_SET + " goal -> (" + this.f2988b + ") : ";
        for (int i2 = 0; i2 < this.f3011j; i2++) {
            this.f3012k.k(this.f3009h[i2]);
            str = str + this.f3012k + " ";
        }
        return str;
    }
}
