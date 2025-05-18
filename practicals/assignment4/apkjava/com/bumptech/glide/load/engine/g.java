package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class g<Transcode> {
    private final List<n.a<?>> a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.f> f9103b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.e f9104c;

    /* renamed from: d, reason: collision with root package name */
    private Object f9105d;

    /* renamed from: e, reason: collision with root package name */
    private int f9106e;

    /* renamed from: f, reason: collision with root package name */
    private int f9107f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f9108g;

    /* renamed from: h, reason: collision with root package name */
    private h.e f9109h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.i f9110i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.l<?>> f9111j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f9112k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.f n;
    private com.bumptech.glide.g o;
    private j p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f9104c = null;
        this.f9105d = null;
        this.n = null;
        this.f9108g = null;
        this.f9112k = null;
        this.f9110i = null;
        this.o = null;
        this.f9111j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.f9103b.clear();
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.z.b b() {
        return this.f9104c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.f> c() {
        if (!this.m) {
            this.m = true;
            this.f9103b.clear();
            List<n.a<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = g2.get(i2);
                if (!this.f9103b.contains(aVar.a)) {
                    this.f9103b.add(aVar.a);
                }
                for (int i3 = 0; i3 < aVar.f9325b.size(); i3++) {
                    if (!this.f9103b.contains(aVar.f9325b.get(i3))) {
                        this.f9103b.add(aVar.f9325b.get(i3));
                    }
                }
            }
        }
        return this.f9103b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.a0.a d() {
        return this.f9109h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f9107f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List i2 = this.f9104c.h().i(this.f9105d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                n.a<?> b2 = ((com.bumptech.glide.load.n.n) i2.get(i3)).b(this.f9105d, this.f9106e, this.f9107f, this.f9110i);
                if (b2 != null) {
                    this.a.add(b2);
                }
            }
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f9104c.h().h(cls, this.f9108g, this.f9112k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f9105d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.n.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f9104c.h().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.i k() {
        return this.f9110i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.g l() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f9104c.h().j(this.f9105d.getClass(), this.f9108g, this.f9112k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.k<Z> n(u<Z> uVar) {
        return this.f9104c.h().k(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.f o() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.d<X> p(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f9104c.h().m(x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return this.f9112k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.l<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.l<Z> lVar = (com.bumptech.glide.load.l) this.f9111j.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.l<?>>> it = this.f9111j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (com.bumptech.glide.load.l) next.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (this.f9111j.isEmpty() && this.q) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return com.bumptech.glide.load.o.b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f9106e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.f fVar, int i2, int i3, j jVar, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, com.bumptech.glide.load.i iVar, Map<Class<?>, com.bumptech.glide.load.l<?>> map, boolean z, boolean z2, h.e eVar2) {
        this.f9104c = eVar;
        this.f9105d = obj;
        this.n = fVar;
        this.f9106e = i2;
        this.f9107f = i3;
        this.p = jVar;
        this.f9108g = cls;
        this.f9109h = eVar2;
        this.f9112k = cls2;
        this.o = gVar;
        this.f9110i = iVar;
        this.f9111j = map;
        this.q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(u<?> uVar) {
        return this.f9104c.h().n(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(com.bumptech.glide.load.f fVar) {
        List<n.a<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
