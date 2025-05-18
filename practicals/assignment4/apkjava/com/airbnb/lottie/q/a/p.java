package com.airbnb.lottie.q.a;

import android.graphics.Path;
import com.airbnb.lottie.q.b.a;
import com.airbnb.lottie.s.j.q;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class p implements l, a.InterfaceC0118a {
    private final Path a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final String f8640b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.f f8641c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Path> f8642d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8643e;

    /* renamed from: f, reason: collision with root package name */
    private r f8644f;

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.o oVar) {
        this.f8640b = oVar.b();
        this.f8641c = fVar;
        com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.l, Path> a = oVar.c().a();
        this.f8642d = a;
        aVar.i(a);
        a.a(this);
    }

    private void c() {
        this.f8643e = false;
        this.f8641c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        c();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.j() == q.a.Simultaneously) {
                    this.f8644f = rVar;
                    rVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        if (this.f8643e) {
            return this.a;
        }
        this.a.reset();
        this.a.set(this.f8642d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.v.f.b(this.a, this.f8644f);
        this.f8643e = true;
        return this.a;
    }
}
