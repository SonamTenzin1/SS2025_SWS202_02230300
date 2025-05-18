package com.airbnb.lottie.s.i;

import android.graphics.PointF;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;

    /* renamed from: b, reason: collision with root package name */
    private final b f8709b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.f8709b = bVar2;
    }

    @Override // com.airbnb.lottie.s.i.m
    public com.airbnb.lottie.q.b.a<PointF, PointF> a() {
        return new com.airbnb.lottie.q.b.m(this.a.a(), this.f8709b.a());
    }
}
