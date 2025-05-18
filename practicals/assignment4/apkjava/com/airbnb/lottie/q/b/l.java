package com.airbnb.lottie.q.b;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.s.j.l, Path> {

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.l f8664g;

    /* renamed from: h, reason: collision with root package name */
    private final Path f8665h;

    public l(List<com.airbnb.lottie.w.a<com.airbnb.lottie.s.j.l>> list) {
        super(list);
        this.f8664g = new com.airbnb.lottie.s.j.l();
        this.f8665h = new Path();
    }

    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Path i(com.airbnb.lottie.w.a<com.airbnb.lottie.s.j.l> aVar, float f2) {
        this.f8664g.c(aVar.f8862b, aVar.f8863c, f2);
        com.airbnb.lottie.v.e.h(this.f8664g, this.f8665h);
        return this.f8665h;
    }
}
