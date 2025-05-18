package c.a.l.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapper.java */
/* loaded from: classes.dex */
public class c extends Drawable implements Drawable.Callback {

    /* renamed from: f, reason: collision with root package name */
    private Drawable f2790f;

    public c(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.f2790f;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f2790f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2790f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2790f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f2790f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2790f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2790f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2790f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2790f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2790f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2790f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2790f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2790f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2790f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return androidx.core.graphics.drawable.a.h(this.f2790f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f2790f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2790f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f2790f.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.f2790f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2790f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        androidx.core.graphics.drawable.a.j(this.f2790f, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f2790f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2790f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2790f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2790f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        androidx.core.graphics.drawable.a.k(this.f2790f, f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        androidx.core.graphics.drawable.a.l(this.f2790f, i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f2790f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        androidx.core.graphics.drawable.a.n(this.f2790f, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.f2790f, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        androidx.core.graphics.drawable.a.p(this.f2790f, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2790f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
