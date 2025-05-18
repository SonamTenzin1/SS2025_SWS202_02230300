package c.x;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class v implements w {
    private final ViewGroupOverlay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // c.x.b0
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // c.x.b0
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override // c.x.w
    public void c(View view) {
        this.a.add(view);
    }

    @Override // c.x.w
    public void d(View view) {
        this.a.remove(view);
    }
}
