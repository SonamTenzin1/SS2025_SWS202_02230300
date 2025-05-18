package i.a.g.t.e;

import i.a.g.f;
import i.a.g.i;
import i.a.g.l;
import i.a.g.q;
import i.a.g.s.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DNSStateTask.java */
/* loaded from: classes2.dex */
public abstract class c extends i.a.g.t.a {

    /* renamed from: g, reason: collision with root package name */
    static k.b.b f21909g = k.b.c.i(c.class.getName());

    /* renamed from: h, reason: collision with root package name */
    private static int f21910h = 3600;

    /* renamed from: i, reason: collision with root package name */
    private final int f21911i;

    /* renamed from: j, reason: collision with root package name */
    private g f21912j;

    public c(l lVar, int i2) {
        super(lVar);
        this.f21912j = null;
        this.f21911i = i2;
    }

    public static int n() {
        return f21910h;
    }

    protected void g(List<i> list) {
        if (list != null) {
            for (i iVar : list) {
                synchronized (iVar) {
                    iVar.d(this);
                }
            }
        }
    }

    protected abstract void h();

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(g gVar) {
        synchronized (e()) {
            e().K(this, gVar);
        }
        Iterator<i.a.d> it = e().y0().values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).E(this, gVar);
        }
    }

    protected abstract f j(f fVar) throws IOException;

    protected abstract f k(q qVar, f fVar) throws IOException;

    protected abstract boolean l();

    protected abstract f m();

    public int o() {
        return this.f21911i;
    }

    public abstract String p();

    /* JADX INFO: Access modifiers changed from: protected */
    public g q() {
        return this.f21912j;
    }

    protected abstract void r(Throwable th);

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        f m = m();
        try {
        } catch (Throwable th) {
            f21909g.f(f() + ".run() exception ", th);
            r(th);
        }
        if (!l()) {
            cancel();
            return;
        }
        List<i> arrayList = new ArrayList<>();
        synchronized (e()) {
            if (e().T0(this, q())) {
                f21909g.c(f() + ".run() JmDNS " + p() + " " + e().p0());
                arrayList.add(e());
                m = j(m);
            }
        }
        Iterator<i.a.d> it = e().y0().values().iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            synchronized (qVar) {
                if (qVar.S(this, q())) {
                    f21909g.c(f() + ".run() JmDNS " + p() + " " + qVar.o());
                    arrayList.add(qVar);
                    m = k(qVar, m);
                }
            }
        }
        if (!m.n()) {
            f21909g.c(f() + ".run() JmDNS " + p() + " #" + q());
            e().x1(m);
            g(arrayList);
            h();
            return;
        }
        g(arrayList);
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        synchronized (e()) {
            e().q1(this);
        }
        Iterator<i.a.d> it = e().y0().values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).Z(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(g gVar) {
        this.f21912j = gVar;
    }
}
