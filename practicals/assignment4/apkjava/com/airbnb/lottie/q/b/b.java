package com.airbnb.lottie.q.b;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.w.a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer i(com.airbnb.lottie.w.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f8862b;
        if (num2 != null && aVar.f8863c != null) {
            int intValue = num2.intValue();
            int intValue2 = aVar.f8863c.intValue();
            com.airbnb.lottie.w.c<A> cVar = this.f8653e;
            return (cVar == 0 || (num = (Integer) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) == null) ? Integer.valueOf(com.airbnb.lottie.v.b.c(f2, intValue, intValue2)) : num;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
