package com.bumptech.glide.p.m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.p.m.d;

/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: classes.dex */
public class b implements d<Drawable> {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9535b;

    public b(int i2, boolean z) {
        this.a = i2;
        this.f9535b = z;
    }

    @Override // com.bumptech.glide.p.m.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, d.a aVar) {
        Drawable b2 = aVar.b();
        if (b2 == null) {
            b2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{b2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f9535b);
        transitionDrawable.startTransition(this.a);
        aVar.a(transitionDrawable);
        return true;
    }
}
