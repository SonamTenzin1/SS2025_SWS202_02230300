package i.a.g.t.d;

import i.a.g.f;
import i.a.g.l;
import java.io.IOException;
import java.util.Timer;

/* compiled from: DNSResolverTask.java */
/* loaded from: classes2.dex */
public abstract class a extends i.a.g.t.a {

    /* renamed from: g, reason: collision with root package name */
    private static k.b.b f21903g = k.b.c.i(a.class.getName());

    /* renamed from: h, reason: collision with root package name */
    protected int f21904h;

    public a(l lVar) {
        super(lVar);
        this.f21904h = 0;
    }

    protected abstract f g(f fVar) throws IOException;

    protected abstract f h(f fVar) throws IOException;

    protected abstract String i();

    public void j(Timer timer) {
        if (e().X0() || e().V0()) {
            return;
        }
        timer.schedule(this, 225L, 225L);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            if (!e().X0() && !e().V0()) {
                int i2 = this.f21904h;
                this.f21904h = i2 + 1;
                if (i2 < 3) {
                    if (f21903g.b()) {
                        f21903g.c(f() + ".run() JmDNS " + i());
                    }
                    f h2 = h(new f(0));
                    if (e().R0()) {
                        h2 = g(h2);
                    }
                    if (h2.n()) {
                        return;
                    }
                    e().x1(h2);
                    return;
                }
                cancel();
                return;
            }
            cancel();
        } catch (Throwable th) {
            f21903g.f(f() + ".run() exception ", th);
            e().h1();
        }
    }

    @Override // i.a.g.t.a
    public String toString() {
        return super.toString() + " count: " + this.f21904h;
    }
}
