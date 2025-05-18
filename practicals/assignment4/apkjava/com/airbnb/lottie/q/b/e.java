package com.airbnb.lottie.q.b;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.w.a<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer i(com.airbnb.lottie.w.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f8862b != null && aVar.f8863c != null) {
            com.airbnb.lottie.w.c<A> cVar = this.f8653e;
            return (cVar == 0 || (num = (Integer) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), aVar.f8862b, aVar.f8863c, f2, e(), f())) == null) ? Integer.valueOf(com.airbnb.lottie.v.e.k(aVar.f8862b.intValue(), aVar.f8863c.intValue(), f2)) : num;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
