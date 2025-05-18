package com.airbnb.lottie.q.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: g, reason: collision with root package name */
    private final PointF f8659g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f8660h;

    /* renamed from: i, reason: collision with root package name */
    private h f8661i;

    /* renamed from: j, reason: collision with root package name */
    private PathMeasure f8662j;

    public i(List<? extends com.airbnb.lottie.w.a<PointF>> list) {
        super(list);
        this.f8659g = new PointF();
        this.f8660h = new float[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.q.b.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.w.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path e2 = hVar.e();
        if (e2 == null) {
            return aVar.f8862b;
        }
        com.airbnb.lottie.w.c<A> cVar = this.f8653e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(hVar.f8865e, hVar.f8866f.floatValue(), hVar.f8862b, hVar.f8863c, e(), f2, f())) != null) {
            return pointF;
        }
        if (this.f8661i != hVar) {
            this.f8662j = new PathMeasure(e2, false);
            this.f8661i = hVar;
        }
        PathMeasure pathMeasure = this.f8662j;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f8660h, null);
        PointF pointF2 = this.f8659g;
        float[] fArr = this.f8660h;
        pointF2.set(fArr[0], fArr[1]);
        return this.f8659g;
    }
}
