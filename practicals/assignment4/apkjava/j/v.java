package j;

/* compiled from: PeekSource.kt */
/* loaded from: classes3.dex */
public final class v implements d0 {

    /* renamed from: f, reason: collision with root package name */
    private final f f22865f;

    /* renamed from: g, reason: collision with root package name */
    private y f22866g;

    /* renamed from: h, reason: collision with root package name */
    private int f22867h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f22868i;

    /* renamed from: j, reason: collision with root package name */
    private long f22869j;

    /* renamed from: k, reason: collision with root package name */
    private final h f22870k;

    public v(h hVar) {
        kotlin.jvm.internal.m.f(hVar, "upstream");
        this.f22870k = hVar;
        f i2 = hVar.i();
        this.f22865f = i2;
        y yVar = i2.f22831f;
        this.f22866g = yVar;
        this.f22867h = yVar != null ? yVar.f22879c : -1;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22868i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r4 == r5.f22879c) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    @Override // j.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(f fVar, long j2) {
        y yVar;
        kotlin.jvm.internal.m.f(fVar, "sink");
        boolean z = false;
        if (j2 >= 0) {
            if (!this.f22868i) {
                y yVar2 = this.f22866g;
                if (yVar2 != null) {
                    y yVar3 = this.f22865f.f22831f;
                    if (yVar2 == yVar3) {
                        int i2 = this.f22867h;
                        kotlin.jvm.internal.m.c(yVar3);
                    }
                    if (z) {
                        throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
                    }
                    if (j2 == 0) {
                        return 0L;
                    }
                    if (!this.f22870k.request(this.f22869j + 1)) {
                        return -1L;
                    }
                    if (this.f22866g == null && (yVar = this.f22865f.f22831f) != null) {
                        this.f22866g = yVar;
                        kotlin.jvm.internal.m.c(yVar);
                        this.f22867h = yVar.f22879c;
                    }
                    long min = Math.min(j2, this.f22865f.size() - this.f22869j);
                    this.f22865f.j(fVar, this.f22869j, min);
                    this.f22869j += min;
                    return min;
                }
                z = true;
                if (z) {
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22870k.timeout();
    }
}
