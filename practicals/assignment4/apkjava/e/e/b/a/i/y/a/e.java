package e.e.b.a.i.y.a;

/* compiled from: StorageMetrics.java */
/* loaded from: classes2.dex */
public final class e {
    private static final e a = new a().a();

    /* renamed from: b, reason: collision with root package name */
    private final long f20878b;

    /* renamed from: c, reason: collision with root package name */
    private final long f20879c;

    /* compiled from: StorageMetrics.java */
    /* loaded from: classes2.dex */
    public static final class a {
        private long a = 0;

        /* renamed from: b, reason: collision with root package name */
        private long f20880b = 0;

        a() {
        }

        public e a() {
            return new e(this.a, this.f20880b);
        }

        public a b(long j2) {
            this.a = j2;
            return this;
        }

        public a c(long j2) {
            this.f20880b = j2;
            return this;
        }
    }

    e(long j2, long j3) {
        this.f20878b = j2;
        this.f20879c = j3;
    }

    public static a c() {
        return new a();
    }

    @com.google.firebase.encoders.i.f(tag = 1)
    public long a() {
        return this.f20878b;
    }

    @com.google.firebase.encoders.i.f(tag = 2)
    public long b() {
        return this.f20879c;
    }
}
