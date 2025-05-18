package com.google.gson.t.n;

import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes2.dex */
public final class l<T> extends q<T> {
    private final o<T> a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.i<T> f20257b;

    /* renamed from: c, reason: collision with root package name */
    final com.google.gson.e f20258c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.gson.u.a<T> f20259d;

    /* renamed from: e, reason: collision with root package name */
    private final r f20260e;

    /* renamed from: f, reason: collision with root package name */
    private final l<T>.b f20261f = new b();

    /* renamed from: g, reason: collision with root package name */
    private q<T> f20262g;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes2.dex */
    private final class b implements com.google.gson.n, com.google.gson.h {
        private b() {
        }
    }

    public l(o<T> oVar, com.google.gson.i<T> iVar, com.google.gson.e eVar, com.google.gson.u.a<T> aVar, r rVar) {
        this.a = oVar;
        this.f20257b = iVar;
        this.f20258c = eVar;
        this.f20259d = aVar;
        this.f20260e = rVar;
    }

    private q<T> e() {
        q<T> qVar = this.f20262g;
        if (qVar != null) {
            return qVar;
        }
        q<T> l = this.f20258c.l(this.f20260e, this.f20259d);
        this.f20262g = l;
        return l;
    }

    @Override // com.google.gson.q
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.f20257b == null) {
            return e().b(aVar);
        }
        com.google.gson.j a2 = com.google.gson.t.l.a(aVar);
        if (a2.i()) {
            return null;
        }
        return this.f20257b.a(a2, this.f20259d.getType(), this.f20261f);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.c cVar, T t) throws IOException {
        o<T> oVar = this.a;
        if (oVar == null) {
            e().d(cVar, t);
        } else if (t == null) {
            cVar.y();
        } else {
            com.google.gson.t.l.b(oVar.a(t, this.f20259d.getType(), this.f20261f), cVar);
        }
    }
}
