package j;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class p implements d0 {

    /* renamed from: f, reason: collision with root package name */
    private final InputStream f22858f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f22859g;

    public p(InputStream inputStream, e0 e0Var) {
        kotlin.jvm.internal.m.f(inputStream, "input");
        kotlin.jvm.internal.m.f(e0Var, "timeout");
        this.f22858f = inputStream;
        this.f22859g = e0Var;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22858f.close();
    }

    @Override // j.d0
    public long read(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (j2 == 0) {
            return 0L;
        }
        if (j2 >= 0) {
            try {
                this.f22859g.throwIfReached();
                y q0 = fVar.q0(1);
                int read = this.f22858f.read(q0.f22878b, q0.f22880d, (int) Math.min(j2, 8192 - q0.f22880d));
                if (read == -1) {
                    if (q0.f22879c != q0.f22880d) {
                        return -1L;
                    }
                    fVar.f22831f = q0.b();
                    z.b(q0);
                    return -1L;
                }
                q0.f22880d += read;
                long j3 = read;
                fVar.f0(fVar.size() + j3);
                return j3;
            } catch (AssertionError e2) {
                if (q.e(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22859g;
    }

    public String toString() {
        return "source(" + this.f22858f + ')';
    }
}
