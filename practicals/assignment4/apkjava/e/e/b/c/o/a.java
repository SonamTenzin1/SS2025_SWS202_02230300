package e.e.b.c.o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.e;
import com.google.android.material.internal.j;
import e.e.b.c.b;
import e.e.b.c.k;
import e.e.b.c.l;
import e.e.b.c.x.c;

/* compiled from: MaterialCheckBox.java */
/* loaded from: classes2.dex */
public class a extends e {

    /* renamed from: i, reason: collision with root package name */
    private static final int f21064i = k.t;

    /* renamed from: j, reason: collision with root package name */
    private static final int[][] f21065j = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f21066k;
    private boolean l;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f20968g);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f21066k == null) {
            int[][] iArr = f21065j;
            int[] iArr2 = new int[iArr.length];
            int c2 = e.e.b.c.q.a.c(this, b.f20971j);
            int c3 = e.e.b.c.q.a.c(this, b.o);
            int c4 = e.e.b.c.q.a.c(this, b.l);
            iArr2[0] = e.e.b.c.q.a.f(c3, c2, 1.0f);
            iArr2[1] = e.e.b.c.q.a.f(c3, c4, 0.54f);
            iArr2[2] = e.e.b.c.q.a.f(c3, c4, 0.38f);
            iArr2[3] = e.e.b.c.q.a.f(c3, c4, 0.38f);
            this.f21066k = new ColorStateList(iArr, iArr2);
        }
        return this.f21066k;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l && androidx.core.widget.e.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.l = z;
        if (z) {
            androidx.core.widget.e.c(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.e.c(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, r4), attributeSet, i2);
        int i3 = f21064i;
        Context context2 = getContext();
        TypedArray h2 = j.h(context2, attributeSet, l.q3, i2, i3, new int[0]);
        int i4 = l.r3;
        if (h2.hasValue(i4)) {
            androidx.core.widget.e.c(this, c.a(context2, h2, i4));
        }
        this.l = h2.getBoolean(l.s3, false);
        h2.recycle();
    }
}
