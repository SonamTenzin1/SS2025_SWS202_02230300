package com.airbnb.lottie.q.b;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<com.airbnb.lottie.s.j.c> {

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.c f8655g;

    public d(List<com.airbnb.lottie.w.a<com.airbnb.lottie.s.j.c>> list) {
        super(list);
        com.airbnb.lottie.s.j.c cVar = list.get(0).f8862b;
        int c2 = cVar != null ? cVar.c() : 0;
        this.f8655g = new com.airbnb.lottie.s.j.c(new float[c2], new int[c2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.s.j.c i(com.airbnb.lottie.w.a<com.airbnb.lottie.s.j.c> aVar, float f2) {
        this.f8655g.d(aVar.f8862b, aVar.f8863c, f2);
        return this.f8655g;
    }
}
