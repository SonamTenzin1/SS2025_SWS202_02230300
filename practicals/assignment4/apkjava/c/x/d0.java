package c.x;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class d0 extends i0 {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f3549e = true;

    @Override // c.x.i0
    public void a(View view) {
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f3549e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f3549e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // c.x.i0
    public void d(View view) {
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f2) {
        if (f3549e) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f3549e = false;
            }
        }
        view.setAlpha(f2);
    }
}
