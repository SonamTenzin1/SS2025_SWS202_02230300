package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import e.e.b.c.a0.k;
import e.e.b.c.a0.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BorderDrawable.java */
/* loaded from: classes2.dex */
public class a extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private final Paint f18642b;

    /* renamed from: h, reason: collision with root package name */
    float f18648h;

    /* renamed from: i, reason: collision with root package name */
    private int f18649i;

    /* renamed from: j, reason: collision with root package name */
    private int f18650j;

    /* renamed from: k, reason: collision with root package name */
    private int f18651k;
    private int l;
    private int m;
    private k o;
    private ColorStateList p;
    private final l a = new l();

    /* renamed from: c, reason: collision with root package name */
    private final Path f18643c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f18644d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f18645e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f18646f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final b f18647g = new b();
    private boolean n = true;

    /* compiled from: BorderDrawable.java */
    /* loaded from: classes2.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return a.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(k kVar) {
        this.o = kVar;
        Paint paint = new Paint(1);
        this.f18642b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        copyBounds(this.f18644d);
        float height = this.f18648h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{c.i.e.a.j(this.f18649i, this.m), c.i.e.a.j(this.f18650j, this.m), c.i.e.a.j(c.i.e.a.o(this.f18650j, 0), this.m), c.i.e.a.j(c.i.e.a.o(this.l, 0), this.m), c.i.e.a.j(this.l, this.m), c.i.e.a.j(this.f18651k, this.m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f18646f.set(getBounds());
        return this.f18646f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    public void d(float f2) {
        if (this.f18648h != f2) {
            this.f18648h = f2;
            this.f18642b.setStrokeWidth(f2 * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            this.f18642b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.f18642b.getStrokeWidth() / 2.0f;
        copyBounds(this.f18644d);
        this.f18645e.set(this.f18644d);
        float min = Math.min(this.o.r().a(b()), this.f18645e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f18645e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f18645e, min, min, this.f18642b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i2, int i3, int i4, int i5) {
        this.f18649i = i2;
        this.f18650j = i3;
        this.f18651k = i4;
        this.l = i5;
    }

    public void f(k kVar) {
        this.o = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f18647g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f18648h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f18644d);
        this.f18645e.set(this.f18644d);
        this.a.d(this.o, 1.0f, this.f18645e, this.f18643c);
        if (this.f18643c.isConvex()) {
            outline.setConvexPath(this.f18643c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.o.u(b())) {
            return true;
        }
        int round = Math.round(this.f18648h);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f18642b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f18642b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
