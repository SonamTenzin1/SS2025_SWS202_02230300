package e.h.a.g0;

import android.os.Process;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.g0.a;
import e.h.a.g0.g;
import java.io.IOException;
import java.net.SocketException;

/* compiled from: DownloadRunnable.java */
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final e.h.a.g0.a f21301f;

    /* renamed from: g, reason: collision with root package name */
    private final h f21302g;

    /* renamed from: h, reason: collision with root package name */
    private final String f21303h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f21304i;

    /* renamed from: j, reason: collision with root package name */
    private g f21305j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f21306k;
    private final int l;
    final int m;

    /* compiled from: DownloadRunnable.java */
    /* loaded from: classes2.dex */
    public static class b {
        private final a.b a = new a.b();

        /* renamed from: b, reason: collision with root package name */
        private h f21307b;

        /* renamed from: c, reason: collision with root package name */
        private String f21308c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f21309d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f21310e;

        public e a() {
            if (this.f21307b != null && this.f21308c != null && this.f21309d != null && this.f21310e != null) {
                e.h.a.g0.a a = this.a.a();
                return new e(a.a, this.f21310e.intValue(), a, this.f21307b, this.f21309d.booleanValue(), this.f21308c);
            }
            throw new IllegalArgumentException(e.h.a.k0.f.o("%s %s %B", this.f21307b, this.f21308c, this.f21309d));
        }

        public b b(h hVar) {
            this.f21307b = hVar;
            return this;
        }

        public b c(Integer num) {
            this.f21310e = num;
            return this;
        }

        public b d(e.h.a.g0.b bVar) {
            this.a.b(bVar);
            return this;
        }

        public b e(String str) {
            this.a.d(str);
            return this;
        }

        public b f(FileDownloadHeader fileDownloadHeader) {
            this.a.e(fileDownloadHeader);
            return this;
        }

        public b g(int i2) {
            this.a.c(i2);
            return this;
        }

        public b h(String str) {
            this.f21308c = str;
            return this;
        }

        public b i(String str) {
            this.a.f(str);
            return this;
        }

        public b j(boolean z) {
            this.f21309d = Boolean.valueOf(z);
            return this;
        }
    }

    private long b() {
        e.h.a.f0.a f2 = c.j().f();
        if (this.m >= 0) {
            for (com.liulishuo.filedownloader.model.a aVar : f2.n(this.l)) {
                if (aVar.d() == this.m) {
                    return aVar.a();
                }
            }
            return 0L;
        }
        FileDownloadModel o = f2.o(this.l);
        if (o != null) {
            return o.g();
        }
        return 0L;
    }

    public void a() {
        c();
    }

    public void c() {
        this.f21306k = true;
        g gVar = this.f21305j;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Exception e2;
        g.b bVar;
        Process.setThreadPriority(10);
        long j2 = this.f21301f.f().f21275b;
        e.h.a.e0.b bVar2 = null;
        boolean z2 = false;
        while (!this.f21306k) {
            try {
                try {
                    bVar2 = this.f21301f.c();
                    int d2 = bVar2.d();
                    if (e.h.a.k0.d.a) {
                        e.h.a.k0.d.a(this, "the connection[%d] for %d, is connected %s with code[%d]", Integer.valueOf(this.m), Integer.valueOf(this.l), this.f21301f.f(), Integer.valueOf(d2));
                    }
                    if (d2 != 206 && d2 != 200) {
                        throw new SocketException(e.h.a.k0.f.o("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.f21301f.g(), bVar2.b(), Integer.valueOf(d2), Integer.valueOf(this.l), Integer.valueOf(this.m)));
                        break;
                    }
                    try {
                        bVar = new g.b();
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e3) {
                        e2 = e3;
                        z = true;
                        try {
                            if (this.f21302g.e(e2)) {
                                if (z && this.f21305j == null) {
                                    e.h.a.k0.d.i(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                                    this.f21302g.b(e2);
                                    if (bVar2 == null) {
                                        return;
                                    }
                                } else {
                                    if (this.f21305j != null) {
                                        long b2 = b();
                                        if (b2 > 0) {
                                            this.f21301f.i(b2);
                                        }
                                    }
                                    this.f21302g.c(e2);
                                    if (bVar2 != null) {
                                        bVar2.g();
                                    }
                                    z2 = z;
                                }
                            } else {
                                this.f21302g.b(e2);
                                if (bVar2 == null) {
                                    return;
                                }
                            }
                            return;
                        } finally {
                            if (bVar2 != null) {
                                bVar2.g();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e4) {
                    e2 = e4;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e5) {
                z = z2;
                e2 = e5;
            }
            if (this.f21306k) {
                bVar2.g();
                return;
            }
            g a2 = bVar.f(this.l).d(this.m).b(this.f21302g).g(this).i(this.f21304i).c(bVar2).e(this.f21301f.f()).h(this.f21303h).a();
            this.f21305j = a2;
            a2.c();
            if (this.f21306k) {
                this.f21305j.b();
            }
            return;
        }
        if (bVar2 != null) {
            bVar2.g();
        }
    }

    private e(int i2, int i3, e.h.a.g0.a aVar, h hVar, boolean z, String str) {
        this.l = i2;
        this.m = i3;
        this.f21306k = false;
        this.f21302g = hVar;
        this.f21303h = str;
        this.f21301f = aVar;
        this.f21304i = z;
    }
}
