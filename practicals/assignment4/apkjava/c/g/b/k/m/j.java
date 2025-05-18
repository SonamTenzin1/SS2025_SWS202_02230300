package c.g.b.k.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
public class j extends p {
    public j(c.g.b.k.e eVar) {
        super(eVar);
        eVar.f3071f.f();
        eVar.f3072g.f();
        this.f3146f = ((c.g.b.k.g) eVar).b1();
    }

    private void q(f fVar) {
        this.f3148h.f3113k.add(fVar);
        fVar.l.add(this.f3148h);
    }

    @Override // c.g.b.k.m.p, c.g.b.k.m.d
    public void a(d dVar) {
        f fVar = this.f3148h;
        if (fVar.f3105c && !fVar.f3112j) {
            this.f3148h.d((int) ((fVar.l.get(0).f3109g * ((c.g.b.k.g) this.f3142b).e1()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void d() {
        c.g.b.k.g gVar = (c.g.b.k.g) this.f3142b;
        int c1 = gVar.c1();
        int d1 = gVar.d1();
        gVar.e1();
        if (gVar.b1() == 1) {
            if (c1 != -1) {
                this.f3148h.l.add(this.f3142b.U.f3071f.f3148h);
                this.f3142b.U.f3071f.f3148h.f3113k.add(this.f3148h);
                this.f3148h.f3108f = c1;
            } else if (d1 != -1) {
                this.f3148h.l.add(this.f3142b.U.f3071f.f3149i);
                this.f3142b.U.f3071f.f3149i.f3113k.add(this.f3148h);
                this.f3148h.f3108f = -d1;
            } else {
                f fVar = this.f3148h;
                fVar.f3104b = true;
                fVar.l.add(this.f3142b.U.f3071f.f3149i);
                this.f3142b.U.f3071f.f3149i.f3113k.add(this.f3148h);
            }
            q(this.f3142b.f3071f.f3148h);
            q(this.f3142b.f3071f.f3149i);
            return;
        }
        if (c1 != -1) {
            this.f3148h.l.add(this.f3142b.U.f3072g.f3148h);
            this.f3142b.U.f3072g.f3148h.f3113k.add(this.f3148h);
            this.f3148h.f3108f = c1;
        } else if (d1 != -1) {
            this.f3148h.l.add(this.f3142b.U.f3072g.f3149i);
            this.f3142b.U.f3072g.f3149i.f3113k.add(this.f3148h);
            this.f3148h.f3108f = -d1;
        } else {
            f fVar2 = this.f3148h;
            fVar2.f3104b = true;
            fVar2.l.add(this.f3142b.U.f3072g.f3149i);
            this.f3142b.U.f3072g.f3149i.f3113k.add(this.f3148h);
        }
        q(this.f3142b.f3072g.f3148h);
        q(this.f3142b.f3072g.f3149i);
    }

    @Override // c.g.b.k.m.p
    public void e() {
        if (((c.g.b.k.g) this.f3142b).b1() == 1) {
            this.f3142b.V0(this.f3148h.f3109g);
        } else {
            this.f3142b.W0(this.f3148h.f3109g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public void f() {
        this.f3148h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.g.b.k.m.p
    public boolean m() {
        return false;
    }
}
