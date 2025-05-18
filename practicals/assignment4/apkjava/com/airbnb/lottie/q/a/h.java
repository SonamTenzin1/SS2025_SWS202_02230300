package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class h extends a {
    private final String o;
    private final c.e.d<LinearGradient> p;
    private final c.e.d<RadialGradient> q;
    private final RectF r;
    private final com.airbnb.lottie.s.j.f s;
    private final int t;
    private final com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> u;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> v;
    private final com.airbnb.lottie.q.b.a<PointF, PointF> w;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.e eVar) {
        super(fVar, aVar, eVar.b().g(), eVar.g().g(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.p = new c.e.d<>();
        this.q = new c.e.d<>();
        this.r = new RectF();
        this.o = eVar.j();
        this.s = eVar.f();
        this.t = (int) (fVar.j().d() / 32.0f);
        com.airbnb.lottie.q.b.a<com.airbnb.lottie.s.j.c, com.airbnb.lottie.s.j.c> a = eVar.e().a();
        this.u = a;
        a.a(this);
        aVar.i(a);
        com.airbnb.lottie.q.b.a<PointF, PointF> a2 = eVar.l().a();
        this.v = a2;
        a2.a(this);
        aVar.i(a2);
        com.airbnb.lottie.q.b.a<PointF, PointF> a3 = eVar.d().a();
        this.w = a3;
        a3.a(this);
        aVar.i(a3);
    }

    private int j() {
        int round = Math.round(this.v.f() * this.t);
        int round2 = Math.round(this.w.f() * this.t);
        int round3 = Math.round(this.u.f() * this.t);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient g2 = this.p.g(j2);
        if (g2 != null) {
            return g2;
        }
        PointF h2 = this.v.h();
        PointF h3 = this.w.h();
        com.airbnb.lottie.s.j.c h4 = this.u.h();
        int[] a = h4.a();
        float[] b2 = h4.b();
        RectF rectF = this.r;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + h2.x);
        RectF rectF2 = this.r;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + h2.y);
        RectF rectF3 = this.r;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + h3.x);
        RectF rectF4 = this.r;
        LinearGradient linearGradient = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + h3.y), a, b2, Shader.TileMode.CLAMP);
        this.p.k(j2, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        long j2 = j();
        RadialGradient g2 = this.q.g(j2);
        if (g2 != null) {
            return g2;
        }
        PointF h2 = this.v.h();
        PointF h3 = this.w.h();
        com.airbnb.lottie.s.j.c h4 = this.u.h();
        int[] a = h4.a();
        float[] b2 = h4.b();
        RectF rectF = this.r;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + h2.x);
        RectF rectF2 = this.r;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + h2.y);
        RectF rectF3 = this.r;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + h3.x);
        RectF rectF4 = this.r;
        RadialGradient radialGradient = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + h3.y)) - height), a, b2, Shader.TileMode.CLAMP);
        this.q.k(j2, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.q.a.a, com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        d(this.r, matrix);
        if (this.s == com.airbnb.lottie.s.j.f.Linear) {
            this.f8573i.setShader(k());
        } else {
            this.f8573i.setShader(l());
        }
        super.f(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.o;
    }
}
