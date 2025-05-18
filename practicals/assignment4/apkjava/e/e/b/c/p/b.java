package e.e.b.c.p;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import e.e.b.c.p.d;

/* compiled from: CircularRevealFrameLayout.java */
/* loaded from: classes2.dex */
public class b extends FrameLayout implements d {

    /* renamed from: f, reason: collision with root package name */
    private final c f21067f;

    @Override // e.e.b.c.p.d
    public void a() {
        throw null;
    }

    @Override // e.e.b.c.p.d
    public void b() {
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (this.f21067f == null) {
            super.draw(canvas);
            return;
        }
        throw null;
    }

    public Drawable getCircularRevealOverlayDrawable() {
        throw null;
    }

    @Override // e.e.b.c.p.d
    public int getCircularRevealScrimColor() {
        throw null;
    }

    @Override // e.e.b.c.p.d
    public d.e getRevealInfo() {
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        if (this.f21067f == null) {
            return super.isOpaque();
        }
        throw null;
    }

    @Override // e.e.b.c.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        throw null;
    }

    @Override // e.e.b.c.p.d
    public void setCircularRevealScrimColor(int i2) {
        throw null;
    }

    @Override // e.e.b.c.p.d
    public void setRevealInfo(d.e eVar) {
        throw null;
    }
}
