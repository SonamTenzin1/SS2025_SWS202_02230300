package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class y implements f, d.a<Object>, f.a {

    /* renamed from: f, reason: collision with root package name */
    private final g<?> f9214f;

    /* renamed from: g, reason: collision with root package name */
    private final f.a f9215g;

    /* renamed from: h, reason: collision with root package name */
    private int f9216h;

    /* renamed from: i, reason: collision with root package name */
    private c f9217i;

    /* renamed from: j, reason: collision with root package name */
    private Object f9218j;

    /* renamed from: k, reason: collision with root package name */
    private volatile n.a<?> f9219k;
    private d l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(g<?> gVar, f.a aVar) {
        this.f9214f = gVar;
        this.f9215g = aVar;
    }

    private void b(Object obj) {
        long b2 = com.bumptech.glide.r.f.b();
        try {
            com.bumptech.glide.load.d<X> p = this.f9214f.p(obj);
            e eVar = new e(p, obj, this.f9214f.k());
            this.l = new d(this.f9219k.a, this.f9214f.o());
            this.f9214f.d().a(this.l, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.l + ", data: " + obj + ", encoder: " + p + ", duration: " + com.bumptech.glide.r.f.a(b2));
            }
            this.f9219k.f9326c.b();
            this.f9217i = new c(Collections.singletonList(this.f9219k.a), this.f9214f, this);
        } catch (Throwable th) {
            this.f9219k.f9326c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.f9216h < this.f9214f.g().size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        Object obj = this.f9218j;
        if (obj != null) {
            this.f9218j = null;
            b(obj);
        }
        c cVar = this.f9217i;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f9217i = null;
        this.f9219k = null;
        boolean z = false;
        while (!z && d()) {
            List<n.a<?>> g2 = this.f9214f.g();
            int i2 = this.f9216h;
            this.f9216h = i2 + 1;
            this.f9219k = g2.get(i2);
            if (this.f9219k != null && (this.f9214f.e().c(this.f9219k.f9326c.d()) || this.f9214f.t(this.f9219k.f9326c.a()))) {
                this.f9219k.f9326c.e(this.f9214f.l(), this);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f9215g.g(this.l, exc, this.f9219k.f9326c, this.f9219k.f9326c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f9219k;
        if (aVar != null) {
            aVar.f9326c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void f(Object obj) {
        j e2 = this.f9214f.e();
        if (obj != null && e2.c(this.f9219k.f9326c.d())) {
            this.f9218j = obj;
            this.f9215g.k();
        } else {
            this.f9215g.q(this.f9219k.a, obj, this.f9219k.f9326c, this.f9219k.f9326c.d(), this.l);
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void g(com.bumptech.glide.load.f fVar, Exception exc, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f9215g.g(fVar, exc, dVar, this.f9219k.f9326c.d());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void k() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void q(com.bumptech.glide.load.f fVar, Object obj, com.bumptech.glide.load.m.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.f9215g.q(fVar, obj, dVar, this.f9219k.f9326c.d(), fVar);
    }
}
