package j;

import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class u implements b0 {

    /* renamed from: f, reason: collision with root package name */
    private final OutputStream f22863f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f22864g;

    public u(OutputStream outputStream, e0 e0Var) {
        kotlin.jvm.internal.m.f(outputStream, "out");
        kotlin.jvm.internal.m.f(e0Var, "timeout");
        this.f22863f = outputStream;
        this.f22864g = e0Var;
    }

    @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22863f.close();
    }

    @Override // j.b0, java.io.Flushable
    public void flush() {
        this.f22863f.flush();
    }

    @Override // j.b0
    public e0 timeout() {
        return this.f22864g;
    }

    public String toString() {
        return "sink(" + this.f22863f + ')';
    }

    @Override // j.b0
    public void write(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "source");
        c.b(fVar.size(), 0L, j2);
        while (j2 > 0) {
            this.f22864g.throwIfReached();
            y yVar = fVar.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int min = (int) Math.min(j2, yVar.f22880d - yVar.f22879c);
            this.f22863f.write(yVar.f22878b, yVar.f22879c, min);
            yVar.f22879c += min;
            long j3 = min;
            j2 -= j3;
            fVar.f0(fVar.size() - j3);
            if (yVar.f22879c == yVar.f22880d) {
                fVar.f22831f = yVar.b();
                z.b(yVar);
            }
        }
    }
}
