package com.bumptech.glide.p.l;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class c extends d<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p.l.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(Drawable drawable) {
        ((ImageView) this.f9523h).setImageDrawable(drawable);
    }
}
