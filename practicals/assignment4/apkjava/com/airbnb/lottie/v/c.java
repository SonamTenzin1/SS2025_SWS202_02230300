package com.airbnb.lottie.v;

import android.view.Choreographer;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class c extends a implements Choreographer.FrameCallback {
    private com.airbnb.lottie.d o;

    /* renamed from: h, reason: collision with root package name */
    private float f8852h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8853i = false;

    /* renamed from: j, reason: collision with root package name */
    private long f8854j = 0;

    /* renamed from: k, reason: collision with root package name */
    private float f8855k = 0.0f;
    private int l = 0;
    private float m = -2.1474836E9f;
    private float n = 2.1474836E9f;
    protected boolean p = false;

    private void E() {
        if (this.o == null) {
            return;
        }
        float f2 = this.f8855k;
        if (f2 < this.m || f2 > this.n) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.m), Float.valueOf(this.n), Float.valueOf(this.f8855k)));
        }
    }

    private float l() {
        com.airbnb.lottie.d dVar = this.o;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f8852h);
    }

    private boolean p() {
        return o() < 0.0f;
    }

    public void A(int i2) {
        B((int) this.m, i2);
    }

    public void B(int i2, int i3) {
        com.airbnb.lottie.d dVar = this.o;
        float m = dVar == null ? -3.4028235E38f : dVar.m();
        com.airbnb.lottie.d dVar2 = this.o;
        float f2 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
        float f3 = i2;
        this.m = e.b(f3, m, f2);
        float f4 = i3;
        this.n = e.b(f4, m, f2);
        w((int) e.b(this.f8855k, f3, f4));
    }

    public void C(int i2) {
        B(i2, (int) this.n);
    }

    public void D(float f2) {
        this.f8852h = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        r();
        if (this.o == null || !isRunning()) {
            return;
        }
        long nanoTime = System.nanoTime();
        float l = ((float) (nanoTime - this.f8854j)) / l();
        float f2 = this.f8855k;
        if (p()) {
            l = -l;
        }
        float f3 = f2 + l;
        this.f8855k = f3;
        boolean z = !e.d(f3, n(), m());
        this.f8855k = e.b(this.f8855k, n(), m());
        this.f8854j = nanoTime;
        g();
        if (z) {
            if (getRepeatCount() != -1 && this.l >= getRepeatCount()) {
                this.f8855k = m();
                s();
                d(p());
            } else {
                e();
                this.l++;
                if (getRepeatMode() == 2) {
                    this.f8853i = !this.f8853i;
                    u();
                } else {
                    this.f8855k = p() ? m() : n();
                }
                this.f8854j = nanoTime;
            }
        }
        E();
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float n;
        float m;
        float n2;
        if (this.o == null) {
            return 0.0f;
        }
        if (p()) {
            n = m() - this.f8855k;
            m = m();
            n2 = n();
        } else {
            n = this.f8855k - n();
            m = m();
            n2 = n();
        }
        return n / (m - n2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(j());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.o == null) {
            return 0L;
        }
        return r0.d();
    }

    public void h() {
        this.o = null;
        this.m = -2.1474836E9f;
        this.n = 2.1474836E9f;
    }

    public void i() {
        s();
        d(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.p;
    }

    public float j() {
        com.airbnb.lottie.d dVar = this.o;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f8855k - dVar.m()) / (this.o.f() - this.o.m());
    }

    public float k() {
        return this.f8855k;
    }

    public float m() {
        com.airbnb.lottie.d dVar = this.o;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.n;
        return f2 == 2.1474836E9f ? dVar.f() : f2;
    }

    public float n() {
        com.airbnb.lottie.d dVar = this.o;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.m;
        return f2 == -2.1474836E9f ? dVar.m() : f2;
    }

    public float o() {
        return this.f8852h;
    }

    public void q() {
        this.p = true;
        f(p());
        w((int) (p() ? m() : n()));
        this.f8854j = System.nanoTime();
        this.l = 0;
        r();
    }

    protected void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f8853i) {
            return;
        }
        this.f8853i = false;
        u();
    }

    protected void t(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.p = false;
        }
    }

    public void u() {
        D(-o());
    }

    public void v(com.airbnb.lottie.d dVar) {
        boolean z = this.o == null;
        this.o = dVar;
        if (z) {
            B((int) Math.max(this.m, dVar.m()), (int) Math.min(this.n, dVar.f()));
        } else {
            B((int) dVar.m(), (int) dVar.f());
        }
        w((int) this.f8855k);
        this.f8854j = System.nanoTime();
    }

    public void w(int i2) {
        float f2 = i2;
        if (this.f8855k == f2) {
            return;
        }
        this.f8855k = e.b(f2, n(), m());
        this.f8854j = System.nanoTime();
        g();
    }
}
