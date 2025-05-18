package com.airbnb.lottie.q.b;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: g, reason: collision with root package name */
    private final PointF f8663g;

    public j(List<com.airbnb.lottie.w.a<PointF>> list) {
        super(list);
        this.f8663g = new PointF();
    }

    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.w.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f8862b;
        if (pointF3 != null && (pointF = aVar.f8863c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            com.airbnb.lottie.w.c<A> cVar = this.f8653e;
            if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.f8865e, aVar.f8866f.floatValue(), pointF4, pointF5, f2, e(), f())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f8663g;
            float f3 = pointF4.x;
            float f4 = f3 + ((pointF5.x - f3) * f2);
            float f5 = pointF4.y;
            pointF6.set(f4, f5 + (f2 * (pointF5.y - f5)));
            return this.f8663g;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
