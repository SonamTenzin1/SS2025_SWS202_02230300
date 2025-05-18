package com.bumptech.glide.load.o.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.u;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return Math.max(1, this.f9410f.getIntrinsicWidth() * this.f9410f.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<Drawable> e() {
        return this.f9410f.getClass();
    }
}
