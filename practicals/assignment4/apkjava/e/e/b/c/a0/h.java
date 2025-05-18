package e.e.b.c.a0;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: MaterialShapeUtils.java */
/* loaded from: classes2.dex */
public class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(int i2) {
        if (i2 == 0) {
            return new j();
        }
        if (i2 != 1) {
            return b();
        }
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f c() {
        return new f();
    }

    public static void d(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).W(f2);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.P()) {
            gVar.a0(com.google.android.material.internal.k.c(view));
        }
    }
}
