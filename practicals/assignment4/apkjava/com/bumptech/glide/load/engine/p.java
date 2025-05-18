package com.bumptech.glide.load.engine;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class p<Z> implements u<Z> {

    /* renamed from: f, reason: collision with root package name */
    private final boolean f9183f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f9184g;

    /* renamed from: h, reason: collision with root package name */
    private final u<Z> f9185h;

    /* renamed from: i, reason: collision with root package name */
    private a f9186i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.load.f f9187j;

    /* renamed from: k, reason: collision with root package name */
    private int f9188k;
    private boolean l;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void d(com.bumptech.glide.load.f fVar, p<?> pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(u<Z> uVar, boolean z, boolean z2) {
        this.f9185h = (u) com.bumptech.glide.r.j.d(uVar);
        this.f9183f = z;
        this.f9184g = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.l) {
            this.f9188k++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u<Z> b() {
        return this.f9185h;
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void c() {
        if (this.f9188k <= 0) {
            if (!this.l) {
                this.l = true;
                if (this.f9184g) {
                    this.f9185h.c();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return this.f9185h.d();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Z> e() {
        return this.f9185h.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f9183f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        synchronized (this.f9186i) {
            synchronized (this) {
                int i2 = this.f9188k;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    this.f9188k = i3;
                    if (i3 == 0) {
                        this.f9186i.d(this.f9187j, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public Z get() {
        return this.f9185h.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void h(com.bumptech.glide.load.f fVar, a aVar) {
        this.f9187j = fVar;
        this.f9186i = aVar;
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f9183f + ", listener=" + this.f9186i + ", key=" + this.f9187j + ", acquired=" + this.f9188k + ", isRecycled=" + this.l + ", resource=" + this.f9185h + '}';
    }
}
