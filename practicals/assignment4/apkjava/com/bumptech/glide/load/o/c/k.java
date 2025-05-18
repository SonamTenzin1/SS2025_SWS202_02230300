package com.bumptech.glide.load.o.c;

/* compiled from: DownsampleStrategy.java */
/* loaded from: classes.dex */
public abstract class k {
    public static final k a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final k f9360b;

    /* renamed from: c, reason: collision with root package name */
    public static final k f9361c;

    /* renamed from: d, reason: collision with root package name */
    public static final k f9362d;

    /* renamed from: e, reason: collision with root package name */
    public static final k f9363e;

    /* renamed from: f, reason: collision with root package name */
    public static final k f9364f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f9365g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<k> f9366h;

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class a extends k {
        a() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class b extends k {
        b() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(ceil)) >= ceil ? 0 : 1));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class c extends k {
        c() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, k.a.b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class d extends k {
        d() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class e extends k {
        e() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(i4 / i2, i5 / i3);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class f extends k {
        f() {
        }

        @Override // com.bumptech.glide.load.o.c.k
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.o.c.k
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f9360b = dVar;
        f9361c = new a();
        f9362d = new b();
        f9363e = new c();
        f9364f = new f();
        f9365g = dVar;
        f9366h = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
