package c.x;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class e0 extends d0 {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f3560f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f3561g = true;

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f3560f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3560f = false;
            }
        }
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f3561g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3561g = false;
            }
        }
    }
}
