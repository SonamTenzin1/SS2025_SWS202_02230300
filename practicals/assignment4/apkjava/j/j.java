package j;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: DeflaterSink.kt */
/* loaded from: classes3.dex */
public final class j implements b0 {

    /* renamed from: f, reason: collision with root package name */
    private boolean f22846f;

    /* renamed from: g, reason: collision with root package name */
    private final g f22847g;

    /* renamed from: h, reason: collision with root package name */
    private final Deflater f22848h;

    public j(g gVar, Deflater deflater) {
        kotlin.jvm.internal.m.f(gVar, "sink");
        kotlin.jvm.internal.m.f(deflater, "deflater");
        this.f22847g = gVar;
        this.f22848h = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z) {
        y q0;
        int deflate;
        f i2 = this.f22847g.i();
        while (true) {
            q0 = i2.q0(1);
            if (z) {
                Deflater deflater = this.f22848h;
                byte[] bArr = q0.f22878b;
                int i3 = q0.f22880d;
                deflate = deflater.deflate(bArr, i3, 8192 - i3, 2);
            } else {
                Deflater deflater2 = this.f22848h;
                byte[] bArr2 = q0.f22878b;
                int i4 = q0.f22880d;
                deflate = deflater2.deflate(bArr2, i4, 8192 - i4);
            }
            if (deflate > 0) {
                q0.f22880d += deflate;
                i2.f0(i2.size() + deflate);
                this.f22847g.c0();
            } else if (this.f22848h.needsInput()) {
                break;
            }
        }
        if (q0.f22879c == q0.f22880d) {
            i2.f22831f = q0.b();
            z.b(q0);
        }
    }

    public final void b() {
        this.f22848h.finish();
        a(false);
    }

    @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f22846f) {
            return;
        }
        Throwable th = null;
        try {
            b();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f22848h.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f22847g.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f22846f = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.b0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f22847g.flush();
    }

    @Override // j.b0
    public e0 timeout() {
        return this.f22847g.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f22847g + ')';
    }

    @Override // j.b0
    public void write(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "source");
        c.b(fVar.size(), 0L, j2);
        while (j2 > 0) {
            y yVar = fVar.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int min = (int) Math.min(j2, yVar.f22880d - yVar.f22879c);
            this.f22848h.setInput(yVar.f22878b, yVar.f22879c, min);
            a(false);
            long j3 = min;
            fVar.f0(fVar.size() - j3);
            int i2 = yVar.f22879c + min;
            yVar.f22879c = i2;
            if (i2 == yVar.f22880d) {
                fVar.f22831f = yVar.b();
                z.b(yVar);
            }
            j2 -= j3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(b0 b0Var, Deflater deflater) {
        this(q.c(b0Var), deflater);
        kotlin.jvm.internal.m.f(b0Var, "sink");
        kotlin.jvm.internal.m.f(deflater, "deflater");
    }
}
