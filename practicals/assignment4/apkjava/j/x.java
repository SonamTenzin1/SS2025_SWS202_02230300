package j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes3.dex */
public final class x implements h {

    /* renamed from: f, reason: collision with root package name */
    public final f f22874f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22875g;

    /* renamed from: h, reason: collision with root package name */
    public final d0 f22876h;

    public x(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "source");
        this.f22876h = d0Var;
        this.f22874f = new f();
    }

    @Override // j.h
    public i D0() {
        this.f22874f.B0(this.f22876h);
        return this.f22874f.D0();
    }

    @Override // j.h
    public String L0() {
        return g0(Long.MAX_VALUE);
    }

    @Override // j.h
    public byte[] M() {
        this.f22874f.B0(this.f22876h);
        return this.f22874f.M();
    }

    @Override // j.h
    public byte[] O0(long j2) {
        g1(j2);
        return this.f22874f.O0(j2);
    }

    @Override // j.h
    public long P(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        return c(iVar, 0L);
    }

    @Override // j.h
    public boolean R() {
        if (!this.f22875g) {
            return this.f22874f.R() && this.f22876h.read(this.f22874f, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.h
    public void X(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "sink");
        try {
            g1(j2);
            this.f22874f.X(fVar, j2);
        } catch (EOFException e2) {
            fVar.B0(this.f22874f);
            throw e2;
        }
    }

    @Override // j.h
    public long Y0(b0 b0Var) {
        kotlin.jvm.internal.m.f(b0Var, "sink");
        long j2 = 0;
        while (this.f22876h.read(this.f22874f, 8192) != -1) {
            long e2 = this.f22874f.e();
            if (e2 > 0) {
                j2 += e2;
                b0Var.write(this.f22874f, e2);
            }
        }
        if (this.f22874f.size() <= 0) {
            return j2;
        }
        long size = j2 + this.f22874f.size();
        f fVar = this.f22874f;
        b0Var.write(fVar, fVar.size());
        return size;
    }

    public long a(byte b2) {
        return b(b2, 0L, Long.MAX_VALUE);
    }

    public long b(byte b2, long j2, long j3) {
        if (!(!this.f22875g)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long p = this.f22874f.p(b2, j2, j3);
            if (p != -1) {
                return p;
            }
            long size = this.f22874f.size();
            if (size >= j3 || this.f22876h.read(this.f22874f, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
        return -1L;
    }

    @Override // j.h
    public long b0(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "targetBytes");
        return d(iVar, 0L);
    }

    public long c(i iVar, long j2) {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        if (!(!this.f22875g)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long A = this.f22874f.A(iVar, j2);
            if (A != -1) {
                return A;
            }
            long size = this.f22874f.size();
            if (this.f22876h.read(this.f22874f, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - iVar.P()) + 1);
        }
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f22875g) {
            return;
        }
        this.f22875g = true;
        this.f22876h.close();
        this.f22874f.b();
    }

    public long d(i iVar, long j2) {
        kotlin.jvm.internal.m.f(iVar, "targetBytes");
        if (!(!this.f22875g)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long B = this.f22874f.B(iVar, j2);
            if (B != -1) {
                return B;
            }
            long size = this.f22874f.size();
            if (this.f22876h.read(this.f22874f, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r4 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9] or '-' character but was 0x");
        r2 = kotlin.text.b.a(16);
        r2 = kotlin.text.b.a(r2);
        r2 = java.lang.Integer.toString(r8, r2);
        kotlin.jvm.internal.m.e(r2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long d0() {
        g1(1L);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!request(j3)) {
                break;
            }
            byte m = this.f22874f.m(j2);
            if ((m < ((byte) 48) || m > ((byte) 57)) && !(j2 == 0 && m == ((byte) 45))) {
                break;
            }
            j2 = j3;
        }
        return this.f22874f.d0();
    }

    public boolean e(long j2, i iVar, int i2, int i3) {
        int i4;
        kotlin.jvm.internal.m.f(iVar, "bytes");
        if (!this.f22875g) {
            if (j2 >= 0 && i2 >= 0 && i3 >= 0 && iVar.P() - i2 >= i3) {
                while (i4 < i3) {
                    long j3 = i4 + j2;
                    i4 = (request(1 + j3) && this.f22874f.m(j3) == iVar.x(i2 + i4)) ? i4 + 1 : 0;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public int f() {
        g1(4L);
        return this.f22874f.K();
    }

    @Override // j.h
    public String g0(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b2 = (byte) 10;
            long b3 = b(b2, 0L, j3);
            if (b3 != -1) {
                return j.g0.a.d(this.f22874f, b3);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.f22874f.m(j3 - 1) == ((byte) 13) && request(1 + j3) && this.f22874f.m(j3) == b2) {
                return j.g0.a.d(this.f22874f, j3);
            }
            f fVar = new f();
            f fVar2 = this.f22874f;
            fVar2.j(fVar, 0L, Math.min(32, fVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f22874f.size(), j2) + " content=" + fVar.D0().F() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @Override // j.h
    public void g1(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    @Override // j.h, j.g
    public f i() {
        return this.f22874f;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f22875g;
    }

    public short j() {
        g1(2L);
        return this.f22874f.N();
    }

    @Override // j.h
    public long m1() {
        byte m;
        int a2;
        int a3;
        g1(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            m = this.f22874f.m(i2);
            if ((m < ((byte) 48) || m > ((byte) 57)) && ((m < ((byte) 97) || m > ((byte) 102)) && (m < ((byte) 65) || m > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a2 = kotlin.text.b.a(16);
            a3 = kotlin.text.b.a(a2);
            String num = Integer.toString(m, a3);
            kotlin.jvm.internal.m.e(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.f22874f.m1();
    }

    @Override // j.h
    public InputStream o1() {
        return new a();
    }

    @Override // j.h
    public int p1(t tVar) {
        kotlin.jvm.internal.m.f(tVar, "options");
        if (!(!this.f22875g)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int e2 = j.g0.a.e(this.f22874f, tVar, true);
            if (e2 != -2) {
                if (e2 != -1) {
                    this.f22874f.skip(tVar.i()[e2].P());
                    return e2;
                }
            } else if (this.f22876h.read(this.f22874f, 8192) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // j.h
    public h peek() {
        return q.d(new v(this));
    }

    @Override // j.d0
    public long read(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (j2 >= 0) {
            if (!(true ^ this.f22875g)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f22874f.size() == 0 && this.f22876h.read(this.f22874f, 8192) == -1) {
                return -1L;
            }
            return this.f22874f.read(fVar, Math.min(j2, this.f22874f.size()));
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.h
    public byte readByte() {
        g1(1L);
        return this.f22874f.readByte();
    }

    @Override // j.h
    public void readFully(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "sink");
        try {
            g1(bArr.length);
            this.f22874f.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.f22874f.size() > 0) {
                f fVar = this.f22874f;
                int read = fVar.read(bArr, i2, (int) fVar.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i2 += read;
            }
            throw e2;
        }
    }

    @Override // j.h
    public int readInt() {
        g1(4L);
        return this.f22874f.readInt();
    }

    @Override // j.h
    public long readLong() {
        g1(8L);
        return this.f22874f.readLong();
    }

    @Override // j.h
    public short readShort() {
        g1(2L);
        return this.f22874f.readShort();
    }

    @Override // j.h
    public boolean request(long j2) {
        if (j2 >= 0) {
            if (!(!this.f22875g)) {
                throw new IllegalStateException("closed".toString());
            }
            while (this.f22874f.size() < j2) {
                if (this.f22876h.read(this.f22874f, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.h
    public void skip(long j2) {
        if (!(!this.f22875g)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.f22874f.size() == 0 && this.f22876h.read(this.f22874f, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.f22874f.size());
            this.f22874f.skip(min);
            j2 -= min;
        }
    }

    @Override // j.h
    public f t() {
        return this.f22874f;
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22876h.timeout();
    }

    public String toString() {
        return "buffer(" + this.f22876h + ')';
    }

    @Override // j.h
    public i u(long j2) {
        g1(j2);
        return this.f22874f.u(j2);
    }

    @Override // j.h
    public boolean v0(long j2, i iVar) {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        return e(j2, iVar, 0, iVar.P());
    }

    @Override // j.h
    public String w0(Charset charset) {
        kotlin.jvm.internal.m.f(charset, "charset");
        this.f22874f.B0(this.f22876h);
        return this.f22874f.w0(charset);
    }

    /* compiled from: RealBufferedSource.kt */
    /* loaded from: classes3.dex */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            x xVar = x.this;
            if (!xVar.f22875g) {
                return (int) Math.min(xVar.f22874f.size(), Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            x.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            x xVar = x.this;
            if (!xVar.f22875g) {
                if (xVar.f22874f.size() == 0) {
                    x xVar2 = x.this;
                    if (xVar2.f22876h.read(xVar2.f22874f, 8192) == -1) {
                        return -1;
                    }
                }
                return x.this.f22874f.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return x.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            kotlin.jvm.internal.m.f(bArr, "data");
            if (!x.this.f22875g) {
                c.b(bArr.length, i2, i3);
                if (x.this.f22874f.size() == 0) {
                    x xVar = x.this;
                    if (xVar.f22876h.read(xVar.f22874f, 8192) == -1) {
                        return -1;
                    }
                }
                return x.this.f22874f.read(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.m.f(byteBuffer, "sink");
        if (this.f22874f.size() == 0 && this.f22876h.read(this.f22874f, 8192) == -1) {
            return -1;
        }
        return this.f22874f.read(byteBuffer);
    }
}
