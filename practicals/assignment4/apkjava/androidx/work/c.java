package androidx.work;

import android.os.Build;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public final class c {
    public static final c a = new a().a();

    /* renamed from: b, reason: collision with root package name */
    private o f2311b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2312c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2313d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2314e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2315f;

    /* renamed from: g, reason: collision with root package name */
    private long f2316g;

    /* renamed from: h, reason: collision with root package name */
    private long f2317h;

    /* renamed from: i, reason: collision with root package name */
    private d f2318i;

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static final class a {
        boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f2319b = false;

        /* renamed from: c, reason: collision with root package name */
        o f2320c = o.NOT_REQUIRED;

        /* renamed from: d, reason: collision with root package name */
        boolean f2321d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f2322e = false;

        /* renamed from: f, reason: collision with root package name */
        long f2323f = -1;

        /* renamed from: g, reason: collision with root package name */
        long f2324g = -1;

        /* renamed from: h, reason: collision with root package name */
        d f2325h = new d();

        public c a() {
            return new c(this);
        }

        public a b(o oVar) {
            this.f2320c = oVar;
            return this;
        }
    }

    public c() {
        this.f2311b = o.NOT_REQUIRED;
        this.f2316g = -1L;
        this.f2317h = -1L;
        this.f2318i = new d();
    }

    public d a() {
        return this.f2318i;
    }

    public o b() {
        return this.f2311b;
    }

    public long c() {
        return this.f2316g;
    }

    public long d() {
        return this.f2317h;
    }

    public boolean e() {
        return this.f2318i.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2312c == cVar.f2312c && this.f2313d == cVar.f2313d && this.f2314e == cVar.f2314e && this.f2315f == cVar.f2315f && this.f2316g == cVar.f2316g && this.f2317h == cVar.f2317h && this.f2311b == cVar.f2311b) {
            return this.f2318i.equals(cVar.f2318i);
        }
        return false;
    }

    public boolean f() {
        return this.f2314e;
    }

    public boolean g() {
        return this.f2312c;
    }

    public boolean h() {
        return this.f2313d;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f2311b.hashCode() * 31) + (this.f2312c ? 1 : 0)) * 31) + (this.f2313d ? 1 : 0)) * 31) + (this.f2314e ? 1 : 0)) * 31) + (this.f2315f ? 1 : 0)) * 31;
        long j2 = this.f2316g;
        int i2 = (hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f2317h;
        return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f2318i.hashCode();
    }

    public boolean i() {
        return this.f2315f;
    }

    public void j(d dVar) {
        this.f2318i = dVar;
    }

    public void k(o oVar) {
        this.f2311b = oVar;
    }

    public void l(boolean z) {
        this.f2314e = z;
    }

    public void m(boolean z) {
        this.f2312c = z;
    }

    public void n(boolean z) {
        this.f2313d = z;
    }

    public void o(boolean z) {
        this.f2315f = z;
    }

    public void p(long j2) {
        this.f2316g = j2;
    }

    public void q(long j2) {
        this.f2317h = j2;
    }

    c(a aVar) {
        this.f2311b = o.NOT_REQUIRED;
        this.f2316g = -1L;
        this.f2317h = -1L;
        this.f2318i = new d();
        this.f2312c = aVar.a;
        int i2 = Build.VERSION.SDK_INT;
        this.f2313d = i2 >= 23 && aVar.f2319b;
        this.f2311b = aVar.f2320c;
        this.f2314e = aVar.f2321d;
        this.f2315f = aVar.f2322e;
        if (i2 >= 24) {
            this.f2318i = aVar.f2325h;
            this.f2316g = aVar.f2323f;
            this.f2317h = aVar.f2324g;
        }
    }

    public c(c cVar) {
        this.f2311b = o.NOT_REQUIRED;
        this.f2316g = -1L;
        this.f2317h = -1L;
        this.f2318i = new d();
        this.f2312c = cVar.f2312c;
        this.f2313d = cVar.f2313d;
        this.f2311b = cVar.f2311b;
        this.f2314e = cVar.f2314e;
        this.f2315f = cVar.f2315f;
        this.f2318i = cVar.f2318i;
    }
}
