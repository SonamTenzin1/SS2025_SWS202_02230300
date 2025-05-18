package c.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends m {
    private static final String[] P = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> Q = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> R = new C0101c(PointF.class, "topLeft");
    private static final Property<k, PointF> S = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> T = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> U = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> V = new g(PointF.class, "position");
    private static c.x.k W = new c.x.k();
    private int[] X = new int[2];
    private boolean Y = false;
    private boolean Z = false;

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f3525b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3526c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f3527d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.a = viewGroup;
            this.f3525b = bitmapDrawable;
            this.f3526c = view;
            this.f3527d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.a).b(this.f3525b);
            c0.g(this.f3526c, this.f3527d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: c.x.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0101c extends Property<k, PointF> {
        C0101c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(k kVar) {
            this.a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3530b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f3531c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3532d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3533e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3534f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3535g;

        i(View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f3530b = view;
            this.f3531c = rect;
            this.f3532d = i2;
            this.f3533e = i3;
            this.f3534f = i4;
            this.f3535g = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            androidx.core.view.u.p0(this.f3530b, this.f3531c);
            c0.f(this.f3530b, this.f3532d, this.f3533e, this.f3534f, this.f3535g);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class j extends n {
        boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3537b;

        j(ViewGroup viewGroup) {
            this.f3537b = viewGroup;
        }

        @Override // c.x.n, c.x.m.f
        public void b(m mVar) {
            x.c(this.f3537b, false);
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            if (!this.a) {
                x.c(this.f3537b, false);
            }
            mVar.T(this);
        }

        @Override // c.x.n, c.x.m.f
        public void d(m mVar) {
            x.c(this.f3537b, false);
            this.a = true;
        }

        @Override // c.x.n, c.x.m.f
        public void e(m mVar) {
            x.c(this.f3537b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class k {
        private int a;

        /* renamed from: b, reason: collision with root package name */
        private int f3539b;

        /* renamed from: c, reason: collision with root package name */
        private int f3540c;

        /* renamed from: d, reason: collision with root package name */
        private int f3541d;

        /* renamed from: e, reason: collision with root package name */
        private View f3542e;

        /* renamed from: f, reason: collision with root package name */
        private int f3543f;

        /* renamed from: g, reason: collision with root package name */
        private int f3544g;

        k(View view) {
            this.f3542e = view;
        }

        private void b() {
            c0.f(this.f3542e, this.a, this.f3539b, this.f3540c, this.f3541d);
            this.f3543f = 0;
            this.f3544g = 0;
        }

        void a(PointF pointF) {
            this.f3540c = Math.round(pointF.x);
            this.f3541d = Math.round(pointF.y);
            int i2 = this.f3544g + 1;
            this.f3544g = i2;
            if (this.f3543f == i2) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.f3539b = Math.round(pointF.y);
            int i2 = this.f3543f + 1;
            this.f3543f = i2;
            if (i2 == this.f3544g) {
                b();
            }
        }
    }

    private void k0(s sVar) {
        View view = sVar.f3608b;
        if (!androidx.core.view.u.O(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.a.put("android:changeBounds:parent", sVar.f3608b.getParent());
        if (this.Z) {
            sVar.f3608b.getLocationInWindow(this.X);
            sVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.X[0]));
            sVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.X[1]));
        }
        if (this.Y) {
            sVar.a.put("android:changeBounds:clip", androidx.core.view.u.r(view));
        }
    }

    private boolean l0(View view, View view2) {
        if (!this.Z) {
            return true;
        }
        s u = u(view, true);
        if (u == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == u.f3608b) {
            return true;
        }
        return false;
    }

    @Override // c.x.m
    public String[] H() {
        return P;
    }

    @Override // c.x.m
    public void h(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public void k(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.a;
        Map<String, Object> map2 = sVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f3608b;
        if (l0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) sVar.a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.Y) {
                view = view2;
                c0.f(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        c2 = c.x.f.a(view, V, w().a(i4, i6, i5, i7));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a2 = c.x.f.a(kVar, R, w().a(i4, i6, i5, i7));
                        ObjectAnimator a3 = c.x.f.a(kVar, S, w().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a2, a3);
                        animatorSet.addListener(new h(kVar));
                        c2 = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    c2 = c.x.f.a(view, T, w().a(i8, i10, i9, i11));
                } else {
                    c2 = c.x.f.a(view, U, w().a(i4, i6, i5, i7));
                }
            } else {
                view = view2;
                c0.f(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a4 = (i4 == i5 && i6 == i7) ? null : c.x.f.a(view, V, w().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    androidx.core.view.u.p0(view, rect);
                    c.x.k kVar2 = W;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar2, objArr);
                    ofObject.addListener(new i(view, rect5, i5, i7, i9, i11));
                    objectAnimator = ofObject;
                }
                c2 = r.c(a4, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                b(new j(viewGroup4));
            }
            return c2;
        }
        int intValue = ((Integer) sVar.a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar.a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar2.a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar2.a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.X);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c3 = c0.c(view2);
        c0.g(view2, 0.0f);
        c0.b(viewGroup).a(bitmapDrawable);
        c.x.g w = w();
        int[] iArr = this.X;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, c.x.i.a(Q, w.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c3));
        return ofPropertyValuesHolder;
    }
}
