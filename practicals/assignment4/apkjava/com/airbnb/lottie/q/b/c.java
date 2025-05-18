package com.airbnb.lottie.q.b;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.w.a<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Float i(com.airbnb.lottie.w.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f8862b != null && aVar.f8863c != null) {
            com.airbnb.lottie.w.c<A> cVar = this.f8653e;
            return (cVar == 0 || (f3 = (Float) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), aVar.f8862b, aVar.f8863c, f2, e(), f())) == null) ? Float.valueOf(com.airbnb.lottie.v.e.j(aVar.f8862b.floatValue(), aVar.f8863c.floatValue(), f2)) : f3;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
