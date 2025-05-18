package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class t {
    final c.e.g<RecyclerView.c0, a> a = new c.e.g<>();

    /* renamed from: b, reason: collision with root package name */
    final c.e.d<RecyclerView.c0> f2108b = new c.e.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {
        static c.i.j.f<a> a = new c.i.j.g(20);

        /* renamed from: b, reason: collision with root package name */
        int f2109b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f2110c;

        /* renamed from: d, reason: collision with root package name */
        RecyclerView.l.c f2111d;

        private a() {
        }

        static void a() {
            do {
            } while (a.b() != null);
        }

        static a b() {
            a b2 = a.b();
            return b2 == null ? new a() : b2;
        }

        static void c(a aVar) {
            aVar.f2109b = 0;
            aVar.f2110c = null;
            aVar.f2111d = null;
            a.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.c0 c0Var, int i2) {
        a n;
        RecyclerView.l.c cVar;
        int f2 = this.a.f(c0Var);
        if (f2 >= 0 && (n = this.a.n(f2)) != null) {
            int i3 = n.f2109b;
            if ((i3 & i2) != 0) {
                int i4 = (i2 ^ (-1)) & i3;
                n.f2109b = i4;
                if (i2 == 4) {
                    cVar = n.f2110c;
                } else if (i2 == 8) {
                    cVar = n.f2111d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.a.l(f2);
                    a.c(n);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f2109b |= 2;
        aVar.f2110c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f2109b |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j2, RecyclerView.c0 c0Var) {
        this.f2108b.k(j2, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f2111d = cVar;
        aVar.f2109b |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            aVar = a.b();
            this.a.put(c0Var, aVar);
        }
        aVar.f2110c = cVar;
        aVar.f2109b |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a.clear();
        this.f2108b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.c0 g(long j2) {
        return this.f2108b.g(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.f2109b & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.f2109b & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 j2 = this.a.j(size);
            a l = this.a.l(size);
            int i2 = l.f2109b;
            if ((i2 & 3) == 3) {
                bVar.a(j2);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = l.f2110c;
                if (cVar == null) {
                    bVar.a(j2);
                } else {
                    bVar.c(j2, cVar, l.f2111d);
                }
            } else if ((i2 & 14) == 14) {
                bVar.b(j2, l.f2110c, l.f2111d);
            } else if ((i2 & 12) == 12) {
                bVar.d(j2, l.f2110c, l.f2111d);
            } else if ((i2 & 4) != 0) {
                bVar.c(j2, l.f2110c, null);
            } else if ((i2 & 8) != 0) {
                bVar.b(j2, l.f2110c, l.f2111d);
            }
            a.c(l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2109b &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.c0 c0Var) {
        int n = this.f2108b.n() - 1;
        while (true) {
            if (n < 0) {
                break;
            }
            if (c0Var == this.f2108b.o(n)) {
                this.f2108b.m(n);
                break;
            }
            n--;
        }
        a remove = this.a.remove(c0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
