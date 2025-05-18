package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f678f = {R.attr.colorBackground};

    /* renamed from: g, reason: collision with root package name */
    private static final e f679g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f680h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f681i;

    /* renamed from: j, reason: collision with root package name */
    int f682j;

    /* renamed from: k, reason: collision with root package name */
    int f683k;
    final Rect l;
    final Rect m;
    private final d n;

    /* loaded from: classes.dex */
    class a implements d {
        private Drawable a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.m.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.l;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void b(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f682j) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f683k) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.d
        public void c(Drawable drawable) {
            this.a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable f() {
            return this.a;
        }

        @Override // androidx.cardview.widget.d
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f679g = new b();
        } else if (i2 >= 17) {
            f679g = new androidx.cardview.widget.a();
        } else {
            f679g = new c();
        }
        f679g.j();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.d.a.a);
    }

    public void f(int i2, int i3, int i4, int i5) {
        this.l.set(i2, i3, i4, i5);
        f679g.i(this.n);
    }

    public ColorStateList getCardBackgroundColor() {
        return f679g.h(this.n);
    }

    public float getCardElevation() {
        return f679g.c(this.n);
    }

    public int getContentPaddingBottom() {
        return this.l.bottom;
    }

    public int getContentPaddingLeft() {
        return this.l.left;
    }

    public int getContentPaddingRight() {
        return this.l.right;
    }

    public int getContentPaddingTop() {
        return this.l.top;
    }

    public float getMaxCardElevation() {
        return f679g.g(this.n);
    }

    public boolean getPreventCornerOverlap() {
        return this.f681i;
    }

    public float getRadius() {
        return f679g.d(this.n);
    }

    public boolean getUseCompatPadding() {
        return this.f680h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!(f679g instanceof b)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.l(this.n)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.k(this.n)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f679g.n(this.n, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f679g.f(this.n, f2);
    }

    public void setMaxCardElevation(float f2) {
        f679g.o(this.n, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f683k = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f682j = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f681i) {
            this.f681i = z;
            f679g.m(this.n);
        }
    }

    public void setRadius(float f2) {
        f679g.b(this.n, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f680h != z) {
            this.f680h = z;
            f679g.e(this.n);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.l = rect;
        this.m = new Rect();
        a aVar = new a();
        this.n = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.d.e.a, i2, c.d.d.a);
        int i3 = c.d.e.f2900d;
        if (obtainStyledAttributes.hasValue(i3)) {
            valueOf = obtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f678f);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(c.d.b.f2895b);
            } else {
                color = getResources().getColor(c.d.b.a);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(c.d.e.f2901e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(c.d.e.f2902f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(c.d.e.f2903g, 0.0f);
        this.f680h = obtainStyledAttributes.getBoolean(c.d.e.f2905i, false);
        this.f681i = obtainStyledAttributes.getBoolean(c.d.e.f2904h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2906j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(c.d.e.l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(c.d.e.n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(c.d.e.m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2907k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f682j = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2898b, 0);
        this.f683k = obtainStyledAttributes.getDimensionPixelSize(c.d.e.f2899c, 0);
        obtainStyledAttributes.recycle();
        f679g.a(aVar, context, colorStateList, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f679g.n(this.n, colorStateList);
    }
}
