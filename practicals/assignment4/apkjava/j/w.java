package j;

import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes3.dex */
public final class w implements g {

    /* renamed from: f, reason: collision with root package name */
    public final f f22871f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22872g;

    /* renamed from: h, reason: collision with root package name */
    public final b0 f22873h;

    public w(b0 b0Var) {
        kotlin.jvm.internal.m.f(b0Var, "sink");
        this.f22873h = b0Var;
        this.f22871f = new f();
    }

    @Override // j.g
    public g A0(String str, int i2, int i3) {
        kotlin.jvm.internal.m.f(str, "string");
        if (!this.f22872g) {
            this.f22871f.A0(str, i2, i3);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public long B0(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "source");
        long j2 = 0;
        while (true) {
            long read = d0Var.read(this.f22871f, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            c0();
        }
    }

    @Override // j.g
    public g C() {
        if (!this.f22872g) {
            long size = this.f22871f.size();
            if (size > 0) {
                this.f22873h.write(this.f22871f, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g C0(long j2) {
        if (!this.f22872g) {
            this.f22871f.C0(j2);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g U0(i iVar) {
        kotlin.jvm.internal.m.f(iVar, "byteString");
        if (!this.f22872g) {
            this.f22871f.U0(iVar);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g c0() {
        if (!this.f22872g) {
            long e2 = this.f22871f.e();
            if (e2 > 0) {
                this.f22873h.write(this.f22871f, e2);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f22872g) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f22871f.size() > 0) {
                b0 b0Var = this.f22873h;
                f fVar = this.f22871f;
                b0Var.write(fVar, fVar.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f22873h.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f22872g = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.g, j.b0, java.io.Flushable
    public void flush() {
        if (!this.f22872g) {
            if (this.f22871f.size() > 0) {
                b0 b0Var = this.f22873h;
                f fVar = this.f22871f;
                b0Var.write(fVar, fVar.size());
            }
            this.f22873h.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public f i() {
        return this.f22871f;
    }

    @Override // j.g
    public g i1(long j2) {
        if (!this.f22872g) {
            this.f22871f.i1(j2);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f22872g;
    }

    @Override // j.g
    public g r0(String str) {
        kotlin.jvm.internal.m.f(str, "string");
        if (!this.f22872g) {
            this.f22871f.r0(str);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.b0
    public e0 timeout() {
        return this.f22873h.timeout();
    }

    public String toString() {
        return "buffer(" + this.f22873h + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        kotlin.jvm.internal.m.f(byteBuffer, "source");
        if (!this.f22872g) {
            int write = this.f22871f.write(byteBuffer);
            c0();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g writeByte(int i2) {
        if (!this.f22872g) {
            this.f22871f.writeByte(i2);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g writeInt(int i2) {
        if (!this.f22872g) {
            this.f22871f.writeInt(i2);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g writeShort(int i2) {
        if (!this.f22872g) {
            this.f22871f.writeShort(i2);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.b0
    public void write(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "source");
        if (!this.f22872g) {
            this.f22871f.write(fVar, j2);
            c0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g write(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "source");
        if (!this.f22872g) {
            this.f22871f.write(bArr);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g write(byte[] bArr, int i2, int i3) {
        kotlin.jvm.internal.m.f(bArr, "source");
        if (!this.f22872g) {
            this.f22871f.write(bArr, i2, i3);
            return c0();
        }
        throw new IllegalStateException("closed".toString());
    }
}
