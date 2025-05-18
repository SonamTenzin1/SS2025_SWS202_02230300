package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class l extends g {

    /* renamed from: b, reason: collision with root package name */
    private c.b.a.b.a<j, a> f1756b;

    /* renamed from: c, reason: collision with root package name */
    private g.c f1757c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<k> f1758d;

    /* renamed from: e, reason: collision with root package name */
    private int f1759e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1760f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1761g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<g.c> f1762h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1763i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {
        g.c a;

        /* renamed from: b, reason: collision with root package name */
        i f1764b;

        a(j jVar, g.c cVar) {
            this.f1764b = o.f(jVar);
            this.a = cVar;
        }

        void a(k kVar, g.b bVar) {
            g.c k2 = bVar.k();
            this.a = l.k(this.a, k2);
            this.f1764b.a(kVar, bVar);
            this.a = k2;
        }
    }

    public l(k kVar) {
        this(kVar, true);
    }

    private void d(k kVar) {
        Iterator<Map.Entry<j, a>> c2 = this.f1756b.c();
        while (c2.hasNext() && !this.f1761g) {
            Map.Entry<j, a> next = c2.next();
            a value = next.getValue();
            while (value.a.compareTo(this.f1757c) > 0 && !this.f1761g && this.f1756b.contains(next.getKey())) {
                g.b g2 = g.b.g(value.a);
                if (g2 != null) {
                    n(g2.k());
                    value.a(kVar, g2);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + value.a);
                }
            }
        }
    }

    private g.c e(j jVar) {
        Map.Entry<j, a> r = this.f1756b.r(jVar);
        g.c cVar = null;
        g.c cVar2 = r != null ? r.getValue().a : null;
        if (!this.f1762h.isEmpty()) {
            cVar = this.f1762h.get(r0.size() - 1);
        }
        return k(k(this.f1757c, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (!this.f1763i || c.b.a.a.a.e().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(k kVar) {
        c.b.a.b.b<j, a>.d h2 = this.f1756b.h();
        while (h2.hasNext() && !this.f1761g) {
            Map.Entry next = h2.next();
            a aVar = (a) next.getValue();
            while (aVar.a.compareTo(this.f1757c) < 0 && !this.f1761g && this.f1756b.contains(next.getKey())) {
                n(aVar.a);
                g.b q = g.b.q(aVar.a);
                if (q != null) {
                    aVar.a(kVar, q);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f1756b.size() == 0) {
            return true;
        }
        g.c cVar = this.f1756b.f().getValue().a;
        g.c cVar2 = this.f1756b.i().getValue().a;
        return cVar == cVar2 && this.f1757c == cVar2;
    }

    static g.c k(g.c cVar, g.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(g.c cVar) {
        if (this.f1757c == cVar) {
            return;
        }
        this.f1757c = cVar;
        if (!this.f1760f && this.f1759e == 0) {
            this.f1760f = true;
            p();
            this.f1760f = false;
            return;
        }
        this.f1761g = true;
    }

    private void m() {
        this.f1762h.remove(r0.size() - 1);
    }

    private void n(g.c cVar) {
        this.f1762h.add(cVar);
    }

    private void p() {
        k kVar = this.f1758d.get();
        if (kVar != null) {
            while (!i()) {
                this.f1761g = false;
                if (this.f1757c.compareTo(this.f1756b.f().getValue().a) < 0) {
                    d(kVar);
                }
                Map.Entry<j, a> i2 = this.f1756b.i();
                if (!this.f1761g && i2 != null && this.f1757c.compareTo(i2.getValue().a) > 0) {
                    g(kVar);
                }
            }
            this.f1761g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.g
    public void a(j jVar) {
        k kVar;
        f("addObserver");
        g.c cVar = this.f1757c;
        g.c cVar2 = g.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = g.c.INITIALIZED;
        }
        a aVar = new a(jVar, cVar2);
        if (this.f1756b.o(jVar, aVar) == null && (kVar = this.f1758d.get()) != null) {
            boolean z = this.f1759e != 0 || this.f1760f;
            g.c e2 = e(jVar);
            this.f1759e++;
            while (aVar.a.compareTo(e2) < 0 && this.f1756b.contains(jVar)) {
                n(aVar.a);
                g.b q = g.b.q(aVar.a);
                if (q != null) {
                    aVar.a(kVar, q);
                    m();
                    e2 = e(jVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.a);
                }
            }
            if (!z) {
                p();
            }
            this.f1759e--;
        }
    }

    @Override // androidx.lifecycle.g
    public g.c b() {
        return this.f1757c;
    }

    @Override // androidx.lifecycle.g
    public void c(j jVar) {
        f("removeObserver");
        this.f1756b.q(jVar);
    }

    public void h(g.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.k());
    }

    @Deprecated
    public void j(g.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(g.c cVar) {
        f("setCurrentState");
        l(cVar);
    }

    private l(k kVar, boolean z) {
        this.f1756b = new c.b.a.b.a<>();
        this.f1759e = 0;
        this.f1760f = false;
        this.f1761g = false;
        this.f1762h = new ArrayList<>();
        this.f1758d = new WeakReference<>(kVar);
        this.f1757c = g.c.INITIALIZED;
        this.f1763i = z;
    }
}
