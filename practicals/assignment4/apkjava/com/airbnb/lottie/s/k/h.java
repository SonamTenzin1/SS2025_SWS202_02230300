package com.airbnb.lottie.s.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.j;
import com.airbnb.lottie.q.b.n;
import com.airbnb.lottie.s.i.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.s.k.a {
    private final Paint A;
    private final Map<com.airbnb.lottie.s.d, List<com.airbnb.lottie.q.a.c>> B;
    private final n C;
    private final com.airbnb.lottie.f D;
    private final com.airbnb.lottie.d E;
    private com.airbnb.lottie.q.b.a<Integer, Integer> F;
    private com.airbnb.lottie.q.b.a<Integer, Integer> G;
    private com.airbnb.lottie.q.b.a<Float, Float> H;
    private com.airbnb.lottie.q.b.a<Float, Float> I;
    private final char[] w;
    private final RectF x;
    private final Matrix y;
    private final Paint z;

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class a extends Paint {
        a(int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class b extends Paint {
        b(int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        com.airbnb.lottie.s.i.b bVar;
        com.airbnb.lottie.s.i.b bVar2;
        com.airbnb.lottie.s.i.a aVar;
        com.airbnb.lottie.s.i.a aVar2;
        this.w = new char[1];
        this.x = new RectF();
        this.y = new Matrix();
        this.z = new a(1);
        this.A = new b(1);
        this.B = new HashMap();
        this.D = fVar;
        this.E = dVar.a();
        n a2 = dVar.q().a();
        this.C = a2;
        a2.a(this);
        i(a2);
        k r = dVar.r();
        if (r != null && (aVar2 = r.a) != null) {
            com.airbnb.lottie.q.b.a<Integer, Integer> a3 = aVar2.a();
            this.F = a3;
            a3.a(this);
            i(this.F);
        }
        if (r != null && (aVar = r.f8710b) != null) {
            com.airbnb.lottie.q.b.a<Integer, Integer> a4 = aVar.a();
            this.G = a4;
            a4.a(this);
            i(this.G);
        }
        if (r != null && (bVar2 = r.f8711c) != null) {
            com.airbnb.lottie.q.b.a<Float, Float> a5 = bVar2.a();
            this.H = a5;
            a5.a(this);
            i(this.H);
        }
        if (r == null || (bVar = r.f8712d) == null) {
            return;
        }
        com.airbnb.lottie.q.b.a<Float, Float> a6 = bVar.a();
        this.I = a6;
        a6.a(this);
        i(this.I);
    }

    private void D(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private void E(com.airbnb.lottie.s.d dVar, Matrix matrix, float f2, com.airbnb.lottie.s.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.q.a.c> J = J(dVar);
        for (int i2 = 0; i2 < J.size(); i2++) {
            Path g2 = J.get(i2).g();
            g2.computeBounds(this.x, false);
            this.y.set(matrix);
            this.y.preTranslate(0.0f, ((float) (-bVar.f8693g)) * com.airbnb.lottie.v.f.e());
            this.y.preScale(f2, f2);
            g2.transform(this.y);
            if (bVar.f8697k) {
                G(g2, this.z, canvas);
                G(g2, this.A, canvas);
            } else {
                G(g2, this.A, canvas);
                G(g2, this.z, canvas);
            }
        }
    }

    private void F(char c2, com.airbnb.lottie.s.b bVar, Canvas canvas) {
        char[] cArr = this.w;
        cArr[0] = c2;
        if (bVar.f8697k) {
            D(cArr, this.z, canvas);
            D(this.w, this.A, canvas);
        } else {
            D(cArr, this.A, canvas);
            D(this.w, this.z, canvas);
        }
    }

    private void G(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void H(com.airbnb.lottie.s.b bVar, Matrix matrix, com.airbnb.lottie.s.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f8689c) / 100.0f;
        float f3 = com.airbnb.lottie.v.f.f(matrix);
        String str = bVar.a;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.s.d g2 = this.E.c().g(com.airbnb.lottie.s.d.c(str.charAt(i2), cVar.a(), cVar.c()));
            if (g2 != null) {
                E(g2, matrix, f2, bVar, canvas);
                float b2 = ((float) g2.b()) * f2 * com.airbnb.lottie.v.f.e() * f3;
                float f4 = bVar.f8691e / 10.0f;
                com.airbnb.lottie.q.b.a<Float, Float> aVar = this.I;
                if (aVar != null) {
                    f4 += aVar.h().floatValue();
                }
                canvas.translate(b2 + (f4 * f3), 0.0f);
            }
        }
    }

    private void I(com.airbnb.lottie.s.b bVar, com.airbnb.lottie.s.c cVar, Matrix matrix, Canvas canvas) {
        float f2 = com.airbnb.lottie.v.f.f(matrix);
        Typeface A = this.D.A(cVar.a(), cVar.c());
        if (A == null) {
            return;
        }
        String str = bVar.a;
        if (this.D.z() != null) {
            throw null;
        }
        this.z.setTypeface(A);
        Paint paint = this.z;
        double d2 = bVar.f8689c;
        double e2 = com.airbnb.lottie.v.f.e();
        Double.isNaN(e2);
        paint.setTextSize((float) (d2 * e2));
        this.A.setTypeface(this.z.getTypeface());
        this.A.setTextSize(this.z.getTextSize());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            F(charAt, bVar, canvas);
            char[] cArr = this.w;
            cArr[0] = charAt;
            float measureText = this.z.measureText(cArr, 0, 1);
            float f3 = bVar.f8691e / 10.0f;
            com.airbnb.lottie.q.b.a<Float, Float> aVar = this.I;
            if (aVar != null) {
                f3 += aVar.h().floatValue();
            }
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private List<com.airbnb.lottie.q.a.c> J(com.airbnb.lottie.s.d dVar) {
        if (this.B.containsKey(dVar)) {
            return this.B.get(dVar);
        }
        List<com.airbnb.lottie.s.j.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.q.a.c(this.D, this, a2.get(i2)));
        }
        this.B.put(dVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.s.k.a, com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        com.airbnb.lottie.q.b.a<Float, Float> aVar;
        com.airbnb.lottie.q.b.a<Float, Float> aVar2;
        com.airbnb.lottie.q.b.a<Integer, Integer> aVar3;
        com.airbnb.lottie.q.b.a<Integer, Integer> aVar4;
        super.h(t, cVar);
        if (t == j.a && (aVar4 = this.F) != null) {
            aVar4.m(cVar);
            return;
        }
        if (t == j.f8532b && (aVar3 = this.G) != null) {
            aVar3.m(cVar);
            return;
        }
        if (t == j.f8541k && (aVar2 = this.H) != null) {
            aVar2.m(cVar);
        } else {
            if (t != j.l || (aVar = this.I) == null) {
                return;
            }
            aVar.m(cVar);
        }
    }

    @Override // com.airbnb.lottie.s.k.a
    void n(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.D.W()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.s.b h2 = this.C.h();
        com.airbnb.lottie.s.c cVar = this.E.g().get(h2.f8688b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.q.b.a<Integer, Integer> aVar = this.F;
        if (aVar != null) {
            this.z.setColor(aVar.h().intValue());
        } else {
            this.z.setColor(h2.f8694h);
        }
        com.airbnb.lottie.q.b.a<Integer, Integer> aVar2 = this.G;
        if (aVar2 != null) {
            this.A.setColor(aVar2.h().intValue());
        } else {
            this.A.setColor(h2.f8695i);
        }
        int intValue = (this.u.g().h().intValue() * 255) / 100;
        this.z.setAlpha(intValue);
        this.A.setAlpha(intValue);
        com.airbnb.lottie.q.b.a<Float, Float> aVar3 = this.H;
        if (aVar3 != null) {
            this.A.setStrokeWidth(aVar3.h().floatValue());
        } else {
            float f2 = com.airbnb.lottie.v.f.f(matrix);
            Paint paint = this.A;
            double d2 = h2.f8696j;
            double e2 = com.airbnb.lottie.v.f.e();
            Double.isNaN(e2);
            double d3 = d2 * e2;
            double d4 = f2;
            Double.isNaN(d4);
            paint.setStrokeWidth((float) (d3 * d4));
        }
        if (this.D.W()) {
            H(h2, matrix, cVar, canvas);
        } else {
            I(h2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
