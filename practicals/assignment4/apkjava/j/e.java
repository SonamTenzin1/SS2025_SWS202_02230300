package j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.kt */
/* loaded from: classes3.dex */
public final class e implements b0 {
    @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // j.b0, java.io.Flushable
    public void flush() {
    }

    @Override // j.b0
    public e0 timeout() {
        return e0.NONE;
    }

    @Override // j.b0
    public void write(f fVar, long j2) {
        kotlin.jvm.internal.m.f(fVar, "source");
        fVar.skip(j2);
    }
}
