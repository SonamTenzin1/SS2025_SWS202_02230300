package c.g.b.k.m;

import c.g.b.k.m.f;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
public class k extends p {
    public k(c.g.b.k.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f3148h.f3113k.add(fVar);
        fVar.l.add(this.f3148h);
    }

    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    public void a(d dVar) {
        c.g.b.k.a aVar = (c.g.b.k.a) this.f3142b;
        int e1 = aVar.e1();
        Iterator<f> it = this.f3148h.l.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = it.next().f3109g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (e1 != 0 && e1 != 2) {
            this.f3148h.d(i2 + aVar.f1());
        } else {
            this.f3148h.d(i3 + aVar.f1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void d() {
        c.g.b.k.e eVar = this.f3142b;
        if (eVar instanceof c.g.b.k.a) {
            this.f3148h.f3104b = true;
            c.g.b.k.a aVar = (c.g.b.k.a) eVar;
            int e1 = aVar.e1();
            boolean d1 = aVar.d1();
            int i2 = 0;
            if (e1 == 0) {
                this.f3148h.f3107e = f.a.LEFT;
                while (i2 < aVar.E0) {
                    c.g.b.k.e eVar2 = aVar.D0[i2];
                    if (d1 || eVar2.Q() != 8) {
                        f fVar = eVar2.f3071f.f3148h;
                        fVar.f3113k.add(this.f3148h);
                        this.f3148h.l.add(fVar);
                    }
                    i2++;
                }
                q(this.f3142b.f3071f.f3148h);
                q(this.f3142b.f3071f.f3149i);
                return;
            }
            if (e1 == 1) {
                this.f3148h.f3107e = f.a.RIGHT;
                while (i2 < aVar.E0) {
                    c.g.b.k.e eVar3 = aVar.D0[i2];
                    if (d1 || eVar3.Q() != 8) {
                        f fVar2 = eVar3.f3071f.f3149i;
                        fVar2.f3113k.add(this.f3148h);
                        this.f3148h.l.add(fVar2);
                    }
                    i2++;
                }
                q(this.f3142b.f3071f.f3148h);
                q(this.f3142b.f3071f.f3149i);
                return;
            }
            if (e1 == 2) {
                this.f3148h.f3107e = f.a.TOP;
                while (i2 < aVar.E0) {
                    c.g.b.k.e eVar4 = aVar.D0[i2];
                    if (d1 || eVar4.Q() != 8) {
                        f fVar3 = eVar4.f3072g.f3148h;
                        fVar3.f3113k.add(this.f3148h);
                        this.f3148h.l.add(fVar3);
                    }
                    i2++;
                }
                q(this.f3142b.f3072g.f3148h);
                q(this.f3142b.f3072g.f3149i);
                return;
            }
            if (e1 != 3) {
                return;
            }
            this.f3148h.f3107e = f.a.BOTTOM;
            while (i2 < aVar.E0) {
                c.g.b.k.e eVar5 = aVar.D0[i2];
                if (d1 || eVar5.Q() != 8) {
                    f fVar4 = eVar5.f3072g.f3149i;
                    fVar4.f3113k.add(this.f3148h);
                    this.f3148h.l.add(fVar4);
                }
                i2++;
            }
            q(this.f3142b.f3072g.f3148h);
            q(this.f3142b.f3072g.f3149i);
        }
    }

    @Override // c.g.b.k.m.p
    public void e() {
        c.g.b.k.e eVar = this.f3142b;
        if (eVar instanceof c.g.b.k.a) {
            int e1 = ((c.g.b.k.a) eVar).e1();
            if (e1 != 0 && e1 != 1) {
                this.f3142b.W0(this.f3148h.f3109g);
            } else {
                this.f3142b.V0(this.f3148h.f3109g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void f() {
        this.f3143c = null;
        this.f3148h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public boolean m() {
        return false;
    }
}
