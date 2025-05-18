package com.google.firebase.crashlytics.internal.t;

/* compiled from: Settings.java */
/* loaded from: classes2.dex */
public class d {
    public final b a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19545b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19546c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19547d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19548e;

    /* renamed from: f, reason: collision with root package name */
    public final double f19549f;

    /* renamed from: g, reason: collision with root package name */
    public final double f19550g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19551h;

    /* compiled from: Settings.java */
    /* loaded from: classes2.dex */
    public static class a {
        public final boolean a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19552b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19553c;

        public a(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.f19552b = z2;
            this.f19553c = z3;
        }
    }

    /* compiled from: Settings.java */
    /* loaded from: classes2.dex */
    public static class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19554b;

        public b(int i2, int i3) {
            this.a = i2;
            this.f19554b = i3;
        }
    }

    public d(long j2, b bVar, a aVar, int i2, int i3, double d2, double d3, int i4) {
        this.f19546c = j2;
        this.a = bVar;
        this.f19545b = aVar;
        this.f19547d = i2;
        this.f19548e = i3;
        this.f19549f = d2;
        this.f19550g = d3;
        this.f19551h = i4;
    }

    public boolean a(long j2) {
        return this.f19546c < j2;
    }
}
