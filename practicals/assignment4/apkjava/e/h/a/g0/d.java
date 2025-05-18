package e.h.a.g0;

import android.os.Process;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.g0.a;
import e.h.a.g0.b;
import e.h.a.g0.e;
import e.h.a.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DownloadLaunchRunnable.java */
/* loaded from: classes2.dex */
public class d implements Runnable, h {

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadPoolExecutor f21286f = e.h.a.k0.b.c("ConnectionBlock");
    private volatile boolean A;
    private volatile Exception B;
    private String C;
    private long D;
    private long E;
    private long F;
    private long G;

    /* renamed from: g, reason: collision with root package name */
    private final f f21287g;

    /* renamed from: h, reason: collision with root package name */
    private final int f21288h;

    /* renamed from: i, reason: collision with root package name */
    private final FileDownloadModel f21289i;

    /* renamed from: j, reason: collision with root package name */
    private final FileDownloadHeader f21290j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f21291k;
    private final boolean l;
    private final e.h.a.f0.a m;
    private final y n;
    private boolean o;
    int p;
    private boolean q;
    private final boolean r;
    private final ArrayList<e> s;
    private e t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private final AtomicBoolean y;
    private volatile boolean z;

    /* compiled from: DownloadLaunchRunnable.java */
    /* loaded from: classes2.dex */
    public static class b {
        private FileDownloadModel a;

        /* renamed from: b, reason: collision with root package name */
        private FileDownloadHeader f21292b;

        /* renamed from: c, reason: collision with root package name */
        private y f21293c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f21294d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f21295e;

        /* renamed from: f, reason: collision with root package name */
        private Boolean f21296f;

        /* renamed from: g, reason: collision with root package name */
        private Boolean f21297g;

        /* renamed from: h, reason: collision with root package name */
        private Integer f21298h;

        public d a() {
            if (this.a != null && this.f21293c != null && this.f21294d != null && this.f21295e != null && this.f21296f != null && this.f21297g != null && this.f21298h != null) {
                return new d(this.a, this.f21292b, this.f21293c, this.f21294d.intValue(), this.f21295e.intValue(), this.f21296f.booleanValue(), this.f21297g.booleanValue(), this.f21298h.intValue());
            }
            throw new IllegalArgumentException();
        }

        public b b(Integer num) {
            this.f21295e = num;
            return this;
        }

        public b c(Boolean bool) {
            this.f21296f = bool;
            return this;
        }

        public b d(FileDownloadHeader fileDownloadHeader) {
            this.f21292b = fileDownloadHeader;
            return this;
        }

        public b e(Integer num) {
            this.f21298h = num;
            return this;
        }

        public b f(Integer num) {
            this.f21294d = num;
            return this;
        }

        public b g(FileDownloadModel fileDownloadModel) {
            this.a = fileDownloadModel;
            return this;
        }

        public b h(y yVar) {
            this.f21293c = yVar;
            return this;
        }

        public b i(Boolean bool) {
            this.f21297g = bool;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadLaunchRunnable.java */
    /* loaded from: classes2.dex */
    public class c extends Throwable {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadLaunchRunnable.java */
    /* renamed from: e.h.a.g0.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0276d extends Throwable {
        C0276d() {
        }
    }

    private int g(long j2) {
        if (!q()) {
            return 1;
        }
        if (this.v) {
            return this.f21289i.a();
        }
        return e.h.a.g0.c.j().c(this.f21289i.e(), this.f21289i.l(), this.f21289i.f(), j2);
    }

    private void h() throws C0276d, c {
        int e2 = this.f21289i.e();
        if (this.f21289i.p()) {
            String i2 = this.f21289i.i();
            int r = e.h.a.k0.f.r(this.f21289i.l(), i2);
            if (!e.h.a.k0.c.d(e2, i2, this.f21291k, false)) {
                FileDownloadModel o = this.m.o(r);
                if (o != null) {
                    if (!e.h.a.k0.c.e(e2, o, this.n, false)) {
                        List<com.liulishuo.filedownloader.model.a> n = this.m.n(r);
                        this.m.remove(r);
                        this.m.h(r);
                        e.h.a.k0.f.e(this.f21289i.i());
                        if (e.h.a.k0.f.G(r, o)) {
                            this.f21289i.x(o.g());
                            this.f21289i.z(o.k());
                            this.f21289i.s(o.b());
                            this.f21289i.r(o.a());
                            this.m.j(this.f21289i);
                            if (n != null) {
                                for (com.liulishuo.filedownloader.model.a aVar : n) {
                                    aVar.i(e2);
                                    this.m.g(aVar);
                                }
                            }
                            throw new C0276d();
                        }
                    } else {
                        this.m.remove(e2);
                        this.m.h(e2);
                        throw new c();
                    }
                }
                if (e.h.a.k0.c.c(e2, this.f21289i.g(), this.f21289i.j(), i2, this.n)) {
                    this.m.remove(e2);
                    this.m.h(e2);
                    throw new c();
                }
                return;
            }
            this.m.remove(e2);
            this.m.h(e2);
            throw new c();
        }
    }

    private void i() throws FileDownloadGiveUpRetryException {
        if (this.l && !e.h.a.k0.f.a("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f21289i.e()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.l && e.h.a.k0.f.M()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void j(List<com.liulishuo.filedownloader.model.a> list, long j2) throws InterruptedException {
        long b2;
        int e2 = this.f21289i.e();
        String b3 = this.f21289i.b();
        String str = this.C;
        if (str == null) {
            str = this.f21289i.l();
        }
        String j3 = this.f21289i.j();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(e2), Long.valueOf(j2));
        }
        boolean z = this.v;
        long j4 = 0;
        long j5 = 0;
        for (com.liulishuo.filedownloader.model.a aVar : list) {
            if (aVar.b() == -1) {
                b2 = j2 - aVar.a();
            } else {
                b2 = (aVar.b() - aVar.a()) + 1;
            }
            long j6 = b2;
            j5 += aVar.a() - aVar.e();
            if (j6 == j4) {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.c()), Integer.valueOf(aVar.d()));
                }
            } else {
                e a2 = new e.b().g(e2).c(Integer.valueOf(aVar.d())).b(this).i(str).e(z ? b3 : null).f(this.f21290j).j(this.l).d(b.C0275b.b(aVar.e(), aVar.a(), aVar.b(), j6)).h(j3).a();
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "enable multiple connection: %s", aVar);
                }
                if (a2 != null) {
                    this.s.add(a2);
                } else {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
            }
            j4 = 0;
        }
        if (j5 != this.f21289i.g()) {
            e.h.a.k0.d.i(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f21289i.g()), Long.valueOf(j5));
            this.f21289i.x(j5);
        }
        ArrayList arrayList = new ArrayList(this.s.size());
        Iterator<e> it = this.s.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (this.z) {
                next.c();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.z) {
            this.f21289i.y((byte) -2);
            return;
        }
        List<Future> invokeAll = f21286f.invokeAll(arrayList);
        if (e.h.a.k0.d.a) {
            for (Future future : invokeAll) {
                e.h.a.k0.d.a(this, "finish sub-task for [%d] %B %B", Integer.valueOf(e2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void m(long j2, String str) throws IOException, IllegalAccessException {
        e.h.a.j0.a aVar = null;
        if (j2 != -1) {
            try {
                aVar = e.h.a.k0.f.c(this.f21289i.j());
                long length = new File(str).length();
                long j3 = j2 - length;
                long x = e.h.a.k0.f.x(str);
                if (x >= j3) {
                    if (!e.h.a.k0.e.a().f21368f) {
                        aVar.a(j2);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(x, j3, length);
                }
            } finally {
                if (0 != 0) {
                    aVar.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n(Map<String, List<String>> map, e.h.a.g0.a aVar, e.h.a.e0.b bVar) throws IOException, C0276d, IllegalArgumentException, FileDownloadSecurityException {
        boolean z;
        int e2 = this.f21289i.e();
        int d2 = bVar.d();
        this.w = e.h.a.k0.f.E(d2, bVar);
        boolean z2 = d2 == 200 || d2 == 201 || d2 == 0;
        long m = e.h.a.k0.f.m(bVar);
        String b2 = this.f21289i.b();
        String j2 = e.h.a.k0.f.j(e2, bVar);
        if (d2 != 412 && ((b2 == null || b2.equals(j2) || (!z2 && !this.w)) && (d2 != 201 || !aVar.h()))) {
            if (d2 == 416) {
                if (this.w && m >= 0) {
                    e.h.a.k0.d.i(this, "get 416 but the Content-Range is returned, no need to retry", new Object[0]);
                } else if (this.f21289i.g() > 0) {
                    e.h.a.k0.d.i(this, "get 416, precondition failed and just retry", new Object[0]);
                } else if (!this.q) {
                    this.q = true;
                    e.h.a.k0.d.i(this, "get 416, precondition failed and need to retry with discarding range", new Object[0]);
                }
            }
            z = false;
            if (!z) {
                if (this.v) {
                    e.h.a.k0.d.i(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", Integer.valueOf(e2), b2, j2, Integer.valueOf(d2));
                }
                this.m.h(this.f21289i.e());
                e.h.a.k0.f.f(this.f21289i.i(), this.f21289i.j());
                this.v = false;
                if (b2 != null && b2.equals(j2)) {
                    e.h.a.k0.d.i(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", b2, j2, Integer.valueOf(d2), Integer.valueOf(e2));
                    j2 = null;
                }
                this.f21289i.x(0L);
                this.f21289i.z(0L);
                this.f21289i.s(j2);
                this.f21289i.q();
                this.m.e(e2, this.f21289i.b(), this.f21289i.g(), this.f21289i.k(), this.f21289i.a());
                throw new C0276d();
            }
            this.C = aVar.e();
            if (!this.w && !z2) {
                throw new FileDownloadHttpException(d2, map, bVar.b());
            }
            String l = this.f21289i.p() ? e.h.a.k0.f.l(bVar, this.f21289i.l()) : null;
            this.x = m == -1;
            this.f21287g.n(this.v && this.w, m, j2, l);
            return;
        }
        z = true;
        if (!z) {
        }
    }

    private boolean q() {
        return (!this.v || this.f21289i.a() > 1) && this.w && this.r && !this.x;
    }

    private void t(long j2, int i2) throws InterruptedException {
        long j3 = j2 / i2;
        int e2 = this.f21289i.e();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        int i3 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + (-1) ? -1L : (j4 + j3) - 1;
            com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
            aVar.i(e2);
            aVar.j(i3);
            aVar.k(j4);
            aVar.g(j4);
            aVar.h(j5);
            arrayList.add(aVar);
            this.m.g(aVar);
            j4 += j3;
            i3++;
        }
        this.f21289i.r(i2);
        this.m.p(e2, i2);
        j(arrayList, j2);
    }

    private void u(int i2, List<com.liulishuo.filedownloader.model.a> list) throws InterruptedException {
        if (i2 > 1 && list.size() == i2) {
            j(list, this.f21289i.k());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void v(long j2) throws IOException, IllegalAccessException {
        e.h.a.g0.b c2;
        if (!this.w) {
            this.f21289i.x(0L);
            c2 = b.C0275b.a(j2);
        } else {
            c2 = b.C0275b.c(this.f21289i.g(), this.f21289i.g(), j2 - this.f21289i.g());
        }
        this.t = new e.b().g(this.f21289i.e()).c(-1).b(this).i(this.f21289i.l()).e(this.f21289i.b()).f(this.f21290j).j(this.l).d(c2).h(this.f21289i.j()).a();
        this.f21289i.r(1);
        this.m.p(this.f21289i.e(), 1);
        if (this.z) {
            this.f21289i.y((byte) -2);
            this.t.c();
        } else {
            this.t.run();
        }
    }

    private void w() throws IOException, C0276d, IllegalAccessException, FileDownloadSecurityException {
        e.h.a.g0.b d2;
        e.h.a.e0.b bVar = null;
        try {
            if (this.q) {
                d2 = b.C0275b.e();
            } else {
                d2 = b.C0275b.d();
            }
            e.h.a.g0.a a2 = new a.b().c(this.f21289i.e()).f(this.f21289i.l()).d(this.f21289i.b()).e(this.f21290j).b(d2).a();
            bVar = a2.c();
            n(a2.g(), a2, bVar);
        } finally {
            if (bVar != null) {
                bVar.g();
            }
        }
    }

    @Override // e.h.a.g0.h
    public void a(e eVar, long j2, long j3) {
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f21289i.e()));
                return;
            }
            return;
        }
        int i2 = eVar.m;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21289i.k()));
        }
        if (!this.u) {
            synchronized (this.s) {
                this.s.remove(eVar);
            }
        } else {
            if (j2 == 0 || j3 == this.f21289i.k()) {
                return;
            }
            e.h.a.k0.d.b(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21289i.k()), Integer.valueOf(this.f21289i.e()));
        }
    }

    @Override // e.h.a.g0.h
    public void b(Exception exc) {
        this.A = true;
        this.B = exc;
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f21289i.e()));
            }
        } else {
            Iterator it = ((ArrayList) this.s.clone()).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
    }

    @Override // e.h.a.g0.h
    public void c(Exception exc) {
        if (this.z) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f21289i.e()));
            }
        } else {
            int i2 = this.p;
            int i3 = i2 - 1;
            this.p = i3;
            if (i2 < 0) {
                e.h.a.k0.d.b(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.f21289i.e()));
            }
            this.f21287g.t(exc, this.p);
        }
    }

    @Override // e.h.a.g0.h
    public void d(long j2) {
        if (this.z) {
            return;
        }
        this.f21287g.s(j2);
    }

    @Override // e.h.a.g0.h
    public boolean e(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int b2 = ((FileDownloadHttpException) exc).b();
            if (this.u && b2 == 416 && !this.o) {
                e.h.a.k0.f.f(this.f21289i.i(), this.f21289i.j());
                this.o = true;
                return true;
            }
        }
        return this.p > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // e.h.a.g0.h
    public void f() {
        this.m.l(this.f21289i.e(), this.f21289i.g());
    }

    public int k() {
        return this.f21289i.e();
    }

    public String l() {
        return this.f21289i.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void o(List<com.liulishuo.filedownloader.model.a> list) {
        long g2;
        boolean z;
        int a2 = this.f21289i.a();
        String j2 = this.f21289i.j();
        String i2 = this.f21289i.i();
        boolean z2 = a2 > 1;
        if (!this.q && ((!z2 || this.r) && e.h.a.k0.f.G(this.f21289i.e(), this.f21289i))) {
            if (!this.r) {
                g2 = new File(j2).length();
            } else if (z2) {
                if (a2 == list.size()) {
                    g2 = com.liulishuo.filedownloader.model.a.f(list);
                }
            } else {
                g2 = this.f21289i.g();
            }
            this.f21289i.x(g2);
            z = g2 > 0;
            this.v = z;
            if (z) {
                this.m.h(this.f21289i.e());
                e.h.a.k0.f.f(i2, j2);
                return;
            }
            return;
        }
        g2 = 0;
        this.f21289i.x(g2);
        if (g2 > 0) {
        }
        this.v = z;
        if (z) {
        }
    }

    public boolean p() {
        return this.y.get() || this.f21287g.l();
    }

    public void r() {
        this.z = true;
        e eVar = this.t;
        if (eVar != null) {
            eVar.c();
        }
        Iterator it = ((ArrayList) this.s.clone()).iterator();
        while (it.hasNext()) {
            e eVar2 = (e) it.next();
            if (eVar2 != null) {
                eVar2.c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c1 A[Catch: all -> 0x01f6, TryCatch #12 {all -> 0x01f6, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:25:0x0030, B:26:0x008d, B:28:0x0091, B:30:0x0096, B:116:0x009a, B:118:0x009e, B:33:0x00c6, B:35:0x00e2, B:44:0x0100, B:56:0x0136, B:58:0x013a, B:69:0x015f, B:71:0x0163, B:85:0x0167, B:87:0x0170, B:88:0x0174, B:90:0x0178, B:91:0x018b, B:109:0x018c, B:93:0x01bb, B:95:0x01c1, B:99:0x01c6), top: B:2:0x0003, inners: #15, #12, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c6 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        List<com.liulishuo.filedownloader.model.a> n;
        try {
            Process.setThreadPriority(10);
            if (this.f21289i.h() != 1) {
                if (this.f21289i.h() == -2) {
                    if (e.h.a.k0.d.a) {
                        e.h.a.k0.d.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f21289i.e()));
                    }
                } else {
                    b(new RuntimeException(e.h.a.k0.f.o("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f21289i.e()), Byte.valueOf(this.f21289i.h()), (byte) 1)));
                }
                this.f21287g.b();
                if (!this.z) {
                    if (!this.A) {
                        try {
                            this.f21287g.m();
                        } catch (IOException e2) {
                            e = e2;
                            this.f21287g.o(e);
                            this.y.set(false);
                        }
                        this.y.set(false);
                    }
                    this.f21287g.o(this.B);
                    this.y.set(false);
                }
                this.f21287g.q();
                this.y.set(false);
            }
            if (!this.z) {
                this.f21287g.u();
            }
            while (!this.z) {
                try {
                    i();
                    w();
                    h();
                    n = this.m.n(this.f21289i.e());
                    o(n);
                } catch (FileDownloadGiveUpRetryException e3) {
                    e = e3;
                    if (!e(e)) {
                        c(e);
                    } else {
                        b(e);
                        this.f21287g.b();
                        if (!this.z) {
                        }
                        this.y.set(false);
                        return;
                    }
                } catch (FileDownloadSecurityException e4) {
                    e = e4;
                    if (!e(e)) {
                    }
                } catch (c unused) {
                    this.f21287g.b();
                    if (!this.z) {
                        if (!this.A) {
                            try {
                                this.f21287g.m();
                            } catch (IOException e5) {
                                e = e5;
                                this.f21287g.o(e);
                                this.y.set(false);
                            }
                        }
                    }
                } catch (C0276d unused2) {
                    this.f21289i.y((byte) 5);
                } catch (IOException e6) {
                    e = e6;
                    if (!e(e)) {
                    }
                } catch (IllegalAccessException e7) {
                    e = e7;
                    if (!e(e)) {
                    }
                } catch (IllegalArgumentException e8) {
                    e = e8;
                    if (!e(e)) {
                    }
                } catch (InterruptedException e9) {
                    e = e9;
                    if (!e(e)) {
                    }
                }
                if (this.z) {
                    this.f21289i.y((byte) -2);
                    this.f21287g.b();
                    if (!this.z) {
                        if (!this.A) {
                            try {
                                this.f21287g.m();
                            } catch (IOException e10) {
                                e = e10;
                                this.f21287g.o(e);
                                this.y.set(false);
                            }
                            this.y.set(false);
                        }
                        this.f21287g.o(this.B);
                        this.y.set(false);
                    }
                    this.f21287g.q();
                    this.y.set(false);
                }
                long k2 = this.f21289i.k();
                m(k2, this.f21289i.j());
                int g2 = g(k2);
                if (g2 <= 0) {
                    throw new IllegalAccessException(e.h.a.k0.f.o("invalid connection count %d, the connection count must be larger than 0", Integer.valueOf(g2)));
                }
                if (k2 == 0) {
                    this.f21287g.b();
                    if (!this.z) {
                        if (!this.A) {
                            try {
                                this.f21287g.m();
                            } catch (IOException e11) {
                                e = e11;
                                this.f21287g.o(e);
                                this.y.set(false);
                            }
                            this.y.set(false);
                        }
                        this.f21287g.o(this.B);
                        this.y.set(false);
                    }
                    this.f21287g.q();
                    this.y.set(false);
                }
                if (this.z) {
                    this.f21289i.y((byte) -2);
                    this.f21287g.b();
                    if (!this.z) {
                        if (!this.A) {
                            try {
                                this.f21287g.m();
                            } catch (IOException e12) {
                                e = e12;
                                this.f21287g.o(e);
                                this.y.set(false);
                            }
                            this.y.set(false);
                        }
                        this.f21287g.o(this.B);
                        this.y.set(false);
                    }
                    this.f21287g.q();
                    this.y.set(false);
                }
                boolean z = g2 == 1;
                this.u = z;
                if (z) {
                    v(k2);
                } else {
                    this.f21287g.p();
                    if (this.v) {
                        u(g2, n);
                    } else {
                        t(k2, g2);
                    }
                }
                this.f21287g.b();
                if (!this.z) {
                    this.f21287g.q();
                } else if (this.A) {
                    this.f21287g.o(this.B);
                } else {
                    try {
                        this.f21287g.m();
                    } catch (IOException e13) {
                        this.f21287g.o(e13);
                    }
                }
                this.y.set(false);
                return;
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f21289i.e()));
            }
            this.f21287g.b();
            if (!this.z) {
                if (!this.A) {
                    try {
                        this.f21287g.m();
                    } catch (IOException e14) {
                        e = e14;
                        this.f21287g.o(e);
                        this.y.set(false);
                    }
                    this.y.set(false);
                }
                this.f21287g.o(this.B);
                this.y.set(false);
            }
            this.f21287g.q();
            this.y.set(false);
        } catch (Throwable th) {
            this.f21287g.b();
            if (!this.z) {
                if (this.A) {
                    this.f21287g.o(this.B);
                } else {
                    try {
                        this.f21287g.m();
                    } catch (IOException e15) {
                        this.f21287g.o(e15);
                    }
                }
            } else {
                this.f21287g.q();
            }
            this.y.set(false);
            throw th;
        }
    }

    public void s() {
        o(this.m.n(this.f21289i.e()));
        this.f21287g.r();
    }

    private d(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, y yVar, int i2, int i3, boolean z, boolean z2, int i4) {
        this.f21288h = 5;
        this.q = false;
        this.s = new ArrayList<>(5);
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.y = new AtomicBoolean(true);
        this.z = false;
        this.o = false;
        this.f21289i = fileDownloadModel;
        this.f21290j = fileDownloadHeader;
        this.f21291k = z;
        this.l = z2;
        this.m = e.h.a.g0.c.j().f();
        this.r = e.h.a.g0.c.j().m();
        this.n = yVar;
        this.p = i4;
        this.f21287g = new f(fileDownloadModel, i4, i2, i3);
    }
}
