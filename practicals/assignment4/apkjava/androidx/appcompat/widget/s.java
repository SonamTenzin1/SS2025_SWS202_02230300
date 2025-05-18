package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.d.f;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public class s {
    private final TextView a;

    /* renamed from: b, reason: collision with root package name */
    private o0 f622b;

    /* renamed from: c, reason: collision with root package name */
    private o0 f623c;

    /* renamed from: d, reason: collision with root package name */
    private o0 f624d;

    /* renamed from: e, reason: collision with root package name */
    private o0 f625e;

    /* renamed from: f, reason: collision with root package name */
    private o0 f626f;

    /* renamed from: g, reason: collision with root package name */
    private o0 f627g;

    /* renamed from: h, reason: collision with root package name */
    private o0 f628h;

    /* renamed from: i, reason: collision with root package name */
    private final u f629i;

    /* renamed from: j, reason: collision with root package name */
    private int f630j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f631k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class a extends f.c {
        final /* synthetic */ int a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f632b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f633c;

        a(int i2, int i3, WeakReference weakReference) {
            this.a = i2;
            this.f632b = i3;
            this.f633c = weakReference;
        }

        @Override // androidx.core.content.d.f.c
        public void d(int i2) {
        }

        @Override // androidx.core.content.d.f.c
        public void e(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f632b & 2) != 0);
            }
            s.this.n(this.f633c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TextView textView) {
        this.a = textView;
        this.f629i = new u(textView);
    }

    private void A(int i2, float f2) {
        this.f629i.y(i2, f2);
    }

    private void B(Context context, q0 q0Var) {
        String o;
        this.f630j = q0Var.k(c.a.j.a3, this.f630j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int k2 = q0Var.k(c.a.j.f3, -1);
            this.f631k = k2;
            if (k2 != -1) {
                this.f630j = (this.f630j & 2) | 0;
            }
        }
        int i3 = c.a.j.e3;
        if (!q0Var.s(i3) && !q0Var.s(c.a.j.g3)) {
            int i4 = c.a.j.Z2;
            if (q0Var.s(i4)) {
                this.m = false;
                int k3 = q0Var.k(i4, 1);
                if (k3 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (k3 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (k3 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = c.a.j.g3;
        if (q0Var.s(i5)) {
            i3 = i5;
        }
        int i6 = this.f631k;
        int i7 = this.f630j;
        if (!context.isRestricted()) {
            try {
                Typeface j2 = q0Var.j(i3, this.f630j, new a(i6, i7, new WeakReference(this.a)));
                if (j2 != null) {
                    if (i2 >= 28 && this.f631k != -1) {
                        this.l = Typeface.create(Typeface.create(j2, 0), this.f631k, (this.f630j & 2) != 0);
                    } else {
                        this.l = j2;
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (o = q0Var.o(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && this.f631k != -1) {
            this.l = Typeface.create(Typeface.create(o, 0), this.f631k, (this.f630j & 2) != 0);
        } else {
            this.l = Typeface.create(o, this.f630j);
        }
    }

    private void a(Drawable drawable, o0 o0Var) {
        if (drawable == null || o0Var == null) {
            return;
        }
        h.i(drawable, o0Var, this.a.getDrawableState());
    }

    private static o0 d(Context context, h hVar, int i2) {
        ColorStateList f2 = hVar.f(context, i2);
        if (f2 == null) {
            return null;
        }
        o0 o0Var = new o0();
        o0Var.f596d = true;
        o0Var.a = f2;
        return o0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i2 >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void y() {
        o0 o0Var = this.f628h;
        this.f622b = o0Var;
        this.f623c = o0Var;
        this.f624d = o0Var;
        this.f625e = o0Var;
        this.f626f = o0Var;
        this.f627g = o0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f622b != null || this.f623c != null || this.f624d != null || this.f625e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.f622b);
            a(compoundDrawables[1], this.f623c);
            a(compoundDrawables[2], this.f624d);
            a(compoundDrawables[3], this.f625e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f626f == null && this.f627g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f626f);
            a(compoundDrawablesRelative[2], this.f627g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f629i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f629i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f629i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f629i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f629i.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f629i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        o0 o0Var = this.f628h;
        if (o0Var != null) {
            return o0Var.a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        o0 o0Var = this.f628h;
        if (o0Var != null) {
            return o0Var.f594b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f629i.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e9  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AttributeSet attributeSet, int i2) {
        String str;
        ColorStateList colorStateList;
        String str2;
        boolean z;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        boolean z2;
        String str3;
        int i3;
        int i4;
        String str4;
        h hVar;
        Typeface typeface;
        q0 u;
        int i5;
        int i6;
        int i7;
        int f2;
        int f3;
        int f4;
        int[] m;
        Context context = this.a.getContext();
        h b2 = h.b();
        int[] iArr = c.a.j.a0;
        q0 v = q0.v(context, attributeSet, iArr, i2, 0);
        TextView textView = this.a;
        androidx.core.view.u.g0(textView, textView.getContext(), iArr, attributeSet, v.r(), i2, 0);
        int n = v.n(c.a.j.b0, -1);
        int i8 = c.a.j.e0;
        if (v.s(i8)) {
            this.f622b = d(context, b2, v.n(i8, 0));
        }
        int i9 = c.a.j.c0;
        if (v.s(i9)) {
            this.f623c = d(context, b2, v.n(i9, 0));
        }
        int i10 = c.a.j.f0;
        if (v.s(i10)) {
            this.f624d = d(context, b2, v.n(i10, 0));
        }
        int i11 = c.a.j.d0;
        if (v.s(i11)) {
            this.f625e = d(context, b2, v.n(i11, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 17) {
            int i13 = c.a.j.g0;
            if (v.s(i13)) {
                this.f626f = d(context, b2, v.n(i13, 0));
            }
            int i14 = c.a.j.h0;
            if (v.s(i14)) {
                this.f627g = d(context, b2, v.n(i14, 0));
            }
        }
        v.w();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n != -1) {
            q0 t = q0.t(context, n, c.a.j.X2);
            if (!z3) {
                int i15 = c.a.j.i3;
                if (t.s(i15)) {
                    z = t.a(i15, false);
                    z2 = true;
                    B(context, t);
                    if (i12 >= 23) {
                        int i16 = c.a.j.b3;
                        colorStateList = t.s(i16) ? t.c(i16) : null;
                        int i17 = c.a.j.c3;
                        colorStateList2 = t.s(i17) ? t.c(i17) : null;
                        int i18 = c.a.j.d3;
                        if (t.s(i18)) {
                            colorStateList3 = t.c(i18);
                            int i19 = c.a.j.j3;
                            str2 = t.s(i19) ? t.o(i19) : null;
                            if (i12 >= 26) {
                                int i20 = c.a.j.h3;
                                if (t.s(i20)) {
                                    str = t.o(i20);
                                    t.w();
                                }
                            }
                            str = null;
                            t.w();
                        }
                    } else {
                        colorStateList = null;
                        colorStateList2 = null;
                    }
                    colorStateList3 = null;
                    int i192 = c.a.j.j3;
                    if (t.s(i192)) {
                    }
                    if (i12 >= 26) {
                    }
                    str = null;
                    t.w();
                }
            }
            z = false;
            z2 = false;
            B(context, t);
            if (i12 >= 23) {
            }
            colorStateList3 = null;
            int i1922 = c.a.j.j3;
            if (t.s(i1922)) {
            }
            if (i12 >= 26) {
            }
            str = null;
            t.w();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            z = false;
            colorStateList2 = null;
            colorStateList3 = null;
            z2 = false;
        }
        q0 v2 = q0.v(context, attributeSet, c.a.j.X2, i2, 0);
        if (!z3) {
            int i21 = c.a.j.i3;
            if (v2.s(i21)) {
                str3 = str;
                z = v2.a(i21, false);
                i3 = 23;
                z2 = true;
                if (i12 < i3) {
                    int i22 = c.a.j.b3;
                    if (v2.s(i22)) {
                        colorStateList = v2.c(i22);
                    }
                    int i23 = c.a.j.c3;
                    if (v2.s(i23)) {
                        colorStateList2 = v2.c(i23);
                    }
                    int i24 = c.a.j.d3;
                    if (v2.s(i24)) {
                        colorStateList3 = v2.c(i24);
                    }
                }
                i4 = c.a.j.j3;
                if (v2.s(i4)) {
                    str2 = v2.o(i4);
                }
                if (i12 >= 26) {
                    int i25 = c.a.j.h3;
                    if (v2.s(i25)) {
                        str4 = v2.o(i25);
                        if (i12 >= 28) {
                            int i26 = c.a.j.Y2;
                            if (v2.s(i26)) {
                                hVar = b2;
                                if (v2.f(i26, -1) == 0) {
                                    this.a.setTextSize(0, 0.0f);
                                }
                                B(context, v2);
                                v2.w();
                                if (colorStateList != null) {
                                    this.a.setTextColor(colorStateList);
                                }
                                if (colorStateList2 != null) {
                                    this.a.setHintTextColor(colorStateList2);
                                }
                                if (colorStateList3 != null) {
                                    this.a.setLinkTextColor(colorStateList3);
                                }
                                if (!z3 && z2) {
                                    r(z);
                                }
                                typeface = this.l;
                                if (typeface != null) {
                                    if (this.f631k == -1) {
                                        this.a.setTypeface(typeface, this.f630j);
                                    } else {
                                        this.a.setTypeface(typeface);
                                    }
                                }
                                if (str4 != null) {
                                    this.a.setFontVariationSettings(str4);
                                }
                                if (str2 != null) {
                                    if (i12 >= 24) {
                                        this.a.setTextLocales(LocaleList.forLanguageTags(str2));
                                    } else if (i12 >= 21) {
                                        this.a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                                    }
                                }
                                this.f629i.t(attributeSet, i2);
                                if (androidx.core.widget.d.a && this.f629i.n() != 0) {
                                    m = this.f629i.m();
                                    if (m.length > 0) {
                                        if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                                            this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f629i.k(), this.f629i.j(), this.f629i.l(), 0);
                                        } else {
                                            this.a.setAutoSizeTextTypeUniformWithPresetSizes(m, 0);
                                        }
                                    }
                                }
                                u = q0.u(context, attributeSet, c.a.j.i0);
                                int n2 = u.n(c.a.j.q0, -1);
                                h hVar2 = hVar;
                                Drawable c2 = n2 == -1 ? hVar2.c(context, n2) : null;
                                int n3 = u.n(c.a.j.v0, -1);
                                Drawable c3 = n3 == -1 ? hVar2.c(context, n3) : null;
                                int n4 = u.n(c.a.j.r0, -1);
                                Drawable c4 = n4 == -1 ? hVar2.c(context, n4) : null;
                                int n5 = u.n(c.a.j.o0, -1);
                                Drawable c5 = n5 == -1 ? hVar2.c(context, n5) : null;
                                int n6 = u.n(c.a.j.s0, -1);
                                Drawable c6 = n6 == -1 ? hVar2.c(context, n6) : null;
                                int n7 = u.n(c.a.j.p0, -1);
                                x(c2, c3, c4, c5, c6, n7 == -1 ? hVar2.c(context, n7) : null);
                                i5 = c.a.j.t0;
                                if (u.s(i5)) {
                                    androidx.core.widget.k.g(this.a, u.c(i5));
                                }
                                i6 = c.a.j.u0;
                                if (u.s(i6)) {
                                    i7 = -1;
                                } else {
                                    i7 = -1;
                                    androidx.core.widget.k.h(this.a, y.e(u.k(i6, -1), null));
                                }
                                f2 = u.f(c.a.j.w0, i7);
                                f3 = u.f(c.a.j.x0, i7);
                                f4 = u.f(c.a.j.y0, i7);
                                u.w();
                                if (f2 != i7) {
                                    androidx.core.widget.k.j(this.a, f2);
                                }
                                if (f3 != i7) {
                                    androidx.core.widget.k.k(this.a, f3);
                                }
                                if (f4 == i7) {
                                    androidx.core.widget.k.l(this.a, f4);
                                    return;
                                }
                                return;
                            }
                        }
                        hVar = b2;
                        B(context, v2);
                        v2.w();
                        if (colorStateList != null) {
                        }
                        if (colorStateList2 != null) {
                        }
                        if (colorStateList3 != null) {
                        }
                        if (!z3) {
                            r(z);
                        }
                        typeface = this.l;
                        if (typeface != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str2 != null) {
                        }
                        this.f629i.t(attributeSet, i2);
                        if (androidx.core.widget.d.a) {
                            m = this.f629i.m();
                            if (m.length > 0) {
                            }
                        }
                        u = q0.u(context, attributeSet, c.a.j.i0);
                        int n22 = u.n(c.a.j.q0, -1);
                        h hVar22 = hVar;
                        if (n22 == -1) {
                        }
                        int n32 = u.n(c.a.j.v0, -1);
                        if (n32 == -1) {
                        }
                        int n42 = u.n(c.a.j.r0, -1);
                        if (n42 == -1) {
                        }
                        int n52 = u.n(c.a.j.o0, -1);
                        if (n52 == -1) {
                        }
                        int n62 = u.n(c.a.j.s0, -1);
                        if (n62 == -1) {
                        }
                        int n72 = u.n(c.a.j.p0, -1);
                        x(c2, c3, c4, c5, c6, n72 == -1 ? hVar22.c(context, n72) : null);
                        i5 = c.a.j.t0;
                        if (u.s(i5)) {
                        }
                        i6 = c.a.j.u0;
                        if (u.s(i6)) {
                        }
                        f2 = u.f(c.a.j.w0, i7);
                        f3 = u.f(c.a.j.x0, i7);
                        f4 = u.f(c.a.j.y0, i7);
                        u.w();
                        if (f2 != i7) {
                        }
                        if (f3 != i7) {
                        }
                        if (f4 == i7) {
                        }
                    }
                }
                str4 = str3;
                if (i12 >= 28) {
                }
                hVar = b2;
                B(context, v2);
                v2.w();
                if (colorStateList != null) {
                }
                if (colorStateList2 != null) {
                }
                if (colorStateList3 != null) {
                }
                if (!z3) {
                }
                typeface = this.l;
                if (typeface != null) {
                }
                if (str4 != null) {
                }
                if (str2 != null) {
                }
                this.f629i.t(attributeSet, i2);
                if (androidx.core.widget.d.a) {
                }
                u = q0.u(context, attributeSet, c.a.j.i0);
                int n222 = u.n(c.a.j.q0, -1);
                h hVar222 = hVar;
                if (n222 == -1) {
                }
                int n322 = u.n(c.a.j.v0, -1);
                if (n322 == -1) {
                }
                int n422 = u.n(c.a.j.r0, -1);
                if (n422 == -1) {
                }
                int n522 = u.n(c.a.j.o0, -1);
                if (n522 == -1) {
                }
                int n622 = u.n(c.a.j.s0, -1);
                if (n622 == -1) {
                }
                int n722 = u.n(c.a.j.p0, -1);
                x(c2, c3, c4, c5, c6, n722 == -1 ? hVar222.c(context, n722) : null);
                i5 = c.a.j.t0;
                if (u.s(i5)) {
                }
                i6 = c.a.j.u0;
                if (u.s(i6)) {
                }
                f2 = u.f(c.a.j.w0, i7);
                f3 = u.f(c.a.j.x0, i7);
                f4 = u.f(c.a.j.y0, i7);
                u.w();
                if (f2 != i7) {
                }
                if (f3 != i7) {
                }
                if (f4 == i7) {
                }
            }
        }
        str3 = str;
        i3 = 23;
        if (i12 < i3) {
        }
        i4 = c.a.j.j3;
        if (v2.s(i4)) {
        }
        if (i12 >= 26) {
        }
        str4 = str3;
        if (i12 >= 28) {
        }
        hVar = b2;
        B(context, v2);
        v2.w();
        if (colorStateList != null) {
        }
        if (colorStateList2 != null) {
        }
        if (colorStateList3 != null) {
        }
        if (!z3) {
        }
        typeface = this.l;
        if (typeface != null) {
        }
        if (str4 != null) {
        }
        if (str2 != null) {
        }
        this.f629i.t(attributeSet, i2);
        if (androidx.core.widget.d.a) {
        }
        u = q0.u(context, attributeSet, c.a.j.i0);
        int n2222 = u.n(c.a.j.q0, -1);
        h hVar2222 = hVar;
        if (n2222 == -1) {
        }
        int n3222 = u.n(c.a.j.v0, -1);
        if (n3222 == -1) {
        }
        int n4222 = u.n(c.a.j.r0, -1);
        if (n4222 == -1) {
        }
        int n5222 = u.n(c.a.j.o0, -1);
        if (n5222 == -1) {
        }
        int n6222 = u.n(c.a.j.s0, -1);
        if (n6222 == -1) {
        }
        int n7222 = u.n(c.a.j.p0, -1);
        x(c2, c3, c4, c5, c6, n7222 == -1 ? hVar2222.c(context, n7222) : null);
        i5 = c.a.j.t0;
        if (u.s(i5)) {
        }
        i6 = c.a.j.u0;
        if (u.s(i6)) {
        }
        f2 = u.f(c.a.j.w0, i7);
        f3 = u.f(c.a.j.x0, i7);
        f4 = u.f(c.a.j.y0, i7);
        u.w();
        if (f2 != i7) {
        }
        if (f3 != i7) {
        }
        if (f4 == i7) {
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f630j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z, int i2, int i3, int i4, int i5) {
        if (androidx.core.widget.d.a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i2) {
        String o;
        ColorStateList c2;
        q0 t = q0.t(context, i2, c.a.j.X2);
        int i3 = c.a.j.i3;
        if (t.s(i3)) {
            r(t.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = c.a.j.b3;
            if (t.s(i5) && (c2 = t.c(i5)) != null) {
                this.a.setTextColor(c2);
            }
        }
        int i6 = c.a.j.Y2;
        if (t.s(i6) && t.f(i6, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        B(context, t);
        if (i4 >= 26) {
            int i7 = c.a.j.h3;
            if (t.s(i7) && (o = t.o(i7)) != null) {
                this.a.setFontVariationSettings(o);
            }
        }
        t.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f630j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f629i.u(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i2) throws IllegalArgumentException {
        this.f629i.v(iArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2) {
        this.f629i.w(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f628h == null) {
            this.f628h = new o0();
        }
        o0 o0Var = this.f628h;
        o0Var.a = colorStateList;
        o0Var.f596d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f628h == null) {
            this.f628h = new o0();
        }
        o0 o0Var = this.f628h;
        o0Var.f594b = mode;
        o0Var.f595c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i2, float f2) {
        if (androidx.core.widget.d.a || l()) {
            return;
        }
        A(i2, f2);
    }
}
