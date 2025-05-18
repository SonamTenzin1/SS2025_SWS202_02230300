package com.airbnb.lottie.q.b;

import android.graphics.Path;
import android.graphics.PointF;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.w.a<PointF> {

    /* renamed from: k, reason: collision with root package name */
    private Path f8658k;

    /* JADX WARN: Multi-variable type inference failed */
    public h(com.airbnb.lottie.d dVar, com.airbnb.lottie.w.a<PointF> aVar) {
        super(dVar, aVar.f8862b, aVar.f8863c, aVar.f8864d, aVar.f8865e, aVar.f8866f);
        T t;
        T t2 = this.f8863c;
        boolean z = (t2 == 0 || (t = this.f8862b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f8863c;
        if (t3 == 0 || z) {
            return;
        }
        this.f8658k = com.airbnb.lottie.v.f.d((PointF) this.f8862b, (PointF) t3, aVar.f8869i, aVar.f8870j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path e() {
        return this.f8658k;
    }
}
