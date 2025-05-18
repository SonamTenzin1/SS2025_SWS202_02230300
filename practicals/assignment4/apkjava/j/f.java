package j;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;
import okhttp3.internal.connection.RealConnection;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class f implements h, g, Cloneable, ByteChannel {

    /* renamed from: f, reason: collision with root package name */
    public y f22831f;

    /* renamed from: g, reason: collision with root package name */
    private long f22832g;

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Closeable {

        /* renamed from: f, reason: collision with root package name */
        public f f22833f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f22834g;

        /* renamed from: h, reason: collision with root package name */
        private y f22835h;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f22837j;

        /* renamed from: i, reason: collision with root package name */
        public long f22836i = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f22838k = -1;
        public int l = -1;

        public final y a() {
            return this.f22835h;
        }

        public final int b() {
            long j2 = this.f22836i;
            f fVar = this.f22833f;
            kotlin.jvm.internal.m.c(fVar);
            if (j2 != fVar.size()) {
                long j3 = this.f22836i;
                return d(j3 == -1 ? 0L : j3 + (this.l - this.f22838k));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long c(long j2) {
            f fVar = this.f22833f;
            if (fVar != null) {
                if (this.f22834g) {
                    long size = fVar.size();
                    int i2 = 1;
                    if (j2 <= size) {
                        if (j2 >= 0) {
                            long j3 = size - j2;
                            while (true) {
                                if (j3 <= 0) {
                                    break;
                                }
                                y yVar = fVar.f22831f;
                                kotlin.jvm.internal.m.c(yVar);
                                y yVar2 = yVar.f22884h;
                                kotlin.jvm.internal.m.c(yVar2);
                                int i3 = yVar2.f22880d;
                                long j4 = i3 - yVar2.f22879c;
                                if (j4 <= j3) {
                                    fVar.f22831f = yVar2.b();
                                    z.b(yVar2);
                                    j3 -= j4;
                                } else {
                                    yVar2.f22880d = i3 - ((int) j3);
                                    break;
                                }
                            }
                            e(null);
                            this.f22836i = j2;
                            this.f22837j = null;
                            this.f22838k = -1;
                            this.l = -1;
                        } else {
                            throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                        }
                    } else if (j2 > size) {
                        long j5 = j2 - size;
                        boolean z = true;
                        while (j5 > 0) {
                            y q0 = fVar.q0(i2);
                            int min = (int) Math.min(j5, 8192 - q0.f22880d);
                            q0.f22880d += min;
                            j5 -= min;
                            if (z) {
                                e(q0);
                                this.f22836i = size;
                                this.f22837j = q0.f22878b;
                                int i4 = q0.f22880d;
                                this.f22838k = i4 - min;
                                this.l = i4;
                                z = false;
                            }
                            i2 = 1;
                        }
                    }
                    fVar.f0(j2);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f22833f != null) {
                this.f22833f = null;
                e(null);
                this.f22836i = -1L;
                this.f22837j = null;
                this.f22838k = -1;
                this.l = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int d(long j2) {
            y yVar;
            f fVar = this.f22833f;
            if (fVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j2 < -1 || j2 > fVar.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + fVar.size());
            }
            if (j2 != -1 && j2 != fVar.size()) {
                long j3 = 0;
                long size = fVar.size();
                y yVar2 = fVar.f22831f;
                if (a() != null) {
                    long j4 = this.f22836i;
                    int i2 = this.f22838k;
                    kotlin.jvm.internal.m.c(a());
                    long j5 = j4 - (i2 - r12.f22879c);
                    if (j5 > j2) {
                        yVar2 = a();
                        size = j5;
                        yVar = yVar2;
                    } else {
                        yVar = a();
                        j3 = j5;
                    }
                } else {
                    yVar = yVar2;
                }
                if (size - j2 > j2 - j3) {
                    while (true) {
                        kotlin.jvm.internal.m.c(yVar);
                        int i3 = yVar.f22880d;
                        int i4 = yVar.f22879c;
                        if (j2 < (i3 - i4) + j3) {
                            break;
                        }
                        j3 += i3 - i4;
                        yVar = yVar.f22883g;
                    }
                } else {
                    while (size > j2) {
                        kotlin.jvm.internal.m.c(yVar2);
                        yVar2 = yVar2.f22884h;
                        kotlin.jvm.internal.m.c(yVar2);
                        size -= yVar2.f22880d - yVar2.f22879c;
                    }
                    j3 = size;
                    yVar = yVar2;
                }
                if (this.f22834g) {
                    kotlin.jvm.internal.m.c(yVar);
                    if (yVar.f22881e) {
                        y f2 = yVar.f();
                        if (fVar.f22831f == yVar) {
                            fVar.f22831f = f2;
                        }
                        yVar = yVar.c(f2);
                        y yVar3 = yVar.f22884h;
                        kotlin.jvm.internal.m.c(yVar3);
                        yVar3.b();
                    }
                }
                e(yVar);
                this.f22836i = j2;
                kotlin.jvm.internal.m.c(yVar);
                this.f22837j = yVar.f22878b;
                int i5 = yVar.f22879c + ((int) (j2 - j3));
                this.f22838k = i5;
                int i6 = yVar.f22880d;
                this.l = i6;
                return i6 - i5;
            }
            e(null);
            this.f22836i = j2;
            this.f22837j = null;
            this.f22838k = -1;
            this.l = -1;
            return -1;
        }

        public final void e(y yVar) {
            this.f22835h = yVar;
        }
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return f.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            f.this.writeByte(i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            kotlin.jvm.internal.m.f(bArr, "data");
            f.this.write(bArr, i2, i3);
        }
    }

    public static /* synthetic */ a J(f fVar, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a();
        }
        return fVar.I(aVar);
    }

    public long A(i iVar, long j2) throws IOException {
        long j3 = j2;
        kotlin.jvm.internal.m.f(iVar, "bytes");
        if (!(iVar.P() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j4 = 0;
        if (j3 >= 0) {
            y yVar = this.f22831f;
            if (yVar != null) {
                if (size() - j3 < j3) {
                    long size = size();
                    while (size > j3) {
                        yVar = yVar.f22884h;
                        kotlin.jvm.internal.m.c(yVar);
                        size -= yVar.f22880d - yVar.f22879c;
                    }
                    byte[] G = iVar.G();
                    byte b2 = G[0];
                    int P = iVar.P();
                    long size2 = (size() - P) + 1;
                    while (size < size2) {
                        byte[] bArr = yVar.f22878b;
                        long j5 = size;
                        int min = (int) Math.min(yVar.f22880d, (yVar.f22879c + size2) - size);
                        for (int i2 = (int) ((yVar.f22879c + j3) - j5); i2 < min; i2++) {
                            if (bArr[i2] == b2 && j.g0.a.c(yVar, i2 + 1, G, 1, P)) {
                                return (i2 - yVar.f22879c) + j5;
                            }
                        }
                        j3 = j5 + (yVar.f22880d - yVar.f22879c);
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                        size = j3;
                    }
                } else {
                    while (true) {
                        long j6 = (yVar.f22880d - yVar.f22879c) + j4;
                        if (j6 > j3) {
                            break;
                        }
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                        j4 = j6;
                    }
                    byte[] G2 = iVar.G();
                    byte b3 = G2[0];
                    int P2 = iVar.P();
                    long size3 = (size() - P2) + 1;
                    while (j4 < size3) {
                        byte[] bArr2 = yVar.f22878b;
                        long j7 = size3;
                        int min2 = (int) Math.min(yVar.f22880d, (yVar.f22879c + size3) - j4);
                        for (int i3 = (int) ((yVar.f22879c + j3) - j4); i3 < min2; i3++) {
                            if (bArr2[i3] == b3 && j.g0.a.c(yVar, i3 + 1, G2, 1, P2)) {
                                return (i3 - yVar.f22879c) + j4;
                            }
                        }
                        j4 += yVar.f22880d - yVar.f22879c;
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                        j3 = j4;
                        size3 = j7;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
    }

    public long B(i iVar, long j2) {
        int i2;
        int i3;
        kotlin.jvm.internal.m.f(iVar, "targetBytes");
        long j3 = 0;
        if (j2 >= 0) {
            y yVar = this.f22831f;
            if (yVar == null) {
                return -1L;
            }
            if (size() - j2 < j2) {
                j3 = size();
                while (j3 > j2) {
                    yVar = yVar.f22884h;
                    kotlin.jvm.internal.m.c(yVar);
                    j3 -= yVar.f22880d - yVar.f22879c;
                }
                if (iVar.P() == 2) {
                    byte x = iVar.x(0);
                    byte x2 = iVar.x(1);
                    while (j3 < size()) {
                        byte[] bArr = yVar.f22878b;
                        i2 = (int) ((yVar.f22879c + j2) - j3);
                        int i4 = yVar.f22880d;
                        while (i2 < i4) {
                            byte b2 = bArr[i2];
                            if (b2 != x && b2 != x2) {
                                i2++;
                            }
                            i3 = yVar.f22879c;
                        }
                        j3 += yVar.f22880d - yVar.f22879c;
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                        j2 = j3;
                    }
                    return -1L;
                }
                byte[] G = iVar.G();
                while (j3 < size()) {
                    byte[] bArr2 = yVar.f22878b;
                    i2 = (int) ((yVar.f22879c + j2) - j3);
                    int i5 = yVar.f22880d;
                    while (i2 < i5) {
                        byte b3 = bArr2[i2];
                        for (byte b4 : G) {
                            if (b3 == b4) {
                                i3 = yVar.f22879c;
                            }
                        }
                        i2++;
                    }
                    j3 += yVar.f22880d - yVar.f22879c;
                    yVar = yVar.f22883g;
                    kotlin.jvm.internal.m.c(yVar);
                    j2 = j3;
                }
                return -1L;
            }
            while (true) {
                long j4 = (yVar.f22880d - yVar.f22879c) + j3;
                if (j4 > j2) {
                    break;
                }
                yVar = yVar.f22883g;
                kotlin.jvm.internal.m.c(yVar);
                j3 = j4;
            }
            if (iVar.P() == 2) {
                byte x3 = iVar.x(0);
                byte x4 = iVar.x(1);
                while (j3 < size()) {
                    byte[] bArr3 = yVar.f22878b;
                    i2 = (int) ((yVar.f22879c + j2) - j3);
                    int i6 = yVar.f22880d;
                    while (i2 < i6) {
                        byte b5 = bArr3[i2];
                        if (b5 != x3 && b5 != x4) {
                            i2++;
                        }
                        i3 = yVar.f22879c;
                    }
                    j3 += yVar.f22880d - yVar.f22879c;
                    yVar = yVar.f22883g;
                    kotlin.jvm.internal.m.c(yVar);
                    j2 = j3;
                }
                return -1L;
            }
            byte[] G2 = iVar.G();
            while (j3 < size()) {
                byte[] bArr4 = yVar.f22878b;
                i2 = (int) ((yVar.f22879c + j2) - j3);
                int i7 = yVar.f22880d;
                while (i2 < i7) {
                    byte b6 = bArr4[i2];
                    for (byte b7 : G2) {
                        if (b6 == b7) {
                            i3 = yVar.f22879c;
                        }
                    }
                    i2++;
                }
                j3 += yVar.f22880d - yVar.f22879c;
                yVar = yVar.f22883g;
                kotlin.jvm.internal.m.c(yVar);
                j2 = j3;
            }
            return -1L;
            return (i2 - i3) + j3;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }

    @Override // j.g
    public long B0(d0 d0Var) throws IOException {
        kotlin.jvm.internal.m.f(d0Var, "source");
        long j2 = 0;
        while (true) {
            long read = d0Var.read(this, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    public OutputStream D() {
        return new c();
    }

    @Override // j.h
    public i D0() {
        return u(size());
    }

    @Override // j.g
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public f write(byte[] bArr, int i2, int i3) {
        kotlin.jvm.internal.m.f(bArr, "source");
        long j2 = i3;
        j.c.b(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            y q0 = q0(1);
            int min = Math.min(i4 - i2, 8192 - q0.f22880d);
            int i5 = i2 + min;
            kotlin.collections.j.d(bArr, q0.f22878b, q0.f22880d, i2, i5);
            q0.f22880d += min;
            i2 = i5;
        }
        f0(size() + j2);
        return this;
    }

    @Override // j.g
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public f writeByte(int i2) {
        y q0 = q0(1);
        byte[] bArr = q0.f22878b;
        int i3 = q0.f22880d;
        q0.f22880d = i3 + 1;
        bArr[i3] = (byte) i2;
        f0(size() + 1);
        return this;
    }

    @Override // j.g
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public f i1(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return r0("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        y q0 = q0(i2);
        byte[] bArr = q0.f22878b;
        int i3 = q0.f22880d + i2;
        while (j2 != 0) {
            long j3 = 10;
            i3--;
            bArr[i3] = j.g0.a.b()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        q0.f22880d += i2;
        f0(size() + i2);
        return this;
    }

    public boolean H(long j2, i iVar, int i2, int i3) {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || size() - j2 < i3 || iVar.P() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (m(i4 + j2) != iVar.x(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public final a I(a aVar) {
        kotlin.jvm.internal.m.f(aVar, "unsafeCursor");
        return j.g0.a.a(this, aVar);
    }

    public int K() throws EOFException {
        return j.c.c(readInt());
    }

    @Override // j.g
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public f C0(long j2) {
        if (j2 == 0) {
            return writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        y q0 = q0(i2);
        byte[] bArr = q0.f22878b;
        int i3 = q0.f22880d;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = j.g0.a.b()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        q0.f22880d += i2;
        f0(size() + i2);
        return this;
    }

    @Override // j.h
    public String L0() throws EOFException {
        return g0(Long.MAX_VALUE);
    }

    @Override // j.h
    public byte[] M() {
        return O0(size());
    }

    public short N() throws EOFException {
        return j.c.d(readShort());
    }

    @Override // j.g
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public f writeInt(int i2) {
        y q0 = q0(4);
        byte[] bArr = q0.f22878b;
        int i3 = q0.f22880d;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        q0.f22880d = i6 + 1;
        f0(size() + 4);
        return this;
    }

    @Override // j.h
    public byte[] O0(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (size() >= j2) {
            byte[] bArr = new byte[(int) j2];
            readFully(bArr);
            return bArr;
        }
        throw new EOFException();
    }

    @Override // j.h
    public long P(i iVar) throws IOException {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        return A(iVar, 0L);
    }

    public String Q(long j2, Charset charset) throws EOFException {
        kotlin.jvm.internal.m.f(charset, "charset");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (this.f22832g < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        y yVar = this.f22831f;
        kotlin.jvm.internal.m.c(yVar);
        int i2 = yVar.f22879c;
        if (i2 + j2 > yVar.f22880d) {
            return new String(O0(j2), charset);
        }
        int i3 = (int) j2;
        String str = new String(yVar.f22878b, i2, i3, charset);
        int i4 = yVar.f22879c + i3;
        yVar.f22879c = i4;
        this.f22832g -= j2;
        if (i4 == yVar.f22880d) {
            this.f22831f = yVar.b();
            z.b(yVar);
        }
        return str;
    }

    public f Q0(long j2) {
        y q0 = q0(8);
        byte[] bArr = q0.f22878b;
        int i2 = q0.f22880d;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        q0.f22880d = i9 + 1;
        f0(size() + 8);
        return this;
    }

    @Override // j.h
    public boolean R() {
        return this.f22832g == 0;
    }

    @Override // j.g
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public f writeShort(int i2) {
        y q0 = q0(2);
        byte[] bArr = q0.f22878b;
        int i3 = q0.f22880d;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        q0.f22880d = i4 + 1;
        f0(size() + 2);
        return this;
    }

    public String T() {
        return Q(this.f22832g, Charsets.f25054b);
    }

    public f T0(String str, int i2, int i3, Charset charset) {
        kotlin.jvm.internal.m.f(str, "string");
        kotlin.jvm.internal.m.f(charset, "charset");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (i3 <= str.length()) {
                if (kotlin.jvm.internal.m.a(charset, Charsets.f25054b)) {
                    return A0(str, i2, i3);
                }
                String substring = str.substring(i2, i3);
                kotlin.jvm.internal.m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    byte[] bytes = substring.getBytes(charset);
                    kotlin.jvm.internal.m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    public f V0(String str, Charset charset) {
        kotlin.jvm.internal.m.f(str, "string");
        kotlin.jvm.internal.m.f(charset, "charset");
        return T0(str, 0, str.length(), charset);
    }

    @Override // j.h
    public void X(f fVar, long j2) throws EOFException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (size() >= j2) {
            fVar.write(this, j2);
        } else {
            fVar.write(this, size());
            throw new EOFException();
        }
    }

    @Override // j.h
    public long Y0(b0 b0Var) throws IOException {
        kotlin.jvm.internal.m.f(b0Var, "sink");
        long size = size();
        if (size > 0) {
            b0Var.write(this, size);
        }
        return size;
    }

    public String Z(long j2) throws EOFException {
        return Q(j2, Charsets.f25054b);
    }

    @Override // j.g
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public f r0(String str) {
        kotlin.jvm.internal.m.f(str, "string");
        return A0(str, 0, str.length());
    }

    public int a0() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (size() != 0) {
            byte m = m(0L);
            if ((m & 128) == 0) {
                i2 = m & Byte.MAX_VALUE;
                i3 = 1;
                i4 = 0;
            } else if ((m & 224) == 192) {
                i2 = m & 31;
                i3 = 2;
                i4 = 128;
            } else if ((m & 240) == 224) {
                i2 = m & 15;
                i3 = 3;
                i4 = RecyclerView.l.FLAG_MOVED;
            } else {
                if ((m & 248) != 240) {
                    skip(1L);
                    return 65533;
                }
                i2 = m & 7;
                i3 = 4;
                i4 = 65536;
            }
            long j2 = i3;
            if (size() >= j2) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j3 = i5;
                    byte m2 = m(j3);
                    if ((m2 & 192) != 128) {
                        skip(j3);
                        return 65533;
                    }
                    i2 = (i2 << 6) | (m2 & 63);
                }
                skip(j2);
                if (i2 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i2 && 57343 >= i2) || i2 < i4) {
                    return 65533;
                }
                return i2;
            }
            throw new EOFException("size < " + i3 + ": " + size() + " (to read code point prefixed 0x" + j.c.e(m) + ')');
        }
        throw new EOFException();
    }

    public final void b() {
        skip(size());
    }

    @Override // j.h
    public long b0(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "targetBytes");
        return B(iVar, 0L);
    }

    @Override // j.g
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public f A0(String str, int i2, int i3) {
        kotlin.jvm.internal.m.f(str, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    y q0 = q0(1);
                    byte[] bArr = q0.f22878b;
                    int i4 = q0.f22880d - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = q0.f22880d;
                    int i7 = (i4 + i5) - i6;
                    q0.f22880d = i6 + i7;
                    f0(size() + i7);
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        y q02 = q0(2);
                        byte[] bArr2 = q02.f22878b;
                        int i8 = q02.f22880d;
                        bArr2[i8] = (byte) ((charAt >> 6) | 192);
                        bArr2[i8 + 1] = (byte) ((charAt & '?') | 128);
                        q02.f22880d = i8 + 2;
                        f0(size() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            y q03 = q0(4);
                            byte[] bArr3 = q03.f22878b;
                            int i11 = q03.f22880d;
                            bArr3[i11] = (byte) ((i10 >> 18) | 240);
                            bArr3[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr3[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr3[i11 + 3] = (byte) ((i10 & 63) | 128);
                            q03.f22880d = i11 + 4;
                            f0(size() + 4);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i9;
                        }
                    } else {
                        y q04 = q0(3);
                        byte[] bArr4 = q04.f22878b;
                        int i12 = q04.f22880d;
                        bArr4[i12] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i12 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i12 + 2] = (byte) ((charAt & '?') | 128);
                        q04.f22880d = i12 + 3;
                        f0(size() + 3);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f clone() {
        return f();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c4 A[EDGE_INSN: B:48:0x00c4->B:42:0x00c4 BREAK  A[LOOP:0: B:4:0x0011->B:47:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long d0() throws EOFException {
        y yVar;
        boolean z;
        long j2 = 0;
        if (size() != 0) {
            long j3 = -7;
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            do {
                y yVar2 = this.f22831f;
                kotlin.jvm.internal.m.c(yVar2);
                byte[] bArr = yVar2.f22878b;
                int i3 = yVar2.f22879c;
                int i4 = yVar2.f22880d;
                while (i3 < i4) {
                    byte b2 = bArr[i3];
                    byte b3 = (byte) 48;
                    if (b2 >= b3 && b2 <= ((byte) 57)) {
                        int i5 = b3 - b2;
                        if (j2 >= -922337203685477580L) {
                            z = z3;
                            yVar = yVar2;
                            if (j2 != -922337203685477580L || i5 >= j3) {
                                j2 = (j2 * 10) + i5;
                            }
                        }
                        f writeByte = new f().i1(j2).writeByte(b2);
                        if (!z2) {
                            writeByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + writeByte.T());
                    }
                    z = z3;
                    yVar = yVar2;
                    if (b2 == ((byte) 45) && i2 == 0) {
                        j3--;
                        z2 = true;
                    } else {
                        if (i2 == 0) {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + j.c.e(b2));
                        }
                        z3 = true;
                        if (i3 != i4) {
                            this.f22831f = yVar.b();
                            z.b(yVar);
                        } else {
                            yVar.f22879c = i3;
                        }
                        if (!z3) {
                            break;
                        }
                    }
                    i3++;
                    i2++;
                    z3 = z;
                    yVar2 = yVar;
                }
                yVar = yVar2;
                if (i3 != i4) {
                }
                if (!z3) {
                }
            } while (this.f22831f != null);
            f0(size() - i2);
            return z2 ? j2 : -j2;
        }
        throw new EOFException();
    }

    public final long e() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        y yVar = this.f22831f;
        kotlin.jvm.internal.m.c(yVar);
        y yVar2 = yVar.f22884h;
        kotlin.jvm.internal.m.c(yVar2);
        if (yVar2.f22880d < 8192 && yVar2.f22882f) {
            size -= r3 - yVar2.f22879c;
        }
        return size;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (size() != fVar.size()) {
                return false;
            }
            if (size() != 0) {
                y yVar = this.f22831f;
                kotlin.jvm.internal.m.c(yVar);
                y yVar2 = fVar.f22831f;
                kotlin.jvm.internal.m.c(yVar2);
                int i2 = yVar.f22879c;
                int i3 = yVar2.f22879c;
                long j2 = 0;
                while (j2 < size()) {
                    long min = Math.min(yVar.f22880d - i2, yVar2.f22880d - i3);
                    long j3 = 0;
                    while (j3 < min) {
                        int i4 = i2 + 1;
                        int i5 = i3 + 1;
                        if (yVar.f22878b[i2] != yVar2.f22878b[i3]) {
                            return false;
                        }
                        j3++;
                        i2 = i4;
                        i3 = i5;
                    }
                    if (i2 == yVar.f22880d) {
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                        i2 = yVar.f22879c;
                    }
                    if (i3 == yVar2.f22880d) {
                        yVar2 = yVar2.f22883g;
                        kotlin.jvm.internal.m.c(yVar2);
                        i3 = yVar2.f22879c;
                    }
                    j2 += min;
                }
            }
        }
        return true;
    }

    public final f f() {
        f fVar = new f();
        if (size() != 0) {
            y yVar = this.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            y d2 = yVar.d();
            fVar.f22831f = d2;
            d2.f22884h = d2;
            d2.f22883g = d2;
            for (y yVar2 = yVar.f22883g; yVar2 != yVar; yVar2 = yVar2.f22883g) {
                y yVar3 = d2.f22884h;
                kotlin.jvm.internal.m.c(yVar3);
                kotlin.jvm.internal.m.c(yVar2);
                yVar3.c(yVar2.d());
            }
            fVar.f0(size());
        }
        return fVar;
    }

    public final void f0(long j2) {
        this.f22832g = j2;
    }

    public f f1(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            y q0 = q0(2);
            byte[] bArr = q0.f22878b;
            int i3 = q0.f22880d;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            q0.f22880d = i3 + 2;
            f0(size() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            writeByte(63);
        } else if (i2 < 65536) {
            y q02 = q0(3);
            byte[] bArr2 = q02.f22878b;
            int i4 = q02.f22880d;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            q02.f22880d = i4 + 3;
            f0(size() + 3);
        } else if (i2 <= 1114111) {
            y q03 = q0(4);
            byte[] bArr3 = q03.f22878b;
            int i5 = q03.f22880d;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            q03.f22880d = i5 + 4;
            f0(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + j.c.f(i2));
        }
        return this;
    }

    @Override // j.g, j.b0, java.io.Flushable
    public void flush() {
    }

    @Override // j.h
    public String g0(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
            byte b2 = (byte) 10;
            long p = p(b2, 0L, j3);
            if (p != -1) {
                return j.g0.a.d(this, p);
            }
            if (j3 < size() && m(j3 - 1) == ((byte) 13) && m(j3) == b2) {
                return j.g0.a.d(this, j3);
            }
            f fVar = new f();
            j(fVar, 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j2) + " content=" + fVar.D0().F() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @Override // j.h
    public void g1(long j2) throws EOFException {
        if (this.f22832g < j2) {
            throw new EOFException();
        }
    }

    public int hashCode() {
        y yVar = this.f22831f;
        if (yVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = yVar.f22880d;
            for (int i4 = yVar.f22879c; i4 < i3; i4++) {
                i2 = (i2 * 31) + yVar.f22878b[i4];
            }
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
        } while (yVar != this.f22831f);
        return i2;
    }

    @Override // j.h, j.g
    public f i() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final f j(f fVar, long j2, long j3) {
        kotlin.jvm.internal.m.f(fVar, "out");
        j.c.b(size(), j2, j3);
        if (j3 != 0) {
            fVar.f0(fVar.size() + j3);
            y yVar = this.f22831f;
            while (true) {
                kotlin.jvm.internal.m.c(yVar);
                int i2 = yVar.f22880d;
                int i3 = yVar.f22879c;
                if (j2 < i2 - i3) {
                    break;
                }
                j2 -= i2 - i3;
                yVar = yVar.f22883g;
            }
            while (j3 > 0) {
                kotlin.jvm.internal.m.c(yVar);
                y d2 = yVar.d();
                int i4 = d2.f22879c + ((int) j2);
                d2.f22879c = i4;
                d2.f22880d = Math.min(i4 + ((int) j3), d2.f22880d);
                y yVar2 = fVar.f22831f;
                if (yVar2 == null) {
                    d2.f22884h = d2;
                    d2.f22883g = d2;
                    fVar.f22831f = d2;
                } else {
                    kotlin.jvm.internal.m.c(yVar2);
                    y yVar3 = yVar2.f22884h;
                    kotlin.jvm.internal.m.c(yVar3);
                    yVar3.c(d2);
                }
                j3 -= d2.f22880d - d2.f22879c;
                yVar = yVar.f22883g;
                j2 = 0;
            }
        }
        return this;
    }

    @Override // j.g
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f C() {
        return this;
    }

    @Override // j.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public f c0() {
        return this;
    }

    public final byte m(long j2) {
        j.c.b(size(), j2, 1L);
        y yVar = this.f22831f;
        if (yVar == null) {
            kotlin.jvm.internal.m.c(null);
            throw null;
        }
        if (size() - j2 < j2) {
            long size = size();
            while (size > j2) {
                yVar = yVar.f22884h;
                kotlin.jvm.internal.m.c(yVar);
                size -= yVar.f22880d - yVar.f22879c;
            }
            kotlin.jvm.internal.m.c(yVar);
            return yVar.f22878b[(int) ((yVar.f22879c + j2) - size)];
        }
        long j3 = 0;
        while (true) {
            long j4 = (yVar.f22880d - yVar.f22879c) + j3;
            if (j4 > j2) {
                kotlin.jvm.internal.m.c(yVar);
                return yVar.f22878b[(int) ((yVar.f22879c + j2) - j3)];
            }
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
            j3 = j4;
        }
    }

    public final i m0() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return n0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae A[EDGE_INSN: B:39:0x00ae->B:36:0x00ae BREAK  A[LOOP:0: B:4:0x000d->B:38:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m1() throws EOFException {
        int i2;
        if (size() != 0) {
            int i3 = 0;
            long j2 = 0;
            boolean z = false;
            do {
                y yVar = this.f22831f;
                kotlin.jvm.internal.m.c(yVar);
                byte[] bArr = yVar.f22878b;
                int i4 = yVar.f22879c;
                int i5 = yVar.f22880d;
                while (i4 < i5) {
                    byte b2 = bArr[i4];
                    byte b3 = (byte) 48;
                    if (b2 < b3 || b2 > ((byte) 57)) {
                        byte b4 = (byte) 97;
                        if ((b2 >= b4 && b2 <= ((byte) 102)) || (b2 >= (b4 = (byte) 65) && b2 <= ((byte) 70))) {
                            i2 = (b2 - b4) + 10;
                        } else {
                            if (i3 == 0) {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + j.c.e(b2));
                            }
                            z = true;
                            if (i4 != i5) {
                                this.f22831f = yVar.b();
                                z.b(yVar);
                            } else {
                                yVar.f22879c = i4;
                            }
                            if (!z) {
                                break;
                            }
                        }
                    } else {
                        i2 = b2 - b3;
                    }
                    if (((-1152921504606846976L) & j2) != 0) {
                        throw new NumberFormatException("Number too large: " + new f().C0(j2).writeByte(b2).T());
                    }
                    j2 = (j2 << 4) | i2;
                    i4++;
                    i3++;
                }
                if (i4 != i5) {
                }
                if (!z) {
                }
            } while (this.f22831f != null);
            f0(size() - i3);
            return j2;
        }
        throw new EOFException();
    }

    public final i n0(int i2) {
        if (i2 == 0) {
            return i.f22841f;
        }
        j.c.b(size(), 0L, i2);
        y yVar = this.f22831f;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            kotlin.jvm.internal.m.c(yVar);
            int i6 = yVar.f22880d;
            int i7 = yVar.f22879c;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                yVar = yVar.f22883g;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5];
        int[] iArr = new int[i5 * 2];
        y yVar2 = this.f22831f;
        int i8 = 0;
        while (i3 < i2) {
            kotlin.jvm.internal.m.c(yVar2);
            bArr[i8] = yVar2.f22878b;
            i3 += yVar2.f22880d - yVar2.f22879c;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = yVar2.f22879c;
            yVar2.f22881e = true;
            i8++;
            yVar2 = yVar2.f22883g;
        }
        return new a0(bArr, iArr);
    }

    @Override // j.h
    public InputStream o1() {
        return new b();
    }

    public long p(byte b2, long j2, long j3) {
        y yVar;
        int i2;
        long j4 = 0;
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        if (j3 > size()) {
            j3 = size();
        }
        if (j2 == j3 || (yVar = this.f22831f) == null) {
            return -1L;
        }
        if (size() - j2 < j2) {
            j4 = size();
            while (j4 > j2) {
                yVar = yVar.f22884h;
                kotlin.jvm.internal.m.c(yVar);
                j4 -= yVar.f22880d - yVar.f22879c;
            }
            while (j4 < j3) {
                byte[] bArr = yVar.f22878b;
                int min = (int) Math.min(yVar.f22880d, (yVar.f22879c + j3) - j4);
                i2 = (int) ((yVar.f22879c + j2) - j4);
                while (i2 < min) {
                    if (bArr[i2] != b2) {
                        i2++;
                    }
                }
                j4 += yVar.f22880d - yVar.f22879c;
                yVar = yVar.f22883g;
                kotlin.jvm.internal.m.c(yVar);
                j2 = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (yVar.f22880d - yVar.f22879c) + j4;
            if (j5 > j2) {
                break;
            }
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
            j4 = j5;
        }
        while (j4 < j3) {
            byte[] bArr2 = yVar.f22878b;
            int min2 = (int) Math.min(yVar.f22880d, (yVar.f22879c + j3) - j4);
            i2 = (int) ((yVar.f22879c + j2) - j4);
            while (i2 < min2) {
                if (bArr2[i2] != b2) {
                    i2++;
                }
            }
            j4 += yVar.f22880d - yVar.f22879c;
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
            j2 = j4;
        }
        return -1L;
        return (i2 - yVar.f22879c) + j4;
    }

    @Override // j.h
    public int p1(t tVar) {
        kotlin.jvm.internal.m.f(tVar, "options");
        int f2 = j.g0.a.f(this, tVar, false, 2, null);
        if (f2 == -1) {
            return -1;
        }
        skip(tVar.i()[f2].P());
        return f2;
    }

    @Override // j.h
    public h peek() {
        return q.d(new v(this));
    }

    public final y q0(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            y yVar = this.f22831f;
            if (yVar == null) {
                y c2 = z.c();
                this.f22831f = c2;
                c2.f22884h = c2;
                c2.f22883g = c2;
                return c2;
            }
            kotlin.jvm.internal.m.c(yVar);
            y yVar2 = yVar.f22884h;
            kotlin.jvm.internal.m.c(yVar2);
            return (yVar2.f22880d + i2 > 8192 || !yVar2.f22882f) ? yVar2.c(z.c()) : yVar2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        kotlin.jvm.internal.m.f(byteBuffer, "sink");
        y yVar = this.f22831f;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), yVar.f22880d - yVar.f22879c);
        byteBuffer.put(yVar.f22878b, yVar.f22879c, min);
        int i2 = yVar.f22879c + min;
        yVar.f22879c = i2;
        this.f22832g -= min;
        if (i2 == yVar.f22880d) {
            this.f22831f = yVar.b();
            z.b(yVar);
        }
        return min;
    }

    @Override // j.h
    public byte readByte() throws EOFException {
        if (size() != 0) {
            y yVar = this.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int i2 = yVar.f22879c;
            int i3 = yVar.f22880d;
            int i4 = i2 + 1;
            byte b2 = yVar.f22878b[i2];
            f0(size() - 1);
            if (i4 == i3) {
                this.f22831f = yVar.b();
                z.b(yVar);
            } else {
                yVar.f22879c = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    @Override // j.h
    public void readFully(byte[] bArr) throws EOFException {
        kotlin.jvm.internal.m.f(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    @Override // j.h
    public int readInt() throws EOFException {
        if (size() >= 4) {
            y yVar = this.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int i2 = yVar.f22879c;
            int i3 = yVar.f22880d;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = yVar.f22878b;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            f0(size() - 4);
            if (i9 == i3) {
                this.f22831f = yVar.b();
                z.b(yVar);
            } else {
                yVar.f22879c = i9;
            }
            return i10;
        }
        throw new EOFException();
    }

    @Override // j.h
    public long readLong() throws EOFException {
        if (size() >= 8) {
            y yVar = this.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int i2 = yVar.f22879c;
            int i3 = yVar.f22880d;
            if (i3 - i2 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = yVar.f22878b;
            long j2 = (bArr[i2] & 255) << 56;
            long j3 = j2 | ((bArr[r6] & 255) << 48);
            long j4 = j3 | ((bArr[r1] & 255) << 40);
            int i4 = i2 + 1 + 1 + 1 + 1;
            long j5 = ((bArr[r6] & 255) << 32) | j4;
            long j6 = j5 | ((bArr[i4] & 255) << 24);
            long j7 = j6 | ((bArr[r8] & 255) << 16);
            long j8 = j7 | ((bArr[r1] & 255) << 8);
            int i5 = i4 + 1 + 1 + 1 + 1;
            long j9 = j8 | (bArr[r8] & 255);
            f0(size() - 8);
            if (i5 == i3) {
                this.f22831f = yVar.b();
                z.b(yVar);
            } else {
                yVar.f22879c = i5;
            }
            return j9;
        }
        throw new EOFException();
    }

    @Override // j.h
    public short readShort() throws EOFException {
        if (size() >= 2) {
            y yVar = this.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int i2 = yVar.f22879c;
            int i3 = yVar.f22880d;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = yVar.f22878b;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            f0(size() - 2);
            if (i5 == i3) {
                this.f22831f = yVar.b();
                z.b(yVar);
            } else {
                yVar.f22879c = i5;
            }
            return (short) i6;
        }
        throw new EOFException();
    }

    @Override // j.h
    public boolean request(long j2) {
        return this.f22832g >= j2;
    }

    public final long size() {
        return this.f22832g;
    }

    @Override // j.h
    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            y yVar = this.f22831f;
            if (yVar != null) {
                int min = (int) Math.min(j2, yVar.f22880d - yVar.f22879c);
                long j3 = min;
                f0(size() - j3);
                j2 -= j3;
                int i2 = yVar.f22879c + min;
                yVar.f22879c = i2;
                if (i2 == yVar.f22880d) {
                    this.f22831f = yVar.b();
                    z.b(yVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // j.h
    public f t() {
        return this;
    }

    @Override // j.g
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public f U0(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "byteString");
        iVar.T(this, 0, iVar.P());
        return this;
    }

    @Override // j.d0
    public e0 timeout() {
        return e0.NONE;
    }

    public String toString() {
        return m0().toString();
    }

    @Override // j.h
    public i u(long j2) throws EOFException {
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (size() < j2) {
            throw new EOFException();
        }
        if (j2 >= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) {
            i n0 = n0((int) j2);
            skip(j2);
            return n0;
        }
        return new i(O0(j2));
    }

    @Override // j.h
    public boolean v0(long j2, i iVar) {
        kotlin.jvm.internal.m.f(iVar, "bytes");
        return H(j2, iVar, 0, iVar.P());
    }

    @Override // j.h
    public String w0(Charset charset) {
        kotlin.jvm.internal.m.f(charset, "charset");
        return Q(this.f22832g, charset);
    }

    public f x0(d0 d0Var, long j2) throws IOException {
        kotlin.jvm.internal.m.f(d0Var, "source");
        while (j2 > 0) {
            long read = d0Var.read(this, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return this;
    }

    @Override // j.g
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public f write(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(f.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (f.this.size() > 0) {
                return f.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return f.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            kotlin.jvm.internal.m.f(bArr, "sink");
            return f.this.read(bArr, i2, i3);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        kotlin.jvm.internal.m.f(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i2 = remaining;
        while (i2 > 0) {
            y q0 = q0(1);
            int min = Math.min(i2, 8192 - q0.f22880d);
            byteBuffer.get(q0.f22878b, q0.f22880d, min);
            i2 -= min;
            q0.f22880d += min;
        }
        this.f22832g += remaining;
        return remaining;
    }

    public int read(byte[] bArr, int i2, int i3) {
        kotlin.jvm.internal.m.f(bArr, "sink");
        j.c.b(bArr.length, i2, i3);
        y yVar = this.f22831f;
        if (yVar == null) {
            return -1;
        }
        int min = Math.min(i3, yVar.f22880d - yVar.f22879c);
        byte[] bArr2 = yVar.f22878b;
        int i4 = yVar.f22879c;
        kotlin.collections.j.d(bArr2, bArr, i2, i4, i4 + min);
        yVar.f22879c += min;
        f0(size() - min);
        if (yVar.f22879c != yVar.f22880d) {
            return min;
        }
        this.f22831f = yVar.b();
        z.b(yVar);
        return min;
    }

    @Override // j.b0
    public void write(f fVar, long j2) {
        y yVar;
        kotlin.jvm.internal.m.f(fVar, "source");
        if (fVar != this) {
            j.c.b(fVar.size(), 0L, j2);
            while (j2 > 0) {
                y yVar2 = fVar.f22831f;
                kotlin.jvm.internal.m.c(yVar2);
                int i2 = yVar2.f22880d;
                kotlin.jvm.internal.m.c(fVar.f22831f);
                if (j2 < i2 - r2.f22879c) {
                    y yVar3 = this.f22831f;
                    if (yVar3 != null) {
                        kotlin.jvm.internal.m.c(yVar3);
                        yVar = yVar3.f22884h;
                    } else {
                        yVar = null;
                    }
                    if (yVar != null && yVar.f22882f) {
                        if ((yVar.f22880d + j2) - (yVar.f22881e ? 0 : yVar.f22879c) <= 8192) {
                            y yVar4 = fVar.f22831f;
                            kotlin.jvm.internal.m.c(yVar4);
                            yVar4.g(yVar, (int) j2);
                            fVar.f0(fVar.size() - j2);
                            f0(size() + j2);
                            return;
                        }
                    }
                    y yVar5 = fVar.f22831f;
                    kotlin.jvm.internal.m.c(yVar5);
                    fVar.f22831f = yVar5.e((int) j2);
                }
                y yVar6 = fVar.f22831f;
                kotlin.jvm.internal.m.c(yVar6);
                long j3 = yVar6.f22880d - yVar6.f22879c;
                fVar.f22831f = yVar6.b();
                y yVar7 = this.f22831f;
                if (yVar7 == null) {
                    this.f22831f = yVar6;
                    yVar6.f22884h = yVar6;
                    yVar6.f22883g = yVar6;
                } else {
                    kotlin.jvm.internal.m.c(yVar7);
                    y yVar8 = yVar7.f22884h;
                    kotlin.jvm.internal.m.c(yVar8);
                    yVar8.c(yVar6).a();
                }
                fVar.f0(fVar.size() - j3);
                f0(size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // j.d0
    public long read(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j2 > size()) {
            j2 = size();
        }
        fVar.write(this, j2);
        return j2;
    }
}
