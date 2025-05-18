package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.services.i;
import e.h.a.e0.c;
import e.h.a.j0.b;
import e.h.a.k0.c;

/* compiled from: DownloadMgrInitialParams.java */
/* loaded from: classes2.dex */
public class c {
    private final a a;

    /* compiled from: DownloadMgrInitialParams.java */
    /* loaded from: classes2.dex */
    public static class a {
        c.InterfaceC0281c a;

        /* renamed from: b, reason: collision with root package name */
        Integer f20513b;

        /* renamed from: c, reason: collision with root package name */
        c.e f20514c;

        /* renamed from: d, reason: collision with root package name */
        c.b f20515d;

        /* renamed from: e, reason: collision with root package name */
        c.a f20516e;

        /* renamed from: f, reason: collision with root package name */
        c.d f20517f;

        /* renamed from: g, reason: collision with root package name */
        i f20518g;

        public a a(c.b bVar) {
            this.f20515d = bVar;
            return this;
        }

        public String toString() {
            return e.h.a.k0.f.o("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.a, this.f20513b, this.f20514c, this.f20515d, this.f20516e);
        }
    }

    public c() {
        this.a = null;
    }

    private c.a d() {
        return new e.h.a.e0.a();
    }

    private c.b e() {
        return new c.b();
    }

    private e.h.a.f0.a f() {
        return new e.h.a.f0.c();
    }

    private i g() {
        return new i.b().b(true).a();
    }

    private c.d h() {
        return new b();
    }

    private c.e i() {
        return new b.a();
    }

    private int m() {
        return e.h.a.k0.e.a().f21367e;
    }

    public c.a a() {
        a aVar = this.a;
        if (aVar == null) {
            return d();
        }
        c.a aVar2 = aVar.f20516e;
        if (aVar2 != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar2);
            }
            return aVar2;
        }
        return d();
    }

    public c.b b() {
        a aVar = this.a;
        if (aVar == null) {
            return e();
        }
        c.b bVar = aVar.f20515d;
        if (bVar != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
            }
            return bVar;
        }
        return e();
    }

    public e.h.a.f0.a c() {
        c.InterfaceC0281c interfaceC0281c;
        a aVar = this.a;
        if (aVar != null && (interfaceC0281c = aVar.a) != null) {
            e.h.a.f0.a a2 = interfaceC0281c.a();
            if (a2 != null) {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize database: %s", a2);
                }
                return a2;
            }
            return f();
        }
        return f();
    }

    public i j() {
        a aVar = this.a;
        if (aVar == null) {
            return g();
        }
        i iVar = aVar.f20518g;
        if (iVar != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize foreground service config: %s", iVar);
            }
            return iVar;
        }
        return g();
    }

    public c.d k() {
        a aVar = this.a;
        if (aVar == null) {
            return h();
        }
        c.d dVar = aVar.f20517f;
        if (dVar != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return h();
    }

    public c.e l() {
        a aVar = this.a;
        if (aVar == null) {
            return i();
        }
        c.e eVar = aVar.f20514c;
        if (eVar != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return i();
    }

    public int n() {
        a aVar = this.a;
        if (aVar == null) {
            return m();
        }
        Integer num = aVar.f20513b;
        if (num != null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return e.h.a.k0.e.b(num.intValue());
        }
        return m();
    }

    public c(a aVar) {
        this.a = aVar;
    }
}
