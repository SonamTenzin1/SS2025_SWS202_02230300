package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: LinearLayoutCompat.java */
/* loaded from: classes.dex */
public class c0 extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    private boolean f489f;

    /* renamed from: g, reason: collision with root package name */
    private int f490g;

    /* renamed from: h, reason: collision with root package name */
    private int f491h;

    /* renamed from: i, reason: collision with root package name */
    private int f492i;

    /* renamed from: j, reason: collision with root package name */
    private int f493j;

    /* renamed from: k, reason: collision with root package name */
    private int f494k;
    private float l;
    private boolean m;
    private int[] n;
    private int[] o;
    private Drawable p;
    private int q;
    private int r;
    private int s;
    private int t;

    public c0(Context context) {
        this(context, null);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void k(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = s.getMeasuredWidth();
                    measureChildWithMargins(s, i3, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void l(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View s = s(i4);
            if (s.getVisibility() != 8) {
                a aVar = (a) s.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = s.getMeasuredHeight();
                    measureChildWithMargins(s, makeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i5;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i2;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean b2 = w0.b(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View s = s(i3);
            if (s != null && s.getVisibility() != 8 && t(i3)) {
                a aVar = (a) s.getLayoutParams();
                if (b2) {
                    left2 = s.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                } else {
                    left2 = (s.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.q;
                }
                j(canvas, left2);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 != null) {
                a aVar2 = (a) s2.getLayoutParams();
                if (b2) {
                    left = s2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i2 = this.q;
                    right = left - i2;
                } else {
                    right = s2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (b2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.q;
                right = left - i2;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f490g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f490g;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f490g == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i4 = this.f491h;
            if (this.f492i == 1 && (i2 = this.f493j & 112) != 48) {
                if (i2 == 16) {
                    i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f494k) / 2;
                } else if (i2 == 80) {
                    i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f494k;
                }
            }
            return i4 + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f490g;
    }

    public Drawable getDividerDrawable() {
        return this.p;
    }

    public int getDividerPadding() {
        return this.t;
    }

    public int getDividerWidth() {
        return this.q;
    }

    public int getGravity() {
        return this.f493j;
    }

    public int getOrientation() {
        return this.f492i;
    }

    public int getShowDividers() {
        return this.s;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.l;
    }

    void h(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View s = s(i2);
            if (s != null && s.getVisibility() != 8 && t(i2)) {
                i(canvas, (s.getTop() - ((ViewGroup.MarginLayoutParams) ((a) s.getLayoutParams())).topMargin) - this.r);
            }
        }
        if (t(virtualChildCount)) {
            View s2 = s(virtualChildCount - 1);
            if (s2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.r;
            } else {
                bottom = s2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) s2.getLayoutParams())).bottomMargin;
            }
            i(canvas, bottom);
        }
    }

    void i(Canvas canvas, int i2) {
        this.p.setBounds(getPaddingLeft() + this.t, i2, (getWidth() - getPaddingRight()) - this.t, this.r + i2);
        this.p.draw(canvas);
    }

    void j(Canvas canvas, int i2) {
        this.p.setBounds(i2, getPaddingTop() + this.t, this.q + i2, (getHeight() - getPaddingBottom()) - this.t);
        this.p.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f492i;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.p == null) {
            return;
        }
        if (this.f492i == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f492i == 1) {
            v(i2, i3, i4, i5);
        } else {
            u(i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f492i == 1) {
            z(i2, i3);
        } else {
            x(i2, i3);
        }
    }

    int p(View view, int i2) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i2) {
        return getChildAt(i2);
    }

    public void setBaselineAligned(boolean z) {
        this.f489f = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f490g = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.p) {
            return;
        }
        this.p = drawable;
        if (drawable != null) {
            this.q = drawable.getIntrinsicWidth();
            this.r = drawable.getIntrinsicHeight();
        } else {
            this.q = 0;
            this.r = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.t = i2;
    }

    public void setGravity(int i2) {
        if (this.f493j != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f493j = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f493j;
        if ((8388615 & i4) != i3) {
            this.f493j = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.m = z;
    }

    public void setOrientation(int i2) {
        if (this.f492i != i2) {
            this.f492i = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.s) {
            requestLayout();
        }
        this.s = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f493j;
        if ((i4 & 112) != i3) {
            this.f493j = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.l = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i2) {
        if (i2 == 0) {
            return (this.s & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.s & 4) != 0;
        }
        if ((this.s & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void u(int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean b2 = w0.b(this);
        int paddingTop = getPaddingTop();
        int i15 = i5 - i3;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.f493j;
        int i17 = i16 & 112;
        boolean z = this.f489f;
        int[] iArr = this.n;
        int[] iArr2 = this.o;
        int b3 = androidx.core.view.d.b(8388615 & i16, androidx.core.view.u.y(this));
        if (b3 == 1) {
            paddingLeft = getPaddingLeft() + (((i4 - i2) - this.f494k) / 2);
        } else if (b3 != 5) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = ((getPaddingLeft() + i4) - i2) - this.f494k;
        }
        if (b2) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i6 + (i7 * i18);
            View s = s(i19);
            if (s == null) {
                paddingLeft += y(i19);
            } else if (s.getVisibility() != 8) {
                int measuredWidth = s.getMeasuredWidth();
                int measuredHeight = s.getMeasuredHeight();
                a aVar = (a) s.getLayoutParams();
                int i20 = i18;
                if (z) {
                    i8 = virtualChildCount;
                    if (((ViewGroup.MarginLayoutParams) aVar).height != -1) {
                        i9 = s.getBaseline();
                        i10 = aVar.f495b;
                        if (i10 < 0) {
                            i10 = i17;
                        }
                        i11 = i10 & 112;
                        i12 = i17;
                        if (i11 != 16) {
                            i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        } else if (i11 == 48) {
                            i13 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                            if (i9 != -1) {
                                i13 += iArr[1] - i9;
                            }
                        } else if (i11 != 80) {
                            i13 = paddingTop;
                        } else {
                            i13 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                            if (i9 != -1) {
                                i13 -= iArr2[2] - (s.getMeasuredHeight() - i9);
                            }
                        }
                        if (t(i19)) {
                            paddingLeft += this.q;
                        }
                        int i21 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        i14 = paddingTop;
                        A(s, i21 + q(s), i13, measuredWidth, measuredHeight);
                        int r = i21 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(s);
                        i18 = i20 + p(s, i19);
                        paddingLeft = r;
                        i18++;
                        virtualChildCount = i8;
                        i17 = i12;
                        paddingTop = i14;
                    }
                } else {
                    i8 = virtualChildCount;
                }
                i9 = -1;
                i10 = aVar.f495b;
                if (i10 < 0) {
                }
                i11 = i10 & 112;
                i12 = i17;
                if (i11 != 16) {
                }
                if (t(i19)) {
                }
                int i212 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                i14 = paddingTop;
                A(s, i212 + q(s), i13, measuredWidth, measuredHeight);
                int r2 = i212 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(s);
                i18 = i20 + p(s, i19);
                paddingLeft = r2;
                i18++;
                virtualChildCount = i8;
                i17 = i12;
                paddingTop = i14;
            }
            i14 = paddingTop;
            i8 = virtualChildCount;
            i12 = i17;
            i18++;
            virtualChildCount = i8;
            i17 = i12;
            paddingTop = i14;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void v(int i2, int i3, int i4, int i5) {
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.f493j;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        if (i11 == 16) {
            paddingTop = getPaddingTop() + (((i5 - i3) - this.f494k) / 2);
        } else if (i11 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i5) - i3) - this.f494k;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View s = s(i13);
            if (s == null) {
                paddingTop += y(i13);
            } else if (s.getVisibility() != 8) {
                int measuredWidth = s.getMeasuredWidth();
                int measuredHeight = s.getMeasuredHeight();
                a aVar = (a) s.getLayoutParams();
                int i14 = aVar.f495b;
                if (i14 < 0) {
                    i14 = i12;
                }
                int b2 = androidx.core.view.d.b(i14, androidx.core.view.u.y(this)) & 7;
                if (b2 == 1) {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                } else if (b2 != 5) {
                    i8 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    int i15 = i8;
                    if (t(i13)) {
                        paddingTop += this.r;
                    }
                    int i16 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(s, i15, i16 + q(s), measuredWidth, measuredHeight);
                    int r = i16 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(s);
                    i13 += p(s, i13);
                    paddingTop = r;
                } else {
                    i6 = paddingRight - measuredWidth;
                    i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                }
                i8 = i6 - i7;
                int i152 = i8;
                if (t(i13)) {
                }
                int i162 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(s, i152, i162 + q(s), measuredWidth, measuredHeight);
                int r2 = i162 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(s);
                i13 += p(s, i13);
                paddingTop = r2;
            }
            i13++;
        }
    }

    void w(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x(int i2, int i3) {
        int[] iArr;
        int i4;
        int max;
        int i5;
        int i6;
        int max2;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        boolean z;
        int baseline;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        boolean z3;
        View view;
        int i16;
        boolean z4;
        int measuredHeight;
        int p;
        int baseline2;
        int i17;
        this.f494k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.n == null || this.o == null) {
            this.n = new int[4];
            this.o = new int[4];
        }
        int[] iArr2 = this.n;
        int[] iArr3 = this.o;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.f489f;
        boolean z6 = this.m;
        int i18 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f3 = 0.0f;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        boolean z8 = false;
        int i24 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i19 >= virtualChildCount) {
                break;
            }
            View s = s(i19);
            if (s == null) {
                this.f494k += y(i19);
            } else if (s.getVisibility() == 8) {
                i19 += p(s, i19);
            } else {
                if (t(i19)) {
                    this.f494k += this.q;
                }
                a aVar = (a) s.getLayoutParams();
                float f4 = aVar.a;
                float f5 = f3 + f4;
                if (mode == i18 && ((ViewGroup.MarginLayoutParams) aVar).width == 0 && f4 > 0.0f) {
                    if (z7) {
                        this.f494k += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    } else {
                        int i25 = this.f494k;
                        this.f494k = Math.max(i25, ((ViewGroup.MarginLayoutParams) aVar).leftMargin + i25 + ((ViewGroup.MarginLayoutParams) aVar).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        s.measure(makeMeasureSpec, makeMeasureSpec);
                        i15 = i19;
                        z2 = z6;
                        z3 = z5;
                        view = s;
                    } else {
                        i15 = i19;
                        z2 = z6;
                        z3 = z5;
                        view = s;
                        i16 = 1073741824;
                        z8 = true;
                        if (mode2 == i16 && ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i26 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i26;
                        i24 = View.combineMeasuredStates(i24, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i17 = aVar.f495b;
                            if (i17 < 0) {
                                i17 = this.f493j;
                            }
                            int i27 = (((i17 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i27] = Math.max(iArr2[i27], baseline2);
                            iArr[i27] = Math.max(iArr[i27], measuredHeight - baseline2);
                        }
                        i21 = Math.max(i21, measuredHeight);
                        z9 = !z9 && ((ViewGroup.MarginLayoutParams) aVar).height == -1;
                        if (aVar.a <= 0.0f) {
                            if (!z4) {
                                i26 = measuredHeight;
                            }
                            i23 = Math.max(i23, i26);
                        } else {
                            int i28 = i23;
                            if (!z4) {
                                i26 = measuredHeight;
                            }
                            i22 = Math.max(i22, i26);
                            i23 = i28;
                        }
                        int i29 = i15;
                        p = p(view, i29) + i29;
                        f3 = f5;
                        i19 = p + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i18 = 1073741824;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) aVar).width != 0 || f4 <= 0.0f) {
                        i14 = Integer.MIN_VALUE;
                    } else {
                        ((ViewGroup.MarginLayoutParams) aVar).width = -2;
                        i14 = 0;
                    }
                    i15 = i19;
                    int i30 = i14;
                    z2 = z6;
                    z3 = z5;
                    w(s, i15, i2, f5 == 0.0f ? this.f494k : 0, i3, 0);
                    if (i30 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) aVar).width = i30;
                    }
                    int measuredWidth = s.getMeasuredWidth();
                    if (z7) {
                        view = s;
                        this.f494k += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view);
                    } else {
                        view = s;
                        int i31 = this.f494k;
                        this.f494k = Math.max(i31, i31 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view));
                    }
                    if (z2) {
                        i20 = Math.max(measuredWidth, i20);
                    }
                }
                i16 = 1073741824;
                if (mode2 == i16) {
                }
                z4 = false;
                int i262 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i262;
                i24 = View.combineMeasuredStates(i24, view.getMeasuredState());
                if (z3) {
                    i17 = aVar.f495b;
                    if (i17 < 0) {
                    }
                    int i272 = (((i17 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i272] = Math.max(iArr2[i272], baseline2);
                    iArr[i272] = Math.max(iArr[i272], measuredHeight - baseline2);
                }
                i21 = Math.max(i21, measuredHeight);
                if (z9) {
                }
                if (aVar.a <= 0.0f) {
                }
                int i292 = i15;
                p = p(view, i292) + i292;
                f3 = f5;
                i19 = p + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i18 = 1073741824;
            }
            p = i19;
            z2 = z6;
            z3 = z5;
            i19 = p + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i18 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i32 = i21;
        int i33 = i22;
        int i34 = i23;
        int i35 = i24;
        if (this.f494k > 0 && t(virtualChildCount)) {
            this.f494k += this.q;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i32;
            i4 = i35;
        } else {
            i4 = i35;
            max = Math.max(i32, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f494k = 0;
            int i36 = 0;
            while (i36 < virtualChildCount) {
                View s2 = s(i36);
                if (s2 == null) {
                    this.f494k += y(i36);
                } else if (s2.getVisibility() == 8) {
                    i36 += p(s2, i36);
                } else {
                    a aVar2 = (a) s2.getLayoutParams();
                    if (z7) {
                        this.f494k += ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + i20 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(s2);
                    } else {
                        int i37 = this.f494k;
                        i13 = max;
                        this.f494k = Math.max(i37, i37 + i20 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(s2));
                        i36++;
                        max = i13;
                    }
                }
                i13 = max;
                i36++;
                max = i13;
            }
        }
        int i38 = max;
        int paddingLeft = this.f494k + getPaddingLeft() + getPaddingRight();
        this.f494k = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, 0);
        int i39 = (16777215 & resolveSizeAndState) - this.f494k;
        if (!z8 && (i39 == 0 || f3 <= 0.0f)) {
            i7 = Math.max(i33, i34);
            if (z11 && mode != 1073741824) {
                for (int i40 = 0; i40 < virtualChildCount; i40++) {
                    View s3 = s(i40);
                    if (s3 != null && s3.getVisibility() != 8 && ((a) s3.getLayoutParams()).a > 0.0f) {
                        s3.measure(View.MeasureSpec.makeMeasureSpec(i20, 1073741824), View.MeasureSpec.makeMeasureSpec(s3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = i3;
            i6 = virtualChildCount;
            max2 = i38;
        } else {
            float f6 = this.l;
            if (f6 > 0.0f) {
                f3 = f6;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f494k = 0;
            int i41 = i33;
            int i42 = i4;
            int i43 = -1;
            int i44 = 0;
            while (i44 < virtualChildCount) {
                View s4 = s(i44);
                if (s4 == null || s4.getVisibility() == 8) {
                    i8 = i39;
                    i9 = virtualChildCount;
                } else {
                    a aVar3 = (a) s4.getLayoutParams();
                    float f7 = aVar3.a;
                    if (f7 > 0.0f) {
                        int i45 = (int) ((i39 * f7) / f3);
                        float f8 = f3 - f7;
                        int i46 = i39 - i45;
                        i9 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar3).height);
                        if (((ViewGroup.MarginLayoutParams) aVar3).width == 0) {
                            i12 = 1073741824;
                            if (mode == 1073741824) {
                                if (i45 <= 0) {
                                    i45 = 0;
                                }
                                s4.measure(View.MeasureSpec.makeMeasureSpec(i45, 1073741824), childMeasureSpec);
                                i42 = View.combineMeasuredStates(i42, s4.getMeasuredState() & (-16777216));
                                f3 = f8;
                                i8 = i46;
                            }
                        } else {
                            i12 = 1073741824;
                        }
                        int measuredWidth2 = s4.getMeasuredWidth() + i45;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        s4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i12), childMeasureSpec);
                        i42 = View.combineMeasuredStates(i42, s4.getMeasuredState() & (-16777216));
                        f3 = f8;
                        i8 = i46;
                    } else {
                        i8 = i39;
                        i9 = virtualChildCount;
                    }
                    if (z7) {
                        this.f494k += s4.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(s4);
                        f2 = f3;
                    } else {
                        int i47 = this.f494k;
                        f2 = f3;
                        this.f494k = Math.max(i47, s4.getMeasuredWidth() + i47 + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(s4));
                    }
                    boolean z13 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                    int i48 = ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = s4.getMeasuredHeight() + i48;
                    i43 = Math.max(i43, measuredHeight2);
                    if (!z13) {
                        i48 = measuredHeight2;
                    }
                    int max3 = Math.max(i41, i48);
                    if (z9) {
                        i10 = -1;
                        if (((ViewGroup.MarginLayoutParams) aVar3).height == -1) {
                            z = true;
                            if (z12 && (baseline = s4.getBaseline()) != i10) {
                                i11 = aVar3.f495b;
                                if (i11 < 0) {
                                    i11 = this.f493j;
                                }
                                int i49 = (((i11 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i49] = Math.max(iArr2[i49], baseline);
                                iArr[i49] = Math.max(iArr[i49], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i41 = max3;
                            f3 = f2;
                        }
                    } else {
                        i10 = -1;
                    }
                    z = false;
                    if (z12) {
                        i11 = aVar3.f495b;
                        if (i11 < 0) {
                        }
                        int i492 = (((i11 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i492] = Math.max(iArr2[i492], baseline);
                        iArr[i492] = Math.max(iArr[i492], measuredHeight2 - baseline);
                    }
                    z9 = z;
                    i41 = max3;
                    f3 = f2;
                }
                i44++;
                i39 = i8;
                virtualChildCount = i9;
            }
            i5 = i3;
            i6 = virtualChildCount;
            this.f494k += getPaddingLeft() + getPaddingRight();
            max2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i43 : Math.max(i43, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i7 = i41;
            i4 = i42;
        }
        if (z9 || mode2 == 1073741824) {
            i7 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i4 & (-16777216)), View.resolveSizeAndState(Math.max(i7 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i4 << 16));
        if (z10) {
            k(i6, i2);
        }
    }

    int y(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0323  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void z(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View view;
        int max;
        boolean z2;
        int max2;
        this.f494k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i20 = this.f490g;
        boolean z3 = this.m;
        float f2 = 0.0f;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i27 = 8;
            int i28 = i24;
            if (i26 < virtualChildCount) {
                View s = s(i26);
                if (s == null) {
                    this.f494k += y(i26);
                    i15 = virtualChildCount;
                    i16 = mode2;
                    i24 = i28;
                } else {
                    int i29 = i21;
                    if (s.getVisibility() == 8) {
                        i26 += p(s, i26);
                        i15 = virtualChildCount;
                        i24 = i28;
                        i21 = i29;
                        i16 = mode2;
                    } else {
                        if (t(i26)) {
                            this.f494k += this.r;
                        }
                        a aVar = (a) s.getLayoutParams();
                        float f3 = aVar.a;
                        float f4 = f2 + f3;
                        if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) aVar).height == 0 && f3 > 0.0f) {
                            int i30 = this.f494k;
                            this.f494k = Math.max(i30, ((ViewGroup.MarginLayoutParams) aVar).topMargin + i30 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
                            max = i23;
                            view = s;
                            i18 = i25;
                            i13 = i29;
                            i14 = i22;
                            z4 = true;
                            i15 = virtualChildCount;
                            i16 = mode2;
                            i17 = i28;
                            i19 = i26;
                        } else {
                            int i31 = i22;
                            if (((ViewGroup.MarginLayoutParams) aVar).height != 0 || f3 <= 0.0f) {
                                i12 = Integer.MIN_VALUE;
                            } else {
                                ((ViewGroup.MarginLayoutParams) aVar).height = -2;
                                i12 = 0;
                            }
                            i13 = i29;
                            int i32 = i12;
                            i14 = i31;
                            int i33 = i23;
                            i15 = virtualChildCount;
                            i16 = mode2;
                            i17 = i28;
                            i18 = i25;
                            i19 = i26;
                            w(s, i26, i2, 0, i3, f4 == 0.0f ? this.f494k : 0);
                            if (i32 != Integer.MIN_VALUE) {
                                ((ViewGroup.MarginLayoutParams) aVar).height = i32;
                            }
                            int measuredHeight = s.getMeasuredHeight();
                            int i34 = this.f494k;
                            view = s;
                            this.f494k = Math.max(i34, i34 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(view));
                            max = z3 ? Math.max(measuredHeight, i33) : i33;
                        }
                        if (i20 >= 0 && i20 == i19 + 1) {
                            this.f491h = this.f494k;
                        }
                        if (i19 < i20 && aVar.a > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) aVar).width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i35 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i35;
                        int max3 = Math.max(i14, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                        z5 = z5 && ((ViewGroup.MarginLayoutParams) aVar).width == -1;
                        if (aVar.a > 0.0f) {
                            if (!z2) {
                                i35 = measuredWidth;
                            }
                            i24 = Math.max(i17, i35);
                            max2 = i18;
                        } else {
                            if (!z2) {
                                i35 = measuredWidth;
                            }
                            max2 = Math.max(i18, i35);
                            i24 = i17;
                        }
                        int p = p(view, i19) + i19;
                        i23 = max;
                        f2 = f4;
                        i25 = max2;
                        i21 = combineMeasuredStates;
                        i26 = p;
                        i22 = max3;
                    }
                }
                i26++;
                mode2 = i16;
                virtualChildCount = i15;
            } else {
                int i36 = i21;
                int i37 = i23;
                int i38 = i25;
                int i39 = virtualChildCount;
                int i40 = mode2;
                int i41 = i22;
                if (this.f494k > 0) {
                    i4 = i39;
                    if (t(i4)) {
                        this.f494k += this.r;
                    }
                } else {
                    i4 = i39;
                }
                if (z3 && (i40 == Integer.MIN_VALUE || i40 == 0)) {
                    this.f494k = 0;
                    int i42 = 0;
                    while (i42 < i4) {
                        View s2 = s(i42);
                        if (s2 == null) {
                            this.f494k += y(i42);
                        } else if (s2.getVisibility() == i27) {
                            i42 += p(s2, i42);
                        } else {
                            a aVar2 = (a) s2.getLayoutParams();
                            int i43 = this.f494k;
                            this.f494k = Math.max(i43, i43 + i37 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(s2));
                        }
                        i42++;
                        i27 = 8;
                    }
                }
                int paddingTop = this.f494k + getPaddingTop() + getPaddingBottom();
                this.f494k = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, 0);
                int i44 = (16777215 & resolveSizeAndState) - this.f494k;
                if (!z4 && (i44 == 0 || f2 <= 0.0f)) {
                    i7 = Math.max(i38, i28);
                    if (z3 && i40 != 1073741824) {
                        for (int i45 = 0; i45 < i4; i45++) {
                            View s3 = s(i45);
                            if (s3 != null && s3.getVisibility() != 8 && ((a) s3.getLayoutParams()).a > 0.0f) {
                                s3.measure(View.MeasureSpec.makeMeasureSpec(s3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i37, 1073741824));
                            }
                        }
                    }
                    i6 = i2;
                    i5 = i36;
                } else {
                    float f5 = this.l;
                    if (f5 > 0.0f) {
                        f2 = f5;
                    }
                    this.f494k = 0;
                    int i46 = i44;
                    int i47 = i38;
                    i5 = i36;
                    int i48 = 0;
                    while (i48 < i4) {
                        View s4 = s(i48);
                        if (s4.getVisibility() == 8) {
                            i8 = i46;
                        } else {
                            a aVar3 = (a) s4.getLayoutParams();
                            float f6 = aVar3.a;
                            if (f6 > 0.0f) {
                                int i49 = (int) ((i46 * f6) / f2);
                                float f7 = f2 - f6;
                                i8 = i46 - i49;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin, ((ViewGroup.MarginLayoutParams) aVar3).width);
                                if (((ViewGroup.MarginLayoutParams) aVar3).height == 0) {
                                    i11 = 1073741824;
                                    if (i40 == 1073741824) {
                                        if (i49 <= 0) {
                                            i49 = 0;
                                        }
                                        s4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i49, 1073741824));
                                        i5 = View.combineMeasuredStates(i5, s4.getMeasuredState() & (-256));
                                        f2 = f7;
                                    }
                                } else {
                                    i11 = 1073741824;
                                }
                                int measuredHeight2 = s4.getMeasuredHeight() + i49;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                s4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i11));
                                i5 = View.combineMeasuredStates(i5, s4.getMeasuredState() & (-256));
                                f2 = f7;
                            } else {
                                i8 = i46;
                            }
                            int i50 = ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin;
                            int measuredWidth2 = s4.getMeasuredWidth() + i50;
                            i41 = Math.max(i41, measuredWidth2);
                            float f8 = f2;
                            if (mode != 1073741824) {
                                i9 = i5;
                                i10 = -1;
                                if (((ViewGroup.MarginLayoutParams) aVar3).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i50 = measuredWidth2;
                                    }
                                    int max4 = Math.max(i47, i50);
                                    boolean z7 = !z5 && ((ViewGroup.MarginLayoutParams) aVar3).width == i10;
                                    int i51 = this.f494k;
                                    this.f494k = Math.max(i51, s4.getMeasuredHeight() + i51 + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin + r(s4));
                                    z5 = z7;
                                    i5 = i9;
                                    i47 = max4;
                                    f2 = f8;
                                }
                            } else {
                                i9 = i5;
                                i10 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max42 = Math.max(i47, i50);
                            if (z5) {
                            }
                            int i512 = this.f494k;
                            this.f494k = Math.max(i512, s4.getMeasuredHeight() + i512 + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin + r(s4));
                            z5 = z7;
                            i5 = i9;
                            i47 = max42;
                            f2 = f8;
                        }
                        i48++;
                        i46 = i8;
                    }
                    i6 = i2;
                    this.f494k += getPaddingTop() + getPaddingBottom();
                    i7 = i47;
                }
                if (z5 || mode == 1073741824) {
                    i7 = i41;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i5), resolveSizeAndState);
                if (z6) {
                    l(i4, i3);
                    return;
                }
                return;
            }
        }
    }

    public c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f489f = true;
        this.f490g = -1;
        this.f491h = 0;
        this.f493j = 8388659;
        int[] iArr = c.a.j.b1;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        androidx.core.view.u.g0(this, context, iArr, attributeSet, v.r(), i2, 0);
        int k2 = v.k(c.a.j.d1, -1);
        if (k2 >= 0) {
            setOrientation(k2);
        }
        int k3 = v.k(c.a.j.c1, -1);
        if (k3 >= 0) {
            setGravity(k3);
        }
        boolean a2 = v.a(c.a.j.e1, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.l = v.i(c.a.j.g1, -1.0f);
        this.f490g = v.k(c.a.j.f1, -1);
        this.m = v.a(c.a.j.j1, false);
        setDividerDrawable(v.g(c.a.j.h1));
        this.s = v.k(c.a.j.k1, 0);
        this.t = v.f(c.a.j.i1, 0);
        v.w();
    }

    /* compiled from: LinearLayoutCompat.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float a;

        /* renamed from: b, reason: collision with root package name */
        public int f495b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f495b = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.l1);
            this.a = obtainStyledAttributes.getFloat(c.a.j.n1, 0.0f);
            this.f495b = obtainStyledAttributes.getInt(c.a.j.m1, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f495b = -1;
            this.a = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f495b = -1;
        }
    }
}
