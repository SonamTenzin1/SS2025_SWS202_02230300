package c.g.b.k.m;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
public class m {
    public static int a;

    /* renamed from: d, reason: collision with root package name */
    p f3123d;

    /* renamed from: e, reason: collision with root package name */
    p f3124e;

    /* renamed from: g, reason: collision with root package name */
    int f3126g;

    /* renamed from: h, reason: collision with root package name */
    int f3127h;

    /* renamed from: b, reason: collision with root package name */
    public int f3121b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3122c = false;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<p> f3125f = new ArrayList<>();

    public m(p pVar, int i2) {
        this.f3123d = null;
        this.f3124e = null;
        this.f3126g = 0;
        int i3 = a;
        this.f3126g = i3;
        a = i3 + 1;
        this.f3123d = pVar;
        this.f3124e = pVar;
        this.f3127h = i2;
    }

    private long c(f fVar, long j2) {
        p pVar = fVar.f3106d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f3113k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f3113k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3106d != pVar) {
                    j3 = Math.min(j3, c(fVar2, fVar2.f3108f + j2));
                }
            }
        }
        if (fVar != pVar.f3149i) {
            return j3;
        }
        long j4 = j2 - pVar.j();
        return Math.min(Math.min(j3, c(pVar.f3148h, j4)), j4 - pVar.f3148h.f3108f);
    }

    private long d(f fVar, long j2) {
        p pVar = fVar.f3106d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f3113k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f3113k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3106d != pVar) {
                    j3 = Math.max(j3, d(fVar2, fVar2.f3108f + j2));
                }
            }
        }
        if (fVar != pVar.f3148h) {
            return j3;
        }
        long j4 = j2 + pVar.j();
        return Math.max(Math.max(j3, d(pVar.f3149i, j4)), j4 - pVar.f3149i.f3108f);
    }

    public void a(p pVar) {
        this.f3125f.add(pVar);
        this.f3124e = pVar;
    }

    public long b(c.g.b.k.f fVar, int i2) {
        long j2;
        int i3;
        p pVar = this.f3123d;
        if (pVar instanceof c) {
            if (((c) pVar).f3146f != i2) {
                return 0L;
            }
        } else if (i2 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i2 == 0 ? fVar.f3071f : fVar.f3072g).f3148h;
        f fVar3 = (i2 == 0 ? fVar.f3071f : fVar.f3072g).f3149i;
        boolean contains = pVar.f3148h.l.contains(fVar2);
        boolean contains2 = this.f3123d.f3149i.l.contains(fVar3);
        long j3 = this.f3123d.j();
        if (contains && contains2) {
            long d2 = d(this.f3123d.f3148h, 0L);
            long c2 = c(this.f3123d.f3149i, 0L);
            long j4 = d2 - j3;
            p pVar2 = this.f3123d;
            int i4 = pVar2.f3149i.f3108f;
            if (j4 >= (-i4)) {
                j4 += i4;
            }
            int i5 = pVar2.f3148h.f3108f;
            long j5 = ((-c2) - j3) - i5;
            if (j5 >= i5) {
                j5 -= i5;
            }
            float f2 = (float) (pVar2.f3142b.o(i2) > 0.0f ? (((float) j5) / r13) + (((float) j4) / (1.0f - r13)) : 0L);
            long j6 = (f2 * r13) + 0.5f + j3 + (f2 * (1.0f - r13)) + 0.5f;
            j2 = r13.f3148h.f3108f + j6;
            i3 = this.f3123d.f3149i.f3108f;
        } else {
            if (contains) {
                return Math.max(d(this.f3123d.f3148h, r13.f3108f), this.f3123d.f3148h.f3108f + j3);
            }
            if (contains2) {
                return Math.max(-c(this.f3123d.f3149i, r13.f3108f), (-this.f3123d.f3149i.f3108f) + j3);
            }
            j2 = r13.f3148h.f3108f + this.f3123d.j();
            i3 = this.f3123d.f3149i.f3108f;
        }
        return j2 - i3;
    }
}
