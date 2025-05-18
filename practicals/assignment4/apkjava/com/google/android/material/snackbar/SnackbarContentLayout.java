package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.u;
import e.e.b.c.d;
import e.e.b.c.f;
import e.e.b.c.l;

/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: f, reason: collision with root package name */
    private TextView f18754f;

    /* renamed from: g, reason: collision with root package name */
    private Button f18755g;

    /* renamed from: h, reason: collision with root package name */
    private int f18756h;

    /* renamed from: i, reason: collision with root package name */
    private int f18757i;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.h4);
        this.f18756h = obtainStyledAttributes.getDimensionPixelSize(l.i4, -1);
        this.f18757i = obtainStyledAttributes.getDimensionPixelSize(l.p4, -1);
        obtainStyledAttributes.recycle();
    }

    private static void d(View view, int i2, int i3) {
        if (u.Q(view)) {
            u.w0(view, u.D(view), i2, u.C(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean e(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.f18754f.getPaddingTop() == i3 && this.f18754f.getPaddingBottom() == i4) {
            return z;
        }
        d(this.f18754f, i3, i4);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i2, int i3) {
        this.f18754f.setAlpha(0.0f);
        long j2 = i3;
        long j3 = i2;
        this.f18754f.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f18755g.getVisibility() == 0) {
            this.f18755g.setAlpha(0.0f);
            this.f18755g.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i2, int i3) {
        this.f18754f.setAlpha(1.0f);
        long j2 = i3;
        long j3 = i2;
        this.f18754f.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f18755g.getVisibility() == 0) {
            this.f18755g.setAlpha(1.0f);
            this.f18755g.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f2) {
        if (f2 != 1.0f) {
            this.f18755g.setTextColor(e.e.b.c.q.a.f(e.e.b.c.q.a.c(this, e.e.b.c.b.o), this.f18755g.getCurrentTextColor(), f2));
        }
    }

    public Button getActionView() {
        return this.f18755g;
    }

    public TextView getMessageView() {
        return this.f18754f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f18754f = (TextView) findViewById(f.C);
        this.f18755g = (Button) findViewById(f.B);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (e(1, r0, r0 - r1) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (e(0, r0, r0) != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f18756h > 0) {
            int measuredWidth = getMeasuredWidth();
            int i4 = this.f18756h;
            if (measuredWidth > i4) {
                i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                super.onMeasure(i2, i3);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.o);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.n);
        boolean z = false;
        boolean z2 = this.f18754f.getLayout().getLineCount() > 1;
        if (!z2 || this.f18757i <= 0 || this.f18755g.getMeasuredWidth() <= this.f18757i) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f18757i = i2;
    }
}
