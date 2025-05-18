package c.g.b.k.m;

import c.g.b.k.d;
import c.g.b.k.e;

/* compiled from: WidgetRun.java */
/* loaded from: classes.dex */
public abstract class p implements d {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    c.g.b.k.e f3142b;

    /* renamed from: c, reason: collision with root package name */
    m f3143c;

    /* renamed from: d, reason: collision with root package name */
    protected e.b f3144d;

    /* renamed from: e, reason: collision with root package name */
    g f3145e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f3146f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f3147g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f3148h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f3149i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    protected b f3150j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(c.g.b.k.e eVar) {
        this.f3142b = eVar;
    }

    private void l(int i2, int i3) {
        int i4;
        int i5 = this.a;
        if (i5 == 0) {
            this.f3145e.d(g(i3, i2));
            return;
        }
        if (i5 == 1) {
            this.f3145e.d(Math.min(g(this.f3145e.m, i2), i3));
            return;
        }
        if (i5 == 2) {
            c.g.b.k.e I = this.f3142b.I();
            if (I != null) {
                if ((i2 == 0 ? I.f3071f : I.f3072g).f3145e.f3112j) {
                    c.g.b.k.e eVar = this.f3142b;
                    this.f3145e.d(g((int) ((r9.f3109g * (i2 == 0 ? eVar.v : eVar.y)) + 0.5f), i2));
                    return;
                }
                return;
            }
            return;
        }
        if (i5 != 3) {
            return;
        }
        c.g.b.k.e eVar2 = this.f3142b;
        p pVar = eVar2.f3071f;
        e.b bVar = pVar.f3144d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.a == 3) {
            n nVar = eVar2.f3072g;
            if (nVar.f3144d == bVar2 && nVar.a == 3) {
                return;
            }
        }
        if (i2 == 0) {
            pVar = eVar2.f3072g;
        }
        if (pVar.f3145e.f3112j) {
            float t = eVar2.t();
            if (i2 == 1) {
                i4 = (int) ((pVar.f3145e.f3109g / t) + 0.5f);
            } else {
                i4 = (int) ((t * pVar.f3145e.f3109g) + 0.5f);
            }
            this.f3145e.d(i4);
        }
    }

    @Override // c.g.b.k.m.d
    public void a(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i2) {
        fVar.l.add(fVar2);
        fVar.f3108f = i2;
        fVar2.f3113k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.f3145e);
        fVar.f3110h = i2;
        fVar.f3111i = gVar;
        fVar2.f3113k.add(fVar);
        gVar.f3113k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i2, int i3) {
        int max;
        if (i3 == 0) {
            c.g.b.k.e eVar = this.f3142b;
            int i4 = eVar.u;
            max = Math.max(eVar.t, i2);
            if (i4 > 0) {
                max = Math.min(i4, i2);
            }
            if (max == i2) {
                return i2;
            }
        } else {
            c.g.b.k.e eVar2 = this.f3142b;
            int i5 = eVar2.x;
            max = Math.max(eVar2.w, i2);
            if (i5 > 0) {
                max = Math.min(i5, i2);
            }
            if (max == i2) {
                return i2;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(c.g.b.k.d dVar) {
        c.g.b.k.d dVar2 = dVar.f3057f;
        if (dVar2 == null) {
            return null;
        }
        c.g.b.k.e eVar = dVar2.f3055d;
        int i2 = a.a[dVar2.f3056e.ordinal()];
        if (i2 == 1) {
            return eVar.f3071f.f3148h;
        }
        if (i2 == 2) {
            return eVar.f3071f.f3149i;
        }
        if (i2 == 3) {
            return eVar.f3072g.f3148h;
        }
        if (i2 == 4) {
            return eVar.f3072g.f3128k;
        }
        if (i2 != 5) {
            return null;
        }
        return eVar.f3072g.f3149i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(c.g.b.k.d dVar, int i2) {
        c.g.b.k.d dVar2 = dVar.f3057f;
        if (dVar2 == null) {
            return null;
        }
        c.g.b.k.e eVar = dVar2.f3055d;
        p pVar = i2 == 0 ? eVar.f3071f : eVar.f3072g;
        int i3 = a.a[dVar2.f3056e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f3149i;
        }
        return pVar.f3148h;
    }

    public long j() {
        if (this.f3145e.f3112j) {
            return r0.f3109g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f3147g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, c.g.b.k.d dVar2, c.g.b.k.d dVar3, int i2) {
        f h2 = h(dVar2);
        f h3 = h(dVar3);
        if (h2.f3112j && h3.f3112j) {
            int e2 = h2.f3109g + dVar2.e();
            int e3 = h3.f3109g - dVar3.e();
            int i3 = e3 - e2;
            if (!this.f3145e.f3112j && this.f3144d == e.b.MATCH_CONSTRAINT) {
                l(i2, i3);
            }
            g gVar = this.f3145e;
            if (gVar.f3112j) {
                if (gVar.f3109g == i3) {
                    this.f3148h.d(e2);
                    this.f3149i.d(e3);
                    return;
                }
                c.g.b.k.e eVar = this.f3142b;
                float w = i2 == 0 ? eVar.w() : eVar.M();
                if (h2 == h3) {
                    e2 = h2.f3109g;
                    e3 = h3.f3109g;
                    w = 0.5f;
                }
                this.f3148h.d((int) (e2 + 0.5f + (((e3 - e2) - this.f3145e.f3109g) * w)));
                this.f3149i.d(this.f3148h.f3109g + this.f3145e.f3109g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
