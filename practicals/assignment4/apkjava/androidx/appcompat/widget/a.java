package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    protected final C0012a f470f;

    /* renamed from: g, reason: collision with root package name */
    protected final Context f471g;

    /* renamed from: h, reason: collision with root package name */
    protected ActionMenuView f472h;

    /* renamed from: i, reason: collision with root package name */
    protected ActionMenuPresenter f473i;

    /* renamed from: j, reason: collision with root package name */
    protected int f474j;

    /* renamed from: k, reason: collision with root package name */
    protected androidx.core.view.y f475k;
    private boolean l;
    private boolean m;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0012a implements androidx.core.view.z {
        private boolean a = false;

        /* renamed from: b, reason: collision with root package name */
        int f476b;

        protected C0012a() {
        }

        public C0012a a(androidx.core.view.y yVar, int i2) {
            a.this.f475k = yVar;
            this.f476b = i2;
            return this;
        }

        @Override // androidx.core.view.z
        public void onAnimationCancel(View view) {
            this.a = true;
        }

        @Override // androidx.core.view.z
        public void onAnimationEnd(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.f475k = null;
            a.super.setVisibility(this.f476b);
        }

        @Override // androidx.core.view.z
        public void onAnimationStart(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.y f(int i2, long j2) {
        androidx.core.view.y yVar = this.f475k;
        if (yVar != null) {
            yVar.b();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.view.y a = androidx.core.view.u.c(this).a(1.0f);
            a.d(j2);
            a.f(this.f470f.a(a, i2));
            return a;
        }
        androidx.core.view.y a2 = androidx.core.view.u.c(this).a(0.0f);
        a2.d(j2);
        a2.f(this.f470f.a(a2, i2));
        return a2;
    }

    public int getAnimatedVisibility() {
        if (this.f475k != null) {
            return this.f470f.f476b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f474j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.j.a, c.a.a.f2686c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(c.a.j.f2764j, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f473i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.m = false;
        }
        if (!this.m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.l = false;
        }
        if (!this.l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            androidx.core.view.y yVar = this.f475k;
            if (yVar != null) {
                yVar.b();
            }
            super.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f470f = new C0012a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(c.a.a.a, typedValue, true) && typedValue.resourceId != 0) {
            this.f471g = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f471g = context;
        }
    }
}
