package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import e.h.a.a;
import e.h.a.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* compiled from: DownloadTaskHunter.java */
/* loaded from: classes2.dex */
public class d implements x, x.b, x.a, a.d {
    private t a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f21235b;

    /* renamed from: c, reason: collision with root package name */
    private final a f21236c;

    /* renamed from: f, reason: collision with root package name */
    private final s f21239f;

    /* renamed from: g, reason: collision with root package name */
    private final r f21240g;

    /* renamed from: h, reason: collision with root package name */
    private long f21241h;

    /* renamed from: i, reason: collision with root package name */
    private long f21242i;

    /* renamed from: j, reason: collision with root package name */
    private int f21243j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21244k;
    private boolean l;
    private String m;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte f21237d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f21238e = null;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTaskHunter.java */
    /* loaded from: classes2.dex */
    public interface a {
        ArrayList<a.InterfaceC0271a> D();

        FileDownloadHeader N();

        void a(String str);

        a.b s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Object obj) {
        this.f21235b = obj;
        this.f21236c = aVar;
        b bVar = new b();
        this.f21239f = bVar;
        this.f21240g = bVar;
        this.a = new k(aVar.s(), this);
    }

    private int s() {
        return this.f21236c.s().v().getId();
    }

    private void t() throws IOException {
        File file;
        e.h.a.a v = this.f21236c.s().v();
        if (v.g() == null) {
            v.k(e.h.a.k0.f.v(v.n()));
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "save Path is null to %s", v.g());
            }
        }
        if (v.Q()) {
            file = new File(v.g());
        } else {
            String A = e.h.a.k0.f.A(v.g());
            if (A != null) {
                file = new File(A);
            } else {
                throw new InvalidParameterException(e.h.a.k0.f.o("the provided mPath[%s] is invalid, can't find its directory", v.g()));
            }
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(e.h.a.k0.f.o("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(MessageSnapshot messageSnapshot) {
        e.h.a.a v = this.f21236c.s().v();
        byte k2 = messageSnapshot.k();
        this.f21237d = k2;
        this.f21244k = messageSnapshot.m();
        if (k2 == -4) {
            this.f21239f.a();
            int e2 = h.i().e(v.getId());
            if (e2 + ((e2 > 1 || !v.Q()) ? 0 : h.i().e(e.h.a.k0.f.r(v.n(), v.l()))) <= 1) {
                byte Q = m.b().Q(v.getId());
                e.h.a.k0.d.i(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(v.getId()), Integer.valueOf(Q));
                if (com.liulishuo.filedownloader.model.b.a(Q)) {
                    this.f21237d = (byte) 1;
                    this.f21242i = messageSnapshot.g();
                    long f2 = messageSnapshot.f();
                    this.f21241h = f2;
                    this.f21239f.g(f2);
                    this.a.b(((MessageSnapshot.b) messageSnapshot).a());
                    return;
                }
            }
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (k2 == -3) {
            this.n = messageSnapshot.o();
            this.f21241h = messageSnapshot.g();
            this.f21242i = messageSnapshot.g();
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (k2 == -1) {
            this.f21238e = messageSnapshot.l();
            this.f21241h = messageSnapshot.f();
            h.i().l(this.f21236c.s(), messageSnapshot);
            return;
        }
        if (k2 == 1) {
            this.f21241h = messageSnapshot.f();
            this.f21242i = messageSnapshot.g();
            this.a.b(messageSnapshot);
            return;
        }
        if (k2 == 2) {
            this.f21242i = messageSnapshot.g();
            this.l = messageSnapshot.n();
            this.m = messageSnapshot.c();
            String d2 = messageSnapshot.d();
            if (d2 != null) {
                if (v.V() != null) {
                    e.h.a.k0.d.i(this, "already has mFilename[%s], but assign mFilename[%s] again", v.V(), d2);
                }
                this.f21236c.a(d2);
            }
            this.f21239f.g(this.f21241h);
            this.a.h(messageSnapshot);
            return;
        }
        if (k2 == 3) {
            this.f21241h = messageSnapshot.f();
            this.f21239f.i(messageSnapshot.f());
            this.a.f(messageSnapshot);
        } else if (k2 != 5) {
            if (k2 != 6) {
                return;
            }
            this.a.l(messageSnapshot);
        } else {
            this.f21241h = messageSnapshot.f();
            this.f21238e = messageSnapshot.l();
            this.f21243j = messageSnapshot.h();
            this.f21239f.a();
            this.a.e(messageSnapshot);
        }
    }

    @Override // e.h.a.x.a
    public boolean a(MessageSnapshot messageSnapshot) {
        if (!this.f21236c.s().v().Q() || messageSnapshot.k() != -4 || getStatus() != 2) {
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.x
    public void b() {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "free the task %d, when the status is %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
        }
        this.f21237d = (byte) 0;
    }

    @Override // e.h.a.r
    public int c() {
        return this.f21240g.c();
    }

    @Override // e.h.a.x
    public int d() {
        return this.f21243j;
    }

    @Override // e.h.a.x
    public Throwable e() {
        return this.f21238e;
    }

    @Override // e.h.a.x.a
    public t f() {
        return this.a;
    }

    @Override // e.h.a.a.d
    public void g() {
        e.h.a.a v = this.f21236c.s().v();
        if (l.b()) {
            l.a().c(v);
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
        this.f21239f.f(this.f21241h);
        if (this.f21236c.D() != null) {
            ArrayList arrayList = (ArrayList) this.f21236c.D().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.InterfaceC0271a) arrayList.get(i2)).a(v);
            }
        }
        q.e().f().c(this.f21236c.s());
    }

    @Override // e.h.a.x
    public byte getStatus() {
        return this.f21237d;
    }

    @Override // e.h.a.x
    public boolean h() {
        return this.f21244k;
    }

    @Override // e.h.a.x.a
    public boolean i(MessageSnapshot messageSnapshot) {
        if (!com.liulishuo.filedownloader.model.b.b(getStatus(), messageSnapshot.k())) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21237d), Byte.valueOf(getStatus()), Integer.valueOf(s()));
            }
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.x
    public void j() {
        boolean z;
        synchronized (this.f21235b) {
            if (this.f21237d != 0) {
                e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
                return;
            }
            this.f21237d = (byte) 10;
            a.b s = this.f21236c.s();
            e.h.a.a v = s.v();
            if (l.b()) {
                l.a().b(v);
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.h(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", v.n(), v.g(), v.G(), v.getTag());
            }
            try {
                t();
                z = true;
            } catch (Throwable th) {
                h.i().a(s);
                h.i().l(s, l(th));
                z = false;
            }
            if (z) {
                p.c().d(this);
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.h(this, "the task[%d] has been into the launch pool.", Integer.valueOf(s()));
            }
        }
    }

    @Override // e.h.a.x
    public long k() {
        return this.f21241h;
    }

    @Override // e.h.a.x.a
    public MessageSnapshot l(Throwable th) {
        this.f21237d = (byte) -1;
        this.f21238e = th;
        return com.liulishuo.filedownloader.message.c.b(s(), k(), th);
    }

    @Override // e.h.a.x
    public long m() {
        return this.f21242i;
    }

    @Override // e.h.a.x.a
    public boolean n(MessageSnapshot messageSnapshot) {
        if (!com.liulishuo.filedownloader.model.b.d(this.f21236c.s().v())) {
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.a.d
    public void o() {
        if (l.b() && getStatus() == 6) {
            l.a().e(this.f21236c.s().v());
        }
    }

    @Override // e.h.a.x.a
    public boolean p(MessageSnapshot messageSnapshot) {
        byte status = getStatus();
        byte k2 = messageSnapshot.k();
        if (-2 == status && com.liulishuo.filedownloader.model.b.a(k2)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(s()));
            }
            return true;
        }
        if (!com.liulishuo.filedownloader.model.b.c(status, k2)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.f21237d), Byte.valueOf(getStatus()), Integer.valueOf(s()));
            }
            return false;
        }
        u(messageSnapshot);
        return true;
    }

    @Override // e.h.a.x
    public boolean pause() {
        if (com.liulishuo.filedownloader.model.b.e(getStatus())) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(getStatus()), Integer.valueOf(this.f21236c.s().v().getId()));
            }
            return false;
        }
        this.f21237d = (byte) -2;
        a.b s = this.f21236c.s();
        e.h.a.a v = s.v();
        p.c().b(this);
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(s()));
        }
        if (!q.e().i()) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(v.getId()));
            }
        } else {
            m.b().a0(v.getId());
        }
        h.i().a(s);
        h.i().l(s, com.liulishuo.filedownloader.message.c.c(v));
        q.e().f().c(s);
        return true;
    }

    @Override // e.h.a.a.d
    public void q() {
        if (l.b()) {
            l.a().d(this.f21236c.s().v());
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(getStatus()));
        }
    }

    @Override // e.h.a.x.b
    public boolean r(i iVar) {
        return this.f21236c.s().v().G() == iVar;
    }

    @Override // e.h.a.x.b
    public void start() {
        if (this.f21237d != 10) {
            e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
            return;
        }
        a.b s = this.f21236c.s();
        e.h.a.a v = s.v();
        v f2 = q.e().f();
        try {
            if (f2.b(s)) {
                return;
            }
            synchronized (this.f21235b) {
                if (this.f21237d != 10) {
                    e.h.a.k0.d.i(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(s()), Byte.valueOf(this.f21237d));
                    return;
                }
                this.f21237d = (byte) 11;
                h.i().a(s);
                if (e.h.a.k0.c.d(v.getId(), v.l(), v.M(), true)) {
                    return;
                }
                boolean S = m.b().S(v.n(), v.g(), v.Q(), v.K(), v.q(), v.t(), v.M(), this.f21236c.N(), v.r());
                if (this.f21237d == -2) {
                    e.h.a.k0.d.i(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(s()));
                    if (S) {
                        m.b().a0(s());
                        return;
                    }
                    return;
                }
                if (!S) {
                    if (f2.b(s)) {
                        return;
                    }
                    MessageSnapshot l = l(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.i().k(s)) {
                        f2.c(s);
                        h.i().a(s);
                    }
                    h.i().l(s, l);
                    return;
                }
                f2.c(s);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.i().l(s, l(th));
        }
    }
}
