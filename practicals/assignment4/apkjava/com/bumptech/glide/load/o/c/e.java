package com.bumptech.glide.load.o.c;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class e implements com.bumptech.glide.load.l<Bitmap> {
    protected abstract Bitmap transform(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.l
    public final com.bumptech.glide.load.engine.u<Bitmap> transform(Context context, com.bumptech.glide.load.engine.u<Bitmap> uVar, int i2, int i3) {
        if (com.bumptech.glide.r.k.t(i2, i3)) {
            com.bumptech.glide.load.engine.z.e f2 = com.bumptech.glide.c.c(context).f();
            Bitmap bitmap = uVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap transform = transform(f2, bitmap, i2, i3);
            return bitmap.equals(transform) ? uVar : d.f(transform, f2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
