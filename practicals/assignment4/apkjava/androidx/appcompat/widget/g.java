package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
class g {
    private final CompoundButton a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f517b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f518c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f519d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f520e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f521f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() {
        Drawable a = androidx.core.widget.e.a(this.a);
        if (a != null) {
            if (this.f519d || this.f520e) {
                Drawable mutate = androidx.core.graphics.drawable.a.r(a).mutate();
                if (this.f519d) {
                    androidx.core.graphics.drawable.a.o(mutate, this.f517b);
                }
                if (this.f520e) {
                    androidx.core.graphics.drawable.a.p(mutate, this.f518c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2) {
        Drawable a;
        return (Build.VERSION.SDK_INT >= 17 || (a = androidx.core.widget.e.a(this.a)) == null) ? i2 : i2 + a.getIntrinsicWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f517b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f518c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(AttributeSet attributeSet, int i2) {
        boolean z;
        int i3;
        int i4;
        int n;
        int n2;
        Context context = this.a.getContext();
        int[] iArr = c.a.j.R0;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.a;
        androidx.core.view.u.g0(compoundButton, compoundButton.getContext(), iArr, attributeSet, v.r(), i2, 0);
        try {
            int i5 = c.a.j.T0;
            if (v.s(i5) && (n2 = v.n(i5, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(c.a.k.a.a.d(compoundButton2.getContext(), n2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z) {
                    int i6 = c.a.j.S0;
                    if (v.s(i6) && (n = v.n(i6, 0)) != 0) {
                        CompoundButton compoundButton3 = this.a;
                        compoundButton3.setButtonDrawable(c.a.k.a.a.d(compoundButton3.getContext(), n));
                    }
                }
                i3 = c.a.j.U0;
                if (v.s(i3)) {
                    androidx.core.widget.e.c(this.a, v.c(i3));
                }
                i4 = c.a.j.V0;
                if (v.s(i4)) {
                    androidx.core.widget.e.d(this.a, y.e(v.k(i4, -1), null));
                }
            }
            z = false;
            if (!z) {
            }
            i3 = c.a.j.U0;
            if (v.s(i3)) {
            }
            i4 = c.a.j.V0;
            if (v.s(i4)) {
            }
        } finally {
            v.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f521f) {
            this.f521f = false;
        } else {
            this.f521f = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f517b = colorStateList;
        this.f519d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f518c = mode;
        this.f520e = true;
        a();
    }
}
