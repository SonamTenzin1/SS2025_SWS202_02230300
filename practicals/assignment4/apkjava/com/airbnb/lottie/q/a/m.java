package com.airbnb.lottie.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.q.b.a;
import com.airbnb.lottie.s.j.i;
import com.airbnb.lottie.s.j.q;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class m implements l, a.InterfaceC0118a, j {
    private final Path a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final String f8614b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.f f8615c;

    /* renamed from: d, reason: collision with root package name */
    private final i.a f8616d;

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8617e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8618f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8619g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8620h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8621i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8622j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8623k;
    private r l;
    private boolean m;

    /* compiled from: PolystarContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.i iVar) {
        this.f8615c = fVar;
        this.f8614b = iVar.d();
        i.a j2 = iVar.j();
        this.f8616d = j2;
        com.airbnb.lottie.q.b.a<Float, Float> a2 = iVar.g().a();
        this.f8617e = a2;
        com.airbnb.lottie.q.b.a<PointF, PointF> a3 = iVar.h().a();
        this.f8618f = a3;
        com.airbnb.lottie.q.b.a<Float, Float> a4 = iVar.i().a();
        this.f8619g = a4;
        com.airbnb.lottie.q.b.a<Float, Float> a5 = iVar.e().a();
        this.f8621i = a5;
        com.airbnb.lottie.q.b.a<Float, Float> a6 = iVar.f().a();
        this.f8623k = a6;
        i.a aVar2 = i.a.Star;
        if (j2 == aVar2) {
            this.f8620h = iVar.b().a();
            this.f8622j = iVar.c().a();
        } else {
            this.f8620h = null;
            this.f8622j = null;
        }
        aVar.i(a2);
        aVar.i(a3);
        aVar.i(a4);
        aVar.i(a5);
        aVar.i(a6);
        if (j2 == aVar2) {
            aVar.i(this.f8620h);
            aVar.i(this.f8622j);
        }
        a2.a(this);
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        if (j2 == aVar2) {
            this.f8620h.a(this);
            this.f8622j.a(this);
        }
    }

    private void e() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor(this.f8617e.h().floatValue());
        double radians = Math.toRadians((this.f8619g == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d5 = floor;
        Double.isNaN(d5);
        float floatValue = this.f8623k.h().floatValue() / 100.0f;
        float floatValue2 = this.f8621i.h().floatValue();
        double d6 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.a.moveTo(f2, f3);
        double d7 = (float) (6.283185307179586d / d5);
        Double.isNaN(d7);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < ceil) {
            double cos2 = Math.cos(d8);
            Double.isNaN(d6);
            float f4 = (float) (cos2 * d6);
            double sin2 = Math.sin(d8);
            Double.isNaN(d6);
            double d9 = ceil;
            float f5 = (float) (d6 * sin2);
            if (floatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float f6 = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(f2 - (cos3 * f6), f3 - (sin3 * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.a.lineTo(f4, f5);
            }
            Double.isNaN(d4);
            d8 = d2 + d4;
            i3 = i2 + 1;
            f3 = f5;
            f2 = f4;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF h2 = this.f8618f.h();
        this.a.offset(h2.x, h2.y);
        this.a.close();
    }

    private void i() {
        double d2;
        float f2;
        float f3;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        double d4;
        float f12;
        float f13;
        float floatValue = this.f8617e.h().floatValue();
        double radians = Math.toRadians((this.f8619g == null ? 0.0d : r2.h().floatValue()) - 90.0d);
        double d5 = floatValue;
        Double.isNaN(d5);
        float f14 = (float) (6.283185307179586d / d5);
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((int) floatValue);
        if (f16 != 0.0f) {
            double d6 = (1.0f - f16) * f15;
            Double.isNaN(d6);
            radians += d6;
        }
        float floatValue2 = this.f8621i.h().floatValue();
        float floatValue3 = this.f8620h.h().floatValue();
        com.airbnb.lottie.q.b.a<?, Float> aVar = this.f8622j;
        float floatValue4 = aVar != null ? aVar.h().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.q.b.a<?, Float> aVar2 = this.f8623k;
        float floatValue5 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        if (f16 != 0.0f) {
            float f17 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            double d7 = f17;
            double cos = Math.cos(radians);
            Double.isNaN(d7);
            d2 = d5;
            float f18 = (float) (d7 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d7);
            float f19 = (float) (d7 * sin);
            this.a.moveTo(f18, f19);
            double d8 = (f14 * f16) / 2.0f;
            Double.isNaN(d8);
            d3 = radians + d8;
            f4 = f18;
            f6 = f17;
            f2 = floatValue2;
            f5 = f19;
            f3 = f15;
        } else {
            d2 = d5;
            f2 = floatValue2;
            double d9 = f2;
            double cos2 = Math.cos(radians);
            Double.isNaN(d9);
            f3 = f15;
            f4 = (float) (d9 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d9);
            f5 = (float) (d9 * sin2);
            this.a.moveTo(f4, f5);
            double d10 = f3;
            Double.isNaN(d10);
            d3 = radians + d10;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i2 = 0;
        float f20 = floatValue5;
        boolean z = false;
        while (true) {
            double d11 = i2;
            if (d11 < ceil) {
                float f21 = z ? f2 : floatValue3;
                float f22 = (f6 == 0.0f || d11 != ceil - 2.0d) ? f3 : (f14 * f16) / 2.0f;
                if (f6 == 0.0f || d11 != ceil - 1.0d) {
                    f7 = f14;
                    f8 = f21;
                    f9 = f2;
                } else {
                    f7 = f14;
                    f9 = f2;
                    f8 = f6;
                }
                double d12 = f8;
                double cos3 = Math.cos(d3);
                Double.isNaN(d12);
                float f23 = (float) (d12 * cos3);
                double sin3 = Math.sin(d3);
                Double.isNaN(d12);
                float f24 = (float) (d12 * sin3);
                if (floatValue4 == 0.0f && f20 == 0.0f) {
                    this.a.lineTo(f23, f24);
                    d4 = d3;
                    f10 = floatValue3;
                    f11 = floatValue4;
                    f12 = f3;
                    f13 = f22;
                } else {
                    f10 = floatValue3;
                    f11 = floatValue4;
                    double atan2 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    d4 = d3;
                    f12 = f3;
                    f13 = f22;
                    double atan22 = (float) (Math.atan2(f24, f23) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f25 = z ? f11 : f20;
                    float f26 = z ? f20 : f11;
                    float f27 = (z ? f10 : f9) * f25 * 0.47829f;
                    float f28 = cos4 * f27;
                    float f29 = f27 * sin4;
                    float f30 = (z ? f9 : f10) * f26 * 0.47829f;
                    float f31 = cos5 * f30;
                    float f32 = f30 * sin5;
                    if (f16 != 0.0f) {
                        if (i2 == 0) {
                            f28 *= f16;
                            f29 *= f16;
                        } else if (d11 == ceil - 1.0d) {
                            f31 *= f16;
                            f32 *= f16;
                        }
                    }
                    this.a.cubicTo(f4 - f28, f5 - f29, f23 + f31, f24 + f32, f23, f24);
                }
                double d13 = f13;
                Double.isNaN(d13);
                z = !z;
                i2++;
                f5 = f24;
                d3 = d4 + d13;
                f3 = f12;
                f4 = f23;
                f2 = f9;
                f14 = f7;
                floatValue3 = f10;
                floatValue4 = f11;
            } else {
                PointF h2 = this.f8618f.h();
                this.a.offset(h2.x, h2.y);
                this.a.close();
                return;
            }
        }
    }

    private void j() {
        this.m = false;
        this.f8615c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        j();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.j() == q.a.Simultaneously) {
                    this.l = rVar;
                    rVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        if (this.m) {
            return this.a;
        }
        this.a.reset();
        int i2 = a.a[this.f8616d.ordinal()];
        if (i2 == 1) {
            i();
        } else if (i2 == 2) {
            e();
        }
        this.a.close();
        com.airbnb.lottie.v.f.b(this.a, this.l);
        this.m = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8614b;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        com.airbnb.lottie.q.b.a<?, Float> aVar;
        com.airbnb.lottie.q.b.a<?, Float> aVar2;
        if (t == com.airbnb.lottie.j.o) {
            this.f8617e.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.p) {
            this.f8619g.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.f8538h) {
            this.f8618f.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.q && (aVar2 = this.f8620h) != null) {
            aVar2.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.r) {
            this.f8621i.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.s && (aVar = this.f8622j) != null) {
            aVar.m(cVar);
        } else if (t == com.airbnb.lottie.j.t) {
            this.f8623k.m(cVar);
        }
    }
}
