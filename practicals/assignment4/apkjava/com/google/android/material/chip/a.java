package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;
import e.e.b.c.a0.g;
import e.e.b.c.l;
import e.e.b.c.x.c;
import e.e.b.c.x.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* compiled from: ChipDrawable.java */
/* loaded from: classes2.dex */
public class a extends g implements b, Drawable.Callback, h.b {
    private static final int[] D = {R.attr.state_enabled};
    private static final ShapeDrawable E = new ShapeDrawable(new OvalShape());
    private boolean A0;
    private int B0;
    private int C0;
    private ColorFilter D0;
    private PorterDuffColorFilter E0;
    private ColorStateList F;
    private ColorStateList F0;
    private ColorStateList G;
    private PorterDuff.Mode G0;
    private float H;
    private int[] H0;
    private float I;
    private boolean I0;
    private ColorStateList J;
    private ColorStateList J0;
    private float K;
    private WeakReference<InterfaceC0196a> K0;
    private ColorStateList L;
    private TextUtils.TruncateAt L0;
    private CharSequence M;
    private boolean M0;
    private boolean N;
    private int N0;
    private Drawable O;
    private boolean O0;
    private ColorStateList P;
    private float Q;
    private boolean R;
    private boolean S;
    private Drawable T;
    private Drawable U;
    private ColorStateList V;
    private float W;
    private CharSequence X;
    private boolean Y;
    private boolean Z;
    private Drawable a0;
    private ColorStateList b0;
    private e.e.b.c.m.h c0;
    private e.e.b.c.m.h d0;
    private float e0;
    private float f0;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    private float k0;
    private float l0;
    private final Context m0;
    private final Paint n0;
    private final Paint o0;
    private final Paint.FontMetrics p0;
    private final RectF q0;
    private final PointF r0;
    private final Path s0;
    private final h t0;
    private int u0;
    private int v0;
    private int w0;
    private int x0;
    private int y0;
    private int z0;

    /* compiled from: ChipDrawable.java */
    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0196a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.I = -1.0f;
        this.n0 = new Paint(1);
        this.p0 = new Paint.FontMetrics();
        this.q0 = new RectF();
        this.r0 = new PointF();
        this.s0 = new Path();
        this.C0 = 255;
        this.G0 = PorterDuff.Mode.SRC_IN;
        this.K0 = new WeakReference<>(null);
        N(context);
        this.m0 = context;
        h hVar = new h(this);
        this.t0 = hVar;
        this.M = HttpUrl.FRAGMENT_ENCODE_SET;
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.o0 = null;
        int[] iArr = D;
        setState(iArr);
        k2(iArr);
        this.M0 = true;
        if (e.e.b.c.y.b.a) {
            E.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (this.K <= 0.0f || this.O0) {
            return;
        }
        this.n0.setColor(this.x0);
        this.n0.setStyle(Paint.Style.STROKE);
        if (!this.O0) {
            this.n0.setColorFilter(k1());
        }
        RectF rectF = this.q0;
        float f2 = rect.left;
        float f3 = this.K;
        rectF.set(f2 + (f3 / 2.0f), rect.top + (f3 / 2.0f), rect.right - (f3 / 2.0f), rect.bottom - (f3 / 2.0f));
        float f4 = this.I - (this.K / 2.0f);
        canvas.drawRoundRect(this.q0, f4, f4, this.n0);
    }

    private void B0(Canvas canvas, Rect rect) {
        if (this.O0) {
            return;
        }
        this.n0.setColor(this.u0);
        this.n0.setStyle(Paint.Style.FILL);
        this.q0.set(rect);
        canvas.drawRoundRect(this.q0, J0(), J0(), this.n0);
    }

    private void C0(Canvas canvas, Rect rect) {
        if (N2()) {
            p0(rect, this.q0);
            RectF rectF = this.q0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.T.setBounds(0, 0, (int) this.q0.width(), (int) this.q0.height());
            if (e.e.b.c.y.b.a) {
                this.U.setBounds(this.T.getBounds());
                this.U.jumpToCurrentState();
                this.U.draw(canvas);
            } else {
                this.T.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private void D0(Canvas canvas, Rect rect) {
        this.n0.setColor(this.y0);
        this.n0.setStyle(Paint.Style.FILL);
        this.q0.set(rect);
        if (!this.O0) {
            canvas.drawRoundRect(this.q0, J0(), J0(), this.n0);
        } else {
            h(new RectF(rect), this.s0);
            super.p(canvas, this.n0, this.s0, u());
        }
    }

    private void E0(Canvas canvas, Rect rect) {
        Paint paint = this.o0;
        if (paint != null) {
            paint.setColor(c.i.e.a.o(-16777216, 127));
            canvas.drawRect(rect, this.o0);
            if (M2() || L2()) {
                m0(rect, this.q0);
                canvas.drawRect(this.q0, this.o0);
            }
            if (this.M != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.o0);
            }
            if (N2()) {
                p0(rect, this.q0);
                canvas.drawRect(this.q0, this.o0);
            }
            this.o0.setColor(c.i.e.a.o(-65536, 127));
            o0(rect, this.q0);
            canvas.drawRect(this.q0, this.o0);
            this.o0.setColor(c.i.e.a.o(-16711936, 127));
            q0(rect, this.q0);
            canvas.drawRect(this.q0, this.o0);
        }
    }

    private void F0(Canvas canvas, Rect rect) {
        if (this.M != null) {
            Paint.Align u0 = u0(rect, this.r0);
            s0(rect, this.q0);
            if (this.t0.d() != null) {
                this.t0.e().drawableState = getState();
                this.t0.j(this.m0);
            }
            this.t0.e().setTextAlign(u0);
            int i2 = 0;
            boolean z = Math.round(this.t0.f(g1().toString())) > Math.round(this.q0.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.q0);
            }
            CharSequence charSequence = this.M;
            if (z && this.L0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.t0.e(), this.q0.width(), this.L0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.r0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.t0.e());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private boolean L2() {
        return this.Z && this.a0 != null && this.A0;
    }

    private boolean M2() {
        return this.N && this.O != null;
    }

    private boolean N2() {
        return this.S && this.T != null;
    }

    private void O2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void P2() {
        this.J0 = this.I0 ? e.e.b.c.y.b.d(this.L) : null;
    }

    @TargetApi(21)
    private void Q2() {
        this.U = new RippleDrawable(e.e.b.c.y.b.d(e1()), this.T, E);
    }

    private void a2(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            onStateChange(getState());
        }
    }

    private ColorFilter k1() {
        ColorFilter colorFilter = this.D0;
        return colorFilter != null ? colorFilter : this.E0;
    }

    private void l0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.T) {
            if (drawable.isStateful()) {
                drawable.setState(X0());
            }
            androidx.core.graphics.drawable.a.o(drawable, this.V);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.O;
        if (drawable == drawable2 && this.R) {
            androidx.core.graphics.drawable.a.o(drawable2, this.P);
        }
    }

    private void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (M2() || L2()) {
            float f2 = this.e0 + this.f0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + this.Q;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.Q;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private static boolean m1(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void o0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (N2()) {
            float f2 = this.l0 + this.k0 + this.W + this.j0 + this.i0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    private void p0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (N2()) {
            float f2 = this.l0 + this.k0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.W;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.W;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.W;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private void q0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (N2()) {
            float f2 = this.l0 + this.k0 + this.W + this.j0 + this.i0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean q1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean r1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void s0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.M != null) {
            float n0 = this.e0 + n0() + this.h0;
            float r0 = this.l0 + r0() + this.i0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + n0;
                rectF.right = rect.right - r0;
            } else {
                rectF.left = rect.left + r0;
                rectF.right = rect.right - n0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean s1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f21085b) == null || !colorStateList.isStateful()) ? false : true;
    }

    private float t0() {
        this.t0.e().getFontMetrics(this.p0);
        Paint.FontMetrics fontMetrics = this.p0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private void t1(AttributeSet attributeSet, int i2, int i3) {
        TypedArray h2 = j.h(this.m0, attributeSet, l.h0, i2, i3, new int[0]);
        this.O0 = h2.hasValue(l.S0);
        a2(c.a(this.m0, h2, l.F0));
        E1(c.a(this.m0, h2, l.s0));
        S1(h2.getDimension(l.A0, 0.0f));
        int i4 = l.t0;
        if (h2.hasValue(i4)) {
            G1(h2.getDimension(i4, 0.0f));
        }
        W1(c.a(this.m0, h2, l.D0));
        Y1(h2.getDimension(l.E0, 0.0f));
        x2(c.a(this.m0, h2, l.R0));
        C2(h2.getText(l.m0));
        D2(c.f(this.m0, h2, l.i0));
        int i5 = h2.getInt(l.k0, 0);
        if (i5 == 1) {
            p2(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            p2(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            p2(TextUtils.TruncateAt.END);
        }
        R1(h2.getBoolean(l.z0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            R1(h2.getBoolean(l.w0, false));
        }
        K1(c.d(this.m0, h2, l.v0));
        int i6 = l.y0;
        if (h2.hasValue(i6)) {
            O1(c.a(this.m0, h2, i6));
        }
        M1(h2.getDimension(l.x0, 0.0f));
        n2(h2.getBoolean(l.M0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            n2(h2.getBoolean(l.H0, false));
        }
        b2(c.d(this.m0, h2, l.G0));
        l2(c.a(this.m0, h2, l.L0));
        g2(h2.getDimension(l.J0, 0.0f));
        w1(h2.getBoolean(l.n0, false));
        D1(h2.getBoolean(l.r0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            D1(h2.getBoolean(l.p0, false));
        }
        y1(c.d(this.m0, h2, l.o0));
        int i7 = l.q0;
        if (h2.hasValue(i7)) {
            A1(c.a(this.m0, h2, i7));
        }
        A2(e.e.b.c.m.h.b(this.m0, h2, l.T0));
        q2(e.e.b.c.m.h.b(this.m0, h2, l.O0));
        U1(h2.getDimension(l.C0, 0.0f));
        u2(h2.getDimension(l.Q0, 0.0f));
        s2(h2.getDimension(l.P0, 0.0f));
        H2(h2.getDimension(l.V0, 0.0f));
        F2(h2.getDimension(l.U0, 0.0f));
        i2(h2.getDimension(l.K0, 0.0f));
        d2(h2.getDimension(l.I0, 0.0f));
        I1(h2.getDimension(l.u0, 0.0f));
        w2(h2.getDimensionPixelSize(l.l0, Integer.MAX_VALUE));
        h2.recycle();
    }

    private boolean v0() {
        return this.Z && this.a0 != null && this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean v1(int[] iArr, int[] iArr2) {
        boolean z;
        int colorForState;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.F;
        int colorForState2 = colorStateList != null ? colorStateList.getColorForState(iArr, this.u0) : 0;
        boolean z2 = true;
        if (this.u0 != colorForState2) {
            this.u0 = colorForState2;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.G;
        int colorForState3 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.v0) : 0;
        if (this.v0 != colorForState3) {
            this.v0 = colorForState3;
            onStateChange = true;
        }
        int e2 = e.e.b.c.q.a.e(colorForState2, colorForState3);
        if ((this.w0 != e2) | (x() == null)) {
            this.w0 = e2;
            X(ColorStateList.valueOf(e2));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.J;
        int colorForState4 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.x0) : 0;
        if (this.x0 != colorForState4) {
            this.x0 = colorForState4;
            onStateChange = true;
        }
        int colorForState5 = (this.J0 == null || !e.e.b.c.y.b.e(iArr)) ? 0 : this.J0.getColorForState(iArr, this.y0);
        if (this.y0 != colorForState5) {
            this.y0 = colorForState5;
            if (this.I0) {
                onStateChange = true;
            }
        }
        int colorForState6 = (this.t0.d() == null || this.t0.d().f21085b == null) ? 0 : this.t0.d().f21085b.getColorForState(iArr, this.z0);
        if (this.z0 != colorForState6) {
            this.z0 = colorForState6;
            onStateChange = true;
        }
        boolean z3 = m1(getState(), R.attr.state_checked) && this.Y;
        if (this.A0 != z3 && this.a0 != null) {
            float n0 = n0();
            this.A0 = z3;
            if (n0 != n0()) {
                onStateChange = true;
                z = true;
                ColorStateList colorStateList4 = this.F0;
                colorForState = colorStateList4 == null ? colorStateList4.getColorForState(iArr, this.B0) : 0;
                if (this.B0 == colorForState) {
                    this.B0 = colorForState;
                    this.E0 = e.e.b.c.s.a.a(this, this.F0, this.G0);
                } else {
                    z2 = onStateChange;
                }
                if (r1(this.O)) {
                    z2 |= this.O.setState(iArr);
                }
                if (r1(this.a0)) {
                    z2 |= this.a0.setState(iArr);
                }
                if (r1(this.T)) {
                    int[] iArr3 = new int[iArr.length + iArr2.length];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z2 |= this.T.setState(iArr3);
                }
                if (e.e.b.c.y.b.a && r1(this.U)) {
                    z2 |= this.U.setState(iArr2);
                }
                if (z2) {
                    invalidateSelf();
                }
                if (z) {
                    u1();
                }
                return z2;
            }
            onStateChange = true;
        }
        z = false;
        ColorStateList colorStateList42 = this.F0;
        if (colorStateList42 == null) {
        }
        if (this.B0 == colorForState) {
        }
        if (r1(this.O)) {
        }
        if (r1(this.a0)) {
        }
        if (r1(this.T)) {
        }
        if (e.e.b.c.y.b.a) {
            z2 |= this.U.setState(iArr2);
        }
        if (z2) {
        }
        if (z) {
        }
        return z2;
    }

    public static a w0(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.t1(attributeSet, i2, i3);
        return aVar;
    }

    private void x0(Canvas canvas, Rect rect) {
        if (L2()) {
            m0(rect, this.q0);
            RectF rectF = this.q0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.a0.setBounds(0, 0, (int) this.q0.width(), (int) this.q0.height());
            this.a0.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        if (this.O0) {
            return;
        }
        this.n0.setColor(this.v0);
        this.n0.setStyle(Paint.Style.FILL);
        this.n0.setColorFilter(k1());
        this.q0.set(rect);
        canvas.drawRoundRect(this.q0, J0(), J0(), this.n0);
    }

    private void z0(Canvas canvas, Rect rect) {
        if (M2()) {
            m0(rect, this.q0);
            RectF rectF = this.q0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.O.setBounds(0, 0, (int) this.q0.width(), (int) this.q0.height());
            this.O.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    public void A1(ColorStateList colorStateList) {
        if (this.b0 != colorStateList) {
            this.b0 = colorStateList;
            if (v0()) {
                androidx.core.graphics.drawable.a.o(this.a0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void A2(e.e.b.c.m.h hVar) {
        this.c0 = hVar;
    }

    public void B1(int i2) {
        A1(c.a.k.a.a.c(this.m0, i2));
    }

    public void B2(int i2) {
        A2(e.e.b.c.m.h.c(this.m0, i2));
    }

    public void C1(int i2) {
        D1(this.m0.getResources().getBoolean(i2));
    }

    public void C2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (TextUtils.equals(this.M, charSequence)) {
            return;
        }
        this.M = charSequence;
        this.t0.i(true);
        invalidateSelf();
        u1();
    }

    public void D1(boolean z) {
        if (this.Z != z) {
            boolean L2 = L2();
            this.Z = z;
            boolean L22 = L2();
            if (L2 != L22) {
                if (L22) {
                    l0(this.a0);
                } else {
                    O2(this.a0);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public void D2(d dVar) {
        this.t0.h(dVar, this.m0);
    }

    public void E1(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            onStateChange(getState());
        }
    }

    public void E2(int i2) {
        D2(new d(this.m0, i2));
    }

    public void F1(int i2) {
        E1(c.a.k.a.a.c(this.m0, i2));
    }

    public void F2(float f2) {
        if (this.i0 != f2) {
            this.i0 = f2;
            invalidateSelf();
            u1();
        }
    }

    public Drawable G0() {
        return this.a0;
    }

    @Deprecated
    public void G1(float f2) {
        if (this.I != f2) {
            this.I = f2;
            setShapeAppearanceModel(D().w(f2));
        }
    }

    public void G2(int i2) {
        F2(this.m0.getResources().getDimension(i2));
    }

    public ColorStateList H0() {
        return this.b0;
    }

    @Deprecated
    public void H1(int i2) {
        G1(this.m0.getResources().getDimension(i2));
    }

    public void H2(float f2) {
        if (this.h0 != f2) {
            this.h0 = f2;
            invalidateSelf();
            u1();
        }
    }

    public ColorStateList I0() {
        return this.G;
    }

    public void I1(float f2) {
        if (this.l0 != f2) {
            this.l0 = f2;
            invalidateSelf();
            u1();
        }
    }

    public void I2(int i2) {
        H2(this.m0.getResources().getDimension(i2));
    }

    public float J0() {
        return this.O0 ? G() : this.I;
    }

    public void J1(int i2) {
        I1(this.m0.getResources().getDimension(i2));
    }

    public void J2(boolean z) {
        if (this.I0 != z) {
            this.I0 = z;
            P2();
            onStateChange(getState());
        }
    }

    public float K0() {
        return this.l0;
    }

    public void K1(Drawable drawable) {
        Drawable L0 = L0();
        if (L0 != drawable) {
            float n0 = n0();
            this.O = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float n02 = n0();
            O2(L0);
            if (M2()) {
                l0(this.O);
            }
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K2() {
        return this.M0;
    }

    public Drawable L0() {
        Drawable drawable = this.O;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void L1(int i2) {
        K1(c.a.k.a.a.d(this.m0, i2));
    }

    public float M0() {
        return this.Q;
    }

    public void M1(float f2) {
        if (this.Q != f2) {
            float n0 = n0();
            this.Q = f2;
            float n02 = n0();
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    public ColorStateList N0() {
        return this.P;
    }

    public void N1(int i2) {
        M1(this.m0.getResources().getDimension(i2));
    }

    public float O0() {
        return this.H;
    }

    public void O1(ColorStateList colorStateList) {
        this.R = true;
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (M2()) {
                androidx.core.graphics.drawable.a.o(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.e0;
    }

    public void P1(int i2) {
        O1(c.a.k.a.a.c(this.m0, i2));
    }

    public ColorStateList Q0() {
        return this.J;
    }

    public void Q1(int i2) {
        R1(this.m0.getResources().getBoolean(i2));
    }

    public float R0() {
        return this.K;
    }

    public void R1(boolean z) {
        if (this.N != z) {
            boolean M2 = M2();
            this.N = z;
            boolean M22 = M2();
            if (M2 != M22) {
                if (M22) {
                    l0(this.O);
                } else {
                    O2(this.O);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public Drawable S0() {
        Drawable drawable = this.T;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void S1(float f2) {
        if (this.H != f2) {
            this.H = f2;
            invalidateSelf();
            u1();
        }
    }

    public CharSequence T0() {
        return this.X;
    }

    public void T1(int i2) {
        S1(this.m0.getResources().getDimension(i2));
    }

    public float U0() {
        return this.k0;
    }

    public void U1(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            u1();
        }
    }

    public float V0() {
        return this.W;
    }

    public void V1(int i2) {
        U1(this.m0.getResources().getDimension(i2));
    }

    public float W0() {
        return this.j0;
    }

    public void W1(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (this.O0) {
                g0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int[] X0() {
        return this.H0;
    }

    public void X1(int i2) {
        W1(c.a.k.a.a.c(this.m0, i2));
    }

    public ColorStateList Y0() {
        return this.V;
    }

    public void Y1(float f2) {
        if (this.K != f2) {
            this.K = f2;
            this.n0.setStrokeWidth(f2);
            if (this.O0) {
                super.h0(f2);
            }
            invalidateSelf();
        }
    }

    public void Z0(RectF rectF) {
        q0(getBounds(), rectF);
    }

    public void Z1(int i2) {
        Y1(this.m0.getResources().getDimension(i2));
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        u1();
        invalidateSelf();
    }

    public TextUtils.TruncateAt a1() {
        return this.L0;
    }

    public e.e.b.c.m.h b1() {
        return this.d0;
    }

    public void b2(Drawable drawable) {
        Drawable S0 = S0();
        if (S0 != drawable) {
            float r0 = r0();
            this.T = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (e.e.b.c.y.b.a) {
                Q2();
            }
            float r02 = r0();
            O2(S0);
            if (N2()) {
                l0(this.T);
            }
            invalidateSelf();
            if (r0 != r02) {
                u1();
            }
        }
    }

    public float c1() {
        return this.g0;
    }

    public void c2(CharSequence charSequence) {
        if (this.X != charSequence) {
            this.X = c.i.i.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float d1() {
        return this.f0;
    }

    public void d2(float f2) {
        if (this.k0 != f2) {
            this.k0 = f2;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.C0;
        int a = i2 < 255 ? e.e.b.c.n.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        B0(canvas, bounds);
        y0(canvas, bounds);
        if (this.O0) {
            super.draw(canvas);
        }
        A0(canvas, bounds);
        D0(canvas, bounds);
        z0(canvas, bounds);
        x0(canvas, bounds);
        if (this.M0) {
            F0(canvas, bounds);
        }
        C0(canvas, bounds);
        E0(canvas, bounds);
        if (this.C0 < 255) {
            canvas.restoreToCount(a);
        }
    }

    public ColorStateList e1() {
        return this.L;
    }

    public void e2(int i2) {
        d2(this.m0.getResources().getDimension(i2));
    }

    public e.e.b.c.m.h f1() {
        return this.c0;
    }

    public void f2(int i2) {
        b2(c.a.k.a.a.d(this.m0, i2));
    }

    public CharSequence g1() {
        return this.M;
    }

    public void g2(float f2) {
        if (this.W != f2) {
            this.W = f2;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.C0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.D0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.e0 + n0() + this.h0 + this.t0.f(g1().toString()) + this.i0 + r0() + this.l0), this.N0);
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.O0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.I);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.I);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public d h1() {
        return this.t0.d();
    }

    public void h2(int i2) {
        g2(this.m0.getResources().getDimension(i2));
    }

    public float i1() {
        return this.i0;
    }

    public void i2(float f2) {
        if (this.j0 != f2) {
            this.j0 = f2;
            invalidateSelf();
            if (N2()) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return q1(this.F) || q1(this.G) || q1(this.J) || (this.I0 && q1(this.J0)) || s1(this.t0.d()) || v0() || r1(this.O) || r1(this.a0) || q1(this.F0);
    }

    public float j1() {
        return this.h0;
    }

    public void j2(int i2) {
        i2(this.m0.getResources().getDimension(i2));
    }

    public boolean k2(int[] iArr) {
        if (Arrays.equals(this.H0, iArr)) {
            return false;
        }
        this.H0 = iArr;
        if (N2()) {
            return v1(getState(), iArr);
        }
        return false;
    }

    public boolean l1() {
        return this.I0;
    }

    public void l2(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (N2()) {
                androidx.core.graphics.drawable.a.o(this.T, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void m2(int i2) {
        l2(c.a.k.a.a.c(this.m0, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n0() {
        if (M2() || L2()) {
            return this.f0 + this.Q + this.g0;
        }
        return 0.0f;
    }

    public boolean n1() {
        return this.Y;
    }

    public void n2(boolean z) {
        if (this.S != z) {
            boolean N2 = N2();
            this.S = z;
            boolean N22 = N2();
            if (N2 != N22) {
                if (N22) {
                    l0(this.T);
                } else {
                    O2(this.T);
                }
                invalidateSelf();
                u1();
            }
        }
    }

    public boolean o1() {
        return r1(this.T);
    }

    public void o2(InterfaceC0196a interfaceC0196a) {
        this.K0 = new WeakReference<>(interfaceC0196a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (M2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.O, i2);
        }
        if (L2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.a0, i2);
        }
        if (N2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.T, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (M2()) {
            onLevelChange |= this.O.setLevel(i2);
        }
        if (L2()) {
            onLevelChange |= this.a0.setLevel(i2);
        }
        if (N2()) {
            onLevelChange |= this.T.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        if (this.O0) {
            super.onStateChange(iArr);
        }
        return v1(iArr, X0());
    }

    public boolean p1() {
        return this.S;
    }

    public void p2(TextUtils.TruncateAt truncateAt) {
        this.L0 = truncateAt;
    }

    public void q2(e.e.b.c.m.h hVar) {
        this.d0 = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float r0() {
        if (N2()) {
            return this.j0 + this.W + this.k0;
        }
        return 0.0f;
    }

    public void r2(int i2) {
        q2(e.e.b.c.m.h.c(this.m0, i2));
    }

    public void s2(float f2) {
        if (this.g0 != f2) {
            float n0 = n0();
            this.g0 = f2;
            float n02 = n0();
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.C0 != i2) {
            this.C0 = i2;
            invalidateSelf();
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.D0 != colorFilter) {
            this.D0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            this.F0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.G0 != mode) {
            this.G0 = mode;
            this.E0 = e.e.b.c.s.a.a(this, this.F0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (M2()) {
            visible |= this.O.setVisible(z, z2);
        }
        if (L2()) {
            visible |= this.a0.setVisible(z, z2);
        }
        if (N2()) {
            visible |= this.T.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(int i2) {
        s2(this.m0.getResources().getDimension(i2));
    }

    Paint.Align u0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.M != null) {
            float n0 = this.e0 + n0() + this.h0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + n0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - n0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - t0();
        }
        return align;
    }

    protected void u1() {
        InterfaceC0196a interfaceC0196a = this.K0.get();
        if (interfaceC0196a != null) {
            interfaceC0196a.a();
        }
    }

    public void u2(float f2) {
        if (this.f0 != f2) {
            float n0 = n0();
            this.f0 = f2;
            float n02 = n0();
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v2(int i2) {
        u2(this.m0.getResources().getDimension(i2));
    }

    public void w1(boolean z) {
        if (this.Y != z) {
            this.Y = z;
            float n0 = n0();
            if (!z && this.A0) {
                this.A0 = false;
            }
            float n02 = n0();
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    public void w2(int i2) {
        this.N0 = i2;
    }

    public void x1(int i2) {
        w1(this.m0.getResources().getBoolean(i2));
    }

    public void x2(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            P2();
            onStateChange(getState());
        }
    }

    public void y1(Drawable drawable) {
        if (this.a0 != drawable) {
            float n0 = n0();
            this.a0 = drawable;
            float n02 = n0();
            O2(this.a0);
            l0(this.a0);
            invalidateSelf();
            if (n0 != n02) {
                u1();
            }
        }
    }

    public void y2(int i2) {
        x2(c.a.k.a.a.c(this.m0, i2));
    }

    public void z1(int i2) {
        y1(c.a.k.a.a.d(this.m0, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z2(boolean z) {
        this.M0 = z;
    }
}
