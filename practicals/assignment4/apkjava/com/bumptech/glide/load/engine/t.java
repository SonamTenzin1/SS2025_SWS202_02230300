package com.bumptech.glide.load.engine;

import com.bumptech.glide.r.l.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class t<Z> implements u<Z>, a.f {

    /* renamed from: f, reason: collision with root package name */
    private static final c.i.j.f<t<?>> f9193f = com.bumptech.glide.r.l.a.d(20, new a());

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f9194g = com.bumptech.glide.r.l.c.a();

    /* renamed from: h, reason: collision with root package name */
    private u<Z> f9195h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9196i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9197j;

    /* compiled from: LockedResource.java */
    /* loaded from: classes.dex */
    class a implements a.d<t<?>> {
        a() {
        }

        @Override // com.bumptech.glide.r.l.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public t<?> a() {
            return new t<>();
        }
    }

    t() {
    }

    private void a(u<Z> uVar) {
        this.f9197j = false;
        this.f9196i = true;
        this.f9195h = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> t<Z> b(u<Z> uVar) {
        t<Z> tVar = (t) com.bumptech.glide.r.j.d(f9193f.b());
        tVar.a(uVar);
        return tVar;
    }

    private void f() {
        this.f9195h = null;
        f9193f.a(this);
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void c() {
        this.f9194g.c();
        this.f9197j = true;
        if (!this.f9196i) {
            this.f9195h.c();
            f();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return this.f9195h.d();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Z> e() {
        return this.f9195h.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        this.f9194g.c();
        if (this.f9196i) {
            this.f9196i = false;
            if (this.f9197j) {
                c();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    public Z get() {
        return this.f9195h.get();
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c u() {
        return this.f9194g;
    }
}
