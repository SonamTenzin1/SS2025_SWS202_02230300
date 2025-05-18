package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class c0 {
    public static final c0 a;

    /* renamed from: b, reason: collision with root package name */
    private final l f1007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        private static Field a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f1008b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f1009c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f1010d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f1008b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f1009c = declaredField3;
                declaredField3.setAccessible(true);
                f1010d = true;
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        public static c0 a(View view) {
            if (f1010d && view.isAttachedToWindow()) {
                try {
                    Object obj = a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f1008b.get(obj);
                        Rect rect2 = (Rect) f1009c.get(obj);
                        if (rect != null && rect2 != null) {
                            c0 a2 = new b().b(c.i.e.b.c(rect)).c(c.i.e.b.c(rect2)).a();
                            a2.r(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(c0 c0Var) {
            super(c0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class f {
        private final c0 a;

        /* renamed from: b, reason: collision with root package name */
        c.i.e.b[] f1018b;

        f() {
            this(new c0((c0) null));
        }

        protected final void a() {
            c.i.e.b[] bVarArr = this.f1018b;
            if (bVarArr != null) {
                c.i.e.b bVar = bVarArr[m.a(1)];
                c.i.e.b bVar2 = this.f1018b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.a.f(2);
                }
                if (bVar == null) {
                    bVar = this.a.f(1);
                }
                f(c.i.e.b.a(bVar, bVar2));
                c.i.e.b bVar3 = this.f1018b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                c.i.e.b bVar4 = this.f1018b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                c.i.e.b bVar5 = this.f1018b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        c0 b() {
            a();
            return this.a;
        }

        void c(c.i.e.b bVar) {
        }

        void d(c.i.e.b bVar) {
        }

        void e(c.i.e.b bVar) {
        }

        void f(c.i.e.b bVar) {
        }

        void g(c.i.e.b bVar) {
        }

        f(c0 c0Var) {
            this.a = c0Var;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class i extends h {
        i(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        @Override // androidx.core.view.c0.l
        c0 a() {
            return c0.u(this.f1025i.consumeDisplayCutout());
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return c.i.j.c.a(this.f1025i, iVar.f1025i) && c.i.j.c.a(this.m, iVar.m);
        }

        @Override // androidx.core.view.c0.l
        androidx.core.view.c f() {
            return androidx.core.view.c.e(this.f1025i.getDisplayCutout());
        }

        @Override // androidx.core.view.c0.l
        public int hashCode() {
            return this.f1025i.hashCode();
        }

        i(c0 c0Var, i iVar) {
            super(c0Var, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class k extends j {
        static final c0 r = c0.u(WindowInsets.CONSUMED);

        k(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        public c.i.e.b g(int i2) {
            return c.i.e.b.d(this.f1025i.getInsets(n.a(i2)));
        }

        k(c0 c0Var, k kVar) {
            super(c0Var, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class l {
        static final c0 a = new b().a().a().b().c();

        /* renamed from: b, reason: collision with root package name */
        final c0 f1028b;

        l(c0 c0Var) {
            this.f1028b = c0Var;
        }

        c0 a() {
            return this.f1028b;
        }

        c0 b() {
            return this.f1028b;
        }

        c0 c() {
            return this.f1028b;
        }

        void d(View view) {
        }

        void e(c0 c0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && c.i.j.d.a(k(), lVar.k()) && c.i.j.d.a(i(), lVar.i()) && c.i.j.d.a(f(), lVar.f());
        }

        androidx.core.view.c f() {
            return null;
        }

        c.i.e.b g(int i2) {
            return c.i.e.b.a;
        }

        c.i.e.b h() {
            return k();
        }

        public int hashCode() {
            return c.i.j.d.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        c.i.e.b i() {
            return c.i.e.b.a;
        }

        c.i.e.b j() {
            return k();
        }

        c.i.e.b k() {
            return c.i.e.b.a;
        }

        c.i.e.b l() {
            return k();
        }

        c0 m(int i2, int i3, int i4, int i5) {
            return a;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(c.i.e.b[] bVarArr) {
        }

        void q(c.i.e.b bVar) {
        }

        void r(c0 c0Var) {
        }

        public void s(c.i.e.b bVar) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i2) {
            int statusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= statusBars;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a = k.r;
        } else {
            a = l.a;
        }
    }

    private c0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f1007b = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f1007b = new j(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.f1007b = new i(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.f1007b = new h(this, windowInsets);
        } else if (i2 >= 20) {
            this.f1007b = new g(this, windowInsets);
        } else {
            this.f1007b = new l(this);
        }
    }

    static c.i.e.b m(c.i.e.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f3188b - i2);
        int max2 = Math.max(0, bVar.f3189c - i3);
        int max3 = Math.max(0, bVar.f3190d - i4);
        int max4 = Math.max(0, bVar.f3191e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : c.i.e.b.b(max, max2, max3, max4);
    }

    public static c0 u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static c0 v(WindowInsets windowInsets, View view) {
        c0 c0Var = new c0((WindowInsets) c.i.j.i.c(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c0Var.r(u.E(view));
            c0Var.d(view.getRootView());
        }
        return c0Var;
    }

    @Deprecated
    public c0 a() {
        return this.f1007b.a();
    }

    @Deprecated
    public c0 b() {
        return this.f1007b.b();
    }

    @Deprecated
    public c0 c() {
        return this.f1007b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f1007b.d(view);
    }

    public androidx.core.view.c e() {
        return this.f1007b.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return c.i.j.d.a(this.f1007b, ((c0) obj).f1007b);
        }
        return false;
    }

    public c.i.e.b f(int i2) {
        return this.f1007b.g(i2);
    }

    @Deprecated
    public c.i.e.b g() {
        return this.f1007b.i();
    }

    @Deprecated
    public int h() {
        return this.f1007b.k().f3191e;
    }

    public int hashCode() {
        l lVar = this.f1007b;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f1007b.k().f3188b;
    }

    @Deprecated
    public int j() {
        return this.f1007b.k().f3190d;
    }

    @Deprecated
    public int k() {
        return this.f1007b.k().f3189c;
    }

    public c0 l(int i2, int i3, int i4, int i5) {
        return this.f1007b.m(i2, i3, i4, i5);
    }

    public boolean n() {
        return this.f1007b.n();
    }

    @Deprecated
    public c0 o(int i2, int i3, int i4, int i5) {
        return new b(this).c(c.i.e.b.b(i2, i3, i4, i5)).a();
    }

    void p(c.i.e.b[] bVarArr) {
        this.f1007b.p(bVarArr);
    }

    void q(c.i.e.b bVar) {
        this.f1007b.q(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(c0 c0Var) {
        this.f1007b.r(c0Var);
    }

    void s(c.i.e.b bVar) {
        this.f1007b.s(bVar);
    }

    public WindowInsets t() {
        l lVar = this.f1007b;
        if (lVar instanceof g) {
            return ((g) lVar).f1025i;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: c, reason: collision with root package name */
        private static Field f1011c = null;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f1012d = false;

        /* renamed from: e, reason: collision with root package name */
        private static Constructor<WindowInsets> f1013e = null;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f1014f = false;

        /* renamed from: g, reason: collision with root package name */
        private WindowInsets f1015g;

        /* renamed from: h, reason: collision with root package name */
        private c.i.e.b f1016h;

        c() {
            this.f1015g = h();
        }

        private static WindowInsets h() {
            if (!f1012d) {
                try {
                    f1011c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f1012d = true;
            }
            Field field = f1011c;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f1014f) {
                try {
                    f1013e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f1014f = true;
            }
            Constructor<WindowInsets> constructor = f1013e;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // androidx.core.view.c0.f
        c0 b() {
            a();
            c0 u = c0.u(this.f1015g);
            u.p(this.f1018b);
            u.s(this.f1016h);
            return u;
        }

        @Override // androidx.core.view.c0.f
        void d(c.i.e.b bVar) {
            this.f1016h = bVar;
        }

        @Override // androidx.core.view.c0.f
        void f(c.i.e.b bVar) {
            WindowInsets windowInsets = this.f1015g;
            if (windowInsets != null) {
                this.f1015g = windowInsets.replaceSystemWindowInsets(bVar.f3188b, bVar.f3189c, bVar.f3190d, bVar.f3191e);
            }
        }

        c(c0 c0Var) {
            super(c0Var);
            this.f1015g = c0Var.t();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f1017c;

        d() {
            this.f1017c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.c0.f
        c0 b() {
            a();
            c0 u = c0.u(this.f1017c.build());
            u.p(this.f1018b);
            return u;
        }

        @Override // androidx.core.view.c0.f
        void c(c.i.e.b bVar) {
            this.f1017c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void d(c.i.e.b bVar) {
            this.f1017c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void e(c.i.e.b bVar) {
            this.f1017c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void f(c.i.e.b bVar) {
            this.f1017c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void g(c.i.e.b bVar) {
            this.f1017c.setTappableElementInsets(bVar.e());
        }

        d(c0 c0Var) {
            super(c0Var);
            WindowInsets.Builder builder;
            WindowInsets t = c0Var.t();
            if (t != null) {
                builder = new WindowInsets.Builder(t);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f1017c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class h extends g {
        private c.i.e.b n;

        h(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.n = null;
        }

        @Override // androidx.core.view.c0.l
        c0 b() {
            return c0.u(this.f1025i.consumeStableInsets());
        }

        @Override // androidx.core.view.c0.l
        c0 c() {
            return c0.u(this.f1025i.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.c0.l
        final c.i.e.b i() {
            if (this.n == null) {
                this.n = c.i.e.b.b(this.f1025i.getStableInsetLeft(), this.f1025i.getStableInsetTop(), this.f1025i.getStableInsetRight(), this.f1025i.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // androidx.core.view.c0.l
        boolean n() {
            return this.f1025i.isConsumed();
        }

        @Override // androidx.core.view.c0.l
        public void s(c.i.e.b bVar) {
            this.n = bVar;
        }

        h(c0 c0Var, h hVar) {
            super(c0Var, hVar);
            this.n = null;
            this.n = hVar.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class g extends l {

        /* renamed from: c, reason: collision with root package name */
        private static boolean f1019c = false;

        /* renamed from: d, reason: collision with root package name */
        private static Method f1020d;

        /* renamed from: e, reason: collision with root package name */
        private static Class<?> f1021e;

        /* renamed from: f, reason: collision with root package name */
        private static Class<?> f1022f;

        /* renamed from: g, reason: collision with root package name */
        private static Field f1023g;

        /* renamed from: h, reason: collision with root package name */
        private static Field f1024h;

        /* renamed from: i, reason: collision with root package name */
        final WindowInsets f1025i;

        /* renamed from: j, reason: collision with root package name */
        private c.i.e.b[] f1026j;

        /* renamed from: k, reason: collision with root package name */
        private c.i.e.b f1027k;
        private c0 l;
        c.i.e.b m;

        g(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var);
            this.f1027k = null;
            this.f1025i = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private c.i.e.b t(int i2, boolean z) {
            c.i.e.b bVar = c.i.e.b.a;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    bVar = c.i.e.b.a(bVar, u(i3, z));
                }
            }
            return bVar;
        }

        private c.i.e.b v() {
            c0 c0Var = this.l;
            if (c0Var != null) {
                return c0Var.g();
            }
            return c.i.e.b.a;
        }

        private c.i.e.b w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f1019c) {
                    x();
                }
                Method method = f1020d;
                if (method != null && f1022f != null && f1023g != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f1023g.get(f1024h.get(invoke));
                        if (rect != null) {
                            return c.i.e.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f1020d = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f1021e = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f1022f = cls;
                f1023g = cls.getDeclaredField("mVisibleInsets");
                f1024h = f1021e.getDeclaredField("mAttachInfo");
                f1023g.setAccessible(true);
                f1024h.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f1019c = true;
        }

        @Override // androidx.core.view.c0.l
        void d(View view) {
            c.i.e.b w = w(view);
            if (w == null) {
                w = c.i.e.b.a;
            }
            q(w);
        }

        @Override // androidx.core.view.c0.l
        void e(c0 c0Var) {
            c0Var.r(this.l);
            c0Var.q(this.m);
        }

        @Override // androidx.core.view.c0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return c.i.j.c.a(this.m, ((g) obj).m);
            }
            return false;
        }

        @Override // androidx.core.view.c0.l
        public c.i.e.b g(int i2) {
            return t(i2, false);
        }

        @Override // androidx.core.view.c0.l
        final c.i.e.b k() {
            if (this.f1027k == null) {
                this.f1027k = c.i.e.b.b(this.f1025i.getSystemWindowInsetLeft(), this.f1025i.getSystemWindowInsetTop(), this.f1025i.getSystemWindowInsetRight(), this.f1025i.getSystemWindowInsetBottom());
            }
            return this.f1027k;
        }

        @Override // androidx.core.view.c0.l
        c0 m(int i2, int i3, int i4, int i5) {
            b bVar = new b(c0.u(this.f1025i));
            bVar.c(c0.m(k(), i2, i3, i4, i5));
            bVar.b(c0.m(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // androidx.core.view.c0.l
        boolean o() {
            return this.f1025i.isRound();
        }

        @Override // androidx.core.view.c0.l
        public void p(c.i.e.b[] bVarArr) {
            this.f1026j = bVarArr;
        }

        @Override // androidx.core.view.c0.l
        void q(c.i.e.b bVar) {
            this.m = bVar;
        }

        @Override // androidx.core.view.c0.l
        void r(c0 c0Var) {
            this.l = c0Var;
        }

        protected c.i.e.b u(int i2, boolean z) {
            c.i.e.b g2;
            int i3;
            androidx.core.view.c f2;
            if (i2 == 1) {
                if (z) {
                    return c.i.e.b.b(0, Math.max(v().f3189c, k().f3189c), 0, 0);
                }
                return c.i.e.b.b(0, k().f3189c, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    c.i.e.b v = v();
                    c.i.e.b i4 = i();
                    return c.i.e.b.b(Math.max(v.f3188b, i4.f3188b), 0, Math.max(v.f3190d, i4.f3190d), Math.max(v.f3191e, i4.f3191e));
                }
                c.i.e.b k2 = k();
                c0 c0Var = this.l;
                g2 = c0Var != null ? c0Var.g() : null;
                int i5 = k2.f3191e;
                if (g2 != null) {
                    i5 = Math.min(i5, g2.f3191e);
                }
                return c.i.e.b.b(k2.f3188b, 0, k2.f3190d, i5);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return j();
                }
                if (i2 == 32) {
                    return h();
                }
                if (i2 == 64) {
                    return l();
                }
                if (i2 != 128) {
                    return c.i.e.b.a;
                }
                c0 c0Var2 = this.l;
                if (c0Var2 != null) {
                    f2 = c0Var2.e();
                } else {
                    f2 = f();
                }
                if (f2 != null) {
                    return c.i.e.b.b(f2.b(), f2.d(), f2.c(), f2.a());
                }
                return c.i.e.b.a;
            }
            c.i.e.b[] bVarArr = this.f1026j;
            g2 = bVarArr != null ? bVarArr[m.a(8)] : null;
            if (g2 != null) {
                return g2;
            }
            c.i.e.b k3 = k();
            c.i.e.b v2 = v();
            int i6 = k3.f3191e;
            if (i6 > v2.f3191e) {
                return c.i.e.b.b(0, 0, 0, i6);
            }
            c.i.e.b bVar = this.m;
            if (bVar != null && !bVar.equals(c.i.e.b.a) && (i3 = this.m.f3191e) > v2.f3191e) {
                return c.i.e.b.b(0, 0, 0, i3);
            }
            return c.i.e.b.a;
        }

        g(c0 c0Var, g gVar) {
            this(c0Var, new WindowInsets(gVar.f1025i));
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class j extends i {
        private c.i.e.b o;
        private c.i.e.b p;
        private c.i.e.b q;

        j(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // androidx.core.view.c0.l
        c.i.e.b h() {
            if (this.p == null) {
                this.p = c.i.e.b.d(this.f1025i.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // androidx.core.view.c0.l
        c.i.e.b j() {
            if (this.o == null) {
                this.o = c.i.e.b.d(this.f1025i.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // androidx.core.view.c0.l
        c.i.e.b l() {
            if (this.q == null) {
                this.q = c.i.e.b.d(this.f1025i.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        c0 m(int i2, int i3, int i4, int i5) {
            return c0.u(this.f1025i.inset(i2, i3, i4, i5));
        }

        @Override // androidx.core.view.c0.h, androidx.core.view.c0.l
        public void s(c.i.e.b bVar) {
        }

        j(c0 c0Var, j jVar) {
            super(c0Var, jVar);
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final f a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new e();
                return;
            }
            if (i2 >= 29) {
                this.a = new d();
            } else if (i2 >= 20) {
                this.a = new c();
            } else {
                this.a = new f();
            }
        }

        public c0 a() {
            return this.a.b();
        }

        @Deprecated
        public b b(c.i.e.b bVar) {
            this.a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(c.i.e.b bVar) {
            this.a.f(bVar);
            return this;
        }

        public b(c0 c0Var) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new e(c0Var);
                return;
            }
            if (i2 >= 29) {
                this.a = new d(c0Var);
            } else if (i2 >= 20) {
                this.a = new c(c0Var);
            } else {
                this.a = new f(c0Var);
            }
        }
    }

    public c0(c0 c0Var) {
        if (c0Var != null) {
            l lVar = c0Var.f1007b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (lVar instanceof k)) {
                this.f1007b = new k(this, (k) lVar);
            } else if (i2 >= 29 && (lVar instanceof j)) {
                this.f1007b = new j(this, (j) lVar);
            } else if (i2 >= 28 && (lVar instanceof i)) {
                this.f1007b = new i(this, (i) lVar);
            } else if (i2 >= 21 && (lVar instanceof h)) {
                this.f1007b = new h(this, (h) lVar);
            } else if (i2 >= 20 && (lVar instanceof g)) {
                this.f1007b = new g(this, (g) lVar);
            } else {
                this.f1007b = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f1007b = new l(this);
    }
}
