package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.u;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class c implements View.OnTouchListener {

    /* renamed from: f, reason: collision with root package name */
    private static final int f1100f = ViewConfiguration.getTapTimeout();

    /* renamed from: i, reason: collision with root package name */
    final View f1103i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f1104j;
    private int m;
    private int n;
    private boolean r;
    boolean s;
    boolean t;
    boolean u;
    private boolean v;
    private boolean w;

    /* renamed from: g, reason: collision with root package name */
    final a f1101g = new a();

    /* renamed from: h, reason: collision with root package name */
    private final Interpolator f1102h = new AccelerateInterpolator();

    /* renamed from: k, reason: collision with root package name */
    private float[] f1105k = {0.0f, 0.0f};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] o = {0.0f, 0.0f};
    private float[] p = {0.0f, 0.0f};
    private float[] q = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public static class a {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f1106b;

        /* renamed from: c, reason: collision with root package name */
        private float f1107c;

        /* renamed from: d, reason: collision with root package name */
        private float f1108d;

        /* renamed from: j, reason: collision with root package name */
        private float f1114j;

        /* renamed from: k, reason: collision with root package name */
        private int f1115k;

        /* renamed from: e, reason: collision with root package name */
        private long f1109e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f1113i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f1110f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f1111g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f1112h = 0;

        a() {
        }

        private float e(long j2) {
            long j3 = this.f1109e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f1113i;
            if (j4 >= 0 && j2 >= j4) {
                float f2 = this.f1114j;
                return (1.0f - f2) + (f2 * c.e(((float) (j2 - j4)) / this.f1115k, 0.0f, 1.0f));
            }
            return c.e(((float) (j2 - j3)) / this.a, 0.0f, 1.0f) * 0.5f;
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f1110f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g2 = g(e(currentAnimationTimeMillis));
                long j2 = currentAnimationTimeMillis - this.f1110f;
                this.f1110f = currentAnimationTimeMillis;
                float f2 = ((float) j2) * g2;
                this.f1111g = (int) (this.f1107c * f2);
                this.f1112h = (int) (f2 * this.f1108d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f1111g;
        }

        public int c() {
            return this.f1112h;
        }

        public int d() {
            float f2 = this.f1107c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f1108d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f1113i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1113i + ((long) this.f1115k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1115k = c.f((int) (currentAnimationTimeMillis - this.f1109e), 0, this.f1106b);
            this.f1114j = e(currentAnimationTimeMillis);
            this.f1113i = currentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f1106b = i2;
        }

        public void k(int i2) {
            this.a = i2;
        }

        public void l(float f2, float f3) {
            this.f1107c = f2;
            this.f1108d = f3;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1109e = currentAnimationTimeMillis;
            this.f1113i = -1L;
            this.f1110f = currentAnimationTimeMillis;
            this.f1114j = 0.5f;
            this.f1111g = 0;
            this.f1112h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.u) {
                if (cVar.s) {
                    cVar.s = false;
                    cVar.f1101g.m();
                }
                a aVar = c.this.f1101g;
                if (!aVar.h() && c.this.u()) {
                    c cVar2 = c.this;
                    if (cVar2.t) {
                        cVar2.t = false;
                        cVar2.c();
                    }
                    aVar.a();
                    c.this.j(aVar.b(), aVar.c());
                    u.a0(c.this.f1103i, this);
                    return;
                }
                c.this.u = false;
            }
        }
    }

    public c(View view) {
        this.f1103i = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f1100f);
        r(500);
        q(500);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float h2 = h(this.f1105k[i2], f3, this.l[i2], f2);
        if (h2 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.o[i2];
        float f6 = this.p[i2];
        float f7 = this.q[i2];
        float f8 = f5 * f4;
        if (h2 > 0.0f) {
            return e(h2 * f8, f6, f7);
        }
        return -e((-h2) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.m;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.u && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float e2 = e(f2 * f3, 0.0f, f4);
        float g2 = g(f3 - f5, e2) - g(f5, e2);
        if (g2 < 0.0f) {
            interpolation = -this.f1102h.getInterpolation(-g2);
        } else {
            if (g2 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f1102h.getInterpolation(g2);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.s) {
            this.u = false;
        } else {
            this.f1101g.i();
        }
    }

    private void v() {
        int i2;
        if (this.f1104j == null) {
            this.f1104j = new b();
        }
        this.u = true;
        this.s = true;
        if (!this.r && (i2 = this.n) > 0) {
            u.b0(this.f1103i, this.f1104j, i2);
        } else {
            this.f1104j.run();
        }
        this.r = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1103i.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public c k(int i2) {
        this.n = i2;
        return this;
    }

    public c l(int i2) {
        this.m = i2;
        return this;
    }

    public c m(boolean z) {
        if (this.v && !z) {
            i();
        }
        this.v = z;
        return this;
    }

    public c n(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public c o(float f2, float f3) {
        float[] fArr = this.q;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.v) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            i();
            return this.w && this.u;
        }
        this.t = true;
        this.r = false;
        this.f1101g.l(d(0, motionEvent.getX(), view.getWidth(), this.f1103i.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f1103i.getHeight()));
        if (!this.u && u()) {
            v();
        }
        if (this.w) {
            return false;
        }
    }

    public c p(float f2, float f3) {
        float[] fArr = this.p;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public c q(int i2) {
        this.f1101g.j(i2);
        return this;
    }

    public c r(int i2) {
        this.f1101g.k(i2);
        return this;
    }

    public c s(float f2, float f3) {
        float[] fArr = this.f1105k;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public c t(float f2, float f3) {
        float[] fArr = this.o;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        a aVar = this.f1101g;
        int f2 = aVar.f();
        int d2 = aVar.d();
        return (f2 != 0 && b(f2)) || (d2 != 0 && a(d2));
    }
}
