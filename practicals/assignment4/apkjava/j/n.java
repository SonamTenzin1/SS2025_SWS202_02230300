package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.kt */
/* loaded from: classes3.dex */
public final class n implements d0 {

    /* renamed from: f, reason: collision with root package name */
    private byte f22849f;

    /* renamed from: g, reason: collision with root package name */
    private final x f22850g;

    /* renamed from: h, reason: collision with root package name */
    private final Inflater f22851h;

    /* renamed from: i, reason: collision with root package name */
    private final o f22852i;

    /* renamed from: j, reason: collision with root package name */
    private final CRC32 f22853j;

    public n(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "source");
        x xVar = new x(d0Var);
        this.f22850g = xVar;
        Inflater inflater = new Inflater(true);
        this.f22851h = inflater;
        this.f22852i = new o((h) xVar, inflater);
        this.f22853j = new CRC32();
    }

    private final void a(String str, int i2, int i3) {
        if (i3 == i2) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    private final void b() throws IOException {
        this.f22850g.g1(10L);
        byte m = this.f22850g.f22874f.m(3L);
        boolean z = ((m >> 1) & 1) == 1;
        if (z) {
            d(this.f22850g.f22874f, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f22850g.readShort());
        this.f22850g.skip(8L);
        if (((m >> 2) & 1) == 1) {
            this.f22850g.g1(2L);
            if (z) {
                d(this.f22850g.f22874f, 0L, 2L);
            }
            long N = this.f22850g.f22874f.N();
            this.f22850g.g1(N);
            if (z) {
                d(this.f22850g.f22874f, 0L, N);
            }
            this.f22850g.skip(N);
        }
        if (((m >> 3) & 1) == 1) {
            long a = this.f22850g.a((byte) 0);
            if (a != -1) {
                if (z) {
                    d(this.f22850g.f22874f, 0L, a + 1);
                }
                this.f22850g.skip(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((m >> 4) & 1) == 1) {
            long a2 = this.f22850g.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    d(this.f22850g.f22874f, 0L, a2 + 1);
                }
                this.f22850g.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f22850g.j(), (short) this.f22853j.getValue());
            this.f22853j.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.f22850g.f(), (int) this.f22853j.getValue());
        a("ISIZE", this.f22850g.f(), (int) this.f22851h.getBytesWritten());
    }

    private final void d(f fVar, long j2, long j3) {
        y yVar = fVar.f22831f;
        kotlin.jvm.internal.m.c(yVar);
        while (true) {
            int i2 = yVar.f22880d;
            int i3 = yVar.f22879c;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
        }
        while (j3 > 0) {
            int min = (int) Math.min(yVar.f22880d - r7, j3);
            this.f22853j.update(yVar.f22878b, (int) (yVar.f22879c + j2), min);
            j3 -= min;
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
            j2 = 0;
        }
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22852i.close();
    }

    @Override // j.d0
    public long read(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        if (this.f22849f == 0) {
            b();
            this.f22849f = (byte) 1;
        }
        if (this.f22849f == 1) {
            long size = fVar.size();
            long read = this.f22852i.read(fVar, j2);
            if (read != -1) {
                d(fVar, size, read);
                return read;
            }
            this.f22849f = (byte) 2;
        }
        if (this.f22849f == 2) {
            c();
            this.f22849f = (byte) 3;
            if (!this.f22850g.R()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22850g.timeout();
    }
}
