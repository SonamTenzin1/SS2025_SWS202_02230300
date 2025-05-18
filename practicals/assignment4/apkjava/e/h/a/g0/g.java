package e.h.a.g0;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FetchDataTask.java */
/* loaded from: classes2.dex */
public class g {
    private final h a;

    /* renamed from: b, reason: collision with root package name */
    private final int f21319b;

    /* renamed from: c, reason: collision with root package name */
    private final int f21320c;

    /* renamed from: d, reason: collision with root package name */
    private final e f21321d;

    /* renamed from: e, reason: collision with root package name */
    private final e.h.a.e0.b f21322e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f21323f;

    /* renamed from: g, reason: collision with root package name */
    private final long f21324g;

    /* renamed from: h, reason: collision with root package name */
    private final long f21325h;

    /* renamed from: i, reason: collision with root package name */
    private final long f21326i;

    /* renamed from: j, reason: collision with root package name */
    private final String f21327j;

    /* renamed from: k, reason: collision with root package name */
    long f21328k;
    private e.h.a.j0.a l;
    private volatile boolean m;
    private final e.h.a.f0.a n;
    private volatile long o;
    private volatile long p;

    /* compiled from: FetchDataTask.java */
    /* loaded from: classes2.dex */
    public static class b {
        e a;

        /* renamed from: b, reason: collision with root package name */
        e.h.a.e0.b f21329b;

        /* renamed from: c, reason: collision with root package name */
        e.h.a.g0.b f21330c;

        /* renamed from: d, reason: collision with root package name */
        h f21331d;

        /* renamed from: e, reason: collision with root package name */
        String f21332e;

        /* renamed from: f, reason: collision with root package name */
        Boolean f21333f;

        /* renamed from: g, reason: collision with root package name */
        Integer f21334g;

        /* renamed from: h, reason: collision with root package name */
        Integer f21335h;

        public g a() throws IllegalArgumentException {
            e.h.a.e0.b bVar;
            e.h.a.g0.b bVar2;
            Integer num;
            if (this.f21333f != null && (bVar = this.f21329b) != null && (bVar2 = this.f21330c) != null && this.f21331d != null && this.f21332e != null && (num = this.f21335h) != null && this.f21334g != null) {
                return new g(bVar, bVar2, this.a, num.intValue(), this.f21334g.intValue(), this.f21333f.booleanValue(), this.f21331d, this.f21332e);
            }
            throw new IllegalArgumentException();
        }

        public b b(h hVar) {
            this.f21331d = hVar;
            return this;
        }

        public b c(e.h.a.e0.b bVar) {
            this.f21329b = bVar;
            return this;
        }

        public b d(int i2) {
            this.f21334g = Integer.valueOf(i2);
            return this;
        }

        public b e(e.h.a.g0.b bVar) {
            this.f21330c = bVar;
            return this;
        }

        public b f(int i2) {
            this.f21335h = Integer.valueOf(i2);
            return this;
        }

        public b g(e eVar) {
            this.a = eVar;
            return this;
        }

        public b h(String str) {
            this.f21332e = str;
            return this;
        }

        public b i(boolean z) {
            this.f21333f = Boolean.valueOf(z);
            return this;
        }
    }

    private void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (e.h.a.k0.f.L(this.f21328k - this.o, elapsedRealtime - this.p)) {
            d();
            this.o = this.f21328k;
            this.p = elapsedRealtime;
        }
    }

    private void d() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.l.b();
            z = true;
        } catch (IOException e2) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z = false;
        }
        if (z) {
            int i2 = this.f21320c;
            if (i2 >= 0) {
                this.n.f(this.f21319b, i2, this.f21328k);
            } else {
                this.a.f();
            }
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c), Long.valueOf(this.f21328k), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void b() {
        this.m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ea, code lost:
    
        throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() throws IOException, IllegalAccessException, IllegalArgumentException, FileDownloadGiveUpRetryException {
        Throwable th;
        e.h.a.j0.a aVar;
        if (this.m) {
            return;
        }
        long h2 = e.h.a.k0.f.h(this.f21320c, this.f21322e);
        if (h2 == -1) {
            h2 = e.h.a.k0.f.i(this.f21322e);
        }
        if (h2 != 0) {
            long j2 = this.f21326i;
            if (j2 > 0 && h2 != j2) {
                throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.f21325h == -1 ? e.h.a.k0.f.o("range[%d-)", Long.valueOf(this.f21328k)) : e.h.a.k0.f.o("range[%d-%d)", Long.valueOf(this.f21328k), Long.valueOf(this.f21325h)), Long.valueOf(this.f21326i), Long.valueOf(h2), Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c)));
            }
            long j3 = this.f21328k;
            InputStream inputStream = null;
            try {
                boolean m = c.j().m();
                if (this.f21321d != null && !m) {
                    throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
                }
                aVar = e.h.a.k0.f.c(this.f21327j);
                try {
                    this.l = aVar;
                    if (m) {
                        aVar.c(this.f21328k);
                    }
                    if (e.h.a.k0.d.a) {
                        e.h.a.k0.d.a(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.f21320c), Long.valueOf(this.f21324g), Long.valueOf(this.f21325h), Long.valueOf(this.f21328k));
                    }
                    inputStream = this.f21322e.a();
                    byte[] bArr = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                    if (this.m) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                d();
                            } finally {
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.close();
                                return;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            if (aVar != null) {
                                try {
                                    d();
                                } finally {
                                    try {
                                        aVar.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                            if (aVar != null) {
                                try {
                                    aVar.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            long j4 = this.f21328k - j3;
                            if (h2 != -1 && h2 != j4) {
                                throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]", Long.valueOf(j4), Long.valueOf(h2), Long.valueOf(this.f21324g), Long.valueOf(this.f21325h), Long.valueOf(this.f21328k), Long.valueOf(j3)));
                            }
                            this.a.a(this.f21321d, this.f21324g, this.f21325h);
                            return;
                        }
                        aVar.write(bArr, 0, read);
                        long j5 = j3;
                        long j6 = read;
                        this.f21328k += j6;
                        this.a.d(j6);
                        a();
                        if (this.m) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                            try {
                                d();
                                try {
                                    aVar.close();
                                    return;
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    return;
                                }
                            } finally {
                            }
                        } else {
                            if (this.f21323f && e.h.a.k0.f.M()) {
                                break;
                            }
                            j3 = j5;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        try {
                            d();
                        } finally {
                            try {
                                aVar.close();
                                throw th;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    if (aVar != null) {
                        try {
                            aVar.close();
                            throw th;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        } else {
            throw new FileDownloadGiveUpRetryException(e.h.a.k0.f.o("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.f21319b), Integer.valueOf(this.f21320c)));
        }
    }

    private g(e.h.a.e0.b bVar, e.h.a.g0.b bVar2, e eVar, int i2, int i3, boolean z, h hVar, String str) {
        this.o = 0L;
        this.p = 0L;
        this.a = hVar;
        this.f21327j = str;
        this.f21322e = bVar;
        this.f21323f = z;
        this.f21321d = eVar;
        this.f21320c = i3;
        this.f21319b = i2;
        this.n = c.j().f();
        this.f21324g = bVar2.a;
        this.f21325h = bVar2.f21276c;
        this.f21328k = bVar2.f21275b;
        this.f21326i = bVar2.f21277d;
    }
}
