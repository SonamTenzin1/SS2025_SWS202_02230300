package e.e.b.c.m;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f21050b = new c.n.a.a.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f21051c = new c.n.a.a.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f21052d = new c.n.a.a.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f21053e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }
}
