package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import okhttp3.HttpUrl;

/* compiled from: StaticLayoutBuilderCompat.java */
/* loaded from: classes2.dex */
final class g {
    private static boolean a;

    /* renamed from: b, reason: collision with root package name */
    private static Constructor<StaticLayout> f18704b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f18705c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f18706d;

    /* renamed from: e, reason: collision with root package name */
    private final TextPaint f18707e;

    /* renamed from: f, reason: collision with root package name */
    private final int f18708f;

    /* renamed from: h, reason: collision with root package name */
    private int f18710h;
    private boolean l;

    /* renamed from: g, reason: collision with root package name */
    private int f18709g = 0;

    /* renamed from: i, reason: collision with root package name */
    private Layout.Alignment f18711i = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: j, reason: collision with root package name */
    private int f18712j = Integer.MAX_VALUE;

    /* renamed from: k, reason: collision with root package name */
    private boolean f18713k = true;
    private TextUtils.TruncateAt m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticLayoutBuilderCompat.java */
    /* loaded from: classes2.dex */
    public static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f18706d = charSequence;
        this.f18707e = textPaint;
        this.f18708f = i2;
        this.f18710h = charSequence.length();
    }

    private void b() throws a {
        Class<?> cls;
        if (a) {
            return;
        }
        try {
            boolean z = this.l && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f18705c = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = g.class.getClassLoader();
                String str = this.l ? "RTL" : "LTR";
                Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                f18705c = loadClass2.getField(str).get(loadClass2);
                cls = loadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            f18704b = declaredConstructor;
            declaredConstructor.setAccessible(true);
            a = true;
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new g(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws a {
        if (this.f18706d == null) {
            this.f18706d = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int max = Math.max(0, this.f18708f);
        CharSequence charSequence = this.f18706d;
        if (this.f18712j == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f18707e, max, this.m);
        }
        int min = Math.min(charSequence.length(), this.f18710h);
        this.f18710h = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.l) {
                this.f18711i = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f18709g, min, this.f18707e, max);
            obtain.setAlignment(this.f18711i);
            obtain.setIncludePad(this.f18713k);
            obtain.setTextDirection(this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f18712j);
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) c.i.j.i.c(f18704b)).newInstance(charSequence, Integer.valueOf(this.f18709g), Integer.valueOf(this.f18710h), this.f18707e, Integer.valueOf(max), this.f18711i, c.i.j.i.c(f18705c), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f18713k), null, Integer.valueOf(max), Integer.valueOf(this.f18712j));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public g d(Layout.Alignment alignment) {
        this.f18711i = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    public g f(boolean z) {
        this.f18713k = z;
        return this;
    }

    public g g(boolean z) {
        this.l = z;
        return this;
    }

    public g h(int i2) {
        this.f18712j = i2;
        return this;
    }
}
