package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.m;
import androidx.core.view.c0;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements w, androidx.core.view.n, androidx.core.view.l, androidx.core.view.m {

    /* renamed from: f, reason: collision with root package name */
    static final int[] f366f = {c.a.a.f2685b, R.attr.windowContentOverlay};
    private androidx.core.view.c0 A;
    private androidx.core.view.c0 B;
    private androidx.core.view.c0 C;
    private androidx.core.view.c0 D;
    private d E;
    private OverScroller F;
    ViewPropertyAnimator G;
    final AnimatorListenerAdapter H;
    private final Runnable I;
    private final Runnable J;
    private final androidx.core.view.o K;

    /* renamed from: g, reason: collision with root package name */
    private int f367g;

    /* renamed from: h, reason: collision with root package name */
    private int f368h;

    /* renamed from: i, reason: collision with root package name */
    private ContentFrameLayout f369i;

    /* renamed from: j, reason: collision with root package name */
    ActionBarContainer f370j;

    /* renamed from: k, reason: collision with root package name */
    private x f371k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    boolean q;
    private int r;
    private int s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private final Rect x;
    private final Rect y;
    private final Rect z;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.G = null;
            actionBarOverlayLayout.q = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.G = null;
            actionBarOverlayLayout.q = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.G = actionBarOverlayLayout.f370j.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.H);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.G = actionBarOverlayLayout.f370j.animate().translationY(-ActionBarOverlayLayout.this.f370j.getHeight()).setListener(ActionBarOverlayLayout.this.H);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(boolean z);

        void d();

        void e();

        void onWindowVisibilityChanged(int i2);
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f368h = 0;
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = new Rect();
        this.y = new Rect();
        this.z = new Rect();
        androidx.core.view.c0 c0Var = androidx.core.view.c0.a;
        this.A = c0Var;
        this.B = c0Var;
        this.C = c0Var;
        this.D = c0Var;
        this.H = new a();
        this.I = new b();
        this.J = new c();
        v(context);
        this.K = new androidx.core.view.o(this);
    }

    private void A() {
        u();
        this.I.run();
    }

    private boolean B(float f2) {
        this.F.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.F.getFinalY() > this.f370j.getHeight();
    }

    private void p() {
        u();
        this.J.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        e eVar = (e) view.getLayoutParams();
        if (z) {
            int i2 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i3 = rect.left;
            if (i2 != i3) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i3;
                z5 = true;
                if (z2) {
                    int i4 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    int i5 = rect.top;
                    if (i4 != i5) {
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = i5;
                        z5 = true;
                    }
                }
                if (z4) {
                    int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                    int i7 = rect.right;
                    if (i6 != i7) {
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i7;
                        z5 = true;
                    }
                }
                if (z3) {
                    int i8 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    int i9 = rect.bottom;
                    if (i8 != i9) {
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i9;
                        return true;
                    }
                }
                return z5;
            }
        }
        z5 = false;
        if (z2) {
        }
        if (z4) {
        }
        if (z3) {
        }
        return z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x t(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f366f);
        this.f367g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.l = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.m = context.getApplicationInfo().targetSdkVersion < 19;
        this.F = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.J, 600L);
    }

    private void y() {
        u();
        postDelayed(this.I, 600L);
    }

    @Override // androidx.appcompat.widget.w
    public void a(Menu menu, m.a aVar) {
        z();
        this.f371k.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.w
    public boolean b() {
        z();
        return this.f371k.b();
    }

    @Override // androidx.appcompat.widget.w
    public void c() {
        z();
        this.f371k.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.w
    public boolean d() {
        z();
        return this.f371k.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.l == null || this.m) {
            return;
        }
        int bottom = this.f370j.getVisibility() == 0 ? (int) (this.f370j.getBottom() + this.f370j.getTranslationY() + 0.5f) : 0;
        this.l.setBounds(0, bottom, getWidth(), this.l.getIntrinsicHeight() + bottom);
        this.l.draw(canvas);
    }

    @Override // androidx.appcompat.widget.w
    public boolean e() {
        z();
        return this.f371k.e();
    }

    @Override // androidx.appcompat.widget.w
    public boolean f() {
        z();
        return this.f371k.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean q = q(this.f370j, rect, true, true, false, true);
        this.w.set(rect);
        w0.a(this, this.w, this.t);
        if (!this.x.equals(this.w)) {
            this.x.set(this.w);
            q = true;
        }
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            q = true;
        }
        if (q) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.w
    public boolean g() {
        z();
        return this.f371k.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f370j;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.K.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f371k.getTitle();
    }

    @Override // androidx.appcompat.widget.w
    public void h(int i2) {
        z();
        if (i2 == 2) {
            this.f371k.u();
        } else if (i2 == 5) {
            this.f371k.v();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.w
    public void i() {
        z();
        this.f371k.h();
    }

    @Override // androidx.core.view.m
    public void j(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        k(view, i2, i3, i4, i5, i6);
    }

    @Override // androidx.core.view.l
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.l
    public boolean l(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // androidx.core.view.l
    public void m(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.l
    public void n(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.l
    public void o(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        androidx.core.view.c0 u = androidx.core.view.c0.u(windowInsets);
        boolean q = q(this.f370j, new Rect(u.i(), u.k(), u.j(), u.h()), true, true, false, true);
        androidx.core.view.u.f(this, u, this.t);
        Rect rect = this.t;
        androidx.core.view.c0 l = u.l(rect.left, rect.top, rect.right, rect.bottom);
        this.A = l;
        boolean z = true;
        if (!this.B.equals(l)) {
            this.B = this.A;
            q = true;
        }
        if (this.u.equals(this.t)) {
            z = q;
        } else {
            this.u.set(this.t);
        }
        if (z) {
            requestLayout();
        }
        return u.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        androidx.core.view.u.f0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        z();
        measureChildWithMargins(this.f370j, i2, 0, i3, 0);
        e eVar = (e) this.f370j.getLayoutParams();
        int max = Math.max(0, this.f370j.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f370j.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f370j.getMeasuredState());
        boolean z = (androidx.core.view.u.H(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f367g;
            if (this.o && this.f370j.getTabContainer() != null) {
                measuredHeight += this.f367g;
            }
        } else {
            measuredHeight = this.f370j.getVisibility() != 8 ? this.f370j.getMeasuredHeight() : 0;
        }
        this.v.set(this.t);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            this.C = this.A;
        } else {
            this.y.set(this.w);
        }
        if (!this.n && !z) {
            Rect rect = this.v;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i4 >= 21) {
                this.C = this.C.l(0, measuredHeight, 0, 0);
            }
        } else if (i4 >= 21) {
            this.C = new c0.b(this.C).c(c.i.e.b.b(this.C.i(), this.C.k() + measuredHeight, this.C.j(), this.C.h() + 0)).a();
        } else {
            Rect rect2 = this.y;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        q(this.f369i, this.v, true, true, true, true);
        if (i4 >= 21 && !this.D.equals(this.C)) {
            androidx.core.view.c0 c0Var = this.C;
            this.D = c0Var;
            androidx.core.view.u.g(this.f369i, c0Var);
        } else if (i4 < 21 && !this.z.equals(this.y)) {
            this.z.set(this.y);
            this.f369i.a(this.y);
        }
        measureChildWithMargins(this.f369i, i2, 0, i3, 0);
        e eVar2 = (e) this.f369i.getLayoutParams();
        int max3 = Math.max(max, this.f369i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f369i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f369i.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.p || !z) {
            return false;
        }
        if (B(f3)) {
            p();
        } else {
            A();
        }
        this.q = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.r + i3;
        this.r = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.K.b(view, view2, i2);
        this.r = getActionBarHideOffset();
        u();
        d dVar = this.E;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f370j.getVisibility() != 0) {
            return false;
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onStopNestedScroll(View view) {
        if (this.p && !this.q) {
            if (this.r <= this.f370j.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.E;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        z();
        int i3 = this.s ^ i2;
        this.s = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & 256) != 0;
        d dVar = this.E;
        if (dVar != null) {
            dVar.c(!z2);
            if (!z && z2) {
                this.E.d();
            } else {
                this.E.a();
            }
        }
        if ((i3 & 256) == 0 || this.E == null) {
            return;
        }
        androidx.core.view.u.f0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f368h = i2;
        d dVar = this.E;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i2) {
        u();
        this.f370j.setTranslationY(-Math.max(0, Math.min(i2, this.f370j.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.E = dVar;
        if (getWindowToken() != null) {
            this.E.onWindowVisibilityChanged(this.f368h);
            int i2 = this.s;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                androidx.core.view.u.f0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.o = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.p) {
            this.p = z;
            if (z) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        z();
        this.f371k.setIcon(i2);
    }

    public void setLogo(int i2) {
        z();
        this.f371k.m(i2);
    }

    public void setOverlayMode(boolean z) {
        this.n = z;
        this.m = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f371k.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f371k.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.I);
        removeCallbacks(this.J);
        ViewPropertyAnimator viewPropertyAnimator = this.G;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.n;
    }

    void z() {
        if (this.f369i == null) {
            this.f369i = (ContentFrameLayout) findViewById(c.a.f.f2722b);
            this.f370j = (ActionBarContainer) findViewById(c.a.f.f2723c);
            this.f371k = t(findViewById(c.a.f.a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f371k.setIcon(drawable);
    }
}
