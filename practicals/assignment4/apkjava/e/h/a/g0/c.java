package e.h.a.g0;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.services.c;
import com.liulishuo.filedownloader.services.i;
import e.h.a.f0.a;
import e.h.a.k0.c;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: CustomComponentHolder.java */
/* loaded from: classes2.dex */
public class c {
    private com.liulishuo.filedownloader.services.c a;

    /* renamed from: b, reason: collision with root package name */
    private c.a f21280b;

    /* renamed from: c, reason: collision with root package name */
    private c.b f21281c;

    /* renamed from: d, reason: collision with root package name */
    private c.e f21282d;

    /* renamed from: e, reason: collision with root package name */
    private e.h.a.f0.a f21283e;

    /* renamed from: f, reason: collision with root package name */
    private c.d f21284f;

    /* renamed from: g, reason: collision with root package name */
    private i f21285g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CustomComponentHolder.java */
    /* loaded from: classes2.dex */
    public static final class a {
        private static final c a = new c();
    }

    private c.a d() {
        c.a aVar = this.f21280b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21280b == null) {
                this.f21280b = g().a();
            }
        }
        return this.f21280b;
    }

    private c.b e() {
        c.b bVar = this.f21281c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f21281c == null) {
                this.f21281c = g().b();
            }
        }
        return this.f21281c;
    }

    private com.liulishuo.filedownloader.services.c g() {
        com.liulishuo.filedownloader.services.c cVar = this.a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new com.liulishuo.filedownloader.services.c();
            }
        }
        return this.a;
    }

    public static c j() {
        return a.a;
    }

    private c.e l() {
        c.e eVar = this.f21282d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f21282d == null) {
                this.f21282d = g().l();
            }
        }
        return this.f21282d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d4, code lost:
    
        if (r8.g() > 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0051, code lost:
    
        if (r8.g() <= 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fb A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:26:0x00f1, B:15:0x00fb, B:17:0x0111, B:19:0x0115, B:20:0x012d, B:21:0x0134, B:51:0x00a3, B:52:0x00c5, B:54:0x00cc, B:57:0x00da, B:60:0x00e5), top: B:25:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:72:0x0034, B:74:0x003b, B:76:0x0042, B:78:0x0049, B:10:0x0056, B:36:0x0065, B:38:0x0070, B:9:0x0053), top: B:71:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc A[Catch: all -> 0x013f, TryCatch #3 {all -> 0x013f, blocks: (B:26:0x00f1, B:15:0x00fb, B:17:0x0111, B:19:0x0115, B:20:0x012d, B:21:0x0134, B:51:0x00a3, B:52:0x00c5, B:54:0x00cc, B:57:0x00da, B:60:0x00e5), top: B:25:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void n(a.InterfaceC0272a interfaceC0272a) {
        long j2;
        long j3;
        String i2;
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<FileDownloadModel> it = interfaceC0272a.iterator();
        c.d i3 = j().i();
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        while (it.hasNext()) {
            try {
                FileDownloadModel next = it.next();
                String str2 = str;
                if (next.h() != 3) {
                    try {
                        if (next.h() != 2) {
                            if (next.h() != -1) {
                                if (next.h() == 1) {
                                }
                                i2 = next.i();
                                if (i2 != null) {
                                    j2 = currentTimeMillis;
                                    j3 = j4;
                                    z = true;
                                } else {
                                    File file = new File(i2);
                                    if (next.h() == -2) {
                                        j2 = currentTimeMillis;
                                        try {
                                            if (e.h.a.k0.f.I(next.e(), next, next.f(), null)) {
                                                File file2 = new File(next.j());
                                                if (!file2.exists() && file.exists()) {
                                                    boolean renameTo = file.renameTo(file2);
                                                    if (e.h.a.k0.d.a) {
                                                        j3 = j4;
                                                        e.h.a.k0.d.a(e.h.a.f0.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(renameTo), file.getPath(), file2.getPath());
                                                        if (next.h() != 1) {
                                                        }
                                                        if (e.h.a.k0.f.G(next.e(), next) && !file.exists()) {
                                                            z = false;
                                                        }
                                                        z = true;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            j3 = j4;
                                            str = str2;
                                            e.h.a.k0.f.N(e.h.a.k0.c.a());
                                            interfaceC0272a.T0();
                                            if (e.h.a.k0.d.a) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        j2 = currentTimeMillis;
                                    }
                                    j3 = j4;
                                    if (next.h() != 1) {
                                    }
                                    if (e.h.a.k0.f.G(next.e(), next)) {
                                        z = false;
                                    }
                                    z = true;
                                }
                                if (!z) {
                                    try {
                                        it.remove();
                                        interfaceC0272a.K(next);
                                        j5++;
                                        j4 = j3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = str2;
                                        e.h.a.k0.f.N(e.h.a.k0.c.a());
                                        interfaceC0272a.T0();
                                        if (e.h.a.k0.d.a) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    int e2 = next.e();
                                    int b2 = i3.b(e2, next.l(), next.f(), next.p());
                                    if (b2 != e2) {
                                        if (e.h.a.k0.d.a) {
                                            e.h.a.k0.d.a(e.h.a.f0.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(e2), Integer.valueOf(b2));
                                        }
                                        next.v(b2);
                                        interfaceC0272a.f0(e2, next);
                                        j6++;
                                    }
                                    interfaceC0272a.T(next);
                                    j4 = j3 + 1;
                                }
                                str = str2;
                                currentTimeMillis = j2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j2 = currentTimeMillis;
                        j3 = j4;
                        str = str2;
                        e.h.a.k0.f.N(e.h.a.k0.c.a());
                        interfaceC0272a.T0();
                        if (e.h.a.k0.d.a) {
                            e.h.a.k0.d.a(e.h.a.f0.a.class, str, Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(System.currentTimeMillis() - j2));
                        }
                        throw th;
                    }
                }
                next.y((byte) -2);
                i2 = next.i();
                if (i2 != null) {
                }
                if (!z) {
                }
                str = str2;
                currentTimeMillis = j2;
            } catch (Throwable th4) {
                th = th4;
                j2 = currentTimeMillis;
                j3 = j4;
            }
        }
        String str3 = str;
        long j7 = currentTimeMillis;
        long j8 = j4;
        e.h.a.k0.f.N(e.h.a.k0.c.a());
        interfaceC0272a.T0();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(e.h.a.f0.a.class, str3, Long.valueOf(j8), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(System.currentTimeMillis() - j7));
        }
    }

    public e.h.a.e0.b a(String str) throws IOException {
        return e().a(str);
    }

    public e.h.a.j0.a b(File file) throws IOException {
        return l().a(file);
    }

    public int c(int i2, String str, String str2, long j2) {
        return d().a(i2, str, str2, j2);
    }

    public e.h.a.f0.a f() {
        e.h.a.f0.a aVar = this.f21283e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21283e == null) {
                e.h.a.f0.a c2 = g().c();
                this.f21283e = c2;
                n(c2.b());
            }
        }
        return this.f21283e;
    }

    public i h() {
        i iVar = this.f21285g;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f21285g == null) {
                this.f21285g = g().j();
            }
        }
        return this.f21285g;
    }

    public c.d i() {
        c.d dVar = this.f21284f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f21284f == null) {
                this.f21284f = g().k();
            }
        }
        return this.f21284f;
    }

    public int k() {
        return g().n();
    }

    public boolean m() {
        return l().b();
    }

    public void o(c.a aVar) {
        synchronized (this) {
            this.a = new com.liulishuo.filedownloader.services.c(aVar);
            this.f21281c = null;
            this.f21282d = null;
            this.f21283e = null;
            this.f21284f = null;
        }
    }
}
