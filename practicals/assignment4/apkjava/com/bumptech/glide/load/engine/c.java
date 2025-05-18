package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
public class c implements f, d.a<Object> {

    /* renamed from: f, reason: collision with root package name */
    private final List<com.bumptech.glide.load.f> f9090f;

    /* renamed from: g, reason: collision with root package name */
    private final g<?> f9091g;

    /* renamed from: h, reason: collision with root package name */
    private final f.a f9092h;

    /* renamed from: i, reason: collision with root package name */
    private int f9093i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.load.f f9094j;

    /* renamed from: k, reason: collision with root package name */
    private List<com.bumptech.glide.load.n.n<File, ?>> f9095k;
    private int l;
    private volatile n.a<?> m;
    private File n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        return this.l < this.f9095k.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f9095k != null && b()) {
                this.m = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.n.n<File, ?>> list = this.f9095k;
                    int i2 = this.l;
                    this.l = i2 + 1;
                    this.m = list.get(i2).b(this.n, this.f9091g.s(), this.f9091g.f(), this.f9091g.k());
                    if (this.m != null && this.f9091g.t(this.m.f9326c.a())) {
                        this.m.f9326c.e(this.f9091g.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f9093i + 1;
            this.f9093i = i3;
            if (i3 >= this.f9090f.size()) {
                return false;
            }
            com.bumptech.glide.load.f fVar = this.f9090f.get(this.f9093i);
            File b2 = this.f9091g.d().b(new d(fVar, this.f9091g.o()));
            this.n = b2;
            if (b2 != null) {
                this.f9094j = fVar;
                this.f9095k = this.f9091g.j(b2);
                this.l = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void c(Exception exc) {
        this.f9092h.g(this.f9094j, exc, this.m.f9326c, com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.f9326c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.m.d.a
    public void f(Object obj) {
        this.f9092h.q(this.f9094j, obj, this.m.f9326c, com.bumptech.glide.load.a.DATA_DISK_CACHE, this.f9094j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<com.bumptech.glide.load.f> list, g<?> gVar, f.a aVar) {
        this.f9093i = -1;
        this.f9090f = list;
        this.f9091g = gVar;
        this.f9092h = aVar;
    }
}
