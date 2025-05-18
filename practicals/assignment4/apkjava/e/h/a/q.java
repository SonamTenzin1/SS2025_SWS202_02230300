package e.h.a;

import android.content.Context;
import com.liulishuo.filedownloader.services.c;
import e.h.a.a;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: FileDownloader.java */
/* loaded from: classes2.dex */
public class q {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f21384b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private w f21385c;

    /* renamed from: d, reason: collision with root package name */
    private v f21386d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileDownloader.java */
    /* loaded from: classes2.dex */
    public static final class a {
        private static final q a = new q();
    }

    public static q e() {
        return a.a;
    }

    public static void h(Context context, c.a aVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(q.class, "init Downloader with params: %s %s", context, aVar);
        }
        if (context != null) {
            e.h.a.k0.c.b(context.getApplicationContext());
            e.h.a.g0.c.j().o(aVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    public void a(e eVar) {
        f.e().a("event.service.connect.changed", eVar);
    }

    public void b() {
        if (i()) {
            return;
        }
        m.b().u0(e.h.a.k0.c.a());
    }

    public boolean c(int i2, String str) {
        j(i2);
        if (!m.b().o0(i2)) {
            return false;
        }
        File file = new File(e.h.a.k0.f.C(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            return true;
        }
        file2.delete();
        return true;
    }

    public e.h.a.a d(String str) {
        return new c(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v f() {
        if (this.f21386d == null) {
            synchronized (f21384b) {
                if (this.f21386d == null) {
                    z zVar = new z();
                    this.f21386d = zVar;
                    a(zVar);
                }
            }
        }
        return this.f21386d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w g() {
        if (this.f21385c == null) {
            synchronized (a) {
                if (this.f21385c == null) {
                    this.f21385c = new c0();
                }
            }
        }
        return this.f21385c;
    }

    public boolean i() {
        return m.b().isConnected();
    }

    public int j(int i2) {
        List<a.b> h2 = h.i().h(i2);
        if (h2 == null || h2.isEmpty()) {
            e.h.a.k0.d.i(this, "request pause but not exist %d", Integer.valueOf(i2));
            return 0;
        }
        Iterator<a.b> it = h2.iterator();
        while (it.hasNext()) {
            it.next().v().pause();
        }
        return h2.size();
    }

    public void k(i iVar) {
        p.c().a(iVar);
        Iterator<a.b> it = h.i().d(iVar).iterator();
        while (it.hasNext()) {
            it.next().v().pause();
        }
    }

    public int l(int i2, i iVar) {
        a.b g2 = h.i().g(i2);
        if (g2 == null) {
            return 0;
        }
        g2.v().W(iVar);
        return g2.v().getId();
    }

    public boolean m(i iVar, boolean z) {
        if (iVar == null) {
            e.h.a.k0.d.i(this, "Tasks with the listener can't start, because the listener provided is null: [null, %B]", Boolean.valueOf(z));
            return false;
        }
        if (z) {
            return g().e(iVar);
        }
        return g().c(iVar);
    }

    public void n(boolean z) {
        m.b().t0(z);
    }
}
