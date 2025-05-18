package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.g0;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class h {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private static h f531b;

    /* renamed from: c, reason: collision with root package name */
    private g0 f532c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public class a implements g0.e {
        private final int[] a = {c.a.e.S, c.a.e.Q, c.a.e.a};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f533b = {c.a.e.o, c.a.e.B, c.a.e.t, c.a.e.p, c.a.e.q, c.a.e.s, c.a.e.r};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f534c = {c.a.e.P, c.a.e.R, c.a.e.f2721k, c.a.e.I, c.a.e.J, c.a.e.L, c.a.e.N, c.a.e.K, c.a.e.M, c.a.e.O};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f535d = {c.a.e.w, c.a.e.f2719i, c.a.e.v};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f536e = {c.a.e.H, c.a.e.T};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f537f = {c.a.e.f2713c, c.a.e.f2717g, c.a.e.f2714d, c.a.e.f2718h};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int c2 = l0.c(context, c.a.a.v);
            return new ColorStateList(new int[][]{l0.f576b, l0.f579e, l0.f577c, l0.f583i}, new int[]{l0.b(context, c.a.a.t), c.i.e.a.j(c2, i2), c.i.e.a.j(c2, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, l0.c(context, c.a.a.s));
        }

        private ColorStateList j(Context context) {
            return h(context, l0.c(context, c.a.a.t));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i2 = c.a.a.y;
            ColorStateList e2 = l0.e(context, i2);
            if (e2 != null && e2.isStateful()) {
                iArr[0] = l0.f576b;
                iArr2[0] = e2.getColorForState(iArr[0], 0);
                iArr[1] = l0.f580f;
                iArr2[1] = l0.c(context, c.a.a.u);
                iArr[2] = l0.f583i;
                iArr2[2] = e2.getDefaultColor();
            } else {
                iArr[0] = l0.f576b;
                iArr2[0] = l0.b(context, i2);
                iArr[1] = l0.f580f;
                iArr2[1] = l0.c(context, c.a.a.u);
                iArr[2] = l0.f583i;
                iArr2[2] = l0.c(context, i2);
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (y.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = h.a;
            }
            drawable.setColorFilter(h.e(i2, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        @Override // androidx.appcompat.widget.g0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(Context context, int i2, Drawable drawable) {
            int i3;
            boolean z;
            PorterDuff.Mode mode = h.a;
            boolean f2 = f(this.a, i2);
            int i4 = R.attr.colorBackground;
            if (f2) {
                i4 = c.a.a.w;
            } else if (f(this.f534c, i2)) {
                i4 = c.a.a.u;
            } else if (f(this.f535d, i2)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else {
                if (i2 == c.a.e.u) {
                    i4 = R.attr.colorForeground;
                    i3 = Math.round(40.8f);
                    z = true;
                    if (!z) {
                        return false;
                    }
                    if (y.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(h.e(l0.c(context, i4), mode));
                    if (i3 != -1) {
                        drawable.setAlpha(i3);
                    }
                    return true;
                }
                if (i2 != c.a.e.l) {
                    i3 = -1;
                    z = false;
                    i4 = 0;
                    if (!z) {
                    }
                }
            }
            i3 = -1;
            z = true;
            if (!z) {
            }
        }

        @Override // androidx.appcompat.widget.g0.e
        public PorterDuff.Mode b(int i2) {
            if (i2 == c.a.e.F) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public Drawable c(g0 g0Var, Context context, int i2) {
            if (i2 == c.a.e.f2720j) {
                return new LayerDrawable(new Drawable[]{g0Var.j(context, c.a.e.f2719i), g0Var.j(context, c.a.e.f2721k)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public ColorStateList d(Context context, int i2) {
            if (i2 == c.a.e.m) {
                return c.a.k.a.a.c(context, c.a.c.f2698e);
            }
            if (i2 == c.a.e.G) {
                return c.a.k.a.a.c(context, c.a.c.f2701h);
            }
            if (i2 == c.a.e.F) {
                return k(context);
            }
            if (i2 == c.a.e.f2716f) {
                return j(context);
            }
            if (i2 == c.a.e.f2712b) {
                return g(context);
            }
            if (i2 == c.a.e.f2715e) {
                return i(context);
            }
            if (i2 != c.a.e.D && i2 != c.a.e.E) {
                if (f(this.f533b, i2)) {
                    return l0.e(context, c.a.a.w);
                }
                if (f(this.f536e, i2)) {
                    return c.a.k.a.a.c(context, c.a.c.f2697d);
                }
                if (f(this.f537f, i2)) {
                    return c.a.k.a.a.c(context, c.a.c.f2696c);
                }
                if (i2 == c.a.e.A) {
                    return c.a.k.a.a.c(context, c.a.c.f2699f);
                }
                return null;
            }
            return c.a.k.a.a.c(context, c.a.c.f2700g);
        }

        @Override // androidx.appcompat.widget.g0.e
        public boolean e(Context context, int i2, Drawable drawable) {
            if (i2 == c.a.e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i3 = c.a.a.w;
                l(findDrawableByLayerId, l0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), l0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(R.id.progress), l0.c(context, c.a.a.u), h.a);
                return true;
            }
            if (i2 != c.a.e.y && i2 != c.a.e.x && i2 != c.a.e.z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            l(layerDrawable2.findDrawableByLayerId(R.id.background), l0.b(context, c.a.a.w), h.a);
            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i4 = c.a.a.u;
            l(findDrawableByLayerId2, l0.c(context, i4), h.a);
            l(layerDrawable2.findDrawableByLayerId(R.id.progress), l0.c(context, i4), h.a);
            return true;
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f531b == null) {
                h();
            }
            hVar = f531b;
        }
        return hVar;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (h.class) {
            l = g0.l(i2, mode);
        }
        return l;
    }

    public static synchronized void h() {
        synchronized (h.class) {
            if (f531b == null) {
                h hVar = new h();
                f531b = hVar;
                hVar.f532c = g0.h();
                f531b.f532c.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, o0 o0Var, int[] iArr) {
        g0.w(drawable, o0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f532c.j(context, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i2, boolean z) {
        return this.f532c.k(context, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i2) {
        return this.f532c.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f532c.s(context);
    }
}
