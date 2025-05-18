package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.l;
import com.bumptech.glide.r.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class g {
    private final com.bumptech.glide.l.a a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f9425b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f9426c;

    /* renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.i f9427d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9428e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9429f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9430g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9431h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.h<Bitmap> f9432i;

    /* renamed from: j, reason: collision with root package name */
    private a f9433j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9434k;
    private a l;
    private Bitmap m;
    private l<Bitmap> n;
    private a o;
    private d p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends com.bumptech.glide.p.l.g<Bitmap> {

        /* renamed from: f, reason: collision with root package name */
        private final Handler f9435f;

        /* renamed from: g, reason: collision with root package name */
        final int f9436g;

        /* renamed from: h, reason: collision with root package name */
        private final long f9437h;

        /* renamed from: i, reason: collision with root package name */
        private Bitmap f9438i;

        a(Handler handler, int i2, long j2) {
            this.f9435f = handler;
            this.f9436g = i2;
            this.f9437h = j2;
        }

        Bitmap c() {
            return this.f9438i;
        }

        @Override // com.bumptech.glide.p.l.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.p.m.d<? super Bitmap> dVar) {
            this.f9438i = bitmap;
            this.f9435f.sendMessageAtTime(this.f9435f.obtainMessage(1, this), this.f9437h);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.n((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            g.this.f9427d.e((a) message.obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.c cVar, com.bumptech.glide.l.a aVar, int i2, int i3, l<Bitmap> lVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.t(cVar.h()), aVar, null, j(com.bumptech.glide.c.t(cVar.h()), i2, i3), lVar, bitmap);
    }

    private static com.bumptech.glide.load.f g() {
        return new com.bumptech.glide.q.c(Double.valueOf(Math.random()));
    }

    private int h() {
        return k.g(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static com.bumptech.glide.h<Bitmap> j(com.bumptech.glide.i iVar, int i2, int i3) {
        return iVar.b().b(com.bumptech.glide.p.h.t0(com.bumptech.glide.load.engine.j.f9140b).r0(true).k0(true).X(i2, i3));
    }

    private void m() {
        if (!this.f9429f || this.f9430g) {
            return;
        }
        if (this.f9431h) {
            com.bumptech.glide.r.j.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.g();
            this.f9431h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            n(aVar);
            return;
        }
        this.f9430g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.a.e();
        this.a.c();
        this.l = new a(this.f9425b, this.a.h(), uptimeMillis);
        this.f9432i.b(com.bumptech.glide.p.h.v0(g())).I0(this.a).A0(this.l);
    }

    private void o() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f9428e.c(bitmap);
            this.m = null;
        }
    }

    private void q() {
        if (this.f9429f) {
            return;
        }
        this.f9429f = true;
        this.f9434k = false;
        m();
    }

    private void r() {
        this.f9429f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f9426c.clear();
        o();
        r();
        a aVar = this.f9433j;
        if (aVar != null) {
            this.f9427d.e(aVar);
            this.f9433j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f9427d.e(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f9427d.e(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.f9434k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.a.b().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f9433j;
        return aVar != null ? aVar.c() : this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f9433j;
        if (aVar != null) {
            return aVar.f9436g;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return c().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.a.i() + h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return c().getWidth();
    }

    void n(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f9430g = false;
        if (this.f9434k) {
            this.f9425b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f9429f) {
            this.o = aVar;
            return;
        }
        if (aVar.c() != null) {
            o();
            a aVar2 = this.f9433j;
            this.f9433j = aVar;
            for (int size = this.f9426c.size() - 1; size >= 0; size--) {
                this.f9426c.get(size).a();
            }
            if (aVar2 != null) {
                this.f9425b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(l<Bitmap> lVar, Bitmap bitmap) {
        this.n = (l) com.bumptech.glide.r.j.d(lVar);
        this.m = (Bitmap) com.bumptech.glide.r.j.d(bitmap);
        this.f9432i = this.f9432i.b(new com.bumptech.glide.p.h().l0(lVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(b bVar) {
        if (!this.f9434k) {
            if (!this.f9426c.contains(bVar)) {
                boolean isEmpty = this.f9426c.isEmpty();
                this.f9426c.add(bVar);
                if (isEmpty) {
                    q();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(b bVar) {
        this.f9426c.remove(bVar);
        if (this.f9426c.isEmpty()) {
            r();
        }
    }

    g(com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.i iVar, com.bumptech.glide.l.a aVar, Handler handler, com.bumptech.glide.h<Bitmap> hVar, l<Bitmap> lVar, Bitmap bitmap) {
        this.f9426c = new ArrayList();
        this.f9427d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f9428e = eVar;
        this.f9425b = handler;
        this.f9432i = hVar;
        this.a = aVar;
        p(lVar, bitmap);
    }
}
