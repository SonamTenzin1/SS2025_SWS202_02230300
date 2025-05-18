package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.m.l;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private k f8921b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.e f8922c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.b f8923d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a0.h f8924e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b0.a f8925f;

    /* renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b0.a f8926g;

    /* renamed from: h, reason: collision with root package name */
    private a.InterfaceC0125a f8927h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a0.i f8928i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.m.d f8929j;
    private l.b m;
    private com.bumptech.glide.load.engine.b0.a n;
    private boolean o;
    private List<com.bumptech.glide.p.g<Object>> p;
    private boolean q;
    private final Map<Class<?>, j<?, ?>> a = new c.e.a();

    /* renamed from: k, reason: collision with root package name */
    private int f8930k = 4;
    private com.bumptech.glide.p.h l = new com.bumptech.glide.p.h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(Context context) {
        if (this.f8925f == null) {
            this.f8925f = com.bumptech.glide.load.engine.b0.a.f();
        }
        if (this.f8926g == null) {
            this.f8926g = com.bumptech.glide.load.engine.b0.a.d();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.engine.b0.a.b();
        }
        if (this.f8928i == null) {
            this.f8928i = new i.a(context).a();
        }
        if (this.f8929j == null) {
            this.f8929j = new com.bumptech.glide.m.f();
        }
        if (this.f8922c == null) {
            int b2 = this.f8928i.b();
            if (b2 > 0) {
                this.f8922c = new com.bumptech.glide.load.engine.z.k(b2);
            } else {
                this.f8922c = new com.bumptech.glide.load.engine.z.f();
            }
        }
        if (this.f8923d == null) {
            this.f8923d = new com.bumptech.glide.load.engine.z.j(this.f8928i.a());
        }
        if (this.f8924e == null) {
            this.f8924e = new com.bumptech.glide.load.engine.a0.g(this.f8928i.d());
        }
        if (this.f8927h == null) {
            this.f8927h = new com.bumptech.glide.load.engine.a0.f(context);
        }
        if (this.f8921b == null) {
            this.f8921b = new k(this.f8924e, this.f8927h, this.f8926g, this.f8925f, com.bumptech.glide.load.engine.b0.a.h(), com.bumptech.glide.load.engine.b0.a.b(), this.o);
        }
        List<com.bumptech.glide.p.g<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new c(context, this.f8921b, this.f8924e, this.f8922c, this.f8923d, new l(this.m), this.f8929j, this.f8930k, this.l.Q(), this.a, this.p, this.q);
    }

    public d b(com.bumptech.glide.load.engine.z.e eVar) {
        this.f8922c = eVar;
        return this;
    }

    public d c(com.bumptech.glide.p.h hVar) {
        this.l = hVar;
        return this;
    }

    public d d(com.bumptech.glide.load.engine.a0.h hVar) {
        this.f8924e = hVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(l.b bVar) {
        this.m = bVar;
    }
}
