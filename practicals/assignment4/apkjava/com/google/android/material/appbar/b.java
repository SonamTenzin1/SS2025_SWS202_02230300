package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.c0;
import androidx.core.view.u;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes2.dex */
public abstract class b extends c<View> {

    /* renamed from: d, reason: collision with root package name */
    final Rect f18395d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f18396e;

    /* renamed from: f, reason: collision with root package name */
    private int f18397f;

    /* renamed from: g, reason: collision with root package name */
    private int f18398g;

    public b() {
        this.f18395d = new Rect();
        this.f18396e = new Rect();
        this.f18397f = 0;
    }

    private static int N(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void F(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View H = H(coordinatorLayout.r(view));
        if (H != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f18395d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            c0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.v(coordinatorLayout) && !u.v(view)) {
                rect.left += lastWindowInsets.i();
                rect.right -= lastWindowInsets.j();
            }
            Rect rect2 = this.f18396e;
            androidx.core.view.d.a(N(fVar.f821c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f18397f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view, i2);
        this.f18397f = 0;
    }

    abstract View H(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f18398g == 0) {
            return 0;
        }
        float J = J(view);
        int i2 = this.f18398g;
        return c.i.g.a.b((int) (J * i2), 0, i2);
    }

    abstract float J(View view);

    public final int K() {
        return this.f18398g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M() {
        return this.f18397f;
    }

    public final void O(int i2) {
        this.f18398g = i2;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View H;
        c0 lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (H = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size > 0) {
            if (u.v(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.k() + lastWindowInsets.h();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            L -= measuredHeight;
        }
        coordinatorLayout.J(view, i2, i3, View.MeasureSpec.makeMeasureSpec(L, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18395d = new Rect();
        this.f18396e = new Rect();
        this.f18397f = 0;
    }
}
